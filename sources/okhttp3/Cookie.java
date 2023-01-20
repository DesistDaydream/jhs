package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.m7.imkfsdk.view.pickerview.utils.LunarCalendar;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import h.i;
import h.k2.g;
import h.k2.k;
import h.k2.v.f0;
import h.q0;
import h.t2.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u0000 -2\u00020\u0001:\u0002.-BQ\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\r\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u0015J\u000f\u0010\u001e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001d\u0010\u000fJ\u000f\u0010 \u001a\u00020\rH\u0007¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010\"\u001a\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010\u0015J\u000f\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0004\b#\u0010\u0015J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0004H\u0000¢\u0006\u0004\b&\u0010'R\u0019\u0010 \u001a\u00020\r8\u0007@\u0006¢\u0006\f\n\u0004\b \u0010(\u001a\u0004\b \u0010\u000fR\u0019\u0010\u0013\u001a\u00020\r8\u0007@\u0006¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\"\u001a\u00020\u00048\u0007@\u0006¢\u0006\f\n\u0004\b\"\u0010)\u001a\u0004\b\"\u0010\u0015R\u0019\u0010\u0011\u001a\u00020\r8\u0007@\u0006¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u001c\u001a\u00020\u00048\u0007@\u0006¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b\u001c\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\u00048\u0007@\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010$\u001a\u00020\u00048\u0007@\u0006¢\u0006\f\n\u0004\b$\u0010)\u001a\u0004\b$\u0010\u0015R\u0019\u0010\u001a\u001a\u00020\u00178\u0007@\u0006¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b\u001a\u0010\u0019R\u0019\u0010\u001e\u001a\u00020\r8\u0007@\u0006¢\u0006\f\n\u0004\b\u001e\u0010(\u001a\u0004\b\u001e\u0010\u000f¨\u0006/"}, d2 = {"Lokhttp3/Cookie;", "", "Lokhttp3/HttpUrl;", "url", "", "matches", "(Lokhttp3/HttpUrl;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toString", "()Ljava/lang/String;", "-deprecated_name", "name", "-deprecated_value", "value", "-deprecated_persistent", "()Z", "persistent", "", "-deprecated_expiresAt", "()J", "expiresAt", "-deprecated_hostOnly", "hostOnly", "-deprecated_domain", "domain", "-deprecated_path", "path", "-deprecated_httpOnly", "httpOnly", "-deprecated_secure", "secure", "forObsoleteRfc2965", "toString$okhttp", "(Z)Ljava/lang/String;", "Ljava/lang/String;", "Z", "J", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Cookie {
    @d
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    @d
    private final String name;
    @d
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    @d
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0003\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\bJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016¨\u0006\u001b"}, d2 = {"Lokhttp3/Cookie$Builder;", "", "", "domain", "", "hostOnly", "(Ljava/lang/String;Z)Lokhttp3/Cookie$Builder;", "name", "(Ljava/lang/String;)Lokhttp3/Cookie$Builder;", "value", "", "expiresAt", "(J)Lokhttp3/Cookie$Builder;", "hostOnlyDomain", "path", "secure", "()Lokhttp3/Cookie$Builder;", "httpOnly", "Lokhttp3/Cookie;", "build", "()Lokhttp3/Cookie;", "persistent", "Z", "J", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;
        private String path = MqttTopic.TOPIC_LEVEL_SEPARATOR;

        @d
        public final Cookie build() {
            String str = this.name;
            Objects.requireNonNull(str, "builder.name == null");
            String str2 = this.value;
            Objects.requireNonNull(str2, "builder.value == null");
            long j2 = this.expiresAt;
            String str3 = this.domain;
            Objects.requireNonNull(str3, "builder.domain == null");
            return new Cookie(str, str2, j2, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
        }

        @d
        public final Builder domain(@d String str) {
            return domain(str, false);
        }

        @d
        public final Builder expiresAt(long j2) {
            if (j2 <= 0) {
                j2 = Long.MIN_VALUE;
            }
            if (j2 > DatesKt.MAX_DATE) {
                j2 = 253402300799999L;
            }
            this.expiresAt = j2;
            this.persistent = true;
            return this;
        }

        @d
        public final Builder hostOnlyDomain(@d String str) {
            return domain(str, true);
        }

        @d
        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        @d
        public final Builder name(@d String str) {
            if (f0.g(StringsKt__StringsKt.B5(str).toString(), str)) {
                this.name = str;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        @d
        public final Builder path(@d String str) {
            if (u.u2(str, MqttTopic.TOPIC_LEVEL_SEPARATOR, false, 2, null)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        @d
        public final Builder secure() {
            this.secure = true;
            return this;
        }

        @d
        public final Builder value(@d String str) {
            if (f0.g(StringsKt__StringsKt.B5(str).toString(), str)) {
                this.value = str;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        private final Builder domain(String str, boolean z) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b/\u00100J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0000¢\u0006\u0004\b!\u0010\"J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0%2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b&\u0010'R\u001e\u0010*\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010,\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+R\u001e\u0010-\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010+R\u001e\u0010.\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010+¨\u00061"}, d2 = {"Lokhttp3/Cookie$Companion;", "", "", "urlHost", "domain", "", "domainMatch", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lokhttp3/HttpUrl;", "url", "path", "pathMatch", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Z", "s", "", "pos", "limit", "", "parseExpires", "(Ljava/lang/String;II)J", "input", "invert", "dateCharacterOffset", "(Ljava/lang/String;IIZ)I", "parseMaxAge", "(Ljava/lang/String;)J", "parseDomain", "(Ljava/lang/String;)Ljava/lang/String;", "setCookie", "Lokhttp3/Cookie;", "parse", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "currentTimeMillis", "parse$okhttp", "(JLokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "Lokhttp3/Headers;", "headers", "", "parseAll", "(Lokhttp3/HttpUrl;Lokhttp3/Headers;)Ljava/util/List;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        private final int dateCharacterOffset(String str, int i2, int i3, boolean z) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || ('0' <= charAt && '9' >= charAt) || (('a' <= charAt && 'z' >= charAt) || (('A' <= charAt && 'Z' >= charAt) || charAt == ':'))) == (!z)) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (f0.g(str, str2)) {
                return true;
            }
            return u.J1(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str);
        }

        private final String parseDomain(String str) {
            if (!u.J1(str, ".", false, 2, null)) {
                String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt__StringsKt.c4(str, "."));
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseExpires(String str, int i2, int i3) {
            int dateCharacterOffset = dateCharacterOffset(str, i2, i3, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            while (dateCharacterOffset < i3) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i3, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i5 != -1 || !matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    if (i6 != -1 || !matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                        if (i7 != -1 || !matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                            if (i4 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                                i4 = Integer.parseInt(matcher.group(1));
                            }
                        } else {
                            String group = matcher.group(1);
                            Locale locale = Locale.US;
                            Objects.requireNonNull(group, "null cannot be cast to non-null type java.lang.String");
                            i7 = StringsKt__StringsKt.r3(Cookie.MONTH_PATTERN.pattern(), group.toLowerCase(locale), 0, false, 6, null) / 4;
                        }
                    } else {
                        i6 = Integer.parseInt(matcher.group(1));
                    }
                } else {
                    i5 = Integer.parseInt(matcher.group(1));
                    i8 = Integer.parseInt(matcher.group(2));
                    i9 = Integer.parseInt(matcher.group(3));
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i3, false);
            }
            if (70 <= i4 && 99 >= i4) {
                i4 += LunarCalendar.MIN_YEAR;
            }
            if (i4 >= 0 && 69 >= i4) {
                i4 += 2000;
            }
            if (i4 >= 1601) {
                if (i7 != -1) {
                    if (1 <= i6 && 31 >= i6) {
                        if (i5 >= 0 && 23 >= i5) {
                            if (i8 >= 0 && 59 >= i8) {
                                if (i9 >= 0 && 59 >= i9) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i4);
                                    gregorianCalendar.set(2, i7 - 1);
                                    gregorianCalendar.set(5, i6);
                                    gregorianCalendar.set(11, i5);
                                    gregorianCalendar.set(12, i8);
                                    gregorianCalendar.set(13, i9);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e2) {
                if (new Regex("-?\\d+").matches(str)) {
                    return u.u2(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER, false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (f0.g(encodedPath, str)) {
                return true;
            }
            return u.u2(encodedPath, str, false, 2, null) && (u.J1(str, MqttTopic.TOPIC_LEVEL_SEPARATOR, false, 2, null) || encodedPath.charAt(str.length()) == '/');
        }

        @k
        @e
        public final Cookie parse(@d HttpUrl httpUrl, @d String str) {
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00f7, code lost:
            if (r1 > okhttp3.internal.http.DatesKt.MAX_DATE) goto L86;
         */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0153  */
        @k.e.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.Cookie parse$okhttp(long r27, @k.e.a.d okhttp3.HttpUrl r29, @k.e.a.d java.lang.String r30) {
            /*
                Method dump skipped, instructions count: 360
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        @k
        @d
        public final List<Cookie> parseAll(@d HttpUrl httpUrl, @d Headers headers) {
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                Cookie parse = parse(httpUrl, values.get(i2));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return CollectionsKt__CollectionsKt.E();
        }

        public /* synthetic */ Companion(h.k2.v.u uVar) {
            this();
        }
    }

    private Cookie(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j2;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }

    @k
    @e
    public static final Cookie parse(@d HttpUrl httpUrl, @d String str) {
        return Companion.parse(httpUrl, str);
    }

    @k
    @d
    public static final List<Cookie> parseAll(@d HttpUrl httpUrl, @d Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    @g(name = "-deprecated_domain")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "domain", imports = {}))
    @d
    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m148deprecated_domain() {
        return this.domain;
    }

    @g(name = "-deprecated_expiresAt")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "expiresAt", imports = {}))
    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m149deprecated_expiresAt() {
        return this.expiresAt;
    }

    @g(name = "-deprecated_hostOnly")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "hostOnly", imports = {}))
    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m150deprecated_hostOnly() {
        return this.hostOnly;
    }

    @g(name = "-deprecated_httpOnly")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "httpOnly", imports = {}))
    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m151deprecated_httpOnly() {
        return this.httpOnly;
    }

    @g(name = "-deprecated_name")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "name", imports = {}))
    @d
    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m152deprecated_name() {
        return this.name;
    }

    @g(name = "-deprecated_path")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "path", imports = {}))
    @d
    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m153deprecated_path() {
        return this.path;
    }

    @g(name = "-deprecated_persistent")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "persistent", imports = {}))
    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m154deprecated_persistent() {
        return this.persistent;
    }

    @g(name = "-deprecated_secure")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "secure", imports = {}))
    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m155deprecated_secure() {
        return this.secure;
    }

    @g(name = "-deprecated_value")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "value", imports = {}))
    @d
    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m156deprecated_value() {
        return this.value;
    }

    @g(name = "domain")
    @d
    public final String domain() {
        return this.domain;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (f0.g(cookie.name, this.name) && f0.g(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && f0.g(cookie.domain, this.domain) && f0.g(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    @g(name = "expiresAt")
    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + b.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + a.a(this.secure)) * 31) + a.a(this.httpOnly)) * 31) + a.a(this.persistent)) * 31) + a.a(this.hostOnly);
    }

    @g(name = "hostOnly")
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    @g(name = "httpOnly")
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(@d HttpUrl httpUrl) {
        boolean domainMatch;
        if (!this.hostOnly) {
            domainMatch = Companion.domainMatch(httpUrl.host(), this.domain);
        } else {
            domainMatch = f0.g(httpUrl.host(), this.domain);
        }
        if (domainMatch && Companion.pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    @g(name = "name")
    @d
    public final String name() {
        return this.name;
    }

    @g(name = "path")
    @d
    public final String path() {
        return this.path;
    }

    @g(name = "persistent")
    public final boolean persistent() {
        return this.persistent;
    }

    @g(name = "secure")
    public final boolean secure() {
        return this.secure;
    }

    @d
    public String toString() {
        return toString$okhttp(false);
    }

    @d
    public final String toString$okhttp(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    @g(name = "value")
    @d
    public final String value() {
        return this.value;
    }

    public /* synthetic */ Cookie(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, h.k2.v.u uVar) {
        this(str, str2, j2, str3, str4, z, z2, z3, z4);
    }
}
