package crypters;

import constants.Language;

public class Bruteforce {
    public String BruteForceDecrypted(String input) {
        StringBuilder bruteForceBuilder = new StringBuilder();
        Decrypter decrypter = new Decrypter();
        for (int key = 1; key <= Language.english.size(); key++) {
            String decrypted = decrypter.Decrypt(input,key);

            if(decrypted.contains("the") || decrypted.contains("with")) {
                bruteForceBuilder.append(decrypted);
            }
        }
        return bruteForceBuilder.toString();
    }
}
