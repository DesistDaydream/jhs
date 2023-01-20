package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.Identifier;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CameraFilter {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Identifier DEFAULT_ID = Identifier.create(new Object());

    @NonNull
    List<CameraInfo> filter(@NonNull List<CameraInfo> list);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    Identifier getIdentifier();
}
