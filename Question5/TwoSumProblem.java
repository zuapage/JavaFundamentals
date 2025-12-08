public class TwoSumProblem {
    
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array harus berisi minimal 2 elemen");
        }
        
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        
        throw new IllegalArgumentException("Tidak ada dua angka yang jumlahnya sama dengan target");
    }
    
    public static int[] twoSumOptimized(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array harus berisi minimal 2 elemen");
        }
        
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("Tidak ada dua angka yang jumlahnya sama dengan target");
    }
    
    public static void main(String[] args) {
        System.out.println("=== TWO SUM PROBLEM ===\n");
        
        demonstrateBruteForce();
        System.out.println("\n" + "=".repeat(80) + "\n");
        demonstrateOptimized();
        System.out.println("\n" + "=".repeat(80) + "\n");
        demonstrateEdgeCases();
    }
    
    private static void demonstrateBruteForce() {
        System.out.println("METODE 1: BRUTE FORCE (Nested Loop)");
        System.out.println("-".repeat(80));
        
        System.out.println("Test Case 1:");
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1) + ", target = " + target1);
        
        try {
            int[] result1 = twoSum(nums1, target1);
            System.out.println("Output: " + java.util.Arrays.toString(result1));
            System.out.println("Penjelasan: nums[" + result1[0] + "] + nums[" + result1[1] + "] = " + 
                             nums1[result1[0]] + " + " + nums1[result1[1]] + " = " + target1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\nTest Case 2:");
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2) + ", target = " + target2);
        
        try {
            int[] result2 = twoSum(nums2, target2);
            System.out.println("Output: " + java.util.Arrays.toString(result2));
            System.out.println("Penjelasan: nums[" + result2[0] + "] + nums[" + result2[1] + "] = " + 
                             nums2[result2[0]] + " + " + nums2[result2[1]] + " = " + target2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\nTest Case 3:");
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums3) + ", target = " + target3);
        
        try {
            int[] result3 = twoSum(nums3, target3);
            System.out.println("Output: " + java.util.Arrays.toString(result3));
            System.out.println("Penjelasan: nums[" + result3[0] + "] + nums[" + result3[1] + "] = " + 
                             nums3[result3[0]] + " + " + nums3[result3[1]] + " = " + target3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\nKarakteristik Brute Force:");
        System.out.println("- Time Complexity: O(n²) - nested loop");
        System.out.println("- Space Complexity: O(1) - hanya array output");
        System.out.println("- Mudah dipahami, cocok untuk array kecil");
    }
    
    private static void demonstrateOptimized() {
        System.out.println("METODE 2: OPTIMIZED (HashMap)");
        System.out.println("-".repeat(80));
        
        System.out.println("Test Case 1:");
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1) + ", target = " + target1);
        
        try {
            int[] result1 = twoSumOptimized(nums1, target1);
            System.out.println("Output: " + java.util.Arrays.toString(result1));
            System.out.println("Penjelasan: nums[" + result1[0] + "] + nums[" + result1[1] + "] = " + 
                             nums1[result1[0]] + " + " + nums1[result1[1]] + " = " + target1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\nTest Case 2:");
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2) + ", target = " + target2);
        
        try {
            int[] result2 = twoSumOptimized(nums2, target2);
            System.out.println("Output: " + java.util.Arrays.toString(result2));
            System.out.println("Penjelasan: nums[" + result2[0] + "] + nums[" + result2[1] + "] = " + 
                             nums2[result2[0]] + " + " + nums2[result2[1]] + " = " + target2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\nTest Case 3 (Large Array):");
        int[] nums3 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums3[i] = i;
        }
        int target3 = 1998;
        System.out.println("Input: nums = array with 1000 elements [0, 1, 2, ..., 999], target = " + target3);
        
        try {
            long startTime = System.nanoTime();
            int[] result3 = twoSumOptimized(nums3, target3);
            long endTime = System.nanoTime();
            
            System.out.println("Output: " + java.util.Arrays.toString(result3));
            System.out.println("Penjelasan: nums[" + result3[0] + "] + nums[" + result3[1] + "] = " + 
                             nums3[result3[0]] + " + " + nums3[result3[1]] + " = " + target3);
            System.out.println("Waktu eksekusi: " + (endTime - startTime) + " nanoseconds");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\nKarakteristik Optimized:");
        System.out.println("- Time Complexity: O(n) - single loop");
        System.out.println("- Space Complexity: O(n) - HashMap storage");
        System.out.println("- Lebih cepat untuk array besar");
    }
    
    private static void demonstrateEdgeCases() {
        System.out.println("EDGE CASES DAN EXCEPTION HANDLING");
        System.out.println("-".repeat(80));
        
        System.out.println("Case 1: Array kosong");
        try {
            int[] nums = {};
            int[] result = twoSum(nums, 9);
            System.out.println("Output: " + java.util.Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\nCase 2: Array null");
        try {
            int[] result = twoSum(null, 9);
            System.out.println("Output: " + java.util.Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\nCase 3: Array dengan 1 elemen");
        try {
            int[] nums = {5};
            int[] result = twoSum(nums, 9);
            System.out.println("Output: " + java.util.Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\nCase 4: Tidak ada pasangan yang cocok");
        try {
            int[] nums = {1, 2, 3, 4};
            int[] result = twoSum(nums, 100);
            System.out.println("Output: " + java.util.Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\nCase 5: Bilangan negatif");
        try {
            int[] nums = {-1, -2, -3, 5};
            int target = 2;
            int[] result = twoSum(nums, target);
            System.out.println("Input: nums = " + java.util.Arrays.toString(nums) + ", target = " + target);
            System.out.println("Output: " + java.util.Arrays.toString(result));
            System.out.println("Penjelasan: nums[" + result[0] + "] + nums[" + result[1] + "] = " + 
                             nums[result[0]] + " + " + nums[result[1]] + " = " + target);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}