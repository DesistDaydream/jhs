package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes.dex */
public final class k {
    public final w a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final String f367c;

    public k(w wVar, int i2, String str) {
        this.a = wVar;
        this.b = i2;
        this.f367c = str;
    }

    public static k a(String str) throws IOException {
        w wVar;
        String str2;
        int i2 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                wVar = w.HTTP_1_0;
            } else if (charAt != 1) {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                wVar = w.HTTP_1_1;
            }
        } else if (!str.startsWith("ICY ")) {
            throw new ProtocolException("Unexpected status line: " + str);
        } else {
            wVar = w.HTTP_1_0;
            i2 = 4;
        }
        int i3 = i2 + 3;
        if (str.length() < i3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i2, i3));
            if (str.length() <= i3) {
                str2 = "";
            } else if (str.charAt(i3) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                str2 = str.substring(i2 + 4);
            }
            return new k(wVar, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a == w.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.b);
        if (this.f367c != null) {
            sb.append(' ');
            sb.append(this.f367c);
        }
        return sb.toString();
    }
}
