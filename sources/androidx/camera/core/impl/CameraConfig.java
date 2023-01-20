package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CameraConfig extends ReadableConfig {
    public static final int REQUIRED_RULE_COEXISTING_PREVIEW_AND_IMAGE_CAPTURE = 1;
    public static final int REQUIRED_RULE_NONE = 0;
    public static final Config.Option<UseCaseConfigFactory> OPTION_USECASE_CONFIG_FACTORY = Config.Option.create("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);
    public static final Config.Option<Identifier> OPTION_COMPATIBILITY_ID = Config.Option.create("camerax.core.camera.compatibilityId", Identifier.class);
    public static final Config.Option<Integer> OPTION_USE_CASE_COMBINATION_REQUIRED_RULE = Config.Option.create("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class);
    public static final Config.Option<SessionProcessor> OPTION_SESSION_PROCESSOR = Config.Option.create("camerax.core.camera.SessionProcessor", SessionProcessor.class);
    public static final Config.Option<Boolean> OPTION_ZSL_DISABLED = Config.Option.create("camerax.core.camera.isZslDisabled", Boolean.class);

    /* loaded from: classes.dex */
    public interface Builder<B> {
        @NonNull
        B setCompatibilityId(@NonNull Identifier identifier);

        @NonNull
        B setSessionProcessor(@NonNull SessionProcessor sessionProcessor);

        @NonNull
        B setUseCaseCombinationRequiredRule(int i2);

        @NonNull
        B setUseCaseConfigFactory(@NonNull UseCaseConfigFactory useCaseConfigFactory);

        @NonNull
        B setZslDisabled(boolean z);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RequiredRule {
    }

    @NonNull
    Identifier getCompatibilityId();

    @NonNull
    SessionProcessor getSessionProcessor();

    @Nullable
    SessionProcessor getSessionProcessor(@Nullable SessionProcessor sessionProcessor);

    int getUseCaseCombinationRequiredRule();

    @NonNull
    UseCaseConfigFactory getUseCaseConfigFactory();

    @NonNull
    Boolean isZslDisabled();
}
