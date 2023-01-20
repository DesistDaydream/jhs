package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.u.p;
import h.k2.v.f0;
import h.k2.v.u;
import h.k2.v.x0.d;
import h.k2.v.x0.g;
import h.o2.q;
import i.b.w3.i0;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003\u001f'(B\u0011\u0012\b\b\u0002\u0010#\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00052\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u0019\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0007J\r\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0007R\u0016\u0010\u0019\u001a\u00020\u00168V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR(\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e0\u001a8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\"¨\u0006)"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lh/a2/f;", "Lh/t1;", "k", "()V", "key", "value", NotifyType.LIGHTS, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Li/b/u3/b/e;", IAdInterListener.AdReqParam.WIDTH, "j", "(Li/b/u3/b/e;)V", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "remove", "clear", "m", "", "f", "()I", "size", "", f.f10128d, "()Ljava/util/Set;", "keys", "", am.av, "entries", "Ljava/lang/ref/ReferenceQueue;", "Ljava/lang/ref/ReferenceQueue;", "weakRefQueue", "", "<init>", "(Z)V", "b", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ConcurrentWeakMap<K, V> extends h.a2.f<K, V> {
    private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    private volatile int _size;
    private final ReferenceQueue<K> a;
    public volatile Object core;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00120\u0012R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00072\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\u001c\"\u0004\b\u0002\u0010\u00192\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010 R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010 ¨\u0006&"}, d2 = {"kotlinx/coroutines/debug/internal/ConcurrentWeakMap$a", "", "", "hash", f.f10128d, "(I)I", "index", "Lh/t1;", "i", "(I)V", "key", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "Li/b/u3/b/e;", "weakKey0", "f", "(Ljava/lang/Object;Ljava/lang/Object;Li/b/u3/b/e;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$a;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "h", "()Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$a;", "weakRef", "b", "(Li/b/u3/b/e;)V", ExifInterface.LONGITUDE_EAST, "Lkotlin/Function2;", "factory", "", e.a, "(Lh/k2/u/p;)Ljava/util/Iterator;", am.av, ExpandableTextView.P, "shift", "threshold", "allocated", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class a {

        /* renamed from: g  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f16924g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");
        private final int a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicReferenceArray f16925c;

        /* renamed from: d  reason: collision with root package name */
        public AtomicReferenceArray f16926d;

        /* renamed from: e  reason: collision with root package name */
        private final int f16927e;
        private volatile int load = 0;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR(\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0016\u0010\u0015\u001a\u00028\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017¨\u0006\u001b"}, d2 = {"kotlinx/coroutines/debug/internal/ConcurrentWeakMap$a$a", ExifInterface.LONGITUDE_EAST, "", "Lh/t1;", am.av, "()V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", f.f10128d, "()Ljava/lang/Void;", "b", "Ljava/lang/Object;", "key", "Lkotlin/Function2;", "Lh/k2/u/p;", "factory", "c", "value", "", ExpandableTextView.P, "index", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$a;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public final class C0499a<E> implements Iterator<E>, d {
            private int a = -1;
            private K b;

            /* renamed from: c  reason: collision with root package name */
            private V f16929c;

            /* renamed from: d  reason: collision with root package name */
            private final p<K, V, E> f16930d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0499a(@k.e.a.d p<? super K, ? super V, ? extends E> pVar) {
                this.f16930d = pVar;
                a();
            }

            private final void a() {
                K k2;
                while (true) {
                    int i2 = this.a + 1;
                    this.a = i2;
                    if (i2 >= a.this.f16927e) {
                        return;
                    }
                    i.b.u3.b.e eVar = (i.b.u3.b.e) a.this.f16925c.get(this.a);
                    if (eVar != null && (k2 = (K) eVar.get()) != null) {
                        this.b = k2;
                        V v = (V) a.this.f16926d.get(this.a);
                        if (v instanceof i.b.u3.b.f) {
                            v = (V) ((i.b.u3.b.f) v).a;
                        }
                        if (v != null) {
                            this.f16929c = v;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            @k.e.a.d
            /* renamed from: d */
            public Void remove() {
                i.b.u3.b.a.e();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a < a.this.f16927e;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.a < a.this.f16927e) {
                    E invoke = this.f16930d.invoke(this.b, this.f16929c);
                    a();
                    return invoke;
                }
                throw new NoSuchElementException();
            }
        }

        public a(int i2) {
            this.f16927e = i2;
            this.a = Integer.numberOfLeadingZeros(i2) + 1;
            this.b = (i2 * 2) / 3;
            this.f16925c = new AtomicReferenceArray(i2);
            this.f16926d = new AtomicReferenceArray(i2);
        }

        private final int d(int i2) {
            return (i2 * (-1640531527)) >>> this.a;
        }

        public static /* synthetic */ Object g(a aVar, Object obj, Object obj2, i.b.u3.b.e eVar, int i2, Object obj3) {
            if ((i2 & 4) != 0) {
                eVar = null;
            }
            return aVar.f(obj, obj2, eVar);
        }

        private final void i(int i2) {
            Object obj;
            do {
                obj = this.f16926d.get(i2);
                if (obj == null || (obj instanceof i.b.u3.b.f)) {
                    return;
                }
            } while (!this.f16926d.compareAndSet(i2, obj, null));
            ConcurrentWeakMap.this.k();
        }

        public final void b(@k.e.a.d i.b.u3.b.e<?> eVar) {
            int d2 = d(eVar.a);
            while (true) {
                i.b.u3.b.e<?> eVar2 = (i.b.u3.b.e) this.f16925c.get(d2);
                if (eVar2 == null) {
                    return;
                }
                if (eVar2 == eVar) {
                    i(d2);
                    return;
                }
                if (d2 == 0) {
                    d2 = this.f16927e;
                }
                d2--;
            }
        }

        /* JADX WARN: Failed to parse method signature: (TK)TV
        jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: (TK)TV at position 2 ('K'), unexpected: T
        	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
        	at jadx.core.dex.nodes.parser.SignatureParser.consumeMethodArgs(SignatureParser.java:318)
        	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:109)
        	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
         */
        @k.e.a.e
        public final Object c(@k.e.a.d Object obj) {
            int d2 = d(obj.hashCode());
            while (true) {
                i.b.u3.b.e eVar = (i.b.u3.b.e) this.f16925c.get(d2);
                if (eVar == null) {
                    return null;
                }
                T t = eVar.get();
                if (f0.g(obj, t)) {
                    Object obj2 = this.f16926d.get(d2);
                    return obj2 instanceof i.b.u3.b.f ? ((i.b.u3.b.f) obj2).a : obj2;
                }
                if (t == 0) {
                    i(d2);
                }
                if (d2 == 0) {
                    d2 = this.f16927e;
                }
                d2--;
            }
        }

        @k.e.a.d
        public final <E> Iterator<E> e(@k.e.a.d p<? super K, ? super V, ? extends E> pVar) {
            return new C0499a(pVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
            r6 = r5.f16926d.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
            if ((r6 instanceof i.b.u3.b.f) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
            r6 = i.b.u3.b.a.f15849c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
            if (r5.f16926d.compareAndSet(r0, r6, r7) == false) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
            return r6;
         */
        /* JADX WARN: Failed to parse method signature: (TKTVLi/b/u3/b/e<TK;>;)Ljava/lang/Object;
        jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: (TKTVLi/b/u3/b/e<TK;>;)Ljava/lang/Object; at position 20 ('>'), unexpected: >
        	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
        	at jadx.core.dex.nodes.parser.SignatureParser.consumeMethodArgs(SignatureParser.java:318)
        	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:109)
        	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
         */
        @k.e.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object f(@k.e.a.d java.lang.Object r6, @k.e.a.e java.lang.Object r7, @k.e.a.e i.b.u3.b.e r8) {
            /*
                r5 = this;
                int r0 = r6.hashCode()
                int r0 = r5.d(r0)
                r1 = 0
            L9:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r5.f16925c
                java.lang.Object r2 = r2.get(r0)
                i.b.u3.b.e r2 = (i.b.u3.b.e) r2
                if (r2 != 0) goto L45
                r2 = 0
                if (r7 != 0) goto L17
                return r2
            L17:
                if (r1 != 0) goto L2f
            L19:
                int r1 = r5.load
                int r3 = r5.b
                if (r1 < r3) goto L24
                i.b.w3.i0 r6 = i.b.u3.b.a.a()
                return r6
            L24:
                int r3 = r1 + 1
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.f16924g
                boolean r1 = r4.compareAndSet(r5, r1, r3)
                if (r1 == 0) goto L19
                r1 = 1
            L2f:
                if (r8 != 0) goto L3c
                i.b.u3.b.e r8 = new i.b.u3.b.e
                kotlinx.coroutines.debug.internal.ConcurrentWeakMap r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this
                java.lang.ref.ReferenceQueue r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.i(r3)
                r8.<init>(r6, r3)
            L3c:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r5.f16925c
                boolean r2 = r3.compareAndSet(r0, r2, r8)
                if (r2 == 0) goto L9
                goto L56
            L45:
                java.lang.Object r2 = r2.get()
                boolean r3 = h.k2.v.f0.g(r6, r2)
                if (r3 == 0) goto L6e
                if (r1 == 0) goto L56
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.f16924g
                r6.decrementAndGet(r5)
            L56:
                java.util.concurrent.atomic.AtomicReferenceArray r6 = r5.f16926d
                java.lang.Object r6 = r6.get(r0)
                boolean r8 = r6 instanceof i.b.u3.b.f
                if (r8 == 0) goto L65
                i.b.w3.i0 r6 = i.b.u3.b.a.a()
                return r6
            L65:
                java.util.concurrent.atomic.AtomicReferenceArray r8 = r5.f16926d
                boolean r8 = r8.compareAndSet(r0, r6, r7)
                if (r8 == 0) goto L56
                return r6
            L6e:
                if (r2 != 0) goto L73
                r5.i(r0)
            L73:
                if (r0 != 0) goto L77
                int r0 = r5.f16927e
            L77:
                int r0 = r0 + (-1)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.f(java.lang.Object, java.lang.Object, i.b.u3.b.e):java.lang.Object");
        }

        @k.e.a.d
        public final ConcurrentWeakMap<K, V>.a h() {
            Object obj;
            i0 i0Var;
            i.b.u3.b.f d2;
            while (true) {
                ConcurrentWeakMap<K, V>.a aVar = new a(Integer.highestOneBit(q.n(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i2 = this.f16927e;
                for (int i3 = 0; i3 < i2; i3++) {
                    i.b.u3.b.e eVar = (i.b.u3.b.e) this.f16925c.get(i3);
                    Object obj2 = eVar != null ? eVar.get() : null;
                    if (eVar != null && obj2 == null) {
                        i(i3);
                    }
                    while (true) {
                        obj = this.f16926d.get(i3);
                        if (obj instanceof i.b.u3.b.f) {
                            obj = ((i.b.u3.b.f) obj).a;
                            break;
                        }
                        AtomicReferenceArray atomicReferenceArray = this.f16926d;
                        d2 = i.b.u3.b.a.d(obj);
                        if (atomicReferenceArray.compareAndSet(i3, obj, d2)) {
                            break;
                        }
                    }
                    if (obj2 != null && obj != null) {
                        Object f2 = aVar.f(obj2, obj, eVar);
                        i0Var = i.b.u3.b.a.f15849c;
                        if (f2 == i0Var) {
                            break;
                        }
                    }
                }
                return aVar;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u000b\u001a\u00028\u0002\u0012\u0006\u0010\u000e\u001a\u00028\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\u00028\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00028\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"kotlinx/coroutines/debug/internal/ConcurrentWeakMap$b", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", am.av, "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "key", "b", "getValue", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b<K, V> implements Map.Entry<K, V>, g.a {
        private final K a;
        private final V b;

        public b(K k2, V v) {
            this.a = k2;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            i.b.u3.b.a.e();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR(\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000f¨\u0006\u0013"}, d2 = {"kotlinx/coroutines/debug/internal/ConcurrentWeakMap$c", ExifInterface.LONGITUDE_EAST, "Lh/a2/g;", "element", "", "add", "(Ljava/lang/Object;)Z", "", "iterator", "()Ljava/util/Iterator;", "", am.av, "()I", "size", "Lkotlin/Function2;", "Lh/k2/u/p;", "factory", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class c<E> extends h.a2.g<E> {
        private final p<K, V, E> a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@k.e.a.d p<? super K, ? super V, ? extends E> pVar) {
            this.a = pVar;
        }

        @Override // h.a2.g
        public int a() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // h.a2.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e2) {
            i.b.u3.b.a.e();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @k.e.a.d
        public Iterator<E> iterator() {
            return ((a) ConcurrentWeakMap.this.core).e(this.a);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i2, u uVar) {
        this((i2 & 1) != 0 ? false : z);
    }

    private final void j(i.b.u3.b.e<?> eVar) {
        ((a) this.core).b(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        b.decrementAndGet(this);
    }

    private final synchronized V l(K k2, V v) {
        V v2;
        i0 i0Var;
        a aVar = (a) this.core;
        while (true) {
            v2 = (V) a.g(aVar, k2, v, null, 4, null);
            i0Var = i.b.u3.b.a.f15849c;
            if (v2 == i0Var) {
                aVar = aVar.h();
                this.core = aVar;
            }
        }
        return v2;
    }

    @Override // h.a2.f
    @k.e.a.d
    public Set<Map.Entry<K, V>> a() {
        return new c(ConcurrentWeakMap$entries$1.INSTANCE);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (K k2 : keySet()) {
            remove(k2);
        }
    }

    @Override // h.a2.f
    @k.e.a.d
    public Set<K> d() {
        return new c(ConcurrentWeakMap$keys$1.INSTANCE);
    }

    @Override // h.a2.f
    public int f() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @k.e.a.e
    public V get(@k.e.a.d Object obj) {
        if (obj != null) {
            return (V) ((a) this.core).c(obj);
        }
        return null;
    }

    public final void m() {
        if (!(this.a != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> remove = this.a.remove();
                if (remove == null) {
                    break;
                }
                j((i.b.u3.b.e) remove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
    }

    @Override // h.a2.f, java.util.AbstractMap, java.util.Map
    @k.e.a.e
    public V put(@k.e.a.d K k2, @k.e.a.d V v) {
        i0 i0Var;
        V v2 = (V) a.g((a) this.core, k2, v, null, 4, null);
        i0Var = i.b.u3.b.a.f15849c;
        if (v2 == i0Var) {
            v2 = l(k2, v);
        }
        if (v2 == null) {
            b.incrementAndGet(this);
        }
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @k.e.a.e
    public V remove(@k.e.a.d Object obj) {
        i0 i0Var;
        if (obj != 0) {
            V v = (V) a.g((a) this.core, obj, null, null, 4, null);
            i0Var = i.b.u3.b.a.f15849c;
            if (v == i0Var) {
                v = l(obj, null);
            }
            if (v != null) {
                b.decrementAndGet(this);
            }
            return v;
        }
        return null;
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new a(16);
        this.a = z ? new ReferenceQueue<>() : null;
    }
}
