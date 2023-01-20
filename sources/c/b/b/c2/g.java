package c.b.b.c2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.UseCaseEventConfig;

/* compiled from: UseCaseEventConfig.java */
/* loaded from: classes.dex */
public final /* synthetic */ class g {
    @Nullable
    public static UseCase.EventCallback $default$getUseCaseEventCallback(@Nullable UseCaseEventConfig _this, UseCase.EventCallback eventCallback) {
        return (UseCase.EventCallback) _this.retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
    }

    @NonNull
    public static UseCase.EventCallback $default$getUseCaseEventCallback(UseCaseEventConfig _this) {
        return (UseCase.EventCallback) _this.retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK);
    }
}
