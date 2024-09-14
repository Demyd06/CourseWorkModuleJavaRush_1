package files;

import constants.Commands;
import java.nio.file.Path;

public class Options {
    private final Commands Command;
    private final Path filePath;
    private final Integer key;

    public Options(Commands Command, Path filePath, Integer key) {
        this.Command = Command;
        this.filePath = filePath;
        this.key = key;
    }

    public Commands getCommand() {
        return Command;
    }
    public Path getFilePath() {
        return filePath;
    }
    public Integer getKey() {
        return key;
    }

}
