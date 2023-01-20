package okhttp3.internal.http2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import h.k2.d;
import h.k2.v.f0;
import h.k2.v.u;
import k.e.a.e;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0019B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/http2/Header;", "", "", "toString", "()Ljava/lang/String;", "Lokio/ByteString;", "component1", "()Lokio/ByteString;", "component2", "name", "value", "copy", "(Lokio/ByteString;Lokio/ByteString;)Lokhttp3/internal/http2/Header;", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lokio/ByteString;", "hpackSize", ExpandableTextView.P, "<init>", "(Lokio/ByteString;Lokio/ByteString;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "(Lokio/ByteString;Ljava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    @d
    @k.e.a.d
    public static final ByteString PSEUDO_PREFIX;
    @d
    @k.e.a.d
    public static final ByteString RESPONSE_STATUS;
    @k.e.a.d
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    @d
    @k.e.a.d
    public static final ByteString TARGET_AUTHORITY;
    @k.e.a.d
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    @d
    @k.e.a.d
    public static final ByteString TARGET_METHOD;
    @k.e.a.d
    public static final String TARGET_METHOD_UTF8 = ":method";
    @d
    @k.e.a.d
    public static final ByteString TARGET_PATH;
    @k.e.a.d
    public static final String TARGET_PATH_UTF8 = ":path";
    @d
    @k.e.a.d
    public static final ByteString TARGET_SCHEME;
    @k.e.a.d
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    @d
    public final int hpackSize;
    @d
    @k.e.a.d
    public final ByteString name;
    @d
    @k.e.a.d
    public final ByteString value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\b¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/http2/Header$Companion;", "", "Lokio/ByteString;", "PSEUDO_PREFIX", "Lokio/ByteString;", "RESPONSE_STATUS", "", "RESPONSE_STATUS_UTF8", "Ljava/lang/String;", "TARGET_AUTHORITY", "TARGET_AUTHORITY_UTF8", "TARGET_METHOD", "TARGET_METHOD_UTF8", "TARGET_PATH", "TARGET_PATH_UTF8", "TARGET_SCHEME", "TARGET_SCHEME_UTF8", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    static {
        ByteString.a aVar = ByteString.Companion;
        PSEUDO_PREFIX = aVar.l(Constants.COLON_SEPARATOR);
        RESPONSE_STATUS = aVar.l(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = aVar.l(TARGET_METHOD_UTF8);
        TARGET_PATH = aVar.l(TARGET_PATH_UTF8);
        TARGET_SCHEME = aVar.l(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = aVar.l(TARGET_AUTHORITY_UTF8);
    }

    public Header(@k.e.a.d ByteString byteString, @k.e.a.d ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString.size() + 32 + byteString2.size();
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            byteString = header.name;
        }
        if ((i2 & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    @k.e.a.d
    public final ByteString component1() {
        return this.name;
    }

    @k.e.a.d
    public final ByteString component2() {
        return this.value;
    }

    @k.e.a.d
    public final Header copy(@k.e.a.d ByteString byteString, @k.e.a.d ByteString byteString2) {
        return new Header(byteString, byteString2);
    }

    public boolean equals(@e Object obj) {
        if (this != obj) {
            if (obj instanceof Header) {
                Header header = (Header) obj;
                return f0.g(this.name, header.name) && f0.g(this.value, header.value);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        ByteString byteString = this.name;
        int hashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.value;
        return hashCode + (byteString2 != null ? byteString2.hashCode() : 0);
    }

    @k.e.a.d
    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Header(@k.e.a.d java.lang.String r2, @k.e.a.d java.lang.String r3) {
        /*
            r1 = this;
            okio.ByteString$a r0 = okio.ByteString.Companion
            okio.ByteString r2 = r0.l(r2)
            okio.ByteString r3 = r0.l(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Header.<init>(java.lang.String, java.lang.String):void");
    }

    public Header(@k.e.a.d ByteString byteString, @k.e.a.d String str) {
        this(byteString, ByteString.Companion.l(str));
    }
}
