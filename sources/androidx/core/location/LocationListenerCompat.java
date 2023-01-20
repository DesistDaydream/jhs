package androidx.core.location;

import android.location.LocationListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public interface LocationListenerCompat extends LocationListener {
    @Override // android.location.LocationListener
    void onProviderDisabled(@NonNull String str);

    @Override // android.location.LocationListener
    void onProviderEnabled(@NonNull String str);

    @Override // android.location.LocationListener
    void onStatusChanged(@NonNull String str, int i2, @Nullable Bundle bundle);
}
