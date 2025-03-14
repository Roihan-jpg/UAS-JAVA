import java.util.Stack;// Mengimpor kelas Stack dari pustaka java.util

public class StackOperations {// Mendeklarasikan kelas
    public static void main(String[] args) {// Metode utama untuk menjalankan program
        // Membuat objek stack bertipe Integer.
        Stack<Integer> stack = new Stack<>();

        // Menambahkan elemen ke dalam stack
        stack.push(10);// Membuat objek stack bertipe Integer.
        stack.push(20);// Menambahkan 20 ke stack, Stack: 20]
        stack.push(30);// Menambahkan 30 ke stack, Stack: [10, 20, 30]
        System.out.println("Stack setelah push: " + stack);// enampilkan isi stack setelah push

        int poppedElement = stack.pop();// Menghapus 30 dari stack
        System.out.println("Elemen: " + poppedElement);// Menampilkan elemen yang di-pop (30)
        System.out.println("Stack: " + stack);// Menampilkan stack setelah pop [10, 20]

        //  Melihat elemen teratas tanpa menghapusnya
        int topElement = stack.peek();// Mengembalikan elemen teratas (20) tanpa menghapusnya
        System.out.println("Elemen: " + topElement);// Menampilkan elemen teratas (20)

        // Menghapus semua elemen di stack
        stack.clear();//Menghapus semua elemen dari stack
        System.out.println("Elemen: " + stack);// Menampilkan stack kosong []
    }
}
