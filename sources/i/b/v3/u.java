package i.b.v3;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StartedWhileSubscribed;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Li/b/v3/u;", "", "Li/b/v3/x;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", am.av, "(Li/b/v3/x;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface u {
    public static final a a = a.f15872c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"i/b/v3/u$a", "", "", "stopTimeoutMillis", "replayExpirationMillis", "Li/b/v3/u;", am.av, "(JJ)Li/b/v3/u;", "Li/b/v3/u;", "c", "()Li/b/v3/u;", "Eagerly", "b", e.j.a.b.c.f.f10128d, "Lazily", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ a f15872c = new a();
        @k.e.a.d
        private static final u a = new w();
        @k.e.a.d
        private static final u b = new StartedLazily();

        private a() {
        }

        public static /* synthetic */ u b(a aVar, long j2, long j3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j2 = 0;
            }
            if ((i2 & 2) != 0) {
                j3 = Long.MAX_VALUE;
            }
            return aVar.a(j2, j3);
        }

        @k.e.a.d
        public final u a(long j2, long j3) {
            return new StartedWhileSubscribed(j2, j3);
        }

        @k.e.a.d
        public final u c() {
            return a;
        }

        @k.e.a.d
        public final u d() {
            return b;
        }
    }

    @k.e.a.d
    Flow<SharingCommand> a(@k.e.a.d x<Integer> xVar);
}
