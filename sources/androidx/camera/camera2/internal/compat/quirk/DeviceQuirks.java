package androidx.camera.camera2.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;

@RequiresApi(21)
/* loaded from: classes.dex */
public class DeviceQuirks {
    @NonNull
    private static final Quirks QUIRKS = new Quirks(DeviceQuirksLoader.loadQuirks());

    private DeviceQuirks() {
    }

    @Nullable
    public static <T extends Quirk> T get(@NonNull Class<T> cls) {
        return (T) QUIRKS.get(cls);
    }

    @NonNull
    public static Quirks getAll() {
        return QUIRKS;
    }
}
