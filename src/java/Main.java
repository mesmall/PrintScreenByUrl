package java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        Runtime rt = Runtime.getRuntime();

        String exec = "/usr/local/phantomjs-2.1.1-macosx/bin/phantomjs /var/root/jsLocal/webpage.js";
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
