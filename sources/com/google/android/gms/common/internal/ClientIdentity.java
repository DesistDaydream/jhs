package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.m.a;
import e.j.a.b.c.r.l0;
import e.j.a.b.c.r.y;

@SafeParcelable.a(creator = "ClientIdentityCreator")
@a
@SafeParcelable.f({1000})
/* loaded from: classes2.dex */
public class ClientIdentity extends AbstractSafeParcelable {
    @a
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new l0();
    @Nullable
    @SafeParcelable.c(defaultValueUnchecked = "null", id = 2)
    private final String packageName;
    @SafeParcelable.c(defaultValueUnchecked = "0", id = 1)
    private final int uid;

    @SafeParcelable.b
    public ClientIdentity(@SafeParcelable.e(id = 1) int i2, @Nullable @SafeParcelable.e(id = 2) String str) {
        this.uid = i2;
        this.packageName = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ClientIdentity)) {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            if (clientIdentity.uid == this.uid && y.a(clientIdentity.packageName, this.packageName)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        int i2 = this.uid;
        String str = this.packageName;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i2);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.uid);
        e.j.a.b.c.r.i0.a.X(parcel, 2, this.packageName, false);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }
}
