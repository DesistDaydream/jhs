package com.effective.android.panel.log;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.effective.android.panel.Constants;
import com.effective.android.panel.interfaces.listener.OnEditFocusChangeListener;
import com.effective.android.panel.interfaces.listener.OnKeyboardStateListener;
import com.effective.android.panel.interfaces.listener.OnPanelChangeListener;
import com.effective.android.panel.interfaces.listener.OnViewClickListener;
import com.effective.android.panel.view.panel.IPanelView;
import h.k2.k;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\t\b\u0002¢\u0006\u0004\b'\u0010\u0017J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJA\u0010!\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/effective/android/panel/log/LogTracker;", "Lcom/effective/android/panel/interfaces/listener/OnEditFocusChangeListener;", "Lcom/effective/android/panel/interfaces/listener/OnKeyboardStateListener;", "Lcom/effective/android/panel/interfaces/listener/OnPanelChangeListener;", "Lcom/effective/android/panel/interfaces/listener/OnViewClickListener;", "", "methodName", "message", "Lh/t1;", "log", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/View;", "view", "", "hasFocus", "onFocusChange", "(Landroid/view/View;Z)V", TTLogUtil.TAG_EVENT_SHOW, "", "height", "onKeyboardChange", "(ZI)V", "onKeyboard", "()V", "onNone", "Lcom/effective/android/panel/view/panel/IPanelView;", "panel", "onPanel", "(Lcom/effective/android/panel/view/panel/IPanelView;)V", "portrait", "oldWidth", "oldHeight", "width", "onPanelSizeChange", "(Lcom/effective/android/panel/view/panel/IPanelView;ZIIII)V", "onClickBefore", "(Landroid/view/View;)V", "TAG", "Ljava/lang/String;", "<init>", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LogTracker implements OnEditFocusChangeListener, OnKeyboardStateListener, OnPanelChangeListener, OnViewClickListener {
    public static final LogTracker INSTANCE = new LogTracker();
    private static final String TAG = LogTracker.class.getSimpleName();

    private LogTracker() {
    }

    @k
    public static final void log(@d String str, @d String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !Constants.DEBUG) {
            return;
        }
        String str3 = TAG;
        Log.d(str3, str + " => " + str2);
    }

    @Override // com.effective.android.panel.interfaces.listener.OnViewClickListener
    public void onClickBefore(@e View view) {
        StringBuilder sb = new StringBuilder();
        sb.append("view is ");
        sb.append((Object) ((view == null || (r3 = view.toString()) == null) ? " null " : " null "));
        log("OnViewClickListener#onViewClick", sb.toString());
    }

    @Override // com.effective.android.panel.interfaces.listener.OnEditFocusChangeListener
    public void onFocusChange(@e View view, boolean z) {
        log("OnEditFocusChangeListener#onFocusChange", "EditText has focus ( " + z + " )");
    }

    @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
    public void onKeyboard() {
        log("OnPanelChangeListener#onKeyboard", "panel： keyboard");
    }

    @Override // com.effective.android.panel.interfaces.listener.OnKeyboardStateListener
    public void onKeyboardChange(boolean z, int i2) {
        log("OnKeyboardStateListener#onKeyboardChange", "Keyboard is showing ( " + z + " ),height is " + i2);
    }

    @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
    public void onNone() {
        log("OnPanelChangeListener#onNone", "panel： none");
    }

    @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
    public void onPanel(@e IPanelView iPanelView) {
        StringBuilder sb = new StringBuilder();
        sb.append("panel：");
        sb.append((Object) ((iPanelView == null || (r3 = iPanelView.toString()) == null) ? "null" : "null"));
        log("OnPanelChangeListener#onPanel", sb.toString());
    }

    @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
    public void onPanelSizeChange(@e IPanelView iPanelView, boolean z, int i2, int i3, int i4, int i5) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("panelView is ");
        if (iPanelView == null || (str = iPanelView.toString()) == null) {
            str = "null portrait : " + z + " oldWidth : " + i2 + " oldHeight : " + i3 + " width : " + i4 + " height : " + i5;
        }
        sb.append((Object) str);
        log("OnPanelChangeListener#onPanelSizeChange", sb.toString());
    }
}
