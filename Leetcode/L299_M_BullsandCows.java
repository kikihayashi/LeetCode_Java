package Leetcode;

public class L299_M_BullsandCows {

    /**
     * https://leetcode.com/problems/bulls-and-cows/
     */


    public static void main(String[] args) {
//        String secret = "1123";
//        String guess = "0111";

//        String secret = "1807";
//        String guess = "7810";

//        String secret = "1122";
//        String guess = "2211";

        String secret = "1122";
        String guess = "0001";

        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        int[] s_map = new int[10];
        int[] g_map = new int[10];
        int x = 0;
        int y = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                x++;
            } else {
                s_map[secret.charAt(i) - '0']++;
                g_map[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            y += Math.min(s_map[i], g_map[i]);
        }
        return x + "A" + y + "B";
    }
}
