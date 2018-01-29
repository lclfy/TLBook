package com.example.shenxm.tlbook.Dal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shenxm.tlbook.Model.DanweiModel;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class DanweiDal {

    public static List<DanweiModel> getDanwei(String xitong){
        SQLiteDatabase sdb = ComDal.GetDatabase();

        List<DanweiModel> arrayList = new ArrayList<>();

        String qsql = "select DEPTNAME, DEPT_ID,CODE from RS_DEPT_TEMP where DEPT_P_ID='"+xitong+"' order by SEQ";
        Cursor cur = sdb.rawQuery(qsql,null);
        while (cur.moveToNext()){
            DanweiModel danweiModel = new DanweiModel("","","");
            String deptname = cur.getString(cur.getColumnIndex("DEPTNAME"));
            String deptid = cur.getString(cur.getColumnIndex("DEPT_ID"));
            String depcode = cur.getString(cur.getColumnIndex("CODE"));
            danweiModel.danweiname=deptname;
            danweiModel.danweiid=deptid;
            danweiModel.danweiCode=depcode;
            arrayList.add(danweiModel);

        }
        cur.close();

        return arrayList;
    }
}
