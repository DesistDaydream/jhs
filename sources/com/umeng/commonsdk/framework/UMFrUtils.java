package com.umeng.commonsdk.framework;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class UMFrUtils {
    private static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static String mDefaultEnvelopeDir = "envelope";
    private static String mDefaultEnvelopeDirPath = null;
    private static Object mEnvelopeBuildTimeLock = new Object();
    private static Object mEnvelopeFileLock = new Object();
    private static String sCurrentProcessName = "";

    private static boolean checkPermission(Context context, String str) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                        return false;
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(applicationContext, th);
                    return false;
                }
            } else {
                try {
                    if (applicationContext.getPackageManager().checkPermission(str, applicationContext.getPackageName()) != 0) {
                        return false;
                    }
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(applicationContext, th2);
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static int envelopeFileNumber(Context context) {
        String[] list;
        if (context != null) {
            try {
                File file = new File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    if (file.isDirectory() && (list = file.list()) != null) {
                        return list.length;
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
        return 0;
    }

    public static String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            try {
                String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
                if (TextUtils.isEmpty(processName)) {
                    int myPid = Process.myPid();
                    String processName2 = getProcessName(myPid);
                    if (!TextUtils.isEmpty(processName2)) {
                        sCurrentProcessName = processName2;
                    } else {
                        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next.pid == myPid) {
                                    sCurrentProcessName = next.processName;
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    sCurrentProcessName = processName;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context.getApplicationContext(), th);
            }
        }
        return sCurrentProcessName;
    }

    private static long getDistanceDays(long j2, long j3) {
        return (j2 < j3 ? j3 - j2 : j2 - j3) / 86400000;
    }

    public static String getEnvelopeDirPath(Context context) {
        String str;
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + File.separator + "." + mDefaultEnvelopeDir;
                }
                File file = new File(mDefaultEnvelopeDirPath);
                if (!file.exists() && !file.mkdir()) {
                    ULog.d("--->>> Create Envelope Directory failed!!!");
                }
                str = mDefaultEnvelopeDirPath;
            }
        }
        return str;
    }

    public static File getEnvelopeFile(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.2
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        int i2 = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                        if (i2 > 0) {
                            return 1;
                        }
                        return i2 == 0 ? 0 : -1;
                    }
                });
                return listFiles[0];
            }
            return null;
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        long j2;
        synchronized (mEnvelopeBuildTimeLock) {
            j2 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0L);
        }
        return j2;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j2;
        synchronized (mEnvelopeBuildTimeLock) {
            j2 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0L);
        }
        return j2;
    }

    public static String getLegacyEnvelopeDir(Context context) {
        try {
            String currentProcessName = getCurrentProcessName(context);
            if (!TextUtils.isEmpty(currentProcessName)) {
                String replace = currentProcessName.replace(':', '_');
                ULog.d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                return replace;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return mDefaultEnvelopeDir;
    }

    private static String getProcessName(int i2) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i2 + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                return readLine;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static String getSubProcessName(Context context) {
        String str;
        str = "";
        try {
            String currentProcessName = getCurrentProcessName(context);
            int indexOf = currentProcessName.indexOf(Constants.COLON_SEPARATOR);
            str = indexOf >= 0 ? currentProcessName.substring(indexOf + 1) : "";
            if (indexOf < 0) {
                String packageName = context.getPackageName();
                return currentProcessName.length() > packageName.length() ? currentProcessName.substring(packageName.length() + 1, currentProcessName.length()) : currentProcessName;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
        }
        return str;
    }

    public static boolean hasEnvelopeFile(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        String str = am.av;
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_INTERNAL) {
            str = "i";
        }
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_ZeroEnv) {
            str = am.aD;
        }
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_Silent) {
            str = "h";
        }
        String envelopeDirPath = getEnvelopeDirPath(context);
        if (envelopeDirPath != null) {
            File file = new File(envelopeDirPath);
            synchronized (mEnvelopeFileLock) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (file2.getName().startsWith(str)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return false;
        }
    }

    public static boolean removeEnvelopeFile(File file) {
        UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            if (file != null) {
                if (file.exists()) {
                    return file.delete();
                }
            }
            return true;
        }
    }

    public static void removeRedundantEnvelopeFiles(Context context, int i2) {
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > i2) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.1
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        int i3 = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                        if (i3 > 0) {
                            return 1;
                        }
                        return i3 == 0 ? 0 : -1;
                    }
                });
                if (listFiles.length > i2) {
                    for (int i3 = 0; i3 < listFiles.length - i2; i3++) {
                        if (!listFiles[i3].delete()) {
                            ULog.d("--->>> remove [" + i3 + "] file fail.");
                        }
                    }
                }
            }
        }
    }

    public static int saveEnvelopeFile(Context context, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (bArr == null) {
            return 101;
        }
        File file = new File(getEnvelopeDirPath(context) + File.separator + str);
        synchronized (mEnvelopeFileLock) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    boolean a = com.umeng.commonsdk.statistics.internal.a.a(context).a(str);
                    boolean b = com.umeng.commonsdk.statistics.internal.a.a(context).b(str);
                    if (a) {
                        updateLastSuccessfulBuildTime(context);
                    }
                    if (b) {
                        updateLastInstantBuildTime(context);
                    }
                    return 0;
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    UMCrashManager.reportCrash(context, e);
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    return 101;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        }
    }

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        if (context == null) {
            return;
        }
        try {
            String legacyEnvelopeDir = getLegacyEnvelopeDir(context);
            if (TextUtils.isEmpty(legacyEnvelopeDir) || legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
                return;
            }
            File file = new File(context.getFilesDir().getAbsolutePath() + "/." + legacyEnvelopeDir);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    String envelopeDirPath = getEnvelopeDirPath(context);
                    for (int i2 = 0; i2 < listFiles.length; i2++) {
                        File file2 = listFiles[i2];
                        file2.renameTo(new File(envelopeDirPath + File.separator + listFiles[i2].getName()));
                    }
                    if (file.isDirectory()) {
                        file.delete();
                    }
                } else if (file.isDirectory()) {
                    file.delete();
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static byte[] toByteArray(String str) throws IOException {
        byte[] bArr;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            try {
                try {
                    FileChannel channel = new RandomAccessFile(str, "r").getChannel();
                    MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                    bArr = new byte[(int) channel.size()];
                    if (load.remaining() > 0) {
                        load.get(bArr, 0, load.remaining());
                    }
                    channel.close();
                }
            } catch (IOException e2) {
                UMCrashManager.reportCrash(appContext, e2);
                throw e2;
            }
        }
        return bArr;
    }

    private static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }
}
