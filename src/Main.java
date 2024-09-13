import java.util.Scanner;

public class Main {
    private static final char[] litters = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z'
    };
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final StringBuilder BUILDER = new StringBuilder();

    public static void main(String[] args) {
        printScan();
    }

    public static void printScan() {
        System.out.println("Enter number 1 (Encrypt) or 2 (Decrypt): ");
        int number = SCANNER.nextInt();
        SCANNER.nextLine();

        switch (number) {
            case 1 -> {
                encrypterText(BUILDER, litters);
                printScan();
            }
            case 2 -> {
                decrypterText(BUILDER, litters);
                printScan();
            }
            case 3 -> System.out.println(0);
            default -> System.out.println("Invalid option. Try again.");
        }
    }

    public static void decrypterText(StringBuilder BUILDER, char[] litters) {
        System.out.println("Enter shift (index): ");
        int count = SCANNER.nextInt();

        String encryptedText = BUILDER.toString();
        BUILDER.setLength(0);

        for (int i = 0; i < encryptedText.length(); i++) {
            int index = new String(litters).indexOf(encryptedText.charAt(i));
            if (index != -1) { // Перевіряємо, чи символ є в масиві litters
                int newIndex = (index - count) % litters.length;
                if (newIndex < 0) {
                    newIndex += litters.length; // Виправлення для негативних індексів
                }
                BUILDER.append(litters[newIndex]);
            } else {
                BUILDER.append(encryptedText.charAt(i)); // Якщо символ не знайдено, додаємо його без змін
            }
        }

        System.out.println("Decrypted text: " + BUILDER);
    }

    public static void encrypterText(StringBuilder BUILDER, char[] litters) {
        BUILDER.setLength(0);

        System.out.println("Enter a string: ");
        String text = SCANNER.nextLine();
        System.out.println("Enter shift (index): ");
        int count = SCANNER.nextInt();

        for (int i = 0; i < text.length(); i++) {
            int index = new String(litters).indexOf(text.charAt(i));
            if (index != -1) { // Перевіряємо, чи символ є в масиві litters
                int newIndex = (index + count) % litters.length;
                BUILDER.append(litters[newIndex]);
            } else {
                BUILDER.append(text.charAt(i)); // Якщо символ не знайдено, додаємо його без змін
            }
        }

        System.out.println("Encrypted text: " + BUILDER);
    }
}
