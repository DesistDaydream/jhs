package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class UseCaseGroup {
    @NonNull
    private final List<UseCase> mUseCases;
    @Nullable
    private final ViewPort mViewPort;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final List<UseCase> mUseCases = new ArrayList();
        private ViewPort mViewPort;

        @NonNull
        public Builder addUseCase(@NonNull UseCase useCase) {
            this.mUseCases.add(useCase);
            return this;
        }

        @NonNull
        public UseCaseGroup build() {
            Preconditions.checkArgument(!this.mUseCases.isEmpty(), "UseCase must not be empty.");
            return new UseCaseGroup(this.mViewPort, this.mUseCases);
        }

        @NonNull
        public Builder setViewPort(@NonNull ViewPort viewPort) {
            this.mViewPort = viewPort;
            return this;
        }
    }

    public UseCaseGroup(@Nullable ViewPort viewPort, @NonNull List<UseCase> list) {
        this.mViewPort = viewPort;
        this.mUseCases = list;
    }

    @NonNull
    public List<UseCase> getUseCases() {
        return this.mUseCases;
    }

    @Nullable
    public ViewPort getViewPort() {
        return this.mViewPort;
    }
}
