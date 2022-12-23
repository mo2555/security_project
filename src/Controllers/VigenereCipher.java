package Controllers;

import Sevices.ICipher;

public class VigenereCipher implements ICipher {
    @Override
    public String encode(String key, String planText) {
        String cipherText = "";
        planText = planText.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < planText.length(); i++) {
            char c = planText.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            cipherText += (char) ((c + key.charAt(j) - 2 * 65) % 26 + 65);
            j = ++j % key.length();
        }
        return cipherText.toLowerCase();
    }

    @Override
    public String decode(String key, String cipherText) {
        String planText = "";
        cipherText = cipherText.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            planText += (char) ((c - key.charAt(j) + 26) % 26 + 65);
            j = ++j % key.length();
        }
        return planText.toLowerCase();
    }
}
