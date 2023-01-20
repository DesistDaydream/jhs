package h.o2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.v.f0;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", MessageKey.MSG_ACCEPT_TIME_START, "endInclusive", "(CC)V", "getEndInclusive", "()Ljava/lang/Character;", "getStart", "contains", "", "value", "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class c extends h.o2.a implements g<Character> {
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final a f14964f = new a(null);
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final c f14963e = new c((char) 1, (char) 0);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/CharRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/CharRange;", "getEMPTY", "()Lkotlin/ranges/CharRange;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @k.e.a.d
        public final c a() {
            return c.f14963e;
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public c(char c2, char c3) {
        super(c2, c3, 1);
    }

    @Override // h.o2.g
    public /* bridge */ /* synthetic */ boolean contains(Character ch) {
        return m(ch.charValue());
    }

    @Override // h.o2.a
    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (d() != cVar.d() || f() != cVar.f()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // h.o2.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (d() * 31) + f();
    }

    @Override // h.o2.a, h.o2.g
    public boolean isEmpty() {
        return f0.t(d(), f()) > 0;
    }

    public boolean m(char c2) {
        return f0.t(d(), c2) <= 0 && f0.t(c2, f()) <= 0;
    }

    @Override // h.o2.g
    @k.e.a.d
    /* renamed from: p */
    public Character getEndInclusive() {
        return Character.valueOf(f());
    }

    @Override // h.o2.g
    @k.e.a.d
    /* renamed from: q */
    public Character getStart() {
        return Character.valueOf(d());
    }

    @Override // h.o2.a
    @k.e.a.d
    public String toString() {
        return d() + ".." + f();
    }
}
