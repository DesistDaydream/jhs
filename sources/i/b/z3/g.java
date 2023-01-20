package i.b.z3;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.k2.u.l;
import h.k2.v.c0;
import h.t1;
import h.u2.j;
import i.b.r1;
import i.b.w0;
import i.b.w3.i0;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u001aK\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aG\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\b\u000bH\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\r\u0010\u000e\"\u001c\u0010\u0014\u001a\u00020\u000f8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0012\u0010\u0013\"\"\u0010\u001a\u001a\u00020\u00068\u0000@\u0001X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018\"\u001c\u0010\u001c\u001a\u00020\u00068\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0016\u0012\u0004\b\u001b\u0010\u0013\"\u001c\u0010\u001f\u001a\u00020\u00068\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u0012\u0004\b\u001e\u0010\u0013\"\"\u0010#\u001a\u00020\u00068\u0000@\u0001X\u0081\u0004¢\u0006\u0012\n\u0004\b \u0010\u0016\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b!\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"R", "Li/b/z3/a;", "Lh/u2/d;", "timeout", "Lkotlin/Function1;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, "Lh/t1;", "k", "(Li/b/z3/a;DLh/k2/u/l;)V", "Lh/q;", "builder", NotifyType.LIGHTS, "(Lh/k2/u/l;Lh/e2/c;)Ljava/lang/Object;", "Li/b/z3/i;", com.huawei.hms.push.e.a, "Li/b/z3/i;", "getSelectOpSequenceNumber$annotations", "()V", "selectOpSequenceNumber", "b", "Ljava/lang/Object;", e.j.a.b.c.f.f10128d, "()Ljava/lang/Object;", "getALREADY_SELECTED$annotations", "ALREADY_SELECTED", "getRESUMED$annotations", "RESUMED", "c", "getUNDECIDED$annotations", "UNDECIDED", am.av, "f", "getNOT_SELECTED$annotations", "NOT_SELECTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class g {
    @k.e.a.d
    private static final Object a = new i0("NOT_SELECTED");
    @k.e.a.d
    private static final Object b = new i0("ALREADY_SELECTED");

    /* renamed from: c  reason: collision with root package name */
    private static final Object f15956c = new i0("UNDECIDED");

    /* renamed from: d  reason: collision with root package name */
    private static final Object f15957d = new i0("RESUMED");

    /* renamed from: e  reason: collision with root package name */
    private static final i f15958e = new i();

    @k.e.a.d
    public static final Object d() {
        return b;
    }

    public static /* synthetic */ void e() {
    }

    @k.e.a.d
    public static final Object f() {
        return a;
    }

    public static /* synthetic */ void g() {
    }

    private static /* synthetic */ void h() {
    }

    private static /* synthetic */ void i() {
    }

    private static /* synthetic */ void j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @j
    @r1
    public static final <R> void k(@k.e.a.d a<? super R> aVar, double d2, @k.e.a.d l<? super h.e2.c<? super R>, ? extends Object> lVar) {
        aVar.h(w0.e(d2), lVar);
    }

    @k.e.a.e
    public static final <R> Object l(@k.e.a.d l<? super a<? super R>, t1> lVar, @k.e.a.d h.e2.c<? super R> cVar) {
        b bVar = new b(cVar);
        try {
            lVar.invoke(bVar);
        } catch (Throwable th) {
            bVar.r0(th);
        }
        Object q0 = bVar.q0();
        if (q0 == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return q0;
    }

    @k.e.a.e
    private static final Object m(@k.e.a.d l lVar, @k.e.a.d h.e2.c cVar) {
        c0.e(0);
        b bVar = new b(cVar);
        try {
            lVar.invoke(bVar);
        } catch (Throwable th) {
            bVar.r0(th);
        }
        Object q0 = bVar.q0();
        if (q0 == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        c0.e(1);
        return q0;
    }
}
