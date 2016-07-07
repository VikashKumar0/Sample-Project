package com.example.linchpin.sampleapplication;

import com.example.linchpin.sampleapplication.Models.ResponseBody;
import com.example.linchpin.sampleapplication.Models.Timesheet;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by linchpin on 7/7/16.
 */
public interface RetrofitObjectAPI {
    /*
    * Retrofit get annotation with our URL
    * And our method that will return us details of student.
   */
    @GET("api/RetrofitAndroidObjectResponse")
    Call<Student> getStudentDetails();

    @POST("MobileExpensesApprove")
    Call<ResponseBody> approveExpenses(@Body Timesheet user);
}
