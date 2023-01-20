package okhttp3.internal.http;

import com.qiniu.android.http.request.Request;
import h.i;
import h.k2.g;
import h.k2.v.f0;
import h.q0;
import h.t2.u;
import j.m;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.ByteString;

@g(name = "HttpHeaders")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001a!\u0010\u001b\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001e\u001a\u00020\r*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001dH\u0007¢\u0006\u0004\b!\u0010\u001f\"\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\"\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lokhttp3/Headers;", "", "headerName", "", "Lokhttp3/Challenge;", "parseChallenges", "(Lokhttp3/Headers;Ljava/lang/String;)Ljava/util/List;", "Lj/m;", "", "result", "Lh/t1;", "readChallengeHeader", "(Lj/m;Ljava/util/List;)V", "", "skipCommasAndWhitespace", "(Lj/m;)Z", "", "prefix", "startsWith", "(Lj/m;B)Z", "readQuotedString", "(Lj/m;)Ljava/lang/String;", "readToken", "Lokhttp3/CookieJar;", "Lokhttp3/HttpUrl;", "url", "headers", "receiveHeaders", "(Lokhttp3/CookieJar;Lokhttp3/HttpUrl;Lokhttp3/Headers;)V", "Lokhttp3/Response;", "promisesBody", "(Lokhttp3/Response;)Z", "response", "hasBody", "Lokio/ByteString;", "TOKEN_DELIMITERS", "Lokio/ByteString;", "QUOTED_STRING_DELIMITERS", "okhttp"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.a aVar = ByteString.Companion;
        QUOTED_STRING_DELIMITERS = aVar.l("\"\\");
        TOKEN_DELIMITERS = aVar.l("\t ,=");
    }

    @i(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @q0(expression = "response.promisesBody()", imports = {}))
    public static final boolean hasBody(@d Response response) {
        return promisesBody(response);
    }

    @d
    public static final List<Challenge> parseChallenges(@d Headers headers, @d String str) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (u.K1(str, headers.name(i2), true)) {
                try {
                    readChallengeHeader(new m().B(headers.value(i2)), arrayList);
                } catch (EOFException e2) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e2);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(@d Response response) {
        if (f0.g(response.request().method(), Request.HttpMethodHEAD)) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && Util.headersContentLength(response) == -1 && !u.K1("chunked", Response.header$default(response, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0080, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0080, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void readChallengeHeader(j.m r7, java.util.List<okhttp3.Challenge> r8) throws java.io.EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            skipCommasAndWhitespace(r7)
            java.lang.String r1 = readToken(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = skipCommasAndWhitespace(r7)
            java.lang.String r3 = readToken(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.b0()
            if (r7 != 0) goto L1f
            return
        L1f:
            okhttp3.Challenge r7 = new okhttp3.Challenge
            java.util.Map r0 = h.a2.t0.z()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            byte r4 = (byte) r4
            int r5 = okhttp3.internal.Util.skipAll(r7, r4)
            boolean r6 = skipCommasAndWhitespace(r7)
            if (r2 != 0) goto L63
            if (r6 != 0) goto L41
            boolean r2 = r7.b0()
            if (r2 == 0) goto L63
        L41:
            okhttp3.Challenge r2 = new okhttp3.Challenge
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "="
            java.lang.String r3 = h.t2.u.g2(r3, r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L63:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = okhttp3.internal.Util.skipAll(r7, r4)
            int r5 = r5 + r6
        L6d:
            if (r3 != 0) goto L7e
            java.lang.String r3 = readToken(r7)
            boolean r5 = skipCommasAndWhitespace(r7)
            if (r5 == 0) goto L7a
            goto L80
        L7a:
            int r5 = okhttp3.internal.Util.skipAll(r7, r4)
        L7e:
            if (r5 != 0) goto L8b
        L80:
            okhttp3.Challenge r4 = new okhttp3.Challenge
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L8b:
            r6 = 1
            if (r5 <= r6) goto L8f
            return
        L8f:
            boolean r6 = skipCommasAndWhitespace(r7)
            if (r6 == 0) goto L96
            return
        L96:
            r6 = 34
            byte r6 = (byte) r6
            boolean r6 = startsWith(r7, r6)
            if (r6 == 0) goto La4
            java.lang.String r6 = readQuotedString(r7)
            goto La8
        La4:
            java.lang.String r6 = readToken(r7)
        La8:
            if (r6 == 0) goto Lc2
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lb3
            return
        Lb3:
            boolean r3 = skipCommasAndWhitespace(r7)
            if (r3 != 0) goto Lc0
            boolean r3 = r7.b0()
            if (r3 != 0) goto Lc0
            return
        Lc0:
            r3 = r0
            goto L6d
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.readChallengeHeader(j.m, java.util.List):void");
    }

    private static final String readQuotedString(m mVar) throws EOFException {
        byte b = (byte) 34;
        if (mVar.readByte() == b) {
            m mVar2 = new m();
            while (true) {
                long p = mVar.p(QUOTED_STRING_DELIMITERS);
                if (p == -1) {
                    return null;
                }
                if (mVar.m0(p) == b) {
                    mVar2.write(mVar, p);
                    mVar.readByte();
                    return mVar2.p0();
                } else if (mVar.O0() == p + 1) {
                    return null;
                } else {
                    mVar2.write(mVar, p);
                    mVar.readByte();
                    mVar2.write(mVar, 1L);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private static final String readToken(m mVar) {
        long p = mVar.p(TOKEN_DELIMITERS);
        if (p == -1) {
            p = mVar.O0();
        }
        if (p != 0) {
            return mVar.U(p);
        }
        return null;
    }

    public static final void receiveHeaders(@d CookieJar cookieJar, @d HttpUrl httpUrl, @d Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.Companion.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    private static final boolean skipCommasAndWhitespace(m mVar) {
        boolean z = false;
        while (!mVar.b0()) {
            byte m0 = mVar.m0(0L);
            if (m0 == 9 || m0 == 32) {
                mVar.readByte();
            } else if (m0 != 44) {
                break;
            } else {
                mVar.readByte();
                z = true;
            }
        }
        return z;
    }

    private static final boolean startsWith(m mVar, byte b) {
        return !mVar.b0() && mVar.m0(0L) == b;
    }
}
