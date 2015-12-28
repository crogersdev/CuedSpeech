package crogersdev.cuedspeech;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

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
                if (mMnemonicStr != "") {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "leisure");
                }

                args.putInt("cue_image", CueImg.VOWEL_MOUTH.id);
                return vowelCueCard;
            case 1:
                Log.d("VowelPagerAdapter", "position = 2");
                args.putString("label", "Chin");
                args.putString("phonemes", "/aw/, /ue/, /e/");

                mSharedPrefs.getString("mnemonic_10", mMnemonicStr);
                if (mMnemonicStr != "") {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "tall blue tent");
                }

                args.putInt("cue_image", CueImg.VOWEL_CHIN.id);
                return vowelCueCard;
            case 2:
                Log.d("VowelPagerAdapter", "position = 3");
                args.putString("label", "Throat");
                args.putString("phonemes", "/oo/, /i/, /a/");

                mSharedPrefs.getString("mnemonic_11", mMnemonicStr);
                if (mMnemonicStr != "") {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "look big crabs");
                }

                args.putInt("cue_image", CueImg.VOWEL_THROAT.id);
                return vowelCueCard;
            case 3:
                Log.d("VowelPagerAdapter", "position = 4");
                args.putString("label", "Side");
                args.putString("phonemes", "consonant alone");

                mSharedPrefs.getString("mnemonic_12", mMnemonicStr);
                if (mMnemonicStr != "") {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "");
                }

                args.putInt("cue_image", CueImg.VOWEL_SIDE.id);
                return vowelCueCard;
            case 4:
                Log.d("VowelPagerAdapter", "position = 5");
                args.putString("label", "Side Forward");
                args.putString("phonemes", "/oe/, /ah/");

                mSharedPrefs.getString("mnemonic_13", mMnemonicStr);
                if (mMnemonicStr != "") {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "boat dock");
                }

                args.putInt("cue_image", CueImg.VOWEL_SIDE_FWD.id);
                return vowelCueCard;
            case 5:
                Log.d("VowelPagerAdapter", "position = 6");
                args.putString("label", "Side Down");
                args.putString("phonemes", "/uh/");

                mSharedPrefs.getString("mnemonic_14", mMnemonicStr);
                if (mMnemonicStr != "") {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "sun");
                }

                args.putInt("cue_image", CueImg.VOWEL_SIDE_DOWN.id);
                return vowelCueCard;
            case 6:
                Log.d("VowelPagerAdapter", "position = 7");
                args.putString("label", "Chin to 5 Throat");
                args.putString("phonemes", "/oi/, /ay/");

                mSharedPrefs.getString("mnemonic_15", mMnemonicStr);
                if (mMnemonicStr != "") {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "moist snails");
                }

                args.putInt("cue_image", CueImg.VOWEL_CHIN_THROAT.id);
                return vowelCueCard;
            case 7:
                Log.d("VowelPagerAdapter", "position = 8");
                args.putString("label", "Side to 5 Throat");
                args.putString("phonemes", "/ie/, /ou/");

                mSharedPrefs.getString("mnemonic_16", mMnemonicStr);
                if (mMnemonicStr != "") {
                    args.putString("mnemonic", mMnemonicStr);
                }
                else {
                    args.putString("mnemonic", "light house");
                }

                args.putInt("cue_image", CueImg.VOWEL_SIDE_THROAT.id);
                return vowelCueCard;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 8;
    }
}
