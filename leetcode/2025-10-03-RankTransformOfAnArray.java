class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copyArr = arr.clone();
        Arrays.sort(copyArr);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank  = 1;
        for(int ele : copyArr)
        {   
            if(!map.containsKey(ele)){ 
                map.put(ele,rank);
                rank++;
            }
        }
        int[] result = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            result[i] = map.get(arr[i]);
        }

        return result;
        
    }
}
