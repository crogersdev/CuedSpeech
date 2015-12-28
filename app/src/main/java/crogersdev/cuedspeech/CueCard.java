package crogersdev.cuedspeech;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chris on 10/24/15.
 */
public class CueCard extends Fragment {

    private SharedPreferences mSharedPreferences;
    private String mMnemonicStr;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.consonants_tab_view, container, false);

        mSharedPreferences = this.getContext().getSharedPreferences("MnemonicPrefs", Context.MODE_PRIVATE);

        Bundle args = getArguments();
        ((TextView)rootView.findViewById(R.id.cuecard_label)).setText(args.getString("label"));
        ((TextView)rootView.findViewById(R.id.cuecard_phonemes)).setText(args.getString("phonemes"));

        EditText mnemonicField = (EditText)rootView.findViewById(R.id.cuecard_mnemonic);
        mnemonicField.setText(args.getString("mnemonic"));

        Log.d("CueCard", "cue_image is: " + args.getInt("cue_image"));

        rootView.findViewById(R.id.cue_image).setBackgroundResource(args.getInt("cue_image"));

        mnemonicField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mMnemonicStr = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("mnemonic_" + Integer.toString(R.id.cue_image), mMnemonicStr);
        prefsEditor.commit();

        return rootView;
    }

    public class AspectRatioImageView extends ImageView {
        public AspectRatioImageView(Context cxt) {
            super(cxt);
        }
        public AspectRatioImageView(Context cxt, AttributeSet attrs) {
            super(cxt, attrs);
        }
        public AspectRatioImageView(Context cxt, AttributeSet attrs, int defStyle) {
            super(cxt, attrs, defStyle);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = width * getDrawable().getIntrinsicHeight() / getDrawable().getIntrinsicWidth();
            setMeasuredDimension(width, height);
        }

    }
}
