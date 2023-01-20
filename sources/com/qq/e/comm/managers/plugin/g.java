package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public class g {
    private final File a;
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private String f5091c;

    /* renamed from: d  reason: collision with root package name */
    private int f5092d;

    /* renamed from: e  reason: collision with root package name */
    private String f5093e;

    public g(File file, File file2) {
        this.a = file;
        this.b = file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    private String a(File file) throws IOException {
        Throwable th;
        ?? r1 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                            return sb2;
                        } catch (IOException e2) {
                            throw e2;
                        }
                    } catch (IOException e3) {
                        throw e3;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (Exception unused2) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                r1 = file;
                th = th3;
            }
        }
        return null;
    }

    public boolean b() {
        int i2;
        try {
            if (this.b.exists() && this.a.exists()) {
                String a = a(this.b);
                this.f5093e = a;
                if (TextUtils.isEmpty(a)) {
                    return false;
                }
                String[] split = this.f5093e.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    try {
                        i2 = Integer.parseInt(split[0]);
                    } catch (Throwable unused) {
                        i2 = 0;
                    }
                    if (c.b.a.a(str, this.a)) {
                        this.f5091c = str;
                        this.f5092d = i2;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }

    public boolean c(File file, File file2) {
        return (file.equals(this.a) || h.a(this.a, file)) && (file2.equals(this.b) || h.a(this.b, file2));
    }

    public String d() {
        return this.f5093e;
    }

    public String e() {
        return this.f5091c;
    }

    public int f() {
        return this.f5092d;
    }
}
