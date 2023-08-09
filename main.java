import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String reversedStr = "2823101701997927";
        List<Character> listChar = new ArrayList<>();
        for(int idx=reversedStr.length()-1; idx >=0; idx--) {
            listChar.add(reversedStr.charAt(idx));
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : listChar) {
            sb.append(ch);
        }
        String s= sb.toString();
        System.out.println(s);

        int left = 0;
        List<String> temp = new ArrayList<>();
        String substr;

        while (left <= (s.length() - 1)) {
            if (s.charAt(left) == '1') {
                // Check if there are enough characters to form a 3-digit substring
                if (left + 2 < s.length()) {
                    substr = s.substring(left, left + 3);
                    temp.add(substr);
                    left += 3;
                }
            } else if (s.charAt(left) >= '6' && s.charAt(left) <= '9') {
                // Check if there are enough characters to form a 2-digit substring
                if (left + 1 < s.length()) {
                    substr = s.substring(left, left + 2);
                    temp.add(substr);
                    left += 2;
                }
            } else if (s.charAt(left) == '3') {
                // Skip the character '3'
                left += 1;
            } else {
                // Move to the next character
                left += 1;
            }
        }
        System.out.println("Result: " + temp);


        StringBuilder sbi = new StringBuilder();

        for (String numberStr : temp) {
            try {
                int number = Integer.parseInt(numberStr);
                char asciiChar = (char) number;
                sbi.append(asciiChar);
            } catch (NumberFormatException e) {
                // Handle invalid number format if needed
                e.printStackTrace();
            }
        }

        sbi.toString();
        System.out.println("final result: " + sbi);
    }
}
