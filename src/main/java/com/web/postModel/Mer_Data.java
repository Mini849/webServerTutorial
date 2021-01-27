package com.web.postModel;

import java.util.List;

public class Mer_Data {

    private List<String> data;
    private List<String> yoink;
    private List<String> trailers;

    public Mer_Data(List<String> data, List<String> yoink, List<String> trailers) {
        this.data = data;
        this.yoink = yoink;
        this.trailers = trailers;
    }


    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getYoink() {
        return yoink;
    }

    public void setYoink(List<String> yoink) {
        this.yoink = yoink;
    }

    public List<String> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<String> trailers) {
        this.trailers = trailers;
    }
}
