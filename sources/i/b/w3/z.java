package i.b.w3;

import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.e1;
import i.b.l2;
import i.b.v0;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010#\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00018V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Li/b/w3/z;", "Li/b/l2;", "Li/b/v0;", "", "C0", "()Ljava/lang/Void;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isDispatchNeeded", "(Lkotlin/coroutines/CoroutineContext;)Z", "", "time", "m0", "(JLh/e2/c;)Ljava/lang/Object;", "timeMillis", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ReportItem.LogTypeBlock, "Li/b/e1;", am.aI, "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Li/b/e1;", "B0", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)Ljava/lang/Void;", "Li/b/n;", "Lh/t1;", "continuation", "D0", "(JLi/b/n;)Ljava/lang/Void;", "", "toString", "()Ljava/lang/String;", "", am.av, "Ljava/lang/Throwable;", "cause", "b", "Ljava/lang/String;", "errorHint", "z0", "()Li/b/l2;", "immediate", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class z extends l2 implements v0 {
    private final Throwable a;
    private final String b;

    public /* synthetic */ z(Throwable th, String str, int i2, h.k2.v.u uVar) {
        this(th, (i2 & 2) != 0 ? null : str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r1 != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Void C0() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.a
            if (r0 == 0) goto L37
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.b
            if (r1 == 0) goto L26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L26
            goto L28
        L26:
            java.lang.String r1 = ""
        L28:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.a
            r1.<init>(r0, r2)
            throw r1
        L37:
            i.b.w3.y.e()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.w3.z.C0():java.lang.Void");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @k.e.a.d
    /* renamed from: B0 */
    public Void dispatch(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Runnable runnable) {
        C0();
        throw new KotlinNothingValueException();
    }

    @Override // i.b.v0
    @k.e.a.d
    /* renamed from: D0 */
    public Void c(long j2, @k.e.a.d i.b.n<? super t1> nVar) {
        C0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@k.e.a.d CoroutineContext coroutineContext) {
        C0();
        throw new KotlinNothingValueException();
    }

    @Override // i.b.v0
    @k.e.a.e
    public Object m0(long j2, @k.e.a.d h.e2.c<?> cVar) {
        C0();
        throw new KotlinNothingValueException();
    }

    @Override // i.b.v0
    @k.e.a.d
    public e1 t(long j2, @k.e.a.d Runnable runnable, @k.e.a.d CoroutineContext coroutineContext) {
        C0();
        throw new KotlinNothingValueException();
    }

    @Override // i.b.l2, kotlinx.coroutines.CoroutineDispatcher
    @k.e.a.d
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.a != null) {
            str = ", cause=" + this.a;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    @Override // i.b.l2
    @k.e.a.d
    public l2 z0() {
        return this;
    }

    public z(@k.e.a.e Throwable th, @k.e.a.e String str) {
        this.a = th;
        this.b = str;
    }
}
