package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes.dex */
public final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager a;
    private ViewPager2.PageTransformer b;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.a = linearLayoutManager;
    }

    public ViewPager2.PageTransformer a() {
        return this.b;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i2, float f2, int i3) {
        if (this.b == null) {
            return;
        }
        float f3 = -f2;
        for (int i4 = 0; i4 < this.a.getChildCount(); i4++) {
            View childAt = this.a.getChildAt(i4);
            if (childAt != null) {
                this.b.transformPage(childAt, (this.a.getPosition(childAt) - i2) + f3);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i4), Integer.valueOf(this.a.getChildCount())));
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i2) {
    }

    public void a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.b = pageTransformer;
    }
}
