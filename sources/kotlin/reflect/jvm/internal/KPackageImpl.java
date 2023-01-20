package kotlin.reflect.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.b0.g.l;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.f1.a.f;
import h.p2.b0.g.t.c.j;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.f.z.g;
import h.p2.c;
import h.p2.n;
import java.util.Collection;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001,B\u001d\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\b2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0016J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012 \u000f*\b\u0018\u00010\u000eR\u00020\u00000\u000eR\u00020\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u0018\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00038TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "usageModuleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "methodOwner", "getMethodOwner", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getUsageModuleName", "()Ljava/lang/String;", "equals", "", "other", "", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", TTDownloadField.TT_HASHCODE, "toString", "Data", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KPackageImpl extends KDeclarationContainerImpl {

    /* renamed from: d  reason: collision with root package name */
    private final l.b<Data> f16361d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f16362e;
    @e

    /* renamed from: f  reason: collision with root package name */
    private final String f16363f;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R%\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000eR/\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "members", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "metadata", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "getMetadata", "()Lkotlin/Triple;", "metadata$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "multifileFacade", "Ljava/lang/Class;", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade$delegate", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope$delegate", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class Data extends KDeclarationContainerImpl.Data {

        /* renamed from: j  reason: collision with root package name */
        public static final /* synthetic */ n[] f16364j = {n0.r(new PropertyReference1Impl(n0.d(Data.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "metadata", "getMetadata()Lkotlin/Triple;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "members", "getMembers()Ljava/util/Collection;"))};

        /* renamed from: d  reason: collision with root package name */
        private final l.a f16365d;
        @d

        /* renamed from: e  reason: collision with root package name */
        private final l.a f16366e;
        @e

        /* renamed from: f  reason: collision with root package name */
        private final l.b f16367f;
        @e

        /* renamed from: g  reason: collision with root package name */
        private final l.b f16368g;
        @d

        /* renamed from: h  reason: collision with root package name */
        private final l.a f16369h;

        public Data() {
            super();
            this.f16365d = l.d(new KPackageImpl$Data$kotlinClass$2(this));
            this.f16366e = l.d(new KPackageImpl$Data$scope$2(this));
            this.f16367f = l.b(new KPackageImpl$Data$multifileFacade$2(this));
            this.f16368g = l.b(new KPackageImpl$Data$metadata$2(this));
            this.f16369h = l.d(new KPackageImpl$Data$members$2(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final f c() {
            return (f) this.f16365d.b(this, f16364j[0]);
        }

        @d
        public final Collection<KCallableImpl<?>> d() {
            return (Collection) this.f16369h.b(this, f16364j[4]);
        }

        @e
        public final Triple<h.p2.b0.g.t.f.a0.f.f, ProtoBuf.Package, h.p2.b0.g.t.f.a0.f.e> e() {
            return (Triple) this.f16368g.b(this, f16364j[3]);
        }

        @e
        public final Class<?> f() {
            return (Class) this.f16367f.b(this, f16364j[2]);
        }

        @d
        public final MemberScope g() {
            return (MemberScope) this.f16366e.b(this, f16364j[1]);
        }
    }

    public /* synthetic */ KPackageImpl(Class cls, String str, int i2, u uVar) {
        this(cls, (i2 & 2) != 0 ? null : str);
    }

    private final MemberScope V() {
        return this.f16361d.invoke().g();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @d
    public Collection<j> J() {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @d
    public Collection<v> K(@d h.p2.b0.g.t.g.f fVar) {
        return V().a(fVar, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @e
    public j0 L(int i2) {
        Triple<h.p2.b0.g.t.f.a0.f.f, ProtoBuf.Package, h.p2.b0.g.t.f.a0.f.e> e2 = this.f16361d.invoke().e();
        if (e2 != null) {
            h.p2.b0.g.t.f.a0.f.f component1 = e2.component1();
            ProtoBuf.Package component2 = e2.component2();
            h.p2.b0.g.t.f.a0.f.e component3 = e2.component3();
            ProtoBuf.Property property = (ProtoBuf.Property) h.p2.b0.g.t.f.z.e.b(component2, JvmProtoBuf.n, i2);
            if (property != null) {
                return (j0) q.g(d(), property, component1, new g(component2.getTypeTable()), component3, KPackageImpl$getLocalProperty$1$1$1.INSTANCE);
            }
            return null;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @d
    public Class<?> N() {
        Class<?> f2 = this.f16361d.invoke().f();
        return f2 != null ? f2 : d();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @d
    public Collection<j0> O(@d h.p2.b0.g.t.g.f fVar) {
        return V().c(fVar, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // h.k2.v.r
    @d
    public Class<?> d() {
        return this.f16362e;
    }

    public boolean equals(@e Object obj) {
        return (obj instanceof KPackageImpl) && f0.g(d(), ((KPackageImpl) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // h.p2.h
    @d
    public Collection<c<?>> q() {
        return this.f16361d.invoke().d();
    }

    @d
    public String toString() {
        return "file class " + ReflectClassUtilKt.a(d()).b();
    }

    public KPackageImpl(@d Class<?> cls, @e String str) {
        this.f16362e = cls;
        this.f16363f = str;
        this.f16361d = l.b(new KPackageImpl$data$1(this));
    }
}
