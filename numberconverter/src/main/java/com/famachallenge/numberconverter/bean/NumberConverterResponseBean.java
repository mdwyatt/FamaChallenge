package com.famachallenge.numberconverter.bean;

public class NumberConverterResponseBean {

    private String status;
    private String numInEnglish;

    public NumberConverterResponseBean() { }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumInEnglish() {
        return numInEnglish;
    }

    public void setNumInEnglish(String numInEnglish) {
        this.numInEnglish = numInEnglish;
    }

}
