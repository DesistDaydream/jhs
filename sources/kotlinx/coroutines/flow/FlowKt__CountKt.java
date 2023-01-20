package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.e2.c;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a#\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aG\u0010\n\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "", am.av, "(Lkotlinx/coroutines/flow/Flow;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lh/e2/c;", "", "", "predicate", "b", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__CountKt {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CountKt$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements f<T> {
        public final /* synthetic */ Ref.IntRef a;

        public a(Ref.IntRef intRef) {
            this.a = intRef;
        }

        @Override // i.b.v3.f
        @e
        public Object emit(Object obj, @d c cVar) {
            this.a.element++;
            return t1.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d h.e2.c<? super java.lang.Integer> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__CountKt$count$1 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$1 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$1
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
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
            h.r0.n(r5)
            goto L5d
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            h.r0.n(r5)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            r2 = 0
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__CountKt$a r2 = new kotlinx.coroutines.flow.FlowKt__CountKt$a
            r2.<init>(r5)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r4
            r0.label = r3
            java.lang.Object r4 = r4.e(r2, r0)
            if (r4 != r1) goto L5c
            return r1
        L5c:
            r4 = r5
        L5d:
            int r4 = r4.element
            java.lang.Integer r4 = h.e2.k.a.a.f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt.a(kotlinx.coroutines.flow.Flow, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @k.e.a.d h.e2.c<? super java.lang.Integer> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$3
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CountKt$count$3 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$3 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$3
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
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r0.L$1
            h.k2.u.p r5 = (h.k2.u.p) r5
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.Flow r5 = (kotlinx.coroutines.flow.Flow) r5
            h.r0.n(r6)
            goto L63
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            h.r0.n(r6)
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef
            r6.<init>()
            r2 = 0
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2 r2 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2
            r2.<init>(r5, r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.L$3 = r4
            r0.label = r3
            java.lang.Object r4 = r4.e(r2, r0)
            if (r4 != r1) goto L62
            return r1
        L62:
            r4 = r6
        L63:
            int r4 = r4.element
            java.lang.Integer r4 = h.e2.k.a.a.f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt.b(kotlinx.coroutines.flow.Flow, h.k2.u.p, h.e2.c):java.lang.Object");
    }
}
