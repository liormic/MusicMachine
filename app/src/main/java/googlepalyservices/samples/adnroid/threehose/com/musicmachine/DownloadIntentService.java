package googlepalyservices.samples.adnroid.threehose.com.musicmachine;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Liorm on 11/2/2016.
 */

public class DownloadIntentService extends IntentService{

    private static final String TAG =DownloadIntentService.class.getSimpleName() ;

    public DownloadIntentService() {
        super("DownloadIntentService");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        downloadSong(song);
    }

    private void downloadSong(String song) {

        long endTime = System.currentTimeMillis()+10*1000;
        while (System.currentTimeMillis() <endTime){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG,song+" Downloaded!");
    }

}
