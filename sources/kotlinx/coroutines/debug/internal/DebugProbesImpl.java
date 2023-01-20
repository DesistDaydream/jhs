package kotlinx.coroutines.debug.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.moor.imkf.YKFConstants;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.a2.s0;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.t0;
import h.o2.q;
import h.r0;
import h.t;
import h.t1;
import h.t2.u;
import h.z0;
import i.b.b2;
import i.b.e2;
import i.b.u3.b.g;
import i.b.w3.e0;
import i.b.w3.h0;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0092\u0001B\n\b\u0002¢\u0006\u0005\b\u0091\u0001\u0010\bJ\u001d\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ;\u0010\u0013\u001a\u00020\u0004*\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J>\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\b\b\u0000\u0010\u0015*\u00020\u00012\u001c\u0010\u0019\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u00000\u0016H\u0082\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J%\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002¢\u0006\u0004\b%\u0010&J5\u0010+\u001a\b\u0012\u0004\u0012\u00020#0\u001a2\u0006\u0010'\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002¢\u0006\u0004\b+\u0010,J?\u00102\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0003012\u0006\u0010.\u001a\u00020-2\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0/2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002¢\u0006\u0004\b2\u00103J3\u00105\u001a\u00020-2\u0006\u00104\u001a\u00020-2\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0/2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002¢\u0006\u0004\b5\u00106J#\u0010\u0015\u001a\u00020\u00042\n\u00108\u001a\u0006\u0012\u0002\b\u0003072\u0006\u0010'\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u00109J\u001f\u0010;\u001a\u00020\u00042\u0006\u00108\u001a\u00020:2\u0006\u0010'\u001a\u00020\u0011H\u0002¢\u0006\u0004\b;\u0010<J\u0016\u0010=\u001a\u0004\u0018\u00010:*\u00020:H\u0082\u0010¢\u0006\u0004\b=\u0010>J/\u0010@\u001a\u00020\u00042\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u00172\n\u00108\u001a\u0006\u0012\u0002\b\u0003072\u0006\u0010'\u001a\u00020\u0011H\u0002¢\u0006\u0004\b@\u0010AJ\u001d\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u0006\u0012\u0002\b\u000307H\u0002¢\u0006\u0004\bB\u0010CJ\u001a\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u00020:H\u0082\u0010¢\u0006\u0004\bD\u0010EJ\u001b\u0010G\u001a\u0004\u0018\u00010F*\b\u0012\u0004\u0012\u00020#0\u001aH\u0002¢\u0006\u0004\bG\u0010HJ3\u0010K\u001a\b\u0012\u0004\u0012\u00028\u000007\"\u0004\b\u0000\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u0000072\b\u00108\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\u00042\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0004\bM\u0010NJ'\u0010Q\u001a\b\u0012\u0004\u0012\u00020#0\u001a\"\b\b\u0000\u0010I*\u00020O2\u0006\u0010P\u001a\u00028\u0000H\u0002¢\u0006\u0004\bQ\u0010RJ\r\u0010S\u001a\u00020\u0004¢\u0006\u0004\bS\u0010\bJ\r\u0010T\u001a\u00020\u0004¢\u0006\u0004\bT\u0010\bJ\u0015\u0010V\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n¢\u0006\u0004\bV\u0010WJ\u0013\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0\u001a¢\u0006\u0004\bY\u0010ZJ\u0013\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0\u001a¢\u0006\u0004\b\\\u0010ZJ\u0015\u0010]\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b]\u0010\"J)\u0010_\u001a\b\u0012\u0004\u0012\u00020#0\u001a2\u0006\u0010^\u001a\u00020X2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001a¢\u0006\u0004\b_\u0010`J\u001b\u0010a\u001a\u00020\u00042\n\u00108\u001a\u0006\u0012\u0002\b\u000307H\u0000¢\u0006\u0004\ba\u0010bJ\u001b\u0010c\u001a\u00020\u00042\n\u00108\u001a\u0006\u0012\u0002\b\u000307H\u0000¢\u0006\u0004\bc\u0010bJ)\u0010d\u001a\b\u0012\u0004\u0012\u00028\u000007\"\u0004\b\u0000\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0000¢\u0006\u0004\bd\u0010eR\"\u0010h\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\f0f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010gR \u0010l\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170i8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bm\u0010nR \u0010s\u001a\u00020\u0011*\u00020\n8B@\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\bq\u0010r\u001a\u0004\bp\u0010WR\u001a\u0010v\u001a\u00020\u0003*\u00020#8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0016\u0010y\u001a\u00020\u00038@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR&\u0010{\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u00030f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010gR\u0016\u0010\u007f\u001a\u00020|8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R&\u0010\u0081\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001b\u0010\u0080\u0001R\u0019\u0010\u0084\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bK\u0010\u0083\u0001R'\u0010\u0089\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b]\u0010\u0085\u0001\u001a\u0005\b\u0086\u0001\u0010x\"\u0006\b\u0087\u0001\u0010\u0088\u0001R'\u0010\u008c\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bY\u0010\u0085\u0001\u001a\u0005\b\u008a\u0001\u0010x\"\u0006\b\u008b\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010=R\u001b\u0010\u0090\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001¨\u0006\u0093\u0001"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "Lkotlin/Function1;", "", "Lh/t1;", am.aI, "()Lh/k2/u/l;", "M", "()V", "N", "Li/b/b2;", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "", "indent", "f", "(Li/b/b2;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$e;", "Lkotlin/coroutines/CoroutineContext;", "create", "", "j", "(Lh/k2/u/p;)Ljava/util/List;", "y", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$e;)Z", "Ljava/io/PrintStream;", YKFConstants.INVESTIGATE_TYPE_OUT, "k", "(Ljava/io/PrintStream;)V", "Ljava/lang/StackTraceElement;", "frames", "D", "(Ljava/io/PrintStream;Ljava/util/List;)V", "state", "Ljava/lang/Thread;", "thread", "coroutineTrace", "n", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "", "actualTrace", "Lkotlin/Pair;", "o", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", am.ax, "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lh/e2/c;", TypedValues.Attributes.S_FRAME, "(Lh/e2/c;Ljava/lang/String;)V", "Lh/e2/k/a/c;", "Q", "(Lh/e2/k/a/c;Ljava/lang/String;)V", ExpandableTextView.P, "(Lh/e2/k/a/c;)Lh/e2/k/a/c;", TUIConstants.TUIChat.OWNER, ExifInterface.LATITUDE_SOUTH, "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$e;Lh/e2/c;Ljava/lang/String;)V", "B", "(Lh/e2/c;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$e;", "C", "(Lh/e2/k/a/c;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$e;", "Li/b/u3/b/g;", "O", "(Ljava/util/List;)Li/b/u3/b/g;", ExifInterface.GPS_DIRECTION_TRUE, "completion", "g", "(Lh/e2/c;Li/b/u3/b/g;)Lh/e2/c;", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$e;)V", "", "throwable", "J", "(Ljava/lang/Throwable;)Ljava/util/List;", "x", "P", "job", IAdInterListener.AdReqParam.WIDTH, "(Li/b/b2;)Ljava/lang/String;", "Li/b/u3/b/b;", "i", "()Ljava/util/List;", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", NotifyType.LIGHTS, "h", "info", "m", "(Li/b/u3/b/b;Ljava/util/List;)Ljava/util/List;", "G", "(Lh/e2/c;)V", "H", "F", "(Lh/e2/c;)Lh/e2/c;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "callerInfoCache", "", "q", "()Ljava/util/Set;", "capturedCoroutines", am.av, "Ljava/lang/String;", "ARTIFICIAL_FRAME_MESSAGE", "r", "getDebugString$annotations", "(Li/b/b2;)V", "debugString", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/StackTraceElement;)Z", "isInternalMethod", am.aD, "()Z", "isInstalled", f.f10128d, "capturedCoroutinesMap", "Ljava/text/SimpleDateFormat;", "b", "Ljava/text/SimpleDateFormat;", "dateFormat", "Lh/k2/u/l;", "dynamicAttach", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Z", "v", "L", "(Z)V", "sanitizeStackTraces", am.aH, "K", "enableCreationStackTraces", "installations", "c", "Ljava/lang/Thread;", "weakRefCleanerThread", "<init>", com.huawei.hms.push.e.a, "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DebugProbesImpl {
    private static final String a = "Coroutine creation stacktrace";
    private static final SimpleDateFormat b;

    /* renamed from: c  reason: collision with root package name */
    private static Thread f16936c;

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentWeakMap<e<?>, Boolean> f16937d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ i.b.u3.b.d f16938e;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f16939f;

    /* renamed from: g  reason: collision with root package name */
    private static final ReentrantReadWriteLock f16940g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f16941h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f16942i;
    private static volatile int installations;

    /* renamed from: j  reason: collision with root package name */
    private static final l<Boolean, t1> f16943j;

    /* renamed from: k  reason: collision with root package name */
    private static final ConcurrentWeakMap<h.e2.k.a.c, DebugCoroutineInfoImpl> f16944k;

    /* renamed from: l  reason: collision with root package name */
    public static final DebugProbesImpl f16945l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", am.av, "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "h/b2/b$b", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return h.b2.b.g(Long.valueOf(((e) t).b.f16935f), Long.valueOf(((e) t2).b.f16935f));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", am.av, "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "h/b2/b$b", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return h.b2.b.g(Long.valueOf(((e) t).b.f16935f), Long.valueOf(((e) t2).b.f16935f));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", am.av, "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "h/b2/b$b", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return h.b2.b.g(Long.valueOf(((e) t).b.f16935f), Long.valueOf(((e) t2).b.f16935f));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", am.av, "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "h/b2/b$b", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class d<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return h.b2.b.g(Long.valueOf(((e) t).b.f16935f), Long.valueOf(((e) t2).b.f16935f));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B'\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b \u0010!J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"kotlinx/coroutines/debug/internal/DebugProbesImpl$e", ExifInterface.GPS_DIRECTION_TRUE, "Lh/e2/c;", "Lh/e2/k/a/c;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "Lh/t1;", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "getCallerFrame", "()Lh/e2/k/a/c;", "callerFrame", am.av, "Lh/e2/c;", "delegate", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "b", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "info", "c", "Lh/e2/k/a/c;", TypedValues.Attributes.S_FRAME, "<init>", "(Lh/e2/c;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lh/e2/k/a/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class e<T> implements h.e2.c<T>, h.e2.k.a.c {
        @h.k2.d
        @k.e.a.d
        public final h.e2.c<T> a;
        @h.k2.d
        @k.e.a.d
        public final DebugCoroutineInfoImpl b;

        /* renamed from: c  reason: collision with root package name */
        private final h.e2.k.a.c f16946c;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@k.e.a.d h.e2.c<? super T> cVar, @k.e.a.d DebugCoroutineInfoImpl debugCoroutineInfoImpl, @k.e.a.e h.e2.k.a.c cVar2) {
            this.a = cVar;
            this.b = debugCoroutineInfoImpl;
            this.f16946c = cVar2;
        }

        @Override // h.e2.k.a.c
        @k.e.a.e
        public h.e2.k.a.c getCallerFrame() {
            h.e2.k.a.c cVar = this.f16946c;
            if (cVar != null) {
                return cVar.getCallerFrame();
            }
            return null;
        }

        @Override // h.e2.c
        @k.e.a.d
        public CoroutineContext getContext() {
            return this.a.getContext();
        }

        @Override // h.e2.k.a.c
        @k.e.a.e
        public StackTraceElement getStackTraceElement() {
            h.e2.k.a.c cVar = this.f16946c;
            if (cVar != null) {
                return cVar.getStackTraceElement();
            }
            return null;
        }

        @Override // h.e2.c
        public void resumeWith(@k.e.a.d Object obj) {
            DebugProbesImpl.f16945l.E(this);
            this.a.resumeWith(obj);
        }

        @k.e.a.d
        public String toString() {
            return this.a.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [i.b.u3.b.d] */
    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        f16945l = debugProbesImpl;
        b = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f16937d = new ConcurrentWeakMap<>(false, 1, null);
        f16938e = new Object(0L) { // from class: i.b.u3.b.d
            public volatile long sequenceNumber;

            {
                this.sequenceNumber = r1;
            }
        };
        f16940g = new ReentrantReadWriteLock();
        f16941h = true;
        f16942i = true;
        f16943j = debugProbesImpl.t();
        f16944k = new ConcurrentWeakMap<>(true);
        f16939f = AtomicLongFieldUpdater.newUpdater(i.b.u3.b.d.class, "sequenceNumber");
    }

    private DebugProbesImpl() {
    }

    private final boolean A(StackTraceElement stackTraceElement) {
        return u.u2(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, null);
    }

    private final e<?> B(h.e2.c<?> cVar) {
        if (!(cVar instanceof h.e2.k.a.c)) {
            cVar = null;
        }
        h.e2.k.a.c cVar2 = (h.e2.k.a.c) cVar;
        if (cVar2 != null) {
            return C(cVar2);
        }
        return null;
    }

    private final e<?> C(h.e2.k.a.c cVar) {
        while (!(cVar instanceof e)) {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return null;
            }
        }
        return (e) cVar;
    }

    private final void D(PrintStream printStream, List<StackTraceElement> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            printStream.print("\n\tat " + ((StackTraceElement) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(e<?> eVar) {
        h.e2.k.a.c I;
        f16937d.remove(eVar);
        h.e2.k.a.c d2 = eVar.b.d();
        if (d2 == null || (I = I(d2)) == null) {
            return;
        }
        f16944k.remove(I);
    }

    private final h.e2.k.a.c I(h.e2.k.a.c cVar) {
        do {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return null;
            }
        } while (cVar.getStackTraceElement() == null);
        return cVar;
    }

    private final <T extends Throwable> List<StackTraceElement> J(T t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        int length2 = stackTrace.length - 1;
        while (true) {
            if (length2 < 0) {
                break;
            } else if (f0.g(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                i2 = length2;
                break;
            } else {
                length2--;
            }
        }
        int i3 = 0;
        if (!f16941h) {
            int i4 = length - i2;
            ArrayList arrayList = new ArrayList(i4);
            while (i3 < i4) {
                arrayList.add(i3 == 0 ? h0.d(a) : stackTrace[i3 + i2]);
                i3++;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i2) + 1);
        arrayList2.add(h0.d(a));
        int i5 = length - 1;
        boolean z = true;
        for (int i6 = i2 + 1; i6 < i5; i6++) {
            StackTraceElement stackTraceElement = stackTrace[i6];
            if (A(stackTraceElement)) {
                if (z) {
                    arrayList2.add(stackTraceElement);
                    z = false;
                } else if (!A(stackTrace[i6 + 1])) {
                    arrayList2.add(stackTraceElement);
                }
            } else {
                arrayList2.add(stackTraceElement);
            }
            z = true;
        }
        arrayList2.add(stackTrace[i5]);
        return arrayList2;
    }

    private final void M() {
        Thread b2;
        b2 = h.c2.b.b((r12 & 1) != 0, (r12 & 2) != 0 ? false : true, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : "Coroutines Debugger Cleaner", (r12 & 16) != 0 ? -1 : 0, DebugProbesImpl$startWeakRefCleanerThread$1.INSTANCE);
        f16936c = b2;
    }

    private final void N() {
        Thread thread = f16936c;
        if (thread != null) {
            thread.interrupt();
        }
        f16936c = null;
    }

    private final g O(List<StackTraceElement> list) {
        g gVar = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                gVar = new g(gVar, listIterator.previous());
            }
        }
        return gVar;
    }

    private final void Q(h.e2.k.a.c cVar, String str) {
        ReentrantReadWriteLock.ReadLock readLock = f16940g.readLock();
        readLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f16945l;
            if (debugProbesImpl.z()) {
                ConcurrentWeakMap<h.e2.k.a.c, DebugCoroutineInfoImpl> concurrentWeakMap = f16944k;
                DebugCoroutineInfoImpl remove = concurrentWeakMap.remove(cVar);
                if (remove == null) {
                    e<?> C = debugProbesImpl.C(cVar);
                    if (C == null || (remove = C.b) == null) {
                        return;
                    }
                    h.e2.k.a.c d2 = remove.d();
                    h.e2.k.a.c I = d2 != null ? debugProbesImpl.I(d2) : null;
                    if (I != null) {
                        concurrentWeakMap.remove(I);
                    }
                }
                if (cVar != null) {
                    remove.h(str, (h.e2.c) cVar);
                    h.e2.k.a.c I2 = debugProbesImpl.I(cVar);
                    if (I2 != null) {
                        concurrentWeakMap.put(I2, remove);
                        t1 t1Var = t1.a;
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            }
        } finally {
            readLock.unlock();
        }
    }

    private final void R(h.e2.c<?> cVar, String str) {
        if (z()) {
            if (f0.g(str, i.b.u3.b.c.b) && t.f15672f.g(1, 3, 30)) {
                if (!(cVar instanceof h.e2.k.a.c)) {
                    cVar = null;
                }
                h.e2.k.a.c cVar2 = (h.e2.k.a.c) cVar;
                if (cVar2 != null) {
                    Q(cVar2, str);
                    return;
                }
                return;
            }
            e<?> B = B(cVar);
            if (B != null) {
                S(B, cVar, str);
            }
        }
    }

    private final void S(e<?> eVar, h.e2.c<?> cVar, String str) {
        ReentrantReadWriteLock.ReadLock readLock = f16940g.readLock();
        readLock.lock();
        try {
            if (f16945l.z()) {
                eVar.b.h(str, cVar);
                t1 t1Var = t1.a;
            }
        } finally {
            readLock.unlock();
        }
    }

    private final void f(b2 b2Var, Map<b2, DebugCoroutineInfoImpl> map, StringBuilder sb, String str) {
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = map.get(b2Var);
        if (debugCoroutineInfoImpl == null) {
            if (!(b2Var instanceof e0)) {
                sb.append(str + r(b2Var) + '\n');
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("\t");
                str = sb2.toString();
            }
        } else {
            String e2 = debugCoroutineInfoImpl.e();
            sb.append(str + r(b2Var) + ", continuation is " + e2 + " at line " + ((StackTraceElement) CollectionsKt___CollectionsKt.t2(debugCoroutineInfoImpl.f())) + '\n');
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("\t");
            str = sb3.toString();
        }
        for (b2 b2Var2 : b2Var.k()) {
            f(b2Var2, map, sb, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> h.e2.c<T> g(h.e2.c<? super T> cVar, g gVar) {
        if (z()) {
            e<?> eVar = new e<>(cVar, new DebugCoroutineInfoImpl(cVar.getContext(), gVar, f16939f.incrementAndGet(f16938e)), gVar);
            ConcurrentWeakMap<e<?>, Boolean> concurrentWeakMap = f16937d;
            concurrentWeakMap.put(eVar, Boolean.TRUE);
            if (!z()) {
                concurrentWeakMap.clear();
            }
            return eVar;
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
        r6.add(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <R> java.util.List<R> j(h.k2.u.p<? super kotlinx.coroutines.debug.internal.DebugProbesImpl.e<?>, ? super kotlin.coroutines.CoroutineContext, ? extends R> r11) {
        /*
            r10 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = c(r10)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L14
            int r2 = r0.getReadHoldCount()
            goto L15
        L14:
            r2 = 0
        L15:
            r4 = 0
        L16:
            if (r4 >= r2) goto L1e
            r1.unlock()
            int r4 = r4 + 1
            goto L16
        L1e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            r4 = 1
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f16945l     // Catch: java.lang.Throwable -> L8a
            boolean r6 = r5.z()     // Catch: java.lang.Throwable -> L8a
            if (r6 == 0) goto L7e
            java.util.Set r5 = b(r5)     // Catch: java.lang.Throwable -> L8a
            kotlinx.coroutines.debug.internal.DebugProbesImpl$a r6 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$a     // Catch: java.lang.Throwable -> L8a
            r6.<init>()     // Catch: java.lang.Throwable -> L8a
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.h5(r5, r6)     // Catch: java.lang.Throwable -> L8a
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L8a
            r6.<init>()     // Catch: java.lang.Throwable -> L8a
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L8a
        L44:
            boolean r7 = r5.hasNext()     // Catch: java.lang.Throwable -> L8a
            if (r7 == 0) goto L6c
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L8a
            kotlinx.coroutines.debug.internal.DebugProbesImpl$e r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.e) r7     // Catch: java.lang.Throwable -> L8a
            kotlinx.coroutines.debug.internal.DebugProbesImpl r8 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f16945l     // Catch: java.lang.Throwable -> L8a
            boolean r8 = d(r8, r7)     // Catch: java.lang.Throwable -> L8a
            r9 = 0
            if (r8 == 0) goto L5a
            goto L66
        L5a:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r8 = r7.b     // Catch: java.lang.Throwable -> L8a
            kotlin.coroutines.CoroutineContext r8 = r8.getContext()     // Catch: java.lang.Throwable -> L8a
            if (r8 == 0) goto L66
            java.lang.Object r9 = r11.invoke(r7, r8)     // Catch: java.lang.Throwable -> L8a
        L66:
            if (r9 == 0) goto L44
            r6.add(r9)     // Catch: java.lang.Throwable -> L8a
            goto L44
        L6c:
            h.k2.v.c0.d(r4)
        L6f:
            if (r3 >= r2) goto L77
            r1.lock()
            int r3 = r3 + 1
            goto L6f
        L77:
            r0.unlock()
            h.k2.v.c0.c(r4)
            return r6
        L7e:
            java.lang.String r11 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L8a
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L8a
            r5.<init>(r11)     // Catch: java.lang.Throwable -> L8a
            throw r5     // Catch: java.lang.Throwable -> L8a
        L8a:
            r11 = move-exception
            h.k2.v.c0.d(r4)
        L8e:
            if (r3 >= r2) goto L96
            r1.lock()
            int r3 = r3 + 1
            goto L8e
        L96:
            r0.unlock()
            h.k2.v.c0.c(r4)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.j(h.k2.u.p):java.util.List");
    }

    private final void k(PrintStream printStream) {
        ReentrantReadWriteLock reentrantReadWriteLock = f16940g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f16945l;
            if (debugProbesImpl.z()) {
                printStream.print("Coroutines dump " + b.format(Long.valueOf(System.currentTimeMillis())));
                for (e eVar : SequencesKt___SequencesKt.D2(SequencesKt___SequencesKt.i0(CollectionsKt___CollectionsKt.n1(debugProbesImpl.q()), DebugProbesImpl$dumpCoroutinesSynchronized$1$2.INSTANCE), new d())) {
                    DebugCoroutineInfoImpl debugCoroutineInfoImpl = eVar.b;
                    List<StackTraceElement> f2 = debugCoroutineInfoImpl.f();
                    DebugProbesImpl debugProbesImpl2 = f16945l;
                    List<StackTraceElement> n = debugProbesImpl2.n(debugCoroutineInfoImpl.e(), debugCoroutineInfoImpl.f16932c, f2);
                    printStream.print("\n\nCoroutine " + eVar.a + ", state: " + ((f0.g(debugCoroutineInfoImpl.e(), i.b.u3.b.c.b) && n == f2) ? debugCoroutineInfoImpl.e() + " (Last suspension stacktrace, not an actual stacktrace)" : debugCoroutineInfoImpl.e()));
                    if (f2.isEmpty()) {
                        printStream.print("\n\tat " + h0.d(a));
                        debugProbesImpl2.D(printStream, debugCoroutineInfoImpl.c());
                    } else {
                        debugProbesImpl2.D(printStream, n);
                    }
                }
                t1 t1Var = t1.a;
                return;
            }
            throw new IllegalStateException("Debug probes are not installed".toString());
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }

    private final List<StackTraceElement> n(String str, Thread thread, List<StackTraceElement> list) {
        Object m106constructorimpl;
        if (!(!f0.g(str, i.b.u3.b.c.b)) && thread != null) {
            try {
                Result.a aVar = Result.Companion;
                m106constructorimpl = Result.m106constructorimpl(thread.getStackTrace());
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                m106constructorimpl = Result.m106constructorimpl(r0.a(th));
            }
            if (Result.m112isFailureimpl(m106constructorimpl)) {
                m106constructorimpl = null;
            }
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) m106constructorimpl;
            if (stackTraceElementArr != null) {
                int length = stackTraceElementArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                    if (f0.g(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && f0.g(stackTraceElement.getMethodName(), "resumeWith") && f0.g(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                        break;
                    }
                    i2++;
                }
                Pair<Integer, Boolean> o = o(i2, stackTraceElementArr, list);
                int intValue = o.component1().intValue();
                boolean booleanValue = o.component2().booleanValue();
                if (intValue == -1) {
                    return list;
                }
                ArrayList arrayList = new ArrayList((((list.size() + i2) - intValue) - 1) - (booleanValue ? 1 : 0));
                int i3 = i2 - (booleanValue ? 1 : 0);
                for (int i4 = 0; i4 < i3; i4++) {
                    arrayList.add(stackTraceElementArr[i4]);
                }
                int size = list.size();
                for (int i5 = intValue + 1; i5 < size; i5++) {
                    arrayList.add(list.get(i5));
                }
                return arrayList;
            }
        }
        return list;
    }

    private final Pair<Integer, Boolean> o(int i2, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        int p = p(i2 - 1, stackTraceElementArr, list);
        if (p == -1) {
            return z0.a(Integer.valueOf(p(i2 - 2, stackTraceElementArr, list)), Boolean.TRUE);
        }
        return z0.a(Integer.valueOf(p), Boolean.FALSE);
    }

    private final int p(int i2, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt___ArraysKt.me(stackTraceElementArr, i2);
        if (stackTraceElement != null) {
            int i3 = 0;
            for (StackTraceElement stackTraceElement2 : list) {
                if (f0.g(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && f0.g(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && f0.g(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<e<?>> q() {
        return f16937d.keySet();
    }

    private final String r(b2 b2Var) {
        return b2Var instanceof JobSupport ? ((JobSupport) b2Var).f1() : b2Var.toString();
    }

    private static /* synthetic */ void s(b2 b2Var) {
    }

    private final l<Boolean, t1> t() {
        Object m106constructorimpl;
        Object newInstance;
        try {
            Result.a aVar = Result.Companion;
            newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        if (newInstance != null) {
            m106constructorimpl = Result.m106constructorimpl((l) t0.q(newInstance, 1));
            if (Result.m112isFailureimpl(m106constructorimpl)) {
                m106constructorimpl = null;
            }
            return (l) m106constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Boolean) -> kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y(e<?> eVar) {
        b2 b2Var;
        CoroutineContext context = eVar.b.getContext();
        if (context == null || (b2Var = (b2) context.get(b2.y0)) == null || !b2Var.l()) {
            return false;
        }
        f16937d.remove(eVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @k.e.a.d
    public final <T> h.e2.c<T> F(@k.e.a.d h.e2.c<? super T> cVar) {
        if (z() && B(cVar) == null) {
            return g(cVar, f16942i ? O(J(new Exception())) : null);
        }
        return cVar;
    }

    public final void G(@k.e.a.d h.e2.c<?> cVar) {
        R(cVar, i.b.u3.b.c.b);
    }

    public final void H(@k.e.a.d h.e2.c<?> cVar) {
        R(cVar, i.b.u3.b.c.f15858c);
    }

    public final void K(boolean z) {
        f16942i = z;
    }

    public final void L(boolean z) {
        f16941h = z;
    }

    public final void P() {
        ReentrantReadWriteLock reentrantReadWriteLock = f16940g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f16945l;
            if (debugProbesImpl.z()) {
                installations--;
                if (installations != 0) {
                    return;
                }
                debugProbesImpl.N();
                f16937d.clear();
                f16944k.clear();
                if (i.b.u3.a.f15848c.b()) {
                    while (i2 < readHoldCount) {
                        readLock.lock();
                        i2++;
                    }
                    writeLock.unlock();
                    return;
                }
                l<Boolean, t1> lVar = f16943j;
                if (lVar != null) {
                    lVar.invoke(Boolean.FALSE);
                }
                t1 t1Var = t1.a;
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
                return;
            }
            throw new IllegalStateException("Agent was not installed".toString());
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }

    public final void h(@k.e.a.d PrintStream printStream) {
        synchronized (printStream) {
            f16945l.k(printStream);
            t1 t1Var = t1.a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        r5.add(r8);
     */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<i.b.u3.b.b> i() {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = c(r9)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L14
            int r2 = r0.getReadHoldCount()
            goto L15
        L14:
            r2 = 0
        L15:
            r4 = 0
        L16:
            if (r4 >= r2) goto L1e
            r1.unlock()
            int r4 = r4 + 1
            goto L16
        L1e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f16945l     // Catch: java.lang.Throwable -> L86
            boolean r5 = r4.z()     // Catch: java.lang.Throwable -> L86
            if (r5 == 0) goto L7a
            java.util.Set r4 = b(r4)     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.DebugProbesImpl$b r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$b     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.h5(r4, r5)     // Catch: java.lang.Throwable -> L86
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L86
        L43:
            boolean r6 = r4.hasNext()     // Catch: java.lang.Throwable -> L86
            if (r6 == 0) goto L6e
            java.lang.Object r6 = r4.next()     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.DebugProbesImpl$e r6 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.e) r6     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.DebugProbesImpl r7 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f16945l     // Catch: java.lang.Throwable -> L86
            boolean r7 = d(r7, r6)     // Catch: java.lang.Throwable -> L86
            r8 = 0
            if (r7 == 0) goto L59
            goto L68
        L59:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r7 = r6.b     // Catch: java.lang.Throwable -> L86
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L68
            i.b.u3.b.b r8 = new i.b.u3.b.b     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r6 = r6.b     // Catch: java.lang.Throwable -> L86
            r8.<init>(r6, r7)     // Catch: java.lang.Throwable -> L86
        L68:
            if (r8 == 0) goto L43
            r5.add(r8)     // Catch: java.lang.Throwable -> L86
            goto L43
        L6e:
            if (r3 >= r2) goto L76
            r1.lock()
            int r3 = r3 + 1
            goto L6e
        L76:
            r0.unlock()
            return r5
        L7a:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L86
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L86
            throw r5     // Catch: java.lang.Throwable -> L86
        L86:
            r4 = move-exception
        L87:
            if (r3 >= r2) goto L8f
            r1.lock()
            int r3 = r3 + 1
            goto L87
        L8f:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.i():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        r5.add(r8);
     */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<kotlinx.coroutines.debug.internal.DebuggerInfo> l() {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = c(r9)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L14
            int r2 = r0.getReadHoldCount()
            goto L15
        L14:
            r2 = 0
        L15:
            r4 = 0
        L16:
            if (r4 >= r2) goto L1e
            r1.unlock()
            int r4 = r4 + 1
            goto L16
        L1e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f16945l     // Catch: java.lang.Throwable -> L86
            boolean r5 = r4.z()     // Catch: java.lang.Throwable -> L86
            if (r5 == 0) goto L7a
            java.util.Set r4 = b(r4)     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.DebugProbesImpl$c r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$c     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.h5(r4, r5)     // Catch: java.lang.Throwable -> L86
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L86
        L43:
            boolean r6 = r4.hasNext()     // Catch: java.lang.Throwable -> L86
            if (r6 == 0) goto L6e
            java.lang.Object r6 = r4.next()     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.DebugProbesImpl$e r6 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.e) r6     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.DebugProbesImpl r7 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f16945l     // Catch: java.lang.Throwable -> L86
            boolean r7 = d(r7, r6)     // Catch: java.lang.Throwable -> L86
            r8 = 0
            if (r7 == 0) goto L59
            goto L68
        L59:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r7 = r6.b     // Catch: java.lang.Throwable -> L86
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L68
            kotlinx.coroutines.debug.internal.DebuggerInfo r8 = new kotlinx.coroutines.debug.internal.DebuggerInfo     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r6 = r6.b     // Catch: java.lang.Throwable -> L86
            r8.<init>(r6, r7)     // Catch: java.lang.Throwable -> L86
        L68:
            if (r8 == 0) goto L43
            r5.add(r8)     // Catch: java.lang.Throwable -> L86
            goto L43
        L6e:
            if (r3 >= r2) goto L76
            r1.lock()
            int r3 = r3 + 1
            goto L6e
        L76:
            r0.unlock()
            return r5
        L7a:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L86
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L86
            throw r5     // Catch: java.lang.Throwable -> L86
        L86:
            r4 = move-exception
        L87:
            if (r3 >= r2) goto L8f
            r1.lock()
            int r3 = r3 + 1
            goto L87
        L8f:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.l():java.util.List");
    }

    @k.e.a.d
    public final List<StackTraceElement> m(@k.e.a.d i.b.u3.b.b bVar, @k.e.a.d List<StackTraceElement> list) {
        return n(bVar.f(), bVar.d(), list);
    }

    public final boolean u() {
        return f16942i;
    }

    public final boolean v() {
        return f16941h;
    }

    @k.e.a.d
    public final String w(@k.e.a.d b2 b2Var) {
        ReentrantReadWriteLock reentrantReadWriteLock = f16940g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f16945l;
            if (debugProbesImpl.z()) {
                Set<e<?>> q = debugProbesImpl.q();
                ArrayList arrayList = new ArrayList();
                for (Object obj : q) {
                    if (((e) obj).a.getContext().get(b2.y0) != null) {
                        arrayList.add(obj);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(s0.j(h.a2.u.Y(arrayList, 10)), 16));
                for (Object obj2 : arrayList) {
                    linkedHashMap.put(e2.C(((e) obj2).a.getContext()), ((e) obj2).b);
                }
                StringBuilder sb = new StringBuilder();
                f16945l.f(b2Var, linkedHashMap, sb, "");
                return sb.toString();
            }
            throw new IllegalStateException("Debug probes are not installed".toString());
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }

    public final void x() {
        ReentrantReadWriteLock reentrantReadWriteLock = f16940g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            installations++;
            if (installations > 1) {
                return;
            }
            f16945l.M();
            if (i.b.u3.a.f15848c.b()) {
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
                return;
            }
            l<Boolean, t1> lVar = f16943j;
            if (lVar != null) {
                lVar.invoke(Boolean.TRUE);
            }
            t1 t1Var = t1.a;
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }

    public final boolean z() {
        return installations > 0;
    }
}
