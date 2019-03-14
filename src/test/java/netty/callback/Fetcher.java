package netty.callback;

/**
 * Created by hjhuang on 2018/6/14.
 */
public interface Fetcher {
    void fetchData(FetcherCallback callback);
}
