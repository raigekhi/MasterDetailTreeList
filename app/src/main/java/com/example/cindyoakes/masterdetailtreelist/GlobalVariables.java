package com.example.cindyoakes.masterdetailtreelist;

import java.util.ArrayList;

/**
 * Created by cindyoakes on 9/23/16.
 */
public class GlobalVariables
{
    public static String TRUE = "true";
    public static String FALSE = "false";

    public static ArrayList<TreeViewData> dataList = new ArrayList<TreeViewData>();
    public static ArrayList<TreeViewNode> nodes = new ArrayList<TreeViewNode>();
    public static ArrayList<TreeViewNode> displayNodes = new ArrayList<TreeViewNode>();

    public static String[] androidNames = new String[]
            {
                    "Android 5.0 Lollipop",
                    "Android 4.4 KitKat",
                    "Android 4.1 Jelly Bean",
                    "Android 4.0 Ice Cream Sandwich",
                    "Android 3.0 Honeycomb",
                    "Android 2.3 Gingerbread"
            };

    public static String[] androidDescriptions = new String[]
            {
                    "A sweet new take on Android. Get the smarts of Android on screens big and small – with the right information at the right moment.",
                    "Smart, simple, and truly yours. A more polished design, improved performance, and new features.",
                    "Android is fast and smooth with buttery graphics. With Google Now, you get just the right information at the right time.\\n And with more than 1 million apps on Google Play, and thousands of Android devices, you\\'ve got the freedom to do what you want on any device you choose.",
                    "Android comes of age with a new, refined design. Simple, beautiful and beyond smart.",
                    "Optimized for tablets, this release opens up new horizons wherever you are.",
                    "New sensors make Android great for gaming - so you can touch, tap, tilt, and play away."
            };

}
