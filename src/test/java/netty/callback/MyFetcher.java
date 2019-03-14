package netty.callback;

/**
 * Created by hjhuang on 2018/6/14.
 */
public class MyFetcher implements Fetcher {

    final String data;

    public MyFetcher(String data) {
        this.data = data;
    }

    @Override
    public void fetchData(FetcherCallback callback) {
        try{
            callback.onData(this.data);
        }catch (Throwable cause) {
            callback.onError(cause);
        }
    }
}
