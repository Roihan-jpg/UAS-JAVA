public class upperBound {
    public static int upperBound(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int result = -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            result = mid;
            low = mid + 1; // Lanjutkan pencarian di setengah kanan
        } else if (arr[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return result;
}

}

Konsep Upper Bound
Upper Bound = Posisi terakhir (paling kanan) dari elemen yang dicari dalam array yang memiliki duplikat.
Perbedaan Key dengan Lower Bound:
Target Ditemukan
javaif (arr[mid] == target) {
    result = mid;
    low = mid + 1; // Lanjutkan pencarian di setengah kanan
}

result = mid: Simpan posisi sebagai kandidat upper bound
low = mid + 1: Lanjutkan pencarian ke kanan untuk mencari posisi yang lebih akhir

Contoh Trace Execution
Data: arr = [1, 2, 4, 4, 4, 4, 5, 7], target = 4
Lower Bound Trace:
Iterasilowhighmidarr[mid]Aksiresult10734Found! result=3, high=2320212arr[mid]<target, low=2332224Found! result=2, high=12421--low>high, stop2
Hasil Lower Bound: Index 2 (posisi pertama dari angka 4)
Upper Bound Trace:
Iterasilowhighmidarr[mid]Aksiresult10734Found! result=3, low=4324754Found! result=5, low=6536765arr[mid]>target, high=55465--low>high, stop5
Hasil Upper Bound: Index 5 (posisi terakhir dari angka 4)