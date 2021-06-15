package com.perdev.designpattern.creational.builder;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.creational.builder
 * Date       2021/06/08 - 15:54
 * Author     Payne.
 * About      类描述：模拟网络请求
 */
public class Request {
    String url;
    String method;
    String body;

    private Request(String url, String method, String body) {
        this.url = url;
        this.method = method;
        this.body = body;
    }

    public String call() {
        return "this is data:" + url + method + body;
    }

    public static class Builder {
        String url;
        String method;
        String body;

        public Builder() {
            method = "get";
        }

        public Builder url(String url) {
            //在这里可以做其他处理处理
            this.url = url;
            return this;
        }

        public Builder method(String method) {
            //在这里可以做其他处理处理
            this.method = method;
            return this;
        }

        public Builder body(String body) {
            //在这里可以做其他处理处理
            this.body = body;
            return this;
        }

        public Request build() {
            return new Request(url, method, body);
        }
    }
}