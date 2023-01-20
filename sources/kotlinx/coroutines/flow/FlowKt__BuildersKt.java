package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.i;
import h.k2.u.l;
import h.k2.u.p;
import h.o2.k;
import h.o2.n;
import h.q2.m;
import h.t1;
import i.b.n0;
import i.b.r1;
import i.b.s1;
import i.b.t3.c0;
import i.b.t3.w;
import i.b.v3.h;
import i.b.v3.o;
import java.util.Iterator;
import k.e.a.d;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a8\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001a\"\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0019\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b!\u0010\"\u001a#\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b#\u0010\u001d\u001a\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\b*\u00020$¢\u0006\u0004\b&\u0010'\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\b*\u00020(¢\u0006\u0004\b*\u0010+\u001a\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020%0\b*\u00020,¢\u0006\u0004\b-\u0010.\u001a\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020)0\b*\u00020/¢\u0006\u0004\b0\u00101\u001a[\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u00102\u001a\u00020%24\b\u0001\u0010\u0007\u001a.\u0012\u0004\u0012\u000203\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u000004¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b8\u00109\u001aO\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b;\u0010\n\u001aO\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Li/b/v3/f;", "Lh/e2/c;", "Lh/t1;", "", "Lh/q;", ReportItem.LogTypeBlock, "Lkotlinx/coroutines/flow/Flow;", "n", "(Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function0;", "c", "(Lh/k2/u/a;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", f.f10128d, "(Lh/k2/u/l;)Lkotlinx/coroutines/flow/Flow;", "", am.av, "(Ljava/lang/Iterable;)Lkotlinx/coroutines/flow/Flow;", "", "b", "(Ljava/util/Iterator;)Lkotlinx/coroutines/flow/Flow;", "Lh/q2/m;", "g", "(Lh/q2/m;)Lkotlinx/coroutines/flow/Flow;", "", MessageKey.CUSTOM_LAYOUT_ELEMENTS, am.ax, "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "value", "o", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "m", "()Lkotlinx/coroutines/flow/Flow;", "j", "", "", "h", "([I)Lkotlinx/coroutines/flow/Flow;", "", "", "i", "([J)Lkotlinx/coroutines/flow/Flow;", "Lh/o2/k;", e.a, "(Lh/o2/k;)Lkotlinx/coroutines/flow/Flow;", "Lh/o2/n;", "f", "(Lh/o2/n;)Lkotlinx/coroutines/flow/Flow;", "bufferSize", "Li/b/n0;", "Li/b/t3/c0;", "Lh/k0;", "name", "channel", "q", "(ILh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "Li/b/t3/w;", NotifyType.LIGHTS, "k", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__BuildersKt {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt$a", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements Flow<T> {
        public final /* synthetic */ h.k2.u.a a;

        public a(h.k2.u.a aVar) {
            this.a = aVar;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @k.e.a.e
        public Object e(@d i.b.v3.f fVar, @d c cVar) {
            Object emit = fVar.emit(this.a.invoke(), cVar);
            return emit == h.e2.j.b.h() ? emit : t1.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt$b", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b implements Flow<T> {
        public final /* synthetic */ Object a;

        public b(Object obj) {
            this.a = obj;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @k.e.a.e
        public Object e(@d i.b.v3.f fVar, @d c cVar) {
            Object emit = fVar.emit(this.a, cVar);
            return emit == h.e2.j.b.h() ? emit : t1.a;
        }
    }

    @d
    public static final <T> Flow<T> a(@d Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    @d
    public static final <T> Flow<T> b(@d Iterator<? extends T> it) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it);
    }

    @s1
    @d
    public static final <T> Flow<T> c(@d h.k2.u.a<? extends T> aVar) {
        return new a(aVar);
    }

    @s1
    @d
    public static final <T> Flow<T> d(@d l<? super c<? super T>, ? extends Object> lVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(lVar);
    }

    @d
    public static final Flow<Integer> e(@d k kVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(kVar);
    }

    @d
    public static final Flow<Long> f(@d n nVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(nVar);
    }

    @d
    public static final <T> Flow<T> g(@d m<? extends T> mVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(mVar);
    }

    @d
    public static final Flow<Integer> h(@d int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    @d
    public static final Flow<Long> i(@d long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    @d
    public static final <T> Flow<T> j(@d T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    @r1
    @d
    public static final <T> Flow<T> k(@h.b @d p<? super w<? super T>, ? super c<? super t1>, ? extends Object> pVar) {
        return new CallbackFlowBuilder(pVar, null, 0, null, 14, null);
    }

    @r1
    @d
    public static final <T> Flow<T> l(@h.b @d p<? super w<? super T>, ? super c<? super t1>, ? extends Object> pVar) {
        return new i.b.v3.d(pVar, null, 0, null, 14, null);
    }

    @d
    public static final <T> Flow<T> m() {
        return i.b.v3.e.a;
    }

    @d
    public static final <T> Flow<T> n(@h.b @d p<? super i.b.v3.f<? super T>, ? super c<? super t1>, ? extends Object> pVar) {
        return new o(pVar);
    }

    @d
    public static final <T> Flow<T> o(T t) {
        return new b(t);
    }

    @d
    public static final <T> Flow<T> p(@d T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }

    @s1
    @i(level = DeprecationLevel.ERROR, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    @d
    public static final <T> Flow<T> q(int i2, @h.b @d p<? super n0, ? super c0<? super T>, t1> pVar) {
        Flow<T> d2;
        d2 = i.b.v3.i.d(h.y(new FlowKt__BuildersKt$flowViaChannel$1(pVar, null)), i2, null, 2, null);
        return d2;
    }

    public static /* synthetic */ Flow r(int i2, p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -2;
        }
        return h.T0(i2, pVar);
    }
}
