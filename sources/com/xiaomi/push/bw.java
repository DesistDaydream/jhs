package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;

/* loaded from: classes3.dex */
public final class bw {
    private String a;
    private int b;

    public bw(String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    public static bw a(String str, int i2) {
        int lastIndexOf = str.lastIndexOf(Constants.COLON_SEPARATOR);
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i2 = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new bw(str, i2);
    }

    public static InetSocketAddress b(String str, int i2) {
        bw a = a(str, i2);
        return new InetSocketAddress(a.b(), a.a());
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String toString() {
        if (this.b > 0) {
            return this.a + Constants.COLON_SEPARATOR + this.b;
        }
        return this.a;
    }
}
