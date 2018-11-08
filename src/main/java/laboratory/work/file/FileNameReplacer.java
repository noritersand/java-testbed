package laboratory.work.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileNameReplacer {
	private static final Logger logger = LoggerFactory.getLogger(FileNameReplacer.class);
	
    private static final String targetLocation = "c:/dev/temp/target";
    private static final String prefix = "02-alarm-";
    private static final String suffix = "";
    private static final String destLocation = "c:/dev/temp/result";

    public static void main(String[] args) throws Exception {
        Path path = new File(targetLocation).toPath();
        Stream<Path> list = Files.list(path);

        // list.forEach(System.out::println);

        File newPathParent = new File(destLocation);
        if (!newPathParent.exists()) {
        	newPathParent.mkdirs();
        }
        
        list.forEach((k) -> {
            final String fileName = k.toString();
            final String newFileName = prefix
                    + fileName.substring(fileName.lastIndexOf(File.separator) + 1)
                    + suffix;
            Path newPath = new File(destLocation, newFileName).toPath();
            
            // logging
            logger.debug("{} -> {}", k.toString(), newPath.toString());
            
            try {
                Files.move(k, newPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println(e);
                System.exit(0);
            }
        });

        list.close();
    }
}