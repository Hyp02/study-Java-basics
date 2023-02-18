package Socket03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTcpServer03 {
    public static void main(String[] args) throws IOException {
        //服务端
        //在服务端9999端口处监听，如果没有连接 继续等待连接
        //要求本机没有其他服务在监听9999端口
        //这个ServerSocket可以通过 accept返回多个socket【多个客户端连接服务端的并发】
        System.out.println("服务端等待连接~~");
        ServerSocket serversocket = new ServerSocket(9999);
        //当没有服务监听9999端口时，程序阻塞，等待连接
        //如果有服务连接 返回Socket对象
        Socket socket = serversocket.accept();
        System.out.println("服务端已连接到客户端 "+serversocket.getClass());
        System.out.println("======服务端读入客户端信息====");


        //根据字符流读取信息
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s ;
        s = br.readLine();
        System.out.println(s);

        //将信息通过通道发送
        OutputStream outputStream = socket.getOutputStream();
        //字符流发送信息
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("你好，我是服务端~~（字符流）");
        bw.newLine();//按行读取的结束标志
        bw.flush();
        //关闭流操作
        bw.close();
        br.close();
        socket.close();

    }
}
