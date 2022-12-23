package Controllers;

import Sevices.ICipher;

public class AffineCipher implements ICipher {
    static int a = 160;

    @Override
    public String encode(String key, String planText) {
        if(gcd(26,a)==1){
            String cipherText = "";
            planText = planText.toUpperCase();
            for (int i = 0; i < planText.length(); i++) {
                if (planText.charAt(i) != ' ') {
                    cipherText = cipherText
                            + (char) ((((a * (planText.charAt(i) - 'A')) + Integer.parseInt(key)) % 26) + 'A');
                } else {
                    cipherText += planText.charAt(i);
                }
            }
            return cipherText.toLowerCase();
        }else{
            return  "";
        }

    }

    @Override
    public String decode(String key, String cipherText) {
        if(gcd(26,a)==1){
            String planText = "";
            cipherText = cipherText.toUpperCase();
            int a_inv = 0;
            for (int i = 0; i < 26; i++) {

                if (((a * i) % 26) == 1) {
                    a_inv = i;
                }
            }
            System.out.println(a_inv);
            for (int i = 0; i < cipherText.length(); i++) {
                if (cipherText.charAt(i) != ' ') {
                    planText = planText + (char) (((a_inv *
                            ((cipherText.charAt(i) + 'A' - Integer.parseInt(key))) % 26)) + 'A');
                } else {
                    planText += cipherText.charAt(i);
                }
            }

            return planText.toLowerCase();
        }
        return  "";
    }

    public int gcd(int n, int a){
        if(a==0){
            return n;
        }else{
            return  gcd(a,n%a);
        }
    }

}
