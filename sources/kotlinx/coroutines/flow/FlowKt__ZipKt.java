package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.b;
import h.e2.c;
import h.k2.g;
import h.k2.u.a;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.u.r;
import h.k2.u.s;
import h.k2.u.t;
import h.k2.u.u;
import h.k2.v.c0;
import h.k2.v.f0;
import h.r0;
import h.t1;
import i.b.v3.h;
import java.util.Objects;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0006\u001a\u008a\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032F\u0010\f\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u008c\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032F\u0010\f\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u009d\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032Y\b\u0001\u0010\f\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0012\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u009f\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032Y\b\u0001\u0010\f\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0012\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011¢\u0006\u0002\b\u0014ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u008a\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u000320\b\u0001\u0010\f\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u009b\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032A\b\u0001\u0010\f\u001a;\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001c¢\u0006\u0002\b\u0014ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a¢\u0001\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u000324\u0010\f\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001cø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aµ\u0001\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u00032G\b\u0001\u0010\f\u001aA\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0#¢\u0006\u0002\b\u0014ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a¼\u0001\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010&\"\u0004\b\u0005\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032:\u0010\f\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0#ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001aÏ\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010&\"\u0004\b\u0005\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032M\b\u0001\u0010\f\u001aG\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0*¢\u0006\u0002\b\u0014ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001as\u00101\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032*\b\u0004\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b00H\u0086\bø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u0084\u0001\u00103\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032;\b\u0005\u0010\f\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000¢\u0006\u0004\b3\u00104\u001as\u00105\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032*\b\u0004\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b00H\u0082\bø\u0001\u0000¢\u0006\u0004\b5\u00102\u001a\u0084\u0001\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032;\b\u0005\u0010\f\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\b\u0014H\u0082\bø\u0001\u0000¢\u0006\u0004\b6\u00104\u001a#\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010.07\"\u0004\b\u0000\u0010-H\u0002¢\u0006\u0004\b8\u00109\u001ag\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030:2*\b\u0004\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b00H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010;\u001ax\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030:2;\b\u0005\u0010\f\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001aj\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005ø\u0001\u0000¢\u0006\u0004\b?\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlin/Function3;", "Lh/k0;", "name", am.av, "b", "Lh/e2/c;", "", "transform", am.ax, "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", "flow2", "c", "Lkotlin/Function4;", "Li/b/v3/f;", "Lh/t1;", "Lh/q;", "q", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/r;)Lkotlinx/coroutines/flow/Flow;", "i", "T3", "flow3", f.f10128d, "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/r;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "j", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/s;)Lkotlinx/coroutines/flow/Flow;", "T4", "flow4", e.a, "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/s;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function6;", "k", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/t;)Lkotlinx/coroutines/flow/Flow;", "T5", "flow5", "f", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/t;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function7;", NotifyType.LIGHTS, "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/u;)Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "", "flows", "Lkotlin/Function2;", "g", "([Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "m", "([Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", "o", "n", "Lkotlin/Function0;", "r", "()Lh/k2/u/a;", "", "(Ljava/lang/Iterable;Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "h", "(Ljava/lang/Iterable;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", "other", "s", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__ZipKt {
    @d
    public static final /* synthetic */ <T, R> Flow<R> b(@d Iterable<? extends Flow<? extends T>> iterable, @d p<? super T[], ? super c<? super R>, ? extends Object> pVar) {
        Object[] array = CollectionsKt___CollectionsKt.I5(iterable).toArray(new Flow[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        f0.w();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$4((Flow[]) array, pVar);
    }

    @d
    public static final <T1, T2, R> Flow<R> c(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return h.O0(flow, flow2, qVar);
    }

    @d
    public static final <T1, T2, T3, R> Flow<R> d(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d Flow<? extends T3> flow3, @b @d final r<? super T1, ? super T2, ? super T3, ? super c<? super R>, ? extends Object> rVar) {
        final Flow[] flowArr = {flow, flow2, flow3};
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            @h.e2.k.a.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", i = {0, 0, 0, 0, 1, 1}, l = {336, 336}, m = "invokeSuspend", n = {"$this$combineInternal", AdvanceSetting.NETWORK_TYPE, "continuation", "args", "$this$combineInternal", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/v3/f;", "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements q<i.b.v3.f<? super R>, Object[], c<? super t1>, Object> {
                public Object L$0;
                public Object L$1;
                public Object L$2;
                public Object L$3;
                public Object L$4;
                public int label;
                private i.b.v3.f p$;
                private Object[] p$0;
                public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(c cVar, FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1) {
                    super(3, cVar);
                    this.this$0 = flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1;
                }

                @d
                public final c<t1> create(@d i.b.v3.f<? super R> fVar, @d Object[] objArr, @d c<? super t1> cVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar, this.this$0);
                    anonymousClass2.p$ = fVar;
                    anonymousClass2.p$0 = objArr;
                    return anonymousClass2;
                }

                @Override // h.k2.u.q
                public final Object invoke(Object obj, Object[] objArr, c<? super t1> cVar) {
                    return ((AnonymousClass2) create((i.b.v3.f) obj, objArr, cVar)).invokeSuspend(t1.a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @k.e.a.e
                public final Object invokeSuspend(@d Object obj) {
                    i.b.v3.f fVar;
                    i.b.v3.f fVar2;
                    Object[] objArr;
                    Object h2 = h.e2.j.b.h();
                    int i2 = this.label;
                    if (i2 == 0) {
                        r0.n(obj);
                        fVar = this.p$;
                        Object[] objArr2 = this.p$0;
                        r rVar = rVar;
                        Object obj2 = objArr2[0];
                        Object obj3 = objArr2[1];
                        Object obj4 = objArr2[2];
                        this.L$0 = fVar;
                        this.L$1 = objArr2;
                        this.L$2 = fVar;
                        this.L$3 = this;
                        this.L$4 = objArr2;
                        this.label = 1;
                        c0.e(6);
                        Object invoke = rVar.invoke(obj2, obj3, obj4, this);
                        c0.e(7);
                        if (invoke == h2) {
                            return h2;
                        }
                        fVar2 = fVar;
                        objArr = objArr2;
                        obj = invoke;
                    } else if (i2 != 1) {
                        if (i2 == 2) {
                            Object[] objArr3 = (Object[]) this.L$1;
                            i.b.v3.f fVar3 = (i.b.v3.f) this.L$0;
                            r0.n(obj);
                            return t1.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object[] objArr4 = (Object[]) this.L$4;
                        c cVar = (c) this.L$3;
                        fVar = (i.b.v3.f) this.L$2;
                        objArr = (Object[]) this.L$1;
                        fVar2 = (i.b.v3.f) this.L$0;
                        r0.n(obj);
                    }
                    this.L$0 = fVar2;
                    this.L$1 = objArr;
                    this.label = 2;
                    if (fVar.emit(obj, this) == h2) {
                        return h2;
                    }
                    return t1.a;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d i.b.v3.f fVar, @d c cVar) {
                a r;
                Flow[] flowArr2 = flowArr;
                r = FlowKt__ZipKt.r();
                Object a = CombineKt.a(fVar, flowArr2, r, new AnonymousClass2(null, this), cVar);
                return a == h.e2.j.b.h() ? a : t1.a;
            }
        };
    }

    @d
    public static final <T1, T2, T3, T4, R> Flow<R> e(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d Flow<? extends T3> flow3, @d Flow<? extends T4> flow4, @d final s<? super T1, ? super T2, ? super T3, ? super T4, ? super c<? super R>, ? extends Object> sVar) {
        final Flow[] flowArr = {flow, flow2, flow3, flow4};
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "", "invoke", "()[Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$2$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2 extends Lambda implements a<Object[]> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // h.k2.u.a
                @k.e.a.e
                public final Object[] invoke() {
                    return new Object[flowArr.length];
                }
            }

            @h.e2.k.a.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$3", f = "Zip.kt", i = {0, 0, 0, 0, 1, 1}, l = {337, 337}, m = "invokeSuspend", n = {"$this$combineInternal", AdvanceSetting.NETWORK_TYPE, "continuation", "args", "$this$combineInternal", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/v3/f;", "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$2$lambda$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$3  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements q<i.b.v3.f<? super R>, Object[], c<? super t1>, Object> {
                public Object L$0;
                public Object L$1;
                public Object L$2;
                public Object L$3;
                public Object L$4;
                public int label;
                private i.b.v3.f p$;
                private Object[] p$0;
                public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combine$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(c cVar, FlowKt__ZipKt$combine$$inlined$combine$1 flowKt__ZipKt$combine$$inlined$combine$1) {
                    super(3, cVar);
                    this.this$0 = flowKt__ZipKt$combine$$inlined$combine$1;
                }

                @d
                public final c<t1> create(@d i.b.v3.f<? super R> fVar, @d Object[] objArr, @d c<? super t1> cVar) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(cVar, this.this$0);
                    anonymousClass3.p$ = fVar;
                    anonymousClass3.p$0 = objArr;
                    return anonymousClass3;
                }

                @Override // h.k2.u.q
                public final Object invoke(Object obj, Object[] objArr, c<? super t1> cVar) {
                    return ((AnonymousClass3) create((i.b.v3.f) obj, objArr, cVar)).invokeSuspend(t1.a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @k.e.a.e
                public final Object invokeSuspend(@d Object obj) {
                    i.b.v3.f fVar;
                    i.b.v3.f fVar2;
                    Object[] objArr;
                    Object h2 = h.e2.j.b.h();
                    int i2 = this.label;
                    if (i2 == 0) {
                        r0.n(obj);
                        fVar = this.p$;
                        Object[] objArr2 = this.p$0;
                        s sVar = sVar;
                        Object obj2 = objArr2[0];
                        Object obj3 = objArr2[1];
                        Object obj4 = objArr2[2];
                        Object obj5 = objArr2[3];
                        this.L$0 = fVar;
                        this.L$1 = objArr2;
                        this.L$2 = fVar;
                        this.L$3 = this;
                        this.L$4 = objArr2;
                        this.label = 1;
                        c0.e(6);
                        Object invoke = sVar.invoke(obj2, obj3, obj4, obj5, this);
                        c0.e(7);
                        if (invoke == h2) {
                            return h2;
                        }
                        fVar2 = fVar;
                        objArr = objArr2;
                        obj = invoke;
                    } else if (i2 != 1) {
                        if (i2 == 2) {
                            Object[] objArr3 = (Object[]) this.L$1;
                            i.b.v3.f fVar3 = (i.b.v3.f) this.L$0;
                            r0.n(obj);
                            return t1.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object[] objArr4 = (Object[]) this.L$4;
                        c cVar = (c) this.L$3;
                        fVar = (i.b.v3.f) this.L$2;
                        objArr = (Object[]) this.L$1;
                        fVar2 = (i.b.v3.f) this.L$0;
                        r0.n(obj);
                    }
                    this.L$0 = fVar2;
                    this.L$1 = objArr;
                    this.label = 2;
                    if (fVar.emit(obj, this) == h2) {
                        return h2;
                    }
                    return t1.a;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d i.b.v3.f fVar, @d c cVar) {
                Object a = CombineKt.a(fVar, flowArr, new AnonymousClass2(), new AnonymousClass3(null, this), cVar);
                return a == h.e2.j.b.h() ? a : t1.a;
            }
        };
    }

    @d
    public static final <T1, T2, T3, T4, T5, R> Flow<R> f(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d Flow<? extends T3> flow3, @d Flow<? extends T4> flow4, @d Flow<? extends T5> flow5, @d final t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super c<? super R>, ? extends Object> tVar) {
        final Flow[] flowArr = {flow, flow2, flow3, flow4, flow5};
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            @h.e2.k.a.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", i = {0, 0, 0, 0, 1, 1}, l = {338, 338}, m = "invokeSuspend", n = {"$this$combineInternal", AdvanceSetting.NETWORK_TYPE, "continuation", "args", "$this$combineInternal", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/v3/f;", "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements q<i.b.v3.f<? super R>, Object[], c<? super t1>, Object> {
                public Object L$0;
                public Object L$1;
                public Object L$2;
                public Object L$3;
                public Object L$4;
                public int label;
                private i.b.v3.f p$;
                private Object[] p$0;
                public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(c cVar, FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2) {
                    super(3, cVar);
                    this.this$0 = flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2;
                }

                @d
                public final c<t1> create(@d i.b.v3.f<? super R> fVar, @d Object[] objArr, @d c<? super t1> cVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar, this.this$0);
                    anonymousClass2.p$ = fVar;
                    anonymousClass2.p$0 = objArr;
                    return anonymousClass2;
                }

                @Override // h.k2.u.q
                public final Object invoke(Object obj, Object[] objArr, c<? super t1> cVar) {
                    return ((AnonymousClass2) create((i.b.v3.f) obj, objArr, cVar)).invokeSuspend(t1.a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @k.e.a.e
                public final Object invokeSuspend(@d Object obj) {
                    i.b.v3.f fVar;
                    i.b.v3.f fVar2;
                    Object[] objArr;
                    Object h2 = h.e2.j.b.h();
                    int i2 = this.label;
                    if (i2 == 0) {
                        r0.n(obj);
                        fVar = this.p$;
                        Object[] objArr2 = this.p$0;
                        t tVar = tVar;
                        Object obj2 = objArr2[0];
                        Object obj3 = objArr2[1];
                        Object obj4 = objArr2[2];
                        Object obj5 = objArr2[3];
                        Object obj6 = objArr2[4];
                        this.L$0 = fVar;
                        this.L$1 = objArr2;
                        this.L$2 = fVar;
                        this.L$3 = this;
                        this.L$4 = objArr2;
                        this.label = 1;
                        c0.e(6);
                        Object invoke = tVar.invoke(obj2, obj3, obj4, obj5, obj6, this);
                        c0.e(7);
                        if (invoke == h2) {
                            return h2;
                        }
                        fVar2 = fVar;
                        objArr = objArr2;
                        obj = invoke;
                    } else if (i2 != 1) {
                        if (i2 == 2) {
                            Object[] objArr3 = (Object[]) this.L$1;
                            i.b.v3.f fVar3 = (i.b.v3.f) this.L$0;
                            r0.n(obj);
                            return t1.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object[] objArr4 = (Object[]) this.L$4;
                        c cVar = (c) this.L$3;
                        fVar = (i.b.v3.f) this.L$2;
                        objArr = (Object[]) this.L$1;
                        fVar2 = (i.b.v3.f) this.L$0;
                        r0.n(obj);
                    }
                    this.L$0 = fVar2;
                    this.L$1 = objArr;
                    this.label = 2;
                    if (fVar.emit(obj, this) == h2) {
                        return h2;
                    }
                    return t1.a;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d i.b.v3.f fVar, @d c cVar) {
                a r;
                Flow[] flowArr2 = flowArr;
                r = FlowKt__ZipKt.r();
                Object a = CombineKt.a(fVar, flowArr2, r, new AnonymousClass2(null, this), cVar);
                return a == h.e2.j.b.h() ? a : t1.a;
            }
        };
    }

    @d
    public static final /* synthetic */ <T, R> Flow<R> h(@d Iterable<? extends Flow<? extends T>> iterable, @b @d q<? super i.b.v3.f<? super R>, ? super T[], ? super c<? super t1>, ? extends Object> qVar) {
        Object[] array = CollectionsKt___CollectionsKt.I5(iterable).toArray(new Flow[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        f0.w();
        return h.N0(new FlowKt__ZipKt$combineTransform$7((Flow[]) array, qVar, null));
    }

    @d
    public static final <T1, T2, R> Flow<R> i(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @b @d r<? super i.b.v3.f<? super R>, ? super T1, ? super T2, ? super c<? super t1>, ? extends Object> rVar) {
        return h.N0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2(new Flow[]{flow, flow2}, null, rVar));
    }

    @d
    public static final <T1, T2, T3, R> Flow<R> j(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d Flow<? extends T3> flow3, @b @d s<? super i.b.v3.f<? super R>, ? super T1, ? super T2, ? super T3, ? super c<? super t1>, ? extends Object> sVar) {
        return h.N0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(new Flow[]{flow, flow2, flow3}, null, sVar));
    }

    @d
    public static final <T1, T2, T3, T4, R> Flow<R> k(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d Flow<? extends T3> flow3, @d Flow<? extends T4> flow4, @b @d t<? super i.b.v3.f<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super c<? super t1>, ? extends Object> tVar) {
        return h.N0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(new Flow[]{flow, flow2, flow3, flow4}, null, tVar));
    }

    @d
    public static final <T1, T2, T3, T4, T5, R> Flow<R> l(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d Flow<? extends T3> flow3, @d Flow<? extends T4> flow4, @d Flow<? extends T5> flow5, @b @d u<? super i.b.v3.f<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super c<? super t1>, ? extends Object> uVar) {
        return h.N0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(new Flow[]{flow, flow2, flow3, flow4, flow5}, null, uVar));
    }

    private static final /* synthetic */ <T, R> Flow<R> o(Flow<? extends T>[] flowArr, p<? super T[], ? super c<? super R>, ? extends Object> pVar) {
        return new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$3(flowArr, pVar);
    }

    @g(name = "flowCombine")
    @d
    public static final <T1, T2, R> Flow<R> p(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(flow, flow2, qVar);
    }

    @g(name = "flowCombineTransform")
    @d
    public static final <T1, T2, R> Flow<R> q(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @b @d r<? super i.b.v3.f<? super R>, ? super T1, ? super T2, ? super c<? super t1>, ? extends Object> rVar) {
        return h.N0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1(new Flow[]{flow, flow2}, null, rVar));
    }

    public static final <T> a<T[]> r() {
        return FlowKt__ZipKt$nullArrayFactory$1.INSTANCE;
    }

    @d
    public static final <T1, T2, R> Flow<R> s(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return CombineKt.b(flow, flow2, qVar);
    }
}
