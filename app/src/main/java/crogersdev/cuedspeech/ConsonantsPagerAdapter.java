package crogersdev.cuedspeech;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;

public class ConsonantsPagerAdapter extends FragmentStatePagerAdapter {
    protected Context mContext;
    protected SharedPreferences mSharedPrefs;
    protected String mMnemonicStr;
    protected ViewPager mVp;

    public ConsonantsPagerAdapter(FragmentManager fm, Context cxt, ViewPager vp) {
        super(fm);
        mContext = cxt;
        mVp = vp;
        mSharedPrefs = mContext.getSharedPreferences("MnemonicPrefs", Context.MODE_PRIVATE);
    }

    @Override
    public Fragment getItem(int pos) {
        Fragment fragment = new CueCard();
        Bundle args = new Bundle();
        args.putInt("page_position", pos + 1);
        fragment.setArguments(args);

        args.putInt("position", pos);

        switch (pos) {
            case 0:
                Log.d("ConsonantsPagerAdapter", "position = 1");
                args.putString("label", "Handshape 1");
                args.putString("phonemes", "/d/, /p/, /zh/");

                mSharedPrefs.getString("mnemonic", mMnemonicStr);
                if (mMnemonicStr != null) {
                    Log.d("crogersdev", "putting mMnemonicStr: " + mMnemonicStr);
                    args.putString("phonemes", mMnemonicStr);
                }
                else {
                    Log.d("crogersdev", "putting in hard coded string");
                    String text = "<font color=red><b>d</b></font>ee<font color=red><b>p</b></font> trea<font color=red><b>su</b></font>re";
                    args.putString("mnemonic", text);
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
                    String text = "<font color=red><b>t</b></font>he <font color=red><b>c</b></font>a<font color=red><b>v</b></font>e<font color=red><b>s</b></font>";
                    args.putString("mnemonic", text);
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
                    String text = "<font color=red><b>s</b></font>ea ho<font color=red><b>rs</b></font>e";
                    args.putString("mnemonic", text);
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
                    String text = "<font color=red><b>wh</b></font>ite <font color=red><b>b</b></font>o<font color=red><b>n</b></font>e";
                    args.putString("mnemonic", text);
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
                    String text = "<font color=red><b>m</b></font>y <font color=red><b>t</b></font>a<font color=red><b>ff</b></font>y";
                    args.putString("mnemonic", text);
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
                    String text = "<font color=red><b>w</b></font>et <font color=red><b>sh</b></font>e<font color=red><b>ll</b></font>";
                    args.putString("mnemonic", text);
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
                    String text = "<font color=red><b>th</b></font>in <font color=red><b>j</b></font>o<font color=red><b>gg</b></font>er";
                    args.putString("mnemonic", text);
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
                    String text = "<font color=red><b>y</b></font>ou<font color=red><b>ng</b></font> <font color=red><b>ch</b></font>ild";
                    args.putString("mnemonic", text);
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
