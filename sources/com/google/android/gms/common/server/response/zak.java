package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.d0;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.c.u.b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SafeParcelable.a(creator = "FieldMappingDictionaryCreator")
@d0
/* loaded from: classes2.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new k();
    @SafeParcelable.g(id = 1)
    private final int zalf;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zaqv;
    @SafeParcelable.c(getter = "getSerializedDictionary", id = 2)
    private final ArrayList<zal> zaqw;
    @SafeParcelable.c(getter = "getRootClassName", id = 3)
    private final String zaqx;

    @SafeParcelable.b
    public zak(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) ArrayList<zal> arrayList, @SafeParcelable.e(id = 3) String str) {
        this.zalf = i2;
        this.zaqw = null;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zal zalVar = arrayList.get(i3);
            String str2 = zalVar.className;
            HashMap hashMap2 = new HashMap();
            int size2 = zalVar.zaqy.size();
            for (int i4 = 0; i4 < size2; i4++) {
                zam zamVar = zalVar.zaqy.get(i4);
                hashMap2.put(zamVar.zaqz, zamVar.zara);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zaqv = hashMap;
        this.zaqx = (String) a0.k(str);
        zacr();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.zaqv.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zaqv.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.zalf);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zaqv.keySet()) {
            arrayList.add(new zal(str, this.zaqv.get(str)));
        }
        a.c0(parcel, 2, arrayList, false);
        a.X(parcel, 3, this.zaqx, false);
        a.b(parcel, a);
    }

    public final void zaa(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.zaqv.put(cls.getCanonicalName(), map);
    }

    public final void zacr() {
        for (String str : this.zaqv.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zaqv.get(str);
            for (String str2 : map.keySet()) {
                map.get(str2).zaa(this);
            }
        }
    }

    public final void zacs() {
        for (String str : this.zaqv.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zaqv.get(str);
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap.put(str2, map.get(str2).zacl());
            }
            this.zaqv.put(str, hashMap);
        }
    }

    public final String zact() {
        return this.zaqx;
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> zai(String str) {
        return this.zaqv.get(str);
    }

    public final boolean zaa(Class<? extends FastJsonResponse> cls) {
        return this.zaqv.containsKey(cls.getCanonicalName());
    }

    public zak(Class<? extends FastJsonResponse> cls) {
        this.zalf = 1;
        this.zaqw = null;
        this.zaqv = new HashMap<>();
        this.zaqx = cls.getCanonicalName();
    }
}
