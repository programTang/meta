package org.tj.meta.base.project.zhishi;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by 001 on 16/12/28.
 */
public class AppMain {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String decode = URLDecoder.decode("http://news.baidu.com/ns?from=news&cl=2&bt=1483977600&y0=2017&m0=1&d0=10&y1=2017&m1=1&d1=10&et=1484063999&q1=%B9%FA%B7%C0%B4%F3%D1%A7&submit=%B0%D9%B6%C8%D2%BB%CF%C2&q3=&q4=&mt=24&lm=&s=2&begin_date=2017-1-10&end_date=2017-1-10&tn=newsdy&ct1=1&ct=1&rn=50&q6=",
                "GBK");
        System.out.println(decode);
    }
}
