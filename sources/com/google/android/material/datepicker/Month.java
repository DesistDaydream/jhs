package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.j.a.c.m.d;
import e.j.a.c.m.o;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes2.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();
    public final int daysInMonth;
    public final int daysInWeek;
    @NonNull
    private final Calendar firstOfMonth;
    @Nullable
    private String longName;
    public final int month;
    public final long timeInMillis;
    public final int year;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.create(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public Month[] newArray(int i2) {
            return new Month[i2];
        }
    }

    private Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar f2 = o.f(calendar);
        this.firstOfMonth = f2;
        this.month = f2.get(2);
        this.year = f2.get(1);
        this.daysInWeek = f2.getMaximum(7);
        this.daysInMonth = f2.getActualMaximum(5);
        this.timeInMillis = f2.getTimeInMillis();
    }

    @NonNull
    public static Month create(long j2) {
        Calendar v = o.v();
        v.setTimeInMillis(j2);
        return new Month(v);
    }

    @NonNull
    public static Month current() {
        return new Month(o.t());
    }

    public int daysFromStartOfWeekToFirstOfMonth() {
        int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.daysInWeek : firstDayOfWeek;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Month) {
            Month month = (Month) obj;
            return this.month == month.month && this.year == month.year;
        }
        return false;
    }

    public long getDay(int i2) {
        Calendar f2 = o.f(this.firstOfMonth);
        f2.set(5, i2);
        return f2.getTimeInMillis();
    }

    public int getDayOfMonth(long j2) {
        Calendar f2 = o.f(this.firstOfMonth);
        f2.setTimeInMillis(j2);
        return f2.get(5);
    }

    @NonNull
    public String getLongName(Context context) {
        if (this.longName == null) {
            this.longName = d.i(context, this.firstOfMonth.getTimeInMillis());
        }
        return this.longName;
    }

    public long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    @NonNull
    public Month monthsLater(int i2) {
        Calendar f2 = o.f(this.firstOfMonth);
        f2.add(2, i2);
        return new Month(f2);
    }

    public int monthsUntil(@NonNull Month month) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return ((month.year - this.year) * 12) + (month.month - this.month);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    @NonNull
    public static Month create(int i2, int i3) {
        Calendar v = o.v();
        v.set(1, i2);
        v.set(2, i3);
        return new Month(v);
    }
}
