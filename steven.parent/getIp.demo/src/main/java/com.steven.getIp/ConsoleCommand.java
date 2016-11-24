package com.steven.getIp;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by kira7 on 2016/11/22 0022.
 */
@Component
public class ConsoleCommand {
    public String executeConsole() throws IOException, InterruptedException {
        Runtime run = Runtime.getRuntime();
//		Process process = run.exec("cmd.exe /k ipconfig");
        Process process = run.exec("tracert www.baidu.com");
        InputStream in = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(in,"GBK");
        BufferedReader br = new BufferedReader(isr);
        String article = "";
        String line;
        while ((line =br.readLine())!=null){
            System.out.println(line);
            article += line + "\n";
        }
        //String regex = "IPv4 地址\d+";
        in.close();
        process.waitFor();
	    return article;
    }


}
