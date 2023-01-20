package c.b.b.b2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.UseCaseConfigFactory;

/* compiled from: CameraConfig.java */
/* loaded from: classes.dex */
public final /* synthetic */ class x {
    @Nullable
    public static SessionProcessor $default$getSessionProcessor(@Nullable CameraConfig _this, SessionProcessor sessionProcessor) {
        return (SessionProcessor) _this.retrieveOption(CameraConfig.OPTION_SESSION_PROCESSOR, sessionProcessor);
    }

    @NonNull
    public static UseCaseConfigFactory $default$getUseCaseConfigFactory(CameraConfig _this) {
        return (UseCaseConfigFactory) _this.retrieveOption(CameraConfig.OPTION_USECASE_CONFIG_FACTORY, UseCaseConfigFactory.EMPTY_INSTANCE);
    }

    @NonNull
    public static Boolean $default$isZslDisabled(CameraConfig _this) {
        return (Boolean) _this.retrieveOption(CameraConfig.OPTION_ZSL_DISABLED, Boolean.FALSE);
    }

    @NonNull
    public static SessionProcessor $default$getSessionProcessor(CameraConfig _this) {
        return (SessionProcessor) _this.retrieveOption(CameraConfig.OPTION_SESSION_PROCESSOR);
    }
}
