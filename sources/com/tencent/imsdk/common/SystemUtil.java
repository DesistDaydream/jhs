package com.tencent.imsdk.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.qq.e.comm.constants.ErrorCode;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public class SystemUtil {
    private static final String DEVICE_ID = "DeviceID";
    private static final String DEVICE_INFO = "DeviceInfo";
    private static final String TAG = "SystemUtil";
    private static final int TIME_INTERVAL = 15000;
    private static String buildBrand = "";
    private static String buildManufacturer = "";
    private static String buildModel = "";
    private static String buildVersionRelease = "";
    private static int buildVersionSDKInt = 0;
    private static float lastAppCpu = 0.0f;
    private static long lastAppCpuTime = 0;
    private static long lastMemCheckTimeStamps = 0;
    private static int lastMemUsage = 0;
    private static float lastSysCpu = 0.0f;
    private static long lastSysCpuTime = 0;
    private static boolean mFirstTimeRun = true;
    private static CpuUsageMeasurer sCpuUsageMeasurer = null;
    private static boolean sIsLoadLibrarySuccess = false;
    private static boolean sRunningMemCheck = false;

    public static float getAppCpuUsage() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastAppCpuTime < 15000) {
            return lastAppCpu;
        }
        float f2 = (getProcessCPURate()[0] / 10) / 100.0f;
        lastAppCpu = f2;
        lastAppCpuTime = currentTimeMillis;
        return f2;
    }

    public static float getAppMemory() {
        int i2;
        final long currentTimeMillis = System.currentTimeMillis();
        if (!sRunningMemCheck) {
            long j2 = lastMemCheckTimeStamps;
            if (j2 == 0 || currentTimeMillis - j2 >= 15000) {
                sRunningMemCheck = true;
                AsyncTask.execute(new Runnable() { // from class: com.tencent.imsdk.common.SystemUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        System.currentTimeMillis();
                        boolean unused = SystemUtil.sRunningMemCheck = false;
                        try {
                            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                            Debug.getMemoryInfo(memoryInfo);
                            int totalPss = memoryInfo.getTotalPss();
                            long unused2 = SystemUtil.lastMemCheckTimeStamps = currentTimeMillis;
                            int unused3 = SystemUtil.lastMemUsage = totalPss / 1024;
                        } catch (Exception unused4) {
                        }
                    }
                });
                i2 = lastMemUsage;
                return i2;
            }
        }
        i2 = lastMemUsage;
        return i2;
    }

    private static String getBuildBrand() {
        if (TextUtils.isEmpty(buildBrand)) {
            buildBrand = Build.BRAND;
        }
        return buildBrand;
    }

    private static String getBuildManufacturer() {
        if (TextUtils.isEmpty(buildManufacturer)) {
            buildManufacturer = Build.MANUFACTURER;
        }
        return buildManufacturer;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDeviceID() {
        /*
            com.tencent.imsdk.common.IMContext r0 = com.tencent.imsdk.common.IMContext.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = ""
            if (r0 != 0) goto Ld
            return r1
        Ld:
            java.lang.String r2 = "DeviceInfo"
            r3 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r3)
            java.lang.String r2 = "DeviceID"
            boolean r4 = r0.contains(r2)
            r5 = 1
            if (r4 != 0) goto L27
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
        L25:
            r3 = 1
            goto L42
        L27:
            java.lang.String r1 = r0.getString(r2, r1)
            java.lang.String r4 = "\\w{8}(-\\w{4}){3}-\\w{12}"
            boolean r4 = java.util.regex.Pattern.matches(r4, r1)
            if (r4 == 0) goto L39
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L42
        L39:
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            goto L25
        L42:
            if (r3 == 0) goto L4e
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putString(r2, r1)
            r0.apply()
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.common.SystemUtil.getDeviceID():java.lang.String");
    }

    public static String getDeviceType() {
        if (TextUtils.isEmpty(buildModel)) {
            buildModel = Build.MODEL;
        }
        return buildModel;
    }

    public static int getInstanceType() {
        if (isBrandXiaoMi()) {
            return 2000;
        }
        if (isBrandHuawei()) {
            return ErrorCode.INIT_ERROR;
        }
        if (isBrandMeizu()) {
            return 2003;
        }
        return isBrandOppo() ? PushConstants.NOTIFICATION_SERVICE_SEND_MESSAGE_ERROR : isBrandVivo() ? PushConstants.NOTIFICATION_SERVICE_SEND_MESSAGE_BROADCAST : ErrorCode.INNER_ERROR;
    }

    public static int[] getProcessCPURate() {
        if (sCpuUsageMeasurer == null) {
            sCpuUsageMeasurer = new CpuUsageMeasurer();
        }
        if (mFirstTimeRun) {
            mFirstTimeRun = false;
            sCpuUsageMeasurer.getCpuUsage();
            return new int[]{0, 0};
        }
        return sCpuUsageMeasurer.getCpuUsage();
    }

    public static String getSDKInitPath() {
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        String file = applicationContext.getFilesDir().toString();
        String str = TAG;
        IMLog.v(str, "SDK Init Path: " + file);
        return file;
    }

    public static String getSDKLogPath() {
        String sb;
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        File externalFilesDir = applicationContext.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            sb = "/sdcard/Android/data/" + applicationContext.getPackageName() + "/log/tencent/imsdk";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(externalFilesDir.getAbsolutePath());
            String str = File.separator;
            sb2.append(str);
            sb2.append("log");
            sb2.append(str);
            sb2.append("tencent");
            sb2.append(str);
            sb2.append("imsdk");
            sb = sb2.toString();
        }
        File file = new File(sb);
        if (!file.exists() && !file.mkdirs()) {
            file = applicationContext.getFilesDir();
            IMLog.e(TAG, "create log folder failed");
        }
        String str2 = file.getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR;
        IMLog.v(TAG, "SDK LOG Path: " + str2);
        return str2;
    }

    public static int getSDKVersion() {
        if (buildVersionSDKInt == 0) {
            buildVersionSDKInt = Build.VERSION.SDK_INT;
        }
        return buildVersionSDKInt;
    }

    public static float getSysCpuUsage() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastSysCpuTime < 15000) {
            return lastSysCpu;
        }
        float f2 = (getProcessCPURate()[1] / 10) / 100.0f;
        lastSysCpu = f2;
        lastSysCpuTime = currentTimeMillis;
        return f2;
    }

    public static String getSystemVersion() {
        if (TextUtils.isEmpty(buildVersionRelease)) {
            buildVersionRelease = Build.VERSION.RELEASE;
        }
        return buildVersionRelease;
    }

    public static boolean isBrandHuawei() {
        return "huawei".equalsIgnoreCase(getBuildBrand()) || "huawei".equalsIgnoreCase(getBuildManufacturer()) || "honor".equalsIgnoreCase(getBuildBrand()) || "honor".equalsIgnoreCase(getBuildManufacturer());
    }

    public static boolean isBrandMeizu() {
        return "meizu".equalsIgnoreCase(getBuildBrand()) || "meizu".equalsIgnoreCase(getBuildManufacturer());
    }

    public static boolean isBrandOppo() {
        return "oppo".equalsIgnoreCase(getBuildBrand()) || "oppo".equalsIgnoreCase(getBuildManufacturer()) || "realme".equalsIgnoreCase(getBuildBrand()) || "realme".equalsIgnoreCase(getBuildManufacturer()) || "oneplus".equalsIgnoreCase(getBuildBrand()) || "oneplus".equalsIgnoreCase(getBuildManufacturer());
    }

    public static boolean isBrandVivo() {
        return "vivo".equalsIgnoreCase(getBuildBrand()) || "vivo".equalsIgnoreCase(getBuildManufacturer());
    }

    public static boolean isBrandXiaoMi() {
        return "xiaomi".equalsIgnoreCase(getBuildBrand()) || "xiaomi".equalsIgnoreCase(getBuildManufacturer());
    }

    public static boolean isLibraryLoaded() {
        return sIsLoadLibrarySuccess;
    }

    public static boolean loadIMLibrary() {
        return loadIMLibrary(null);
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void setBuildBrand(String str) {
        buildBrand = str;
    }

    public static void setBuildManufacturer(String str) {
        buildManufacturer = str;
    }

    public static void setBuildModel(String str) {
        buildModel = str;
    }

    public static void setBuildVersionRelease(String str) {
        buildVersionRelease = str;
    }

    public static void setBuildVersionSDKInt(int i2) {
        buildVersionSDKInt = i2;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static boolean loadIMLibrary(String str) {
        if (sIsLoadLibrarySuccess) {
            return true;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = str + File.separator + "libImSDK.so";
                System.load(str2);
                sIsLoadLibrarySuccess = true;
                Log.i(TAG, "system load so library success: " + str2);
            } else {
                System.loadLibrary("ImSDK");
                sIsLoadLibrarySuccess = true;
                Log.i(TAG, "system load so library success, libImSDK.so");
            }
        } catch (Exception e2) {
            sIsLoadLibrarySuccess = false;
            Log.e(TAG, "system load so library failed, " + e2.getMessage());
        } catch (UnsatisfiedLinkError e3) {
            sIsLoadLibrarySuccess = false;
            Log.e(TAG, "system load so library failed, " + e3.getMessage());
        }
        return sIsLoadLibrarySuccess;
    }
}
