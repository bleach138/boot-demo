package netty.callback;

/**
 * Created by hjhuang on 2018/6/14.
 */
public interface FetcherCallback {
    void onData(String data) throws Exception;
    void onError(Throwable cause);
}
