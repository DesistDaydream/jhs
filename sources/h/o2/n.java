package h.o2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", MessageKey.MSG_ACCEPT_TIME_START, "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", "value", "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class n extends l implements g<Long> {
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final a f14976f = new a(null);
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final n f14975e = new n(1, 0);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/LongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @k.e.a.d
        public final n a() {
            return n.f14975e;
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public n(long j2, long j3) {
        super(j2, j3, 1L);
    }

    @Override // h.o2.g
    public /* bridge */ /* synthetic */ boolean contains(Long l2) {
        return m(l2.longValue());
    }

    @Override // h.o2.l
    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof n) {
            if (!isEmpty() || !((n) obj).isEmpty()) {
                n nVar = (n) obj;
                if (d() != nVar.d() || f() != nVar.f()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // h.o2.l
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (d() ^ (d() >>> 32))) + (f() ^ (f() >>> 32)));
    }

    @Override // h.o2.l, h.o2.g
    public boolean isEmpty() {
        return d() > f();
    }

    public boolean m(long j2) {
        return d() <= j2 && j2 <= f();
    }

    @Override // h.o2.g
    @k.e.a.d
    /* renamed from: p */
    public Long getEndInclusive() {
        return Long.valueOf(f());
    }

    @Override // h.o2.g
    @k.e.a.d
    /* renamed from: q */
    public Long getStart() {
        return Long.valueOf(d());
    }

    @Override // h.o2.l
    @k.e.a.d
    public String toString() {
        return d() + ".." + f();
    }
}
