package crogersdev.cuedspeech;

import android.app.ActionBar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

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

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final ConsonantsPagerAdapter consonantsPagerAdapter = new ConsonantsPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(consonantsPagerAdapter);
        final VowelPagerAdapter vowelPagerAdapter = new VowelPagerAdapter(getSupportFragmentManager(), this);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.d("crogersdev, MainActivity", "onTabSelected, tab value is " + tab.toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
