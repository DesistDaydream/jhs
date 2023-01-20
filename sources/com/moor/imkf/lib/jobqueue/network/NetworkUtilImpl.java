package com.moor.imkf.lib.jobqueue.network;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PowerManager;
import com.moor.imkf.lib.jobqueue.network.NetworkEventProvider;

/* loaded from: classes2.dex */
public class NetworkUtilImpl implements NetworkUtil, NetworkEventProvider {
    private NetworkEventProvider.Listener listener;

    public NetworkUtilImpl(Context context) {
        Context applicationContext = context.getApplicationContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 >= 23) {
                listenForIdle(applicationContext);
            }
            listenNetworkViaConnectivityManager(applicationContext);
            return;
        }
        applicationContext.registerReceiver(new BroadcastReceiver() { // from class: com.moor.imkf.lib.jobqueue.network.NetworkUtilImpl.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                NetworkUtilImpl.this.dispatchNetworkChange(context2);
            }
        }, getNetworkIntentFilter());
    }

    @TargetApi(23)
    private static IntentFilter getNetworkIntentFilter() {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        }
        return intentFilter;
    }

    @TargetApi(23)
    private static boolean isDozing(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return powerManager.isDeviceIdleMode() && !powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
        }
        return false;
    }

    @TargetApi(23)
    private void listenForIdle(Context context) {
        context.registerReceiver(new BroadcastReceiver() { // from class: com.moor.imkf.lib.jobqueue.network.NetworkUtilImpl.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                NetworkUtilImpl.this.dispatchNetworkChange(context2);
            }
        }, new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"));
    }

    @TargetApi(23)
    private void listenNetworkViaConnectivityManager(final Context context) {
        ((ConnectivityManager) context.getSystemService("connectivity")).registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addCapability(13).build(), new ConnectivityManager.NetworkCallback() { // from class: com.moor.imkf.lib.jobqueue.network.NetworkUtilImpl.2
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                NetworkUtilImpl.this.dispatchNetworkChange(context);
            }
        });
    }

    public void dispatchNetworkChange(Context context) {
        NetworkEventProvider.Listener listener = this.listener;
        if (listener == null) {
            return;
        }
        listener.onNetworkChange(getNetworkStatus(context));
    }

    @Override // com.moor.imkf.lib.jobqueue.network.NetworkUtil
    public int getNetworkStatus(Context context) {
        NetworkInfo activeNetworkInfo;
        if (isDozing(context) || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return 0;
        }
        return (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) ? 2 : 1;
    }

    @Override // com.moor.imkf.lib.jobqueue.network.NetworkEventProvider
    public void setListener(NetworkEventProvider.Listener listener) {
        this.listener = listener;
    }
}
