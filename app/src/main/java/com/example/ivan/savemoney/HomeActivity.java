package com.example.ivan.savemoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


public class HomeActivity extends AppCompatActivity {

    private WebView graficasPie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inicializarViews();
        graficasPie.loadUrl("https://www.facebook.com");
    }

    public void inicializarViews(){
        graficasPie = (WebView) findViewById(R.id.graficasMoneyPie);
    }
}
