package netty;

import netty.callback.FetcherCallback;
import netty.callback.MyFetcher;
import org.junit.Test;

/**
 * Created by hjhuang on 2018/6/14.
 */
public class TestFetcher {

    @Test
    public  void testFetch(){
        MyFetcher fetcher = new MyFetcher("22222");

        fetcher.fetchData(new FetcherCallback() {
            @Override
            public void onData(String data) throws Exception {
                System.out.println(data);
            }

            @Override
            public void onError(Throwable cause) {
                cause.printStackTrace();
            }
        });
    }

}
