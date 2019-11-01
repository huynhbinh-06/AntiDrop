package hbinh.com.antidrop.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import hbinh.com.antidrop.DAO.UserDAO;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME ="baove";
    public static int VERSION = 1;
    public static String USERNAME="";
    public static String PASSWORD="";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(UserDAO.SQL_USER);
        db.execSQL("INSERT INTO user VALUES('admin','admin','nam','21-06-2000',1)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if exists "+ UserDAO.TABLE_NAME);

    }
}
