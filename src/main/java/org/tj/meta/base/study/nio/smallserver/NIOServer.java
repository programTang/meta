package org.tj.meta.base.study.nio.smallserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 001 on 16/12/26.
 */
public class NIOServer {
    int flag = 0;
    private final int BLOCK = 1024;
    /*接受数据缓冲区*/
    private  ByteBuffer sendbuffer = ByteBuffer.allocate(BLOCK);
    /*发送数据缓冲区*/
    private  ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);
    private Selector selector;


    public static void main(String[] args) throws IOException {
        int port = 8888;
        NIOServer nioServer = new NIOServer(port);
        nioServer.listen();
    }

    public NIOServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//        设置为非阻塞
        serverSocketChannel.configureBlocking(false);
//        检索与此通道关联的服务器套接字
        ServerSocket serverSocket = serverSocketChannel.socket();
//        进行服务绑定
        serverSocket.bind(new InetSocketAddress(port));
        selector = Selector.open();
//        把通道注册到selector，等待链接
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    // 监听
    private void listen() throws IOException {
        while (true) {
            // 选择一组键，并且相应的通道已经打开
            selector.select();
            // 返回此选择器的已选择键集。
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                handleKey(selectionKey);
            }
        }
    }

    private void handleKey(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel server = null;
        SocketChannel client = null;
        String receiveText;
        String sendText;
        int count = 0;
        // 测试此键的通道是否已准备好接受新的套接字连接 对应客户端的 isConnected
        if (selectionKey.isAcceptable()){
            // 返回为之创建此键的通道。
            server = (ServerSocketChannel) selectionKey.channel();
            // 接受到此通道套接字的连接。
            // 此方法返回的套接字通道（如果有）将处于阻塞模式。
            client = server.accept();
            // 配置为非阻塞
            client.configureBlocking(false);
            // 注册到selector读事件，等待连接
            client.register(selector, SelectionKey.OP_READ);
        }else if (selectionKey.isReadable()) {
//            返回为之创建此键的通道。
            client = (SocketChannel) selectionKey.channel();
//            将缓冲区清空以备下次读取。
            receivebuffer.clear();
//            读取服务器发送来的数据到缓冲区
            count = client.read(receivebuffer);
            if (count > 0) {
                receiveText = new String(receivebuffer.array(), 0, count);
                System.out.println("服务器接受的客户端数据: " + receiveText);
//                注册写事件
                client.register(selector, SelectionKey.OP_WRITE);
            }
        }else if (selectionKey.isWritable()){
//                将缓冲区清空以备下次写入
                sendbuffer.clear();
//                返回为之创建的此键的通道
                client = (SocketChannel) selectionKey.channel();
                sendText = "message from server: "+flag++;
//                向缓冲区输入数据
                sendbuffer.put(sendText.getBytes());
//                将缓冲区各标志复位，因为向里面put了数据标志位改变想从中读取数据法向服务器，就要复位。
                sendbuffer.flip();
//                输出到通道
                client.write(sendbuffer);
                System.out.println("服务器端向客户端发送数据--："+sendText);
                client.register(selector, SelectionKey.OP_READ);
        }

    }

}
