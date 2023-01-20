package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class c {
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f3437c;

    /* renamed from: d  reason: collision with root package name */
    public int f3438d;

    /* renamed from: g  reason: collision with root package name */
    public String f3441g;

    /* renamed from: h  reason: collision with root package name */
    public int f3442h;

    /* renamed from: i  reason: collision with root package name */
    public int f3443i;

    /* renamed from: j  reason: collision with root package name */
    public int f3444j;
    public final StringBuilder a = new StringBuilder();

    /* renamed from: e  reason: collision with root package name */
    public long f3439e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f3440f = 0;

    public c(int i2, String str, int i3, String str2) {
        this.b = null;
        this.f3437c = "HMS";
        this.f3438d = 0;
        this.f3444j = 0;
        this.f3444j = i2;
        this.b = str;
        this.f3438d = i3;
        if (str2 != null) {
            this.f3437c = str2;
        }
        b();
    }

    public static String a(int i2) {
        return i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? String.valueOf(i2) : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : ExpandableTextView.P : "D";
    }

    public final c b() {
        this.f3439e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f3440f = currentThread.getId();
        this.f3442h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i2 = this.f3444j;
        if (length > i2) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            this.f3441g = stackTraceElement.getFileName();
            this.f3443i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        a(sb);
        return sb.toString();
    }

    public <T> c a(T t) {
        this.a.append(t);
        return this;
    }

    public c a(Throwable th) {
        a((c) '\n').a((c) Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    public final StringBuilder a(StringBuilder sb) {
        sb.append(' ');
        sb.append(this.a.toString());
        return sb;
    }

    public final StringBuilder b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.f3439e)));
        String a = a(this.f3438d);
        sb.append(' ');
        sb.append(a);
        sb.append(Attributes.InternalPrefix);
        sb.append(this.f3437c);
        sb.append(Attributes.InternalPrefix);
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.f3442h);
        sb.append(':');
        sb.append(this.f3440f);
        sb.append(' ');
        sb.append(this.f3441g);
        sb.append(':');
        sb.append(this.f3443i);
        sb.append(']');
        return sb;
    }
}
