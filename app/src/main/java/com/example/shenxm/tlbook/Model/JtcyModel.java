package com.example.shenxm.tlbook.Model;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class JtcyModel {
    String _id;
    String rybm;
    String hzmc;//关系
    String cyxm;//成员姓名
    String nl;//年龄
    String zzmm;//政治面貌
    String cygzdw;//成员工作单位
    String cyrq;//成员生日

    public JtcyModel(String _id,String rybm, String hzmc, String cyxm, String nl, String zzmm, String cygzdw, String cyrq) {
        this.rybm = rybm;
        this.hzmc = hzmc;
        this.cyxm = cyxm;
        this.nl = nl;
        this.zzmm = zzmm;
        this.cygzdw = cygzdw;
        this.cyrq = cyrq;
        this._id = _id;
    }

    public JtcyModel() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCyrq() {
        return cyrq;
    }

    public void setCyrq(String cyrq) {
        this.cyrq = cyrq;
    }

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm;
    }

    public String getHzmc() {
        return hzmc;
    }

    public void setHzmc(String hzmc) {
        this.hzmc = hzmc;
    }

    public String getCyxm() {
        return cyxm;
    }

    public void setCyxm(String cyxm) {
        this.cyxm = cyxm;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    public String getCygzdw() {
        return cygzdw;
    }

    public void setCygzdw(String cygzdw) {
        this.cygzdw = cygzdw;
    }

    public String getString(){
        return getHzmc()+"  "+getCyxm()+"   " +getNl()+"    "+getZzmm()+"   "+getCygzdw();
    }
}
