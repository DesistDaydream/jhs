package org.conscrypt;

import com.moor.imkf.IMChatManager;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

/* loaded from: classes4.dex */
public abstract class AbstractSessionContext implements SSLSessionContext {
    private static final int DEFAULT_SESSION_TIMEOUT_SECONDS = 28800;
    private volatile int maximumSize;
    private volatile int timeout = DEFAULT_SESSION_TIMEOUT_SECONDS;
    public final long sslCtxNativePointer = NativeCrypto.SSL_CTX_new();
    private final Map<ByteArray, NativeSslSession> sessions = new LinkedHashMap<ByteArray, NativeSslSession>() { // from class: org.conscrypt.AbstractSessionContext.1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<ByteArray, NativeSslSession> entry) {
            if (AbstractSessionContext.this.maximumSize <= 0 || size() <= AbstractSessionContext.this.maximumSize) {
                return false;
            }
            AbstractSessionContext.this.onBeforeRemoveSession(entry.getValue());
            return true;
        }
    };

    public AbstractSessionContext(int i2) {
        this.maximumSize = i2;
    }

    private void trimToSize() {
        synchronized (this.sessions) {
            int size = this.sessions.size();
            if (size > this.maximumSize) {
                int i2 = size - this.maximumSize;
                Iterator<NativeSslSession> it = this.sessions.values().iterator();
                while (true) {
                    int i3 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    onBeforeRemoveSession(it.next());
                    it.remove();
                    i2 = i3;
                }
            }
        }
    }

    public final void cacheSession(NativeSslSession nativeSslSession) {
        byte[] id = nativeSslSession.getId();
        if (id == null || id.length == 0) {
            return;
        }
        synchronized (this.sessions) {
            ByteArray byteArray = new ByteArray(id);
            if (this.sessions.containsKey(byteArray)) {
                removeSession(this.sessions.get(byteArray));
            }
            onBeforeAddSession(nativeSslSession);
            this.sessions.put(byteArray, nativeSslSession);
        }
    }

    public void finalize() throws Throwable {
        try {
            NativeCrypto.SSL_CTX_free(this.sslCtxNativePointer, this);
        } finally {
            super.finalize();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final Enumeration<byte[]> getIds() {
        final Iterator it;
        synchronized (this.sessions) {
            it = Arrays.asList(this.sessions.values().toArray(new NativeSslSession[this.sessions.size()])).iterator();
        }
        return new Enumeration<byte[]>() { // from class: org.conscrypt.AbstractSessionContext.2
            private NativeSslSession next;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                if (this.next != null) {
                    return true;
                }
                while (it.hasNext()) {
                    NativeSslSession nativeSslSession = (NativeSslSession) it.next();
                    if (nativeSslSession.isValid()) {
                        this.next = nativeSslSession;
                        return true;
                    }
                }
                this.next = null;
                return false;
            }

            @Override // java.util.Enumeration
            public byte[] nextElement() {
                if (hasMoreElements()) {
                    byte[] id = this.next.getId();
                    this.next = null;
                    return id;
                }
                throw new NoSuchElementException();
            }
        };
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final SSLSession getSession(byte[] bArr) {
        NativeSslSession nativeSslSession;
        Objects.requireNonNull(bArr, IMChatManager.CONSTANT_SESSIONID);
        ByteArray byteArray = new ByteArray(bArr);
        synchronized (this.sessions) {
            nativeSslSession = this.sessions.get(byteArray);
        }
        if (nativeSslSession == null || !nativeSslSession.isValid()) {
            return null;
        }
        return nativeSslSession.toSSLSession();
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final int getSessionCacheSize() {
        return this.maximumSize;
    }

    public final NativeSslSession getSessionFromCache(byte[] bArr) {
        NativeSslSession nativeSslSession;
        if (bArr == null) {
            return null;
        }
        synchronized (this.sessions) {
            nativeSslSession = this.sessions.get(new ByteArray(bArr));
        }
        if (nativeSslSession != null && nativeSslSession.isValid()) {
            if (nativeSslSession.isSingleUse()) {
                removeSession(nativeSslSession);
            }
            return nativeSslSession;
        }
        return getSessionFromPersistentCache(bArr);
    }

    public abstract NativeSslSession getSessionFromPersistentCache(byte[] bArr);

    @Override // javax.net.ssl.SSLSessionContext
    public final int getSessionTimeout() {
        return this.timeout;
    }

    public abstract void onBeforeAddSession(NativeSslSession nativeSslSession);

    public abstract void onBeforeRemoveSession(NativeSslSession nativeSslSession);

    public final void removeSession(NativeSslSession nativeSslSession) {
        byte[] id = nativeSslSession.getId();
        if (id == null || id.length == 0) {
            return;
        }
        onBeforeRemoveSession(nativeSslSession);
        ByteArray byteArray = new ByteArray(id);
        synchronized (this.sessions) {
            this.sessions.remove(byteArray);
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final void setSessionCacheSize(int i2) throws IllegalArgumentException {
        if (i2 >= 0) {
            int i3 = this.maximumSize;
            this.maximumSize = i2;
            if (i2 < i3) {
                trimToSize();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("size < 0");
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final void setSessionTimeout(int i2) throws IllegalArgumentException {
        if (i2 >= 0) {
            synchronized (this.sessions) {
                this.timeout = i2;
                if (i2 > 0) {
                    NativeCrypto.SSL_CTX_set_timeout(this.sslCtxNativePointer, this, i2);
                } else {
                    NativeCrypto.SSL_CTX_set_timeout(this.sslCtxNativePointer, this, 2147483647L);
                }
                Iterator<NativeSslSession> it = this.sessions.values().iterator();
                while (it.hasNext()) {
                    NativeSslSession next = it.next();
                    if (!next.isValid()) {
                        onBeforeRemoveSession(next);
                        it.remove();
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("seconds < 0");
    }
}
