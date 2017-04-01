package crogersdev.cuedspeech;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
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
        cueImg.setImageResource(args.getInt("cue_image"));

        Bitmap bitmap = null;
        Canvas canvas = null;
        View dotv = null;
        if (args.getString("animate_dot") != null) {
            bitmap = Bitmap.createBitmap(1092, 800, Bitmap.Config.ARGB_8888); // dimensions hardcoded to be the size of the image (bleh!  feels like an ugly hack)
            canvas = new Canvas(bitmap);
        }

        if (args.getString("animate_dot") != null) {
            AnimationSet animation = null;
            switch (args.getString("animate_dot")) {
                case "leisure":
                    /*Bitmap b = ((BitmapDrawable)cueImg.getDrawable()).getBitmap();
                    Log.d("CueCard", "width: " + b.getWidth());
                    Log.d("CueCard", "height: " + b.getHeight());
                    leaving this here for legacy purposes...*/
                    dotv = new Dot(getActivity(), Color.RED, 350, 445); // getActivity used because we're a fragment and we need context
                    break;
                case "tall blue tent":
                    dotv = new Dot(getActivity(), Color.RED, 570, 570);
                    break;
                case "look big crabs":
                    dotv = new Dot(getActivity(), Color.RED, 570, 720);
                    break;
                case "consonant alone":
                    dotv = new Dot(getActivity(), Color.RED, 50, 460); // side
                    break;
                case "boat dock":
                    animation = VowelAnimations.setSideForwardAnimation();
                    dotv = new Dot(getActivity(), Color.RED, 50, 460); // side forward
                    break;
                case "sun":
                    //animation = AnimationUtils.loadAnimation(getActivity(), R.anim.side_down);
                    animation = VowelAnimations.setSideDownAnimation();
                    dotv = new Dot(getActivity(), Color.RED, 50, 460); // side down
                    break;
                case "moist snails":
                    animation = VowelAnimations.setChinToThroatAnimation();
                    dotv = new Dot(getActivity(), Color.RED, 570, 570); // chin to throat
                    break;
                case "light house":
                    animation = VowelAnimations.setSideToThroatAnimation();
                    dotv = new Dot(getActivity(), Color.RED, 50, 445); // side to throat
                    break;
                default:
                    break;
            } // end switch
            dotImg.setVisibility(View.VISIBLE);
            dotv.draw(canvas);
            dotImg.setImageBitmap(bitmap);
            if (animation != null) {
                dotImg.startAnimation(animation);
            }
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
    } // end onCreateView

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

        public void zoomAnimate() {

        }
    }
}
