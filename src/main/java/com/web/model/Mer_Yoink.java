package com.web.model;

import javax.persistence.*;

@Entity
@Table(name = "TBL_MEERANE_YOINK")
public class Mer_Yoink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "yoink")
    private String yoink;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYoink() {
        return yoink;
    }

    public void setYoink(String yoink) {
        this.yoink = yoink;
    }

    @Override
    public String toString() {
        return "Mer_Yoink{" +
                "id=" + id +
                ", yoink='" + yoink + '\'' +
                '}';
    }
}
