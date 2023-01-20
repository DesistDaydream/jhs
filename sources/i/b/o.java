package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import i.b.b2;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.CoroutineDispatcher;

@h.p0
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001f\u0012\f\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000v\u0012\u0006\u0010+\u001a\u00020%¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014JB\u0010\u001a\u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\bJB\u0010 \u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J8\u0010#\u001a\u00020\"2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u0018H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(JZ\u0010.\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020%2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u00152\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b.\u0010/JH\u00100\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020%2%\b\u0002\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0002¢\u0006\u0004\b0\u00101JJ\u0010\u0001\u001a\u0004\u0018\u0001022\b\u0010*\u001a\u0004\u0018\u00010\u001e2\b\u0010-\u001a\u0004\u0018\u00010\u001e2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0001\u00103J\u0019\u00105\u001a\u0002042\b\u0010*\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\tH\u0002¢\u0006\u0004\b7\u0010\u000bJ\u000f\u00108\u001a\u00020\tH\u0016¢\u0006\u0004\b8\u0010\u000bJ\u000f\u00109\u001a\u00020\u0006H\u0001¢\u0006\u0004\b9\u0010\bJ\u0017\u0010<\u001a\n\u0018\u00010:j\u0004\u0018\u0001`;H\u0016¢\u0006\u0004\b<\u0010=J\u0011\u0010>\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\b>\u0010?J!\u0010A\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\bA\u0010BJ\u0019\u0010C\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bC\u0010\u0010J\u0017\u0010D\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bF\u0010GJ8\u0010H\u001a\u00020\t2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bH\u0010\u001bJ\u0017\u0010K\u001a\u00020\r2\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u0011\u0010M\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\bM\u0010?J \u0010P\u001a\u00020\t2\f\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000NH\u0016ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ<\u0010S\u001a\u00020\t2\u0006\u0010R\u001a\u00028\u00002#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0016¢\u0006\u0004\bS\u0010TJ8\u0010U\u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u0018H\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\tH\u0000¢\u0006\u0004\bW\u0010\u000bJ#\u0010X\u001a\u0004\u0018\u00010\u001e2\u0006\u0010R\u001a\u00028\u00002\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\bX\u0010YJH\u0010Z\u001a\u0004\u0018\u00010\u001e2\u0006\u0010R\u001a\u00028\u00002\b\u0010-\u001a\u0004\u0018\u00010\u001e2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0016¢\u0006\u0004\bZ\u0010[J\u0019\u0010]\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\\\u001a\u00020\rH\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u001eH\u0016¢\u0006\u0004\b`\u0010QJ\u001b\u0010b\u001a\u00020\t*\u00020a2\u0006\u0010R\u001a\u00028\u0000H\u0016¢\u0006\u0004\bb\u0010cJ\u001b\u0010d\u001a\u00020\t*\u00020a2\u0006\u0010\\\u001a\u00020\rH\u0016¢\u0006\u0004\bd\u0010eJ\u001f\u0010f\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bf\u0010gJ\u001b\u0010h\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bh\u0010iJ\u000f\u0010k\u001a\u00020jH\u0016¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020jH\u0014¢\u0006\u0004\bm\u0010lR\u001e\u0010p\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0016\u0010q\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bq\u0010\bR\u0016\u0010s\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u0010\bR\u0016\u0010u\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010\bR\"\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000v8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bh\u0010w\u001a\u0004\bx\u0010yR\u001c\u0010\u007f\u001a\u00020{8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bx\u0010|\u001a\u0004\b}\u0010~R/\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0080\u00012\t\u0010R\u001a\u0005\u0018\u00010\u0080\u00018B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8@@\u0000X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010?\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0089\u0001"}, d2 = {"Li/b/o;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/y0;", "Li/b/n;", "Lh/e2/k/a/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "F", "()Z", "Lh/t1;", "R", "()V", "s", "", "cause", "r", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function0;", ReportItem.LogTypeBlock, "o", "(Lh/k2/u/a;)V", "Lkotlin/Function1;", "Lh/k0;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "k", "(Lh/k2/u/l;Ljava/lang/Throwable;)V", "U", ExifInterface.LATITUDE_SOUTH, "", "state", ExpandableTextView.P, "(Lh/k2/u/l;Ljava/lang/Object;)V", "Li/b/l;", "H", "(Lh/k2/u/l;)Li/b/l;", "", "mode", "y", "(I)V", "Li/b/p2;", "proposedUpdate", "resumeMode", "onCancellation", "idempotent", "O", "(Li/b/p2;Ljava/lang/Object;ILh/k2/u/l;Ljava/lang/Object;)Ljava/lang/Object;", "M", "(Ljava/lang/Object;ILh/k2/u/l;)V", "Li/b/w3/i0;", "(Ljava/lang/Object;Ljava/lang/Object;Lh/k2/u/l;)Li/b/w3/i0;", "", "i", "(Ljava/lang/Object;)Ljava/lang/Void;", "x", "G", "L", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "h", "()Ljava/lang/Object;", "takenState", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", am.av, "K", "(Ljava/lang/Throwable;)V", "n", "(Li/b/l;Ljava/lang/Throwable;)V", "q", "Li/b/b2;", "parent", am.aD, "(Li/b/b2;)Ljava/lang/Throwable;", "B", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "value", IAdInterListener.AdReqParam.WIDTH, "(Ljava/lang/Object;Lh/k2/u/l;)V", am.ax, "(Lh/k2/u/l;)V", "v", "m", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "D", "(Ljava/lang/Object;Ljava/lang/Object;Lh/k2/u/l;)Ljava/lang/Object;", "exception", am.aI, "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "P", "Lkotlinx/coroutines/CoroutineDispatcher;", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", am.aH, "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "f", "(Ljava/lang/Object;)Ljava/lang/Object;", com.huawei.hms.push.e.a, "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", "J", "getCallerFrame", "()Lh/e2/k/a/c;", "callerFrame", "isCancelled", "j", "isActive", NotifyType.LIGHTS, "isCompleted", "Lh/e2/c;", "Lh/e2/c;", e.j.a.b.c.f.f10128d, "()Lh/e2/c;", "delegate", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "Li/b/e1;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Li/b/e1;", "Q", "(Li/b/e1;)V", "parentHandle", "C", "<init>", "(Lh/e2/c;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class o<T> extends y0<T> implements n<T>, h.e2.k.a.c {

    /* renamed from: f */
    private static final AtomicIntegerFieldUpdater f15773f = AtomicIntegerFieldUpdater.newUpdater(o.class, "_decision");

    /* renamed from: g */
    private static final AtomicReferenceFieldUpdater f15774g = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_state");
    private volatile int _decision;
    private volatile Object _parentHandle;
    private volatile Object _state;
    @k.e.a.d

    /* renamed from: d */
    private final CoroutineContext f15775d;
    @k.e.a.d

    /* renamed from: e */
    private final h.e2.c<T> f15776e;

    /* JADX WARN: Multi-variable type inference failed */
    public o(@k.e.a.d h.e2.c<? super T> cVar, int i2) {
        super(i2);
        this.f15776e = cVar;
        if (q0.b()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        this.f15775d = cVar.getContext();
        this._decision = 0;
        this._state = b.a;
        this._parentHandle = null;
    }

    private final e1 A() {
        return (e1) this._parentHandle;
    }

    private final boolean F() {
        h.e2.c<T> cVar = this.f15776e;
        return (cVar instanceof i.b.w3.j) && ((i.b.w3.j) cVar).r(this);
    }

    private final l H(h.k2.u.l<? super Throwable, h.t1> lVar) {
        return lVar instanceof l ? (l) lVar : new y1(lVar);
    }

    private final void I(h.k2.u.l<? super Throwable, h.t1> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final void M(Object obj, int i2, h.k2.u.l<? super Throwable, h.t1> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof p2) {
            } else {
                if (obj2 instanceof r) {
                    r rVar = (r) obj2;
                    if (rVar.c()) {
                        if (lVar != null) {
                            q(lVar, rVar.a);
                            return;
                        }
                        return;
                    }
                }
                i(obj);
                throw new KotlinNothingValueException();
            }
        } while (!f15774g.compareAndSet(this, obj2, O((p2) obj2, obj, i2, lVar, null)));
        x();
        y(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void N(o oVar, Object obj, int i2, h.k2.u.l lVar, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 4) != 0) {
                lVar = null;
            }
            oVar.M(obj, i2, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object O(p2 p2Var, Object obj, int i2, h.k2.u.l<? super Throwable, h.t1> lVar, Object obj2) {
        if (obj instanceof b0) {
            if (q0.b()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (q0.b()) {
                if (lVar == null) {
                    return obj;
                }
                throw new AssertionError();
            }
            return obj;
        } else if (z0.c(i2) || obj2 != null) {
            if (lVar != null || (((p2Var instanceof l) && !(p2Var instanceof d)) || obj2 != null)) {
                if (!(p2Var instanceof l)) {
                    p2Var = null;
                }
                return new a0(obj, (l) p2Var, lVar, obj2, null, 16, null);
            }
            return obj;
        } else {
            return obj;
        }
    }

    private final void Q(e1 e1Var) {
        this._parentHandle = e1Var;
    }

    private final void R() {
        b2 b2Var;
        if (s() || A() != null || (b2Var = (b2) this.f15776e.getContext().get(b2.y0)) == null) {
            return;
        }
        e1 f2 = b2.a.f(b2Var, true, false, new s(b2Var, this), 2, null);
        Q(f2);
        if (!l() || F()) {
            return;
        }
        f2.dispose();
        Q(o2.a);
    }

    private final boolean S() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f15773f.compareAndSet(this, 0, 2));
        return true;
    }

    private final i.b.w3.i0 T(Object obj, Object obj2, h.k2.u.l<? super Throwable, h.t1> lVar) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof p2) {
            } else if (!(obj3 instanceof a0) || obj2 == null) {
                return null;
            } else {
                a0 a0Var = (a0) obj3;
                if (a0Var.f15715d == obj2) {
                    if (!q0.b() || h.k2.v.f0.g(a0Var.a, obj)) {
                        return p.f15778d;
                    }
                    throw new AssertionError();
                }
                return null;
            }
        } while (!f15774g.compareAndSet(this, obj3, O((p2) obj3, obj, this.f15915c, lVar, obj2)));
        x();
        return p.f15778d;
    }

    private final boolean U() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f15773f.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void i(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void k(h.k2.u.l<? super Throwable, h.t1> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            k0.b(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final void o(h.k2.u.a<h.t1> aVar) {
        try {
            aVar.invoke();
        } catch (Throwable th) {
            CoroutineContext context = getContext();
            k0.b(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    private final boolean r(Throwable th) {
        if (z0.d(this.f15915c)) {
            h.e2.c<T> cVar = this.f15776e;
            if (!(cVar instanceof i.b.w3.j)) {
                cVar = null;
            }
            i.b.w3.j jVar = (i.b.w3.j) cVar;
            if (jVar != null) {
                return jVar.s(th);
            }
            return false;
        }
        return false;
    }

    private final boolean s() {
        Throwable i2;
        boolean l2 = l();
        if (z0.d(this.f15915c)) {
            h.e2.c<T> cVar = this.f15776e;
            if (!(cVar instanceof i.b.w3.j)) {
                cVar = null;
            }
            i.b.w3.j jVar = (i.b.w3.j) cVar;
            if (jVar == null || (i2 = jVar.i(this)) == null) {
                return l2;
            }
            if (!l2) {
                a(i2);
            }
            return true;
        }
        return l2;
    }

    private final void x() {
        if (F()) {
            return;
        }
        v();
    }

    private final void y(int i2) {
        if (S()) {
            return;
        }
        z0.a(this, i2);
    }

    @h.p0
    @k.e.a.e
    public final Object B() {
        b2 b2Var;
        R();
        if (U()) {
            return h.e2.j.b.h();
        }
        Object C = C();
        if (C instanceof b0) {
            Throwable th = ((b0) C).a;
            if (q0.e()) {
                throw i.b.w3.h0.c(th, this);
            }
            throw th;
        } else if (z0.c(this.f15915c) && (b2Var = (b2) getContext().get(b2.y0)) != null && !b2Var.j()) {
            CancellationException q = b2Var.q();
            c(C, q);
            if (q0.e()) {
                throw i.b.w3.h0.c(q, this);
            }
            throw q;
        } else {
            return f(C);
        }
    }

    @k.e.a.e
    public final Object C() {
        return this._state;
    }

    @Override // i.b.n
    @k.e.a.e
    public Object D(T t, @k.e.a.e Object obj, @k.e.a.e h.k2.u.l<? super Throwable, h.t1> lVar) {
        return T(t, obj, lVar);
    }

    @Override // i.b.n
    public void E(@k.e.a.d CoroutineDispatcher coroutineDispatcher, T t) {
        h.e2.c<T> cVar = this.f15776e;
        if (!(cVar instanceof i.b.w3.j)) {
            cVar = null;
        }
        i.b.w3.j jVar = (i.b.w3.j) cVar;
        N(this, t, (jVar != null ? jVar.f15886g : null) == coroutineDispatcher ? 4 : this.f15915c, null, 4, null);
    }

    @Override // i.b.n
    public void G() {
        R();
    }

    @k.e.a.d
    public String J() {
        return "CancellableContinuation";
    }

    public final void K(@k.e.a.d Throwable th) {
        if (r(th)) {
            return;
        }
        a(th);
        x();
    }

    @h.k2.g(name = "resetStateReusable")
    public final boolean L() {
        if (q0.b()) {
            if (!(this.f15915c == 2)) {
                throw new AssertionError();
            }
        }
        if (q0.b()) {
            if (!(A() != o2.a)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (!q0.b() || (!(obj instanceof p2))) {
            if ((obj instanceof a0) && ((a0) obj).f15715d != null) {
                v();
                return false;
            }
            this._decision = 0;
            this._state = b.a;
            return true;
        }
        throw new AssertionError();
    }

    @Override // i.b.n
    public void P(@k.e.a.d Object obj) {
        if (q0.b()) {
            if (!(obj == p.f15778d)) {
                throw new AssertionError();
            }
        }
        y(this.f15915c);
    }

    @Override // i.b.n
    public boolean a(@k.e.a.e Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof p2)) {
                return false;
            }
            z = obj instanceof l;
        } while (!f15774g.compareAndSet(this, obj, new r(this, th, z)));
        if (!z) {
            obj = null;
        }
        l lVar = (l) obj;
        if (lVar != null) {
            n(lVar, th);
        }
        x();
        y(this.f15915c);
        return true;
    }

    @Override // i.b.y0
    public void c(@k.e.a.e Object obj, @k.e.a.d Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof p2)) {
                if (obj2 instanceof b0) {
                    return;
                }
                if (obj2 instanceof a0) {
                    a0 a0Var = (a0) obj2;
                    if (!a0Var.h()) {
                        if (f15774g.compareAndSet(this, obj2, a0.g(a0Var, null, null, null, null, th, 15, null))) {
                            a0Var.i(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (f15774g.compareAndSet(this, obj2, new a0(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed".toString());
            }
        }
    }

    @Override // i.b.y0
    @k.e.a.d
    public final h.e2.c<T> d() {
        return this.f15776e;
    }

    @Override // i.b.y0
    @k.e.a.e
    public Throwable e(@k.e.a.e Object obj) {
        Throwable e2 = super.e(obj);
        if (e2 != null) {
            h.e2.c<T> cVar = this.f15776e;
            return (q0.e() && (cVar instanceof h.e2.k.a.c)) ? i.b.w3.h0.c(e2, (h.e2.k.a.c) cVar) : e2;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.y0
    public <T> T f(@k.e.a.e Object obj) {
        return obj instanceof a0 ? (T) ((a0) obj).a : obj;
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public h.e2.k.a.c getCallerFrame() {
        h.e2.c<T> cVar = this.f15776e;
        if (!(cVar instanceof h.e2.k.a.c)) {
            cVar = null;
        }
        return (h.e2.k.a.c) cVar;
    }

    @Override // h.e2.c
    @k.e.a.d
    public CoroutineContext getContext() {
        return this.f15775d;
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // i.b.y0
    @k.e.a.e
    public Object h() {
        return C();
    }

    @Override // i.b.n
    public boolean isCancelled() {
        return C() instanceof r;
    }

    @Override // i.b.n
    public boolean j() {
        return C() instanceof p2;
    }

    @Override // i.b.n
    public boolean l() {
        return !(C() instanceof p2);
    }

    @Override // i.b.n
    @k.e.a.e
    public Object m(T t, @k.e.a.e Object obj) {
        return T(t, obj, null);
    }

    public final void n(@k.e.a.d l lVar, @k.e.a.e Throwable th) {
        try {
            lVar.a(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            k0.b(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // i.b.n
    public void p(@k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar) {
        l H = H(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof b) {
                if (f15774g.compareAndSet(this, obj, H)) {
                    return;
                }
            } else if (obj instanceof l) {
                I(lVar, obj);
            } else {
                boolean z = obj instanceof b0;
                if (z) {
                    if (!((b0) obj).b()) {
                        I(lVar, obj);
                    }
                    if (obj instanceof r) {
                        if (!z) {
                            obj = null;
                        }
                        b0 b0Var = (b0) obj;
                        k(lVar, b0Var != null ? b0Var.a : null);
                        return;
                    }
                    return;
                } else if (obj instanceof a0) {
                    a0 a0Var = (a0) obj;
                    if (a0Var.b != null) {
                        I(lVar, obj);
                    }
                    if (H instanceof d) {
                        return;
                    }
                    if (a0Var.h()) {
                        k(lVar, a0Var.f15716e);
                        return;
                    } else {
                        if (f15774g.compareAndSet(this, obj, a0.g(a0Var, null, H, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else if (H instanceof d) {
                    return;
                } else {
                    if (f15774g.compareAndSet(this, obj, new a0(obj, H, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    public final void q(@k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar, @k.e.a.d Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            k0.b(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // h.e2.c
    public void resumeWith(@k.e.a.d Object obj) {
        N(this, g0.c(obj, this), this.f15915c, null, 4, null);
    }

    @Override // i.b.n
    @k.e.a.e
    public Object t(@k.e.a.d Throwable th) {
        return T(new b0(th, false, 2, null), null, null);
    }

    @k.e.a.d
    public String toString() {
        return J() + '(' + r0.c(this.f15776e) + "){" + C() + "}@" + r0.b(this);
    }

    @Override // i.b.n
    public void u(@k.e.a.d CoroutineDispatcher coroutineDispatcher, @k.e.a.d Throwable th) {
        h.e2.c<T> cVar = this.f15776e;
        if (!(cVar instanceof i.b.w3.j)) {
            cVar = null;
        }
        i.b.w3.j jVar = (i.b.w3.j) cVar;
        N(this, new b0(th, false, 2, null), (jVar != null ? jVar.f15886g : null) == coroutineDispatcher ? 4 : this.f15915c, null, 4, null);
    }

    public final void v() {
        e1 A = A();
        if (A != null) {
            A.dispose();
        }
        Q(o2.a);
    }

    @Override // i.b.n
    public void w(T t, @k.e.a.e h.k2.u.l<? super Throwable, h.t1> lVar) {
        M(t, this.f15915c, lVar);
    }

    @k.e.a.d
    public Throwable z(@k.e.a.d b2 b2Var) {
        return b2Var.q();
    }
}
