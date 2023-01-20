package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.a2.t0;
import h.i;
import h.k2.g;
import h.k2.v.f0;
import h.q0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u001c\u0010\u001dB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001eJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\bR'\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\n8G@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\r\u0010\fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00068G@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u0013\u0010\u0003\u001a\u00020\u00028G@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0011R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\t\u0010\b¨\u0006\u001f"}, d2 = {"Lokhttp3/Challenge;", "", "Ljava/nio/charset/Charset;", "charset", "withCharset", "(Ljava/nio/charset/Charset;)Lokhttp3/Challenge;", "", "-deprecated_scheme", "()Ljava/lang/String;", "scheme", "", "-deprecated_authParams", "()Ljava/util/Map;", "authParams", "-deprecated_realm", "realm", "-deprecated_charset", "()Ljava/nio/charset/Charset;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/util/Map;", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Challenge {
    @d
    private final Map<String, String> authParams;
    @d
    private final String scheme;

    public Challenge(@d String str, @d Map<String, String> map) {
        String str2;
        this.scheme = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                Objects.requireNonNull(key, "null cannot be cast to non-null type java.lang.String");
                str2 = key.toLowerCase(locale);
            } else {
                str2 = null;
            }
            linkedHashMap.put(str2, value);
        }
        this.authParams = Collections.unmodifiableMap(linkedHashMap);
    }

    @g(name = "-deprecated_authParams")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "authParams", imports = {}))
    @d
    /* renamed from: -deprecated_authParams  reason: not valid java name */
    public final Map<String, String> m140deprecated_authParams() {
        return this.authParams;
    }

    @g(name = "-deprecated_charset")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "charset", imports = {}))
    @d
    /* renamed from: -deprecated_charset  reason: not valid java name */
    public final Charset m141deprecated_charset() {
        return charset();
    }

    @g(name = "-deprecated_realm")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "realm", imports = {}))
    /* renamed from: -deprecated_realm  reason: not valid java name */
    public final String m142deprecated_realm() {
        return realm();
    }

    @g(name = "-deprecated_scheme")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "scheme", imports = {}))
    @d
    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m143deprecated_scheme() {
        return this.scheme;
    }

    @g(name = "authParams")
    @d
    public final Map<String, String> authParams() {
        return this.authParams;
    }

    @g(name = "charset")
    @d
    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return StandardCharsets.ISO_8859_1;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (f0.g(challenge.scheme, this.scheme) && f0.g(challenge.authParams, this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    @g(name = "realm")
    @e
    public final String realm() {
        return this.authParams.get("realm");
    }

    @g(name = "scheme")
    @d
    public final String scheme() {
        return this.scheme;
    }

    @d
    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    @d
    public final Challenge withCharset(@d Charset charset) {
        Map J0 = t0.J0(this.authParams);
        J0.put("charset", charset.name());
        return new Challenge(this.scheme, J0);
    }

    public Challenge(@d String str, @d String str2) {
        this(str, Collections.singletonMap("realm", str2));
    }
}
