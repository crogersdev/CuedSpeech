package crogersdev.cuedspeech;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;

public class VowelPagerAdapter extends FragmentStatePagerAdapter {
    protected Context mContext;
    protected SharedPreferences mSharedPrefs;
    protected String mMnemonicStr;

    public VowelPagerAdapter(FragmentManager fm, Context cxt) {
        super(fm);
        mContext = cxt;

        mSharedPrefs = mContext.getSharedPreferences("MnemonicPrefs", Context.MODE_PRIVATE);
    }

    @Override
    public Fragment getItem(int pos) {
        Fragment vowelCueCard = new CueCard();
        Bundle args = new Bundle();
        args.putInt("page_position", pos + 1);
        vowelCueCard.setArguments(args);

        switch (pos) {
            case 0:
                Log.d("VowelPagerAdapter", "position = 1");
                args.putString("label", "Mouth");
                args.putString("phonemes", "/ee/, /ur/");

                mSharedPrefs.getString("mnemonic_9", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    String text = "l<font color=red><b>ei</b></font>su<font color=red><b>re</b></font>";
                    args.putString("mnemonic", text);
                }

                args.putInt("cue_image", CueImg.VOWEL.id);
                args.putString("animate_dot", "leisure");
                return vowelCueCard;

            case 1:
                Log.d("VowelPagerAdapter", "position = 2");
                args.putString("label", "Chin");
                args.putString("phonemes", "/aw/, /oo/, /e/");

                mSharedPrefs.getString("mnemonic_10", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    String text = "t<font color=red><b>a</b></font>ll bl<font color=red><b>ue</b></font> t<font color=red><b>e</b></font>nt";
                    args.putString("mnemonic", text);
                }

                args.putInt("cue_image", CueImg.VOWEL.id);
                args.putString("animate_dot", "tall blue tent");
                return vowelCueCard;

            case 2:
                Log.d("VowelPagerAdapter", "position = 3");
                args.putString("label", "Throat");
                args.putString("phonemes", "/oo/, /i/, /a/");

                mSharedPrefs.getString("mnemonic_11", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    String text = "l<font color=red><b>oo</b></font>k b<font color=red><b>i</b></font>g cr<font color=red><b>a</b></font>bs";
                    args.putString("mnemonic", text);
                }

                //args.putInt("cue_image", CueImg.VOWEL_THROAT.id);
                args.putInt("cue_image", CueImg.VOWEL.id);
                args.putString("animate_dot", "look big crabs");
                return vowelCueCard;

            case 3:
                Log.d("VowelPagerAdapter", "position = 4");
                args.putString("label", "Side");
                args.putString("phonemes", "consonant alone");

                mSharedPrefs.getString("mnemonic_12", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "");
                }

                args.putString("animate_dot", "consonant alone");
                args.putInt("cue_image", CueImg.VOWEL.id);
                return vowelCueCard;

            case 4:
                Log.d("VowelPagerAdapter", "position = 5");
                args.putString("label", "Side Forward");
                args.putString("phonemes", "/oe/, /ah/");

                mSharedPrefs.getString("mnemonic_13", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    String text = "b<font color=red><b>oa</b></font>t d<font color=red><b>o</b></font>ck";
                    args.putString("mnemonic", text);
                }

                args.putString("animate_dot", "boat dock");
                args.putInt("cue_image", CueImg.VOWEL.id);
                return vowelCueCard;

            case 5:
                Log.d("VowelPagerAdapter", "position = 6");
                args.putString("label", "Side Down");
                args.putString("phonemes", "/uh/");

                mSharedPrefs.getString("mnemonic_14", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    String text = "s<font color=red><b>u</b></font>n";
                    args.putString("mnemonic", text);
                }

                args.putString("animate_dot", "sun");
                args.putInt("cue_image", CueImg.VOWEL.id);
                return vowelCueCard;

            case 6:
                Log.d("VowelPagerAdapter", "position = 7");
                args.putString("label", "Chin to 5 Throat");
                args.putString("phonemes", "/oi/, /ay/");

                mSharedPrefs.getString("mnemonic_15", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    String text = "m<font color=red><b>oi</b></font>st sn<font color=red><b>ai</b></font>ls";
                    args.putString("mnemonic", text);
                }

                args.putString("animate_dot", "moist snails");
                args.putInt("cue_image", CueImg.VOWEL.id);
                return vowelCueCard;

            case 7:
                Log.d("VowelPagerAdapter", "position = 8");
                args.putString("label", "Side to 5 Throat");
                args.putString("phonemes", "/ie/, /ou/");

                mSharedPrefs.getString("mnemonic_16", mMnemonicStr);
                if (mMnemonicStr != null) {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    String text = "l<font color=red><b>i</b></font>ght h<font color=red><b>ou</b></font>se";
                    args.putString("mnemonic", text);
                }

                args.putString("animate_dot", "light house");
                args.putInt("cue_image", CueImg.VOWEL.id);
                return vowelCueCard;

        }
        Log.d("VowelPagerAdapter", " about to return, shouldn't see this, right?");
        return null;
    }

    @Override
    public int getCount() {
        return 8;
    }
}
