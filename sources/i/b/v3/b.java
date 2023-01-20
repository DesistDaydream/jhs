package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.e2;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Li/b/v3/b;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/a;", "Li/b/v3/f;", "collector", "Lh/t1;", com.huawei.hms.push.e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", am.av, "Lkotlinx/coroutines/flow/Flow;", "flow", "<init>", "(Lkotlinx/coroutines/flow/Flow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class b<T> implements i.b.v3.a<T> {
    private final Flow<T> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"i/b/v3/b$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements f<T> {
        public final /* synthetic */ f a;

        public a(f fVar) {
            this.a = fVar;
        }

        @Override // i.b.v3.f
        @k.e.a.e
        public Object emit(Object obj, @k.e.a.d h.e2.c cVar) {
            e2.A(cVar.getContext());
            Object emit = this.a.emit(obj, cVar);
            return emit == h.e2.j.b.h() ? emit : t1.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@k.e.a.d Flow<? extends T> flow) {
        this.a = flow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    public Object e(@k.e.a.d f<? super T> fVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        Object e2 = this.a.e(new a(fVar), cVar);
        return e2 == h.e2.j.b.h() ? e2 : t1.a;
    }
}
