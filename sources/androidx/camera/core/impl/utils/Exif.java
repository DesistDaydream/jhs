package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import e.t.u.b0;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class Exif {
    public static final long INVALID_TIMESTAMP = -1;
    private static final String KILOMETERS_PER_HOUR = "K";
    private static final String KNOTS = "N";
    private static final String MILES_PER_HOUR = "M";
    private static final String TAG = "Exif";
    private final ExifInterface mExifInterface;
    private boolean mRemoveTimestamp = false;
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.1
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.2
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(b0.a.n, Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.3
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        }
    };
    private static final List<String> ALL_EXIF_TAGS = getAllExifTags();
    private static final List<String> DO_NOT_COPY_EXIF_TAGS = Arrays.asList(ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_PIXEL_X_DIMENSION, ExifInterface.TAG_PIXEL_Y_DIMENSION, ExifInterface.TAG_COMPRESSION, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, ExifInterface.TAG_THUMBNAIL_ORIENTATION);

    /* loaded from: classes.dex */
    public static final class Speed {

        /* loaded from: classes.dex */
        public static final class Converter {
            public final double mMph;

            public Converter(double d2) {
                this.mMph = d2;
            }

            public double toKilometersPerHour() {
                return this.mMph / 0.621371d;
            }

            public double toKnots() {
                return this.mMph / 1.15078d;
            }

            public double toMetersPerSecond() {
                return this.mMph / 2.23694d;
            }

            public double toMilesPerHour() {
                return this.mMph;
            }
        }

        private Speed() {
        }

        public static Converter fromKilometersPerHour(double d2) {
            return new Converter(d2 * 0.621371d);
        }

        public static Converter fromKnots(double d2) {
            return new Converter(d2 * 1.15078d);
        }

        public static Converter fromMetersPerSecond(double d2) {
            return new Converter(d2 * 2.23694d);
        }

        public static Converter fromMilesPerHour(double d2) {
            return new Converter(d2);
        }
    }

    private Exif(ExifInterface exifInterface) {
        this.mExifInterface = exifInterface;
    }

    private void attachLastModifiedTimestamp() {
        long currentTimeMillis = System.currentTimeMillis();
        String convertToExifDateTime = convertToExifDateTime(currentTimeMillis);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME, convertToExifDateTime);
        try {
            this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME, Long.toString(currentTimeMillis - convertFromExifDateTime(convertToExifDateTime).getTime()));
        } catch (ParseException unused) {
        }
    }

    private static Date convertFromExifDate(String str) throws ParseException {
        return DATE_FORMAT.get().parse(str);
    }

    private static Date convertFromExifDateTime(String str) throws ParseException {
        return DATETIME_FORMAT.get().parse(str);
    }

    private static Date convertFromExifTime(String str) throws ParseException {
        return TIME_FORMAT.get().parse(str);
    }

    private static String convertToExifDateTime(long j2) {
        return DATETIME_FORMAT.get().format(new Date(j2));
    }

    @NonNull
    public static Exif createFromFile(@NonNull File file) throws IOException {
        return createFromFileString(file.toString());
    }

    @NonNull
    public static Exif createFromFileString(@NonNull String str) throws IOException {
        return new Exif(new ExifInterface(str));
    }

    @NonNull
    public static Exif createFromImageProxy(@NonNull ImageProxy imageProxy) throws IOException {
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        buffer.rewind();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.get(bArr);
        return createFromInputStream(new ByteArrayInputStream(bArr));
    }

    @NonNull
    public static Exif createFromInputStream(@NonNull InputStream inputStream) throws IOException {
        return new Exif(new ExifInterface(inputStream));
    }

    @NonNull
    public static List<String> getAllExifTags() {
        return Arrays.asList(ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_BITS_PER_SAMPLE, ExifInterface.TAG_COMPRESSION, ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, ExifInterface.TAG_ORIENTATION, ExifInterface.TAG_SAMPLES_PER_PIXEL, ExifInterface.TAG_PLANAR_CONFIGURATION, ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, ExifInterface.TAG_Y_CB_CR_POSITIONING, ExifInterface.TAG_X_RESOLUTION, ExifInterface.TAG_Y_RESOLUTION, ExifInterface.TAG_RESOLUTION_UNIT, ExifInterface.TAG_STRIP_OFFSETS, ExifInterface.TAG_ROWS_PER_STRIP, ExifInterface.TAG_STRIP_BYTE_COUNTS, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface.TAG_TRANSFER_FUNCTION, ExifInterface.TAG_WHITE_POINT, ExifInterface.TAG_PRIMARY_CHROMATICITIES, ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, ExifInterface.TAG_REFERENCE_BLACK_WHITE, ExifInterface.TAG_DATETIME, ExifInterface.TAG_IMAGE_DESCRIPTION, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SOFTWARE, ExifInterface.TAG_ARTIST, ExifInterface.TAG_COPYRIGHT, ExifInterface.TAG_EXIF_VERSION, ExifInterface.TAG_FLASHPIX_VERSION, ExifInterface.TAG_COLOR_SPACE, ExifInterface.TAG_GAMMA, ExifInterface.TAG_PIXEL_X_DIMENSION, ExifInterface.TAG_PIXEL_Y_DIMENSION, ExifInterface.TAG_COMPONENTS_CONFIGURATION, ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, ExifInterface.TAG_MAKER_NOTE, ExifInterface.TAG_USER_COMMENT, ExifInterface.TAG_RELATED_SOUND_FILE, ExifInterface.TAG_DATETIME_ORIGINAL, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_OFFSET_TIME, ExifInterface.TAG_OFFSET_TIME_ORIGINAL, ExifInterface.TAG_OFFSET_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_EXPOSURE_PROGRAM, ExifInterface.TAG_SPECTRAL_SENSITIVITY, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_OECF, ExifInterface.TAG_SENSITIVITY_TYPE, ExifInterface.TAG_STANDARD_OUTPUT_SENSITIVITY, ExifInterface.TAG_RECOMMENDED_EXPOSURE_INDEX, ExifInterface.TAG_ISO_SPEED, ExifInterface.TAG_ISO_SPEED_LATITUDE_YYY, ExifInterface.TAG_ISO_SPEED_LATITUDE_ZZZ, ExifInterface.TAG_SHUTTER_SPEED_VALUE, ExifInterface.TAG_APERTURE_VALUE, ExifInterface.TAG_BRIGHTNESS_VALUE, ExifInterface.TAG_EXPOSURE_BIAS_VALUE, ExifInterface.TAG_MAX_APERTURE_VALUE, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_METERING_MODE, ExifInterface.TAG_LIGHT_SOURCE, ExifInterface.TAG_FLASH, ExifInterface.TAG_SUBJECT_AREA, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_FLASH_ENERGY, ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, ExifInterface.TAG_SUBJECT_LOCATION, ExifInterface.TAG_EXPOSURE_INDEX, ExifInterface.TAG_SENSING_METHOD, ExifInterface.TAG_FILE_SOURCE, ExifInterface.TAG_SCENE_TYPE, ExifInterface.TAG_CFA_PATTERN, ExifInterface.TAG_CUSTOM_RENDERED, ExifInterface.TAG_EXPOSURE_MODE, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, ExifInterface.TAG_SCENE_CAPTURE_TYPE, ExifInterface.TAG_GAIN_CONTROL, ExifInterface.TAG_CONTRAST, ExifInterface.TAG_SATURATION, ExifInterface.TAG_SHARPNESS, ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, ExifInterface.TAG_IMAGE_UNIQUE_ID, "CameraOwnerName", ExifInterface.TAG_BODY_SERIAL_NUMBER, ExifInterface.TAG_LENS_SPECIFICATION, ExifInterface.TAG_LENS_MAKE, ExifInterface.TAG_LENS_MODEL, ExifInterface.TAG_LENS_SERIAL_NUMBER, ExifInterface.TAG_GPS_VERSION_ID, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_GPS_SATELLITES, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_MEASURE_MODE, ExifInterface.TAG_GPS_DOP, ExifInterface.TAG_GPS_SPEED_REF, ExifInterface.TAG_GPS_SPEED, ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.TAG_GPS_TRACK, ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.TAG_GPS_IMG_DIRECTION, ExifInterface.TAG_GPS_MAP_DATUM, ExifInterface.TAG_GPS_DEST_LATITUDE_REF, ExifInterface.TAG_GPS_DEST_LATITUDE, ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, ExifInterface.TAG_GPS_DEST_LONGITUDE, ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.TAG_GPS_DEST_BEARING, ExifInterface.TAG_GPS_DEST_DISTANCE_REF, ExifInterface.TAG_GPS_DEST_DISTANCE, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_AREA_INFORMATION, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_DIFFERENTIAL, ExifInterface.TAG_GPS_H_POSITIONING_ERROR, ExifInterface.TAG_INTEROPERABILITY_INDEX, ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, ExifInterface.TAG_THUMBNAIL_ORIENTATION, ExifInterface.TAG_DNG_VERSION, ExifInterface.TAG_DEFAULT_CROP_SIZE, ExifInterface.TAG_ORF_THUMBNAIL_IMAGE, ExifInterface.TAG_ORF_PREVIEW_IMAGE_START, ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH, ExifInterface.TAG_ORF_ASPECT_FRAME, ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER, ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER, ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER, ExifInterface.TAG_RW2_SENSOR_TOP_BORDER, ExifInterface.TAG_RW2_ISO, ExifInterface.TAG_RW2_JPG_FROM_RAW, ExifInterface.TAG_XMP, ExifInterface.TAG_NEW_SUBFILE_TYPE, ExifInterface.TAG_SUBFILE_TYPE);
    }

    private long parseTimestamp(@Nullable String str, @Nullable String str2) {
        if (str == null && str2 == null) {
            return -1L;
        }
        if (str2 == null) {
            try {
                return convertFromExifDate(str).getTime();
            } catch (ParseException unused) {
                return -1L;
            }
        } else if (str == null) {
            try {
                return convertFromExifTime(str2).getTime();
            } catch (ParseException unused2) {
                return -1L;
            }
        } else {
            return parseTimestamp(str + ExpandableTextView.N + str2);
        }
    }

    public void attachLocation(@NonNull Location location) {
        this.mExifInterface.setGpsInfo(location);
    }

    public void attachTimestamp() {
        long currentTimeMillis = System.currentTimeMillis();
        String convertToExifDateTime = convertToExifDateTime(currentTimeMillis);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_ORIGINAL, convertToExifDateTime);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_DIGITIZED, convertToExifDateTime);
        try {
            String l2 = Long.toString(currentTimeMillis - convertFromExifDateTime(convertToExifDateTime).getTime());
            this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, l2);
            this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, l2);
        } catch (ParseException unused) {
        }
        this.mRemoveTimestamp = false;
    }

    public void copyToCroppedImage(@NonNull Exif exif) {
        ArrayList<String> arrayList = new ArrayList(ALL_EXIF_TAGS);
        arrayList.removeAll(DO_NOT_COPY_EXIF_TAGS);
        for (String str : arrayList) {
            String attribute = this.mExifInterface.getAttribute(str);
            if (attribute != null) {
                exif.mExifInterface.setAttribute(str, attribute);
            }
        }
    }

    public void flipHorizontally() {
        int i2;
        switch (getOrientation()) {
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
                i2 = 3;
                break;
            case 5:
                i2 = 6;
                break;
            case 6:
                i2 = 5;
                break;
            case 7:
                i2 = 8;
                break;
            case 8:
                i2 = 7;
                break;
            default:
                i2 = 2;
                break;
        }
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i2));
    }

    public void flipVertically() {
        int i2;
        switch (getOrientation()) {
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                i2 = 1;
                break;
            case 5:
                i2 = 8;
                break;
            case 6:
                i2 = 7;
                break;
            case 7:
                i2 = 6;
                break;
            case 8:
                i2 = 5;
                break;
            default:
                i2 = 4;
                break;
        }
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i2));
    }

    @Nullable
    public String getDescription() {
        return this.mExifInterface.getAttribute(ExifInterface.TAG_IMAGE_DESCRIPTION);
    }

    public int getHeight() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0);
    }

    public long getLastModifiedTimestamp() {
        long parseTimestamp = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_DATETIME));
        if (parseTimestamp == -1) {
            return -1L;
        }
        String attribute = this.mExifInterface.getAttribute(ExifInterface.TAG_SUBSEC_TIME);
        if (attribute != null) {
            try {
                long parseLong = Long.parseLong(attribute);
                while (parseLong > 1000) {
                    parseLong /= 10;
                }
                return parseTimestamp + parseLong;
            } catch (NumberFormatException unused) {
                return parseTimestamp;
            }
        }
        return parseTimestamp;
    }

    @Nullable
    public Location getLocation() {
        double metersPerSecond;
        String attribute = this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_PROCESSING_METHOD);
        double[] latLong = this.mExifInterface.getLatLong();
        double altitude = this.mExifInterface.getAltitude(0.0d);
        double attributeDouble = this.mExifInterface.getAttributeDouble(ExifInterface.TAG_GPS_SPEED, 0.0d);
        String attribute2 = this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_SPEED_REF);
        if (attribute2 == null) {
            attribute2 = "K";
        }
        long parseTimestamp = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_DATESTAMP), this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_TIMESTAMP));
        if (latLong == null) {
            return null;
        }
        if (attribute == null) {
            attribute = TAG;
        }
        Location location = new Location(attribute);
        location.setLatitude(latLong[0]);
        location.setLongitude(latLong[1]);
        if (altitude != 0.0d) {
            location.setAltitude(altitude);
        }
        if (attributeDouble != 0.0d) {
            char c2 = 65535;
            int hashCode = attribute2.hashCode();
            if (hashCode != 75) {
                if (hashCode != 77) {
                    if (hashCode == 78 && attribute2.equals("N")) {
                        c2 = 1;
                    }
                } else if (attribute2.equals("M")) {
                    c2 = 0;
                }
            } else if (attribute2.equals("K")) {
                c2 = 2;
            }
            if (c2 == 0) {
                metersPerSecond = Speed.fromMilesPerHour(attributeDouble).toMetersPerSecond();
            } else if (c2 != 1) {
                metersPerSecond = Speed.fromKilometersPerHour(attributeDouble).toMetersPerSecond();
            } else {
                metersPerSecond = Speed.fromKnots(attributeDouble).toMetersPerSecond();
            }
            location.setSpeed((float) metersPerSecond);
        }
        if (parseTimestamp != -1) {
            location.setTime(parseTimestamp);
        }
        return location;
    }

    public int getOrientation() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
    }

    public int getRotation() {
        switch (getOrientation()) {
            case 3:
            case 4:
                return 180;
            case 5:
                return 270;
            case 6:
            case 7:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public long getTimestamp() {
        long parseTimestamp = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_DATETIME_ORIGINAL));
        if (parseTimestamp == -1) {
            return -1L;
        }
        String attribute = this.mExifInterface.getAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL);
        if (attribute != null) {
            try {
                long parseLong = Long.parseLong(attribute);
                while (parseLong > 1000) {
                    parseLong /= 10;
                }
                return parseTimestamp + parseLong;
            } catch (NumberFormatException unused) {
                return parseTimestamp;
            }
        }
        return parseTimestamp;
    }

    public int getWidth() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0);
    }

    public boolean isFlippedHorizontally() {
        return getOrientation() == 2;
    }

    public boolean isFlippedVertically() {
        int orientation = getOrientation();
        return orientation == 4 || orientation == 5 || orientation == 7;
    }

    public void removeLocation() {
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_PROCESSING_METHOD, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_ALTITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_ALTITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_SPEED, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_SPEED_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_DATESTAMP, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_TIMESTAMP, null);
    }

    public void removeTimestamp() {
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_ORIGINAL, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_DIGITIZED, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, null);
        this.mRemoveTimestamp = true;
    }

    public void rotate(int i2) {
        if (i2 % 90 != 0) {
            Logger.w(TAG, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", Integer.valueOf(i2)));
            this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(0));
            return;
        }
        int i3 = i2 % 360;
        int orientation = getOrientation();
        while (i3 < 0) {
            i3 += 90;
            switch (orientation) {
                case 2:
                    orientation = 5;
                    break;
                case 3:
                case 8:
                    orientation = 6;
                    break;
                case 4:
                    orientation = 7;
                    break;
                case 5:
                    orientation = 4;
                    break;
                case 6:
                    orientation = 1;
                    break;
                case 7:
                    orientation = 2;
                    break;
                default:
                    orientation = 8;
                    break;
            }
        }
        while (i3 > 0) {
            i3 -= 90;
            switch (orientation) {
                case 2:
                    orientation = 7;
                    break;
                case 3:
                    orientation = 8;
                    break;
                case 4:
                    orientation = 5;
                    break;
                case 5:
                    orientation = 2;
                    break;
                case 6:
                    orientation = 3;
                    break;
                case 7:
                    orientation = 4;
                    break;
                case 8:
                    orientation = 1;
                    break;
                default:
                    orientation = 6;
                    break;
            }
        }
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(orientation));
    }

    public void save() throws IOException {
        if (!this.mRemoveTimestamp) {
            attachLastModifiedTimestamp();
        }
        this.mExifInterface.saveAttributes();
    }

    public void setDescription(@Nullable String str) {
        this.mExifInterface.setAttribute(ExifInterface.TAG_IMAGE_DESCRIPTION, str);
    }

    public void setOrientation(int i2) {
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i2));
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(getRotation()), Boolean.valueOf(isFlippedVertically()), Boolean.valueOf(isFlippedHorizontally()), getLocation(), Long.valueOf(getTimestamp()), getDescription());
    }

    private long parseTimestamp(@Nullable String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return convertFromExifDateTime(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }
}
