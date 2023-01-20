package i.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00048@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00048@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lh/e2/c;", "", "c", "(Lh/e2/c;)Ljava/lang/String;", "", am.av, "(Ljava/lang/Object;)Ljava/lang/String;", "classSimpleName", "b", "hexAddress", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class r0 {
    @k.e.a.d
    public static final String a(@k.e.a.d Object obj) {
        return obj.getClass().getSimpleName();
    }

    @k.e.a.d
    public static final String b(@k.e.a.d Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @k.e.a.d
    public static final String c(@k.e.a.d h.e2.c<?> cVar) {
        String m106constructorimpl;
        if (cVar instanceof i.b.w3.j) {
            return cVar.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(cVar + '@' + b(cVar));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(h.r0.a(th));
        }
        if (Result.m109exceptionOrNullimpl(m106constructorimpl) != null) {
            m106constructorimpl = cVar.getClass().getName() + '@' + b(cVar);
        }
        return (String) m106constructorimpl;
    }
}
