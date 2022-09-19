package dp;

/**
 * 最长回文串
 * 给定一个字符串 s, 找到 s 中最长的回文串
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * link: https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class _9_19_longestPalindrome_v1 {
    /**
     * 状态转移方程
     * isP(i,j)=i==j&&isP(i+1,j-1)
     * 边界
     * * isP(i,i)=true
     * * isP(i,j) invalid i>j
     */
    public String longestPalindrome(String s) {
        boolean[][] grid = new boolean[s.length()][s.length()];
        // layer 表示对称轴往右上角扩展的层数
        for (int layer = 0; layer < s.length(); layer++) {
            for (int row = 0; row < s.length(); row++) {
                int column = row + layer;
                if (column >= s.length()) continue;

                boolean b = s.charAt(row) == s.charAt(column);
                grid[row][column] = row == column || (grid[row + 1][column - 1] && b) || column == row + 1 && b;
            }
        }
        // 输出
        for (int layer = s.length() - 1; layer >= 0; layer--) {
            for (int row = 0; row < s.length(); row++) {
                int column = row + layer;
                if (column >= s.length()) continue;
                if (grid[row][column])
                    return s.substring(row, column + 1);
            }
        }
        return "";
    }

    public static void main(String args[]) {
        _9_19_longestPalindrome_v1 palindrome = new _9_19_longestPalindrome_v1();
        System.out.println(palindrome.longestPalindrome("cbbd"));
    }
}
