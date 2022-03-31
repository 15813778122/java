package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        //URL统一资源定位符
        try {
            URL url = new URL("http://img1.baidu.com/it/u=3788606852,2363382091&fm=253&app=53&size=w500&n=0&g=0n&f=jpeg?sec=1646100575&t=a1ccbb9cd46cd043f6b4948422cc4a06");
            //打开完连接后返回的就是URLConnection,但是我们用的是http，所以我们要用它的子类HttpURLConnection
            HttpURLConnection conn = ((HttpURLConnection) url.openConnection());
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\HP\\Desktop\\fu.jpg"));
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = in.read(bytes))!=-1){
                out.write(bytes,0,len);
                out.flush();
            }
            out.close();
            in.close();
            System.out.println("下载完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
