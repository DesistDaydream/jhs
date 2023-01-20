package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.k2.u.q;
import h.t1;
import i.b.r1;
import i.b.s1;
import i.b.v3.f;
import i.b.v3.h;
import i.b.w3.k0;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\u001ag\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000227\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aq\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\r\u001a\u00020\f27\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a;\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0016\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0015\"\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a5\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001at\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0001\u0010\t\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001b¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001aj\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000229\b\u0005\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b!\u0010\u000b\u001ac\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000223\b\u0001\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000b\"\"\u0010(\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010#\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%\"\u001c\u0010*\u001a\u00020)8\u0006@\u0007X\u0087T¢\u0006\f\n\u0004\b*\u0010+\u0012\u0004\b,\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lh/k0;", "name", "value", "Lh/e2/c;", "", "transform", am.av, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "", "concurrency", "c", "(Lkotlinx/coroutines/flow/Flow;ILh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", e.a, "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "", "k", "(Ljava/lang/Iterable;)Lkotlinx/coroutines/flow/Flow;", "", "flows", NotifyType.LIGHTS, "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "f", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Li/b/v3/f;", "Lh/t1;", "Lh/q;", "m", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", "b", "j", ExpandableTextView.P, "h", "()I", "getDEFAULT_CONCURRENCY$annotations", "()V", "DEFAULT_CONCURRENCY", "", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "Ljava/lang/String;", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__MergeKt {
    private static final int a = k0.b(h.a, 16, 1, Integer.MAX_VALUE);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__MergeKt$a", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements Flow<T> {
        public final /* synthetic */ Flow a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__MergeKt$a$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$$special$$inlined$collect$3"}, k = 1, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$a$a */
        /* loaded from: classes4.dex */
        public static final class C0501a implements f<Flow<? extends T>> {
            public final /* synthetic */ f a;

            public C0501a(f fVar) {
                this.a = fVar;
            }

            @Override // i.b.v3.f
            @k.e.a.e
            public Object emit(Object obj, @d c cVar) {
                Object e2 = ((Flow) obj).e(this.a, cVar);
                return e2 == b.h() ? e2 : t1.a;
            }
        }

        public a(Flow flow) {
            this.a = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @k.e.a.e
        public Object e(@d f fVar, @d c cVar) {
            Object e2 = this.a.e(new C0501a(fVar), cVar);
            return e2 == b.h() ? e2 : t1.a;
        }
    }

    @s1
    @d
    public static final <T, R> Flow<R> a(@d final Flow<? extends T> flow, @d final p<? super T, ? super c<? super Flow<? extends R>>, ? extends Object> pVar) {
        return h.K0(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2 */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2 implements f<T> {
                public final /* synthetic */ f a;
                public final /* synthetic */ FlowKt__MergeKt$flatMapConcat$$inlined$map$1 b;

                @h.e2.k.a.d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {134, 134}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lh/e2/c;", "Lh/t1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1", "emit"}, k = 3, mv = {1, 4, 0})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public Object L$2;
                    public Object L$3;
                    public Object L$4;
                    public Object L$5;
                    public Object L$6;
                    public Object L$7;
                    public int label;
                    public /* synthetic */ Object result;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(c cVar) {
                        super(cVar);
                        AnonymousClass2.this = r1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @k.e.a.e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(f fVar, FlowKt__MergeKt$flatMapConcat$$inlined$map$1 flowKt__MergeKt$flatMapConcat$$inlined$map$1) {
                    this.a = fVar;
                    this.b = flowKt__MergeKt$flatMapConcat$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:66:0x0069  */
                /* JADX WARN: Removed duplicated region for block: B:72:0x00aa A[RETURN] */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r11, @k.e.a.d h.e2.c r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L69
                        if (r2 == r4) goto L4b
                        if (r2 != r3) goto L43
                        java.lang.Object r11 = r0.L$6
                        i.b.v3.f r11 = (i.b.v3.f) r11
                        java.lang.Object r11 = r0.L$5
                        java.lang.Object r11 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r11
                        java.lang.Object r11 = r0.L$3
                        java.lang.Object r11 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r11
                        java.lang.Object r11 = r0.L$1
                        java.lang.Object r11 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2) r11
                        h.r0.n(r12)
                        goto Lab
                    L43:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L4b:
                        java.lang.Object r11 = r0.L$7
                        i.b.v3.f r11 = (i.b.v3.f) r11
                        java.lang.Object r2 = r0.L$6
                        i.b.v3.f r2 = (i.b.v3.f) r2
                        java.lang.Object r4 = r0.L$5
                        java.lang.Object r5 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r5 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r5
                        java.lang.Object r6 = r0.L$3
                        java.lang.Object r7 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        java.lang.Object r8 = r0.L$1
                        java.lang.Object r9 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2) r9
                        h.r0.n(r12)
                        goto L94
                    L69:
                        h.r0.n(r12)
                        i.b.v3.f r12 = r10.a
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1 r2 = r10.b
                        h.k2.u.p r2 = r2
                        r0.L$0 = r10
                        r0.L$1 = r11
                        r0.L$2 = r0
                        r0.L$3 = r11
                        r0.L$4 = r0
                        r0.L$5 = r11
                        r0.L$6 = r12
                        r0.L$7 = r12
                        r0.label = r4
                        java.lang.Object r2 = r2.invoke(r11, r0)
                        if (r2 != r1) goto L8b
                        return r1
                    L8b:
                        r9 = r10
                        r4 = r11
                        r6 = r4
                        r8 = r6
                        r11 = r12
                        r5 = r0
                        r7 = r5
                        r12 = r2
                        r2 = r11
                    L94:
                        r0.L$0 = r9
                        r0.L$1 = r8
                        r0.L$2 = r7
                        r0.L$3 = r6
                        r0.L$4 = r5
                        r0.L$5 = r4
                        r0.L$6 = r2
                        r0.label = r3
                        java.lang.Object r11 = r11.emit(r12, r0)
                        if (r11 != r1) goto Lab
                        return r1
                    Lab:
                        h.t1 r11 = h.t1.a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d f fVar, @d c cVar) {
                Object e2 = flow.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == b.h() ? e2 : t1.a;
            }
        });
    }

    @r1
    @d
    public static final <T, R> Flow<R> b(@d Flow<? extends T> flow, @h.b @d p<? super T, ? super c<? super Flow<? extends R>>, ? extends Object> pVar) {
        return h.m2(flow, new FlowKt__MergeKt$flatMapLatest$1(pVar, null));
    }

    @s1
    @d
    public static final <T, R> Flow<R> c(@d final Flow<? extends T> flow, int i2, @d final p<? super T, ? super c<? super Flow<? extends R>>, ? extends Object> pVar) {
        return h.L0(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2"}, k = 1, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2 */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2 implements f<T> {
                public final /* synthetic */ f a;
                public final /* synthetic */ FlowKt__MergeKt$flatMapMerge$$inlined$map$1 b;

                @h.e2.k.a.d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {134, 134}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lh/e2/c;", "Lh/t1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1", "emit"}, k = 3, mv = {1, 4, 0})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public Object L$2;
                    public Object L$3;
                    public Object L$4;
                    public Object L$5;
                    public Object L$6;
                    public Object L$7;
                    public int label;
                    public /* synthetic */ Object result;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(c cVar) {
                        super(cVar);
                        AnonymousClass2.this = r1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @k.e.a.e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(f fVar, FlowKt__MergeKt$flatMapMerge$$inlined$map$1 flowKt__MergeKt$flatMapMerge$$inlined$map$1) {
                    this.a = fVar;
                    this.b = flowKt__MergeKt$flatMapMerge$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:66:0x0069  */
                /* JADX WARN: Removed duplicated region for block: B:72:0x00aa A[RETURN] */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r11, @k.e.a.d h.e2.c r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L69
                        if (r2 == r4) goto L4b
                        if (r2 != r3) goto L43
                        java.lang.Object r11 = r0.L$6
                        i.b.v3.f r11 = (i.b.v3.f) r11
                        java.lang.Object r11 = r0.L$5
                        java.lang.Object r11 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r11
                        java.lang.Object r11 = r0.L$3
                        java.lang.Object r11 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r11
                        java.lang.Object r11 = r0.L$1
                        java.lang.Object r11 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2) r11
                        h.r0.n(r12)
                        goto Lab
                    L43:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L4b:
                        java.lang.Object r11 = r0.L$7
                        i.b.v3.f r11 = (i.b.v3.f) r11
                        java.lang.Object r2 = r0.L$6
                        i.b.v3.f r2 = (i.b.v3.f) r2
                        java.lang.Object r4 = r0.L$5
                        java.lang.Object r5 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r5 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r5
                        java.lang.Object r6 = r0.L$3
                        java.lang.Object r7 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        java.lang.Object r8 = r0.L$1
                        java.lang.Object r9 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2) r9
                        h.r0.n(r12)
                        goto L94
                    L69:
                        h.r0.n(r12)
                        i.b.v3.f r12 = r10.a
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1 r2 = r10.b
                        h.k2.u.p r2 = r2
                        r0.L$0 = r10
                        r0.L$1 = r11
                        r0.L$2 = r0
                        r0.L$3 = r11
                        r0.L$4 = r0
                        r0.L$5 = r11
                        r0.L$6 = r12
                        r0.L$7 = r12
                        r0.label = r4
                        java.lang.Object r2 = r2.invoke(r11, r0)
                        if (r2 != r1) goto L8b
                        return r1
                    L8b:
                        r9 = r10
                        r4 = r11
                        r6 = r4
                        r8 = r6
                        r11 = r12
                        r5 = r0
                        r7 = r5
                        r12 = r2
                        r2 = r11
                    L94:
                        r0.L$0 = r9
                        r0.L$1 = r8
                        r0.L$2 = r7
                        r0.L$3 = r6
                        r0.L$4 = r5
                        r0.L$5 = r4
                        r0.L$6 = r2
                        r0.label = r3
                        java.lang.Object r11 = r11.emit(r12, r0)
                        if (r11 != r1) goto Lab
                        return r1
                    Lab:
                        h.t1 r11 = h.t1.a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d f fVar, @d c cVar) {
                Object e2 = flow.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == b.h() ? e2 : t1.a;
            }
        }, i2);
    }

    public static /* synthetic */ Flow d(Flow flow, int i2, p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = a;
        }
        return h.H0(flow, i2, pVar);
    }

    @s1
    @d
    public static final <T> Flow<T> e(@d Flow<? extends Flow<? extends T>> flow) {
        return new a(flow);
    }

    @s1
    @d
    public static final <T> Flow<T> f(@d Flow<? extends Flow<? extends T>> flow, int i2) {
        if (i2 > 0) {
            return i2 == 1 ? h.K0(flow) : new ChannelFlowMerge(flow, i2, null, 0, null, 28, null);
        }
        throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i2).toString());
    }

    public static /* synthetic */ Flow g(Flow flow, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = a;
        }
        return h.L0(flow, i2);
    }

    public static final int h() {
        return a;
    }

    @s1
    public static /* synthetic */ void i() {
    }

    @r1
    @d
    public static final <T, R> Flow<R> j(@d Flow<? extends T> flow, @h.b @d p<? super T, ? super c<? super R>, ? extends Object> pVar) {
        return h.m2(flow, new FlowKt__MergeKt$mapLatest$1(pVar, null));
    }

    @r1
    @d
    public static final <T> Flow<T> k(@d Iterable<? extends Flow<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    @r1
    @d
    public static final <T> Flow<T> l(@d Flow<? extends T>... flowArr) {
        return h.g1(ArraysKt___ArraysKt.Y4(flowArr));
    }

    @r1
    @d
    public static final <T, R> Flow<R> m(@d Flow<? extends T> flow, @h.b @d q<? super f<? super R>, ? super T, ? super c<? super t1>, ? extends Object> qVar) {
        return new ChannelFlowTransformLatest(qVar, flow, null, 0, null, 28, null);
    }
}
