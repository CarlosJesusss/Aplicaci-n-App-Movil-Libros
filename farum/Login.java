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
import com.teamcjz.farum.interfaces.UsuarioRetroFit;
import com.teamcjz.farum.model.Usuario;
import com.teamcjz.farum.util.Constantes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    Button btn_crear_cuenta,btn_iniciar_sesion;
    EditText etCorreo, etContrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_crear_cuenta=findViewById(R.id.btn_ir_crear_cuenta);
        btn_iniciar_sesion=findViewById(R.id.btn_iniciar_sesion);
        etCorreo = findViewById(R.id.et_correo);
        etContrasenia = findViewById(R.id.et_contraseña);

        btn_crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,SignUp.class));
                finish();
            }
        });

        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Bienvenido Usuario", Toast.LENGTH_SHORT).show();

//                FarumRequestQueue queue = FarumRequestQueue.getInstance(Login.this);
//                final Usuario usu = new Usuario();
//                usu.setContrasenia(etContrasenia.getText().toString());
//                usu.setCorreo(etCorreo.getText().toString());
//                new UsuarioData().getCredenciales(queue, usu, new UsuarioData.OnLoginSuccess() {
//                    @Override
//                    public void procesaLogin(Usuario usuario) {
//                        Log.d("UsuarioId", usuario.getIdUsuario() + "");
//                    }
//                });

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constantes.BASEURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                final Usuario usu = new Usuario();
                usu.setContrasenia(etContrasenia.getText().toString());
                usu.setCorreo(etCorreo.getText().toString());
                UsuarioRetroFit usuarioRetroFit = retrofit.create(UsuarioRetroFit.class);
                Call<Usuario> call = usuarioRetroFit.Login(usu);
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Log.d("Codigo" , response.code() + "");
                        if (response.isSuccessful()) {
                            Usuario usuLogueado = response.body();
                            if(usu.getNombre()!= null){
                                Log.d("Usuario", usuLogueado.getNombre());
                                Toast.makeText(Login.this, usuLogueado.getNombre(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {

                    }
                });
            }
        });
    }
}