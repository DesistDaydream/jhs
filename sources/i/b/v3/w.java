package i.b.v3;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharingCommand;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Li/b/v3/w;", "Li/b/v3/u;", "Li/b/v3/x;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", am.av, "(Li/b/v3/x;)Lkotlinx/coroutines/flow/Flow;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class w implements u {
    @Override // i.b.v3.u
    @k.e.a.d
    public Flow<SharingCommand> a(@k.e.a.d x<Integer> xVar) {
        return h.Q0(SharingCommand.START);
    }

    @k.e.a.d
    public String toString() {
        return "SharingStarted.Eagerly";
    }
}
