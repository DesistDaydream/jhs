package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.b;
import h.e2.c;
import h.i;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.u.r;
import h.k2.u.s;
import h.k2.u.t;
import h.q0;
import h.t1;
import i.b.v3.h;
import k.e.a.d;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\b\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\b\u001a3\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\f\u0010\r\u001a3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\r\u001a\u001f\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aF\u0010\u0016\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aj\u0010\u001a\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00122\"\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aX\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042(\u0010\u001d\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001aE\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040 H\u0007¢\u0006\u0004\b!\u0010\"\u001a+\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004H\u0007¢\u0006\u0004\b#\u0010$\u001a+\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004H\u0007¢\u0006\u0004\b%\u0010$\u001aP\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042#\u0010'\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040 ¢\u0006\u0002\b&H\u0007¢\u0006\u0004\b(\u0010\"\u001a-\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b+\u0010,\u001aU\u00101\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u000421\u00100\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0017\u001a\u0080\u0001\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u00102\u001a\u00028\u00012H\b\u0001\u00105\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u001403H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a-\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0007¢\u0006\u0004\b8\u00109\u001aC\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000b\u001a\u00028\u00002\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020:0 H\u0007¢\u0006\u0004\b<\u0010=\u001a-\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010/\u001a\u00028\u0000H\u0007¢\u0006\u0004\b>\u00109\u001a3\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b@\u0010\r\u001a-\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010/\u001a\u00028\u0000H\u0007¢\u0006\u0004\bA\u00109\u001a3\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\bB\u0010\r\u001al\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010C\"\u0004\b\u0001\u0010D\"\u0004\b\u0002\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010E\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u001403H\u0007ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a\u0086\u0001\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004\"\u0004\b\u0000\u0010C\"\u0004\b\u0001\u0010D\"\u0004\b\u0002\u0010H\"\u0004\b\u0003\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042.\u0010E\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140JH\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a \u0001\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00040\u0004\"\u0004\b\u0000\u0010C\"\u0004\b\u0001\u0010D\"\u0004\b\u0002\u0010H\"\u0004\b\u0003\u0010M\"\u0004\b\u0004\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00030\u000424\u0010E\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140OH\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001aº\u0001\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00050\u0004\"\u0004\b\u0000\u0010C\"\u0004\b\u0001\u0010D\"\u0004\b\u0002\u0010H\"\u0004\b\u0003\u0010M\"\u0004\b\u0004\u0010R\"\u0004\b\u0005\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00030\u00042\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00040\u00042:\u0010E\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140TH\u0007ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a-\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010X\u001a\u00020WH\u0007¢\u0006\u0004\bY\u0010Z\u001a-\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010X\u001a\u00020WH\u0007¢\u0006\u0004\b[\u0010Z\u001ag\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u000427\u0010E\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\\\u0010\u001f\u001ap\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042F\u00105\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u001403H\u0007ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a%\u0010_\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b_\u0010$\u001a-\u0010a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010`\u001a\u00020)H\u0007¢\u0006\u0004\ba\u0010,\u001a%\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\bb\u0010$\u001a-\u0010c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010`\u001a\u00020)H\u0007¢\u0006\u0004\bc\u0010,\u001a%\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\bd\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006e"}, d2 = {"", am.ax, "()Ljava/lang/Void;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "q", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", "y", "J", "fallback", "r", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "s", "Lh/t1;", "G", "(Lkotlinx/coroutines/flow/Flow;)V", "Lkotlin/Function2;", "Lh/e2/c;", "", "onEach", "H", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;)V", "", "onError", ExpandableTextView.P, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;Lh/k2/u/p;)V", "R", "mapper", NotifyType.LIGHTS, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "g", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/l;)Lkotlinx/coroutines/flow/Flow;", "o", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "m", "Lh/q;", "transformer", "f", "", "count", "D", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "Lh/k0;", "name", "value", "action", "n", "initial", "Lkotlin/Function3;", "accumulator", "operation", "B", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", am.aI, "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "", "predicate", am.aH, "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lh/k2/u/l;)Lkotlinx/coroutines/flow/Flow;", ExifInterface.LONGITUDE_EAST, "other", "F", "h", "i", "T1", "T2", "transform", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", "T3", "other2", "Lkotlin/Function4;", "c", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/r;)Lkotlinx/coroutines/flow/Flow;", "T4", "other3", "Lkotlin/Function5;", f.f10128d, "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/s;)Lkotlinx/coroutines/flow/Flow;", "T5", "other4", "Lkotlin/Function6;", e.a, "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/t;)Lkotlinx/coroutines/flow/Flow;", "", "timeMillis", "k", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "j", "K", "C", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", IAdInterListener.AdReqParam.WIDTH, "bufferSize", "x", am.aD, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, am.av, "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__MigrationKt {
    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @q0(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @d
    public static final <T> Flow<T> A(@d Flow<? extends T> flow, int i2) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @q0(expression = "scan(initial, operation)", imports = {}))
    @d
    public static final <T, R> Flow<R> B(@d Flow<? extends T> flow, R r, @b @d q<? super R, ? super T, ? super c<? super R>, ? extends Object> qVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.WARNING, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @q0(expression = "runningReduce(operation)", imports = {}))
    @d
    public static final <T> Flow<T> C(@d Flow<? extends T> flow, @d q<? super T, ? super T, ? super c<? super T>, ? extends Object> qVar) {
        return h.K1(flow, qVar);
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @q0(expression = "drop(count)", imports = {}))
    @d
    public static final <T> Flow<T> D(@d Flow<? extends T> flow, int i2) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @q0(expression = "onStart { emit(value) }", imports = {}))
    @d
    public static final <T> Flow<T> E(@d Flow<? extends T> flow, T t) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @q0(expression = "onStart { emitAll(other) }", imports = {}))
    @d
    public static final <T> Flow<T> F(@d Flow<? extends T> flow, @d Flow<? extends T> flow2) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void G(@d Flow<? extends T> flow) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void H(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super t1>, ? extends Object> pVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void I(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super t1>, ? extends Object> pVar, @d p<? super Throwable, ? super c<? super t1>, ? extends Object> pVar2) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @d
    public static final <T> Flow<T> J(@d Flow<? extends T> flow, @d CoroutineContext coroutineContext) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @q0(expression = "this.flatMapLatest(transform)", imports = {}))
    @d
    public static final <T, R> Flow<R> K(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super Flow<? extends R>>, ? extends Object> pVar) {
        return h.m2(flow, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(pVar, null));
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @q0(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @d
    public static final <T> Flow<T> a(@d Flow<? extends T> flow) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @q0(expression = "this.combine(other, transform)", imports = {}))
    @d
    public static final <T1, T2, R> Flow<R> b(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return h.I(flow, flow2, qVar);
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @q0(expression = "combine(this, other, other2, transform)", imports = {}))
    @d
    public static final <T1, T2, T3, R> Flow<R> c(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d Flow<? extends T3> flow3, @d r<? super T1, ? super T2, ? super T3, ? super c<? super R>, ? extends Object> rVar) {
        return h.J(flow, flow2, flow3, rVar);
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @q0(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @d
    public static final <T1, T2, T3, T4, R> Flow<R> d(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d Flow<? extends T3> flow3, @d Flow<? extends T4> flow4, @d s<? super T1, ? super T2, ? super T3, ? super T4, ? super c<? super R>, ? extends Object> sVar) {
        return h.K(flow, flow2, flow3, flow4, sVar);
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @q0(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @d
    public static final <T1, T2, T3, T4, T5, R> Flow<R> e(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d Flow<? extends T3> flow3, @d Flow<? extends T4> flow4, @d Flow<? extends T5> flow5, @d t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super c<? super R>, ? extends Object> tVar) {
        return h.L(flow, flow2, flow3, flow4, flow5, tVar);
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @q0(expression = "let(transformer)", imports = {}))
    @d
    public static final <T, R> Flow<R> f(@d Flow<? extends T> flow, @d l<? super Flow<? extends T>, ? extends Flow<? extends R>> lVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @q0(expression = "flatMapConcat(mapper)", imports = {}))
    @d
    public static final <T, R> Flow<R> g(@d Flow<? extends T> flow, @d l<? super T, ? extends Flow<? extends R>> lVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @q0(expression = "onCompletion { emit(value) }", imports = {}))
    @d
    public static final <T> Flow<T> h(@d Flow<? extends T> flow, T t) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith = @q0(expression = "onCompletion { emitAll(other) }", imports = {}))
    @d
    public static final <T> Flow<T> i(@d Flow<? extends T> flow, @d Flow<? extends T> flow2) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.WARNING, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @q0(expression = "onEach { delay(timeMillis) }", imports = {}))
    @d
    public static final <T> Flow<T> j(@d Flow<? extends T> flow, long j2) {
        return h.m1(flow, new FlowKt__MigrationKt$delayEach$1(j2, null));
    }

    @i(level = DeprecationLevel.WARNING, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @q0(expression = "onStart { delay(timeMillis) }", imports = {}))
    @d
    public static final <T> Flow<T> k(@d Flow<? extends T> flow, long j2) {
        return h.v1(flow, new FlowKt__MigrationKt$delayFlow$1(j2, null));
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @q0(expression = "flatMapConcat(mapper)", imports = {}))
    @d
    public static final <T, R> Flow<R> l(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super Flow<? extends R>>, ? extends Object> pVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @q0(expression = "flattenConcat()", imports = {}))
    @d
    public static final <T> Flow<T> m(@d Flow<? extends Flow<? extends T>> flow) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @q0(expression = "collect(block)", imports = {}))
    public static final <T> void n(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super t1>, ? extends Object> pVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @q0(expression = "flattenConcat()", imports = {}))
    @d
    public static final <T> Flow<T> o(@d Flow<? extends Flow<? extends T>> flow) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @d
    public static final Void p() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @i(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @d
    public static final <T> Flow<T> q(@d Flow<? extends T> flow, @d CoroutineContext coroutineContext) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @q0(expression = "catch { emitAll(fallback) }", imports = {}))
    @d
    public static final <T> Flow<T> r(@d Flow<? extends T> flow, @d Flow<? extends T> flow2) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @q0(expression = "catch { emitAll(fallback) }", imports = {}))
    @d
    public static final <T> Flow<T> s(@d Flow<? extends T> flow, @d Flow<? extends T> flow2) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @q0(expression = "catch { emit(fallback) }", imports = {}))
    @d
    public static final <T> Flow<T> t(@d Flow<? extends T> flow, T t) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @q0(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @d
    public static final <T> Flow<T> u(@d Flow<? extends T> flow, T t, @d l<? super Throwable, Boolean> lVar) {
        return h.w(flow, new FlowKt__MigrationKt$onErrorReturn$2(lVar, t, null));
    }

    public static /* synthetic */ Flow v(Flow flow, Object obj, l lVar, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            lVar = FlowKt__MigrationKt$onErrorReturn$1.INSTANCE;
        }
        return h.t1(flow, obj, lVar);
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @q0(expression = "this.shareIn(scope, 0)", imports = {}))
    @d
    public static final <T> Flow<T> w(@d Flow<? extends T> flow) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @q0(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @d
    public static final <T> Flow<T> x(@d Flow<? extends T> flow, int i2) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @d
    public static final <T> Flow<T> y(@d Flow<? extends T> flow, @d CoroutineContext coroutineContext) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @q0(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @d
    public static final <T> Flow<T> z(@d Flow<? extends T> flow) {
        h.j1();
        throw new KotlinNothingValueException();
    }
}
