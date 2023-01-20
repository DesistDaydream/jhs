package com.qiniu.android.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.text.TextUtils;
import com.jihuanshe.mmkv.UserKV;
import com.qiniu.android.dns.NetworkInfo;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class NetworkReceiver extends BroadcastReceiver {
    private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    private static DnsManager mdnsManager;

    public static NetworkInfo createNetInfo(android.net.NetworkInfo networkInfo, Context context) {
        NetworkInfo.NetSatus netSatus;
        String extraInfo;
        if (networkInfo == null) {
            return NetworkInfo.noNetwork;
        }
        int i2 = 0;
        if (networkInfo.getType() == 1) {
            netSatus = NetworkInfo.NetSatus.WIFI;
        } else {
            NetworkInfo.NetSatus netSatus2 = NetworkInfo.NetSatus.MOBILE;
            Cursor query = context.getContentResolver().query(PREFERRED_APN_URI, null, null, null, null);
            if (query != null) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(UserKV.f3914d));
                if (!TextUtils.isEmpty(string) && (string.startsWith("ctwap") || string.startsWith("ctnet"))) {
                    i2 = 1;
                }
            }
            query.close();
            if (i2 != 1 && (extraInfo = networkInfo.getExtraInfo()) != null) {
                String lowerCase = extraInfo.toLowerCase(Locale.getDefault());
                if (lowerCase.equals("cmwap") || lowerCase.equals("cmnet")) {
                    i2 = 3;
                } else if (lowerCase.equals("3gnet") || lowerCase.equals("uninet") || lowerCase.equals("3gwap") || lowerCase.equals("uniwap")) {
                    i2 = 2;
                }
            }
            netSatus = netSatus2;
        }
        return new NetworkInfo(netSatus, i2);
    }

    public static void setDnsManager(DnsManager dnsManager) {
        mdnsManager = dnsManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (mdnsManager == null) {
            return;
        }
        mdnsManager.onNetworkChange(createNetInfo(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo(), context));
    }
}
