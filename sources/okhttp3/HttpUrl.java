package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.moor.imkf.lib.socket.java_websocket.WebSocketImpl;
import com.qiniu.android.collect.ReportItem;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.android.tpns.mqtt.MqttTopic;
import h.a2.d1;
import h.k2.g;
import h.k2.k;
import h.k2.v.f0;
import h.k2.v.u;
import h.o2.i;
import h.o2.q;
import h.q0;
import h.t2.y;
import j.m;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\"\n\u0002\b\u0013\u0018\u0000 W2\u00020\u0001:\u0002XWBc\b\u0000\u0012\u0006\u0010*\u001a\u00020\n\u0012\u0006\u0010.\u001a\u00020\n\u0012\u0006\u00102\u001a\u00020\n\u0012\u0006\u00104\u001a\u00020\n\u0012\u0006\u00106\u001a\u00020\u0011\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\u000e\u0012\u0010\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000e\u0012\b\u0010M\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\bU\u0010VJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010\u0017J\u000f\u0010&\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b&\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b(\u0010\bJ\u000f\u0010*\u001a\u00020\nH\u0007¢\u0006\u0004\b)\u0010\u0017J\u000f\u0010,\u001a\u00020\nH\u0007¢\u0006\u0004\b+\u0010\u0017J\u000f\u0010.\u001a\u00020\nH\u0007¢\u0006\u0004\b-\u0010\u0017J\u000f\u00100\u001a\u00020\nH\u0007¢\u0006\u0004\b/\u0010\u0017J\u000f\u00102\u001a\u00020\nH\u0007¢\u0006\u0004\b1\u0010\u0017J\u000f\u00104\u001a\u00020\nH\u0007¢\u0006\u0004\b3\u0010\u0017J\u000f\u00106\u001a\u00020\u0011H\u0007¢\u0006\u0004\b5\u0010$J\u000f\u00108\u001a\u00020\u0011H\u0007¢\u0006\u0004\b7\u0010$J\u000f\u0010:\u001a\u00020\nH\u0007¢\u0006\u0004\b9\u0010\u0017J\u0015\u0010=\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0004\b;\u0010<J\u0015\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0004\b>\u0010<J\u0011\u0010A\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b@\u0010\u0017J\u0011\u0010C\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\bB\u0010\u0017J\u000f\u0010E\u001a\u00020\u0011H\u0007¢\u0006\u0004\bD\u0010$J\u0015\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0FH\u0007¢\u0006\u0004\bG\u0010HJ\u0011\u0010K\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\bJ\u0010\u0017J\u0011\u0010M\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\bL\u0010\u0017R \u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001f\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8\u0007@\u0006¢\u0006\f\n\u0004\b?\u0010O\u001a\u0004\b?\u0010<R\u0013\u0010,\u001a\u00020\n8G@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\u0017R\u001b\u0010M\u001a\u0004\u0018\u00010\n8\u0007@\u0006¢\u0006\f\n\u0004\bM\u0010P\u001a\u0004\bM\u0010\u0017R\u0013\u00108\u001a\u00020\u00118G@\u0006¢\u0006\u0006\u001a\u0004\b8\u0010$R\u0015\u0010C\u001a\u0004\u0018\u00010\n8G@\u0006¢\u0006\u0006\u001a\u0004\bC\u0010\u0017R\u0013\u0010E\u001a\u00020\u00118G@\u0006¢\u0006\u0006\u001a\u0004\bE\u0010$R\u0019\u00104\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b4\u0010P\u001a\u0004\b4\u0010\u0017R\u0013\u00100\u001a\u00020\n8G@\u0006¢\u0006\u0006\u001a\u0004\b0\u0010\u0017R\u0019\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0F8G@\u0006¢\u0006\u0006\u001a\u0004\bI\u0010HR\u0019\u00106\u001a\u00020\u00118\u0007@\u0006¢\u0006\f\n\u0004\b6\u0010Q\u001a\u0004\b6\u0010$R\u0015\u0010A\u001a\u0004\u0018\u00010\n8G@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010\u0017R\u0019\u0010.\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b.\u0010P\u001a\u0004\b.\u0010\u0017R\u0013\u0010:\u001a\u00020\n8G@\u0006¢\u0006\u0006\u001a\u0004\b:\u0010\u0017R\u0019\u0010*\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b*\u0010P\u001a\u0004\b*\u0010\u0017R\u0019\u00102\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b2\u0010P\u001a\u0004\b2\u0010\u0017R\u0019\u0010R\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bR\u0010TR\u0016\u0010\u0003\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010PR\u0019\u0010=\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8G@\u0006¢\u0006\u0006\u001a\u0004\b=\u0010<R\u0015\u0010K\u001a\u0004\u0018\u00010\n8G@\u0006¢\u0006\u0006\u001a\u0004\bK\u0010\u0017¨\u0006Y"}, d2 = {"Lokhttp3/HttpUrl;", "", "Ljava/net/URL;", "url", "()Ljava/net/URL;", "toUrl", "Ljava/net/URI;", "uri", "()Ljava/net/URI;", "toUri", "", "name", "queryParameter", "(Ljava/lang/String;)Ljava/lang/String;", "", "queryParameterValues", "(Ljava/lang/String;)Ljava/util/List;", "", "index", "queryParameterName", "(I)Ljava/lang/String;", "queryParameterValue", "redact", "()Ljava/lang/String;", "link", "resolve", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "Lokhttp3/HttpUrl$Builder;", "newBuilder", "()Lokhttp3/HttpUrl$Builder;", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "()I", "toString", "topPrivateDomain", "-deprecated_url", "-deprecated_uri", "-deprecated_scheme", "scheme", "-deprecated_encodedUsername", "encodedUsername", "-deprecated_username", IMChatManager.CONSTANT_USERNAME, "-deprecated_encodedPassword", "encodedPassword", "-deprecated_password", "password", "-deprecated_host", ReportItem.RequestKeyHost, "-deprecated_port", "port", "-deprecated_pathSize", "pathSize", "-deprecated_encodedPath", "encodedPath", "-deprecated_encodedPathSegments", "()Ljava/util/List;", "encodedPathSegments", "-deprecated_pathSegments", "pathSegments", "-deprecated_encodedQuery", "encodedQuery", "-deprecated_query", "query", "-deprecated_querySize", "querySize", "", "-deprecated_queryParameterNames", "()Ljava/util/Set;", "queryParameterNames", "-deprecated_encodedFragment", "encodedFragment", "-deprecated_fragment", "fragment", "queryNamesAndValues", "Ljava/util/List;", "Ljava/lang/String;", ExpandableTextView.P, "isHttps", "Z", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class HttpUrl {
    @d
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    @d
    public static final String FRAGMENT_ENCODE_SET = "";
    @d
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    @d
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    @d
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    @d
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    @d
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    @d
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    @d
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    @d
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    @d
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    @e
    private final String fragment;
    @d
    private final String host;
    private final boolean isHttps;
    @d
    private final String password;
    @d
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    @d
    private final String scheme;
    private final String url;
    @d
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0016\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\bd\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0005¢\u0006\u0004\b \u0010\u001eJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\u001eJ\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010\u001eJ\u0015\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0004\b#\u0010\u001eJ\u0015\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\u001eJ\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u001eJ\u0015\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0005¢\u0006\u0004\b)\u0010\u001eJ\u0015\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0005¢\u0006\u0004\b+\u0010\u001eJ\u001d\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0005¢\u0006\u0004\b-\u0010.J\u001d\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0005¢\u0006\u0004\b/\u0010.J\u0015\u00100\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0002¢\u0006\u0004\b0\u0010%J\u0015\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0005¢\u0006\u0004\b1\u0010\u001eJ\u0017\u00102\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b2\u0010\u001eJ\u0017\u00103\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b3\u0010\u001eJ\u001f\u00106\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b6\u00107J\u001f\u0010:\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b:\u00107J\u001f\u0010;\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b;\u00107J\u001f\u0010<\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b<\u00107J\u0015\u0010=\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0005¢\u0006\u0004\b=\u0010\u001eJ\u0015\u0010>\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0005¢\u0006\u0004\b>\u0010\u001eJ\u0017\u0010?\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b?\u0010\u001eJ\u0017\u0010@\u001a\u00020\u00002\b\u0010@\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b@\u0010\u001eJ\u000f\u0010C\u001a\u00020\u0000H\u0000¢\u0006\u0004\bA\u0010BJ\r\u0010E\u001a\u00020D¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0005H\u0016¢\u0006\u0004\bG\u0010HJ!\u0010L\u001a\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010D2\u0006\u0010\u000f\u001a\u00020\u0005H\u0000¢\u0006\u0004\bJ\u0010KR$\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010M\u001a\u0004\bN\u0010H\"\u0004\bO\u0010\u000eR,\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010P8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010@\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u0010M\u001a\u0004\bW\u0010H\"\u0004\bX\u0010\u000eR\"\u0010 \u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010M\u001a\u0004\bY\u0010H\"\u0004\bZ\u0010\u000eR\"\u0010$\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010[\u001a\u0004\b\\\u0010\u0004\"\u0004\b]\u0010^R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050P8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b*\u0010R\u001a\u0004\b_\u0010TR$\u0010#\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010M\u001a\u0004\b`\u0010H\"\u0004\ba\u0010\u000eR\"\u0010\"\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010M\u001a\u0004\bb\u0010H\"\u0004\bc\u0010\u000e¨\u0006f"}, d2 = {"Lokhttp3/HttpUrl$Builder;", "", "", "effectivePort", "()I", "", "pathSegments", "", "alreadyEncoded", "addPathSegments", "(Ljava/lang/String;Z)Lokhttp3/HttpUrl$Builder;", "canonicalName", "Lh/t1;", "removeAllCanonicalQueryParameters", "(Ljava/lang/String;)V", "input", "startPos", "limit", "resolvePath", "(Ljava/lang/String;II)V", "pos", "addTrailingSlash", "push", "(Ljava/lang/String;IIZZ)V", "isDot", "(Ljava/lang/String;)Z", "isDotDot", "pop", "()V", "scheme", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", IMChatManager.CONSTANT_USERNAME, "encodedUsername", "password", "encodedPassword", ReportItem.RequestKeyHost, "port", "(I)Lokhttp3/HttpUrl$Builder;", "pathSegment", "addPathSegment", "encodedPathSegment", "addEncodedPathSegment", "encodedPathSegments", "addEncodedPathSegments", "index", "setPathSegment", "(ILjava/lang/String;)Lokhttp3/HttpUrl$Builder;", "setEncodedPathSegment", "removePathSegment", "encodedPath", "query", "encodedQuery", "name", "value", "addQueryParameter", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "encodedName", "encodedValue", "addEncodedQueryParameter", "setQueryParameter", "setEncodedQueryParameter", "removeAllQueryParameters", "removeAllEncodedQueryParameters", "fragment", "encodedFragment", "reencodeForUri$okhttp", "()Lokhttp3/HttpUrl$Builder;", "reencodeForUri", "Lokhttp3/HttpUrl;", "build", "()Lokhttp3/HttpUrl;", "toString", "()Ljava/lang/String;", "base", "parse$okhttp", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "parse", "Ljava/lang/String;", "getScheme$okhttp", "setScheme$okhttp", "", "encodedQueryNamesAndValues", "Ljava/util/List;", "getEncodedQueryNamesAndValues$okhttp", "()Ljava/util/List;", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "getEncodedFragment$okhttp", "setEncodedFragment$okhttp", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", ExpandableTextView.P, "getPort$okhttp", "setPort$okhttp", "(I)V", "getEncodedPathSegments$okhttp", "getHost$okhttp", "setHost$okhttp", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "<init>", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        @d
        public static final String INVALID_HOST = "Invalid URL host";
        @e
        private String encodedFragment;
        @d
        private final List<String> encodedPathSegments;
        @e
        private List<String> encodedQueryNamesAndValues;
        @e
        private String host;
        @e
        private String scheme;
        @d
        private String encodedUsername = "";
        @d
        private String encodedPassword = "";
        private int port = -1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", "", "", "input", "", "pos", "limit", "schemeDelimiterOffset", "(Ljava/lang/String;II)I", "slashCount", "portColonOffset", "parsePort", "INVALID_HOST", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes4.dex */
        public static final class Companion {
            private Companion() {
            }

            public final int parsePort(String str, int i2, int i3) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i2, i3, "", false, false, false, false, null, 248, null));
                    if (1 <= parseInt && 65535 >= parseInt) {
                        return parseInt;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            public final int portColonOffset(String str, int i2, int i3) {
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt == ':') {
                        return i2;
                    }
                    if (charAt == '[') {
                        do {
                            i2++;
                            if (i2 < i3) {
                            }
                        } while (str.charAt(i2) != ']');
                    }
                    i2++;
                }
                return i3;
            }

            public final int schemeDelimiterOffset(String str, int i2, int i3) {
                if (i3 - i2 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i2);
                if ((f0.t(charAt, 97) < 0 || f0.t(charAt, 122) > 0) && (f0.t(charAt, 65) < 0 || f0.t(charAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        return -1;
                    }
                    char charAt2 = str.charAt(i2);
                    if ('a' > charAt2 || 'z' < charAt2) {
                        if ('A' > charAt2 || 'Z' < charAt2) {
                            if ('0' > charAt2 || '9' < charAt2) {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i2;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            public final int slashCount(String str, int i2, int i3) {
                int i4 = 0;
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i4++;
                    i2++;
                }
                return i4;
            }

            public /* synthetic */ Companion(u uVar) {
                this();
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i2 = this.port;
            return i2 != -1 ? i2 : HttpUrl.Companion.defaultPort(this.scheme);
        }

        private final boolean isDot(String str) {
            return f0.g(str, ".") || h.t2.u.K1(str, "%2e", true);
        }

        private final boolean isDotDot(String str) {
            return f0.g(str, "..") || h.t2.u.K1(str, "%2e.", true) || h.t2.u.K1(str, ".%2e", true) || h.t2.u.K1(str, "%2e%2e", true);
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if ((list.remove(list.size() - 1).length() == 0) && (!this.encodedPathSegments.isEmpty())) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.encodedPathSegments.add("");
        }

        private final void push(String str, int i2, int i3, boolean z, boolean z2) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i2, i3, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, false, null, 240, null);
            if (isDot(canonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(canonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, canonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(canonicalize$okhttp$default);
            }
            if (z) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            i S0 = q.S0(q.W(this.encodedQueryNamesAndValues.size() - 2, 0), 2);
            int d2 = S0.d();
            int f2 = S0.f();
            int g2 = S0.g();
            if (g2 >= 0) {
                if (d2 > f2) {
                    return;
                }
            } else if (d2 < f2) {
                return;
            }
            while (true) {
                if (f0.g(str, this.encodedQueryNamesAndValues.get(d2))) {
                    this.encodedQueryNamesAndValues.remove(d2 + 1);
                    this.encodedQueryNamesAndValues.remove(d2);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (d2 == f2) {
                    return;
                }
                d2 += g2;
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:37:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0041 -> B:35:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void resolvePath(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = okhttp3.internal.Util.delimiterOffset(r11, r12, r6, r13)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.push(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.resolvePath(java.lang.String, int, int):void");
        }

        @d
        public final Builder addEncodedPathSegment(@d String str) {
            push(str, 0, str.length(), false, true);
            return this;
        }

        @d
        public final Builder addEncodedPathSegments(@d String str) {
            return addPathSegments(str, true);
        }

        @d
        public final Builder addEncodedQueryParameter(@d String str, @e String str2) {
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, AdEventType.VIDEO_LOADING, null));
            this.encodedQueryNamesAndValues.add(str2 != null ? Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, AdEventType.VIDEO_LOADING, null) : null);
            return this;
        }

        @d
        public final Builder addPathSegment(@d String str) {
            push(str, 0, str.length(), false, false);
            return this;
        }

        @d
        public final Builder addPathSegments(@d String str) {
            return addPathSegments(str, false);
        }

        @d
        public final Builder addQueryParameter(@d String str, @e String str2) {
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            this.encodedQueryNamesAndValues.add(str2 != null ? Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null) : null);
            return this;
        }

        @d
        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
                String str2 = this.host;
                if (str2 != null) {
                    int effectivePort = effectivePort();
                    List<String> list = this.encodedPathSegments;
                    ArrayList arrayList2 = new ArrayList(h.a2.u.Y(list, 10));
                    for (String str3 : list) {
                        arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, false, 7, null));
                    }
                    List<String> list2 = this.encodedQueryNamesAndValues;
                    if (list2 != null) {
                        arrayList = new ArrayList(h.a2.u.Y(list2, 10));
                        for (String str4 : list2) {
                            arrayList.add(str4 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, true, 3, null) : null);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str5 = this.encodedFragment;
                    return new HttpUrl(str, percentDecode$okhttp$default, percentDecode$okhttp$default2, str2, effectivePort, arrayList2, arrayList, str5 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str5, 0, 0, false, 7, null) : null, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        @d
        public final Builder encodedFragment(@e String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, 179, null) : null;
            return this;
        }

        @d
        public final Builder encodedPassword(@d String str) {
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @d
        public final Builder encodedPath(@d String str) {
            if (h.t2.u.u2(str, MqttTopic.TOPIC_LEVEL_SEPARATOR, false, 2, null)) {
                resolvePath(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + str).toString());
        }

        @d
        public final Builder encodedQuery(@e String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, AdEventType.VIDEO_LOADING, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        @d
        public final Builder encodedUsername(@d String str) {
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @d
        public final Builder fragment(@e String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, 187, null) : null;
            return this;
        }

        @e
        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        @d
        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        @d
        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        @e
        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        @d
        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        @e
        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        @e
        public final String getScheme$okhttp() {
            return this.scheme;
        }

        @d
        public final Builder host(@d String str) {
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        @d
        public final Builder parse$okhttp(@e HttpUrl httpUrl, @d String str) {
            int schemeDelimiterOffset;
            int delimiterOffset;
            int i2;
            int i3;
            int i4;
            boolean z;
            boolean z2;
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(str, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(str, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            char c2 = 65535;
            if (companion.schemeDelimiterOffset(str, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default) != -1) {
                if (h.t2.u.r2(str, "https:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else if (h.t2.u.r2(str, "http:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, schemeDelimiterOffset) + "'");
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme();
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int slashCount = companion.slashCount(str, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c3 = k.b.a.a.o.e.a;
            char c4 = '#';
            if (slashCount < 2 && httpUrl != null && !(!f0.g(httpUrl.scheme(), this.scheme))) {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || str.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i2 = indexOfLastNonAsciiWhitespace$default;
            } else {
                int i5 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(str, "@/\\?#", i5, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? str.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == c2 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        break;
                    }
                    if (charAt != '@') {
                        i3 = indexOfLastNonAsciiWhitespace$default;
                    } else {
                        if (!z3) {
                            int delimiterOffset2 = Util.delimiterOffset(str, ':', i5, delimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            i3 = indexOfLastNonAsciiWhitespace$default;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, str, i5, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z4) {
                                canonicalize$okhttp$default = this.encodedUsername + "%40" + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, str, delimiterOffset2 + 1, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z2 = true;
                            } else {
                                z2 = z3;
                            }
                            z3 = z2;
                            i4 = delimiterOffset;
                            z = true;
                        } else {
                            i3 = indexOfLastNonAsciiWhitespace$default;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.encodedPassword);
                            sb.append("%40");
                            i4 = delimiterOffset;
                            sb.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i5, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb.toString();
                            z = z4;
                        }
                        i5 = i4 + 1;
                        z4 = z;
                    }
                    indexOfLastNonAsciiWhitespace$default = i3;
                    c4 = '#';
                    c3 = k.b.a.a.o.e.a;
                    c2 = 65535;
                }
                i2 = indexOfLastNonAsciiWhitespace$default;
                Companion companion3 = Companion;
                int portColonOffset = companion3.portColonOffset(str, i5, delimiterOffset);
                int i6 = portColonOffset + 1;
                if (i6 < delimiterOffset) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i5, portColonOffset, false, 4, null));
                    int parsePort = companion3.parsePort(str, i6, delimiterOffset);
                    this.port = parsePort;
                    if (!(parsePort != -1)) {
                        throw new IllegalArgumentException(("Invalid URL port: \"" + str.substring(i6, delimiterOffset) + y.a).toString());
                    }
                } else {
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, str, i5, portColonOffset, false, 4, null));
                    this.port = companion4.defaultPort(this.scheme);
                }
                if (!(this.host != null)) {
                    throw new IllegalArgumentException(("Invalid URL host: \"" + str.substring(i5, portColonOffset) + y.a).toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            }
            int i7 = i2;
            int delimiterOffset3 = Util.delimiterOffset(str, "?#", indexOfFirstNonAsciiWhitespace$default, i7);
            resolvePath(str, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i7 && str.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(str, '#', delimiterOffset3, i7);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, str, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, AdEventType.VIDEO_CLICKED, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i7 && str.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, delimiterOffset3 + 1, i7, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        @d
        public final Builder password(@d String str) {
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        @d
        public final Builder port(int i2) {
            boolean z = true;
            if ((1 > i2 || 65535 < i2) ? false : false) {
                this.port = i2;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i2).toString());
        }

        @d
        public final Builder query(@e String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        @d
        public final Builder reencodeForUri$okhttp() {
            String str = this.host;
            this.host = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i2 = 0; i2 < size; i2++) {
                List<String> list = this.encodedPathSegments;
                list.set(i2, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i2), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str2 = list2.get(i3);
                    list2.set(i3, str2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null) : null;
            return this;
        }

        @d
        public final Builder removeAllEncodedQueryParameters(@d String str) {
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, AdEventType.VIDEO_LOADING, null));
            return this;
        }

        @d
        public final Builder removeAllQueryParameters(@d String str) {
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        @d
        public final Builder removePathSegment(int i2) {
            this.encodedPathSegments.remove(i2);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        @d
        public final Builder scheme(@d String str) {
            if (h.t2.u.K1(str, "http", true)) {
                this.scheme = "http";
            } else if (!h.t2.u.K1(str, "https", true)) {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            } else {
                this.scheme = "https";
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(@e String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(@d String str) {
            this.encodedPassword = str;
        }

        @d
        public final Builder setEncodedPathSegment(int i2, @d String str) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(i2, canonicalize$okhttp$default);
            if ((isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + str).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@e List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        @d
        public final Builder setEncodedQueryParameter(@d String str, @e String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final void setEncodedUsername$okhttp(@d String str) {
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(@e String str) {
            this.host = str;
        }

        @d
        public final Builder setPathSegment(int i2, @d String str) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if ((isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) ? false : true) {
                this.encodedPathSegments.set(i2, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + str).toString());
        }

        public final void setPort$okhttp(int i2) {
            this.port = i2;
        }

        @d
        public final Builder setQueryParameter(@d String str, @e String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final void setScheme$okhttp(@e String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:63:0x0033, code lost:
            if ((r6.encodedPassword.length() > 0) != false) goto L38;
         */
        @k.e.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L12
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L17
            L12:
                java.lang.String r1 = "//"
                r0.append(r1)
            L17:
                java.lang.String r1 = r6.encodedUsername
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L23
                r1 = 1
                goto L24
            L23:
                r1 = 0
            L24:
                r4 = 58
                if (r1 != 0) goto L35
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L32
                r1 = 1
                goto L33
            L32:
                r1 = 0
            L33:
                if (r1 == 0) goto L53
            L35:
                java.lang.String r1 = r6.encodedUsername
                r0.append(r1)
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L43
                goto L44
            L43:
                r2 = 0
            L44:
                if (r2 == 0) goto L4e
                r0.append(r4)
                java.lang.String r1 = r6.encodedPassword
                r0.append(r1)
            L4e:
                r1 = 64
                r0.append(r1)
            L53:
                java.lang.String r1 = r6.host
                if (r1 == 0) goto L74
                r2 = 2
                r5 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.U2(r1, r4, r3, r2, r5)
                if (r1 == 0) goto L6f
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.host
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L74
            L6f:
                java.lang.String r1 = r6.host
                r0.append(r1)
            L74:
                int r1 = r6.port
                r2 = -1
                if (r1 != r2) goto L7d
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L93
            L7d:
                int r1 = r6.effectivePort()
                java.lang.String r2 = r6.scheme
                if (r2 == 0) goto L8d
                okhttp3.HttpUrl$Companion r3 = okhttp3.HttpUrl.Companion
                int r2 = r3.defaultPort(r2)
                if (r1 == r2) goto L93
            L8d:
                r0.append(r4)
                r0.append(r1)
            L93:
                okhttp3.HttpUrl$Companion r1 = okhttp3.HttpUrl.Companion
                java.util.List<java.lang.String> r2 = r6.encodedPathSegments
                r1.toPathString$okhttp(r2, r0)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                if (r2 == 0) goto La8
                r2 = 63
                r0.append(r2)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                r1.toQueryString$okhttp(r2, r0)
            La8:
                java.lang.String r1 = r6.encodedFragment
                if (r1 == 0) goto Lb6
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.encodedFragment
                r0.append(r1)
            Lb6:
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        @d
        public final Builder username(@d String str) {
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z) {
            int i2 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i2, str.length());
                push(str, i2, delimiterOffset, delimiterOffset < str.length(), z);
                i2 = delimiterOffset + 1;
            } while (i2 <= str.length());
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0019\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bK\u0010LJ3\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ]\u0010\u0016\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010!\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00030\u001b2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 J'\u0010#\u001a\u00020\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001dH\u0000¢\u0006\u0004\b\"\u0010 J\u001b\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030$*\u00020\u0003H\u0000¢\u0006\u0004\b%\u0010&J\u0013\u0010+\u001a\u00020(*\u00020\u0003H\u0007¢\u0006\u0004\b)\u0010*J\u0015\u0010-\u001a\u0004\u0018\u00010(*\u00020\u0003H\u0007¢\u0006\u0004\b,\u0010*J\u0015\u0010-\u001a\u0004\u0018\u00010(*\u00020.H\u0007¢\u0006\u0004\b)\u0010/J\u0015\u0010-\u001a\u0004\u0018\u00010(*\u000200H\u0007¢\u0006\u0004\b)\u00101J\u0017\u0010)\u001a\u00020(2\u0006\u00102\u001a\u00020\u0003H\u0007¢\u0006\u0004\b3\u0010*J\u0019\u0010,\u001a\u0004\u0018\u00010(2\u0006\u00102\u001a\u00020\u0003H\u0007¢\u0006\u0004\b4\u0010*J\u0019\u0010)\u001a\u0004\u0018\u00010(2\u0006\u00102\u001a\u00020.H\u0007¢\u0006\u0004\b3\u0010/J\u0019\u0010)\u001a\u0004\u0018\u00010(2\u0006\u00105\u001a\u000200H\u0007¢\u0006\u0004\b3\u00101J1\u00108\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b6\u00107Jc\u0010;\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b>\u0010=R\u0016\u0010?\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bC\u0010=R\u0016\u0010D\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bD\u0010=R\u0016\u0010E\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bE\u0010=R\u0016\u0010F\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bF\u0010=R\u0016\u0010G\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bG\u0010=R\u0016\u0010H\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bH\u0010=R\u0016\u0010I\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bI\u0010=R\u0016\u0010J\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bJ\u0010=¨\u0006M"}, d2 = {"Lokhttp3/HttpUrl$Companion;", "", "Lj/m;", "", "encoded", "", "pos", "limit", "", "plusIsSpace", "Lh/t1;", "writePercentDecoded", "(Lj/m;Ljava/lang/String;IIZ)V", "isPercentEncoded", "(Ljava/lang/String;II)Z", "input", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", "charset", "writeCanonicalized", "(Lj/m;Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)V", "scheme", "defaultPort", "(Ljava/lang/String;)I", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", YKFConstants.INVESTIGATE_TYPE_OUT, "toPathString$okhttp", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "toPathString", "toQueryString$okhttp", "toQueryString", "", "toQueryNamesAndValues$okhttp", "(Ljava/lang/String;)Ljava/util/List;", "toQueryNamesAndValues", "Lokhttp3/HttpUrl;", "get", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "toHttpUrl", "parse", "toHttpUrlOrNull", "Ljava/net/URL;", "(Ljava/net/URL;)Lokhttp3/HttpUrl;", "Ljava/net/URI;", "(Ljava/net/URI;)Lokhttp3/HttpUrl;", "url", "-deprecated_get", "-deprecated_parse", "uri", "percentDecode$okhttp", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "percentDecode", "canonicalize$okhttp", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "canonicalize", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i4, Object obj) {
            return companion.canonicalize$okhttp(str, (i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? str.length() : i3, str2, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? false : z3, (i4 & 64) != 0 ? false : z4, (i4 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i2, int i3) {
            int i4 = i2 + 2;
            return i4 < i3 && str.charAt(i2) == '%' && Util.parseHexDigit(str.charAt(i2 + 1)) != -1 && Util.parseHexDigit(str.charAt(i4)) != -1;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i2, int i3, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = str.length();
            }
            if ((i4 & 4) != 0) {
                z = false;
            }
            return companion.percentDecode$okhttp(str, i2, i3, z);
        }

        /* JADX WARN: Code restructure failed: missing block: B:97:0x0065, code lost:
            if (isPercentEncoded(r16, r5, r18) == false) goto L39;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void writeCanonicalized(j.m r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            Lb:
                if (r5 >= r2) goto Lbf
                java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
                java.util.Objects.requireNonNull(r1, r7)
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L2e
                r8 = 9
                if (r7 == r8) goto L29
                r8 = 10
                if (r7 == r8) goto L29
                r8 = 12
                if (r7 == r8) goto L29
                r8 = 13
                if (r7 == r8) goto L29
                goto L2e
            L29:
                r8 = r14
                r12 = r19
                goto Lb8
            L2e:
                r8 = 43
                if (r7 != r8) goto L3f
                if (r22 == 0) goto L3f
                if (r20 == 0) goto L39
                java.lang.String r8 = "+"
                goto L3b
            L39:
                java.lang.String r8 = "%2B"
            L3b:
                r15.B(r8)
                goto L29
            L3f:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L6f
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L6f
                r8 = 128(0x80, float:1.794E-43)
                if (r7 < r8) goto L4f
                if (r23 == 0) goto L6f
            L4f:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.StringsKt__StringsKt.U2(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L6d
                if (r7 != r9) goto L68
                if (r20 == 0) goto L6d
                if (r21 == 0) goto L68
                r8 = r14
                boolean r10 = r14.isPercentEncoded(r1, r5, r2)
                if (r10 != 0) goto L69
                goto L72
            L68:
                r8 = r14
            L69:
                r15.w(r7)
                goto Lb8
            L6d:
                r8 = r14
                goto L72
            L6f:
                r8 = r14
                r12 = r19
            L72:
                if (r6 != 0) goto L79
                j.m r6 = new j.m
                r6.<init>()
            L79:
                if (r3 == 0) goto L8d
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = h.k2.v.f0.g(r3, r10)
                if (r10 == 0) goto L84
                goto L8d
            L84:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.P(r1, r5, r10, r3)
                goto L90
            L8d:
                r6.w(r7)
            L90:
                boolean r10 = r6.b0()
                if (r10 != 0) goto Lb8
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r11 = okhttp3.HttpUrl.access$getHEX_DIGITS$cp()
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte(r11)
                char[] r11 = okhttp3.HttpUrl.access$getHEX_DIGITS$cp()
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L90
            Lb8:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto Lb
            Lbf:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.writeCanonicalized(j.m, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void writePercentDecoded(m mVar, String str, int i2, int i3, boolean z) {
            int i4;
            while (i2 < i3) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                int codePointAt = str.codePointAt(i2);
                if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                    int parseHexDigit = Util.parseHexDigit(str.charAt(i2 + 1));
                    int parseHexDigit2 = Util.parseHexDigit(str.charAt(i4));
                    if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                        mVar.writeByte((parseHexDigit << 4) + parseHexDigit2);
                        i2 = Character.charCount(codePointAt) + i4;
                    }
                    mVar.w(codePointAt);
                    i2 += Character.charCount(codePointAt);
                } else {
                    if (codePointAt == 43 && z) {
                        mVar.writeByte(32);
                        i2++;
                    }
                    mVar.w(codePointAt);
                    i2 += Character.charCount(codePointAt);
                }
            }
        }

        @g(name = "-deprecated_get")
        @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        @d
        /* renamed from: -deprecated_get */
        public final HttpUrl m188deprecated_get(@d String str) {
            return get(str);
        }

        @g(name = "-deprecated_parse")
        @e
        @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* renamed from: -deprecated_parse */
        public final HttpUrl m191deprecated_parse(@d String str) {
            return parse(str);
        }

        @d
        public final String canonicalize$okhttp(@d String str, int i2, int i3, @d String str2, boolean z, boolean z2, boolean z3, boolean z4, @e Charset charset) {
            int i4 = i2;
            while (i4 < i3) {
                int codePointAt = str.codePointAt(i4);
                if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z4)) {
                    if (!StringsKt__StringsKt.U2(str2, (char) codePointAt, false, 2, null)) {
                        if (codePointAt == 37) {
                            if (z) {
                                if (z2) {
                                    if (!isPercentEncoded(str, i4, i3)) {
                                    }
                                    if (codePointAt == 43 || !z3) {
                                        i4 += Character.charCount(codePointAt);
                                    }
                                }
                            }
                        }
                        if (codePointAt == 43) {
                        }
                        i4 += Character.charCount(codePointAt);
                    }
                }
                m mVar = new m();
                mVar.D(str, i2, i4);
                writeCanonicalized(mVar, str, i4, i3, str2, z, z2, z3, z4, charset);
                return mVar.p0();
            }
            return str.substring(i2, i3);
        }

        @k
        public final int defaultPort(@d String str) {
            int hashCode = str.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && str.equals("https")) {
                    return WebSocketImpl.DEFAULT_WSS_PORT;
                }
            } else if (str.equals("http")) {
                return 80;
            }
            return -1;
        }

        @g(name = "get")
        @k
        @d
        public final HttpUrl get(@d String str) {
            return new Builder().parse$okhttp(null, str).build();
        }

        @g(name = "parse")
        @k
        @e
        public final HttpUrl parse(@d String str) {
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @d
        public final String percentDecode$okhttp(@d String str, int i2, int i3, boolean z) {
            for (int i4 = i2; i4 < i3; i4++) {
                char charAt = str.charAt(i4);
                if (charAt == '%' || (charAt == '+' && z)) {
                    m mVar = new m();
                    mVar.D(str, i2, i4);
                    writePercentDecoded(mVar, str, i4, i3, z);
                    return mVar.p0();
                }
            }
            return str.substring(i2, i3);
        }

        public final void toPathString$okhttp(@d List<String> list, @d StringBuilder sb) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(Attributes.InternalPrefix);
                sb.append(list.get(i2));
            }
        }

        @d
        public final List<String> toQueryNamesAndValues$okhttp(@d String str) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 <= str.length()) {
                int q3 = StringsKt__StringsKt.q3(str, y.f15690c, i2, false, 4, null);
                if (q3 == -1) {
                    q3 = str.length();
                }
                int i3 = q3;
                int q32 = StringsKt__StringsKt.q3(str, '=', i2, false, 4, null);
                if (q32 != -1 && q32 <= i3) {
                    arrayList.add(str.substring(i2, q32));
                    arrayList.add(str.substring(q32 + 1, i3));
                } else {
                    arrayList.add(str.substring(i2, i3));
                    arrayList.add(null);
                }
                i2 = i3 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(@d List<String> list, @d StringBuilder sb) {
            i S0 = q.S0(q.n1(0, list.size()), 2);
            int d2 = S0.d();
            int f2 = S0.f();
            int g2 = S0.g();
            if (g2 >= 0) {
                if (d2 > f2) {
                    return;
                }
            } else if (d2 < f2) {
                return;
            }
            while (true) {
                String str = list.get(d2);
                String str2 = list.get(d2 + 1);
                if (d2 > 0) {
                    sb.append(y.f15690c);
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (d2 == f2) {
                    return;
                }
                d2 += g2;
            }
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        @g(name = "-deprecated_get")
        @e
        @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* renamed from: -deprecated_get */
        public final HttpUrl m190deprecated_get(@d URL url) {
            return get(url);
        }

        @g(name = "get")
        @k
        @e
        public final HttpUrl get(@d URL url) {
            return parse(url.toString());
        }

        @g(name = "-deprecated_get")
        @e
        @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* renamed from: -deprecated_get */
        public final HttpUrl m189deprecated_get(@d URI uri) {
            return get(uri);
        }

        @g(name = "get")
        @k
        @e
        public final HttpUrl get(@d URI uri) {
            return parse(uri.toString());
        }
    }

    public HttpUrl(@d String str, @d String str2, @d String str3, @d String str4, int i2, @d List<String> list, @e List<String> list2, @e String str5, @d String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i2;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = f0.g(str, "https");
    }

    @k
    public static final int defaultPort(@d String str) {
        return Companion.defaultPort(str);
    }

    @g(name = "get")
    @k
    @d
    public static final HttpUrl get(@d String str) {
        return Companion.get(str);
    }

    @g(name = "get")
    @k
    @e
    public static final HttpUrl get(@d URI uri) {
        return Companion.get(uri);
    }

    @g(name = "get")
    @k
    @e
    public static final HttpUrl get(@d URL url) {
        return Companion.get(url);
    }

    @g(name = "parse")
    @k
    @e
    public static final HttpUrl parse(@d String str) {
        return Companion.parse(str);
    }

    @g(name = "-deprecated_encodedFragment")
    @e
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "encodedFragment", imports = {}))
    /* renamed from: -deprecated_encodedFragment */
    public final String m169deprecated_encodedFragment() {
        return encodedFragment();
    }

    @g(name = "-deprecated_encodedPassword")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "encodedPassword", imports = {}))
    @d
    /* renamed from: -deprecated_encodedPassword */
    public final String m170deprecated_encodedPassword() {
        return encodedPassword();
    }

    @g(name = "-deprecated_encodedPath")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "encodedPath", imports = {}))
    @d
    /* renamed from: -deprecated_encodedPath */
    public final String m171deprecated_encodedPath() {
        return encodedPath();
    }

    @g(name = "-deprecated_encodedPathSegments")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "encodedPathSegments", imports = {}))
    @d
    /* renamed from: -deprecated_encodedPathSegments */
    public final List<String> m172deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @g(name = "-deprecated_encodedQuery")
    @e
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "encodedQuery", imports = {}))
    /* renamed from: -deprecated_encodedQuery */
    public final String m173deprecated_encodedQuery() {
        return encodedQuery();
    }

    @g(name = "-deprecated_encodedUsername")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "encodedUsername", imports = {}))
    @d
    /* renamed from: -deprecated_encodedUsername */
    public final String m174deprecated_encodedUsername() {
        return encodedUsername();
    }

    @g(name = "-deprecated_fragment")
    @e
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "fragment", imports = {}))
    /* renamed from: -deprecated_fragment */
    public final String m175deprecated_fragment() {
        return this.fragment;
    }

    @g(name = "-deprecated_host")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = ReportItem.RequestKeyHost, imports = {}))
    @d
    /* renamed from: -deprecated_host */
    public final String m176deprecated_host() {
        return this.host;
    }

    @g(name = "-deprecated_password")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "password", imports = {}))
    @d
    /* renamed from: -deprecated_password */
    public final String m177deprecated_password() {
        return this.password;
    }

    @g(name = "-deprecated_pathSegments")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "pathSegments", imports = {}))
    @d
    /* renamed from: -deprecated_pathSegments */
    public final List<String> m178deprecated_pathSegments() {
        return this.pathSegments;
    }

    @g(name = "-deprecated_pathSize")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "pathSize", imports = {}))
    /* renamed from: -deprecated_pathSize */
    public final int m179deprecated_pathSize() {
        return pathSize();
    }

    @g(name = "-deprecated_port")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "port", imports = {}))
    /* renamed from: -deprecated_port */
    public final int m180deprecated_port() {
        return this.port;
    }

    @g(name = "-deprecated_query")
    @e
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "query", imports = {}))
    /* renamed from: -deprecated_query */
    public final String m181deprecated_query() {
        return query();
    }

    @g(name = "-deprecated_queryParameterNames")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "queryParameterNames", imports = {}))
    @d
    /* renamed from: -deprecated_queryParameterNames */
    public final Set<String> m182deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @g(name = "-deprecated_querySize")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "querySize", imports = {}))
    /* renamed from: -deprecated_querySize */
    public final int m183deprecated_querySize() {
        return querySize();
    }

    @g(name = "-deprecated_scheme")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "scheme", imports = {}))
    @d
    /* renamed from: -deprecated_scheme */
    public final String m184deprecated_scheme() {
        return this.scheme;
    }

    @g(name = "-deprecated_uri")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @q0(expression = "toUri()", imports = {}))
    @d
    /* renamed from: -deprecated_uri */
    public final URI m185deprecated_uri() {
        return uri();
    }

    @g(name = "-deprecated_url")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @q0(expression = "toUrl()", imports = {}))
    @d
    /* renamed from: -deprecated_url */
    public final URL m186deprecated_url() {
        return url();
    }

    @g(name = "-deprecated_username")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = IMChatManager.CONSTANT_USERNAME, imports = {}))
    @d
    /* renamed from: -deprecated_username */
    public final String m187deprecated_username() {
        return this.username;
    }

    @g(name = "encodedFragment")
    @e
    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String str = this.url;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.substring(StringsKt__StringsKt.q3(this.url, '#', 0, false, 6, null) + 1);
    }

    @g(name = "encodedPassword")
    @d
    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int q3 = StringsKt__StringsKt.q3(this.url, '@', 0, false, 6, null);
        String str = this.url;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.substring(StringsKt__StringsKt.q3(this.url, ':', this.scheme.length() + 3, false, 4, null) + 1, q3);
    }

    @g(name = "encodedPath")
    @d
    public final String encodedPath() {
        int q3 = StringsKt__StringsKt.q3(this.url, Attributes.InternalPrefix, this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", q3, str.length());
        String str2 = this.url;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        return str2.substring(q3, delimiterOffset);
    }

    @g(name = "encodedPathSegments")
    @d
    public final List<String> encodedPathSegments() {
        int q3 = StringsKt__StringsKt.q3(this.url, Attributes.InternalPrefix, this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", q3, str.length());
        ArrayList arrayList = new ArrayList();
        while (q3 < delimiterOffset) {
            int i2 = q3 + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, (char) Attributes.InternalPrefix, i2, delimiterOffset);
            String str2 = this.url;
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            arrayList.add(str2.substring(i2, delimiterOffset2));
            q3 = delimiterOffset2;
        }
        return arrayList;
    }

    @g(name = "encodedQuery")
    @e
    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int q3 = StringsKt__StringsKt.q3(this.url, k.b.a.a.o.e.a, 0, false, 6, null) + 1;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, '#', q3, str.length());
        String str2 = this.url;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        return str2.substring(q3, delimiterOffset);
    }

    @g(name = "encodedUsername")
    @d
    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, ":@", length, str.length());
        String str2 = this.url;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        return str2.substring(length, delimiterOffset);
    }

    public boolean equals(@e Object obj) {
        return (obj instanceof HttpUrl) && f0.g(((HttpUrl) obj).url, this.url);
    }

    @g(name = "fragment")
    @e
    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @g(name = ReportItem.RequestKeyHost)
    @d
    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    @d
    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    @g(name = "password")
    @d
    public final String password() {
        return this.password;
    }

    @g(name = "pathSegments")
    @d
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    @g(name = "pathSize")
    public final int pathSize() {
        return this.pathSegments.size();
    }

    @g(name = "port")
    public final int port() {
        return this.port;
    }

    @g(name = "query")
    @e
    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    @e
    public final String queryParameter(@d String str) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        i S0 = q.S0(q.n1(0, list.size()), 2);
        int d2 = S0.d();
        int f2 = S0.f();
        int g2 = S0.g();
        if (g2 < 0 ? d2 >= f2 : d2 <= f2) {
            while (!f0.g(str, this.queryNamesAndValues.get(d2))) {
                if (d2 != f2) {
                    d2 += g2;
                }
            }
            return this.queryNamesAndValues.get(d2 + 1);
        }
        return null;
    }

    @d
    public final String queryParameterName(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get(i2 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    @g(name = "queryParameterNames")
    @d
    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return d1.k();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        i S0 = q.S0(q.n1(0, this.queryNamesAndValues.size()), 2);
        int d2 = S0.d();
        int f2 = S0.f();
        int g2 = S0.g();
        if (g2 < 0 ? d2 >= f2 : d2 <= f2) {
            while (true) {
                linkedHashSet.add(this.queryNamesAndValues.get(d2));
                if (d2 == f2) {
                    break;
                }
                d2 += g2;
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @e
    public final String queryParameterValue(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i2 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    @d
    public final List<String> queryParameterValues(@d String str) {
        if (this.queryNamesAndValues == null) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList();
        i S0 = q.S0(q.n1(0, this.queryNamesAndValues.size()), 2);
        int d2 = S0.d();
        int f2 = S0.f();
        int g2 = S0.g();
        if (g2 < 0 ? d2 >= f2 : d2 <= f2) {
            while (true) {
                if (f0.g(str, this.queryNamesAndValues.get(d2))) {
                    arrayList.add(this.queryNamesAndValues.get(d2 + 1));
                }
                if (d2 == f2) {
                    break;
                }
                d2 += g2;
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @g(name = "querySize")
    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    @d
    public final String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    @e
    public final HttpUrl resolve(@d String str) {
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    @g(name = "scheme")
    @d
    public final String scheme() {
        return this.scheme;
    }

    @d
    public String toString() {
        return this.url;
    }

    @e
    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @g(name = "uri")
    @d
    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(builder, ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    @g(name = "url")
    @d
    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    @g(name = IMChatManager.CONSTANT_USERNAME)
    @d
    public final String username() {
        return this.username;
    }

    @e
    public final Builder newBuilder(@d String str) {
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
