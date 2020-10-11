package lwh.other;

import java.io.*;

/**
 * 读取代码行数
 */
public class CodeLineCountUtil {

    private static int count = 0;

    public static void main(String[] args) {
        String path = "D:\\Test";
        File file = new File(path);
        int lineCount = getLineCountOfCode(file);
        System.out.println(lineCount);
    }

    private static int getLineCountOfCode(File file) {
        if (file.isFile()) {
            count += getFileCount(file);
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                getLineCountOfCode(f);
            }
        }
        return count;
    }

    public static int getFileCount(File file) {
        int num = 0;
        String name = file.getName();
        if (name != null) {
            if (name.contains("jsp")) {
                return num;
            }
            if (name.endsWith(".java")) {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    while ((br.readLine()) != null) {
                        num++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("File " + name + " is count: " + num);
            }
        }
        return num;
    }
}
