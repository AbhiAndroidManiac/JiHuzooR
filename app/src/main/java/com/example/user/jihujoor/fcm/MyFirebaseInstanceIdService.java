package com.example.user.jihujoor.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by ADMIN on 11-04-2018.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIDService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String fcmToken = FirebaseInstanceId.getInstance().getToken();
        Log.e(TAG, fcmToken);
       // System.out.println("Fcmtoken stored in sessionmanager, token is:"+sessionManager.getRefreshedToken());

    }
}

