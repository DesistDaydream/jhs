package i.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "name", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "b", "(Ljava/lang/String;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "nThreads", am.av, "(ILjava/lang/String;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class j3 {
    @q2
    @k.e.a.d
    public static final ExecutorCoroutineDispatcher a(int i2, @k.e.a.d String str) {
        if (i2 >= 1) {
            return new i3(i2, str);
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i2 + " specified").toString());
    }

    @q2
    @k.e.a.d
    public static final ExecutorCoroutineDispatcher b(@k.e.a.d String str) {
        return a(1, str);
    }
}
