package kotlinx.coroutines.selects;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.e;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.k2.u.l;
import h.k2.u.p;
import h.p0;
import h.t1;
import i.b.z3.a;
import i.b.z3.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import k.e.a.d;
import kotlin.Metadata;

@p0
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\u0004\u0010\tJ5\u0010\u000e\u001a\u00020\u0005*\u00020\n2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000bH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00010\u00112\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0012H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J[\u0010\u0018\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0010*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00012\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0012H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J8\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR5\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001f` 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000&8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010'\u001a\u0004\b!\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Li/b/z3/a;", "", e.a, "Lh/t1;", "c", "(Ljava/lang/Throwable;)V", "", "()Ljava/lang/Object;", "Li/b/z3/c;", "Lkotlin/Function1;", "Lh/e2/c;", ReportItem.LogTypeBlock, f.f10128d, "(Li/b/z3/c;Lh/k2/u/l;)V", "Q", "Li/b/z3/d;", "Lkotlin/Function2;", "B", "(Li/b/z3/d;Lh/k2/u/p;)V", "P", "Li/b/z3/e;", RemoteMessageConst.MessageBody.PARAM, "f", "(Li/b/z3/e;Ljava/lang/Object;Lh/k2/u/p;)V", "", "timeMillis", "h", "(JLh/k2/u/l;)V", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", am.av, "()Ljava/util/ArrayList;", "clauses", "Li/b/z3/b;", "Li/b/z3/b;", "()Li/b/z3/b;", "instance", "uCont", "<init>", "(Lh/e2/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class UnbiasedSelectBuilderImpl<R> implements a<R> {
    @d
    private final b<R> a;
    @d
    private final ArrayList<h.k2.u.a<t1>> b = new ArrayList<>();

    public UnbiasedSelectBuilderImpl(@d c<? super R> cVar) {
        this.a = new b<>(cVar);
    }

    @Override // i.b.z3.a
    public <Q> void B(@d i.b.z3.d<? extends Q> dVar, @d p<? super Q, ? super c<? super R>, ? extends Object> pVar) {
        this.b.add(new UnbiasedSelectBuilderImpl$invoke$2(this, dVar, pVar));
    }

    @d
    public final ArrayList<h.k2.u.a<t1>> a() {
        return this.b;
    }

    @d
    public final b<R> b() {
        return this.a;
    }

    @p0
    public final void c(@d Throwable th) {
        this.a.r0(th);
    }

    @Override // i.b.z3.a
    public void d(@d i.b.z3.c cVar, @d l<? super c<? super R>, ? extends Object> lVar) {
        this.b.add(new UnbiasedSelectBuilderImpl$invoke$1(this, cVar, lVar));
    }

    @p0
    @k.e.a.e
    public final Object e() {
        if (!this.a.b()) {
            try {
                Collections.shuffle(this.b);
                Iterator<T> it = this.b.iterator();
                while (it.hasNext()) {
                    ((h.k2.u.a) it.next()).invoke();
                }
            } catch (Throwable th) {
                this.a.r0(th);
            }
        }
        return this.a.q0();
    }

    @Override // i.b.z3.a
    public <P, Q> void f(@d i.b.z3.e<? super P, ? extends Q> eVar, P p, @d p<? super Q, ? super c<? super R>, ? extends Object> pVar) {
        this.b.add(new UnbiasedSelectBuilderImpl$invoke$3(this, eVar, p, pVar));
    }

    @Override // i.b.z3.a
    public void h(long j2, @d l<? super c<? super R>, ? extends Object> lVar) {
        this.b.add(new UnbiasedSelectBuilderImpl$onTimeout$1(this, j2, lVar));
    }

    @Override // i.b.z3.a
    public <P, Q> void q(@d i.b.z3.e<? super P, ? extends Q> eVar, @d p<? super Q, ? super c<? super R>, ? extends Object> pVar) {
        a.C0484a.a(this, eVar, pVar);
    }
}
