package com.moor.imkf.lib.jsoup.helper;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.jsoup.Connection;
import com.moor.imkf.lib.jsoup.UncheckedIOException;
import com.moor.imkf.lib.jsoup.internal.ConstrainableInputStream;
import com.moor.imkf.lib.jsoup.internal.Normalizer;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.parser.Parser;
import com.moor.imkf.lib.jsoup.parser.TokenQueue;
import h.t2.y;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public class HttpConnection implements Connection {
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";
    private static final String DefaultUploadType = "application/octet-stream";
    public static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded";
    private static final int HTTP_TEMP_REDIR = 307;
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final String USER_AGENT = "User-Agent";
    private Connection.Request req = new Request();
    private Connection.Response res = new Response();

    /* loaded from: classes2.dex */
    public static abstract class Base<T extends Connection.Base> implements Connection.Base<T> {
        public Map<String, String> cookies;
        public Map<String, List<String>> headers;
        public Connection.Method method;
        public URL url;

        private static String fixHeaderEncoding(String str) {
            try {
                byte[] bytes = str.getBytes("ISO-8859-1");
                return !looksLikeUtf8(bytes) ? str : new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }

        private List<String> getHeadersCaseInsensitive(String str) {
            Validate.notNull(str);
            for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return Collections.emptyList();
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
            if ((((r8[1] & 255) == 187) & ((r8[2] & 255) == 191)) != false) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static boolean looksLikeUtf8(byte[] r8) {
            /*
                int r0 = r8.length
                r1 = 3
                r2 = 1
                r3 = 0
                if (r0 < r1) goto L29
                r0 = r8[r3]
                r0 = r0 & 255(0xff, float:3.57E-43)
                r4 = 239(0xef, float:3.35E-43)
                if (r0 != r4) goto L29
                r0 = r8[r2]
                r0 = r0 & 255(0xff, float:3.57E-43)
                r4 = 187(0xbb, float:2.62E-43)
                if (r0 != r4) goto L18
                r0 = 1
                goto L19
            L18:
                r0 = 0
            L19:
                r4 = 2
                r4 = r8[r4]
                r4 = r4 & 255(0xff, float:3.57E-43)
                r5 = 191(0xbf, float:2.68E-43)
                if (r4 != r5) goto L24
                r4 = 1
                goto L25
            L24:
                r4 = 0
            L25:
                r0 = r0 & r4
                if (r0 == 0) goto L29
                goto L2a
            L29:
                r1 = 0
            L2a:
                int r0 = r8.length
            L2b:
                if (r1 >= r0) goto L61
                r4 = r8[r1]
                r5 = r4 & 128(0x80, float:1.794E-43)
                if (r5 != 0) goto L34
                goto L5e
            L34:
                r5 = r4 & 224(0xe0, float:3.14E-43)
                r6 = 192(0xc0, float:2.69E-43)
                if (r5 != r6) goto L3d
                int r4 = r1 + 1
                goto L4e
            L3d:
                r5 = r4 & 240(0xf0, float:3.36E-43)
                r7 = 224(0xe0, float:3.14E-43)
                if (r5 != r7) goto L46
                int r4 = r1 + 2
                goto L4e
            L46:
                r4 = r4 & 248(0xf8, float:3.48E-43)
                r5 = 240(0xf0, float:3.36E-43)
                if (r4 != r5) goto L60
                int r4 = r1 + 3
            L4e:
                int r5 = r8.length
                if (r4 < r5) goto L52
                return r3
            L52:
                if (r1 >= r4) goto L5e
                int r1 = r1 + 1
                r5 = r8[r1]
                r5 = r5 & r6
                r7 = 128(0x80, float:1.794E-43)
                if (r5 == r7) goto L52
                return r3
            L5e:
                int r1 = r1 + r2
                goto L2b
            L60:
                return r3
            L61:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.jsoup.helper.HttpConnection.Base.looksLikeUtf8(byte[]):boolean");
        }

        private Map.Entry<String, List<String>> scanHeaders(String str) {
            String lowerCase = Normalizer.lowerCase(str);
            for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
                if (Normalizer.lowerCase(entry.getKey()).equals(lowerCase)) {
                    return entry;
                }
            }
            return null;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public T addHeader(String str, String str2) {
            Validate.notEmpty(str);
            if (str2 == null) {
                str2 = "";
            }
            List<String> headers = headers(str);
            if (headers.isEmpty()) {
                headers = new ArrayList<>();
                this.headers.put(str, headers);
            }
            headers.add(fixHeaderEncoding(str2));
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public String cookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.cookies.get(str);
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public Map<String, String> cookies() {
            return this.cookies;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public boolean hasCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.cookies.containsKey(str);
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public boolean hasHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            return !getHeadersCaseInsensitive(str).isEmpty();
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public boolean hasHeaderWithValue(String str, String str2) {
            Validate.notEmpty(str);
            Validate.notEmpty(str2);
            for (String str3 : headers(str)) {
                if (str2.equalsIgnoreCase(str3)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public String header(String str) {
            Validate.notNull(str, "Header name must not be null");
            List<String> headersCaseInsensitive = getHeadersCaseInsensitive(str);
            if (headersCaseInsensitive.size() > 0) {
                return StringUtil.join(headersCaseInsensitive, ", ");
            }
            return null;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public List<String> headers(String str) {
            Validate.notEmpty(str);
            return getHeadersCaseInsensitive(str);
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public Connection.Method method() {
            return this.method;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public Map<String, List<String>> multiHeaders() {
            return this.headers;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public T removeCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            this.cookies.remove(str);
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public T removeHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            Map.Entry<String, List<String>> scanHeaders = scanHeaders(str);
            if (scanHeaders != null) {
                this.headers.remove(scanHeaders.getKey());
            }
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public URL url() {
            return this.url;
        }

        private Base() {
            this.headers = new LinkedHashMap();
            this.cookies = new LinkedHashMap();
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public T method(Connection.Method method) {
            Validate.notNull(method, "Method must not be null");
            this.method = method;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public T url(URL url) {
            Validate.notNull(url, "URL must not be null");
            this.url = url;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public T cookie(String str, String str2) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            Validate.notNull(str2, "Cookie value must not be null");
            this.cookies.put(str, str2);
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public Map<String, String> headers() {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.headers.size());
            for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value.size() > 0) {
                    linkedHashMap.put(key, value.get(0));
                }
            }
            return linkedHashMap;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Base
        public T header(String str, String str2) {
            Validate.notEmpty(str, "Header name must not be empty");
            removeHeader(str);
            addHeader(str, str2);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class KeyVal implements Connection.KeyVal {
        private String contentType;
        private String key;
        private InputStream stream;
        private String value;

        private KeyVal() {
        }

        public static KeyVal create(String str, String str2) {
            return new KeyVal().key(str).value(str2);
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.KeyVal
        public Connection.KeyVal contentType(String str) {
            Validate.notEmpty(str);
            this.contentType = str;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.KeyVal
        public boolean hasInputStream() {
            return this.stream != null;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public static KeyVal create(String str, String str2, InputStream inputStream) {
            return new KeyVal().key(str).value(str2).inputStream(inputStream);
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.KeyVal
        public KeyVal inputStream(InputStream inputStream) {
            Validate.notNull(this.value, "Data input stream must not be null");
            this.stream = inputStream;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.KeyVal
        public KeyVal key(String str) {
            Validate.notEmpty(str, "Data key must not be empty");
            this.key = str;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.KeyVal
        public KeyVal value(String str) {
            Validate.notNull(str, "Data value must not be null");
            this.value = str;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.KeyVal
        public String contentType() {
            return this.contentType;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.KeyVal
        public InputStream inputStream() {
            return this.stream;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.KeyVal
        public String key() {
            return this.key;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.KeyVal
        public String value() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public static class Request extends Base<Connection.Request> implements Connection.Request {
        private String body;
        private Collection<Connection.KeyVal> data;
        private boolean followRedirects;
        private boolean ignoreContentType;
        private boolean ignoreHttpErrors;
        private int maxBodySizeBytes;
        private Parser parser;
        private boolean parserDefined;
        private String postDataCharset;
        private Proxy proxy;
        private SSLSocketFactory sslSocketFactory;
        private int timeoutMilliseconds;

        public Request() {
            super();
            this.body = null;
            this.ignoreHttpErrors = false;
            this.ignoreContentType = false;
            this.parserDefined = false;
            this.postDataCharset = "UTF-8";
            this.timeoutMilliseconds = 30000;
            this.maxBodySizeBytes = 2097152;
            this.followRedirects = true;
            this.data = new ArrayList();
            this.method = Connection.Method.GET;
            addHeader("Accept-Encoding", "gzip");
            addHeader(HttpConnection.USER_AGENT, HttpConnection.DEFAULT_UA);
            this.parser = Parser.htmlParser();
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public boolean followRedirects() {
            return this.followRedirects;
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ List headers(String str) {
            return super.headers(str);
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public boolean ignoreContentType() {
            return this.ignoreContentType;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public boolean ignoreHttpErrors() {
            return this.ignoreHttpErrors;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public int maxBodySize() {
            return this.maxBodySizeBytes;
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map multiHeaders() {
            return super.multiHeaders();
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Connection.Request postDataCharset(String str) {
            Validate.notNull(str, "Charset must not be null");
            if (Charset.isSupported(str)) {
                this.postDataCharset = str;
                return this;
            }
            throw new IllegalCharsetNameException(str);
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Connection.Request requestBody(String str) {
            this.body = str;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public SSLSocketFactory sslSocketFactory() {
            return this.sslSocketFactory;
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Request data(Connection.KeyVal keyVal) {
            Validate.notNull(keyVal, "Key val must not be null");
            this.data.add(keyVal);
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Connection.Request followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Connection.Request ignoreContentType(boolean z) {
            this.ignoreContentType = z;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Connection.Request ignoreHttpErrors(boolean z) {
            this.ignoreHttpErrors = z;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Connection.Request maxBodySize(int i2) {
            Validate.isTrue(i2 >= 0, "maxSize must be 0 (unlimited) or larger");
            this.maxBodySizeBytes = i2;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Request parser(Parser parser) {
            this.parser = parser;
            this.parserDefined = true;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public String requestBody() {
            return this.body;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public void sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactory = sSLSocketFactory;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public int timeout() {
            return this.timeoutMilliseconds;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Proxy proxy() {
            return this.proxy;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Request timeout(int i2) {
            Validate.isTrue(i2 >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.timeoutMilliseconds = i2;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Collection<Connection.KeyVal> data() {
            return this.data;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Parser parser() {
            return this.parser;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Request proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public String postDataCharset() {
            return this.postDataCharset;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Request
        public Request proxy(String str, int i2) {
            this.proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2));
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class Response extends Base<Connection.Response> implements Connection.Response {
        private static final String LOCATION = "Location";
        private static final int MAX_REDIRECTS = 20;
        private static final Pattern xmlContentTypeRxp = Pattern.compile("(application|text)/\\w*\\+?xml.*");
        private InputStream bodyStream;
        private ByteBuffer byteData;
        private String charset;
        private HttpURLConnection conn;
        private String contentType;
        private boolean executed;
        private boolean inputStreamRead;
        private int numRedirects;
        private Connection.Request req;
        private int statusCode;
        private String statusMessage;

        public Response() {
            super();
            this.executed = false;
            this.inputStreamRead = false;
            this.numRedirects = 0;
        }

        private static HttpURLConnection createConnection(Connection.Request request) throws IOException {
            URLConnection openConnection;
            if (request.proxy() == null) {
                openConnection = request.url().openConnection();
            } else {
                openConnection = request.url().openConnection(request.proxy());
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod(request.method().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(request.timeout());
            httpURLConnection.setReadTimeout(request.timeout() / 2);
            if (request.sslSocketFactory() != null && (httpURLConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(request.sslSocketFactory());
            }
            if (request.method().hasBody()) {
                httpURLConnection.setDoOutput(true);
            }
            if (request.cookies().size() > 0) {
                httpURLConnection.addRequestProperty("Cookie", getRequestCookieString(request));
            }
            for (Map.Entry<String, List<String>> entry : request.multiHeaders().entrySet()) {
                for (String str : entry.getValue()) {
                    httpURLConnection.addRequestProperty(entry.getKey(), str);
                }
            }
            return httpURLConnection;
        }

        private static LinkedHashMap<String, List<String>> createHeaderMap(HttpURLConnection httpURLConnection) {
            LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<>();
            int i2 = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
                String headerField = httpURLConnection.getHeaderField(i2);
                if (headerFieldKey == null && headerField == null) {
                    return linkedHashMap;
                }
                i2++;
                if (headerFieldKey != null && headerField != null) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        linkedHashMap.get(headerFieldKey).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
        }

        public static Response execute(Connection.Request request) throws IOException {
            return execute(request, null);
        }

        private static String getRequestCookieString(Connection.Request request) {
            StringBuilder borrowBuilder = StringUtil.borrowBuilder();
            boolean z = true;
            for (Map.Entry<String, String> entry : request.cookies().entrySet()) {
                if (z) {
                    z = false;
                } else {
                    borrowBuilder.append("; ");
                }
                borrowBuilder.append(entry.getKey());
                borrowBuilder.append('=');
                borrowBuilder.append(entry.getValue());
            }
            return StringUtil.releaseBuilder(borrowBuilder);
        }

        private void prepareByteData() {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            if (this.byteData == null) {
                Validate.isFalse(this.inputStreamRead, "Request has already been read (with .parse())");
                try {
                    try {
                        this.byteData = DataUtil.readToByteBuffer(this.bodyStream, this.req.maxBodySize());
                    } catch (IOException e2) {
                        throw new UncheckedIOException(e2);
                    }
                } finally {
                    this.inputStreamRead = true;
                    safeClose();
                }
            }
        }

        private void safeClose() {
            InputStream inputStream = this.bodyStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.bodyStream = null;
                    throw th;
                }
                this.bodyStream = null;
            }
            HttpURLConnection httpURLConnection = this.conn;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.conn = null;
            }
        }

        private static void serialiseRequestUrl(Connection.Request request) throws IOException {
            boolean z;
            URL url = request.url();
            StringBuilder borrowBuilder = StringUtil.borrowBuilder();
            borrowBuilder.append(url.getProtocol());
            borrowBuilder.append("://");
            borrowBuilder.append(url.getAuthority());
            borrowBuilder.append(url.getPath());
            borrowBuilder.append("?");
            if (url.getQuery() != null) {
                borrowBuilder.append(url.getQuery());
                z = false;
            } else {
                z = true;
            }
            for (Connection.KeyVal keyVal : request.data()) {
                Validate.isFalse(keyVal.hasInputStream(), "InputStream data not supported in URL query string.");
                if (z) {
                    z = false;
                } else {
                    borrowBuilder.append(y.f15690c);
                }
                borrowBuilder.append(URLEncoder.encode(keyVal.key(), "UTF-8"));
                borrowBuilder.append('=');
                borrowBuilder.append(URLEncoder.encode(keyVal.value(), "UTF-8"));
            }
            request.url(new URL(StringUtil.releaseBuilder(borrowBuilder)));
            request.data().clear();
        }

        private static String setOutputContentType(Connection.Request request) {
            if (!request.hasHeader("Content-Type")) {
                if (HttpConnection.needsMultipart(request)) {
                    String mimeBoundary = DataUtil.mimeBoundary();
                    request.header("Content-Type", "multipart/form-data; boundary=" + mimeBoundary);
                    return mimeBoundary;
                }
                request.header("Content-Type", "application/x-www-form-urlencoded; charset=" + request.postDataCharset());
            } else if (request.header("Content-Type").contains(HttpConnection.MULTIPART_FORM_DATA) && !request.header("Content-Type").contains("boundary")) {
                String mimeBoundary2 = DataUtil.mimeBoundary();
                request.header("Content-Type", "multipart/form-data; boundary=" + mimeBoundary2);
                return mimeBoundary2;
            }
            return null;
        }

        private void setupFromConnection(HttpURLConnection httpURLConnection, Response response) throws IOException {
            this.conn = httpURLConnection;
            this.method = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.url = httpURLConnection.getURL();
            this.statusCode = httpURLConnection.getResponseCode();
            this.statusMessage = httpURLConnection.getResponseMessage();
            this.contentType = httpURLConnection.getContentType();
            processResponseHeaders(createHeaderMap(httpURLConnection));
            if (response != null) {
                for (Map.Entry entry : response.cookies().entrySet()) {
                    if (!hasCookie((String) entry.getKey())) {
                        cookie((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                response.safeClose();
            }
        }

        private static void writePost(Connection.Request request, OutputStream outputStream, String str) throws IOException {
            Collection<Connection.KeyVal> data = request.data();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, request.postDataCharset()));
            if (str != null) {
                for (Connection.KeyVal keyVal : data) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(HttpConnection.encodeMimeName(keyVal.key()));
                    bufferedWriter.write("\"");
                    if (keyVal.hasInputStream()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(HttpConnection.encodeMimeName(keyVal.value()));
                        bufferedWriter.write("\"\r\nContent-Type: ");
                        bufferedWriter.write(keyVal.contentType() != null ? keyVal.contentType() : "application/octet-stream");
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.flush();
                        DataUtil.crossStreams(keyVal.inputStream(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(keyVal.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (request.requestBody() != null) {
                bufferedWriter.write(request.requestBody());
            } else {
                boolean z = true;
                for (Connection.KeyVal keyVal2 : data) {
                    if (z) {
                        z = false;
                    } else {
                        bufferedWriter.append(y.f15690c);
                    }
                    bufferedWriter.write(URLEncoder.encode(keyVal2.key(), request.postDataCharset()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(keyVal2.value(), request.postDataCharset()));
                }
            }
            bufferedWriter.close();
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Response
        public String body() {
            String charBuffer;
            prepareByteData();
            String str = this.charset;
            if (str == null) {
                charBuffer = Charset.forName("UTF-8").decode(this.byteData).toString();
            } else {
                charBuffer = Charset.forName(str).decode(this.byteData).toString();
            }
            this.byteData.rewind();
            return charBuffer;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Response
        public byte[] bodyAsBytes() {
            prepareByteData();
            return this.byteData.array();
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Response
        public BufferedInputStream bodyStream() {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            Validate.isFalse(this.inputStreamRead, "Request has already been read");
            this.inputStreamRead = true;
            return ConstrainableInputStream.wrap(this.bodyStream, 32768, this.req.maxBodySize());
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Response
        public Connection.Response bufferUp() {
            prepareByteData();
            return this;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Response
        public String contentType() {
            return this.contentType;
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ List headers(String str) {
            return super.headers(str);
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map multiHeaders() {
            return super.multiHeaders();
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Response
        public Document parse() throws IOException {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (this.byteData != null) {
                this.bodyStream = new ByteArrayInputStream(this.byteData.array());
                this.inputStreamRead = false;
            }
            Validate.isFalse(this.inputStreamRead, "Input stream already read and parsed, cannot re-read.");
            Document parseInputStream = DataUtil.parseInputStream(this.bodyStream, this.charset, this.url.toExternalForm(), this.req.parser());
            this.charset = parseInputStream.outputSettings().charset().name();
            this.inputStreamRead = true;
            safeClose();
            return parseInputStream;
        }

        public void processResponseHeaders(Map<String, List<String>> map) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    List<String> value = entry.getValue();
                    if (key.equalsIgnoreCase("Set-Cookie")) {
                        for (String str : value) {
                            if (str != null) {
                                TokenQueue tokenQueue = new TokenQueue(str);
                                String trim = tokenQueue.chompTo("=").trim();
                                String trim2 = tokenQueue.consumeTo(";").trim();
                                if (trim.length() > 0) {
                                    cookie(trim, trim2);
                                }
                            }
                        }
                    }
                    for (String str2 : value) {
                        addHeader(key, str2);
                    }
                }
            }
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Response
        public int statusCode() {
            return this.statusCode;
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Response
        public String statusMessage() {
            return this.statusMessage;
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x0162, code lost:
            if (com.moor.imkf.lib.jsoup.helper.HttpConnection.Response.xmlContentTypeRxp.matcher(r10).matches() == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0166, code lost:
            if ((r9 instanceof com.moor.imkf.lib.jsoup.helper.HttpConnection.Request) == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x016f, code lost:
            if (((com.moor.imkf.lib.jsoup.helper.HttpConnection.Request) r9).parserDefined != false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0171, code lost:
            r9.parser(com.moor.imkf.lib.jsoup.parser.Parser.xmlParser());
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008b A[Catch: IOException -> 0x01fe, TryCatch #0 {IOException -> 0x01fe, blocks: (B:24:0x0082, B:26:0x008b, B:27:0x0092), top: B:97:0x0082 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static com.moor.imkf.lib.jsoup.helper.HttpConnection.Response execute(com.moor.imkf.lib.jsoup.Connection.Request r9, com.moor.imkf.lib.jsoup.helper.HttpConnection.Response r10) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 517
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.jsoup.helper.HttpConnection.Response.execute(com.moor.imkf.lib.jsoup.Connection$Request, com.moor.imkf.lib.jsoup.helper.HttpConnection$Response):com.moor.imkf.lib.jsoup.helper.HttpConnection$Response");
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Response
        public String charset() {
            return this.charset;
        }

        @Override // com.moor.imkf.lib.jsoup.helper.HttpConnection.Base, com.moor.imkf.lib.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        @Override // com.moor.imkf.lib.jsoup.Connection.Response
        public Response charset(String str) {
            this.charset = str;
            return this;
        }

        private Response(Response response) throws IOException {
            super();
            this.executed = false;
            this.inputStreamRead = false;
            this.numRedirects = 0;
            if (response != null) {
                int i2 = response.numRedirects + 1;
                this.numRedirects = i2;
                if (i2 >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", response.url()));
                }
            }
        }
    }

    public static Connection connect(String str) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(str);
        return httpConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String encodeMimeName(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\"", "%22");
    }

    private static String encodeUrl(String str) {
        try {
            return encodeUrl(new URL(str)).toExternalForm();
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needsMultipart(Connection.Request request) {
        for (Connection.KeyVal keyVal : request.data()) {
            if (keyVal.hasInputStream()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection cookie(String str, String str2) {
        this.req.cookie(str, str2);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection cookies(Map<String, String> map) {
        Validate.notNull(map, "Cookie map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.cookie(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection data(String str, String str2) {
        this.req.data(KeyVal.create(str, str2));
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection.Response execute() throws IOException {
        Response execute = Response.execute(this.req);
        this.res = execute;
        return execute;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection followRedirects(boolean z) {
        this.req.followRedirects(z);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Document get() throws IOException {
        this.req.method(Connection.Method.GET);
        execute();
        return this.res.parse();
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection header(String str, String str2) {
        this.req.header(str, str2);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection headers(Map<String, String> map) {
        Validate.notNull(map, "Header map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.header(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection ignoreContentType(boolean z) {
        this.req.ignoreContentType(z);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection ignoreHttpErrors(boolean z) {
        this.req.ignoreHttpErrors(z);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection maxBodySize(int i2) {
        this.req.maxBodySize(i2);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection method(Connection.Method method) {
        this.req.method(method);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection parser(Parser parser) {
        this.req.parser(parser);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Document post() throws IOException {
        this.req.method(Connection.Method.POST);
        execute();
        return this.res.parse();
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection postDataCharset(String str) {
        this.req.postDataCharset(str);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection proxy(Proxy proxy) {
        this.req.proxy(proxy);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection referrer(String str) {
        Validate.notNull(str, "Referrer must not be null");
        this.req.header("Referer", str);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection.Request request() {
        return this.req;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection requestBody(String str) {
        this.req.requestBody(str);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection.Response response() {
        return this.res;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.req.sslSocketFactory(sSLSocketFactory);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection timeout(int i2) {
        this.req.timeout(i2);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection url(URL url) {
        this.req.url(url);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection userAgent(String str) {
        Validate.notNull(str, "User agent must not be null");
        this.req.header(USER_AGENT, str);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection data(String str, String str2, InputStream inputStream) {
        this.req.data(KeyVal.create(str, str2, inputStream));
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection proxy(String str, int i2) {
        this.req.proxy(str, i2);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection request(Connection.Request request) {
        this.req = request;
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection response(Connection.Response response) {
        this.res = response;
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection url(String str) {
        Validate.notEmpty(str, "Must supply a valid URL");
        try {
            this.req.url(new URL(encodeUrl(str)));
            return this;
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Malformed URL: " + str, e2);
        }
    }

    public static Connection connect(URL url) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(url);
        return httpConnection;
    }

    public static URL encodeUrl(URL url) {
        try {
            return new URL(new URI(url.toExternalForm().replace(ExpandableTextView.N, "%20")).toASCIIString());
        } catch (MalformedURLException | URISyntaxException unused) {
            return url;
        }
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection data(String str, String str2, InputStream inputStream, String str3) {
        this.req.data(KeyVal.create(str, str2, inputStream).contentType(str3));
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection data(Map<String, String> map) {
        Validate.notNull(map, "Data map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.data(KeyVal.create(entry.getKey(), entry.getValue()));
        }
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection data(String... strArr) {
        Validate.notNull(strArr, "Data key value pairs must not be null");
        Validate.isTrue(strArr.length % 2 == 0, "Must supply an even number of key value pairs");
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            String str = strArr[i2];
            String str2 = strArr[i2 + 1];
            Validate.notEmpty(str, "Data key must not be empty");
            Validate.notNull(str2, "Data value must not be null");
            this.req.data(KeyVal.create(str, str2));
        }
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection data(Collection<Connection.KeyVal> collection) {
        Validate.notNull(collection, "Data collection must not be null");
        for (Connection.KeyVal keyVal : collection) {
            this.req.data(keyVal);
        }
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.Connection
    public Connection.KeyVal data(String str) {
        Validate.notEmpty(str, "Data key must not be empty");
        for (Connection.KeyVal keyVal : request().data()) {
            if (keyVal.key().equals(str)) {
                return keyVal;
            }
        }
        return null;
    }
}
