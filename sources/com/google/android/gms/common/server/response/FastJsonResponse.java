package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.d0;
import e.j.a.b.c.r.y;
import e.j.a.b.c.u.b.i;
import e.j.a.b.c.x.c;
import e.j.a.b.c.x.r;
import e.j.a.b.c.x.s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@e.j.a.b.c.m.a
@d0
/* loaded from: classes2.dex */
public abstract class FastJsonResponse {

    @SafeParcelable.a(creator = "FieldCreator")
    @e.j.a.b.c.m.a
    @d0
    @e.j.a.b.c.x.d0
    /* loaded from: classes2.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final i CREATOR = new i();
        @SafeParcelable.g(getter = "getVersionCode", id = 1)
        private final int zalf;
        @SafeParcelable.c(getter = "getTypeIn", id = 2)
        public final int zapr;
        @SafeParcelable.c(getter = "isTypeInArray", id = 3)
        public final boolean zaps;
        @SafeParcelable.c(getter = "getTypeOut", id = 4)
        public final int zapt;
        @SafeParcelable.c(getter = "isTypeOutArray", id = 5)
        public final boolean zapu;
        @SafeParcelable.c(getter = "getOutputFieldName", id = 6)
        public final String zapv;
        @SafeParcelable.c(getter = "getSafeParcelableFieldId", id = 7)
        public final int zapw;
        public final Class<? extends FastJsonResponse> zapx;
        @SafeParcelable.c(getter = "getConcreteTypeName", id = 8)
        private final String zapy;
        private zak zapz;
        @SafeParcelable.c(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
        private a<I, O> zaqa;

        @SafeParcelable.b
        public Field(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) int i3, @SafeParcelable.e(id = 3) boolean z, @SafeParcelable.e(id = 4) int i4, @SafeParcelable.e(id = 5) boolean z2, @SafeParcelable.e(id = 6) String str, @SafeParcelable.e(id = 7) int i5, @SafeParcelable.e(id = 8) String str2, @SafeParcelable.e(id = 9) zaa zaaVar) {
            this.zalf = i2;
            this.zapr = i3;
            this.zaps = z;
            this.zapt = i4;
            this.zapu = z2;
            this.zapv = str;
            this.zapw = i5;
            if (str2 == null) {
                this.zapx = null;
                this.zapy = null;
            } else {
                this.zapx = SafeParcelResponse.class;
                this.zapy = str2;
            }
            if (zaaVar == null) {
                this.zaqa = null;
            } else {
                this.zaqa = (a<I, O>) zaaVar.zaci();
            }
        }

        @e.j.a.b.c.m.a
        @e.j.a.b.c.x.d0
        public static Field<byte[], byte[]> forBase64(String str, int i2) {
            return new Field<>(8, false, 8, false, str, i2, null, null);
        }

        @e.j.a.b.c.m.a
        public static Field<Boolean, Boolean> forBoolean(String str, int i2) {
            return new Field<>(6, false, 6, false, str, i2, null, null);
        }

        @e.j.a.b.c.m.a
        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String str, int i2, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i2, cls, null);
        }

        @e.j.a.b.c.m.a
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String str, int i2, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i2, cls, null);
        }

        @e.j.a.b.c.m.a
        public static Field<Double, Double> forDouble(String str, int i2) {
            return new Field<>(4, false, 4, false, str, i2, null, null);
        }

        @e.j.a.b.c.m.a
        public static Field<Float, Float> forFloat(String str, int i2) {
            return new Field<>(3, false, 3, false, str, i2, null, null);
        }

        @e.j.a.b.c.m.a
        @e.j.a.b.c.x.d0
        public static Field<Integer, Integer> forInteger(String str, int i2) {
            return new Field<>(0, false, 0, false, str, i2, null, null);
        }

        @e.j.a.b.c.m.a
        public static Field<Long, Long> forLong(String str, int i2) {
            return new Field<>(2, false, 2, false, str, i2, null, null);
        }

        @e.j.a.b.c.m.a
        public static Field<String, String> forString(String str, int i2) {
            return new Field<>(7, false, 7, false, str, i2, null, null);
        }

        @e.j.a.b.c.m.a
        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String str, int i2) {
            return new Field<>(7, true, 7, true, str, i2, null, null);
        }

        @e.j.a.b.c.m.a
        public static Field withConverter(String str, int i2, a<?, ?> aVar, boolean z) {
            return new Field(aVar.zacj(), z, aVar.zack(), false, str, i2, null, aVar);
        }

        private final String zacm() {
            String str = this.zapy;
            if (str == null) {
                return null;
            }
            return str;
        }

        private final zaa zaco() {
            a<I, O> aVar = this.zaqa;
            if (aVar == null) {
                return null;
            }
            return zaa.zaa(aVar);
        }

        public final O convert(I i2) {
            return this.zaqa.convert(i2);
        }

        public final I convertBack(O o) {
            return this.zaqa.convertBack(o);
        }

        @e.j.a.b.c.m.a
        public int getSafeParcelableFieldId() {
            return this.zapw;
        }

        public String toString() {
            y.a a = y.c(this).a("versionCode", Integer.valueOf(this.zalf)).a("typeIn", Integer.valueOf(this.zapr)).a("typeInArray", Boolean.valueOf(this.zaps)).a("typeOut", Integer.valueOf(this.zapt)).a("typeOutArray", Boolean.valueOf(this.zapu)).a("outputFieldName", this.zapv).a("safeParcelFieldId", Integer.valueOf(this.zapw)).a("concreteTypeName", zacm());
            Class<? extends FastJsonResponse> cls = this.zapx;
            if (cls != null) {
                a.a("concreteType.class", cls.getCanonicalName());
            }
            a<I, O> aVar = this.zaqa;
            if (aVar != null) {
                a.a("converterName", aVar.getClass().getCanonicalName());
            }
            return a.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int a = e.j.a.b.c.r.i0.a.a(parcel);
            e.j.a.b.c.r.i0.a.F(parcel, 1, this.zalf);
            e.j.a.b.c.r.i0.a.F(parcel, 2, this.zapr);
            e.j.a.b.c.r.i0.a.g(parcel, 3, this.zaps);
            e.j.a.b.c.r.i0.a.F(parcel, 4, this.zapt);
            e.j.a.b.c.r.i0.a.g(parcel, 5, this.zapu);
            e.j.a.b.c.r.i0.a.X(parcel, 6, this.zapv, false);
            e.j.a.b.c.r.i0.a.F(parcel, 7, getSafeParcelableFieldId());
            e.j.a.b.c.r.i0.a.X(parcel, 8, zacm(), false);
            e.j.a.b.c.r.i0.a.S(parcel, 9, zaco(), i2, false);
            e.j.a.b.c.r.i0.a.b(parcel, a);
        }

        public final void zaa(zak zakVar) {
            this.zapz = zakVar;
        }

        public final Field<I, O> zacl() {
            return new Field<>(this.zalf, this.zapr, this.zaps, this.zapt, this.zapu, this.zapv, this.zapw, this.zapy, zaco());
        }

        public final boolean zacn() {
            return this.zaqa != null;
        }

        public final FastJsonResponse zacp() throws InstantiationException, IllegalAccessException {
            Class<? extends FastJsonResponse> cls = this.zapx;
            if (cls == SafeParcelResponse.class) {
                a0.l(this.zapz, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
                return new SafeParcelResponse(this.zapz, this.zapy);
            }
            return cls.newInstance();
        }

        public final Map<String, Field<?, ?>> zacq() {
            a0.k(this.zapy);
            a0.k(this.zapz);
            return this.zapz.zai(this.zapy);
        }

        private Field(int i2, boolean z, int i3, boolean z2, String str, int i4, Class<? extends FastJsonResponse> cls, a<I, O> aVar) {
            this.zalf = 1;
            this.zapr = i2;
            this.zaps = z;
            this.zapt = i3;
            this.zapu = z2;
            this.zapv = str;
            this.zapw = i4;
            this.zapx = cls;
            if (cls == null) {
                this.zapy = null;
            } else {
                this.zapy = cls.getCanonicalName();
            }
            this.zaqa = aVar;
        }
    }

    @d0
    /* loaded from: classes2.dex */
    public interface a<I, O> {
        O convert(I i2);

        I convertBack(O o);

        int zacj();

        int zack();
    }

    private final <I, O> void zaa(Field<I, O> field, I i2) {
        String str = field.zapv;
        O convert = field.convert(i2);
        switch (field.zapt) {
            case 0:
                if (zaa(str, convert)) {
                    setIntegerInternal(field, str, ((Integer) convert).intValue());
                    return;
                }
                return;
            case 1:
                zaa((Field<?, ?>) field, str, (BigInteger) convert);
                return;
            case 2:
                if (zaa(str, convert)) {
                    setLongInternal(field, str, ((Long) convert).longValue());
                    return;
                }
                return;
            case 3:
            default:
                int i3 = field.zapt;
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unsupported type for conversion: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            case 4:
                if (zaa(str, convert)) {
                    zaa((Field<?, ?>) field, str, ((Double) convert).doubleValue());
                    return;
                }
                return;
            case 5:
                zaa((Field<?, ?>) field, str, (BigDecimal) convert);
                return;
            case 6:
                if (zaa(str, convert)) {
                    setBooleanInternal(field, str, ((Boolean) convert).booleanValue());
                    return;
                }
                return;
            case 7:
                setStringInternal(field, str, (String) convert);
                return;
            case 8:
            case 9:
                if (zaa(str, convert)) {
                    setDecodedBytesInternal(field, str, (byte[]) convert);
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <O, I> I zab(Field<I, O> field, Object obj) {
        return ((Field) field).zaqa != null ? field.convertBack(obj) : obj;
    }

    @e.j.a.b.c.m.a
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    @e.j.a.b.c.m.a
    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String str, T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    @e.j.a.b.c.m.a
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    @e.j.a.b.c.m.a
    public Object getFieldValue(Field field) {
        String str = field.zapv;
        if (field.zapx != null) {
            a0.s(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", field.zapv);
            boolean z = field.zapu;
            try {
                char upperCase = Character.toUpperCase(str.charAt(0));
                String substring = str.substring(1);
                StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
                sb.append("get");
                sb.append(upperCase);
                sb.append(substring);
                return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return getValueObject(str);
    }

    @e.j.a.b.c.m.a
    public abstract Object getValueObject(String str);

    @e.j.a.b.c.m.a
    public boolean isFieldSet(Field field) {
        if (field.zapt == 11) {
            if (field.zapu) {
                String str = field.zapv;
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            }
            String str2 = field.zapv;
            throw new UnsupportedOperationException("Concrete types not supported");
        }
        return isPrimitiveFieldSet(field.zapv);
    }

    @e.j.a.b.c.m.a
    public abstract boolean isPrimitiveFieldSet(String str);

    @e.j.a.b.c.m.a
    public void setBooleanInternal(Field<?, ?> field, String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    @e.j.a.b.c.m.a
    public void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    @e.j.a.b.c.m.a
    public void setIntegerInternal(Field<?, ?> field, String str, int i2) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    @e.j.a.b.c.m.a
    public void setLongInternal(Field<?, ?> field, String str, long j2) {
        throw new UnsupportedOperationException("Long not supported");
    }

    @e.j.a.b.c.m.a
    public void setStringInternal(Field<?, ?> field, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    @e.j.a.b.c.m.a
    public void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    @e.j.a.b.c.m.a
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object zab = zab(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (zab == null) {
                    sb.append("null");
                } else {
                    switch (field.zapt) {
                        case 8:
                            sb.append("\"");
                            sb.append(c.d((byte[]) zab));
                            sb.append("\"");
                            continue;
                        case 9:
                            sb.append("\"");
                            sb.append(c.e((byte[]) zab));
                            sb.append("\"");
                            continue;
                        case 10:
                            s.a(sb, (HashMap) zab);
                            continue;
                        default:
                            if (field.zaps) {
                                ArrayList arrayList = (ArrayList) zab;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    if (i2 > 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    Object obj = arrayList.get(i2);
                                    if (obj != null) {
                                        zaa(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            } else {
                                zaa(sb, field, zab);
                                continue;
                            }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public final <O> void zac(Field<ArrayList<Long>, O> field, ArrayList<Long> arrayList) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<ArrayList<Long>, O>, O>) field, (Field<ArrayList<Long>, O>) arrayList);
        } else {
            zac(field, field.zapv, arrayList);
        }
    }

    public final <O> void zad(Field<ArrayList<Float>, O> field, ArrayList<Float> arrayList) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<ArrayList<Float>, O>, O>) field, (Field<ArrayList<Float>, O>) arrayList);
        } else {
            zad(field, field.zapv, arrayList);
        }
    }

    public final <O> void zae(Field<ArrayList<Double>, O> field, ArrayList<Double> arrayList) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<ArrayList<Double>, O>, O>) field, (Field<ArrayList<Double>, O>) arrayList);
        } else {
            zae(field, field.zapv, arrayList);
        }
    }

    public final <O> void zaf(Field<ArrayList<BigDecimal>, O> field, ArrayList<BigDecimal> arrayList) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<ArrayList<BigDecimal>, O>, O>) field, (Field<ArrayList<BigDecimal>, O>) arrayList);
        } else {
            zaf(field, field.zapv, arrayList);
        }
    }

    public final <O> void zag(Field<ArrayList<Boolean>, O> field, ArrayList<Boolean> arrayList) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<ArrayList<Boolean>, O>, O>) field, (Field<ArrayList<Boolean>, O>) arrayList);
        } else {
            zag(field, field.zapv, arrayList);
        }
    }

    public final <O> void zah(Field<ArrayList<String>, O> field, ArrayList<String> arrayList) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<ArrayList<String>, O>, O>) field, (Field<ArrayList<String>, O>) arrayList);
        } else {
            setStringsInternal(field, field.zapv, arrayList);
        }
    }

    public final <O> void zab(Field<ArrayList<BigInteger>, O> field, ArrayList<BigInteger> arrayList) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<ArrayList<BigInteger>, O>, O>) field, (Field<ArrayList<BigInteger>, O>) arrayList);
        } else {
            zab(field, field.zapv, arrayList);
        }
    }

    public void zac(Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    public void zad(Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public void zae(Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public void zaf(Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public void zag(Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public void zab(Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final <O> void zaa(Field<Integer, O> field, int i2) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<Integer, O>, O>) field, (Field<Integer, O>) Integer.valueOf(i2));
        } else {
            setIntegerInternal(field, field.zapv, i2);
        }
    }

    public final <O> void zaa(Field<ArrayList<Integer>, O> field, ArrayList<Integer> arrayList) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<ArrayList<Integer>, O>, O>) field, (Field<ArrayList<Integer>, O>) arrayList);
        } else {
            zaa(field, field.zapv, arrayList);
        }
    }

    public final <O> void zaa(Field<BigInteger, O> field, BigInteger bigInteger) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<BigInteger, O>, O>) field, (Field<BigInteger, O>) bigInteger);
        } else {
            zaa(field, field.zapv, bigInteger);
        }
    }

    public final <O> void zaa(Field<Long, O> field, long j2) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<Long, O>, O>) field, (Field<Long, O>) Long.valueOf(j2));
        } else {
            setLongInternal(field, field.zapv, j2);
        }
    }

    public final <O> void zaa(Field<Float, O> field, float f2) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<Float, O>, O>) field, (Field<Float, O>) Float.valueOf(f2));
        } else {
            zaa((Field<?, ?>) field, field.zapv, f2);
        }
    }

    public final <O> void zaa(Field<Double, O> field, double d2) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<Double, O>, O>) field, (Field<Double, O>) Double.valueOf(d2));
        } else {
            zaa(field, field.zapv, d2);
        }
    }

    public final <O> void zaa(Field<BigDecimal, O> field, BigDecimal bigDecimal) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<BigDecimal, O>, O>) field, (Field<BigDecimal, O>) bigDecimal);
        } else {
            zaa(field, field.zapv, bigDecimal);
        }
    }

    public final <O> void zaa(Field<Boolean, O> field, boolean z) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<Boolean, O>, O>) field, (Field<Boolean, O>) Boolean.valueOf(z));
        } else {
            setBooleanInternal(field, field.zapv, z);
        }
    }

    public final <O> void zaa(Field<String, O> field, String str) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<String, O>, O>) field, (Field<String, O>) str);
        } else {
            setStringInternal(field, field.zapv, str);
        }
    }

    public final <O> void zaa(Field<byte[], O> field, byte[] bArr) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<byte[], O>, O>) field, (Field<byte[], O>) bArr);
        } else {
            setDecodedBytesInternal(field, field.zapv, bArr);
        }
    }

    public final <O> void zaa(Field<Map<String, String>, O> field, Map<String, String> map) {
        if (((Field) field).zaqa != null) {
            zaa((Field<Field<Map<String, String>, O>, O>) field, (Field<Map<String, String>, O>) map);
        } else {
            zaa(field, field.zapv, map);
        }
    }

    public void zaa(Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public void zaa(Field<?, ?> field, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public void zaa(Field<?, ?> field, String str, float f2) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public void zaa(Field<?, ?> field, String str, double d2) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public void zaa(Field<?, ?> field, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public void zaa(Field<?, ?> field, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    private static <O> boolean zaa(String str, O o) {
        if (o == null) {
            if (Log.isLoggable("FastJsonResponse", 6)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 58);
                sb.append("Output field (");
                sb.append(str);
                sb.append(") has a null value, but expected a primitive");
                Log.e("FastJsonResponse", sb.toString());
                return false;
            }
            return false;
        }
        return true;
    }

    private static void zaa(StringBuilder sb, Field field, Object obj) {
        int i2 = field.zapr;
        if (i2 == 11) {
            sb.append(field.zapx.cast(obj).toString());
        } else if (i2 == 7) {
            sb.append("\"");
            sb.append(r.b((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }
}
