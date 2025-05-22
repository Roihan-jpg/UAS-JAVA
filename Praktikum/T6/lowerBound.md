Lower Bound Implementation
javapublic class lowerBound {
    public static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // Lanjut pencarian ke kiri
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5, 7};
        int index = lowerBound(arr, 4);
        System.out.println("Indeks lower bound: " + index);
    }
}

Penjelasan Lower Bound
Konsep Lower Bound
Lower Bound = Posisi pertama (paling kiri) dari elemen yang dicari dalam array yang memiliki duplikat.
Langkah per Langkah Lower Bound:
1. Inisialisasi
javaint low = 0;
int high = arr.length - 1;
int result = -1;

low: Pointer kiri array
high: Pointer kanan array
result: Menyimpan indeks lower bound (-1 jika tidak ditemukan)

2. Loop Pencarian
javawhile (low <= high) {
    int mid = low + (high - low) / 2;

Kondisi: Loop berlanjut selama area pencarian masih valid
mid: Titik tengah dari area pencarian saat ini

3. Target Ditemukan
javaif (arr[mid] == target) {
    result = mid;
    high = mid - 1; // Lanjut pencarian ke kiri
}

Kondisi: Elemen tengah sama dengan target
Key difference: Tidak langsung return!
result = mid: Simpan posisi sebagai kandidat lower bound
high = mid - 1: Lanjutkan pencarian ke kiri untuk mencari posisi yang lebih awal

4. Target Lebih Kecil dari Mid
javaelse if (arr[mid] > target) {
    high = mid - 1;
}

Kondisi: Elemen tengah > target
Aksi: Cari di setengah kiri (sama dengan binary search biasa)

5. Target Lebih Besar dari Mid
javaelse {
    low = mid + 1;
}

Kondisi: Elemen tengah < target
Aksi: Cari di setengah kanan (sama dengan binary search biasa)