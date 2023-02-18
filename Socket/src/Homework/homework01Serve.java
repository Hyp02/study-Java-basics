package Homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * (1)使用字符流的方式，编写一个客户端程序和服务器端程序，
 * (2)客户端发送"name",服务器端接收到后，返回"我是nova ", nova是你自己的名字.
 * (3)客户端发送"hobby",服务器端接收到后，返回"编写java程序"
 * (4)不是这两个问题，回复“你说啥呢"
 **/
public class homework01Serve {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端等待连接~~~");
        ServerSocket server = new ServerSocket(6666);
        Socket socket = server.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String question = br.readLine();
        String answer;
        if("name".equals(question)){
            System.out.println("已经收到问题 "+"（"+question+")");
            answer="韩永鹏";

        }else if("hobby".equals(question)){
            System.out.println("已经收到问题 "+"（"+question+")");
            answer="Java编程";
        }else{
            answer = "你说啥子";
        }
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(answer);
        bw.newLine();

        bw.close();
        br.close();
        server.close();
        socket.close();

    }

}
