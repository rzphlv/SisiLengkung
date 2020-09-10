package rzphlv.nmf.sisilengkung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import rzphlv.nmf.sisilengkung.Bola.MateriBola;
import rzphlv.nmf.sisilengkung.Kerucut.MateriKerucut;
import rzphlv.nmf.sisilengkung.Tabung.MateriTabung;

public class BangunRuang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_ruang);

        String htmlText = " %s ";
        String myData = String.valueOf(Html
                .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222; \">"
                        + getResources().getString(R.string.desc_bangun_ruang)
                        + "</body>]]>"));
        WebView webView = (WebView) findViewById(R.id.pengertian);
        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");

        FloatingActionButton fab = findViewById(R.id.fabBack);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        });
    }

    public void tabung(View view){
        Intent intent = new Intent(getApplicationContext(), MateriTabung.class);
        startActivity(intent);
    }

    public void kerucut(View view){
        Intent intent = new Intent(getApplicationContext(), MateriKerucut.class);
        startActivity(intent);
    }

    public void bola(View view){
        Intent intent = new Intent(getApplicationContext(), MateriBola.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);
        finish();
        return;
    }
}
