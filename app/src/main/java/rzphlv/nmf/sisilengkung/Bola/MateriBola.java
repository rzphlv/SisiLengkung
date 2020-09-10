package rzphlv.nmf.sisilengkung.Bola;

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

public class MateriBola extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_bola);

// Create an instance of the tab layout from the view.
        TabLayout tabLayout = findViewById(R.id.tabLayoutBola);
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText("Materi"));
        tabLayout.addTab(tabLayout.newTab().setText("Contoh Soal"));
        tabLayout.addTab(tabLayout.newTab().setText("Latihan"));

        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        final ViewPager viewPager = findViewById(R.id.viewPagerBola);
        final PagerAdapterBola adapter = new PagerAdapterBola
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                    }
                });

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
                Intent intent = new Intent(getApplicationContext(), KalkulatorBola.class);

                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), BangunRuang.class);

        startActivity(intent);
        finish();
        return;
    }
}
