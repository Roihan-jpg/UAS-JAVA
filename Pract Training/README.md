Praktikum 1 <LatihanArray1.java>


//Mendeklarasikan sebuah kelas bernama LatihanArray1
public class LatihanArray1 {
    //Method utama main() yang akan dieksekusi saat program dijalankan.
    public static void main(String[] args) {

        //Membuat array bilanganGenap dengan ukuran 10 untuk menyimpan bilangan genap.
        int[] bilanganGenap = new int[10];
        //Variabel jumlah digunakan untuk menyimpan total dari elemen-elemen dalam array.
        int jumlah = 0;

        //Perulangan for dijalankan dari i = 0 hingga i < bilanganGenap.length (yaitu 10 iterasi).
        for (int i = 0; i < bilanganGenap.length; i++) {
            //Setiap indeks i dalam array diisi dengan bilangan genap yang dihitung sebagai (i + 1) * 2.
            bilanganGenap[i] = (i + 1) * 2;
        }

        //Mencetak teks untuk menunjukkan bahwa berikutnya akan ditampilkan isi array.
        System.out.println("Isi array:");
        //Enhanced for-loop (for-each) digunakan untuk mengambil setiap elemen bilangan dari bilanganGenap.
        for (int bilangan : bilanganGenap) {
            //System.out.print(bilangan + " "); → Mencetak setiap elemen dalam array.
            System.out.print(bilangan + " ");
            //jumlah += bilangan; → Menambahkan setiap bilangan ke variabel jumlah.
            jumlah += bilangan;
        }
        //Menampilkan total dari semua elemen yang telah dijumlahkan.
        System.out.println("Jumlah semua elemen: " + jumlah);
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------
Praktikum 2 <PencarianArray.java>


//Mendeklarasikan sebuah kelas bernama PencarianArray.
public class PencarianArray {
    //Method utama main() yang akan dieksekusi saat program berjalan.
    public static void main(String[] args) {
        //Array nilai berisi beberapa angka yang akan digunakan untuk pencarian.
        int[] nilai = {75, 80, 65, 90, 85, 70, 95, 88};
        //Variabel cari menyimpan angka yang ingin dicari dalam array.
        int cari = 90;
        //Variabel ketemu digunakan untuk menandai apakah angka yang dicari ditemukan atau tidak.
        boolean ketemu = false;
        //Variabel indeks digunakan untuk menyimpan posisi elemen yang ditemukan dalam array. Jika tetap -1, berarti angka tidak ditemukan.
        int indeks = -1;

        //Loop for berjalan dari i = 0 hingga i < nilai.length untuk memeriksa setiap elemen dalam array.
        for (int i = 0; i < nilai.length; i++) {
            //Jika elemen ke-i dalam array sama dengan cari, maka:            
            if (nilai[i] == cari) {
                //Menandai bahwa angka ditemukan.
                ketemu = true;
                //Menyimpan posisi indeks angka yang ditemukan.
                indeks = i;
                //Menghentikan loop setelah angka ditemukan agar tidak terus mencari.
                break;
            }
        }

        //program mencetak bahwa angka ditemukan beserta indeksnya.
        if (ketemu) {
            System.out.println("Nilai " + cari + " ditemukan pada indeks " + indeks);
         //program mencetak bahwa angka tidak ditemukan.
        } else {
            System.out.println("Nilai " + cari + " tidak ditemukan");
        }
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------
Praktikum 3 <StatistikArray.java>


// Mendeklarasikan kelas StatistikArray.
public class StatistikArray {
    //Method utama main() yang dieksekusi saat program dijalankan.
    public static void main(String[] args) {
        //Array nilai menyimpan nilai-nilai siswa yang akan dihitung statistiknya.
        int[] nilai = {75, 80, 65, 90, 85, 70, 95, 88};

        //Variabel tertinggi diset ke elemen pertama array sebagai nilai awal.
        int tertinggi = nilai[0];
        //Variabel terendah juga diset ke elemen pertama array sebagai nilai awal.
        int terendah = nilai[0];
        //Variabel total untuk menyimpan jumlah semua nilai, dimulai dari elemen pertama.
        int total = nilai[0];

        //Loop for dimulai dari i = 1 (karena elemen ke-0 sudah digunakan untuk inisialisasi).
        for (int i = 1; i < nilai.length; i++) {
            //Jika elemen saat ini lebih besar dari tertinggi, maka diperbarui.
            if (nilai[i] > tertinggi) tertinggi = nilai[i];
            //Jika elemen saat ini lebih kecil dari terendah, maka diperbarui.
            if (nilai[i] < terendah) terendah = nilai[i];
            //Menambahkan nilai saat ini ke variabel total.
            total += nilai[i];
        }

        //Total semua nilai dibagi jumlah elemen array untuk mendapatkan nilai rata-rata(double digunakan agar hasil pembagian dalam bentuk desimal (bukan integer)).
        double rataRata = (double) total / nilai.length;

        //Mencetak nilai tertinggi yang ditemukan.
        System.out.println("Nilai tertinggi: " + tertinggi);
        //Mencetak nilai terendah yang ditemukan.
        System.out.println("Nilai terendah: " + terendah);
        //Mencetak hasil perhitungan rata-rata.
        System.out.println("Rata-rata: " + rataRata);
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------
Praktikum 4 <OperasiMatriks.java>


//Mendeklarasikan kelas OperasiMatriks.
public class OperasiMatriks {
    //Method utama yang dieksekusi saat program dijalankan.
    public static void main(String[] args) {
        //int[][] matriksA adalah matriks 2x3 (2 baris, 3 kolom) dengan elemen seperti dibawah:
        int[][] matriksA = {
            {1, 2, 3},
            {4, 5, 6}
        };

        //int[][] matriksB adalah matriks 2x3 dengan elemen seperti dibawah :
        int[][] matriksB = {
            {7, 8, 9},
            {10, 11, 12}
        };

        //Matriks hasil dengan ukuran yang sama (2x3) dibuat untuk menyimpan hasil penjumlahan matriksA + matriksB.
        int[][] hasil = new int[2][3];

        //Loop for pertama (i): Mengakses setiap baris (0 sampai 1).
        for (int i = 0; i < matriksA.length; i++) {
            //Loop for kedua (j): Mengakses setiap kolom (0 sampai 2).
            for (int j = 0; j < matriksA[0].length; j++) {
                //Menjumlahkan elemen dari matriksA dan matriksB berdasarkan posisi indeks [i][j].
                hasil[i][j] = matriksA[i][j] + matriksB[i][j];
            }
        }

        //Mencetak teks sebagai header output
        System.out.println("Hasil penjumlahan matriks:");
        //Mengambil setiap baris dari matriks hasil.
        for (int[] baris : hasil) {
            //Mengambil setiap elemen dalam baris dan mencetaknya di satu baris yang sama.
            for (int nilai : baris) {
                System.out.print(nilai + " ");
            }
            //Berpindah ke baris baru setelah mencetak satu baris matriks.
            System.out.println();
        }
    }
}
