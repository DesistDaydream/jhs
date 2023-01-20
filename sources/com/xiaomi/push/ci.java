package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.multidex.MultiDexExtractor;
import com.xiaomi.mipush.sdk.Constants;
import e.t.u.b0;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class ci {
    private static String b = "/MiPushLog";

    /* renamed from: c  reason: collision with root package name */
    private String f8326c;

    /* renamed from: d  reason: collision with root package name */
    private String f8327d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8328e;

    /* renamed from: f  reason: collision with root package name */
    private int f8329f;
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat a = new SimpleDateFormat(b0.a.f14658i);

    /* renamed from: g  reason: collision with root package name */
    private int f8330g = 2097152;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<File> f8331h = new ArrayList<>();

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= read || !matcher.find(i2)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f8326c.length() + start);
                if (this.f8328e) {
                    if (substring.compareTo(this.f8327d) > 0) {
                        read = start;
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.f8326c) >= 0) {
                    this.f8328e = true;
                    i3 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f8326c.length();
                }
                i2 = start + indexOf;
            }
            if (this.f8328e) {
                int i4 = read - i3;
                this.f8329f += i4;
                bufferedWriter.write(cArr, i3, i4);
                if (z || this.f8329f > this.f8330g) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    private void b(File file) {
        BufferedReader bufferedReader;
        String str;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + com.xiaomi.push.service.ay.e() + "; lng :" + Locale.getDefault().toString() + "; sdk :48; andver :" + Build.VERSION.SDK_INT + "\n");
                    this.f8329f = 0;
                    Iterator<File> it = this.f8331h.iterator();
                    while (it.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        try {
                            a(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            com.xiaomi.a.a.a.c.c(str);
                            c.a(bufferedReader2);
                            c.a(bufferedReader);
                            return;
                        } catch (IOException e3) {
                            e = e3;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            com.xiaomi.a.a.a.c.c(str);
                            c.a(bufferedReader2);
                            c.a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedWriter;
                            c.a(bufferedReader2);
                            c.a(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter.write(by.a().e());
                    c.a(bufferedWriter);
                    c.a(bufferedReader2);
                } catch (FileNotFoundException e4) {
                    e = e4;
                    bufferedReader = bufferedReader2;
                } catch (IOException e5) {
                    e = e5;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public ci a(File file) {
        if (file.exists()) {
            this.f8331h.add(file);
        }
        return this;
    }

    public ci a(Date date, Date date2) {
        String format;
        if (date.after(date2)) {
            this.f8326c = this.a.format(date2);
            format = this.a.format(date);
        } else {
            this.f8326c = this.a.format(date);
            format = this.a.format(date2);
        }
        this.f8327d = format;
        return this;
    }

    public File a(Context context, Date date, Date date2, File file) {
        File file2;
        File file3;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = new File(context.getExternalFilesDir(null), com.xiaomi.push.service.an.N);
            if (!file2.exists()) {
                file2 = new File(context.getFilesDir(), com.xiaomi.push.service.an.N);
            }
            if (!file2.exists()) {
                file2 = context.getFilesDir();
            }
            a(new File(file2, "xmsf.log.1"));
            file3 = new File(file2, "xmsf.log");
        } else {
            file2 = new File(context.getExternalFilesDir(null) + b);
            a(new File(file2, "log0.txt"));
            file3 = new File(file2, "log1.txt");
        }
        a(file3);
        if (file2.isDirectory()) {
            File file4 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + MultiDexExtractor.EXTRACTED_SUFFIX);
            if (file4.exists()) {
                return null;
            }
            a(date, date2);
            long currentTimeMillis = System.currentTimeMillis();
            File file5 = new File(file, "log.txt");
            b(file5);
            com.xiaomi.a.a.a.c.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
            if (file5.exists()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                c.a(file4, file5);
                com.xiaomi.a.a.a.c.c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
                file5.delete();
                if (file4.exists()) {
                    return file4;
                }
            }
            return null;
        }
        return null;
    }

    public void a(int i2) {
        if (i2 != 0) {
            this.f8330g = i2;
        }
    }
}
