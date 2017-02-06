package org.tj.meta.base.study.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 001 on 16/12/23.
 */
public class TestServerSocket {

    static int i = 0;

    public static void test(String[] args) throws IOException {
//创建Selector
        Selector selector = Selector.open();
//打开ServerSocketChannel
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);

        ServerSocket serverSocket = socketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(9000);
        serverSocket.bind(address);

        SelectionKey key = socketChannel.register(selector,SelectionKey.OP_ACCEPT);

        int num = selector.select();
        Set selectedKeys = selector.selectedKeys();
        Iterator it = selectedKeys.iterator();

        while (it.hasNext()){
            SelectionKey key1 = (SelectionKey) it.next();
            if ((key1.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
                System.out.println("新连接"+i++);
            }
        }
    }
}
