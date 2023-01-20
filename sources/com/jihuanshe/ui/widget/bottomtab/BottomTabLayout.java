package com.jihuanshe.ui.widget.bottomtab;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.jihuanshe.ui.widget.bottomtab.BottomTabItemView;
import e.l.q.c.p0.c;
import h.t1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class BottomTabLayout extends LinearLayout implements BottomTabItemView.b {
    @d
    private final List<c> a;
    @d
    private final HashMap<String, BottomTabItemView> b;
    @e

    /* renamed from: c  reason: collision with root package name */
    private c f4258c;

    /* renamed from: d  reason: collision with root package name */
    private int f4259d;
    @e

    /* renamed from: e  reason: collision with root package name */
    private a f4260e;

    /* loaded from: classes2.dex */
    public interface a {
        boolean a(@d c cVar);
    }

    public BottomTabLayout(@e Context context) {
        this(context, null);
    }

    private final BottomTabItemView b(c cVar) {
        BottomTabItemView bottomTabItemView = new BottomTabItemView(getContext(), cVar);
        bottomTabItemView.setOnSelectListener(this);
        return bottomTabItemView;
    }

    public static /* synthetic */ void d(BottomTabLayout bottomTabLayout, List list, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        bottomTabLayout.c(list, i2);
    }

    private final void e() {
        BottomTabItemView bottomTabItemView;
        for (c cVar : this.a) {
            this.b.put(cVar.g(), b(cVar));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 1.0f;
            t1 t1Var = t1.a;
            addView(this.b.get(cVar.g()), layoutParams);
            if (this.f4258c == null) {
                this.f4258c = cVar;
            }
        }
        c cVar2 = this.f4258c;
        if (cVar2 == null || (bottomTabItemView = this.b.get(cVar2.g())) == null) {
            return;
        }
        bottomTabItemView.b(1);
    }

    @Override // com.jihuanshe.ui.widget.bottomtab.BottomTabItemView.b
    public void a(@d c cVar) {
        String g2;
        String g3;
        this.f4259d = this.a.indexOf(cVar);
        a aVar = this.f4260e;
        if (!(aVar != null && aVar.a(cVar)) || cVar.k()) {
            return;
        }
        HashMap<String, BottomTabItemView> hashMap = this.b;
        c cVar2 = this.f4258c;
        String str = "";
        if (cVar2 == null || (g2 = cVar2.g()) == null) {
            g2 = "";
        }
        BottomTabItemView bottomTabItemView = hashMap.get(g2);
        if (bottomTabItemView != null) {
            bottomTabItemView.b(0);
        }
        this.f4258c = cVar;
        HashMap<String, BottomTabItemView> hashMap2 = this.b;
        if (cVar != null && (g3 = cVar.g()) != null) {
            str = g3;
        }
        BottomTabItemView bottomTabItemView2 = hashMap2.get(str);
        if (bottomTabItemView2 == null) {
            return;
        }
        bottomTabItemView2.b(1);
    }

    public final void c(@d List<c> list, int i2) {
        this.a.clear();
        this.a.addAll(list);
        this.f4258c = (c) CollectionsKt___CollectionsKt.J2(list, i2);
        e();
    }

    public final void f(int i2) {
        String g2;
        HashMap<String, BottomTabItemView> hashMap = this.b;
        c cVar = (c) CollectionsKt___CollectionsKt.J2(this.a, i2);
        String str = "";
        if (cVar != null && (g2 = cVar.g()) != null) {
            str = g2;
        }
        BottomTabItemView bottomTabItemView = hashMap.get(str);
        if (bottomTabItemView == null) {
            return;
        }
        bottomTabItemView.performClick();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002b A[Catch: all -> 0x005b, TryCatch #0 {all -> 0x005b, blocks: (B:2:0x0000, B:4:0x0009, B:11:0x0022, B:15:0x002f, B:22:0x0048, B:25:0x0051, B:18:0x0040, B:14:0x002b, B:8:0x001b, B:26:0x0055), top: B:31:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051 A[Catch: all -> 0x005b, TryCatch #0 {all -> 0x005b, blocks: (B:2:0x0000, B:4:0x0009, B:11:0x0022, B:15:0x002f, B:22:0x0048, B:25:0x0051, B:18:0x0040, B:14:0x002b, B:8:0x001b, B:26:0x0055), top: B:31:0x0000 }] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRestoreInstanceState(@k.e.a.e android.os.Parcelable r3) {
        /*
            r2 = this;
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L5b
            super.onRestoreInstanceState(r3)     // Catch: java.lang.Throwable -> L5b
            boolean r0 = r3 instanceof com.jihuanshe.ui.widget.bottomtab.SavedState     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L55
            com.jihuanshe.ui.widget.bottomtab.SavedState r3 = (com.jihuanshe.ui.widget.bottomtab.SavedState) r3     // Catch: java.lang.Throwable -> L5b
            int r3 = r3.getCurrent()     // Catch: java.lang.Throwable -> L5b
            r2.f4259d = r3     // Catch: java.lang.Throwable -> L5b
            java.util.HashMap<java.lang.String, com.jihuanshe.ui.widget.bottomtab.BottomTabItemView> r3 = r2.b     // Catch: java.lang.Throwable -> L5b
            e.l.q.c.p0.c r0 = r2.f4258c     // Catch: java.lang.Throwable -> L5b
            java.lang.String r1 = ""
            if (r0 != 0) goto L1b
        L19:
            r0 = r1
            goto L22
        L1b:
            java.lang.String r0 = r0.g()     // Catch: java.lang.Throwable -> L5b
            if (r0 != 0) goto L22
            goto L19
        L22:
            java.lang.Object r3 = r3.get(r0)     // Catch: java.lang.Throwable -> L5b
            com.jihuanshe.ui.widget.bottomtab.BottomTabItemView r3 = (com.jihuanshe.ui.widget.bottomtab.BottomTabItemView) r3     // Catch: java.lang.Throwable -> L5b
            if (r3 != 0) goto L2b
            goto L2f
        L2b:
            r0 = 0
            r3.b(r0)     // Catch: java.lang.Throwable -> L5b
        L2f:
            java.util.List<e.l.q.c.p0.c> r3 = r2.a     // Catch: java.lang.Throwable -> L5b
            int r0 = r2.f4259d     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.J2(r3, r0)     // Catch: java.lang.Throwable -> L5b
            e.l.q.c.p0.c r3 = (e.l.q.c.p0.c) r3     // Catch: java.lang.Throwable -> L5b
            r2.f4258c = r3     // Catch: java.lang.Throwable -> L5b
            java.util.HashMap<java.lang.String, com.jihuanshe.ui.widget.bottomtab.BottomTabItemView> r0 = r2.b     // Catch: java.lang.Throwable -> L5b
            if (r3 != 0) goto L40
            goto L48
        L40:
            java.lang.String r3 = r3.g()     // Catch: java.lang.Throwable -> L5b
            if (r3 != 0) goto L47
            goto L48
        L47:
            r1 = r3
        L48:
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L5b
            com.jihuanshe.ui.widget.bottomtab.BottomTabItemView r3 = (com.jihuanshe.ui.widget.bottomtab.BottomTabItemView) r3     // Catch: java.lang.Throwable -> L5b
            if (r3 != 0) goto L51
            goto L55
        L51:
            r0 = 1
            r3.b(r0)     // Catch: java.lang.Throwable -> L5b
        L55:
            h.t1 r3 = h.t1.a     // Catch: java.lang.Throwable -> L5b
            kotlin.Result.m106constructorimpl(r3)     // Catch: java.lang.Throwable -> L5b
            goto L65
        L5b:
            r3 = move-exception
            kotlin.Result$a r0 = kotlin.Result.Companion
            java.lang.Object r3 = h.r0.a(r3)
            kotlin.Result.m106constructorimpl(r3)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ui.widget.bottomtab.BottomTabLayout.onRestoreInstanceState(android.os.Parcelable):void");
    }

    @Override // android.view.View
    @e
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setCurrent(this.f4259d);
        return savedState;
    }

    public final void setOnTabSelectListener(@d a aVar) {
        this.f4260e = aVar;
    }

    public BottomTabLayout(@e Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomTabLayout(@e Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new ArrayList();
        this.b = new HashMap<>();
        this.f4259d = -1;
        setOrientation(0);
        setClipChildren(false);
    }
}
