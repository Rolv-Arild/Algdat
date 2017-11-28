package util;

import java.util.Arrays;

public class TextSearch {

    public static boolean BooyerMoore(String string, String key) {
        int[] movelen = new int[Character.MAX_VALUE+1];
        Arrays.fill(movelen, key.length());
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            movelen[c] = key.length()-1-i;
        }
        for (int i = key.length()-1; i < string.length();) {
            char c = string.charAt(i);
            if (movelen[c] == 0) { // last character in key
                int j = 0;
                while (j < key.length() && string.charAt(i-j) == key.charAt(key.length()-1-j)) {
                    j++;
                }
                if (j == key.length()) return true; // the entire key was found
                i++;
            } else {
                i += movelen[c];
            }
        }
        return false;
    }
}
