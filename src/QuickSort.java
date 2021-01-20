import java.util.Random;

public class QuickSort {
    public void QuickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int index = partition(nums, left, right);
        QuickSort(nums, left, index-1);
        QuickSort(nums, index+1, right);
    }

    public int partition(int[] nums, int left, int right){
        if(left == right){
            return left;
        }
        Random random = new Random();
        int index = random.nextInt(right-left+1)+left;
        swap(nums, left, index);
        int j = left;
        int pivot = nums[left];
        for(int i=left+1; i<=right; i++){
            if(nums[i]<pivot){
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
