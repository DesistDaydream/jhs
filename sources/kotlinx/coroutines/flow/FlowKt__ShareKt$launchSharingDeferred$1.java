package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.v3.f;
import i.b.v3.h;
import i.b.v3.l;
import i.b.v3.y;
import i.b.x;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;

@d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {0, 0, 0}, l = {TTAdConstant.VIDEO_COVER_URL_CODE}, m = "invokeSuspend", n = {"$this$launch", "state", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ x $result;
    public final /* synthetic */ Flow $upstream;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private n0 p$;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ShareKt$launchSharingDeferred$1$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements f<T> {
        public final /* synthetic */ n0 b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f16953c;

        public a(n0 n0Var, Ref.ObjectRef objectRef) {
            this.b = n0Var;
            this.f16953c = objectRef;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, i.b.v3.l] */
        @Override // i.b.v3.f
        @e
        public Object emit(Object obj, @k.e.a.d c cVar) {
            t1 t1Var;
            Ref.ObjectRef objectRef = this.f16953c;
            l lVar = (l) objectRef.element;
            if (lVar != null) {
                lVar.setValue(obj);
                t1Var = t1.a;
            } else {
                ?? a = y.a(obj);
                FlowKt__ShareKt$launchSharingDeferred$1.this.$result.complete(h.m(a));
                t1 t1Var2 = t1.a;
                objectRef.element = a;
                t1Var = t1Var2;
            }
            return t1Var == b.h() ? t1Var : t1.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharingDeferred$1(Flow flow, x xVar, c cVar) {
        super(2, cVar);
        this.$upstream = flow;
        this.$result = xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, cVar);
        flowKt__ShareKt$launchSharingDeferred$1.p$ = (n0) obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(n0 n0Var, c<? super t1> cVar) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                r0.n(obj);
                n0 n0Var = this.p$;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = null;
                Flow flow = this.$upstream;
                a aVar = new a(n0Var, objectRef);
                this.L$0 = n0Var;
                this.L$1 = objectRef;
                this.L$2 = flow;
                this.label = 1;
                if (flow.e(aVar, this) == h2) {
                    return h2;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Flow flow2 = (Flow) this.L$2;
                Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.L$1;
                n0 n0Var2 = (n0) this.L$0;
                r0.n(obj);
            }
            return t1.a;
        } catch (Throwable th) {
            this.$result.d(th);
            throw th;
        }
    }
}
