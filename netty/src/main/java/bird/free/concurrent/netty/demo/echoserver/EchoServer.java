package bird.free.concurrent.netty.demo.echoserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            return;
        }
        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }

    /**
     * 使用NIO作为网络的IO方式
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {
        // 所有channel可以共享的消息处理器
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        EventLoopGroup group = null;
        try {
            // nio
            group = new NioEventLoopGroup();
            // 服务器的启动及绑定等等
            final ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(echoServerHandler);
                            // TODO 为什么需要同步阻塞？
                            ChannelFuture future = bootstrap.bind().sync();
                            future.channel().closeFuture().sync();
                        }
                    });
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
