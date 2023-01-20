package i.b;

import com.umeng.analytics.pro.am;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0081\b¢\u0006\u0004\b\u0006\u0010\u0007\"\u0016\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\t\"\u0016\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\t\"\u001c\u0010\u0011\u001a\u00020\u00048\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0013\u001a\u00020\u00048\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\"\u0016\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\t\"\u001c\u0010\u001a\u001a\u00020\u00158\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u001c\u0010\u001c\u001a\u00020\u00048\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u000b\u0010\u0010\"\u0016\u0010\u001d\u001a\u00020\b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0012\u0010\t\"\u0016\u0010\u001e\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\t¨\u0006\u001f"}, d2 = {"Lh/t1;", "f", "()V", "Lkotlin/Function0;", "", "value", am.av, "(Lh/k2/u/a;)V", "", "Ljava/lang/String;", "DEBUG_PROPERTY_NAME", e.j.a.b.c.f.f10128d, "DEBUG_PROPERTY_VALUE_ON", "h", "Z", com.huawei.hms.push.e.a, "()Z", "RECOVER_STACK_TRACES", "b", "ASSERTIONS_ENABLED", "DEBUG_PROPERTY_VALUE_OFF", "Ljava/util/concurrent/atomic/AtomicLong;", "i", "Ljava/util/concurrent/atomic/AtomicLong;", "c", "()Ljava/util/concurrent/atomic/AtomicLong;", "COROUTINE_ID", "g", "DEBUG", "STACKTRACE_RECOVERY_PROPERTY_NAME", "DEBUG_PROPERTY_VALUE_AUTO", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class q0 {
    @k.e.a.d
    public static final String a = "kotlinx.coroutines.debug";
    @k.e.a.d
    public static final String b = "kotlinx.coroutines.stacktrace.recovery";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final String f15780c = "auto";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final String f15781d = "on";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final String f15782e = "off";

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f15783f = false;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f15784g;

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f15785h;
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicLong f15786i;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r0.equals(i.b.q0.f15781d) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r0.equals("") != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        r0 = true;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = i.b.w3.k0.d(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Lb
            goto L27
        Lb:
            int r3 = r0.hashCode()
            if (r3 == 0) goto L3b
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L32
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L29
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L5e
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
        L27:
            r0 = 0
            goto L44
        L29:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
            goto L27
        L32:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
            goto L43
        L3b:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
        L43:
            r0 = 1
        L44:
            i.b.q0.f15784g = r0
            if (r0 == 0) goto L51
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = i.b.w3.k0.e(r0, r1)
            if (r0 == 0) goto L51
            goto L52
        L51:
            r1 = 0
        L52:
            i.b.q0.f15785h = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            i.b.q0.f15786i = r0
            return
        L5e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
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
        throw new UnsupportedOperationException("Method not decompiled: i.b.q0.<clinit>():void");
    }

    @h.g2.f
    private static final void a(h.k2.u.a<Boolean> aVar) {
        if (b() && !aVar.invoke().booleanValue()) {
            throw new AssertionError();
        }
    }

    public static final boolean b() {
        return f15783f;
    }

    @k.e.a.d
    public static final AtomicLong c() {
        return f15786i;
    }

    public static final boolean d() {
        return f15784g;
    }

    public static final boolean e() {
        return f15785h;
    }

    public static final void f() {
        f15786i.set(0L);
    }
}
