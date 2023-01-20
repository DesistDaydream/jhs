package com.tencent.qcloud.tuicore.util;

import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;

/* loaded from: classes3.dex */
public class SoftKeyBoardUtil {
    private static SharedPreferences preferences = TUIConfig.getAppContext().getSharedPreferences(TUIConstants.TUIChat.UI_PARAMS, 0);
    private static int softKeyBoardHeight;

    public static int[] getScreenSize() {
        DisplayMetrics displayMetrics = TUIConfig.getAppContext().getResources().getDisplayMetrics();
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static int getSoftKeyBoardHeight() {
        int i2 = softKeyBoardHeight;
        if (i2 != 0) {
            return i2;
        }
        int i3 = preferences.getInt(TUIConstants.TUIChat.SOFT_KEY_BOARD_HEIGHT, 0);
        softKeyBoardHeight = i3;
        return i3 == 0 ? (getScreenSize()[1] * 2) / 5 : i3;
    }

    public static void hideKeyBoard(IBinder iBinder) {
        InputMethodManager inputMethodManager = (InputMethodManager) TUIConfig.getAppContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }
}
