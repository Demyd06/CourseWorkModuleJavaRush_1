package crypters;

import constants.Language;

import java.util.ArrayList;

public class Encrypter {
    public String Encrypter(String input, int key, ArrayList<Character> language){
        StringBuilder encryptedBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (language.contains(currentChar)) {
                int index = language.indexOf(currentChar);
                int newIndex = (index + key) % language.size();
                encryptedBuilder.append(language.get(newIndex));
            } else {
                encryptedBuilder.append(currentChar);
            }
        }
        return encryptedBuilder.toString();
    }
}
