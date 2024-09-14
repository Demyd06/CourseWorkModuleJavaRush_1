import chekedCommands.CommandsParser;
import constants.Commands;
import crypters.Bruteforce;
import crypters.Decrypter;
import crypters.Encrypter;
import files.FileManager;
import files.Options;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Bruteforce bruteforce = new Bruteforce();
        Encrypter enc = new Encrypter();
        Decrypter dec = new Decrypter();
        FileManager fm = new FileManager();
        CommandsParser commandsParser = new CommandsParser();
        Options options = commandsParser.parse(args);

        try {
            if (options.getCommand() == Commands.ENCRYPT) {
                String content = fm.read(options.getFilePath());
                String encryptedContent = enc.Encrypter(content, options.getKey());
                String fileName = options.getFilePath().getFileName().toString();
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [ENCRYPTED].txt";

                Path newFilePath = options.getFilePath().resolveSibling(newFileName);
                fm.write(newFilePath, encryptedContent);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } try {
            if (options.getCommand() == Commands.DECRYPT) {
                String content = fm.read(options.getFilePath());
                String decryptedContent = dec.Decrypt(content, options.getKey());
                String fileName = options.getFilePath().getFileName().toString();
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [DECRYPTED].txt";

                Path newFilePath = options.getFilePath().resolveSibling(newFileName);
                fm.write(newFilePath, decryptedContent);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } try {
            if (options.getCommand() == Commands.BRUTEFORCE) {
                String content = fm.read(options.getFilePath());
                String BruteForceContent = bruteforce.BruteForceDecrypted(content);
                String fileName = options.getFilePath().getFileName().toString();
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [BRUTEFORCE].txt";

                Path newFilePath = options.getFilePath().resolveSibling(newFileName);
                fm.write(newFilePath, BruteForceContent);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
