package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class VisibleStateFrameLayout extends FrameLayout {
    private VisibilityChanged a;

    /* loaded from: classes.dex */
    public interface VisibilityChanged {
        void callback(boolean z);
    }

    public VisibleStateFrameLayout(@NonNull Context context) {
        super(context);
    }

    public VisibleStateFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VisibleStateFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        VisibilityChanged visibilityChanged = this.a;
        if (visibilityChanged == null || view != this) {
            return;
        }
        visibilityChanged.callback(i2 == 0);
    }

    public void setVisibilityChanged(VisibilityChanged visibilityChanged) {
        this.a = visibilityChanged;
    }
}
