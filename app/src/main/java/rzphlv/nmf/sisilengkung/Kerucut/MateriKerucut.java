package rzphlv.nmf.sisilengkung.Kerucut;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import rzphlv.nmf.sisilengkung.BangunRuang;
import rzphlv.nmf.sisilengkung.R;

public class MateriKerucut extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_kerucut);

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
                Intent intent = new Intent(getApplicationContext(), KalkulatorKerucut.class);

                startActivity(intent);
            }
        });

        mTablayout = findViewById(R.id.tabLayoutKerucut);
        mViewPager = findViewById(R.id.viewPagerKerucut);

        setupViewPager(mViewPager);
        mTablayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabMateriKerucut(),"Materi");
        adapter.addFragment(new TabContohSoalKerucut(),"Contoh Soal");
        adapter.addFragment(new TabLatihanKerucut(),"Latihan");

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);

    }

    class viewPagerAdapter extends FragmentStatePagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTittleList = new ArrayList<>();

        public viewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment (Fragment fragment, String tittle){
            mFragmentList.add(fragment);
            mFragmentTittleList.add(tittle);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTittleList.get(position);
        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), BangunRuang.class);

        startActivity(intent);
        finish();
        return;
    }
}
