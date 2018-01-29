package com.example.shenxm.tlbook.Model;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class XitongModel {
    public String deptname;
    public String dept_id;
    public String code;

    public XitongModel(String deptname, String dept_id, String code) {
        this.deptname = deptname;
        this.dept_id = dept_id;
        this.code = code;
    }

    public String getDeptname() {
        return deptname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }
}
