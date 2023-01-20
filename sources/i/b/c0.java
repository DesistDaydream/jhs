package i.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B4\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJA\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012#\b\u0002\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001aR1\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001b¨\u0006\u001e"}, d2 = {"Li/b/c0;", "", am.av, "()Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lh/k0;", "name", "cause", "Lh/t1;", "b", "()Lh/k2/u/l;", "result", "onCancellation", "c", "(Ljava/lang/Object;Lh/k2/u/l;)Li/b/c0;", "", "toString", "()Ljava/lang/String;", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "Lh/k2/u/l;", "<init>", "(Ljava/lang/Object;Lh/k2/u/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class c0 {
    @h.k2.d
    @k.e.a.e
    public final Object a;
    @h.k2.d
    @k.e.a.d
    public final h.k2.u.l<Throwable, h.t1> b;

    /* JADX WARN: Multi-variable type inference failed */
    public c0(@k.e.a.e Object obj, @k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar) {
        this.a = obj;
        this.b = lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c0 d(c0 c0Var, Object obj, h.k2.u.l lVar, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = c0Var.a;
        }
        if ((i2 & 2) != 0) {
            lVar = c0Var.b;
        }
        return c0Var.c(obj, lVar);
    }

    @k.e.a.e
    public final Object a() {
        return this.a;
    }

    @k.e.a.d
    public final h.k2.u.l<Throwable, h.t1> b() {
        return this.b;
    }

    @k.e.a.d
    public final c0 c(@k.e.a.e Object obj, @k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar) {
        return new c0(obj, lVar);
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            if (obj instanceof c0) {
                c0 c0Var = (c0) obj;
                return h.k2.v.f0.g(this.a, c0Var.a) && h.k2.v.f0.g(this.b, c0Var.b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        h.k2.u.l<Throwable, h.t1> lVar = this.b;
        return hashCode + (lVar != null ? lVar.hashCode() : 0);
    }

    @k.e.a.d
    public String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.b + ")";
    }
}
