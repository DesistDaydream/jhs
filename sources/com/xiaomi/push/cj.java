package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.jihuanshe.model.Constants;
import com.xiaomi.push.p;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class cj {

    /* renamed from: c  reason: collision with root package name */
    private static volatile cj f8332c;
    private final ConcurrentLinkedQueue<b> a;
    private Context b;

    /* loaded from: classes3.dex */
    public class a extends b {
        public a() {
            super();
        }

        @Override // com.xiaomi.push.cj.b, com.xiaomi.push.p.b
        public void b() {
            cj.this.b();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends p.b {
        public long b = System.currentTimeMillis();

        public b() {
        }

        @Override // com.xiaomi.push.p.b
        public void b() {
        }

        public boolean d() {
            return true;
        }

        public final boolean e() {
            return System.currentTimeMillis() - this.b > com.baidu.mobads.sdk.internal.bc.f1470e;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends b {
        public String a;

        /* renamed from: d  reason: collision with root package name */
        public String f8334d;

        /* renamed from: e  reason: collision with root package name */
        public File f8335e;

        /* renamed from: f  reason: collision with root package name */
        public int f8336f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8337g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8338h;

        public c(String str, String str2, File file, boolean z) {
            super();
            this.a = str;
            this.f8334d = str2;
            this.f8335e = file;
            this.f8338h = z;
        }

        private boolean f() {
            int i2;
            int i3 = 0;
            SharedPreferences sharedPreferences = cj.this.b.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i2 = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i2 = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
            } else if (i2 > 10) {
                return false;
            } else {
                i3 = i2;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i3 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                com.xiaomi.a.a.a.c.c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.cj.b, com.xiaomi.push.p.b
        public void b() {
            try {
                if (f()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Constants.KEY_PARAM_USER_ID, com.xiaomi.push.service.ay.e());
                    hashMap.put("token", this.f8334d);
                    hashMap.put("net", al.l(cj.this.b));
                    al.a(this.a, hashMap, this.f8335e, "file");
                }
                this.f8337g = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.p.b
        public void c() {
            if (!this.f8337g) {
                int i2 = this.f8336f + 1;
                this.f8336f = i2;
                if (i2 < 3) {
                    cj.this.a.add(this);
                }
            }
            if (this.f8337g || this.f8336f >= 3) {
                this.f8335e.delete();
            }
            cj.this.a((1 << this.f8336f) * 1000);
        }

        @Override // com.xiaomi.push.cj.b
        public boolean d() {
            return al.f(cj.this.b) || (this.f8338h && al.c(cj.this.b));
        }
    }

    private cj(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.a = concurrentLinkedQueue;
        this.b = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    public static cj a(Context context) {
        if (f8332c == null) {
            synchronized (cj.class) {
                if (f8332c == null) {
                    f8332c = new cj(context);
                }
            }
        }
        f8332c.b = context;
        return f8332c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        b peek = this.a.peek();
        if (peek == null || !peek.d()) {
            return;
        }
        b(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (e.b() || e.a()) {
            return;
        }
        try {
            File file = new File(this.b.getExternalFilesDir(null) + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void b(long j2) {
        if (this.a.isEmpty()) {
            return;
        }
        gf.a(new cl(this), j2);
    }

    private void c() {
        while (!this.a.isEmpty()) {
            b peek = this.a.peek();
            if (peek != null) {
                if (!peek.e() && this.a.size() <= 6) {
                    return;
                }
                com.xiaomi.a.a.a.c.c("remove Expired task");
                this.a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i2, boolean z) {
        this.a.add(new ck(this, i2, date, date2, str, str2, z));
        b(0L);
    }
}
