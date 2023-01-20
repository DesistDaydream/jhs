package androidx.camera.camera2.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.workaround.PreviewPixelHDRnet;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class Camera2UseCaseConfigFactory implements UseCaseConfigFactory {
    public final DisplayInfoManager mDisplayInfoManager;

    /* renamed from: androidx.camera.camera2.internal.Camera2UseCaseConfigFactory$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType;

        static {
            int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
            $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType = iArr;
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Camera2UseCaseConfigFactory(@NonNull Context context) {
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(context);
    }

    @Override // androidx.camera.core.impl.UseCaseConfigFactory
    @NonNull
    public Config getConfig(@NonNull UseCaseConfigFactory.CaptureType captureType, int i2) {
        MutableOptionsBundle create = MutableOptionsBundle.create();
        SessionConfig.Builder builder = new SessionConfig.Builder();
        int[] iArr = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType;
        int i3 = iArr[captureType.ordinal()];
        if (i3 == 1) {
            builder.setTemplateType(i2 == 2 ? 5 : 1);
        } else if (i3 == 2 || i3 == 3) {
            builder.setTemplateType(1);
        } else if (i3 == 4) {
            builder.setTemplateType(3);
        }
        UseCaseConfigFactory.CaptureType captureType2 = UseCaseConfigFactory.CaptureType.PREVIEW;
        if (captureType == captureType2) {
            PreviewPixelHDRnet.setHDRnet(builder);
        }
        create.insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, builder.build());
        create.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, Camera2SessionOptionUnpacker.INSTANCE);
        CaptureConfig.Builder builder2 = new CaptureConfig.Builder();
        int i4 = iArr[captureType.ordinal()];
        if (i4 == 1) {
            builder2.setTemplateType(i2 != 2 ? 2 : 5);
        } else if (i4 == 2 || i4 == 3) {
            builder2.setTemplateType(1);
        } else if (i4 == 4) {
            builder2.setTemplateType(3);
        }
        create.insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, builder2.build());
        create.insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, captureType == UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE ? ImageCaptureOptionUnpacker.INSTANCE : Camera2CaptureOptionUnpacker.INSTANCE);
        if (captureType == captureType2) {
            create.insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, this.mDisplayInfoManager.getPreviewSize());
        }
        create.insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(this.mDisplayInfoManager.getMaxSizeDisplay().getRotation()));
        return OptionsBundle.from(create);
    }
}
