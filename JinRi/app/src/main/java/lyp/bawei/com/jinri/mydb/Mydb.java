package lyp.bawei.com.jinri.mydb;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/3/23.
 */

public class Mydb extends SQLiteOpenHelper{
    public Mydb(Context context) {
        super(context, "shoucang", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table love(" +
                "id Integer primary key autoincrement," +
                "imgurl varchar," +
                "title varchar," +
                "url varchar" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
