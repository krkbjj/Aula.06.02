package com.wordpress.comsettingsgeneralmarcosdotapp.httpswordpress.appjonas23;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editSms,editSite,editGps1,editGps2;
    private Button btnSms,btnSite,btnGps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editSms=(EditText)findViewById(R.id.edtsms);
        editSite=(EditText)findViewById(R.id.edtsite);
        editGps1=(EditText)findViewById(R.id.editgps1);
        editGps2=(EditText)findViewById(R.id.editgps2);
        btnSms=(Button)findViewById(R.id.btn_sms);
        btnSite=(Button)findViewById(R.id.btn_site);
        btnGps=(Button)findViewById(R.id.btn_gps);

       /// acao do botao sms ao clicar ele direciona para proxima tela
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirsms = new Intent(Intent.ACTION_VIEW);//aqui ele direciona
                abrirsms.setData(Uri.parse("sms:"+ editSms.getText().toString()));// aqui ele recebe a string que foi digitada
                startActivity(abrirsms);// ele execulta
            }
        });
        // açao do botao site ao clicar ele direciona para o site de busca
        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirsite=new Intent(Intent.ACTION_VIEW);
                String site = editSite.getText().toString();// aqui ele recebe a string que foi digitada
                if(!site.startsWith("http://")){// se o site ja tem http:// ele nao inclui
                    site="http://"+site;// aqui ele inclui o http://
                }
                abrirsite.setData(Uri.parse(site));// aqui ele verifica se e uri
                startActivity(abrirsite);//ele execulta
            }
        });
        btnGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirgps=new Intent(Intent.ACTION_VIEW);
                // aqui ele recebe e direciona as strings enceridas e direciona para a pagina uri
                abrirgps.setData(Uri.parse("geo:"+editGps1.getText().toString()+","+editGps2.getText().toString()));
                startActivity(abrirgps);
            }
        });
    }
}
