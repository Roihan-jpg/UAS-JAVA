import java.util.Scanner;

public class PerkalianMatriks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input ukuran matriks
        System.out.print("Masukkan ukuran matriks (n x n): ");
        int n = scanner.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] hasil = new int[n][n];

        // Input Matriks A
        System.out.println("Masukkan elemen matriks A:");
        isiMatriks(scanner, A);

        // Input Matriks B
        System.out.println("Masukkan elemen matriks B:");
        isiMatriks(scanner, B);

        // Perkalian Matriks
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    hasil[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Tampilkan hasil perkalian
        System.out.println("Hasil Perkalian Matriks:");
        tampilkanMatriks(hasil);
        
        scanner.close();
    }

    public static void isiMatriks(Scanner scanner, int[][] matriks) {
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                matriks[i][j] = scanner.nextInt();
            }
        }
    }

    public static void tampilkanMatriks(int[][] matriks) {
        for (int[] baris : matriks) {
            for (int elemen : baris) {
                System.out.print(elemen + "\t");
            }
            System.out.println();
        }
    }
}
