package com.example.linchpin.sampleapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.inputmethod.InputMethodManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by linchpin on 22/6/16.
 */
public class Utils {
    private final static String USER_AGENT = "Mozilla/5.0";
    public static SharedPreferences getPreferences(Activity activity){
        return activity.getPreferences(Context.MODE_APPEND);
    }
    public static void hideSoftKeyboard(Activity activity) {
        if (activity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }
    public static String httpGetRaw(String url) throws Exception {
        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
         con.setRequestMethod("GET");
        int timeout = 30  * 1000;
        con.setRequestProperty("User-Agent", USER_AGENT);
//        con.setRequestProperty("Accept-Charset", "UTF-8");
        con.setRequestProperty("Content-length", "0");
        con.setUseCaches(false);
        con.setAllowUserInteraction(false);
        con.setConnectTimeout(timeout);
        con.setReadTimeout(timeout);
//        con.setDoOutput(true);
//        con.connect();


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        return response.toString();
    }

//    public static String httpPostRaw(String url, String jsonData) {
//        String response = "";
//        try {
//            HttpClient client = new DefaultHttpClient();
//            HttpPost httppost = new HttpPost(url);
//            if (!jsonData.equals("")) {
//
//                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//                nameValuePairs.add(new BasicNameValuePair("approvalRejectionData", jsonData));
//                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//
//
//                //Code to send raw data..............................................................
//
////                StringEntity se = new StringEntity(jsonData);
////                se.setContentType("application/json;charset=UTF-8");
////                se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
////                post.setEntity(se);
//            }
//            HttpResponse httpresponse = client.execute(httppost);
//
//            response = EntityUtils.toString(httpresponse.getEntity());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return response;
//    }

//    public static boolean isConnectingToInternet(final Context ctx) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Network[] networks = connectivityManager.getAllNetworks();
//            NetworkInfo networkInfo;
//            for (Network mNetwork : networks) {
//                networkInfo = connectivityManager.getNetworkInfo(mNetwork);
//                if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
//                    return true;
//                }
//            }
//        } else {
//            if (connectivityManager != null) {
//                NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
//                if (info != null){
//                    for (int i = 0; i < info.length; i++){
//                        if (info[i].getState() == NetworkInfo.State.CONNECTED) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    public static void showInternetAlert(Activity activity) {
//
//        final Dialog dialog = new Dialog(activity);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.alert_internet);
//        TextView editText = (TextView) dialog.findViewById(R.id.label_field);
//        //TextView ok = (TextView) dialog.findViewById(R.id.alert_submit);
//        TextView cancel = (TextView) dialog.findViewById(R.id.alert_close);
//
//        // String first = "Are you shure ayou want to ";
//        String first = "You don't have ";
//        String next = "<font color='#242424'>internet</font>" + " connection.";
//        editText.setText(Html.fromHtml(first + next));
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//    }
}
