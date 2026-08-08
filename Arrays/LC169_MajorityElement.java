import java.util.HashMap;
import java.util.Map;

class LC169_MajorityElement {
    public int majorityElementHashMap(int[] nums) {

        int N = nums.length;    //Used in brute force and HashMap approach
      
        // better case (HashMap)
        HashMap<Integer, Integer> data = new HashMap<>();

        for(int i : nums){
            if(!data.containsKey(i)){
                data.put(i, 1);
            }else{
                data.put(i, data.get(i)+1);
            }
        }

        for(Map.Entry<Integer, Integer> d : data.entrySet()){
            if((N/2) < d.getValue()){
                return d.getKey();
            }
        }

        
        return -1;
    }

    public int majorityElementBruteForce(int[] nums) {

        int N = nums.length; 
      
        //brute force -----------------------
        int target = -1;

        for(int i = 0; i<N; i++){
              int count = 0;
              target = nums[i];    

            for(int j : nums){
                if(target == j){
                    count++;
                }
            }

            if(count > (N/2)){
                return nums[i];
            }
        }

        return -1; // This line will never be reached if the input guarantees a majority element
    }

    public int majorityElementOptimal(int[] nums) {

        //Best case (Boyer Moore Majority Vote Algorithm)
        int count = 0;
        int candidate = 0;

        for(int i : nums){
            if(count == 0)
                candidate = i;

            if(i == candidate)
                count++;
            else
                count--;
        }
        
        return candidate;
    }


    public static void main(String[] args) {
        LC169_MajorityElement solution = new LC169_MajorityElement();
        int[] nums = {3,3,4,2,3,3,3};
        //brute force
        int majority = solution.majorityElementBruteForce(nums);
        System.out.println("Majority Element (Brute Force): " + majority);
        // HashMap
        majority = solution.majorityElementHashMap(nums);
        System.out.println("Majority Element (HashMap): " + majority);
        // optimal
        majority = solution.majorityElementOptimal(nums);
        System.out.println("Majority Element (Optimal): " + majority);
    }

}