package com.example.shenxm.tlbook.Dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;


import com.example.shenxm.tlbook.R;

import org.xutils.DbManager;

import org.xutils.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


public class ComDal {
    private static SQLiteDatabase database;
    private final int BUFFER_SIZE = 4000000;
    public static final String DB_NAME = "rsxx.db";
    public static final String PACKAGE_NAME = "com.example.shenxm.tlbook";
    public static final String DB_PATH = "/data"
            + Environment.getDataDirectory().getAbsolutePath()+"/"
            + PACKAGE_NAME;

    private Context context;

//    public static SQLiteDatabase CreateDb(Context context){
//        try{
//            String databaseFileName = DB_PATH + "/" + DB_NAME;
//            File dir = new File(DB_PATH);
//            if(!dir.exists()){
//                System.out.println("文件路径不存在");
//                if(dir.mkdir()){
//                    System.out.println("创建文件路径");
//                }else{
//                    System.out.println("未能创建文件路径");
//
//                }
//            }
//            if(!(new File(databaseFileName)).exists()){
//                System.out.println("数据文件不存在，需要现在创建");
//                InputStream is = context.getResources().openRawResource(R.raw.rsxx);
//                FileOutputStream fos = new FileOutputStream(databaseFileName);
//                byte[] buffer = new byte[8192];
//                int count = 0;
//                while((count = is.read(buffer))>0){
//                    fos.write(buffer,0,count);
//                }
//                fos.close();
//                is.close();
//            }
//            database = SQLiteDatabase.openOrCreateDatabase(databaseFileName,null);
//            return database;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
    public static void InitDb() {
        File dbFileName = Environment.getExternalStorageDirectory();
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                .setDbName("rsxx.db")
                // 不设置dbDir时, 默认存储在app的私有目录.
                .setDbDir(new File(dbFileName + "/tl")) // "sdcard"的写法并非最佳实践, 这里为了简单, 先这样写了.
                .setDbVersion(1)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        // 开启WAL, 对写入加速提升巨大
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                    }
                });

        DbManager db = x.getDb(daoConfig);
        database = db.getDatabase();
        UpdateDataBase();

    }

    public static SQLiteDatabase GetDatabase() {
        return database;
    }

    public static void UpdateDataBase()
    {
//        Cursor cursor =database.rawQuery("select * from sqlite_master where name='flightplan'",null);
//        if(cursor.getCount()==0)
//        {
//            database.execSQL("create table flightplan (fpid varchar(40) primary key,name text,distance text,ESA text);");
//
//        }
//        //database.execSQL("drop table flightplan");
//        cursor.close();

    }


}
