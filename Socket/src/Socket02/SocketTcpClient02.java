package Socket02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTcpClient02 {
    public static void main(String[] args) throws IOException {
        //连接服务端的 IP 和 端口
        //如果连接成功，返回Socket对象
        System.out.println("客户端等待连接~~");
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        //获取OutPutStream对象 将信息通过通道发送
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("客户端已连接到服务端 "+socket.getClass());
        outputStream.write("你好服务端~~".getBytes());
        //设置发送消息的结束标志
        socket.shutdownOutput();
        //读取服务端传过来的数据
        System.out.println("====客户端读入服务端信息====");
        InputStream inputStream = socket.getInputStream();
        int lean;
        byte[] bytes = new byte[1024];
        // lean = inputStream.read(bytes);
        while((lean = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,lean));
        }

        //最后记得关闭流
        socket.close();
        outputStream.close();

    }
}
