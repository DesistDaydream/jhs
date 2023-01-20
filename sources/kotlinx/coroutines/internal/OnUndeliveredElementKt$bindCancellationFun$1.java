package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LONGITUDE_EAST, "", "<anonymous parameter 0>", "Lh/t1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class OnUndeliveredElementKt$bindCancellationFun$1 extends Lambda implements l<Throwable, t1> {
    public final /* synthetic */ CoroutineContext $context;
    public final /* synthetic */ Object $element;
    public final /* synthetic */ l $this_bindCancellationFun;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnUndeliveredElementKt$bindCancellationFun$1(l lVar, Object obj, CoroutineContext coroutineContext) {
        super(1);
        this.$this_bindCancellationFun = lVar;
        this.$element = obj;
        this.$context = coroutineContext;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
        invoke2(th);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Throwable th) {
        OnUndeliveredElementKt.b(this.$this_bindCancellationFun, this.$element, this.$context);
    }
}
