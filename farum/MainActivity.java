package com.teamcjz.farum;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button lr_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lr_login=findViewById(R.id.lr_login);
        lr_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Login.class));
                finish();

            }
        });
    }

    public void muestra(View v){
        Intent i =new Intent(MainActivity.this,Navega.class);
        startActivity(i);
    }
}
