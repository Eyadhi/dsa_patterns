package topkelements.quickselect;

public class Problems {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }

    public int quickSelect(int[] nums,int left,int right,int target){
        if(left == right) return nums[left];

        int pivot = nums[left];
        int low = left;
        int high = right;

        while(low <= high){
            while(low<=high && nums[low] < pivot){
                low++;
            }
            while(low<=high && nums[high]>pivot){
                high--;
            }
            if(low<=high){
                int temp = nums[low];
                nums[low++] = nums[high];
                nums[high--] =temp;
            }
        }
        if(target<= high){
            return quickSelect(nums,left,high,target);
        }else if(target >= low){
            return quickSelect(nums,low,right,target);
        }else{
            return nums[target];
        }     
    }
}