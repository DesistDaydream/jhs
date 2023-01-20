package com.moor.imkf.lib.jsoup;

import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.parser.Parser;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public interface Connection {

    /* loaded from: classes2.dex */
    public interface Base<T extends Base> {
        T addHeader(String str, String str2);

        T cookie(String str, String str2);

        String cookie(String str);

        Map<String, String> cookies();

        boolean hasCookie(String str);

        boolean hasHeader(String str);

        boolean hasHeaderWithValue(String str, String str2);

        T header(String str, String str2);

        String header(String str);

        List<String> headers(String str);

        Map<String, String> headers();

        T method(Method method);

        Method method();

        Map<String, List<String>> multiHeaders();

        T removeCookie(String str);

        T removeHeader(String str);

        T url(URL url);

        URL url();
    }

    /* loaded from: classes2.dex */
    public interface KeyVal {
        KeyVal contentType(String str);

        String contentType();

        boolean hasInputStream();

        KeyVal inputStream(InputStream inputStream);

        InputStream inputStream();

        KeyVal key(String str);

        String key();

        KeyVal value(String str);

        String value();
    }

    /* loaded from: classes2.dex */
    public enum Method {
        GET(false),
        POST(true),
        PUT(true),
        DELETE(false),
        PATCH(true),
        HEAD(false),
        OPTIONS(false),
        TRACE(false);
        
        private final boolean hasBody;

        Method(boolean z) {
            this.hasBody = z;
        }

        public final boolean hasBody() {
            return this.hasBody;
        }
    }

    /* loaded from: classes2.dex */
    public interface Request extends Base<Request> {
        Request data(KeyVal keyVal);

        Collection<KeyVal> data();

        Request followRedirects(boolean z);

        boolean followRedirects();

        Request ignoreContentType(boolean z);

        boolean ignoreContentType();

        Request ignoreHttpErrors(boolean z);

        boolean ignoreHttpErrors();

        int maxBodySize();

        Request maxBodySize(int i2);

        Request parser(Parser parser);

        Parser parser();

        Request postDataCharset(String str);

        String postDataCharset();

        Request proxy(String str, int i2);

        Request proxy(Proxy proxy);

        Proxy proxy();

        Request requestBody(String str);

        String requestBody();

        SSLSocketFactory sslSocketFactory();

        void sslSocketFactory(SSLSocketFactory sSLSocketFactory);

        int timeout();

        Request timeout(int i2);
    }

    /* loaded from: classes2.dex */
    public interface Response extends Base<Response> {
        String body();

        byte[] bodyAsBytes();

        BufferedInputStream bodyStream();

        Response bufferUp();

        Response charset(String str);

        String charset();

        String contentType();

        Document parse() throws IOException;

        int statusCode();

        String statusMessage();
    }

    Connection cookie(String str, String str2);

    Connection cookies(Map<String, String> map);

    KeyVal data(String str);

    Connection data(String str, String str2);

    Connection data(String str, String str2, InputStream inputStream);

    Connection data(String str, String str2, InputStream inputStream, String str3);

    Connection data(Collection<KeyVal> collection);

    Connection data(Map<String, String> map);

    Connection data(String... strArr);

    Response execute() throws IOException;

    Connection followRedirects(boolean z);

    Document get() throws IOException;

    Connection header(String str, String str2);

    Connection headers(Map<String, String> map);

    Connection ignoreContentType(boolean z);

    Connection ignoreHttpErrors(boolean z);

    Connection maxBodySize(int i2);

    Connection method(Method method);

    Connection parser(Parser parser);

    Document post() throws IOException;

    Connection postDataCharset(String str);

    Connection proxy(String str, int i2);

    Connection proxy(Proxy proxy);

    Connection referrer(String str);

    Request request();

    Connection request(Request request);

    Connection requestBody(String str);

    Response response();

    Connection response(Response response);

    Connection sslSocketFactory(SSLSocketFactory sSLSocketFactory);

    Connection timeout(int i2);

    Connection url(String str);

    Connection url(URL url);

    Connection userAgent(String str);
}
