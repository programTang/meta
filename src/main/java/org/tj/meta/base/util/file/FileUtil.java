package org.tj.meta.base.util.file;

import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.IOException;

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


    public static void main(String[] args) throws IOException {

//        boolean success =
//        System.out.println("".charAt(0));
//        File file = new File("/Users/Jia/Downloads/index.html");
//        System.out.println(file.isDirectory());
//        HtmlConverter.convertToPdf(
//                file,
//                new File("/Users/Jia/Downloads/test.pdf"));



        long n = 8;
        long sum = 0;
        long max = n/5;

        System.out.println(max);
        for (long j = 0; j< max; j++ ){
            sum += Math.pow(2, j);
        }
        System.out.println(sum);
    }
}
