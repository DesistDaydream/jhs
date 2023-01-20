package com.effective.android.panel;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/effective/android/panel/Constants;", "", "", "KEYBOARD_HEIGHT_FOR_L", "Ljava/lang/String;", "", "DEFAULT_KEYBOARD_HEIGHT_FOR_P", "F", "LOG_TAG", "KEYBOARD_HEIGHT_FOR_P", "DEFAULT_KEYBOARD_HEIGHT_FOR_L", "NAVIGATION_BAR_HEIGHT_RES_NAME", "DIMEN", "ANDROID", "", "PANEL_KEYBOARD", ExpandableTextView.P, "", "DEBUG", "Z", "", "PROTECT_KEY_CLICK_DURATION", "J", "PANEL_NONE", "STATUS_BAR_HEIGHT_RES_NAME", "KB_PANEL_PREFERENCE_NAME", "<init>", "()V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Constants {
    @d
    public static final String ANDROID = "android";
    @h.k2.d
    public static boolean DEBUG = false;
    public static final float DEFAULT_KEYBOARD_HEIGHT_FOR_L = 198.0f;
    public static final float DEFAULT_KEYBOARD_HEIGHT_FOR_P = 290.0f;
    @d
    public static final String DIMEN = "dimen";
    public static final Constants INSTANCE = new Constants();
    @d
    public static final String KB_PANEL_PREFERENCE_NAME = "ky_panel_name";
    @d
    public static final String KEYBOARD_HEIGHT_FOR_L = "keyboard_height_for_l";
    @d
    public static final String KEYBOARD_HEIGHT_FOR_P = "keyboard_height_for_p";
    @d
    public static final String LOG_TAG = "Panel";
    @d
    public static final String NAVIGATION_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    public static final int PANEL_KEYBOARD = 0;
    public static final int PANEL_NONE = -1;
    public static final long PROTECT_KEY_CLICK_DURATION = 500;
    @d
    public static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";

    private Constants() {
    }
}
