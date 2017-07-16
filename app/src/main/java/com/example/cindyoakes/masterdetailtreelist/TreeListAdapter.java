package com.example.cindyoakes.masterdetailtreelist;

/**
 * Created by cindyoakes on 9/23/16.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.cindyoakes.masterdetailtreelist.R;
import com.example.cindyoakes.masterdetailtreelist.TreeViewNode;
import com.example.cindyoakes.masterdetailtreelist.TreeListViewHolder;
import com.example.cindyoakes.masterdetailtreelist.GlobalVariables;

public class TreeListAdapter extends ArrayAdapter<TreeViewNode>
{

    private final LayoutInflater mInflater;

    public TreeListAdapter(Context context) {
        super(context, android.R.layout.simple_gallery_item);

        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return GlobalVariables.displayNodes.size();
    }

    @Override
    public TreeViewNode getItem(int position) {
        return GlobalVariables.displayNodes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     * Populate new items in the list.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TreeListViewHolder holder = null;

        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.single_item, parent, false);

            holder = new TreeListViewHolder();
            holder.content = (TextView) convertView.findViewById(R.id.text);
            holder.arrow = (ImageView) convertView.findViewById(R.id.arrow);
            holder.position = position;

            ((ImageView) convertView.findViewById(R.id.arrow)).setOnClickListener(mArrowClickListener);

            convertView.setTag(holder);
        } else
        {
            holder = (TreeListViewHolder) convertView.getTag();
        }


        TreeViewNode node = GlobalVariables.displayNodes.get(position);
        holder.content.setText(node.getNodeName());

        if (node.getIsExpanded() == GlobalVariables.TRUE)
        {
            holder.arrow.setImageResource(R.drawable.open_arrow);
        }
        else
        {
            holder.arrow.setImageResource(R.drawable.close_arrow);
        }


        holder.arrow.setTag(position);

        int lvl = node.getNodeLevel();
        int newWidth = (lvl * 60) + 1;
        ((TextView) convertView.findViewById(R.id.spacer)).getLayoutParams().width = newWidth;
        ((TextView) convertView.findViewById(R.id.spacer)).requestLayout();

        return convertView;
    }

    private OnClickListener mArrowClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

            int position = (int)v.getTag();

            if (position != ListView.INVALID_POSITION) {
                TreeViewNode node = GlobalVariables.displayNodes.get(position);

                if (node.getIsExpanded() == GlobalVariables.TRUE)
                {
                    node.setIsExpanded(GlobalVariables.FALSE);
                }
                else
                {
                    if (node.getNodeChildren() != null)
                        node.setIsExpanded(GlobalVariables.TRUE);
                }

                TreeViewLists.LoadDisplayList();

                notifyDataSetChanged();

            }

        }
    };


}


