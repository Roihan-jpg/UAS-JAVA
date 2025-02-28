public class StatistikArray {
    public static void main(String[] args) {
        int[] nilai = {75, 80, 65, 90, 85, 70, 95, 88};

        int tertinggi = nilai[0];
        int terendah = nilai[0];
        int total = nilai[0];

        for (int i = 1; i < nilai.length; i++) {
            if (nilai[i] > tertinggi) tertinggi = nilai[i];
            if (nilai[i] < terendah) terendah = nilai[i];
            total += nilai[i];
        }

        double rataRata = (double) total / nilai.length;

        System.out.println("Nilai tertinggi: " + tertinggi);
        System.out.println("Nilai terendah: " + terendah);
        System.out.println("Rata-rata: " + rataRata);
    }
}