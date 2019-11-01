package hbinh.com.antidrop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static hbinh.com.antidrop.MainActivity.strUsername;

public class InformationActivity extends AppCompatActivity {

    TextView txtusername,txtdoimatkhau,txtgioitinhnam,txtngaysinh1,txtnoisinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        txtusername = findViewById(R.id.txtusername);
        txtdoimatkhau = findViewById(R.id.txtdoimatkhau);
        txtgioitinhnam  = findViewById(R.id.txtgioitinhnam);
        txtngaysinh1 = findViewById(R.id.txtngaysinh1);
        txtnoisinh  = findViewById(R.id.txtnoisinh);

        txtusername.setText(strUsername);

        txtdoimatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InformationActivity.this,ChangeActivity.class));
            }
        });
    }
}
