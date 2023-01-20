package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import e.j.a.c.m.o;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new a();
    private final long point;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<DateValidatorPointBackward> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public DateValidatorPointBackward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public DateValidatorPointBackward[] newArray(int i2) {
            return new DateValidatorPointBackward[i2];
        }
    }

    public /* synthetic */ DateValidatorPointBackward(long j2, a aVar) {
        this(j2);
    }

    @NonNull
    public static DateValidatorPointBackward before(long j2) {
        return new DateValidatorPointBackward(j2);
    }

    @NonNull
    public static DateValidatorPointBackward now() {
        return before(o.t().getTimeInMillis());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointBackward) && this.point == ((DateValidatorPointBackward) obj).point;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j2) {
        return j2 <= this.point;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeLong(this.point);
    }

    private DateValidatorPointBackward(long j2) {
        this.point = j2;
    }
}
