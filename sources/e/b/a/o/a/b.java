package e.b.a.o.a;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import e.b.a.p.j.d;
import e.b.a.p.l.g;
import e.b.a.v.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public class b implements d<InputStream>, Callback {

    /* renamed from: g  reason: collision with root package name */
    private static final String f9438g = "OkHttpFetcher";
    private final Call.Factory a;
    private final g b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f9439c;

    /* renamed from: d  reason: collision with root package name */
    private ResponseBody f9440d;

    /* renamed from: e  reason: collision with root package name */
    private d.a<? super InputStream> f9441e;

    /* renamed from: f  reason: collision with root package name */
    private volatile Call f9442f;

    public b(Call.Factory factory, g gVar) {
        this.a = factory;
        this.b = gVar;
    }

    @Override // e.b.a.p.j.d
    public void a() {
        try {
            InputStream inputStream = this.f9439c;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.f9440d;
        if (responseBody != null) {
            responseBody.close();
        }
        this.f9441e = null;
    }

    @Override // e.b.a.p.j.d
    public void c(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        Request.Builder url = new Request.Builder().url(this.b.f());
        for (Map.Entry<String, String> entry : this.b.c().entrySet()) {
            url.addHeader(entry.getKey(), entry.getValue());
        }
        Request build = url.build();
        this.f9441e = aVar;
        this.f9442f = this.a.newCall(build);
        this.f9442f.enqueue(this);
    }

    @Override // e.b.a.p.j.d
    public void cancel() {
        Call call = this.f9442f;
        if (call != null) {
            call.cancel();
        }
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

    @Override // okhttp3.Callback
    public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
        if (Log.isLoggable(f9438g, 3)) {
            Log.d(f9438g, "OkHttp failed to obtain result", iOException);
        }
        this.f9441e.b(iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(@NonNull Call call, @NonNull Response response) {
        this.f9440d = response.body();
        if (response.isSuccessful()) {
            InputStream b = e.b.a.v.c.b(this.f9440d.byteStream(), ((ResponseBody) l.d(this.f9440d)).contentLength());
            this.f9439c = b;
            this.f9441e.d(b);
            return;
        }
        this.f9441e.b(new HttpException(response.message(), response.code()));
    }
}
