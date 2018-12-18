package ru.javawebinar.basejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class MainFile {

    public static void main(String[] args) throws IOException {
  /*      File file = new File(".");
        System.out.println(file.getCanonicalPath());

        File dir = new File(".\\src\\ru\\javawebinar\\basejava");
        System.out.println(dir.getCanonicalPath());

        System.out.println(dir.isDirectory());
        if (dir.list() != null) {
            for (String name : Objects.requireNonNull(dir.list())) {
                System.out.println(name);
            }
        }*/

        String filePath = ".\\.gitignore";
        System.out.println(new File(filePath).exists());
        FileInputStream fis = new FileInputStream(filePath);
        System.out.println(fis.read());

        String rootCatalog = ".\\storage";
        System.out.println(new File(rootCatalog).getCanonicalPath());
        File f = new File(rootCatalog);
        Path p = f.toPath();
        System.out.println(p.getFileName());
        System.out.println(f.getCanonicalPath());

//        printDirectory(".");

    }

    public static void printDirectory(String dirPath)  {
        File dir = new File(dirPath);

        File[] files = dir.listFiles();
        if (files == null) {
            throw new RuntimeException("This is not directory");
        }

        for (File f : files) {

            String canonicalPath = null;
            try {
                canonicalPath = f.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (f.isDirectory()) {
                printDirectory(canonicalPath);
            } else {
                System.out.println(canonicalPath);
            }
        }

    }
}
