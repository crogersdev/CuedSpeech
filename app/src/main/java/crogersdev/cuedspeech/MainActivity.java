package crogersdev.cuedspeech;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

public class MainActivity extends AppCompatActivity {

    int mConsPrevPos = 0;
    int mVowelPrevPos = 0;
    ViewPager mViewPager;
    CirclePageIndicator mCirclePageIndicator;

    private DrawerLayout mDrawerLayout;
    private String[] mDrawerOptions = new String[]{"Dictionary", "Quizzes", "Preferences"};
    private ListView mDrawerList;

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("crogersdev:MainActivity", "here we go...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Consonants"));
        tabLayout.addTab(tabLayout.newTab().setText("Vowels"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mCirclePageIndicator = (CirclePageIndicator)findViewById(R.id.circles);
        mViewPager = (ViewPager)findViewById(R.id.pager);
        final ConsonantsPagerAdapter consonantsPagerAdapter = new ConsonantsPagerAdapter(getSupportFragmentManager(), this, mViewPager);
        mViewPager.setAdapter(consonantsPagerAdapter);
        final VowelPagerAdapter vowelPagerAdapter = new VowelPagerAdapter(getSupportFragmentManager(), this);

        mCirclePageIndicator.setViewPager(mViewPager);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.left_drawer);

        mSharedPreferences = this.getApplicationContext().getSharedPreferences("MnemonicPrefs", Context.MODE_PRIVATE);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        mVowelPrevPos = mViewPager.getCurrentItem();
                        mViewPager.setAdapter(consonantsPagerAdapter);
                        mCirclePageIndicator.setViewPager(mViewPager);
                        Log.d("crogersdev:MainActivity", "tab 0 selected, setting pager adapter to consonants");
                        break;
                    case 1:
                        mConsPrevPos = mViewPager.getCurrentItem();
                        mViewPager.setAdapter(vowelPagerAdapter);
                        mCirclePageIndicator.setViewPager(mViewPager);
                        mViewPager.setCurrentItem(mViewPager.getCurrentItem());
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

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerOptions));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "you clicked me!  i like you.", Toast.LENGTH_SHORT).show();
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("currentItem", mViewPager.getCurrentItem());

        super.onSaveInstanceState(savedInstanceState);
    }
}
