package com.perdev.designpattern.builder;

import android.app.AlertDialog;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
//import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.builder
 * Date       2021/06/08 - 14:59
 * Author     Payne.
 * About      类描述：
 */
public class Main {


    public static void main() {
        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url("url")
                .method("get")
                .body("body")
                .build();
        String data = request.call();
        System.out.println(data);


        //android dialog
//        AlertDialog.Builder builder=new AlertDialog.Builder(null);
//        builder
//                .setView(null)
//                .setTitle(1)
//                .setIcon(2);
//        AlertDialog dialog=builder.create();
//        dialog.show();


        //okhttp
//        MediaType JSON = MediaType.get("application/json; charset=utf-8");
//        OkHttpClient client = new OkHttpClient();
//        RequestBody body = RequestBody.create("json", JSON);
//        Request request = new Request.Builder()
//                .url("url")
//                .post(body)
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            String data = response.body().toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //retrofit
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GitHubService service = retrofit.create(GitHubService.class);


    }
}