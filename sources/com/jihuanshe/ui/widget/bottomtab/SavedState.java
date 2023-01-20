package com.jihuanshe.ui.widget.bottomtab;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class SavedState extends View.BaseSavedState {
    @d
    public static final a CREATOR = new a(null);
    private int current;

    /* loaded from: classes2.dex */
    public static final class a implements Parcelable.Creator<SavedState> {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @e
        /* renamed from: a */
        public SavedState createFromParcel(@d Parcel parcel) {
            return new SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @d
        /* renamed from: b */
        public SavedState[] newArray(int i2) {
            return new SavedState[i2];
        }
    }

    public SavedState(@e Parcel parcel) {
        super(parcel);
        this.current = parcel == null ? 0 : parcel.readInt();
    }

    public final int getCurrent() {
        return this.current;
    }

    public final void setCurrent(int i2) {
        this.current = i2;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@e Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.current);
    }

    public SavedState(@e Parcelable parcelable) {
        super(parcelable);
    }
}
