package com.example.shenxm.tlbook.Model;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class ZhuyaoXXModel {
    public String zhaopian;
    public String zhuyaoName;
    public String zhuyaoGender;
    public String zhuyaoPosition;
    public String zhuyaoRank;
    public String zhuyaoDob;
    public String zhuyaoEducation;
    public String zhuyaoDanweiMC;//单位名称
    public String nl;//年龄
    public String mzhz;//民族
    public String jg;//籍贯
    public String jrdprq;//加入党派日期
    public String cjgzrq;//参加工作日期
    public String zcmchz;//专业技术职务
    public String rxzrq;//任现级日期
    public String xjszwrq;//任职日期
    public String rybm;

    public ZhuyaoXXModel(String zhuyaoName, String zhuyaoGender, String zhuyaoPosition, String zhuyaoRank, String zhuyaoDob,String rybm,String zhuyaoDanweiMC, String zhuyaoEducation) {
        this.zhuyaoName = zhuyaoName;
        this.zhuyaoGender = zhuyaoGender;
        this.zhuyaoPosition = zhuyaoPosition;
        this.zhuyaoRank = zhuyaoRank;
        this.zhuyaoDob = zhuyaoDob;
        this.rybm = rybm;
        this.zhuyaoDanweiMC = zhuyaoDanweiMC;
        this.zhuyaoEducation = zhuyaoEducation;
    }

    public ZhuyaoXXModel(String zhuyaoName, String zhuyaoGender, String zhuyaoDob, String mzhz, String jg, String jrdprq, String cjgzrq, String zcmchz, String rxzrq, String xjszwrq, String rybm, String nl) {
        this.zhuyaoName = zhuyaoName;
        this.zhuyaoGender = zhuyaoGender;
        this.zhuyaoDob = zhuyaoDob;
        this.mzhz = mzhz;
        this.jg = jg;
        this.jrdprq = jrdprq;
        this.cjgzrq = cjgzrq;
        this.zcmchz = zcmchz;
        this.rxzrq = rxzrq;
        this.xjszwrq = xjszwrq;
        this.rybm = rybm;
        this.nl = nl;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getMzhz() {
        return mzhz;
    }

    public void setMzhz(String mzhz) {
        this.mzhz = mzhz;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getJrdprq() {
        return jrdprq;
    }

    public void setJrdprq(String jrdprq) {
        this.jrdprq = jrdprq;
    }

    public String getCjgzrq() {
        return cjgzrq;
    }

    public void setCjgzrq(String cjgzrq) {
        this.cjgzrq = cjgzrq;
    }

    public String getZcmchz() {
        return zcmchz;
    }

    public void setZcmchz(String zcmchz) {
        this.zcmchz = zcmchz;
    }

    public String getRxzrq() {
        return rxzrq;
    }

    public void setRxzrq(String rxzrq) {
        this.rxzrq = rxzrq;
    }

    public String getXjszwrq() {
        return xjszwrq;
    }

    public void setXjszwrq(String xjszwrq) {
        this.xjszwrq = xjszwrq;
    }

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm;
    }

    public String getZhaopian() {
        return zhaopian;
    }

    public void setZhaopian(String zhaopian) {
        this.zhaopian = zhaopian;
    }

    public String getZhuyaoName() {
        return zhuyaoName;
    }

    public void setZhuyaoName(String zhuyaoName) {
        this.zhuyaoName = zhuyaoName;
    }

    public String getZhuyaoGender() {
        return zhuyaoGender;
    }

    public void setZhuyaoGender(String zhuyaoGender) {
        this.zhuyaoGender = zhuyaoGender;
    }

    public String getZhuyaoPosition() {
        return zhuyaoPosition;
    }

    public void setZhuyaoPosition(String zhuyaoPosition) {
        this.zhuyaoPosition = zhuyaoPosition;
    }

    public String getZhuyaoRank() {
        return zhuyaoRank;
    }

    public void setZhuyaoRank(String zhuyaoRank) {
        this.zhuyaoRank = zhuyaoRank;
    }

    public String getZhuyaoDob() {
        return zhuyaoDob;
    }

    public void setZhuyaoDob(String zhuyaoDob) {
        this.zhuyaoDob = zhuyaoDob;
    }

    public String getZhuyaoEducation() {
        return zhuyaoEducation;
    }

    public void setZhuyaoEducation(String zhuyaoEducation) {
        this.zhuyaoEducation = zhuyaoEducation;
    }

    public String getZhuyaoDanweiMC() {
        return zhuyaoDanweiMC;
    }

    public void setZhuyaoDanweiMC(String zhuyaoDanweiMC) {
        this.zhuyaoDanweiMC = zhuyaoDanweiMC;
    }

    public String getString(){
        if (zhuyaoName.length()==2){
            return zhuyaoName + "                 " + zhuyaoGender +"             "+zhuyaoDob  +"           " + zhuyaoRank +"         "+zhuyaoEducation+"         "+zhuyaoDanweiMC+" "+zhuyaoPosition;
        }else{
            return zhuyaoName + "             " + zhuyaoGender +"             " +zhuyaoDob  +"           " + zhuyaoRank +"          "+zhuyaoEducation+"         " +zhuyaoDanweiMC+" "+zhuyaoPosition;}
    }
}
