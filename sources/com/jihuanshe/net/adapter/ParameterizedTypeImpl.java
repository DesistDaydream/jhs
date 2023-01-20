package com.jihuanshe.net.adapter;

import h.k2.k;
import h.k2.v.u;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ParameterizedTypeImpl implements ParameterizedType {
    @d
    public static final Companion Companion = new Companion(null);
    @d
    private final Type[] actualTypeArguments;
    @e
    private final Type ownerType;
    @d
    private final Type rawType;

    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        @k
        @d
        public final ParameterizedTypeImpl get(@d Type type, @d Type... typeArr) {
            int length = typeArr.length;
            if (length > 1) {
                int i2 = length - 1;
                ParameterizedTypeImpl parameterizedTypeImpl = new ParameterizedTypeImpl(typeArr[length - 2], typeArr[i2]);
                Type[] typeArr2 = (Type[]) Arrays.copyOf(typeArr, i2);
                typeArr2[typeArr2.length - 1] = parameterizedTypeImpl;
                return get(type, (Type[]) Arrays.copyOf(typeArr2, typeArr2.length));
            }
            return new ParameterizedTypeImpl(type, typeArr[0]);
        }

        @k
        @d
        public final ParameterizedTypeImpl getParameterized(@d Type type, @d Type... typeArr) {
            return new ParameterizedTypeImpl(null, type, (Type[]) Arrays.copyOf(typeArr, typeArr.length));
        }
    }

    public ParameterizedTypeImpl(@e Type type, @d Type type2, @d Type... typeArr) {
        this.ownerType = type;
        this.rawType = type2;
        this.actualTypeArguments = typeArr;
    }

    @k
    @d
    public static final ParameterizedTypeImpl get(@d Type type, @d Type... typeArr) {
        return Companion.get(type, typeArr);
    }

    @k
    @d
    public static final ParameterizedTypeImpl getParameterized(@d Type type, @d Type... typeArr) {
        return Companion.getParameterized(type, typeArr);
    }

    @Override // java.lang.reflect.ParameterizedType
    @d
    public Type[] getActualTypeArguments() {
        return this.actualTypeArguments;
    }

    @Override // java.lang.reflect.ParameterizedType
    @e
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    @d
    public Type getRawType() {
        return this.rawType;
    }

    public ParameterizedTypeImpl(@d Type type, @d Type type2) {
        this(null, type, type2);
    }
}
