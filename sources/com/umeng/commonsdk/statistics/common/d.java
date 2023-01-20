package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class d {
    private static d a = null;
    private static Context b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f7476c = null;

    /* renamed from: e  reason: collision with root package name */
    private static final String f7477e = "mobclick_agent_user_";

    /* renamed from: f  reason: collision with root package name */
    private static final String f7478f = "mobclick_agent_header_";

    /* renamed from: g  reason: collision with root package name */
    private static final String f7479g = "mobclick_agent_cached_";

    /* renamed from: d  reason: collision with root package name */
    private a f7480d;

    /* loaded from: classes3.dex */
    public static class a {
        private final int a;
        private File b;

        /* renamed from: c  reason: collision with root package name */
        private FilenameFilter f7481c;

        public a(Context context) {
            this(context, ".um");
        }

        public boolean a() {
            File[] listFiles = this.b.listFiles();
            return listFiles != null && listFiles.length > 0;
        }

        public void b() {
            File[] listFiles = this.b.listFiles(this.f7481c);
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                file.delete();
            }
        }

        public int c() {
            File[] listFiles = this.b.listFiles(this.f7481c);
            if (listFiles == null || listFiles.length <= 0) {
                return 0;
            }
            return listFiles.length;
        }

        public a(Context context, String str) {
            this.a = 10;
            this.f7481c = new FilenameFilter() { // from class: com.umeng.commonsdk.statistics.common.d.a.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return str2.startsWith("um");
                }
            };
            File file = new File(context.getFilesDir(), str);
            this.b = file;
            if (file.exists() && this.b.isDirectory()) {
                return;
            }
            this.b.mkdir();
        }

        public void a(b bVar) {
            File file;
            File[] listFiles = this.b.listFiles(this.f7481c);
            if (listFiles != null && listFiles.length >= 10) {
                Arrays.sort(listFiles);
                int length = listFiles.length - 10;
                for (int i2 = 0; i2 < length; i2++) {
                    listFiles[i2].delete();
                }
            }
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            bVar.a(this.b);
            int length2 = listFiles.length;
            for (int i3 = 0; i3 < length2; i3++) {
                try {
                } catch (Throwable unused) {
                    file = listFiles[i3];
                }
                if (bVar.b(listFiles[i3])) {
                    file = listFiles[i3];
                    file.delete();
                }
            }
            bVar.c(this.b);
        }

        public void a(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                HelperUtils.writeFile(new File(this.b, String.format(Locale.US, "um_cache_%d.env", Long.valueOf(System.currentTimeMillis()))), bArr);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(File file);

        boolean b(File file);

        void c(File file);
    }

    public d(Context context) {
        this.f7480d = new a(context);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            b = context.getApplicationContext();
            f7476c = context.getPackageName();
            if (a == null) {
                a = new d(context);
            }
            dVar = a;
        }
        return dVar;
    }

    private SharedPreferences f() {
        Context context = b;
        return context.getSharedPreferences(f7477e + f7476c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences f2 = f();
            String string = f2.getString("au_p", null);
            String string2 = f2.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i2).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }
}
