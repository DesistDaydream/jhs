package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001b\u0010\u0006\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a6\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0080\b¢\u0006\u0004\b\r\u0010\u000e\"\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000f*\u00020\u00048@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0016\u0010\u0016\u001a\u00020\u000f8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0011\"\u001c\u0010\u001a\u001a\u00020\u00178\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", am.av, "()Lkotlinx/coroutines/CoroutineDispatcher;", "Li/b/n0;", "Lkotlin/coroutines/CoroutineContext;", "context", e.j.a.b.c.f.f10128d, "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", ExifInterface.GPS_DIRECTION_TRUE, "", "countOrElement", "Lkotlin/Function0;", ReportItem.LogTypeBlock, com.huawei.hms.push.e.a, "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lh/k2/u/a;)Ljava/lang/Object;", "", "c", "Ljava/lang/String;", "DEBUG_THREAD_NAME_SEPARATOR", "b", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "coroutineName", "COROUTINES_SCHEDULER_PROPERTY_NAME", "", "Z", "()Z", "useCoroutinesScheduler", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class i0 {
    @k.e.a.d
    public static final String a = "kotlinx.coroutines.scheduler";
    private static final boolean b;

    /* renamed from: c */
    private static final String f15741c = " @";

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0028, code lost:
        if (r0.equals(i.b.q0.f15781d) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0031, code lost:
        if (r0.equals("") != false) goto L21;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = i.b.w3.k0.d(r0)
            if (r0 != 0) goto L9
            goto L33
        L9:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L22
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L37
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            r0 = 0
            goto L34
        L22:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            goto L33
        L2b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
        L33:
            r0 = 1
        L34:
            i.b.i0.b = r0
            return
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.i0.<clinit>():void");
    }

    @k.e.a.d
    public static final CoroutineDispatcher a() {
        return b ? i.b.y3.c.f15917h : w.f15875e;
    }

    @k.e.a.e
    public static final String b(@k.e.a.d CoroutineContext coroutineContext) {
        l0 l0Var;
        if (q0.d() && (l0Var = (l0) coroutineContext.get(l0.b)) != null) {
            m0 m0Var = (m0) coroutineContext.get(m0.b);
            String str = (m0Var == null || (str = m0Var.C0()) == null) ? "coroutine" : "coroutine";
            return str + '#' + l0Var.C0();
        }
        return null;
    }

    public static final boolean c() {
        return b;
    }

    @r1
    @k.e.a.d
    public static final CoroutineContext d(@k.e.a.d n0 n0Var, @k.e.a.d CoroutineContext coroutineContext) {
        CoroutineContext plus = n0Var.getCoroutineContext().plus(coroutineContext);
        CoroutineContext plus2 = q0.d() ? plus.plus(new l0(q0.c().incrementAndGet())) : plus;
        return (plus == b1.a() || plus.get(h.e2.d.v0) != null) ? plus2 : plus2.plus(b1.a());
    }

    public static final <T> T e(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.e Object obj, @k.e.a.d h.k2.u.a<? extends T> aVar) {
        Object c2 = ThreadContextKt.c(coroutineContext, obj);
        try {
            return aVar.invoke();
        } finally {
            h.k2.v.c0.d(1);
            ThreadContextKt.a(coroutineContext, c2);
            h.k2.v.c0.c(1);
        }
    }
}
