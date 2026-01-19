package ProyekAkhir;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class DataMahasiswaGUI extends JFrame {

    private final MahasiswaDAO dao = new MahasiswaDAO();
    private final ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    // Input umum
    private JTextField tfNama, tfNim, tfProdi, tfFakultas;
    private JSpinner spSemester;
    private JComboBox<String> cbKampus;
    private JComboBox<String> cbJenis;

    // Extra (CardLayout)
    private CardLayout cardLayout;
    private JPanel panelExtra;

    // Aktif
    private JSpinner spSks;
    private JTextField tfIpk, tfStatus;
    // Baru
    private JTextField tfAsalSekolah;
    private JSpinner spTahunMasuk;
    // Cuti
    private JTextField tfAlasanCuti;
    private JSpinner spDurasiCuti;
    // Lulus
    private JSpinner spTahunLulus;
    private JTextField tfIpkAkhir;

    // Table
    private JTable table;
    private DefaultTableModel tableModel;

    // Buttons
    private JButton btnTambah, btnEdit, btnSimpan, btnBatal, btnHapus, btnDetail, btnClear, btnReload;

    // State edit
    private boolean editMode = false;
    private String oldNimForEdit = null;

    public DataMahasiswaGUI() {
        setTitle("Sistem Manajemen Data Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new BorderLayout(10, 10));
        formPanel.setBorder(new TitledBorder("Form Input Data Mahasiswa"));
        formPanel.add(buildFormCommon(), BorderLayout.NORTH);
        formPanel.add(buildFormExtra(), BorderLayout.CENTER);
        formPanel.add(buildButtons(), BorderLayout.SOUTH);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new TitledBorder("Daftar Mahasiswa"));
        tablePanel.add(buildTable(), BorderLayout.CENTER);

        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);

        loadFromDatabaseAsync();
    }

    private JPanel buildFormCommon() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(new TitledBorder("Data Umum"));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        tfNama = new JTextField(18);
        tfNim = new JTextField(18);
        tfProdi = new JTextField(18);
        tfFakultas = new JTextField(18);

        spSemester = new JSpinner(new SpinnerNumberModel(1, 1, 14, 1));
        cbKampus = new JComboBox<>(new String[]{"Jakarta", "Bekasi", "Tangerang"});
        cbJenis = new JComboBox<>(new String[]{"Mahasiswa Aktif", "Mahasiswa Baru", "Mahasiswa Cuti", "Mahasiswa Lulus"});

        int row = 0;
        row = addRow(p, c, row, "Nama", tfNama);
        row = addRow(p, c, row, "NIM", tfNim);
        row = addRow(p, c, row, "Prodi", tfProdi);
        row = addRow(p, c, row, "Fakultas", tfFakultas);
        row = addRow(p, c, row, "Semester", spSemester);
        row = addRow(p, c, row, "Kampus", cbKampus);

        c.gridx = 0; c.gridy = row; c.weightx = 0;
        p.add(new JLabel("Jenis"), c);
        c.gridx = 1; c.weightx = 1;
        p.add(cbJenis, c);

        cbJenis.addActionListener(e -> {
            String jenis = (String) cbJenis.getSelectedItem();
            cardLayout.show(panelExtra, jenis);
            if ("Mahasiswa Baru".equals(jenis)) spSemester.setValue(1);
        });

        return p;
    }

    private int addRow(JPanel p, GridBagConstraints c, int row, String label, JComponent comp) {
        c.gridx = 0; c.gridy = row; c.weightx = 0;
        p.add(new JLabel(label), c);
        c.gridx = 1; c.weightx = 1;
        p.add(comp, c);
        return row + 1;
    }

    private JPanel buildFormExtra() {
        cardLayout = new CardLayout();
        panelExtra = new JPanel(cardLayout);
        panelExtra.setBorder(new TitledBorder("Data Tambahan (sesuai jenis)"));

        panelExtra.add(buildExtraAktif(), "Mahasiswa Aktif");
        panelExtra.add(buildExtraBaru(), "Mahasiswa Baru");
        panelExtra.add(buildExtraCuti(), "Mahasiswa Cuti");
        panelExtra.add(buildExtraLulus(), "Mahasiswa Lulus");

        cardLayout.show(panelExtra, "Mahasiswa Aktif");
        return panelExtra;
    }

    private JPanel buildExtraAktif() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        spSks = new JSpinner(new SpinnerNumberModel(0, 0, 200, 1));
        tfIpk = new JTextField(10);
        tfStatus = new JTextField(12);

        int row = 0;
        row = addRow(p, c, row, "Jumlah SKS", spSks);
        row = addRow(p, c, row, "IPK (3.76 / 3,76)", tfIpk);
        row = addRow(p, c, row, "Status", tfStatus);

        return p;
    }

    private JPanel buildExtraBaru() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        tfAsalSekolah = new JTextField(18);
        spTahunMasuk = new JSpinner(new SpinnerNumberModel(2025, 1990, 2100, 1));

        int row = 0;
        row = addRow(p, c, row, "Asal Sekolah", tfAsalSekolah);
        row = addRow(p, c, row, "Tahun Masuk", spTahunMasuk);

        return p;
    }

    private JPanel buildExtraCuti() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        tfAlasanCuti = new JTextField(18);
        spDurasiCuti = new JSpinner(new SpinnerNumberModel(1, 1, 14, 1));

        int row = 0;
        row = addRow(p, c, row, "Alasan Cuti", tfAlasanCuti);
        row = addRow(p, c, row, "Durasi (semester)", spDurasiCuti);

        return p;
    }

    private JPanel buildExtraLulus() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        spTahunLulus = new JSpinner(new SpinnerNumberModel(2025, 1990, 2100, 1));
        tfIpkAkhir = new JTextField(10);

        int row = 0;
        row = addRow(p, c, row, "Tahun Lulus", spTahunLulus);
        row = addRow(p, c, row, "IPK Akhir (3.76 / 3,76)", tfIpkAkhir);

        return p;
    }

    private JScrollPane buildTable() {
        String[] cols = {"Nama", "NIM", "Jenis", "Prodi", "Semester", "Kampus"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(24);

        // Double click -> detail
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    showDetailSelected();
                }
            }
        });

        return new JScrollPane(table);
    }

    private JPanel buildButtons() {
        JPanel p = new JPanel(new GridLayout(4, 2, 8, 8));
        p.setBorder(new TitledBorder("Aksi"));

        btnTambah = new JButton("Tambah");
        btnEdit   = new JButton("Edit - pilih baris");
        btnSimpan = new JButton("Simpan Perubahan");
        btnBatal  = new JButton("Batal Edit");
        btnHapus  = new JButton("Hapus");
        btnDetail = new JButton("Detail - pilih baris");
        btnClear  = new JButton("Clear Form");
        btnReload = new JButton("Reload");

        btnTambah.addActionListener(e -> tambahMahasiswaAsync());
        btnEdit.addActionListener(e -> mulaiEditDariBaris());
        btnSimpan.addActionListener(e -> simpanEditAsync());
        btnBatal.addActionListener(e -> batalEdit());

        btnHapus.addActionListener(e -> hapusSelectedAsync());
        btnDetail.addActionListener(e -> showDetailSelected());
        btnClear.addActionListener(e -> clearForm());
        btnReload.addActionListener(e -> loadFromDatabaseAsync());

        p.add(btnTambah);
        p.add(btnEdit);
        p.add(btnSimpan);
        p.add(btnBatal);
        p.add(btnHapus);
        p.add(btnDetail);
        p.add(btnClear);
        p.add(btnReload);

        setEditMode(false);
        return p;
    }

    private void setEditMode(boolean on) {
        editMode = on;

        btnTambah.setEnabled(!on);
        btnEdit.setEnabled(!on);
        btnHapus.setEnabled(!on);

        btnSimpan.setEnabled(on);
        btnBatal.setEnabled(on);

        // saat edit, kita boleh ganti jenis juga (boleh), tapi NIM harus hati-hati
        // boleh tetap enabled, karena DAO update sudah handle cek duplikat
        // tfNim.setEnabled(true);

        setTitle(on ? "Sistem Manajemen Data Mahasiswa (MODE EDIT)" : "Sistem Manajemen Data Mahasiswa");
    }

    private void setBusy(boolean busy) {
        // saat loading, semua tombol dikunci
        btnTambah.setEnabled(!busy && !editMode);
        btnEdit.setEnabled(!busy && !editMode);
        btnHapus.setEnabled(!busy && !editMode);
        btnDetail.setEnabled(!busy);
        btnClear.setEnabled(!busy);
        btnReload.setEnabled(!busy);

        btnSimpan.setEnabled(!busy && editMode);
        btnBatal.setEnabled(!busy && editMode);

        setCursor(busy ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getDefaultCursor());
    }

    private void loadFromDatabaseAsync() {
        setBusy(true);

        SwingWorker<ArrayList<Mahasiswa>, Void> worker = new SwingWorker<>() {
            @Override
            protected ArrayList<Mahasiswa> doInBackground() throws Exception {
                return dao.getAllMahasiswa();
            }

            @Override
            protected void done() {
                try {
                    ArrayList<Mahasiswa> result = get();
                    daftarMahasiswa.clear();
                    daftarMahasiswa.addAll(result);
                    refreshTable();
                } catch (Exception ex) {
                    showError("Gagal load data dari database:\n" + ex.getMessage());
                } finally {
                    setBusy(false);
                }
            }
        };
        worker.execute();
    }

    private void tambahMahasiswaAsync() {
        if (editMode) {
            JOptionPane.showMessageDialog(this, "Sedang mode edit. Klik 'Batal Edit' dulu.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        final Mahasiswa obj;
        try {
            obj = buildObjFromForm();
        } catch (Exception ex) {
            showError(ex.getMessage());
            return;
        }

        setBusy(true);

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                dao.insertMahasiswa(obj);
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    JOptionPane.showMessageDialog(DataMahasiswaGUI.this, "Data berhasil ditambahkan ✅", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    clearForm();
                    loadFromDatabaseAsync();
                } catch (Exception ex) {
                    showError("Gagal insert ke database:\n" + ex.getMessage());
                } finally {
                    setBusy(false);
                }
            }
        };

        worker.execute();
    }

    // ====== EDIT FLOW ======
    private void mulaiEditDariBaris() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris mahasiswa yang mau diedit.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Mahasiswa m = daftarMahasiswa.get(row);
        oldNimForEdit = m.getNim();

        // isi form dari objek
        tfNama.setText(m.getNama());
        tfNim.setText(m.getNim());
        tfProdi.setText(m.getProdi());
        tfFakultas.setText(m.getFakultas());
        spSemester.setValue(m.getSemester());
        cbKampus.setSelectedItem(m.getKampus());

        String jenisLabel = m.getJenisMahasiswa(); // "Mahasiswa Aktif" dll dari override
        cbJenis.setSelectedItem(jenisLabel);
        cardLayout.show(panelExtra, jenisLabel);

        // isi extra sesuai jenis
        if (m instanceof MahasiswaAktif) {
            MahasiswaAktif a = (MahasiswaAktif) m;
            spSks.setValue(a.getSksTempuh());
            tfIpk.setText(String.valueOf(a.getIpk()));
            tfStatus.setText(a.getStatus());
        } else if (m instanceof MahasiswaBaru) {
            MahasiswaBaru b = (MahasiswaBaru) m;
            tfAsalSekolah.setText(b.getAsalSekolah());
            spTahunMasuk.setValue(b.getTahunMasuk());
        } else if (m instanceof MahasiswaCuti) {
            MahasiswaCuti c = (MahasiswaCuti) m;
            tfAlasanCuti.setText(c.getAlasanCuti());
            spDurasiCuti.setValue(c.getDurasiCuti());
        } else if (m instanceof MahasiswaLulus) {
            MahasiswaLulus l = (MahasiswaLulus) m;
            spTahunLulus.setValue(l.getTahunLulus());
            tfIpkAkhir.setText(String.valueOf(l.getIpkAkhir()));
        }

        setEditMode(true);
    }

    private void simpanEditAsync() {
        if (!editMode || oldNimForEdit == null) {
            JOptionPane.showMessageDialog(this, "Tidak sedang mode edit.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        final Mahasiswa obj;
        try {
            obj = buildObjFromForm();
        } catch (Exception ex) {
            showError(ex.getMessage());
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Simpan perubahan data?\n(NIM lama: " + oldNimForEdit + ")", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        setBusy(true);

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                dao.updateMahasiswaByNim(oldNimForEdit, obj);
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    JOptionPane.showMessageDialog(DataMahasiswaGUI.this, "Data berhasil diupdate ✅", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    batalEdit(); // reset state + clear form
                    loadFromDatabaseAsync();
                } catch (Exception ex) {
                    showError("Gagal update ke database:\n" + ex.getMessage());
                } finally {
                    setBusy(false);
                }
            }
        };

        worker.execute();
    }

    private void batalEdit() {
        oldNimForEdit = null;
        clearForm();
        setEditMode(false);
    }

    // ====== DELETE ======
    private void hapusSelectedAsync() {
        if (editMode) {
            JOptionPane.showMessageDialog(this, "Sedang mode edit. Klik 'Batal Edit' dulu.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris mahasiswa yang mau dihapus.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String nim = (String) tableModel.getValueAt(row, 1);
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin hapus NIM: " + nim + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        setBusy(true);

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                dao.deleteMahasiswaByNim(nim);
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    JOptionPane.showMessageDialog(DataMahasiswaGUI.this, "Data berhasil dihapus ✅", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    loadFromDatabaseAsync();
                } catch (Exception ex) {
                    showError("Gagal hapus dari database:\n" + ex.getMessage());
                } finally {
                    setBusy(false);
                }
            }
        };

        worker.execute();
    }

    // ====== BUILD OBJECT FROM FORM ======
    private Mahasiswa buildObjFromForm() throws Exception {
        String nama = tfNama.getText().trim();
        String nim = tfNim.getText().trim();
        String prodi = tfProdi.getText().trim();
        String fakultas = tfFakultas.getText().trim();
        int semester = (Integer) spSemester.getValue();
        String kampus = (String) cbKampus.getSelectedItem();
        String jenis = (String) cbJenis.getSelectedItem();

        if (nama.isEmpty() || nim.isEmpty() || prodi.isEmpty() || fakultas.isEmpty()) {
            throw new Exception("Nama/NIM/Prodi/Fakultas wajib diisi!");
        }

        Mahasiswa obj = buildByJenis(jenis);

        obj.setNama(nama);
        obj.setNim(nim);
        obj.setProdi(prodi);
        obj.setFakultas(fakultas);
        obj.setSemester(semester);
        obj.setKampus(kampus);

        return obj;
    }

    private Mahasiswa buildByJenis(String jenis) throws Exception {
        switch (jenis) {
            case "Mahasiswa Aktif": {
                MahasiswaAktif m = new MahasiswaAktif();
                m.setSksTempuh((Integer) spSks.getValue());
                m.setIpk(parseDoubleFlexible(tfIpk.getText().trim(), "IPK"));
                String status = tfStatus.getText().trim();
                m.setStatus(status.isEmpty() ? "Aktif" : status);
                return m;
            }
            case "Mahasiswa Baru": {
                MahasiswaBaru m = new MahasiswaBaru();
                m.setAsalSekolah(tfAsalSekolah.getText().trim());
                m.setTahunMasuk((Integer) spTahunMasuk.getValue());
                return m;
            }
            case "Mahasiswa Cuti": {
                MahasiswaCuti m = new MahasiswaCuti();
                m.setAlasanCuti(tfAlasanCuti.getText().trim());
                m.setDurasiCuti((Integer) spDurasiCuti.getValue());
                return m;
            }
            case "Mahasiswa Lulus": {
                MahasiswaLulus m = new MahasiswaLulus();
                m.setTahunLulus((Integer) spTahunLulus.getValue());
                m.setIpkAkhir(parseDoubleFlexible(tfIpkAkhir.getText().trim(), "IPK Akhir"));
                return m;
            }
            default:
                throw new Exception("Jenis mahasiswa tidak valid!");
        }
    }

    // ====== DETAIL ======
    private void showDetailSelected() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris dulu.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Mahasiswa m = daftarMahasiswa.get(row);

        StringBuilder sb = new StringBuilder();
        sb.append("Jenis: ").append(m.getJenisMahasiswa()).append("\n");
        sb.append("Nama: ").append(m.getNama()).append("\n");
        sb.append("NIM: ").append(m.getNim()).append("\n");
        sb.append("Prodi: ").append(m.getProdi()).append("\n");
        sb.append("Fakultas: ").append(m.getFakultas()).append("\n");
        sb.append("Semester: ").append(m.getSemester()).append("\n");
        sb.append("Kampus: ").append(m.getKampus()).append("\n\n");

        if (m instanceof MahasiswaAktif) {
            MahasiswaAktif a = (MahasiswaAktif) m;
            sb.append("SKS Tempuh: ").append(a.getSksTempuh()).append("\n");
            sb.append("IPK: ").append(a.getIpk()).append("\n");
            sb.append("Status: ").append(a.getStatus()).append("\n");
        } else if (m instanceof MahasiswaBaru) {
            MahasiswaBaru b = (MahasiswaBaru) m;
            sb.append("Asal Sekolah: ").append(b.getAsalSekolah()).append("\n");
            sb.append("Tahun Masuk: ").append(b.getTahunMasuk()).append("\n");
        } else if (m instanceof MahasiswaCuti) {
            MahasiswaCuti c = (MahasiswaCuti) m;
            sb.append("Alasan Cuti: ").append(c.getAlasanCuti()).append("\n");
            sb.append("Durasi Cuti: ").append(c.getDurasiCuti()).append(" semester\n");
        } else if (m instanceof MahasiswaLulus) {
            MahasiswaLulus l = (MahasiswaLulus) m;
            sb.append("Tahun Lulus: ").append(l.getTahunLulus()).append("\n");
            sb.append("IPK Akhir: ").append(l.getIpkAkhir()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Detail Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
    }

    // ====== TABLE ======
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Mahasiswa m : daftarMahasiswa) {
            tableModel.addRow(new Object[]{
                    m.getNama(),
                    m.getNim(),
                    m.getJenisMahasiswa(),
                    m.getProdi(),
                    m.getSemester(),
                    m.getKampus()
            });
        }
    }

    // ====== CLEAR ======
    private void clearForm() {
        tfNama.setText("");
        tfNim.setText("");
        tfProdi.setText("");
        tfFakultas.setText("");
        spSemester.setValue(1);
        cbKampus.setSelectedIndex(0);

        if (tfIpk != null) tfIpk.setText("");
        if (tfStatus != null) tfStatus.setText("");

        if (tfAsalSekolah != null) tfAsalSekolah.setText("");
        if (spTahunMasuk != null) spTahunMasuk.setValue(2025);

        if (tfAlasanCuti != null) tfAlasanCuti.setText("");
        if (spDurasiCuti != null) spDurasiCuti.setValue(1);

        if (spTahunLulus != null) spTahunLulus.setValue(2025);
        if (tfIpkAkhir != null) tfIpkAkhir.setText("");

        cbJenis.setSelectedItem("Mahasiswa Aktif");
        cardLayout.show(panelExtra, "Mahasiswa Aktif");
    }

    private double parseDoubleFlexible(String text, String fieldName) throws Exception {
        if (text == null || text.isEmpty()) throw new Exception(fieldName + " wajib diisi.");
        String normalized = text.replace(',', '.');
        try {
            return Double.parseDouble(normalized);
        } catch (NumberFormatException e) {
            throw new Exception(fieldName + " harus berupa angka desimal. Contoh: 3.76");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DataMahasiswaGUI gui = new DataMahasiswaGUI();
            gui.setVisible(true);
        });
    }
}
