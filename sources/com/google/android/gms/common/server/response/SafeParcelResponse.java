package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.m.a;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.u.b.m;
import e.j.a.b.c.x.b;
import e.j.a.b.c.x.c;
import e.j.a.b.c.x.d0;
import e.j.a.b.c.x.r;
import e.j.a.b.c.x.s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SafeParcelable.a(creator = "SafeParcelResponseCreator")
@a
@d0
/* loaded from: classes2.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    @a
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new m();
    private final String mClassName;
    @SafeParcelable.g(getter = "getVersionCode", id = 1)
    private final int zalf;
    @SafeParcelable.c(getter = "getFieldMappingDictionary", id = 3)
    private final zak zapz;
    @SafeParcelable.c(getter = "getParcel", id = 2)
    private final Parcel zarb;
    private final int zarc;
    private int zard;
    private int zare;

    public SafeParcelResponse(zak zakVar, String str) {
        this.zalf = 1;
        this.zarb = Parcel.obtain();
        this.zarc = 0;
        this.zapz = (zak) a0.k(zakVar);
        this.mClassName = (String) a0.k(str);
        this.zard = 0;
    }

    @a
    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        zak zakVar = new zak(t.getClass());
        zaa(zakVar, t);
        zakVar.zacs();
        zakVar.zacr();
        return new SafeParcelResponse(t, zakVar, canonicalName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void zaa(zak zakVar, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (zakVar.zaa(cls)) {
            return;
        }
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        zakVar.zaa(cls, fieldMappings);
        for (String str : fieldMappings.keySet()) {
            FastJsonResponse.Field<?, ?> field = fieldMappings.get(str);
            Class<? extends FastJsonResponse> cls2 = field.zapx;
            if (cls2 != null) {
                try {
                    zaa(zakVar, cls2.newInstance());
                } catch (IllegalAccessException e2) {
                    String valueOf = String.valueOf(field.zapx.getCanonicalName());
                    throw new IllegalStateException(valueOf.length() != 0 ? "Could not access object of type ".concat(valueOf) : new String("Could not access object of type "), e2);
                } catch (InstantiationException e3) {
                    String valueOf2 = String.valueOf(field.zapx.getCanonicalName());
                    throw new IllegalStateException(valueOf2.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf2) : new String("Could not instantiate an object of type "), e3);
                }
            }
        }
    }

    private final void zab(FastJsonResponse.Field<?, ?> field) {
        if (field.zapw != -1) {
            Parcel parcel = this.zarb;
            if (parcel != null) {
                int i2 = this.zard;
                if (i2 == 0) {
                    this.zare = e.j.a.b.c.r.i0.a.a(parcel);
                    this.zard = 1;
                    return;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
                    }
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                } else {
                    return;
                }
            }
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        if (r0 != 1) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.os.Parcel zacu() {
        /*
            r2 = this;
            int r0 = r2.zard
            if (r0 == 0) goto L8
            r1 = 1
            if (r0 == r1) goto L10
            goto L1a
        L8:
            android.os.Parcel r0 = r2.zarb
            int r0 = e.j.a.b.c.r.i0.a.a(r0)
            r2.zare = r0
        L10:
            android.os.Parcel r0 = r2.zarb
            int r1 = r2.zare
            e.j.a.b.c.r.i0.a.b(r0, r1)
            r0 = 2
            r2.zard = r0
        L1a:
            android.os.Parcel r0 = r2.zarb
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.zacu():android.os.Parcel");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        zab(field);
        ArrayList arrayList2 = new ArrayList();
        arrayList.size();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            T t = arrayList.get(i2);
            i2++;
            arrayList2.add(((SafeParcelResponse) t).zacu());
        }
        e.j.a.b.c.r.i0.a.Q(this.zarb, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        zab(field);
        e.j.a.b.c.r.i0.a.O(this.zarb, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t).zacu(), true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zak zakVar = this.zapz;
        if (zakVar == null) {
            return null;
        }
        return zakVar.zai(this.mClassName);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        zab(field);
        e.j.a.b.c.r.i0.a.g(this.zarb, field.getSafeParcelableFieldId(), z);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        zab(field);
        e.j.a.b.c.r.i0.a.m(this.zarb, field.getSafeParcelableFieldId(), bArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i2) {
        zab(field);
        e.j.a.b.c.r.i0.a.F(this.zarb, field.getSafeParcelableFieldId(), i2);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j2) {
        zab(field);
        e.j.a.b.c.r.i0.a.K(this.zarb, field.getSafeParcelableFieldId(), j2);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        zab(field);
        e.j.a.b.c.r.i0.a.X(this.zarb, field.getSafeParcelableFieldId(), str2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        zab(field);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = arrayList.get(i2);
        }
        e.j.a.b.c.r.i0.a.Y(this.zarb, field.getSafeParcelableFieldId(), strArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        a0.l(this.zapz, "Cannot convert to JSON on client side.");
        Parcel zacu = zacu();
        zacu.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zaa(sb, this.zapz.zai(this.mClassName), zacu);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        zak zakVar;
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.zalf);
        e.j.a.b.c.r.i0.a.O(parcel, 2, zacu(), false);
        int i3 = this.zarc;
        if (i3 == 0) {
            zakVar = null;
        } else if (i3 == 1) {
            zakVar = this.zapz;
        } else if (i3 == 2) {
            zakVar = this.zapz;
        } else {
            int i4 = this.zarc;
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid creation type: ");
            sb.append(i4);
            throw new IllegalStateException(sb.toString());
        }
        e.j.a.b.c.r.i0.a.S(parcel, 3, zakVar, i2, false);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zac(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        zab(field);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = arrayList.get(i2).longValue();
        }
        e.j.a.b.c.r.i0.a.L(this.zarb, field.getSafeParcelableFieldId(), jArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zad(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        zab(field);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            fArr[i2] = arrayList.get(i2).floatValue();
        }
        e.j.a.b.c.r.i0.a.x(this.zarb, field.getSafeParcelableFieldId(), fArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zae(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        zab(field);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = arrayList.get(i2).doubleValue();
        }
        e.j.a.b.c.r.i0.a.s(this.zarb, field.getSafeParcelableFieldId(), dArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaf(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        zab(field);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i2 = 0; i2 < size; i2++) {
            bigDecimalArr[i2] = arrayList.get(i2);
        }
        e.j.a.b.c.r.i0.a.d(this.zarb, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zag(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        zab(field);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i2 = 0; i2 < size; i2++) {
            zArr[i2] = arrayList.get(i2).booleanValue();
        }
        e.j.a.b.c.r.i0.a.h(this.zarb, field.getSafeParcelableFieldId(), zArr, true);
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zak zakVar, String str) {
        this.zalf = 1;
        Parcel obtain = Parcel.obtain();
        this.zarb = obtain;
        safeParcelable.writeToParcel(obtain, 0);
        this.zarc = 1;
        this.zapz = (zak) a0.k(zakVar);
        this.mClassName = (String) a0.k(str);
        this.zard = 2;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zab(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        zab(field);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i2 = 0; i2 < size; i2++) {
            bigIntegerArr[i2] = arrayList.get(i2);
        }
        e.j.a.b.c.r.i0.a.f(this.zarb, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    @SafeParcelable.b
    public SafeParcelResponse(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) Parcel parcel, @SafeParcelable.e(id = 3) zak zakVar) {
        this.zalf = i2;
        this.zarb = (Parcel) a0.k(parcel);
        this.zarc = 2;
        this.zapz = zakVar;
        if (zakVar == null) {
            this.mClassName = null;
        } else {
            this.mClassName = zakVar.zact();
        }
        this.zard = 2;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        zab(field);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = arrayList.get(i2).intValue();
        }
        e.j.a.b.c.r.i0.a.G(this.zarb, field.getSafeParcelableFieldId(), iArr, true);
    }

    private final void zab(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zaps) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                zaa(sb, field.zapr, arrayList.get(i2));
            }
            sb.append("]");
            return;
        }
        zaa(sb, field.zapr, obj);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, BigInteger bigInteger) {
        zab(field);
        e.j.a.b.c.r.i0.a.e(this.zarb, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, float f2) {
        zab(field);
        e.j.a.b.c.r.i0.a.w(this.zarb, field.getSafeParcelableFieldId(), f2);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, double d2) {
        zab(field);
        e.j.a.b.c.r.i0.a.r(this.zarb, field.getSafeParcelableFieldId(), d2);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, BigDecimal bigDecimal) {
        zab(field);
        e.j.a.b.c.r.i0.a.c(this.zarb, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        zab(field);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        e.j.a.b.c.r.i0.a.k(this.zarb, field.getSafeParcelableFieldId(), bundle, true);
    }

    private final void zaa(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().getSafeParcelableFieldId(), entry);
        }
        sb.append('{');
        int h0 = SafeParcelReader.h0(parcel);
        boolean z = false;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.O(X));
            if (entry2 != null) {
                if (z) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append((String) entry2.getKey());
                sb.append("\":");
                if (field.zacn()) {
                    switch (field.zapt) {
                        case 0:
                            zab(sb, field, FastJsonResponse.zab(field, Integer.valueOf(SafeParcelReader.Z(parcel, X))));
                            break;
                        case 1:
                            zab(sb, field, FastJsonResponse.zab(field, SafeParcelReader.c(parcel, X)));
                            break;
                        case 2:
                            zab(sb, field, FastJsonResponse.zab(field, Long.valueOf(SafeParcelReader.c0(parcel, X))));
                            break;
                        case 3:
                            zab(sb, field, FastJsonResponse.zab(field, Float.valueOf(SafeParcelReader.V(parcel, X))));
                            break;
                        case 4:
                            zab(sb, field, FastJsonResponse.zab(field, Double.valueOf(SafeParcelReader.T(parcel, X))));
                            break;
                        case 5:
                            zab(sb, field, FastJsonResponse.zab(field, SafeParcelReader.a(parcel, X)));
                            break;
                        case 6:
                            zab(sb, field, FastJsonResponse.zab(field, Boolean.valueOf(SafeParcelReader.P(parcel, X))));
                            break;
                        case 7:
                            zab(sb, field, FastJsonResponse.zab(field, SafeParcelReader.G(parcel, X)));
                            break;
                        case 8:
                        case 9:
                            zab(sb, field, FastJsonResponse.zab(field, SafeParcelReader.h(parcel, X)));
                            break;
                        case 10:
                            Bundle g2 = SafeParcelReader.g(parcel, X);
                            HashMap hashMap = new HashMap();
                            for (String str : g2.keySet()) {
                                hashMap.put(str, g2.getString(str));
                            }
                            zab(sb, field, FastJsonResponse.zab(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int i2 = field.zapt;
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i2);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.zapu) {
                    sb.append("[");
                    switch (field.zapt) {
                        case 0:
                            b.m(sb, SafeParcelReader.u(parcel, X));
                            break;
                        case 1:
                            b.o(sb, SafeParcelReader.d(parcel, X));
                            break;
                        case 2:
                            b.n(sb, SafeParcelReader.w(parcel, X));
                            break;
                        case 3:
                            b.l(sb, SafeParcelReader.o(parcel, X));
                            break;
                        case 4:
                            b.k(sb, SafeParcelReader.l(parcel, X));
                            break;
                        case 5:
                            b.o(sb, SafeParcelReader.b(parcel, X));
                            break;
                        case 6:
                            b.p(sb, SafeParcelReader.e(parcel, X));
                            break;
                        case 7:
                            b.q(sb, SafeParcelReader.H(parcel, X));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] z2 = SafeParcelReader.z(parcel, X);
                            int length = z2.length;
                            for (int i3 = 0; i3 < length; i3++) {
                                if (i3 > 0) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                z2[i3].setDataPosition(0);
                                zaa(sb, field.zacq(), z2[i3]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.zapt) {
                        case 0:
                            sb.append(SafeParcelReader.Z(parcel, X));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.c(parcel, X));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.c0(parcel, X));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.V(parcel, X));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.T(parcel, X));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.a(parcel, X));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.P(parcel, X));
                            break;
                        case 7:
                            String G = SafeParcelReader.G(parcel, X);
                            sb.append("\"");
                            sb.append(r.b(G));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] h2 = SafeParcelReader.h(parcel, X);
                            sb.append("\"");
                            sb.append(c.d(h2));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] h3 = SafeParcelReader.h(parcel, X);
                            sb.append("\"");
                            sb.append(c.e(h3));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle g3 = SafeParcelReader.g(parcel, X);
                            Set<String> keySet = g3.keySet();
                            keySet.size();
                            sb.append("{");
                            boolean z3 = true;
                            for (String str2 : keySet) {
                                if (!z3) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                sb.append("\"");
                                sb.append(str2);
                                sb.append("\"");
                                sb.append(Constants.COLON_SEPARATOR);
                                sb.append("\"");
                                sb.append(r.b(g3.getString(str2)));
                                sb.append("\"");
                                z3 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel y = SafeParcelReader.y(parcel, X);
                            y.setDataPosition(0);
                            zaa(sb, field.zacq(), y);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == h0) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(h0);
        throw new SafeParcelReader.ParseException(sb3.toString(), parcel);
    }

    private static void zaa(StringBuilder sb, int i2, Object obj) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(r.b(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(c.d((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(c.e((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                s.a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
        }
    }
}
