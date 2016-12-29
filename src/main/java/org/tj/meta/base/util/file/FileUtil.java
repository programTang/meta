package org.tj.meta.base.util.file;

import java.io.File;

/**
 * Created by 001 on 16/12/22.
 */
public class FileUtil {

    static int i = 0;
//    static int size = 0;
    /**
     * 递归列出所有目录下所有的文件
     * @param file 文件
     */
    public static void listAllFiles(int size,File file){
        i++;
        if (file.isFile()){
            size = (int) (size + (file.length()/1024));
            System.out.println((file.length()/1024)+" 文件："+i+getSpace(i)+file.getName());
            i--;
        }else {
            File[] files = file.listFiles();
            int size1 = 0;
            for (int i = 0,j = files.length; i < j; i++) {
                listAllFiles(size1,files[i]);
            }
            i--;
            System.out.println(size1+" 目录："+i+getSpace(i)+file.getName());
        }
    }

    static String getSpace(int i){
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append("   ");
        }
        return sb.toString();
    }


//    public static void main(String[] args) {
////        listAllFiles(new File("/Users/fahai/Documents/Axure"));
////        OutputStreamWriter
//    }
}
