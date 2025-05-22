# Binary Search Iteratif - Penjelasan Detail

## Kode Program

```java
public class binarySearch {
    // Metode binary search iteratif
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Cari indeks tengah
            int mid = low + (high - low) / 2;

            // Jika elemen tengah adalah target
            if (arr[mid] == target) {
                return mid;
            }

            // Jika target lebih kecil, abaikan setengah kanan
            if (arr[mid] > target) {
                high = mid - 1;
            }
            // Jika target lebih besar, abaikan setengah kiri
            else {
                low = mid + 1;
            }
        }

        // Jika target tidak ditemukan
        return -1;
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

### 1. Deklarasi Class dan Method
```java
public class binarySearch {
    public static int binarySearch(int[] arr, int target) {
```
- **Baris 1**: Mendeklarasikan class public bernama `binarySearch`
- **Baris 2**: Mendeklarasikan method static yang menerima array integer dan nilai target yang dicari
- **Return type**: `int` - mengembalikan indeks jika ditemukan, atau -1 jika tidak ditemukan

### 2. Inisialisasi Pointer
```java
int low = 0;
int high = arr.length - 1;
```
- **Baris 1**: `low` = pointer kiri, dimulai dari indeks 0 (elemen pertama)
- **Baris 2**: `high` = pointer kanan, dimulai dari indeks terakhir array (arr.length - 1)
- **Tujuan**: Menentukan batas area pencarian dalam array

### 3. Loop Pencarian Utama
```java
while (low <= high) {
```
- **Kondisi**: Loop berlanjut selama `low <= high`
- **Arti**: Masih ada elemen yang belum diperiksa
- **Berhenti**: Ketika `low > high`, artinya area pencarian sudah habis

### 4. Mencari Titik Tengah
```java
int mid = low + (high - low) / 2;
```
- **Formula**: `mid = low + (high - low) / 2`
- **Alasan**: Mencegah integer overflow dibanding `(low + high) / 2`
- **Hasil**: Indeks tengah dari area pencarian saat ini

### 5. Pengecekan Target Ditemukan
```java
if (arr[mid] == target) {
    return mid;
}
```
- **Kondisi**: Jika elemen di posisi tengah sama dengan target
- **Aksi**: Langsung return indeks `mid` (pencarian selesai)
- **Kompleksitas**: Best case O(1) jika target di tengah

### 6. Pengecekan Target Lebih Kecil
```java
if (arr[mid] > target) {
    high = mid - 1;
}
```
- **Kondisi**: Jika elemen tengah lebih besar dari target
- **Logika**: Target pasti berada di setengah kiri (karena array terurut)
- **Aksi**: Pindahkan `high` ke `mid - 1` (abaikan setengah kanan)

### 7. Pengecekan Target Lebih Besar
```java
else {
    low = mid + 1;
}
```
- **Kondisi**: Jika elemen tengah lebih kecil dari target
- **Logika**: Target pasti berada di setengah kanan (karena array terurut)
- **Aksi**: Pindahkan `low` ke `mid + 1` (abaikan setengah kiri)

### 8. Return Tidak Ditemukan
```java
return -1;
```
- **Kondisi**: Ketika loop berakhir tanpa menemukan target
- **Arti**: Target tidak ada dalam array
- **Konvensi**: Return -1 sebagai indikator "tidak ditemukan"

### 9. Method Main - Testing
```java
public static void main(String[] args) {
    int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
    int target = 23;
    int result = binarySearch(arr, target);
```
- **Baris 1**: Method main untuk testing
- **Baris 2**: Array terurut ascending sebagai data test
- **Baris 3**: Target yang dicari (nilai 23)
- **Baris 4**: Memanggil method binarySearch dan menyimpan hasilnya

### 10. Output Hasil
```java
if (result == -1) {
    System.out.println("Elemen " + target + " tidak ditemukan dalam array");
} else {
    System.out.println("Elemen " + target + " ditemukan pada indeks " + result);
}
```
- **Kondisi 1**: Jika result = -1, tampilkan pesan "tidak ditemukan"
- **Kondisi 2**: Jika result ≠ -1, tampilkan pesan "ditemukan" beserta indeksnya

## Analisis Kompleksitas

### Time Complexity: O(log n)
- Setiap iterasi membagi ruang pencarian menjadi setengah
- Maksimal log₂(n) iterasi diperlukan

### Space Complexity: O(1)
- Hanya menggunakan variabel tambahan: low, high, mid
- Tidak ada recursive call atau struktur data tambahan

## Trace Execution untuk target = 23

| Iterasi | low | high | mid | arr[mid] | Aksi |
|---------|-----|------|-----|----------|------|
| 1 | 0 | 10 | 5 | 23 | Found! Return 5 |

**Hasil**: Elemen 23 ditemukan pada indeks 5