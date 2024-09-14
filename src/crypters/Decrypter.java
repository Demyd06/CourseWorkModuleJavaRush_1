package crypters;

import constants.Language;

public class Decrypter {
    public String Decrypt(String input, int key) {
        StringBuilder decryptBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(Language.ENGLISH.contains(ch)) {
                int index = Language.ENGLISH.indexOf(ch);
                int newIndex = (index - key) % Language.ENGLISH.size();

                if(newIndex < 0){
                    newIndex += Language.ENGLISH.size();
                }

                decryptBuilder.append(Language.ENGLISH.get(newIndex));
            }else{
                decryptBuilder.append(ch);
            }
        }

        return decryptBuilder.toString();
    }
}
