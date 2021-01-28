package homework1;

import java.io.*;

/**
 * 王金宇
 * 2020/10/26 0026
 */
public class Test3 {
    public static void main(String[] args) {

    }

    public static void copyFolder(String srcFolder,String destFolder){
        File srcDir = new File(srcFolder);
        if (!srcDir.exists()){
            System.out.println(srcFolder + "源文件不存在，不需要复制");
            return;
        }

        File destDir = new File(destFolder);
        if (!destDir.exists()){
            destDir.mkdirs();
        }

        File[] listFiles = srcDir.listFiles();
        if (listFiles != null){
            for (File file : listFiles) {
                File destFile = new File(destFolder,file.getName());
                if (file.isFile()){
                    copyFile(file,destFile);
                }else{
                    copyFolder(file.getAbsolutePath(), destFile.getAbsolutePath());
                }
            }
        }
    }

    public static void copyFile(File srcFile, File destFile){
        try(
                FileInputStream fis = new FileInputStream(srcFile);
                FileOutputStream fos = new FileOutputStream(destFile);
                ) {
            byte[] bytes = new byte[1024*8];
            int read = fis.read(bytes);
            while (read != -1){
                fos.write(bytes,0,read);
                read = fis.read(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
