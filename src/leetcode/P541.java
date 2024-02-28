package leetcode;

public class P541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k) {
            if (i + k - 1 < s.length()) {
                reverse(arr, i, i + k - 1);
            } else {
                reverse(arr, i, s.length() - 1);
            }
        }

        return new String(arr);
    }

    public void reverse(char[] s, int i, int j) {
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
