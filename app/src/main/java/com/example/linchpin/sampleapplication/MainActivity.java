package com.example.linchpin.sampleapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.linchpin.sampleapplication.Models.Phone;
import com.example.linchpin.sampleapplication.Models.ResponseBody;
import com.example.linchpin.sampleapplication.Models.Timesheet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnAsyncTaskCompleteListner{

    private static final String BASE_URL = "http://ambarish-developer-edition.ap2.force.com/";//"http://androidtutorialpoint.com/";
    private TextView name;
    private String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
init();
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                postQuery();
//                getRetrofitObject();
//                new CommonAsyncTask(getApplicationContext(), json, MainActivity.this).execute();
            }
        });

    }

    private void init() {
        name=(TextView)findViewById(R.id.show_string);

    }
    void getRetrofitObject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);

        Call<Student> call = service.getStudentDetails();

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                try {

                    String s=("StudentId  :  " + response.body().getStudentId() + "\n");
                    s=s+("StudentName  :  " + response.body().getStudentName() + "\n");
                    s=s+("StudentMarks  : " + response.body().getStudentMarks());
                    name.setText(s);

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

    public void postQuery(){

        List<Phone> list=new ArrayList<Phone>();
        list.add(new Phone("lkhoshiuyiu", "vikash"));
        Timesheet timesheet= new Timesheet();
        timesheet.setTimesheet(list);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI apiService = retrofit.create(RetrofitObjectAPI.class);
        Call<ResponseBody> call = apiService.approveExpenses(timesheet);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                int errorCode = response.body().getErrorCode();
                String statusMsg = response.body().getStatusMsg();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void sendPostResult(String response) {
        name.setText(response.toString());
    }

    @Override
    public void showDialog() {

    }
}
