package crogersdev.cuedspeech;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class ConsonantsPagerAdapter extends FragmentStatePagerAdapter {
    protected Context mContext;
    protected SharedPreferences mSharedPrefs;
    protected String mMnemonicStr;

    public ConsonantsPagerAdapter(FragmentManager fm, Context cxt) {
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
                Log.d("ConsonantsPagerAdapter", "position = 1");
                args.putString("label", "Handshape 1");

                mSharedPrefs.getString("mnemonic", mMnemonicStr);
                if (mMnemonicStr == "") {
                    args.putString("phonemes", mMnemonicStr);
                }
                else {
                    args.putString("phonemes", "/ee/, /ur/");
                }

                args.putString("mnemonic", "deep treasure");
                args.putInt("cue_image", 1);
                return fragment;
            case 1:
                Log.d("ConsonantsPagerAdapter", "position = 2");
                args.putString("label", "Handshape 2");
                args.putString("phonemes", "/th/, /c/, /v/, /z/");
                args.putString("mnemonic", "the caves");
                args.putInt("cue_image", 2);
                return fragment;
            case 2:
                Log.d("ConsonantsPagerAdapter", "position = 3");
                args.putString("label", "Handshape 3");
                args.putString("phonemes", "/r/, /h/, /s/");
                args.putString("mnemonic", "sea horse");
                args.putInt("cue_image", 3);
                return fragment;
            case 3:
                Log.d("ConsonantsPagerAdapter", "position = 4");
                args.putString("label", "Handshape 4");
                args.putString("phonemes", "/wh/, /b/, /n/");
                args.putString("mnemonic", "white bone");
                args.putInt("cue_image", 4);
                return fragment;
            case 4:
                Log.d("ConsonantsPagerAdapter", "position = 5");
                args.putString("label", "Handshape 5");
                args.putString("phonemes", "/m/, /t/, /f/");
                args.putString("mnemonic", "my taffy");
                args.putInt("cue_image", 5);
                return fragment;
            case 5:
                Log.d("ConsonantsPagerAdapter", "position = 6");
                args.putString("label", "Handshape 6");
                args.putString("phonemes", "/w/, /sh/, /l/");
                args.putString("mnemonic", "wet shell");
                args.putInt("cue_image", 6);
                return fragment;
            case 6:
                Log.d("ConsonantsPagerAdapter", "position = 7");
                args.putString("label", "Handshape 7");
                args.putString("phonemes", "/th/, /j/, /gg/");
                args.putString("mnemonic", "thin jogger");
                args.putInt("cue_image", 7);
                return fragment;
            case 7:
                Log.d("ConsonantsPagerAdapter", "position = 8");
                args.putString("label", "Handshape 8");
                args.putString("phonemes", "/y/, /ng/, /ch/");
                args.putString("mnemonic", "young child");
                args.putInt("cue_image", 8);
                return fragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 8;
    }
}
