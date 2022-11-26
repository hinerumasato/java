package Array.EX2;

public class CeasarCipherTeacher {
    protected char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'M', 'W', 'X', 'Y', 'Z' };
    private int k;
    public CeasarCipherTeacher(int k) {
        this.k = k;
    }

    public int getIndex(char c) {
        for(int i = 0; i < k; i++) {
            if(this.alphabet[i] == c)
                return i;
        }
        return -1;
    }

    private char encryptPerChar(char c) {
        int p = getIndex(c);
        int decryptC = (p + k) % 26;
        return alphabet[decryptC];
    }

    private char decryptPerChar(char encryptC) {
        int c = getIndex(encryptC);
        int decryptC = (c - k + 26) % 26;
        return alphabet[decryptC];
    }

    public String encrypt(String input) {
        char[] msg = isTransformDecrypt(input, true);
        return new String(msg);
    }

    public String decrypt(String input) {
        char[] msg = isTransformDecrypt(input, false);
        return new String(msg);
    }

    private char[] isTransformDecrypt(String input, boolean isEncrypt) {
        char[] msg = input.toCharArray();
        for(int i = 0; i < msg.length; i++) {
            if(Character.isUpperCase(msg[i])) {
                if(isEncrypt) {
                    msg[i] = encryptPerChar(msg[i]);
                } else {
                    msg[i] = decryptPerChar(msg[i]);
                }
            }
        }
        return msg;
    }

    public static void main(String[] args) {
        CeasarCipherTeacher ceasarCipherTeacher = new CeasarCipherTeacher(5);
        System.out.println(ceasarCipherTeacher.encrypt("WELL"));
    }
    
}
