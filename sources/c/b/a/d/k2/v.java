package c.b.a.d.k2;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompatApi28Impl;
import androidx.camera.camera2.internal.compat.CameraManagerCompatApi29Impl;
import androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl;

/* compiled from: CameraManagerCompat.java */
/* loaded from: classes.dex */
public final /* synthetic */ class v {
    @NonNull
    public static CameraManagerCompat.CameraManagerCompatImpl a(@NonNull Context context, @NonNull Handler handler) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return new CameraManagerCompatApi29Impl(context);
        }
        if (i2 >= 28) {
            return CameraManagerCompatApi28Impl.create(context);
        }
        return CameraManagerCompatBaseImpl.create(context, handler);
    }
}
