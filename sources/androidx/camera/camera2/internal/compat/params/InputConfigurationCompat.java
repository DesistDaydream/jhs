package androidx.camera.camera2.internal.compat.params;

import android.annotation.SuppressLint;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class InputConfigurationCompat {
    private final InputConfigurationCompatImpl mImpl;

    @RequiresApi(31)
    /* loaded from: classes.dex */
    public static final class InputConfigurationCompatApi31Impl extends InputConfigurationCompatApi23Impl {
        public InputConfigurationCompatApi31Impl(@NonNull Object obj) {
            super(obj);
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatApi23Impl, androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public boolean isMultiResolution() {
            return ((InputConfiguration) getInputConfiguration()).isMultiResolution();
        }

        public InputConfigurationCompatApi31Impl(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class InputConfigurationCompatBaseImpl implements InputConfigurationCompatImpl {
        private final int mFormat;
        private final int mHeight;
        private final int mWidth;

        public InputConfigurationCompatBaseImpl(int i2, int i3, int i4) {
            this.mWidth = i2;
            this.mHeight = i3;
            this.mFormat = i4;
        }

        public boolean equals(Object obj) {
            if (obj instanceof InputConfigurationCompatBaseImpl) {
                InputConfigurationCompatBaseImpl inputConfigurationCompatBaseImpl = (InputConfigurationCompatBaseImpl) obj;
                return inputConfigurationCompatBaseImpl.getWidth() == this.mWidth && inputConfigurationCompatBaseImpl.getHeight() == this.mHeight && inputConfigurationCompatBaseImpl.getFormat() == this.mFormat;
            }
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getFormat() {
            return this.mFormat;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getHeight() {
            return this.mHeight;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public Object getInputConfiguration() {
            return null;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getWidth() {
            return this.mWidth;
        }

        public int hashCode() {
            int i2 = this.mWidth ^ 31;
            int i3 = this.mHeight ^ ((i2 << 5) - i2);
            return this.mFormat ^ ((i3 << 5) - i3);
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public boolean isMultiResolution() {
            return false;
        }

        @NonNull
        @SuppressLint({"DefaultLocale"})
        public String toString() {
            return String.format("InputConfiguration(w:%d, h:%d, format:%d)", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mFormat));
        }
    }

    /* loaded from: classes.dex */
    public interface InputConfigurationCompatImpl {
        int getFormat();

        int getHeight();

        @Nullable
        Object getInputConfiguration();

        int getWidth();

        boolean isMultiResolution();
    }

    public InputConfigurationCompat(int i2, int i3, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 31) {
            this.mImpl = new InputConfigurationCompatApi31Impl(i2, i3, i4);
        } else if (i5 >= 23) {
            this.mImpl = new InputConfigurationCompatApi23Impl(i2, i3, i4);
        } else {
            this.mImpl = new InputConfigurationCompatBaseImpl(i2, i3, i4);
        }
    }

    @Nullable
    public static InputConfigurationCompat wrap(@Nullable Object obj) {
        int i2;
        if (obj != null && (i2 = Build.VERSION.SDK_INT) >= 23) {
            if (i2 >= 31) {
                return new InputConfigurationCompat(new InputConfigurationCompatApi31Impl(obj));
            }
            return new InputConfigurationCompat(new InputConfigurationCompatApi23Impl(obj));
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InputConfigurationCompat) {
            return this.mImpl.equals(((InputConfigurationCompat) obj).mImpl);
        }
        return false;
    }

    public int getFormat() {
        return this.mImpl.getFormat();
    }

    public int getHeight() {
        return this.mImpl.getHeight();
    }

    public int getWidth() {
        return this.mImpl.getWidth();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public boolean isMultiResolution() {
        return this.mImpl.isMultiResolution();
    }

    @NonNull
    public String toString() {
        return this.mImpl.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getInputConfiguration();
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class InputConfigurationCompatApi23Impl implements InputConfigurationCompatImpl {
        private final InputConfiguration mObject;

        public InputConfigurationCompatApi23Impl(@NonNull Object obj) {
            this.mObject = (InputConfiguration) obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof InputConfigurationCompatImpl) {
                return Objects.equals(this.mObject, ((InputConfigurationCompatImpl) obj).getInputConfiguration());
            }
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getFormat() {
            return this.mObject.getFormat();
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getHeight() {
            return this.mObject.getHeight();
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        @Nullable
        public Object getInputConfiguration() {
            return this.mObject;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getWidth() {
            return this.mObject.getWidth();
        }

        public int hashCode() {
            return this.mObject.hashCode();
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public boolean isMultiResolution() {
            return false;
        }

        @NonNull
        public String toString() {
            return this.mObject.toString();
        }

        public InputConfigurationCompatApi23Impl(int i2, int i3, int i4) {
            this(new InputConfiguration(i2, i3, i4));
        }
    }

    private InputConfigurationCompat(@NonNull InputConfigurationCompatImpl inputConfigurationCompatImpl) {
        this.mImpl = inputConfigurationCompatImpl;
    }
}
