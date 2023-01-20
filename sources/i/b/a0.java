package i.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\\\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b.\u0010/J!\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0013\u0010\nJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015Jg\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R3\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010'R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010(R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010)R\u0013\u0010,\u001a\u00020$8F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010)R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010-¨\u00060"}, d2 = {"Li/b/a0;", "", "Li/b/o;", "cont", "", "cause", "Lh/t1;", "i", "(Li/b/o;Ljava/lang/Throwable;)V", am.av, "()Ljava/lang/Object;", "Li/b/l;", "b", "()Li/b/l;", "Lkotlin/Function1;", "Lh/k0;", "name", "c", "()Lh/k2/u/l;", e.j.a.b.c.f.f10128d, com.huawei.hms.push.e.a, "()Ljava/lang/Throwable;", "result", "cancelHandler", "onCancellation", "idempotentResume", "cancelCause", "f", "(Ljava/lang/Object;Li/b/l;Lh/k2/u/l;Ljava/lang/Object;Ljava/lang/Throwable;)Li/b/a0;", "", "toString", "()Ljava/lang/String;", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lh/k2/u/l;", "Ljava/lang/Throwable;", "Ljava/lang/Object;", "h", "()Z", "cancelled", "Li/b/l;", "<init>", "(Ljava/lang/Object;Li/b/l;Lh/k2/u/l;Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class a0 {
    @h.k2.d
    @k.e.a.e
    public final Object a;
    @h.k2.d
    @k.e.a.e
    public final l b;
    @h.k2.d
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    public final h.k2.u.l<Throwable, h.t1> f15714c;
    @h.k2.d
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    public final Object f15715d;
    @h.k2.d
    @k.e.a.e

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f15716e;

    /* JADX WARN: Multi-variable type inference failed */
    public a0(@k.e.a.e Object obj, @k.e.a.e l lVar, @k.e.a.e h.k2.u.l<? super Throwable, h.t1> lVar2, @k.e.a.e Object obj2, @k.e.a.e Throwable th) {
        this.a = obj;
        this.b = lVar;
        this.f15714c = lVar2;
        this.f15715d = obj2;
        this.f15716e = th;
    }

    public static /* synthetic */ a0 g(a0 a0Var, Object obj, l lVar, h.k2.u.l lVar2, Object obj2, Throwable th, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = a0Var.a;
        }
        if ((i2 & 2) != 0) {
            lVar = a0Var.b;
        }
        l lVar3 = lVar;
        h.k2.u.l<Throwable, h.t1> lVar4 = lVar2;
        if ((i2 & 4) != 0) {
            lVar4 = a0Var.f15714c;
        }
        h.k2.u.l lVar5 = lVar4;
        if ((i2 & 8) != 0) {
            obj2 = a0Var.f15715d;
        }
        Object obj4 = obj2;
        if ((i2 & 16) != 0) {
            th = a0Var.f15716e;
        }
        return a0Var.f(obj, lVar3, lVar5, obj4, th);
    }

    @k.e.a.e
    public final Object a() {
        return this.a;
    }

    @k.e.a.e
    public final l b() {
        return this.b;
    }

    @k.e.a.e
    public final h.k2.u.l<Throwable, h.t1> c() {
        return this.f15714c;
    }

    @k.e.a.e
    public final Object d() {
        return this.f15715d;
    }

    @k.e.a.e
    public final Throwable e() {
        return this.f15716e;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            if (obj instanceof a0) {
                a0 a0Var = (a0) obj;
                return h.k2.v.f0.g(this.a, a0Var.a) && h.k2.v.f0.g(this.b, a0Var.b) && h.k2.v.f0.g(this.f15714c, a0Var.f15714c) && h.k2.v.f0.g(this.f15715d, a0Var.f15715d) && h.k2.v.f0.g(this.f15716e, a0Var.f15716e);
            }
            return false;
        }
        return true;
    }

    @k.e.a.d
    public final a0 f(@k.e.a.e Object obj, @k.e.a.e l lVar, @k.e.a.e h.k2.u.l<? super Throwable, h.t1> lVar2, @k.e.a.e Object obj2, @k.e.a.e Throwable th) {
        return new a0(obj, lVar, lVar2, obj2, th);
    }

    public final boolean h() {
        return this.f15716e != null;
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        l lVar = this.b;
        int hashCode2 = (hashCode + (lVar != null ? lVar.hashCode() : 0)) * 31;
        h.k2.u.l<Throwable, h.t1> lVar2 = this.f15714c;
        int hashCode3 = (hashCode2 + (lVar2 != null ? lVar2.hashCode() : 0)) * 31;
        Object obj2 = this.f15715d;
        int hashCode4 = (hashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.f15716e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final void i(@k.e.a.d o<?> oVar, @k.e.a.d Throwable th) {
        l lVar = this.b;
        if (lVar != null) {
            oVar.n(lVar, th);
        }
        h.k2.u.l<Throwable, h.t1> lVar2 = this.f15714c;
        if (lVar2 != null) {
            oVar.q(lVar2, th);
        }
    }

    @k.e.a.d
    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.f15714c + ", idempotentResume=" + this.f15715d + ", cancelCause=" + this.f15716e + ")";
    }

    public /* synthetic */ a0(Object obj, l lVar, h.k2.u.l lVar2, Object obj2, Throwable th, int i2, h.k2.v.u uVar) {
        this(obj, (i2 & 2) != 0 ? null : lVar, (i2 & 4) != 0 ? null : lVar2, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? null : th);
    }
}
