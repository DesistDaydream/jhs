package com.effective.android.panel.view.content;

import android.view.MotionEvent;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/effective/android/panel/view/content/IResetAction;", "", "", "enable", "Lh/t1;", "enableReset", "(Z)V", "Ljava/lang/Runnable;", "runnable", "setResetCallback", "(Ljava/lang/Runnable;)V", "Landroid/view/MotionEvent;", "ev", "consume", "hookDispatchTouchEvent", "(Landroid/view/MotionEvent;Z)Z", "hookOnTouchEvent", "(Landroid/view/MotionEvent;)Z", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface IResetAction {
    void enableReset(boolean z);

    boolean hookDispatchTouchEvent(@e MotionEvent motionEvent, boolean z);

    boolean hookOnTouchEvent(@e MotionEvent motionEvent);

    void setResetCallback(@d Runnable runnable);
}
