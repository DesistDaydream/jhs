package okhttp3.internal.platform;

import com.baidu.mobads.sdk.internal.bj;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import com.umeng.analytics.pro.am;
import h.a2.u;
import h.k2.k;
import h.k2.v.f0;
import j.m;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b=\u0010>J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ4\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0011\u0010\u0015\u001a\r\u0012\t\u0012\u00070\u0013¢\u0006\u0002\b\u00140\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010#\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J-\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020!2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u0004\u0018\u00010\u00012\u0006\u0010.\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u00100J!\u00102\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u0002042\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u0002072\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0002H\u0016¢\u0006\u0004\b<\u0010\u0004¨\u0006@"}, d2 = {"Lokhttp3/internal/platform/Platform;", "", "", "getPrefix", "()Ljava/lang/String;", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "hostname", "", "Lokhttp3/Protocol;", "Lh/k2/l;", "protocols", "Lh/t1;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "afterHandshake", "(Ljavax/net/ssl/SSLSocket;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", "address", "", "connectTimeout", "connectSocket", "(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V", "message", "level", "", am.aI, "log", "(Ljava/lang/String;ILjava/lang/Throwable;)V", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "closer", "getStackTraceForCloseable", "(Ljava/lang/String;)Ljava/lang/Object;", "stackTrace", "logCloseableLeak", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lokhttp3/internal/tls/CertificateChainCleaner;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/tls/TrustRootIndex;", "buildTrustRootIndex", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/TrustRootIndex;", "newSslSocketFactory", "(Ljavax/net/ssl/X509TrustManager;)Ljavax/net/ssl/SSLSocketFactory;", "toString", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class Platform {
    public static final Companion Companion;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger;
    private static volatile Platform platform;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u00020\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00158B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00158B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u001b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u001e\u0010!\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010#¨\u0006&"}, d2 = {"Lokhttp3/internal/platform/Platform$Companion;", "", "Lokhttp3/internal/platform/Platform;", "findPlatform", "()Lokhttp3/internal/platform/Platform;", "findAndroidPlatform", "findJvmPlatform", "get", "platform", "Lh/t1;", "resetForTests", "(Lokhttp3/internal/platform/Platform;)V", "", "Lokhttp3/Protocol;", "protocols", "", "alpnProtocolNames", "(Ljava/util/List;)Ljava/util/List;", "", "concatLengthPrefixed", "(Ljava/util/List;)[B", "", "isAndroid", "()Z", "isOpenJSSEPreferred", "isConscryptPreferred", "isBouncyCastlePreferred", "", "INFO", ExpandableTextView.P, "WARN", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", bj.a, "Ljava/util/logging/Logger;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        private final Platform findAndroidPlatform() {
            AndroidLog.INSTANCE.enable();
            Platform buildIfSupported = Android10Platform.Companion.buildIfSupported();
            return buildIfSupported != null ? buildIfSupported : AndroidPlatform.Companion.buildIfSupported();
        }

        private final Platform findJvmPlatform() {
            OpenJSSEPlatform buildIfSupported;
            BouncyCastlePlatform buildIfSupported2;
            ConscryptPlatform buildIfSupported3;
            if (!isConscryptPreferred() || (buildIfSupported3 = ConscryptPlatform.Companion.buildIfSupported()) == null) {
                if (!isBouncyCastlePreferred() || (buildIfSupported2 = BouncyCastlePlatform.Companion.buildIfSupported()) == null) {
                    if (!isOpenJSSEPreferred() || (buildIfSupported = OpenJSSEPlatform.Companion.buildIfSupported()) == null) {
                        Jdk9Platform buildIfSupported4 = Jdk9Platform.Companion.buildIfSupported();
                        if (buildIfSupported4 != null) {
                            return buildIfSupported4;
                        }
                        Platform buildIfSupported5 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
                        return buildIfSupported5 != null ? buildIfSupported5 : new Platform();
                    }
                    return buildIfSupported;
                }
                return buildIfSupported2;
            }
            return buildIfSupported3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Platform findPlatform() {
            if (isAndroid()) {
                return findAndroidPlatform();
            }
            return findJvmPlatform();
        }

        private final boolean isBouncyCastlePreferred() {
            return f0.g("BC", Security.getProviders()[0].getName());
        }

        private final boolean isConscryptPreferred() {
            return f0.g("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean isOpenJSSEPreferred() {
            return f0.g("OpenJSSE", Security.getProviders()[0].getName());
        }

        public static /* synthetic */ void resetForTests$default(Companion companion, Platform platform, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                platform = companion.findPlatform();
            }
            companion.resetForTests(platform);
        }

        @d
        public final List<String> alpnProtocolNames(@d List<? extends Protocol> list) {
            ArrayList<Protocol> arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(u.Y(arrayList, 10));
            for (Protocol protocol : arrayList) {
                arrayList2.add(protocol.toString());
            }
            return arrayList2;
        }

        @d
        public final byte[] concatLengthPrefixed(@d List<? extends Protocol> list) {
            m mVar = new m();
            for (String str : alpnProtocolNames(list)) {
                mVar.writeByte(str.length());
                mVar.B(str);
            }
            return mVar.Z();
        }

        @k
        @d
        public final Platform get() {
            return Platform.platform;
        }

        public final boolean isAndroid() {
            return f0.g("Dalvik", System.getProperty("java.vm.name"));
        }

        public final void resetForTests(@d Platform platform) {
            Platform.platform = platform;
        }

        public /* synthetic */ Companion(h.k2.v.u uVar) {
            this();
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        platform = companion.findPlatform();
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    @k
    @d
    public static final Platform get() {
        return Companion.get();
    }

    public static /* synthetic */ void log$default(Platform platform2, String str, int i2, Throwable th, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 4;
            }
            if ((i3 & 4) != 0) {
                th = null;
            }
            platform2.log(str, i2, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public void afterHandshake(@d SSLSocket sSLSocket) {
    }

    @d
    public CertificateChainCleaner buildCertificateChainCleaner(@d X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    @d
    public TrustRootIndex buildTrustRootIndex(@d X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void configureTlsExtensions(@d SSLSocket sSLSocket, @e String str, @d List<Protocol> list) {
    }

    public void connectSocket(@d Socket socket, @d InetSocketAddress inetSocketAddress, int i2) throws IOException {
        socket.connect(inetSocketAddress, i2);
    }

    @d
    public final String getPrefix() {
        return "OkHttp";
    }

    @e
    public String getSelectedProtocol(@d SSLSocket sSLSocket) {
        return null;
    }

    @e
    public Object getStackTraceForCloseable(@d String str) {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(@d String str) {
        return true;
    }

    public void log(@d String str, int i2, @e Throwable th) {
        logger.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void logCloseableLeak(@d String str, @e Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(str, 5, (Throwable) obj);
    }

    @d
    public SSLContext newSSLContext() {
        return SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
    }

    @d
    public SSLSocketFactory newSslSocketFactory(@d X509TrustManager x509TrustManager) {
        try {
            SSLContext newSSLContext = newSSLContext();
            newSSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return newSSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS: " + e2, e2);
        }
    }

    @d
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        boolean z = true;
        if ((trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) ? false : false) {
            TrustManager trustManager = trustManagers[0];
            Objects.requireNonNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return (X509TrustManager) trustManager;
        }
        throw new IllegalStateException(("Unexpected default trust managers: " + Arrays.toString(trustManagers)).toString());
    }

    @d
    public String toString() {
        return getClass().getSimpleName();
    }

    @e
    public X509TrustManager trustManager(@d SSLSocketFactory sSLSocketFactory) {
        try {
            Object readFieldOrNull = Util.readFieldOrNull(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (readFieldOrNull != null) {
                return (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
