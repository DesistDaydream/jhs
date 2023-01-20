package com.qiniu.android.dns.dns;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes3.dex */
public class DohResolver extends DnsResolver {
    public DohResolver(String str) {
        super(str);
    }

    @Override // com.qiniu.android.dns.dns.DnsResolver
    public DnsResponse request(String str, String str2, int i2) throws IOException {
        int contentLength;
        DnsRequest dnsRequest = new DnsRequest((short) (Math.random() * 65535.0d), i2, str2);
        byte[] dnsQuestionData = dnsRequest.toDnsQuestionData();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setConnectTimeout(3000);
        httpsURLConnection.setReadTimeout(this.timeout * 1000);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Content-Type", "application/dns-message");
        httpsURLConnection.setRequestProperty("Accept", "application/dns-message");
        httpsURLConnection.setRequestProperty("Accept-Encoding", "");
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.write(dnsQuestionData);
        dataOutputStream.close();
        if (httpsURLConnection.getResponseCode() == 200 && (contentLength = httpsURLConnection.getContentLength()) > 0 && contentLength <= 1048576) {
            InputStream inputStream = httpsURLConnection.getInputStream();
            byte[] bArr = new byte[contentLength];
            int read = inputStream.read(bArr);
            inputStream.close();
            if (read <= 0) {
                return null;
            }
            return new DnsResponse(str, 5, dnsRequest, bArr);
        }
        return null;
    }

    public DohResolver(String str, int i2) {
        super(str, i2);
    }

    public DohResolver(String str, int i2, int i3) {
        super(str, i2, i3);
    }

    public DohResolver(String[] strArr, int i2, int i3) {
        super(strArr, i2, i3);
    }

    public DohResolver(String[] strArr, int i2, int i3, ExecutorService executorService) {
        super(strArr, i2, i3, executorService);
    }
}
