package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.conscrypt.NativeCrypto;

/* loaded from: classes.dex */
public final class h {
    public static final Comparator<String> b;

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, h> f579c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f580d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f581e;

    /* renamed from: f  reason: collision with root package name */
    public static final h f582f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f583g;

    /* renamed from: h  reason: collision with root package name */
    public static final h f584h;

    /* renamed from: i  reason: collision with root package name */
    public static final h f585i;

    /* renamed from: j  reason: collision with root package name */
    public static final h f586j;

    /* renamed from: k  reason: collision with root package name */
    public static final h f587k;

    /* renamed from: l  reason: collision with root package name */
    public static final h f588l;

    /* renamed from: m  reason: collision with root package name */
    public static final h f589m;
    public static final h n;
    public static final h o;
    public static final h p;
    public static final h q;
    public static final h r;
    public final String a;

    /* loaded from: classes.dex */
    public static final class a implements Comparator<String> {
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
            return -1;
         */
        @Override // java.util.Comparator
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int compare(java.lang.String r6, java.lang.String r7) {
            /*
                r5 = this;
                int r0 = r6.length()
                int r1 = r7.length()
                int r0 = java.lang.Math.min(r0, r1)
                r1 = 4
            Ld:
                r2 = 1
                if (r1 >= r0) goto L20
                char r3 = r6.charAt(r1)
                char r4 = r7.charAt(r1)
                if (r3 == r4) goto L1d
                if (r3 >= r4) goto L30
                goto L2d
            L1d:
                int r1 = r1 + 1
                goto Ld
            L20:
                int r6 = r6.length()
                int r7 = r7.length()
                if (r6 == r7) goto L2f
                if (r6 < r7) goto L2d
                goto L30
            L2d:
                r2 = -1
                goto L30
            L2f:
                r2 = 0
            L30:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.h.a.compare(java.lang.String, java.lang.String):int");
        }
    }

    static {
        a aVar = new a();
        b = aVar;
        f579c = new TreeMap(aVar);
        a("SSL_RSA_WITH_NULL_MD5", 1);
        a("SSL_RSA_WITH_NULL_SHA", 2);
        a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        a("SSL_RSA_WITH_RC4_128_MD5", 4);
        a("SSL_RSA_WITH_RC4_128_SHA", 5);
        a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        a("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f580d = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        a("TLS_KRB5_WITH_RC4_128_SHA", 32);
        a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        a("TLS_KRB5_WITH_RC4_128_MD5", 36);
        a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f581e = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f582f = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        a("TLS_RSA_WITH_NULL_SHA256", 59);
        a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        a("TLS_PSK_WITH_RC4_128_SHA", 138);
        a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f583g = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f584h = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", TTAdConstant.IMAGE_MODE_LIVE);
        a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        a(NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV, 255);
        a("TLS_FALLBACK_SCSV", 22016);
        a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        f585i = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        f586j = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f587k = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        f588l = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        f589m = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        n = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        o = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        p = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        q = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        r = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    private h(String str) {
        Objects.requireNonNull(str);
        this.a = str;
    }

    public static h a(String str) {
        h hVar;
        synchronized (h.class) {
            Map<String, h> map = f579c;
            hVar = map.get(str);
            if (hVar == null) {
                hVar = new h(str);
                map.put(str, hVar);
            }
        }
        return hVar;
    }

    private static h a(String str, int i2) {
        return a(str);
    }

    public static List<h> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String toString() {
        return this.a;
    }
}
