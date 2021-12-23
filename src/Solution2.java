import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution2 {

    public static String solution(String S) {
        char[] arr = S.toCharArray();
        HashMap<Character, ArrayList<Integer>> set = new HashMap<>();

        for(int i = 0; i< arr.length; i++){
            if(set.containsKey(arr[i])){
                ArrayList<Integer> list = set.get(arr[i]);
                list.add(i);
            }
            else{
                ArrayList<Integer> found = new ArrayList<>();
                found.add(i);
                set.put(arr[i], found);
            }
        }

        ArrayList<Integer> big = null;
        int tempBig = 0;

        for(Map.Entry yikes : set.entrySet()){
            int sum = 0;
            ArrayList<Integer> list = (ArrayList<Integer>) yikes.getValue();
            sum += list.get(list.size() - 1) - list.get(0);
            if(sum > tempBig){
                tempBig = sum;
                big = list;
            }
        }
        if(big == null){
            return String.valueOf(S.charAt(0));
        }

        int a = big.get(0);
        int b = big.get(big.size() - 1);

        return S.substring(a, b + 1).length() != 1 ? S.substring(a, b + 1) : String.valueOf(S.charAt(0));
    }

    public static void main(String[] args){
        String a = "cbaabaab";
        String b = "performance";
        String c = "cat";
        String d = "ben";

        System.out.println(solution(d));


    }

}