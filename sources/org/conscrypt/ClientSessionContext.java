package org.conscrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ClientSessionContext extends AbstractSessionContext {
    private SSLClientSessionCache persistentCache;
    private final Map<HostAndPort, List<NativeSslSession>> sessionsByHostAndPort;

    /* loaded from: classes4.dex */
    public static final class HostAndPort {
        public final String host;
        public final int port;

        public HostAndPort(String str, int i2) {
            this.host = str;
            this.port = i2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof HostAndPort) {
                HostAndPort hostAndPort = (HostAndPort) obj;
                return this.host.equals(hostAndPort.host) && this.port == hostAndPort.port;
            }
            return false;
        }

        public int hashCode() {
            return (this.host.hashCode() * 31) + this.port;
        }
    }

    public ClientSessionContext() {
        super(10);
        this.sessionsByHostAndPort = new HashMap();
    }

    private NativeSslSession getSession(String str, int i2) {
        NativeSslSession nativeSslSession;
        byte[] sessionData;
        NativeSslSession newInstance;
        if (str == null) {
            return null;
        }
        HostAndPort hostAndPort = new HostAndPort(str, i2);
        synchronized (this.sessionsByHostAndPort) {
            List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
            nativeSslSession = (list == null || list.size() <= 0) ? null : list.get(0);
        }
        if (nativeSslSession == null || !nativeSslSession.isValid()) {
            SSLClientSessionCache sSLClientSessionCache = this.persistentCache;
            if (sSLClientSessionCache == null || (sessionData = sSLClientSessionCache.getSessionData(str, i2)) == null || (newInstance = NativeSslSession.newInstance(this, sessionData, str, i2)) == null || !newInstance.isValid()) {
                return null;
            }
            putSession(hostAndPort, newInstance);
            return newInstance;
        }
        return nativeSslSession;
    }

    private void putSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
            if (list == null) {
                list = new ArrayList<>();
                this.sessionsByHostAndPort.put(hostAndPort, list);
            }
            if (list.size() > 0 && list.get(0).isSingleUse() != nativeSslSession.isSingleUse()) {
                while (!list.isEmpty()) {
                    removeSession(list.get(0));
                }
                this.sessionsByHostAndPort.put(hostAndPort, list);
            }
            list.add(nativeSslSession);
        }
    }

    private void removeSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
            if (list != null) {
                list.remove(nativeSslSession);
                if (list.isEmpty()) {
                    this.sessionsByHostAndPort.remove(hostAndPort);
                }
            }
        }
    }

    public synchronized NativeSslSession getCachedSession(String str, int i2, SSLParametersImpl sSLParametersImpl) {
        boolean z;
        if (str == null) {
            return null;
        }
        NativeSslSession session = getSession(str, i2);
        if (session == null) {
            return null;
        }
        String protocol = session.getProtocol();
        String[] strArr = sSLParametersImpl.enabledProtocols;
        int length = strArr.length;
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z = false;
                break;
            } else if (protocol.equals(strArr[i3])) {
                z = true;
                break;
            } else {
                i3++;
            }
        }
        if (z) {
            String cipherSuite = session.getCipherSuite();
            String[] enabledCipherSuites = sSLParametersImpl.getEnabledCipherSuites();
            int length2 = enabledCipherSuites.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    break;
                } else if (cipherSuite.equals(enabledCipherSuites[i4])) {
                    z2 = true;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                if (session.isSingleUse()) {
                    removeSession(session);
                }
                return session;
            }
            return null;
        }
        return null;
    }

    @Override // org.conscrypt.AbstractSessionContext
    public NativeSslSession getSessionFromPersistentCache(byte[] bArr) {
        return null;
    }

    @Override // org.conscrypt.AbstractSessionContext
    public void onBeforeAddSession(NativeSslSession nativeSslSession) {
        byte[] bytes;
        String peerHost = nativeSslSession.getPeerHost();
        int peerPort = nativeSslSession.getPeerPort();
        if (peerHost == null) {
            return;
        }
        putSession(new HostAndPort(peerHost, peerPort), nativeSslSession);
        if (this.persistentCache == null || nativeSslSession.isSingleUse() || (bytes = nativeSslSession.toBytes()) == null) {
            return;
        }
        this.persistentCache.putSessionData(nativeSslSession.toSSLSession(), bytes);
    }

    @Override // org.conscrypt.AbstractSessionContext
    public void onBeforeRemoveSession(NativeSslSession nativeSslSession) {
        String peerHost = nativeSslSession.getPeerHost();
        if (peerHost == null) {
            return;
        }
        removeSession(new HostAndPort(peerHost, nativeSslSession.getPeerPort()), nativeSslSession);
    }

    public void setPersistentCache(SSLClientSessionCache sSLClientSessionCache) {
        this.persistentCache = sSLClientSessionCache;
    }

    public int size() {
        int i2;
        synchronized (this.sessionsByHostAndPort) {
            i2 = 0;
            for (List<NativeSslSession> list : this.sessionsByHostAndPort.values()) {
                i2 += list.size();
            }
        }
        return i2;
    }
}
