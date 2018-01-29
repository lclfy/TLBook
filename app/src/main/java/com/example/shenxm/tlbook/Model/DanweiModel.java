package com.example.shenxm.tlbook.Model;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class DanweiModel {

    public String danweiname;
    public String danweiid;
    public String danweiCode;
    public DanweiModel(String danweiid, String danweiname, String danweiCode) {
        this.danweiid = danweiid;
        this.danweiname = danweiname;
        this.danweiCode = danweiCode;
    }

    public String getDanweiCode() {
        return danweiCode;
    }

    public void setDanweiCode(String danweiCode) {
        this.danweiCode = danweiCode;
    }

    public String getDanweiid() {
        return danweiid;
    }

    public void setDanweiid(String danweiid) {
        this.danweiid = danweiid;
    }

    public String getDanweiname() {
        return danweiname;
    }

    public void setDanweiname(String danweiname) {
        this.danweiname = danweiname;
    }
}
