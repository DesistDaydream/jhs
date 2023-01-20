package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface ThreadConfig extends ReadableConfig {
    public static final Config.Option<Executor> OPTION_BACKGROUND_EXECUTOR = Config.Option.create("camerax.core.thread.backgroundExecutor", Executor.class);

    /* loaded from: classes.dex */
    public interface Builder<B> {
        @NonNull
        B setBackgroundExecutor(@NonNull Executor executor);
    }

    @NonNull
    Executor getBackgroundExecutor();

    @Nullable
    Executor getBackgroundExecutor(@Nullable Executor executor);
}
