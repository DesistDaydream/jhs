package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableFloat extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new Parcelable.Creator<ObservableFloat>() { // from class: androidx.databinding.ObservableFloat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ObservableFloat createFromParcel(Parcel parcel) {
            return new ObservableFloat(parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ObservableFloat[] newArray(int i2) {
            return new ObservableFloat[i2];
        }
    };
    public static final long serialVersionUID = 1;
    private float mValue;

    public ObservableFloat(float f2) {
        this.mValue = f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float get() {
        return this.mValue;
    }

    public void set(float f2) {
        if (f2 != this.mValue) {
            this.mValue = f2;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.mValue);
    }

    public ObservableFloat() {
    }

    public ObservableFloat(Observable... observableArr) {
        super(observableArr);
    }
}
