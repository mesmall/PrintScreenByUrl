package com.java;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        Runtime rt = Runtime.getRuntime();

        System.out.println("start虚拟机空闲内存："+rt.freeMemory());
        System.out.println("start虚拟机内存总量："+rt.totalMemory());
        System.out.println("start虚拟机空闲内存占比："+rt.freeMemory()*1.0/rt.totalMemory());


        File directory = new File("");//设定为当前文件夹
        String path = directory.getAbsolutePath()+"/src/phantomjs/webpage.js";//获取绝对路径
        String exec = "/usr/local/phantomjs-2.1.1-macosx/bin/phantomjs "+path;
        String urls [] ={
                "http://www.baidu.com"
        };
        String time ="";
        //for (String url:urls) {
        for (int i=0;i<100;i++) {
            time = String.valueOf(System.currentTimeMillis());
            Process p = rt.exec(exec+" "+urls[0]+" "+time);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sbf = new StringBuffer();
            String tmp = "";
            int count = 0;
            while((tmp = br.readLine())!=null){
                count++;
                sbf.append(tmp);
                if(tmp.contains("vrender:false"))
                    System.out.println("count:"+count+":"+tmp);
            }

            if(sbf.toString().contains("vrender:false"))
                System.out.println("sbf:"+sbf);
//          System.out.println(sbf.toString());
            is.close();
            sbf=null;
            p.destroy();
            if(p.isAlive()){
                p.destroyForcibly();
                System.out.println("再次销毁："+p.isAlive());
            }
        }
        directory=null;
        System.out.println("over虚拟机空闲内存："+rt.freeMemory());
        System.out.println("over虚拟机内存总量："+rt.totalMemory());
        System.out.println("over虚拟机空闲内存占比："+rt.freeMemory()*1.0/rt.totalMemory());
        return ;
    }
}
