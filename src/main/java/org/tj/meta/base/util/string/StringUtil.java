package org.tj.meta.base.util.string;

/**
 * Created by 001 on 16/12/15.
 */
public class StringUtil {

    public static String reserval(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=chars.length-1;i>=0;i--){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
