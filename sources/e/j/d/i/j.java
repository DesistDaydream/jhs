package e.j.d.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.caverock.androidsvg.SVG;
import e.j.a.b.c.r.a0;
import e.j.a.b.f.c.n;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class j implements Closeable {
    private final URL a;
    @Nullable
    private e.j.a.b.j.k<Bitmap> b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private volatile InputStream f11282c;

    private j(URL url) {
        this.a = url;
    }

    @Nullable
    public static j k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new j(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            Log.w("FirebaseMessaging", valueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(valueOf) : new String("Not downloading image, bad URL: "));
            return null;
        }
    }

    private static /* synthetic */ void l(Throwable th, InputStream inputStream) {
        if (th == null) {
            inputStream.close();
            return;
        }
        try {
            inputStream.close();
        } catch (Throwable th2) {
            n.b(th, th2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        e.j.a.b.f.c.k.a(this.f11282c);
    }

    public final e.j.a.b.j.k<Bitmap> j() {
        return (e.j.a.b.j.k) a0.k(this.b);
    }

    public final void n(Executor executor) {
        this.b = e.j.a.b.j.n.call(executor, new Callable(this) { // from class: e.j.d.i.k
            private final j a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.o();
            }
        });
    }

    public final Bitmap o() throws IOException {
        String valueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        Log.i("FirebaseMessaging", sb.toString());
        try {
            InputStream inputStream = this.a.openConnection().getInputStream();
            InputStream a = e.j.a.b.f.c.j.a(inputStream, SVG.H);
            this.f11282c = inputStream;
            Bitmap decodeStream = BitmapFactory.decodeStream(a);
            if (decodeStream != null) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    String valueOf2 = String.valueOf(this.a);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                    sb2.append("Successfully downloaded image: ");
                    sb2.append(valueOf2);
                    Log.d("FirebaseMessaging", sb2.toString());
                }
                l(null, a);
                if (inputStream != null) {
                    l(null, inputStream);
                }
                return decodeStream;
            }
            String valueOf3 = String.valueOf(this.a);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 24);
            sb3.append("Failed to decode image: ");
            sb3.append(valueOf3);
            String sb4 = sb3.toString();
            Log.w("FirebaseMessaging", sb4);
            throw new IOException(sb4);
        } catch (IOException e2) {
            String valueOf4 = String.valueOf(this.a);
            StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf4).length() + 26);
            sb5.append("Failed to download image: ");
            sb5.append(valueOf4);
            Log.w("FirebaseMessaging", sb5.toString());
            throw e2;
        }
    }
}
