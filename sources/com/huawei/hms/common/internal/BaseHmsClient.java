package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class BaseHmsClient implements AidlApiClient {
    private static final int BINDING = 5;
    private static final int CONNECTED = 3;
    private static final int DISCONNECTED = 1;
    private static final int MSG_CONN_TIMEOUT = 2;
    private static final String TAG = "BaseHmsClient";
    public static final int TIMEOUT_DISCONNECTED = 6;
    private static BinderAdapter mInnerBinderAdapter;
    private static BinderAdapter mOuterBinderAdapter;
    private HuaweiApi.RequestHandler internalRequest;
    private String mAppID;
    private final ClientSettings mClientSettings;
    private Handler mConnectTimeoutHandler = null;
    private final ConnectionCallbacks mConnectionCallbacks;
    private final OnConnectionFailedListener mConnectionFailedListener;
    private final Context mContext;
    private volatile IAIDLInvoke mService;
    public String sessionId;
    private static final Object LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
    private static final AtomicInteger CONN_STATUS = new AtomicInteger(1);
    private static final AtomicInteger INNER_CONN_STATUS = new AtomicInteger(1);

    /* loaded from: classes2.dex */
    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i2);
    }

    /* loaded from: classes2.dex */
    public static final class ConnectionResultWrapper {
        private ConnectionResult connectionResult;
        private HuaweiApi.RequestHandler request;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            this.request = requestHandler;
            this.connectionResult = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            return this.connectionResult;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.request;
        }
    }

    /* loaded from: classes2.dex */
    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.mContext = context;
        this.mClientSettings = clientSettings;
        this.mAppID = clientSettings.getAppID();
        this.mConnectionFailedListener = onConnectionFailedListener;
        this.mConnectionCallbacks = connectionCallbacks;
    }

    private void bindCoreInternal(String str, String str2) {
        if (this.mClientSettings.isUseInnerHms()) {
            mInnerBinderAdapter = InnerBinderAdapter.getInstance(this.mContext, str2, str);
            if (isConnected()) {
                HMSLog.i(TAG, "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            }
            setConnectStatus(5);
            mInnerBinderAdapter.binder(newBinderCallBack());
            return;
        }
        mOuterBinderAdapter = OuterBinderAdapter.getInstance(this.mContext, str2, str);
        if (isConnected()) {
            HMSLog.i(TAG, "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
            return;
        }
        setConnectStatus(5);
        mOuterBinderAdapter.binder(newBinderCallBack());
    }

    private void cancelConnDelayHandle() {
        synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
            Handler handler = this.mConnectTimeoutHandler;
            if (handler != null) {
                handler.removeMessages(2);
                this.mConnectTimeoutHandler = null;
            }
        }
    }

    private void checkAvailabilityAndConnect(int i2, boolean z) {
        HMSLog.i(TAG, "====== HMSSDK version: 60500300 ======");
        int i3 = (this.mClientSettings.isUseInnerHms() ? INNER_CONN_STATUS : CONN_STATUS).get();
        HMSLog.i(TAG, "Enter connect, Connection Status: " + i3);
        if (z || !(i3 == 3 || i3 == 5)) {
            if (getMinApkVersion() > i2) {
                i2 = getMinApkVersion();
            }
            HMSLog.i(TAG, "connect minVersion:" + i2 + " packageName:" + this.mClientSettings.getInnerHmsPkg());
            if (this.mContext.getPackageName().equals(this.mClientSettings.getInnerHmsPkg())) {
                HMSLog.i(TAG, "service packageName is same, bind core service return");
                bindCoreService();
            } else if (Util.isAvailableLibExist(this.mContext)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i2);
                int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.mContext);
                HMSLog.i(TAG, "check available result: " + isHuaweiMobileServicesAvailable);
                if (isHuaweiMobileServicesAvailable == 0) {
                    bindCoreService();
                } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.i(TAG, "bindCoreService3.0 fail, start resolution now.");
                    resolution(availableAdapter, isHuaweiMobileServicesAvailable);
                } else if (availableAdapter.isUserNoticeError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.i(TAG, "bindCoreService3.0 fail, start notice now.");
                    notice(availableAdapter, isHuaweiMobileServicesAvailable);
                } else {
                    HMSLog.i(TAG, "bindCoreService3.0 fail: " + isHuaweiMobileServicesAvailable + " is not resolvable.");
                    notifyFailed(isHuaweiMobileServicesAvailable);
                }
            } else {
                int isHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.mContext, i2);
                HMSLog.i(TAG, "HuaweiApiAvailability check available result: " + isHuaweiMobileServicesAvailable2);
                if (isHuaweiMobileServicesAvailable2 == 0) {
                    bindCoreService();
                } else {
                    notifyFailed(isHuaweiMobileServicesAvailable2);
                }
            }
        }
    }

    private BinderAdapter.BinderCallBack newBinderCallBack() {
        return new BinderAdapter.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1
            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i2) {
                onBinderFailed(i2, null);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onNullBinding(ComponentName componentName) {
                BaseHmsClient.this.setConnectStatus(1);
                BaseHmsClient.this.notifyFailed(10);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.i(BaseHmsClient.TAG, "Enter onServiceConnected.");
                BaseHmsClient.this.connectedInternal(iBinder);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.i(BaseHmsClient.TAG, "Enter onServiceDisconnected.");
                BaseHmsClient.this.setConnectStatus(1);
                RequestManager.getHandler().sendEmptyMessage(10013);
                if (BaseHmsClient.this.mConnectionCallbacks == null || (BaseHmsClient.this.mConnectionCallbacks instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.mConnectionCallbacks.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onTimedDisconnected() {
                BaseHmsClient.this.setConnectStatus(6);
                if (BaseHmsClient.this.mConnectionCallbacks == null || (BaseHmsClient.this.mConnectionCallbacks instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.mConnectionCallbacks.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i2, Intent intent) {
                if (intent != null) {
                    Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
                    if (activeActivity != null) {
                        HMSLog.i(BaseHmsClient.TAG, "onBinderFailed: SDK try to resolve and reConnect!");
                        long time = new Timestamp(System.currentTimeMillis()).getTime();
                        FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                            @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                            public void binderCallBack(int i3) {
                                if (i3 != 0) {
                                    BaseHmsClient.this.notifyFailed(new ConnectionResult(10, (PendingIntent) null));
                                    BaseHmsClient.this.mService = null;
                                }
                            }
                        });
                        intent.putExtra("callId", time);
                        activeActivity.startActivity(intent);
                        return;
                    }
                    HMSLog.i(BaseHmsClient.TAG, "onBinderFailed: return pendingIntent to kit and cp");
                    BaseHmsClient.this.notifyFailed(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.mContext, 11, intent, 67108864)));
                    BaseHmsClient.this.mService = null;
                    return;
                }
                HMSLog.i(BaseHmsClient.TAG, "onBinderFailed: intent is null!");
                BaseHmsClient.this.notifyFailed(new ConnectionResult(10, (PendingIntent) null));
                BaseHmsClient.this.mService = null;
            }
        };
    }

    private void notice(AvailableAdapter availableAdapter, int i2) {
        HMSLog.i(TAG, "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i2 == 29) {
                i2 = 9;
            }
            notifyFailed(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.mContext, i2, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.2
                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i3) {
                    BaseHmsClient.this.notifyFailed(i3);
                }
            });
        } else {
            notifyFailed(26);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailed(int i2) {
        HMSLog.i(TAG, "notifyFailed result: " + i2);
        Message message = new Message();
        message.what = 10012;
        message.obj = new ConnectionResultWrapper(this.internalRequest, new ConnectionResult(i2));
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.mConnectionFailedListener;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i2));
    }

    private void resolution(AvailableAdapter availableAdapter, int i2) {
        HMSLog.i(TAG, "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            notifyFailed(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.mContext, i2, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.3
                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i3) {
                    if (i3 == 0) {
                        BaseHmsClient.this.bindCoreService();
                    } else {
                        BaseHmsClient.this.notifyFailed(i3);
                    }
                }
            });
        } else {
            notifyFailed(26);
        }
    }

    private void tryUnBind() {
        HMSLog.w(TAG, "Failed to get service as interface, trying to unbind.");
        if (this.mClientSettings.isUseInnerHms()) {
            BinderAdapter binderAdapter = mInnerBinderAdapter;
            if (binderAdapter == null) {
                HMSLog.w(TAG, "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            BinderAdapter binderAdapter2 = mOuterBinderAdapter;
            if (binderAdapter2 == null) {
                HMSLog.w(TAG, "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        setConnectStatus(1);
        notifyFailed(10);
    }

    private void unBindAdapter() {
        if (this.mClientSettings.isUseInnerHms()) {
            BinderAdapter binderAdapter = mInnerBinderAdapter;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        BinderAdapter binderAdapter2 = mOuterBinderAdapter;
        if (binderAdapter2 != null) {
            binderAdapter2.unBind();
        }
    }

    public void bindCoreService() {
        String innerHmsPkg = this.mClientSettings.getInnerHmsPkg();
        String serviceAction = getServiceAction();
        HMSLog.i(TAG, "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        bindCoreInternal(innerHmsPkg, serviceAction);
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(int i2) {
        checkAvailabilityAndConnect(i2, false);
    }

    public void connectedInternal(IBinder iBinder) {
        this.mService = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.mService == null) {
            HMSLog.e(TAG, "mService is null, try to unBind.");
            tryUnBind();
            return;
        }
        onConnecting();
    }

    public final void connectionConnected() {
        setConnectStatus(3);
        RequestManager.getHandler().sendEmptyMessage(10011);
        ConnectionCallbacks connectionCallbacks = this.mConnectionCallbacks;
        if (connectionCallbacks == null || (connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        connectionCallbacks.onConnected();
    }

    public void disconnect() {
        int i2 = (this.mClientSettings.isUseInnerHms() ? INNER_CONN_STATUS : CONN_STATUS).get();
        HMSLog.i(TAG, "Enter disconnect, Connection Status: " + i2);
        if (i2 != 1) {
            if (i2 == 3) {
                unBindAdapter();
                setConnectStatus(1);
            } else if (i2 != 5) {
            } else {
                cancelConnDelayHandle();
                setConnectStatus(1);
            }
        }
    }

    public BinderAdapter getAdapter() {
        HMSLog.i(TAG, "getAdapter:isInner:" + this.mClientSettings.isUseInnerHms() + ", mInnerBinderAdapter:" + mInnerBinderAdapter + ", mOuterBinderAdapter:" + mOuterBinderAdapter);
        return this.mClientSettings.isUseInnerHms() ? mInnerBinderAdapter : mOuterBinderAdapter;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        return this.mClientSettings.getApiName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.mAppID;
    }

    public ClientSettings getClientSettings() {
        return this.mClientSettings;
    }

    public int getConnectionStatus() {
        return (this.mClientSettings.isUseInnerHms() ? INNER_CONN_STATUS : CONN_STATUS).get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.mClientSettings.getCpID();
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.mClientSettings.getClientPackageName();
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.mService;
    }

    public String getServiceAction() {
        HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(this.mContext);
        if (this.mClientSettings.isUseInnerHms()) {
            return hMSPackageManager.getInnerServiceAction();
        }
        return hMSPackageManager.getServiceAction();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        return this.mClientSettings.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        return !this.mClientSettings.isUseInnerHms() ? CONN_STATUS.get() != 3 : INNER_CONN_STATUS.get() != 3;
    }

    public boolean isConnecting() {
        return (this.mClientSettings.isUseInnerHms() ? INNER_CONN_STATUS : CONN_STATUS).get() == 5;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public void setConnectStatus(int i2) {
        if (this.mClientSettings.isUseInnerHms()) {
            INNER_CONN_STATUS.set(i2);
        } else {
            CONN_STATUS.set(i2);
        }
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        this.internalRequest = requestHandler;
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        this.mService = iAIDLInvoke;
    }

    public void connect(int i2, boolean z) {
        checkAvailabilityAndConnect(i2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailed(ConnectionResult connectionResult) {
        HMSLog.i(TAG, "notifyFailed result: " + connectionResult.getErrorCode());
        Message message = new Message();
        message.what = 10012;
        HuaweiApi.RequestHandler requestHandler = this.internalRequest;
        this.internalRequest = null;
        message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.mConnectionFailedListener;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(connectionResult);
    }
}
