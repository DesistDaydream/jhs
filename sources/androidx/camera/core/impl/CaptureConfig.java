package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CaptureConfig {
    public static final int TEMPLATE_TYPE_NONE = -1;
    public final List<CameraCaptureCallback> mCameraCaptureCallbacks;
    @Nullable
    private final CameraCaptureResult mCameraCaptureResult;
    public final Config mImplementationOptions;
    public final List<DeferrableSurface> mSurfaces;
    @NonNull
    private final TagBundle mTagBundle;
    public final int mTemplateType;
    private final boolean mUseRepeatingSurface;
    public static final Config.Option<Integer> OPTION_ROTATION = Config.Option.create("camerax.core.captureConfig.rotation", Integer.TYPE);
    public static final Config.Option<Integer> OPTION_JPEG_QUALITY = Config.Option.create("camerax.core.captureConfig.jpegQuality", Integer.class);

    /* loaded from: classes.dex */
    public interface OptionUnpacker {
        void unpack(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull Builder builder);
    }

    public CaptureConfig(List<DeferrableSurface> list, Config config, int i2, List<CameraCaptureCallback> list2, boolean z, @NonNull TagBundle tagBundle, @Nullable CameraCaptureResult cameraCaptureResult) {
        this.mSurfaces = list;
        this.mImplementationOptions = config;
        this.mTemplateType = i2;
        this.mCameraCaptureCallbacks = Collections.unmodifiableList(list2);
        this.mUseRepeatingSurface = z;
        this.mTagBundle = tagBundle;
        this.mCameraCaptureResult = cameraCaptureResult;
    }

    @NonNull
    public static CaptureConfig defaultEmptyCaptureConfig() {
        return new Builder().build();
    }

    @NonNull
    public List<CameraCaptureCallback> getCameraCaptureCallbacks() {
        return this.mCameraCaptureCallbacks;
    }

    @Nullable
    public CameraCaptureResult getCameraCaptureResult() {
        return this.mCameraCaptureResult;
    }

    @NonNull
    public Config getImplementationOptions() {
        return this.mImplementationOptions;
    }

    @NonNull
    public List<DeferrableSurface> getSurfaces() {
        return Collections.unmodifiableList(this.mSurfaces);
    }

    @NonNull
    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public boolean isUseRepeatingSurface() {
        return this.mUseRepeatingSurface;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private List<CameraCaptureCallback> mCameraCaptureCallbacks;
        @Nullable
        private CameraCaptureResult mCameraCaptureResult;
        private MutableConfig mImplementationOptions;
        private MutableTagBundle mMutableTagBundle;
        private final Set<DeferrableSurface> mSurfaces;
        private int mTemplateType;
        private boolean mUseRepeatingSurface;

        public Builder() {
            this.mSurfaces = new HashSet();
            this.mImplementationOptions = MutableOptionsBundle.create();
            this.mTemplateType = -1;
            this.mCameraCaptureCallbacks = new ArrayList();
            this.mUseRepeatingSurface = false;
            this.mMutableTagBundle = MutableTagBundle.create();
        }

        @NonNull
        public static Builder createFrom(@NonNull UseCaseConfig<?> useCaseConfig) {
            OptionUnpacker captureOptionUnpacker = useCaseConfig.getCaptureOptionUnpacker(null);
            if (captureOptionUnpacker != null) {
                Builder builder = new Builder();
                captureOptionUnpacker.unpack(useCaseConfig, builder);
                return builder;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + useCaseConfig.getTargetName(useCaseConfig.toString()));
        }

        @NonNull
        public static Builder from(@NonNull CaptureConfig captureConfig) {
            return new Builder(captureConfig);
        }

        public void addAllCameraCaptureCallbacks(@NonNull Collection<CameraCaptureCallback> collection) {
            for (CameraCaptureCallback cameraCaptureCallback : collection) {
                addCameraCaptureCallback(cameraCaptureCallback);
            }
        }

        public void addAllTags(@NonNull TagBundle tagBundle) {
            this.mMutableTagBundle.addTagBundle(tagBundle);
        }

        public void addCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            if (this.mCameraCaptureCallbacks.contains(cameraCaptureCallback)) {
                return;
            }
            this.mCameraCaptureCallbacks.add(cameraCaptureCallback);
        }

        public <T> void addImplementationOption(@NonNull Config.Option<T> option, @NonNull T t) {
            this.mImplementationOptions.insertOption(option, t);
        }

        public void addImplementationOptions(@NonNull Config config) {
            for (Config.Option<?> option : config.listOptions()) {
                Object retrieveOption = this.mImplementationOptions.retrieveOption(option, null);
                Object retrieveOption2 = config.retrieveOption(option);
                if (retrieveOption instanceof MultiValueSet) {
                    ((MultiValueSet) retrieveOption).addAll(((MultiValueSet) retrieveOption2).getAllItems());
                } else {
                    if (retrieveOption2 instanceof MultiValueSet) {
                        retrieveOption2 = ((MultiValueSet) retrieveOption2).m0clone();
                    }
                    this.mImplementationOptions.insertOption(option, config.getOptionPriority(option), retrieveOption2);
                }
            }
        }

        public void addSurface(@NonNull DeferrableSurface deferrableSurface) {
            this.mSurfaces.add(deferrableSurface);
        }

        public void addTag(@NonNull String str, @NonNull Object obj) {
            this.mMutableTagBundle.putTag(str, obj);
        }

        @NonNull
        public CaptureConfig build() {
            return new CaptureConfig(new ArrayList(this.mSurfaces), OptionsBundle.from(this.mImplementationOptions), this.mTemplateType, this.mCameraCaptureCallbacks, this.mUseRepeatingSurface, TagBundle.from(this.mMutableTagBundle), this.mCameraCaptureResult);
        }

        public void clearSurfaces() {
            this.mSurfaces.clear();
        }

        @NonNull
        public Config getImplementationOptions() {
            return this.mImplementationOptions;
        }

        @NonNull
        public Set<DeferrableSurface> getSurfaces() {
            return this.mSurfaces;
        }

        @Nullable
        public Object getTag(@NonNull String str) {
            return this.mMutableTagBundle.getTag(str);
        }

        public int getTemplateType() {
            return this.mTemplateType;
        }

        public boolean isUseRepeatingSurface() {
            return this.mUseRepeatingSurface;
        }

        public boolean removeCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            return this.mCameraCaptureCallbacks.remove(cameraCaptureCallback);
        }

        public void removeSurface(@NonNull DeferrableSurface deferrableSurface) {
            this.mSurfaces.remove(deferrableSurface);
        }

        public void setCameraCaptureResult(@NonNull CameraCaptureResult cameraCaptureResult) {
            this.mCameraCaptureResult = cameraCaptureResult;
        }

        public void setImplementationOptions(@NonNull Config config) {
            this.mImplementationOptions = MutableOptionsBundle.from(config);
        }

        public void setTemplateType(int i2) {
            this.mTemplateType = i2;
        }

        public void setUseRepeatingSurface(boolean z) {
            this.mUseRepeatingSurface = z;
        }

        private Builder(CaptureConfig captureConfig) {
            HashSet hashSet = new HashSet();
            this.mSurfaces = hashSet;
            this.mImplementationOptions = MutableOptionsBundle.create();
            this.mTemplateType = -1;
            this.mCameraCaptureCallbacks = new ArrayList();
            this.mUseRepeatingSurface = false;
            this.mMutableTagBundle = MutableTagBundle.create();
            hashSet.addAll(captureConfig.mSurfaces);
            this.mImplementationOptions = MutableOptionsBundle.from(captureConfig.mImplementationOptions);
            this.mTemplateType = captureConfig.mTemplateType;
            this.mCameraCaptureCallbacks.addAll(captureConfig.getCameraCaptureCallbacks());
            this.mUseRepeatingSurface = captureConfig.isUseRepeatingSurface();
            this.mMutableTagBundle = MutableTagBundle.from(captureConfig.getTagBundle());
        }
    }
}
