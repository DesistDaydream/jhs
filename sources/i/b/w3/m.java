package i.b.w3;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001c\u0010\u0004\u001a\u00020\u00008\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003¨\u0006\u0005"}, d2 = {"", am.av, "Z", "()Z", "ANDROID_DETECTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class m {
    private static final boolean a;

    static {
        Object m106constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(h.r0.a(th));
        }
        a = Result.m113isSuccessimpl(m106constructorimpl);
    }

    public static final boolean a() {
        return a;
    }
}
