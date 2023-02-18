package Socket04;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {


        System.out.println("服务端等待连接~~");
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = serverSocket.accept();
        System.out.println("服务端已经和客户端连接~~");

        //服务端接收数据
        InputStream inputStream = socket.getInputStream();
        //几首图片到指定位置
        String newPath = "src\\111.jpg";
        //利用先写好的工具类 将文件以字节数组的形式从通道中保存
        byte[] byteArray = StreamUtils.getByteArray(inputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(newPath);
        fileOutputStream.write(byteArray);
        fileOutputStream.close();
        /**
         * 利用字节输入输出流 存放到  "src\\111.jpg" 中
         */
//        int lean;
//        byte[] bytes = new byte[1024];
//        while((lean = inputStream.read(bytes))!=-1){
//            fileOutputStream.write(bytes);
//        }

        //读取发送成功消息
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("图片已获取成功~~");
        bw.newLine();//字符流传输结束标志
        bw.close();

//        //给客户端发送接收成功提醒
//        OutputStream outputStream = socket.getOutputStream();
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
//        bw.write("服务端已收到数据~~");
//        bw.newLine();
//        bw.flush();

        //关闭流
        socket.close();
        inputStream.close();
//      outputStream.close();
//       bw.close();
        serverSocket.close();

    }
}
