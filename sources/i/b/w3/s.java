package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import i.b.x1;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@x1
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001:\u0005IJKLMB\u0007¢\u0006\u0004\bH\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00060\u0000j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0005H\u0082\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u000f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082\u0010¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0016\u001a\u00020\u00152\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0081\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\n2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u001a\u0010\fJ)\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\"\f\b\u0000\u0010\u000b*\u00060\u0000j\u0002`\u00052\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ,\u0010\u001e\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0086\b¢\u0006\u0004\b\u001e\u0010\u001fJ4\u0010\"\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u0016\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\u0004\u0012\u00020\u00130 H\u0086\b¢\u0006\u0004\b\"\u0010#JD\u0010$\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u0016\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\u0004\u0012\u00020\u00130 2\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0086\b¢\u0006\u0004\b$\u0010%J'\u0010&\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0001¢\u0006\u0004\b&\u0010'J/\u0010*\u001a\u00020)2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u00052\u0006\u0010(\u001a\u00020\u0015H\u0001¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0013H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0001¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\n¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\nH\u0001¢\u0006\u0004\b2\u00101J\u0015\u00103\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b3\u0010/J\u0017\u00105\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u000504¢\u0006\u0004\b5\u00106J.\u00107\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130 H\u0086\b¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0014¢\u0006\u0004\b9\u0010/J'\u0010;\u001a\u00020\n2\n\u0010:\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0000¢\u0006\u0004\b;\u0010<J\u000f\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?R\u0013\u0010\t\u001a\u00020\u00018F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0017\u0010C\u001a\u00060\u0000j\u0002`\u00058F@\u0006¢\u0006\u0006\u001a\u0004\bB\u0010/R\u0017\u0010E\u001a\u00060\u0000j\u0002`\u00058F@\u0006¢\u0006\u0006\u001a\u0004\bD\u0010/R\u0016\u0010G\u001a\u00020\u00138V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010-¨\u0006N"}, d2 = {"Li/b/w3/s;", "", "Li/b/w3/d0;", "g0", "()Li/b/w3/d0;", "Lkotlinx/coroutines/internal/Node;", "current", ExifInterface.LATITUDE_SOUTH, "(Li/b/w3/s;)Li/b/w3/s;", "next", "Lh/t1;", ExifInterface.GPS_DIRECTION_TRUE, "(Li/b/w3/s;)V", "Li/b/w3/b0;", "op", "O", "(Li/b/w3/b0;)Li/b/w3/s;", "node", "Lkotlin/Function0;", "", "condition", "Li/b/w3/s$c;", "a0", "(Li/b/w3/s;Lh/k2/u/a;)Li/b/w3/s$c;", "N", "(Li/b/w3/s;)Z", ExpandableTextView.P, "Li/b/w3/s$b;", "Q", "(Li/b/w3/s;)Li/b/w3/s$b;", "J", "(Li/b/w3/s;Lh/k2/u/a;)Z", "Lkotlin/Function1;", "predicate", "K", "(Li/b/w3/s;Lh/k2/u/l;)Z", "L", "(Li/b/w3/s;Lh/k2/u/l;Lh/k2/u/a;)Z", "M", "(Li/b/w3/s;Li/b/w3/s;)Z", "condAdd", "", "h0", "(Li/b/w3/s;Li/b/w3/s;Li/b/w3/s$c;)I", "c0", "()Z", "f0", "()Li/b/w3/s;", "X", "()V", "Y", "e0", "Li/b/w3/s$e;", "R", "()Li/b/w3/s$e;", "d0", "(Lh/k2/u/l;)Ljava/lang/Object;", "b0", "prev", "i0", "(Li/b/w3/s;Li/b/w3/s;)V", "", "toString", "()Ljava/lang/String;", "U", "()Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "prevNode", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "nextNode", "Z", "isRemoved", "<init>", am.av, "b", "c", e.j.a.b.c.f.f10128d, com.huawei.hms.push.e.a, "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class s {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_prev");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f15892c = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    private volatile Object _removedRef = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u001f\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\b\u001a\u00060\u0004j\u0002`\u0005H\u0014¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\r2\n\u0010\b\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0011\u001a\u00020\u00102\n\u0010\b\u001a\u00060\u0004j\u0002`\u00052\n\u0010\f\u001a\u00060\u0004j\u0002`\u0005H$¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0004j\u0002`\u00052\n\u0010\f\u001a\u00060\u0004j\u0002`\u0005H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u00102\n\u0010\b\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010!\u001a\u00020\u00102\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u001d2\b\u0010 \u001a\u0004\u0018\u00010\t¢\u0006\u0004\b!\u0010\"R\u001e\u0010%\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001e\u0010'\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006*"}, d2 = {"i/b/w3/s$a", "Li/b/w3/b;", "Li/b/w3/b0;", "op", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", "m", "(Li/b/w3/b0;)Li/b/w3/s;", "affected", "", com.huawei.hms.push.e.a, "(Li/b/w3/s;)Ljava/lang/Object;", "next", "", NotifyType.LIGHTS, "(Li/b/w3/s;Ljava/lang/Object;)Z", "Lh/t1;", "f", "(Li/b/w3/s;Li/b/w3/s;)V", "n", "(Li/b/w3/s;Li/b/w3/s;)Ljava/lang/Object;", "Li/b/w3/s$d;", "prepareOp", "g", "(Li/b/w3/s$d;)V", "j", "(Li/b/w3/s$d;)Ljava/lang/Object;", "k", "(Li/b/w3/s;)V", "Li/b/w3/d;", "c", "(Li/b/w3/d;)Ljava/lang/Object;", "failure", am.av, "(Li/b/w3/d;Ljava/lang/Object;)V", "h", "()Li/b/w3/s;", "affectedNode", "i", "originalNext", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static abstract class a extends i.b.w3.b {
        @Override // i.b.w3.b
        public final void a(@k.e.a.d i.b.w3.d<?> dVar, @k.e.a.e Object obj) {
            boolean z = obj == null;
            s h2 = h();
            if (h2 != null) {
                s i2 = i();
                if (i2 != null) {
                    if (s.a.compareAndSet(h2, dVar, z ? n(h2, i2) : i2) && z) {
                        f(h2, i2);
                    }
                } else if (i.b.q0.b() && !(!z)) {
                    throw new AssertionError();
                }
            } else if (i.b.q0.b() && !(!z)) {
                throw new AssertionError();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
            if (i.b.q0.b() == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
            if (r4 != null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
            r7 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
            if (r7 == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0066, code lost:
            return null;
         */
        @Override // i.b.w3.b
        @k.e.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object c(@k.e.a.d i.b.w3.d<?> r7) {
            /*
                r6 = this;
            L0:
                i.b.w3.s r0 = r6.m(r7)
                if (r0 == 0) goto L6e
                java.lang.Object r1 = r0._next
                r2 = 0
                if (r1 != r7) goto Lc
                return r2
            Lc:
                boolean r3 = r7.h()
                if (r3 == 0) goto L13
                return r2
            L13:
                boolean r3 = r1 instanceof i.b.w3.b0
                if (r3 == 0) goto L26
                i.b.w3.b0 r1 = (i.b.w3.b0) r1
                boolean r2 = r7.b(r1)
                if (r2 == 0) goto L22
                java.lang.Object r7 = i.b.w3.c.b
                return r7
            L22:
                r1.c(r0)
                goto L0
            L26:
                java.lang.Object r3 = r6.e(r0)
                if (r3 == 0) goto L2d
                return r3
            L2d:
                boolean r3 = r6.l(r0, r1)
                if (r3 == 0) goto L34
                goto L0
            L34:
                i.b.w3.s$d r3 = new i.b.w3.s$d
            */
            //  java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            /*
                java.util.Objects.requireNonNull(r1, r4)
                r4 = r1
                i.b.w3.s r4 = (i.b.w3.s) r4
                r3.<init>(r0, r4, r6)
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = i.b.w3.s.a
                boolean r4 = r4.compareAndSet(r0, r1, r3)
                if (r4 == 0) goto L0
                java.lang.Object r4 = r3.c(r0)     // Catch: java.lang.Throwable -> L67
                java.lang.Object r5 = i.b.w3.t.a     // Catch: java.lang.Throwable -> L67
                if (r4 != r5) goto L52
                goto L0
            L52:
                boolean r7 = i.b.q0.b()     // Catch: java.lang.Throwable -> L67
                if (r7 == 0) goto L66
                if (r4 != 0) goto L5c
                r7 = 1
                goto L5d
            L5c:
                r7 = 0
            L5d:
                if (r7 == 0) goto L60
                goto L66
            L60:
                java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L67
                r7.<init>()     // Catch: java.lang.Throwable -> L67
                throw r7     // Catch: java.lang.Throwable -> L67
            L66:
                return r2
            L67:
                r7 = move-exception
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = i.b.w3.s.a
                r2.compareAndSet(r0, r3, r1)
                throw r7
            L6e:
                java.lang.Object r7 = i.b.w3.c.b
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: i.b.w3.s.a.c(i.b.w3.d):java.lang.Object");
        }

        @k.e.a.e
        public Object e(@k.e.a.d s sVar) {
            return null;
        }

        public abstract void f(@k.e.a.d s sVar, @k.e.a.d s sVar2);

        public abstract void g(@k.e.a.d d dVar);

        @k.e.a.e
        public abstract s h();

        @k.e.a.e
        public abstract s i();

        @k.e.a.e
        public Object j(@k.e.a.d d dVar) {
            g(dVar);
            return null;
        }

        public void k(@k.e.a.d s sVar) {
        }

        public boolean l(@k.e.a.d s sVar, @k.e.a.d Object obj) {
            return false;
        }

        @k.e.a.e
        public s m(@k.e.a.d b0 b0Var) {
            return h();
        }

        @k.e.a.d
        public abstract Object n(@k.e.a.d s sVar, @k.e.a.d s sVar2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020\u0004B\u001b\u0012\n\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0004\b\"\u0010\u0017J\u001f\u0010\u0007\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\u00112\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001f\u001a\u00060\u0001j\u0002`\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00028\u00008\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006#"}, d2 = {"i/b/w3/s$b", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/w3/s$a;", "Li/b/w3/b0;", "op", "m", "(Li/b/w3/b0;)Li/b/w3/s;", "affected", "", "next", "", NotifyType.LIGHTS, "(Li/b/w3/s;Ljava/lang/Object;)Z", "Li/b/w3/s$d;", "prepareOp", "Lh/t1;", "g", "(Li/b/w3/s$d;)V", "n", "(Li/b/w3/s;Li/b/w3/s;)Ljava/lang/Object;", "f", "(Li/b/w3/s;Li/b/w3/s;)V", "i", "()Li/b/w3/s;", "originalNext", "h", "affectedNode", "b", "Li/b/w3/s;", "queue", "c", "node", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static class b<T extends s> extends a {

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f15893d = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_affectedNode");
        private volatile Object _affectedNode;
        @h.k2.d
        @k.e.a.d
        public final s b;
        @h.k2.d
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public final T f15894c;

        public b(@k.e.a.d s sVar, @k.e.a.d T t) {
            this.b = sVar;
            this.f15894c = t;
            if (i.b.q0.b()) {
                if (!(t._next == t && ((s) t._prev) == t)) {
                    throw new AssertionError();
                }
            }
            this._affectedNode = null;
        }

        @Override // i.b.w3.s.a
        public void f(@k.e.a.d s sVar, @k.e.a.d s sVar2) {
            this.f15894c.T(this.b);
        }

        @Override // i.b.w3.s.a
        public void g(@k.e.a.d d dVar) {
            f15893d.compareAndSet(this, null, dVar.a);
        }

        @Override // i.b.w3.s.a
        @k.e.a.e
        public final s h() {
            return (s) this._affectedNode;
        }

        @Override // i.b.w3.s.a
        @k.e.a.e
        public final s i() {
            return this.b;
        }

        @Override // i.b.w3.s.a
        public boolean l(@k.e.a.d s sVar, @k.e.a.d Object obj) {
            return obj != this.b;
        }

        @Override // i.b.w3.s.a
        @k.e.a.e
        public final s m(@k.e.a.d b0 b0Var) {
            return this.b.O(b0Var);
        }

        @Override // i.b.w3.s.a
        @k.e.a.d
        public Object n(@k.e.a.d s sVar, @k.e.a.d s sVar2) {
            T t = this.f15894c;
            s.b.compareAndSet(t, t, sVar);
            T t2 = this.f15894c;
            s.a.compareAndSet(t2, t2, this.b);
            return this.f15894c;
        }
    }

    @h.p0
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"i/b/w3/s$c", "Li/b/w3/d;", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "failure", "Lh/t1;", "j", "(Li/b/w3/s;Ljava/lang/Object;)V", "b", "Li/b/w3/s;", "oldNext", "c", "newNode", "<init>", "(Li/b/w3/s;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static abstract class c extends i.b.w3.d<s> {
        @h.k2.d
        @k.e.a.e
        public s b;
        @h.k2.d
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public final s f15895c;

        public c(@k.e.a.d s sVar) {
            this.f15895c = sVar;
        }

        @Override // i.b.w3.d
        /* renamed from: j */
        public void d(@k.e.a.d s sVar, @k.e.a.e Object obj) {
            boolean z = obj == null;
            s sVar2 = z ? this.f15895c : this.b;
            if (sVar2 != null && s.a.compareAndSet(sVar, this, sVar2) && z) {
                this.f15895c.T(this.b);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0003\u001a\u00060\fj\u0002`\r\u0012\n\u0010\u0010\u001a\u00060\fj\u0002`\r\u0012\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00060\fj\u0002`\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u001a\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00060\fj\u0002`\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u001a"}, d2 = {"i/b/w3/s$d", "Li/b/w3/b0;", "", "affected", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lh/t1;", e.j.a.b.c.f.f10128d, "()V", "", "toString", "()Ljava/lang/String;", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", "b", "Li/b/w3/s;", "next", "Li/b/w3/s$a;", "Li/b/w3/s$a;", "desc", "Li/b/w3/d;", am.av, "()Li/b/w3/d;", "atomicOp", "<init>", "(Li/b/w3/s;Li/b/w3/s;Li/b/w3/s$a;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class d extends b0 {
        @h.k2.d
        @k.e.a.d
        public final s a;
        @h.k2.d
        @k.e.a.d
        public final s b;
        @h.k2.d
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public final a f15896c;

        public d(@k.e.a.d s sVar, @k.e.a.d s sVar2, @k.e.a.d a aVar) {
            this.a = sVar;
            this.b = sVar2;
            this.f15896c = aVar;
        }

        @Override // i.b.w3.b0
        @k.e.a.d
        public i.b.w3.d<?> a() {
            return this.f15896c.b();
        }

        @Override // i.b.w3.b0
        @k.e.a.e
        public Object c(@k.e.a.e Object obj) {
            Object f2;
            Object obj2;
            if (i.b.q0.b()) {
                if (!(obj == this.a)) {
                    throw new AssertionError();
                }
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            s sVar = (s) obj;
            Object j2 = this.f15896c.j(this);
            Object obj3 = t.a;
            if (j2 == obj3) {
                s sVar2 = this.b;
                if (s.a.compareAndSet(sVar, this, sVar2.g0())) {
                    this.f15896c.k(sVar);
                    sVar2.O(null);
                }
                return obj3;
            }
            if (j2 != null) {
                f2 = a().e(j2);
            } else {
                f2 = a().f();
            }
            if (f2 == i.b.w3.c.a) {
                obj2 = a();
            } else if (f2 == null) {
                obj2 = this.f15896c.n(sVar, this.b);
            } else {
                obj2 = this.b;
            }
            s.a.compareAndSet(sVar, this, obj2);
            return null;
        }

        public final void d() {
            this.f15896c.g(this);
        }

        @Override // i.b.w3.b0
        @k.e.a.d
        public String toString() {
            return "PrepareOp(op=" + a() + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010&\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b'\u0010(J\u001f\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u000e2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\r\u001a\u00020\nH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00132\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010!\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010#\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001bR\u001a\u0010&\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"i/b/w3/s$e", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/w3/s$a;", "Li/b/w3/b0;", "op", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", "m", "(Li/b/w3/b0;)Li/b/w3/s;", "affected", "", com.huawei.hms.push.e.a, "(Li/b/w3/s;)Ljava/lang/Object;", "next", "", NotifyType.LIGHTS, "(Li/b/w3/s;Ljava/lang/Object;)Z", "Li/b/w3/s$d;", "prepareOp", "Lh/t1;", "g", "(Li/b/w3/s$d;)V", "n", "(Li/b/w3/s;Li/b/w3/s;)Ljava/lang/Object;", "f", "(Li/b/w3/s;Li/b/w3/s;)V", "i", "()Li/b/w3/s;", "originalNext", "o", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "h", "affectedNode", "b", "Li/b/w3/s;", "queue", "<init>", "(Li/b/w3/s;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static class e<T> extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f15897c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_affectedNode");

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f15898d = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_originalNext");
        private volatile Object _affectedNode = null;
        private volatile Object _originalNext = null;
        @h.k2.d
        @k.e.a.d
        public final s b;

        public e(@k.e.a.d s sVar) {
            this.b = sVar;
        }

        public static /* synthetic */ void p() {
        }

        @Override // i.b.w3.s.a
        @k.e.a.e
        public Object e(@k.e.a.d s sVar) {
            if (sVar == this.b) {
                return r.d();
            }
            return null;
        }

        @Override // i.b.w3.s.a
        public final void f(@k.e.a.d s sVar, @k.e.a.d s sVar2) {
            sVar2.O(null);
        }

        @Override // i.b.w3.s.a
        public void g(@k.e.a.d d dVar) {
            f15897c.compareAndSet(this, null, dVar.a);
            f15898d.compareAndSet(this, null, dVar.b);
        }

        @Override // i.b.w3.s.a
        @k.e.a.e
        public final s h() {
            return (s) this._affectedNode;
        }

        @Override // i.b.w3.s.a
        @k.e.a.e
        public final s i() {
            return (s) this._originalNext;
        }

        @Override // i.b.w3.s.a
        public final boolean l(@k.e.a.d s sVar, @k.e.a.d Object obj) {
            if (obj instanceof d0) {
                ((d0) obj).a.Y();
                return true;
            }
            return false;
        }

        @Override // i.b.w3.s.a
        @k.e.a.e
        public final s m(@k.e.a.d b0 b0Var) {
            s sVar = this.b;
            while (true) {
                Object obj = sVar._next;
                if (obj instanceof b0) {
                    b0 b0Var2 = (b0) obj;
                    if (b0Var.b(b0Var2)) {
                        return null;
                    }
                    b0Var2.c(this.b);
                } else {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                    return (s) obj;
                }
            }
        }

        @Override // i.b.w3.s.a
        @k.e.a.d
        public final Object n(@k.e.a.d s sVar, @k.e.a.d s sVar2) {
            return sVar2.g0();
        }

        public final T o() {
            return (T) h();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"i/b/w3/s$f", "Li/b/w3/s$c;", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "(Li/b/w3/s;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class f extends c {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h.k2.u.a f15899d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f15900e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(h.k2.u.a aVar, s sVar, s sVar2) {
            super(sVar2);
            this.f15899d = aVar;
            this.f15900e = sVar;
        }

        @Override // i.b.w3.d
        @k.e.a.e
        /* renamed from: k */
        public Object i(@k.e.a.d s sVar) {
            if (((Boolean) this.f15899d.invoke()).booleanValue()) {
                return null;
            }
            return r.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (i.b.w3.s.a.compareAndSet(r3, r2, ((i.b.w3.d0) r4).a) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final i.b.w3.s O(i.b.w3.b0 r7) {
        /*
            r6 = this;
        L0:
            java.lang.Object r0 = r6._prev
            i.b.w3.s r0 = (i.b.w3.s) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r6) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = i.b.w3.s.b
            boolean r0 = r1.compareAndSet(r6, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r6.Z()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r7) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof i.b.w3.b0
            if (r5 == 0) goto L38
            if (r7 == 0) goto L32
            r0 = r4
            i.b.w3.b0 r0 = (i.b.w3.b0) r0
            boolean r0 = r7.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            i.b.w3.b0 r4 = (i.b.w3.b0) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof i.b.w3.d0
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = i.b.w3.s.a
            i.b.w3.d0 r4 = (i.b.w3.d0) r4
            i.b.w3.s r4 = r4.a
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            i.b.w3.s r2 = (i.b.w3.s) r2
            goto L7
        L52:
        */
        //  java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            java.util.Objects.requireNonNull(r4, r3)
            i.b.w3.s r4 = (i.b.w3.s) r4
            r3 = r2
            r2 = r4
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.w3.s.O(i.b.w3.b0):i.b.w3.s");
    }

    private final s S(s sVar) {
        while (sVar.Z()) {
            sVar = (s) sVar._prev;
        }
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(s sVar) {
        s sVar2;
        do {
            sVar2 = (s) sVar._prev;
            if (U() != sVar) {
                return;
            }
        } while (!b.compareAndSet(sVar, sVar2, this));
        if (Z()) {
            sVar.O(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d0 g0() {
        d0 d0Var = (d0) this._removedRef;
        if (d0Var != null) {
            return d0Var;
        }
        d0 d0Var2 = new d0(this);
        f15892c.lazySet(this, d0Var2);
        return d0Var2;
    }

    public final void I(@k.e.a.d s sVar) {
        do {
        } while (!W().M(sVar, this));
    }

    public final boolean J(@k.e.a.d s sVar, @k.e.a.d h.k2.u.a<Boolean> aVar) {
        int h0;
        f fVar = new f(aVar, sVar, sVar);
        do {
            h0 = W().h0(sVar, this, fVar);
            if (h0 == 1) {
                return true;
            }
        } while (h0 != 2);
        return false;
    }

    public final boolean K(@k.e.a.d s sVar, @k.e.a.d h.k2.u.l<? super s, Boolean> lVar) {
        s W;
        do {
            W = W();
            if (!lVar.invoke(W).booleanValue()) {
                return false;
            }
        } while (!W.M(sVar, this));
        return true;
    }

    public final boolean L(@k.e.a.d s sVar, @k.e.a.d h.k2.u.l<? super s, Boolean> lVar, @k.e.a.d h.k2.u.a<Boolean> aVar) {
        int h0;
        f fVar = new f(aVar, sVar, sVar);
        do {
            s W = W();
            if (!lVar.invoke(W).booleanValue()) {
                return false;
            }
            h0 = W.h0(sVar, this, fVar);
            if (h0 == 1) {
                return true;
            }
        } while (h0 != 2);
        return false;
    }

    @h.p0
    public final boolean M(@k.e.a.d s sVar, @k.e.a.d s sVar2) {
        b.lazySet(sVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(sVar, sVar2);
        if (atomicReferenceFieldUpdater.compareAndSet(this, sVar2, sVar)) {
            sVar.T(sVar2);
            return true;
        }
        return false;
    }

    public final boolean N(@k.e.a.d s sVar) {
        b.lazySet(sVar, this);
        a.lazySet(sVar, this);
        while (U() == this) {
            if (a.compareAndSet(this, this, sVar)) {
                sVar.T(this);
                return true;
            }
        }
        return false;
    }

    @k.e.a.d
    public final <T extends s> b<T> Q(@k.e.a.d T t) {
        return new b<>(this, t);
    }

    @k.e.a.d
    public final e<s> R() {
        return new e<>(this);
    }

    @k.e.a.d
    public final Object U() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof b0)) {
                return obj;
            }
            ((b0) obj).c(this);
        }
    }

    @k.e.a.d
    public final s V() {
        return r.h(U());
    }

    @k.e.a.d
    public final s W() {
        s O = O(null);
        return O != null ? O : S((s) this._prev);
    }

    public final void X() {
        Object U = U();
        Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
        ((d0) U).a.O(null);
    }

    @h.p0
    public final void Y() {
        s sVar = this;
        while (true) {
            Object U = sVar.U();
            if (!(U instanceof d0)) {
                sVar.O(null);
                return;
            }
            sVar = ((d0) U).a;
        }
    }

    public boolean Z() {
        return U() instanceof d0;
    }

    @h.p0
    @k.e.a.d
    public final c a0(@k.e.a.d s sVar, @k.e.a.d h.k2.u.a<Boolean> aVar) {
        return new f(aVar, sVar, sVar);
    }

    @k.e.a.e
    public s b0() {
        Object U = U();
        if (!(U instanceof d0)) {
            U = null;
        }
        d0 d0Var = (d0) U;
        if (d0Var != null) {
            return d0Var.a;
        }
        return null;
    }

    public boolean c0() {
        return f0() == null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, i.b.w3.s, java.lang.Object] */
    @k.e.a.e
    public final /* synthetic */ <T> T d0(@k.e.a.d h.k2.u.l<? super T, Boolean> lVar) {
        s f0;
        while (true) {
            Object U = U();
            Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            s sVar = (s) U;
            if (sVar == this) {
                return null;
            }
            h.k2.v.f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (!(sVar instanceof Object)) {
                return null;
            }
            if ((lVar.invoke(sVar).booleanValue() && !sVar.Z()) || (f0 = sVar.f0()) == null) {
                return sVar;
            }
            f0.Y();
        }
    }

    @k.e.a.e
    public final s e0() {
        while (true) {
            Object U = U();
            Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            s sVar = (s) U;
            if (sVar == this) {
                return null;
            }
            if (sVar.c0()) {
                return sVar;
            }
            sVar.X();
        }
    }

    @h.p0
    @k.e.a.e
    public final s f0() {
        Object U;
        s sVar;
        do {
            U = U();
            if (U instanceof d0) {
                return ((d0) U).a;
            }
            if (U == this) {
                return (s) U;
            }
            Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            sVar = (s) U;
        } while (!a.compareAndSet(this, U, sVar.g0()));
        sVar.O(null);
        return null;
    }

    @h.p0
    public final int h0(@k.e.a.d s sVar, @k.e.a.d s sVar2, @k.e.a.d c cVar) {
        b.lazySet(sVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(sVar, sVar2);
        cVar.b = sVar2;
        if (atomicReferenceFieldUpdater.compareAndSet(this, sVar2, cVar)) {
            return cVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    public final void i0(@k.e.a.d s sVar, @k.e.a.d s sVar2) {
        if (i.b.q0.b()) {
            if (!(sVar == ((s) this._prev))) {
                throw new AssertionError();
            }
        }
        if (i.b.q0.b()) {
            if (!(sVar2 == this._next)) {
                throw new AssertionError();
            }
        }
    }

    @k.e.a.d
    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
