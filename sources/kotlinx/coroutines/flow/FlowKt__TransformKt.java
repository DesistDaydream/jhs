package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.a2.i0;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.k2.u.q;
import h.t1;
import i.b.r1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aO\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012$\b\u0004\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aO\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012$\b\u0004\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\b\u001a&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\n\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u0005*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b\r\u0010\f\u001ad\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u000123\b\u0004\u0010\u0011\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\b\u001aj\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\n*\u00020\u0005*\b\u0012\u0004\u0012\u00028\u00000\u000125\b\u0004\u0010\u0011\u001a/\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\b\u001a)\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0015\u0010\f\u001aJ\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\b\u001a\u0080\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0019\u001a\u00028\u00012H\b\u0001\u0010\u001c\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001ap\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012F\u0010\u001c\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lh/e2/c;", "", "", "predicate", am.av, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "c", "R", "b", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", f.f10128d, "Lh/k0;", "name", "value", "transform", e.a, "f", "Lh/a2/i0;", "j", "Lh/t1;", "action", "g", "initial", "Lkotlin/Function3;", "accumulator", "operation", "i", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", "h", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__TransformKt {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__TransformKt$a", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements Flow<T> {
        public final /* synthetic */ Flow a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__TransformKt$a$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4$lambda$1"}, k = 1, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$a$a */
        /* loaded from: classes4.dex */
        public static final class C0502a implements i.b.v3.f<T> {
            public final /* synthetic */ i.b.v3.f a;
            public final /* synthetic */ a b;

            public C0502a(i.b.v3.f fVar, a aVar) {
                this.a = fVar;
                this.b = aVar;
            }

            @Override // i.b.v3.f
            @k.e.a.e
            public Object emit(Object obj, @d c cVar) {
                i.b.v3.f fVar = this.a;
                if (obj != null) {
                    Object emit = fVar.emit(obj, cVar);
                    return emit == h.e2.j.b.h() ? emit : t1.a;
                }
                return t1.a;
            }
        }

        public a(Flow flow) {
            this.a = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @k.e.a.e
        public Object e(@d i.b.v3.f fVar, @d c cVar) {
            Object e2 = this.a.e(new C0502a(fVar, this), cVar);
            return e2 == h.e2.j.b.h() ? e2 : t1.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__TransformKt$b", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b implements Flow<i0<? extends T>> {
        public final /* synthetic */ Flow a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__TransformKt$b$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$7"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes4.dex */
        public static final class a implements i.b.v3.f<T> {
            public final /* synthetic */ i.b.v3.f a;
            public final /* synthetic */ Ref.IntRef b;

            public a(i.b.v3.f fVar, Ref.IntRef intRef) {
                this.a = fVar;
                this.b = intRef;
            }

            @Override // i.b.v3.f
            @k.e.a.e
            public Object emit(Object obj, @d c cVar) {
                i.b.v3.f fVar = this.a;
                Ref.IntRef intRef = this.b;
                int i2 = intRef.element;
                intRef.element = i2 + 1;
                if (i2 >= 0) {
                    Object emit = fVar.emit(new i0(i2, obj), cVar);
                    return emit == h.e2.j.b.h() ? emit : t1.a;
                }
                throw new ArithmeticException("Index overflow has happened");
            }
        }

        public b(Flow flow) {
            this.a = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @k.e.a.e
        public Object e(@d i.b.v3.f fVar, @d c cVar) {
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            Object e2 = this.a.e(new a(fVar, intRef), cVar);
            return e2 == h.e2.j.b.h() ? e2 : t1.a;
        }
    }

    @d
    public static final <T> Flow<T> a(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super Boolean>, ? extends Object> pVar) {
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(flow, pVar);
    }

    @d
    public static final <T> Flow<T> c(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super Boolean>, ? extends Object> pVar) {
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(flow, pVar);
    }

    @d
    public static final <T> Flow<T> d(@d Flow<? extends T> flow) {
        return new a(flow);
    }

    @d
    public static final <T, R> Flow<R> e(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super R>, ? extends Object> pVar) {
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(flow, pVar);
    }

    @d
    public static final <T, R> Flow<R> f(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super R>, ? extends Object> pVar) {
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(flow, pVar);
    }

    @d
    public static final <T> Flow<T> g(@d final Flow<? extends T> flow, @d final p<? super T, ? super c<? super t1>, ? extends Object> pVar) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$7$lambda$1"}, k = 1, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<T> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 b;

                @h.e2.k.a.d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {134, 135}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lh/e2/c;", "Lh/t1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$7$lambda$1$1", "emit"}, k = 3, mv = {1, 4, 0})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public Object L$2;
                    public Object L$3;
                    public Object L$4;
                    public Object L$5;
                    public Object L$6;
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

                public AnonymousClass2(i.b.v3.f fVar, FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1) {
                    this.a = fVar;
                    this.b = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:66:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:72:0x00a9 A[RETURN] */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r10, @k.e.a.d h.e2.c r11) {
                    /*
                        r9 = this;
                        boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r11
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r11)
                    L18:
                        java.lang.Object r11 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L64
                        if (r2 == r4) goto L4a
                        if (r2 != r3) goto L42
                        java.lang.Object r10 = r0.L$6
                        i.b.v3.f r10 = (i.b.v3.f) r10
                        java.lang.Object r10 = r0.L$5
                        java.lang.Object r10 = r0.L$4
                        h.e2.c r10 = (h.e2.c) r10
                        java.lang.Object r10 = r0.L$3
                        java.lang.Object r10 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r10 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r10
                        java.lang.Object r10 = r0.L$1
                        java.lang.Object r10 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 r10 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2) r10
                        h.r0.n(r11)
                        goto Laa
                    L42:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L4a:
                        java.lang.Object r10 = r0.L$6
                        i.b.v3.f r10 = (i.b.v3.f) r10
                        java.lang.Object r2 = r0.L$5
                        java.lang.Object r4 = r0.L$4
                        h.e2.c r4 = (h.e2.c) r4
                        java.lang.Object r5 = r0.L$3
                        java.lang.Object r6 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r6
                        java.lang.Object r7 = r0.L$1
                        java.lang.Object r8 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 r8 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2) r8
                        h.r0.n(r11)
                        goto L93
                    L64:
                        h.r0.n(r11)
                        i.b.v3.f r11 = r9.a
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 r2 = r9.b
                        h.k2.u.p r2 = r2
                        r0.L$0 = r9
                        r0.L$1 = r10
                        r0.L$2 = r0
                        r0.L$3 = r10
                        r0.L$4 = r0
                        r0.L$5 = r10
                        r0.L$6 = r11
                        r0.label = r4
                        r4 = 6
                        h.k2.v.c0.e(r4)
                        java.lang.Object r2 = r2.invoke(r10, r0)
                        r4 = 7
                        h.k2.v.c0.e(r4)
                        if (r2 != r1) goto L8c
                        return r1
                    L8c:
                        r8 = r9
                        r2 = r10
                        r5 = r2
                        r7 = r5
                        r10 = r11
                        r4 = r0
                        r6 = r4
                    L93:
                        r0.L$0 = r8
                        r0.L$1 = r7
                        r0.L$2 = r6
                        r0.L$3 = r5
                        r0.L$4 = r4
                        r0.L$5 = r2
                        r0.L$6 = r10
                        r0.label = r3
                        java.lang.Object r10 = r10.emit(r2, r0)
                        if (r10 != r1) goto Laa
                        return r1
                    Laa:
                        h.t1 r10 = h.t1.a
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d i.b.v3.f fVar, @d c cVar) {
                Object e2 = flow.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == b.h() ? e2 : t1.a;
            }
        };
    }

    @r1
    @d
    public static final <T> Flow<T> h(@d Flow<? extends T> flow, @d q<? super T, ? super T, ? super c<? super T>, ? extends Object> qVar) {
        return new FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1(flow, qVar);
    }

    @r1
    @d
    public static final <T, R> Flow<R> i(@d Flow<? extends T> flow, R r, @h.b @d q<? super R, ? super T, ? super c<? super R>, ? extends Object> qVar) {
        return new FlowKt__TransformKt$scan$$inlined$unsafeFlow$1(flow, r, qVar);
    }

    @d
    public static final <T> Flow<i0<T>> j(@d Flow<? extends T> flow) {
        return new b(flow);
    }
}
