package i.b.a4;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.l;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f¨\u0006\u0013"}, d2 = {"Li/b/a4/a;", "Li/b/l;", "", "cause", "Lh/t1;", am.av, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "", "b", ExpandableTextView.P, "index", "Li/b/a4/e;", "Li/b/a4/e;", "segment", "<init>", "(Li/b/a4/e;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class a extends l {
    private final e a;
    private final int b;

    public a(@k.e.a.d e eVar, int i2) {
        this.a = eVar;
        this.b = i2;
    }

    @Override // i.b.m
    public void a(@k.e.a.e Throwable th) {
        this.a.s(this.b);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
        a(th);
        return t1.a;
    }

    @k.e.a.d
    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.a + ", " + this.b + ']';
    }
}
