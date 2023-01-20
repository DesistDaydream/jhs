package com.jihuanshe.ui.page.user;

import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.h.j.b.f.b;
import e.t.o.d;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class IllegalListActivity$decoration$2 extends Lambda implements a<b> {
    public static final IllegalListActivity$decoration$2 INSTANCE = new IllegalListActivity$decoration$2();

    /* renamed from: com.jihuanshe.ui.page.user.IllegalListActivity$decoration$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<b, t1> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(b bVar) {
            invoke2(bVar);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d b bVar) {
            bVar.K(d.a.c(e.t.o.d.a, null, 1, null).c(0.5f));
            bVar.w(Res.k(R.color.transparent));
        }
    }

    public IllegalListActivity$decoration$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @k.e.a.d
    public final b invoke() {
        return b.o.a(AnonymousClass1.INSTANCE);
    }
}
