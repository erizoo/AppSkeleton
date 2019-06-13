package com.bastau.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bastau.app.data.models.ResponseAuth;
import com.bastau.app.ui.MainActivity;
import com.google.firebase.iid.FirebaseInstanceId;
import com.pixplicity.easyprefs.library.Prefs;

public class SplashActivity extends AppCompatActivity implements SplashView {



    private static final String TAG = "FirebaseApp";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "getInstanceId failed", task.getException());
                        return;
                    }
                    String token = task.getResult().getToken();

                    Log.d(TAG + " success", token);

                });
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

    @Override
    public void onSended(ResponseAuth responseAuth) {

    }

    @Override
    public void error(Throwable throwable) {

    }
}
