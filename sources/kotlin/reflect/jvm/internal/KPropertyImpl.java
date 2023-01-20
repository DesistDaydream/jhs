package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.b0.g.l;
import h.p2.b0.g.o;
import h.p2.b0.g.q;
import h.p2.b0.g.s.f;
import h.p2.b0.g.t.c.i0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k0;
import h.p2.b0.g.t.c.l0;
import h.p2.i;
import h.p2.j;
import h.p2.n;
import h.t1;
import h.t2.y;
import java.lang.reflect.Field;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 >*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004=>?@B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\n\u00104\u001a\u0004\u0018\u00010\u0017H\u0004J\u0013\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u001e\u00107\u001a\u0004\u0018\u00010\n2\b\u00108\u001a\u0004\u0018\u00010\u00172\b\u00109\u001a\u0004\u0018\u00010\nH\u0004J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\r0\r0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0013\u0010.\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00102¨\u0006A"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", TTDownloadField.TT_HASHCODE, "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements n<V> {

    /* renamed from: e */
    private final l.b<Field> f16383e;

    /* renamed from: f */
    private final l.a<j0> f16384f;
    @d

    /* renamed from: g */
    private final KDeclarationContainerImpl f16385g;
    @d

    /* renamed from: h */
    private final String f16386h;
    @d

    /* renamed from: i */
    private final String f16387i;

    /* renamed from: j */
    private final Object f16388j;
    @d

    /* renamed from: l */
    public static final b f16382l = new b(null);
    @d

    /* renamed from: k */
    private static final Object f16381k = new Object();

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static abstract class Getter<V> extends a<V, V> implements n.c<V> {

        /* renamed from: g */
        public static final /* synthetic */ n[] f16389g = {n0.r(new PropertyReference1Impl(n0.d(Getter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), n0.r(new PropertyReference1Impl(n0.d(Getter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        @d

        /* renamed from: e */
        private final l.a f16390e = l.d(new KPropertyImpl$Getter$descriptor$2(this));
        @d

        /* renamed from: f */
        private final l.b f16391f = l.b(new KPropertyImpl$Getter$caller$2(this));

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @d
        public h.p2.b0.g.s.b<?> G() {
            return (h.p2.b0.g.s.b) this.f16391f.b(this, f16389g[1]);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.a
        @d
        /* renamed from: O */
        public k0 M() {
            return (k0) this.f16390e.b(this, f16389g[0]);
        }

        public boolean equals(@e Object obj) {
            return (obj instanceof Getter) && f0.g(N(), ((Getter) obj).N());
        }

        @Override // h.p2.c
        @d
        public String getName() {
            return "<get-" + N().getName() + y.f15692e;
        }

        public int hashCode() {
            return N().hashCode();
        }

        @d
        public String toString() {
            return "getter of " + N();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static abstract class Setter<V> extends a<V, t1> implements j.a<V> {

        /* renamed from: g */
        public static final /* synthetic */ n[] f16392g = {n0.r(new PropertyReference1Impl(n0.d(Setter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), n0.r(new PropertyReference1Impl(n0.d(Setter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        @d

        /* renamed from: e */
        private final l.a f16393e = l.d(new KPropertyImpl$Setter$descriptor$2(this));
        @d

        /* renamed from: f */
        private final l.b f16394f = l.b(new KPropertyImpl$Setter$caller$2(this));

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @d
        public h.p2.b0.g.s.b<?> G() {
            return (h.p2.b0.g.s.b) this.f16394f.b(this, f16392g[1]);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.a
        @d
        /* renamed from: O */
        public l0 M() {
            return (l0) this.f16393e.b(this, f16392g[0]);
        }

        public boolean equals(@e Object obj) {
            return (obj instanceof Setter) && f0.g(N(), ((Setter) obj).N());
        }

        @Override // h.p2.c
        @d
        public String getName() {
            return "<set-" + N().getName() + y.f15692e;
        }

        public int hashCode() {
            return N().hashCode();
        }

        @d
        public String toString() {
            return "setter of " + N();
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static abstract class a<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements i<ReturnType>, n.a<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @d
        public KDeclarationContainerImpl H() {
            return N().H();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @e
        public h.p2.b0.g.s.b<?> I() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public boolean L() {
            return N().L();
        }

        @d
        public abstract i0 M();

        @d
        public abstract KPropertyImpl<PropertyType> N();

        @Override // h.p2.i
        public boolean isExternal() {
            return M().isExternal();
        }

        @Override // h.p2.i
        public boolean isInfix() {
            return M().isInfix();
        }

        @Override // h.p2.i
        public boolean isInline() {
            return M().isInline();
        }

        @Override // h.p2.i
        public boolean isOperator() {
            return M().isOperator();
        }

        @Override // h.p2.c
        public boolean isSuspend() {
            return M().isSuspend();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        @d
        public final Object a() {
            return KPropertyImpl.f16381k;
        }

        public /* synthetic */ b(u uVar) {
            this();
        }
    }

    private KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, j0 j0Var, Object obj) {
        this.f16385g = kDeclarationContainerImpl;
        this.f16386h = str;
        this.f16387i = str2;
        this.f16388j = obj;
        this.f16383e = l.b(new KPropertyImpl$_javaField$1(this));
        this.f16384f = l.c(j0Var, new KPropertyImpl$_descriptor$1(this));
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @d
    public h.p2.b0.g.s.b<?> G() {
        return R().G();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @d
    public KDeclarationContainerImpl H() {
        return this.f16385g;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @e
    public h.p2.b0.g.s.b<?> I() {
        return R().I();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean L() {
        return !f0.g(this.f16388j, CallableReference.NO_RECEIVER);
    }

    @e
    public final Field N() {
        if (J().C()) {
            return S();
        }
        return null;
    }

    @e
    public final Object O() {
        return f.a(this.f16388j, J());
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
        return r2.get(r3);
     */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object P(@k.e.a.e java.lang.reflect.Field r2, @k.e.a.e java.lang.Object r3) {
        /*
            r1 = this;
            java.lang.Object r0 = kotlin.reflect.jvm.internal.KPropertyImpl.f16381k     // Catch: java.lang.IllegalAccessException -> L39
            if (r3 != r0) goto L30
            h.p2.b0.g.t.c.j0 r0 = r1.J()     // Catch: java.lang.IllegalAccessException -> L39
            h.p2.b0.g.t.c.m0 r0 = r0.Q()     // Catch: java.lang.IllegalAccessException -> L39
            if (r0 == 0) goto Lf
            goto L30
        Lf:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.IllegalAccessException -> L39
            r3.<init>()     // Catch: java.lang.IllegalAccessException -> L39
            r0 = 39
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            r3.append(r1)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r0 = "' is not an extension property and thus getExtensionDelegate() "
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r0 = "is not going to work, use getDelegate() instead"
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r3 = r3.toString()     // Catch: java.lang.IllegalAccessException -> L39
            r2.<init>(r3)     // Catch: java.lang.IllegalAccessException -> L39
            throw r2     // Catch: java.lang.IllegalAccessException -> L39
        L30:
            if (r2 == 0) goto L37
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.IllegalAccessException -> L39
            goto L38
        L37:
            r2 = 0
        L38:
            return r2
        L39:
            r2 = move-exception
            kotlin.reflect.full.IllegalPropertyDelegateAccessException r3 = new kotlin.reflect.full.IllegalPropertyDelegateAccessException
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImpl.P(java.lang.reflect.Field, java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @d
    /* renamed from: Q */
    public j0 J() {
        return this.f16384f.invoke();
    }

    @d
    public abstract Getter<V> R();

    @e
    public final Field S() {
        return this.f16383e.invoke();
    }

    @d
    public final String T() {
        return this.f16387i;
    }

    public boolean equals(@e Object obj) {
        KPropertyImpl<?> c2 = q.c(obj);
        return c2 != null && f0.g(H(), c2.H()) && f0.g(getName(), c2.getName()) && f0.g(this.f16387i, c2.f16387i) && f0.g(this.f16388j, c2.f16388j);
    }

    @Override // h.p2.c
    @d
    public String getName() {
        return this.f16386h;
    }

    public int hashCode() {
        return (((H().hashCode() * 31) + getName().hashCode()) * 31) + this.f16387i.hashCode();
    }

    @Override // h.p2.n
    public boolean isConst() {
        return J().isConst();
    }

    @Override // h.p2.n
    public boolean isLateinit() {
        return J().v0();
    }

    @Override // h.p2.c
    public boolean isSuspend() {
        return false;
    }

    @d
    public String toString() {
        return ReflectionObjectRenderer.b.g(J());
    }

    public KPropertyImpl(@d KDeclarationContainerImpl kDeclarationContainerImpl, @d String str, @d String str2, @e Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
    }

    public KPropertyImpl(@d KDeclarationContainerImpl kDeclarationContainerImpl, @d j0 j0Var) {
        this(kDeclarationContainerImpl, j0Var.getName().b(), o.b.f(j0Var).a(), j0Var, CallableReference.NO_RECEIVER);
    }
}
