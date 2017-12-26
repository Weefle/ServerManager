package fr.weefle.servermanager.servers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesUtils {

    public void copyFolder(File source, File destination){

        try {
            Files.walk(source.toPath()).forEach(path -> {
                try {
                    Files.copy(path, source.toPath().resolve(destination.toPath().relativize(path)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteFolder(File source){
        try {
            Files.walk(source.toPath()).filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
