package com.bytedance.pangle.c;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {
    private static String a;
    private static Map<String, Integer> b;

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put("arm64-v8a", 64);
        b.put("armeabi-v7a", 32);
        b.put("armeabi", 32);
        b.put("x86_64", 64);
        b.put("x86", 32);
        b.put("mips64", 64);
        b.put("mips", 32);
        a = c();
    }

    public static void a(File file, File file2, String str) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        LinkedList<ZipEntry> linkedList = null;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Map<String, List<ZipEntry>> a2 = a(zipFile);
            boolean a3 = a(a2, a);
            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + a3 + "], pkg=" + str);
            if (a3) {
                if (!a2.isEmpty()) {
                    linkedList = new LinkedList();
                    HashSet hashSet = new HashSet();
                    String str2 = a;
                    char c2 = 65535;
                    switch (str2.hashCode()) {
                        case -1073971299:
                            if (str2.equals("mips64")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case -806050265:
                            if (str2.equals("x86_64")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case -738963905:
                            if (str2.equals("armeabi")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 117110:
                            if (str2.equals("x86")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 3351711:
                            if (str2.equals("mips")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case 145444210:
                            if (str2.equals("armeabi-v7a")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1431565292:
                            if (str2.equals("arm64-v8a")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            a(a2, "arm64-v8a", linkedList, hashSet);
                            break;
                        case 1:
                            a(a2, "armeabi-v7a", linkedList, hashSet);
                            a(a2, "armeabi", linkedList, hashSet);
                            break;
                        case 2:
                            a(a2, "armeabi", linkedList, hashSet);
                            a(a2, "armeabi-v7a", linkedList, hashSet);
                            break;
                        case 3:
                            a(a2, "x86_64", linkedList, hashSet);
                            break;
                        case 4:
                            a(a2, "x86", linkedList, hashSet);
                            break;
                        case 5:
                            a(a2, "mips64", linkedList, hashSet);
                            break;
                        case 6:
                            a(a2, "mips", linkedList, hashSet);
                            break;
                    }
                }
                if (linkedList != null && !linkedList.isEmpty()) {
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    for (ZipEntry zipEntry : linkedList) {
                        a(zipFile, zipEntry, file2);
                    }
                }
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copyNativeLib, supportedSoEntries empty, pkg=".concat(String.valueOf(str)));
                zipFile.close();
                return;
            }
            zipFile.close();
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                zipFile2.close();
            }
            throw th;
        }
    }

    public static int b() {
        return b.get(a()).intValue();
    }

    private static String c() {
        JSONObject d2 = d();
        String a2 = a(d2);
        return a2 == null ? b(d2) : a2;
    }

    private static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", "0");
            jSONObject.put("processMode", "0");
            jSONObject.put("supportedABI0", "0");
            jSONObject.put("matchCpuAbi", "0");
            jSONObject.put("defaultABI0", "0");
            jSONObject.put("defaultABI", "0");
            jSONObject.put("autoError", "0");
            jSONObject.put("manualError", "0");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static String b(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            ZipFile zipFile = new ZipFile(new File(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(a(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            strArr = i.a() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
            a(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            a(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                a(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (i.a()) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            a(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        String str2 = Build.CPU_ABI;
        a(jSONObject, "defaultABI", str2);
        return str2;
    }

    private static Map<String, List<ZipEntry>> a(ZipFile zipFile) {
        String[] split;
        HashMap hashMap = new HashMap();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && !nextElement.getName().contains("../") && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                String str = split[split.length - 2];
                if (b.containsKey(str)) {
                    if (hashMap.get(str) == null) {
                        hashMap.put(str, new LinkedList());
                    }
                    ((List) hashMap.get(str)).add(nextElement);
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
        return hashMap;
    }

    public static boolean b(File file) {
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory() && compile.matcher(nextElement.getName()).matches()) {
                            try {
                                zipFile2.close();
                                return true;
                            } catch (IOException unused) {
                                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException unused2) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                    }
                    return false;
                } catch (IOException e2) {
                    e = e2;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused4) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
        List<ZipEntry> list2 = map.get(str);
        if (list2 == null || list2.size() == 0) {
            return;
        }
        for (ZipEntry zipEntry : list2) {
            String substring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1);
            if (!set.contains(substring)) {
                list.add(zipEntry);
                set.add(substring);
            }
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        File file2 = new File(file, zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1));
        int i2 = 0;
        boolean z = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                h.a(zipFile.getInputStream(zipEntry), new FileOutputStream(file2));
                z = true;
                continue;
            } catch (IOException e2) {
                if (i2 >= 3) {
                    throw e2;
                }
                i2++;
                continue;
            }
        } while (!z);
    }

    public static String a() {
        String str = a;
        if (str != null) {
            return str;
        }
        String c2 = c();
        a = c2;
        return c2;
    }

    private static String a(JSONObject jSONObject) {
        if (i.a()) {
            try {
                String str = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
                a(jSONObject, "primaryCpuAbi", str);
                if (str != null) {
                    int i2 = 0;
                    if (Build.VERSION.SDK_INT >= 23) {
                        try {
                            i2 = Process.is64Bit() ? 64 : 32;
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i2)));
                        } catch (Exception unused) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i2)));
                        }
                    } else {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");
                    }
                    a(jSONObject, "processMode", String.valueOf(i2));
                    if (i2 != 0) {
                        if (b.get(str).intValue() == i2) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(String.valueOf(str)));
                            return str;
                        }
                        return null;
                    }
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(String.valueOf(str)));
                    return str;
                }
                return null;
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e2);
                a(jSONObject, "autoError", "1");
                return null;
            }
        }
        return null;
    }

    public static boolean a(File file) {
        boolean a2;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Map<String, List<ZipEntry>> a3 = a(zipFile2);
                    if (a3.isEmpty()) {
                        a2 = true;
                        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
                    } else {
                        a2 = a(a3, a);
                        if (a2) {
                            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + a2 + "], " + file);
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + a2 + "], " + file);
                        }
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException unused) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                    }
                    return a2;
                } catch (IOException e2) {
                    e = e2;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            return false;
                        } catch (IOException unused2) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    private static boolean a(Map<String, List<ZipEntry>> map, String str) {
        if (TextUtils.equals(str, "armeabi") || TextUtils.equals(str, "armeabi-v7a")) {
            return map.containsKey("armeabi") || map.containsKey("armeabi-v7a");
        }
        return map.containsKey(str);
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
