package com.example.cindyoakes.masterdetailtreelist;

/**
 * Created by cindyoakes on 9/23/16.
 */

import android.os.Bundle;
import android.app.ListFragment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class TreeViewFragment extends ListFragment {



    TreeListAdapter mAdapter;

    public TreeViewFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GlobalVariables.dataList = TreeViewLists.LoadInitialData();

        GlobalVariables.nodes = TreeViewLists.LoadInitialNodes(GlobalVariables.dataList);

        TreeViewLists.LoadDisplayList();

        // Create an empty adapter we will use to display the loaded data.
        mAdapter = new TreeListAdapter(getActivity().getBaseContext());
        setListAdapter(mAdapter);

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        TreeViewNode node = GlobalVariables.displayNodes.get(position);
        //showMessage(node.getNodeName());

        OnVerseNameSelectionChangeListener listener = (OnVerseNameSelectionChangeListener) getActivity();

        listener.OnSelectionChanged(position);
    }


    private void showMessage(String message) {
        //Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

        Log.v("show message", message);
    }





}
