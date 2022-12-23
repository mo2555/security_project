import Controllers.AffineCipher;
import Controllers.CeaserCipher;
import Controllers.VigenereCipher;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static String takeKey() {
        System.out.println("Enter the key : ");
        return scanner.next();
    }

    public static String takeText(String text) {
        System.out.println("Enter the " + text + " : ");
        return scanner.next();
    }

    public static int encodeOrDecode() {
        System.out.println("Please enter ( 1 ) for encode or ( 2 ) for decode : ");
        return scanner.nextInt();
    }

    public static void printAll(String key, String planText, String cipherText) {
        if(!key.isEmpty())
        System.out.println("Your key is " + key);
        System.out.println("Your plantext is " + planText);

        System.out.println("The ciphertext is " + cipherText);
    }

    public static void exec(int operationNumber) {
        int encodeOrDecode = encodeOrDecode();
        if (operationNumber == 1) {
            CeaserCipher ceaserCipher = new CeaserCipher();
            switch (encodeOrDecode) {

                case 1: {

                    String key = takeKey();
                    String text = takeText("plantext");
                    printAll(key, text, ceaserCipher.encode(key, text));
                    break;
                }
                case 2: {
                    String key = takeKey();
                    String text = takeText("ciphertext");
                    printAll(key, ceaserCipher.decode(key, text), text);
                    break;
                }
                default: {
                    System.out.println("No operation have this number.");
                }
            }
        } else if (operationNumber == 2) {
            VigenereCipher vigenereCipher = new VigenereCipher();
            switch (encodeOrDecode) {

                case 1: {

                    String key = takeKey();
                    String text = takeText("plantext");
                    printAll(key, text, vigenereCipher.encode(key, text));
                    break;
                }
                case 2: {
                    String key = takeKey();
                    String text = takeText("ciphertext");
                    printAll(key, vigenereCipher.decode(key, text), text);
                    break;
                }
                default: {
                    System.out.println("No operation have this number.");
                }
            }
        } else if (operationNumber == 3) {
            AffineCipher affineCipher = new AffineCipher();
            switch (encodeOrDecode) {

                case 1: {
                    String key = takeKey();
                    String text = takeText("plantext");
                    printAll(key, text, affineCipher.encode(key, text)==""?"Can not encode":affineCipher.encode(key, text));
                    break;
                }
                case 2: {
                    String key = takeKey();
                    String text = takeText("ciphertext");
                    printAll(key, affineCipher.decode(key, text)==""?"Can not decode":affineCipher.decode(key, text), text);
                    break;
                }
                default: {
                    System.out.println("No operation have this number.");
                }
            }
        } else {
            System.out.println("No operation have this number.");
        }
    }


    public static void main(String[] args) {
        loop:
        while (true) {
            System.out.println("Enter the number of the operation : \n ( 1 ) for CeaserCipher\n ( 2 ) for VigenereCipher\n ( 3 ) for AffineCipher\n ( 0 ) for exit");

            switch (scanner.nextInt()) {
                case 0: {
                    break loop;
                }
                case 1: {
                    exec(1);
                    break;
                }
                case 2: {
                    exec(2);
                    break;
                }
                case 3: {
                    exec(3);
                    break;
                }
            }
        }

    }
}
