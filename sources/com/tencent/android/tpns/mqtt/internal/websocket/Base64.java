package com.tencent.android.tpns.mqtt.internal.websocket;

import java.util.Objects;
import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;

/* loaded from: classes3.dex */
public class Base64 {
    private static final Base64Encoder ENCODER;
    private static final Base64 INSTANCE;

    /* loaded from: classes3.dex */
    public class Base64Encoder extends AbstractPreferences {
        private String base64String;

        public Base64Encoder() {
            super(null, "");
            this.base64String = null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public AbstractPreferences childSpi(String str) {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public String[] childrenNamesSpi() throws BackingStoreException {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public void flushSpi() throws BackingStoreException {
        }

        public String getBase64String() {
            return this.base64String;
        }

        @Override // java.util.prefs.AbstractPreferences
        public String getSpi(String str) {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public String[] keysSpi() throws BackingStoreException {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public void putSpi(String str, String str2) {
            this.base64String = str2;
        }

        @Override // java.util.prefs.AbstractPreferences
        public void removeNodeSpi() throws BackingStoreException {
        }

        @Override // java.util.prefs.AbstractPreferences
        public void removeSpi(String str) {
        }

        @Override // java.util.prefs.AbstractPreferences
        public void syncSpi() throws BackingStoreException {
        }
    }

    static {
        Base64 base64 = new Base64();
        INSTANCE = base64;
        Objects.requireNonNull(base64);
        ENCODER = new Base64Encoder();
    }

    public static String encode(String str) {
        Base64Encoder base64Encoder = ENCODER;
        base64Encoder.putByteArray("akey", str.getBytes());
        return base64Encoder.getBase64String();
    }

    public static String encodeBytes(byte[] bArr) {
        Base64Encoder base64Encoder = ENCODER;
        base64Encoder.putByteArray("aKey", bArr);
        return base64Encoder.getBase64String();
    }
}
