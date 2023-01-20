package e.t.r.a.m;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.e;
import e.b.a.p.j.d;
import e.b.a.p.l.g;
import e.b.a.v.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/vector/network/image/https/OkHttpStreamFetcher;", "Lcom/bumptech/glide/load/data/DataFetcher;", "Ljava/io/InputStream;", "Lokhttp3/Callback;", "client", "Lokhttp3/Call$Factory;", "url", "Lcom/bumptech/glide/load/model/GlideUrl;", "(Lokhttp3/Call$Factory;Lcom/bumptech/glide/load/model/GlideUrl;)V", "call", "Lokhttp3/Call;", "callback", "Lcom/bumptech/glide/load/data/DataFetcher$DataCallback;", "responseBody", "Lokhttp3/ResponseBody;", "stream", "cancel", "", "cleanup", "getDataClass", "Ljava/lang/Class;", "getDataSource", "Lcom/bumptech/glide/load/DataSource;", "loadData", RemoteMessageConst.Notification.PRIORITY, "Lcom/bumptech/glide/Priority;", "onFailure", e.a, "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b implements e.b.a.p.j.d<InputStream>, Callback {
    @k.e.a.e
    private Call.Factory a;
    @k.e.a.e
    private g b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private InputStream f14626c;
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private ResponseBody f14627d;
    @k.e.a.e

    /* renamed from: e  reason: collision with root package name */
    private d.a<? super InputStream> f14628e;
    @k.e.a.e

    /* renamed from: f  reason: collision with root package name */
    private volatile Call f14629f;

    public b(@k.e.a.e Call.Factory factory, @k.e.a.d g gVar) {
        this.a = factory;
        this.b = gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0016, code lost:
        if (r1 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0019, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001c, code lost:
        r3.f14628e = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x001e, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
        if (r1 == null) goto L9;
     */
    @Override // e.b.a.p.j.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            r3 = this;
            r0 = 0
            java.io.InputStream r1 = r3.f14626c     // Catch: java.lang.Throwable -> Le java.io.IOException -> L10
            if (r1 != 0) goto L6
            goto L9
        L6:
            r1.close()     // Catch: java.lang.Throwable -> Le java.io.IOException -> L10
        L9:
            okhttp3.ResponseBody r1 = r3.f14627d
            if (r1 != 0) goto L19
            goto L1c
        Le:
            r1 = move-exception
            goto L1f
        L10:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Le
            okhttp3.ResponseBody r1 = r3.f14627d
            if (r1 != 0) goto L19
            goto L1c
        L19:
            r1.close()
        L1c:
            r3.f14628e = r0
            return
        L1f:
            okhttp3.ResponseBody r2 = r3.f14627d
            if (r2 != 0) goto L24
            goto L27
        L24:
            r2.close()
        L27:
            r3.f14628e = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.t.r.a.m.b.a():void");
    }

    @Override // e.b.a.p.j.d
    public void c(@k.e.a.d Priority priority, @k.e.a.d d.a<? super InputStream> aVar) {
        Map<String, String> c2;
        Request.Builder builder = new Request.Builder();
        g gVar = this.b;
        String f2 = gVar == null ? null : gVar.f();
        if (f2 != null) {
            Request.Builder url = builder.url(f2);
            g gVar2 = this.b;
            if (gVar2 != null && (c2 = gVar2.c()) != null) {
                for (Map.Entry<String, String> entry : c2.entrySet()) {
                    url.addHeader(entry.getKey(), entry.getValue());
                }
            }
            Request build = url.build();
            this.f14628e = aVar;
            Call.Factory factory = this.a;
            this.f14629f = factory != null ? factory.newCall(build) : null;
            Call call = this.f14629f;
            if (call == null) {
                return;
            }
            call.enqueue(this);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // e.b.a.p.j.d
    public void cancel() {
        Call call = this.f14629f;
        if (call == null) {
            return;
        }
        call.cancel();
    }

    @Override // e.b.a.p.j.d
    @k.e.a.d
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // e.b.a.p.j.d
    @k.e.a.d
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @Override // okhttp3.Callback
    public void onFailure(@k.e.a.d Call call, @k.e.a.d IOException iOException) {
        d.a<? super InputStream> aVar = this.f14628e;
        if (aVar == null) {
            return;
        }
        aVar.b(iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(@k.e.a.d Call call, @k.e.a.d Response response) {
        InputStream byteStream;
        this.f14627d = response.body();
        if (response.isSuccessful()) {
            long contentLength = ((ResponseBody) l.d(this.f14627d)).contentLength();
            ResponseBody responseBody = this.f14627d;
            InputStream inputStream = null;
            if (responseBody != null && (byteStream = responseBody.byteStream()) != null) {
                inputStream = e.b.a.v.c.b(byteStream, contentLength);
            }
            this.f14626c = inputStream;
            d.a<? super InputStream> aVar = this.f14628e;
            if (aVar == null) {
                return;
            }
            aVar.d(inputStream);
            return;
        }
        d.a<? super InputStream> aVar2 = this.f14628e;
        if (aVar2 == null) {
            return;
        }
        aVar2.b(new HttpException(response.message(), response.code()));
    }
}
