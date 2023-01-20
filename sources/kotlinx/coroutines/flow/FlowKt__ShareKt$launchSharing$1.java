package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.qq.e.comm.adevent.AdEventType;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.a;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.v3.g;
import i.b.v3.k;
import i.b.v3.r;
import i.b.v3.u;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {0, 1, 2, 3}, l = {AdEventType.VIDEO_COMPLETE, AdEventType.VIDEO_READY, AdEventType.VIDEO_LOADING, 217}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ Object $initialValue;
    public final /* synthetic */ k $shared;
    public final /* synthetic */ u $started;
    public final /* synthetic */ Flow $upstream;
    public Object L$0;
    public int label;
    private n0 p$;

    @d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<Integer, c<? super Boolean>, Object> {
        public int label;
        private int p$0;

        public AnonymousClass1(c cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k.e.a.d
        public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(cVar);
            Number number = (Number) obj;
            number.intValue();
            anonymousClass1.p$0 = number.intValue();
            return anonymousClass1;
        }

        @Override // h.k2.u.p
        public final Object invoke(Integer num, c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(num, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@k.e.a.d Object obj) {
            b.h();
            if (this.label == 0) {
                r0.n(obj);
                return a.a(this.p$0 > 0);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {0}, l = {219}, m = "invokeSuspend", n = {AdvanceSetting.NETWORK_TYPE}, s = {"L$0"})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/SharingCommand;", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements p<SharingCommand, c<? super t1>, Object> {
        public Object L$0;
        public int label;
        private SharingCommand p$0;

        public AnonymousClass2(c cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k.e.a.d
        public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.p$0 = (SharingCommand) obj;
            return anonymousClass2;
        }

        @Override // h.k2.u.p
        public final Object invoke(SharingCommand sharingCommand, c<? super t1> cVar) {
            return ((AnonymousClass2) create(sharingCommand, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@k.e.a.d Object obj) {
            Object h2 = b.h();
            int i2 = this.label;
            if (i2 == 0) {
                r0.n(obj);
                SharingCommand sharingCommand = this.p$0;
                int i3 = g.a[sharingCommand.ordinal()];
                if (i3 == 1) {
                    FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$1 = FlowKt__ShareKt$launchSharing$1.this;
                    Flow flow = flowKt__ShareKt$launchSharing$1.$upstream;
                    k kVar = flowKt__ShareKt$launchSharing$1.$shared;
                    this.L$0 = sharingCommand;
                    this.label = 1;
                    if (flow.e(kVar, this) == h2) {
                        return h2;
                    }
                } else if (i3 == 3) {
                    FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$12 = FlowKt__ShareKt$launchSharing$1.this;
                    Object obj2 = flowKt__ShareKt$launchSharing$12.$initialValue;
                    if (obj2 == r.a) {
                        flowKt__ShareKt$launchSharing$12.$shared.g();
                    } else {
                        flowKt__ShareKt$launchSharing$12.$shared.b(obj2);
                    }
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                SharingCommand sharingCommand2 = (SharingCommand) this.L$0;
                r0.n(obj);
            }
            return t1.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharing$1(u uVar, Flow flow, k kVar, Object obj, c cVar) {
        super(2, cVar);
        this.$started = uVar;
        this.$upstream = flow;
        this.$shared = kVar;
        this.$initialValue = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$1 = new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, cVar);
        flowKt__ShareKt$launchSharing$1.p$ = (n0) obj;
        return flowKt__ShareKt$launchSharing$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(n0 n0Var, c<? super t1> cVar) {
        return ((FlowKt__ShareKt$launchSharing$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0078 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r8.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2d
            if (r1 == r5) goto L25
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L15
            goto L25
        L15:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1d:
            java.lang.Object r1 = r8.L$0
            i.b.n0 r1 = (i.b.n0) r1
            h.r0.n(r9)
            goto L6a
        L25:
            java.lang.Object r0 = r8.L$0
            i.b.n0 r0 = (i.b.n0) r0
            h.r0.n(r9)
            goto L99
        L2d:
            h.r0.n(r9)
            i.b.n0 r1 = r8.p$
            i.b.v3.u r9 = r8.$started
            i.b.v3.u$a r6 = i.b.v3.u.a
            i.b.v3.u r7 = r6.c()
            if (r9 != r7) goto L4b
            kotlinx.coroutines.flow.Flow r9 = r8.$upstream
            i.b.v3.k r2 = r8.$shared
            r8.L$0 = r1
            r8.label = r5
            java.lang.Object r9 = r9.e(r2, r8)
            if (r9 != r0) goto L99
            return r0
        L4b:
            i.b.v3.u r9 = r8.$started
            i.b.v3.u r5 = r6.d()
            r6 = 0
            if (r9 != r5) goto L79
            i.b.v3.k r9 = r8.$shared
            i.b.v3.x r9 = r9.c()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r2 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r2.<init>(r6)
            r8.L$0 = r1
            r8.label = r4
            java.lang.Object r9 = i.b.v3.h.z0(r9, r2, r8)
            if (r9 != r0) goto L6a
            return r0
        L6a:
            kotlinx.coroutines.flow.Flow r9 = r8.$upstream
            i.b.v3.k r2 = r8.$shared
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = r9.e(r2, r8)
            if (r9 != r0) goto L99
            return r0
        L79:
            i.b.v3.u r9 = r8.$started
            i.b.v3.k r3 = r8.$shared
            i.b.v3.x r3 = r3.c()
            kotlinx.coroutines.flow.Flow r9 = r9.a(r3)
            kotlinx.coroutines.flow.Flow r9 = i.b.v3.h.l0(r9)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r3 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            r3.<init>(r6)
            r8.L$0 = r1
            r8.label = r2
            java.lang.Object r9 = i.b.v3.h.E(r9, r3, r8)
            if (r9 != r0) goto L99
            return r0
        L99:
            h.t1 r9 = h.t1.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
