package com.example.loginform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void validar(View view) {

        Intent intent;
        EditText edtxtUname = (EditText) findViewById(R.id.edtxtUname);
        EditText edtxtUpass = (EditText) findViewById(R.id.edtxtUpass);

        try {

            String uname = edtxtUname.getText().toString().toLowerCase();
            String upass = edtxtUpass.getText().toString().toLowerCase();

            if(uname.equals("user")&&upass.equals("pass")) {
                intent = new Intent(MainActivity.this, LoginOkActivity.class);
                startActivity(intent);
            }else {
                intent = new Intent(MainActivity.this, LoginErradoActivity.class);
                startActivity(intent);
            }

            edtxtUname.setText("");
            edtxtUpass.setText("");

        }catch (Exception ex){
            mensagem("Não validado", "Preencha os campos!");
        }
    }

    public void mensagem(String title, String sms){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle(title);

        alert.setMessage(sms);

        alert.create().show();
    }
}