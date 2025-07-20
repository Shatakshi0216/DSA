class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String word : strs)
        {
            char[] sortedArray = word.toCharArray();
            Arrays.sort(sortedArray);
            String SortedWord = new String(sortedArray);

            if(!map.containsKey(SortedWord)) map.put(SortedWord,new ArrayList<>());
            map.get(SortedWord).add(word);
        }
         return new ArrayList<>(map.values());
    }
}
