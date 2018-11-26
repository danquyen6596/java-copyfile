package vn.codegym.QuyenLeSy;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input source: ");
        String s = scanner.nextLine();
        File fileIn = GetFile(s);

        System.out.println("Input disk: ");
        s = scanner.nextLine();
        CreateFile(s);
        File fileOut = GetFile(s);

        ReadWriteFile(fileIn, fileOut);

    }

    public static void CreateFile(String source) {
        try {

            File file = new File(source);
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File is exits!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File GetFile(String disk) {
        File f = new File(disk);
        if (f.isFile()) {
            System.out.println("Select file success!");
        } else {
            System.out.println("File is not exist!");
        }
        return f;
    }



    public static void ReadWriteFile(File fileIn, File fileOut) {
        try {
            FileReader fileReader = new FileReader(fileIn);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(fileOut);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
            }

            bufferedReader.close();
            bufferedWriter.close();
            System.out.println("Write file success!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
