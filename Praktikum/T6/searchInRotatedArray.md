# Search in Rotated Array - Penjelasan Detail

## Kode Program

```java
public class searchInRotatedArray {
    public static int searchInRotatedArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Periksa apakah setengah kiri terurut
            if (arr[low] <= arr[mid]) {
                // Periksa apakah target berada di setengah kiri yang terurut
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Setengah kanan terurut
            else {
                // Periksa apakah target berada di setengah kanan yang terurut
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
```

## Penjelasan Konsep Rotated Array

### Apa itu Rotated Array?
**Rotated Array** adalah array yang originally sorted, kemudian di-"rotate" ke kiri atau kanan beberapa posisi.

#### Contoh:
```
Original: [1, 2, 3, 4, 5, 6, 7]
Rotated:  [4, 5, 6, 7, 1, 2, 3]  (rotated 3 positions to left)
```

### Karakteristik Rotated Array:
1. **Ada pivot point** di mana sequence "break"
2. **Dua bagian sorted** terpisah
3. **Maximum element** diikuti oleh minimum element di pivot

## Penjelasan Langkah per Langkah

### 1. Method Signature
```java
public static int searchInRotatedArray(int[] arr, int target) {
```
- **Purpose**: Mencari target dalam rotated sorted array
- **Challenge**: Array tidak fully sorted, tapi memiliki pattern
- **Goal**: Tetap O(log n) time complexity

### 2. Inisialisasi Standard
```java
int low = 0;
int high = arr.length - 1;
```
- **Same as**: Binary search biasa
- **Strategy**: Akan menggunakan modified binary search

### 3. Main Loop dan Target Found
```java
while (low <= high) {
    int mid = low + (high - low) / 2;

    if (arr[mid] == target) {
        return mid;
    }
```
- **Standard check**: Jika target ditemukan di mid, return
- **Same logic**: Dengan binary search biasa

### 4. Key Innovation - Identify Sorted Half
```java
// Periksa apakah setengah kiri terurut
if (arr[low] <= arr[mid]) {
```

#### Mengapa Check `arr[low] <= arr[mid]`?
- **If true**: Setengah kiri **pasti sorted**
- **Logic**: Dalam rotated array, minimal satu setengah pasti sorted
- **Edge case**: `<=` handles duplicate elements

#### Visual Example:
```
Array: [4, 5, 6, 7, 1, 2, 3]
       low     mid     high
        4       7       3

arr[low] <= arr[mid] → 4 <= 7 → TRUE
Artinya: [4, 5, 6, 7] adalah bagian yang sorted
```

### 5. Search in Sorted Left Half
```java
// Periksa apakah target berada di setengah kiri yang terurut
if (arr[low] <= target && target < arr[mid]) {
    high = mid - 1;
} else {
    low = mid + 1;
}
```

#### Condition Breakdown:
- **arr[low] <= target**: Target >= elemen pertama left half
- **target < arr[mid]**: Target < elemen terakhir left half
- **Both true**: Target pasti ada di left half (karena sorted)
- **Else**: Target pasti ada di right half

#### Visual:
```
Left sorted: [4, 5, 6, 7], target = 5
arr[low] <= target: 4 <= 5 ✓
target < arr[mid]: 5 < 7 ✓
→ Search in left half
```

### 6. Search in Sorted Right Half
```java
// Setengah kanan terurut
else {
    // Periksa apakah target berada di setengah kanan yang terurut
    if (arr[mid] < target && target <= arr[high]) {
        low = mid + 1;
    } else {
        high = mid - 1;
    }
}
```

#### When Execute:
- **Condition**: `arr[low] > arr[mid]` (left half not sorted)
- **Implication**: Right half must be sorted

#### Logic:
- **arr[mid] < target**: Target > elemen pertama right half
- **target <= arr[high]**: Target <= elemen terakhir right half
- **Both true**: Target pasti ada di right half

## Contoh Trace Execution

### Data: arr = [4, 5, 6, 7, 1, 2, 3], target = 2

| Step | low | high | mid | arr[mid] | Left Sorted? | Action |
|------|-----|------|-----|----------|--------------|--------|
| 1 | 0 | 6 | 3 | 7 | Yes (4≤7) | 4≤2? No → go right |
| 2 | 4 | 6 | 5 | 2 | No (1>2) | Found! Return 5 |

### Detailed Step 1:
- **Check left sorted**: arr[0] ≤ arr[3] → 4 ≤ 7 ✓
- **Check target in left**: 4 ≤ 2? ✗ → Target not in sorted left
- **Action**: Search right half (low = 4)

### Detailed Step 2:
- **mid = 5**, arr[5] = 2
- **Target found**: Return 5

## Contoh Lain: Target = 6

### Data: arr = [4, 5, 6, 7, 1, 2, 3], target = 6

| Step | low | high | mid | arr[mid] | Left Sorted? | Action |
|------|-----|------|-----|----------|--------------|--------|
| 1 | 0 | 6 | 3 | 7 | Yes (4≤7) | 4≤6<7? Yes → go left |
| 2 | 0 | 2 | 1 | 5 | Yes (4≤5) | 4≤6? Yes, 6<5? No → go right |
| 3 | 2 | 2 | 2 | 6 | - | Found! Return 2 |

## Edge Cases dan Handling

### 1. **No Rotation (Regular Sorted Array)**
```
Array: [1, 2, 3, 4, 5, 6, 7]
```
- **Algorithm still works**: Left half always sorted
- **Performance**: Same as regular binary search

### 2. **Single Element**
```
Array: [5], target = 5
```
- **mid = 0**: arr[0] == target → return 0

### 3. **Duplicate Elements**
```
Array: [2, 2, 2, 3, 1, 2, 2]
```
- **Challenge**: `arr[low] == arr[mid]` doesn't guarantee sorted
- **Solution**: Need additional handling (advanced topic)

### 4. **Target Not Found**
```
Array: [4, 5, 6, 7, 1, 2, 3], target = 8
```
- **Loop akan berakhir**: low > high
- **Return -1**: Target tidak ditemukan

## Kompleksitas

### Time Complexity: O(log n)
- **Same as**: Regular binary search
- **Each iteration**: Eliminates half of search space
- **Worst case**: log₂(n) iterations

### Space Complexity: O(1)
- **No recursion**: Iterative approach
- **Variables**: Only low, high, mid

## Variations dan Advanced Topics

### 1. **Find Pivot Point**
```java
public static int findPivot(int[] arr) {
    int low = 0, high = arr.length - 1;
    
    while (low < high) {
        int mid = low + (high - low) / 2;
        
        if (arr[mid] > arr[high]) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    
    return low; // Index of minimum element
}
```

### 2. **Two-Step Approach**
```java
public static int searchAlternative(int[] arr, int target) {
    int pivot = findPivot(arr);
    
    // Search in left sorted part
    int leftResult = binarySearch(arr, 0, pivot - 1, target);
    if (leftResult != -1) return leftResult;
    
    // Search in right sorted part
    return binarySearch(arr, pivot, arr.length - 1, target);
}
```

### 3. **Handle Duplicates**
```java
public static int searchWithDuplicates(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    
    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (arr[mid] == target) return mid;
        
        // Handle duplicates
        if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
            low++;
            high--;
        } else if (arr[low] <= arr[mid]) {
            // Left half sorted logic
        } else {
            // Right half sorted logic
        }
    }
    
    return -1;
}
```

## Real World Applications

### 1. **Log File Analysis**
- **Rotated logs**: Log files dengan timestamp yang wrap around
- **Search events**: Dalam specific time range

### 2. **Circular Buffer Search**
- **Ring buffers**: Data structures yang wrap around
- **Efficient search**: Dalam circular data

### 3. **Array Rotation Problems**
- **Data recovery**: Setelah rotation operations
- **Pattern matching**: Dalam shifted sequences

### 4. **System Performance**
- **Load balancing**: Server rotation schemes
- **Cache management**: Circular cache searches