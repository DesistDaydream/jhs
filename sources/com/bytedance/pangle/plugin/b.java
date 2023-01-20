package com.bytedance.pangle.plugin;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.multidex.MultiDexExtractor;
import com.baidu.mobads.sdk.internal.bp;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.bytedance.pangle.b.b;
import com.bytedance.pangle.e.b;
import com.bytedance.pangle.g;
import com.bytedance.pangle.g.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpns.mqtt.MqttTopic;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {
    private static final g a = g.a();

    /* loaded from: classes.dex */
    public static class a extends IOException {
        public /* synthetic */ a(String str, byte b) {
            this(str);
        }

        public /* synthetic */ a(String str, Throwable th, byte b) {
            this(str, th);
        }

        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }
    }

    public static boolean a(File file, String str, int i2) {
        g gVar;
        String str2 = str;
        int i3 = Build.VERSION.SDK_INT;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                gVar = a;
            } catch (a e2) {
                e = e2;
            }
            try {
                gVar.a(1000, 0, str, i2, null);
                com.bytedance.pangle.log.b a2 = com.bytedance.pangle.log.b.a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
                a(com.bytedance.pangle.b.b.f2212e, b.a.n, str, i2, -1L, null);
                com.bytedance.pangle.util.g.a(com.bytedance.pangle.c.c.a(str, i2));
                long a3 = a2.a("cleanDir");
                if (a3 > 30 || a3 < 0) {
                    sb.append("cleanDir cost:");
                    sb.append(a3);
                    sb.append(";");
                }
                try {
                    if (e.a(file.getAbsolutePath(), str2)) {
                        long a4 = a2.a("checkSignature");
                        if (a4 > 30 || a4 < 0) {
                            sb.append("checkSignature cost:");
                            sb.append(a4);
                            sb.append(";");
                        }
                        if (GlobalParam.getInstance().checkMatchHostAbi()) {
                            try {
                                if (!com.bytedance.pangle.c.b.a(file)) {
                                    throw new a("插件包包含so不符合宿主ABI类型", (byte) 0);
                                }
                            } catch (Exception e3) {
                                a(com.bytedance.pangle.b.b.f2213f, b.a.w, str, i2, -1L, null);
                                a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -5, str, i2, e3);
                                throw new a("插件包包含so不符合宿主ABI类型", e3, (byte) 0);
                            }
                        }
                        long a5 = a2.a("checkMathHostAbi");
                        if (a5 > 30 || a5 < 0) {
                            sb.append("checkMathHostAbi cost:");
                            sb.append(a5);
                            sb.append(";");
                        }
                        b(file, str, i2);
                        long a6 = a2.a("checkPermissions");
                        if (a6 > 30 || a6 < 0) {
                            sb.append("checkPermissions cost:");
                            sb.append(a6);
                            sb.append(";");
                        }
                        String c2 = c(file, str, i2);
                        long a7 = a2.a("copyApk");
                        if (a7 > 30 || a7 < 0) {
                            sb.append("copyApk cost:");
                            sb.append(a7);
                            sb.append(";");
                        }
                        StringBuilder sb2 = new StringBuilder();
                        int a8 = new com.bytedance.pangle.res.a.c().a(new File(c2), false, sb2);
                        if (a8 != 100 && a8 != 200) {
                            String sb3 = sb2.toString();
                            a(com.bytedance.pangle.b.b.f2213f, b.a.x, str, i2, -1L, sb3);
                            gVar.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -2, str, i2, null);
                            throw new a("modifyRes failed. result = " + a8 + ", errorLog = " + sb3, (byte) 0);
                        }
                        long a9 = a2.a(a8 == 100 ? "modifyRes" : "noModifyRes");
                        if (a9 > 30 || a9 < 0) {
                            sb.append("modifyRes cost:");
                            sb.append(a9);
                            sb.append(";");
                        }
                        try {
                            com.bytedance.pangle.c.b.a(new File(com.bytedance.pangle.c.c.b(str, i2)), new File(com.bytedance.pangle.c.c.d(str, i2)), str2);
                            long a10 = a2.a("copySo");
                            if (a10 > 30 || a10 < 0) {
                                sb.append("copySo cost:");
                                sb.append(a10);
                                sb.append(";");
                            }
                            try {
                                String c3 = com.bytedance.pangle.c.c.c(str, i2);
                                String d2 = com.bytedance.pangle.c.c.d(str, i2);
                                String absolutePath = file.getAbsolutePath();
                                if (i3 < 26) {
                                    try {
                                        if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
                                            DexFile.loadDex(absolutePath, null, 0).close();
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                                String b = com.bytedance.pangle.c.c.b(str, i2);
                                if (GlobalParam.getInstance().isFastDex2oat()) {
                                    if (i3 >= 21 && i3 < 26) {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append(c3);
                                        sb4.append(File.separator);
                                        String substring = b.substring(b.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
                                        String substring2 = substring.substring(substring.lastIndexOf("."));
                                        String str3 = i3 >= 26 ? ".odex" : MultiDexExtractor.DEX_SUFFIX;
                                        if (!MultiDexExtractor.DEX_SUFFIX.equals(substring2)) {
                                            if (!MultiDexExtractor.EXTRACTED_SUFFIX.equals(substring2) && !".apk".equals(substring2)) {
                                                substring = substring + str3;
                                            }
                                            substring = substring.replace(substring2, str3);
                                        }
                                        sb4.append(substring);
                                        String sb5 = sb4.toString();
                                        File file2 = new File(sb5);
                                        if (!file2.exists() || !com.bytedance.pangle.e.c.a(file2)) {
                                            int i4 = b.a.b;
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add("dex2oat");
                                            if (i3 >= 24) {
                                                arrayList.add("--runtime-arg");
                                                arrayList.add("-classpath");
                                                arrayList.add("--runtime-arg");
                                                arrayList.add(ContainerUtils.FIELD_DELIMITER);
                                            }
                                            arrayList.add("--instruction-set=" + com.bytedance.pangle.e.b.a());
                                            if (i4 == b.a.a) {
                                                arrayList.add("--compiler-filter=verify-none");
                                            } else if (i4 == b.a.b) {
                                                arrayList.add("--compiler-filter=interpret-only");
                                            } else {
                                                int i5 = b.a.f2243c;
                                            }
                                            arrayList.add("--dex-file=".concat(String.valueOf(b)));
                                            arrayList.add("--oat-file=".concat(String.valueOf(sb5)));
                                            com.bytedance.pangle.e.a.a((String[]) arrayList.toArray(new String[arrayList.size()]));
                                        }
                                    }
                                }
                                PluginClassLoader pluginClassLoader = new PluginClassLoader(b, c3, d2, null);
                                if (!TextUtils.isEmpty("")) {
                                    pluginClassLoader.loadClass("");
                                }
                                long a11 = a2.a("dexOpt");
                                if (a11 > 30 || a11 < 0) {
                                    sb.append("dexOpt cost:");
                                    sb.append(a11);
                                    sb.append(";");
                                }
                                com.bytedance.pangle.util.g.a(file);
                                long a12 = a2.a("cleanPluginApk");
                                if (a12 > 30 || a12 < 0) {
                                    sb.append("cleanPluginApk cost:");
                                    sb.append(a12);
                                    sb.append(";");
                                }
                                a(com.bytedance.pangle.b.b.f2213f, b.a.o, str, i2, a2.a(), sb.toString());
                                a2.b(bp.o);
                                a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, 0, str, i2, null);
                                return true;
                            } catch (Exception e4) {
                                a(com.bytedance.pangle.b.b.f2213f, b.a.v, str, i2, -1L, null);
                                a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -8, str, i2, e4);
                                throw new a("dexOpt失败", e4, (byte) 0);
                            }
                        } catch (Exception e5) {
                            a(com.bytedance.pangle.b.b.f2213f, b.a.t, str, i2, -1L, null);
                            a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -7, str, i2, e5);
                            throw new a("安装包动态库拷贝失败", e5, (byte) 0);
                        }
                    }
                    throw new RuntimeException("安装包签名校验失败[1]");
                } catch (Exception e6) {
                    a(com.bytedance.pangle.b.b.f2213f, b.a.q, str, i2, -1L, null);
                    a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -3, str, i2, e6);
                    throw new a(e6.getMessage(), e6, (byte) 0);
                }
            } catch (a e7) {
                e = e7;
                str2 = str;
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str2 + " install failed.", e);
                return false;
            }
        } catch (Exception e8) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", e8);
            a(com.bytedance.pangle.b.b.f2213f, b.a.p, str, i2, -1L, sb.toString());
            a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -1, str, i2, e8);
            return false;
        }
    }

    private static void b(File file, String str, int i2) {
        String[] strArr;
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
            PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
            List asList = Arrays.asList(packageInfo.requestedPermissions);
            String[] strArr2 = packageArchiveInfo.requestedPermissions;
            if (strArr2 == null || strArr2.length <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : packageArchiveInfo.requestedPermissions) {
                if (!asList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
            if (GlobalParam.getInstance().checkPermission()) {
                throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), (byte) 0);
            }
        } catch (Exception e2) {
            a(com.bytedance.pangle.b.b.f2213f, b.a.r, str, i2, -1L, null);
            a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -4, str, i2, e2);
            throw new a("安装包权限校验失败", e2, (byte) 0);
        }
    }

    private static String c(File file, String str, int i2) {
        String b = com.bytedance.pangle.c.c.b(str, i2);
        try {
            String absolutePath = file.getAbsolutePath();
            if (!TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(b)) {
                File file2 = new File(absolutePath);
                File file3 = new File(b);
                if (file2.exists() && file2.isFile() && file2.canRead()) {
                    if (file3.getParentFile() != null && !file3.getParentFile().exists()) {
                        file3.getParentFile().mkdirs();
                    }
                    FileInputStream fileInputStream = new FileInputStream(absolutePath);
                    FileOutputStream fileOutputStream = new FileOutputStream(b);
                    FileChannel channel = fileInputStream.getChannel();
                    FileChannel channel2 = fileOutputStream.getChannel();
                    channel2.write(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()));
                    channel.close();
                    channel2.close();
                    fileInputStream.close();
                    fileOutputStream.close();
                }
            }
            return b;
        } catch (Exception e2) {
            a(com.bytedance.pangle.b.b.f2213f, b.a.s, str, i2, -1L, null);
            a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -6, str, i2, e2);
            throw new a("安装包拷贝失败", e2, (byte) 0);
        }
    }

    private static void a(String str, int i2, @NonNull String str2, int i3, long j2, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(ReportItem.RequestKeyStatusCode, com.bytedance.pangle.log.c.a(Integer.valueOf(i2)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.c.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.c.a(Integer.valueOf(i3)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.c.b(Long.valueOf(j2))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.c.a(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.bytedance.pangle.b.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }
}
