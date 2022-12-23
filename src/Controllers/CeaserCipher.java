package Controllers;

import Sevices.ICipher;

public class CeaserCipher implements ICipher {
    @Override
    public String encode(String key, String planText) {

        String cipherText = "";
        planText = planText.toUpperCase();
        for (int i = 0; i < planText.length(); i++) {
            cipherText += (char) (((Integer.parseInt(key) + ((int) planText.charAt(i)) - 65) % 26) + 65);
        }
        return cipherText.toLowerCase();
    }

    @Override
    public String decode(String key, String cipherText) {
        String planText = "";
        cipherText = cipherText.toUpperCase();
        for (int i = 0; i < cipherText.length(); i++) {
            planText += (char) ((((((int) cipherText.charAt(i)) - Integer.parseInt(key)) - 65) % 26) + 65);
        }

        return planText.toLowerCase();
    }
}
