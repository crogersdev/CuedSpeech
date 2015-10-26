package crogersdev.cuedspeech;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class CustomPagerAdapter extends FragmentStatePagerAdapter {
    protected Context mContext;

    public CustomPagerAdapter(FragmentManager fm, Context cxt) {
        super(fm);
        mContext = cxt;
    }

    @Override
    public Fragment getItem(int pos) {
        Fragment fragment = new CueCard();
        Bundle args = new Bundle();
        args.putInt("page_position", pos + 1);
        fragment.setArguments(args);

        switch (pos) {
            case 0:
                Log.d("CustomPagerAdapter", "position = 0");
            case 1:
                Log.d("CustomPagerAdapter", "position = 1");
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
