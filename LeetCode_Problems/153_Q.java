int Min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length-1;
        while(low <= high)
        {
            int mid = (low+high)/2;
            
            if(nums[mid] < nums[high])
            {
                Min = Math.min(Min, nums[mid]);
                high = mid-1;
            }
            else
            {
                Min = Math.min(Min, nums[mid]);
                low = mid+1;
            }

        }

        return Min;
