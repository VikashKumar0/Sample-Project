package com.example.linchpin.sampleapplication;


import java.util.List;

import retrofit2.http.GET;

/**
 * Created by Linchpin66 on 16-06-16.
 */
public interface OnAsyncTaskCompleteListner {

    void sendPostResult(String response);
    void showDialog();

}
//public interface GetAPI {
//
//    @GET("/list")
//    Call<Model> getModel();
//}