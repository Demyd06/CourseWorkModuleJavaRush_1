package chekedCommands;

import constants.Commands;
import files.Options;

import java.nio.file.Path;


public class CommandsParser {
    public static Options parse(String[] args) {
        Commands command = null;
        Integer key = null;
        Path file = null;

        return checked(command, file, key, args);
    }
    private static Options checked(Commands command, Path filePath, Integer key, String [] args){
        for (int index = 0; index < args.length; index++) {
            String arg = args[index];

            switch (arg) {
                case "-e" -> command = Commands.ENCRYPT;
                case "-d" -> command = Commands.DECRYPT;
                case "-bf" -> command = Commands.BRUTEFORCE;
                case "-k" -> {
                    if (index + 1 < args.length) {
                        key = Integer.parseInt(args[++index]);
                    } else {
                        throw new IllegalArgumentException("Missing value for key");
                    }
                }
                case "-f" -> {
                    if (index + 1 < args.length) {
                        filePath = Path.of(args[++index]);
                    } else {
                        throw new IllegalArgumentException("Missing value for file");
                    }
                }
                default -> throw new IllegalArgumentException("Unknown argument: " + arg);
            }
        }

        if (command == null) {throw new IllegalArgumentException("Command (-e, -d, or -bf) is required");}

        if (key == null && (command == Commands.DECRYPT || command == Commands.ENCRYPT)) {throw new IllegalArgumentException("Key is required for encrypt or decrypt mode");}
        if(key != null && key < 0){throw new IndexOutOfBoundsException("Key must be positive");}
        if (filePath == null) {throw new IllegalArgumentException("File path is required");}

        return new Options(command, filePath, key);
    }


}
