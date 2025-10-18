class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        StringBuilder sb = new StringBuilder(s);
        sb.append(s);
        return sb.toString().contains(goal); // contains -> checks whether the given substring exists inside the string
    }
}
