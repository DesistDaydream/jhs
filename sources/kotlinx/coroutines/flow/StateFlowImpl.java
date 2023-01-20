package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.a2.t;
import h.e2.c;
import h.k2.v.f0;
import h.t1;
import i.b.v3.c0.a;
import i.b.v3.c0.k;
import i.b.v3.c0.n;
import i.b.v3.l;
import i.b.v3.y;
import i.b.v3.z;
import i.b.w3.i0;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000f\u0012\u0006\u00106\u001a\u00020\u0007¢\u0006\u0004\b7\u0010.J!\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b!\u0010\"J-\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010*R*\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\u0017\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00100R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104\u0082\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/c0/a;", "Li/b/v3/z;", "Li/b/v3/l;", "Li/b/v3/a;", "Li/b/v3/c0/k;", "", "expectedState", "newState", "", IAdInterListener.AdReqParam.WIDTH, "(Ljava/lang/Object;Ljava/lang/Object;)Z", "expect", "update", "f", "value", "b", "(Ljava/lang/Object;)Z", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "g", "()V", "Li/b/v3/f;", "collector", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", am.aI, "()Li/b/v3/z;", "", "size", "", am.aH, "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", am.av, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "getValue$annotations", ExpandableTextView.P, "sequence", "", f.f10128d, "()Ljava/util/List;", "replayCache", "initialState", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class StateFlowImpl<T> extends a<z> implements l<T>, i.b.v3.a<T>, k<T> {
    private volatile Object _state;

    /* renamed from: e */
    private int f16969e;

    public StateFlowImpl(@d Object obj) {
        this._state = obj;
    }

    public static /* synthetic */ void v() {
    }

    private final boolean w(Object obj, Object obj2) {
        int i2;
        z[] r;
        r();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && (!f0.g(obj3, obj))) {
                return false;
            }
            if (f0.g(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i3 = this.f16969e;
            if ((i3 & 1) == 0) {
                int i4 = i3 + 1;
                this.f16969e = i4;
                z[] r2 = r();
                t1 t1Var = t1.a;
                while (true) {
                    if (r2 != null) {
                        for (z zVar : r2) {
                            if (zVar != null) {
                                zVar.f();
                            }
                        }
                    }
                    synchronized (this) {
                        i2 = this.f16969e;
                        if (i2 == i4) {
                            this.f16969e = i4 + 1;
                            return true;
                        }
                        r = r();
                        t1 t1Var2 = t1.a;
                    }
                    r2 = r;
                    i4 = i2;
                }
            } else {
                this.f16969e = i3 + 2;
                return true;
            }
        }
    }

    @Override // i.b.v3.c0.k
    @d
    public Flow<T> a(@d CoroutineContext coroutineContext, int i2, @d BufferOverflow bufferOverflow) {
        return y.d(this, coroutineContext, i2, bufferOverflow);
    }

    @Override // i.b.v3.k
    public boolean b(T t) {
        setValue(t);
        return true;
    }

    @Override // i.b.v3.p
    @d
    public List<T> d() {
        return t.k(getValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x00b8, code lost:
        if ((!h.k2.v.f0.g(r12, r13)) != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00b3 A[Catch: all -> 0x0077, TryCatch #1 {all -> 0x0077, blocks: (B:76:0x0040, B:96:0x00aa, B:98:0x00ae, B:100:0x00b3, B:111:0x00d8, B:113:0x00de, B:102:0x00ba, B:106:0x00c1, B:81:0x0060, B:84:0x0073, B:95:0x009b), top: B:122:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00de A[Catch: all -> 0x0077, TRY_LEAVE, TryCatch #1 {all -> 0x0077, blocks: (B:76:0x0040, B:96:0x00aa, B:98:0x00ae, B:100:0x00b3, B:111:0x00d8, B:113:0x00de, B:102:0x00ba, B:106:0x00c1, B:81:0x0060, B:84:0x0073, B:95:0x009b), top: B:122:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00ae A[Catch: all -> 0x0077, TryCatch #1 {all -> 0x0077, blocks: (B:76:0x0040, B:96:0x00aa, B:98:0x00ae, B:100:0x00b3, B:111:0x00d8, B:113:0x00de, B:102:0x00ba, B:106:0x00c1, B:81:0x0060, B:84:0x0073, B:95:0x009b), top: B:122:0x0024 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x00dc -> B:96:0x00aa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x00f0 -> B:96:0x00aa). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@k.e.a.d i.b.v3.f<? super T> r12, @k.e.a.d h.e2.c<? super h.t1> r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.e(i.b.v3.f, h.e2.c):java.lang.Object");
    }

    @Override // i.b.v3.f
    @k.e.a.e
    public Object emit(T t, @d c<? super t1> cVar) {
        setValue(t);
        return t1.a;
    }

    @Override // i.b.v3.l
    public boolean f(T t, T t2) {
        if (t == null) {
            t = (T) n.a;
        }
        if (t2 == null) {
            t2 = (T) n.a;
        }
        return w(t, t2);
    }

    @Override // i.b.v3.k
    public void g() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // i.b.v3.l, i.b.v3.x
    public T getValue() {
        i0 i0Var = n.a;
        T t = (T) this._state;
        if (t == i0Var) {
            return null;
        }
        return t;
    }

    @Override // i.b.v3.l
    public void setValue(T t) {
        if (t == null) {
            t = (T) n.a;
        }
        w(null, t);
    }

    @Override // i.b.v3.c0.a
    @d
    /* renamed from: t */
    public z m() {
        return new z();
    }

    @Override // i.b.v3.c0.a
    @d
    /* renamed from: u */
    public z[] n(int i2) {
        return new z[i2];
    }
}
