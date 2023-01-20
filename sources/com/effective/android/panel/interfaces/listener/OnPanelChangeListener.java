package com.effective.android.panel.interfaces.listener;

import com.effective.android.panel.view.panel.IPanelView;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\b\u0010\tJA\u0010\u0011\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/effective/android/panel/interfaces/listener/OnPanelChangeListener;", "", "Lh/t1;", "onKeyboard", "()V", "onNone", "Lcom/effective/android/panel/view/panel/IPanelView;", "panel", "onPanel", "(Lcom/effective/android/panel/view/panel/IPanelView;)V", "", "portrait", "", "oldWidth", "oldHeight", "width", "height", "onPanelSizeChange", "(Lcom/effective/android/panel/view/panel/IPanelView;ZIIII)V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface OnPanelChangeListener {
    void onKeyboard();

    void onNone();

    void onPanel(@e IPanelView iPanelView);

    void onPanelSizeChange(@e IPanelView iPanelView, boolean z, int i2, int i3, int i4, int i5);
}
