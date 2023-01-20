package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import e.j.a.b.c.u.a.a;

@SafeParcelable.a(creator = "ConverterWrapperCreator")
/* loaded from: classes2.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a();
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(getter = "getStringToIntConverter", id = 2)
    private final StringToIntConverter zapl;

    @SafeParcelable.b
    public zaa(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) StringToIntConverter stringToIntConverter) {
        this.zalf = i2;
        this.zapl = stringToIntConverter;
    }

    public static zaa zaa(FastJsonResponse.a<?, ?> aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.zalf);
        e.j.a.b.c.r.i0.a.S(parcel, 2, this.zapl, i2, false);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    public final FastJsonResponse.a<?, ?> zaci() {
        StringToIntConverter stringToIntConverter = this.zapl;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.zalf = 1;
        this.zapl = stringToIntConverter;
    }
}
