package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.junit.Test;

/**
 * Created by hjhuang on 2018/6/14.
 */
public class TestServer {

    @Test
    public void test() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup();
        EventLoopGroup workLoopGroup = new NioEventLoopGroup();

        bootstrap.group(bossLoopGroup,workLoopGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel channel) throws Exception {

            }
        });

        bootstrap.bind(8080).sync();

    }
}
