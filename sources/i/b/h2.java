package i.b;

import i.b.b2;
import java.util.Objects;
import kotlin.Metadata;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00028\u00008\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Li/b/h2;", "Li/b/b2;", "J", "Li/b/d0;", "Li/b/e1;", "Li/b/v1;", "Lh/t1;", "dispose", "()V", "", "j", "()Z", "isActive", e.j.a.b.c.f.f10128d, "Li/b/b2;", "job", "Li/b/m2;", "c", "()Li/b/m2;", "list", "<init>", "(Li/b/b2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class h2<J extends b2> extends d0 implements e1, v1 {
    @h.k2.d
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public final J f15739d;

    public h2(@k.e.a.d J j2) {
        this.f15739d = j2;
    }

    @Override // i.b.v1
    @k.e.a.e
    public m2 c() {
        return null;
    }

    @Override // i.b.e1
    public void dispose() {
        J j2 = this.f15739d;
        Objects.requireNonNull(j2, "null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        ((JobSupport) j2).Y0(this);
    }

    @Override // i.b.v1
    public boolean j() {
        return true;
    }
}
