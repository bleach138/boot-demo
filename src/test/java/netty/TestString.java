package netty;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;
import org.junit.Test;

public class TestString {

    @Test
    public void test() {

        int val = 16;
        System.out.println((val & -val) == val);

        int DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));

        System.out.println(DEFAULT_EVENT_LOOP_THREADS);
    }
}
