import java.util.Scanner;

public class TransposeMatriks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input ukuran matriks
        System.out.print("Masukkan jumlah baris: ");
        int baris = scanner.nextInt();
        System.out.print("Masukkan jumlah kolom: ");
        int kolom = scanner.nextInt();

        int[][] matriks = new int[baris][kolom];
        int[][] hasil = new int[kolom][baris];

        // Input elemen matriks
        System.out.println("Masukkan elemen matriks:");
        isiMatriks(scanner, matriks);

        // Proses transpose
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil[j][i] = matriks[i][j];
            }
        }

        // Menampilkan hasil transpose
        System.out.println("Hasil Transpose Matriks:");
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
