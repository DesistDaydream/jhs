package l;

import j.m0;
import j.o0;
import j.z;
import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public final class l<T> implements d<T> {
    private final q a;
    private final Object[] b;

    /* renamed from: c */
    private final Call.Factory f17042c;

    /* renamed from: d */
    private final h<ResponseBody, T> f17043d;

    /* renamed from: e */
    private volatile boolean f17044e;
    @GuardedBy("this")
    @Nullable

    /* renamed from: f */
    private Call f17045f;
    @GuardedBy("this")
    @Nullable

    /* renamed from: g */
    private Throwable f17046g;
    @GuardedBy("this")

    /* renamed from: h */
    private boolean f17047h;

    /* loaded from: classes4.dex */
    public class a implements Callback {
        public final /* synthetic */ f a;

        public a(f fVar) {
            l.this = r1;
            this.a = fVar;
        }

        private void a(Throwable th) {
            try {
                this.a.onFailure(l.this, th);
            } catch (Throwable th2) {
                w.s(th2);
                th2.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.a.onResponse(l.this, l.this.e(response));
                } catch (Throwable th) {
                    w.s(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                w.s(th2);
                a(th2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends ResponseBody {
        private final ResponseBody a;
        private final j.o b;
        @Nullable

        /* renamed from: c */
        public IOException f17048c;

        /* loaded from: classes4.dex */
        public class a extends j.r {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(m0 m0Var) {
                super(m0Var);
                b.this = r1;
            }

            @Override // j.r, j.m0
            public long read(j.m mVar, long j2) throws IOException {
                try {
                    return super.read(mVar, j2);
                } catch (IOException e2) {
                    b.this.f17048c = e2;
                    throw e2;
                }
            }
        }

        public b(ResponseBody responseBody) {
            this.a = responseBody;
            this.b = z.d(new a(responseBody.source()));
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.a.contentType();
        }

        public void j() throws IOException {
            IOException iOException = this.f17048c;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody
        public j.o source() {
            return this.b;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends ResponseBody {
        @Nullable
        private final MediaType a;
        private final long b;

        public c(@Nullable MediaType mediaType, long j2) {
            this.a = mediaType;
            this.b = j2;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.a;
        }

        @Override // okhttp3.ResponseBody
        public j.o source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public l(q qVar, Object[] objArr, Call.Factory factory, h<ResponseBody, T> hVar) {
        this.a = qVar;
        this.b = objArr;
        this.f17042c = factory;
        this.f17043d = hVar;
    }

    private Call b() throws IOException {
        Call newCall = this.f17042c.newCall(this.a.a(this.b));
        Objects.requireNonNull(newCall, "Call.Factory returned null.");
        return newCall;
    }

    @GuardedBy("this")
    private Call c() throws IOException {
        Call call = this.f17045f;
        if (call != null) {
            return call;
        }
        Throwable th = this.f17046g;
        if (th != null) {
            if (!(th instanceof IOException)) {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw ((Error) th);
            }
            throw ((IOException) th);
        }
        try {
            Call b2 = b();
            this.f17045f = b2;
            return b2;
        } catch (IOException | Error | RuntimeException e2) {
            w.s(e2);
            this.f17046g = e2;
            throw e2;
        }
    }

    @Override // l.d
    /* renamed from: a */
    public l<T> clone() {
        return new l<>(this.a, this.b, this.f17042c, this.f17043d);
    }

    @Override // l.d
    public void cancel() {
        Call call;
        this.f17044e = true;
        synchronized (this) {
            call = this.f17045f;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public r<T> e(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new c(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return r.d(w.a(body), build);
            } finally {
                body.close();
            }
        } else if (code != 204 && code != 205) {
            b bVar = new b(body);
            try {
                return r.m(this.f17043d.convert(bVar), build);
            } catch (RuntimeException e2) {
                bVar.j();
                throw e2;
            }
        } else {
            body.close();
            return r.m(null, build);
        }
    }

    @Override // l.d
    public r<T> execute() throws IOException {
        Call c2;
        synchronized (this) {
            if (!this.f17047h) {
                this.f17047h = true;
                c2 = c();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f17044e) {
            c2.cancel();
        }
        return e(c2.execute());
    }

    @Override // l.d
    public void i(f<T> fVar) {
        Call call;
        Throwable th;
        Objects.requireNonNull(fVar, "callback == null");
        synchronized (this) {
            if (!this.f17047h) {
                this.f17047h = true;
                call = this.f17045f;
                th = this.f17046g;
                if (call == null && th == null) {
                    Call b2 = b();
                    this.f17045f = b2;
                    call = b2;
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            fVar.onFailure(this, th);
            return;
        }
        if (this.f17044e) {
            call.cancel();
        }
        call.enqueue(new a(fVar));
    }

    @Override // l.d
    public boolean isCanceled() {
        boolean z = true;
        if (this.f17044e) {
            return true;
        }
        synchronized (this) {
            Call call = this.f17045f;
            if (call == null || !call.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // l.d
    public synchronized boolean isExecuted() {
        return this.f17047h;
    }

    @Override // l.d
    public synchronized Request request() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create request.", e2);
        }
        return c().request();
    }

    @Override // l.d
    public synchronized o0 timeout() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create call.", e2);
        }
        return c().timeout();
    }
}
