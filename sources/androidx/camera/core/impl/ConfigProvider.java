package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface ConfigProvider<C extends Config> {
    @NonNull
    C getConfig();
}
