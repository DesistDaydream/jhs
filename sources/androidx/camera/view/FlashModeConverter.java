package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class FlashModeConverter {
    private FlashModeConverter() {
    }

    @NonNull
    public static String nameOf(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return "OFF";
                }
                throw new IllegalArgumentException("Unknown flash mode " + i2);
            }
            return "ON";
        }
        return "AUTO";
    }

    public static int valueOf(@Nullable String str) {
        Objects.requireNonNull(str, "name cannot be null");
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 2527:
                if (str.equals("ON")) {
                    c2 = 0;
                    break;
                }
                break;
            case 78159:
                if (str.equals("OFF")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2020783:
                if (str.equals("AUTO")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 0;
            default:
                throw new IllegalArgumentException("Unknown flash mode name " + str);
        }
    }
}
