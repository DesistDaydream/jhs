package i.b.x3;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.k2.u.l;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.w3.k;
import i.b.x1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a{\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a%\u0010\u0013\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0017\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0082\b¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lh/e2/c;", "", "completion", "Lh/t1;", "c", "(Lh/k2/u/l;Lh/e2/c;)V", "R", "Lkotlin/Function2;", "receiver", "", "Lh/k0;", "name", "cause", "onCancellation", f.f10128d, "(Lh/k2/u/p;Ljava/lang/Object;Lh/e2/c;Lh/k2/u/l;)V", "fatalCompletion", "b", "(Lh/e2/c;Lh/e2/c;)V", "Lkotlin/Function0;", ReportItem.LogTypeBlock, am.av, "(Lh/e2/c;Lh/k2/u/a;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class a {
    private static final void a(c<?> cVar, h.k2.u.a<t1> aVar) {
        try {
            aVar.invoke();
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            cVar.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }
    }

    public static final void b(@d c<? super t1> cVar, @d c<?> cVar2) {
        try {
            c d2 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
            Result.a aVar = Result.Companion;
            k.g(d2, Result.m106constructorimpl(t1.a), null, 2, null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            cVar2.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }
    }

    @x1
    public static final <T> void c(@d l<? super c<? super T>, ? extends Object> lVar, @d c<? super T> cVar) {
        try {
            c d2 = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.b(lVar, cVar));
            Result.a aVar = Result.Companion;
            k.g(d2, Result.m106constructorimpl(t1.a), null, 2, null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            cVar.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }
    }

    public static final <R, T> void d(@d p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, @d c<? super T> cVar, @e l<? super Throwable, t1> lVar) {
        try {
            c d2 = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.c(pVar, r, cVar));
            Result.a aVar = Result.Companion;
            k.f(d2, Result.m106constructorimpl(t1.a), lVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            cVar.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }
    }

    public static /* synthetic */ void e(p pVar, Object obj, c cVar, l lVar, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            lVar = null;
        }
        d(pVar, obj, cVar, lVar);
    }
}
