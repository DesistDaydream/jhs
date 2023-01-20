package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

/* loaded from: classes2.dex */
public class TabItem extends View {
    public final CharSequence a;
    public final Drawable b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3061c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TabItem);
        this.a = obtainStyledAttributes.getText(R.styleable.TabItem_android_text);
        this.b = obtainStyledAttributes.getDrawable(R.styleable.TabItem_android_icon);
        this.f3061c = obtainStyledAttributes.getResourceId(R.styleable.TabItem_android_layout, 0);
        obtainStyledAttributes.recycle();
    }
}
