package MS.OA2017;

/**Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 …
 Z -> 26
 AA -> 27
 AB -> 28

 [分析]
 26进制转10进制

 [注意事项]
 1）s == null的处理
 * Created by wtnwi on 1/15/2017.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int rst = 0;
        if (s==null) return rst;
        int n = s.length();
        for (int i=0; i<n; ++i) {
            char ch = s.charAt(i);
            rst = rst * 26 + ch - 'A' + 1;
        }
        return rst;
    }
}
