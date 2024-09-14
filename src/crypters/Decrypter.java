package crypters;

import constants.Language;

public class Decrypter {
    public String Decrypt(String input, int key) {
        StringBuilder decryptBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(Language.english.contains(ch)) {
                int index = Language.english.indexOf(ch);
                int newIndex = (index - key) % Language.english.size();

                if(newIndex < 0){
                    newIndex += Language.english.size();
                }

                decryptBuilder.append(Language.english.get(newIndex));
            }else{
                decryptBuilder.append(ch);
            }
        }

        return decryptBuilder.toString();
    }
}
