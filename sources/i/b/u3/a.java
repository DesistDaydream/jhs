package i.b.u3;

import android.annotation.SuppressLint;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.umeng.analytics.pro.am;
import com.vivo.push.PushClientConstants;
import e.j.a.b.c.f;
import h.k2.k;
import h.k2.v.f0;
import h.r0;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import sun.misc.Signal;
import sun.misc.SignalHandler;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0013\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0014"}, d2 = {"Li/b/u3/a;", "", "", "args", "Ljava/lang/instrument/Instrumentation;", "instrumentation", "Lh/t1;", "c", "(Ljava/lang/String;Ljava/lang/instrument/Instrumentation;)V", am.av, "()V", "", "Z", "b", "()Z", f.f10128d, "(Z)V", "isInstalledStatically", "enableCreationStackTraces", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"all"})
/* loaded from: classes4.dex */
public final class a {
    private static boolean a;
    private static final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f15848c = new a();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"i/b/u3/a$a", "Ljava/lang/instrument/ClassFileTransformer;", "Ljava/lang/ClassLoader;", "loader", "", PushClientConstants.TAG_CLASS_NAME, "Ljava/lang/Class;", "classBeingRedefined", "Ljava/security/ProtectionDomain;", "protectionDomain", "", "classfileBuffer", am.av, "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/Class;Ljava/security/ProtectionDomain;[B)[B", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* renamed from: i.b.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0482a implements ClassFileTransformer {
        public static final C0482a a = new C0482a();

        private C0482a() {
        }

        @e
        public byte[] a(@d ClassLoader classLoader, @d String str, @e Class<?> cls, @d ProtectionDomain protectionDomain, @e byte[] bArr) {
            if (!f0.g(str, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            a.f15848c.d(true);
            return h.h2.a.p(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsun/misc/Signal;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", am.av, "(Lsun/misc/Signal;)V"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b implements SignalHandler {
        public static final b a = new b();

        public final void a(Signal signal) {
            DebugProbesImpl debugProbesImpl = DebugProbesImpl.f16945l;
            if (debugProbesImpl.z()) {
                debugProbesImpl.h(System.out);
            } else {
                System.out.println((Object) "Cannot perform coroutines dump, debug probes are disabled");
            }
        }
    }

    static {
        Object m106constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            m106constructorimpl = Result.m106constructorimpl(property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        Boolean bool = Result.m112isFailureimpl(m106constructorimpl) ? null : m106constructorimpl;
        b = bool != null ? bool.booleanValue() : DebugProbesImpl.f16945l.u();
    }

    private a() {
    }

    private final void a() {
        try {
            Signal.handle(new Signal("TRAP"), b.a);
        } catch (Throwable unused) {
        }
    }

    @k
    public static final void c(@e String str, @d Instrumentation instrumentation) {
        a = true;
        instrumentation.addTransformer(C0482a.a);
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.f16945l;
        debugProbesImpl.K(b);
        debugProbesImpl.x();
        f15848c.a();
    }

    public final boolean b() {
        return a;
    }

    public final void d(boolean z) {
        a = z;
    }
}
