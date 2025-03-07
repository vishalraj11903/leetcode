package amzn;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileFinder {

    // Interface File (Provided)
    public interface File {
        boolean isDirectory(); // returns true if the given file is a directory
        String getName(); // returns relative name of the file including extension
        long getLength(); // returns file size in bytes
        Date getLastModified(); // returns last modified date for the file
        File[] listFiles(); // returns array of files if the current file is a directory
    }

    // The findFiles method to find files based on extension and/or modified date
    public static List<File> findFiles(File directory, String extension, Date modifiedBefore, Date modifiedAfter) {
        List<File> matchingFiles = new ArrayList<>();

        // Check if the directory is valid
        if (directory == null || !directory.isDirectory()) {
            return matchingFiles;
        }

        // Get all files in the directory
        File[] files = directory.listFiles();
        if (files == null) {
            return matchingFiles;
        }

        // Loop through the files in the directory
        for (File file : files) {
            // Check if file matches the extension
            boolean matchesExtension = (extension == null || file.getName().endsWith(extension));

            // Check if file matches the modifiedBefore date
            boolean matchesModifiedBefore = (modifiedBefore == null || file.getLastModified().before(modifiedBefore));

            // Check if file matches the modifiedAfter date
            boolean matchesModifiedAfter = (modifiedAfter == null || file.getLastModified().after(modifiedAfter));

            // If the file matches all criteria, add it to the result list
            if (matchesExtension && matchesModifiedBefore && matchesModifiedAfter) {
                matchingFiles.add(file);
            }

            // If the file is a directory, recurse into it
            if (file.isDirectory()) {
                matchingFiles.addAll(findFiles(file, extension, modifiedBefore, modifiedAfter));
            }
        }

        return matchingFiles;
    }

    // Example usage
    public static void main(String[] args) {
        // Example usage: Assuming `directory` is an instance of File (a directory)
      /*  File directory = new File("//path//to//directory"); // Replace with actual directory path

        // Example search criteria
        String extension = ".txt";
        Date modifiedBefore = new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24); // 1 day ago
        Date modifiedAfter = new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 48); // 2 days ago

        List<File> resultFiles = findFiles(directory, extension, modifiedBefore, modifiedAfter);

        // Print the results
        for (File file : resultFiles) {
            System.out.println("Found file: " + file.getName());
        }*/
    }
}
