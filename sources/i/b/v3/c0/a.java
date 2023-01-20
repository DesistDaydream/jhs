package i.b.v3.c0;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.v3.c0.c;
import i.b.v3.x;
import i.b.v3.y;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b+\u0010\u001fJ\u000f\u0010\u0005\u001a\u00028\u0000H$¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t2\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0011H\u0084\b¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R>\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t2\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t8\u0004@BX\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010)\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00078\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010&¨\u0006,"}, d2 = {"Li/b/v3/c0/a;", "Li/b/v3/c0/c;", ExifInterface.LATITUDE_SOUTH, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "m", "()Li/b/v3/c0/c;", "", "size", "", "n", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", NotifyType.LIGHTS, "slot", "Lh/t1;", am.ax, "(Li/b/v3/c0/c;)V", "Lkotlin/Function1;", ReportItem.LogTypeBlock, "o", "(Lh/k2/u/l;)V", "Li/b/v3/x;", "c", "()Li/b/v3/x;", "subscriptionCount", "<set-?>", am.av, "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "r", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "getSlots$annotations", "()V", "slots", "Li/b/v3/l;", e.j.a.b.c.f.f10128d, "Li/b/v3/l;", "_subscriptionCount", "b", ExpandableTextView.P, "q", "()I", "nCollectors", "nextIndex", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class a<S extends c<?>> {
    @k.e.a.e
    private S[] a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f15863c;

    /* renamed from: d  reason: collision with root package name */
    private i.b.v3.l<Integer> f15864d;

    public static /* synthetic */ void s() {
    }

    @k.e.a.d
    public final x<Integer> c() {
        i.b.v3.l<Integer> lVar;
        synchronized (this) {
            lVar = this.f15864d;
            if (lVar == null) {
                lVar = y.a(Integer.valueOf(this.b));
                this.f15864d = lVar;
            }
        }
        return lVar;
    }

    @k.e.a.d
    public final S l() {
        S s;
        i.b.v3.l<Integer> lVar;
        synchronized (this) {
            S[] sArr = this.a;
            if (sArr == null) {
                sArr = n(2);
                this.a = sArr;
            } else if (this.b >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                this.a = (S[]) ((c[]) copyOf);
                sArr = (S[]) ((c[]) copyOf);
            }
            int i2 = this.f15863c;
            do {
                s = sArr[i2];
                if (s == null) {
                    s = m();
                    sArr[i2] = s;
                }
                i2++;
                if (i2 >= sArr.length) {
                    i2 = 0;
                }
                if (s == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                }
            } while (!s.a(this));
            this.f15863c = i2;
            this.b++;
            lVar = this.f15864d;
        }
        if (lVar != null) {
            y.g(lVar, 1);
        }
        return s;
    }

    @k.e.a.d
    public abstract S m();

    @k.e.a.d
    public abstract S[] n(int i2);

    public final void o(@k.e.a.d h.k2.u.l<? super S, t1> lVar) {
        c[] cVarArr;
        if (this.b == 0 || (cVarArr = this.a) == null) {
            return;
        }
        for (c cVar : cVarArr) {
            if (cVar != null) {
                lVar.invoke(cVar);
            }
        }
    }

    public final void p(@k.e.a.d S s) {
        i.b.v3.l<Integer> lVar;
        int i2;
        h.e2.c<t1>[] b;
        synchronized (this) {
            int i3 = this.b - 1;
            this.b = i3;
            lVar = this.f15864d;
            if (i3 == 0) {
                this.f15863c = 0;
            }
            if (s != null) {
                b = s.b(this);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            }
        }
        for (h.e2.c<t1> cVar : b) {
            if (cVar != null) {
                t1 t1Var = t1.a;
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m106constructorimpl(t1Var));
            }
        }
        if (lVar != null) {
            y.g(lVar, -1);
        }
    }

    public final int q() {
        return this.b;
    }

    @k.e.a.e
    public final S[] r() {
        return this.a;
    }
}
