# Nearest Element Search - Penjelasan Detail

## Kode Program

```java
public class nearestElement {
    public static int nearestElement(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        // Kasus khusus
        if (target <= arr[0]) {
            return 0;
        }
        if (target >= arr[high]) {
            return high;
        }

        // Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Setelah binary search berakhir, low > high
        // Bandingkan arr[high] dan arr[low] untuk melihat mana yang lebih dekat
        if (Math.abs(arr[high] - target) <= Math.abs(arr[low] - target)) {
            return high;
        } else {
            return low;
        }
    }
}
```

## Penjelasan Langkah per Langkah

### 1. Method Signature
```java
public static int nearestElement(int[] arr, int target) {
```
- **Purpose**: Mencari elemen yang **paling dekat** dengan target
- **Return**: Index dari elemen terdekat (bukan nilai target exact)
- **Assumption**: Array sudah terurut ascending

### 2. Inisialisasi Pointers
```java
int low = 0;
int high = arr.length - 1;
```
- **low**: Pointer kiri (start of array)
- **high**: Pointer kanan (end of array)
- **Standard**: Sama dengan binary search biasa

### 3. Edge Case - Target Terlalu Kecil
```java
if (target <= arr[0]) {
    return 0;
}
```
- **Kondisi**: Target lebih kecil atau sama dengan elemen pertama
- **Logic**: Elemen pertama pasti yang terdekat
- **Contoh**: arr=[10,20,30], target=5 → return 0 (elemen 10)

### 4. Edge Case - Target Terlalu Besar
```java
if (target >= arr[high]) {
    return high;
}
```
- **Kondisi**: Target lebih besar atau sama dengan elemen terakhir
- **Logic**: Elemen terakhir pasti yang terdekat
- **Contoh**: arr=[10,20,30], target=35 → return 2 (elemen 30)

### 5. Standard Binary Search
```java
while (low <= high) {
    int mid = low + (high - low) / 2;

    if (arr[mid] == target) {
        return mid;
    }

    if (arr[mid] > target) {
        high = mid - 1;
    } else {
        low = mid + 1;
    }
}
```
- **Exact match**: Jika ditemukan exact, langsung return
- **Standard logic**: Sama dengan binary search biasa
- **Tujuan**: Mempersempit area pencarian

### 6. Post-Search Analysis - Key Innovation
```java
// Setelah binary search berakhir, low > high
// Bandingkan arr[high] dan arr[low] untuk melihat mana yang lebih dekat
if (Math.abs(arr[high] - target) <= Math.abs(arr[low] - target)) {
    return high;
} else {
    return low;
}
```

#### Mengapa low > high setelah loop?
- **Loop berakhir** ketika `low > high`
- **Position**: `high` dan `low` adalah dua elemen terdekat dengan target
- **high**: Elemen terbesar yang **< target**
- **low**: Elemen terkecil yang **> target**

#### Distance Comparison:
- **Math.abs(arr[high] - target)**: Jarak antara elemen kiri dengan target
- **Math.abs(arr[low] - target)**: Jarak antara elemen kanan dengan target
- **Pilih yang jaraknya lebih kecil**

#### Tie Breaking:
- **Condition `<=`**: Jika jarak sama, pilih elemen yang **lebih kecil** (index `high`)

## Contoh Trace Execution

### Data: arr = [10, 20, 30, 40, 50], target = 35

| Step | low | high | mid | arr[mid] | Aksi |
|------|-----|------|-----|----------|------|
| Init | 0 | 4 | - | - | Check edge cases |
| Edge | - | - | - | - | 35 not <= 10, not >= 50 |
| 1 | 0 | 4 | 2 | 30 | 30 < 35, low = 3 |
| 2 | 3 | 4 | 3 | 40 | 40 > 35, high = 2 |
| 3 | 3 | 2 | - | - | low > high, exit loop |

#### Post-Search State:
- **low = 3** → arr[3] = 40
- **high = 2** → arr[2] = 30

#### Distance Calculation:
- **Distance to arr[high]**: |30 - 35| = 5
- **Distance to arr[low]**: |40 - 35| = 5
- **Result**: Equal distance, choose `high` → return 2

### Visualization:
```
Array: [10, 20, 30, 40, 50]
Index:  0   1   2   3   4
             ↑       ↑
           high    low
            30      40
             ←  35  →
        Distance: 5   5
```

## Contoh Lain

### Target = 33
- **high = 2** (arr[2] = 30), distance = |30-33| = 3
- **low = 3** (arr[3] = 40), distance = |40-33| = 7
- **Result**: return 2 (index dari 30)

### Target = 37
- **high = 2** (arr[2] = 30), distance = |30-37| = 7
- **low = 3** (arr[3] = 40), distance = |40-37| = 3
- **Result**: return 3 (index dari 40)

## Kompleksitas

### Time Complexity: O(log n)
- **Binary search**: O(log n)
- **Post-processing**: O(1)
- **Total**: O(log n)

### Space Complexity: O(1)
- Hanya menggunakan variabel tambahan konstan

## Aplikasi dalam Real World

### 1. **Temperature Sensor Calibration**
```java
// Mencari setting terdekat untuk target temperature
int[] availableSettings = {15, 18, 21, 24, 27, 30};
int targetTemp = 23;
int nearestSetting = nearestElement(availableSettings, targetTemp);
```

### 2. **Price Matching**
```java
// Mencari produk dengan harga terdekat
int[] productPrices = {100, 150, 200, 300, 500};
int budget = 180;
int closestPrice = nearestElement(productPrices, budget);
```

### 3. **Time Scheduling**
```java
// Mencari slot waktu terdekat
int[] availableSlots = {900, 1000, 1100, 1300, 1400}; // dalam format HHMM
int preferredTime = 1130;
int nearestSlot = nearestElement(availableSlots, preferredTime);
```

### 4. **Data Analysis - Quantization**
```java
// Mapping continuous values ke discrete levels
double[] quantizationLevels = {0.0, 0.25, 0.5, 0.75, 1.0};
double inputValue = 0.63;
int nearestLevel = nearestElement(quantizationLevels, inputValue);
```

## Variasi dan Optimizations

### 1. **Return Value Instead of Index**
```java
public static int nearestValue(int[] arr, int target) {
    int index = nearestElement(arr, target);
    return arr[index];
}
```

### 2. **Handle Multiple Nearest Elements**
```java
public static List<Integer> getAllNearest(int[] arr, int target) {
    int nearestIndex = nearestElement(arr, target);
    int nearestDistance = Math.abs(arr[nearestIndex] - target);
    
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
        if (Math.abs(arr[i] - target) == nearestDistance) {
            result.add(i);
        }
    }
    return result;
}
```

### 3. **Generic Version**
```java
public static <T extends Comparable<T>> int nearestElement(T[] arr, T target) {
    // Implementation using Comparable interface
}
```

## Tips dan Best Practices

### 1. **Input Validation**
```java
if (arr == null || arr.length == 0) {
    throw new IllegalArgumentException("Array cannot be null or empty");
}
```

### 2. **Handle Single Element**
```java
if (arr.length == 1) {
    return 0;
}
```

### 3. **Tie-Breaking Strategy**
- **Current**: Prefer smaller element (lower index)
- **Alternative**: Prefer larger element, prefer middle, random choice

### 4. **Floating Point Considerations**
```java
// For double arrays, consider epsilon for equality
private static final double EPSILON = 1e-9;
if (Math.abs(arr[mid] - target) < EPSILON) {
    return mid;
}
```