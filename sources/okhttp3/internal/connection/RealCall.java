package okhttp3.internal.connection;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.qiniu.android.collect.ReportItem;
import h.k2.v.f0;
import h.m;
import h.t1;
import j.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import k.e.a.d;
import kotlin.Metadata;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001h\u0018\u00002\u00020\u0001:\u0002z{B\u001f\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010Q\u001a\u00020\u0019\u0012\u0006\u0010^\u001a\u00020\u001d¢\u0006\u0004\bx\u0010yJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\b\u001a\u00028\u0000\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00028\u0000\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001dH\u0016¢\u0006\u0004\b'\u0010\u001fJ\u000f\u0010)\u001a\u00020 H\u0000¢\u0006\u0004\b(\u0010\"J\u001d\u0010+\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001d¢\u0006\u0004\b+\u0010,J\u0017\u00102\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\b0\u00101J\u0015\u00105\u001a\u00020\u00022\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J;\u0010<\u001a\u00028\u0000\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00028\u0000H\u0000¢\u0006\u0004\b:\u0010;J\u001b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b=\u0010\tJ\u0011\u0010B\u001a\u0004\u0018\u00010?H\u0000¢\u0006\u0004\b@\u0010AJ\r\u0010C\u001a\u00020\u0002¢\u0006\u0004\bC\u0010\u0004J\u0017\u0010G\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u001dH\u0000¢\u0006\u0004\bE\u0010FJ\r\u0010H\u001a\u00020\u001d¢\u0006\u0004\bH\u0010\u001fJ\u000f\u0010J\u001a\u00020\u0011H\u0000¢\u0006\u0004\bI\u0010\u0013R\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u00107\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010PR\u0019\u0010Q\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010\u001bR\u001c\u0010U\u001a\u00020T8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR$\u0010Y\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u00106R\u0019\u0010^\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010O\u001a\u0004\b_\u0010\u001fR\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010C\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010OR(\u0010d\u001a\u0004\u0018\u00010/2\b\u0010c\u001a\u0004\u0018\u00010/8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bd\u0010P\u001a\u0004\be\u0010fR\u0016\u0010g\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010OR\u0016\u0010\u0015\u001a\u00020h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010iR\u0019\u0010k\u001a\u00020j8\u0006@\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010OR\u0016\u0010t\u001a\u00020s8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR(\u00104\u001a\u0004\u0018\u0001032\b\u0010c\u001a\u0004\u0018\u0001038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b4\u0010Z\u001a\u0004\bv\u0010\\R\u0016\u0010w\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010O¨\u0006|"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "Lh/t1;", "callStart", "()V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, e.a, "callDone", "(Ljava/io/IOException;)Ljava/io/IOException;", "cause", "timeoutExit", "Lokhttp3/HttpUrl;", "url", "Lokhttp3/Address;", "createAddress", "(Lokhttp3/HttpUrl;)Lokhttp3/Address;", "", "toLoggableString", "()Ljava/lang/String;", "Lj/k;", "timeout", "()Lj/k;", "clone", "()Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "cancel", "", "isCanceled", "()Z", "Lokhttp3/Response;", "execute", "()Lokhttp3/Response;", "Lokhttp3/Callback;", "responseCallback", "enqueue", "(Lokhttp3/Callback;)V", "isExecuted", "getResponseWithInterceptorChain$okhttp", "getResponseWithInterceptorChain", "newExchangeFinder", "enterNetworkInterceptorExchange", "(Lokhttp3/Request;Z)V", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/connection/Exchange;", "initExchange$okhttp", "(Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/connection/Exchange;", "initExchange", "Lokhttp3/internal/connection/RealConnection;", "connection", "acquireConnectionNoEvents", "(Lokhttp3/internal/connection/RealConnection;)V", "exchange", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "messageDone", "noMoreExchanges$okhttp", "noMoreExchanges", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "()Ljava/net/Socket;", "releaseConnectionNoEvents", "timeoutEarlyExit", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "(Z)V", "exitNetworkInterceptorExchange", "retryAfterFailure", "redactedUrl$okhttp", "redactedUrl", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "canceled", "Z", "Lokhttp3/internal/connection/Exchange;", "originalRequest", "Lokhttp3/Request;", "getOriginalRequest", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "connectionToCancel", "Lokhttp3/internal/connection/RealConnection;", "getConnectionToCancel", "()Lokhttp3/internal/connection/RealConnection;", "setConnectionToCancel", "forWebSocket", "getForWebSocket", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<set-?>", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "requestBodyOpen", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "", "callStackTrace", "Ljava/lang/Object;", "responseBodyOpen", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "getConnection", "expectMoreExchanges", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;
    @d
    private final OkHttpClient client;
    @k.e.a.e
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    @k.e.a.e
    private volatile RealConnection connectionToCancel;
    @d
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;
    @k.e.a.e
    private Exchange interceptorScopedExchange;
    @d
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000R\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0010\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0017\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u001a\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "Lokhttp3/internal/connection/RealCall;", "other", "Lh/t1;", "reuseCallsPerHostFrom", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "Ljava/util/concurrent/ExecutorService;", "executorService", "executeOn", "(Ljava/util/concurrent/ExecutorService;)V", "run", "()V", "", "getHost", "()Ljava/lang/String;", ReportItem.RequestKeyHost, "Lokhttp3/Callback;", "responseCallback", "Lokhttp3/Callback;", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "request", "getCall", "()Lokhttp3/internal/connection/RealCall;", "call", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "callsPerHost", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class AsyncCall implements Runnable {
        @d
        private volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        private final Callback responseCallback;

        public AsyncCall(@d Callback callback) {
            RealCall.this = r1;
            this.responseCallback = callback;
        }

        public final void executeOn(@d ExecutorService executorService) {
            Dispatcher dispatcher = RealCall.this.getClient().dispatcher();
            if (Util.assertionsEnabled && Thread.holdsLock(dispatcher)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    RealCall.this.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.getClient().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th) {
                RealCall.this.getClient().dispatcher().finished$okhttp(this);
                throw th;
            }
        }

        @d
        public final RealCall getCall() {
            return RealCall.this;
        }

        @d
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        @d
        public final String getHost() {
            return RealCall.this.getOriginalRequest().url().host();
        }

        @d
        public final Request getRequest() {
            return RealCall.this.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(@d AsyncCall asyncCall) {
            this.callsPerHost = asyncCall.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            boolean z;
            IOException e2;
            Dispatcher dispatcher;
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName("OkHttp " + RealCall.this.redactedUrl$okhttp());
            try {
                enter();
                try {
                    z = true;
                    try {
                        this.responseCallback.onResponse(RealCall.this, RealCall.this.getResponseWithInterceptorChain$okhttp());
                        dispatcher = RealCall.this.getClient().dispatcher();
                    } catch (IOException e3) {
                        e2 = e3;
                        if (z) {
                            Platform.Companion.get().log("Callback failure for " + RealCall.this.toLoggableString(), 4, e2);
                        } else {
                            this.responseCallback.onFailure(RealCall.this, e2);
                        }
                        dispatcher = RealCall.this.getClient().dispatcher();
                        dispatcher.finished$okhttp(this);
                    } catch (Throwable th2) {
                        th = th2;
                        RealCall.this.cancel();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            m.a(iOException, th);
                            this.responseCallback.onFailure(RealCall.this, iOException);
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    z = false;
                } catch (Throwable th3) {
                    th = th3;
                    z = false;
                }
                dispatcher.finished$okhttp(this);
            } finally {
                currentThread.setName(name);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "", "callStackTrace", "Ljava/lang/Object;", "getCallStackTrace", "()Ljava/lang/Object;", "referent", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class CallReference extends WeakReference<RealCall> {
        @k.e.a.e
        private final Object callStackTrace;

        public CallReference(@d RealCall realCall, @k.e.a.e Object obj) {
            super(realCall);
            this.callStackTrace = obj;
        }

        @k.e.a.e
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [j.o0, okhttp3.internal.connection.RealCall$timeout$1] */
    public RealCall(@d OkHttpClient okHttpClient, @d Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.connectionPool = okHttpClient.connectionPool().getDelegate$okhttp();
        this.eventListener = okHttpClient.eventListenerFactory().create(this);
        ?? r4 = new k() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            {
                RealCall.this = this;
            }

            @Override // j.k
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        r4.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        t1 t1Var = t1.a;
        this.timeout = r4;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    private final <E extends IOException> E callDone(E e2) {
        Socket releaseConnectionNoEvents$okhttp;
        boolean z = Util.assertionsEnabled;
        if (z && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z && Thread.holdsLock(realConnection)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection);
            }
            synchronized (realConnection) {
                releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (releaseConnectionNoEvents$okhttp != null) {
                    Util.closeQuietly(releaseConnectionNoEvents$okhttp);
                }
                this.eventListener.connectionReleased(this, realConnection);
            } else {
                if (!(releaseConnectionNoEvents$okhttp == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        E e3 = (E) timeoutExit(e2);
        if (e2 != null) {
            this.eventListener.callFailed(this, e3);
        } else {
            this.eventListener.callEnd(this);
        }
        return e3;
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    private final Address createAddress(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private final <E extends IOException> E timeoutExit(E e2) {
        if (!this.timeoutEarlyExit && exit()) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            if (e2 != null) {
                interruptedIOException.initCause(e2);
            }
            return interruptedIOException;
        }
        return e2;
    }

    public final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl$okhttp());
        return sb.toString();
    }

    public final void acquireConnectionNoEvents(@d RealConnection realConnection) {
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        if (this.connection == null) {
            this.connection = realConnection;
            realConnection.getCalls().add(new CallReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        RealConnection realConnection = this.connectionToCancel;
        if (realConnection != null) {
            realConnection.cancel();
        }
        this.eventListener.canceled(this);
    }

    @Override // okhttp3.Call
    public void enqueue(@d Callback callback) {
        if (this.executed.compareAndSet(false, true)) {
            callStart();
            this.client.dispatcher().enqueue$okhttp(new AsyncCall(callback));
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void enterNetworkInterceptorExchange(@d Request request, boolean z) {
        if (this.interceptorScopedExchange == null) {
            synchronized (this) {
                if (!this.responseBodyOpen) {
                    if (!this.requestBodyOpen) {
                        t1 t1Var = t1.a;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                }
            }
            if (z) {
                this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    @d
    public Response execute() {
        if (this.executed.compareAndSet(false, true)) {
            enter();
            callStart();
            try {
                this.client.dispatcher().executed$okhttp(this);
                return getResponseWithInterceptorChain$okhttp();
            } finally {
                this.client.dispatcher().finished$okhttp(this);
            }
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        Exchange exchange;
        synchronized (this) {
            if (this.expectMoreExchanges) {
                t1 t1Var = t1.a;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z && (exchange = this.exchange) != null) {
            exchange.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    @d
    public final OkHttpClient getClient() {
        return this.client;
    }

    @k.e.a.e
    public final RealConnection getConnection() {
        return this.connection;
    }

    @k.e.a.e
    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    @d
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    @k.e.a.e
    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    @d
    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response getResponseWithInterceptorChain$okhttp() throws java.io.IOException {
        /*
            r10 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            okhttp3.OkHttpClient r0 = r10.client
            java.util.List r0 = r0.interceptors()
            h.a2.y.q0(r2, r0)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            okhttp3.CookieJar r1 = r1.cookieJar()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            okhttp3.Cache r1 = r1.cache()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = okhttp3.internal.connection.ConnectInterceptor.INSTANCE
            r2.add(r0)
            boolean r0 = r10.forWebSocket
            if (r0 != 0) goto L46
            okhttp3.OkHttpClient r0 = r10.client
            java.util.List r0 = r0.networkInterceptors()
            h.a2.y.q0(r2, r0)
        L46:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r1 = r10.forWebSocket
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.RealInterceptorChain r9 = new okhttp3.internal.http.RealInterceptorChain
            r3 = 0
            r4 = 0
            okhttp3.Request r5 = r10.originalRequest
            okhttp3.OkHttpClient r0 = r10.client
            int r6 = r0.connectTimeoutMillis()
            okhttp3.OkHttpClient r0 = r10.client
            int r7 = r0.readTimeoutMillis()
            okhttp3.OkHttpClient r0 = r10.client
            int r8 = r0.writeTimeoutMillis()
            r0 = r9
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            okhttp3.Request r2 = r10.originalRequest     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            okhttp3.Response r2 = r9.proceed(r2)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            boolean r3 = r10.isCanceled()     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            if (r3 != 0) goto L7f
            r10.noMoreExchanges$okhttp(r1)
            return r2
        L7f:
            okhttp3.internal.Util.closeQuietly(r2)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            throw r2     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
        L8a:
            r2 = move-exception
            goto La0
        L8c:
            r0 = move-exception
            r2 = 1
            java.io.IOException r0 = r10.noMoreExchanges$okhttp(r0)     // Catch: java.lang.Throwable -> L9d
            if (r0 != 0) goto L9c
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L9d
            throw r0     // Catch: java.lang.Throwable -> L9d
        L9c:
            throw r0     // Catch: java.lang.Throwable -> L9d
        L9d:
            r0 = move-exception
            r2 = r0
            r0 = 1
        La0:
            if (r0 != 0) goto La5
            r10.noMoreExchanges$okhttp(r1)
        La5:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.getResponseWithInterceptorChain$okhttp():okhttp3.Response");
    }

    @d
    public final Exchange initExchange$okhttp(@d RealInterceptorChain realInterceptorChain) {
        synchronized (this) {
            if (this.expectMoreExchanges) {
                if (!this.responseBodyOpen) {
                    if (!this.requestBodyOpen) {
                        t1 t1Var = t1.a;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find(this.client, realInterceptorChain));
        this.interceptorScopedExchange = exchange;
        this.exchange = exchange;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return exchange;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x001e A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:57:0x000f, B:66:0x001e, B:68:0x0022, B:69:0x0024, B:71:0x0028, B:76:0x0031, B:78:0x0035, B:84:0x003e, B:63:0x0018), top: B:96:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0022 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:57:0x000f, B:66:0x001e, B:68:0x0022, B:69:0x0024, B:71:0x0028, B:76:0x0031, B:78:0x0035, B:84:0x003e, B:63:0x0018), top: B:96:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <E extends java.io.IOException> E messageDone$okhttp(@k.e.a.d okhttp3.internal.connection.Exchange r3, boolean r4, boolean r5, E r6) {
        /*
            r2 = this;
            okhttp3.internal.connection.Exchange r0 = r2.exchange
            boolean r3 = h.k2.v.f0.g(r3, r0)
            r0 = 1
            r3 = r3 ^ r0
            if (r3 == 0) goto Lb
            return r6
        Lb:
            monitor-enter(r2)
            r3 = 0
            if (r4 == 0) goto L16
            boolean r1 = r2.requestBodyOpen     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L1c
            goto L16
        L14:
            r3 = move-exception
            goto L55
        L16:
            if (r5 == 0) goto L3d
            boolean r1 = r2.responseBodyOpen     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L3d
        L1c:
            if (r4 == 0) goto L20
            r2.requestBodyOpen = r3     // Catch: java.lang.Throwable -> L14
        L20:
            if (r5 == 0) goto L24
            r2.responseBodyOpen = r3     // Catch: java.lang.Throwable -> L14
        L24:
            boolean r4 = r2.requestBodyOpen     // Catch: java.lang.Throwable -> L14
            if (r4 != 0) goto L2e
            boolean r5 = r2.responseBodyOpen     // Catch: java.lang.Throwable -> L14
            if (r5 != 0) goto L2e
            r5 = 1
            goto L2f
        L2e:
            r5 = 0
        L2f:
            if (r4 != 0) goto L3a
            boolean r4 = r2.responseBodyOpen     // Catch: java.lang.Throwable -> L14
            if (r4 != 0) goto L3a
            boolean r4 = r2.expectMoreExchanges     // Catch: java.lang.Throwable -> L14
            if (r4 != 0) goto L3a
            goto L3b
        L3a:
            r0 = 0
        L3b:
            r3 = r5
            goto L3e
        L3d:
            r0 = 0
        L3e:
            h.t1 r4 = h.t1.a     // Catch: java.lang.Throwable -> L14
            monitor-exit(r2)
            if (r3 == 0) goto L4d
            r3 = 0
            r2.exchange = r3
            okhttp3.internal.connection.RealConnection r3 = r2.connection
            if (r3 == 0) goto L4d
            r3.incrementSuccessCount$okhttp()
        L4d:
            if (r0 == 0) goto L54
            java.io.IOException r3 = r2.callDone(r6)
            return r3
        L54:
            return r6
        L55:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.messageDone$okhttp(okhttp3.internal.connection.Exchange, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    @k.e.a.e
    public final IOException noMoreExchanges$okhttp(@k.e.a.e IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z = true;
                }
            }
            t1 t1Var = t1.a;
        }
        return z ? callDone(iOException) : iOException;
    }

    @d
    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @k.e.a.e
    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        Iterator<Reference<RealCall>> it = calls.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (f0.g(it.next().get(), this)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            calls.remove(i2);
            this.connection = null;
            if (calls.isEmpty()) {
                realConnection.setIdleAtNs$okhttp(System.nanoTime());
                if (this.connectionPool.connectionBecameIdle(realConnection)) {
                    return realConnection.socket();
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    @d
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        return this.exchangeFinder.retryAfterFailure();
    }

    public final void setConnectionToCancel(@k.e.a.e RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    public final void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    @d
    public k timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    @d
    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
