package in.skylinelabs.FindX.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ProgressBar;

import in.skylinelabs.FindX.R;

public class SkylinelabsFlashScreen extends ActionBarActivity {
    private static int SPLASH_TIME_OUT = 1000;
    private Animator anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skyline_labs_flash_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        //this.getActionBar().hide();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                start_MainActivity();
            }
        }, SPLASH_TIME_OUT);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED)
                finish();
        }
    }

    private void start_MainActivity() {
        View myView = findViewById(R.id.reveal_view);
        final Intent intent = new Intent(SkylinelabsFlashScreen.this, Pre_launch_activity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            int cx = myView.getWidth() / 2;
            int cy = myView.getHeight() / 2;

            float finalRadius = (float) Math.hypot(cx, cy);
            anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
            anim.setDuration(325);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    startActivity(intent);
                    finish();
                }
            });
            myView.setVisibility(View.VISIBLE);
            anim.start();
        }
    }



}
