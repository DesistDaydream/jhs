package com.didichuxing.doraemonkit.kit.network.okhttp.interceptor;

import h.k2.v.u;
import java.io.IOException;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "<init>", "()V", "Companion", "DokitExtInterceptorProxy", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DokitExtInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    @d
    public static final String TAG = "DokitExtInterceptor";
    @e
    private static DokitExtInterceptorProxy dokitExtInterceptorProxy;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor$Companion;", "", "Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor$DokitExtInterceptorProxy;", "dokitExtInterceptorProxy", "Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor$DokitExtInterceptorProxy;", "getDokitExtInterceptorProxy", "()Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor$DokitExtInterceptorProxy;", "setDokitExtInterceptorProxy", "(Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor$DokitExtInterceptorProxy;)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        @e
        public final DokitExtInterceptorProxy getDokitExtInterceptorProxy() {
            return DokitExtInterceptor.dokitExtInterceptorProxy;
        }

        public final void setDokitExtInterceptorProxy(@e DokitExtInterceptorProxy dokitExtInterceptorProxy) {
            DokitExtInterceptor.dokitExtInterceptorProxy = dokitExtInterceptorProxy;
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor$DokitExtInterceptorProxy;", "", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public interface DokitExtInterceptorProxy {
        @d
        Response intercept(@d Interceptor.Chain chain);
    }

    @Override // okhttp3.Interceptor
    @d
    public Response intercept(@d Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}
