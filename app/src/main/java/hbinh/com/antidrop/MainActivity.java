package hbinh.com.antidrop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import hbinh.com.antidrop.DAO.UserDAO;
import hbinh.com.antidrop.Database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    EditText edtuser,edtpassword;
    CheckBox remember;
    Button btnlogin,btncancel;
    UserDAO userDAO;
    public static String strUsername,strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtuser = findViewById(R.id.edtuser);
        edtpassword = findViewById(R.id.edtpassword);
        remember = findViewById(R.id.remember);
        btnlogin = findViewById(R.id.btnlogin);
        btncancel = findViewById(R.id.btncancel);

        userDAO = new UserDAO(this);

        SharedPreferences preferences = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        String usern = preferences.getString("USERNAME","");
        String passw = preferences.getString("PASSWORD","");
        edtuser.setText(usern);
        edtpassword.setText(passw);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });

    }

    public void checkLogin(){

        strUsername = edtuser.getText().toString();
        strPassword = edtpassword.getText().toString();

        if (strUsername.isEmpty() || strPassword.isEmpty()){
            Toast.makeText(this, "Ten dang nhap hoac mat khau khong de trong!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (userDAO.checkLoginn(strUsername,strPassword)){

                DatabaseHelper.USERNAME = strUsername;
                DatabaseHelper.PASSWORD = strPassword;

                Toast.makeText(this, "Dang nhap thanh cong!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,InformationActivity.class));
            }
        }

    }
}
