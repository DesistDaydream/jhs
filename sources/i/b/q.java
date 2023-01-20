package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0080Hø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000f\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0013\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Li/b/n;", "Lh/t1;", ReportItem.LogTypeBlock, e.j.a.b.c.f.f10128d, "(Lh/k2/u/l;Lh/e2/c;)Ljava/lang/Object;", "f", "Lh/e2/c;", "delegate", "Li/b/o;", "b", "(Lh/e2/c;)Li/b/o;", "Li/b/w3/s;", "node", "c", "(Li/b/n;Li/b/w3/s;)V", "Li/b/e1;", "handle", am.av, "(Li/b/n;Li/b/e1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class q {
    @x1
    public static final void a(@k.e.a.d n<?> nVar, @k.e.a.d e1 e1Var) {
        nVar.p(new f1(e1Var));
    }

    @k.e.a.d
    public static final <T> o<T> b(@k.e.a.d h.e2.c<? super T> cVar) {
        if (!(cVar instanceof i.b.w3.j)) {
            return new o<>(cVar, 2);
        }
        o<T> k2 = ((i.b.w3.j) cVar).k();
        if (k2 != null) {
            if (!k2.L()) {
                k2 = null;
            }
            if (k2 != null) {
                return k2;
            }
        }
        return new o<>(cVar, 2);
    }

    public static final void c(@k.e.a.d n<?> nVar, @k.e.a.d i.b.w3.s sVar) {
        nVar.p(new t2(sVar));
    }

    @k.e.a.e
    public static final <T> Object d(@k.e.a.d h.k2.u.l<? super n<? super T>, h.t1> lVar, @k.e.a.d h.e2.c<? super T> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        lVar.invoke(oVar);
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    @k.e.a.e
    private static final Object e(@k.e.a.d h.k2.u.l lVar, @k.e.a.d h.e2.c cVar) {
        h.k2.v.c0.e(0);
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        lVar.invoke(oVar);
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        h.k2.v.c0.e(1);
        return B;
    }

    @k.e.a.e
    public static final <T> Object f(@k.e.a.d h.k2.u.l<? super n<? super T>, h.t1> lVar, @k.e.a.d h.e2.c<? super T> cVar) {
        o b = b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        lVar.invoke(b);
        Object B = b.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    @k.e.a.e
    private static final Object g(@k.e.a.d h.k2.u.l lVar, @k.e.a.d h.e2.c cVar) {
        h.k2.v.c0.e(0);
        o b = b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        lVar.invoke(b);
        Object B = b.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        h.k2.v.c0.e(1);
        return B;
    }
}
