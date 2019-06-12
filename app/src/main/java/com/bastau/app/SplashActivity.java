package com.bastau.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bastau.app.ui.MainActivity;
import com.pixplicity.easyprefs.library.Prefs;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (!Prefs.getString("LOGIN", "").equals("")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            new Handler().postDelayed(() -> {
                startActivity(new Intent(getApplicationContext(), CarouselViewActivity.class));
                finish();
            }, 2000);
        }
    }
}
