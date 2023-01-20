package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\r\u001a\u00020\f2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0001\"\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\n0\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Li/b/u0;", "deferreds", "", "b", "([Lkotlinx/coroutines/Deferred;Lh/e2/c;)Ljava/lang/Object;", "", am.av, "(Ljava/util/Collection;Lh/e2/c;)Ljava/lang/Object;", "Li/b/b2;", "jobs", "Lh/t1;", f.f10128d, "([Lkotlinx/coroutines/Job;Lh/e2/c;)Ljava/lang/Object;", "c", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class AwaitKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(@k.e.a.d java.util.Collection<? extends i.b.u0<? extends T>> r5, @k.e.a.d h.e2.c<? super java.util.List<? extends T>> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.AwaitKt$awaitAll$2
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.AwaitKt$awaitAll$2 r0 = (kotlinx.coroutines.AwaitKt$awaitAll$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.AwaitKt$awaitAll$2 r0 = new kotlinx.coroutines.AwaitKt$awaitAll$2
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            java.util.Collection r5 = (java.util.Collection) r5
            h.r0.n(r6)
            goto L61
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            h.r0.n(r6)
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L43
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.E()
            goto L64
        L43:
            i.b.c r6 = new i.b.c
            r2 = 0
            i.b.u0[] r2 = new i.b.u0[r2]
            java.lang.Object[] r2 = r5.toArray(r2)
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Array<T>"
            java.util.Objects.requireNonNull(r2, r4)
            i.b.u0[] r2 = (i.b.u0[]) r2
            r6.<init>(r2)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.b(r0)
            if (r6 != r1) goto L61
            return r1
        L61:
            r5 = r6
            java.util.List r5 = (java.util.List) r5
        L64:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.a(java.util.Collection, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(@k.e.a.d i.b.u0<? extends T>[] r4, @k.e.a.d h.e2.c<? super java.util.List<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.AwaitKt$awaitAll$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.AwaitKt$awaitAll$1 r0 = (kotlinx.coroutines.AwaitKt$awaitAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.AwaitKt$awaitAll$1 r0 = new kotlinx.coroutines.AwaitKt$awaitAll$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            i.b.u0[] r4 = (i.b.u0[]) r4
            h.r0.n(r5)
            goto L55
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            h.r0.n(r5)
            int r5 = r4.length
            if (r5 != 0) goto L3d
            r5 = 1
            goto L3e
        L3d:
            r5 = 0
        L3e:
            if (r5 == 0) goto L45
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.E()
            goto L58
        L45:
            i.b.c r5 = new i.b.c
            r5.<init>(r4)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.b(r0)
            if (r5 != r1) goto L55
            return r1
        L55:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
        L58:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.b(i.b.u0[], h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(@k.e.a.d java.util.Collection<? extends i.b.b2> r7, @k.e.a.d h.e2.c<? super h.t1> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.AwaitKt$joinAll$3
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = (kotlinx.coroutines.AwaitKt$joinAll$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = new kotlinx.coroutines.AwaitKt$joinAll$3
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r7 = r0.L$4
            i.b.b2 r7 = (i.b.b2) r7
            java.lang.Object r7 = r0.L$3
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r4 = r0.L$0
            java.util.Collection r4 = (java.util.Collection) r4
            h.r0.n(r8)
            r8 = r4
            r6 = r1
            r1 = r0
            r0 = r2
            r2 = r6
            goto L54
        L40:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L48:
            h.r0.n(r8)
            java.util.Iterator r8 = r7.iterator()
            r2 = r1
            r1 = r0
            r0 = r7
            r7 = r8
            r8 = r0
        L54:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L74
            java.lang.Object r4 = r7.next()
            r5 = r4
            i.b.b2 r5 = (i.b.b2) r5
            r1.L$0 = r8
            r1.L$1 = r0
            r1.L$2 = r7
            r1.L$3 = r4
            r1.L$4 = r5
            r1.label = r3
            java.lang.Object r4 = r5.Y(r1)
            if (r4 != r2) goto L54
            return r2
        L74:
            h.t1 r7 = h.t1.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.c(java.util.Collection, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0073 -> B:19:0x0076). Please submit an issue!!! */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(@k.e.a.d i.b.b2[] r7, @k.e.a.d h.e2.c<? super h.t1> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.AwaitKt$joinAll$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.AwaitKt$joinAll$1 r0 = (kotlinx.coroutines.AwaitKt$joinAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.AwaitKt$joinAll$1 r0 = new kotlinx.coroutines.AwaitKt$joinAll$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4f
            if (r2 != r3) goto L47
            java.lang.Object r7 = r0.L$4
            i.b.b2 r7 = (i.b.b2) r7
            java.lang.Object r7 = r0.L$3
            i.b.b2 r7 = (i.b.b2) r7
            int r7 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$2
            i.b.b2[] r4 = (i.b.b2[]) r4
            java.lang.Object r5 = r0.L$1
            i.b.b2[] r5 = (i.b.b2[]) r5
            java.lang.Object r6 = r0.L$0
            i.b.b2[] r6 = (i.b.b2[]) r6
            h.r0.n(r8)
            r8 = r4
            r4 = r1
            r1 = r5
            r5 = r2
            r2 = r0
            r0 = r6
            goto L76
        L47:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L4f:
            h.r0.n(r8)
            int r8 = r7.length
            r2 = 0
            r5 = r8
            r2 = r0
            r4 = r1
            r8 = r7
            r0 = r8
            r1 = r0
            r7 = 0
        L5b:
            if (r7 >= r5) goto L78
            r6 = r8[r7]
            r2.L$0 = r0
            r2.L$1 = r1
            r2.L$2 = r8
            r2.I$0 = r5
            r2.I$1 = r7
            r2.L$3 = r6
            r2.L$4 = r6
            r2.label = r3
            java.lang.Object r6 = r6.Y(r2)
            if (r6 != r4) goto L76
            return r4
        L76:
            int r7 = r7 + r3
            goto L5b
        L78:
            h.t1 r7 = h.t1.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.d(i.b.b2[], h.e2.c):java.lang.Object");
    }
}
