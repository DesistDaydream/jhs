package com.umeng.analytics.filter;

import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class d {
    private static final String b = "Ă";

    /* renamed from: c  reason: collision with root package name */
    private MessageDigest f6980c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6982e;
    private final String a = "MD5";

    /* renamed from: d  reason: collision with root package name */
    private Set<Object> f6981d = new HashSet();

    public d(boolean z, String str) {
        int i2 = 0;
        this.f6982e = false;
        this.f6982e = z;
        try {
            this.f6980c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (str != null) {
            if (z) {
                try {
                    byte[] decode = Base64.decode(str.getBytes(), 0);
                    while (i2 < decode.length / 4) {
                        int i3 = i2 * 4;
                        this.f6981d.add(Integer.valueOf(((decode[i3 + 0] & 255) << 24) + ((decode[i3 + 1] & 255) << 16) + ((decode[i3 + 2] & 255) << 8) + (decode[i3 + 3] & 255)));
                        i2++;
                    }
                    return;
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            String[] split = str.split(b);
            int length = split.length;
            while (i2 < length) {
                this.f6981d.add(split[i2]);
                i2++;
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f6980c.update(str.getBytes());
            byte[] digest = this.f6980c.digest();
            return Integer.valueOf(((digest[0] & 255) << 24) + ((digest[1] & 255) << 16) + ((digest[2] & 255) << 8) + (digest[3] & 255));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        if (this.f6982e) {
            return this.f6981d.contains(c(str));
        }
        return this.f6981d.contains(str);
    }

    public void b(String str) {
        if (this.f6982e) {
            this.f6981d.add(c(str));
        } else {
            this.f6981d.add(str);
        }
    }

    public String toString() {
        if (this.f6982e) {
            byte[] bArr = new byte[this.f6981d.size() * 4];
            Iterator<Object> it = this.f6981d.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                int i3 = i2 + 1;
                bArr[i2] = (byte) (((-16777216) & intValue) >> 24);
                int i4 = i3 + 1;
                bArr[i3] = (byte) ((16711680 & intValue) >> 16);
                int i5 = i4 + 1;
                bArr[i4] = (byte) ((65280 & intValue) >> 8);
                i2 = i5 + 1;
                bArr[i5] = (byte) (intValue & 255);
            }
            return new String(Base64.encode(bArr, 0));
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.f6981d) {
            if (sb.length() > 0) {
                sb.append(b);
            }
            sb.append(obj.toString());
        }
        return sb.toString();
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.f6981d) {
            sb.append(obj);
            if (sb.length() > 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        System.out.println(sb.toString());
    }
}
