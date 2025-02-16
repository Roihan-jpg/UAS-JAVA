import java.util.ArrayList;
import java.util.Scanner;

class Prestasi {
    String nama;
    String nim;
    String jenis;
    String tingkat;
    String tahun;

    public Prestasi(String nama, String nim, String jenis, String tingkat, String tahun) {
        this.nama = nama;
        this.nim = nim;
        this.jenis = jenis;
        this.tingkat = tingkat;
        this.tahun = tahun;
    }
    
    @Override
    public String toString() {
        return "Nama: " + nama + ", NIM: " + nim + ", Jenis: " + jenis + ", Tingkat: " + tingkat + ", Tahun: " + tahun;
    }
}

public class PrestasiUas8 {
    private static ArrayList<Prestasi> prestasiList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Prestasi");
            System.out.println("2. Lihat Prestasi");
            System.out.println("3. Analisis Prestasi");
            System.out.println("4. Hapus Prestasi");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (pilihan) {
                case 1:
                    tambahPrestasi();
                    break;
                case 2:
                    lihatPrestasi();
                    break;
                case 3:
                    analisisPrestasi();
                    break;
                case 4:
                    hapusPrestasi();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahPrestasi() {
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan jenis prestasi: ");
        String jenis = scanner.nextLine();
        System.out.print("Masukkan tingkat prestasi (Lokal/Nasional/Internasional): ");
        String tingkat = scanner.nextLine();
    
        // Validasi tahun
        String tahun = "";
        while (true) {
            System.out.print("Masukkan tahun prestasi (antara 2010 dan 2024): ");
            tahun = scanner.nextLine();
            try {
                int tahunInt = Integer.parseInt(tahun);  // Mengubah input menjadi integer
                if (tahunInt >= 2010 && tahunInt <= 2024) {
                    break; // Keluar dari loop jika tahun valid
                } else {
                    System.out.println("Tahun harus antara 2010 dan 2024. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tahun tidak valid. Silakan masukkan angka tahun yang valid.");
            }
        }
    
        Prestasi prestasi = new Prestasi(nama, nim, jenis, tingkat, tahun);
        prestasiList.add(prestasi);
        System.out.println("Prestasi berhasil ditambahkan!");
    }
    

    private static void lihatPrestasi() {
        if (prestasiList.isEmpty()) {
            System.out.println("Tidak ada prestasi yang dicatat.");
            return;
        }
        for (Prestasi prestasi : prestasiList) {
            System.out.println(prestasi);
        }
    }

    private static void analisisPrestasi() {
        if (prestasiList.isEmpty()) {
            System.out.println("Tidak ada prestasi yang dicatat.");
            return;
        }

        System.out.println("Analisis Prestasi berdasarkan tahun:");
        prestasiList.sort((p1, p2) -> p1.tahun.compareTo(p2.tahun)); // Sorting by year

        for (Prestasi prestasi : prestasiList) {
            System.out.println(prestasi);
        }

        // Tambahan analisis berdasarkan jenis prestasi
        System.out.println("\nAnalisis Prestasi berdasarkan jenis:");
        for (String jenis : new String[]{"Lokal", "Nasional", "Internasional"}) {
            System.out.println("\nPrestasi " + jenis + ":");
            boolean found = false;
            for (Prestasi prestasi : prestasiList) {
                if (prestasi.tingkat.equalsIgnoreCase(jenis)) {
                    System.out.println(prestasi);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Tidak ada prestasi dengan jenis " + jenis + ".");
            }
        }
    }

    private static void hapusPrestasi() {
        System.out.print("Masukkan NIM mahasiswa yang prestasinya ingin dihapus: ");
        String nim = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < prestasiList.size(); i++) {
            if (prestasiList.get(i).nim.equals(nim)) {
                prestasiList.remove(i);
                found = true;
                System.out.println("Prestasi berhasil dihapus.");
                break;
            }
        }

        if (!found) {
            System.out.println("NIM tidak ditemukan.");
        }
    }
}
