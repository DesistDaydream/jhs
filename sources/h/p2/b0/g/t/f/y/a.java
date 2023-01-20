package h.p2.b0.g.t.f.y;

import h.a2.l0;
import h.k2.v.u;
import h.o2.k;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class a extends h.p2.b0.g.t.f.z.a {
    @d

    /* renamed from: g  reason: collision with root package name */
    public static final C0454a f15369g = new C0454a(null);
    @h.k2.d
    @d

    /* renamed from: h  reason: collision with root package name */
    public static final a f15370h = new a(1, 0, 7);
    @h.k2.d
    @d

    /* renamed from: i  reason: collision with root package name */
    public static final a f15371i = new a(new int[0]);

    /* renamed from: h.p2.b0.g.t.f.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0454a {
        private C0454a() {
        }

        public /* synthetic */ C0454a(u uVar) {
            this();
        }

        @d
        public final a a(@d InputStream inputStream) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            k kVar = new k(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(h.a2.u.Y(kVar, 10));
            Iterator<Integer> it = kVar.iterator();
            while (it.hasNext()) {
                ((l0) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] H5 = CollectionsKt___CollectionsKt.H5(arrayList);
            int[] iArr = new int[H5.length];
            System.arraycopy(H5, 0, iArr, 0, H5.length);
            return new a(iArr);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(@k.e.a.d int... r4) {
        /*
            r3 = this;
            int r0 = r4.length
            int[] r0 = new int[r0]
            int r1 = r4.length
            r2 = 0
            java.lang.System.arraycopy(r4, r2, r0, r2, r1)
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.f.y.a.<init>(int[]):void");
    }

    public boolean h() {
        return f(f15370h);
    }
}
