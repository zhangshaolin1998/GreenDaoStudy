package com.bewei.greendao.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bewei.greendao.gen.DaoMaster;
import com.bewei.greendao.gen.DaoSession;

/**
 * 1. 类的用途  单例设计模式
 * 2. @author forever
 * 3. @date 2017/11/6 15:10
 */


public class MyApp extends Application {
    private static  MyApp mInstance;

    private DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        setDb();
    }



    public static MyApp getmInstance(){
        return  mInstance;
    }

    private void setDb() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "bw.db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();


    }

    public DaoSession getDaoSessio(){
        return daoSession;
    }
}
