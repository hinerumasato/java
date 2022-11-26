package Array.EX2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyCaesarCipher {
    private int k;
    protected char[] alphabetArr = new char[26];

    public MyCaesarCipher(int k) {
        for(int i = 0; i < alphabetArr.length; i++)
            alphabetArr[i] = (char)('A' + i % 26);
        this.k = k;
    }

    private char[] createEncryptedAlphabet() {
        char[] result = new char[26];
        for(int i = 0; i < result.length; i++)
            result[i] = (char)((alphabetArr[i] - 'A' + k) % 26 + 'A');
        return result;
    }

    public String encrypt(String msg) {
        char[] encryptArr = this.createEncryptedAlphabet();
        char[] resultChar = msg.toCharArray();
        for(int i = 0; i < resultChar.length; i++)
            if(resultChar[i] >= 'A' && resultChar[i] <= 'Z')
                resultChar[i] = encryptArr[resultChar[i] - 'A'];
        return new String(resultChar);
    }

    public String decrypt(String secret) {
        char[] resultChar = secret.toCharArray();
        for(int i = 0; i < resultChar.length; i++)
            if(resultChar[i] >= 'A' && resultChar[i] <= 'Z')
                resultChar[i] = this.alphabetArr[(resultChar[i] - 'A' - k + 26) % 26];
        return new String(resultChar);
    }

    public String readTextFile(String url) throws IOException {
        // FileInputStream file = new FileInputStream(url);
        String result = "";
        // for(byte chCode : file.read)
        //     result += (char) chCode;
        // file.close();
        return result;
    }

    public void writeTextFile(String url, String content) throws IOException {
        FileOutputStream file = new FileOutputStream(url);
        file.write(content.getBytes());
        file.close();
    }

    public static void main(String[] args) throws IOException {
        MyCaesarCipher cipher = new MyCaesarCipher(3);
        System.out.println(cipher.encrypt("WELL; WELL"));
        System.out.println(cipher.decrypt("C"));
        String readedText = cipher.readTextFile("src/EX2/Text_File/input.txt");
        System.out.println(readedText);
        cipher.writeTextFile("src/EX2/Text_File/output.txt", cipher.decrypt(readedText));
    }
}
