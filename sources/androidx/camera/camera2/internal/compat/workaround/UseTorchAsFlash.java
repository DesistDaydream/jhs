package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.UseTorchAsFlashQuirk;
import androidx.camera.core.impl.Quirks;

@RequiresApi(21)
/* loaded from: classes.dex */
public class UseTorchAsFlash {
    private final boolean mHasUseTorchAsFlashQuirk;

    public UseTorchAsFlash(@NonNull Quirks quirks) {
        this.mHasUseTorchAsFlashQuirk = quirks.contains(UseTorchAsFlashQuirk.class);
    }

    public boolean shouldUseTorchAsFlash() {
        return this.mHasUseTorchAsFlashQuirk;
    }
}
