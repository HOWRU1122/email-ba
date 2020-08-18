package com.tester.model;

public class TestResult {
    private int id;
    private String start_time;
    private String code;
    private String item;
    private String method;
    private String result;
    private String url;
    private String response;
    private String new_column;


    public TestResult(int id, String start_time, String code, String item, String method, String result, String url, String response, String new_column)
    {
        super();
        this.id = id;
        this.start_time = start_time;
        this.code = code;
        this.item = item;
        this.method = method;
        this.result = result;
        this.url = url;
        this.response = response;
        this.new_column = new_column;

    }

    public TestResult() {
        super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStart_time() {
        return start_time;
    }
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }
    public String getNew_column() {
        return new_column;
    }
    public void setNew_column(String new_column) {
        this.new_column = new_column;
    }

}
