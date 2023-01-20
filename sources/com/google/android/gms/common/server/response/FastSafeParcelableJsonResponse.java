package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import e.j.a.b.c.m.a;
import e.j.a.b.c.r.d0;

@a
@d0
/* loaded from: classes2.dex */
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass().isInstance(obj)) {
            FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
            for (FastJsonResponse.Field<?, ?> field : getFieldMappings().values()) {
                if (isFieldSet(field)) {
                    if (!fastJsonResponse.isFieldSet(field) || !getFieldValue(field).equals(fastJsonResponse.getFieldValue(field))) {
                        return false;
                    }
                } else if (fastJsonResponse.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @e.j.a.b.c.x.d0
    public Object getValueObject(String str) {
        return null;
    }

    public int hashCode() {
        int i2 = 0;
        for (FastJsonResponse.Field<?, ?> field : getFieldMappings().values()) {
            if (isFieldSet(field)) {
                i2 = (i2 * 31) + getFieldValue(field).hashCode();
            }
        }
        return i2;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @e.j.a.b.c.x.d0
    public boolean isPrimitiveFieldSet(String str) {
        return false;
    }

    @a
    public byte[] toByteArray() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
