package com.example.cindyoakes.masterdetailtreelist;

/**
 * Created by cindyoakes on 9/23/16.
 */
import java.util.ArrayList;

public class TreeViewNode
{
    private int _nodeLevel;
    private String _isExpanded;
    private String _nodeName;
    private ArrayList<TreeViewNode> _nodeChildren;

    public TreeViewNode() {}

    public TreeViewNode(int nodeLevel, String isExpanded, String nodeName, ArrayList<TreeViewNode> nodeChildren)
    {
        this._nodeLevel = nodeLevel;
        this._isExpanded = isExpanded;
        this._nodeName = nodeName;
        this._nodeChildren = nodeChildren;
    }

    public int getNodeLevel()
    {
        return _nodeLevel;
    }

    public void setNodeLevel(int nodeLevel)
    {
        this._nodeLevel = nodeLevel;
    }

    public String getIsExpanded()
    {
        return _isExpanded;
    }

    public void setIsExpanded(String isExpanded)
    {
        this._isExpanded = isExpanded;
    }

    public String getNodeName()
    {
        return _nodeName;
    }

    public void setNodeName(String nodeName)
    {
        this._nodeName = nodeName;
    }

    public ArrayList<TreeViewNode> getNodeChildren()
    {
        return _nodeChildren;
    }

    public void setNodeChildern(ArrayList<TreeViewNode> nodeChildren)
    {
        this._nodeChildren = nodeChildren;
    }
}