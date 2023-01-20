package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.qiniu.android.common.Constants;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import e.t.u.b0;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes3.dex */
public class ab {
    private static Map<String, String> a;

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (y.a(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static byte[] b(byte[] bArr, int i2) {
        if (bArr == null) {
            return bArr;
        }
        y.c("[Util] Unzip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            af a2 = ae.a(2);
            if (a2 == null) {
                return null;
            }
            return a2.b(bArr);
        } catch (Throwable th) {
            if (th.getMessage() != null && th.getMessage().contains("Not in GZIP format")) {
                y.d(th.getMessage(), new Object[0]);
            } else if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] c(long j2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(j2);
            return sb.toString().getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean c(String str) {
        if (str == null || str.trim().length() <= 0) {
            return false;
        }
        if (str.length() > 255) {
            y.a("URL(%s)'s length is larger than 255.", str);
            return false;
        } else if (str.toLowerCase().startsWith("http")) {
            return true;
        } else {
            y.a("URL(%s) is not start with \"http\".", str);
            return false;
        }
    }

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String a(long j2) {
        try {
            return new SimpleDateFormat(b0.a.f14658i, Locale.US).format(new Date(j2));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000) * 86400000) - TimeZone.getDefault().getRawOffset();
        } catch (Throwable th) {
            if (y.a(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static String c(String str, String str2) {
        return (com.tencent.bugly.crashreport.common.info.a.b() == null || com.tencent.bugly.crashreport.common.info.a.b().E == null) ? "" : com.tencent.bugly.crashreport.common.info.a.b().E.getString(str, str2);
    }

    public static String a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(b0.a.f14658i, Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static byte[] a(File file, String str, String str2) {
        ZipOutputStream zipOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        if (str == null || str.length() == 0) {
            return null;
        }
        y.c("rqdp{  ZF start}", new Object[0]);
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
            byteArrayOutputStream = new ByteArrayOutputStream();
            zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            zipOutputStream = null;
        }
        try {
            zipOutputStream.setMethod(8);
            zipOutputStream.putNextEntry(new ZipEntry(str2));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
            zipOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                zipOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            y.c("rqdp{  ZF end}", new Object[0]);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                y.c("rqdp{  ZF end}", new Object[0]);
                return null;
            } catch (Throwable th3) {
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                y.c("rqdp{  ZF end}", new Object[0]);
                throw th3;
            }
        }
    }

    public static void b(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.isFile() && file.exists() && file.canWrite()) {
            file.delete();
        }
    }

    public static long b(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return Long.parseLong(new String(bArr, Constants.UTF_8));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList<String> arrayList = new ArrayList<>(size);
            ArrayList<String> arrayList2 = new ArrayList<>(size);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("keys", arrayList);
            bundle.putStringArrayList("values", arrayList2);
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static Map<String, String> b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList != null && stringArrayList2 != null && stringArrayList.size() == stringArrayList2.size()) {
            hashMap = new HashMap(stringArrayList.size());
            for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                hashMap.put(stringArrayList.get(i2), stringArrayList2.get(i2));
            }
        } else {
            y.e("map parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static byte[] a(byte[] bArr, int i2) {
        if (bArr == null) {
            return bArr;
        }
        y.c("[Util] Zip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            af a2 = ae.a(2);
            if (a2 == null) {
                return null;
            }
            return a2.a(bArr);
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Throwable th) {
            if (y.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static boolean b(Context context, String str) {
        y.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (file.delete()) {
                    y.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    return true;
                }
                return false;
            }
            return true;
        } catch (Throwable th) {
            y.a(th);
            return false;
        }
    }

    public static boolean a(File file, File file2, int i2) {
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        y.c("rqdp{  ZF start}", new Object[0]);
        if (a(file, file2)) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                } catch (Throwable th) {
                    th = th;
                    zipOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = null;
            }
            try {
                zipOutputStream.setMethod(8);
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                byte[] bArr = new byte[Math.max(5000, 1000)];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    zipOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                y.c("rqdp{  ZF end}", new Object[0]);
                return true;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                try {
                    if (!y.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    y.c("rqdp{  ZF end}", new Object[0]);
                    return false;
                } catch (Throwable th4) {
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    y.c("rqdp{  ZF end}", new Object[0]);
                    throw th4;
                }
            }
        }
        return false;
    }

    public static void b(String str, String str2) {
        if (com.tencent.bugly.crashreport.common.info.a.b() == null || com.tencent.bugly.crashreport.common.info.a.b().E == null) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.b().E.edit().putString(str, str2).apply();
    }

    private static boolean a(File file, File file2) {
        if (file != null && file2 != null && !file.equals(file2)) {
            if (file.exists() && file.canRead()) {
                try {
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                } catch (Throwable th) {
                    if (!y.a(th)) {
                        th.printStackTrace();
                    }
                }
                return file2.exists() && file2.canWrite();
            }
            y.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        }
        y.d("rqdp{  err ZF 1R!}", new Object[0]);
        return false;
    }

    private static ArrayList<String> a(Context context, String[] strArr) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        if (AppInfo.e(context)) {
            return new ArrayList<>(Arrays.asList("unknown(low memory)"));
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = null;
                }
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!y.a(th)) {
                            th.printStackTrace();
                        }
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
            }
            bufferedReader.close();
            try {
                bufferedReader2.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            bufferedReader2 = null;
        }
    }

    public static String a(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        if (a == null) {
            a = new HashMap();
            String str2 = "/system/bin/sh";
            ArrayList<String> a2 = a(context, new String[]{(new File("/system/bin/sh").exists() && new File("/system/bin/sh").canExecute()) ? "sh" : "sh", "-c", "getprop"});
            if (a2 != null && a2.size() > 0) {
                y.b(ab.class, "Successfully get 'getprop' list.", new Object[0]);
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                for (String str3 : a2) {
                    Matcher matcher = compile.matcher(str3);
                    if (matcher.find()) {
                        a.put(matcher.group(1), matcher.group(2));
                    }
                }
                y.b(ab.class, "Systems properties number: %d.", Integer.valueOf(a.size()));
            }
        }
        return a.containsKey(str) ? a.get(str) : "fail";
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static Context a(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, obj);
        } catch (Exception unused) {
        }
    }

    public static Object a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (Map.Entry<String, PlugInBean> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putInt("pluginNum", arrayList.size());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                bundle.putString("pluginKey" + i2, (String) arrayList.get(i2));
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                bundle.putString("pluginVal" + i3 + "plugInId", ((PlugInBean) arrayList2.get(i3)).a);
                bundle.putString("pluginVal" + i3 + "plugInUUID", ((PlugInBean) arrayList2.get(i3)).f6518c);
                bundle.putString("pluginVal" + i3 + "plugInVersion", ((PlugInBean) arrayList2.get(i3)).b);
            }
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i2 = 0; i2 < intValue; i2++) {
            arrayList.add(readBundle.getString("pluginKey" + i2));
        }
        for (int i3 = 0; i3 < intValue; i3++) {
            String string = readBundle.getString("pluginVal" + i3 + "plugInId");
            String string2 = readBundle.getString("pluginVal" + i3 + "plugInUUID");
            arrayList2.add(new PlugInBean(string, readBundle.getString("pluginVal" + i3 + "plugInVersion"), string2));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                hashMap.put(arrayList.get(i4), PlugInBean.class.cast(arrayList2.get(i4)));
            }
        } else {
            y.e("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            return creator.createFromParcel(obtain);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (obtain != null) {
                    obtain.recycle();
                    return null;
                }
                return null;
            } finally {
                if (obtain != null) {
                    obtain.recycle();
                }
            }
        }
    }

    public static String a(int i2, String str) {
        String[] strArr = str == null ? new String[]{"logcat", "-d", "-v", "threadtime"} : new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        Process process = null;
        StringBuilder sb = new StringBuilder();
        try {
            process = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
                if (i2 > 0 && sb.length() > i2) {
                    sb.delete(0, sb.length() - i2);
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                sb.append("\n[error:");
                sb.append(th.toString());
                sb.append("]");
                String sb2 = sb.toString();
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return sb2;
            } finally {
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            }
        }
    }

    public static Map<String, String> a(boolean z, int i2, boolean z2) {
        if (!z) {
            y.c("get all thread stack not enable", new Object[0]);
            return new HashMap();
        }
        Map<String, String> a2 = a(i2, false);
        return a2 == null ? new HashMap() : a2;
    }

    private static Map<String, String> a(int i2, boolean z) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            if (!z || id != entry.getKey().getId()) {
                int i3 = 0;
                sb.setLength(0);
                if (entry.getValue() != null && entry.getValue().length != 0) {
                    StackTraceElement[] value = entry.getValue();
                    int length = value.length;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        StackTraceElement stackTraceElement = value[i3];
                        if (i2 > 0 && sb.length() >= i2) {
                            sb.append("\n[Stack over limit size :" + i2 + " , has been cut!]");
                            break;
                        }
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                        i3++;
                    }
                    hashMap.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                }
            }
        }
        return hashMap;
    }

    public static String a(Thread thread) {
        if (thread == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static boolean a(Context context, String str, long j2) {
        y.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < com.heytap.mcssdk.constant.a.q) {
                    return false;
                }
                y.c("[Util] Lock file (%s) is expired, unlock it.", str);
                b(context, str);
            }
            if (file.createNewFile()) {
                y.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            y.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            y.a(th);
            return false;
        }
    }

    public static String a(File file, int i2, boolean z) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Constants.UTF_8));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                    if (i2 > 0 && sb.length() > i2) {
                        if (z) {
                            sb.delete(i2, sb.length());
                            break;
                        }
                        sb.delete(0, sb.length() - i2);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        y.a(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                y.a(e2);
                            }
                        }
                    }
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception e3) {
                y.a(e3);
            }
            return sb2;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    private static BufferedReader a(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), Constants.UTF_8));
            } catch (Throwable th) {
                y.a(th);
            }
        }
        return null;
    }

    public static BufferedReader a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists() && file.canRead()) {
                return a(file);
            }
            return null;
        } catch (NullPointerException e2) {
            y.a(e2);
            return null;
        }
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            y.e("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static boolean a(Runnable runnable) {
        if (runnable != null) {
            x a2 = x.a();
            if (a2 != null) {
                return a2.a(runnable);
            }
            String[] split = runnable.getClass().getName().split("\\.");
            return a(runnable, split[split.length - 1]) != null;
        }
        return false;
    }

    public static SharedPreferences a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }
}
