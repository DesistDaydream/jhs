package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.m;
import com.ss.android.download.api.config.n;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class j {
    public static final JSONObject a = new JSONObject();
    private static Context b;

    /* renamed from: c */
    private static com.ss.android.download.api.config.f f5318c;

    /* renamed from: d */
    private static com.ss.android.download.api.config.c f5319d;

    /* renamed from: e */
    private static com.ss.android.download.api.config.k f5320e;

    /* renamed from: f */
    private static com.ss.android.download.api.config.g f5321f;

    /* renamed from: g */
    private static com.ss.android.download.api.config.h f5322g;

    /* renamed from: h */
    private static com.ss.android.download.api.config.i f5323h;

    /* renamed from: i */
    private static com.ss.android.download.api.model.a f5324i;

    /* renamed from: j */
    private static com.ss.android.download.api.config.b f5325j;

    /* renamed from: k */
    private static com.ss.android.socialbase.appdownloader.c.h f5326k;

    /* renamed from: l */
    private static com.ss.android.download.api.config.d f5327l;

    /* renamed from: m */
    private static com.ss.android.download.api.config.e f5328m;
    private static n n;
    private static com.ss.android.download.api.config.j o;
    private static t p;
    private static m q;
    private static com.ss.android.download.api.config.l r;
    private static o s;
    private static com.ss.android.download.api.b.a t;
    private static p u;
    private static r v;

    public static void a(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            b = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void b(Context context) {
        if (b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        b = context.getApplicationContext();
    }

    @NonNull
    public static com.ss.android.download.api.config.k c() {
        if (f5320e == null) {
            f5320e = new com.ss.android.download.api.a.a();
        }
        return f5320e;
    }

    public static com.ss.android.download.api.config.g d() {
        return f5321f;
    }

    @NonNull
    public static com.ss.android.download.api.config.h e() {
        if (f5322g == null) {
            f5322g = new com.ss.android.download.api.a.b();
        }
        return f5322g;
    }

    public static com.ss.android.socialbase.appdownloader.c.h f() {
        if (f5326k == null) {
            f5326k = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.addownload.j.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                }
            };
        }
        return f5326k;
    }

    public static n g() {
        return n;
    }

    public static Context getContext() {
        Context context = b;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    @NonNull
    public static o h() {
        if (s == null) {
            s = new o() { // from class: com.ss.android.downloadlib.addownload.j.3
                @Override // com.ss.android.download.api.config.o
                public void a(String str, int i2, JSONObject jSONObject) {
                }
            };
        }
        return s;
    }

    @NonNull
    public static JSONObject i() {
        com.ss.android.download.api.config.i iVar = f5323h;
        if (iVar != null && iVar.a() != null) {
            return f5323h.a();
        }
        return a;
    }

    public static com.ss.android.download.api.config.l j() {
        return r;
    }

    @Nullable
    public static com.ss.android.download.api.config.b k() {
        return f5325j;
    }

    @Nullable
    public static m l() {
        return q;
    }

    public static String m() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.d n() {
        return f5327l;
    }

    public static com.ss.android.download.api.config.e o() {
        return f5328m;
    }

    public static com.ss.android.download.api.config.j p() {
        return o;
    }

    @NonNull
    public static p q() {
        return u;
    }

    public static t r() {
        return p;
    }

    @NonNull
    public static com.ss.android.download.api.b.a s() {
        if (t == null) {
            t = new com.ss.android.download.api.b.a() { // from class: com.ss.android.downloadlib.addownload.j.4
                @Override // com.ss.android.download.api.b.a
                public void a(Throwable th, String str) {
                }
            };
        }
        return t;
    }

    @NonNull
    public static r t() {
        if (v == null) {
            v = new r() { // from class: com.ss.android.downloadlib.addownload.j.5
                @Override // com.ss.android.download.api.config.r
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i2) {
                }
            };
        }
        return v;
    }

    public static String u() {
        try {
            int i2 = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + i().optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean v() {
        return (f5318c == null || f5321f == null || f5323h == null || f5325j == null || u == null) ? false : true;
    }

    @NonNull
    public static com.ss.android.download.api.config.c b() {
        if (f5319d == null) {
            f5319d = new com.ss.android.download.api.config.c() { // from class: com.ss.android.downloadlib.addownload.j.1
                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return f5319d;
    }

    public static void a(@NonNull com.ss.android.download.api.config.f fVar) {
        f5318c = fVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.k kVar) {
        f5320e = kVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.g gVar) {
        f5321f = gVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.h hVar) {
        f5322g = hVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.i iVar) {
        f5323h = iVar;
    }

    public static void a(@NonNull com.ss.android.download.api.model.a aVar) {
        f5324i = aVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.b bVar) {
        f5325j = bVar;
    }

    public static com.ss.android.download.api.config.f a() {
        return f5318c;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.j().a(str);
    }

    public static void a(p pVar) {
        u = pVar;
    }

    public static void a(com.ss.android.download.api.b.a aVar) {
        t = aVar;
    }
}
