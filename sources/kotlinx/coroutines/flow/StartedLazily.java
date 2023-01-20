package kotlinx.coroutines.flow;

import com.umeng.analytics.pro.am;
import i.b.v3.h;
import i.b.v3.u;
import i.b.v3.x;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/flow/StartedLazily;", "Li/b/v3/u;", "Li/b/v3/x;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", am.av, "(Li/b/v3/x;)Lkotlinx/coroutines/flow/Flow;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class StartedLazily implements u {
    @Override // i.b.v3.u
    @d
    public Flow<SharingCommand> a(@d x<Integer> xVar) {
        return h.N0(new StartedLazily$command$1(xVar, null));
    }

    @d
    public String toString() {
        return "SharingStarted.Lazily";
    }
}
