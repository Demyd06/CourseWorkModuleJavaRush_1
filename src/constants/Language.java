package constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Language {
   public static final ArrayList<Character> ENGLISH = new ArrayList<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z'
    ));
    public static final ArrayList<Character> UKRAINIAN = new ArrayList<>(Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф',
            'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я', 'а', 'б', 'в', 'г',
            'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'й', 'к', 'л', 'м',
            'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш',
            'щ', 'ь', 'ю', 'я'
    ));
    public static final List<String> COMMON_ENGLISH_WORDS = Arrays.asList(
            "the", "and", "is", "in", "with", "to", "of", "on", "for", "a", "at", "as", "that", "it"
    );
    public static final List<String> COMMON_UKRAINIAN_WORDS = Arrays.asList(
            "і", "та", "це", "в", "на", "з", "до", "у", "як", "що", "не", "так", "але"
    );
}
