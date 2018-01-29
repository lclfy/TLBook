package com.example.shenxm.tlbook.Dal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shenxm.tlbook.Model.XitongModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class XitongDal {

    public static List<XitongModel> getXitong(){
        SQLiteDatabase sdb = ComDal.GetDatabase();

        List<XitongModel> arrayList = new ArrayList<>();

        String qsql = "select DEPTNAME, DEPT_ID, CODE from RS_DEPT_TEMP where DEPT_P_ID='1' or DEPT_P_ID='0' order by SEQ";
        Cursor cur = sdb.rawQuery(qsql,null);
        while (cur.moveToNext()){
            XitongModel xitongModel = new XitongModel("","","");
            String deptname = cur.getString(cur.getColumnIndex("DEPTNAME"));
            String deptid = cur.getString(cur.getColumnIndex("DEPT_ID"));
            String code = cur.getString(cur.getColumnIndex("CODE"));
            xitongModel.deptname=deptname;
            xitongModel.dept_id=deptid;
            xitongModel.code = deptid;
            arrayList.add(xitongModel);


        }
        cur.close();

        return arrayList;
    }
}
