package rzphlv.nmf.sisilengkung.Tabung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import rzphlv.nmf.sisilengkung.BangunRuang;
import rzphlv.nmf.sisilengkung.Pager;
import rzphlv.nmf.sisilengkung.R;

public class MateriTabung extends AppCompatActivity {

    ViewPager viewPagerTabung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_tabung);

        viewPagerTabung = findViewById(R.id.viewPagerTabung);

        addTabs(viewPagerTabung);
        ((TabLayout) findViewById(R.id.tabLayoutTabung)).setupWithViewPager(viewPagerTabung);

        FloatingActionButton fab = findViewById(R.id.fabBack);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BangunRuang.class);

                startActivity(intent);
            }
        });

        FloatingActionButton kal = findViewById(R.id.fabKalkulator);
        kal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KalkulatorTabung.class);

                startActivity(intent);
            }
        });
    }


    private void addTabs(ViewPager viewPager) {
        Pager adapter = new Pager(getSupportFragmentManager());

        adapter.addFrag(new TabMateriTabung(), "Materi");
        adapter.addFrag(new TabContohSoalTabung(), "ContohSoal");
        adapter.addFrag(new TabLatihanTabung(), "Latihan");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), BangunRuang.class);

        startActivity(intent);
        finish();
        return;
    }
}
