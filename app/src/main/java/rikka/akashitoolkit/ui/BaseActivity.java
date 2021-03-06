package rikka.akashitoolkit.ui;

import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import moe.xing.daynightmode.BaseDayNightModeActivity;
import rikka.akashitoolkit.R;
import rikka.akashitoolkit.support.Settings;
import rikka.akashitoolkit.support.Statistics;

/**
 * Created by Rikka on 2016/3/6.
 */
public abstract class BaseActivity extends BaseDayNightModeActivity {
    public static final String EXTRA_FROM_NOTIFICATION = "EXTRA_FROM_NOTIFICATION";
    public static final String EXTRA_EXTRA = "EXTRA_EXTRA";
    public static final String EXTRA_EXTRA2 = "EXTRA_EXTRA2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void onPause() {
        super.onPause();
        Statistics.onPause(this);
    }

    protected void onResume() {
        super.onResume();
        Statistics.onResume(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (Settings.instance(this).getBoolean(Settings.NAV_BAR_COLOR, false)) {
                getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
            } else {
                getWindow().setNavigationBarColor(ContextCompat.getColor(this, android.R.color.black));
            }
        }
    }

    protected boolean checkPermission(String permission) {
        return (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED);
    }

    protected void getPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
        }
    }
}
