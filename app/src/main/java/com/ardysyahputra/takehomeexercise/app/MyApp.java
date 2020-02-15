package com.ardysyahputra.takehomeexercise.app;

import android.app.Application;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.Toast;

import com.ardysyahputra.takehomeexercise.api.APIInterface;
import com.ardysyahputra.takehomeexercise.api.RetrofitClient;
import com.ardysyahputra.takehomeexercise.model.dataModel.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }
}
