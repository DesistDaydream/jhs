package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import e.j.a.b.c.m.a;
import e.j.a.b.c.u.a.b;
import e.j.a.b.c.u.a.c;
import java.util.ArrayList;
import java.util.HashMap;

@SafeParcelable.a(creator = "StringToIntConverterCreator")
@a
/* loaded from: classes2.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();
    @SafeParcelable.g(id = 1)
    private final int zalf;
    private final HashMap<String, Integer> zapm;
    private final SparseArray<String> zapn;
    @SafeParcelable.c(getter = "getSerializedMap", id = 2)
    private final ArrayList<zaa> zapo;

    @SafeParcelable.b
    public StringToIntConverter(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) ArrayList<zaa> arrayList) {
        this.zalf = i2;
        this.zapm = new HashMap<>();
        this.zapn = new SparseArray<>();
        this.zapo = null;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            zaa zaaVar = arrayList.get(i3);
            i3++;
            zaa zaaVar2 = zaaVar;
            add(zaaVar2.zapp, zaaVar2.zapq);
        }
    }

    @a
    public final StringToIntConverter add(String str, int i2) {
        this.zapm.put(str, Integer.valueOf(i2));
        this.zapn.put(i2, str);
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    public final /* synthetic */ Integer convert(String str) {
        Integer num = this.zapm.get(str);
        return num == null ? this.zapm.get("gms_unknown") : num;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    public final /* synthetic */ String convertBack(Integer num) {
        String str = this.zapn.get(num.intValue());
        return (str == null && this.zapm.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.zalf);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zapm.keySet()) {
            arrayList.add(new zaa(str, this.zapm.get(str).intValue()));
        }
        e.j.a.b.c.r.i0.a.c0(parcel, 2, arrayList, false);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    public final int zacj() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    public final int zack() {
        return 0;
    }

    @SafeParcelable.a(creator = "StringToIntConverterEntryCreator")
    /* loaded from: classes2.dex */
    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new c();
        @SafeParcelable.g(id = 1)
        private final int versionCode;
        @SafeParcelable.c(id = 2)
        public final String zapp;
        @SafeParcelable.c(id = 3)
        public final int zapq;

        @SafeParcelable.b
        public zaa(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) String str, @SafeParcelable.e(id = 3) int i3) {
            this.versionCode = i2;
            this.zapp = str;
            this.zapq = i3;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int a = e.j.a.b.c.r.i0.a.a(parcel);
            e.j.a.b.c.r.i0.a.F(parcel, 1, this.versionCode);
            e.j.a.b.c.r.i0.a.X(parcel, 2, this.zapp, false);
            e.j.a.b.c.r.i0.a.F(parcel, 3, this.zapq);
            e.j.a.b.c.r.i0.a.b(parcel, a);
        }

        public zaa(String str, int i2) {
            this.versionCode = 1;
            this.zapp = str;
            this.zapq = i2;
        }
    }

    @a
    public StringToIntConverter() {
        this.zalf = 1;
        this.zapm = new HashMap<>();
        this.zapn = new SparseArray<>();
        this.zapo = null;
    }
}
