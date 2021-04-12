package jdk8.jdknio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * description: MyNioClient <br>
 * date: 2021/4/12 下午1:35 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MyNioClient {

    private int size = 1024;
    private SocketChannel socketChannel;
    private ByteBuffer byteBuffer;

    public void connectServer() throws IOException {
        //创建channel
        socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",8888));

        socketChannel.configureBlocking(false);
        byteBuffer = ByteBuffer.allocate(size);
        receive();

    }

    private void receive() throws IOException {
        while(true){
            byteBuffer.clear();
            int count;
            while((count = socketChannel.read(byteBuffer)) > 0){
                //缓冲区写模式切换为读模式
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    System.out.print((char) byteBuffer.get());
                }
                send2Server("hello server".getBytes());
                byteBuffer.clear();
            }

        }

    }

    private void send2Server(byte[] bytes) throws IOException {
        byteBuffer.clear();

        byteBuffer.put(bytes);

        byteBuffer.flip();

        socketChannel.write(byteBuffer);
    }

    public static void main(String[] args) {
        try {
            MyNioClient myNioClient = new MyNioClient();
            myNioClient.connectServer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
