package i.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b¨\u0006\u000f"}, d2 = {"Li/b/t2;", "Li/b/d;", "", "cause", "Lh/t1;", am.av, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Li/b/w3/s;", "Li/b/w3/s;", "node", "<init>", "(Li/b/w3/s;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class t2 extends d {
    private final i.b.w3.s a;

    public t2(@k.e.a.d i.b.w3.s sVar) {
        this.a = sVar;
    }

    @Override // i.b.m
    public void a(@k.e.a.e Throwable th) {
        this.a.c0();
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        a(th);
        return h.t1.a;
    }

    @k.e.a.d
    public String toString() {
        return "RemoveOnCancel[" + this.a + ']';
    }
}
