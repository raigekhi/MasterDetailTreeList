package com.example.cindyoakes.masterdetailtreelist;

/**
 * Created by cindyoakes on 9/23/16.
 */

import android.os.Bundle;
import android.app.Fragment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cindyoakes.masterdetailtreelist.R;


public class DetailFragment extends Fragment
{
    final static String KEY_POSITION = "position";
    int mCurrentPosition = -1;

    TextView mDetailTextView;

    public DetailFragment() {  }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // If the Activity is recreated, the savedInstanceStare Bundle isn't empty
        // we restore the previous version name selection set by the Bundle.
        // This is necessary when in two pane layout
        if (savedInstanceState != null){
            mCurrentPosition = savedInstanceState.getInt(KEY_POSITION);
        }


        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        mDetailTextView = (TextView) view.findViewById(R.id.detail_text);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        // During the startup, we check if there are any arguments passed to the fragment.
        // onStart() is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method below
        // that sets the description text
        Bundle args = getArguments();
        if (args != null){
            // Set description based on argument passed in
            setDetail(args.getInt(KEY_POSITION));
        } else if(mCurrentPosition != -1){
            // Set description based on savedInstanceState defined during onCreateView()
            setDetail(mCurrentPosition);
        }
    }

    public void setDetail(int detailIndex){

        TreeViewNode node = GlobalVariables.displayNodes.get(detailIndex);

        mDetailTextView.setText(node.getNodeName());
        mCurrentPosition = detailIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current description selection in case we need to recreate the fragment
        outState.putInt(KEY_POSITION,mCurrentPosition);
    }


}

