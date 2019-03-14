package netty.handle;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by hjhuang on 2018/6/20.
 */
public class TimeChannelHandle extends ChannelInboundHandlerAdapter {

    private final ByteBuf message;

    public TimeChannelHandle() {
        byte[] req = "query".getBytes();
        message = Unpooled.buffer(req.length);
        message.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(message);
    }


}
