package hbinh.com.antidrop.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import hbinh.com.antidrop.Database.DatabaseHelper;
import hbinh.com.antidrop.Model.User;

public class UserDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static String TABLE_NAME="user";
    public static String SQL_USER = "CREATE TABLE user" + "(" + "username text PRIMARY KEY," +
            "password text, " + "gender text," + "ngaysinh text, " + "acctype integer" + ")";

    public UserDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertUser(User user){
        ContentValues values = new ContentValues();
        values.put("username",user.getUsername());
        values.put("password",user.getPassword());
        values.put("gender",user.isGender());
        values.put("ngaysinh",user.getNgaysinh());
        values.put("acctype",user.getAcctype());

        try {
            if (db.insert(TABLE_NAME,null,values)==-1)
                return 1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<User> getAllUser(){
        ArrayList<User> dsUser = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null,null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            User user = new User();
            user.setUsername(cursor.getString(0));
            user.setPassword(cursor.getString(1));
            user.setGender(cursor.getString(2));
            user.setNgaysinh(cursor.getString(3));
            user.setAcctype(cursor.getInt(4));

            dsUser.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        return dsUser;
    }

    public boolean checkLoginn(String username, String password){
        String sql1 = "SELECT * FROM user WHERE username=? and password=?";
        Cursor cs = db.rawQuery(sql1,new String[]{username,password});
        if (cs.getCount()<=0){
            return false;
        }
        return true;
    }

    public int updatePassword(String username, String password){
        ContentValues values = new ContentValues();
        values.put("password",password); //muon update cai gi truyen cai do vo
        return db.update(TABLE_NAME,values,"username=?",new String[]{username+""});
    }
}
