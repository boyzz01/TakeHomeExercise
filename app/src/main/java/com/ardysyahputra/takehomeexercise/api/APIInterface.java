package com.ardysyahputra.takehomeexercise.api;



import com.ardysyahputra.takehomeexercise.model.ClockInModel.ClockIn;
import com.ardysyahputra.takehomeexercise.model.ClockInModel.StaffRequest;
import com.ardysyahputra.takehomeexercise.model.ClockOutModel.ClockOut;
import com.ardysyahputra.takehomeexercise.model.dataModel.ResponseLogin;
import com.ardysyahputra.takehomeexercise.model.dataModel.Staff;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {


    @FormUrlEncoded
    @POST("auth/login/")
    Call<ResponseLogin> loginRequest(@Field("username") String username,
                                     @Field("password") String password);


    @GET("staff-requests/26074/")
    Call<Staff> getData(@Header("Authorization") String token) ;

    @FormUrlEncoded
    @POST("staff-requests/26074/clock-in/")
    Call<ClockIn> ClockInRequest(@Header("Authorization") String token,
                                 @Field("latitude") String latitude,
                                 @Field("longitude") String longitude);

    @FormUrlEncoded
    @POST("staff-requests/26074/clock-out/")
    Call<ClockOut> ClockOutRequest(@Header("Authorization") String token,
                                   @Field("latitude") String latitude,
                                   @Field("longitude") String longitude);




}
