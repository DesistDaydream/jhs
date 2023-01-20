package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.IOException;

/* loaded from: classes.dex */
public enum w {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String a;

    w(String str) {
        this.a = str;
    }

    public static w a(String str) throws IOException {
        w wVar = HTTP_1_0;
        if (!str.equals(wVar.a)) {
            wVar = HTTP_1_1;
            if (!str.equals(wVar.a)) {
                wVar = HTTP_2;
                if (!str.equals(wVar.a)) {
                    wVar = SPDY_3;
                    if (!str.equals(wVar.a)) {
                        throw new IOException("Unexpected protocol: " + str);
                    }
                }
            }
        }
        return wVar;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
