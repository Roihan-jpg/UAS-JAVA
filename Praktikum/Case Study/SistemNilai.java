public class SistemNilai {
    public static void main(String[] args) {
        // Data siswa
        String[] namaSiswa = {"Ani", "Budi", "Cici", "Dodi", "Edi"};
        int[][] nilai = {
            {80, 85, 90}, // Nilai Ani
            {75, 70, 85}, // Nilai Budi
            {85, 80, 88}, // Nilai Cici
            {90, 85, 95}, // Nilai Dodi
            {70, 75, 80}  // Nilai Edi
        };
        String[] mapel = {"Matematika", "Bahasa Inggris", "IPA"};

        System.out.println("Rata-rata nilai per siswa:");
        for (int i = 0; i < nilai.length; i++) {
            double total = 0;
            for (int n : nilai[i]) {
                total += n;
            }
            double rataSiswa = total / nilai[i].length;
            System.out.printf("%s: %.2f\\n", namaSiswa[i], rataSiswa);
        }

        System.out.println("\\nRata-rata nilai per mata pelajaran:");
        for (int j = 0; j < nilai[0].length; j++) {
            double total = 0;
            for (int i = 0; i < nilai.length; i++) {
                total += nilai[i][j];
            }
            double rataMapel = total / nilai.length;
            System.out.printf("%s: %.2f\\n", mapel[j], rataMapel);
        }
    }
}
