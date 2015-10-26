package crogersdev.cuedspeech;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chris on 10/24/15.
 */
public class CueCard extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cuecard, container, false);

        Bundle args = getArguments();
        //((TextView)rootView.findViewById(R.id.text)).setText("Page " + args.getInt("page_position"));
        ((TextView)rootView.findViewById(R.id.cuecard_label)).setText(args.getString("label"));
        ((TextView)rootView.findViewById(R.id.cuecard_phonemes)).setText(args.getString("phonemes"));
        ((TextView)rootView.findViewById(R.id.cuecard_mnemonic)).setText(args.getString("mnemonic"));
        Log.d("crogersdev", "cue_image is: " + args.getInt("cue_image"));
        switch (args.getInt("cue_image")) {
            case 1:
                rootView.findViewById(R.id.cue_image).setBackgroundResource(R.drawable.handshape_1);
                break;
            case 2:
                rootView.findViewById(R.id.cue_image).setBackgroundResource(R.drawable.handshape_2);
                break;
            case 3:
                rootView.findViewById(R.id.cue_image).setBackgroundResource(R.drawable.handshape_3);
                break;
            case 4:
                rootView.findViewById(R.id.cue_image).setBackgroundResource(R.drawable.handshape_4);
                break;
            case 5:
                rootView.findViewById(R.id.cue_image).setBackgroundResource(R.drawable.handshape_5);
                break;
            case 6:
                rootView.findViewById(R.id.cue_image).setBackgroundResource(R.drawable.handshape_6);
                break;
            case 7:
                rootView.findViewById(R.id.cue_image).setBackgroundResource(R.drawable.handshape_7);
                break;
            case 8:
                rootView.findViewById(R.id.cue_image).setBackgroundResource(R.drawable.handshape_8);
                break;
        }


        return rootView;
    }
}
