package crogersdev.cuedspeech;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.graphics.Rect;

/**
 * Created by chris on 10/24/15.
 */
public class CueCard extends Fragment {

    private SharedPreferences mSharedPreferences;
    private String mMnemonicStr;
    LayoutInflater mLayoutInflater = null;
    ViewGroup mContainer = null;

    ImageView mCueImage = null;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        mLayoutInflater = inflater;
        mContainer = container;
        View rootView = inflater.inflate(R.layout.cue_card, container, false);

        mSharedPreferences = this.getContext().getSharedPreferences("MnemonicPrefs", Context.MODE_PRIVATE);

        Bundle args = getArguments();
        ((TextView)rootView.findViewById(R.id.cuecard_label)).setText(args.getString("label"));
        ((TextView)rootView.findViewById(R.id.cuecard_phonemes)).setText(args.getString("phonemes"));

        TextView mnemonicField = (TextView)rootView.findViewById(R.id.cuecard_mnemonic);
        mnemonicField.setText(Html.fromHtml(args.getString("mnemonic")));

        Log.d("CueCard", "cue_image is: " + args.getInt("cue_image"));

        ImageView cueImg = (ImageView)rootView.findViewById(R.id.cue_image);
        ImageView dotImg = (ImageView)rootView.findViewById(R.id.dot_view);
        mCueImage = cueImg;
        cueImg.setImageResource(args.getInt("cue_image"));

        switch(args.getString("animate_dot"))
        {
            case "leisure":
                break;
            case "tall blue tent":
                break;


        } // end switch

        if (args.getString("animate_dot") == "leisure") {
            View dotv = new Dot(getActivity(), Color.RED, 0, 0); // getActivity used because we're a fragment and we need context
            Bitmap bitmap = Bitmap.createBitmap(1120, 784, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            dotv.draw(canvas);
            dotImg.setImageBitmap(bitmap);
            /*
            BitmapDrawable b = ((BitmapDrawable)cueImg.getDrawable());
            Bitmap bmp = b.getBitmap();
            Integer w = bmp.getWidth();
            Integer h = bmp.getHeight();
            Log.d("CueCard", "width x height of face = " + w.toString() + " x " + h.toString());
            */
        } else if (args.getString("animate_dot") == "tall blue tent") {
            View dotv = new Dot(getActivity(), Color.RED, 50, 0); // getActivity used because we're a fragment and we need context
            Bitmap bitmap = Bitmap.createBitmap(1120, 784, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            dotv.draw(canvas);
            dotImg.setImageBitmap(bitmap);

        } else {

        }


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
        //prefsEditor.putString("currentPage", )
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

    private class Dot extends View {
        Paint mPaint = new Paint();
        int mColor = Color.RED;
        int mX = 0;
        int mY = 0;

        public Dot(Context context, int c, int x, int y) {
            super(context);
            mColor = c;
            mX = x;
            mY = y;
        }

        @Override
        public void onDraw(Canvas canvas) {
            mPaint.setColor(mColor);
            //paint.setAlpha(125);
            canvas.drawCircle(mX, mY, 20, mPaint);
        }
    }
}
