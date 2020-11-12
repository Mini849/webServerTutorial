package com.web.postModel;

import java.util.List;

public class Mer_Data {

    private List<String> data;
    private List<String> yoink;

    public Mer_Data(List<String> data, List<String> yoink) {
        this.data = data;
        this.yoink = yoink;
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
}
