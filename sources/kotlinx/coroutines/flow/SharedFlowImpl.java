package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.k2.d;
import h.k2.v.f0;
import h.t1;
import i.b.e1;
import i.b.o;
import i.b.q0;
import i.b.v3.c0.b;
import i.b.v3.k;
import i.b.v3.q;
import i.b.v3.r;
import i.b.v3.s;
import i.b.w3.i0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0010\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001OB\u001f\u0012\u0006\u0010^\u001a\u00020\u0019\u0012\u0006\u0010X\u001a\u00020\u0019\u0012\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bo\u0010pJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00172\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u0001\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J/\u0010%\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010\u000eJ\u0019\u0010)\u001a\u0004\u0018\u00010\u00132\u0006\u0010(\u001a\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0003H\u0002¢\u0006\u0004\b+\u0010,J\u0019\u0010.\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020\u000fH\u0002¢\u0006\u0004\b.\u0010/J3\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u0001000\u00172\u0014\u00101\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u0001000\u0017H\u0002¢\u0006\u0004\b2\u00103J!\u00106\u001a\u00020\f2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0096@ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b8\u0010\nJ\u001b\u00109\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\u000fH\u0000¢\u0006\u0004\b<\u0010=J%\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u0001000\u00172\u0006\u0010>\u001a\u00020\u000fH\u0000¢\u0006\u0004\b?\u0010@J\u001b\u0010A\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0003H\u0014¢\u0006\u0004\bC\u0010DJ\u001f\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00172\u0006\u0010E\u001a\u00020\u0019H\u0014¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\fH\u0016¢\u0006\u0004\bH\u0010\u000eJ-\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000N2\u0006\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00192\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\u00198B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010\rR\u0016\u0010V\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010\rR\u0016\u0010X\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010FR\u0016\u0010Z\u001a\u00020\u00198B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010RR\u0016\u0010\\\u001a\u00020\u000f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010=R\u0016\u0010^\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010FR\u0016\u0010`\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010FR\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00000a8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010h\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010FR\u0016\u0010j\u001a\u00020\u000f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bi\u0010=R\u0016\u0010l\u001a\u00020\u000f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010=R \u0010n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010m\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006q"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/c0/a;", "Li/b/v3/s;", "Li/b/v3/k;", "Li/b/v3/a;", "Li/b/v3/c0/k;", "value", "", "U", "(Ljava/lang/Object;)Z", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lh/t1;", "J", "()V", "", "newHead", "G", "(J)V", "", "item", "L", "(Ljava/lang/Object;)V", "", "curBuffer", "", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlowImpl$a;", "emitter", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/coroutines/flow/SharedFlowImpl$a;)V", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "Y", "(JJJJ)V", "F", "slot", "X", "(Li/b/v3/s;)Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "(Li/b/v3/s;)J", "index", "P", "(J)Ljava/lang/Object;", "Lh/e2/c;", "resumesIn", "M", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "Li/b/v3/f;", "collector", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "b", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "K", "a0", "()J", "oldIndex", "Z", "(J)[Lkotlin/coroutines/Continuation;", "D", "(Li/b/v3/s;Lh/e2/c;)Ljava/lang/Object;", "H", "()Li/b/v3/s;", "size", ExpandableTextView.P, "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "g", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", am.av, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "R", "()I", "replaySize", "f", "replayIndex", "minCollectorIndex", "k", "bufferCapacity", ExifInterface.LATITUDE_SOUTH, "totalSize", "Q", "queueEndIndex", "j", "replay", "h", "bufferSize", "", f.f10128d, "()Ljava/util/List;", "replayCache", NotifyType.LIGHTS, "Lkotlinx/coroutines/channels/BufferOverflow;", "i", "queueSize", "N", "bufferEndIndex", "O", "head", "[Ljava/lang/Object;", "buffer", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class SharedFlowImpl<T> extends i.b.v3.c0.a<s> implements k<T>, i.b.v3.a<T>, i.b.v3.c0.k<T> {

    /* renamed from: e  reason: collision with root package name */
    private Object[] f16958e;

    /* renamed from: f  reason: collision with root package name */
    private long f16959f;

    /* renamed from: g  reason: collision with root package name */
    private long f16960g;

    /* renamed from: h  reason: collision with root package name */
    private int f16961h;

    /* renamed from: i  reason: collision with root package name */
    private int f16962i;

    /* renamed from: j  reason: collision with root package name */
    private final int f16963j;

    /* renamed from: k  reason: collision with root package name */
    private final int f16964k;

    /* renamed from: l  reason: collision with root package name */
    private final BufferOverflow f16965l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"kotlinx/coroutines/flow/SharedFlowImpl$a", "Li/b/e1;", "Lh/t1;", "dispose", "()V", "", "b", "J", "index", "Lkotlinx/coroutines/flow/SharedFlowImpl;", am.av, "Lkotlinx/coroutines/flow/SharedFlowImpl;", "flow", "", "c", "Ljava/lang/Object;", "value", "Lh/e2/c;", f.f10128d, "Lh/e2/c;", "cont", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lh/e2/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements e1 {
        @d
        @k.e.a.d
        public final SharedFlowImpl<?> a;
        @d
        public long b;
        @d
        @k.e.a.e

        /* renamed from: c  reason: collision with root package name */
        public final Object f16966c;
        @d
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        public final c<t1> f16967d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@k.e.a.d SharedFlowImpl<?> sharedFlowImpl, long j2, @k.e.a.e Object obj, @k.e.a.d c<? super t1> cVar) {
            this.a = sharedFlowImpl;
            this.b = j2;
            this.f16966c = obj;
            this.f16967d = cVar;
        }

        @Override // i.b.e1
        public void dispose() {
            this.a.E(this);
        }
    }

    public SharedFlowImpl(int i2, int i3, @k.e.a.d BufferOverflow bufferOverflow) {
        this.f16963j = i2;
        this.f16964k = i3;
        this.f16965l = bufferOverflow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(a aVar) {
        Object f2;
        synchronized (this) {
            if (aVar.b < O()) {
                return;
            }
            Object[] objArr = this.f16958e;
            f2 = r.f(objArr, aVar.b);
            if (f2 != aVar) {
                return;
            }
            r.h(objArr, aVar.b, r.a);
            F();
            t1 t1Var = t1.a;
        }
    }

    private final void F() {
        Object f2;
        if (this.f16964k != 0 || this.f16962i > 1) {
            Object[] objArr = this.f16958e;
            while (this.f16962i > 0) {
                f2 = r.f(objArr, (O() + S()) - 1);
                if (f2 != r.a) {
                    return;
                }
                this.f16962i--;
                r.h(objArr, O() + S(), null);
            }
        }
    }

    private final void G(long j2) {
        i.b.v3.c0.c[] cVarArr;
        if (((i.b.v3.c0.a) this).b != 0 && (cVarArr = ((i.b.v3.c0.a) this).a) != null) {
            for (i.b.v3.c0.c cVar : cVarArr) {
                if (cVar != null) {
                    s sVar = (s) cVar;
                    long j3 = sVar.a;
                    if (j3 >= 0 && j3 < j2) {
                        sVar.a = j2;
                    }
                }
            }
        }
        this.f16960g = j2;
    }

    private final void J() {
        r.h(this.f16958e, O(), null);
        this.f16961h--;
        long O = O() + 1;
        if (this.f16959f < O) {
            this.f16959f = O;
        }
        if (this.f16960g < O) {
            G(O);
        }
        if (q0.b()) {
            if (!(O() == O)) {
                throw new AssertionError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(Object obj) {
        int S = S();
        Object[] objArr = this.f16958e;
        if (objArr == null) {
            objArr = T(null, 0, 2);
        } else if (S >= objArr.length) {
            objArr = T(objArr, S, objArr.length * 2);
        }
        r.h(objArr, O() + S, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final c<t1>[] M(c<t1>[] cVarArr) {
        i.b.v3.c0.c[] cVarArr2;
        s sVar;
        c<? super t1> cVar;
        int length = cVarArr.length;
        if (((i.b.v3.c0.a) this).b != 0 && (cVarArr2 = ((i.b.v3.c0.a) this).a) != null) {
            int length2 = cVarArr2.length;
            int i2 = 0;
            cVarArr = cVarArr;
            while (i2 < length2) {
                i.b.v3.c0.c cVar2 = cVarArr2[i2];
                if (cVar2 != null && (cVar = (sVar = (s) cVar2).b) != null && W(sVar) >= 0) {
                    int length3 = cVarArr.length;
                    cVarArr = cVarArr;
                    if (length >= length3) {
                        cVarArr = (c[]) Arrays.copyOf(cVarArr, Math.max(2, cVarArr.length * 2));
                    }
                    cVarArr[length] = cVar;
                    sVar.b = null;
                    length++;
                }
                i2++;
                cVarArr = cVarArr;
            }
        }
        return cVarArr;
    }

    private final long N() {
        return O() + this.f16961h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long O() {
        return Math.min(this.f16960g, this.f16959f);
    }

    private final Object P(long j2) {
        Object f2;
        f2 = r.f(this.f16958e, j2);
        return f2 instanceof a ? ((a) f2).f16966c : f2;
    }

    private final long Q() {
        return O() + this.f16961h + this.f16962i;
    }

    private final int R() {
        return (int) ((O() + this.f16961h) - this.f16959f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S() {
        return this.f16961h + this.f16962i;
    }

    private final Object[] T(Object[] objArr, int i2, int i3) {
        Object f2;
        if (i3 > 0) {
            Object[] objArr2 = new Object[i3];
            this.f16958e = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long O = O();
            for (int i4 = 0; i4 < i2; i4++) {
                long j2 = i4 + O;
                f2 = r.f(objArr, j2);
                r.h(objArr2, j2, f2);
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U(T t) {
        if (q() == 0) {
            return V(t);
        }
        if (this.f16961h >= this.f16964k && this.f16960g <= this.f16959f) {
            int i2 = q.a[this.f16965l.ordinal()];
            if (i2 == 1) {
                return false;
            }
            if (i2 == 2) {
                return true;
            }
        }
        L(t);
        int i3 = this.f16961h + 1;
        this.f16961h = i3;
        if (i3 > this.f16964k) {
            J();
        }
        if (R() > this.f16963j) {
            Y(this.f16959f + 1, this.f16960g, N(), Q());
        }
        return true;
    }

    private final boolean V(T t) {
        if (q0.b()) {
            if (!(q() == 0)) {
                throw new AssertionError();
            }
        }
        if (this.f16963j == 0) {
            return true;
        }
        L(t);
        int i2 = this.f16961h + 1;
        this.f16961h = i2;
        if (i2 > this.f16963j) {
            J();
        }
        this.f16960g = O() + this.f16961h;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long W(s sVar) {
        long j2 = sVar.a;
        if (j2 < N()) {
            return j2;
        }
        if (this.f16964k <= 0 && j2 <= O() && this.f16962i != 0) {
            return j2;
        }
        return -1L;
    }

    private final Object X(s sVar) {
        Object obj;
        c<t1>[] cVarArr = b.a;
        synchronized (this) {
            long W = W(sVar);
            if (W < 0) {
                obj = r.a;
            } else {
                long j2 = sVar.a;
                Object P = P(W);
                sVar.a = W + 1;
                cVarArr = Z(j2);
                obj = P;
            }
        }
        for (c<t1> cVar : cVarArr) {
            if (cVar != null) {
                t1 t1Var = t1.a;
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m106constructorimpl(t1Var));
            }
        }
        return obj;
    }

    private final void Y(long j2, long j3, long j4, long j5) {
        long min = Math.min(j3, j2);
        if (q0.b()) {
            if (!(min >= O())) {
                throw new AssertionError();
            }
        }
        for (long O = O(); O < min; O++) {
            r.h(this.f16958e, O, null);
        }
        this.f16959f = j2;
        this.f16960g = j3;
        this.f16961h = (int) (j4 - min);
        this.f16962i = (int) (j5 - j4);
        if (q0.b()) {
            if (!(this.f16961h >= 0)) {
                throw new AssertionError();
            }
        }
        if (q0.b()) {
            if (!(this.f16962i >= 0)) {
                throw new AssertionError();
            }
        }
        if (q0.b()) {
            if (!(this.f16959f <= O() + ((long) this.f16961h))) {
                throw new AssertionError();
            }
        }
    }

    @k.e.a.e
    public final /* synthetic */ Object D(@k.e.a.d s sVar, @k.e.a.d c<? super t1> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        synchronized (this) {
            if (W(sVar) < 0) {
                sVar.b = oVar;
                sVar.b = oVar;
            } else {
                t1 t1Var = t1.a;
                Result.a aVar = Result.Companion;
                oVar.resumeWith(Result.m106constructorimpl(t1Var));
            }
            t1 t1Var2 = t1.a;
        }
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    @Override // i.b.v3.c0.a
    @k.e.a.d
    /* renamed from: H */
    public s m() {
        return new s();
    }

    @Override // i.b.v3.c0.a
    @k.e.a.d
    /* renamed from: I */
    public s[] n(int i2) {
        return new s[i2];
    }

    @k.e.a.e
    public final /* synthetic */ Object K(T t, @k.e.a.d c<? super t1> cVar) {
        c<t1>[] cVarArr;
        a aVar;
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        c<t1>[] cVarArr2 = b.a;
        synchronized (this) {
            if (U(t)) {
                t1 t1Var = t1.a;
                Result.a aVar2 = Result.Companion;
                oVar.resumeWith(Result.m106constructorimpl(t1Var));
                cVarArr = M(cVarArr2);
                aVar = null;
            } else {
                a aVar3 = new a(this, S() + O(), t, oVar);
                L(aVar3);
                this.f16962i++;
                if (this.f16964k == 0) {
                    cVarArr2 = M(cVarArr2);
                }
                cVarArr = cVarArr2;
                aVar = aVar3;
            }
        }
        if (aVar != null) {
            i.b.q.a(oVar, aVar);
        }
        for (c<t1> cVar2 : cVarArr) {
            if (cVar2 != null) {
                t1 t1Var2 = t1.a;
                Result.a aVar4 = Result.Companion;
                cVar2.resumeWith(Result.m106constructorimpl(t1Var2));
            }
        }
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    @k.e.a.d
    public final c<t1>[] Z(long j2) {
        int i2;
        long j3;
        Object f2;
        Object f3;
        long j4;
        i.b.v3.c0.c[] cVarArr;
        if (q0.b()) {
            if (!(j2 >= this.f16960g)) {
                throw new AssertionError();
            }
        }
        if (j2 > this.f16960g) {
            return b.a;
        }
        long O = O();
        long j5 = this.f16961h + O;
        if (this.f16964k == 0 && this.f16962i > 0) {
            j5++;
        }
        if (((i.b.v3.c0.a) this).b != 0 && (cVarArr = ((i.b.v3.c0.a) this).a) != null) {
            for (i.b.v3.c0.c cVar : cVarArr) {
                if (cVar != null) {
                    long j6 = ((s) cVar).a;
                    if (j6 >= 0 && j6 < j5) {
                        j5 = j6;
                    }
                }
            }
        }
        if (q0.b()) {
            if (!(j5 >= this.f16960g)) {
                throw new AssertionError();
            }
        }
        if (j5 <= this.f16960g) {
            return b.a;
        }
        long N = N();
        if (q() > 0) {
            i2 = Math.min(this.f16962i, this.f16964k - ((int) (N - j5)));
        } else {
            i2 = this.f16962i;
        }
        c<t1>[] cVarArr2 = b.a;
        long j7 = this.f16962i + N;
        if (i2 > 0) {
            cVarArr2 = new c[i2];
            Object[] objArr = this.f16958e;
            long j8 = N;
            int i3 = 0;
            while (true) {
                if (N >= j7) {
                    j3 = j5;
                    break;
                }
                f3 = r.f(objArr, N);
                i0 i0Var = r.a;
                j3 = j5;
                if (f3 != i0Var) {
                    Objects.requireNonNull(f3, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) f3;
                    int i4 = i3 + 1;
                    cVarArr2[i3] = aVar.f16967d;
                    r.h(objArr, N, i0Var);
                    r.h(objArr, j8, aVar.f16966c);
                    j4 = 1;
                    j8++;
                    if (i4 >= i2) {
                        break;
                    }
                    i3 = i4;
                } else {
                    j4 = 1;
                }
                N += j4;
                j5 = j3;
            }
            N = j8;
        } else {
            j3 = j5;
        }
        int i5 = (int) (N - O);
        long j9 = q() == 0 ? N : j3;
        long max = Math.max(this.f16959f, N - Math.min(this.f16963j, i5));
        if (this.f16964k == 0 && max < j7) {
            f2 = r.f(this.f16958e, max);
            if (f0.g(f2, r.a)) {
                N++;
                max++;
            }
        }
        Y(max, j9, N, j7);
        F();
        return true ^ (cVarArr2.length == 0) ? M(cVarArr2) : cVarArr2;
    }

    @Override // i.b.v3.c0.k
    @k.e.a.d
    public Flow<T> a(@k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        return r.e(this, coroutineContext, i2, bufferOverflow);
    }

    public final long a0() {
        long j2 = this.f16959f;
        if (j2 < this.f16960g) {
            this.f16960g = j2;
        }
        return j2;
    }

    @Override // i.b.v3.k
    public boolean b(T t) {
        int i2;
        boolean z;
        c<t1>[] cVarArr = b.a;
        synchronized (this) {
            if (U(t)) {
                cVarArr = M(cVarArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (c<t1> cVar : cVarArr) {
            if (cVar != null) {
                t1 t1Var = t1.a;
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m106constructorimpl(t1Var));
            }
        }
        return z;
    }

    @Override // i.b.v3.p
    @k.e.a.d
    public List<T> d() {
        Object f2;
        synchronized (this) {
            int R = R();
            if (R == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            ArrayList arrayList = new ArrayList(R);
            Object[] objArr = this.f16958e;
            for (int i2 = 0; i2 < R; i2++) {
                f2 = r.f(objArr, this.f16959f + i2);
                arrayList.add(f2);
            }
            return arrayList;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003d, B:35:0x00a4, B:38:0x00ae, B:39:0x00b1, B:42:0x00c4, B:19:0x005d, B:22:0x006f, B:33:0x0096), top: B:49:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [i.b.v3.c0.c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v6, types: [i.b.v3.s, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [i.b.v3.c0.a] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00c1 -> B:15:0x0040). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@k.e.a.d i.b.v3.f<? super T> r9, @k.e.a.d h.e2.c<? super h.t1> r10) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.e(i.b.v3.f, h.e2.c):java.lang.Object");
    }

    @Override // i.b.v3.f
    @k.e.a.e
    public Object emit(T t, @k.e.a.d c<? super t1> cVar) {
        if (b(t)) {
            return t1.a;
        }
        Object K = K(t, cVar);
        return K == h.e2.j.b.h() ? K : t1.a;
    }

    @Override // i.b.v3.k
    public void g() {
        synchronized (this) {
            Y(N(), this.f16960g, N(), Q());
            t1 t1Var = t1.a;
        }
    }
}
