package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import e.j.b.a.c;

@c
@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class CameraDeviceId {
    @NonNull
    public static CameraDeviceId create(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        return new AutoValue_CameraDeviceId(str.toLowerCase(), str2.toLowerCase(), str3.toLowerCase(), str4.toLowerCase());
    }

    @NonNull
    public abstract String getBrand();

    @NonNull
    public abstract String getCameraId();

    @NonNull
    public abstract String getDevice();

    @NonNull
    public abstract String getModel();
}
