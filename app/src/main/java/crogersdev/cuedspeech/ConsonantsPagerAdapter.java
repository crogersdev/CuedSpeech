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

        mSharedPrefs = mContext.getSharedPreferences("MnemonicPrefs", Context.MODE_PRIVATE);
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
                args.putString("phonemes", "/ee/, /ur/");
                mSharedPrefs.getString("mnemonic", mMnemonicStr);
                if (mMnemonicStr != null) {
                    Log.d("crogersdev", "putting mMnemonicStr: " + mMnemonicStr);
                    args.putString("phonemes", mMnemonicStr);
                }
                else {
                    Log.d("crogersdev", "putting in hard coded string");
                    args.putString("mnemonic", "deep treasure");
                }
                args.putInt("cue_image", CueImg.HANDSHAPE1.id);
                return fragment;

            case 1:
                Log.d("ConsonantsPagerAdapter", "position = 2");
                args.putString("label", "Handshape 2");
                args.putString("phonemes", "/th/, /c/, /v/, /z/");
                mSharedPrefs.getString("mnemonic", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("phonemes", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "the caves");
                }
                args.putInt("cue_image", CueImg.HANDSHAPE2.id);
                return fragment;

            case 2:
                Log.d("ConsonantsPagerAdapter", "position = 3");
                args.putString("label", "Handshape 3");
                args.putString("phonemes", "/r/, /h/, /s/");
                mSharedPrefs.getString("mnemonic", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("phonemes", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "sea horse");
                }
                args.putInt("cue_image", CueImg.HANDSHAPE3.id);
                return fragment;

            case 3:
                Log.d("ConsonantsPagerAdapter", "position = 4");
                args.putString("label", "Handshape 4");
                args.putString("phonemes", "/wh/, /b/, /n/");
                mSharedPrefs.getString("mnemonic", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("phonemes", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "white bone");
                }
                args.putInt("cue_image", CueImg.HANDSHAPE4.id);
                return fragment;

            case 4:
                Log.d("ConsonantsPagerAdapter", "position = 5");
                args.putString("label", "Handshape 5");
                args.putString("phonemes", "/m/, /t/, /f/");
                mSharedPrefs.getString("mnemonic", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("phonemes", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "my taffy");
                }
                args.putInt("cue_image", CueImg.HANDSHAPE5.id);
                return fragment;

            case 5:
                Log.d("ConsonantsPagerAdapter", "position = 6");
                args.putString("label", "Handshape 6");
                args.putString("phonemes", "/w/, /sh/, /l/");
                mSharedPrefs.getString("mnemonic", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("phonemes", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "wet shell");
                }
                args.putInt("cue_image", CueImg.HANDSHAPE6.id);
                return fragment;

            case 6:
                Log.d("ConsonantsPagerAdapter", "position = 7");
                args.putString("label", "Handshape 7");
                args.putString("phonemes", "/th/, /j/, /gg/");
                mSharedPrefs.getString("mnemonic", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("phonemes", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "thin jogger");
                }
                args.putInt("cue_image", CueImg.HANDSHAPE7.id);
                return fragment;

            case 7:
                Log.d("ConsonantsPagerAdapter", "position = 8");
                args.putString("label", "Handshape 8");
                args.putString("phonemes", "/y/, /ng/, /ch/");
                mSharedPrefs.getString("mnemonic", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("phonemes", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "young child");
                }
                args.putInt("cue_image", CueImg.HANDSHAPE8.id);
                return fragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 8;
    }
}
