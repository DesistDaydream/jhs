package e.b.a.p.l;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
public class g implements e.b.a.p.c {

    /* renamed from: j  reason: collision with root package name */
    private static final String f9689j = "@#&=*+-_.,:!?()/~'%;$";

    /* renamed from: c  reason: collision with root package name */
    private final h f9690c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final URL f9691d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f9692e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f9693f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private URL f9694g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private volatile byte[] f9695h;

    /* renamed from: i  reason: collision with root package name */
    private int f9696i;

    public g(URL url) {
        this(url, h.b);
    }

    private byte[] b() {
        if (this.f9695h == null) {
            this.f9695h = a().getBytes(e.b.a.p.c.b);
        }
        return this.f9695h;
    }

    private String d() {
        if (TextUtils.isEmpty(this.f9693f)) {
            String str = this.f9692e;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) e.b.a.v.l.d(this.f9691d)).toString();
            }
            this.f9693f = Uri.encode(str, f9689j);
        }
        return this.f9693f;
    }

    private URL e() throws MalformedURLException {
        if (this.f9694g == null) {
            this.f9694g = new URL(d());
        }
        return this.f9694g;
    }

    public String a() {
        String str = this.f9692e;
        return str != null ? str : ((URL) e.b.a.v.l.d(this.f9691d)).toString();
    }

    public Map<String, String> c() {
        return this.f9690c.getHeaders();
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return a().equals(gVar.a()) && this.f9690c.equals(gVar.f9690c);
        }
        return false;
    }

    public String f() {
        return d();
    }

    public URL g() throws MalformedURLException {
        return e();
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        if (this.f9696i == 0) {
            int hashCode = a().hashCode();
            this.f9696i = hashCode;
            this.f9696i = (hashCode * 31) + this.f9690c.hashCode();
        }
        return this.f9696i;
    }

    public String toString() {
        return a();
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(b());
    }

    public g(String str) {
        this(str, h.b);
    }

    public g(URL url, h hVar) {
        this.f9691d = (URL) e.b.a.v.l.d(url);
        this.f9692e = null;
        this.f9690c = (h) e.b.a.v.l.d(hVar);
    }

    public g(String str, h hVar) {
        this.f9691d = null;
        this.f9692e = e.b.a.v.l.b(str);
        this.f9690c = (h) e.b.a.v.l.d(hVar);
    }
}
