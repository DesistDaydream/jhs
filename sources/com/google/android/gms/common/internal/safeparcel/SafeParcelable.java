package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface SafeParcelable extends Parcelable {
    public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";

    /* loaded from: classes2.dex */
    public @interface a {
        String creator();

        boolean validate() default false;
    }

    /* loaded from: classes2.dex */
    public @interface b {
    }

    /* loaded from: classes2.dex */
    public @interface c {
        String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";

        String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";

        String getter() default "SAFE_PARCELABLE_NULL_STRING";

        int id();

        String type() default "SAFE_PARCELABLE_NULL_STRING";
    }

    /* loaded from: classes2.dex */
    public @interface d {
        String getter() default "SAFE_PARCELABLE_NULL_STRING";
    }

    /* loaded from: classes2.dex */
    public @interface e {
        int id();
    }

    /* loaded from: classes2.dex */
    public @interface f {
        int[] value();
    }

    /* loaded from: classes2.dex */
    public @interface g {
        String getter() default "SAFE_PARCELABLE_NULL_STRING";

        int id();

        String type() default "SAFE_PARCELABLE_NULL_STRING";
    }
}
