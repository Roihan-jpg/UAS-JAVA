# Binary Search Rekursif - Penjelasan Detail

## Kode Program

```java
public class BinarySearchRecursive {
    // Metode binary search rekursif
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        // Kasus dasar: elemen tidak ditemukan
        if (low > high) {
            return -1;
        }

        // Cari indeks tengah
        int mid = low + (high - low) / 2;

        // Jika elemen tengah adalah target
        if (arr[mid] == target) {
            return mid;
        }

        // Jika target lebih kecil, cari di setengah kiri
        if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1);
        }

        // Jika target lebih besar, cari di setengah kanan
        return binarySearchRecursive(arr, target, mid + 1, high);
    }

    // Metode wrapper untuk memanggil metode rekursif
    public static int binarySearch(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        int target = 23;

        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Elemen " + target + " tidak ditemukan dalam array");
        } else {
            System.out.println("Elemen " + target + " ditemukan pada indeks " + result);
        }
    }
}
```

## Penjelasan Langkah per Langkah

### 1. Deklarasi Method Rekursif
```java
public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
```
- **Parameter 1**: `arr` - array yang akan dicari
- **Parameter 2**: `target` - nilai yang dicari
- **Parameter 3**: `low` - batas kiri area pencarian
- **Parameter 4**: `high` - batas kanan area pencarian
- **Return**: indeks jika ditemukan, -1 jika tidak

### 2. Base Case - Kondisi Berhenti
```java
if (low > high) {
    return -1;
}
```
- **Kondisi**: `low > high` berarti area pencarian sudah habis
- **Arti**: Tidak ada lagi elemen yang bisa diperiksa
- **Aksi**: Return -1 (tidak ditemukan)
- **Penting**: Mencegah infinite recursion

### 3. Menghitung Titik Tengah
```java
int mid = low + (high - low) / 2;
```
- **Formula sama** dengan versi iteratif
- **Tujuan**: Mencari indeks tengah dari area pencarian saat ini
- **Keamanan**: Mencegah integer overflow

### 4. Target Ditemukan
```java
if (arr[mid] == target) {
    return mid;
}
```
- **Kondisi**: Elemen di posisi tengah sama dengan target
- **Aksi**: Return indeks (base case sukses)
- **Rekursi berhenti**: Tidak ada pemanggilan rekursif lagi

### 5. Pencarian di Setengah Kiri
```java
if (arr[mid] > target) {
    return binarySearchRecursive(arr, target, low, mid - 1);
}
```
- **Kondisi**: Elemen tengah > target
- **Logika**: Target berada di sebelah kiri
- **Recursive call**: Panggil dengan `high = mid - 1`
- **Return**: Hasil dari recursive call

### 6. Pencarian di Setengah Kanan
```java
return binarySearchRecursive(arr, target, mid + 1, high);
```
- **Kondisi**: Elemen tengah < target (else case)
- **Logika**: Target berada di sebelah kanan
- **Recursive call**: Panggil dengan `low = mid + 1`
- **Return**: Hasil dari recursive call

### 7. Method Wrapper
```java
public static int binarySearch(int[] arr, int target) {
    return binarySearchRecursive(arr, target, 0, arr.length - 1);
}
```
- **Tujuan**: Menyederhanakan pemanggilan dari luar
- **Parameter**: Hanya perlu array dan target
- **Inisialisasi**: Otomatis set low=0, high=arr.length-1
- **Return**: Hasil dari method rekursif

### 8. Method Main - Testing
```java
public static void main(String[] args) {
    int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
    int target = 23;
    int result = binarySearch(arr, target);
```
- **Data test**: Array terurut dengan 11 elemen
- **Target**: Nilai 23 yang akan dicari
- **Pemanggilan**: Menggunakan wrapper method

### 9. Output Hasil
```java
if (result == -1) {
    System.out.println("Elemen " + target + " tidak ditemukan dalam array");
} else {
    System.out.println("Elemen " + target + " ditemukan pada indeks " + result);
}
```
- **Pengecekan**: Result = -1 berarti tidak ditemukan
- **Output**: Pesan sesuai dengan hasil pencarian

## Perbedaan dengan Versi Iteratif

### Keuntungan Rekursif:
1. **Kode lebih clean** dan mudah dipahami
2. **Struktur mirip** dengan definisi matematis
3. **Lebih intuitif** untuk dipahami secara konseptual

### Kelemahan Rekursif:
1. **Space Complexity O(log n)** karena call stack
2. **Overhead** function call
3. **Risk stack overflow** untuk input sangat besar

## Analisis Kompleksitas

### Time Complexity: O(log n)
- Sama dengan versi iteratif
- Setiap rekursi membagi ruang pencarian setengah

### Space Complexity: O(log n)
- **Berbeda** dengan versi iteratif yang O(1)
- **Call stack** menyimpan log n recursive calls

## Trace Execution untuk target = 23

### Call Stack Visualization:
```
Call 1: binarySearchRecursive(arr, 23, 0, 10)
  mid = 5, arr[5] = 23 ✓
  Return 5

Wrapper: binarySearch(arr, 23)
  Return binarySearchRecursive(arr, 23, 0, 10) = 5
```

**Hasil**: Elemen 23 ditemukan pada indeks 5 (hanya butuh 1 recursive call)

## Kapan Menggunakan Rekursif vs Iteratif?

### Gunakan Rekursif ketika:
- Kode perlu lebih readable
- Tidak ada constraint memory ketat
- Input size tidak terlalu besar

### Gunakan Iteratif ketika:
- Memory efficiency penting
- Performance critical
- Input size sangat besar