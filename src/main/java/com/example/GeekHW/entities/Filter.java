package com.example.GeekHW.entities;

import org.springframework.stereotype.Component;


public class Filter {
    private String strfilter;

    public Filter() {
    }

    public Filter(String strfilter) {
        this.strfilter = strfilter;
    }

    public String getStrfilter() {
        return strfilter;
    }

    public void setStrfilter(String strfilter) {
        this.strfilter = strfilter;
    }
}
