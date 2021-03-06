package com.example.ivan.savemoney;

import android.graphics.Bitmap;

import com.example.ivan.savemoney.Dialogs.AddDialog;
import com.example.ivan.savemoney.Dialogs.WelcomeDialog;
import com.example.ivan.savemoney.Fuentes.Fuentes;
import com.getbase.floatingactionbutton.*;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class HomeActivity extends AppCompatActivity {

    private WebView graficasPie,graficasBar;
    private FloatingActionButton floatingBtnAdd;
    private String usuario;
    private TextView tvPerdida,tvTotalPerdida,tvGanancia,tvTotalAhorro;
    private int totalPerdida = 0,totalAhorro = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        usuario = getIntent().getExtras().getString("User");

        inicializarViews();
        graficasPie.getSettings().setJavaScriptEnabled(true);
        graficasBar.getSettings().setJavaScriptEnabled(true);
        cargarGraficaPie();
        cargarGraficaBar();

        WelcomeDialog dialog = new WelcomeDialog(usuario);
        dialog.show(getFragmentManager(),"WelcomeDialog");
        dialog.setCancelable(false);

        floatingBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDialog dialog = new AddDialog();
                dialog.show(getSupportFragmentManager(),"Dialog Add");
                dialog.setCancelable(false);
            }
        });

        tvTotalPerdida.setText("Total: $ " + totalPerdida);
        tvTotalAhorro.setText("Total: $ " + totalAhorro);
        }


    private void inicializarViews(){
        graficasPie = (WebView) findViewById(R.id.graficasMoneyPie);
        graficasBar = (WebView) findViewById(R.id.graficasMoneBar);
        tvPerdida = (TextView) findViewById(R.id.tvPerdida);
        tvPerdida.setTypeface(Fuentes.ChallengeCountour(this));
        tvTotalPerdida = (TextView) findViewById(R.id.tvTotalPerdida);
        tvTotalPerdida.setTypeface(Fuentes.ChallengeCountour(this));
        tvGanancia = (TextView) findViewById(R.id.tvAhorro);
        tvGanancia.setTypeface(Fuentes.ChallengeCountour(this));
        tvTotalAhorro = (TextView) findViewById(R.id.tvTotalAhorro);
        tvTotalAhorro.setTypeface(Fuentes.ChallengeCountour(this));
        floatingBtnAdd = (FloatingActionButton) findViewById(R.id.floatingBtnAdd);
    }

    private void cargarGraficaPie(){
        final String chart = "var chart = echarts.init($('#chart')[0]);";
        final String tamano = "style = width:500px; height:500px;";
        final String option = "var option = {" +
                "tooltip: {" +
                " trigger: 'item'," +
                " formatter: '{a} <br/>{b}: {c} ({d}%)'" +
                "  }," +
                "legend: {" +
                "orient: 'horizontal'," +
                " x: 'left'," +
                "data:['直达','营销广告','搜索引擎','邮件营销']" +
                "}," +
                "series: [" +
                "{" +
                "name:'访问来源'," +
                "type:'pie'," +
                "selectedMode: 'single'," +
                "radius: [0, '32%']," +
                "label: {" +
                " normal: {" +
                " position: 'inner'" +
                "}" +
                "}," +
                "labelLine: {" +
                "normal: {" +
                "show: false" +
                "}" +
                "}," +
                "data:[" +
                "{value:679, name:'营销广告'},{value:1548, name:'搜索引擎'}" +
                "]" +
                "}," +
                "{" +
                " name:'访问来源'," +
                "type:'pie'," +
                "radius: ['40%', '55%']," +
                "label: {" +
                "normal: {" +
                "formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}'," +
                "backgroundColor: '#eee'," +
                "borderColor: '#aaa'," +
                "borderWidth: 1," +
                "borderRadius: 4," +
                "rich: {" +
                " a: {" +
                " color: '#999'," +
                "lineHeight: 22," +
                "align: 'center'" +
                "}," +
                " hr: {" +
                "borderColor: '#aaa'," +
                "width: '100%'," +
                "borderWidth: 0.5," +
                "height: 0" +
                "}," +
                "b: {" +
                " fontSize: 16," +
                " lineHeight: 33" +
                "}," +
                "per: {" +
                "color: '#eee'," +
                "backgroundColor: '#334455'," +
                "padding: [2, 4]," +
                "borderRadius: 2" +
                " }" +
                " }" +
                " }" +
                " }," +
                "data:[" +
                "{value:335, name:'直达'},{value:310, name:'邮件营销'}," +
                "]" +
                "}" +
                " ]" +
                "};";

        final String setOption = "chart.setOption(option);";
        final String onClick = "chart.on('click', function(params){});";

        graficasPie.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                graficasPie.loadUrl("javascript: " + chart);
                graficasPie.loadUrl("javascript: " + tamano);
                graficasPie.loadUrl("javascript: " + option);
                graficasPie.loadUrl("javascript: " + setOption);
                graficasPie.loadUrl("javascript: " + onClick);
            }
        });

        graficasPie.loadUrl("file:///android_asset/index.html");
    }

    private void cargarGraficaBar() {
        final String chart = "var chart = echarts.init($('#chart')[0]);";
        final String tamano = "style = width:500px; height:500px;";
        final String option = "var option = {"+
              "legend: {"+
                "data:['Andrea','Ivan']"+
                "},"+
                "toolbox: {"+
                "show : true,"+
                "feature : {"+
                "magicType : {show: true, type: ['line', 'bar'],title:['']},"+
                "restore : {show: true, title:['']},"+
                "}" +
                "},"+
                "calculable : true,"+
                "xAxis : ["+
                "{"+
                "type : 'category',"+
                "data : ['Junio','Julio','Agosto']"+
                "}"+
                "],"+
                "yAxis : ["+
                "{"+
                "type : 'value'"+
                "}"+
                "],"+
                "series : ["+
                "{"+
                "name:'Andrea',"+
                "type:'bar',"+
                "data:[100,1000,400],"+
                "},"+
                "{"+
                " name:'Ivan',"+
                " type:'bar',"+
                "data:[10,1000,300],"+
                "}]};";


        final String setOption = "chart.setOption(option);";
        final String onClick = "chart.on('click', function(params){});";

        graficasBar.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                graficasBar.loadUrl("javascript: " + chart);
                graficasBar.loadUrl("javascript: " + tamano);
                graficasBar.loadUrl("javascript: " + option);
                graficasBar.loadUrl("javascript: " + setOption);
                graficasBar.loadUrl("javascript: " + onClick);
            }
        });

        graficasBar.loadUrl("file:///android_asset/index.html");
    }


}
