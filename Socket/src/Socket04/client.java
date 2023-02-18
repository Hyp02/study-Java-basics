package Socket04;

import javax.imageio.IIOException;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        //创建客户端
        System.out.println("等待连接~~");
        Socket socket = new Socket(InetAddress.getLocalHost(), 6666);
        InputStream inputStream = socket.getInputStream();
        System.out.println("客户端已和服务端连接~~");

        //
        String OldPath = "E:\\123123.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(OldPath));

        //将文件保存到字节数组中
        byte[] byteArray = StreamUtils.getByteArray(bis);
        //发送图片
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(byteArray);
        bis.close();
        socket.shutdownOutput();//发送结束标志

        //bos.write("发送成功".getBytes());

        /**
         * 这是根据字节输入输出流 从文件的存储路径发送到
         * 通道中
         */
//        byte[] bytes = new byte[1024];
//        int lean;
//        while((lean = fileInputStream.read(bytes))!=-1){
//           outputStream.write(bytes,0,lean);
//        }
//        socket.shutdownOutput();


        //发送发送成功消息
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        bw.write("已发送成功~~~");
//        bw.newLine();
//        bw.flush();
//        bos.close();
//        //接收返回消息
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);


        socket.close();
        //inputStream.close();
        br.close();




    }
}
