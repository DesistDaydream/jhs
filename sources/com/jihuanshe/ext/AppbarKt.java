package com.jihuanshe.ext;

import android.view.View;
import com.vector.design.ui.nav.AppBar;
import e.t.o.d;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class AppbarKt {
    public static final void a(@d AppBar appBar, int i2, @e l<? super View, t1> lVar) {
        appBar.getEnd().d(new AppbarKt$addMoreView$1(i2, lVar));
    }

    public static /* synthetic */ void b(AppBar appBar, int i2, l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = d.a.c(e.t.o.d.a, null, 1, null).d(12);
        }
        if ((i3 & 2) != 0) {
            lVar = null;
        }
        a(appBar, i2, lVar);
    }

    public static final void c(@k.e.a.d AppBar appBar, int i2, @e a<t1> aVar) {
        appBar.getEnd().d(new AppbarKt$addSearchView$1(i2, aVar));
    }

    public static /* synthetic */ void d(AppBar appBar, int i2, a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = d.a.c(e.t.o.d.a, null, 1, null).d(12);
        }
        if ((i3 & 2) != 0) {
            aVar = null;
        }
        c(appBar, i2, aVar);
    }

    public static final void e(@k.e.a.d AppBar appBar, int i2, @e a<t1> aVar) {
        appBar.getEnd().d(new AppbarKt$addTickView$1(i2, aVar));
    }

    public static /* synthetic */ void f(AppBar appBar, int i2, a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = d.a.c(e.t.o.d.a, null, 1, null).d(12);
        }
        if ((i3 & 2) != 0) {
            aVar = null;
        }
        e(appBar, i2, aVar);
    }
}
