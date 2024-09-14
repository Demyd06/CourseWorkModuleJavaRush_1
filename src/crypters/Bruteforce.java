package crypters;

import constants.CommonWords;
import constants.Language;

public class Bruteforce {
    private int BruteForceKey;

    public String BruteForceDecrypted(String input) {
        StringBuilder bruteForceBuilder = new StringBuilder();
        Decrypter decrypter = new Decrypter();
        String bestMatch = "";
        int bestScore = 0;

        for (int key = 1; key <= Language.ENGLISH.size(); key++) {
            String decrypted = decrypter.Decrypt(input, key);
            int score = countCommonWords(decrypted);

            // Якщо текст має більше типових слів, запам'ятовуємо його як найкращий варіант
            if (score > bestScore) {
                bestScore = score;
                bestMatch = decrypted;
                setBruteForceKey(key);
            }
        }

        bruteForceBuilder.append(bestMatch);
        return bruteForceBuilder.toString();

    }
    private int countCommonWords(String text) {
        int count = 0;
        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) {
            if (CommonWords.COMMON_ENGLISH_WORDS.contains(word)) {
                count++;
            }
        }
        return count;
    }

    public int getBruteForceKey() {return BruteForceKey;}
    public void setBruteForceKey(int bruteForceKey) {BruteForceKey = bruteForceKey;}
}
