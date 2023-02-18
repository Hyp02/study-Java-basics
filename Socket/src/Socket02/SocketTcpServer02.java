package Socket02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTcpServer02 {
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
        InputStream inputStream = socket.getInputStream();
        int lean;
        byte[] bytes = new byte[1024];
        while((lean = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,lean));
        }
        //将信息通过通道发送
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，我是服务端~~".getBytes());
        //发送消息完成后设置结束标志
        socket.shutdownOutput();
        //关闭流操作
        outputStream.close();
        inputStream.close();
        socket.close();

    }
}
