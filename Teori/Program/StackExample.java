// Mengimpor kelas Stack dari pustaka java.util agar dapat menggunakan struktur data Stack.
import java.util.Stack;
// Mendeklarasikan kelas StackExample.
public class StackExample {
    // Metode utama (main) sebagai titik awal eksekusi program.
    public static void main(String[] args) {
        // Membuat objek stack bertipe Stack<Integer> yang menyimpan elemen Integer.
        Stack<Integer> stack = new Stack<>();
            // Menambahkan (push) angka 10 ke dalam stack.
            stack.push(10);
            // Menambahkan (push) angka 20 ke dalam stack
            stack.push(20);
            // Menambahkan (push) angka 30 ke dalam stack
            stack.push(30);
            // pop() mengambil dan menghapus elemen teratas (30) dari stack
            System.out.println(stack.pop());
            // peek() hanya melihat elemen teratas (20) tanpa menghapusnya.
            System.out.println(stack.peek());
    }
}