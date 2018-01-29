package com.example.shenxm.tlbook.Dal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.shenxm.tlbook.Model.DanweiModel;
import com.example.shenxm.tlbook.Model.JianliModel;
import com.example.shenxm.tlbook.Model.JtcyModel;
import com.example.shenxm.tlbook.Model.ListModel;
import com.example.shenxm.tlbook.Model.XlxxModel;
import com.example.shenxm.tlbook.Model.ZhuyaoXXModel;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class PersonsDal {
    public static List<ListModel> getPersons(String code, String deptname, String range) {
        String ran = convertRange(range);
        SQLiteDatabase sdb = ComDal.GetDatabase();
        String[] str = deptname.split(":");
        System.out.println("name " + str[0] + "id " + str[1]);
        if (str[0].equals("郑州铁路局领导")) {
            str[0] = "中国铁路郑州局集团有限公司";
        }
        String xtbm = "70,116,120,55,56,54,51,134,1224,1459,1459,1464,1443,1229,1210,1744";
        Cursor cur;
        List<ListModel> arrayList = new ArrayList<>();


        if (xtbm.indexOf(str[1]) != -1) {
            System.out.println("code " + code);
            Cursor dwcur = sdb.rawQuery("SELECT * FROM RS_DEPT_TEMP WHERE CODE LIKE '" + code + "%'", null);
            ArrayList<String> dwlist = new ArrayList<String>();
            if (dwcur != null) {
                if (dwcur.moveToFirst()) {
                    do {
                        String dw = dwcur.getString(dwcur.getColumnIndex("DEPTNAME"));
                        dwlist.add(dw);
                    } while (dwcur.moveToNext());
                }
            }
            if (dwlist.size() != 0) {
                String cond = "where ";
                for (int j = 0; j < dwlist.size(); j++) {
                    if (j == dwlist.size() - 1) {
                        cond = cond + "a.DWMC LIKE '%" + dwlist.get(j).toString() + "%' ";

                    } else {
                        cond = cond + "a.DWMC LIKE '%" + dwlist.get(j).toString() + "%' OR ";
                    }
                }
                cond = cond + "and " + ran;
                //System.out.println("4 SELECT RYBM as _id, XM, XBHZ, CSRQ, NL,MZHZ,JG,CSD, JRDPRQ,CJGZRQ,JKQKHZ,ZCMCHZ,WHCDHZ,XWMCHZ,DWMC,XSBMMC,ZWMCHZ,ZZMMHZ,XDZZWRQ,RXZRQ,XJSZWRQ,SFZH,ZWJB,JBHZ,ZWJBHZQC,XJSZWMC, ZWMC,HYHZ FROM RS_JBXX_TEMP1 "+cond+"  order by ZWJBHZQC desc");
                System.out.println("4 SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ, a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZWMCHZ,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ, b.RYXH FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b " + cond + " and a.rybm=b.rybm order by a.gldwlb is null, a.GLDWLB ASC, b.RYXH is null, b.RYXH ASC");
                cur = sdb.rawQuery("SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ, a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ, b.RYXH, ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b,RS_XRZW_TEMP d " + cond + " and a.rybm =b.rybm and a.rybm=d.rybm order by a.gldwlb is null, a.GLDWLB ASC, b.RYXH is null, b.RYXH ASC", null);
            } else {
                //cur = database.rawQuery("SELECT a.RYBM as _id, XM, XBHZ, CSRQ, NL,MZHZ,JG,CSD, JRDPRQ,CJGZRQ,JKQKHZ,ZCMCHZ,WHCDHZ,XWMCHZ,DWMC,XSBMMC,ZWMCHZ,ZZMMHZ,XDZZWRQ,RXZRQ,XJSZWRQ,SFZH,ZWJB,JBHZ,ZWJBHZQC,XJSZWMC, ZWMC,HYHZ FROM RS_JBXX_TEMP1 where 1!=1 and "+ran+" order by ZWJBHZQC desc",null);
                cur = sdb.rawQuery("SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ, a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ, b.RYXH, a.RYLBHZ, ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b,RS_XRZW_TEMP d where 1!=1 and a.rybm=b.rybm and a.rybm=d.rybm " + ran + "  order by a.gldwlb is null, a.GLDWLB ASC, b.RYXH is null, b.RYXH ASC", null);

            }

        } else if (str[0] == "中国铁路郑州局集团有限公司") {
            System.out.println("5 SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ,a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZWMCHZ,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ,b.RYXH,a.RYLBHZ,d.BCZWHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b, RS_XRZW_TEMP d where a.DWMC like '" + str[0] + "' and a.rylbhz <> '二线工作' and a.rybm = b.rybm and a.rybm = d.rybm order by a.gldwlb is null, a.GLDWLB ASC, b.RYXH is null, b.RYXH ASC");
            //cur = database.rawQuery("SELECT RYBM as _id, XM, XBHZ, CSRQ,NL,MZHZ,JG,CSD, JRDPRQ,CJGZRQ,JKQKHZ,ZCMCHZ,WHCDHZ,XWMCHZ,DWMC,XSBMMC,ZWMCHZ,ZZMMHZ,XDZZWRQ,RXZRQ,XJSZWRQ,SFZH,ZWJB,JBHZ,ZWJBHZQC,XJSZWMC, ZWMC,HYHZ FROM RS_JBXX_TEMP1 where DWMC like '"+str[0]+"'and ldrpx is not null order by ldrpx",null);

            cur = sdb.rawQuery("SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ,a.NL,a.MZHZ,a.DWMC,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ,b.RYXH,a.RYLBHZ,a.ZWMCHZ,ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b, RS_XRZW_TEMP d where a.DWMC like '" + str[0] + "' and a.rylbhz <> '二线工作' and a.rybm = b.rybm and a.rybm = d.rybm order by a.gldwlb is null, a.GLDWLB ASC, b.RYXH is null, b.RYXH ASC", null);

        } else {
            System.out.println("6 SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ,a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ,b.RYXH, ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b, RS_XRZW_TEMP d where (a.DWMC like '%" + str[0] + "%' or a.DWMC in (SELECT c.EJJGHZ FROM RS_EJJG_TEMP c WHERE c.YJCSHZ LIKE '%" + str[0] + "%')) and a.rybm = b.rybm and a.rybm = d.rybm and " + ran + " order by a.gldwlb is null, a.GLDWLB ASC, b.RYXH is null, b.RYXH ASC");
            //cur = database.rawQuery("SELECT RYBM as _id, XM, XBHZ, CSRQ,NL,MZHZ,JG,CSD, JRDPRQ,CJGZRQ,JKQKHZ,ZCMCHZ,WHCDHZ,XWMCHZ,DWMC,XSBMMC,ZWMCHZ,ZZMMHZ,XDZZWRQ,RXZRQ,XJSZWRQ,SFZH,ZWJB,JBHZ,ZWJBHZQC,XJSZWMC, ZWMC,HYHZ  FROM RS_JBXX_TEMP1 where (DWMC like '%"+str[0]+"%' or DWMC in (SELECT EJJGHZ FROM RS_EJJG_TEMP WHERE YJCSHZ LIKE '%"+str[0]+"%')) and "+ran+"  order by ZWJBHZQC desc",null);}
            cur = sdb.rawQuery("SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ,a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ,b.RYXH, ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b, RS_XRZW_TEMP d where (a.DWMC like '%" + str[0] + "%' or a.DWMC in (SELECT c.EJJGHZ FROM RS_EJJG_TEMP c WHERE c.YJCSHZ LIKE '%" + str[0] + "%')) and a.rybm = b.rybm and a.rybm = d.rybm and " + ran + " order by a.gldwlb is null, a.GLDWLB ASC, b.RYXH is null, b.RYXH ASC", null);
        }


        while (cur.moveToNext()) {
            ListModel danweiModel = new ListModel();
            String _id = cur.getString(cur.getColumnIndex("_id"));
            String XM = cur.getString(cur.getColumnIndex("XM"));
            String XBHZ = cur.getString(cur.getColumnIndex("XBHZ"));
            String CSRQ = cur.getString(cur.getColumnIndex("CSRQ"));
            String NL = cur.getString(cur.getColumnIndex("NL"));
            String MZHZ = cur.getString(cur.getColumnIndex("MZHZ"));
            String JG = cur.getString(cur.getColumnIndex("JG"));
            String CSD = cur.getString(cur.getColumnIndex("CSD"));
            String JRDPRQ = cur.getString(cur.getColumnIndex("JRDPRQ"));
            String CJGZRQ = cur.getString(cur.getColumnIndex("CJGZRQ"));
            String JKQKHZ = cur.getString(cur.getColumnIndex("JKQKHZ"));
            String ZCMCHZ = cur.getString(cur.getColumnIndex("ZCMCHZ"));
            String WHCDHZ = cur.getString(cur.getColumnIndex("WHCDHZ"));
            String XWMCHZ = cur.getString(cur.getColumnIndex("XWMCHZ"));
            String DWMC = cur.getString(cur.getColumnIndex("DWMC"));
            String XSBMMC = cur.getString(cur.getColumnIndex("XSBMMC"));
            String ZZMMHZ = cur.getString(cur.getColumnIndex("ZZMMHZ"));
            String XDZZWRQ = cur.getString(cur.getColumnIndex("XDZZWRQ"));
            String RXZRQ = cur.getString(cur.getColumnIndex("RXZRQ"));
            String XJSZWRQ = cur.getString(cur.getColumnIndex("XJSZWRQ"));
            String SFZH = cur.getString(cur.getColumnIndex("SFZH"));
            String ZWJB = cur.getString(cur.getColumnIndex("ZWJB"));
            String JBHZ = cur.getString(cur.getColumnIndex("JBHZ"));
            String ZWJBHZQC = cur.getString(cur.getColumnIndex("ZWJBHZQC"));
            String XJSZWMC = cur.getString(cur.getColumnIndex("XJSZWMC"));
            String ZWMC = cur.getString(cur.getColumnIndex("ZWMC"));
            String HYHZ = cur.getString(cur.getColumnIndex("HYHZ"));
            String RYXH = cur.getString(cur.getColumnIndex("RYXH"));
            String ZWMCHZ = cur.getString(cur.getColumnIndex("ZWMCHZ"));


            danweiModel._id = _id;
            danweiModel.XM = XM;
            danweiModel.XBHZ = XBHZ;
            danweiModel.CSRQ = CSRQ;
            danweiModel.NL = NL;
            danweiModel.MZHZ = MZHZ;
            danweiModel.JG = JG;
            danweiModel.CSD = CSD;
            danweiModel.JRDPRQ = JRDPRQ;
            danweiModel.CJGZRQ = CJGZRQ;
            danweiModel.JKQKHZ = JKQKHZ;
            danweiModel.ZCMCHZ = ZCMCHZ;
            danweiModel.WHCDHZ = WHCDHZ;
            danweiModel.XWMCHZ = XWMCHZ;
            danweiModel.DWMC = DWMC;
            danweiModel.XSBMMC = XSBMMC;
            danweiModel.ZZMMHZ = ZZMMHZ;
            danweiModel.XDZZWRQ = XDZZWRQ;
            danweiModel.RXZRQ = RXZRQ;
            danweiModel.XJSZWRQ = XJSZWRQ;
            danweiModel.SFZH = SFZH;
            danweiModel.ZWJB = ZWJB;
            danweiModel.JBHZ = JBHZ;
            danweiModel.ZWJBHZQC = ZWJBHZQC;
            danweiModel.XJSZWMC = XJSZWMC;
            danweiModel.ZWMC = ZWMC;
            danweiModel.HYHZ = HYHZ;
            danweiModel.RYXH = RYXH;
            danweiModel.ZWMCHZ = ZWMCHZ;

            arrayList.add(danweiModel);

        }
        cur.close();

        return arrayList;
    }

    public static List<ListModel> getZhuYaoCursorRange(String deptPlusname, String ranage) {
        deptPlusname = deptPlusname.replaceAll(" ", "");
        SQLiteDatabase sdb = ComDal.GetDatabase();
        String ran = convertRange(ranage);

        String sqlstr = "SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ, a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ, b.RYXH,ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ  FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b,RS_XRZW_TEMP d where instr(a.XM,'" + deptPlusname + "') and a.rybm = b.rybm and a.rybm = d.rybm and " + ran + " order by a.gldwlb is null, a.GLDWLB ASC, b.RYXH is null, b.RYXH ASC ";

        Cursor cur = sdb.rawQuery(sqlstr, null);
        List<ListModel> arrayList = new ArrayList<>();

        while (cur.moveToNext()) {
            ListModel danweiModel = new ListModel();
            String _id = cur.getString(cur.getColumnIndex("_id"));
            String XM = cur.getString(cur.getColumnIndex("XM"));
            String XBHZ = cur.getString(cur.getColumnIndex("XBHZ"));
            String CSRQ = cur.getString(cur.getColumnIndex("CSRQ"));
            String NL = cur.getString(cur.getColumnIndex("NL"));
            String MZHZ = cur.getString(cur.getColumnIndex("MZHZ"));
            String JG = cur.getString(cur.getColumnIndex("JG"));
            String CSD = cur.getString(cur.getColumnIndex("CSD"));
            String JRDPRQ = cur.getString(cur.getColumnIndex("JRDPRQ"));
            String CJGZRQ = cur.getString(cur.getColumnIndex("CJGZRQ"));
            String JKQKHZ = cur.getString(cur.getColumnIndex("JKQKHZ"));
            String ZCMCHZ = cur.getString(cur.getColumnIndex("ZCMCHZ"));
            String WHCDHZ = cur.getString(cur.getColumnIndex("WHCDHZ"));
            String XWMCHZ = cur.getString(cur.getColumnIndex("XWMCHZ"));
            String DWMC = cur.getString(cur.getColumnIndex("DWMC"));
            String XSBMMC = cur.getString(cur.getColumnIndex("XSBMMC"));
            String ZZMMHZ = cur.getString(cur.getColumnIndex("ZZMMHZ"));
            String XDZZWRQ = cur.getString(cur.getColumnIndex("XDZZWRQ"));
            String RXZRQ = cur.getString(cur.getColumnIndex("RXZRQ"));
            String XJSZWRQ = cur.getString(cur.getColumnIndex("XJSZWRQ"));
            String SFZH = cur.getString(cur.getColumnIndex("SFZH"));
            String ZWJB = cur.getString(cur.getColumnIndex("ZWJB"));
            String JBHZ = cur.getString(cur.getColumnIndex("JBHZ"));
            String ZWJBHZQC = cur.getString(cur.getColumnIndex("ZWJBHZQC"));
            String XJSZWMC = cur.getString(cur.getColumnIndex("XJSZWMC"));
            String ZWMC = cur.getString(cur.getColumnIndex("ZWMC"));
            String HYHZ = cur.getString(cur.getColumnIndex("HYHZ"));
            String RYXH = cur.getString(cur.getColumnIndex("RYXH"));
            String ZWMCHZ = cur.getString(cur.getColumnIndex("ZWMCHZ"));


            danweiModel._id = _id;
            danweiModel.XM = XM;
            danweiModel.XBHZ = XBHZ;
            danweiModel.CSRQ = CSRQ;
            danweiModel.NL = NL;
            danweiModel.MZHZ = MZHZ;
            danweiModel.JG = JG;
            danweiModel.CSD = CSD;
            danweiModel.JRDPRQ = JRDPRQ;
            danweiModel.CJGZRQ = CJGZRQ;
            danweiModel.JKQKHZ = JKQKHZ;
            danweiModel.ZCMCHZ = ZCMCHZ;
            danweiModel.WHCDHZ = WHCDHZ;
            danweiModel.XWMCHZ = XWMCHZ;
            danweiModel.DWMC = DWMC;
            danweiModel.XSBMMC = XSBMMC;
            danweiModel.ZZMMHZ = ZZMMHZ;
            danweiModel.XDZZWRQ = XDZZWRQ;
            danweiModel.RXZRQ = RXZRQ;
            danweiModel.XJSZWRQ = XJSZWRQ;
            danweiModel.SFZH = SFZH;
            danweiModel.ZWJB = ZWJB;
            danweiModel.JBHZ = JBHZ;
            danweiModel.ZWJBHZQC = ZWJBHZQC;
            danweiModel.XJSZWMC = XJSZWMC;
            danweiModel.ZWMC = ZWMC;
            danweiModel.HYHZ = HYHZ;
            danweiModel.RYXH = RYXH;
            danweiModel.ZWMCHZ = ZWMCHZ;
            arrayList.add(danweiModel);
        }
        cur.close();
        return arrayList;

    }

    private static String convertRange(String range) {
        if (range.equals("全部")) {
            return "1=1";
        } else if (range.equals("领导人员")) {
            return "a.xsbmmc <> '减少人员' and a.rylbhz = '在岗工作' and a.gldwlb in ('031','021')";
        } else if (range.equals("其他干部")) {
            return "(a.gldwlb in ('032','040','041') and a.rylbhz = '在岗工作' and a.xsbmmc <> '减少人员')";
        } else if (range.equals("减少人员")) {
            return "a.xsbmmc = '减少人员'";
        } else if (range.equals("二线人员")) {
            return "a.rylbhz = '二线工作' and a.xsbmmc <> '减少人员'";
        }
        return null;
    }

    public static ZhuyaoXXModel getDetailXX(String rybm) {
        SQLiteDatabase sdb = ComDal.GetDatabase();

        String sqlstr = "SELECT * FROM RS_JBXX_TEMP1 WHERE RYBM ='" + rybm + "'";
        Cursor cur = sdb.rawQuery(sqlstr, null);
        ZhuyaoXXModel zhuyaoXXModel = new ZhuyaoXXModel("", "", "", "", "", "", "", "", "", "", "", "");
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    String name = cur.getString(cur.getColumnIndex("XM"));
                    String gender = cur.getString(cur.getColumnIndex("XBHZ"));
                    String position = cur.getString(cur.getColumnIndex("ZWMCHZ"));
                    String rank = cur.getString(cur.getColumnIndex("JBHZ"));
                    String dob = cur.getString(cur.getColumnIndex("CSRQ"));
                    String rybm1 = cur.getString(cur.getColumnIndex("RYBM"));
                    String mzhz = cur.getString(cur.getColumnIndex("MZHZ"));
                    String jg = cur.getString(cur.getColumnIndex("JG"));
                    String jrdprq = cur.getString(cur.getColumnIndex("JRDPRQ"));
                    String cjgzrq = cur.getString(cur.getColumnIndex("CJGZRQ"));
                    String zcmchz = cur.getString(cur.getColumnIndex("ZCMCHZ"));
                    String rxzrq = cur.getString(cur.getColumnIndex("RXZRQ"));
                    String xjszwrq = cur.getString(cur.getColumnIndex("XDZZWRQ"));
                    String nl = cur.getString(cur.getColumnIndex("NL"));

                    zhuyaoXXModel.setZhuyaoName(name);
                    zhuyaoXXModel.setZhuyaoGender(gender);
                    zhuyaoXXModel.setZhuyaoPosition(position);
                    zhuyaoXXModel.setZhuyaoRank(rank);
                    zhuyaoXXModel.setZhuyaoDob(dob);
                    zhuyaoXXModel.setRybm(rybm1);
                    zhuyaoXXModel.setCjgzrq(cjgzrq);
                    zhuyaoXXModel.setJg(jg);
                    zhuyaoXXModel.setJrdprq(jrdprq);
                    zhuyaoXXModel.setMzhz(mzhz);
                    zhuyaoXXModel.setRxzrq(rxzrq);
                    zhuyaoXXModel.setXjszwrq(xjszwrq);
                    zhuyaoXXModel.setZcmchz(zcmchz);
                    zhuyaoXXModel.setNl(nl + "岁");
                } while (cur.moveToNext());
            }
            cur.close();
            return zhuyaoXXModel;
        } else {
            cur.close();
            return zhuyaoXXModel;
        }
    }

    public static String getXrzwDetail(String rybm) {
        String xrzw = "";
        SQLiteDatabase sdb = ComDal.GetDatabase();

        try {
            Cursor cur = sdb.rawQuery("SELECT * FROM RS_XRZW_TEMP WHERE RYBM = '" + rybm + "'", null);

            if (cur != null) {
                cur.moveToFirst();
                xrzw = cur.getString(cur.getColumnIndex("XRZWHZ"));
                if (xrzw == null) {
                    xrzw = "";
                }
                cur.close();
                return xrzw;
            } else {
                cur.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return xrzw;
        }
    }

    //xueli
    public static XlxxModel getXlxx(String rybm) {
        SQLiteDatabase sdb = ComDal.GetDatabase();
        Cursor cur = sdb.rawQuery("SELECT * FROM RS_XLXX_TEMP WHERE RYBM ='" + rybm + "'", null);
        XlxxModel xlxxModel = new XlxxModel();
        String qrzjy = "";//全日制学位
        String qrzwhcdmc = "";
        String qrzyx = "";//全日制毕业院校
        String qrzzy = "";//全日制毕业专业
        String zzjy = "";//在职学位
        String zzwhcdmc = "";
        String zzyx = "";//在职毕业院校
        String zzzy = "";//在职毕业专业
        if (cur != null) {
            if (cur.moveToFirst()) {
                qrzwhcdmc = cur.getString(cur.getColumnIndex("WHCDMC"));
                qrzjy = cur.getString(cur.getColumnIndex("XWMCMC"));
                qrzyx = cur.getString(cur.getColumnIndex("BYDW"));
                qrzzy = cur.getString(cur.getColumnIndex("SXZY"));
                if (cur.getString(cur.getColumnIndex("WHCDMC")) == null) {
                    qrzwhcdmc = "";
                }
                if (cur.getString(cur.getColumnIndex("BYDW")) == null) {
                    qrzyx = "";
                }
                if (cur.getString(cur.getColumnIndex("SXZY")) == null) {
                    qrzzy = "";
                }
                if (cur.getString(cur.getColumnIndex("XWMCMC")) == null) {
                    qrzjy = "";
                }

            }
        }
        Cursor cur1 = sdb.rawQuery("SELECT * FROM RS_XLXX2_TEMP WHERE RYBM ='" + rybm + "'", null);
        if (cur1 != null) {
            if (cur1.moveToFirst()) {
                zzjy = cur1.getString(cur1.getColumnIndex("XWMCMC"));
                zzwhcdmc = cur1.getString(cur1.getColumnIndex("WHCDMC"));
                zzyx = cur1.getString(cur1.getColumnIndex("BYDW"));
                zzzy = cur1.getString(cur1.getColumnIndex("SXZY"));
                // System.out.println("zzzy" + cur1.getString(cur1.getColumnIndex("SXZY")));
                if (cur1.getString(cur1.getColumnIndex("WHCDMC")) == null) {
                    zzwhcdmc = "";
                }
                if (cur1.getString(cur1.getColumnIndex("BYDW")) == null) {
                    zzyx = "";
                }
                if (cur1.getString(cur1.getColumnIndex("SXZY")) == null) {
                    zzzy = "";
                }
                if (cur1.getString(cur1.getColumnIndex("XWMCMC")) == null) {
                    zzjy = "";
                }
            }
        }

        xlxxModel = new XlxxModel(zzzy, qrzjy, qrzyx, qrzzy, zzjy, zzyx, rybm, qrzwhcdmc, zzwhcdmc);
        cur.close();
        cur1.close();
        return xlxxModel;
    }
//jian li

    public static ArrayList<JianliModel> getJianli(String rybm) {
        SQLiteDatabase sdb = ComDal.GetDatabase();
        Cursor cur = sdb.rawQuery("SELECT * FROM RS_JL_TEMP WHERE RYBM ='" + rybm + "'ORDER BY QSRQ ASC", null);
        JianliModel jianliModel = new JianliModel();
        ArrayList<JianliModel> arrayList = new ArrayList<JianliModel>();
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    jianliModel = new JianliModel("", "", "", "");
                    String qsrq = cur.getString(cur.getColumnIndex("QSRQ"));
                    String zzrq = cur.getString(cur.getColumnIndex("ZZRQ"));
                    String bdms = cur.getString(cur.getColumnIndex("BDMS"));
                    jianliModel.setBDMS(bdms);
                    jianliModel.setZzrq(zzrq);
                    jianliModel.setQsrq(qsrq);
                    jianliModel.setRybm(rybm);
                    arrayList.add(jianliModel);
                } while (cur.moveToNext());
            }
            cur.close();
            return arrayList;
        } else {
            cur.close();
            return null;
        }
    }

    //jtcy
    public static Cursor getJtcyCursor(String rybm) {
        SQLiteDatabase sdb = ComDal.GetDatabase();
        Cursor cur = sdb.rawQuery("SELECT JT_ID as _id,RS_JTGX_TEMP.RYBM,RS_JTGX_TEMP.HZMC, RS_JTGX_TEMP.CYXM, RS_JTGX_TEMP.CYRQ, RS_JTGX_TEMP.ZZMM, RS_JTGX_TEMP.CYGZDW, RS_JTGX_TEMP.CYRQ FROM RS_JTGX_TEMP WHERE RYBM ='" + rybm + "'", null);
        if (cur != null) {
            if (cur.moveToFirst()) {//System.out.println("cur" + cur.getCount());
            }
            return cur;
        } else {
            return null;
        }
    }

    //zhao pian
    public static Bitmap getBmp(String rybm) {
        SQLiteDatabase sdb = ComDal.GetDatabase();
        Cursor cur = sdb.rawQuery("SELECT * FROM RS_ZP WHERE RYBM ='" + rybm + "'", null);
        if (cur != null) {
            if (cur.moveToFirst()) {
                byte[] in = cur.getBlob(cur.getColumnIndex("GRZP"));
                Bitmap bmpout = BitmapFactory.decodeByteArray(in, 0, in.length);
                cur.close();
                return bmpout;
            }
        }
        cur.close();
        return null;

    }

    //kao he
    public static Cursor getKaoheCursor(String rybm) {
        SQLiteDatabase sdb = ComDal.GetDatabase();
        Cursor cur = sdb.rawQuery("SELECT kcqk,kcsj,kclb,kccl,kcyj FROM RS_ZZKCXX_TEMP WHERE rybm = '" + rybm + "' order by kcsj", null);
        if (cur != null) {
            if (cur.moveToFirst()) {
                //System.out.println("Kao He Found");
                return cur;
            } else {
                return null;
            }
        } else {
            cur.close();
            return null;
        }
    }

    public static String convertLB(String kclb) {
        String lbhz = "";
        if (kclb == null) {
            kclb = "null";
        }
        //System.out.println("kclb :" + kclb +":");
        switch (kclb) {
            case "01":
                lbhz = "领导班子换届考察";
                break;
            case "02":
                lbhz = "届中考察";
                break;
            case "03":
                lbhz = "人选考察";
                break;
            case "04":
                lbhz = "后备干部建议人选考察";
                break;
            case "05":
                lbhz = "其他考察";
                break;
            case "06":
                lbhz = "年度考核";
                break;
            case "07":
                lbhz = "职代会民主评议";
                break;
            case "08":
                lbhz = "单位考核";
                break;
            case "09":
                lbhz = "试用期满考核";
                break;
            case "10":
                lbhz = "其他考察考核";
                break;
            case "null":
                lbhz = "";
                break;
            default:
                lbhz = "";
        }
        return lbhz;

    }

    //按条件排序
    public static List<ListModel> getSortedCursor(String code, String deptname, String search, String columname, int sort, String ranage) {
        search = search.replaceAll(" ", "");
        String ran = convertRange(ranage);
        SQLiteDatabase sdb = ComDal.GetDatabase();
        String[] str = deptname.split(":");
        System.out.println("name " + str[0] + "id " + str[1]);
        String order = "desc";
        if (str[0].equals("郑州铁路局领导")) {
            str[0] = "中国铁路郑州局集团有限公司";
        }
        String xtbm = "70,116,120,55,56,54,51,134,1224,1459,1459,1464,1443,1229,1210,1744";
        Cursor cur;
        List<ListModel> arrayList = new ArrayList<>();
        if (sort == 1) {
            order = "asc";
        }

        if (xtbm.indexOf(str[1]) != -1) {
            System.out.println("code " + code);
            Cursor dwcur = sdb.rawQuery("SELECT * FROM RS_DEPT_TEMP WHERE CODE LIKE '" + code + "%'", null);
            ArrayList<String> dwlist = new ArrayList<String>();
            if (dwcur != null) {
                if (dwcur.moveToFirst()) {
                    do {
                        String dw = dwcur.getString(dwcur.getColumnIndex("DEPTNAME"));
                        dwlist.add(dw);
                    } while (dwcur.moveToNext());
                }
            }
            if (dwlist.size() != 0) {
                String cond = "where ";
                for (int j = 0; j < dwlist.size(); j++) {
                    if (j == dwlist.size() - 1) {
                        cond = cond + "a.DWMC LIKE '%" + dwlist.get(j).toString() + "%' ";

                    } else {
                        cond = cond + "a.DWMC LIKE '%" + dwlist.get(j).toString() + "%' OR ";
                    }
                }
                cond = cond + "and " + ran;
                //System.out.println("4 SELECT RYBM as _id, XM, XBHZ, CSRQ, NL,MZHZ,JG,CSD, JRDPRQ,CJGZRQ,JKQKHZ,ZCMCHZ,WHCDHZ,XWMCHZ,DWMC,XSBMMC,ZWMCHZ,ZZMMHZ,XDZZWRQ,RXZRQ,XJSZWRQ,SFZH,ZWJB,JBHZ,ZWJBHZQC,XJSZWMC, ZWMC,HYHZ FROM RS_JBXX_TEMP1 "+cond+"  order by ZWJBHZQC desc");
                System.out.println("4 SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ, a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZWMCHZ,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ, b.RYXH FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b " + cond + " and a.rybm=b.rybm order by b.RYXH");
                cur = sdb.rawQuery("SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ, a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ, b.RYXH, ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b,RS_XRZW_TEMP d " + cond + " and a.rybm =b.rybm and a.rybm=d.rybm order by a." + columname + " " + order, null);
            } else {
                //cur = database.rawQuery("SELECT a.RYBM as _id, XM, XBHZ, CSRQ, NL,MZHZ,JG,CSD, JRDPRQ,CJGZRQ,JKQKHZ,ZCMCHZ,WHCDHZ,XWMCHZ,DWMC,XSBMMC,ZWMCHZ,ZZMMHZ,XDZZWRQ,RXZRQ,XJSZWRQ,SFZH,ZWJB,JBHZ,ZWJBHZQC,XJSZWMC, ZWMC,HYHZ FROM RS_JBXX_TEMP1 where 1!=1 and "+ran+" order by ZWJBHZQC desc",null);
                cur = sdb.rawQuery("SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ, a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ, b.RYXH, a.RYLBHZ, ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b,RS_XRZW_TEMP d where 1!=1 and a.rybm=b.rybm and a.rybm=d.rybm " + ran + "  order by a." + columname + " " + order, null);

            }

        } else if (str[0] == "中国铁路郑州局集团有限公司") {
            System.out.println("5 SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ,a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZWMCHZ,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ,b.RYXH,a.RYLBHZ,d.BCZWHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b, RS_XRZW_TEMP d where a.DWMC like '" + str[0] + "' and a.rylbhz <> '二线工作' and a.rybm = b.rybm and a.rybm = d.rybm order by a.gldwlb, b.ryxh");
            //cur = database.rawQuery("SELECT RYBM as _id, XM, XBHZ, CSRQ,NL,MZHZ,JG,CSD, JRDPRQ,CJGZRQ,JKQKHZ,ZCMCHZ,WHCDHZ,XWMCHZ,DWMC,XSBMMC,ZWMCHZ,ZZMMHZ,XDZZWRQ,RXZRQ,XJSZWRQ,SFZH,ZWJB,JBHZ,ZWJBHZQC,XJSZWMC, ZWMC,HYHZ FROM RS_JBXX_TEMP1 where DWMC like '"+str[0]+"'and ldrpx is not null order by ldrpx",null);

            cur = sdb.rawQuery("SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ,a.NL,a.MZHZ,a.DWMC,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ,b.RYXH,a.RYLBHZ,a.ZWMCHZ,ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b, RS_XRZW_TEMP d where a.DWMC like '" + str[0] + "' and a.rylbhz <> '二线工作' and a.rybm = b.rybm and a.rybm = d.rybm order by a." + columname + " " + order, null);

        } else {
            System.out.println("6 SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ,a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ,b.RYXH, ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b, RS_XRZW_TEMP d where (a.DWMC like '%" + str[0] + "%' or a.DWMC in (SELECT c.EJJGHZ FROM RS_EJJG_TEMP c WHERE c.YJCSHZ LIKE '%" + str[0] + "%')) and a.rybm = b.rybm and a.rybm = d.rybm and " + ran + " order by a." + columname + " " + order);
            //cur = database.rawQuery("SELECT RYBM as _id, XM, XBHZ, CSRQ,NL,MZHZ,JG,CSD, JRDPRQ,CJGZRQ,JKQKHZ,ZCMCHZ,WHCDHZ,XWMCHZ,DWMC,XSBMMC,ZWMCHZ,ZZMMHZ,XDZZWRQ,RXZRQ,XJSZWRQ,SFZH,ZWJB,JBHZ,ZWJBHZQC,XJSZWMC, ZWMC,HYHZ  FROM RS_JBXX_TEMP1 where (DWMC like '%"+str[0]+"%' or DWMC in (SELECT EJJGHZ FROM RS_EJJG_TEMP WHERE YJCSHZ LIKE '%"+str[0]+"%')) and "+ran+"  order by ZWJBHZQC desc",null);}
            cur = sdb.rawQuery("SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ,a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC, a.ZWMC,a.HYHZ,b.RYXH, ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ FROM RS_JBXX_TEMP1 a, RS_ZGJBXX_NEW b, RS_XRZW_TEMP d where (a.DWMC like '%" + str[0] + "%' or a.DWMC in (SELECT c.EJJGHZ FROM RS_EJJG_TEMP c WHERE c.YJCSHZ LIKE '%" + str[0] + "%')) and a.rybm = b.rybm and a.rybm = d.rybm and " + ran + " order by a." + columname + " " + order, null);
        }


        while (cur.moveToNext()) {
            ListModel danweiModel = new ListModel();
            String _id = cur.getString(cur.getColumnIndex("_id"));
            String XM = cur.getString(cur.getColumnIndex("XM"));
            String XBHZ = cur.getString(cur.getColumnIndex("XBHZ"));
            String CSRQ = cur.getString(cur.getColumnIndex("CSRQ"));
            String NL = cur.getString(cur.getColumnIndex("NL"));
            String MZHZ = cur.getString(cur.getColumnIndex("MZHZ"));
            String JG = cur.getString(cur.getColumnIndex("JG"));
            String CSD = cur.getString(cur.getColumnIndex("CSD"));
            String JRDPRQ = cur.getString(cur.getColumnIndex("JRDPRQ"));
            String CJGZRQ = cur.getString(cur.getColumnIndex("CJGZRQ"));
            String JKQKHZ = cur.getString(cur.getColumnIndex("JKQKHZ"));
            String ZCMCHZ = cur.getString(cur.getColumnIndex("ZCMCHZ"));
            String WHCDHZ = cur.getString(cur.getColumnIndex("WHCDHZ"));
            String XWMCHZ = cur.getString(cur.getColumnIndex("XWMCHZ"));
            String DWMC = cur.getString(cur.getColumnIndex("DWMC"));
            String XSBMMC = cur.getString(cur.getColumnIndex("XSBMMC"));
            String ZZMMHZ = cur.getString(cur.getColumnIndex("ZZMMHZ"));
            String XDZZWRQ = cur.getString(cur.getColumnIndex("XDZZWRQ"));
            String RXZRQ = cur.getString(cur.getColumnIndex("RXZRQ"));
            String XJSZWRQ = cur.getString(cur.getColumnIndex("XJSZWRQ"));
            String SFZH = cur.getString(cur.getColumnIndex("SFZH"));
            String ZWJB = cur.getString(cur.getColumnIndex("ZWJB"));
            String JBHZ = cur.getString(cur.getColumnIndex("JBHZ"));
            String ZWJBHZQC = cur.getString(cur.getColumnIndex("ZWJBHZQC"));
            String XJSZWMC = cur.getString(cur.getColumnIndex("XJSZWMC"));
            String ZWMC = cur.getString(cur.getColumnIndex("ZWMC"));
            String HYHZ = cur.getString(cur.getColumnIndex("HYHZ"));
            String RYXH = cur.getString(cur.getColumnIndex("RYXH"));
            String ZWMCHZ = cur.getString(cur.getColumnIndex("ZWMCHZ"));


            danweiModel._id = _id;
            danweiModel.XM = XM;
            danweiModel.XBHZ = XBHZ;
            danweiModel.CSRQ = CSRQ;
            danweiModel.NL = NL;
            danweiModel.MZHZ = MZHZ;
            danweiModel.JG = JG;
            danweiModel.CSD = CSD;
            danweiModel.JRDPRQ = JRDPRQ;
            danweiModel.CJGZRQ = CJGZRQ;
            danweiModel.JKQKHZ = JKQKHZ;
            danweiModel.ZCMCHZ = ZCMCHZ;
            danweiModel.WHCDHZ = WHCDHZ;
            danweiModel.XWMCHZ = XWMCHZ;
            danweiModel.DWMC = DWMC;
            danweiModel.XSBMMC = XSBMMC;
            danweiModel.ZZMMHZ = ZZMMHZ;
            danweiModel.XDZZWRQ = XDZZWRQ;
            danweiModel.RXZRQ = RXZRQ;
            danweiModel.XJSZWRQ = XJSZWRQ;
            danweiModel.SFZH = SFZH;
            danweiModel.ZWJB = ZWJB;
            danweiModel.JBHZ = JBHZ;
            danweiModel.ZWJBHZQC = ZWJBHZQC;
            danweiModel.XJSZWMC = XJSZWMC;
            danweiModel.ZWMC = ZWMC;
            danweiModel.HYHZ = HYHZ;
            danweiModel.RYXH = RYXH;
            danweiModel.ZWMCHZ = ZWMCHZ;

            arrayList.add(danweiModel);

        }
        cur.close();

        return arrayList;
    }

    public static List<ListModel> getSortedCursorSearch(String search,String columname, int sort, String range) {
        search = search.replaceAll(" ","");
        String ran = convertRange(range);
        SQLiteDatabase sdb = ComDal.GetDatabase();
        String order = "desc";
        if(sort==1){
            order = "asc";
        }
        String sqlstr = "SELECT a.RYBM as _id, a.XM, a.XBHZ, a.CSRQ, a.NL,a.MZHZ,a.JG,a.CSD, a.JRDPRQ,a.CJGZRQ,a.JKQKHZ,a.ZCMCHZ,a.WHCDHZ,a.XWMCHZ,a.DWMC,a.XSBMMC,a.ZZMMHZ,a.XDZZWRQ,a.RXZRQ,a.XJSZWRQ,a.SFZH,a.ZWJB,a.JBHZ,a.ZWJBHZQC,a.XJSZWMC,a.ZWMC,a.HYHZ,b.RYXH,ifnull(a.ZWMCHZ,d.BCZWHZ) as ZWMCHZ  FROM RS_JBXX_TEMP1 a,RS_XRZW_TEMP d,RS_ZGJBXX_NEW b where instr(a.XM,'"+search+"') and "+ran+" and a.rybm = d.rybm and a.rybm=b.rybm order by a."+columname+" "+order;
        System.out.println(sqlstr);
        Cursor cur = sdb.rawQuery(sqlstr,null);
        List<ListModel> arrayList = new ArrayList<>();
        while (cur.moveToNext()) {
            ListModel danweiModel = new ListModel();
            String _id = cur.getString(cur.getColumnIndex("_id"));
            String XM = cur.getString(cur.getColumnIndex("XM"));
            String XBHZ = cur.getString(cur.getColumnIndex("XBHZ"));
            String CSRQ = cur.getString(cur.getColumnIndex("CSRQ"));
            String NL = cur.getString(cur.getColumnIndex("NL"));
            String MZHZ = cur.getString(cur.getColumnIndex("MZHZ"));
            String JG = cur.getString(cur.getColumnIndex("JG"));
            String CSD = cur.getString(cur.getColumnIndex("CSD"));
            String JRDPRQ = cur.getString(cur.getColumnIndex("JRDPRQ"));
            String CJGZRQ = cur.getString(cur.getColumnIndex("CJGZRQ"));
            String JKQKHZ = cur.getString(cur.getColumnIndex("JKQKHZ"));
            String ZCMCHZ = cur.getString(cur.getColumnIndex("ZCMCHZ"));
            String WHCDHZ = cur.getString(cur.getColumnIndex("WHCDHZ"));
            String XWMCHZ = cur.getString(cur.getColumnIndex("XWMCHZ"));
            String DWMC = cur.getString(cur.getColumnIndex("DWMC"));
            String XSBMMC = cur.getString(cur.getColumnIndex("XSBMMC"));
            String ZZMMHZ = cur.getString(cur.getColumnIndex("ZZMMHZ"));
            String XDZZWRQ = cur.getString(cur.getColumnIndex("XDZZWRQ"));
            String RXZRQ = cur.getString(cur.getColumnIndex("RXZRQ"));
            String XJSZWRQ = cur.getString(cur.getColumnIndex("XJSZWRQ"));
            String SFZH = cur.getString(cur.getColumnIndex("SFZH"));
            String ZWJB = cur.getString(cur.getColumnIndex("ZWJB"));
            String JBHZ = cur.getString(cur.getColumnIndex("JBHZ"));
            String ZWJBHZQC = cur.getString(cur.getColumnIndex("ZWJBHZQC"));
            String XJSZWMC = cur.getString(cur.getColumnIndex("XJSZWMC"));
            String ZWMC = cur.getString(cur.getColumnIndex("ZWMC"));
            String HYHZ = cur.getString(cur.getColumnIndex("HYHZ"));
            String RYXH = cur.getString(cur.getColumnIndex("RYXH"));
            String ZWMCHZ = cur.getString(cur.getColumnIndex("ZWMCHZ"));


            danweiModel._id = _id;
            danweiModel.XM = XM;
            danweiModel.XBHZ = XBHZ;
            danweiModel.CSRQ = CSRQ;
            danweiModel.NL = NL;
            danweiModel.MZHZ = MZHZ;
            danweiModel.JG = JG;
            danweiModel.CSD = CSD;
            danweiModel.JRDPRQ = JRDPRQ;
            danweiModel.CJGZRQ = CJGZRQ;
            danweiModel.JKQKHZ = JKQKHZ;
            danweiModel.ZCMCHZ = ZCMCHZ;
            danweiModel.WHCDHZ = WHCDHZ;
            danweiModel.XWMCHZ = XWMCHZ;
            danweiModel.DWMC = DWMC;
            danweiModel.XSBMMC = XSBMMC;
            danweiModel.ZZMMHZ = ZZMMHZ;
            danweiModel.XDZZWRQ = XDZZWRQ;
            danweiModel.RXZRQ = RXZRQ;
            danweiModel.XJSZWRQ = XJSZWRQ;
            danweiModel.SFZH = SFZH;
            danweiModel.ZWJB = ZWJB;
            danweiModel.JBHZ = JBHZ;
            danweiModel.ZWJBHZQC = ZWJBHZQC;
            danweiModel.XJSZWMC = XJSZWMC;
            danweiModel.ZWMC = ZWMC;
            danweiModel.HYHZ = HYHZ;
            danweiModel.RYXH = RYXH;
            danweiModel.ZWMCHZ = ZWMCHZ;

            arrayList.add(danweiModel);

        }
        cur.close();

        return arrayList;
    }
}
