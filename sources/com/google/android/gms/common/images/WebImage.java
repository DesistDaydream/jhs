package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.m.a;
import e.j.a.b.c.q.f;
import e.j.a.b.c.r.y;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.a(creator = "WebImageCreator")
/* loaded from: classes2.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new f();
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(getter = "getWidth", id = 3)
    private final int zane;
    @SafeParcelable.c(getter = "getHeight", id = 4)
    private final int zanf;
    @SafeParcelable.c(getter = "getUrl", id = 2)
    private final Uri zang;

    @SafeParcelable.b
    public WebImage(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) Uri uri, @SafeParcelable.e(id = 3) int i3, @SafeParcelable.e(id = 4) int i4) {
        this.zalf = i2;
        this.zang = uri;
        this.zane = i3;
        this.zanf = i4;
    }

    private static Uri zaa(JSONObject jSONObject) {
        if (jSONObject.has("url")) {
            try {
                return Uri.parse(jSONObject.getString("url"));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (y.a(this.zang, webImage.zang) && this.zane == webImage.zane && this.zanf == webImage.zanf) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.zanf;
    }

    public final Uri getUrl() {
        return this.zang;
    }

    public final int getWidth() {
        return this.zane;
    }

    public final int hashCode() {
        return y.b(this.zang, Integer.valueOf(this.zane), Integer.valueOf(this.zanf));
    }

    @a
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.zang.toString());
            jSONObject.put("width", this.zane);
            jSONObject.put("height", this.zanf);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.zane), Integer.valueOf(this.zanf), this.zang.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.zalf);
        e.j.a.b.c.r.i0.a.S(parcel, 2, getUrl(), i2, false);
        e.j.a.b.c.r.i0.a.F(parcel, 3, getWidth());
        e.j.a.b.c.r.i0.a.F(parcel, 4, getHeight());
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    public WebImage(Uri uri, int i2, int i3) throws IllegalArgumentException {
        this(1, uri, i2, i3);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    @a
    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(zaa(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }
}
