package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.SurfaceConfig;
import e.l.r.g0;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ExtraCroppingQuirk implements Quirk {
    private static final List<String> SAMSUNG_DISTORTION_MODELS = Arrays.asList("SM-T580", "SM-J710MN", "SM-A320FL", "SM-G570M", "SM-G610F", "SM-G610M");

    /* renamed from: androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType;

        static {
            int[] iArr = new int[SurfaceConfig.ConfigType.values().length];
            $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType = iArr;
            try {
                iArr[SurfaceConfig.ConfigType.PRIV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType[SurfaceConfig.ConfigType.YUV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType[SurfaceConfig.ConfigType.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static boolean isSamsungDistortion() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && SAMSUNG_DISTORTION_MODELS.contains(Build.MODEL.toUpperCase(Locale.US));
    }

    public static boolean load() {
        return isSamsungDistortion();
    }

    @Nullable
    public Size getVerifiedResolution(@NonNull SurfaceConfig.ConfigType configType) {
        if (isSamsungDistortion()) {
            int i2 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType[configType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return new Size(3264, 1836);
                }
                return new Size(1280, 720);
            }
            return new Size(g0.b.f14278i, g0.b.f14277h);
        }
        return null;
    }
}
