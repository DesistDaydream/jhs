package com.moor.imkf.lib.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.moor.imkf.lib.MoorBaseLibManager;
import com.moor.imkf.lib.constants.MoorPathConstants;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MoorLogUtils {
    public static final int A = 7;
    private static final String ARGS = "args";
    private static final String BOTTOM_BORDER = "╚═══════════════════════════════════════════════════════════════════════════════════════════════════";
    public static final int D = 3;
    public static final int E = 6;
    private static final int FILE = 16;
    public static final int I = 4;
    private static final int JSON = 32;
    private static final String LEFT_BORDER = "║ ";
    private static final int MAX_LEN = 4000;
    private static final String NULL = "null";
    private static final String SPLIT_BORDER = "╟───────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String TOP_BORDER = "╔═══════════════════════════════════════════════════════════════════════════════════════════════════";
    public static final int V = 2;
    public static final int W = 5;
    private static final int XML = 48;
    private static String sDefaultDir;
    private static String sDir;
    private static ExecutorService sExecutor;
    private static final char[] T = {'V', 'D', 'I', 'W', 'E', 'A'};
    private static String sFilePrefix = "util";
    private static boolean sLogSwitch = true;
    private static boolean sLog2ConsoleSwitch = true;
    private static String sGlobalTag = null;
    private static boolean sTagIsSpace = true;
    private static boolean sLogHeadSwitch = true;
    private static boolean sLog2FileSwitch = true;
    private static boolean sLogBorderSwitch = true;
    private static int sConsoleFilter = 2;
    private static int sFileFilter = 2;
    private static int sStackDeep = 1;
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String LINE_SEP = System.getProperty("line.separator");
    private static final Format FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
    private static final Config CONFIG = new Config();

    /* loaded from: classes2.dex */
    public static class Config {
        public Config setBorderSwitch(boolean z) {
            boolean unused = MoorLogUtils.sLogBorderSwitch = z;
            return this;
        }

        public Config setConsoleFilter(int i2) {
            int unused = MoorLogUtils.sConsoleFilter = i2;
            return this;
        }

        public Config setConsoleSwitch(boolean z) {
            boolean unused = MoorLogUtils.sLog2ConsoleSwitch = z;
            return this;
        }

        public Config setDir(String str) {
            if (MoorLogUtils.isSpace(str)) {
                String unused = MoorLogUtils.sDir = null;
            } else {
                if (!str.endsWith(MoorLogUtils.FILE_SEP)) {
                    str = str + MoorLogUtils.FILE_SEP;
                }
                String unused2 = MoorLogUtils.sDir = str;
            }
            return this;
        }

        public Config setFileFilter(int i2) {
            int unused = MoorLogUtils.sFileFilter = i2;
            return this;
        }

        public Config setFilePrefix(String str) {
            if (MoorLogUtils.isSpace(str)) {
                String unused = MoorLogUtils.sFilePrefix = "util";
            } else {
                String unused2 = MoorLogUtils.sFilePrefix = str;
            }
            return this;
        }

        public Config setGlobalTag(String str) {
            if (MoorLogUtils.isSpace(str)) {
                String unused = MoorLogUtils.sGlobalTag = "";
                boolean unused2 = MoorLogUtils.sTagIsSpace = true;
            } else {
                String unused3 = MoorLogUtils.sGlobalTag = str;
                boolean unused4 = MoorLogUtils.sTagIsSpace = false;
            }
            return this;
        }

        public Config setLog2FileSwitch(boolean z) {
            boolean unused = MoorLogUtils.sLog2FileSwitch = z;
            return this;
        }

        public Config setLogHeadSwitch(boolean z) {
            boolean unused = MoorLogUtils.sLogHeadSwitch = z;
            return this;
        }

        public Config setLogSwitch(boolean z) {
            boolean unused = MoorLogUtils.sLogSwitch = z;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("switch: ");
            sb.append(MoorLogUtils.sLogSwitch);
            sb.append(MoorLogUtils.LINE_SEP);
            sb.append("console: ");
            sb.append(MoorLogUtils.sLog2ConsoleSwitch);
            sb.append(MoorLogUtils.LINE_SEP);
            sb.append("tag: ");
            sb.append(MoorLogUtils.sTagIsSpace ? MoorLogUtils.NULL : MoorLogUtils.sGlobalTag);
            sb.append(MoorLogUtils.LINE_SEP);
            sb.append("head: ");
            sb.append(MoorLogUtils.sLogHeadSwitch);
            sb.append(MoorLogUtils.LINE_SEP);
            sb.append("file: ");
            sb.append(MoorLogUtils.sLog2FileSwitch);
            sb.append(MoorLogUtils.LINE_SEP);
            sb.append("dir: ");
            sb.append(MoorLogUtils.sDir == null ? MoorLogUtils.sDefaultDir : MoorLogUtils.sDir);
            sb.append(MoorLogUtils.LINE_SEP);
            sb.append("filePrefix");
            sb.append(MoorLogUtils.sFilePrefix);
            sb.append(MoorLogUtils.LINE_SEP);
            sb.append("border: ");
            sb.append(MoorLogUtils.sLogBorderSwitch);
            sb.append(MoorLogUtils.LINE_SEP);
            sb.append("consoleFilter: ");
            sb.append(MoorLogUtils.T[MoorLogUtils.sConsoleFilter - 2]);
            sb.append(MoorLogUtils.LINE_SEP);
            sb.append("fileFilter: ");
            sb.append(MoorLogUtils.T[MoorLogUtils.sFileFilter - 2]);
            sb.append(MoorLogUtils.LINE_SEP);
            sb.append("stackDeep: ");
            sb.append(MoorLogUtils.sStackDeep);
            return sb.toString();
        }

        private Config() {
            if (MoorLogUtils.sDefaultDir != null) {
                return;
            }
            String unused = MoorLogUtils.sDefaultDir = MoorPathConstants.getStoragePath(MoorPathConstants.PATH_NAME_MOOR_LOG);
        }

        public Config setDir(File file) {
            String str;
            if (file == null) {
                str = null;
            } else {
                str = file.getAbsolutePath() + MoorLogUtils.FILE_SEP;
            }
            String unused = MoorLogUtils.sDir = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class TagHead {
        public String[] consoleHead;
        public String fileHead;
        public String tag;

        public TagHead(String str, String[] strArr, String str2) {
            this.tag = str;
            this.consoleHead = strArr;
            this.fileHead = str2;
        }
    }

    public static void a(Object... objArr) {
        log(7, sGlobalTag, objArr);
    }

    public static void aTag(String str, Object... objArr) {
        log(7, str, objArr);
    }

    private static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean createOrExistsFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (createOrExistsDir(file.getParentFile())) {
            try {
                boolean createNewFile = file.createNewFile();
                printDeviceInfo(str);
                return createNewFile;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static void d(Object... objArr) {
        log(3, sGlobalTag, objArr);
    }

    public static void dTag(String str, Object... objArr) {
        log(3, str, objArr);
    }

    public static void e(Object... objArr) {
        log(6, sGlobalTag, objArr);
    }

    public static void eTag(String str, Object... objArr) {
        log(6, str, objArr);
    }

    private static void execute(Runnable runnable) {
        if (sExecutor == null) {
            sExecutor = Executors.newSingleThreadExecutor();
        }
        sExecutor.execute(runnable);
    }

    private static String formatJson(String str) {
        try {
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public static Config getConfig() {
        return CONFIG;
    }

    public static void i(Object... objArr) {
        log(4, sGlobalTag, objArr);
    }

    public static void iTag(String str, Object... objArr) {
        log(4, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static void json(String str) {
        log(35, sGlobalTag, str);
    }

    private static void log(int i2, String str, Object... objArr) {
        if (sLogSwitch) {
            if (sLog2ConsoleSwitch || sLog2FileSwitch) {
                int i3 = i2 & 15;
                int i4 = i2 & 240;
                if (i3 >= sConsoleFilter || i3 >= sFileFilter) {
                    TagHead processTagAndHead = processTagAndHead(str);
                    String processBody = processBody(i4, objArr);
                    if (sLog2ConsoleSwitch && i3 >= sConsoleFilter && i4 != 16) {
                        print2Console(i3, processTagAndHead.tag, processTagAndHead.consoleHead, processBody);
                    }
                    if ((sLog2FileSwitch || i4 == 16) && i3 >= sFileFilter) {
                        String str2 = processTagAndHead.tag;
                        print2File(i3, str2, processTagAndHead.fileHead + processBody);
                    }
                }
            }
        }
    }

    private static void print2Console(int i2, String str, String[] strArr, String str2) {
        printBorder(i2, str, true);
        printHead(i2, str, strArr);
        printMsg(i2, str, str2);
        printBorder(i2, str, false);
    }

    private static void print2File(int i2, final String str, String str2) {
        String format = FORMAT.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        StringBuilder sb = new StringBuilder();
        String str3 = sDir;
        if (str3 == null) {
            str3 = sDefaultDir;
        }
        sb.append(str3);
        sb.append(sFilePrefix);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb.append(substring);
        sb.append(".txt");
        final String sb2 = sb.toString();
        if (!createOrExistsFile(sb2)) {
            Log.e(str, "log to " + sb2 + " failed!");
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(substring2);
        sb3.append(T[i2 - 2]);
        sb3.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        sb3.append(str);
        String str4 = LINE_SEP;
        sb3.append(str4);
        sb3.append("LOG--START-->>");
        sb3.append(str4);
        sb3.append(str2);
        sb3.append(str4);
        sb3.append("<<--STOP--LOG");
        sb3.append(str4);
        final String sb4 = sb3.toString();
        execute(new Runnable() { // from class: com.moor.imkf.lib.utils.MoorLogUtils.1
            @Override // java.lang.Runnable
            public void run() {
                BufferedWriter bufferedWriter;
                IOException e2;
                try {
                    try {
                        try {
                            bufferedWriter = new BufferedWriter(new FileWriter(sb2, true));
                        } catch (IOException e3) {
                            bufferedWriter = null;
                            e2 = e3;
                        } catch (Throwable th) {
                            bufferedWriter = null;
                            th = th;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            bufferedWriter.write(sb4);
                            bufferedWriter.close();
                        } catch (IOException e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            Log.e(str, "log to " + sb2 + " failed!");
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                        }
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    private static void printBorder(int i2, String str, boolean z) {
        if (sLogBorderSwitch) {
            Log.println(i2, str, z ? TOP_BORDER : BOTTOM_BORDER);
        }
    }

    private static void printDeviceInfo(final String str) {
        String str2 = "";
        int i2 = 0;
        try {
            PackageInfo packageInfo = MoorBaseLibManager.getInstance().getApplication().getPackageManager().getPackageInfo(MoorBaseLibManager.getInstance().getApplication().getPackageName(), 0);
            if (packageInfo != null) {
                str2 = packageInfo.versionName;
                i2 = packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        final String str3 = "\n************* Log Head ****************\nDevice Manufacturer: " + Build.MANUFACTURER + "\nDevice Model       : " + Build.MODEL + "\nAndroid Version    : " + Build.VERSION.RELEASE + "\nAndroid SDK        : " + Build.VERSION.SDK_INT + "\nApp VersionName    : " + str2 + "\nApp VersionCode    : " + i2 + "\n************* Log Head ****************\n\n";
        execute(new Runnable() { // from class: com.moor.imkf.lib.utils.MoorLogUtils.2
            /* JADX WARN: Removed duplicated region for block: B:29:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r6 = this;
                    r0 = 0
                    java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
                    java.io.FileWriter r2 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
                    java.lang.String r3 = r1     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
                    r4 = 1
                    r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
                    java.lang.String r0 = r2     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L30
                    r1.write(r0)     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L30
                    r1.close()     // Catch: java.io.IOException -> L2b
                    goto L2f
                L17:
                    r0 = move-exception
                    goto L22
                L19:
                    r1 = move-exception
                    r5 = r1
                    r1 = r0
                    r0 = r5
                    goto L31
                L1e:
                    r1 = move-exception
                    r5 = r1
                    r1 = r0
                    r0 = r5
                L22:
                    r0.printStackTrace()     // Catch: java.lang.Throwable -> L30
                    if (r1 == 0) goto L2f
                    r1.close()     // Catch: java.io.IOException -> L2b
                    goto L2f
                L2b:
                    r0 = move-exception
                    r0.printStackTrace()
                L2f:
                    return
                L30:
                    r0 = move-exception
                L31:
                    if (r1 == 0) goto L3b
                    r1.close()     // Catch: java.io.IOException -> L37
                    goto L3b
                L37:
                    r1 = move-exception
                    r1.printStackTrace()
                L3b:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.utils.MoorLogUtils.AnonymousClass2.run():void");
            }
        });
    }

    private static void printHead(int i2, String str, String[] strArr) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (sLogBorderSwitch) {
                    str2 = LEFT_BORDER + str2;
                }
                Log.println(i2, str, str2);
            }
            if (sLogBorderSwitch) {
                Log.println(i2, str, SPLIT_BORDER);
            }
        }
    }

    private static void printMsg(int i2, String str, String str2) {
        int length = str2.length();
        int i3 = length / MAX_LEN;
        if (i3 <= 0) {
            printSubMsg(i2, str, str2);
            return;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + MAX_LEN;
            printSubMsg(i2, str, str2.substring(i5, i6));
            i4++;
            i5 = i6;
        }
        if (i5 != length) {
            printSubMsg(i2, str, str2.substring(i5, length));
        }
    }

    private static void printSubMsg(int i2, String str, String str2) {
        String[] split;
        if (!sLogBorderSwitch) {
            Log.println(i2, str, str2);
            return;
        }
        for (String str3 : str2.split(LINE_SEP)) {
            Log.println(i2, str, LEFT_BORDER + str3);
        }
    }

    private static String processBody(int i2, Object... objArr) {
        String str = NULL;
        if (objArr != null) {
            if (objArr.length == 1) {
                Object obj = objArr[0];
                if (obj != null) {
                    str = obj.toString();
                }
                return i2 == 32 ? formatJson(str) : str;
            }
            StringBuilder sb = new StringBuilder();
            int length = objArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                Object obj2 = objArr[i3];
                sb.append(ARGS);
                sb.append("[");
                sb.append(i3);
                sb.append("]");
                sb.append(" = ");
                sb.append(obj2 == null ? NULL : obj2.toString());
                sb.append(LINE_SEP);
            }
            return sb.toString();
        }
        return NULL;
    }

    private static TagHead processTagAndHead(String str) {
        String str2;
        String substring;
        String str3;
        String name;
        if (!sTagIsSpace && !sLogHeadSwitch) {
            str3 = sGlobalTag;
        } else {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StackTraceElement stackTraceElement = stackTrace[3];
            String fileName = stackTraceElement.getFileName();
            if (fileName == null) {
                substring = stackTraceElement.getClassName();
                String[] split = substring.split("\\.");
                if (split.length > 0) {
                    substring = split[split.length - 1];
                }
                int indexOf = substring.indexOf(36);
                if (indexOf != -1) {
                    substring = substring.substring(0, indexOf);
                }
                str2 = substring + ".java";
            } else {
                int indexOf2 = fileName.indexOf(46);
                str2 = fileName;
                substring = indexOf2 == -1 ? fileName : fileName.substring(0, indexOf2);
            }
            if (!sTagIsSpace || !isSpace(str)) {
                substring = str;
            }
            if (sLogHeadSwitch) {
                String formatter = new Formatter().format("%s, %s(%s:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), str2, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                String str4 = " [" + formatter + "]: ";
                int i2 = sStackDeep;
                if (i2 <= 1) {
                    return new TagHead(substring, new String[]{formatter}, str4);
                }
                int min = Math.min(i2, stackTrace.length - 3);
                String[] strArr = new String[min];
                strArr[0] = formatter;
                String formatter2 = new Formatter().format("%" + (name.length() + 2) + "s", "").toString();
                for (int i3 = 1; i3 < min; i3++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i3 + 3];
                    strArr[i3] = new Formatter().format("%s%s(%s:%d)", formatter2, stackTraceElement2.getMethodName(), stackTraceElement2.getFileName(), Integer.valueOf(stackTraceElement2.getLineNumber())).toString();
                }
                return new TagHead(substring, strArr, str4);
            }
            str3 = substring;
        }
        return new TagHead(str3, null, ": ");
    }

    public static void v(Object... objArr) {
        log(2, sGlobalTag, objArr);
    }

    public static void vTag(String str, Object... objArr) {
        log(2, str, objArr);
    }

    public static void w(Object... objArr) {
        log(5, sGlobalTag, objArr);
    }

    public static void wTag(String str, Object... objArr) {
        log(5, str, objArr);
    }

    public static void json(int i2, String str) {
        log(i2 | 32, sGlobalTag, str);
    }

    public static void json(String str, String str2) {
        log(35, str, str2);
    }

    public static void json(int i2, String str, String str2) {
        log(i2 | 32, str, str2);
    }
}
