package com.teamcjz.farum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.teamcjz.farum.data.FarumRequestQueue;
import com.teamcjz.farum.data.UsuarioData;
import com.teamcjz.farum.model.Usuario;

public class SignUp extends AppCompatActivity {
    Button btn_ir_inicioSesion,btn_crear_cuenta;
    EditText etNuevoNombre, etNuevoContrasenia, etNuevoCorreo, etReContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_ir_inicioSesion=findViewById(R.id.btn_retornar_iniciar_sesion);
        btn_crear_cuenta=findViewById(R.id.btn_crear_cuenta);

        etNuevoNombre = findViewById(R.id.et_nuevo_nombre);
        etNuevoContrasenia = findViewById(R.id.et_nuevo_contraseña);
        etNuevoCorreo = findViewById(R.id.et_nuevo_correo);
        etReContrasenia = findViewById(R.id.et_nuevo_re_contrasenia);

        btn_ir_inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,Login.class));
                finish();
            }
        });

        btn_crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aplicar validaciones aca//

                //------------------------//
                FarumRequestQueue queue = FarumRequestQueue.getInstance(SignUp.this);
                final Usuario usu = new Usuario();
                usu.setContrasenia(etNuevoContrasenia.getText().toString());
                usu.setCorreo(etNuevoCorreo.getText().toString());
                usu.setNombre(etNuevoNombre.getText().toString());
                new UsuarioData().CrearCuenta(queue, usu, new UsuarioData.OnCrearCuenta() {
                    @Override
                    public void procesaCuenta() {
                        etNuevoContrasenia.setText("");
                        etNuevoCorreo.setText("");
                        etNuevoContrasenia.setText("");
                        etReContrasenia.setText("");
                        Toast.makeText(SignUp.this,"Cuenta creada exitosamente",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(SignUp.this,Login.class));
                        finish();
                    }
                });
            }
        });
    }
}
