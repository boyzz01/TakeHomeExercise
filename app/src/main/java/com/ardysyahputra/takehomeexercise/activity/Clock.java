package com.ardysyahputra.takehomeexercise.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ardysyahputra.takehomeexercise.R;
import com.ardysyahputra.takehomeexercise.api.APIInterface;

import com.ardysyahputra.takehomeexercise.api.RetrofitClient;
import com.ardysyahputra.takehomeexercise.model.ClockInModel.ClockIn;
import com.ardysyahputra.takehomeexercise.model.ClockOutModel.ClockOut;
import com.ardysyahputra.takehomeexercise.model.dataModel.ResponseLogin;
import com.ardysyahputra.takehomeexercise.model.dataModel.Staff;
import com.ardysyahputra.takehomeexercise.preference.PrefManager;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Clock extends AppCompatActivity {


    ProgressDialog progressDialog;
    TextView positionName, clientName, wageAmount, wageType, locationStreet, locationManager, managerPhone, timeIn, timeOut,cloking;
    TextView cancel;
    ImageView clock;
    ConstraintLayout overlay;

    ProgressBar loading;
    int progressStatus;
    int max = 10;

    Boolean stop = false;
    Handler handler = new Handler();
    PrefManager prefManager;

    double longitude;
    double latitude;
    SimpleDateFormat sdf;
    String token;
    APIInterface mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_in);
        positionName = findViewById(R.id.Position_Name);
        clientName = findViewById(R.id.Client_Name);
        wageAmount = findViewById(R.id.Wage_Amount);
        wageType = findViewById(R.id.Wage_Type);
        locationStreet = findViewById(R.id.Location_Street);
        locationManager = findViewById(R.id.Location_Manager);
        managerPhone = findViewById(R.id.manager_phone);
        timeIn = findViewById(R.id.time_in);
        timeOut = findViewById(R.id.time_out);
        clock = findViewById(R.id.btn_clock);
        cloking = findViewById(R.id.clocking);

        //overlay
        overlay = findViewById(R.id.overlayIn);
        cancel = findViewById(R.id.cancel);
        loading = findViewById(R.id.progressBar);

        loading.setProgress(10);
        managerPhone.setPaintFlags(managerPhone.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        cancel.setPaintFlags(cancel.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        prefManager = new PrefManager("Clock",Clock.this);
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));


        getToken();


        Log.d("tes","clock in "+prefManager.isClockin()+" clock out "+prefManager.isClockOut());

        if (prefManager.isClockin())
        {
            timeIn.setText(prefManager.getTimeIn());
            clock.setImageResource(R.drawable.ic_button_out);
            cloking.setText(R.string.clockingOut);
        }
        if (prefManager.isClockOut())
        {
            timeOut.setText(prefManager.getTimeOut());
            clock.setVisibility(View.GONE);
        }


        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadpermission();
            }

        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop = true;
                overlay.setVisibility(View.GONE);
                clock.setEnabled(true);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        });

    }



    public void overlayClock() {

        //get Latitude and Longitude

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);

        //start clocking
        progressStatus = 0;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        overlay.setVisibility(View.VISIBLE);
        clock.setEnabled(false);
        loading.setMax(max);
        loading.setProgress(progressStatus);
        stop = false;

        Log.d("tes","in :"+prefManager.isClockin());
        new Thread(new Runnable() {
            public void run() {

                while (progressStatus < 10 && !stop) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            loading.setProgress(progressStatus);
                            Log.d("tes", "progress" + progressStatus);
                            if (progressStatus == max) {
                                clock.setEnabled(true);
                                if (prefManager.isClockin())
                                {
                                    PostClockOut();
                                }
                                else if (!prefManager.isClockin())
                                {
                                    PostClockIn();
                                }

                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }

    private void PostClockOut() {
        mApiService = RetrofitClient.getClient().create(APIInterface.class);

        progressDialog= ProgressDialog.show(this, null, "Please Wait..", true, false);
        mApiService.ClockOutRequest("token "+token,""+latitude,""+longitude).enqueue(new Callback<ClockOut>() {
            @Override
            public void onResponse(Call<ClockOut> call, Response<ClockOut> response) {
                if (response.isSuccessful())
                {
                    ClockOut ClockOut = response.body();

                    prefManager.setClockOut(true);

                    try {
                        Date d = sdf.parse(ClockOut.getTimesheet().getClockOutTime());
                        String tempOut = new SimpleDateFormat("hh:mma").format(d);
                        timeOut.setText(tempOut);
                        prefManager.setTime_Out(tempOut);
                        clock.setVisibility(View.GONE);
                    } catch (ParseException ex) {
                        Log.v("Exception", ex.getLocalizedMessage());
                    }

                    progressDialog.dismiss();
                }

                else
                {
                    Toast.makeText(Clock.this, "Error, Already Clock Out", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ClockOut> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
        overlay.setVisibility(View.GONE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void PostClockIn() {
        mApiService = RetrofitClient.getClient().create(APIInterface.class);

        progressDialog= ProgressDialog.show(this, null, "Please Wait..", true, false);
        mApiService.ClockInRequest("token "+token,""+latitude,""+longitude).enqueue(new Callback<ClockIn>() {
            @Override
            public void onResponse(Call<ClockIn> call, Response<ClockIn> response) {

                if (response.isSuccessful())
                {
                    ClockIn ClockIn = response.body();
                    prefManager.setClockIn(true);
                    clock.setImageResource(R.drawable.ic_button_out);
                    cloking.setText(R.string.clockingOut);

                    try {
                        Date d = sdf.parse(ClockIn.getClockInTime());
                        String tempIn = new SimpleDateFormat("hh:mma").format(d);
                        timeIn.setText(tempIn);
                        prefManager.setTime_In(tempIn);


                    } catch (ParseException ex) {
                        Log.v("Exception", ex.getLocalizedMessage());
                    }

                    progressDialog.dismiss();

                }
                else
                {
                    Toast.makeText(Clock.this, "Error, Already Clock In", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ClockIn> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
        overlay.setVisibility(View.GONE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void getToken() {
        mApiService = RetrofitClient.getClient().create(APIInterface.class);
        String username ="+6281313272005";
        String password ="alexander";
        progressDialog= ProgressDialog.show(this, null, "Please Wait..", true, false);
        mApiService.loginRequest(username,password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful())
                {
                    token = response.body().getKey();
                    getData();
                    progressDialog.dismiss();
                }
                else
                {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e("error","error : "+t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    private void getData() {
        mApiService = RetrofitClient.getClient().create(APIInterface.class);

        Log.d("tes","token "+token);
        mApiService.getData("token "+token).enqueue(new Callback<Staff>() {
            @Override
            public void onResponse(Call<Staff> call, Response<Staff> response) {

                if (response.isSuccessful())
                {
                   Staff staff = response.body();
                    progressDialog.dismiss();

                    String wage= NumberFormat.getNumberInstance(Locale.US).format(staff.getWageAmount());
                   positionName.setText(staff.getPosition().getName());
                   clientName.setText(staff.getClient().getName());
                   wageAmount.setText("Rp "+wage);
                   wageType.setText(staff.getWageType());
                   locationStreet.setText(staff.getLocation().getAddress().getStreet1());
                   locationManager.setText(staff.getManager().getName());
                   managerPhone.setText(staff.getManager().getPhone());
                }

            }

            @Override
            public void onFailure(Call<Staff> call, Throwable t) {
                Log.d("data","response : "+t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    private void loadpermission() {

        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
        else
        {
            overlayClock();
        }

    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {

                    return false;
                }


            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case 1:
            {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    overlayClock();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    loadpermission();
                }
                return;
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press Back Again To Leave", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                stop=true;
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
