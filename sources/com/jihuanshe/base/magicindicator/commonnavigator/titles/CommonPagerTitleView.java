package com.jihuanshe.base.magicindicator.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class CommonPagerTitleView extends FrameLayout implements e.l.h.h.g.a.b {
    private b a;
    private a b;

    /* loaded from: classes2.dex */
    public interface a {
        int getContentBottom();

        int getContentLeft();

        int getContentRight();

        int getContentTop();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i2, int i3);

        void b(int i2, int i3, float f2, boolean z);

        void c(int i2, int i3);

        void d(int i2, int i3, float f2, boolean z);
    }

    public CommonPagerTitleView(Context context) {
        super(context);
    }

    @Override // e.l.h.h.g.a.d
    public void a(int i2, int i3) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(i2, i3);
        }
    }

    @Override // e.l.h.h.g.a.d
    public void b(int i2, int i3, float f2, boolean z) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.b(i2, i3, f2, z);
        }
    }

    @Override // e.l.h.h.g.a.d
    public void c(int i2, int i3) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.c(i2, i3);
        }
    }

    @Override // e.l.h.h.g.a.d
    public void d(int i2, int i3, float f2, boolean z) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.d(i2, i3, f2, z);
        }
    }

    public void e(View view, FrameLayout.LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    @Override // e.l.h.h.g.a.b
    public int getContentBottom() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.getContentBottom();
        }
        return getBottom();
    }

    @Override // e.l.h.h.g.a.b
    public int getContentLeft() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.getContentLeft();
        }
        return getLeft();
    }

    public a getContentPositionDataProvider() {
        return this.b;
    }

    @Override // e.l.h.h.g.a.b
    public int getContentRight() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.getContentRight();
        }
        return getRight();
    }

    @Override // e.l.h.h.g.a.b
    public int getContentTop() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.getContentTop();
        }
        return getTop();
    }

    public b getOnPagerTitleChangeListener() {
        return this.a;
    }

    public void setContentPositionDataProvider(a aVar) {
        this.b = aVar;
    }

    public void setContentView(View view) {
        e(view, null);
    }

    public void setOnPagerTitleChangeListener(b bVar) {
        this.a = bVar;
    }

    public void setContentView(int i2) {
        e(LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) null), null);
    }
}
