package Socket03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTcpClient03 {
    public static void main(String[] args) throws IOException {
        //连接服务端的 IP 和 端口
        //如果连接成功，返回Socket对象
        System.out.println("客户端等待连接~~");
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        //获取OutPutStream对象 将信息通过通道发送
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("客户端已连接到服务端 "+socket.getClass());

        //字符流发送信息
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("你好服务端~~（字符流）");
        bw.newLine();
        bw.flush();


        //读取服务端传过来的数据
        System.out.println("====客户端读入 服务端信息====");
        InputStream inputStream = socket.getInputStream();

        //字符流读取
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        s = br.readLine();
        System.out.println(s);

        //最后记得关闭流
        bw.close();
        br.close();
        socket.close();

    }
}
