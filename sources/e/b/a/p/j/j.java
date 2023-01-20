package e.b.a.p.j;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import e.b.a.p.j.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public class j implements d<InputStream> {

    /* renamed from: g  reason: collision with root package name */
    private static final String f9456g = "HttpUrlFetcher";

    /* renamed from: h  reason: collision with root package name */
    private static final int f9457h = 5;
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    public static final String f9458i = "Location";
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    public static final b f9459j = new a();
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    public static final int f9460k = -1;
    private final e.b.a.p.l.g a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final b f9461c;

    /* renamed from: d  reason: collision with root package name */
    private HttpURLConnection f9462d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f9463e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f9464f;

    /* loaded from: classes.dex */
    public static class a implements b {
        @Override // e.b.a.p.j.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(e.b.a.p.l.g gVar, int i2) {
        this(gVar, i2, f9459j);
    }

    private HttpURLConnection b(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection a2 = this.f9461c.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a2.addRequestProperty(entry.getKey(), entry.getValue());
            }
            a2.setConnectTimeout(this.b);
            a2.setReadTimeout(this.b);
            a2.setUseCaches(false);
            a2.setDoInput(true);
            a2.setInstanceFollowRedirects(false);
            return a2;
        } catch (IOException e2) {
            throw new HttpException("URL.openConnection threw", 0, e2);
        }
    }

    private static int d(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e2) {
            if (Log.isLoggable(f9456g, 3)) {
                Log.d(f9456g, "Failed to get a response code", e2);
                return -1;
            }
            return -1;
        }
    }

    private InputStream e(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f9463e = e.b.a.v.c.b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable(f9456g, 3)) {
                    Log.d(f9456g, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.f9463e = httpURLConnection.getInputStream();
            }
            return this.f9463e;
        } catch (IOException e2) {
            throw new HttpException("Failed to obtain InputStream", d(httpURLConnection), e2);
        }
    }

    private static boolean f(int i2) {
        return i2 / 100 == 2;
    }

    private static boolean g(int i2) {
        return i2 / 100 == 3;
    }

    private InputStream h(URL url, int i2, URL url2, Map<String, String> map) throws HttpException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection b2 = b(url, map);
            this.f9462d = b2;
            try {
                b2.connect();
                this.f9463e = this.f9462d.getInputStream();
                if (this.f9464f) {
                    return null;
                }
                int d2 = d(this.f9462d);
                if (f(d2)) {
                    return e(this.f9462d);
                }
                if (!g(d2)) {
                    if (d2 == -1) {
                        throw new HttpException(d2);
                    }
                    try {
                        throw new HttpException(this.f9462d.getResponseMessage(), d2);
                    } catch (IOException e2) {
                        throw new HttpException("Failed to get a response message", d2, e2);
                    }
                }
                String headerField = this.f9462d.getHeaderField(f9458i);
                if (!TextUtils.isEmpty(headerField)) {
                    try {
                        URL url3 = new URL(url, headerField);
                        a();
                        return h(url3, i2 + 1, url, map);
                    } catch (MalformedURLException e3) {
                        throw new HttpException("Bad redirect url: " + headerField, d2, e3);
                    }
                }
                throw new HttpException("Received empty or null redirect url", d2);
            } catch (IOException e4) {
                throw new HttpException("Failed to connect or obtain data", d(this.f9462d), e4);
            }
        }
        throw new HttpException("Too many (> 5) redirects!", -1);
    }

    @Override // e.b.a.p.j.d
    public void a() {
        InputStream inputStream = this.f9463e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f9462d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f9462d = null;
    }

    @Override // e.b.a.p.j.d
    public void c(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long b2 = e.b.a.v.h.b();
        try {
            try {
                aVar.d(h(this.a.g(), 0, null, this.a.c()));
            } catch (IOException e2) {
                if (Log.isLoggable(f9456g, 3)) {
                    Log.d(f9456g, "Failed to load data for url", e2);
                }
                aVar.b(e2);
                if (!Log.isLoggable(f9456g, 2)) {
                    return;
                }
                sb = new StringBuilder();
            }
            if (Log.isLoggable(f9456g, 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(e.b.a.v.h.a(b2));
                Log.v(f9456g, sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable(f9456g, 2)) {
                Log.v(f9456g, "Finished http url fetcher fetch in " + e.b.a.v.h.a(b2));
            }
            throw th;
        }
    }

    @Override // e.b.a.p.j.d
    public void cancel() {
        this.f9464f = true;
    }

    @Override // e.b.a.p.j.d
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // e.b.a.p.j.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @VisibleForTesting
    public j(e.b.a.p.l.g gVar, int i2, b bVar) {
        this.a = gVar;
        this.b = i2;
        this.f9461c = bVar;
    }
}
