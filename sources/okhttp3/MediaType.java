package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.i;
import h.k2.g;
import h.k2.h;
import h.k2.k;
import h.k2.v.f0;
import h.o2.q;
import h.q0;
import h.t2.u;
import h.t2.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\b\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0019\u0010\f\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\f\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006\u001f"}, d2 = {"Lokhttp3/MediaType;", "", "Ljava/nio/charset/Charset;", "defaultValue", "charset", "(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "", "name", "parameter", "(Ljava/lang/String;)Ljava/lang/String;", "-deprecated_type", "()Ljava/lang/String;", "type", "-deprecated_subtype", "subtype", "toString", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "parameterNamesAndValues", "[Ljava/lang/String;", "Ljava/lang/String;", "mediaType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    @d
    private final String subtype;
    @d
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u0005J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005R\u001e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u001e\u0010\u0013\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lokhttp3/MediaType$Companion;", "", "", "Lokhttp3/MediaType;", "get", "(Ljava/lang/String;)Lokhttp3/MediaType;", "toMediaType", "parse", "toMediaTypeOrNull", "mediaType", "-deprecated_get", "-deprecated_parse", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PARAMETER", "Ljava/util/regex/Pattern;", "QUOTED", "Ljava/lang/String;", "TOKEN", "TYPE_SUBTYPE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        @g(name = "-deprecated_get")
        @i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "mediaType.toMediaType()", imports = {"okhttp3.MediaType.Companion.toMediaType"}))
        @d
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final MediaType m194deprecated_get(@d String str) {
            return get(str);
        }

        @g(name = "-deprecated_parse")
        @e
        @i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "mediaType.toMediaTypeOrNull()", imports = {"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final MediaType m195deprecated_parse(@d String str) {
            return parse(str);
        }

        @g(name = "get")
        @k
        @d
        public final MediaType get(@d String str) {
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(str);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                Locale locale = Locale.US;
                Objects.requireNonNull(group, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = group.toLowerCase(locale);
                String group2 = matcher.group(2);
                Objects.requireNonNull(group2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = group2.toLowerCase(locale);
                ArrayList arrayList = new ArrayList();
                Matcher matcher2 = MediaType.PARAMETER.matcher(str);
                int end = matcher.end();
                while (end < str.length()) {
                    matcher2.region(end, str.length());
                    if (matcher2.lookingAt()) {
                        String group3 = matcher2.group(1);
                        if (group3 == null) {
                            end = matcher2.end();
                        } else {
                            String group4 = matcher2.group(2);
                            if (group4 == null) {
                                group4 = matcher2.group(3);
                            } else if (u.u2(group4, "'", false, 2, null) && u.J1(group4, "'", false, 2, null) && group4.length() > 2) {
                                group4 = group4.substring(1, group4.length() - 1);
                            }
                            arrayList.add(group3);
                            arrayList.add(group4);
                            end = matcher2.end();
                        }
                    } else {
                        throw new IllegalArgumentException(("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + y.a).toString());
                    }
                }
                Object[] array = arrayList.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                return new MediaType(str, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + str + y.a).toString());
        }

        @g(name = "parse")
        @k
        @e
        public final MediaType parse(@d String str) {
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(h.k2.v.u uVar) {
            this();
        }
    }

    private MediaType(String str, String str2, String str3, String[] strArr) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    @g(name = "get")
    @k
    @d
    public static final MediaType get(@d String str) {
        return Companion.get(str);
    }

    @g(name = "parse")
    @k
    @e
    public static final MediaType parse(@d String str) {
        return Companion.parse(str);
    }

    @g(name = "-deprecated_subtype")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "subtype", imports = {}))
    @d
    /* renamed from: -deprecated_subtype  reason: not valid java name */
    public final String m192deprecated_subtype() {
        return this.subtype;
    }

    @g(name = "-deprecated_type")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "type", imports = {}))
    @d
    /* renamed from: -deprecated_type  reason: not valid java name */
    public final String m193deprecated_type() {
        return this.type;
    }

    @h
    @e
    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    @h
    @e
    public final Charset charset(@e Charset charset) {
        String parameter = parameter("charset");
        if (parameter != null) {
            try {
                return Charset.forName(parameter);
            } catch (IllegalArgumentException unused) {
                return charset;
            }
        }
        return charset;
    }

    public boolean equals(@e Object obj) {
        return (obj instanceof MediaType) && f0.g(((MediaType) obj).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    @e
    public final String parameter(@d String str) {
        h.o2.i S0 = q.S0(ArraysKt___ArraysKt.Kd(this.parameterNamesAndValues), 2);
        int d2 = S0.d();
        int f2 = S0.f();
        int g2 = S0.g();
        if (g2 >= 0) {
            if (d2 > f2) {
                return null;
            }
        } else if (d2 < f2) {
            return null;
        }
        while (!u.K1(this.parameterNamesAndValues[d2], str, true)) {
            if (d2 == f2) {
                return null;
            }
            d2 += g2;
        }
        return this.parameterNamesAndValues[d2 + 1];
    }

    @g(name = "subtype")
    @d
    public final String subtype() {
        return this.subtype;
    }

    @d
    public String toString() {
        return this.mediaType;
    }

    @g(name = "type")
    @d
    public final String type() {
        return this.type;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String[] strArr, h.k2.v.u uVar) {
        this(str, str2, str3, strArr);
    }
}
