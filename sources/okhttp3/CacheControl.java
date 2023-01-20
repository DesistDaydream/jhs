package okhttp3;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import h.i;
import h.k2.d;
import h.k2.g;
import h.k2.k;
import h.k2.v.u;
import h.q0;
import java.util.concurrent.TimeUnit;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 %2\u00020\u0001:\u0002&%Bs\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0015\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0013\u001a\u00020\b8\u0007@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u000b\u001a\u00020\b8\u0007@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0015\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b\u0007\u0010\u0004R\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0007@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\r\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b\u000f\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b\u0005\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\b8\u0007@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u0011\u0010\nR\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0019\u0010 \u001a\u0004\b\u0019\u0010\u0004¨\u0006'"}, d2 = {"Lokhttp3/CacheControl;", "", "", "-deprecated_noCache", "()Z", "noCache", "-deprecated_noStore", "noStore", "", "-deprecated_maxAgeSeconds", "()I", "maxAgeSeconds", "-deprecated_sMaxAgeSeconds", "sMaxAgeSeconds", "-deprecated_mustRevalidate", "mustRevalidate", "-deprecated_maxStaleSeconds", "maxStaleSeconds", "-deprecated_minFreshSeconds", "minFreshSeconds", "-deprecated_onlyIfCached", "onlyIfCached", "-deprecated_noTransform", "noTransform", "-deprecated_immutable", "immutable", "", "toString", "()Ljava/lang/String;", ExpandableTextView.P, "headerValue", "Ljava/lang/String;", "Z", "isPublic", "isPrivate", "<init>", "(ZZIIZZZIIZZZLjava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);
    @d
    @k.e.a.d
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    @d
    @k.e.a.d
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\t\u0010\fJ\u001d\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0007J\r\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0007J\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0007J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0016\u0010\u0010\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016¨\u0006\u001d"}, d2 = {"Lokhttp3/CacheControl$Builder;", "", "", "", "clampToInt", "(J)I", "noCache", "()Lokhttp3/CacheControl$Builder;", "noStore", "maxAge", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/CacheControl$Builder;", "maxStale", "minFresh", "onlyIfCached", "noTransform", "immutable", "Lokhttp3/CacheControl;", "build", "()Lokhttp3/CacheControl;", "", "Z", "maxStaleSeconds", ExpandableTextView.P, "minFreshSeconds", "maxAgeSeconds", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j2) {
            if (j2 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j2;
        }

        @k.e.a.d
        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        @k.e.a.d
        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        @k.e.a.d
        public final Builder maxAge(int i2, @k.e.a.d TimeUnit timeUnit) {
            if (i2 >= 0) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i2));
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + i2).toString());
        }

        @k.e.a.d
        public final Builder maxStale(int i2, @k.e.a.d TimeUnit timeUnit) {
            if (i2 >= 0) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i2));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i2).toString());
        }

        @k.e.a.d
        public final Builder minFresh(int i2, @k.e.a.d TimeUnit timeUnit) {
            if (i2 >= 0) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i2));
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + i2).toString());
        }

        @k.e.a.d
        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        @k.e.a.d
        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        @k.e.a.d
        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        @k.e.a.d
        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lokhttp3/CacheControl$Companion;", "", "", "characters", "", "startIndex", "indexOfElement", "(Ljava/lang/String;Ljava/lang/String;I)I", "Lokhttp3/Headers;", "headers", "Lokhttp3/CacheControl;", "parse", "(Lokhttp3/Headers;)Lokhttp3/CacheControl;", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        private final int indexOfElement(String str, String str2, int i2) {
            int length = str.length();
            while (i2 < length) {
                if (StringsKt__StringsKt.U2(str2, str.charAt(i2), false, 2, null)) {
                    return i2;
                }
                i2++;
            }
            return str.length();
        }

        public static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return companion.indexOfElement(str, str2, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:107:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x00d4  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x00d8  */
        @h.k2.k
        @k.e.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.CacheControl parse(@k.e.a.d okhttp3.Headers r32) {
            /*
                Method dump skipped, instructions count: 396
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.parse(okhttp3.Headers):okhttp3.CacheControl");
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    private CacheControl(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i2;
        this.sMaxAgeSeconds = i3;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i4;
        this.minFreshSeconds = i5;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    @k
    @k.e.a.d
    public static final CacheControl parse(@k.e.a.d Headers headers) {
        return Companion.parse(headers);
    }

    @g(name = "-deprecated_immutable")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "immutable", imports = {}))
    /* renamed from: -deprecated_immutable */
    public final boolean m130deprecated_immutable() {
        return this.immutable;
    }

    @g(name = "-deprecated_maxAgeSeconds")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "maxAgeSeconds", imports = {}))
    /* renamed from: -deprecated_maxAgeSeconds */
    public final int m131deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @g(name = "-deprecated_maxStaleSeconds")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "maxStaleSeconds", imports = {}))
    /* renamed from: -deprecated_maxStaleSeconds */
    public final int m132deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @g(name = "-deprecated_minFreshSeconds")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "minFreshSeconds", imports = {}))
    /* renamed from: -deprecated_minFreshSeconds */
    public final int m133deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @g(name = "-deprecated_mustRevalidate")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "mustRevalidate", imports = {}))
    /* renamed from: -deprecated_mustRevalidate */
    public final boolean m134deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @g(name = "-deprecated_noCache")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "noCache", imports = {}))
    /* renamed from: -deprecated_noCache */
    public final boolean m135deprecated_noCache() {
        return this.noCache;
    }

    @g(name = "-deprecated_noStore")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "noStore", imports = {}))
    /* renamed from: -deprecated_noStore */
    public final boolean m136deprecated_noStore() {
        return this.noStore;
    }

    @g(name = "-deprecated_noTransform")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "noTransform", imports = {}))
    /* renamed from: -deprecated_noTransform */
    public final boolean m137deprecated_noTransform() {
        return this.noTransform;
    }

    @g(name = "-deprecated_onlyIfCached")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "onlyIfCached", imports = {}))
    /* renamed from: -deprecated_onlyIfCached */
    public final boolean m138deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @g(name = "-deprecated_sMaxAgeSeconds")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "sMaxAgeSeconds", imports = {}))
    /* renamed from: -deprecated_sMaxAgeSeconds */
    public final int m139deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @g(name = "immutable")
    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    @g(name = "maxAgeSeconds")
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @g(name = "maxStaleSeconds")
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @g(name = "minFreshSeconds")
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @g(name = "mustRevalidate")
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @g(name = "noCache")
    public final boolean noCache() {
        return this.noCache;
    }

    @g(name = "noStore")
    public final boolean noStore() {
        return this.noStore;
    }

    @g(name = "noTransform")
    public final boolean noTransform() {
        return this.noTransform;
    }

    @g(name = "onlyIfCached")
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @g(name = "sMaxAgeSeconds")
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @k.e.a.d
    public String toString() {
        String str = this.headerValue;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.noCache) {
                sb.append("no-cache, ");
            }
            if (this.noStore) {
                sb.append("no-store, ");
            }
            if (this.maxAgeSeconds != -1) {
                sb.append("max-age=");
                sb.append(this.maxAgeSeconds);
                sb.append(", ");
            }
            if (this.sMaxAgeSeconds != -1) {
                sb.append("s-maxage=");
                sb.append(this.sMaxAgeSeconds);
                sb.append(", ");
            }
            if (this.isPrivate) {
                sb.append("private, ");
            }
            if (this.isPublic) {
                sb.append("public, ");
            }
            if (this.mustRevalidate) {
                sb.append("must-revalidate, ");
            }
            if (this.maxStaleSeconds != -1) {
                sb.append("max-stale=");
                sb.append(this.maxStaleSeconds);
                sb.append(", ");
            }
            if (this.minFreshSeconds != -1) {
                sb.append("min-fresh=");
                sb.append(this.minFreshSeconds);
                sb.append(", ");
            }
            if (this.onlyIfCached) {
                sb.append("only-if-cached, ");
            }
            if (this.noTransform) {
                sb.append("no-transform, ");
            }
            if (this.immutable) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            sb.delete(sb.length() - 2, sb.length());
            String sb2 = sb.toString();
            this.headerValue = sb2;
            return sb2;
        }
        return str;
    }

    public /* synthetic */ CacheControl(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str, u uVar) {
        this(z, z2, i2, i3, z3, z4, z5, i4, i5, z6, z7, z8, str);
    }
}
