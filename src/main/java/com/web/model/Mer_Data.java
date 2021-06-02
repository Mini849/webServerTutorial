package com.web.model;

import javax.persistence.*;

@Entity
@Table(name = "TBL_MEERANE_DATA")
public class Mer_Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "data")
    private String data;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mer_Data{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
