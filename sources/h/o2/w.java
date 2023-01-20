package h.o2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import h.j1;
import h.s0;
import h.v1;
import h.x1;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", MessageKey.MSG_ACCEPT_TIME_START, "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive-s-VKNKU", "()J", "getStart-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.5")
@x1(markerClass = {h.p.class})
/* loaded from: classes3.dex */
public final class w extends u implements g<j1> {
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final a f14988f = new a(null);
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final w f14987e = new w(-1, 0);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @k.e.a.d
        public final w a() {
            return w.f14987e;
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    private w(long j2, long j3) {
        super(j2, j3, 1L, null);
    }

    @Override // h.o2.g
    public /* bridge */ /* synthetic */ boolean contains(j1 j1Var) {
        return i(j1Var.m0());
    }

    @Override // h.o2.u
    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof w) {
            if (!isEmpty() || !((w) obj).isEmpty()) {
                w wVar = (w) obj;
                if (d() != wVar.d() || f() != wVar.f()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // h.o2.g
    public /* bridge */ /* synthetic */ j1 getEndInclusive() {
        return j1.b(m());
    }

    @Override // h.o2.g
    public /* bridge */ /* synthetic */ j1 getStart() {
        return j1.b(p());
    }

    @Override // h.o2.u
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return ((int) j1.i(f() ^ j1.i(f() >>> 32))) + (((int) j1.i(d() ^ j1.i(d() >>> 32))) * 31);
    }

    public boolean i(long j2) {
        return v1.g(d(), j2) <= 0 && v1.g(j2, f()) <= 0;
    }

    @Override // h.o2.u, h.o2.g
    public boolean isEmpty() {
        return v1.g(d(), f()) > 0;
    }

    public long m() {
        return f();
    }

    public long p() {
        return d();
    }

    @Override // h.o2.u
    @k.e.a.d
    public String toString() {
        return j1.h0(d()) + ".." + j1.h0(f());
    }

    public /* synthetic */ w(long j2, long j3, h.k2.v.u uVar) {
        this(j2, j3);
    }
}
