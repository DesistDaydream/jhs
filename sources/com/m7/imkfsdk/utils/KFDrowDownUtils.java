package com.m7.imkfsdk.utils;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.view.ViewCompat;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.dropdownmenu.DropDownMenu;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class KFDrowDownUtils {
    public static void setChatDropDownMenu(Context context, DropDownMenu dropDownMenu, String[] strArr) {
        dropDownMenu.setmMenuCount(1);
        dropDownMenu.setmShowCount(6);
        dropDownMenu.setShowCheck(true);
        dropDownMenu.setmMenuTitleTextSize(14);
        int i2 = R.color.ykfsdk_all_black;
        dropDownMenu.setmMenuTitleTextColor(i2);
        dropDownMenu.setmMenuListTextSize(14);
        dropDownMenu.setmMenuListTextColor(ViewCompat.MEASURED_STATE_MASK);
        dropDownMenu.setmMenuPressedBackColor(-1);
        dropDownMenu.setmMenuPressedTitleTextColor(i2);
        dropDownMenu.setmCheckIcon(R.drawable.ykfsdk_ico_make);
        dropDownMenu.setDefaultMenuTitle(new String[]{strArr[0]});
        dropDownMenu.setShowDivider(false);
        Resources resources = context.getResources();
        int i3 = R.color.ykfsdk_all_white;
        dropDownMenu.setmMenuListBackColor(resources.getColor(i3));
        dropDownMenu.setmMenuListSelectorRes(i3);
        dropDownMenu.setmArrowMarginTitle(20);
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr);
        dropDownMenu.setmMenuItems(arrayList);
        dropDownMenu.setIsDebug(false);
    }
}
