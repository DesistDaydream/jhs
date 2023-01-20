package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.q;
import h.t1;
import i.b.n0;
import i.b.v3.f;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0, 0}, l = {355}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", "values", "lastValue", RemoteMessageConst.Notification.TICKER}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "Li/b/v3/f;", "downstream", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements q<n0, f<? super T>, c<? super t1>, Object> {
    public final /* synthetic */ long $periodMillis;
    public final /* synthetic */ Flow $this_sample;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    private n0 p$;
    private f p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2(Flow flow, long j2, c cVar) {
        super(3, cVar);
        this.$this_sample = flow;
        this.$periodMillis = j2;
    }

    @k.e.a.d
    public final c<t1> create(@k.e.a.d n0 n0Var, @k.e.a.d f<? super T> fVar, @k.e.a.d c<? super t1> cVar) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$this_sample, this.$periodMillis, cVar);
        flowKt__DelayKt$sample$2.p$ = n0Var;
        flowKt__DelayKt$sample$2.p$0 = fVar;
        return flowKt__DelayKt$sample$2;
    }

    @Override // h.k2.u.q
    public final Object invoke(n0 n0Var, Object obj, c<? super t1> cVar) {
        return ((FlowKt__DelayKt$sample$2) create(n0Var, (f) obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:8|(1:9)|10|11|12|13|14|(1:16)|(1:18)|5|6|(2:26|27)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00af, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b3, code lost:
        r1.r0(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, i.b.t3.y] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c3 -> B:26:0x00c6). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
