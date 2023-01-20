package h.p2.b0.g.t.b;

import h.k2.v.u;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* loaded from: classes3.dex */
public final class c extends f {
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    public static final a f15016i = new a(null);
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    private static final c f15017j = new c(false, 1, null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k.e.a.d
        public final c a() {
            return c.f15017j;
        }
    }

    public c() {
        this(false, 1, null);
    }

    public c(boolean z) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z) {
            f(false);
        }
    }

    @k.e.a.d
    public static final c D0() {
        return f15016i.a();
    }

    public /* synthetic */ c(boolean z, int i2, u uVar) {
        this((i2 & 1) != 0 ? true : z);
    }
}
