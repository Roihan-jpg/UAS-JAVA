Operasi Matriks 1 <PerkalianMatriks.java>


import java.util.Scanner; // Mengimpor library Scanner untuk input dari pengguna

public class PerkalianMatriks { // Deklarasi kelas utama
    public static void main(String[] args) { // Metode utama yang akan dieksekusi pertama kali
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input

        // Meminta pengguna memasukkan ukuran matriks
        System.out.print("Masukkan ukuran matriks (n x n): ");
        int n = scanner.nextInt(); // Membaca ukuran matriks dari input pengguna

        // Deklarasi array dua dimensi untuk menyimpan elemen matriks A dan B
        int[][] A = new int[n][n]; // Matriks pertama
        int[][] B = new int[n][n]; // Matriks kedua
        int[][] hasil = new int[n][n]; // Matriks hasil perkalian A x B

        // Memasukkan elemen-elemen ke dalam matriks A
        System.out.println("Masukkan elemen matriks A:");
        for (int i = 0; i < n; i++) { // Loop baris
            for (int j = 0; j < n; j++) { // Loop kolom
                A[i][j] = scanner.nextInt(); // Membaca elemen matriks A dari input
            }
        }

        // Memasukkan elemen-elemen ke dalam matriks B
        System.out.println("Masukkan elemen matriks B:");
        for (int i = 0; i < n; i++) { // Loop baris
            for (int j = 0; j < n; j++) { // Loop kolom
                B[i][j] = scanner.nextInt(); // Membaca elemen matriks B dari input
            }
        }

        // Melakukan perkalian matriks A x B
        for (int i = 0; i < n; i++) { // Loop untuk baris hasil perkalian
            for (int j = 0; j < n; j++) { // Loop untuk kolom hasil perkalian
                hasil[i][j] = 0; // Inisialisasi elemen hasil perkalian menjadi 0
                for (int k = 0; k < n; k++) { // Loop untuk operasi perkalian
                    hasil[i][j] += A[i][k] * B[k][j]; // Mengalikan elemen A dan B sesuai aturan matriks
                }
            }
        }

        // Menampilkan hasil perkalian matriks
        System.out.println("Hasil Perkalian Matriks:");
        for (int i = 0; i < n; i++) { // Loop untuk baris matriks hasil
            for (int j = 0; j < n; j++) { // Loop untuk kolom matriks hasil
                System.out.print(hasil[i][j] + "\t"); // Menampilkan elemen hasil dengan tab untuk pemisah
            }
            System.out.println(); // Pindah ke baris baru setelah satu baris selesai ditampilkan
        }

        scanner.close(); // Menutup Scanner untuk menghindari kebocoran memori
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------
Operasi Matriks 2 <TransposeMatriks.java>


import java.util.Scanner; // Mengimpor library Scanner untuk input dari pengguna

public class TransposeMatriks { // Mendeklarasikan kelas utama TransposeMatriks
    public static void main(String[] args) { // Metode utama yang akan dieksekusi pertama kali
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input pengguna

        // Meminta pengguna memasukkan ukuran matriks
        System.out.print("Masukkan jumlah baris matriks: ");
        int baris = scanner.nextInt(); // Membaca jumlah baris dari input pengguna
        System.out.print("Masukkan jumlah kolom matriks: ");
        int kolom = scanner.nextInt(); // Membaca jumlah kolom dari input pengguna

        // Deklarasi array dua dimensi untuk menyimpan elemen matriks
        int[][] matriks = new int[baris][kolom]; // Matriks asli berukuran (baris x kolom)
        int[][] transpose = new int[kolom][baris]; // Matriks transpose berukuran (kolom x baris)

        // Memasukkan elemen-elemen ke dalam matriks
        System.out.println("Masukkan elemen matriks:");
        for (int i = 0; i < baris; i++) { // Loop pertama untuk mengakses setiap baris matriks
            for (int j = 0; j < kolom; j++) { // Loop kedua untuk mengakses setiap kolom matriks
                matriks[i][j] = scanner.nextInt(); // Membaca elemen matriks dari input pengguna
            }
        }

        // Menampilkan matriks sebelum ditranspose
        System.out.println("Matriks sebelum transpose:");
        for (int i = 0; i < baris; i++) { // Loop pertama untuk menampilkan setiap baris matriks
            for (int j = 0; j < kolom; j++) { // Loop kedua untuk menampilkan setiap kolom matriks
                System.out.print(matriks[i][j] + "\t"); // Menampilkan elemen matriks dengan tab sebagai pemisah
            }
            System.out.println(); // Pindah ke baris baru setelah satu baris ditampilkan
        }

        // Melakukan operasi transpose (baris menjadi kolom, kolom menjadi baris)
        for (int i = 0; i < baris; i++) { // Loop pertama untuk mengakses setiap baris matriks asli
            for (int j = 0; j < kolom; j++) { // Loop kedua untuk mengakses setiap kolom matriks asli
                transpose[j][i] = matriks[i][j]; // Menukar elemen dari baris ke kolom
            }
        }

        // Menampilkan hasil matriks setelah ditranspose
        System.out.println("Matriks setelah transpose:");
        for (int i = 0; i < kolom; i++) { // Loop pertama untuk menampilkan setiap baris matriks transpose
            for (int j = 0; j < baris; j++) { // Loop kedua untuk menampilkan setiap kolom matriks transpose
                System.out.print(transpose[i][j] + "\t"); // Menampilkan elemen matriks dengan tab sebagai pemisah
            }
            System.out.println(); // Pindah ke baris baru setelah satu baris ditampilkan
        }

        scanner.close(); // Menutup Scanner untuk menghindari kebocoran memori
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------
Operasi Matriks 3 <DiagonalMatriks.java>


import java.util.Scanner; // Mengimpor library Scanner untuk input dari pengguna

public class DiagonalMatriks { // Mendeklarasikan kelas utama DiagonalMatriks
    public static void main(String[] args) { // Metode utama yang dieksekusi pertama kali
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari pengguna

        // Meminta pengguna memasukkan ukuran matriks persegi
        System.out.print("Masukkan ukuran matriks persegi (n x n): ");
        int n = scanner.nextInt(); // Membaca ukuran matriks (n x n) dari input pengguna

        // Deklarasi array dua dimensi untuk menyimpan elemen matriks
        int[][] matriks = new int[n][n]; // Membuat matriks persegi dengan ukuran (n x n)

        // Memasukkan elemen-elemen ke dalam matriks
        System.out.println("Masukkan elemen matriks:");
        for (int i = 0; i < n; i++) { // Loop pertama untuk mengakses setiap baris matriks
            for (int j = 0; j < n; j++) { // Loop kedua untuk mengakses setiap kolom matriks
                matriks[i][j] = scanner.nextInt(); // Membaca elemen matriks dari input pengguna
            }
        }

        // Menampilkan matriks yang telah dimasukkan
        System.out.println("Matriks yang dimasukkan:");
        for (int i = 0; i < n; i++) { // Loop pertama untuk menampilkan setiap baris matriks
            for (int j = 0; j < n; j++) { // Loop kedua untuk menampilkan setiap kolom matriks
                System.out.print(matriks[i][j] + "\t"); // Menampilkan elemen matriks dengan tab sebagai pemisah
            }
            System.out.println(); // Pindah ke baris baru setelah satu baris ditampilkan
        }

        // Menentukan elemen diagonal utama dan diagonal samping
        System.out.println("Elemen diagonal utama:");
        for (int i = 0; i < n; i++) { // Loop untuk mengakses diagonal utama
            System.out.print(matriks[i][i] + " "); // Elemen diagonal utama terdapat pada indeks [i][i]
        }
        System.out.println(); // Pindah ke baris baru

        System.out.println("Elemen diagonal samping:");
        for (int i = 0; i < n; i++) { // Loop untuk mengakses diagonal samping
            System.out.print(matriks[i][n - 1 - i] + " "); // Elemen diagonal samping terdapat pada indeks [i][n-1-i]
        }
        System.out.println(); // Pindah ke baris baru

        scanner.close(); // Menutup Scanner untuk menghindari kebocoran memori
    }
}
