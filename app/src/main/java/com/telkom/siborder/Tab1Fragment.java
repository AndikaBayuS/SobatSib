package com.telkom.siborder;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    RingProgressBar ringProgressBar1,ringProgressBar2,ringProgressBar3,ringProgressBar4,ringProgressBar5,ringProgressBar6,ringProgressBar7,ringProgressBar8,ringProgressBar9;

    int progress = 0;

    Handler myHandler = new Handler()
    {

        @Override
        public void handleMessage(Message msg)
        {
            progress++;
            if (progress <= 90)
            {

                ringProgressBar6.setProgress(progress);
                ringProgressBar8.setProgress (progress);

                if(progress <= 85)
                {
                    ringProgressBar7.setProgress(progress);
                    ringProgressBar4.setProgress(progress);
                    ringProgressBar9.setProgress(progress);

                    if(progress <= 75)
                    {
                        ringProgressBar5.setProgress(progress);
                        ringProgressBar1.setProgress(progress);
                        ringProgressBar2.setProgress(progress);
                        ringProgressBar3.setProgress(progress);
                    }
                }
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        ringProgressBar2 = (RingProgressBar) view.findViewById(R.id.progress_bar_2);
        ringProgressBar1 = (RingProgressBar) view.findViewById(R.id.progress_bar_3);
        ringProgressBar3 = (RingProgressBar) view.findViewById(R.id.progress_bar_4);


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 75; i++) {
                    try {
                        Thread.sleep(75);
                        myHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        ringProgressBar4 = (RingProgressBar) view.findViewById(R.id.progress_bar_5);
        ringProgressBar5 = (RingProgressBar) view.findViewById(R.id.progress_bar_6);
        ringProgressBar6 = (RingProgressBar) view.findViewById(R.id.progress_bar_7);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 85; i++) {
                    try {
                        Thread.sleep(85);
                        myHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        ringProgressBar7 = (RingProgressBar) view.findViewById(R.id.progress_bar_8);
        ringProgressBar8 = (RingProgressBar) view.findViewById(R.id.progress_bar_9);
        ringProgressBar9 = (RingProgressBar) view.findViewById(R.id.progress_bar_10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 90; i++) {
                    try {
                        Thread.sleep(90);
                        myHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        return view;
    }
}
