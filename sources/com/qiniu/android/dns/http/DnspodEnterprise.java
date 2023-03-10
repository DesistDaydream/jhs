package com.qiniu.android.dns.http;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.util.Hex;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class DnspodEnterprise implements IResolver {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final String id;
    private final String ip;
    private final SecretKeySpec key;
    private final int timeout;

    public DnspodEnterprise(String str, String str2, String str3) {
        this(str, str2, str3, 10);
    }

    private String decrypt(String str) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(2, this.key);
            return new String(cipher.doFinal(Hex.decodeHex(str.toCharArray())));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private String encrypt(String str) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(1, this.key);
            byte[] doFinal = cipher.doFinal(str.getBytes(UTF_8));
            return Hex.encodeHexString(doFinal) + "&id=" + this.id;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://" + this.ip + "/d?ttl=1&dn=" + encrypt(domain.domain) + "&id=" + this.id).openConnection();
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setReadTimeout(this.timeout * 1000);
        Record[] recordArr = null;
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        int contentLength = httpURLConnection.getContentLength();
        if (contentLength > 0 && contentLength <= 1024) {
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[contentLength];
            int read = inputStream.read(bArr);
            inputStream.close();
            if (read <= 0) {
                return null;
            }
            String[] split = decrypt(new String(bArr, 0, read)).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length != 2) {
                return null;
            }
            try {
                int parseInt = Integer.parseInt(split[1]);
                String[] split2 = split[0].split(";");
                if (split2.length == 0) {
                    return null;
                }
                recordArr = new Record[split2.length];
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                for (int i2 = 0; i2 < split2.length; i2++) {
                    recordArr[i2] = new Record(split2[i2], 1, parseInt, currentTimeMillis, 2);
                }
            } catch (Exception unused) {
            }
        }
        return recordArr;
    }

    public DnspodEnterprise(String str, String str2, String str3, int i2) {
        this.id = str;
        this.ip = str3;
        this.timeout = i2;
        this.key = new SecretKeySpec(str2.getBytes(UTF_8), "DES");
    }

    public DnspodEnterprise(String str, String str2) {
        this(str, str2, "119.29.29.29");
    }
}
