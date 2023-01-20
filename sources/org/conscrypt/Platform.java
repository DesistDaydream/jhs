package org.conscrypt;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import com.umeng.analytics.pro.am;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;
import java.security.AlgorithmParameters;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.ct.CTLogStore;
import org.conscrypt.ct.CTPolicy;

/* loaded from: classes4.dex */
public final class Platform {
    private static final String TAG = "Conscrypt";
    private static Method m_getCurveName;

    static {
        try {
            Method declaredMethod = ECParameterSpec.class.getDeclaredMethod("getCurveName", new Class[0]);
            m_getCurveName = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    private Platform() {
    }

    public static void blockGuardOnNetwork() {
        BlockGuard.getThreadPolicy().onNetwork();
    }

    @SuppressLint({"NewApi"})
    public static void checkClientTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, AbstractConscryptSocket abstractConscryptSocket) throws CertificateException {
        if (checkTrusted("checkClientTrusted", x509TrustManager, x509CertificateArr, str, Socket.class, abstractConscryptSocket) || checkTrusted("checkClientTrusted", x509TrustManager, x509CertificateArr, str, String.class, abstractConscryptSocket.getHandshakeSession().getPeerHost())) {
            return;
        }
        x509TrustManager.checkClientTrusted(x509CertificateArr, str);
    }

    @SuppressLint({"NewApi"})
    public static void checkServerTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, AbstractConscryptSocket abstractConscryptSocket) throws CertificateException {
        if (checkTrusted("checkServerTrusted", x509TrustManager, x509CertificateArr, str, Socket.class, abstractConscryptSocket) || checkTrusted("checkServerTrusted", x509TrustManager, x509CertificateArr, str, String.class, abstractConscryptSocket.getHandshakeSession().getPeerHost())) {
            return;
        }
        x509TrustManager.checkServerTrusted(x509CertificateArr, str);
    }

    private static boolean checkTrusted(String str, X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str2, Class<?> cls, Object obj) throws CertificateException {
        try {
            x509TrustManager.getClass().getMethod(str, X509Certificate[].class, String.class, cls).invoke(x509TrustManager, x509CertificateArr, str2, obj);
            return true;
        } catch (IllegalAccessException | NoSuchMethodException unused) {
            return false;
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof CertificateException) {
                throw ((CertificateException) e2.getCause());
            }
            throw new RuntimeException(e2.getCause());
        }
    }

    public static void closeGuardClose(Object obj) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        ((CloseGuard) obj).close();
    }

    public static CloseGuard closeGuardGet() {
        if (Build.VERSION.SDK_INT < 14) {
            return null;
        }
        return CloseGuard.get();
    }

    public static void closeGuardOpen(Object obj, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        ((CloseGuard) obj).open(str);
    }

    public static void closeGuardWarnIfOpen(Object obj) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        ((CloseGuard) obj).warnIfOpen();
    }

    public static ConscryptEngineSocket createEngineSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(sSLParametersImpl);
        }
        return new ConscryptEngineSocket(sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(sSLParametersImpl);
    }

    public static GCMParameters fromGCMParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
        Class<?> cls;
        try {
            cls = Class.forName("javax.crypto.spec.GCMParameterSpec");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null || !cls.isAssignableFrom(algorithmParameterSpec.getClass())) {
            return null;
        }
        try {
            return new GCMParameters(((Integer) cls.getMethod("getTLen", new Class[0]).invoke(algorithmParameterSpec, new Object[0])).intValue(), (byte[]) cls.getMethod("getIV", new Class[0]).invoke(algorithmParameterSpec, new Object[0]));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("GCMParameterSpec lacks expected methods", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("GCMParameterSpec lacks expected methods", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Could not fetch GCM parameters", e4.getTargetException());
        }
    }

    public static AlgorithmParameterSpec fromGCMParameters(AlgorithmParameters algorithmParameters) {
        Class<?> cls;
        try {
            cls = Class.forName("javax.crypto.spec.GCMParameterSpec");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return algorithmParameters.getParameterSpec(cls);
            } catch (InvalidParameterSpecException unused2) {
            }
        }
        return null;
    }

    private static Class<?> getClass(String... strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                return Class.forName(strArr[i2]);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getCurveName(ECParameterSpec eCParameterSpec) {
        Method method = m_getCurveName;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(eCParameterSpec, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static KeyStore getDefaultCertKeyStore() throws KeyStoreException {
        KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
        try {
            keyStore.load(null, null);
            return keyStore;
        } catch (IOException e2) {
            throw new KeyStoreException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new KeyStoreException(e3);
        } catch (CertificateException e4) {
            throw new KeyStoreException(e4);
        }
    }

    public static String getDefaultProviderName() {
        return TAG;
    }

    public static String getEndpointIdentificationAlgorithm(SSLParameters sSLParameters) {
        return null;
    }

    public static FileDescriptor getFileDescriptor(Socket socket) {
        try {
            Field declaredField = Socket.class.getDeclaredField("impl");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(socket);
            Field declaredField2 = SocketImpl.class.getDeclaredField("fd");
            declaredField2.setAccessible(true);
            return (FileDescriptor) declaredField2.get(obj);
        } catch (Exception e2) {
            throw new RuntimeException("Can't get FileDescriptor from socket", e2);
        }
    }

    public static FileDescriptor getFileDescriptorFromSSLSocket(AbstractConscryptSocket abstractConscryptSocket) {
        return getFileDescriptor(abstractConscryptSocket);
    }

    public static String getHostStringFromInetSocketAddress(InetSocketAddress inetSocketAddress) {
        if (Build.VERSION.SDK_INT > 23) {
            try {
                return (String) InetSocketAddress.class.getDeclaredMethod("getHostString", new Class[0]).invoke(inetSocketAddress, new Object[0]);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String getOriginalHostNameFromInetAddress(InetAddress inetAddress) {
        if (Build.VERSION.SDK_INT > 27) {
            try {
                Method declaredMethod = InetAddress.class.getDeclaredMethod("holder", new Class[0]);
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Class.forName("java.net.InetAddress$InetAddressHolder").getDeclaredMethod("getOriginalHostName", new Class[0]);
                declaredMethod2.setAccessible(true);
                String str = (String) declaredMethod2.invoke(declaredMethod.invoke(inetAddress, new Object[0]), new Object[0]);
                return str == null ? inetAddress.getHostAddress() : str;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to get originalHostName", e2);
            }
        }
        return inetAddress.getHostAddress();
    }

    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) {
        try {
            getSSLParametersFromImpl(sSLParameters, sSLParametersImpl);
            if (Build.VERSION.SDK_INT >= 24) {
                setParametersSniHostname(sSLParameters, sSLParametersImpl, abstractConscryptSocket);
            }
        } catch (IllegalAccessException | NoSuchMethodException unused) {
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2.getCause());
        }
    }

    private static void getSSLParametersFromImpl(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        sSLParameters.getClass().getMethod("setEndpointIdentificationAlgorithm", String.class).invoke(sSLParameters, sSLParametersImpl.getEndpointIdentificationAlgorithm());
        sSLParameters.getClass().getMethod("setUseCipherSuitesOrder", Boolean.TYPE).invoke(sSLParameters, Boolean.valueOf(sSLParametersImpl.getUseCipherSuitesOrder()));
    }

    @TargetApi(24)
    private static String getSniHostnameFromParams(SSLParameters sSLParameters) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<SNIServerName> list = (List) sSLParameters.getClass().getMethod("getServerNames", new Class[0]).invoke(sSLParameters, new Object[0]);
        if (list != null) {
            for (SNIServerName sNIServerName : list) {
                if (sNIServerName.getType() == 0) {
                    return ((SNIHostName) sNIServerName).getAsciiName();
                }
            }
            return null;
        }
        return null;
    }

    public static boolean isCTVerificationRequired(String str) {
        String property;
        boolean z = false;
        if (str == null || (property = Security.getProperty("conscrypt.ct.enable")) == null || !Boolean.valueOf(property).booleanValue()) {
            return false;
        }
        List<String> asList = Arrays.asList(str.split("\\."));
        Collections.reverse(asList);
        String str2 = "conscrypt.ct.enforce";
        for (String str3 : asList) {
            String property2 = Security.getProperty(str2 + ".*");
            if (property2 != null) {
                z = Boolean.valueOf(property2).booleanValue();
            }
            str2 = str2 + "." + str3;
        }
        String property3 = Security.getProperty(str2);
        return property3 != null ? Boolean.valueOf(property3).booleanValue() : z;
    }

    public static void logEvent(String str) {
        try {
            Class<?> cls = Class.forName("android.os.Process");
            int intValue = ((Integer) cls.getMethod("myUid", null).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0])).intValue();
            Class<?> cls2 = Class.forName("android.util.EventLog");
            cls2.getMethod("writeEvent", Integer.TYPE, Object[].class).invoke(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), 1397638484, new Object[]{"conscrypt", Integer.valueOf(intValue), str});
        } catch (Exception unused) {
        }
    }

    private static void logStackTraceSnippet(String str, Throwable th) {
        Log.w(TAG, str);
        StackTraceElement[] stackTrace = th.getStackTrace();
        for (int i2 = 0; i2 < 2 && i2 < stackTrace.length; i2++) {
            Log.w(TAG, "\tat " + stackTrace[i2].toString());
        }
    }

    public static CertBlacklist newDefaultBlacklist() {
        return null;
    }

    public static ConscryptCertStore newDefaultCertStore() {
        return null;
    }

    public static CTLogStore newDefaultLogStore() {
        return null;
    }

    public static CTPolicy newDefaultPolicy(CTLogStore cTLogStore) {
        return null;
    }

    public static String oidToAlgorithmName(String str) {
        try {
            try {
                Method declaredMethod = Class.forName("org.apache.harmony.security.utils.AlgNameMapper").getDeclaredMethod("map2AlgName", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, str);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (!(cause instanceof RuntimeException)) {
                    if (cause instanceof Error) {
                        throw ((Error) cause);
                    }
                    throw new RuntimeException(e2);
                }
                throw ((RuntimeException) cause);
            } catch (Exception unused) {
                Class<?> cls = Class.forName("sun.security.x509.AlgorithmId");
                Method declaredMethod2 = cls.getDeclaredMethod("get", String.class);
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("getName", new Class[0]);
                declaredMethod3.setAccessible(true);
                return (String) declaredMethod3.invoke(declaredMethod2.invoke(null, str), new Object[0]);
            }
        } catch (InvocationTargetException e3) {
            Throwable cause2 = e3.getCause();
            if (!(cause2 instanceof RuntimeException)) {
                if (cause2 instanceof Error) {
                    throw ((Error) cause2);
                }
                throw new RuntimeException(e3);
            }
            throw ((RuntimeException) cause2);
        } catch (Exception unused2) {
            return str;
        }
    }

    public static boolean provideTrustManagerByDefault() {
        return false;
    }

    public static void setCurveName(ECParameterSpec eCParameterSpec, String str) {
        try {
            eCParameterSpec.getClass().getDeclaredMethod("setCurveName", String.class).invoke(eCParameterSpec, str);
        } catch (Exception unused) {
        }
    }

    public static void setEndpointIdentificationAlgorithm(SSLParameters sSLParameters, String str) {
    }

    @TargetApi(24)
    private static void setParametersSniHostname(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (sSLParametersImpl.getUseSni() && AddressUtils.isValidSniHostname(abstractConscryptSocket.getHostname())) {
            sSLParameters.getClass().getMethod("setServerNames", List.class).invoke(sSLParameters, Collections.singletonList(new SNIHostName(abstractConscryptSocket.getHostname())));
        }
    }

    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) {
        String sniHostnameFromParams;
        try {
            setSSLParametersOnImpl(sSLParameters, sSLParametersImpl);
            if (Build.VERSION.SDK_INT < 24 || (sniHostnameFromParams = getSniHostnameFromParams(sSLParameters)) == null) {
                return;
            }
            abstractConscryptSocket.setHostname(sniHostnameFromParams);
        } catch (IllegalAccessException | NoSuchMethodException unused) {
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2.getCause());
        }
    }

    private static void setSSLParametersOnImpl(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        sSLParametersImpl.setEndpointIdentificationAlgorithm((String) sSLParameters.getClass().getMethod("getEndpointIdentificationAlgorithm", new Class[0]).invoke(sSLParameters, new Object[0]));
        sSLParametersImpl.setUseCipherSuitesOrder(((Boolean) sSLParameters.getClass().getMethod("getUseCipherSuitesOrder", new Class[0]).invoke(sSLParameters, new Object[0])).booleanValue());
    }

    public static void setSocketWriteTimeout(Socket socket, long j2) throws SocketException {
        try {
            FileDescriptor fileDescriptor = getFileDescriptor(socket);
            if (fileDescriptor != null && fileDescriptor.valid()) {
                Class<?> cls = getClass("android.system.StructTimeval", "libcore.io.StructTimeval");
                if (cls == null) {
                    Log.w(TAG, "StructTimeval == null; not setting socket write timeout");
                    return;
                }
                Method declaredMethod = cls.getDeclaredMethod("fromMillis", Long.TYPE);
                if (declaredMethod == null) {
                    Log.w(TAG, "fromMillis == null; not setting socket write timeout");
                    return;
                }
                Object invoke = declaredMethod.invoke(null, Long.valueOf(j2));
                Class<?> cls2 = Class.forName("libcore.io.Libcore");
                if (cls2 == null) {
                    Log.w(TAG, "Libcore == null; not setting socket write timeout");
                    return;
                }
                Field field = cls2.getField(am.x);
                if (field == null) {
                    Log.w(TAG, "os == null; not setting socket write timeout");
                    return;
                }
                Object obj = field.get(null);
                if (obj == null) {
                    Log.w(TAG, "instance_os == null; not setting socket write timeout");
                    return;
                }
                Class<?> cls3 = getClass("android.system.OsConstants", "libcore.io.OsConstants");
                if (cls3 == null) {
                    Log.w(TAG, "OsConstants == null; not setting socket write timeout");
                    return;
                }
                Field field2 = cls3.getField("SOL_SOCKET");
                if (field2 == null) {
                    Log.w(TAG, "SOL_SOCKET == null; not setting socket write timeout");
                    return;
                }
                Field field3 = cls3.getField("SO_SNDTIMEO");
                if (field3 == null) {
                    Log.w(TAG, "SO_SNDTIMEO == null; not setting socket write timeout");
                    return;
                }
                Class<?> cls4 = obj.getClass();
                Class<?> cls5 = Integer.TYPE;
                Method method = cls4.getMethod("setsockoptTimeval", FileDescriptor.class, cls5, cls5, cls);
                if (method == null) {
                    Log.w(TAG, "setsockoptTimeval == null; not setting socket write timeout");
                    return;
                } else {
                    method.invoke(obj, fileDescriptor, field2.get(null), field3.get(null), invoke);
                    return;
                }
            }
            throw new SocketException("Socket closed");
        } catch (Exception e2) {
            logStackTraceSnippet("Could not set socket write timeout: " + e2, e2);
            for (Throwable cause = e2.getCause(); cause != null; cause = cause.getCause()) {
                logStackTraceSnippet("Caused by: " + cause, cause);
            }
        }
    }

    public static void setup() {
    }

    public static boolean supportsConscryptCertStore() {
        return false;
    }

    public static boolean supportsX509ExtendedTrustManager() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static AlgorithmParameterSpec toGCMParameterSpec(int i2, byte[] bArr) {
        Class<?> cls;
        try {
            cls = Class.forName("javax.crypto.spec.GCMParameterSpec");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (AlgorithmParameterSpec) cls.getConstructor(Integer.TYPE, byte[].class).newInstance(Integer.valueOf(i2), bArr);
            } catch (IllegalAccessException e2) {
                e = e2;
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e3) {
                e = e3;
                e.printStackTrace();
                return null;
            } catch (InstantiationException e4) {
                e = e4;
                e.printStackTrace();
                return null;
            } catch (NoSuchMethodException e5) {
                e = e5;
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e6) {
                e6.getCause().printStackTrace();
            }
        }
        return null;
    }

    public static SSLEngine unwrapEngine(SSLEngine sSLEngine) {
        return sSLEngine;
    }

    public static SSLEngine wrapEngine(ConscryptEngine conscryptEngine) {
        return conscryptEngine;
    }

    public static OpenSSLKey wrapRsaKey(PrivateKey privateKey) {
        if (Build.VERSION.SDK_INT >= 17) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLRSAPrivateKey");
            if (!cls.isInstance(privateKey)) {
                Log.e(TAG, "Private key is not an OpenSSLRSAPrivateKey instance, its class name is:" + privateKey.getClass().getCanonicalName());
                return null;
            }
            try {
                Method declaredMethod = cls.getDeclaredMethod("getOpenSSLKey", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(privateKey, new Object[0]);
                declaredMethod.setAccessible(false);
                if (invoke == null) {
                    Log.e(TAG, "Could not getOpenSSLKey on instance: " + privateKey.toString());
                    return null;
                }
                try {
                    Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getPkeyContext", new Class[0]);
                    declaredMethod2.setAccessible(true);
                    long longValue = ((Number) declaredMethod2.invoke(invoke, new Object[0])).longValue();
                    declaredMethod2.setAccessible(false);
                    if (longValue == 0) {
                        Log.e(TAG, "getPkeyContext() returned null");
                        return null;
                    }
                    return new OpenSSLKey(longValue);
                } catch (Exception e2) {
                    Log.e(TAG, "No getPkeyContext() method on OpenSSLKey member:" + e2);
                    return null;
                }
            } catch (Exception e3) {
                Log.e(TAG, "Error during conversion of privatekey instance: " + privateKey.toString(), e3);
                return null;
            }
        } catch (Exception e4) {
            Log.e(TAG, "Cannot find system OpenSSLRSAPrivateKey class: " + e4);
            return null;
        }
    }

    public static SSLSession wrapSSLSession(ExternalSession externalSession) {
        return Build.VERSION.SDK_INT >= 24 ? new Java8ExtendedSSLSession(externalSession) : externalSession;
    }

    public static SSLSocketFactory wrapSocketFactoryIfNeeded(OpenSSLSocketFactoryImpl openSSLSocketFactoryImpl) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            return new PreKitKatPlatformOpenSSLSocketAdapterFactory(openSSLSocketFactoryImpl);
        }
        return i2 < 22 ? new KitKatPlatformOpenSSLSocketAdapterFactory(openSSLSocketFactoryImpl) : openSSLSocketFactoryImpl;
    }

    public static ConscryptEngineSocket createEngineSocket(String str, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(str, i2, sSLParametersImpl);
        }
        return new ConscryptEngineSocket(str, i2, sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(String str, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(str, i2, sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(str, i2, sSLParametersImpl);
    }

    @SuppressLint({"NewApi"})
    public static void checkClientTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, ConscryptEngine conscryptEngine) throws CertificateException {
        if (checkTrusted("checkClientTrusted", x509TrustManager, x509CertificateArr, str, SSLEngine.class, conscryptEngine) || checkTrusted("checkClientTrusted", x509TrustManager, x509CertificateArr, str, String.class, conscryptEngine.getHandshakeSession().getPeerHost())) {
            return;
        }
        x509TrustManager.checkClientTrusted(x509CertificateArr, str);
    }

    @SuppressLint({"NewApi"})
    public static void checkServerTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, ConscryptEngine conscryptEngine) throws CertificateException {
        if (checkTrusted("checkServerTrusted", x509TrustManager, x509CertificateArr, str, SSLEngine.class, conscryptEngine) || checkTrusted("checkServerTrusted", x509TrustManager, x509CertificateArr, str, String.class, conscryptEngine.getHandshakeSession().getPeerHost())) {
            return;
        }
        x509TrustManager.checkServerTrusted(x509CertificateArr, str);
    }

    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        try {
            getSSLParametersFromImpl(sSLParameters, sSLParametersImpl);
            if (Build.VERSION.SDK_INT >= 24) {
                setParametersSniHostname(sSLParameters, sSLParametersImpl, conscryptEngine);
            }
        } catch (IllegalAccessException | NoSuchMethodException unused) {
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2.getCause());
        }
    }

    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        String sniHostnameFromParams;
        try {
            setSSLParametersOnImpl(sSLParameters, sSLParametersImpl);
            if (Build.VERSION.SDK_INT < 24 || (sniHostnameFromParams = getSniHostnameFromParams(sSLParameters)) == null) {
                return;
            }
            conscryptEngine.setHostname(sniHostnameFromParams);
        } catch (IllegalAccessException | NoSuchMethodException unused) {
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2.getCause());
        }
    }

    public static ConscryptEngineSocket createEngineSocket(InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(inetAddress, i2, sSLParametersImpl);
        }
        return new ConscryptEngineSocket(inetAddress, i2, sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(inetAddress, i2, sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(inetAddress, i2, sSLParametersImpl);
    }

    @TargetApi(24)
    private static void setParametersSniHostname(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (sSLParametersImpl.getUseSni() && AddressUtils.isValidSniHostname(conscryptEngine.getHostname())) {
            sSLParameters.getClass().getMethod("setServerNames", List.class).invoke(sSLParameters, Collections.singletonList(new SNIHostName(conscryptEngine.getHostname())));
        }
    }

    public static ConscryptEngineSocket createEngineSocket(String str, int i2, InetAddress inetAddress, int i3, SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(str, i2, inetAddress, i3, sSLParametersImpl);
        }
        return new ConscryptEngineSocket(str, i2, inetAddress, i3, sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(String str, int i2, InetAddress inetAddress, int i3, SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(str, i2, inetAddress, i3, sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(str, i2, inetAddress, i3, sSLParametersImpl);
    }

    public static ConscryptEngineSocket createEngineSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3, SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(inetAddress, i2, inetAddress2, i3, sSLParametersImpl);
        }
        return new ConscryptEngineSocket(inetAddress, i2, inetAddress2, i3, sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3, SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(inetAddress, i2, inetAddress2, i3, sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(inetAddress, i2, inetAddress2, i3, sSLParametersImpl);
    }

    public static ConscryptEngineSocket createEngineSocket(Socket socket, String str, int i2, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(socket, str, i2, z, sSLParametersImpl);
        }
        return new ConscryptEngineSocket(socket, str, i2, z, sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(Socket socket, String str, int i2, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(socket, str, i2, z, sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(socket, str, i2, z, sSLParametersImpl);
    }
}
