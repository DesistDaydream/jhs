package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import h.a2.u;
import h.k2.a;
import h.k2.v.f0;
import h.p2.b0.d;
import h.p2.b0.f;
import h.p2.b0.g.j;
import h.p2.b0.g.l;
import h.p2.b0.g.q;
import h.p2.b0.g.s.b;
import h.p2.b0.g.t.c.v;
import h.p2.c;
import h.p2.r;
import h.p2.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J%\u00106\u001a\u00028\u00002\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0016¢\u0006\u0002\u0010:J#\u0010;\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0002¢\u0006\u0002\u0010=J#\u0010>\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0016¢\u0006\u0002\u0010=J3\u0010?\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<2\f\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010AH\u0000¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020,H\u0002J\n\u0010F\u001a\u0004\u0018\u00010GH\u0002R(\u0010\u0005\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b \t*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \t*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000e0\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \t*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010$R\u0014\u0010%\u001a\u00020#8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0012\u0010&\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0013R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0013R\u0016\u00102\u001a\u0004\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006H"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", PushConstants.PARAMS, "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public abstract class KCallableImpl<R> implements c<R>, j {
    private final l.a<List<Annotation>> a = l.d(new KCallableImpl$_annotations$1(this));
    private final l.a<ArrayList<KParameter>> b = l.d(new KCallableImpl$_parameters$1(this));

    /* renamed from: c */
    private final l.a<KTypeImpl> f16335c = l.d(new KCallableImpl$_returnType$1(this));

    /* renamed from: d */
    private final l.a<List<KTypeParameterImpl>> f16336d = l.d(new KCallableImpl$_typeParameters$1(this));

    public final Type F() {
        Type[] lowerBounds;
        CallableMemberDescriptor J = J();
        if (!(J instanceof v)) {
            J = null;
        }
        v vVar = (v) J;
        if (vVar == null || !vVar.isSuspend()) {
            return null;
        }
        Object i3 = CollectionsKt___CollectionsKt.i3(G().a());
        if (!(i3 instanceof ParameterizedType)) {
            i3 = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) i3;
        if (f0.g(parameterizedType != null ? parameterizedType.getRawType() : null, h.e2.c.class)) {
            Object Cs = ArraysKt___ArraysKt.Cs(parameterizedType.getActualTypeArguments());
            if (!(Cs instanceof WildcardType)) {
                Cs = null;
            }
            WildcardType wildcardType = (WildcardType) Cs;
            if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
                return null;
            }
            return (Type) ArraysKt___ArraysKt.ob(lowerBounds);
        }
        return null;
    }

    private final R h(Map<KParameter, ? extends Object> map) {
        Object t;
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(u.Y(parameters, 10));
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                t = map.get(kParameter);
                if (t == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.s()) {
                t = null;
            } else if (!kParameter.k()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            } else {
                t = t(kParameter.getType());
            }
            arrayList.add(t);
        }
        b<?> I = I();
        if (I != null) {
            try {
                Object[] array = arrayList.toArray(new Object[0]);
                if (array != null) {
                    return (R) I.call(array);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (IllegalAccessException e2) {
                throw new IllegalCallableAccessException(e2);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + J());
    }

    private final Object t(r rVar) {
        Class c2 = a.c(d.b(rVar));
        if (c2.isArray()) {
            return Array.newInstance(c2.getComponentType(), 0);
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + c2.getSimpleName() + ", because it is not an array type");
    }

    @k.e.a.d
    public abstract b<?> G();

    @k.e.a.d
    public abstract KDeclarationContainerImpl H();

    @e
    public abstract b<?> I();

    @k.e.a.d
    public abstract CallableMemberDescriptor J();

    public final boolean K() {
        return f0.g(getName(), "<init>") && H().d().isAnnotation();
    }

    public abstract boolean L();

    @Override // h.p2.c
    public R call(@k.e.a.d Object... objArr) {
        try {
            return (R) G().call(objArr);
        } catch (IllegalAccessException e2) {
            throw new IllegalCallableAccessException(e2);
        }
    }

    @Override // h.p2.c
    public R callBy(@k.e.a.d Map<KParameter, ? extends Object> map) {
        return K() ? h(map) : l(map, null);
    }

    @Override // h.p2.b
    @k.e.a.d
    public List<Annotation> getAnnotations() {
        return this.a.invoke();
    }

    @Override // h.p2.c
    @k.e.a.d
    public List<KParameter> getParameters() {
        return this.b.invoke();
    }

    @Override // h.p2.c
    @k.e.a.d
    public r getReturnType() {
        return this.f16335c.invoke();
    }

    @Override // h.p2.c
    @k.e.a.d
    public List<s> getTypeParameters() {
        return this.f16336d.invoke();
    }

    @Override // h.p2.c
    @e
    public KVisibility getVisibility() {
        return q.p(J().getVisibility());
    }

    @Override // h.p2.c
    public boolean isAbstract() {
        return J().t() == Modality.ABSTRACT;
    }

    @Override // h.p2.c
    public boolean isFinal() {
        return J().t() == Modality.FINAL;
    }

    @Override // h.p2.c
    public boolean isOpen() {
        return J().t() == Modality.OPEN;
    }

    public final R l(@k.e.a.d Map<KParameter, ? extends Object> map, @e h.e2.c<?> cVar) {
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<KParameter> it = parameters.iterator();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                if (cVar != null) {
                    arrayList.add(cVar);
                }
                if (!z) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i3));
                b<?> I = I();
                if (I != null) {
                    arrayList.addAll(arrayList2);
                    arrayList.add(null);
                    try {
                        Object[] array2 = arrayList.toArray(new Object[0]);
                        if (array2 != null) {
                            return (R) I.call(array2);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    } catch (IllegalAccessException e2) {
                        throw new IllegalCallableAccessException(e2);
                    }
                }
                throw new KotlinReflectionInternalError("This callable does not support a default call: " + J());
            }
            KParameter next = it.next();
            if (i2 != 0 && i2 % 32 == 0) {
                arrayList2.add(Integer.valueOf(i3));
                i3 = 0;
            }
            if (map.containsKey(next)) {
                arrayList.add(map.get(next));
            } else if (next.s()) {
                arrayList.add(q.j(next.getType()) ? null : q.f(f.g(next.getType())));
                i3 = (1 << (i2 % 32)) | i3;
                z = true;
            } else if (next.k()) {
                arrayList.add(t(next.getType()));
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
            }
            if (next.i() == KParameter.Kind.VALUE) {
                i2++;
            }
        }
    }
}
