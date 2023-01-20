package h.p2.b0.g.t.f.z;

import h.p2.b0.g.t.i.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public class b {
    public static final C0456b A;
    public static final C0456b B;
    public static final C0456b C;
    public static final C0456b D;
    public static final C0456b E;
    public static final C0456b F;
    public static final C0456b G;
    public static final C0456b H;
    public static final C0456b I;
    public static final C0456b J;
    public static final C0456b K;
    public static final C0456b L;
    public static final C0456b M;
    public static final C0456b N;
    public static final C0456b O;
    public static final C0456b a;
    public static final C0456b b;

    /* renamed from: c  reason: collision with root package name */
    public static final C0456b f15386c;

    /* renamed from: d  reason: collision with root package name */
    public static final d<ProtoBuf.Visibility> f15387d;

    /* renamed from: e  reason: collision with root package name */
    public static final d<ProtoBuf.Modality> f15388e;

    /* renamed from: f  reason: collision with root package name */
    public static final d<ProtoBuf.Class.Kind> f15389f;

    /* renamed from: g  reason: collision with root package name */
    public static final C0456b f15390g;

    /* renamed from: h  reason: collision with root package name */
    public static final C0456b f15391h;

    /* renamed from: i  reason: collision with root package name */
    public static final C0456b f15392i;

    /* renamed from: j  reason: collision with root package name */
    public static final C0456b f15393j;

    /* renamed from: k  reason: collision with root package name */
    public static final C0456b f15394k;

    /* renamed from: l  reason: collision with root package name */
    public static final C0456b f15395l;

    /* renamed from: m  reason: collision with root package name */
    public static final C0456b f15396m;
    public static final C0456b n;
    public static final d<ProtoBuf.MemberKind> o;
    public static final C0456b p;
    public static final C0456b q;
    public static final C0456b r;
    public static final C0456b s;
    public static final C0456b t;
    public static final C0456b u;
    public static final C0456b v;
    public static final C0456b w;
    public static final C0456b x;
    public static final C0456b y;
    public static final C0456b z;

    /* renamed from: h.p2.b0.g.t.f.z.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0456b extends d<Boolean> {
        public C0456b(int i2) {
            super(i2, 1);
        }

        private static /* synthetic */ void f(int i2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        @Override // h.p2.b0.g.t.f.z.b.d
        @k.e.a.d
        /* renamed from: g */
        public Boolean d(int i2) {
            Boolean valueOf = Boolean.valueOf((i2 & (1 << this.a)) != 0);
            if (valueOf == null) {
                f(0);
            }
            return valueOf;
        }

        @Override // h.p2.b0.g.t.f.z.b.d
        /* renamed from: h */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.a;
            }
            return 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class c<E extends h.a> extends d<E> {

        /* renamed from: c  reason: collision with root package name */
        private final E[] f15397c;

        public c(int i2, E[] eArr) {
            super(i2, g(eArr));
            this.f15397c = eArr;
        }

        private static /* synthetic */ void f(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        private static <E> int g(@k.e.a.d E[] eArr) {
            if (eArr == null) {
                f(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i2 = 31; i2 >= 0; i2--) {
                if (((1 << i2) & length) != 0) {
                    return i2 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // h.p2.b0.g.t.f.z.b.d
        @k.e.a.e
        /* renamed from: h */
        public E d(int i2) {
            E[] eArr;
            int i3 = this.a;
            int i4 = (i2 & (((1 << this.b) - 1) << i3)) >> i3;
            for (E e2 : this.f15397c) {
                if (e2.getNumber() == i4) {
                    return e2;
                }
            }
            return null;
        }

        @Override // h.p2.b0.g.t.f.z.b.d
        /* renamed from: i */
        public int e(E e2) {
            return e2.getNumber() << this.a;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<E> {
        public final int a;
        public final int b;

        /* JADX WARN: Incorrect types in method signature: <E::Lh/p2/b0/g/t/i/h$a;>(Lh/p2/b0/g/t/f/z/b$d<*>;[TE;)Lh/p2/b0/g/t/f/z/b$d<TE;>; */
        public static d a(d dVar, h.a[] aVarArr) {
            return new c(dVar.a + dVar.b, aVarArr);
        }

        public static C0456b b(d<?> dVar) {
            return new C0456b(dVar.a + dVar.b);
        }

        public static C0456b c() {
            return new C0456b(0);
        }

        public abstract E d(int i2);

        public abstract int e(E e2);

        private d(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }
    }

    static {
        C0456b c2 = d.c();
        a = c2;
        b = d.b(c2);
        C0456b c3 = d.c();
        f15386c = c3;
        d<ProtoBuf.Visibility> a2 = d.a(c3, ProtoBuf.Visibility.values());
        f15387d = a2;
        d<ProtoBuf.Modality> a3 = d.a(a2, ProtoBuf.Modality.values());
        f15388e = a3;
        d<ProtoBuf.Class.Kind> a4 = d.a(a3, ProtoBuf.Class.Kind.values());
        f15389f = a4;
        C0456b b2 = d.b(a4);
        f15390g = b2;
        C0456b b3 = d.b(b2);
        f15391h = b3;
        C0456b b4 = d.b(b3);
        f15392i = b4;
        C0456b b5 = d.b(b4);
        f15393j = b5;
        C0456b b6 = d.b(b5);
        f15394k = b6;
        f15395l = d.b(b6);
        C0456b b7 = d.b(a2);
        f15396m = b7;
        n = d.b(b7);
        d<ProtoBuf.MemberKind> a5 = d.a(a3, ProtoBuf.MemberKind.values());
        o = a5;
        C0456b b8 = d.b(a5);
        p = b8;
        C0456b b9 = d.b(b8);
        q = b9;
        C0456b b10 = d.b(b9);
        r = b10;
        C0456b b11 = d.b(b10);
        s = b11;
        C0456b b12 = d.b(b11);
        t = b12;
        C0456b b13 = d.b(b12);
        u = b13;
        C0456b b14 = d.b(b13);
        v = b14;
        w = d.b(b14);
        C0456b b15 = d.b(a5);
        x = b15;
        C0456b b16 = d.b(b15);
        y = b16;
        C0456b b17 = d.b(b16);
        z = b17;
        C0456b b18 = d.b(b17);
        A = b18;
        C0456b b19 = d.b(b18);
        B = b19;
        C0456b b20 = d.b(b19);
        C = b20;
        C0456b b21 = d.b(b20);
        D = b21;
        C0456b b22 = d.b(b21);
        E = b22;
        F = d.b(b22);
        C0456b b23 = d.b(c3);
        G = b23;
        C0456b b24 = d.b(b23);
        H = b24;
        I = d.b(b24);
        C0456b b25 = d.b(a3);
        J = b25;
        C0456b b26 = d.b(b25);
        K = b26;
        L = d.b(b26);
        C0456b c4 = d.c();
        M = c4;
        N = d.b(c4);
        O = d.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r5) {
        /*
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 1
            r2 = 0
            r3 = 2
            if (r5 == r1) goto L2b
            if (r5 == r3) goto L26
            r4 = 5
            if (r5 == r4) goto L2b
            r4 = 6
            if (r5 == r4) goto L21
            r4 = 8
            if (r5 == r4) goto L2b
            r4 = 9
            if (r5 == r4) goto L21
            r4 = 11
            if (r5 == r4) goto L2b
            java.lang.String r4 = "visibility"
            r0[r2] = r4
            goto L2f
        L21:
            java.lang.String r4 = "memberKind"
            r0[r2] = r4
            goto L2f
        L26:
            java.lang.String r4 = "kind"
            r0[r2] = r4
            goto L2f
        L2b:
            java.lang.String r4 = "modality"
            r0[r2] = r4
        L2f:
            java.lang.String r2 = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags"
            r0[r1] = r2
            switch(r5) {
                case 3: goto L4a;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L40;
                case 9: goto L40;
                case 10: goto L3b;
                case 11: goto L3b;
                default: goto L36;
            }
        L36:
            java.lang.String r5 = "getClassFlags"
            r0[r3] = r5
            goto L4e
        L3b:
            java.lang.String r5 = "getAccessorFlags"
            r0[r3] = r5
            goto L4e
        L40:
            java.lang.String r5 = "getPropertyFlags"
            r0[r3] = r5
            goto L4e
        L45:
            java.lang.String r5 = "getFunctionFlags"
            r0[r3] = r5
            goto L4e
        L4a:
            java.lang.String r5 = "getConstructorFlags"
            r0[r3] = r5
        L4e:
            java.lang.String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.f.z.b.a(int):void");
    }

    public static int b(boolean z2, @k.e.a.d ProtoBuf.Visibility visibility, @k.e.a.d ProtoBuf.Modality modality, boolean z3, boolean z4, boolean z5) {
        if (visibility == null) {
            a(10);
        }
        if (modality == null) {
            a(11);
        }
        return f15386c.e(Boolean.valueOf(z2)) | f15388e.e(modality) | f15387d.e(visibility) | J.e(Boolean.valueOf(z3)) | K.e(Boolean.valueOf(z4)) | L.e(Boolean.valueOf(z5));
    }
}
