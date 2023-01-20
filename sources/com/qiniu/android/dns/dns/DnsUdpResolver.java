package com.qiniu.android.dns.dns;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class DnsUdpResolver extends DnsResolver {
    private static final int DnsUdpPort = 53;

    public DnsUdpResolver(String str) {
        super(str);
    }

    @Override // com.qiniu.android.dns.dns.DnsResolver
    public DnsResponse request(String str, String str2, int i2) throws IOException {
        DatagramSocket datagramSocket;
        DnsRequest dnsRequest = new DnsRequest((short) (Math.random() * 65535.0d), i2, str2);
        byte[] dnsQuestionData = dnsRequest.toDnsQuestionData();
        InetAddress byName = InetAddress.getByName(str);
        DatagramSocket datagramSocket2 = null;
        try {
            datagramSocket = new DatagramSocket();
        } catch (Throwable th) {
            th = th;
        }
        try {
            DatagramPacket datagramPacket = new DatagramPacket(dnsQuestionData, dnsQuestionData.length, byName, 53);
            datagramSocket.setSoTimeout(this.timeout * 1000);
            datagramSocket.send(datagramPacket);
            DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1500], 1500);
            datagramSocket.receive(datagramPacket2);
            DnsResponse dnsResponse = new DnsResponse(str, 4, dnsRequest, datagramPacket2.getData());
            datagramSocket.close();
            return dnsResponse;
        } catch (Throwable th2) {
            th = th2;
            datagramSocket2 = datagramSocket;
            if (datagramSocket2 != null) {
                datagramSocket2.close();
            }
            throw th;
        }
    }

    public DnsUdpResolver(String str, int i2) {
        super(str, i2);
    }

    public DnsUdpResolver(String str, int i2, int i3) {
        super(str, i2, i3);
    }

    public DnsUdpResolver(String[] strArr, int i2, int i3) {
        super(strArr, i2, i3);
    }

    public DnsUdpResolver(String[] strArr, int i2, int i3, ExecutorService executorService) {
        super(strArr, i2, i3, executorService);
    }
}
