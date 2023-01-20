package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.l;
import h.k2.u.q;
import h.t1;
import i.b.n0;
import i.b.v3.f;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {354, 358}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis", "$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "Li/b/v3/f;", "downstream", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements q<n0, f<? super T>, c<? super t1>, Object> {
    public final /* synthetic */ Flow $this_debounceInternal;
    public final /* synthetic */ l $timeoutMillisSelector;
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
    public FlowKt__DelayKt$debounceInternal$1(Flow flow, l lVar, c cVar) {
        super(3, cVar);
        this.$this_debounceInternal = flow;
        this.$timeoutMillisSelector = lVar;
    }

    @k.e.a.d
    public final c<t1> create(@k.e.a.d n0 n0Var, @k.e.a.d f<? super T> fVar, @k.e.a.d c<? super t1> cVar) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$this_debounceInternal, this.$timeoutMillisSelector, cVar);
        flowKt__DelayKt$debounceInternal$1.p$ = n0Var;
        flowKt__DelayKt$debounceInternal$1.p$0 = fVar;
        return flowKt__DelayKt$debounceInternal$1;
    }

    @Override // h.k2.u.q
    public final Object invoke(n0 n0Var, Object obj, c<? super t1> cVar) {
        return ((FlowKt__DelayKt$debounceInternal$1) create(n0Var, (f) obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:9|(5:11|(1:13)|14|(1:16)(1:30)|(2:28|29)(2:18|(5:20|(1:22)|23|(1:25)|27)))|31|32|(4:34|(1:43)(1:38)|39|(2:41|42))|44|45|46|(5:48|49|50|51|52)(1:67)|53|54|55|(1:57)|(1:59)(4:60|6|7|(2:71|72)(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(5:48|49|50|51|52) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x013e, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x013f, code lost:
        r4 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0160, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0162, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0163, code lost:
        r7 = r11;
        r19 = r12;
        r20 = r13;
        r4 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0169, code lost:
        r7.r0(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0122 A[Catch: all -> 0x0162, TRY_LEAVE, TryCatch #1 {all -> 0x0162, blocks: (B:50:0x011e, B:52:0x0122), top: B:77:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018a  */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, i.b.t3.y] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x017c -> B:72:0x0184). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
