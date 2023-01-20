package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    public GnssStatusWrapper(GnssStatus gnssStatus) {
        this.mWrapped = (GnssStatus) Preconditions.checkNotNull(gnssStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GnssStatusWrapper) {
            return this.mWrapped.equals(((GnssStatusWrapper) obj).mWrapped);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i2) {
        return this.mWrapped.getAzimuthDegrees(i2);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return this.mWrapped.getBasebandCn0DbHz(i2);
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mWrapped.getCarrierFrequencyHz(i2);
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i2) {
        return this.mWrapped.getCn0DbHz(i2);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i2) {
        return this.mWrapped.getConstellationType(i2);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i2) {
        return this.mWrapped.getElevationDegrees(i2);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i2) {
        return this.mWrapped.getSvid(i2);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i2) {
        return this.mWrapped.hasAlmanacData(i2);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return this.mWrapped.hasBasebandCn0DbHz(i2);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mWrapped.hasCarrierFrequencyHz(i2);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i2) {
        return this.mWrapped.hasEphemerisData(i2);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i2) {
        return this.mWrapped.usedInFix(i2);
    }
}
