package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import e.l.m.b;
import h.k2.v.u;
import i.c.c;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class ReasonResult implements Parcelable {
    @d
    public static final Parcelable.Creator<ReasonResult> CREATOR = new Creator();
    @e.j.e.r.c("correction_reason")
    @e
    private final List<String> correctionReason;
    @e.j.e.r.c(b.f14090i)
    @e
    private final List<String> reportReason;
    @e.j.e.r.c("report_seller_reason")
    @e
    private final List<String> reportSellerReason;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ReasonResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReasonResult createFromParcel(@d Parcel parcel) {
            return new ReasonResult(parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReasonResult[] newArray(int i2) {
            return new ReasonResult[i2];
        }
    }

    public ReasonResult() {
        this(null, null, null, 7, null);
    }

    public ReasonResult(@e List<String> list, @e List<String> list2, @e List<String> list3) {
        this.reportReason = list;
        this.correctionReason = list2;
        this.reportSellerReason = list3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final List<String> getCorrectionReason() {
        return this.correctionReason;
    }

    @e
    public final List<String> getReportReason() {
        return this.reportReason;
    }

    @e
    public final List<String> getReportSellerReason() {
        return this.reportSellerReason;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeStringList(this.reportReason);
        parcel.writeStringList(this.correctionReason);
        parcel.writeStringList(this.reportSellerReason);
    }

    public /* synthetic */ ReasonResult(List list, List list2, List list3, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : list2, (i2 & 4) != 0 ? null : list3);
    }
}
