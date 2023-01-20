package kotlin.reflect.jvm.internal;

import h.k2.u.a;
import h.p2.n;
import h.w;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<no name provided>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 extends Lambda implements a<Type> {
    public final /* synthetic */ int $i;
    public final /* synthetic */ w $parameterizedTypeArguments$inlined;
    public final /* synthetic */ n $parameterizedTypeArguments$metadata$inlined;
    public final /* synthetic */ KTypeImpl$arguments$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(int i2, KTypeImpl$arguments$2 kTypeImpl$arguments$2, w wVar, n nVar) {
        super(0);
        this.$i = i2;
        this.this$0 = kTypeImpl$arguments$2;
        this.$parameterizedTypeArguments$inlined = wVar;
        this.$parameterizedTypeArguments$metadata$inlined = nVar;
    }

    @Override // h.k2.u.a
    @d
    public final Type invoke() {
        Type c2 = this.this$0.this$0.c();
        if (c2 instanceof Class) {
            Class cls = (Class) c2;
            return cls.isArray() ? cls.getComponentType() : Object.class;
        } else if (c2 instanceof GenericArrayType) {
            if (this.$i == 0) {
                return ((GenericArrayType) c2).getGenericComponentType();
            }
            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this.this$0.this$0);
        } else if (c2 instanceof ParameterizedType) {
            Type type = (Type) ((List) this.$parameterizedTypeArguments$inlined.getValue()).get(this.$i);
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type type2 = (Type) ArraysKt___ArraysKt.Kb(wildcardType.getLowerBounds());
                return type2 != null ? type2 : (Type) ArraysKt___ArraysKt.ob(wildcardType.getUpperBounds());
            }
            return type;
        } else {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this.this$0.this$0);
        }
    }
}
