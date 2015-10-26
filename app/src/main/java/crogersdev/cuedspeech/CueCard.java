package crogersdev.cuedspeech;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chris on 10/24/15.
 */
public class CueCard extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cuecard, container, false);

        Bundle args = getArguments();
        ((TextView)rootView.findViewById(R.id.text)).setText("Page " + args.getInt("page_position"));

        return rootView;
    }
}