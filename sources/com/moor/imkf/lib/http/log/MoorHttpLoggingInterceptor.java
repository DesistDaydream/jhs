package com.moor.imkf.lib.http.log;

import com.moor.imkf.lib.MoorBaseLibManager;
import com.moor.imkf.lib.jsoup.helper.HttpConnection;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.lib.utils.aes.MoorAesUtils;
import j.m;
import j.o;
import j.u;
import java.io.EOFException;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;

/* loaded from: classes2.dex */
public final class MoorHttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private String iv = "moorrongliansdkv";
    private String offset = "1234567890123456";
    private final Logger logger = new MoorHttpLogger();

    /* loaded from: classes2.dex */
    public interface Logger {
        void log(String str);
    }

    private static boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get(HttpConnection.CONTENT_ENCODING);
        return (str == null || "identity".equalsIgnoreCase(str) || "gzip".equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean isPlaintext(m mVar) {
        try {
            m mVar2 = new m();
            mVar.H(mVar2, 0L, mVar.O0() < 64 ? mVar.O0() : 64L);
            for (int i2 = 0; i2 < 16; i2++) {
                if (mVar2.b0()) {
                    return true;
                }
                int h0 = mVar2.h0();
                if (Character.isISOControl(h0) && !Character.isWhitespace(h0)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        u uVar;
        Request request = chain.request();
        RequestBody body = request.body();
        boolean z = body != null;
        this.logger.log("--> " + request.method() + ' ' + request.url());
        if (!z) {
            this.logger.log("--> END REQUEST" + request.method());
        } else if (bodyHasUnknownEncoding(request.headers())) {
            this.logger.log("--> END REQUEST" + request.method() + " (encoded body omitted)");
        } else {
            m mVar = new m();
            body.writeTo(mVar);
            Charset charset = UTF8;
            MediaType contentType = body.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            this.logger.log("");
            try {
                if (isPlaintext(mVar)) {
                    try {
                        if (MoorBaseLibManager.getInstance().isDebug()) {
                            MoorLogUtils.json(URLDecoder.decode(mVar.g0(charset), "UTF-8"));
                        } else {
                            MoorLogUtils.json(request.url() + "---request--->:" + MoorAesUtils.encrypt_AES(this.iv, mVar.clone().g0(charset), this.offset));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        this.logger.log(URLDecoder.decode(mVar.g0(charset), "UTF-8"));
                    }
                    this.logger.log("");
                    this.logger.log("--> END REQUEST" + request.method());
                } else {
                    this.logger.log("--> END REQUEST" + request.method());
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        try {
            Response proceed = chain.proceed(request);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            this.logger.log("");
            Logger logger = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("<--------- ");
            sb.append(proceed.code());
            if (proceed.message().isEmpty()) {
                str = "";
            } else {
                str = ' ' + proceed.message();
            }
            sb.append(str);
            sb.append(' ');
            sb.append(proceed.request().url());
            logger.log(sb.toString());
            Headers headers = proceed.headers();
            if (!HttpHeaders.hasBody(proceed)) {
                this.logger.log("<--------- END HTTP");
            } else if (bodyHasUnknownEncoding(proceed.headers())) {
                this.logger.log("<--------- END HTTP (encoded body omitted)");
            } else {
                o source = body2.source();
                source.G(Long.MAX_VALUE);
                m u = source.u();
                if ("gzip".equalsIgnoreCase(headers.get(HttpConnection.CONTENT_ENCODING))) {
                    u.O0();
                    u uVar2 = null;
                    try {
                        uVar = new u(u.clone());
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        u = new m();
                        u.E(uVar);
                        uVar.close();
                    } catch (Throwable th2) {
                        th = th2;
                        uVar2 = uVar;
                        if (uVar2 != null) {
                            uVar2.close();
                        }
                        throw th;
                    }
                }
                Charset charset2 = UTF8;
                MediaType contentType2 = body2.contentType();
                if (contentType2 != null) {
                    charset2 = contentType2.charset(charset2);
                }
                if (!isPlaintext(u)) {
                    this.logger.log("");
                    this.logger.log("<--------- END HTTP");
                    return proceed;
                }
                if (contentLength != 0) {
                    this.logger.log("");
                    try {
                        if (MoorBaseLibManager.getInstance().isDebug()) {
                            MoorLogUtils.json(u.clone().g0(charset2));
                        } else {
                            MoorLogUtils.json(request.url() + "---response--->:" + MoorAesUtils.encrypt_AES(this.iv, u.clone().g0(charset2), this.offset));
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        this.logger.log(u.clone().g0(charset2));
                    }
                    this.logger.log("");
                }
                this.logger.log("<--------- END HTTP");
            }
            return proceed;
        } catch (Exception e5) {
            this.logger.log("<--------- HTTP FAILED: " + e5);
            throw e5;
        }
    }
}
