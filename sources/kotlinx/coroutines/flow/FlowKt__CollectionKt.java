package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.t1;
import i.b.v3.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\u001a9\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a=\u0010\r\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00028\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "", "destination", "", "b", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/List;Lh/e2/c;)Ljava/lang/Object;", "", "", f.f10128d, "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Set;Lh/e2/c;)Ljava/lang/Object;", "", "C", am.av, "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Collection;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__CollectionKt {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectionKt$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements i.b.v3.f<T> {
        public final /* synthetic */ Collection a;

        public a(Collection collection) {
            this.a = collection;
        }

        @Override // i.b.v3.f
        @e
        public Object emit(Object obj, @d c cVar) {
            this.a.add(obj);
            return t1.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, C extends java.util.Collection<? super T>> java.lang.Object a(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d C r5, @k.e.a.d h.e2.c<? super C> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 r0 = (kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r4 = r0.L$2
            kotlinx.coroutines.flow.Flow r4 = (kotlinx.coroutines.flow.Flow) r4
            java.lang.Object r4 = r0.L$1
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.Flow r4 = (kotlinx.coroutines.flow.Flow) r4
            h.r0.n(r6)
            goto L55
        L36:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3e:
            h.r0.n(r6)
            kotlinx.coroutines.flow.FlowKt__CollectionKt$a r6 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$a
            r6.<init>(r5)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r4
            r0.label = r3
            java.lang.Object r4 = r4.e(r6, r0)
            if (r4 != r1) goto L55
            return r1
        L55:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.a(kotlinx.coroutines.flow.Flow, java.util.Collection, h.e2.c):java.lang.Object");
    }

    @e
    public static final <T> Object b(@d Flow<? extends T> flow, @d List<T> list, @d c<? super List<? extends T>> cVar) {
        return h.g2(flow, list, cVar);
    }

    public static /* synthetic */ Object c(Flow flow, List list, c cVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = new ArrayList();
        }
        return h.h2(flow, list, cVar);
    }

    @e
    public static final <T> Object d(@d Flow<? extends T> flow, @d Set<T> set, @d c<? super Set<? extends T>> cVar) {
        return h.g2(flow, set, cVar);
    }

    public static /* synthetic */ Object e(Flow flow, Set set, c cVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            set = new LinkedHashSet();
        }
        return h.j2(flow, set, cVar);
    }
}
