package jdk8.jdknio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * description: MyNioServer <br>
 * date: 2021/4/12 上午9:19 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MyNioServer {

    private int size = 1024;
    private ServerSocketChannel serverSocketChannel;
    private ByteBuffer byteBuffer;
    private Selector selector;
    private int remoteClientNumber = 0;

    //我们需要一个初始化入口
    public MyNioServer(int port){
        try {
            initChannel(port);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
    //调用初始化函数
    private void initChannel(int port) throws Exception{
        //创建一个channel
        serverSocketChannel = ServerSocketChannel.open();
        //设置channel为非阻塞
        serverSocketChannel.configureBlocking(false);
        //channel绑定端口
        serverSocketChannel.bind(new InetSocketAddress(port));

        System.out.println("listener on port : " + port);

        //创建选择器
        selector = Selector.open();
        //向选择器中注册通道
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //分配缓冲区
        byteBuffer = ByteBuffer.allocate(size);

    }

    //监听函数：监听channel上数据的变化
    private void listener() throws Exception {

        while (true){
            //返回的值表示这个选择器中有多少个channel处于就绪状态
            int count = selector.select();
            if(count == 0){
                continue;
            }
            //每一个channel在selector中对应一个key，获取selector中所有的key
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                //循环处理每一个channel
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    //获取该key对应的channel
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    //channel接收连接
                    SocketChannel channel = server.accept();
                    //channel注册
                    registerChannel(selector,channel,SelectionKey.OP_READ);
                    //记录链接成功的客户端数量
                    remoteClientNumber++;
                    System.out.println("online client number : " + remoteClientNumber);
                    //服务端写入数据，传输到客户端
                    write(channel,"hello client".getBytes());
                }
                //如果通道处于就绪状态
                if(key.isReadable()){
                    read(key);
                }
                iterator.remove();

            }

        }
    }

    private void write(SocketChannel channel, byte[] bytes) throws Exception {

        byteBuffer.clear();
        //将要发送的数据放到缓冲区中
        byteBuffer.put(bytes);
        //缓冲区从写模式切换为读模式
        byteBuffer.flip();
        //channel永远操作的数据都是缓冲区
        channel.write(byteBuffer);


    }

    private void read(SelectionKey key) throws IOException {

        SocketChannel channel = (SocketChannel) key.channel();
        int count;
        byteBuffer.clear();
        //从通道中读取数据放到缓存区中
        if((count = channel.read(byteBuffer)) > 0){
            //将缓冲区从写模式切换为读模式
            byteBuffer.flip();
            while( byteBuffer.hasRemaining()){
                System.out.print((char) byteBuffer.get());
            }
            System.out.println();
            byteBuffer.clear();
        }

        if(count < 0){
            channel.close();
        }

    }

    private void registerChannel(Selector selector, SocketChannel channel, int opRead) throws IOException {

        if(channel == null){
            return;
        }
        channel.configureBlocking(false);
        channel.register(selector,opRead);
    }

    public static void main(String[] args) {
        try{
            MyNioServer myNioServer = new MyNioServer(8888);
            myNioServer.listener();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
