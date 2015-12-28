package crogersdev.cuedspeech;

import android.content.res.Resources;

/**
 * Created by chris on 12/24/15.
 */
public enum CueImg {

    HANDSHAPE1 (R.drawable.handshape_1_icon),
    HANDSHAPE2 (R.drawable.handshape_2_icon),
    HANDSHAPE3 (R.drawable.handshape_3_icon),
    HANDSHAPE4 (R.drawable.handshape_4_icon),
    HANDSHAPE5 (R.drawable.handshape_5_icon),
    HANDSHAPE6 (R.drawable.handshape_6_icon),
    HANDSHAPE7 (R.drawable.handshape_7_icon),
    HANDSHAPE8 (R.drawable.handshape_8_icon),
    VOWEL_MOUTH (R.drawable.vowel_mouth),
    VOWEL_CHIN (R.drawable.vowel_chin),
    VOWEL_THROAT (R.drawable.vowel_throat),
    VOWEL_SIDE (R.drawable.vowel_side),
    VOWEL_SIDE_FWD (R.drawable.vowel_side_fwd),
    VOWEL_SIDE_DOWN (R.drawable.vowel_side_down),
    VOWEL_CHIN_THROAT (R.drawable.vowel_chin_throat),
    VOWEL_SIDE_THROAT (R.drawable.vowel_side_throat);

    int id;
    CueImg (int id)  { this.id = id; }

    public String getName(Resources r) { return r.getString(id); }
}
