package com.example.ivan.savemoney;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class HomeActivity extends AppCompatActivity {

    private WebView graficasPie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inicializarViews();
        graficasPie.getSettings().setJavaScriptEnabled(true);

        final String chart = "var chart = echarts.init($('#chart')[0]);";
        final String tamano = "style = width:500px; height:500px;";
        final String option = "var option = {"+
                "tooltip: {"+
                " trigger: 'item',"+
                " formatter: '{a} <br/>{b}: {c} ({d}%)'"+
                "  },"+
                "legend: {"+
                "orient: 'horizontal',"+
                " x: 'left',"+
                "data:['直达','营销广告','搜索引擎','邮件营销']"+
                "},"+
                "series: ["+
                "{"+
                "name:'访问来源',"+
                "type:'pie',"+
                "selectedMode: 'single',"+
                "radius: [0, '32%'],"+
                "label: {"+
                " normal: {"+
                " position: 'inner'"+
                "}"+
                "},"+
                "labelLine: {"+
                "normal: {"+
                "show: false"+
                "}"+
                "},"+
                "data:["+
                "{value:679, name:'营销广告'},{value:1548, name:'搜索引擎'}"+
                "]"+
                "},"+
                "{"+
                " name:'访问来源',"+
                "type:'pie',"+
                "radius: ['40%', '55%'],"+
                "label: {"+
                "normal: {"+
                "formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}',"+
                "backgroundColor: '#eee',"+
                "borderColor: '#aaa',"+
                "borderWidth: 1,"+
                "borderRadius: 4,"+
                "rich: {"+
                " a: {"+
                " color: '#999',"+
                "lineHeight: 22,"+
                "align: 'center'"+
                "},"+
                " hr: {"+
                "borderColor: '#aaa',"+
                "width: '100%',"+
                "borderWidth: 0.5,"+
                "height: 0"+
                "},"+
                "b: {"+
                " fontSize: 16,"+
                " lineHeight: 33"+
                "},"+
                "per: {"+
                "color: '#eee',"+
                "backgroundColor: '#334455',"+
                "padding: [2, 4],"+
                "borderRadius: 2"+
                " }"+
                " }"+
                " }"+
                " },"+
                "data:["+
                "{value:335, name:'直达'},{value:310, name:'邮件营销'},"+
                "]"+
                "}"+
                " ]"+
                "};";

        final String setOption = "chart.setOption(option);";
        final String onClick = "chart.on('click', function(params){});";

        graficasPie.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url,Bitmap favicon){

            }
            @Override
            public void onPageFinished(WebView view,String url){
                graficasPie.loadUrl("javascript: " + chart);
                graficasPie.loadUrl("javascript: " + tamano);
                graficasPie.loadUrl("javascript: " + option);
                graficasPie.loadUrl("javascript: " + setOption);
                graficasPie.loadUrl("javascript: " + onClick);
            }
        });



        graficasPie.loadUrl("file:///android_asset/index.html");

    }

    public void inicializarViews(){
        graficasPie = (WebView) findViewById(R.id.graficasMoneyPie);
    }

}
