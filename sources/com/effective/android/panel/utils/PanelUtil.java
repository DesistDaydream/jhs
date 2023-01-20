package com.effective.android.panel.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.effective.android.panel.Constants;
import com.effective.android.panel.log.LogTracker;
import h.k2.k;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/effective/android/panel/utils/PanelUtil;", "", "Landroid/content/Context;", "context", "Lh/t1;", "clearData", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "", "showKeyboard", "(Landroid/content/Context;Landroid/view/View;)Z", "hideKeyboard", "", "getKeyBoardHeight", "(Landroid/content/Context;)I", "curPanelHeight", "isPanelHeightBelowKeyboardHeight", "(Landroid/content/Context;I)Z", "height", "setKeyBoardHeight", "hasMeasuredKeyboard$panel_release", "(Landroid/content/Context;)Z", "hasMeasuredKeyboard", "pHeight", ExpandableTextView.P, "lHeight", "<init>", "()V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PanelUtil {
    public static final PanelUtil INSTANCE = new PanelUtil();
    private static int pHeight = -1;
    private static int lHeight = -1;

    private PanelUtil() {
    }

    @k
    public static final void clearData(@d Context context) {
        pHeight = -1;
        lHeight = -1;
        context.getSharedPreferences(Constants.KB_PANEL_PREFERENCE_NAME, 0).edit().clear().apply();
    }

    @k
    public static final int getKeyBoardHeight(@d Context context) {
        int i2;
        int i3;
        boolean isPortrait = DisplayUtil.isPortrait(context);
        if (!isPortrait || (i3 = pHeight) == -1) {
            if (isPortrait || (i2 = lHeight) == -1) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.KB_PANEL_PREFERENCE_NAME, 0);
                String str = isPortrait ? Constants.KEYBOARD_HEIGHT_FOR_P : Constants.KEYBOARD_HEIGHT_FOR_L;
                int dip2px = DisplayUtil.dip2px(context, isPortrait ? 290.0f : 198.0f);
                int i4 = sharedPreferences.getInt(str, dip2px);
                if (i4 != dip2px) {
                    if (isPortrait) {
                        pHeight = i4;
                    } else {
                        lHeight = i4;
                    }
                }
                return i4;
            }
            return i2;
        }
        return i3;
    }

    @k
    public static final boolean hideKeyboard(@d Context context, @d View view) {
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            return ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @k
    public static final boolean isPanelHeightBelowKeyboardHeight(@d Context context, int i2) {
        return INSTANCE.hasMeasuredKeyboard$panel_release(context) && getKeyBoardHeight(context) > i2;
    }

    @k
    public static final boolean setKeyBoardHeight(@d Context context, int i2) {
        if (getKeyBoardHeight(context) == i2) {
            LogTracker.log("PanelUtil#onGlobalLayout", "current KeyBoardHeight is equal，just ignore！");
            return false;
        }
        boolean isPortrait = DisplayUtil.isPortrait(context);
        if (isPortrait && pHeight == i2) {
            LogTracker.log("PanelUtil#onGlobalLayout", "current KeyBoardHeight is equal，just ignore！");
            return false;
        } else if (!isPortrait && lHeight == i2) {
            LogTracker.log("PanelUtil#onGlobalLayout", "current KeyBoardHeight is equal，just ignore！");
            return false;
        } else {
            boolean commit = context.getSharedPreferences(Constants.KB_PANEL_PREFERENCE_NAME, 0).edit().putInt(isPortrait ? Constants.KEYBOARD_HEIGHT_FOR_P : Constants.KEYBOARD_HEIGHT_FOR_L, i2).commit();
            if (commit) {
                if (isPortrait) {
                    pHeight = i2;
                } else {
                    lHeight = i2;
                }
            }
            return commit;
        }
    }

    @k
    public static final boolean showKeyboard(@d Context context, @d View view) {
        view.requestFocus();
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            return ((InputMethodManager) systemService).showSoftInput(view, 0);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public final boolean hasMeasuredKeyboard$panel_release(@d Context context) {
        getKeyBoardHeight(context);
        return (pHeight == -1 && lHeight == -1) ? false : true;
    }
}
