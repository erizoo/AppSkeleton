package com.bastau.app;

import android.app.Application;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.bastau.app.di.component.ApplicationComponent;
import com.bastau.app.di.component.DaggerApplicationComponent;
import com.bastau.app.di.module.ApplicationModule;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.pixplicity.easyprefs.library.Prefs;

public class Bastau extends Application {

    private static final String TAG = "FirebaseApp";
    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "getInstanceId failed", task.getException());
                        return;
                    }
                    // Get new Instance ID token
                    String token = task.getResult().getToken();

                    // Log and toast
                    Log.d(TAG + " success", token);

                });
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
