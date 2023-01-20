package c.b.b.c2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.internal.IoConfig;
import java.util.concurrent.Executor;

/* compiled from: IoConfig.java */
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    @Nullable
    public static Executor $default$getIoExecutor(@Nullable IoConfig _this, Executor executor) {
        return (Executor) _this.retrieveOption(IoConfig.OPTION_IO_EXECUTOR, executor);
    }

    @NonNull
    public static Executor $default$getIoExecutor(IoConfig _this) {
        return (Executor) _this.retrieveOption(IoConfig.OPTION_IO_EXECUTOR);
    }
}
