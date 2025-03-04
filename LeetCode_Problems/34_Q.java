class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] array = new int[2];
        int low = 0;
        int high = nums.length-1;
        
        if(nums.length == 0)
        {
            array[0] = -1;
            array[1] = -1;
            return array;
        }

        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid]== target)
            {
                int index_l = mid;
                int index_u = mid;
                while(index_l <= nums.length-1 && index_l >= 0 && nums[index_l] == target)
                {
                    array[0] = index_l;
                    index_l--;
                }
                while(index_u <= nums.length-1 && index_u >= 0 && nums[index_u] == target)
                {
                    array[1] = index_u;
                    index_u++;
                }
                return array;
                
            }
            else if(nums[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }    

            if(low > high)
            {
                array[0] = -1;
                array[1] = -1;
                return array;
            }
        }

        
        return array;
    }
}
