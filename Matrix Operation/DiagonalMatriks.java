import java.util.Scanner;

public class DiagonalMatriks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input ukuran matriks
        System.out.print("Masukkan ukuran matriks persegi (n x n): ");
        int n = scanner.nextInt();

        int[][] matriks = new int[n][n];

        // Input elemen matriks
        System.out.println("Masukkan elemen matriks:");
        isiMatriks(scanner, matriks);

        // Menampilkan diagonal utama
        System.out.println("Diagonal Utama:");
        tampilkanDiagonalUtama(matriks);

        // Menampilkan diagonal samping
        System.out.println("Diagonal Samping:");
        tampilkanDiagonalSamping(matriks);

        scanner.close();
    }

    public static void isiMatriks(Scanner scanner, int[][] matriks) {
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                matriks[i][j] = scanner.nextInt();
            }
        }
    }

    public static void tampilkanDiagonalUtama(int[][] matriks) {
        for (int i = 0; i < matriks.length; i++) {
            System.out.print(matriks[i][i] + " ");
        }
        System.out.println();
    }

    public static void tampilkanDiagonalSamping(int[][] matriks) {
        int ukuran = matriks.length;
        for (int i = 0; i < ukuran; i++) {
            System.out.print(matriks[i][ukuran - 1 - i] + " ");
        }
        System.out.println();
    }
}
