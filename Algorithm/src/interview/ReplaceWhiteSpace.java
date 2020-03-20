package interview;

/**
 * Find the whitespace in the string and replace it with '%20'
 *
 * 1. transversing the char[] and count the number of whitespace
 * 2. crate a new char[] with length of (str.length + space * 2)
 * 3. copy original array from the end.
 */
public class ReplaceWhiteSpace {
    public static String replace(String string) {
        if (string == null || string.length() == 0) return null;
        char[] str = string.toCharArray();
        int space = 0;
        for (char c : str) {
            if (c == ' ') space++;
        }
        char[] chars = new char[str.length + space * 2];
        int former = 0;
        int index = chars.length - 1;
        for (int i = str.length -1 ; i >= 0; i--) {
            if (str[i] != ' ') {
                chars[index] = str[i];
            } else {
                chars[index] = '0';
                index--;
                chars[index] = '2';
                index--;
                chars[index] = '%';
            }
            index--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(replace("Hello World"));
        System.out.println(replace("Hello World "));
        System.out.println(replace("HelloWorld"));
    }
}