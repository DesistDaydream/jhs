package kotlin.reflect;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.j256.ormlite.stmt.query.SimpleComparison;
import h.k2.v.f0;
import h.o;
import h.p2.v;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;

@o
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "equals", "", "other", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "getRawType", "getTypeName", "", TTDownloadField.TT_HASHCODE, "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ParameterizedTypeImpl implements ParameterizedType, v {
    private final Type[] a;
    private final Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f16334c;

    public ParameterizedTypeImpl(@d Class<?> cls, @e Type type, @d List<? extends Type> list) {
        this.b = cls;
        this.f16334c = type;
        Object[] array = list.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.a = (Type[]) array;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (f0.g(this.b, parameterizedType.getRawType()) && f0.g(this.f16334c, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @d
    public Type[] getActualTypeArguments() {
        return this.a;
    }

    @Override // java.lang.reflect.ParameterizedType
    @e
    public Type getOwnerType() {
        return this.f16334c;
    }

    @Override // java.lang.reflect.ParameterizedType
    @d
    public Type getRawType() {
        return this.b;
    }

    @Override // java.lang.reflect.Type, h.p2.v
    @d
    public String getTypeName() {
        String j2;
        String j3;
        StringBuilder sb = new StringBuilder();
        Type type = this.f16334c;
        if (type != null) {
            j3 = TypesJVMKt.j(type);
            sb.append(j3);
            sb.append("$");
            sb.append(this.b.getSimpleName());
        } else {
            j2 = TypesJVMKt.j(this.b);
            sb.append(j2);
        }
        Type[] typeArr = this.a;
        if (!(typeArr.length == 0)) {
            ArraysKt___ArraysKt.hg(typeArr, sb, (r14 & 2) != 0 ? ", " : null, (r14 & 4) != 0 ? "" : SimpleComparison.LESS_THAN_OPERATION, (r14 & 8) == 0 ? SimpleComparison.GREATER_THAN_OPERATION : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : ParameterizedTypeImpl$getTypeName$1$1.INSTANCE);
        }
        return sb.toString();
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        Type type = this.f16334c;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @d
    public String toString() {
        return getTypeName();
    }
}
