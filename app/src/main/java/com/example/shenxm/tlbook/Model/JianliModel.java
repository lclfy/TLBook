package com.example.shenxm.tlbook.Model;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class JianliModel {
    String rybm;
    String qsrq;
    String zzrq;
    String BDMS;

    public JianliModel(String rybm, String qsrq, String zzrq, String BDMS) {
        this.rybm = rybm;
        this.qsrq = qsrq;
        this.zzrq = zzrq;
        this.BDMS = BDMS;
    }

    public JianliModel() {
    }

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm;
    }

    public String getQsrq() {
        return qsrq;
    }

    public void setQsrq(String qsrq) {
        this.qsrq = qsrq;
    }

    public String getZzrq() {
        return zzrq;
    }

    public void setZzrq(String zzrq) {
        this.zzrq = zzrq;
    }

    public String getBDMS() {
        return BDMS;
    }

    public void setBDMS(String BDMS) {
        this.BDMS = BDMS;
    }
}
