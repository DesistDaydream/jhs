package cn.thinkingdata.android.aop;

import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import cn.thinkingdata.android.ThinkingDataRuntimeBridge;

/* loaded from: classes.dex */
public class ThinkingDataAutoTrackHelper {
    public static final String TAG = "ThinkingAnalytics";

    public static void track(String str, String str2, String str3) {
        ThinkingDataRuntimeBridge.trackEvent(str, str2, str3);
    }

    public static void trackDialog(DialogInterface dialogInterface, int i2) {
        ThinkingDataRuntimeBridge.onDialogClick(dialogInterface, i2);
    }

    public static void trackExpandableListViewOnChildClick(ExpandableListView expandableListView, View view, int i2, int i3) {
        ThinkingDataRuntimeBridge.onExpandableListViewOnChildClick(expandableListView, view, i2, i3);
    }

    public static void trackExpandableListViewOnGroupClick(ExpandableListView expandableListView, View view, int i2) {
        ThinkingDataRuntimeBridge.onExpandableListViewOnGroupClick(expandableListView, view, i2);
    }

    public static void trackListView(AdapterView<?> adapterView, View view, int i2) {
        ThinkingDataRuntimeBridge.onAdapterViewItemClick(adapterView, view, i2);
    }

    public static void trackMenuItem(MenuItem menuItem) {
    }

    public static void trackMenuItem(Object obj, MenuItem menuItem) {
        ThinkingDataRuntimeBridge.onMenuItemSelected(obj, menuItem);
    }

    public static void trackRadioGroup(RadioGroup radioGroup, int i2) {
        ThinkingDataRuntimeBridge.onViewOnClick(radioGroup, null);
    }

    public static void trackRadioGroup(RadioGroup radioGroup, int i2, String str) {
        ThinkingDataRuntimeBridge.onViewOnClick(radioGroup, str);
    }

    public static void trackTabHost(String str) {
        ThinkingDataRuntimeBridge.onTabHostChanged(str);
    }

    public static void trackTabLayoutSelected(Object obj, Object obj2) {
        try {
            Object invoke = obj2.getClass().getDeclaredMethod("getText", new Class[0]).invoke(obj2, new Object[0]);
            if (invoke != null) {
                ThinkingDataRuntimeBridge.onTabHostChanged(invoke.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void trackViewOnClick(View view) {
        ThinkingDataRuntimeBridge.onViewOnClick(view, null);
    }

    public static void trackViewOnClick(View view, String str) {
        ThinkingDataRuntimeBridge.onViewOnClick(view, str);
    }
}
