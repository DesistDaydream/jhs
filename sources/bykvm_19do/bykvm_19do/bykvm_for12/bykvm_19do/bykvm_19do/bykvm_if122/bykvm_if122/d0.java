package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.conscrypt.NativeCrypto;

/* loaded from: classes.dex */
public enum d0 {
    TLS_1_3(NativeCrypto.SUPPORTED_PROTOCOL_TLSV1_3),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0(NativeCrypto.OBSOLETE_PROTOCOL_SSLV3);
    
    public final String a;

    d0(String str) {
        this.a = str;
    }

    public static d0 a(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -503070503:
                if (str.equals("TLSv1.1")) {
                    c2 = 0;
                    break;
                }
                break;
            case -503070502:
                if (str.equals("TLSv1.2")) {
                    c2 = 1;
                    break;
                }
                break;
            case -503070501:
                if (str.equals(NativeCrypto.SUPPORTED_PROTOCOL_TLSV1_3)) {
                    c2 = 2;
                    break;
                }
                break;
            case 79201641:
                if (str.equals(NativeCrypto.OBSOLETE_PROTOCOL_SSLV3)) {
                    c2 = 3;
                    break;
                }
                break;
            case 79923350:
                if (str.equals("TLSv1")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return TLS_1_1;
            case 1:
                return TLS_1_2;
            case 2:
                return TLS_1_3;
            case 3:
                return SSL_3_0;
            case 4:
                return TLS_1_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    public static List<d0> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
