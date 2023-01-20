package okhttp3;

import com.moor.imkf.IMChatManager;
import h.k2.h;
import h.k2.k;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import k.e.a.d;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lokhttp3/Credentials;", "", "", IMChatManager.CONSTANT_USERNAME, "password", "Ljava/nio/charset/Charset;", "charset", "basic", "(Ljava/lang/String;Ljava/lang/String;Ljava/nio/charset/Charset;)Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    @h
    @k
    @d
    public static final String basic(@d String str, @d String str2) {
        return basic$default(str, str2, null, 4, null);
    }

    @h
    @k
    @d
    public static final String basic(@d String str, @d String str2, @d Charset charset) {
        String base64 = ByteString.Companion.j(str + ':' + str2, charset).base64();
        return "Basic " + base64;
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
        }
        return basic(str, str2, charset);
    }
}
