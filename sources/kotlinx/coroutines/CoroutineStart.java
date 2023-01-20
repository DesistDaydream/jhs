package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import h.e2.c;
import h.e2.e;
import h.k2.u.l;
import h.k2.u.p;
import i.b.p0;
import i.b.x1;
import i.b.x3.a;
import i.b.x3.b;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ^\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u00022'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, "completion", "Lh/t1;", "invoke", "(Lh/k2/u/l;Lh/e2/c;)V", "R", "Lkotlin/Function2;", "Lh/q;", "receiver", "(Lh/k2/u/p;Ljava/lang/Object;Lh/e2/c;)V", "", "isLazy", "()Z", "isLazy$annotations", "()V", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @x1
    public static /* synthetic */ void isLazy$annotations() {
    }

    @x1
    public final <T> void invoke(@d l<? super c<? super T>, ? extends Object> lVar, @d c<? super T> cVar) {
        int i2 = p0.a[ordinal()];
        if (i2 == 1) {
            a.c(lVar, cVar);
        } else if (i2 == 2) {
            e.h(lVar, cVar);
        } else if (i2 == 3) {
            b.a(lVar, cVar);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    @x1
    public final <R, T> void invoke(@d p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, @d c<? super T> cVar) {
        int i2 = p0.b[ordinal()];
        if (i2 == 1) {
            a.e(pVar, r, cVar, null, 4, null);
        } else if (i2 == 2) {
            e.i(pVar, r, cVar);
        } else if (i2 == 3) {
            b.b(pVar, r, cVar);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
