package com.web.model;

import javax.persistence.*;

@Entity
@Table(name = "TBL_MEERANE_TRAILERS")
public class Mer_Trailers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "trailers")
    private String trailers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrailers() {
        return trailers;
    }

    public void setTrailers(String trailers) {
        this.trailers = trailers;
    }

    @Override
    public String toString() {
        return "Mer_Trailers{" +
                "id=" + id +
                ", trailers='" + trailers + '\'' +
                '}';
    }
}
