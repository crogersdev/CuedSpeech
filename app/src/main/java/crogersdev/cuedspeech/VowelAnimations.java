package crogersdev.cuedspeech;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by chris on 12/31/16.
 */

public class VowelAnimations {

    private static int mDuration = 2000;

    public static AnimationSet setSideDownAnimation() {
        /*DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        int originalPos[] = new int[2];
        dot.getLocationOnScreen(originalPos);*/

        int yDelta = 340;

        AnimationSet anim = new AnimationSet(true);
        anim.setFillAfter(true);
        anim.setDuration(mDuration);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        TranslateAnimation translate = new TranslateAnimation(0, 0, 0, yDelta);
        translate.setRepeatMode(Animation.INFINITE);
        translate.setRepeatCount(Animation.INFINITE);
        anim.addAnimation(translate);
        return anim;
    }
    public static AnimationSet setSideForwardAnimation() {
        int yDelta = 50;

        AnimationSet anim = new AnimationSet(true);
        anim.setFillAfter(true);
        anim.setDuration(mDuration);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());

        float scaleXstart = 1.0f;
        float scaleYstart = 1.0f;
        float scaleXfinish = 3f;
        float scaleYfinish = 3f;
        ScaleAnimation scale = new ScaleAnimation(scaleXstart, scaleXfinish, scaleYstart, scaleYfinish, Animation.RELATIVE_TO_SELF, 0.05f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setRepeatMode(Animation.INFINITE);
        scale.setRepeatCount(Animation.INFINITE);

        anim.addAnimation(scale);
        return anim;
    }
    public static AnimationSet setChinToThroatAnimation() {
        int yDelta = 170;

        AnimationSet anim = new AnimationSet(true);
        anim.setFillAfter(true);
        anim.setDuration(mDuration);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        TranslateAnimation translate = new TranslateAnimation(0, 0, 0, yDelta);
        translate.setRepeatMode(Animation.INFINITE);
        translate.setRepeatCount(Animation.INFINITE);
        anim.addAnimation(translate);
        return anim;
    }
    public static AnimationSet setSideToThroatAnimation() {
        int xDelta = 500;
        int yDelta = 325;

        AnimationSet anim = new AnimationSet(true);
        anim.setFillAfter(true);
        anim.setDuration(mDuration);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        TranslateAnimation translate = new TranslateAnimation(0, xDelta, 0, yDelta);
        translate.setRepeatMode(Animation.INFINITE);
        translate.setRepeatCount(Animation.INFINITE);
        anim.addAnimation(translate);
        return anim;
    }
}
