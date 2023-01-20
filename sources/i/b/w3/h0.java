package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import h.z0;
import i.b.x1;
import java.util.ArrayDeque;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlinx.coroutines.internal.ExceptionsConstuctorKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\u001a!\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a.\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0080\b¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0007\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0014\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a3\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00170\u0016\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a3\u0010\u001c\u001a\u00020\u001b2\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00172\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0000H\u0080Hø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\"\u0010!\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b!\u0010\u0004\u001a!\u0010\"\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\"\u0010\u0004\u001a%\u0010#\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00102\n\u0010\u0007\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b#\u0010$\u001a\u001b\u0010'\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b'\u0010(\u001a\u0017\u0010*\u001a\u00020)*\u00060\u0011j\u0002`\u0012H\u0000¢\u0006\u0004\b*\u0010+\u001a%\u0010.\u001a\u00020-*\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00172\u0006\u0010,\u001a\u00020%H\u0002¢\u0006\u0004\b.\u0010/\u001a#\u00100\u001a\u00020)*\u00060\u0011j\u0002`\u00122\n\u0010\u0018\u001a\u00060\u0011j\u0002`\u0012H\u0002¢\u0006\u0004\b0\u00101\u001a\u001b\u00102\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0000¢\u0006\u0004\b2\u00103\"\u0016\u00106\u001a\u00020%8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00105\"\u001e\u00109\u001a\n 7*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00105\"\u001e\u0010:\u001a\n 7*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u00105\"\u0016\u0010<\u001a\u00020%8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00105*\f\b\u0000\u0010=\"\u00020\n2\u00020\n*\f\b\u0000\u0010>\"\u00020\u00112\u00020\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"", ExifInterface.LONGITUDE_EAST, "exception", am.ax, "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "r", "Lh/e2/c;", "continuation", "q", "(Ljava/lang/Throwable;Lh/e2/c;)Ljava/lang/Throwable;", "Lh/e2/k/a/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "o", "(Ljava/lang/Throwable;Lh/e2/k/a/c;)Ljava/lang/Throwable;", "cause", "result", "Ljava/util/ArrayDeque;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "resultStackTrace", "f", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "Lkotlin/Pair;", "", com.huawei.hms.push.e.a, "(Ljava/lang/Throwable;)Lkotlin/Pair;", "recoveredStacktrace", "Lh/t1;", NotifyType.LIGHTS, "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "", "m", "(Ljava/lang/Throwable;Lh/e2/c;)Ljava/lang/Object;", "s", am.aI, "g", "(Lh/e2/k/a/c;)Ljava/util/ArrayDeque;", "", "message", e.j.a.b.c.f.f10128d, "(Ljava/lang/String;)Ljava/lang/StackTraceElement;", "", "k", "(Ljava/lang/StackTraceElement;)Z", "methodName", "", "i", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "h", "(Ljava/lang/StackTraceElement;Ljava/lang/StackTraceElement;)Z", "j", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "b", "Ljava/lang/String;", "stackTraceRecoveryClass", "kotlin.jvm.PlatformType", "c", "baseContinuationImplClassName", "stackTraceRecoveryClassName", am.av, "baseContinuationImplClass", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class h0 {
    private static final String a = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String b = "kotlinx.coroutines.internal.StackTraceRecoveryKt";

    /* renamed from: c */
    private static final String f15880c;

    /* renamed from: d */
    private static final String f15881d;

    static {
        Object m106constructorimpl;
        Object m106constructorimpl2;
        try {
            Result.a aVar = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(Class.forName(a).getCanonicalName());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(h.r0.a(th));
        }
        if (Result.m109exceptionOrNullimpl(m106constructorimpl) != null) {
            m106constructorimpl = a;
        }
        f15880c = (String) m106constructorimpl;
        try {
            Result.a aVar3 = Result.Companion;
            m106constructorimpl2 = Result.m106constructorimpl(Class.forName("i.b.w3.h0").getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar4 = Result.Companion;
            m106constructorimpl2 = Result.m106constructorimpl(h.r0.a(th2));
        }
        if (Result.m109exceptionOrNullimpl(m106constructorimpl2) != null) {
            m106constructorimpl2 = b;
        }
        f15881d = (String) m106constructorimpl2;
    }

    public static /* synthetic */ void a() {
    }

    public static /* synthetic */ void b() {
    }

    public static final /* synthetic */ Throwable c(Throwable th, h.e2.k.a.c cVar) {
        return o(th, cVar);
    }

    @x1
    @k.e.a.d
    public static final StackTraceElement d(@k.e.a.d String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> e(E e2) {
        boolean z;
        Throwable cause = e2.getCause();
        if (cause != null && h.k2.v.f0.g(cause.getClass(), e2.getClass())) {
            StackTraceElement[] stackTrace = e2.getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (k(stackTrace[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return z0.a(cause, stackTrace);
            }
            return z0.a(e2, new StackTraceElement[0]);
        }
        return z0.a(e2, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E f(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(d("Coroutine boundary"));
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int i2 = i(stackTrace, f15880c);
        int i3 = 0;
        if (i2 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            e3.setStackTrace((StackTraceElement[]) array);
            return e3;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + i2];
        for (int i4 = 0; i4 < i2; i4++) {
            stackTraceElementArr[i4] = stackTrace[i4];
        }
        for (StackTraceElement stackTraceElement : arrayDeque) {
            stackTraceElementArr[i2 + i3] = stackTraceElement;
            i3++;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    private static final ArrayDeque<StackTraceElement> g(h.e2.k.a.c cVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = cVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(cVar instanceof h.e2.k.a.c)) {
                cVar = null;
            }
            if (cVar == null || (cVar = cVar.getCallerFrame()) == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = cVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    private static final boolean h(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && h.k2.v.f0.g(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && h.k2.v.f0.g(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && h.k2.v.f0.g(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int i(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (h.k2.v.f0.g(str, stackTraceElementArr[i2].getClassName())) {
                return i2;
            }
        }
        return -1;
    }

    public static final void j(@k.e.a.d Throwable th, @k.e.a.d Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean k(@k.e.a.d StackTraceElement stackTraceElement) {
        return h.t2.u.u2(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
    }

    private static final void l(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (k(stackTraceElementArr[i2])) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i3) {
            return;
        }
        while (true) {
            if (h(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i3) {
                return;
            }
            length2--;
        }
    }

    @k.e.a.e
    public static final Object m(@k.e.a.d Throwable th, @k.e.a.d h.e2.c<?> cVar) {
        if (i.b.q0.e()) {
            if (cVar instanceof h.e2.k.a.c) {
                throw o(th, (h.e2.k.a.c) cVar);
            }
            throw th;
        }
        throw th;
    }

    @k.e.a.e
    private static final Object n(@k.e.a.d Throwable th, @k.e.a.d h.e2.c cVar) {
        if (i.b.q0.e()) {
            h.k2.v.c0.e(0);
            if (cVar instanceof h.e2.k.a.c) {
                throw o(th, (h.e2.k.a.c) cVar);
            }
            throw th;
        }
        throw th;
    }

    public static final <E extends Throwable> E o(E e2, h.e2.k.a.c cVar) {
        Pair e3 = e(e2);
        Throwable th = (Throwable) e3.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) e3.component2();
        Throwable f2 = ExceptionsConstuctorKt.f(th);
        if (f2 == null || (!h.k2.v.f0.g(f2.getMessage(), th.getMessage()))) {
            return e2;
        }
        ArrayDeque<StackTraceElement> g2 = g(cVar);
        if (g2.isEmpty()) {
            return e2;
        }
        if (th != e2) {
            l(stackTraceElementArr, g2);
        }
        return (E) f(th, f2, g2);
    }

    @k.e.a.d
    public static final <E extends Throwable> E p(@k.e.a.d E e2) {
        Throwable f2;
        return (i.b.q0.e() && (f2 = ExceptionsConstuctorKt.f(e2)) != null) ? (E) r(f2) : e2;
    }

    @k.e.a.d
    public static final <E extends Throwable> E q(@k.e.a.d E e2, @k.e.a.d h.e2.c<?> cVar) {
        return (i.b.q0.e() && (cVar instanceof h.e2.k.a.c)) ? (E) o(e2, (h.e2.k.a.c) cVar) : e2;
    }

    private static final <E extends Throwable> E r(E e2) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int length = stackTrace.length;
        int i2 = i(stackTrace, f15881d);
        int i3 = i2 + 1;
        int i4 = i(stackTrace, f15880c);
        int i5 = (length - i2) - (i4 == -1 ? 0 : length - i4);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 == 0) {
                stackTraceElement = d("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i3 + i6) - 1];
            }
            stackTraceElementArr[i6] = stackTraceElement;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    @k.e.a.d
    public static final <E extends Throwable> E s(@k.e.a.d E e2) {
        return !i.b.q0.e() ? e2 : (E) t(e2);
    }

    @k.e.a.d
    public static final <E extends Throwable> E t(@k.e.a.d E e2) {
        E e3 = (E) e2.getCause();
        if (e3 != null) {
            boolean z = true;
            if (!(!h.k2.v.f0.g(e3.getClass(), e2.getClass()))) {
                StackTraceElement[] stackTrace = e2.getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    } else if (k(stackTrace[i2])) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return e3;
                }
            }
        }
        return e2;
    }
}
