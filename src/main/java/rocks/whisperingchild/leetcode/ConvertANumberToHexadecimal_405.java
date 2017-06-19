package rocks.whisperingchild.leetcode;

/**
 * Created by WhisperingChild on 19/06/2017.
 */
public class ConvertANumberToHexadecimal_405 {
    final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    final int mask = 15;
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            int index = num & mask;
            builder.append(hex[index]);
            num >>>= 4;
        }
        return builder.reverse().toString();
    }
}
