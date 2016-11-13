package googlepalyservices.samples.adnroid.threehose.com.musicmachine;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Liorm on 11/7/2016.
 */

public class PlayerService extends Service{
    private static final String TAG = PlayerService.class.getSimpleName();
    private MediaPlayer mPlayer;
    private IBinder mBinder = new LocalBinder();

    @Override
    public void onCreate() {
        Log.d( TAG, "onCreate");
        mPlayer= MediaPlayer.create(this,R.raw.jingle);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
      mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
          @Override
          public void onCompletion(MediaPlayer mp) {
              stopSelf();
          }
      });
        return Service.START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d( TAG, "onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d( TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d( TAG, "onDestory");
        mPlayer.release();
    }


    public class LocalBinder extends Binder{
        public PlayerService getService(){
            return PlayerService.this;
        }
    }


    //Client Methods
    public  boolean isPlaying(){
        return mPlayer.isPlaying();

    }

    public void play(){
        mPlayer.start();
    }

    public void pause(){
        mPlayer.pause();

    }




}
