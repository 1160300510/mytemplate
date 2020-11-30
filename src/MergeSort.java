public class MergeSort {
    public void mergesort(int[] nums){
        mergesortRecursive(nums, 0, nums.length-1);
    }

    public void mergesortRecursive(int[] nums, int left, int right){
        if (left == right){
            return;
        }
        int mid = (left + right)/2;
        mergesortRecursive(nums, left, mid);
        mergesortRecursive(nums, mid+1, right);
        //合并数组
        int[] sorted = new int[right-left+1];
        int p1 = left, p2 = mid+1;
        int p = 0;
        while (p1 <= mid || p2 <= right){
            if(p1 > mid){
                sorted[p++] = nums[p2++];
            }else if(p2 > right){
                sorted[p++] = nums[p1++];
            }else{
                if(nums[p1] < nums[p2]){
                    sorted[p++] = nums[p1++];
                }else{
                    sorted[p++] = nums[p2++];
                }
            }
        }
        for(int k=0; k<sorted.length; k++){
            nums[left+k] = sorted[k];
        }
    }

    public static void main(String[] args) {
        int[] s = new int[]{6,3,2,1,5};
        MergeSort sort = new MergeSort();
        sort.mergesort(s);
        for(int num : s){
            System.out.println(num);
        }
    }
}
