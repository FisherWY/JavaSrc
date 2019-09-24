package LeetCode;

/**
 * @Author Fisher
 * @Date 2019/7/15 10:29
 **/


public class solution1 {
    public static String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        int pos = 0, length = 0;
        int status[][] = new int[s.length()][s.length()];
        String reverse = new StringBuffer(s).reverse().toString();
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<s.length(); j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i==0 || j==0) {
                        status[i][j] = 1;
                    } else {
                        status[i][j] = status[i-1][j-1] + 1;
                    }
                }
                if (status[i][j] > length) {
                    int origin_pos = s.length() - j - 1;
                    if (origin_pos + status[i][j] - 1 == i) {
                        length = status[i][j];
                        pos = i;
                    }
                }
            }
        }
        System.out.println("pos: " + pos + " len:" + length);
        return s.substring(pos-length+1, pos+1);
    }

    public static void main(String[] args) {
        String s1 = "abcdbbfcba";
        String s = "bb";
        System.out.println(longestPalindrome(s));
    }
}
