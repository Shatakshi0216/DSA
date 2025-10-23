class Solution {
    public int maxDiff(int num) {
        String strNum = Integer.toString(num);

        // For max, find first digit ≠ 9, replace it with 9 everywhere
        char toReplaceMax = ' ';
        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) != '9') {
                toReplaceMax = strNum.charAt(i);
                break;
            }
        }
        String maxStr = (toReplaceMax == ' ') ? strNum : strNum.replace(toReplaceMax, '9');

        // For min, find first digit > 1, replace it with 1 if first digit, or 0 if not
        char toReplaceMin = ' ';
        char replaceWith = ' ';
        if (strNum.charAt(0) != '1') {
            toReplaceMin = strNum.charAt(0);
            replaceWith = '1';
        } else {
            for (int i = 1; i < strNum.length(); i++) {
                if (strNum.charAt(i) != '0' && strNum.charAt(i) != '1') {
                    toReplaceMin = strNum.charAt(i);
                    replaceWith = '0';
                    break;
                }
            }
        }
        String minStr = (toReplaceMin == ' ') ? strNum : strNum.replace(toReplaceMin, replaceWith);

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}
