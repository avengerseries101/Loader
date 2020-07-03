package com.example.userapp;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class UserAsyncTaskLoader extends AsyncTaskLoader<String[][]> {
    User user;

    public UserAsyncTaskLoader(@NonNull Context context) {
        super(context);
        user = new User();
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public String[][] loadInBackground() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(50);
                Log.d("@@@@@", "loadInBackground : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String[][] userData = user.getUserList();
        return userData;
    }
}
