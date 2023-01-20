package com.didichuxing.doraemonkit.kit.core;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class DokitFrameLayout extends FrameLayout implements DokitViewInterface {
    public static final int DoKitFrameLayoutFlag_CHILD = 200;
    public static final int DoKitFrameLayoutFlag_ROOT = 100;

    public DokitFrameLayout(@NonNull Context context, int flag) {
        super(context);
    }

    public DokitFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DokitFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
