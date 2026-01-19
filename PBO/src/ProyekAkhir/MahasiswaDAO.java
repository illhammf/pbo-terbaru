package ProyekAkhir;

import java.sql.*;
import java.util.ArrayList;

public class MahasiswaDAO {
    // Data Access Object,
    // kelas yang isinya khusus untuk operasi database (CRUD), bukan logika GUI atau console
    // =========================
    // INSERT (4 jenis)
    // =========================
    public void insertMahasiswa(Mahasiswa m) throws SQLException {
        if (m instanceof MahasiswaAktif) {
            insertMahasiswaAktif((MahasiswaAktif) m);
        } else if (m instanceof MahasiswaBaru) {
            insertMahasiswaBaru((MahasiswaBaru) m);
        } else if (m instanceof MahasiswaCuti) {
            insertMahasiswaCuti((MahasiswaCuti) m);
        } else if (m instanceof MahasiswaLulus) {
            insertMahasiswaLulus((MahasiswaLulus) m);
        } else {
            throw new SQLException("Jenis Mahasiswa tidak dikenali.");
        }
    }

    private int insertMahasiswaInduk(Connection conn, Mahasiswa m, String jenis) throws SQLException {
        String sql = """
            INSERT INTO mahasiswa(nim,nama,prodi,fakultas,semester,kampus,jenis)
            VALUES (?,?,?,?,?,?,?)
            RETURNING id
        """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getNim());
            ps.setString(2, m.getNama());
            ps.setString(3, m.getProdi());
            ps.setString(4, m.getFakultas());
            ps.setInt(5, m.getSemester());
            ps.setString(6, m.getKampus());
            ps.setString(7, jenis);

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    public void insertMahasiswaAktif(MahasiswaAktif m) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                int id = insertMahasiswaInduk(conn, m, "AKTIF");

                String sqlAktif = """
                    INSERT INTO mahasiswa_aktif(mahasiswa_id,sks_tempuh,ipk,status)
                    VALUES (?,?,?,?)
                """;
                try (PreparedStatement ps2 = conn.prepareStatement(sqlAktif)) {
                    ps2.setInt(1, id);
                    ps2.setInt(2, m.getSksTempuh());
                    ps2.setDouble(3, m.getIpk());
                    ps2.setString(4, m.getStatus());
                    ps2.executeUpdate();
                }

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        }
    }

    public void insertMahasiswaBaru(MahasiswaBaru m) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                int id = insertMahasiswaInduk(conn, m, "BARU");

                String sql = """
                    INSERT INTO mahasiswa_baru(mahasiswa_id,asal_sekolah,tahun_masuk)
                    VALUES (?,?,?)
                """;
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.setString(2, m.getAsalSekolah());
                    ps.setInt(3, m.getTahunMasuk());
                    ps.executeUpdate();
                }

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        }
    }

    public void insertMahasiswaCuti(MahasiswaCuti m) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                int id = insertMahasiswaInduk(conn, m, "CUTI");

                String sql = """
                    INSERT INTO mahasiswa_cuti(mahasiswa_id,alasan_cuti,durasi_cuti)
                    VALUES (?,?,?)
                """;
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.setString(2, m.getAlasanCuti());
                    ps.setInt(3, m.getDurasiCuti());
                    ps.executeUpdate();
                }

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        }
    }

    public void insertMahasiswaLulus(MahasiswaLulus m) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                int id = insertMahasiswaInduk(conn, m, "LULUS");

                String sql = """
                    INSERT INTO mahasiswa_lulus(mahasiswa_id,tahun_lulus,ipk_akhir)
                    VALUES (?,?,?)
                """;
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.setInt(2, m.getTahunLulus());
                    ps.setDouble(3, m.getIpkAkhir());
                    ps.executeUpdate();
                }

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        }
    }

    // =========================
    // SELECT ALL (JOIN sesuai jenis)
    // =========================
    public ArrayList<Mahasiswa> getAllMahasiswa() throws SQLException {
        ArrayList<Mahasiswa> list = new ArrayList<>();

        String sql = """
            SELECT m.id, m.nim, m.nama, m.prodi, m.fakultas, m.semester, m.kampus, m.jenis,
                   a.sks_tempuh, a.ipk, a.status,
                   b.asal_sekolah, b.tahun_masuk,
                   c.alasan_cuti, c.durasi_cuti,
                   l.tahun_lulus, l.ipk_akhir
            FROM mahasiswa m
            LEFT JOIN mahasiswa_aktif a ON a.mahasiswa_id = m.id
            LEFT JOIN mahasiswa_baru  b ON b.mahasiswa_id = m.id
            LEFT JOIN mahasiswa_cuti  c ON c.mahasiswa_id = m.id
            LEFT JOIN mahasiswa_lulus l ON l.mahasiswa_id = m.id
            ORDER BY m.id DESC
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String jenis = rs.getString("jenis");

                Mahasiswa obj;
                switch (jenis) {
                    case "AKTIF": {
                        MahasiswaAktif m = new MahasiswaAktif();
                        m.setSksTempuh(rs.getInt("sks_tempuh"));
                        m.setIpk(rs.getDouble("ipk"));
                        m.setStatus(rs.getString("status"));
                        obj = m;
                        break;
                    }
                    case "BARU": {
                        MahasiswaBaru m = new MahasiswaBaru();
                        m.setAsalSekolah(rs.getString("asal_sekolah"));
                        m.setTahunMasuk(rs.getInt("tahun_masuk"));
                        obj = m;
                        break;
                    }
                    case "CUTI": {
                        MahasiswaCuti m = new MahasiswaCuti();
                        m.setAlasanCuti(rs.getString("alasan_cuti"));
                        m.setDurasiCuti(rs.getInt("durasi_cuti"));
                        obj = m;
                        break;
                    }
                    case "LULUS": {
                        MahasiswaLulus m = new MahasiswaLulus();
                        m.setTahunLulus(rs.getInt("tahun_lulus"));
                        m.setIpkAkhir(rs.getDouble("ipk_akhir"));
                        obj = m;
                        break;
                    }
                    default: {
                        obj = new Mahasiswa();
                        break;
                    }
                }

                // set data umum
                obj.setNim(rs.getString("nim"));
                obj.setNama(rs.getString("nama"));
                obj.setProdi(rs.getString("prodi"));
                obj.setFakultas(rs.getString("fakultas"));
                obj.setSemester(rs.getInt("semester"));
                obj.setKampus(rs.getString("kampus"));

                list.add(obj);
            }
        }

        return list;
    }

    // =========================
    // DELETE by NIM
    // =========================
    public void deleteMahasiswaByNim(String nim) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nim);
            ps.executeUpdate();
        }
    }

        // =========================
    // UPDATE (Edit) by NIM (oldNim)
    // - update tabel induk
    // - update tabel detail sesuai jenis
    // - kalau jenis berubah: hapus detail lama, insert detail baru
    // =========================
    public void updateMahasiswaByNim(String oldNim, Mahasiswa m) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                // ambil id & jenis lama berdasarkan NIM lama
                int id;
                String oldJenis;

                String q = "SELECT id, jenis FROM mahasiswa WHERE nim = ?";
                try (PreparedStatement ps = conn.prepareStatement(q)) {
                    ps.setString(1, oldNim);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) throw new SQLException("Data dengan NIM lama tidak ditemukan.");
                        id = rs.getInt("id");
                        oldJenis = rs.getString("jenis");
                    }
                }

                // cek kalau NIM diganti, jangan duplikat
                if (!oldNim.equals(m.getNim())) {
                    String cek = "SELECT 1 FROM mahasiswa WHERE nim = ?";
                    try (PreparedStatement ps = conn.prepareStatement(cek)) {
                        ps.setString(1, m.getNim());
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) throw new SQLException("NIM baru sudah terdaftar!");
                        }
                    }
                }

                // tentukan jenis baru
                String newJenis = jenisOf(m);

                // update tabel induk
                String upInduk = """
                    UPDATE mahasiswa
                    SET nim=?, nama=?, prodi=?, fakultas=?, semester=?, kampus=?, jenis=?
                    WHERE id=?
                """;
                try (PreparedStatement ps = conn.prepareStatement(upInduk)) {
                    ps.setString(1, m.getNim());
                    ps.setString(2, m.getNama());
                    ps.setString(3, m.getProdi());
                    ps.setString(4, m.getFakultas());
                    ps.setInt(5, m.getSemester());
                    ps.setString(6, m.getKampus());
                    ps.setString(7, newJenis);
                    ps.setInt(8, id);
                    ps.executeUpdate();
                }

                // kalau jenis berubah → hapus detail lama dulu
                if (!oldJenis.equals(newJenis)) {
                    deleteDetailByJenis(conn, id, oldJenis);
                    insertDetailByJenis(conn, id, m, newJenis);
                } else {
                    // jenis sama → update detail sesuai jenis
                    updateDetailByJenis(conn, id, m, newJenis);
                }

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        }
    }

    private String jenisOf(Mahasiswa m) throws SQLException {
        if (m instanceof MahasiswaAktif) return "AKTIF";
        if (m instanceof MahasiswaBaru) return "BARU";
        if (m instanceof MahasiswaCuti) return "CUTI";
        if (m instanceof MahasiswaLulus) return "LULUS";
        throw new SQLException("Jenis mahasiswa tidak dikenali.");
    }

    private void deleteDetailByJenis(Connection conn, int id, String jenis) throws SQLException {
        String sql;
        switch (jenis) {
            case "AKTIF": sql = "DELETE FROM mahasiswa_aktif WHERE mahasiswa_id=?"; break;
            case "BARU":  sql = "DELETE FROM mahasiswa_baru  WHERE mahasiswa_id=?"; break;
            case "CUTI":  sql = "DELETE FROM mahasiswa_cuti  WHERE mahasiswa_id=?"; break;
            case "LULUS": sql = "DELETE FROM mahasiswa_lulus WHERE mahasiswa_id=?"; break;
            default: return;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private void insertDetailByJenis(Connection conn, int id, Mahasiswa m, String jenis) throws SQLException {
        switch (jenis) {
            case "AKTIF": {
                MahasiswaAktif a = (MahasiswaAktif) m;
                String sql = "INSERT INTO mahasiswa_aktif(mahasiswa_id,sks_tempuh,ipk,status) VALUES (?,?,?,?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.setInt(2, a.getSksTempuh());
                    ps.setDouble(3, a.getIpk());
                    ps.setString(4, a.getStatus());
                    ps.executeUpdate();
                }
                break;
            }
            case "BARU": {
                MahasiswaBaru b = (MahasiswaBaru) m;
                String sql = "INSERT INTO mahasiswa_baru(mahasiswa_id,asal_sekolah,tahun_masuk) VALUES (?,?,?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.setString(2, b.getAsalSekolah());
                    ps.setInt(3, b.getTahunMasuk());
                    ps.executeUpdate();
                }
                break;
            }
            case "CUTI": {
                MahasiswaCuti c = (MahasiswaCuti) m;
                String sql = "INSERT INTO mahasiswa_cuti(mahasiswa_id,alasan_cuti,durasi_cuti) VALUES (?,?,?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.setString(2, c.getAlasanCuti());
                    ps.setInt(3, c.getDurasiCuti());
                    ps.executeUpdate();
                }
                break;
            }
            case "LULUS": {
                MahasiswaLulus l = (MahasiswaLulus) m;
                String sql = "INSERT INTO mahasiswa_lulus(mahasiswa_id,tahun_lulus,ipk_akhir) VALUES (?,?,?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.setInt(2, l.getTahunLulus());
                    ps.setDouble(3, l.getIpkAkhir());
                    ps.executeUpdate();
                }
                break;
            }
        }
    }

    private void updateDetailByJenis(Connection conn, int id, Mahasiswa m, String jenis) throws SQLException {
        switch (jenis) {
            case "AKTIF": {
                MahasiswaAktif a = (MahasiswaAktif) m;
                String sql = "UPDATE mahasiswa_aktif SET sks_tempuh=?, ipk=?, status=? WHERE mahasiswa_id=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, a.getSksTempuh());
                    ps.setDouble(2, a.getIpk());
                    ps.setString(3, a.getStatus());
                    ps.setInt(4, id);
                    ps.executeUpdate();
                }
                break;
            }
            case "BARU": {
                MahasiswaBaru b = (MahasiswaBaru) m;
                String sql = "UPDATE mahasiswa_baru SET asal_sekolah=?, tahun_masuk=? WHERE mahasiswa_id=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, b.getAsalSekolah());
                    ps.setInt(2, b.getTahunMasuk());
                    ps.setInt(3, id);
                    ps.executeUpdate();
                }
                break;
            }
            case "CUTI": {
                MahasiswaCuti c = (MahasiswaCuti) m;
                String sql = "UPDATE mahasiswa_cuti SET alasan_cuti=?, durasi_cuti=? WHERE mahasiswa_id=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, c.getAlasanCuti());
                    ps.setInt(2, c.getDurasiCuti());
                    ps.setInt(3, id);
                    ps.executeUpdate();
                }
                break;
            }
            case "LULUS": {
                MahasiswaLulus l = (MahasiswaLulus) m;
                String sql = "UPDATE mahasiswa_lulus SET tahun_lulus=?, ipk_akhir=? WHERE mahasiswa_id=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, l.getTahunLulus());
                    ps.setDouble(2, l.getIpkAkhir());
                    ps.setInt(3, id);
                    ps.executeUpdate();
                }
                break;
            }
        }
    }

}
