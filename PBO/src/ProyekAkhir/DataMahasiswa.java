package ProyekAkhir;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataMahasiswa {

    static String inputString(String pesan) {
        Scanner input = new Scanner(System.in);
        System.out.print(pesan);
        return input.nextLine();
    }

    static int inputSemester() {
        Scanner input = new Scanner(System.in);
        System.out.print("Semester: ");
        int semester = input.nextInt();
        if (semester <= 0 || semester > 14) return -1;
        return semester;
    }

    static String pilihKampus() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----- Pilih Kampus -----");
        System.out.println("1. Jakarta");
        System.out.println("2. Bekasi");
        System.out.println("3. Tangerang");
        System.out.println("------------------------");
        System.out.print("Masukkan kode kampus: ");
        int kode = input.nextInt();

        switch (kode) {
            case 1: return "Jakarta";
            case 2: return "Bekasi";
            case 3: return "Tangerang";
            default: return "Kode kampus tidak valid!";
        }
    }

    // MEMORY MANAGEMENT (Sesi 7)
    static void tampilkanMemori(String ket) {
        Runtime rt = Runtime.getRuntime();
        long total = rt.totalMemory() / (1024 * 1024);
        long free = rt.freeMemory() / (1024 * 1024);
        long used = total - free;

        System.out.println("\n=== " + ket + " ===");
        System.out.println("Total Memory  : " + total + " MB");
        System.out.println("Free Memory   : " + free + " MB");
        System.out.println("Used Memory   : " + used + " MB");
    }

    static void demoCallingSequence() {
        tampilkanMemori("Sebelum method bertingkat");
        langkah1();
        tampilkanMemori("Sesudah method bertingkat");
    }
    static void langkah1() { langkah2(); }
    static void langkah2() { langkah3(); }
    static void langkah3() {}

    static void demoSimpleVariables() {
        tampilkanMemori("Sebelum variabel sederhana");
        int a = 10, b = 20;
        int c = a + b;
        tampilkanMemori("Sesudah variabel sederhana");
    }

    static void demoReferenceVariables() {
        tampilkanMemori("Sebelum objek");
        MahasiswaAktif m = new MahasiswaAktif();
        m = null;
        System.gc();
        tampilkanMemori("Setelah GC");
    }

    // Sesi 11: EXCEPTION HANDLING
    static int inputIntAman(String pesan) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(pesan);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Input harus berupa angka!");
                sc.nextLine();
            }
        }
    }

    static double inputDoubleAman(String pesan) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(pesan);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Input harus berupa angka desimal!");
                sc.nextLine();
            }
        }
    }

    static int inputSemesterAman() throws InputSalahException {
        int semester = inputIntAman("Semester: ");
        if (semester <= 0 || semester > 14) {
            throw new InputSalahException("Semester harus antara 1 - 14!");
        }
        return semester;
    }

    // Sesi 12: Collection
    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    static void tambahMahasiswa(Scanner pilih) {
        System.out.println("\n===== Pilih Jenis Mahasiswa =====");
        System.out.println("1. Mahasiswa Aktif");
        System.out.println("2. Mahasiswa Baru");
        System.out.println("3. Mahasiswa Cuti");
        System.out.println("4. Mahasiswa Lulus");
        System.out.println("---------------------------------");
        System.out.print("Masukkan pilihan (1-4): ");
        int jenis = pilih.nextInt();
        pilih.nextLine();

        if (jenis == 1) {
            MahasiswaAktif mhs = new MahasiswaAktif();

            mhs.setNama(inputString("Nama: "));
            mhs.setNim(inputString("NIM: "));
            mhs.setProdi(inputString("Prodi: "));
            mhs.setFakultas(inputString("Fakultas: "));

            int smt = inputSemester();
            if (smt == -1) return;
            mhs.setSemester(smt);

            mhs.setKampus(pilihKampus());

            System.out.print("Jumlah SKS: ");
            mhs.setSksTempuh(pilih.nextInt());
            System.out.print("IPK: ");
            mhs.setIpk(pilih.nextDouble());
            pilih.nextLine();
            System.out.print("Status: ");
            mhs.setStatus(pilih.nextLine());

            daftarMahasiswa.add(mhs);
            System.out.println("✅ Mahasiswa Aktif berhasil ditambahkan!");
        } else if (jenis == 2) {
            MahasiswaBaru m = new MahasiswaBaru();

            m.setNama(inputString("Nama: "));
            m.setNim(inputString("NIM: "));
            m.setProdi(inputString("Prodi: "));
            m.setFakultas(inputString("Fakultas: "));
            m.setSemester(1);
            m.setKampus(pilihKampus());

            System.out.print("Asal sekolah: ");
            m.setAsalSekolah(pilih.nextLine());
            System.out.print("Tahun masuk: ");
            m.setTahunMasuk(pilih.nextInt());

            daftarMahasiswa.add(m);
            System.out.println("✅ Mahasiswa Baru berhasil ditambahkan!");
        } else if (jenis == 3) {
            MahasiswaCuti m = new MahasiswaCuti();

            m.setNama(inputString("Nama: "));
            m.setNim(inputString("NIM: "));
            m.setProdi(inputString("Prodi: "));
            m.setFakultas(inputString("Fakultas: "));

            System.out.print("Alasan cuti: ");
            m.setAlasanCuti(pilih.nextLine());
            System.out.print("Durasi cuti (semester): ");
            m.setDurasiCuti(pilih.nextInt());

            daftarMahasiswa.add(m);
            System.out.println("✅ Mahasiswa Cuti berhasil ditambahkan!");
        } else if (jenis == 4) {
            MahasiswaLulus m = new MahasiswaLulus();

            m.setNama(inputString("Nama: "));
            m.setNim(inputString("NIM: "));
            m.setProdi(inputString("Prodi: "));
            m.setFakultas(inputString("Fakultas: "));

            System.out.print("Tahun lulus: ");
            m.setTahunLulus(pilih.nextInt());
            System.out.print("IPK akhir: ");
            m.setIpkAkhir(pilih.nextDouble());

            daftarMahasiswa.add(m);
            System.out.println("✅ Mahasiswa Lulus berhasil ditambahkan!");
        }
    }

    static void tampilkanSemuaMahasiswa() {
        System.out.println("\n===== DAFTAR SEMUA MAHASISWA =====");

        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        for (Mahasiswa m : daftarMahasiswa) {
            System.out.println("Nama  : " + m.getNama());
            System.out.println("NIM   : " + m.getNim());
            System.out.println("Jenis : " + m.getJenisMahasiswa());
            System.out.println("---------------------------------");
        }
    }

    static void hapusMahasiswa(Scanner pilih) {
        System.out.print("Masukkan NIM yang ingin dihapus: ");
        String nimCari = pilih.nextLine();

        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getNim().equals(nimCari)) {
                daftarMahasiswa.remove(i);
                System.out.println("Data mahasiswa berhasil dihapus.");
                return;
            }
        }
        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner pilih = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Lihat Semua Mahasiswa");
            System.out.println("3. Hapus Mahasiswa");
            System.out.println("4. Keluar");
            System.out.println("=====================");
            System.out.print("Pilih menu (1-4): ");
            menu = pilih.nextInt();
            pilih.nextLine();

            switch (menu) {
                case 1: tambahMahasiswa(pilih); break;
                case 2: tampilkanSemuaMahasiswa(); break;
                case 3: hapusMahasiswa(pilih); break;
                case 4: System.out.println("Program selesai."); break;
                default: System.out.println("Menu tidak valid!");
            }
        } while (menu != 4);

        demoCallingSequence();
        demoSimpleVariables();
        demoReferenceVariables();
    }
}
