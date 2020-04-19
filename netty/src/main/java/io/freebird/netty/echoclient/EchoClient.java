package io.freebird.netty.echoclient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {
    private final String host = "127.0.0.1";
    private final int port = 80;


    private void start() throws InterruptedException {
        final Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = null;
        try {
            group = new NioEventLoopGroup();
            bootstrap.channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .group(group)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect().sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
