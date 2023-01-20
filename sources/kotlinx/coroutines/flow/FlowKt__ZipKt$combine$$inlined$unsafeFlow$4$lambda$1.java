package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.k2.v.f0;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "", "invoke", "()[Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$1 extends Lambda implements a<T[]> {
    public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$1(FlowKt__ZipKt$combine$$inlined$unsafeFlow$4 flowKt__ZipKt$combine$$inlined$unsafeFlow$4) {
        super(0);
        this.this$0 = flowKt__ZipKt$combine$$inlined$unsafeFlow$4;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T[], java.lang.Object[]] */
    @Override // h.k2.u.a
    @e
    public final T[] invoke() {
        int length = this.this$0.a.length;
        f0.y(0, "T?");
        return new Object[length];
    }
}
