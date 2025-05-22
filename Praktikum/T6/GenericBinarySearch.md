# Generic Binary Search - Penjelasan Detail

## Kode Program

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Interface untuk mendefinisikan perilaku pencarian
interface Searchable<T> {
    int compare(T value);
}

public class GenericBinarySearch {

    // Metode binary search generik
    public static <T> int binarySearch(T[] array, Searchable<T> searchable) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int comparison = searchable.compare(array[mid]);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEM PENCARIAN DATASET ===");
        System.out.println("Pilih jenis data yang ingin dicari:");
        System.out.println("1. Integer");
        System.out.println("2. Double");
        System.out.println("3. String");
        System.out.print("Pilihan Anda (1-3): ");

        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        switch (pilihan) {
            case 1:
                // Pencarian nilai Integer
                Integer[] dataInteger = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

                System.out.println("\nData Integer: " + Arrays.toString(dataInteger));
                System.out.print("Masukkan nilai integer yang dicari: ");
                int targetInt = scanner.nextInt();

                int indexInt = binarySearch(dataInteger, new Searchable<Integer>() {
                    @Override
                    public int compare(Integer value) {
                        return targetInt - value; // Negatif jika target < value, 0 jika sama, positif jika target > value
                    }
                });

                if (indexInt != -1) {
                    System.out.println("Nilai " + targetInt + " ditemukan pada indeks " + indexInt);
                } else {
                    System.out.println("Nilai " + targetInt + " tidak ditemukan dalam dataset");
                }
                break;

            case 2:
                // Pencarian nilai Double
                Double[] dataDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};

                System.out.println("\nData Double: " + Arrays.toString(dataDouble));
                System.out.print("Masukkan nilai double yang dicari: ");
                double targetDouble = scanner.nextDouble();

                int indexDouble = binarySearch(dataDouble, new Searchable<Double>() {
                    @Override
                    public int compare(Double value) {
                        return Double.compare(targetDouble, value);
                    }
                });

                if (indexDouble != -1) {
                    System.out.println("Nilai " + targetDouble + " ditemukan pada indeks " + indexDouble);
                } else {
                    System.out.println("Nilai " + targetDouble + " tidak ditemukan dalam dataset");
                }
                break;

            case 3:
                // Pencarian nilai String
                String[] dataString = {"alpha", "beta", "delta", "gamma", "omega", "sigma", "theta", "zeta"};
                Arrays.sort(dataString); // Pastikan array terurut

                System.out.println("\nData String: " + Arrays.toString(dataString));
                System.out.print("Masukkan string yang dicari: ");
                String targetString = scanner.nextLine();

                int indexString = binarySearch(dataString, new Searchable<String>() {
                    @Override
                    public int compare(String value) {
                        return targetString.compareTo(value);
                    }
                });

                if (indexString != -1) {
                    System.out.println("String \"" + targetString + "\" ditemukan pada indeks " + indexString);
                } else {
                    System.out.println("String \"" + targetString + "\" tidak ditemukan dalam dataset");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid!");
        }

        scanner.close();
    }
}
```

## Penjelasan Langkah per Langkah

### 1. Import Dependencies
```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
```
- **Arrays**: Untuk method `toString()` dan `sort()`
- **Comparator**: Interface untuk comparison (tidak digunakan langsung)
- **Scanner**: Untuk input dari user

### 2. Interface Searchable
```java
interface Searchable<T> {
    int compare(T value);
}
```
- **Generic Interface**: `<T>` berarti bisa untuk tipe data apapun
- **Method compare**: Mengembalikan int hasil perbandingan
- **Return values**:
  - **Negatif**: target < value
  - **0**: target == value  
  - **Positif**: target > value

### 3. Generic Binary Search Method
```java
public static <T> int binarySearch(T[] array, Searchable<T> searchable) {
```
- **Generic Method**: `<T>` berarti method bisa handle tipe apapun
- **Parameter 1**: `T[] array` - array generic
- **Parameter 2**: `Searchable<T> searchable` - object untuk comparison
- **Fleksibilitas**: Bisa digunakan untuk Integer, String, Double, dll

### 4. Inisialisasi Pointer
```java
int low = 0;
int high = array.length - 1;
```
- **Same logic** dengan binary search biasa
- **low**: Pointer kiri (awal array)
- **high**: Pointer kanan (akhir array)

### 5. Main Loop
```java
while (low <= high) {
    int mid = low + (high - low) / 2;
    int comparison = searchable.compare(array[mid]);
```
- **Loop condition**: Sama dengan binary search standar
- **mid calculation**: Mencari titik tengah
- **comparison**: Memanggil method compare dari interface

### 6. Decision Making
```java
if (comparison == 0) {
    return mid;
} else if (comparison < 0) {
    high = mid - 1;
} else {
    low = mid + 1;
}
```
- **comparison == 0**: Target found, return index
- **comparison < 0**: Target lebih kecil, cari di kiri
- **comparison > 0**: Target lebih besar, cari di kanan

### 7. Menu System
```java
System.out.println("=== SISTEM PENCARIAN DATASET ===");
System.out.println("Pilih jenis data yang ingin dicari:");
System.out.println("1. Integer");
System.out.println("2. Double");
System.out.println("3. String");
```
- **User Interface**: Menu pilihan tipe data
- **Interactive**: User bisa memilih tipe yang ingin dicari

### 8. Case 1: Integer Search
```java
case 1:
    Integer[] dataInteger = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    
    int indexInt = binarySearch(dataInteger, new Searchable<Integer>() {
        @Override
        public int compare(Integer value) {
            return targetInt - value;
        }
    });
```
- **Data**: Array Integer yang sudah terurut
- **Anonymous Class**: Implementasi Searchable secara inline
- **Compare Logic**: `targetInt - value` untuk perbandingan integer

### 9. Case 2: Double Search
```java
case 2:
    Double[] dataDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};
    
    int indexDouble = binarySearch(dataDouble, new Searchable<Double>() {
        @Override
        public int compare(Double value) {
            return Double.compare(targetDouble, value);
        }
    });
```
- **Data**: Array Double yang sudah terurut
- **Compare Logic**: `Double.compare()` untuk menghindari floating point issues
- **Presisi**: Lebih aman dibanding operator `-` untuk double

### 10. Case 3: String Search
```java
case 3:
    String[] dataString = {"alpha", "beta", "delta", "gamma", "omega", "sigma", "theta", "zeta"};
    Arrays.sort(dataString); // Pastikan array terurut
    
    int indexString = binarySearch(dataString, new Searchable<String>() {
        @Override
        public int compare(String value) {
            return targetString.compareTo(value);
        }
    });
```
- **Data**: Array String (belum terurut)
- **Arrays.sort()**: Mengurutkan array terlebih dahulu
- **Compare Logic**: `compareTo()` untuk lexicographic comparison

## Keunggulan Generic Approach

### 1. **Type Safety**
- Compile-time checking untuk tipe data
- Menghindari ClassCastException

### 2. **Reusability**
- Satu method untuk semua tipe data
- Tidak perlu duplicate code

### 3. **Flexibility**
- Bisa handle custom objects
- User-defined comparison logic

### 4. **Maintainability**
- Perubahan logic hanya di satu tempat
- Konsisten across different types

## Analisis Kompleksitas

### Time Complexity: O(log n)
- Sama dengan binary search biasa
- Generic tidak menambah time complexity

### Space Complexity: O(1)
- Tidak ada extra space untuk algorithm
- Anonymous class creation: O(1)

## Contoh Execution Flow

### Input: Pilihan 1, Target = 50

1. **User memilih** tipe Integer (pilihan 1)
2. **System menampilkan** data: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
3. **User input** target: 50
4. **Create anonymous class** dengan logic `targetInt - value`
5. **Binary search execution**:
   - mid = 4, arr[4] = 50
   - comparison = 50 - 50 = 0
   - Return index 4
6. **Output**: "Nilai 50 ditemukan pada indeks 4"

## Aplikasi dalam Real World

### Use Cases:
1. **Database indexing** dengan custom comparators
2. **Multi-field sorting** dan searching  
3. **Custom object comparison** (Person by age, Product by price)
4. **Different data types** dalam satu aplikasi