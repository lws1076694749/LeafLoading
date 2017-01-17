package com.lws.leafloading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x01:
                    if (mProgress < 30) {
                        mProgress++;
                        sendEmptyMessageDelayed(0x01, new Random().nextInt(100));
                        mLeafLoadingView.setProgress(mProgress);
                    } else if (mProgress >= 30 && mProgress <= 60) {
                        mProgress++;
                        sendEmptyMessageDelayed(0x01, new Random().nextInt(300));
                        mLeafLoadingView.setProgress(mProgress);
                    } else if (mProgress >= 60 && mProgress <= 100) {
                        mProgress++;
                        sendEmptyMessageDelayed(0x01, new Random().nextInt(1000));
                        mLeafLoadingView.setProgress(mProgress);
                    } else {
                        mProgress = 0;
                        sendEmptyMessageDelayed(0x01, new Random().nextInt(1200));
                        mLeafLoadingView.setProgress(mProgress);
                    }
                    break;
            }
        }
    };

    private int mProgress = 0;

    private LeafLoadingView mLeafLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLeafLoadingView = (LeafLoadingView) findViewById(R.id.leaf_loading_view);
        handler.sendEmptyMessage(0x01);
    }
}
