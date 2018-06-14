package com.vedprakashwagh.quizapp.view;

import android.content.Intent;
import android.os.Handler;

import com.daimajia.androidanimations.library.Techniques;
import com.vedprakashwagh.quizapp.R;
import com.vedprakashwagh.quizapp.view.SwipeableCards.SwiperMainActivity;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashScreen extends AwesomeSplash {
    String tempPath = "M 126.00,30.09\n" +
            "           C 126.00,30.09 107.12,30.62 107.12,30.38\n" +
            "             107.12,30.25 96.80,31.15 88.38,34.12\n" +
            "             80.50,36.90 74.50,41.75 74.50,41.75\n" +
            "             74.50,41.75 68.33,48.57 65.12,57.50\n" +
            "             61.78,66.82 61.75,79.50 61.75,79.50\n" +
            "             61.75,79.50 61.00,161.88 61.00,161.88\n" +
            "             61.00,161.88 59.05,171.54 54.00,177.38\n" +
            "             48.63,183.59 40.12,186.00 40.12,186.00\n" +
            "             40.12,186.00 39.88,209.38 40.00,209.25\n" +
            "             40.06,209.19 48.05,210.77 53.12,216.50\n" +
            "             58.57,222.65 61.12,233.00 61.12,233.00\n" +
            "             61.12,233.00 61.38,313.75 61.38,313.75\n" +
            "             61.38,313.75 61.85,326.76 64.75,336.88\n" +
            "             67.19,345.37 72.12,351.25 72.12,351.25\n" +
            "             72.12,351.25 77.73,358.76 87.38,362.50\n" +
            "             97.22,366.32 111.12,366.38 111.12,366.38\n" +
            "             111.12,366.38 126.00,366.62 126.00,366.62\n" +
            "             126.00,366.62 126.00,342.00 126.00,342.00\n" +
            "             126.00,342.00 114.75,342.00 114.75,342.00\n" +
            "             114.75,342.00 101.02,341.02 95.00,333.88\n" +
            "             88.42,326.05 89.50,312.00 89.50,312.00\n" +
            "             89.50,312.00 88.62,230.75 88.62,230.75\n" +
            "             88.62,230.75 86.51,218.93 81.00,211.12\n" +
            "             75.71,203.63 67.00,200.12 67.00,200.12\n" +
            "             67.00,200.12 67.06,198.06 67.06,198.06\n" +
            "             67.06,198.06 76.26,193.88 81.62,186.25\n" +
            "             87.26,178.24 89.06,166.75 89.06,166.75\n" +
            "             89.06,166.75 89.00,84.12 89.00,84.12\n" +
            "             89.00,84.12 89.31,70.75 95.56,63.19\n" +
            "             101.25,56.31 112.94,55.19 112.94,55.19\n" +
            "             112.94,55.19 125.75,54.94 125.75,54.94\n" +
            "             125.75,54.94 126.00,30.09 126.00,30.09 Z\n" +
            "           M 140.36,116.36\n" +
            "           C 140.36,116.36 141.05,110.71 144.55,108.18\n" +
            "             147.21,106.25 152.91,107.27 152.91,107.27\n" +
            "             152.91,107.27 287.00,189.38 287.00,189.38\n" +
            "             287.00,189.38 289.85,194.11 290.18,198.55\n" +
            "             290.48,202.54 288.27,206.27 288.27,206.27\n" +
            "             288.27,206.27 157.36,287.55 157.36,287.55\n" +
            "             157.36,287.55 150.45,291.33 145.91,289.18\n" +
            "             141.84,287.26 140.09,279.36 140.09,279.36\n" +
            "             140.09,279.36 140.36,116.36 140.36,116.36 Z\n" +
            "           M 275.82,30.36\n" +
            "           C 275.82,30.36 276.09,54.96 276.09,54.96\n" +
            "             276.09,54.96 291.04,54.91 291.04,54.91\n" +
            "             291.04,54.91 300.97,55.86 306.50,62.00\n" +
            "             311.88,67.97 312.88,79.12 312.88,79.12\n" +
            "             312.88,79.12 313.38,161.50 313.25,161.50\n" +
            "             313.19,161.50 314.38,174.77 320.00,183.88\n" +
            "             325.21,192.31 334.88,196.62 334.88,196.62\n" +
            "             334.88,196.62 335.12,199.00 335.12,199.00\n" +
            "             335.12,199.00 324.10,205.23 318.88,213.50\n" +
            "             313.30,222.34 313.50,233.25 313.50,233.25\n" +
            "             313.50,233.25 313.12,317.88 313.12,317.88\n" +
            "             313.12,317.88 311.48,329.55 304.62,335.62\n" +
            "             297.86,341.62 285.88,342.00 285.88,342.00\n" +
            "             285.88,342.00 276.12,342.75 276.12,342.75\n" +
            "             276.12,342.75 276.12,367.00 276.12,367.00\n" +
            "             276.12,367.00 291.88,367.00 291.88,367.00\n" +
            "             291.88,367.00 314.81,366.26 327.88,354.62\n" +
            "             339.19,344.56 340.88,323.38 340.88,323.38\n" +
            "             340.88,323.38 341.25,237.62 341.25,237.62\n" +
            "             341.25,237.62 342.59,226.66 348.50,219.00\n" +
            "             353.44,212.59 363.12,209.25 363.12,209.25\n" +
            "             363.12,209.25 363.00,187.88 363.00,187.88\n" +
            "             363.00,187.88 352.79,184.87 347.50,178.12\n" +
            "             341.86,170.94 341.12,160.00 341.12,160.00\n" +
            "             341.12,160.00 340.75,75.62 340.75,75.62\n" +
            "             340.75,75.62 338.35,52.57 327.38,41.38\n" +
            "             316.04,29.82 296.12,30.12 296.12,30.12\n" +
            "             296.12,30.12 275.82,30.36 275.82,30.36 Z";
    @Override
    public void initSplash(ConfigSplash configSplash) {
        configSplash.setBackgroundColor(R.color.colorPrimaryDark);
        configSplash.setAnimCircularRevealDuration(1000);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);


        configSplash.setPathSplash(tempPath);
        configSplash.setOriginalHeight(400);
        configSplash.setOriginalWidth(400);
        configSplash.setAnimPathStrokeDrawingDuration(1500);
        configSplash.setPathSplashStrokeSize(5);
        configSplash.setPathSplashStrokeColor(R.color.white);
        configSplash.setAnimPathFillingDuration(1500);
        configSplash.setPathSplashFillColor(android.R.color.holo_green_dark);


        //Customize Title
        configSplash.setTitleSplash("LearnCodeOnline\n");
        configSplash.setTitleTextColor(R.color.white);
        configSplash.setTitleTextSize(40f); //float value
        configSplash.setAnimTitleDuration(1000);
        configSplash.setAnimTitleTechnique(Techniques.SlideInUp);
        configSplash.setTitleFont("fonts/amatic_bold.ttf");

    }

    @Override
    public void animationsFinished() {
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, SwiperMainActivity.class);
                startActivity(i);
                finish();
            }

        }, 2500L);
    }
}
