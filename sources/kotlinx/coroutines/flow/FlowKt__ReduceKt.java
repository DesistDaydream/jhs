package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.u.q;
import h.k2.v.c0;
import h.t1;
import i.b.v3.c0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001au\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022F\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a{\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u00012H\b\u0004\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013\u001a#\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013\u001aG\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a%\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0013\u001aI\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lh/k0;", "name", "accumulator", "value", "Lh/e2/c;", "", "operation", "g", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;Lh/e2/c;)Ljava/lang/Object;", "R", "initial", "acc", e.a, "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lh/k2/u/q;Lh/e2/c;)Ljava/lang/Object;", "h", "(Lkotlinx/coroutines/flow/Flow;Lh/e2/c;)Ljava/lang/Object;", "i", am.av, "Lkotlin/Function2;", "", "predicate", "b", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "c", f.f10128d, "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__ReduceKt {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ReduceKt$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements i.b.v3.f<T> {
        public final /* synthetic */ Ref.ObjectRef a;

        public a(Ref.ObjectRef objectRef) {
            this.a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.b.v3.f
        @k.e.a.e
        public Object emit(Object obj, @k.e.a.d h.e2.c cVar) {
            this.a.element = obj;
            if (h.e2.k.a.a.a(false).booleanValue()) {
                return t1.a;
            }
            throw new AbortFlowException(this);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ReduceKt$b", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b implements i.b.v3.f<T> {
        public final /* synthetic */ Ref.ObjectRef a;

        public b(Ref.ObjectRef objectRef) {
            this.a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.b.v3.f
        @k.e.a.e
        public Object emit(Object obj, @k.e.a.d h.e2.c cVar) {
            this.a.element = obj;
            if (h.e2.k.a.a.a(false).booleanValue()) {
                return t1.a;
            }
            throw new AbortFlowException(this);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ReduceKt$c", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c implements i.b.v3.f<T> {
        public final /* synthetic */ Ref.ObjectRef a;

        public c(Ref.ObjectRef objectRef) {
            this.a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.b.v3.f
        @k.e.a.e
        public Object emit(Object obj, @k.e.a.d h.e2.c cVar) {
            Ref.ObjectRef objectRef = this.a;
            if (objectRef.element == n.a) {
                objectRef.element = obj;
                return t1.a;
            }
            throw new IllegalArgumentException("Flow has more than one element".toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ReduceKt$d", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class d implements i.b.v3.f<T> {
        public final /* synthetic */ Ref.ObjectRef a;

        public d(Ref.ObjectRef objectRef) {
            this.a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, i.b.w3.i0] */
        @Override // i.b.v3.f
        @k.e.a.e
        public Object emit(Object obj, @k.e.a.d h.e2.c cVar) {
            boolean z;
            Ref.ObjectRef objectRef = this.a;
            T t = objectRef.element;
            ?? r1 = n.a;
            if (t == r1) {
                objectRef.element = obj;
                z = true;
            } else {
                objectRef.element = r1;
                z = false;
            }
            if (h.e2.k.a.a.a(z).booleanValue()) {
                return t1.a;
            }
            throw new AbortFlowException(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d h.e2.c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.L$3
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.a) r4
            java.lang.Object r1 = r0.L$2
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
            h.r0.n(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L39
            goto L6e
        L39:
            r5 = move-exception
            goto L6b
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            h.r0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            i.b.w3.i0 r2 = i.b.v3.c0.n.a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$a
            r2.<init>(r5)
            r0.L$0 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.L$1 = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.L$2 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.L$3 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            java.lang.Object r4 = r4.e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            if (r4 != r1) goto L65
            return r1
        L65:
            r1 = r5
            goto L6e
        L67:
            r4 = move-exception
            r1 = r5
            r5 = r4
            r4 = r2
        L6b:
            i.b.v3.c0.i.b(r5, r4)
        L6e:
            T r4 = r1.element
            i.b.w3.i0 r5 = i.b.v3.c0.n.a
            if (r4 == r5) goto L75
            return r4
        L75:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.a(kotlinx.coroutines.flow.Flow, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @k.e.a.d h.e2.c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r4 = r0.L$4
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2) r4
            java.lang.Object r5 = r0.L$3
            kotlinx.coroutines.flow.Flow r5 = (kotlinx.coroutines.flow.Flow) r5
            java.lang.Object r5 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r1 = r0.L$1
            h.k2.u.p r1 = (h.k2.u.p) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
            h.r0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L3d
            goto L76
        L3d:
            r6 = move-exception
            goto L73
        L3f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L47:
            h.r0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            i.b.w3.i0 r2 = i.b.v3.c0.n.a
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.L$0 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            r0.L$1 = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            r0.L$2 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            r0.L$3 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            r0.L$4 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            java.lang.Object r4 = r4.e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            if (r4 != r1) goto L6b
            return r1
        L6b:
            r1 = r5
            r5 = r6
            goto L76
        L6e:
            r4 = move-exception
            r1 = r5
            r5 = r6
            r6 = r4
            r4 = r2
        L73:
            i.b.v3.c0.i.b(r6, r4)
        L76:
            T r4 = r5.element
            i.b.w3.i0 r5 = i.b.v3.c0.n.a
            if (r4 == r5) goto L7d
            return r4
        L7d:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Expected at least one element matching the predicate "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.b(kotlinx.coroutines.flow.Flow, h.k2.u.p, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object c(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d h.e2.c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.L$3
            kotlinx.coroutines.flow.FlowKt__ReduceKt$b r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.b) r4
            java.lang.Object r1 = r0.L$2
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
            h.r0.n(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L39
            goto L6d
        L39:
            r5 = move-exception
            goto L6a
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            h.r0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            r2 = 0
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$b r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$b
            r2.<init>(r5)
            r0.L$0 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            r0.L$1 = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            r0.L$2 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            r0.L$3 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            java.lang.Object r4 = r4.e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            if (r4 != r1) goto L64
            return r1
        L64:
            r1 = r5
            goto L6d
        L66:
            r4 = move-exception
            r1 = r5
            r5 = r4
            r4 = r2
        L6a:
            i.b.v3.c0.i.b(r5, r4)
        L6d:
            T r4 = r1.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.c(kotlinx.coroutines.flow.Flow, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object d(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @k.e.a.d h.e2.c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r4 = r0.L$4
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) r4
            java.lang.Object r5 = r0.L$3
            kotlinx.coroutines.flow.Flow r5 = (kotlinx.coroutines.flow.Flow) r5
            java.lang.Object r5 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r1 = r0.L$1
            h.k2.u.p r1 = (h.k2.u.p) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
            h.r0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L3d
            goto L73
        L3d:
            r6 = move-exception
            goto L70
        L3f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L47:
            h.r0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r2 = 0
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.L$0 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            r0.L$1 = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            r0.L$2 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            r0.L$3 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            r0.L$4 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            java.lang.Object r4 = r4.e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            if (r4 != r1) goto L6a
            return r1
        L6a:
            r5 = r6
            goto L73
        L6c:
            r4 = move-exception
            r5 = r6
            r6 = r4
            r4 = r2
        L70:
            i.b.v3.c0.i.b(r6, r4)
        L73:
            T r4 = r5.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.d(kotlinx.coroutines.flow.Flow, h.k2.u.p, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, R> java.lang.Object e(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, R r5, @k.e.a.d h.k2.u.q<? super R, ? super T, ? super h.e2.c<? super R>, ? extends java.lang.Object> r6, @k.e.a.d h.e2.c<? super R> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.L$4
            kotlinx.coroutines.flow.Flow r4 = (kotlinx.coroutines.flow.Flow) r4
            java.lang.Object r4 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r0.L$2
            h.k2.u.q r5 = (h.k2.u.q) r5
            java.lang.Object r5 = r0.L$1
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.Flow r5 = (kotlinx.coroutines.flow.Flow) r5
            h.r0.n(r7)
            goto L66
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            h.r0.n(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$1
            r2.<init>(r7, r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.L$3 = r7
            r0.L$4 = r4
            r0.label = r3
            java.lang.Object r4 = r4.e(r2, r0)
            if (r4 != r1) goto L65
            return r1
        L65:
            r4 = r7
        L66:
            T r4 = r4.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.e(kotlinx.coroutines.flow.Flow, java.lang.Object, h.k2.u.q, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @k.e.a.e
    private static final Object f(@k.e.a.d Flow flow, Object obj, @k.e.a.d q qVar, @k.e.a.d h.e2.c cVar) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = obj;
        FlowKt__ReduceKt$fold$$inlined$collect$1 flowKt__ReduceKt$fold$$inlined$collect$1 = new FlowKt__ReduceKt$fold$$inlined$collect$1(objectRef, qVar);
        c0.e(0);
        flow.e(flowKt__ReduceKt$fold$$inlined$collect$1, cVar);
        c0.e(2);
        c0.e(1);
        return objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, i.b.w3.i0] */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <S, T extends S> java.lang.Object g(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d h.k2.u.q<? super S, ? super T, ? super h.e2.c<? super S>, ? extends java.lang.Object> r5, @k.e.a.d h.e2.c<? super S> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r4 = r0.L$3
            kotlinx.coroutines.flow.Flow r4 = (kotlinx.coroutines.flow.Flow) r4
            java.lang.Object r4 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r0.L$1
            h.k2.u.q r5 = (h.k2.u.q) r5
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.Flow r5 = (kotlinx.coroutines.flow.Flow) r5
            h.r0.n(r6)
            goto L64
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            h.r0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            i.b.w3.i0 r2 = i.b.v3.c0.n.a
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1
            r2.<init>(r6, r5)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.L$3 = r4
            r0.label = r3
            java.lang.Object r4 = r4.e(r2, r0)
            if (r4 != r1) goto L63
            return r1
        L63:
            r4 = r6
        L64:
            T r4 = r4.element
            i.b.w3.i0 r5 = i.b.v3.c0.n.a
            if (r4 == r5) goto L6b
            return r4
        L6b:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Empty flow can't be reduced"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.g(kotlinx.coroutines.flow.Flow, h.k2.u.q, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object h(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d h.e2.c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            kotlinx.coroutines.flow.Flow r4 = (kotlinx.coroutines.flow.Flow) r4
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
            h.r0.n(r5)
            goto L5e
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            h.r0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            i.b.w3.i0 r2 = i.b.v3.c0.n.a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$c r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$c
            r2.<init>(r5)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r4
            r0.label = r3
            java.lang.Object r4 = r4.e(r2, r0)
            if (r4 != r1) goto L5d
            return r1
        L5d:
            r4 = r5
        L5e:
            T r4 = r4.element
            i.b.w3.i0 r5 = i.b.v3.c0.n.a
            if (r4 == r5) goto L65
            return r4
        L65:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Flow is empty"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.h(kotlinx.coroutines.flow.Flow, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object i(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d h.e2.c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.L$3
            kotlinx.coroutines.flow.FlowKt__ReduceKt$d r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.d) r4
            java.lang.Object r1 = r0.L$2
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
            h.r0.n(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L39
            goto L6e
        L39:
            r5 = move-exception
            goto L6b
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            h.r0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            i.b.w3.i0 r2 = i.b.v3.c0.n.a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$d r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$d
            r2.<init>(r5)
            r0.L$0 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.L$1 = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.L$2 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.L$3 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            java.lang.Object r4 = r4.e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            if (r4 != r1) goto L65
            return r1
        L65:
            r1 = r5
            goto L6e
        L67:
            r4 = move-exception
            r1 = r5
            r5 = r4
            r4 = r2
        L6b:
            i.b.v3.c0.i.b(r5, r4)
        L6e:
            T r4 = r1.element
            i.b.w3.i0 r5 = i.b.v3.c0.n.a
            if (r4 != r5) goto L75
            r4 = 0
        L75:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.i(kotlinx.coroutines.flow.Flow, h.e2.c):java.lang.Object");
    }
}
