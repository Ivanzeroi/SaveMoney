package com.example.ivan.savemoney;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.widget.Toast.makeText;

public class Login_Activity extends AppCompatActivity {

    private RelativeLayout really1,really2;
    private EditText edtUser,edtPass;
    private FirebaseAuth auth;
    private Button btnIniciarSesion;
    private String password,email;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            really1.setVisibility(View.VISIBLE);
            really2.setVisibility(View.VISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        inicializarCampos();
        handler.postDelayed(runnable,3000);



        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = edtUser.getText().toString();
                password = edtPass.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(Login_Activity.this,"Ingresa un usuario",Toast.LENGTH_LONG).show();
                }else if(password.isEmpty()){
                    Toast.makeText(Login_Activity.this,"Ingresa una contraseña",Toast.LENGTH_LONG).show();
                }else{

                auth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Login_Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("1", "signInWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
                                    Intent intent = new Intent(Login_Activity.this,HomeActivity.class);
                                    startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("2", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(Login_Activity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                                }
                            }
                });

                }
            }
        });

    }


    public void inicializarCampos(){
        really1 = (RelativeLayout) findViewById(R.id.really1);
        really2 = (RelativeLayout) findViewById(R.id.really2);
        edtUser = (EditText) findViewById(R.id.etxtUsuario);
        edtPass = (EditText) findViewById(R.id.etxtCpntrasenia);
        btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);
    }
}
