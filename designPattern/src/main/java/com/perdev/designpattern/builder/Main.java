package com.perdev.designpattern.builder;

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
    }
}