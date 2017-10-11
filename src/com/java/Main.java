package com.java;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        File directory = new File("");//设定为当前文件夹
        String path = directory.getAbsolutePath()+"/src/phantomjs/webpage.js";//获取绝对路径
        Runtime rt = Runtime.getRuntime();
        String exec = "/usr/local/phantomjs-2.1.1-macosx/bin/phantomjs "+path;
        String urls [] ={
                "http://www.baidu.com"
        };
        String time ="";
        for (String url:urls) {
            time = String.valueOf(System.currentTimeMillis());
            Process p = rt.exec(exec+" "+url+" "+time);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sbf = new StringBuffer();
            String tmp = "";
            while((tmp = br.readLine())!=null){
                sbf.append(tmp);
                System.out.println(tmp);
            }
            System.out.println(sbf.toString());
        }
        return ;
    }
}
