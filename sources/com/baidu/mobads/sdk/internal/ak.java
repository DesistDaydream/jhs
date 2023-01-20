package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.Bugly;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public class ak {
    public static final String a = "OAdURLConnection";
    public static final String b = "POST";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1432c = "GET";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1433d = "application/json";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1434e = "text/plain";

    /* renamed from: f  reason: collision with root package name */
    private HttpURLConnection f1435f;

    /* renamed from: g  reason: collision with root package name */
    private bj f1436g;

    /* renamed from: h  reason: collision with root package name */
    private b f1437h;

    /* renamed from: i  reason: collision with root package name */
    private c f1438i;

    /* renamed from: j  reason: collision with root package name */
    private String f1439j;

    /* renamed from: k  reason: collision with root package name */
    private String f1440k;

    /* renamed from: l  reason: collision with root package name */
    private String f1441l;

    /* renamed from: m  reason: collision with root package name */
    private String f1442m;
    private int n;
    private int o;
    private boolean p;
    private Uri.Builder q;

    /* loaded from: classes.dex */
    public class a extends h {
        public a() {
        }

        @Override // com.baidu.mobads.sdk.internal.h
        public Object i() {
            ak.this.e();
            ak.this.f();
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str, int i2);

        void a(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(InputStream inputStream, String str);

        void a(String str, int i2);
    }

    public ak(String str) {
        this(str, "GET");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (TextUtils.isEmpty(this.f1439j)) {
            return;
        }
        try {
            HttpURLConnection a2 = cg.a().a(new URL(this.f1439j));
            this.f1435f = a2;
            a2.setConnectTimeout(this.n);
            if (Integer.parseInt(bc.a((Context) null).b()) < 8) {
                System.setProperty("http.keepAlive", Bugly.SDK_IS_DEV);
            }
            this.f1435f.setRequestMethod(this.f1440k);
            this.f1435f.setUseCaches(this.p);
            if (!TextUtils.isEmpty(this.f1441l)) {
                this.f1435f.setRequestProperty("User-Agent", this.f1441l);
            }
            this.f1435f.setRequestProperty("Content-type", this.f1442m);
            this.f1435f.setRequestProperty("Connection", "keep-alive");
            this.f1435f.setRequestProperty("Cache-Control", "no-cache");
            if (this.f1440k.equals("POST")) {
                this.f1435f.setDoInput(true);
                this.f1435f.setDoOutput(true);
                Uri.Builder builder = this.q;
                if (builder != null) {
                    a(builder.build().getEncodedQuery(), this.f1435f);
                }
            }
        } catch (Exception e2) {
            b bVar = this.f1437h;
            if (bVar != null) {
                bVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
            c cVar = this.f1438i;
            if (cVar != null) {
                cVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f1435f.connect();
                bj bjVar = this.f1436g;
                bjVar.a(a, this.f1435f.getRequestMethod() + " connect code :" + this.f1435f.getResponseCode());
                int responseCode = this.f1435f.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f1435f.setInstanceFollowRedirects(false);
                    HttpURLConnection a2 = a(this.f1435f);
                    this.f1435f = a2;
                    responseCode = a2.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    b bVar = this.f1437h;
                    if (bVar != null) {
                        bVar.a(this.f1435f.getResponseMessage(), responseCode);
                    }
                    c cVar = this.f1438i;
                    if (cVar != null) {
                        cVar.a(this.f1435f.getResponseMessage(), responseCode);
                    }
                } else {
                    String f2 = cg.a().f(this.f1439j);
                    b bVar2 = this.f1437h;
                    if (bVar2 != null) {
                        bVar2.a(c(), f2);
                    }
                    c cVar2 = this.f1438i;
                    if (cVar2 != null) {
                        cVar2.a(this.f1435f.getInputStream(), f2);
                    }
                }
                httpURLConnection = this.f1435f;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                b bVar3 = this.f1437h;
                if (bVar3 != null) {
                    bVar3.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                c cVar3 = this.f1438i;
                if (cVar3 != null) {
                    cVar3.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                httpURLConnection = this.f1435f;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.f1435f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public String c() {
        InputStream inputStream = null;
        try {
            inputStream = this.f1435f.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public void d() {
        HttpURLConnection httpURLConnection = this.f1435f;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e2) {
                Log.e(a, e2.toString());
            }
        }
    }

    public ak(String str, String str2) {
        this.f1436g = bj.a();
        this.f1437h = null;
        this.f1438i = null;
        this.f1442m = f1434e;
        this.n = 10000;
        this.o = 10000;
        this.p = false;
        this.q = null;
        this.f1439j = str;
        this.f1440k = str2;
    }

    public String a() {
        e();
        HttpURLConnection httpURLConnection = this.f1435f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.f1435f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                String c2 = c();
                HttpURLConnection httpURLConnection3 = this.f1435f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return c2;
            } catch (Throwable unused) {
                HttpURLConnection httpURLConnection4 = this.f1435f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    public void b() {
        try {
            at.a().a((h) new a());
        } catch (Exception unused) {
        }
    }

    public void b(int i2) {
        this.o = i2;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public void a(Map<String, String> map) {
        if (this.f1435f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f1435f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField(e.b.a.p.j.j.f9458i)).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    public void a(b bVar) {
        this.f1437h = bVar;
    }

    public void a(c cVar) {
        this.f1438i = cVar;
    }

    public void a(int i2) {
        this.n = i2;
    }

    public void a(Uri.Builder builder) {
        this.q = builder;
    }

    public void a(String str) {
        this.f1442m = str;
    }
}
