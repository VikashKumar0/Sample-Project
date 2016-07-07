package com.example.linchpin.sampleapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linchpin66 on 16-06-16.
 */
public class CommonAsyncTask extends AsyncTask<Void,String,String>{
    private final String json;
    private Context ctx;
    private String url="http://bebetrack.com/api/create";
    private OnAsyncTaskCompleteListner listner;
    public String response;

    public CommonAsyncTask(Context ctx , String json, OnAsyncTaskCompleteListner onAsyncTaskCompleteListner) {
        this.json=json;
        this.ctx=ctx;
        listner=onAsyncTaskCompleteListner;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listner.showDialog();
    }

    @Override
    protected String doInBackground(Void... params) {

//        parseHtmlSite();
//        Utils.httpPostRaw(url, json);
            return response;
    }

//
//    private void getByVolly() {
//        String loginURL=url+letter;
//        try {
//            final RequestQueue requestQueue = Volley.newRequestQueue(ctx);
//            StringRequest jor = new StringRequest(Method.GET, loginURL,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            CommonAsyncTask.this.response = response;
//                            CommonAsyncTask.this.parseHtmlSite();
////                            pDialog.hide();
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.e("Volley", "Error");
////                            pDialog.hide();
//                        }
//                    }
//            );
//            requestQueue.add(jor);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    private void parseHtmlSite() {
//        Document document = null;
//        try{
//            response = Utils.httpGetRaw(url+letter);
//            document = Jsoup.parse(response);
//
//
////            document = (Document) Jsoup.connect(url+letter).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")//"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
////                    .referrer("http://www.google.com")
////                    .timeout(1000*5) //it's in milliseconds, so this means 5 seconds.
////            .get();
//            Elements table = document.select("div.latest");
//            if(table!=null) {
////                Elements tbody = table.select("tbody");
//                Elements tr = table.select("a");
//                int count = 0;
//                for (Element child : tr) {
//                    if (count > 1) {
//                        Elements anchor = child.select("a");
//                        MovieData movieData=new MovieData();
//                        movieData.setMovieLink(child.attr("href"));
//                        movieData.setEnglishMovie(child.text());
////                        movieData.setHindiLyicsLink(anchor.get(1).text());
//                        movieDataList.add(movieData);
//                        count++;
//                    }
//                    else
//                    {
//                        count++;
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        listner.sendPostResult(movieDataList);
//    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        listner.sendPostResult(response);

    }
}
