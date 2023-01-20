package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import com.m7.imkfsdk.view.pickerview.utils.LunarCalendar;
import e.j.a.c.m.o;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
    @NonNull
    private final Month end;
    private final int monthSpan;
    @Nullable
    private Month openAt;
    @NonNull
    private final Month start;
    @NonNull
    private final DateValidator validator;
    private final int yearSpan;

    /* loaded from: classes2.dex */
    public interface DateValidator extends Parcelable {
        boolean isValid(long j2);
    }

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public CalendarConstraints[] newArray(int i2) {
            return new CalendarConstraints[i2];
        }
    }

    public /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, a aVar) {
        this(month, month2, dateValidator, month3);
    }

    public Month clamp(Month month) {
        if (month.compareTo(this.start) < 0) {
            return this.start;
        }
        return month.compareTo(this.end) > 0 ? this.end : month;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CalendarConstraints) {
            CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
            return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && ObjectsCompat.equals(this.openAt, calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
        }
        return false;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    @NonNull
    public Month getEnd() {
        return this.end;
    }

    public int getMonthSpan() {
        return this.monthSpan;
    }

    @Nullable
    public Month getOpenAt() {
        return this.openAt;
    }

    @NonNull
    public Month getStart() {
        return this.start;
    }

    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public boolean isWithinBounds(long j2) {
        if (this.start.getDay(1) <= j2) {
            Month month = this.end;
            if (j2 <= month.getDay(month.daysInMonth)) {
                return true;
            }
        }
        return false;
    }

    public void setOpenAt(@Nullable Month month) {
        this.openAt = month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.monthSpan = month.monthsUntil(month2) + 1;
        this.yearSpan = (month2.year - month.year) + 1;
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        public static final long f2860e = o.a(Month.create(LunarCalendar.MIN_YEAR, 0).timeInMillis);

        /* renamed from: f  reason: collision with root package name */
        public static final long f2861f = o.a(Month.create(2100, 11).timeInMillis);

        /* renamed from: g  reason: collision with root package name */
        private static final String f2862g = "DEEP_COPY_VALIDATOR_KEY";
        private long a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private Long f2863c;

        /* renamed from: d  reason: collision with root package name */
        private DateValidator f2864d;

        public b() {
            this.a = f2860e;
            this.b = f2861f;
            this.f2864d = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        @NonNull
        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(f2862g, this.f2864d);
            Month create = Month.create(this.a);
            Month create2 = Month.create(this.b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable(f2862g);
            Long l2 = this.f2863c;
            return new CalendarConstraints(create, create2, dateValidator, l2 == null ? null : Month.create(l2.longValue()), null);
        }

        @NonNull
        public b b(long j2) {
            this.b = j2;
            return this;
        }

        @NonNull
        public b c(long j2) {
            this.f2863c = Long.valueOf(j2);
            return this;
        }

        @NonNull
        public b d(long j2) {
            this.a = j2;
            return this;
        }

        @NonNull
        public b e(@NonNull DateValidator dateValidator) {
            this.f2864d = dateValidator;
            return this;
        }

        public b(@NonNull CalendarConstraints calendarConstraints) {
            this.a = f2860e;
            this.b = f2861f;
            this.f2864d = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.a = calendarConstraints.start.timeInMillis;
            this.b = calendarConstraints.end.timeInMillis;
            this.f2863c = Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.f2864d = calendarConstraints.validator;
        }
    }
}
