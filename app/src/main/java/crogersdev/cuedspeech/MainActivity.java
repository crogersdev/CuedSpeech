package crogersdev.cuedspeech;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int mConsPrevPos = 0;
    int mVowelPrevPos = 0;
    ViewPager mViewPager;

    /*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tabState", getSelectedTab());
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Consonants"));
        tabLayout.addTab(tabLayout.newTab().setText("Vowels"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        final ConsonantsPagerAdapter consonantsPagerAdapter = new ConsonantsPagerAdapter(getSupportFragmentManager(), this, mViewPager);
        mViewPager.setAdapter(consonantsPagerAdapter);
        final VowelPagerAdapter vowelPagerAdapter = new VowelPagerAdapter(getSupportFragmentManager(), this);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        mVowelPrevPos = mViewPager.getCurrentItem();
                        mViewPager.setAdapter(consonantsPagerAdapter);
                        mViewPager.setCurrentItem(mConsPrevPos);
                        Log.d("crogersdev:MainActivity", "tab 0 selected, setting pager adapter to consonants");
                        break;
                    case 1:
                        mConsPrevPos = mViewPager.getCurrentItem();
                        mViewPager.setAdapter(vowelPagerAdapter);
                        mViewPager.setCurrentItem(mVowelPrevPos);

                        Log.d("crogersdev:MainActivity", "tab 1 selected, setting pager adapter to vowels");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        if (savedInstanceState != null) {
            mViewPager.setCurrentItem(savedInstanceState.getInt("currentItem", 0));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("currentItem", mViewPager.getCurrentItem());

        super.onSaveInstanceState(savedInstanceState);
    }
}
