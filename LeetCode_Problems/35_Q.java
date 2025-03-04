class Solution {
    public int searchInsert(int[] nums, int target) {
        int index=0;
        int high = nums.length - 1;
        int low = 0;
        if(target < nums[low])
        {
                return 0;
        }
        else if(target > nums[high])
        {
            return nums.length;
        }
        
        while(low <= high)
        {
            
            int mid = (high + low)/2;
            //System.out.println("1");
            if(nums[mid] == target)
            {
                
                //System.out.println("2");
                return mid;

                
            }
            else if(nums[mid] < target)
            {
                low = mid +1;
                //System.out.println("3");
                if(low > high)
                {
                    //System.out.println("4");
                    return low;
                }
            }
            else
            {
                high = mid - 1;
                //System.out.println("5");
                if(low > high)
                {
                    //System.out.println("6");
                    return low;
                }
            }
        }
        return index;
    }
    
}
