import java.util.ArrayList;

public class TwoSumWithArrayList {
    
    static class TwoSumResult {
        int index1;
        int index2;
        int num1;
        int num2;
        int sum;
        
        TwoSumResult(int index1, int index2, int num1, int num2) {
            this.index1 = index1;
            this.index2 = index2;
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
        }
        
        @Override
        public String toString() {
            return "Indices: [" + index1 + ", " + index2 + "], " +
                   "Values: [" + num1 + ", " + num2 + "], Sum: " + sum;
        }
    }
    
    public static int[] twoSumArrayList(ArrayList<Integer> nums, int target) {
        if (nums == null || nums.size() < 2) {
            throw new IllegalArgumentException("ArrayList harus berisi minimal 2 elemen");
        }
        
        int[] result = new int[2];
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        
        throw new IllegalArgumentException("Tidak ada dua angka yang jumlahnya sama dengan target");
    }
    
    public static TwoSumResult twoSumWithDetails(ArrayList<Integer> nums, int target) {
        if (nums == null || nums.size() < 2) {
            throw new IllegalArgumentException("ArrayList harus berisi minimal 2 elemen");
        }
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int num1 = nums.get(i);
                int num2 = nums.get(j);
                if (num1 + num2 == target) {
                    return new TwoSumResult(i, j, num1, num2);
                }
            }
        }
        
        throw new IllegalArgumentException("Tidak ada dua angka yang jumlahnya sama dengan target");
    }
    
    public static ArrayList<int[]> findAllPairs(ArrayList<Integer> nums, int target) {
        ArrayList<int[]> pairs = new ArrayList<>();
        
        if (nums == null || nums.size() < 2) {
            throw new IllegalArgumentException("ArrayList harus berisi minimal 2 elemen");
        }
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) == target) {
                    pairs.add(new int[]{i, j});
                }
            }
        }
        
        if (pairs.isEmpty()) {
            throw new IllegalArgumentException("Tidak ada dua angka yang jumlahnya sama dengan target");
        }
        
        return pairs;
    }
    
    public static void main(String[] args) {
        System.out.println("=== TWO SUM DENGAN ARRAYLIST ===\n");
        
        demonstrateBasicUsage();
        System.out.println("\n" + "=".repeat(80) + "\n");
        demonstrateDetailedResult();
        System.out.println("\n" + "=".repeat(80) + "\n");
        demonstrateFindAllPairs();
        System.out.println("\n" + "=".repeat(80) + "\n");
        demonstrateArrayListOperations();
        System.out.println("\n" + "=".repeat(80) + "\n");
        demonstrateExceptionHandling();
    }
    
    private static void demonstrateBasicUsage() {
        System.out.println("PENGGUNAAN DASAR ARRAYLIST");
        System.out.println("-".repeat(80));
        
        System.out.println("Test Case 1:");
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(2);
        nums1.add(7);
        nums1.add(11);
        nums1.add(15);
        int target1 = 9;
        
        System.out.println("Input: nums = " + nums1 + ", target = " + target1);
        
        try {
            int[] result = twoSumArrayList(nums1, target1);
            System.out.println("Output: " + java.util.Arrays.toString(result));
            System.out.println("Penjelasan: nums.get(" + result[0] + ") + nums.get(" + result[1] + ") = " + 
                             nums1.get(result[0]) + " + " + nums1.get(result[1]) + " = " + target1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\nTest Case 2:");
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(3);
        nums2.add(2);
        nums2.add(4);
        int target2 = 6;
        
        System.out.println("Input: nums = " + nums2 + ", target = " + target2);
        
        try {
            int[] result = twoSumArrayList(nums2, target2);
            System.out.println("Output: " + java.util.Arrays.toString(result));
            System.out.println("Penjelasan: nums.get(" + result[0] + ") + nums.get(" + result[1] + ") = " + 
                             nums2.get(result[0]) + " + " + nums2.get(result[1]) + " = " + target2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void demonstrateDetailedResult() {
        System.out.println("HASIL DENGAN DETAIL LENGKAP");
        System.out.println("-".repeat(80));
        
        System.out.println("Test Case 1:");
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(5);
        nums1.add(3);
        nums1.add(8);
        nums1.add(4);
        int target1 = 11;
        
        System.out.println("Input: nums = " + nums1 + ", target = " + target1);
        
        try {
            TwoSumResult result = twoSumWithDetails(nums1, target1);
            System.out.println("Output: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\nTest Case 2:");
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(-1);
        nums2.add(-2);
        nums2.add(-3);
        nums2.add(5);
        int target2 = 2;
        
        System.out.println("Input: nums = " + nums2 + ", target = " + target2);
        
        try {
            TwoSumResult result = twoSumWithDetails(nums2, target2);
            System.out.println("Output: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void demonstrateFindAllPairs() {
        System.out.println("MENCARI SEMUA PASANGAN YANG COCOK");
        System.out.println("-".repeat(80));
        
        System.out.println("Test Case: Multiple pairs");
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(4);
        nums.add(3);
        nums.add(6);
        nums.add(5);
        nums.add(2);
        int target = 7;
        
        System.out.println("Input: nums = " + nums + ", target = " + target);
        
        try {
            ArrayList<int[]> allPairs = findAllPairs(nums, target);
            System.out.println("Jumlah pasangan ditemukan: " + allPairs.size());
            
            for (int i = 0; i < allPairs.size(); i++) {
                int[] pair = allPairs.get(i);
                System.out.println((i+1) + ". Indices: [" + pair[0] + ", " + pair[1] + "], " +
                                 "Values: [" + nums.get(pair[0]) + ", " + nums.get(pair[1]) + "] = " + target);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void demonstrateArrayListOperations() {
        System.out.println("OPERASI ARRAYLIST LAINNYA");
        System.out.println("-".repeat(80));
        
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("ArrayList kosong dibuat");
        System.out.println("Size: " + nums.size());
        
        System.out.println("\nMenambahkan elemen:");
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        System.out.println("Setelah add(10, 20, 30, 40): " + nums);
        System.out.println("Size: " + nums.size());
        
        System.out.println("\nMengakses elemen:");
        System.out.println("nums.get(0) = " + nums.get(0));
        System.out.println("nums.get(2) = " + nums.get(2));
        
        System.out.println("\nMencari index elemen:");
        System.out.println("Index dari 20: " + nums.indexOf(20));
        System.out.println("Index dari 40: " + nums.indexOf(40));
        
        System.out.println("\nMengubah elemen:");
        nums.set(1, 25);
        System.out.println("Setelah set(1, 25): " + nums);
        
        System.out.println("\nMenghapus elemen:");
        nums.remove(2);
        System.out.println("Setelah remove(2): " + nums);
        System.out.println("Size: " + nums.size());
        
        System.out.println("\nMencek keberadaan elemen:");
        System.out.println("Contains 20: " + nums.contains(20));
        System.out.println("Contains 100: " + nums.contains(100));
    }
    
    private static void demonstrateExceptionHandling() {
        System.out.println("EXCEPTION HANDLING");
        System.out.println("-".repeat(80));
        
        System.out.println("Case 1: ArrayList kosong");
        try {
            ArrayList<Integer> nums = new ArrayList<>();
            twoSumArrayList(nums, 9);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\nCase 2: ArrayList null");
        try {
            twoSumArrayList(null, 9);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\nCase 3: ArrayList dengan 1 elemen");
        try {
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(5);
            twoSumArrayList(nums, 9);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\nCase 4: Tidak ada pasangan yang cocok");
        try {
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(1);
            nums.add(2);
            nums.add(3);
            twoSumArrayList(nums, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\nCase 5: Target dengan bilangan negatif");
        try {
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(-5);
            nums.add(-2);
            nums.add(3);
            nums.add(8);
            int target = 1;
            
            System.out.println("Input: nums = " + nums + ", target = " + target);
            int[] result = twoSumArrayList(nums, target);
            System.out.println("Output: " + java.util.Arrays.toString(result));
            System.out.println("Penjelasan: nums.get(" + result[0] + ") + nums.get(" + result[1] + ") = " + 
                             nums.get(result[0]) + " + " + nums.get(result[1]) + " = " + target);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}