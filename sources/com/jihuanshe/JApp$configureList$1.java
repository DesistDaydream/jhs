package com.jihuanshe;

import android.content.Context;
import com.jihuanshe.ui.widget.LoadMoreView;
import e.t.i.b;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class JApp$configureList$1 extends Lambda implements l<b, t1> {
    public static final JApp$configureList$1 INSTANCE = new JApp$configureList$1();

    /* renamed from: com.jihuanshe.JApp$configureList$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Context, LoadMoreView> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        @d
        public final LoadMoreView invoke(@d Context context) {
            return new LoadMoreView(context);
        }
    }

    public JApp$configureList$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(b bVar) {
        invoke2(bVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d b bVar) {
        bVar.m(20);
        bVar.h(AnonymousClass1.INSTANCE);
    }
}
