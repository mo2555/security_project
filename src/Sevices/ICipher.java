package Sevices;

public interface ICipher {

     String encode(String key,String planText);

     String decode(String key,String cipherText);
}
