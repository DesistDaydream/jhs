package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface ReadableConfig extends Config {
    @Override // androidx.camera.core.impl.Config
    boolean containsOption(@NonNull Config.Option<?> option);

    @Override // androidx.camera.core.impl.Config
    void findOptions(@NonNull String str, @NonNull Config.OptionMatcher optionMatcher);

    @NonNull
    Config getConfig();

    @Override // androidx.camera.core.impl.Config
    @NonNull
    Config.OptionPriority getOptionPriority(@NonNull Config.Option<?> option);

    @Override // androidx.camera.core.impl.Config
    @NonNull
    Set<Config.OptionPriority> getPriorities(@NonNull Config.Option<?> option);

    @Override // androidx.camera.core.impl.Config
    @NonNull
    Set<Config.Option<?>> listOptions();

    @Override // androidx.camera.core.impl.Config
    @Nullable
    <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option);

    @Override // androidx.camera.core.impl.Config
    @Nullable
    <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet);

    @Override // androidx.camera.core.impl.Config
    @Nullable
    <ValueT> ValueT retrieveOptionWithPriority(@NonNull Config.Option<ValueT> option, @NonNull Config.OptionPriority optionPriority);
}
