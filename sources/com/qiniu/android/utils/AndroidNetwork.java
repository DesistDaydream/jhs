package com.qiniu.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* loaded from: classes3.dex */
public final class AndroidNetwork {
    public static String getHostIP() {
        Enumeration<NetworkInterface> networkInterfaces;
        String str = null;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e2) {
            e2.printStackTrace();
        }
        if (networkInterfaces == null) {
            return null;
        }
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (true) {
                if (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLinkLocalAddress() && !nextElement.isLoopbackAddress()) {
                        str = nextElement.getHostAddress();
                        break;
                    }
                }
            }
        }
        return str;
    }

    private static String getNetWorkClass(Context context) {
        TelephonyManager telephonyManager;
        if (context.checkPermission(PermissionConstants.PHONE_STATE, Process.myPid(), Process.myUid()) == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2g";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return Constants.NETWORK_CLASS_3_G;
                case 13:
                    return Constants.NETWORK_CLASS_4_G;
                default:
                    return "none";
            }
        }
        return "none";
    }

    public static boolean isNetWorkReady() {
        Context applicationContext = ContextGetter.applicationContext();
        if (applicationContext == null) {
            return true;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static String networkType(Context context) {
        try {
            return networkTypeWithException(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String networkTypeWithException(Context context) throws Exception {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return "wifi";
            }
            if (type == 0) {
                return getNetWorkClass(context);
            }
        }
        return "none";
    }
}
