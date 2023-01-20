package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import e.j.a.b.c.r.d0;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.c.u.b.l;
import java.util.ArrayList;
import java.util.Map;

@SafeParcelable.a(creator = "FieldMappingDictionaryEntryCreator")
@d0
/* loaded from: classes2.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new l();
    @SafeParcelable.c(id = 2)
    public final String className;
    @SafeParcelable.g(id = 1)
    private final int versionCode;
    @SafeParcelable.c(id = 3)
    public final ArrayList<zam> zaqy;

    @SafeParcelable.b
    public zal(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) String str, @SafeParcelable.e(id = 3) ArrayList<zam> arrayList) {
        this.versionCode = i2;
        this.className = str;
        this.zaqy = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.versionCode);
        a.X(parcel, 2, this.className, false);
        a.c0(parcel, 3, this.zaqy, false);
        a.b(parcel, a);
    }

    public zal(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.versionCode = 1;
        this.className = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, map.get(str2)));
            }
        }
        this.zaqy = arrayList;
    }
}
