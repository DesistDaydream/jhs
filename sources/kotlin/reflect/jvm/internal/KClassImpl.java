package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.a;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.t0;
import h.p2.b0.g.g;
import h.p2.b0.g.j;
import h.p2.b0.g.l;
import h.p2.b0.g.o;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.f1.a.f;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.g.b;
import h.p2.c;
import h.p2.d;
import h.p2.i;
import h.p2.n;
import h.p2.r;
import h.p2.s;
import h.t2.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006:\u0001eB\u0013\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0013\u0010T\u001a\u00020&2\b\u0010U\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00142\u0006\u0010X\u001a\u00020YH\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]H\u0016J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020[0\u00142\u0006\u0010X\u001a\u00020YH\u0016J\b\u0010_\u001a\u00020]H\u0016J\u0012\u0010`\u001a\u00020&2\b\u0010a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020AH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R3\u0010\u001b\u001a$\u0012 \u0012\u001e \u001e*\u000e\u0018\u00010\u001dR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001dR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010'R\u0014\u0010.\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010'R\u001a\u0010/\u001a\u00020&8VX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b/\u0010'R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u0002058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001e\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0017R\u001e\u0010;\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0017R\u0016\u0010=\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\"\u0010D\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u000eR\u0016\u0010F\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010CR\u0014\u0010H\u001a\u0002058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u00107R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u000eR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u000eR\u0016\u0010P\u001a\u0004\u0018\u00010Q8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006f"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isFun", "isInner", "isOpen", "isSealed", "isValue", "isValue$annotations", "()V", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", TTDownloadField.TT_HASHCODE, "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements d<T>, g, j {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final l.b<KClassImpl<T>.Data> f16337d = l.b(new KClassImpl$data$1(this));
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final Class<T> f16338e;

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010N\u001a\u00020<2\n\u0010O\u001a\u0006\u0012\u0002\b\u00030PH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R)\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010\u0015R\u001d\u0010C\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bD\u0010>R!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\n\u001a\u0004\bH\u0010\u0015R!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bL\u0010\u0015¨\u0006Q"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "getObjectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        public static final /* synthetic */ n[] w = {n0.r(new PropertyReference1Impl(n0.d(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), n0.r(new PropertyReference1Impl(n0.d(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        private final l.a f16339d;
        @k.e.a.d

        /* renamed from: e  reason: collision with root package name */
        private final l.a f16340e;
        @e

        /* renamed from: f  reason: collision with root package name */
        private final l.a f16341f;
        @e

        /* renamed from: g  reason: collision with root package name */
        private final l.a f16342g;
        @k.e.a.d

        /* renamed from: h  reason: collision with root package name */
        private final l.a f16343h;
        @k.e.a.d

        /* renamed from: i  reason: collision with root package name */
        private final l.a f16344i;
        @e

        /* renamed from: j  reason: collision with root package name */
        private final l.b f16345j;
        @k.e.a.d

        /* renamed from: k  reason: collision with root package name */
        private final l.a f16346k;
        @k.e.a.d

        /* renamed from: l  reason: collision with root package name */
        private final l.a f16347l;
        @k.e.a.d

        /* renamed from: m  reason: collision with root package name */
        private final l.a f16348m;
        @k.e.a.d
        private final l.a n;
        private final l.a o;
        private final l.a p;
        private final l.a q;
        @k.e.a.d
        private final l.a r;
        @k.e.a.d
        private final l.a s;
        @k.e.a.d
        private final l.a t;
        @k.e.a.d
        private final l.a u;

        public Data() {
            super();
            this.f16339d = l.d(new KClassImpl$Data$descriptor$2(this));
            this.f16340e = l.d(new KClassImpl$Data$annotations$2(this));
            this.f16341f = l.d(new KClassImpl$Data$simpleName$2(this));
            this.f16342g = l.d(new KClassImpl$Data$qualifiedName$2(this));
            this.f16343h = l.d(new KClassImpl$Data$constructors$2(this));
            this.f16344i = l.d(new KClassImpl$Data$nestedClasses$2(this));
            this.f16345j = l.b(new KClassImpl$Data$objectInstance$2(this));
            this.f16346k = l.d(new KClassImpl$Data$typeParameters$2(this));
            this.f16347l = l.d(new KClassImpl$Data$supertypes$2(this));
            this.f16348m = l.d(new KClassImpl$Data$sealedSubclasses$2(this));
            this.n = l.d(new KClassImpl$Data$declaredNonStaticMembers$2(this));
            this.o = l.d(new KClassImpl$Data$declaredStaticMembers$2(this));
            this.p = l.d(new KClassImpl$Data$inheritedNonStaticMembers$2(this));
            this.q = l.d(new KClassImpl$Data$inheritedStaticMembers$2(this));
            this.r = l.d(new KClassImpl$Data$allNonStaticMembers$2(this));
            this.s = l.d(new KClassImpl$Data$allStaticMembers$2(this));
            this.t = l.d(new KClassImpl$Data$declaredMembers$2(this));
            this.u = l.d(new KClassImpl$Data$allMembers$2(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                return StringsKt__StringsKt.m5(simpleName, enclosingMethod.getName() + "$", null, 2, null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                return StringsKt__StringsKt.m5(simpleName, enclosingConstructor.getName() + "$", null, 2, null);
            }
            return StringsKt__StringsKt.l5(simpleName, '$', null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> n() {
            return (Collection) this.o.b(this, w[11]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> p() {
            return (Collection) this.p.b(this, w[12]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> q() {
            return (Collection) this.q.b(this, w[13]);
        }

        @k.e.a.d
        public final Collection<KCallableImpl<?>> g() {
            return (Collection) this.u.b(this, w[17]);
        }

        @k.e.a.d
        public final Collection<KCallableImpl<?>> h() {
            return (Collection) this.r.b(this, w[14]);
        }

        @k.e.a.d
        public final Collection<KCallableImpl<?>> i() {
            return (Collection) this.s.b(this, w[15]);
        }

        @k.e.a.d
        public final List<Annotation> j() {
            return (List) this.f16340e.b(this, w[1]);
        }

        @k.e.a.d
        public final Collection<i<T>> k() {
            return (Collection) this.f16343h.b(this, w[4]);
        }

        @k.e.a.d
        public final Collection<KCallableImpl<?>> l() {
            return (Collection) this.t.b(this, w[16]);
        }

        @k.e.a.d
        public final Collection<KCallableImpl<?>> m() {
            return (Collection) this.n.b(this, w[10]);
        }

        @k.e.a.d
        public final h.p2.b0.g.t.c.d o() {
            return (h.p2.b0.g.t.c.d) this.f16339d.b(this, w[0]);
        }

        @k.e.a.d
        public final Collection<d<?>> r() {
            return (Collection) this.f16344i.b(this, w[5]);
        }

        @e
        public final T s() {
            return this.f16345j.b(this, w[6]);
        }

        @e
        public final String t() {
            return (String) this.f16342g.b(this, w[3]);
        }

        @k.e.a.d
        public final List<d<? extends T>> u() {
            return (List) this.f16348m.b(this, w[9]);
        }

        @e
        public final String v() {
            return (String) this.f16341f.b(this, w[2]);
        }

        @k.e.a.d
        public final List<r> w() {
            return (List) this.f16347l.b(this, w[8]);
        }

        @k.e.a.d
        public final List<s> x() {
            return (List) this.f16346k.b(this, w[7]);
        }
    }

    public KClassImpl(@k.e.a.d Class<T> cls) {
        this.f16338e = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b X() {
        return o.b.c(d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void c0() {
        KotlinClassHeader c2;
        f a = f.f15191c.a(d());
        KotlinClassHeader.Kind c3 = (a == null || (c2 = a.c()) == null) ? null : c2.c();
        if (c3 != null) {
            switch (h.p2.b0.g.f.a[c3.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + d());
                case 4:
                    throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations does it have. Please use Java reflection to inspect this class: " + d());
                case 5:
                    throw new KotlinReflectionInternalError("Unknown class: " + d() + " (kind = " + c3 + ')');
                case 6:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        throw new KotlinReflectionInternalError("Unresolved class: " + d());
    }

    @Override // h.p2.d
    @e
    public T A() {
        return this.f16337d.invoke().s();
    }

    @Override // h.p2.d
    public boolean B() {
        return e().a0();
    }

    @Override // h.p2.d
    public boolean C(@e Object obj) {
        Integer c2 = ReflectClassUtilKt.c(d());
        if (c2 != null) {
            return t0.B(obj, c2.intValue());
        }
        Class g2 = ReflectClassUtilKt.g(d());
        if (g2 == null) {
            g2 = d();
        }
        return g2.isInstance(obj);
    }

    @Override // h.p2.d
    @e
    public String D() {
        return this.f16337d.invoke().t();
    }

    @Override // h.p2.d
    @e
    public String E() {
        return this.f16337d.invoke().v();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.j> J() {
        h.p2.b0.g.t.c.d e2 = e();
        if (e2.i() != ClassKind.INTERFACE && e2.i() != ClassKind.OBJECT) {
            return e2.g();
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @k.e.a.d
    public Collection<v> K(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        MemberScope a0 = a0();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt___CollectionsKt.q4(a0.a(fVar, noLookupLocation), b0().a(fVar, noLookupLocation));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @e
    public j0 L(int i2) {
        ProtoBuf.Property property;
        Class<?> declaringClass;
        if (f0.g(d().getSimpleName(), "DefaultImpls") && (declaringClass = d().getDeclaringClass()) != null && declaringClass.isInterface()) {
            d g2 = a.g(declaringClass);
            Objects.requireNonNull(g2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((KClassImpl) g2).L(i2);
        }
        h.p2.b0.g.t.c.d e2 = e();
        if (!(e2 instanceof DeserializedClassDescriptor)) {
            e2 = null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) e2;
        if (deserializedClassDescriptor == null || (property = (ProtoBuf.Property) h.p2.b0.g.t.f.z.e.b(deserializedClassDescriptor.T0(), JvmProtoBuf.f16711j, i2)) == null) {
            return null;
        }
        return (j0) q.g(d(), property, deserializedClassDescriptor.S0().g(), deserializedClassDescriptor.S0().j(), deserializedClassDescriptor.V0(), KClassImpl$getLocalProperty$2$1$1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @k.e.a.d
    public Collection<j0> O(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        MemberScope a0 = a0();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt___CollectionsKt.q4(a0.c(fVar, noLookupLocation), b0().c(fVar, noLookupLocation));
    }

    @k.e.a.d
    public final l.b<KClassImpl<T>.Data> Y() {
        return this.f16337d;
    }

    @Override // h.p2.b0.g.g
    @k.e.a.d
    /* renamed from: Z */
    public h.p2.b0.g.t.c.d e() {
        return this.f16337d.invoke().o();
    }

    @k.e.a.d
    public final MemberScope a0() {
        return e().r().q();
    }

    @k.e.a.d
    public final MemberScope b0() {
        return e().k0();
    }

    @Override // h.k2.v.r
    @k.e.a.d
    public Class<T> d() {
        return this.f16338e;
    }

    @Override // h.p2.d
    public boolean equals(@e Object obj) {
        return (obj instanceof KClassImpl) && f0.g(a.e(this), a.e((d) obj));
    }

    @Override // h.p2.d
    @k.e.a.d
    public Collection<i<T>> g() {
        return this.f16337d.invoke().k();
    }

    @Override // h.p2.b
    @k.e.a.d
    public List<Annotation> getAnnotations() {
        return this.f16337d.invoke().j();
    }

    @Override // h.p2.d
    @k.e.a.d
    public List<s> getTypeParameters() {
        return this.f16337d.invoke().x();
    }

    @Override // h.p2.d
    @e
    public KVisibility getVisibility() {
        return q.p(e().getVisibility());
    }

    @Override // h.p2.d
    public int hashCode() {
        return a.e(this).hashCode();
    }

    @Override // h.p2.d
    public boolean isAbstract() {
        return e().t() == Modality.ABSTRACT;
    }

    @Override // h.p2.d
    public boolean isFinal() {
        return e().t() == Modality.FINAL;
    }

    @Override // h.p2.d
    public boolean isOpen() {
        return e().t() == Modality.OPEN;
    }

    @Override // h.p2.d
    @k.e.a.d
    public List<r> j() {
        return this.f16337d.invoke().w();
    }

    @Override // h.p2.d
    @k.e.a.d
    public List<d<? extends T>> m() {
        return this.f16337d.invoke().u();
    }

    @Override // h.p2.d
    public boolean n() {
        return e().n();
    }

    @Override // h.p2.d
    public boolean p() {
        return e().t() == Modality.SEALED;
    }

    @Override // h.p2.h
    @k.e.a.d
    public Collection<c<?>> q() {
        return this.f16337d.invoke().g();
    }

    @k.e.a.d
    public String toString() {
        h.p2.b0.g.t.g.c h2;
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        b X = X();
        if (X.h().d()) {
            str = "";
        } else {
            str = h2.b() + ".";
        }
        sb.append(str + u.j2(X.i().b(), '.', '$', false, 4, null));
        return sb.toString();
    }

    @Override // h.p2.d
    public boolean v() {
        return e().v();
    }

    @Override // h.p2.d
    public boolean w() {
        return e().w();
    }

    @Override // h.p2.d
    public boolean y() {
        return e().y();
    }

    @Override // h.p2.d
    @k.e.a.d
    public Collection<d<?>> z() {
        return this.f16337d.invoke().r();
    }
}
