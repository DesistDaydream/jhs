package androidx.camera.core.impl.utils;

import android.os.Build;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.core.util.Preconditions;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.internal.ws.WebSocketProtocol;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ExifData {
    private static final boolean DEBUG = false;
    public static final ExifTag[] EXIF_POINTER_TAGS;
    public static final ExifTag[][] EXIF_TAGS;
    private static final ExifTag[] IFD_EXIF_TAGS;
    public static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    public static final int IFD_TYPE_EXIF = 1;
    public static final int IFD_TYPE_GPS = 2;
    public static final int IFD_TYPE_INTEROPERABILITY = 3;
    public static final int IFD_TYPE_PRIMARY = 0;
    private static final int MM_IN_MICRONS = 1000;
    private static final String TAG = "ExifData";
    public static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final HashSet<String> sTagSetForCompatibility;
    private final List<Map<String, ExifAttribute>> mAttributes;
    private final ByteOrder mByteOrder;

    /* renamed from: androidx.camera.core.impl.utils.ExifData$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState;
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode;

        static {
            int[] iArr = new int[WhiteBalanceMode.values().length];
            $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode = iArr;
            try {
                iArr[WhiteBalanceMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode[WhiteBalanceMode.MANUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CameraCaptureMetaData.FlashState.values().length];
            $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState = iArr2;
            try {
                iArr2[CameraCaptureMetaData.FlashState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[CameraCaptureMetaData.FlashState.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[CameraCaptureMetaData.FlashState.FIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private static final int DATETIME_VALUE_STRING_LENGTH = 19;
        public final List<Map<String, ExifAttribute>> mAttributes = Collections.list(new Enumeration<Map<String, ExifAttribute>>() { // from class: androidx.camera.core.impl.utils.ExifData.Builder.2
            public int mIfdIndex = 0;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.mIfdIndex < ExifData.EXIF_TAGS.length;
            }

            @Override // java.util.Enumeration
            public Map<String, ExifAttribute> nextElement() {
                this.mIfdIndex++;
                return new HashMap();
            }
        });
        private final ByteOrder mByteOrder;
        private static final Pattern GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        public static final List<HashMap<String, ExifTag>> sExifTagMapsForWriting = Collections.list(new Enumeration<HashMap<String, ExifTag>>() { // from class: androidx.camera.core.impl.utils.ExifData.Builder.1
            public int mIfdIndex = 0;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.mIfdIndex < ExifData.EXIF_TAGS.length;
            }

            @Override // java.util.Enumeration
            public HashMap<String, ExifTag> nextElement() {
                ExifTag[] exifTagArr;
                HashMap<String, ExifTag> hashMap = new HashMap<>();
                for (ExifTag exifTag : ExifData.EXIF_TAGS[this.mIfdIndex]) {
                    hashMap.put(exifTag.name, exifTag);
                }
                this.mIfdIndex++;
                return hashMap;
            }
        });

        public Builder(@NonNull ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        private static Pair<Integer, Integer> guessDataFormat(String str) {
            if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP, -1);
                Pair<Integer, Integer> guessDataFormat = guessDataFormat(split[0]);
                if (((Integer) guessDataFormat.first).intValue() == 2) {
                    return guessDataFormat;
                }
                for (int i2 = 1; i2 < split.length; i2++) {
                    Pair<Integer, Integer> guessDataFormat2 = guessDataFormat(split[i2]);
                    int intValue = (((Integer) guessDataFormat2.first).equals(guessDataFormat.first) || ((Integer) guessDataFormat2.second).equals(guessDataFormat.first)) ? ((Integer) guessDataFormat.first).intValue() : -1;
                    int intValue2 = (((Integer) guessDataFormat.second).intValue() == -1 || !(((Integer) guessDataFormat2.first).equals(guessDataFormat.second) || ((Integer) guessDataFormat2.second).equals(guessDataFormat.second))) ? -1 : ((Integer) guessDataFormat.second).intValue();
                    if (intValue == -1 && intValue2 == -1) {
                        return new Pair<>(2, -1);
                    }
                    if (intValue == -1) {
                        guessDataFormat = new Pair<>(Integer.valueOf(intValue2), -1);
                    } else if (intValue2 == -1) {
                        guessDataFormat = new Pair<>(Integer.valueOf(intValue), -1);
                    }
                }
                return guessDataFormat;
            } else if (str.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                String[] split2 = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR, -1);
                if (split2.length == 2) {
                    try {
                        long parseDouble = (long) Double.parseDouble(split2[0]);
                        long parseDouble2 = (long) Double.parseDouble(split2[1]);
                        if (parseDouble >= 0 && parseDouble2 >= 0) {
                            if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                                return new Pair<>(10, 5);
                            }
                            return new Pair<>(5, -1);
                        }
                        return new Pair<>(10, -1);
                    } catch (NumberFormatException unused) {
                    }
                }
                return new Pair<>(2, -1);
            } else {
                try {
                    try {
                        long parseLong = Long.parseLong(str);
                        int i3 = (parseLong > 0L ? 1 : (parseLong == 0L ? 0 : -1));
                        if (i3 < 0 || parseLong > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                            if (i3 < 0) {
                                return new Pair<>(9, -1);
                            }
                            return new Pair<>(4, -1);
                        }
                        return new Pair<>(3, 4);
                    } catch (NumberFormatException unused2) {
                        Double.parseDouble(str);
                        return new Pair<>(12, -1);
                    }
                } catch (NumberFormatException unused3) {
                    return new Pair<>(2, -1);
                }
            }
        }

        private void setAttributeIfMissing(@NonNull String str, @NonNull String str2, @NonNull List<Map<String, ExifAttribute>> list) {
            for (Map<String, ExifAttribute> map : list) {
                if (map.containsKey(str)) {
                    return;
                }
            }
            setAttributeInternal(str, str2, list);
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x018a, code lost:
            if (r7 != r0) goto L98;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void setAttributeInternal(@androidx.annotation.NonNull java.lang.String r18, @androidx.annotation.Nullable java.lang.String r19, @androidx.annotation.NonNull java.util.List<java.util.Map<java.lang.String, androidx.camera.core.impl.utils.ExifAttribute>> r20) {
            /*
                Method dump skipped, instructions count: 772
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.Builder.setAttributeInternal(java.lang.String, java.lang.String, java.util.List):void");
        }

        @NonNull
        public ExifData build() {
            ArrayList list = Collections.list(new Enumeration<Map<String, ExifAttribute>>() { // from class: androidx.camera.core.impl.utils.ExifData.Builder.3
                public final Enumeration<Map<String, ExifAttribute>> mMapEnumeration;

                {
                    this.mMapEnumeration = Collections.enumeration(Builder.this.mAttributes);
                }

                @Override // java.util.Enumeration
                public boolean hasMoreElements() {
                    return this.mMapEnumeration.hasMoreElements();
                }

                @Override // java.util.Enumeration
                public Map<String, ExifAttribute> nextElement() {
                    return new HashMap(this.mMapEnumeration.nextElement());
                }
            });
            if (!list.get(1).isEmpty()) {
                setAttributeIfMissing(ExifInterface.TAG_EXPOSURE_PROGRAM, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_EXIF_VERSION, "0230", list);
                setAttributeIfMissing(ExifInterface.TAG_COMPONENTS_CONFIGURATION, "1,2,3,0", list);
                setAttributeIfMissing(ExifInterface.TAG_METERING_MODE, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_LIGHT_SOURCE, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_FLASHPIX_VERSION, "0100", list);
                setAttributeIfMissing(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, String.valueOf(2), list);
                setAttributeIfMissing(ExifInterface.TAG_FILE_SOURCE, String.valueOf(3), list);
                setAttributeIfMissing(ExifInterface.TAG_SCENE_TYPE, String.valueOf(1), list);
                setAttributeIfMissing(ExifInterface.TAG_CUSTOM_RENDERED, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_SCENE_CAPTURE_TYPE, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_CONTRAST, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_SATURATION, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_SHARPNESS, String.valueOf(0), list);
            }
            if (!list.get(2).isEmpty()) {
                setAttributeIfMissing(ExifInterface.TAG_GPS_VERSION_ID, "2300", list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_SPEED_REF, "K", list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, "K", list);
            }
            return new ExifData(this.mByteOrder, list);
        }

        @NonNull
        public Builder removeAttribute(@NonNull String str) {
            setAttributeInternal(str, null, this.mAttributes);
            return this;
        }

        @NonNull
        public Builder setAttribute(@NonNull String str, @NonNull String str2) {
            setAttributeInternal(str, str2, this.mAttributes);
            return this;
        }

        @NonNull
        public Builder setExposureTimeNanos(long j2) {
            return setAttribute(ExifInterface.TAG_EXPOSURE_TIME, String.valueOf(j2 / TimeUnit.SECONDS.toNanos(1L)));
        }

        @NonNull
        public Builder setFlashState(@NonNull CameraCaptureMetaData.FlashState flashState) {
            int i2;
            if (flashState == CameraCaptureMetaData.FlashState.UNKNOWN) {
                return this;
            }
            int i3 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[flashState.ordinal()];
            if (i3 == 1) {
                i2 = 0;
            } else if (i3 == 2) {
                i2 = 32;
            } else if (i3 != 3) {
                Logger.w(ExifData.TAG, "Unknown flash state: " + flashState);
                return this;
            } else {
                i2 = 1;
            }
            if ((i2 & 1) == 1) {
                setAttribute(ExifInterface.TAG_LIGHT_SOURCE, String.valueOf(4));
            }
            return setAttribute(ExifInterface.TAG_FLASH, String.valueOf(i2));
        }

        @NonNull
        public Builder setFocalLength(float f2) {
            return setAttribute(ExifInterface.TAG_FOCAL_LENGTH, new LongRational(f2 * 1000.0f, 1000L).toString());
        }

        @NonNull
        public Builder setImageHeight(int i2) {
            return setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i2));
        }

        @NonNull
        public Builder setImageWidth(int i2) {
            return setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i2));
        }

        @NonNull
        public Builder setIso(int i2) {
            return setAttribute(ExifInterface.TAG_SENSITIVITY_TYPE, String.valueOf(3)).setAttribute(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, String.valueOf(Math.min(65535, i2)));
        }

        @NonNull
        public Builder setLensFNumber(float f2) {
            return setAttribute(ExifInterface.TAG_F_NUMBER, String.valueOf(f2));
        }

        @NonNull
        public Builder setOrientationDegrees(int i2) {
            int i3;
            if (i2 == 0) {
                i3 = 1;
            } else if (i2 == 90) {
                i3 = 6;
            } else if (i2 == 180) {
                i3 = 3;
            } else if (i2 != 270) {
                Logger.w(ExifData.TAG, "Unexpected orientation value: " + i2 + ". Must be one of 0, 90, 180, 270.");
                i3 = 0;
            } else {
                i3 = 8;
            }
            return setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i3));
        }

        @NonNull
        public Builder setWhiteBalanceMode(@NonNull WhiteBalanceMode whiteBalanceMode) {
            String valueOf;
            int i2 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode[whiteBalanceMode.ordinal()];
            if (i2 != 1) {
                valueOf = i2 != 2 ? null : String.valueOf(1);
            } else {
                valueOf = String.valueOf(0);
            }
            return setAttribute(ExifInterface.TAG_WHITE_BALANCE, valueOf);
        }
    }

    /* loaded from: classes.dex */
    public enum WhiteBalanceMode {
        AUTO,
        MANUAL
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag(ExifInterface.TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(ExifInterface.TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(ExifInterface.TAG_MAKE, 271, 2), new ExifTag(ExifInterface.TAG_MODEL, 272, 2), new ExifTag(ExifInterface.TAG_ORIENTATION, TUIMessageBean.MSG_STATUS_DELETE, 3), new ExifTag(ExifInterface.TAG_X_RESOLUTION, 282, 5), new ExifTag(ExifInterface.TAG_Y_RESOLUTION, 283, 5), new ExifTag(ExifInterface.TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(ExifInterface.TAG_SOFTWARE, 305, 2), new ExifTag(ExifInterface.TAG_DATETIME, 306, 2), new ExifTag(ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4)};
        IFD_TIFF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag(ExifInterface.TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(ExifInterface.TAG_F_NUMBER, 33437, 5), new ExifTag(ExifInterface.TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(ExifInterface.TAG_SENSITIVITY_TYPE, 34864, 3), new ExifTag(ExifInterface.TAG_EXIF_VERSION, 36864, 2), new ExifTag(ExifInterface.TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(ExifInterface.TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(ExifInterface.TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(ExifInterface.TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(ExifInterface.TAG_APERTURE_VALUE, 37378, 5), new ExifTag(ExifInterface.TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(ExifInterface.TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(ExifInterface.TAG_METERING_MODE, 37383, 3), new ExifTag(ExifInterface.TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(ExifInterface.TAG_FLASH, 37385, 3), new ExifTag(ExifInterface.TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(ExifInterface.TAG_SUBSEC_TIME, 37520, 2), new ExifTag(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(ExifInterface.TAG_FLASHPIX_VERSION, 40960, 7), new ExifTag(ExifInterface.TAG_COLOR_SPACE, 40961, 3), new ExifTag(ExifInterface.TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(ExifInterface.TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(ExifInterface.TAG_SENSING_METHOD, 41495, 3), new ExifTag(ExifInterface.TAG_FILE_SOURCE, 41728, 7), new ExifTag(ExifInterface.TAG_SCENE_TYPE, 41729, 7), new ExifTag(ExifInterface.TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(ExifInterface.TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(ExifInterface.TAG_WHITE_BALANCE, 41987, 3), new ExifTag(ExifInterface.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(ExifInterface.TAG_CONTRAST, 41992, 3), new ExifTag(ExifInterface.TAG_SATURATION, 41993, 3), new ExifTag(ExifInterface.TAG_SHARPNESS, 41994, 3)};
        IFD_EXIF_TAGS = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag(ExifInterface.TAG_GPS_VERSION_ID, 0, 1), new ExifTag(ExifInterface.TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(ExifInterface.TAG_GPS_LATITUDE, 2, 5, 10), new ExifTag(ExifInterface.TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(ExifInterface.TAG_GPS_LONGITUDE, 4, 5, 10), new ExifTag(ExifInterface.TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(ExifInterface.TAG_GPS_ALTITUDE, 6, 5), new ExifTag(ExifInterface.TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(ExifInterface.TAG_GPS_SPEED_REF, 12, 2), new ExifTag(ExifInterface.TAG_GPS_TRACK_REF, 14, 2), new ExifTag(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(ExifInterface.TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, 25, 2)};
        IFD_GPS_TAGS = exifTagArr3;
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4)};
        ExifTag[] exifTagArr4 = {new ExifTag(ExifInterface.TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr4;
        EXIF_TAGS = new ExifTag[][]{exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4};
        sTagSetForCompatibility = new HashSet<>(Arrays.asList(ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_GPS_TIMESTAMP));
    }

    public ExifData(ByteOrder byteOrder, List<Map<String, ExifAttribute>> list) {
        Preconditions.checkState(list.size() == EXIF_TAGS.length, "Malformed attributes list. Number of IFDs mismatch.");
        this.mByteOrder = byteOrder;
        this.mAttributes = list;
    }

    @NonNull
    public static Builder builderForDevice() {
        return new Builder(ByteOrder.BIG_ENDIAN).setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(1)).setAttribute(ExifInterface.TAG_X_RESOLUTION, "72/1").setAttribute(ExifInterface.TAG_Y_RESOLUTION, "72/1").setAttribute(ExifInterface.TAG_RESOLUTION_UNIT, String.valueOf(2)).setAttribute(ExifInterface.TAG_Y_CB_CR_POSITIONING, String.valueOf(1)).setAttribute(ExifInterface.TAG_MAKE, Build.MANUFACTURER).setAttribute(ExifInterface.TAG_MODEL, Build.MODEL);
    }

    @Nullable
    private ExifAttribute getExifAttribute(@NonNull String str) {
        if (ExifInterface.TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            ExifAttribute exifAttribute = this.mAttributes.get(i2).get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mByteOrder);
            }
            if (str.equals(ExifInterface.TAG_GPS_TIMESTAMP)) {
                int i2 = exifAttribute.format;
                if (i2 != 5 && i2 != 10) {
                    Logger.w(TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.format);
                    return null;
                }
                LongRational[] longRationalArr = (LongRational[]) exifAttribute.getValue(this.mByteOrder);
                if (longRationalArr != null && longRationalArr.length == 3) {
                    return String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf((int) (((float) longRationalArr[0].getNumerator()) / ((float) longRationalArr[0].getDenominator()))), Integer.valueOf((int) (((float) longRationalArr[1].getNumerator()) / ((float) longRationalArr[1].getDenominator()))), Integer.valueOf((int) (((float) longRationalArr[2].getNumerator()) / ((float) longRationalArr[2].getDenominator()))));
                }
                Logger.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(longRationalArr));
                return null;
            }
            try {
                return Double.toString(exifAttribute.getDoubleValue(this.mByteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    @NonNull
    public Map<String, ExifAttribute> getAttributes(int i2) {
        int length = EXIF_TAGS.length;
        Preconditions.checkArgumentInRange(i2, 0, length, "Invalid IFD index: " + i2 + ". Index should be between [0, EXIF_TAGS.length] ");
        return this.mAttributes.get(i2);
    }

    @NonNull
    public ByteOrder getByteOrder() {
        return this.mByteOrder;
    }
}
