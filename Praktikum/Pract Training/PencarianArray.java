public class PencarianArray {
    public static void main(String[] args) {
        int[] nilai = {75, 80, 65, 90, 85, 70, 95, 88};
        int cari = 90;
        boolean ketemu = false;
        int indeks = -1;

        for (int i = 0; i < nilai.length; i++) {
            if (nilai[i] == cari) {
                ketemu = true;
                indeks = i;
                break;
            }
        }

        if (ketemu) {
            System.out.println("Nilai " + cari + " ditemukan pada indeks " + indeks);
        } else {
            System.out.println("Nilai " + cari + " tidak ditemukan");
        }
    }
}