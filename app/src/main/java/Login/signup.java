package Login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import Object.User;
import com.example.enggo.MainActivity;
import com.example.enggo.R;

import java.sql.SQLException;

import SQLServerConnection.UserModel;

public class signup extends AppCompatActivity {
    private Context mContext;
    private EditText mPassword, mPassword2, mName, mEmail;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        mContext = signup.this;
        mPassword = (EditText) findViewById(R.id.signup_password);
        mPassword2 = (EditText) findViewById(R.id.signup_password2);
        mName = (EditText) findViewById(R.id.signup_name);
        mEmail = (EditText) findViewById(R.id.signup_email);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel regist = new UserModel();
                try {
                    regist.Insert(new User(mName.getText().toString(), mPassword2.getText().toString()));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                goToLogin();
            }

        });
    }

    private void goToLogin(){
        Intent intent = new Intent(mContext, login.class);
        startActivity(intent);
        this.finish();// can't come back when clicked backPress button
    }

}