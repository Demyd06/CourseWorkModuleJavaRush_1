package crypters;

import constants.Language;

public class Encrypter {
    public String Encrypter(String input, int key){
        StringBuilder encryptedBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Language.english.contains(currentChar)) {
                int index = Language.english.indexOf(currentChar);
                int newIndex = (index + key) % Language.english.size(); // Додаємо зсув для шифрування
                encryptedBuilder.append(Language.english.get(newIndex));
            } else {
                encryptedBuilder.append(currentChar); // Якщо символ не в списку, додаємо його без змін
            }
        }
        return encryptedBuilder.toString();
    }
}
