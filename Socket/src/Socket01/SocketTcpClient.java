package Socket01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTcpClient {
    public static void main(String[] args) throws IOException {
        //连接服务端的 IP 和 端口
        //如果连s接成功，返回Socket对象
        System.out.println("等待连接~~");
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        //获取OutPutStream对象 输出信息
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("客户端已连接到服务端 "+socket.getClass());
        outputStream.write("你好服务端~~".getBytes());
        //最后记得关闭流
        socket.close();
        outputStream.close();

    }
}
