import java.util.HashMap;
import java.util.Map;

class Solution {

    public static int solution(int[] nums) {

        HashMap<Integer, Integer> set = new HashMap<>();

        for(int i = 0; i < nums.length-1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    break;
                }
                int sum = nums[i] + nums[j];
                if(set.containsKey(sum)) {
                    set.put(sum, (set.get(sum) + 1));
                }
                else{
                    set.put(nums[i] + nums[j], 1);
                }
            }
        }
        int big = 0;
        for(Map.Entry yikes : set.entrySet()){
            if((int) yikes.getValue() > big){
                big = (int) yikes.getValue();
            }
        }
        return big;
    }

    public static void main(String[] args){

        int[] a = {1,9,8,100,2};
        int[] b = {2,4,3,3};

        System.out.println(solution(a));
        System.out.println(solution(b));




    }

}