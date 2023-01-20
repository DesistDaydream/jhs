package com.qiniu.android.dns.local;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.dns.DnsUdpResolver;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class AndroidDnsServer {

    /* loaded from: classes3.dex */
    public static class AndroidResolver implements IResolver {
        private List<InetAddress> dnsServers = new ArrayList();
        private boolean networkCallback = false;

        @TargetApi(21)
        public AndroidResolver(Context context) {
            List<InetAddress> byReflection = AndroidDnsServer.getByReflection();
            byReflection = byReflection == null ? AndroidDnsServer.getByCommand() : byReflection;
            if (byReflection == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    NetworkRequest.Builder builder = new NetworkRequest.Builder();
                    if (connectivityManager != null) {
                        try {
                            connectivityManager.registerNetworkCallback(builder.build(), new ConnectivityManager.NetworkCallback() { // from class: com.qiniu.android.dns.local.AndroidDnsServer.AndroidResolver.1
                                @Override // android.net.ConnectivityManager.NetworkCallback
                                public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                                    if (linkProperties != null) {
                                        AndroidResolver.this.dnsServers.addAll(linkProperties.getDnsServers());
                                    }
                                    AndroidResolver.this.networkCallback = true;
                                }
                            });
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.dnsServers.addAll(byReflection);
        }

        @Override // com.qiniu.android.dns.IResolver
        public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
            boolean z;
            if (this.dnsServers.isEmpty() && !this.networkCallback) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            List<InetAddress> list = this.dnsServers;
            if (list != null && !list.isEmpty()) {
                InetAddress inetAddress = this.dnsServers.get(0);
                Record[] resolve = new HijackingDetectWrapper(new DnsUdpResolver(inetAddress.getHostName())).resolve(domain, networkInfo);
                if (domain.hasCname) {
                    int length = resolve.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = false;
                            break;
                        } else if (resolve[i2].isCname()) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        throw new DnshijackingException(domain.domain, inetAddress.getHostAddress());
                    }
                }
                if (domain.maxTtl != 0) {
                    for (Record record : resolve) {
                        if (!record.isCname() && record.ttl > domain.maxTtl) {
                            throw new DnshijackingException(domain.domain, inetAddress.getHostAddress(), record.ttl);
                        }
                    }
                }
                return resolve;
            }
            throw new IOException("cant get local dns server");
        }
    }

    public static IResolver defaultResolver(Context context) {
        return new AndroidResolver(context);
    }

    public static List<InetAddress> getByCommand() {
        int i2;
        String hostAddress;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
            ArrayList arrayList = new ArrayList(5);
            while (true) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf("]: [");
                if (indexOf > 1 && readLine.length() - 1 > (i2 = indexOf + 4)) {
                    String substring = readLine.substring(1, indexOf);
                    String substring2 = readLine.substring(i2, readLine.length() - 1);
                    if (substring.endsWith(".dns") || substring.endsWith(".dns1") || substring.endsWith(".dns2") || substring.endsWith(".dns3") || substring.endsWith(".dns4")) {
                        InetAddress byName = InetAddress.getByName(substring2);
                        if (byName != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0) {
                            arrayList.add(byName);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (IOException e2) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", (Throwable) e2);
            return null;
        }
    }

    public static List<InetAddress> getByReflection() {
        ArrayList arrayList;
        InetAddress byName;
        String hostAddress;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            arrayList = new ArrayList(5);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i2 = 0; i2 < 4; i2++) {
                String str = (String) method.invoke(null, strArr[i2]);
                if (str != null && str.length() != 0 && (byName = InetAddress.getByName(str)) != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0 && !arrayList.contains(byName)) {
                    arrayList.add(byName);
                }
            }
        } catch (Exception e2) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", (Throwable) e2);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }
}
