package com.tencent.qcloud.tuicore.util;

import android.os.Build;
import android.util.Log;

/* loaded from: classes3.dex */
public final class TUIBuild {
    private static String BOARD = "";
    private static String BRAND = "";
    private static String DEVICE = "";
    private static String HARDWARE = "";
    private static String MANUFACTURER = "";
    private static String MODEL = "";
    private static final String TAG = "TUIBuild";
    private static String VERSION = "";
    private static String VERSION_INCREMENTAL = "";
    private static int VERSION_INT;

    public static String getBoard() {
        String str = BOARD;
        if (str == null || str.isEmpty()) {
            synchronized (TUIBuild.class) {
                String str2 = BOARD;
                if (str2 == null || str2.isEmpty()) {
                    BOARD = Build.BOARD;
                    Log.i(TAG, "get BOARD by Build.BOARD :" + BOARD);
                }
            }
        }
        return BOARD;
    }

    public static String getBrand() {
        String str = BRAND;
        if (str == null || str.isEmpty()) {
            synchronized (TUIBuild.class) {
                String str2 = BRAND;
                if (str2 == null || str2.isEmpty()) {
                    BRAND = Build.BRAND;
                    Log.i(TAG, "get BRAND by Build.BRAND :" + BRAND);
                }
            }
        }
        return BRAND;
    }

    public static String getDevice() {
        String str = DEVICE;
        if (str == null || str.isEmpty()) {
            synchronized (TUIBuild.class) {
                String str2 = DEVICE;
                if (str2 == null || str2.isEmpty()) {
                    DEVICE = Build.DEVICE;
                    Log.i(TAG, "get DEVICE by Build.DEVICE :" + DEVICE);
                }
            }
        }
        return DEVICE;
    }

    public static String getHardware() {
        String str = HARDWARE;
        if (str == null || str.isEmpty()) {
            synchronized (TUIBuild.class) {
                String str2 = HARDWARE;
                if (str2 == null || str2.isEmpty()) {
                    HARDWARE = Build.HARDWARE;
                    Log.i(TAG, "get HARDWARE by Build.HARDWARE :" + HARDWARE);
                }
            }
        }
        return HARDWARE;
    }

    public static String getManufacturer() {
        String str = MANUFACTURER;
        if (str == null || str.isEmpty()) {
            synchronized (TUIBuild.class) {
                String str2 = MANUFACTURER;
                if (str2 == null || str2.isEmpty()) {
                    MANUFACTURER = Build.MANUFACTURER;
                    Log.i(TAG, "get MANUFACTURER by Build.MANUFACTURER :" + MANUFACTURER);
                }
            }
        }
        return MANUFACTURER;
    }

    public static String getModel() {
        String str = MODEL;
        if (str == null || str.isEmpty()) {
            synchronized (TUIBuild.class) {
                String str2 = MODEL;
                if (str2 == null || str2.isEmpty()) {
                    MODEL = Build.MODEL;
                    Log.i(TAG, "get MODEL by Build.MODEL :" + MODEL);
                }
            }
        }
        return MODEL;
    }

    public static String getVersion() {
        String str = VERSION;
        if (str == null || str.isEmpty()) {
            synchronized (TUIBuild.class) {
                String str2 = VERSION;
                if (str2 == null || str2.isEmpty()) {
                    VERSION = Build.VERSION.RELEASE;
                    Log.i(TAG, "get VERSION by Build.VERSION.RELEASE :" + VERSION);
                }
            }
        }
        return VERSION;
    }

    public static String getVersionIncremental() {
        String str = VERSION_INCREMENTAL;
        if (str == null || str.isEmpty()) {
            synchronized (TUIBuild.class) {
                String str2 = VERSION_INCREMENTAL;
                if (str2 == null || str2.isEmpty()) {
                    VERSION_INCREMENTAL = Build.VERSION.INCREMENTAL;
                    Log.i(TAG, "get VERSION_INCREMENTAL by Build.VERSION.INCREMENTAL :" + VERSION_INCREMENTAL);
                }
            }
        }
        return VERSION_INCREMENTAL;
    }

    public static int getVersionInt() {
        if (VERSION_INT == 0) {
            synchronized (TUIBuild.class) {
                if (VERSION_INT == 0) {
                    VERSION_INT = Build.VERSION.SDK_INT;
                    Log.i(TAG, "get VERSION_INT by Build.VERSION.SDK_INT :" + VERSION_INT);
                }
            }
        }
        return VERSION_INT;
    }

    public static void setBoard(String str) {
        synchronized (TUIBuild.class) {
            BOARD = str;
        }
    }

    public static void setBrand(String str) {
        synchronized (TUIBuild.class) {
            BRAND = str;
        }
    }

    public static void setDevice(String str) {
        synchronized (TUIBuild.class) {
            DEVICE = str;
        }
    }

    public static void setHardware(String str) {
        synchronized (TUIBuild.class) {
            HARDWARE = str;
        }
    }

    public static void setManufacturer(String str) {
        synchronized (TUIBuild.class) {
            MANUFACTURER = str;
        }
    }

    public static void setModel(String str) {
        synchronized (TUIBuild.class) {
            MODEL = str;
        }
    }

    public static void setVersion(String str) {
        synchronized (TUIBuild.class) {
            VERSION = str;
        }
    }

    public static void setVersionIncremental(String str) {
        synchronized (TUIBuild.class) {
            VERSION_INCREMENTAL = str;
        }
    }

    public static void setVersionInt(int i2) {
        synchronized (TUIBuild.class) {
            VERSION_INT = i2;
        }
    }
}
