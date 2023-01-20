package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.i;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.f0;
import h.m;
import h.t1;
import i.b.a2;
import i.b.a3;
import i.b.b0;
import i.b.b2;
import i.b.c2;
import i.b.e1;
import i.b.h1;
import i.b.h2;
import i.b.i2;
import i.b.m2;
import i.b.o;
import i.b.o2;
import i.b.q;
import i.b.q0;
import i.b.r0;
import i.b.r2;
import i.b.r3;
import i.b.t;
import i.b.u;
import i.b.u1;
import i.b.u2;
import i.b.v;
import i.b.v1;
import i.b.v2;
import i.b.w3.h0;
import i.b.w3.i0;
import i.b.w3.r;
import i.b.w3.s;
import i.b.x1;
import i.b.z1;
import i.b.z2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004|xÎ\u0001B\u0012\u0012\u0007\u0010Ë\u0001\u001a\u00020\u001b¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J&\u0010\n\u001a\u00020\t2\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0082\b¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\u0007*\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b'\u0010$J2\u0010)\u001a\u00020\u0007\"\u000e\b\u0000\u0010\u0017\u0018\u0001*\u0006\u0012\u0002\b\u00030(2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0082\b¢\u0006\u0004\b)\u0010$J\u0019\u0010+\u001a\u00020*2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b+\u0010,JD\u00102\u001a\u0006\u0012\u0002\b\u00030(2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`/2\u0006\u00101\u001a\u00020\u001bH\u0002¢\u0006\u0004\b2\u00103J+\u00106\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\n\u00105\u001a\u0006\u0012\u0002\b\u00030(H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00072\u0006\u0010\r\u001a\u000208H\u0002¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00072\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030(H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u001bH\u0002¢\u0006\u0004\b=\u0010>J\u001b\u0010?\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b?\u0010@J\u0019\u0010A\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bA\u0010BJ\u001b\u0010C\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bC\u0010@J\u0019\u0010D\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u0019H\u0002¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\bF\u0010GJ%\u0010H\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bH\u0010IJ#\u0010J\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bJ\u0010KJ\u0019\u0010M\u001a\u0004\u0018\u00010L2\u0006\u0010\r\u001a\u00020\u0019H\u0002¢\u0006\u0004\bM\u0010NJ*\u0010P\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010O\u001a\u00020L2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0082\u0010¢\u0006\u0004\bP\u0010QJ)\u0010S\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010R\u001a\u00020L2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bS\u0010TJ\u0015\u0010V\u001a\u0004\u0018\u00010L*\u00020UH\u0002¢\u0006\u0004\bV\u0010WJ\u0019\u0010Y\u001a\u00020X2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bY\u0010ZJ\u0019\u0010\\\u001a\u00020\u00072\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\\\u0010]J\r\u0010^\u001a\u00020\u001b¢\u0006\u0004\b^\u0010>J\u000f\u0010_\u001a\u00020\u0007H\u0010¢\u0006\u0004\b_\u0010`J\u0011\u0010c\u001a\u00060aj\u0002`b¢\u0006\u0004\bc\u0010dJ#\u0010f\u001a\u00060aj\u0002`b*\u00020\u00122\n\b\u0002\u0010e\u001a\u0004\u0018\u00010XH\u0004¢\u0006\u0004\bf\u0010gJ6\u0010i\u001a\u00020h2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`/¢\u0006\u0004\bi\u0010jJF\u0010l\u001a\u00020h2\u0006\u00101\u001a\u00020\u001b2\u0006\u0010k\u001a\u00020\u001b2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`/¢\u0006\u0004\bl\u0010mJ\u0013\u0010n\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ\u0013\u0010p\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\bp\u0010oJB\u0010u\u001a\u00020\u0007\"\u0004\b\u0000\u0010q2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000r2\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000t\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005ø\u0001\u0000¢\u0006\u0004\bu\u0010vJ\u001b\u0010w\u001a\u00020\u00072\n\u00105\u001a\u0006\u0012\u0002\b\u00030(H\u0000¢\u0006\u0004\bw\u0010<J\u001f\u0010x\u001a\u00020\u00072\u000e\u0010\"\u001a\n\u0018\u00010aj\u0004\u0018\u0001`bH\u0016¢\u0006\u0004\bx\u0010yJ\u000f\u0010z\u001a\u00020XH\u0014¢\u0006\u0004\bz\u0010{J\u0019\u0010|\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\b|\u0010&J\u0017\u0010}\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0016¢\u0006\u0004\b}\u0010~J\u0018\u0010\u0080\u0001\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u0003¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0012H\u0016¢\u0006\u0005\b\u0082\u0001\u0010&J\u0019\u0010\u0083\u0001\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0012¢\u0006\u0005\b\u0083\u0001\u0010&J\u001c\u0010\u0084\u0001\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J,\u0010\u0087\u0001\u001a\u00030\u0086\u00012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0080\b¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0015\u0010\u0089\u0001\u001a\u00060aj\u0002`bH\u0016¢\u0006\u0005\b\u0089\u0001\u0010dJ\u001c\u0010\u008a\u0001\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u0085\u0001J\u001d\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0005\b\u008b\u0001\u0010@J\u0019\u0010\u008d\u0001\u001a\u00030\u008c\u00012\u0006\u0010O\u001a\u00020\u0002¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001a\u0010\u0090\u0001\u001a\u00020\u00072\u0007\u0010\u008f\u0001\u001a\u00020\u0012H\u0010¢\u0006\u0005\b\u0090\u0001\u0010~J\u001b\u0010\u0091\u0001\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0005\b\u0091\u0001\u0010~J\u001a\u0010\u0092\u0001\u001a\u00020\u001b2\u0007\u0010\u008f\u0001\u001a\u00020\u0012H\u0014¢\u0006\u0005\b\u0092\u0001\u0010&J\u001c\u0010\u0093\u0001\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001c\u0010\u0095\u0001\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0006\b\u0095\u0001\u0010\u0094\u0001J\u0011\u0010\u0096\u0001\u001a\u00020XH\u0016¢\u0006\u0005\b\u0096\u0001\u0010{J\u0011\u0010\u0097\u0001\u001a\u00020XH\u0007¢\u0006\u0005\b\u0097\u0001\u0010{J\u0011\u0010\u0098\u0001\u001a\u00020XH\u0010¢\u0006\u0005\b\u0098\u0001\u0010{J\u0012\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0012¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0014\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u0017\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0006H\u0080@ø\u0001\u0000¢\u0006\u0005\b\u009d\u0001\u0010oJ\u0017\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0005\b\u009e\u0001\u0010oJT\u0010 \u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010q2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00010r2#\u0010\b\u001a\u001f\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010t\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u009f\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010¡\u0001JT\u0010¢\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010q2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00010r2#\u0010\b\u001a\u001f\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010t\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u009f\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b¢\u0001\u0010¡\u0001R\u0018\u0010¤\u0001\u001a\u00020\u001b8P@\u0010X\u0090\u0004¢\u0006\u0007\u001a\u0005\b£\u0001\u0010>R\u0018\u0010¦\u0001\u001a\u00020\u001b8T@\u0014X\u0094\u0004¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010>R\u0018\u0010¨\u0001\u001a\u00020\u001b8D@\u0004X\u0084\u0004¢\u0006\u0007\u001a\u0005\b§\u0001\u0010>R0\u0010®\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010©\u0001\u001a\u0005\u0018\u00010\u008c\u00018@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010°\u0001\u001a\u0004\u0018\u00010\u00128D@\u0004X\u0084\u0004¢\u0006\b\u001a\u0006\b¯\u0001\u0010\u009a\u0001R\u001d\u0010³\u0001\u001a\u00020\u001b*\u00020\u00198B@\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001R\u0018\u0010µ\u0001\u001a\u00020\u001b8V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010>R\u0015\u0010·\u0001\u001a\u00020\u001b8F@\u0006¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010>R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00068@@\u0000X\u0080\u0004¢\u0006\b\u001a\u0006\b¸\u0001\u0010\u009c\u0001R\u0015\u0010º\u0001\u001a\u00020\u001b8F@\u0006¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010>R \u0010¼\u0001\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\u00068B@\u0002X\u0082\u0004¢\u0006\u0007\u001a\u0005\b»\u0001\u0010BR\u0015\u0010½\u0001\u001a\u00020\u001b8F@\u0006¢\u0006\u0007\u001a\u0005\b½\u0001\u0010>R\u0016\u0010À\u0001\u001a\u00020\u00048F@\u0006¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u001d\u0010Ä\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010Á\u00018F@\u0006¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u001b\u0010È\u0001\u001a\u0007\u0012\u0002\b\u00030Å\u00018F@\u0006¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0018\u0010Ê\u0001\u001a\u00020\u001b8P@\u0010X\u0090\u0004¢\u0006\u0007\u001a\u0005\bÉ\u0001\u0010>\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Ï\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Li/b/b2;", "Li/b/v;", "Li/b/r2;", "Li/b/z3/c;", "Lkotlin/Function1;", "", "Lh/t1;", ReportItem.LogTypeBlock, "", "I0", "(Lh/k2/u/l;)Ljava/lang/Void;", "Lkotlinx/coroutines/JobSupport$c;", "state", "proposedUpdate", "l0", "(Lkotlinx/coroutines/JobSupport$c;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "s0", "(Lkotlinx/coroutines/JobSupport$c;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Throwable;Ljava/util/List;)V", "Li/b/v1;", "update", "", "g1", "(Li/b/v1;Ljava/lang/Object;)Z", "g0", "(Li/b/v1;Ljava/lang/Object;)V", "Li/b/m2;", "list", "cause", "P0", "(Li/b/m2;Ljava/lang/Throwable;)V", "d0", "(Ljava/lang/Throwable;)Z", "Q0", "Li/b/h2;", "R0", "", "b1", "(Ljava/lang/Object;)I", "Lh/k0;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "M0", "(Lh/k2/u/l;Z)Li/b/h2;", "expect", "node", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/Object;Li/b/m2;Li/b/h2;)Z", "Li/b/h1;", "V0", "(Li/b/h1;)V", "W0", "(Li/b/h2;)V", "G0", "()Z", "c0", "(Ljava/lang/Object;)Ljava/lang/Object;", "i0", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "J0", "w0", "(Li/b/v1;)Li/b/m2;", "h1", "(Li/b/v1;Ljava/lang/Throwable;)Z", "i1", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "j1", "(Li/b/v1;Ljava/lang/Object;)Ljava/lang/Object;", "Li/b/u;", "m0", "(Li/b/v1;)Li/b/u;", "child", "k1", "(Lkotlinx/coroutines/JobSupport$c;Li/b/u;Ljava/lang/Object;)Z", "lastChild", "h0", "(Lkotlinx/coroutines/JobSupport$c;Li/b/u;Ljava/lang/Object;)V", "Li/b/w3/s;", "O0", "(Li/b/w3/s;)Li/b/u;", "", "c1", "(Ljava/lang/Object;)Ljava/lang/String;", "parent", "C0", "(Li/b/b2;)V", MessageKey.MSG_ACCEPT_TIME_START, "U0", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "q", "()Ljava/util/concurrent/CancellationException;", "message", "d1", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Li/b/e1;", "H", "(Lh/k2/u/l;)Li/b/e1;", "invokeImmediately", "i", "(ZZLh/k2/u/l;)Li/b/e1;", "Y", "(Lh/e2/c;)Ljava/lang/Object;", "H0", "R", "Li/b/z3/f;", "select", "Lh/e2/c;", "g", "(Li/b/z3/f;Lh/k2/u/l;)V", "Y0", "b", "(Ljava/util/concurrent/CancellationException;)V", "e0", "()Ljava/lang/String;", am.av, "b0", "(Ljava/lang/Throwable;)V", "parentJob", "s", "(Li/b/r2;)V", "f0", "Z", "a0", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/JobCancellationException;", "j0", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "M", "K0", "L0", "Li/b/t;", "x0", "(Li/b/v;)Li/b/t;", "exception", "B0", "S0", "A0", "T0", "(Ljava/lang/Object;)V", "U", "toString", "f1", "N0", "o", "()Ljava/lang/Throwable;", "n0", "()Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "Lkotlin/Function2;", "X0", "(Li/b/z3/f;Lh/k2/u/p;)V", "Z0", "v0", "onCancelComplete", "F0", "isScopedCoroutine", "q0", "completionCauseHandled", "value", "y0", "()Li/b/t;", "a1", "(Li/b/t;)V", "parentHandle", "p0", "completionCause", "D0", "(Li/b/v1;)Z", "isCancelling", "j", "isActive", "E0", "isCompletedExceptionally", "z0", NotifyType.LIGHTS, "isCompleted", "r0", "exceptionOrNull", "isCancelled", "o0", "()Li/b/z3/c;", "onJoin", "Lh/q2/m;", "k", "()Lh/q2/m;", "children", "Lkotlin/coroutines/CoroutineContext$b;", "getKey", "()Lkotlin/coroutines/CoroutineContext$b;", "key", "t0", "handlesException", "active", "<init>", "(Z)V", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@i(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
/* loaded from: classes4.dex */
public class JobSupport implements b2, v, r2, i.b.z3.c {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile Object _parentHandle;
    private volatile Object _state;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"kotlinx/coroutines/JobSupport$a", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/o;", "Li/b/b2;", "parent", "", am.aD, "(Li/b/b2;)Ljava/lang/Throwable;", "", "J", "()Ljava/lang/String;", "Lkotlinx/coroutines/JobSupport;", "h", "Lkotlinx/coroutines/JobSupport;", "job", "Lh/e2/c;", "delegate", "<init>", "(Lh/e2/c;Lkotlinx/coroutines/JobSupport;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a<T> extends o<T> {

        /* renamed from: h */
        private final JobSupport f16903h;

        public a(@k.e.a.d h.e2.c<? super T> cVar, @k.e.a.d JobSupport jobSupport) {
            super(cVar, 1);
            this.f16903h = jobSupport;
        }

        @Override // i.b.o
        @k.e.a.d
        public String J() {
            return "AwaitContinuation";
        }

        @Override // i.b.o
        @k.e.a.d
        public Throwable z(@k.e.a.d b2 b2Var) {
            Throwable e2;
            Object z0 = this.f16903h.z0();
            return (!(z0 instanceof c) || (e2 = ((c) z0).e()) == null) ? z0 instanceof b0 ? ((b0) z0).a : b2Var.q() : e2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"kotlinx/coroutines/JobSupport$b", "Li/b/h2;", "Li/b/b2;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "", "h", "Ljava/lang/Object;", "proposedUpdate", "Lkotlinx/coroutines/JobSupport$c;", "f", "Lkotlinx/coroutines/JobSupport$c;", "state", "Li/b/u;", "g", "Li/b/u;", "child", "Lkotlinx/coroutines/JobSupport;", e.a, "Lkotlinx/coroutines/JobSupport;", "parent", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$c;Li/b/u;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b extends h2<b2> {

        /* renamed from: e */
        private final JobSupport f16904e;

        /* renamed from: f */
        private final c f16905f;

        /* renamed from: g */
        private final u f16906g;

        /* renamed from: h */
        private final Object f16907h;

        public b(@k.e.a.d JobSupport jobSupport, @k.e.a.d c cVar, @k.e.a.d u uVar, @k.e.a.e Object obj) {
            super(uVar.f15846e);
            this.f16904e = jobSupport;
            this.f16905f = cVar;
            this.f16906g = uVar;
            this.f16907h = obj;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
            j0(th);
            return t1.a;
        }

        @Override // i.b.d0
        public void j0(@k.e.a.e Throwable th) {
            this.f16904e.h0(this.f16905f, this.f16906g, this.f16907h);
        }

        @Override // i.b.w3.s
        @k.e.a.d
        public String toString() {
            return "ChildCompletion[" + this.f16906g + ", " + this.f16907h + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010&\u001a\u00020\"\u0012\u0006\u0010*\u001a\u00020\u001e\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b/\u00100J\u001f\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0019\u001a\u0004\u0018\u00010\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0010R\u0013\u0010!\u001a\u00020\u001e8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010&\u001a\u00020\"8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010%R$\u0010*\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010 \"\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u001e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010 R\u0013\u0010.\u001a\u00020\u001e8F@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010 ¨\u00061"}, d2 = {"kotlinx/coroutines/JobSupport$c", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Li/b/v1;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "()Ljava/util/ArrayList;", "proposedException", "", "i", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "Lh/t1;", am.av, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "value", f.f10128d, "()Ljava/lang/Object;", NotifyType.LIGHTS, "(Ljava/lang/Object;)V", "exceptionsHolder", e.a, "()Ljava/lang/Throwable;", "m", "rootCause", "", "f", "()Z", "isCancelling", "Li/b/m2;", "Li/b/m2;", "c", "()Li/b/m2;", "list", "g", "k", "(Z)V", "isCompleting", "j", "isActive", "h", "isSealed", "<init>", "(Li/b/m2;ZLjava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c implements v1 {
        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        @k.e.a.d
        private final m2 a;

        public c(@k.e.a.d m2 m2Var, boolean z, @k.e.a.e Throwable th) {
            this.a = m2Var;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@k.e.a.d Throwable th) {
            Throwable e2 = e();
            if (e2 == null) {
                m(th);
            } else if (th == e2) {
            } else {
                Object d2 = d();
                if (d2 == null) {
                    l(th);
                } else if (!(d2 instanceof Throwable)) {
                    if (d2 instanceof ArrayList) {
                        ((ArrayList) d2).add(th);
                        return;
                    }
                    throw new IllegalStateException(("State is " + d2).toString());
                } else if (th == d2) {
                } else {
                    ArrayList<Throwable> b = b();
                    b.add(d2);
                    b.add(th);
                    t1 t1Var = t1.a;
                    l(b);
                }
            }
        }

        @Override // i.b.v1
        @k.e.a.d
        public m2 c() {
            return this.a;
        }

        @k.e.a.e
        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            i0 i0Var;
            Object d2 = d();
            i0Var = i2.f15748h;
            return d2 == i0Var;
        }

        @k.e.a.d
        public final List<Throwable> i(@k.e.a.e Throwable th) {
            ArrayList<Throwable> arrayList;
            i0 i0Var;
            Object d2 = d();
            if (d2 == null) {
                arrayList = b();
            } else if (d2 instanceof Throwable) {
                ArrayList<Throwable> b = b();
                b.add(d2);
                arrayList = b;
            } else if (!(d2 instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + d2).toString());
            } else {
                arrayList = (ArrayList) d2;
            }
            Throwable e2 = e();
            if (e2 != null) {
                arrayList.add(0, e2);
            }
            if (th != null && (!f0.g(th, e2))) {
                arrayList.add(th);
            }
            i0Var = i2.f15748h;
            l(i0Var);
            return arrayList;
        }

        @Override // i.b.v1
        public boolean j() {
            return e() == null;
        }

        public final void k(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void m(@k.e.a.e Throwable th) {
            this._rootCause = th;
        }

        @k.e.a.d
        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + c() + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b¸\u0006\t"}, d2 = {"kotlinx/coroutines/JobSupport$d", "Li/b/w3/s$c;", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "(Li/b/w3/s;)Ljava/lang/Object;", "kotlinx-coroutines-core", "i/b/w3/s$f"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class d extends s.c {

        /* renamed from: d */
        public final /* synthetic */ s f16908d;

        /* renamed from: e */
        public final /* synthetic */ JobSupport f16909e;

        /* renamed from: f */
        public final /* synthetic */ Object f16910f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(s sVar, s sVar2, JobSupport jobSupport, Object obj) {
            super(sVar2);
            this.f16908d = sVar;
            this.f16909e = jobSupport;
            this.f16910f = obj;
        }

        @Override // i.b.w3.d
        @k.e.a.e
        /* renamed from: k */
        public Object i(@k.e.a.d s sVar) {
            if (this.f16909e.z0() == this.f16910f) {
                return null;
            }
            return r.a();
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? i2.f15750j : i2.f15749i;
        this._parentHandle = null;
    }

    private final boolean D0(v1 v1Var) {
        return (v1Var instanceof c) && ((c) v1Var).f();
    }

    private final boolean G0() {
        Object z0;
        do {
            z0 = z0();
            if (!(z0 instanceof v1)) {
                return false;
            }
        } while (b1(z0) < 0);
        return true;
    }

    private final Void I0(l<Object, t1> lVar) {
        while (true) {
            lVar.invoke(z0());
        }
    }

    private final Object J0(Object obj) {
        i0 i0Var;
        i0 i0Var2;
        i0 i0Var3;
        i0 i0Var4;
        i0 i0Var5;
        i0 i0Var6;
        Throwable th = null;
        while (true) {
            Object z0 = z0();
            if (z0 instanceof c) {
                synchronized (z0) {
                    if (((c) z0).h()) {
                        i0Var2 = i2.f15744d;
                        return i0Var2;
                    }
                    boolean f2 = ((c) z0).f();
                    if (obj != null || !f2) {
                        if (th == null) {
                            th = i0(obj);
                        }
                        ((c) z0).a(th);
                    }
                    Throwable e2 = f2 ^ true ? ((c) z0).e() : null;
                    if (e2 != null) {
                        P0(((c) z0).c(), e2);
                    }
                    i0Var = i2.a;
                    return i0Var;
                }
            } else if (!(z0 instanceof v1)) {
                i0Var3 = i2.f15744d;
                return i0Var3;
            } else {
                if (th == null) {
                    th = i0(obj);
                }
                v1 v1Var = (v1) z0;
                if (v1Var.j()) {
                    if (h1(v1Var, th)) {
                        i0Var4 = i2.a;
                        return i0Var4;
                    }
                } else {
                    Object i1 = i1(z0, new b0(th, false, 2, null));
                    i0Var5 = i2.a;
                    if (i1 != i0Var5) {
                        i0Var6 = i2.f15743c;
                        if (i1 != i0Var6) {
                            return i1;
                        }
                    } else {
                        throw new IllegalStateException(("Cannot happen in " + z0).toString());
                    }
                }
            }
        }
    }

    private final h2<?> M0(l<? super Throwable, t1> lVar, boolean z) {
        if (z) {
            c2 c2Var = lVar instanceof c2 ? lVar : null;
            if (c2Var != null) {
                if (q0.b()) {
                    if (!(c2Var.f15739d == this)) {
                        throw new AssertionError();
                    }
                }
                if (c2Var != null) {
                    return c2Var;
                }
            }
            return new z1(this, lVar);
        }
        h2<?> h2Var = lVar instanceof h2 ? lVar : null;
        if (h2Var != null) {
            if (q0.b()) {
                if (!((h2Var.f15739d != this || (h2Var instanceof c2)) ? false : false)) {
                    throw new AssertionError();
                }
            }
            if (h2Var != null) {
                return h2Var;
            }
        }
        return new a2(this, lVar);
    }

    private final u O0(s sVar) {
        while (sVar.Z()) {
            sVar = sVar.W();
        }
        while (true) {
            sVar = sVar.V();
            if (!sVar.Z()) {
                if (sVar instanceof u) {
                    return (u) sVar;
                }
                if (sVar instanceof m2) {
                    return null;
                }
            }
        }
    }

    private final void P0(m2 m2Var, Throwable th) {
        S0(th);
        Object U = m2Var.U();
        Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        CompletionHandlerException completionHandlerException = null;
        for (s sVar = (s) U; !f0.g(sVar, m2Var); sVar = sVar.V()) {
            if (sVar instanceof c2) {
                h2 h2Var = (h2) sVar;
                try {
                    h2Var.j0(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        m.a(completionHandlerException, th2);
                        if (completionHandlerException != null) {
                        }
                    }
                    completionHandlerException = new CompletionHandlerException("Exception in completion handler " + h2Var + " for " + this, th2);
                    t1 t1Var = t1.a;
                }
            }
        }
        if (completionHandlerException != null) {
            B0(completionHandlerException);
        }
        d0(th);
    }

    private final void Q0(m2 m2Var, Throwable th) {
        Object U = m2Var.U();
        Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        CompletionHandlerException completionHandlerException = null;
        for (s sVar = (s) U; !f0.g(sVar, m2Var); sVar = sVar.V()) {
            if (sVar instanceof h2) {
                h2 h2Var = (h2) sVar;
                try {
                    h2Var.j0(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        m.a(completionHandlerException, th2);
                        if (completionHandlerException != null) {
                        }
                    }
                    completionHandlerException = new CompletionHandlerException("Exception in completion handler " + h2Var + " for " + this, th2);
                    t1 t1Var = t1.a;
                }
            }
        }
        if (completionHandlerException != null) {
            B0(completionHandlerException);
        }
    }

    private final /* synthetic */ <T extends h2<?>> void R0(m2 m2Var, Throwable th) {
        Object U = m2Var.U();
        Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        CompletionHandlerException completionHandlerException = null;
        for (s sVar = (s) U; !f0.g(sVar, m2Var); sVar = sVar.V()) {
            f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (sVar instanceof s) {
                h2 h2Var = (h2) sVar;
                try {
                    h2Var.j0(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        m.a(completionHandlerException, th2);
                        if (completionHandlerException != null) {
                        }
                    }
                    completionHandlerException = new CompletionHandlerException("Exception in completion handler " + h2Var + " for " + this, th2);
                    t1 t1Var = t1.a;
                }
            }
        }
        if (completionHandlerException != null) {
            B0(completionHandlerException);
        }
    }

    private final boolean S(Object obj, m2 m2Var, h2<?> h2Var) {
        int h0;
        d dVar = new d(h2Var, h2Var, this, obj);
        do {
            h0 = m2Var.W().h0(h2Var, m2Var, dVar);
            if (h0 == 1) {
                return true;
            }
        } while (h0 != 2);
        return false;
    }

    private final void T(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable t = !q0.e() ? th : h0.t(th);
        for (Throwable th2 : list) {
            if (q0.e()) {
                th2 = h0.t(th2);
            }
            if (th2 != th && th2 != t && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                m.a(th, th2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [i.b.u1] */
    private final void V0(h1 h1Var) {
        m2 m2Var = new m2();
        if (!h1Var.j()) {
            m2Var = new u1(m2Var);
        }
        a.compareAndSet(this, h1Var, m2Var);
    }

    private final void W0(h2<?> h2Var) {
        h2Var.N(new m2());
        a.compareAndSet(this, h2Var, h2Var.V());
    }

    private final int b1(Object obj) {
        h1 h1Var;
        if (obj instanceof h1) {
            if (((h1) obj).j()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            h1Var = i2.f15750j;
            if (atomicReferenceFieldUpdater.compareAndSet(this, obj, h1Var)) {
                U0();
                return 1;
            }
            return -1;
        } else if (obj instanceof u1) {
            if (a.compareAndSet(this, obj, ((u1) obj).c())) {
                U0();
                return 1;
            }
            return -1;
        } else {
            return 0;
        }
    }

    private final Object c0(Object obj) {
        i0 i0Var;
        Object i1;
        i0 i0Var2;
        do {
            Object z0 = z0();
            if (!(z0 instanceof v1) || ((z0 instanceof c) && ((c) z0).g())) {
                i0Var = i2.a;
                return i0Var;
            }
            i1 = i1(z0, new b0(i0(obj), false, 2, null));
            i0Var2 = i2.f15743c;
        } while (i1 == i0Var2);
        return i1;
    }

    private final String c1(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof v1 ? ((v1) obj).j() ? "Active" : "New" : obj instanceof b0 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.f() ? "Cancelling" : cVar.g() ? "Completing" : "Active";
    }

    private final boolean d0(Throwable th) {
        if (F0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        t y0 = y0();
        return (y0 == null || y0 == o2.a) ? z : y0.g(th) || z;
    }

    public static /* synthetic */ CancellationException e1(JobSupport jobSupport, Throwable th, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return jobSupport.d1(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final void g0(v1 v1Var, Object obj) {
        t y0 = y0();
        if (y0 != null) {
            y0.dispose();
            a1(o2.a);
        }
        if (!(obj instanceof b0)) {
            obj = null;
        }
        b0 b0Var = (b0) obj;
        Throwable th = b0Var != null ? b0Var.a : null;
        if (v1Var instanceof h2) {
            try {
                ((h2) v1Var).j0(th);
                return;
            } catch (Throwable th2) {
                B0(new CompletionHandlerException("Exception in completion handler " + v1Var + " for " + this, th2));
                return;
            }
        }
        m2 c2 = v1Var.c();
        if (c2 != null) {
            Q0(c2, th);
        }
    }

    private final boolean g1(v1 v1Var, Object obj) {
        if (q0.b()) {
            if (!((v1Var instanceof h1) || (v1Var instanceof h2))) {
                throw new AssertionError();
            }
        }
        if (!q0.b() || (!(obj instanceof b0))) {
            if (a.compareAndSet(this, v1Var, i2.g(obj))) {
                S0(null);
                T0(obj);
                g0(v1Var, obj);
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    public final void h0(c cVar, u uVar, Object obj) {
        if (q0.b()) {
            if (!(z0() == cVar)) {
                throw new AssertionError();
            }
        }
        u O0 = O0(uVar);
        if (O0 == null || !k1(cVar, O0, obj)) {
            U(l0(cVar, obj));
        }
    }

    private final boolean h1(v1 v1Var, Throwable th) {
        if (!q0.b() || (!(v1Var instanceof c))) {
            if (!q0.b() || v1Var.j()) {
                m2 w0 = w0(v1Var);
                if (w0 != null) {
                    if (a.compareAndSet(this, v1Var, new c(w0, false, th))) {
                        P0(w0, th);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final Throwable i0(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new JobCancellationException(e0(), null, this);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((r2) obj).M();
    }

    private final Object i1(Object obj, Object obj2) {
        i0 i0Var;
        i0 i0Var2;
        if (!(obj instanceof v1)) {
            i0Var2 = i2.a;
            return i0Var2;
        } else if (((obj instanceof h1) || (obj instanceof h2)) && !(obj instanceof u) && !(obj2 instanceof b0)) {
            if (g1((v1) obj, obj2)) {
                return obj2;
            }
            i0Var = i2.f15743c;
            return i0Var;
        } else {
            return j1((v1) obj, obj2);
        }
    }

    private final Object j1(v1 v1Var, Object obj) {
        i0 i0Var;
        i0 i0Var2;
        i0 i0Var3;
        m2 w0 = w0(v1Var);
        if (w0 == null) {
            i0Var = i2.f15743c;
            return i0Var;
        }
        c cVar = (c) (!(v1Var instanceof c) ? null : v1Var);
        if (cVar == null) {
            cVar = new c(w0, false, null);
        }
        synchronized (cVar) {
            if (cVar.g()) {
                i0Var3 = i2.a;
                return i0Var3;
            }
            cVar.k(true);
            if (cVar != v1Var && !a.compareAndSet(this, v1Var, cVar)) {
                i0Var2 = i2.f15743c;
                return i0Var2;
            }
            if (q0.b() && !(!cVar.h())) {
                throw new AssertionError();
            }
            boolean f2 = cVar.f();
            b0 b0Var = (b0) (!(obj instanceof b0) ? null : obj);
            if (b0Var != null) {
                cVar.a(b0Var.a);
            }
            Throwable e2 = true ^ f2 ? cVar.e() : null;
            t1 t1Var = t1.a;
            if (e2 != null) {
                P0(w0, e2);
            }
            u m0 = m0(v1Var);
            if (m0 != null && k1(cVar, m0, obj)) {
                return i2.b;
            }
            return l0(cVar, obj);
        }
    }

    public static /* synthetic */ JobCancellationException k0(JobSupport jobSupport, String str, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            if ((i2 & 2) != 0) {
                th = null;
            }
            if (str == null) {
                str = jobSupport.e0();
            }
            return new JobCancellationException(str, th, jobSupport);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    private final boolean k1(c cVar, u uVar, Object obj) {
        while (b2.a.f(uVar.f15846e, false, false, new b(this, cVar, uVar, obj), 1, null) == o2.a) {
            uVar = O0(uVar);
            if (uVar == null) {
                return false;
            }
        }
        return true;
    }

    private final Object l0(c cVar, Object obj) {
        boolean f2;
        Throwable s0;
        boolean z = true;
        if (q0.b()) {
            if (!(z0() == cVar)) {
                throw new AssertionError();
            }
        }
        if (!q0.b() || (!cVar.h())) {
            if (!q0.b() || cVar.g()) {
                b0 b0Var = (b0) (!(obj instanceof b0) ? null : obj);
                Throwable th = b0Var != null ? b0Var.a : null;
                synchronized (cVar) {
                    f2 = cVar.f();
                    List<Throwable> i2 = cVar.i(th);
                    s0 = s0(cVar, i2);
                    if (s0 != null) {
                        T(s0, i2);
                    }
                }
                if (s0 != null && s0 != th) {
                    obj = new b0(s0, false, 2, null);
                }
                if (s0 != null) {
                    if (!d0(s0) && !A0(s0)) {
                        z = false;
                    }
                    if (z) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                        ((b0) obj).b();
                    }
                }
                if (!f2) {
                    S0(s0);
                }
                T0(obj);
                boolean compareAndSet = a.compareAndSet(this, cVar, i2.g(obj));
                if (!q0.b() || compareAndSet) {
                    g0(cVar, obj);
                    return obj;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final u m0(v1 v1Var) {
        u uVar = (u) (!(v1Var instanceof u) ? null : v1Var);
        if (uVar != null) {
            return uVar;
        }
        m2 c2 = v1Var.c();
        if (c2 != null) {
            return O0(c2);
        }
        return null;
    }

    private final Throwable r0(Object obj) {
        if (!(obj instanceof b0)) {
            obj = null;
        }
        b0 b0Var = (b0) obj;
        if (b0Var != null) {
            return b0Var.a;
        }
        return null;
    }

    private final Throwable s0(c cVar, List<? extends Throwable> list) {
        Object obj;
        boolean z;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (cVar.f()) {
                return new JobCancellationException(e0(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 == th2 || !(th3 instanceof TimeoutCancellationException)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final m2 w0(v1 v1Var) {
        m2 c2 = v1Var.c();
        if (c2 != null) {
            return c2;
        }
        if (v1Var instanceof h1) {
            return new m2();
        }
        if (v1Var instanceof h2) {
            W0((h2) v1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + v1Var).toString());
    }

    public boolean A0(@k.e.a.d Throwable th) {
        return false;
    }

    public void B0(@k.e.a.d Throwable th) {
        throw th;
    }

    public final void C0(@k.e.a.e b2 b2Var) {
        if (q0.b()) {
            if (!(y0() == null)) {
                throw new AssertionError();
            }
        }
        if (b2Var == null) {
            a1(o2.a);
            return;
        }
        b2Var.start();
        t x0 = b2Var.x0(this);
        a1(x0);
        if (l()) {
            x0.dispose();
            a1(o2.a);
        }
    }

    public final boolean E0() {
        return z0() instanceof b0;
    }

    @Override // i.b.b2
    @i(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @k.e.a.d
    public b2 F(@k.e.a.d b2 b2Var) {
        return b2.a.i(this, b2Var);
    }

    public boolean F0() {
        return false;
    }

    @Override // i.b.b2
    @k.e.a.d
    public final e1 H(@k.e.a.d l<? super Throwable, t1> lVar) {
        return i(false, true, lVar);
    }

    @k.e.a.e
    public final /* synthetic */ Object H0(@k.e.a.d h.e2.c<? super t1> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        q.a(oVar, H(new v2(this, oVar)));
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    public final boolean K0(@k.e.a.e Object obj) {
        Object i1;
        i0 i0Var;
        i0 i0Var2;
        do {
            i1 = i1(z0(), obj);
            i0Var = i2.a;
            if (i1 == i0Var) {
                return false;
            }
            if (i1 == i2.b) {
                return true;
            }
            i0Var2 = i2.f15743c;
        } while (i1 == i0Var2);
        U(i1);
        return true;
    }

    @k.e.a.e
    public final Object L0(@k.e.a.e Object obj) {
        Object i1;
        i0 i0Var;
        i0 i0Var2;
        do {
            i1 = i1(z0(), obj);
            i0Var = i2.a;
            if (i1 != i0Var) {
                i0Var2 = i2.f15743c;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, r0(obj));
            }
        } while (i1 == i0Var2);
        return i1;
    }

    @Override // i.b.r2
    @k.e.a.d
    public CancellationException M() {
        Throwable th;
        Object z0 = z0();
        if (z0 instanceof c) {
            th = ((c) z0).e();
        } else if (z0 instanceof b0) {
            th = ((b0) z0).a;
        } else if (z0 instanceof v1) {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + z0).toString());
        } else {
            th = null;
        }
        CancellationException cancellationException = th instanceof CancellationException ? th : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + c1(z0), th, this);
    }

    @k.e.a.d
    public String N0() {
        return r0.a(this);
    }

    public void S0(@k.e.a.e Throwable th) {
    }

    public void T0(@k.e.a.e Object obj) {
    }

    public void U(@k.e.a.e Object obj) {
    }

    public void U0() {
    }

    @k.e.a.e
    public final Object V(@k.e.a.d h.e2.c<Object> cVar) {
        Object z0;
        do {
            z0 = z0();
            if (!(z0 instanceof v1)) {
                if (z0 instanceof b0) {
                    Throwable th = ((b0) z0).a;
                    if (q0.e()) {
                        if (cVar instanceof h.e2.k.a.c) {
                            throw h0.o(th, (h.e2.k.a.c) cVar);
                        }
                        throw th;
                    }
                    throw th;
                }
                return i2.o(z0);
            }
        } while (b1(z0) < 0);
        return W(cVar);
    }

    @k.e.a.e
    public final /* synthetic */ Object W(@k.e.a.d h.e2.c<Object> cVar) {
        a aVar = new a(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), this);
        q.a(aVar, H(new u2(this, aVar)));
        Object B = aVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    public final <T, R> void X0(@k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d p<? super T, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        Object z0;
        do {
            z0 = z0();
            if (fVar.b()) {
                return;
            }
            if (!(z0 instanceof v1)) {
                if (fVar.s()) {
                    if (z0 instanceof b0) {
                        fVar.y(((b0) z0).a);
                        return;
                    } else {
                        i.b.x3.b.d(pVar, i2.o(z0), fVar.v());
                        return;
                    }
                }
                return;
            }
        } while (b1(z0) != 0);
        fVar.k(H(new z2(this, fVar, pVar)));
    }

    @Override // i.b.b2
    @k.e.a.e
    public final Object Y(@k.e.a.d h.e2.c<? super t1> cVar) {
        if (!G0()) {
            r3.a(cVar.getContext());
            return t1.a;
        }
        Object H0 = H0(cVar);
        return H0 == h.e2.j.b.h() ? H0 : t1.a;
    }

    public final void Y0(@k.e.a.d h2<?> h2Var) {
        Object z0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h1 h1Var;
        do {
            z0 = z0();
            if (!(z0 instanceof h2)) {
                if (!(z0 instanceof v1) || ((v1) z0).c() == null) {
                    return;
                }
                h2Var.c0();
                return;
            } else if (z0 != h2Var) {
                return;
            } else {
                atomicReferenceFieldUpdater = a;
                h1Var = i2.f15750j;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, z0, h1Var));
    }

    public final boolean Z(@k.e.a.e Throwable th) {
        return a0(th);
    }

    public final <T, R> void Z0(@k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d p<? super T, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        Object z0 = z0();
        if (z0 instanceof b0) {
            fVar.y(((b0) z0).a);
        } else {
            i.b.x3.a.e(pVar, i2.o(z0), fVar.v(), null, 4, null);
        }
    }

    @Override // i.b.b2
    @i(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean a(@k.e.a.e Throwable th) {
        Throwable jobCancellationException;
        if (th == null || (jobCancellationException = e1(this, th, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(e0(), null, this);
        }
        b0(jobCancellationException);
        return true;
    }

    public final boolean a0(@k.e.a.e Object obj) {
        Object obj2;
        i0 i0Var;
        i0 i0Var2;
        i0 i0Var3;
        obj2 = i2.a;
        if (v0() && (obj2 = c0(obj)) == i2.b) {
            return true;
        }
        i0Var = i2.a;
        if (obj2 == i0Var) {
            obj2 = J0(obj);
        }
        i0Var2 = i2.a;
        if (obj2 == i0Var2 || obj2 == i2.b) {
            return true;
        }
        i0Var3 = i2.f15744d;
        if (obj2 == i0Var3) {
            return false;
        }
        U(obj2);
        return true;
    }

    public final void a1(@k.e.a.e t tVar) {
        this._parentHandle = tVar;
    }

    @Override // i.b.b2
    public void b(@k.e.a.e CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(e0(), null, this);
        }
        b0(cancellationException);
    }

    public void b0(@k.e.a.d Throwable th) {
        a0(th);
    }

    @Override // i.b.b2
    @i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        b(null);
    }

    @k.e.a.d
    public final CancellationException d1(@k.e.a.d Throwable th, @k.e.a.e String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            if (str == null) {
                str = e0();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @k.e.a.d
    public String e0() {
        return "Job was cancelled";
    }

    public boolean f0(@k.e.a.d Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return a0(th) && t0();
    }

    @x1
    @k.e.a.d
    public final String f1() {
        return N0() + '{' + c1(z0()) + '}';
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @k.e.a.d p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) b2.a.d(this, r, pVar);
    }

    @Override // i.b.z3.c
    public final <R> void g(@k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d l<? super h.e2.c<? super R>, ? extends Object> lVar) {
        Object z0;
        do {
            z0 = z0();
            if (fVar.b()) {
                return;
            }
            if (!(z0 instanceof v1)) {
                if (fVar.s()) {
                    i.b.x3.b.c(lVar, fVar.v());
                    return;
                }
                return;
            }
        } while (b1(z0) != 0);
        fVar.k(H(new a3(this, fVar, lVar)));
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.e
    public <E extends CoroutineContext.a> E get(@k.e.a.d CoroutineContext.b<E> bVar) {
        return (E) b2.a.e(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @k.e.a.d
    public final CoroutineContext.b<?> getKey() {
        return b2.y0;
    }

    @Override // i.b.b2
    @k.e.a.d
    public final e1 i(boolean z, boolean z2, @k.e.a.d l<? super Throwable, t1> lVar) {
        Throwable th;
        h2<?> h2Var = null;
        while (true) {
            Object z0 = z0();
            if (z0 instanceof h1) {
                h1 h1Var = (h1) z0;
                if (h1Var.j()) {
                    if (h2Var == null) {
                        h2Var = M0(lVar, z);
                    }
                    if (a.compareAndSet(this, z0, h2Var)) {
                        return h2Var;
                    }
                } else {
                    V0(h1Var);
                }
            } else if (z0 instanceof v1) {
                m2 c2 = ((v1) z0).c();
                if (c2 == null) {
                    Objects.requireNonNull(z0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    W0((h2) z0);
                } else {
                    e1 e1Var = o2.a;
                    if (z && (z0 instanceof c)) {
                        synchronized (z0) {
                            th = ((c) z0).e();
                            if (th == null || ((lVar instanceof u) && !((c) z0).g())) {
                                if (h2Var == null) {
                                    h2Var = M0(lVar, z);
                                }
                                if (S(z0, c2, h2Var)) {
                                    if (th == null) {
                                        return h2Var;
                                    }
                                    e1Var = h2Var;
                                }
                            }
                            t1 t1Var = t1.a;
                        }
                    } else {
                        th = null;
                    }
                    if (th != null) {
                        if (z2) {
                            lVar.invoke(th);
                        }
                        return e1Var;
                    }
                    if (h2Var == null) {
                        h2Var = M0(lVar, z);
                    }
                    if (S(z0, c2, h2Var)) {
                        return h2Var;
                    }
                }
            } else {
                if (z2) {
                    if (!(z0 instanceof b0)) {
                        z0 = null;
                    }
                    b0 b0Var = (b0) z0;
                    lVar.invoke(b0Var != null ? b0Var.a : null);
                }
                return o2.a;
            }
        }
    }

    @Override // i.b.b2
    public final boolean isCancelled() {
        Object z0 = z0();
        return (z0 instanceof b0) || ((z0 instanceof c) && ((c) z0).f());
    }

    @Override // i.b.b2
    public boolean j() {
        Object z0 = z0();
        return (z0 instanceof v1) && ((v1) z0).j();
    }

    @k.e.a.d
    public final JobCancellationException j0(@k.e.a.e String str, @k.e.a.e Throwable th) {
        if (str == null) {
            str = e0();
        }
        return new JobCancellationException(str, th, this);
    }

    @Override // i.b.b2
    @k.e.a.d
    public final h.q2.m<b2> k() {
        return h.q2.q.e(new JobSupport$children$1(this, null));
    }

    @Override // i.b.b2
    public final boolean l() {
        return !(z0() instanceof v1);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext minusKey(@k.e.a.d CoroutineContext.b<?> bVar) {
        return b2.a.g(this, bVar);
    }

    @k.e.a.e
    public final Object n0() {
        Object z0 = z0();
        if (!(z0 instanceof v1)) {
            if (!(z0 instanceof b0)) {
                return i2.o(z0);
            }
            throw ((b0) z0).a;
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @k.e.a.e
    public final Throwable o() {
        Object z0 = z0();
        if (!(z0 instanceof v1)) {
            return r0(z0);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // i.b.b2
    @k.e.a.d
    public final i.b.z3.c o0() {
        return this;
    }

    @k.e.a.e
    public final Throwable p0() {
        Object z0 = z0();
        if (z0 instanceof c) {
            Throwable e2 = ((c) z0).e();
            if (e2 != null) {
                return e2;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (!(z0 instanceof v1)) {
            if (z0 instanceof b0) {
                return ((b0) z0).a;
            }
            return null;
        } else {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext plus(@k.e.a.d CoroutineContext coroutineContext) {
        return b2.a.h(this, coroutineContext);
    }

    @Override // i.b.b2
    @k.e.a.d
    public final CancellationException q() {
        Object z0 = z0();
        if (z0 instanceof c) {
            Throwable e2 = ((c) z0).e();
            if (e2 != null) {
                CancellationException d1 = d1(e2, r0.a(this) + " is cancelling");
                if (d1 != null) {
                    return d1;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (!(z0 instanceof v1)) {
            if (z0 instanceof b0) {
                return e1(this, ((b0) z0).a, null, 1, null);
            }
            return new JobCancellationException(r0.a(this) + " has completed normally", null, this);
        } else {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
    }

    public final boolean q0() {
        Object z0 = z0();
        return (z0 instanceof b0) && ((b0) z0).a();
    }

    @Override // i.b.v
    public final void s(@k.e.a.d r2 r2Var) {
        a0(r2Var);
    }

    @Override // i.b.b2
    public final boolean start() {
        int b1;
        do {
            b1 = b1(z0());
            if (b1 == 0) {
                return false;
            }
        } while (b1 != 1);
        return true;
    }

    public boolean t0() {
        return true;
    }

    @k.e.a.d
    public String toString() {
        return f1() + '@' + r0.b(this);
    }

    public boolean v0() {
        return false;
    }

    @Override // i.b.b2
    @k.e.a.d
    public final t x0(@k.e.a.d v vVar) {
        e1 f2 = b2.a.f(this, true, false, new u(this, vVar), 2, null);
        Objects.requireNonNull(f2, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (t) f2;
    }

    @k.e.a.e
    public final t y0() {
        return (t) this._parentHandle;
    }

    @k.e.a.e
    public final Object z0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof i.b.w3.b0)) {
                return obj;
            }
            ((i.b.w3.b0) obj).c(this);
        }
    }
}
