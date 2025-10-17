class Solution {
    public String reverseWords(String s) {
        String[] splitted = s.trim().split("\\s+"); // s.trim -> leading zeros .split(\\s+) -> split with multiple spaces 
        List<String> forReverse = Arrays.asList(splitted); 
        Collections.reverse(forReverse);

        return String.join(" ",forReverse); // rebuild with spaces 
    }
}
