package kotlin.reflect.jvm.internal.impl.util;

import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.o.b;
import h.p2.b0.g.t.o.c;
import java.util.Collection;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

/* loaded from: classes3.dex */
public final class Checks {
    @e
    private final f a;
    @e
    private final Regex b;
    @e

    /* renamed from: c  reason: collision with root package name */
    private final Collection<f> f16877c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final l<v, String> f16878d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final b[] f16879e;

    /* renamed from: kotlin.reflect.jvm.internal.impl.util.Checks$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends Lambda implements l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // h.k2.u.l
        @e
        public final Void invoke(@d v vVar) {
            return null;
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.util.Checks$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends Lambda implements l {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // h.k2.u.l
        @e
        public final Void invoke(@d v vVar) {
            return null;
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.util.Checks$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass4 extends Lambda implements l {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // h.k2.u.l
        @e
        public final Void invoke(@d v vVar) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Checks(f fVar, Regex regex, Collection<f> collection, l<? super v, String> lVar, b... bVarArr) {
        this.a = fVar;
        this.b = regex;
        this.f16877c = collection;
        this.f16878d = lVar;
        this.f16879e = bVarArr;
    }

    @d
    public final c a(@d v vVar) {
        b[] bVarArr = this.f16879e;
        int length = bVarArr.length;
        int i2 = 0;
        while (i2 < length) {
            b bVar = bVarArr[i2];
            i2++;
            String a = bVar.a(vVar);
            if (a != null) {
                return new c.b(a);
            }
        }
        String invoke = this.f16878d.invoke(vVar);
        if (invoke != null) {
            return new c.b(invoke);
        }
        return c.C0471c.b;
    }

    public final boolean b(@d v vVar) {
        if (this.a == null || f0.g(vVar.getName(), this.a)) {
            if (this.b != null) {
                if (!this.b.matches(vVar.getName().b())) {
                    return false;
                }
            }
            Collection<f> collection = this.f16877c;
            return collection == null || collection.contains(vVar.getName());
        }
        return false;
    }

    public /* synthetic */ Checks(f fVar, b[] bVarArr, l lVar, int i2, u uVar) {
        this(fVar, bVarArr, (i2 & 4) != 0 ? AnonymousClass2.INSTANCE : lVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Checks(@k.e.a.d h.p2.b0.g.t.g.f r8, @k.e.a.d h.p2.b0.g.t.o.b[] r9, @k.e.a.d h.k2.u.l<? super h.p2.b0.g.t.c.v, java.lang.String> r10) {
        /*
            r7 = this;
            int r0 = r9.length
            h.p2.b0.g.t.o.b[] r6 = new h.p2.b0.g.t.o.b[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r3 = 0
            r4 = 0
            r1 = r7
            r2 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.Checks.<init>(h.p2.b0.g.t.g.f, h.p2.b0.g.t.o.b[], h.k2.u.l):void");
    }

    public /* synthetic */ Checks(Regex regex, b[] bVarArr, l lVar, int i2, u uVar) {
        this(regex, bVarArr, (i2 & 4) != 0 ? AnonymousClass3.INSTANCE : lVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Checks(@k.e.a.d kotlin.text.Regex r8, @k.e.a.d h.p2.b0.g.t.o.b[] r9, @k.e.a.d h.k2.u.l<? super h.p2.b0.g.t.c.v, java.lang.String> r10) {
        /*
            r7 = this;
            int r0 = r9.length
            h.p2.b0.g.t.o.b[] r6 = new h.p2.b0.g.t.o.b[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r2 = 0
            r4 = 0
            r1 = r7
            r3 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.Checks.<init>(kotlin.text.Regex, h.p2.b0.g.t.o.b[], h.k2.u.l):void");
    }

    public /* synthetic */ Checks(Collection collection, b[] bVarArr, l lVar, int i2, u uVar) {
        this(collection, bVarArr, (i2 & 4) != 0 ? AnonymousClass4.INSTANCE : lVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Checks(@k.e.a.d java.util.Collection<h.p2.b0.g.t.g.f> r8, @k.e.a.d h.p2.b0.g.t.o.b[] r9, @k.e.a.d h.k2.u.l<? super h.p2.b0.g.t.c.v, java.lang.String> r10) {
        /*
            r7 = this;
            int r0 = r9.length
            h.p2.b0.g.t.o.b[] r6 = new h.p2.b0.g.t.o.b[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r2 = 0
            r3 = 0
            r1 = r7
            r4 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.Checks.<init>(java.util.Collection, h.p2.b0.g.t.o.b[], h.k2.u.l):void");
    }
}
