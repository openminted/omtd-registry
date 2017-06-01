package eu.openminted.registry;

import org.apache.commons.io.FileDeleteStrategy;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestUnzip {

    private static final int BUFFER_SIZE = 4096;

    @Test
    public void unzipFolder() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        URL fileUrl = classLoader.getResource("corpus.zip");

        if (fileUrl == null) return;

        File inputFile = new File(fileUrl.getFile());

        String destDirectory = "tmpDirectory";

        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(inputFile));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }

        zipIn.close();

        if (destDir.listFiles() != null) {
            for (File file : destDir.listFiles()) {
                iterateThroughDirectories(file, file.getParent());
            }
        }
        System.out.println("Done");
    }


    private void iterateThroughDirectories(File file, String parent) throws IOException {
        if (file.getName().contains(".DS_Store")
                || file.getName().contains("__MACOSX")) {
            FileDeleteStrategy.FORCE.delete(file);
            return;
        }

        System.out.println(parent + File.separator + file.getName());

        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                iterateThroughDirectories(child, file.getName());
            }
        }
    }

    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}
