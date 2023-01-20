package androidx.camera.camera2.internal;

import android.media.CamcorderProfile;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CamcorderProfileHelper {
    CamcorderProfile get(int i2, int i3);

    boolean hasProfile(int i2, int i3);
}
