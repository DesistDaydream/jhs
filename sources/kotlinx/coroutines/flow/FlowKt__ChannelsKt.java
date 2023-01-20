package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.e2.j.b;
import h.q0;
import h.t1;
import i.b.n0;
import i.b.s1;
import i.b.t3.i;
import i.b.t3.y;
import i.b.v3.h;
import k.e.a.d;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineStart;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a#\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u000e\u0010\r\u001a%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "Li/b/t3/y;", "channel", "Lh/t1;", e.a, "(Li/b/v3/f;Li/b/t3/y;Lh/e2/c;)Ljava/lang/Object;", "", "consume", "f", "(Li/b/v3/f;Li/b/t3/y;ZLh/e2/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "h", "(Li/b/t3/y;)Lkotlinx/coroutines/flow/Flow;", f.f10128d, "Li/b/t3/i;", am.av, "(Li/b/t3/i;)Lkotlinx/coroutines/flow/Flow;", "Li/b/n0;", "scope", "Lkotlinx/coroutines/CoroutineStart;", MessageKey.MSG_ACCEPT_TIME_START, "b", "(Lkotlinx/coroutines/flow/Flow;Li/b/n0;Lkotlinx/coroutines/CoroutineStart;)Li/b/t3/i;", "g", "(Lkotlinx/coroutines/flow/Flow;Li/b/n0;)Li/b/t3/y;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ChannelsKt$a", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements Flow<T> {
        public final /* synthetic */ i a;

        public a(i iVar) {
            this.a = iVar;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @k.e.a.e
        public Object e(@d i.b.v3.f fVar, @d c cVar) {
            Object q0 = h.q0(fVar, this.a.v(), cVar);
            return q0 == b.h() ? q0 : t1.a;
        }
    }

    @s1
    @d
    public static final <T> Flow<T> a(@d i<T> iVar) {
        return new a(iVar);
    }

    @h.i(level = DeprecationLevel.WARNING, message = "Use shareIn operator and the resulting SharedFlow as a replacement for BroadcastChannel", replaceWith = @q0(expression = "shareIn(scope, 0, SharingStarted.Lazily)", imports = {}))
    @d
    public static final <T> i<T> b(@d Flow<? extends T> flow, @d n0 n0Var, @d CoroutineStart coroutineStart) {
        return i.b.v3.c0.e.b(flow).i(n0Var, coroutineStart);
    }

    public static /* synthetic */ i c(Flow flow, n0 n0Var, CoroutineStart coroutineStart, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return h.n(flow, n0Var, coroutineStart);
    }

    @d
    public static final <T> Flow<T> d(@d y<? extends T> yVar) {
        return new i.b.v3.c(yVar, true, null, 0, null, 28, null);
    }

    @k.e.a.e
    public static final <T> Object e(@d i.b.v3.f<? super T> fVar, @d y<? extends T> yVar, @d c<? super t1> cVar) {
        Object f2 = f(fVar, yVar, true, cVar);
        return f2 == b.h() ? f2 : t1.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0085 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {all -> 0x005f, blocks: (B:65:0x0038, B:79:0x007f, B:81:0x0085, B:87:0x0093, B:88:0x0094, B:70:0x005b), top: B:102:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0094 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {all -> 0x005f, blocks: (B:65:0x0038, B:79:0x007f, B:81:0x0085, B:87:0x0093, B:88:0x0094, B:70:0x005b), top: B:102:0x0022 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2, types: [i.b.t3.y] */
    /* JADX WARN: Type inference failed for: r10v3, types: [i.b.t3.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x00a8 -> B:66:0x003b). Please submit an issue!!! */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ <T> java.lang.Object f(@k.e.a.d i.b.v3.f<? super T> r8, @k.e.a.d i.b.t3.y<? extends T> r9, boolean r10, @k.e.a.d h.e2.c<? super h.t1> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L61
            if (r2 == r4) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r8 = r0.L$3
            java.lang.Object r8 = r0.L$2
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            i.b.t3.y r10 = (i.b.t3.y) r10
            java.lang.Object r2 = r0.L$0
            i.b.v3.f r2 = (i.b.v3.f) r2
            h.r0.n(r11)     // Catch: java.lang.Throwable -> L5f
        L3b:
            r11 = r8
            r8 = r2
            r6 = r10
            r10 = r9
            r9 = r6
            goto L65
        L41:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L49:
            java.lang.Object r8 = r0.L$3
            i.b.v3.f r8 = (i.b.v3.f) r8
            java.lang.Object r8 = r0.L$2
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            i.b.t3.y r10 = (i.b.t3.y) r10
            java.lang.Object r2 = r0.L$0
            i.b.v3.f r2 = (i.b.v3.f) r2
            h.r0.n(r11)     // Catch: java.lang.Throwable -> L5f
            goto L7f
        L5f:
            r8 = move-exception
            goto Laf
        L61:
            h.r0.n(r11)
            r11 = 0
        L65:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> Lab
            r0.L$1 = r9     // Catch: java.lang.Throwable -> Lab
            r0.Z$0 = r10     // Catch: java.lang.Throwable -> Lab
            r0.L$2 = r11     // Catch: java.lang.Throwable -> Lab
            r0.L$3 = r8     // Catch: java.lang.Throwable -> Lab
            r0.label = r4     // Catch: java.lang.Throwable -> Lab
            java.lang.Object r2 = r9.y(r0)     // Catch: java.lang.Throwable -> Lab
            if (r2 != r1) goto L78
            return r1
        L78:
            r6 = r2
            r2 = r8
            r8 = r11
            r11 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L7f:
            boolean r5 = i.b.t3.g0.l(r11)     // Catch: java.lang.Throwable -> L5f
            if (r5 == 0) goto L94
            java.lang.Throwable r11 = i.b.t3.g0.f(r11)     // Catch: java.lang.Throwable -> L5f
            if (r11 != 0) goto L93
            if (r9 == 0) goto L90
            i.b.t3.o.r(r10, r8)
        L90:
            h.t1 r8 = h.t1.a
            return r8
        L93:
            throw r11     // Catch: java.lang.Throwable -> L5f
        L94:
            java.lang.Object r5 = i.b.t3.g0.h(r11)     // Catch: java.lang.Throwable -> L5f
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L5f
            r0.L$1 = r10     // Catch: java.lang.Throwable -> L5f
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L5f
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L5f
            r0.L$3 = r11     // Catch: java.lang.Throwable -> L5f
            r0.label = r3     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r11 = r2.emit(r5, r0)     // Catch: java.lang.Throwable -> L5f
            if (r11 != r1) goto L3b
            return r1
        Lab:
            r8 = move-exception
            r6 = r10
            r10 = r9
            r9 = r6
        Laf:
            throw r8     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            r11 = move-exception
            if (r9 == 0) goto Lb6
            i.b.t3.o.r(r10, r8)
        Lb6:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.f(i.b.v3.f, i.b.t3.y, boolean, h.e2.c):java.lang.Object");
    }

    @s1
    @d
    public static final <T> y<T> g(@d Flow<? extends T> flow, @d n0 n0Var) {
        return i.b.v3.c0.e.b(flow).p(n0Var);
    }

    @d
    public static final <T> Flow<T> h(@d y<? extends T> yVar) {
        return new i.b.v3.c(yVar, false, null, 0, null, 28, null);
    }
}
