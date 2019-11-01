package hbinh.com.antidrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hbinh.com.antidrop.DAO.UserDAO;
import hbinh.com.antidrop.Model.User;

import static hbinh.com.antidrop.MainActivity.strPassword;
import static hbinh.com.antidrop.MainActivity.strUsername;

public class ChangeActivity extends AppCompatActivity {

    EditText edtold, edtnew, edtnhaplai;
    Button btnchange;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        edtold = findViewById(R.id.edtold);
        edtnew = findViewById(R.id.edtnew);
        edtnhaplai = findViewById(R.id.edtnhaplai);
        btnchange = findViewById(R.id.btnchange);

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkUpdate();

            }
        });
    }

    public void checkUpdate() {
        userDAO = new UserDAO(this);
        if (edtold.getText().toString().equals(strPassword) == true) {
            if (edtnhaplai.getText().toString().equals(edtnew.getText().toString()) == true) {
                userDAO.updatePassword(strUsername + "", edtnew.getText().toString() + "");
                if ((userDAO.updatePassword(strUsername + "", edtnew.getText().toString() + "")) > 0) {
                    Toast.makeText(this, "Change password!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Nhap lai password chua dung!", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Password da duoc thay doi!", Toast.LENGTH_SHORT).show();
            edtold.setText("");
            edtnew.setText("");
            edtnhaplai.setText("");
        }else {
            Toast.makeText(this, "Password cu khong dung! ", Toast.LENGTH_SHORT).show();
        }
    }
}
