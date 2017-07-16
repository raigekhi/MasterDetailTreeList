package com.example.cindyoakes.masterdetailtreelist;

import android.util.Log;

import java.util.ArrayList;


public class TreeViewLists
{

    public static ArrayList<TreeViewData> LoadInitialData()
    {
        ArrayList<TreeViewData> data = new ArrayList<TreeViewData>();

        data.add(new TreeViewData(0, "cindy's family tree", "1", "-1"));
        data.add(new TreeViewData(0, "jack's family tree", "2", "-1"));
        data.add(new TreeViewData(1, "katherine", "3",  "1"));
        data.add(new TreeViewData(1, "kyle", "4", "1"));
        data.add(new TreeViewData(2, "hayley","5", "3"));
        data.add(new TreeViewData(2, "macey", "6", "3"));
        data.add(new TreeViewData(1, "katelyn", "7", "2"));
        data.add(new TreeViewData(1, "jared", "8", "2"));
        data.add(new TreeViewData(1, "denyee", "9", "2"));
        data.add(new TreeViewData(2, "cayleb", "10", "4"));
        data.add(new TreeViewData(2, "carter", "11", "4"));
        data.add(new TreeViewData(2, "braylon", "12", "4"));
        data.add(new TreeViewData(3, "samson", "13", "5"));
        data.add(new TreeViewData(3, "samson", "14", "6"));


        return data;
    }

    public static ArrayList<TreeViewNode> LoadInitialNodes(ArrayList<TreeViewData> dataList)
    {
        ArrayList<TreeViewNode> nodes = new ArrayList<TreeViewNode>();

        for(int i = 0; i < dataList.size(); i++)
        {
            TreeViewData data = dataList.get(i);
            if (data.getLevel() != 0) continue;

            Log.v("LoadInitialNodes", data.getName());

            TreeViewNode node = new TreeViewNode();
            node.setNodeLevel(data.getLevel());
            node.setIsExpanded(GlobalVariables.TRUE);
            node.setNodeName(data.getName());
            int newLevel = data.getLevel() + 1;
            node.setNodeChildern(null);
            ArrayList<TreeViewNode> children = LoadChildrenNodes(dataList, newLevel, data.getID());
            //node.setNodeChildern(LoadChildrenNodes(dataList, newLevel, data.getID()));
            //if (node.getNodeChildren().size() == 0)
            if (children.size() == 0)
            {
                node.setNodeChildern(null);
            }
            else
            {
                node.setNodeChildern(children);
            }

            nodes.add(node);

        }


        return nodes;
    }

    private static ArrayList<TreeViewNode> LoadChildrenNodes(ArrayList<TreeViewData> dataList, int level, String parentID)
    {
        ArrayList<TreeViewNode> nodes = new ArrayList<TreeViewNode>();

        for(int i = 0; i < dataList.size(); i++)
        {
            TreeViewData data = dataList.get(i);
            if ((data.getLevel() != level) || (data.getParentID() != parentID)) continue;



            TreeViewNode node = new TreeViewNode();
            node.setNodeLevel(data.getLevel());
            node.setNodeName(data.getName());
            node.setIsExpanded(GlobalVariables.FALSE);
            int newLevel = level + 1;
            node.setNodeChildern(null);
            ArrayList<TreeViewNode> children = LoadChildrenNodes(dataList, newLevel, data.getID());
            //node.setNodeChildern(LoadChildrenNodes(dataList, newLevel, data.getID()));
            if (children.size() == 0)
            {
                node.setNodeChildern(null);
            }
            else
            {
                node.setNodeChildern(children);
            }

            nodes.add(node);

            Log.v("LoadChildrenNodes", String.format("%s %d",data.getName(), children.size()));
        }


        return nodes;
    }


    public static void LoadDisplayList()
    {
        GlobalVariables.displayNodes = new ArrayList<TreeViewNode>();
        for(int i = 0; i < GlobalVariables.nodes.size(); i++)
        {
            TreeViewNode node = GlobalVariables.nodes.get(i);
            GlobalVariables.displayNodes.add(node);

            if (node.getIsExpanded() == GlobalVariables.TRUE)
            {
                ArrayList<TreeViewNode> children = node.getNodeChildren();
                if (children != null)
                    if (children.size() != 0)
                        AddChildrenToList(children);
            }
        }
    }

    public static void AddChildrenToList(ArrayList<TreeViewNode> children)
    {
        if (children == null) return;

        for(int i = 0; i < children.size(); i++)
        {
            TreeViewNode node = children.get(i);
            GlobalVariables.displayNodes.add(node);

            Log.v("addchildrentolist", String.format("%d %s %d", i, node.getNodeName(), children.size()));

            if (node.getIsExpanded() == GlobalVariables.TRUE)
            {
                ArrayList<TreeViewNode> grandChildren = node.getNodeChildren();
                if (grandChildren != null)
                    AddChildrenToList(grandChildren);
            }
        }
    }










}
