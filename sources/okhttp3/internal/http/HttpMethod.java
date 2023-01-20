package okhttp3.internal.http;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.qiniu.android.http.request.Request;
import h.k2.k;
import h.k2.v.f0;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "", PushConstants.MZ_PUSH_MESSAGE_METHOD, "", "requiresRequestBody", "(Ljava/lang/String;)Z", "permitsRequestBody", "invalidatesCache", "redirectsWithBody", "redirectsToGet", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    @k
    public static final boolean permitsRequestBody(@d String str) {
        return (f0.g(str, "GET") || f0.g(str, Request.HttpMethodHEAD)) ? false : true;
    }

    @k
    public static final boolean requiresRequestBody(@d String str) {
        return f0.g(str, "POST") || f0.g(str, Request.HttpMethodPUT) || f0.g(str, "PATCH") || f0.g(str, "PROPPATCH") || f0.g(str, "REPORT");
    }

    public final boolean invalidatesCache(@d String str) {
        return f0.g(str, "POST") || f0.g(str, "PATCH") || f0.g(str, Request.HttpMethodPUT) || f0.g(str, "DELETE") || f0.g(str, "MOVE");
    }

    public final boolean redirectsToGet(@d String str) {
        return !f0.g(str, "PROPFIND");
    }

    public final boolean redirectsWithBody(@d String str) {
        return f0.g(str, "PROPFIND");
    }
}
