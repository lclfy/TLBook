package com.example.shenxm.tlbook.Model;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class XlxxModel {
    String rybm;
    String qrzjy;//全日制学位
    String qrzwhcd;//
    String qrzyx;//全日制毕业院校
    String qrzzy;//全日制毕业专业
    String zzjy;//在职学位
    String zzwhcd;
    String zzyx;//在职毕业院校
    String zzzy;//在职毕业专业

    public XlxxModel(String zzzy, String qrzjy, String qrzyx, String qrzzy, String zzjy, String zzyx, String rybm, String qrzwhcd,String zzwhcd) {
        this.zzzy = zzzy;
        this.qrzjy = qrzjy;
        this.qrzyx = qrzyx;
        this.qrzzy = qrzzy;
        this.zzjy = zzjy;
        this.zzyx = zzyx;
        this.rybm = rybm;
        this.qrzwhcd = qrzwhcd;
        this.zzwhcd = zzwhcd;
    }

    public XlxxModel() {
    }

    public String getQrzwhcd() {
        return qrzwhcd;
    }

    public void setQrzwhcd(String qrzwhcd) {
        this.qrzwhcd = qrzwhcd;
    }

    public String getZzwhcd() {
        return zzwhcd;
    }

    public void setZzwhcd(String zzwhcd) {
        this.zzwhcd = zzwhcd;
    }

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm;
    }

    public String getQrzjy() {
        return qrzjy;
    }

    public void setQrzjy(String qrzjy) {
        this.qrzjy = qrzjy;
    }

    public String getQrzyx() {
        return qrzyx;
    }

    public void setQrzyx(String qrzyx) {
        this.qrzyx = qrzyx;
    }

    public String getQrzzy() {
        return qrzzy;
    }

    public void setQrzzy(String qrzzy) {
        this.qrzzy = qrzzy;
    }

    public String getZzjy() {
        return zzjy;
    }

    public void setZzjy(String zzjy) {
        this.zzjy = zzjy;
    }

    public String getZzyx() {
        return zzyx;
    }

    public void setZzyx(String zzyx) {
        this.zzyx = zzyx;
    }

    public String getZzzy() {
        return zzzy;
    }

    public void setZzzy(String zzzy) {
        this.zzzy = zzzy;
    }
}
