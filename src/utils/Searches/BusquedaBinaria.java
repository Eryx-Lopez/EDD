package utils.Searches;

public class BusquedaBinaria {
    public static int getRecursive(int[] nums, int left, int right, int target) {
        if (left > right){
            return -1;
        }
        int mid = (left + right)/2;

        if (target == nums[mid]){
            return mid;
        } else if (target < nums[mid]) {
            return getRecursive(nums, left, mid -1, target);
        }
        else{
            return getRecursive(nums, mid + 1, right, target);
        }
    }

    public static int getIterative(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}