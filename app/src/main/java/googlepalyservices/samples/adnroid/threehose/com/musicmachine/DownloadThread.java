package googlepalyservices.samples.adnroid.threehose.com.musicmachine;

import android.os.Looper;
import android.util.Log;

/**
 * Created by Liorm on 10/29/2016.
 */

public class DownloadThread extends  Thread {
    private static final String TAG = MainActivity.class.getSimpleName();
    public DownloadHandler mHandler;


    @Override
    public void run() {
        Looper.prepare();
        mHandler = new DownloadHandler();
        Looper.loop();
       }




}
