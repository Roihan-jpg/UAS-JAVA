import java.util.ArrayList;//  mengimpor ArrayList/untuk menyimpan daftar prestasi mahasiswa 
import java.util.Scanner;//  mengimpor Scanner agar program bisa membaca input pengguna

class Prestasi {//  Mendeklarasikan kelas prestasi yang digunakan untuk menyimpan informasi prestasi mahasiswa
    String nama;//  Menyimpan nama mahasiswa.
    String nim;//  Menyimpan NIM
    String jenis;//  Menyimpan jenis prestasi (akademik atau non-akademik)
    String tingkat;//  Menyimpan tingkat prestasi (Lokal/Nasional/Internasional)
    String tahun;//  Menyimpan tahun prestasi

    public Prestasi(String nama, String nim, String jenis, String tingkat, String tahun) {//  Membuat konstruktor Prestasi yang menerima lima parameter (nama, nim, jenis, tingkat, tahun).
        this.nama = nama;//  Mengisi variabel nama dengan nilai yang diberikan oleh pengguna.
        this.nim = nim;//  Mengisi variabel nim dengan nilai yang diberikan oleh pengguna.
        this.jenis = jenis;//  Mengisi variabel jenis dengan nilai yang diberikan oleh pengguna.
        this.tingkat = tingkat;//  Mengisi variabel tingkat dengan nilai yang diberikan oleh pengguna.
        this.tahun = tahun;//  Mengisi variabel tahun dengan nilai yang diberikan oleh pengguna.
    }
    
    @Override//  Menandakan bahwa method ini menggantikan (override) method toString() dari superclass Object.
    public String toString() {//  Method untuk mengubah objek Prestasi menjadi teks yang mudah dibaca.
        return "Nama: " + nama + ", NIM: " + nim + ", Jenis: " + jenis + ", Tingkat: " + tingkat + ", Tahun: " + tahun;//  Menggabungkan semua atribut Prestasi menjadi satu string format yang rapi.
    }//  Menutup method  toString().
}//  Menutup method Prestasi

//Ketika objek Prestasi dipanggil dalam System.out.println(), method toString() akan otomatis digunakan untuk menampilkan isi objek.

public class PrestasiUas8 {//  Membuat kelas utama tempat program dijalankan.
    private static ArrayList<Prestasi> prestasiList = new ArrayList<>();//  Membuat daftar (ArrayList) prestasi untuk menyimpan objek Prestasi yang dimasukkan oleh pengguna yang berlaku untuk seluruh class dan tidak berubah selama program berjalan.
    private static Scanner scanner = new Scanner(System.in);//  Membuat objek Scanner untuk membaca input dari pengguna dan digunakan di seluruh method untuk membaca data dari keyboard.

    public static void main(String[] args) {//  Titik awal program.
        menu();//  Memanggil method menu() untuk menampilkan menu utama.
    }

    private static void menu() {//  Membuat method menu() yang akan menampilkan pilihan menu kepada pengguna.
        while (true) {//  Perulangan tak terbatas, sehingga program terus berjalan sampai pengguna memilih keluar.
            System.out.println("\nMenu Utama:");//  Menampilkan daftar menu pilihan kepada pengguna.
            System.out.println("1. Tambah Prestasi");//  Opsi menu untuk input data prestasi mahasiswa.
            System.out.println("2. Lihat Prestasi");//  Opsi menu untuk melihat prestasi inputan yang telah disimpan.
            System.out.println("3. Analisis Prestasi");//  Opsi menu untuk menganalisis berdasarkan tahun 
            System.out.println("4. Hapus Prestasi");//  Opsi menu untuk menghapus data inputan.
            System.out.println("5. Keluar");//  Opsi menu untuk keluar dari loop menu.
            System.out.print("Pilih opsi (1-5): ");//  Meminta pengguna memilih menu dengan kode angka 1-5.
            int pilihan = scanner.nextInt();//  Membaca pilihan menu dalam bentuk angka.
            scanner.nextLine(); //  Mengosongkan buffer input agar tidak ada kesalahan saat membaca input berikutnya.

            switch (pilihan) {//  Menggunakan switch-case untuk menangani berbagai opsi menu.
                case 1://  Jika pengguna memilih 1, maka method tambahPrestasi() dipanggil.
                    tambahPrestasi();//  Method.
                    break;//  Memberhentikan kode program agar case tidak jatuh ke bawah.
                case 2://  Jika pengguna memilih 2, maka method lihatPrestasi() dipanggil.
                    lihatPrestasi();//  Method.
                    break;//  Memberhentikan kode program agar case tidak jatuh ke bawah.
                case 3://  Jika pengguna memilih 3, maka method analisisPrestasi() dipanggil.
                    analisisPrestasi();//  Method.
                    break;//  Memberhentikan kode program agar case tidak jatuh ke bawah.
                case 4://  Jika pengguna memilih 4, maka method hapusPrestasi() dipanggil.
                    hapusPrestasi();//  Method.
                    break;//  Memberhentikan kode program agar case tidak jatuh ke bawah.
                case 5://  Jika pengguna memilih 5, maka program berhenti (return menghentikan method menu()).
                    System.out.println("Keluar dari program.");//  Output keluar dari method menu.
                    return;//  Keluar dari seluruh method yang berjalan.
                default:// menangani kasus(input) yang tidak sesuai dengan case.
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");//  Output untuk keterangan kesalahan input yg tidak sesuai dengan case.
            }//  Menutup switch (pilihan).
        }//  Menutup blok kode switch-case dan while-loop.
    }

    private static void tambahPrestasi() {//   Meminta input data prestasi dari pengguna.
        System.out.print("Masukkan nama mahasiswa: ");//  Output.
        String nama = scanner.nextLine();//  Nama mahasiswa peroleh prestasi.
        System.out.print("Masukkan NIM mahasiswa: ");//  Output.
        String nim = scanner.nextLine();//  Input NIM.
        System.out.print("Masukkan jenis prestasi: ");//  Output.
        String jenis = scanner.nextLine();// Jenis(Perolehan) Juara.
        System.out.print("Masukkan tingkat prestasi (Lokal/Nasional/Internasional): ");//  Output.
        String tingkat = scanner.nextLine();//  Tingkat provinsi/nasional/Internasional.
    
        // Validasi tahun
        String tahun = "";//  Deklarasi variabel tahun yang akan menyimpan input tahun dari pengguna bertipe String agar bisa langsung diolah dalam validasi.
        while (true) {//  digunakan agar pengguna terus diminta memasukkan input sampai tahun yang diberikan valid.
            System.out.print("Masukkan tahun prestasi (antara 2010 dan 2024): ");//  Memvalidasi input tahun agar berada dalam rentang 2010-2024.
            tahun = scanner.nextLine();// Deklarasi scanner menggunakan nextLine untuk String, NIM, Tingkat prestasi, dan tahun.
            try {
                int tahunInt = Integer.parseInt(tahun);  // Mengubah input menjadi integer Jika input bukan angka, akan terjadi NumberFormatException, yang ditangani di bagian catch.
                if (tahunInt >= 2010 && tahunInt <= 2024) {//  Jika tahun berada dalam rentang 2010-2024, perulangan dihentikan
                    break; // Keluar dari loop jika tahun valid
                } else {
                    System.out.println("Tahun harus antara 2010 dan 2024. Silakan coba lagi.");//  jika tahun diluar rentan maka program menampilkan pesan error dan meminta input ulang.
                }
            } catch (NumberFormatException e) {//  Jika pengguna memasukkan teks atau karakter non-angka.
                System.out.println("Input tahun tidak valid. Silakan masukkan angka tahun yang valid.");//  Output error yang dihasilkan.
            }
        }Menutup method tambahPrestasi().
    
        Prestasi prestasi = new Prestasi(nama, nim, jenis, tingkat, tahun);//  Menyimpan data ke ArrayList dan menampilkan konfirmasi.
        prestasiList.add(prestasi);
        System.out.println("Prestasi berhasil ditambahkan!");//  Output yang dihasilkan setelaha berhasil terkonfirmasi.
    }
    

    private static void lihatPrestasi() {//  Method untuk menampilkan semua data prestasi mahasiswa.
        if (prestasiList.isEmpty()) {//  Mengecek apakah daftar prestasiList kosong.
            System.out.println("Tidak ada prestasi yang dicatat.");//  Jika kosong, menampilkan pesan ke pengguna.
            return;//  Menghentikan eksekusi method jika daftar kosong.
        }
        for (Prestasi prestasi : prestasiList) {//  Perulangan for-each untuk menampilkan setiap prestasi yang ada dalam daftar.
            System.out.println(prestasi);//  Menampilkan informasi setiap Prestasi menggunakan method toString().
        }//  Menutup perulangan for.
    }//  Menutup method lihatPrestasi().

    private static void analisisPrestasi() {//  Method untuk menganalisis data prestasi mahasiswa.
        if (prestasiList.isEmpty()) {//  Mengecek apakah prestasiList kosong.
            System.out.println("Tidak ada prestasi yang dicatat.");//  Jika kosong, menampilkan pesan ke pengguna.
            return;//  Menghentikan eksekusi method jika daftar kosong.
        }//  Menutup method analisisPrestasi().

        System.out.println("Analisis Prestasi berdasarkan tahun:");//  Menampilkan judul analisis.
        prestasiList.sort((p1, p2) -> p1.tahun.compareTo(p2.tahun)); // Sorting by year//  Mengurutkan daftar berdasarkan tahun menggunakan sort() dari yang paling awal.

        for (Prestasi prestasi : prestasiList) {//   Perulangan for-each untuk mencetak data prestasi yang telah diurutkan.
            System.out.println(prestasi);//  Menampilkan informasi Prestasi.
        }//  Menutup perulangan for.

        // Tambahan analisis berdasarkan jenis prestasi
        System.out.println("\nAnalisis Prestasi berdasarkan jenis:");//  Menampilkan judul analisis berdasarkan tingkat prestasi.
        for (String jenis : new String[]{"Lokal", "Nasional", "Internasional"}) {//  Melakukan perulangan untuk setiap kategori tingkat prestasi.
            System.out.println("\nPrestasi " + jenis + ":");//  Menampilkan kategori prestasi yang sedang dianalisis.
            boolean found = false;//  Variabel untuk mengecek apakah ada prestasi dengan kategori tersebut.
            for (Prestasi prestasi : prestasiList) {//  Perulangan for-each untuk memeriksa setiap prestasi dalam daftar.
                if (prestasi.tingkat.equalsIgnoreCase(jenis)) {//  Mengecek apakah tingkat prestasi cocok dengan kategori yang sedang diperiksa.
                    System.out.println(prestasi);//  Menampilkan prestasi yang sesuai.
                    found = true;//  Menandai bahwa setidaknya ada satu prestasi yang ditemukan.
                }//  Menutup if.
            }//  Menutup for pertama.
            if (!found) {//   Jika found masih false, berarti tidak ada prestasi dengan kategori tersebut.
                System.out.println("Tidak ada prestasi dengan jenis " + jenis + ".");//  Menampilkan pesan bahwa tidak ada prestasi di kategori tersebut.
            }//  Menutup if (!found).
        }//  Menutup for utama.
    }//  Menutup method analisisPrestasi().

    private static void hapusPrestasi() {//  Method untuk menghapus prestasi berdasarkan NIM mahasiswa.
        System.out.print("Masukkan NIM mahasiswa yang prestasinya ingin dihapus: ");//  Meminta input NIM mahasiswa yang prestasinya akan dihapus.
        String nim = scanner.nextLine();//  Membaca input NIM dari pengguna.
        boolean found = false;//  Variabel untuk mengecek apakah NIM ditemukan di daftar prestasi.

        for (int i = 0; i < prestasiList.size(); i++) {//  Perulangan untuk mencari prestasi berdasarkan NIM.
            if (prestasiList.get(i).nim.equals(nim)) {//  Jika ditemukan prestasi dengan NIM yang sama.
                prestasiList.remove(i);//  Menghapus prestasi dari daftar.
                found = true;//  Menandai bahwa prestasi telah ditemukan dan dihapus.
                System.out.println("Prestasi berhasil dihapus.");//  Menampilkan pesan sukses.
                break;//  Keluar dari perulangan setelah prestasi dihapus.
            }//  Menutup if (prestasiList.get(i).nim.equals(nim))
        }//  Menutup method hapusPrestasi().

        if (!found) {//  Jika found masih false, berarti tidak ada prestasi dengan NIM tersebut.
            System.out.println("NIM tidak ditemukan.");//  Menampilkan pesan bahwa NIM tidak ditemukan.
        }//   Menutup if (!found).
    }//   Menutup method hapusPrestasi().
}//  Menutup class PrestasiUas8.
