package i.b.w3;

import com.umeng.analytics.pro.am;
import i.b.l2;
import i.b.x1;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\n\u001a!\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u000f\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u001c\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0015\u0010\u0016\"\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "factories", "Li/b/l2;", "f", "(Lkotlinx/coroutines/internal/MainDispatcherFactory;Ljava/util/List;)Li/b/l2;", "", e.j.a.b.c.f.f10128d, "(Li/b/l2;)Z", "", "cause", "", "errorHint", "Li/b/w3/z;", am.av, "(Ljava/lang/Throwable;Ljava/lang/String;)Li/b/w3/z;", "", com.huawei.hms.push.e.a, "()Ljava/lang/Void;", "b", "Z", "getSUPPORT_MISSING$annotations", "()V", "SUPPORT_MISSING", "Ljava/lang/String;", "FAST_SERVICE_LOADER_PROPERTY_NAME", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class y {
    private static final String a = "kotlinx.coroutines.fast.service.loader";
    private static final boolean b = true;

    private static final z a(Throwable th, String str) {
        if (b) {
            return new z(th, str);
        }
        if (th != null) {
            throw th;
        }
        e();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ z b(Throwable th, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    private static /* synthetic */ void c() {
    }

    @x1
    public static final boolean d(@k.e.a.d l2 l2Var) {
        return l2Var instanceof z;
    }

    @k.e.a.d
    public static final Void e() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @x1
    @k.e.a.d
    public static final l2 f(@k.e.a.d MainDispatcherFactory mainDispatcherFactory, @k.e.a.d List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return a(th, mainDispatcherFactory.hintOnError());
        }
    }
}
