import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    static String defPath = "F:\\JAVA_Proj\\FilesTask1\\Games\\"; // путь к папке Games

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(10);
        list1.add(0, defPath + "savegames\\");
        list1.add(1, defPath + "src\\test\\");
        list1.add(2, defPath + "src\\main\\");
        list1.add(3, "Main.java");
        list1.add(4, "Utils.java");
        list1.add(5, defPath + "res\\drawables\\");
        list1.add(6, defPath + "res\\vectors\\");
        list1.add(7, defPath + "res\\icons\\");
        list1.add(8, defPath + "temp\\");
        list1.add(9, "temp.txt");

        StringBuilder logFile = new StringBuilder("Журнал создания фалов и папок");

        Iterator<String> it = list1.iterator();
        String pathName1 = "", pathName2 = "";

        while (it.hasNext()) {
            pathName1 = it.next();
            File file = new File(pathName1);

            logFile.append(System.lineSeparator() + "создание ");
            if (pathName1.contains(".")) {
                File file1 = new File(pathName2, pathName1);

                logFile.append("файла " + pathName1 + ": ");
                try {
                    logFile.append(file1.createNewFile());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                logFile.append("папки " + pathName1 + ": ");
                logFile.append(file.mkdir() ? file.exists() : file.mkdirs());
                pathName2 = pathName1;
            }
        }

        try (BufferedWriter logFileWriter = new BufferedWriter(
                new FileWriter(list1.get(8) + list1.get(9)))) {

            logFileWriter.write(logFile.toString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}



