package com.vector.gson;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import com.vector.gson.EnumTypeAdapterFactory;
import e.j.e.q;
import e.j.e.r.c;
import h.k2.v.f0;
import h.k2.v.u;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016J$\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0002¨\u0006\r"}, d2 = {"Lcom/vector/gson/EnumTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "createAdapter", "BasicType", "ValueType", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class EnumTypeAdapterFactory implements q {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/vector/gson/EnumTypeAdapterFactory$BasicType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "INT", "STRING", "LONG", "DOUBLE", "BOOLEAN", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum BasicType {
        INT(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL),
        STRING("java.lang.String"),
        LONG("long"),
        DOUBLE("double"),
        BOOLEAN("boolean");
        
        @d
        public static final a Companion = new a(null);
        @d
        private String value;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/vector/gson/EnumTypeAdapterFactory$BasicType$Companion;", "", "()V", "get", "Lcom/vector/gson/EnumTypeAdapterFactory$BasicType;", "name", "", "isBasicType", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }

            @d
            public final BasicType a(@d String str) {
                BasicType[] values;
                for (BasicType basicType : BasicType.values()) {
                    if (f0.g(basicType.getValue(), str)) {
                        return basicType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }

            public final boolean b(@d String str) {
                for (BasicType basicType : BasicType.values()) {
                    if (f0.g(basicType.getValue(), str)) {
                        return true;
                    }
                }
                return false;
            }
        }

        BasicType(String str) {
            this.value = str;
        }

        @d
        public final String getValue() {
            return this.value;
        }

        public final void setValue(@d String str) {
            this.value = str;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u000e\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/vector/gson/EnumTypeAdapterFactory$ValueType;", "", "value", "type", "Lcom/vector/gson/EnumTypeAdapterFactory$BasicType;", "(Ljava/lang/Object;Lcom/vector/gson/EnumTypeAdapterFactory$BasicType;)V", "getType", "()Lcom/vector/gson/EnumTypeAdapterFactory$BasicType;", "setType", "(Lcom/vector/gson/EnumTypeAdapterFactory$BasicType;)V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "component1", "component2", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        @d
        private Object a;
        @d
        private BasicType b;

        public a(@d Object obj, @d BasicType basicType) {
            this.a = obj;
            this.b = basicType;
        }

        public static /* synthetic */ a d(a aVar, Object obj, BasicType basicType, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = aVar.a;
            }
            if ((i2 & 2) != 0) {
                basicType = aVar.b;
            }
            return aVar.c(obj, basicType);
        }

        @d
        public final Object a() {
            return this.a;
        }

        @d
        public final BasicType b() {
            return this.b;
        }

        @d
        public final a c(@d Object obj, @d BasicType basicType) {
            return new a(obj, basicType);
        }

        @d
        public final Object e() {
            return this.a;
        }

        public boolean equals(@e Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(this.a, aVar.a) && this.b == aVar.b;
            }
            return false;
        }

        public final void f(@d BasicType basicType) {
            this.b = basicType;
        }

        public final void g(@d Object obj) {
            this.a = obj;
        }

        @d
        public final BasicType getType() {
            return this.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        @d
        public String toString() {
            return "ValueType(value=" + this.a + ", type=" + this.b + ')';
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BasicType.values().length];
            iArr[BasicType.INT.ordinal()] = 1;
            iArr[BasicType.STRING.ordinal()] = 2;
            iArr[BasicType.LONG.ordinal()] = 3;
            iArr[BasicType.DOUBLE.ordinal()] = 4;
            iArr[BasicType.BOOLEAN.ordinal()] = 5;
            a = iArr;
        }
    }

    private final <T> TypeAdapter<T> b(e.j.e.t.a<T> aVar) {
        List qa;
        Field field;
        Object valueOf;
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object[] enumConstants = aVar.getRawType().getEnumConstants();
        if (enumConstants != null && (qa = ArraysKt___ArraysKt.qa(enumConstants)) != null) {
            for (T t : qa) {
                Class<?> cls = t.getClass();
                c cVar = (c) cls.getField(t.toString()).getAnnotation(c.class);
                if (cVar != null) {
                    linkedHashMap.put(t, new a(cVar.value(), BasicType.STRING));
                } else {
                    Field[] declaredFields = cls.getDeclaredFields();
                    int length = declaredFields.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            field = null;
                            break;
                        }
                        field = declaredFields[i2];
                        if (BasicType.Companion.b(field.getType().getName())) {
                            break;
                        }
                        i2++;
                    }
                    if (field != null) {
                        field.setAccessible(true);
                        BasicType a2 = BasicType.Companion.a(field.getType().getName());
                        int i3 = b.a[a2.ordinal()];
                        if (i3 == 1) {
                            valueOf = Integer.valueOf(field.getInt(t));
                        } else if (i3 == 2) {
                            Object obj = field.get(t);
                            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                            valueOf = (String) obj;
                        } else if (i3 == 3) {
                            valueOf = Long.valueOf(field.getLong(t));
                        } else if (i3 == 4) {
                            valueOf = Double.valueOf(field.getDouble(t));
                        } else if (i3 != 5) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            valueOf = Boolean.valueOf(field.getBoolean(t));
                        }
                        linkedHashMap.put(t, new a(valueOf, a2));
                    } else {
                        linkedHashMap.put(t, new a(t.toString(), BasicType.STRING));
                    }
                }
            }
        }
        return new TypeAdapter<T>() { // from class: com.vector.gson.EnumTypeAdapterFactory$createAdapter$2

            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
            /* loaded from: classes3.dex */
            public /* synthetic */ class a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumTypeAdapterFactory.BasicType.values().length];
                    iArr[EnumTypeAdapterFactory.BasicType.INT.ordinal()] = 1;
                    iArr[EnumTypeAdapterFactory.BasicType.STRING.ordinal()] = 2;
                    iArr[EnumTypeAdapterFactory.BasicType.LONG.ordinal()] = 3;
                    iArr[EnumTypeAdapterFactory.BasicType.DOUBLE.ordinal()] = 4;
                    iArr[EnumTypeAdapterFactory.BasicType.BOOLEAN.ordinal()] = 5;
                    a = iArr;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v1, types: [T] */
            /* JADX WARN: Type inference failed for: r2v2 */
            /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
            @Override // com.google.gson.TypeAdapter
            @e
            public T e(@d e.j.e.u.a aVar2) {
                T t2 = 0;
                if (aVar2.C0() == JsonToken.NULL) {
                    aVar2.x0();
                    return null;
                }
                String A0 = aVar2.A0();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (f0.g(((EnumTypeAdapterFactory.a) entry.getValue()).e().toString(), A0)) {
                        t2 = entry.getKey();
                    }
                }
                return t2;
            }

            @Override // com.google.gson.TypeAdapter
            public void i(@d e.j.e.u.c cVar2, @e T t2) {
                if (t2 == 0) {
                    cVar2.Y();
                    return;
                }
                EnumTypeAdapterFactory.a aVar2 = linkedHashMap.get(t2);
                if (aVar2 == null) {
                    return;
                }
                int i4 = a.a[aVar2.getType().ordinal()];
                if (i4 == 1) {
                    cVar2.F0((Integer) aVar2.e());
                } else if (i4 == 2) {
                    cVar2.G0((String) aVar2.e());
                } else if (i4 == 3) {
                    cVar2.D0(((Long) aVar2.e()).longValue());
                } else if (i4 == 4) {
                    cVar2.C0(((Double) aVar2.e()).doubleValue());
                } else if (i4 != 5) {
                } else {
                    cVar2.H0(((Boolean) aVar2.e()).booleanValue());
                }
            }
        };
    }

    @Override // e.j.e.q
    @e
    public <T> TypeAdapter<T> a(@e Gson gson, @d e.j.e.t.a<T> aVar) {
        if (aVar.getRawType().isEnum()) {
            return b(aVar);
        }
        return null;
    }
}
