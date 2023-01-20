package com.jihuanshe.base.magicindicator.commonnavigator.titles;

import android.content.Context;
import e.l.h.h.a;

/* loaded from: classes2.dex */
public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    public ColorTransitionPagerTitleView(Context context) {
        super(context);
    }

    @Override // com.jihuanshe.base.magicindicator.commonnavigator.titles.SimplePagerTitleView, e.l.h.h.g.a.d
    public void a(int i2, int i3) {
    }

    @Override // com.jihuanshe.base.magicindicator.commonnavigator.titles.SimplePagerTitleView, e.l.h.h.g.a.d
    public void b(int i2, int i3, float f2, boolean z) {
        setTextColor(a.a(f2, this.f3850c, this.b));
    }

    @Override // com.jihuanshe.base.magicindicator.commonnavigator.titles.SimplePagerTitleView, e.l.h.h.g.a.d
    public void c(int i2, int i3) {
    }

    @Override // com.jihuanshe.base.magicindicator.commonnavigator.titles.SimplePagerTitleView, e.l.h.h.g.a.d
    public void d(int i2, int i3, float f2, boolean z) {
        setTextColor(a.a(f2, this.b, this.f3850c));
    }
}
