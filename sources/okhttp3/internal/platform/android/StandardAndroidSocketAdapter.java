package okhttp3.internal.platform.android;

import com.tencent.android.tpush.common.Constants;
import h.k2.v.u;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B3\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000e0\n\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\n\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter;", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "", "matchesSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)Z", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljava/lang/Class;", "paramClass", "Ljava/lang/Class;", "sslSocketFactoryClass", "Ljavax/net/ssl/SSLSocket;", "sslSocketClass", "<init>", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    public static final Companion Companion = new Companion(null);
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter$Companion;", "", "", Constants.FLAG_PACKAGE_NAME, "Lokhttp3/internal/platform/android/SocketAdapter;", "buildIfSupported", "(Ljava/lang/String;)Lokhttp3/internal/platform/android/SocketAdapter;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion companion, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(str);
        }

        @e
        public final SocketAdapter buildIfSupported(@d String str) {
            try {
                Class<?> cls = Class.forName(str + ".OpenSSLSocketImpl");
                if (cls != null) {
                    Class<?> cls2 = Class.forName(str + ".OpenSSLSocketFactoryImpl");
                    if (cls2 != null) {
                        return new StandardAndroidSocketAdapter(cls, cls2, Class.forName(str + ".SSLParametersImpl"));
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
            } catch (Exception e2) {
                Platform.Companion.get().log("unable to load android socket classes", 5, e2);
                return null;
            }
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public StandardAndroidSocketAdapter(@d Class<? super SSLSocket> cls, @d Class<? super SSLSocketFactory> cls2, @d Class<?> cls3) {
        super(cls);
        this.sslSocketFactoryClass = cls2;
        this.paramClass = cls3;
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(@d SSLSocketFactory sSLSocketFactory) {
        return this.sslSocketFactoryClass.isInstance(sSLSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    @e
    public X509TrustManager trustManager(@d SSLSocketFactory sSLSocketFactory) {
        Object readFieldOrNull = Util.readFieldOrNull(sSLSocketFactory, this.paramClass, "sslParameters");
        X509TrustManager x509TrustManager = (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
    }
}
