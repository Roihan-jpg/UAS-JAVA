Studi Kasus 1 <SistemNilai.java>


//Mendeklarasikan kelas SistemNilai.
public class SistemNilai {
    //Method utama yang dieksekusi saat program dijalankan.
    public static void main(String[] args) {
        // Data siswa
        // Menyimpan nama siswa dalam array 1D.
        String[] namaSiswa = {"Ani", "Budi", "Cici", "Dodi", "Edi"};
        // Array 2D yang menyimpan nilai setiap siswa dalam 3 mata pelajaran.
        int[][] nilai = {
            {80, 85, 90}, // Nilai Ani
            {75, 70, 85}, // Nilai Budi
            {85, 80, 88}, // Nilai Cici
            {90, 85, 95}, // Nilai Dodi
            {70, 75, 80}  // Nilai Edi
        };
        // Menyimpan nama mata pelajaran yang sesuai dengan indeks kolom dalam array nilai.
        String[] mapel = {"Matematika", "Bahasa Inggris", "IPA"};

        // Menghitung rata-rata per siswa
        // Mencetak teks header.
        System.out.println("Rata-rata nilai per siswa:");
        // Loop for pertama (i) Mengakses setiap siswa dalam array nilai.
        for (int i = 0; i < nilai.length; i++) {
            double total = 0;
            // Loop for-each (n) Menjumlahkan semua nilai siswa dalam variabel total.
            for (int n : nilai[i]) {
                total += n;
            }
            // Menghitung rata-rata nilai siswa.
            double rataSiswa = total / nilai[i].length;
            // Mencetak nama siswa dan rata-ratanya dengan 2 desimal.
            System.out.printf("%s: %.2f\\n", namaSiswa[i], rataSiswa);
        }

        // Menghitung rata-rata per mata pelajaran
        System.out.println("\\nRata-rata nilai per mata pelajaran:");
        // Loop for pertama (j) Mengakses setiap kolom (mata pelajaran) dari array nilai.
        for (int j = 0; j < nilai[0].length; j++) {
            double total = 0;
            // Loop for kedua (i) Menjumlahkan semua nilai siswa untuk mata pelajaran tersebut.
            for (int i = 0; i < nilai.length; i++) {
                total += nilai[i][j];
            }
            // Menghitung rata-rata nilai untuk mata pelajaran tersebut.
            double rataMapel = total / nilai.length;
            // Mencetak rata-rata nilai untuk setiap mata pelajaran.
            System.out.printf("%s: %.2f\\n", mapel[j], rataMapel);
        }
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------
Studi Kasus 2 <TicTacToe.java>


// Mendeklarasikan kelas TicTacToe.
public class TicTacToe {
    // Method utama yang dieksekusi saat program dijalankan.
    public static void main(String[] args) {
        // Membuat papan Tic Tac Toe berukuran 3x3 dengan tipe data char.
        char[][] papan = new char[3][3];

        // Inisialisasi papan kosong
        // Loop pertama (i) → Mengakses baris (0 sampai 2).
        for (int i = 0; i < 3; i++) {
            // Loop kedua (j) → Mengakses kolom (0 sampai 2).
            for (int j = 0; j < 3; j++) {
                // Mengisi setiap sel dengan '-' sebagai tanda papan kosong.
                papan[i][j] = '-';
            }
        }

        // Simulasi beberapa langkah Permainan
        // Pemain X menempatkan simbol di baris 0, kolom 0.
        papan[0][0] = 'X';
        // Pemain O menempatkan simbol di baris 1, kolom 1.
        papan[1][1] = 'O';
        // Pemain X menempatkan simbol di baris 2, kolom 2.
        papan[2][2] = 'X';

        // Tampilkan papan
        // Mencetak teks sebagai header.
        System.out.println("Status Papan:");
        // Memanggil method untuk mencetak isi papan.
        tampilkanPapan(papan);
    }
    // Method tampilkanPapan digunakan untuk mencetak papan Tic Tac Toe.
    public static void tampilkanPapan(char[][] papan) {
        // Loop for pertama (i) → Mengakses setiap baris.
        for (int i = 0; i < 3; i++) {
            // Loop for kedua (j) → Mengakses setiap kolom.
            for (int j = 0; j < 3; j++) {
                // Mencetak setiap elemen papan dengan spasi antar elemen.
                System.out.print(papan[i][j] + " ");
            }
            // Berpindah ke baris baru setelah mencetak satu baris.
            System.out.println();
        }
    }
}
