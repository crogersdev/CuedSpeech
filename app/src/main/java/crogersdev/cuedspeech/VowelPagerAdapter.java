package crogersdev.cuedspeech;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class VowelPagerAdapter extends FragmentStatePagerAdapter {
    protected Context mContext;

    public VowelPagerAdapter(FragmentManager fm, Context cxt) {
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
                Log.d("VowelPagerAdapter", "position = 1");
                args.putString("label", "Mouth");
                args.putString("phonemes", "/ee/, /ur/");
                args.putString("mnemonic", "leisure");
                args.putInt("cue_image", 9);
                return fragment;
            case 1:
                Log.d("VowelPagerAdapter", "position = 2");
                args.putString("label", "Chin");
                args.putString("phonemes", "/aw/, /ue/, /e/");
                args.putString("mnemonic", "tall blue tent");
                args.putInt("cue_image", 10);
                return fragment;
            case 2:
                Log.d("VowelPagerAdapter", "position = 3");
                args.putString("label", "Throat");
                args.putString("phonemes", "/oo/, /i/, /a/");
                args.putString("mnemonic", "look big crabs");
                args.putInt("cue_image", 11);
                return fragment;
            case 3:
                Log.d("VowelPagerAdapter", "position = 4");
                args.putString("label", "Side");
                args.putString("phonemes", "consonant alone");
                args.putString("mnemonic", "");
                args.putInt("cue_image", 12);
                return fragment;
            case 4:
                Log.d("VowelPagerAdapter", "position = 5");
                args.putString("label", "Side Forward");
                args.putString("phonemes", "/oe/, /ah/");
                args.putString("mnemonic", "boat dock");
                args.putInt("cue_image", 13);
                return fragment;
            case 5:
                Log.d("VowelPagerAdapter", "position = 6");
                args.putString("label", "Side Down");
                args.putString("phonemes", "/uh/");
                args.putString("mnemonic", "sun");
                args.putInt("cue_image", 14);
                return fragment;
            case 6:
                Log.d("VowelPagerAdapter", "position = 7");
                args.putString("label", "Chin to 5 Throat");
                args.putString("phonemes", "/oi/, /ay/");
                args.putString("mnemonic", "moist snails");
                args.putInt("cue_image", 15);
                return fragment;
            case 7:
                Log.d("VowelPagerAdapter", "position = 8");
                args.putString("label", "Side to 5 Throat");
                args.putString("phonemes", "/ie/, /ou/");
                args.putString("mnemonic", "light house");
                args.putInt("cue_image", 16);
                return fragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 8;
    }
}
