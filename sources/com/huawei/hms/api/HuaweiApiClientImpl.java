package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public class HuaweiApiClientImpl extends HuaweiApiClient implements InnerApiClient, ServiceConnection {
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private final Context b;

    /* renamed from: c */
    private final String f3421c;

    /* renamed from: d */
    private String f3422d;

    /* renamed from: e */
    private String f3423e;

    /* renamed from: f */
    private volatile IAIDLInvoke f3424f;

    /* renamed from: g */
    private String f3425g;

    /* renamed from: h */
    private WeakReference<Activity> f3426h;

    /* renamed from: i */
    private WeakReference<Activity> f3427i;

    /* renamed from: l */
    private List<Scope> f3430l;

    /* renamed from: m */
    private List<PermissionInfo> f3431m;
    private Map<Api<?>, Api.ApiOptions> n;
    private SubAppInfo o;
    private final ReentrantLock s;
    private final Condition t;
    private ConnectionResult u;
    private HuaweiApiClient.ConnectionCallbacks v;
    private HuaweiApiClient.OnConnectionFailedListener w;
    private Handler x;
    private Handler y;
    private static final Object z = new Object();
    private static final Object A = new Object();
    private int a = -1;

    /* renamed from: j */
    private boolean f3428j = false;

    /* renamed from: k */
    private AtomicInteger f3429k = new AtomicInteger(1);
    private long p = 0;
    private int q = 0;
    private final Object r = new Object();

    /* loaded from: classes2.dex */
    public class a implements Handler.Callback {
        public a() {
            HuaweiApiClientImpl.this = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
            if (HuaweiApiClientImpl.this.f3429k.get() == 5) {
                HuaweiApiClientImpl.this.c(1);
                HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Handler.Callback {
        public b() {
            HuaweiApiClientImpl.this = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
            if (HuaweiApiClientImpl.this.f3429k.get() == 2) {
                HuaweiApiClientImpl.this.c(1);
                HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends IAIDLCallback.Stub {
        public final /* synthetic */ ResultCallback a;

        public c(HuaweiApiClientImpl huaweiApiClientImpl, ResultCallback resultCallback) {
            this.a = resultCallback;
        }

        @Override // com.huawei.hms.core.aidl.IAIDLCallback
        public void call(DataBuffer dataBuffer) {
            if (dataBuffer != null) {
                MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
                ResponseHeader responseHeader = new ResponseHeader();
                find.decode(dataBuffer.header, responseHeader);
                BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), dataBuffer.getBody());
                HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                this.a.onResult(bundleResult);
                return;
            }
            HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
            this.a.onResult(new BundleResult(-1, null));
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends PendingResultImpl<Status, IMessageEntity> {
        public d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ResultCallback<ResolveResult<ConnectResp>> {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ ResolveResult a;

            public a(ResolveResult resolveResult) {
                e.this = r1;
                this.a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.a(this.a);
            }
        }

        private e() {
            HuaweiApiClientImpl.this = r1;
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        public /* synthetic */ e(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements ResultCallback<ResolveResult<DisconnectResp>> {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ ResolveResult a;

            public a(ResolveResult resolveResult) {
                f.this = r1;
                this.a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.b(this.a);
            }
        }

        private f() {
            HuaweiApiClientImpl.this = r1;
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        public /* synthetic */ f(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class g implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private g() {
            HuaweiApiClientImpl.this = r1;
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            if (resolveResult == null || !resolveResult.getStatus().isSuccess() || (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) == null || value.getStatusCode() != 0) {
                return;
            }
            HMSLog.i("HuaweiApiClientImpl", "get notice has intent.");
            Activity validActivity = Util.getValidActivity((Activity) HuaweiApiClientImpl.this.f3426h.get(), HuaweiApiClientImpl.this.getTopActivity());
            if (validActivity != null) {
                HuaweiApiClientImpl.this.f3428j = true;
                validActivity.startActivity(noticeIntent);
                return;
            }
            HMSLog.e("HuaweiApiClientImpl", "showNotice no valid activity!");
        }

        public /* synthetic */ g(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    public HuaweiApiClientImpl(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.s = reentrantLock;
        this.t = reentrantLock.newCondition();
        this.x = null;
        this.y = null;
        this.b = context;
        String appId = Util.getAppId(context);
        this.f3421c = appId;
        this.f3422d = appId;
        this.f3423e = Util.getCpId(context);
    }

    private DisconnectInfo d() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.n;
        if (map != null) {
            for (Api<?> api : map.keySet()) {
                arrayList.add(api.getApiName());
            }
        }
        return new DisconnectInfo(this.f3430l, arrayList);
    }

    private int e() {
        int hmsVersion = Util.getHmsVersion(this.b);
        if (hmsVersion == 0 || hmsVersion < 20503000) {
            int f2 = f();
            if (g()) {
                if (f2 < 20503000) {
                    return 20503000;
                }
                return f2;
            } else if (f2 < 20600000) {
                return 20600000;
            } else {
                return f2;
            }
        }
        return hmsVersion;
    }

    private int f() {
        Integer num;
        int intValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i2 = 0;
        if (apiMap == null) {
            return 0;
        }
        for (Api<?> api : apiMap.keySet()) {
            String apiName = api.getApiName();
            if (!TextUtils.isEmpty(apiName) && (num = HuaweiApiAvailability.getApiMap().get(apiName)) != null && (intValue = num.intValue()) > i2) {
                i2 = intValue;
            }
        }
        return i2;
    }

    private boolean g() {
        Map<Api<?>, Api.ApiOptions> map = this.n;
        if (map != null) {
            for (Api<?> api : map.keySet()) {
                if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(api.getApiName())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void h() {
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.x = new Handler(Looper.getMainLooper(), new a());
        }
        this.x.sendEmptyMessageDelayed(2, 5000L);
    }

    private void i() {
        synchronized (A) {
            Handler handler = this.y;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.y = new Handler(Looper.getMainLooper(), new b());
            }
            boolean sendEmptyMessageDelayed = this.y.sendEmptyMessageDelayed(3, 3000L);
            HMSLog.d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + sendEmptyMessageDelayed);
        }
    }

    private void j() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, c()).setResultCallback(new e(this, null));
    }

    private void k() {
        ConnectService.disconnect(this, d()).setResultCallback(new f(this, null));
    }

    private void l() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, c()).setResultCallback(new e(this, null));
    }

    private void m() {
        if (this.f3428j) {
            HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.b) == 0) {
            ConnectService.getNotice(this, 0, "6.5.0.300").setResultCallback(new g(this, null));
        }
    }

    private void n() {
        Util.unBindServiceCatchException(this.b, this);
        this.f3424f = null;
    }

    public int asyncRequest(Bundle bundle, String str, int i2, ResultCallback<BundleResult> resultCallback) {
        HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback != null && str != null && bundle != null) {
            if (!innerIsConnected()) {
                HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
                return CommonCode.ErrorCode.CLIENT_API_INVALID;
            }
            DataBuffer dataBuffer = new DataBuffer(str, i2);
            MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
            dataBuffer.addBody(bundle);
            RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 60500300, getSessionId());
            requestHeader.setApiNameList(getApiNameList());
            dataBuffer.header = find.encode(requestHeader, new Bundle());
            try {
                getService().asyncCall(dataBuffer, new c(this, resultCallback));
                return 0;
            } catch (RemoteException e2) {
                HMSLog.e("HuaweiApiClientImpl", "remote exception:" + e2.getMessage());
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
        HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
        return CommonCode.ErrorCode.ARGUMENTS_INVALID;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        if (checkUpdatelistener == null) {
            HMSLog.e("HuaweiApiClientImpl", "listener is null!");
        } else {
            checkUpdatelistener.onResult(-1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60500300 ======");
        int i2 = this.f3429k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i2);
        if (i2 == 3 || i2 == 5 || i2 == 2 || i2 == 4) {
            return;
        }
        if (activity != null) {
            this.f3426h = new WeakReference<>(activity);
            this.f3427i = new WeakReference<>(activity);
        }
        this.f3422d = TextUtils.isEmpty(this.f3421c) ? Util.getAppId(this.b) : this.f3421c;
        int e2 = e();
        HMSLog.i("HuaweiApiClientImpl", "connect minVersion:" + e2);
        HuaweiApiAvailability.setServicesVersionCode(e2);
        int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.b, e2);
        HMSLog.i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
        this.q = HMSPackageManager.getInstance(this.b).getHmsMultiServiceVersion();
        if (isHuaweiMobileServicesAvailable == 0) {
            c(5);
            if (this.f3424f == null) {
                a();
                return;
            }
            c(2);
            j();
            i();
        } else if (this.w != null) {
            b(isHuaweiMobileServicesAvailable);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connectForeground() {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60500300 ======");
        int i2 = this.f3429k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i2);
        if (i2 == 3 || i2 == 5 || i2 == 2 || i2 == 4) {
            return;
        }
        this.f3422d = TextUtils.isEmpty(this.f3421c) ? Util.getAppId(this.b) : this.f3421c;
        l();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disableLifeCycleManagement(Activity activity) {
        if (this.a >= 0) {
            AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.a);
            return;
        }
        throw new IllegalStateException("disableLifeCycleManagement failed");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public PendingResult<Status> discardAndReconnect() {
        return new d(this, null, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disconnect() {
        int i2 = this.f3429k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i2);
        if (i2 == 2) {
            c(4);
        } else if (i2 == 3) {
            c(4);
            k();
        } else if (i2 != 5) {
        } else {
            a(2);
            c(4);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.n;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.n;
        if (map != null) {
            for (Api<?> api : map.keySet()) {
                arrayList.add(api.getApiName());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f3422d;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.u = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.u;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.b;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f3423e;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.b.getPackageName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<PermissionInfo> getPermissionInfos() {
        return this.f3431m;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<Scope> getScopes() {
        return this.f3430l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f3424f;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.f3425g;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public final SubAppInfo getSubAppInfo() {
        return this.o;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.f3427i;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.r) {
            return this.w == onConnectionFailedListener;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.r) {
            return this.v == connectionCallbacks;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.s.lock();
            try {
                connect((Activity) null);
                while (isConnecting()) {
                    this.t.await();
                }
                if (isConnected()) {
                    this.u = null;
                    return new ConnectionResult(0, (PendingIntent) null);
                }
                ConnectionResult connectionResult = this.u;
                return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            } finally {
                this.s.unlock();
            }
        }
        throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerApiClient
    public boolean innerIsConnected() {
        return this.f3429k.get() == 3 || this.f3429k.get() == 4;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient, com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.q == 0) {
            this.q = HMSPackageManager.getInstance(this.b).getHmsMultiServiceVersion();
        }
        if (this.q < 20504000) {
            long currentTimeMillis = System.currentTimeMillis() - this.p;
            if (currentTimeMillis > 0 && currentTimeMillis < 300000) {
                return innerIsConnected();
            }
            if (innerIsConnected()) {
                Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000L, TimeUnit.MILLISECONDS).getStatus();
                if (status.isSuccess()) {
                    this.p = System.currentTimeMillis();
                    return true;
                }
                int statusCode = status.getStatusCode();
                HMSLog.i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
                if (statusCode != 907135004) {
                    n();
                    c(1);
                    this.p = System.currentTimeMillis();
                    return false;
                }
                return false;
            }
            return false;
        }
        return innerIsConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean isConnecting() {
        int i2 = this.f3429k.get();
        return i2 == 2 || i2 == 5;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onPause(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "onPause");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.i("HuaweiApiClientImpl", "onResume");
            this.f3427i = new WeakReference<>(activity);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
        a(2);
        this.f3424f = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f3424f == null) {
            HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            n();
            c(1);
            if (this.w != null) {
                PendingIntent pendingIntent = null;
                WeakReference<Activity> weakReference = this.f3426h;
                if (weakReference != null && weakReference.get() != null) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f3426h.get(), 10);
                }
                ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
                this.w.onConnectionFailed(connectionResult);
                this.u = connectionResult;
            }
        } else if (this.f3429k.get() == 5) {
            c(2);
            j();
            i();
        } else if (this.f3429k.get() != 3) {
            n();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f3424f = null;
        c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.r) {
            if (this.w != onConnectionFailedListener) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.w = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.r) {
            if (this.v != connectionCallbacks) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.v = null;
            }
        }
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.n = map;
    }

    public void setAutoLifecycleClientId(int i2) {
        this.a = i2;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.v = connectionCallbacks;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z2) {
        this.f3428j = z2;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.f3431m = list;
    }

    public void setScopes(List<Scope> list) {
        this.f3430l = list;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.f3421c) ? Util.getAppId(this.b) : this.f3421c)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.o = new SubAppInfo(subAppInfo);
        return true;
    }

    public void c(int i2) {
        this.f3429k.set(i2);
        if (i2 == 1 || i2 == 3 || i2 == 2) {
            this.s.lock();
            try {
                this.t.signalAll();
            } finally {
                this.s.unlock();
            }
        }
    }

    private void b(int i2) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.f3426h;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f3426h.get(), i2);
            HMSLog.i("HuaweiApiClientImpl", "connect 2.0 fail: " + i2);
        }
        ConnectionResult connectionResult = new ConnectionResult(i2, pendingIntent);
        this.w.onConnectionFailed(connectionResult);
        this.u = connectionResult;
    }

    private void a() {
        Intent intent = new Intent(HMSPackageManager.getInstance(this.b).getServiceAction());
        HMSPackageManager.getInstance(this.b).refreshForMultiService();
        intent.setPackage(HMSPackageManager.getInstance(this.b).getHMSPackageNameForMultiService());
        synchronized (z) {
            if (this.b.bindService(intent, this, 1)) {
                h();
                return;
            }
            c(1);
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
            b();
        }
    }

    private ConnectInfo c() {
        String packageSignature = new PackageManagerHelper(this.b).getPackageSignature(this.b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.o;
        return new ConnectInfo(getApiNameList(), this.f3430l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    public void b() {
        n();
        if (this.w != null) {
            int i2 = UIUtil.isBackground(this.b) ? 7 : 6;
            PendingIntent pendingIntent = null;
            WeakReference<Activity> weakReference = this.f3426h;
            if (weakReference != null && weakReference.get() != null) {
                pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f3426h.get(), i2);
            }
            ConnectionResult connectionResult = new ConnectionResult(i2, pendingIntent);
            this.w.onConnectionFailed(connectionResult);
            this.u = connectionResult;
        }
    }

    private void c(ResolveResult<ConnectResp> resolveResult) {
        if (resolveResult.getValue() != null) {
            ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
        }
        c(3);
        this.u = null;
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
        if (this.f3426h != null) {
            m();
        }
        for (Map.Entry<Api<?>, Api.ApiOptions> entry : getApiMap().entrySet()) {
            if (entry.getKey().getmConnetctPostList() != null && !entry.getKey().getmConnetctPostList().isEmpty()) {
                HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                for (ConnectionPostProcessor connectionPostProcessor : entry.getKey().getmConnetctPostList()) {
                    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                    connectionPostProcessor.run(this, this.f3426h);
                }
            }
        }
    }

    public void b(ResolveResult<DisconnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        n();
        c(1);
    }

    private void a(int i2) {
        if (i2 == 2) {
            synchronized (z) {
                Handler handler = this.x;
                if (handler != null) {
                    handler.removeMessages(i2);
                    this.x = null;
                }
            }
        }
        if (i2 == 3) {
            synchronized (A) {
                Handler handler2 = this.y;
                if (handler2 != null) {
                    handler2.removeMessages(i2);
                    this.y = null;
                }
            }
        }
        synchronized (z) {
            Handler handler3 = this.x;
            if (handler3 != null) {
                handler3.removeMessages(2);
                this.x = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect(long j2, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.s.lock();
            try {
                connect((Activity) null);
                long nanos = timeUnit.toNanos(j2);
                while (isConnecting()) {
                    if (nanos <= 0) {
                        disconnect();
                        return new ConnectionResult(14, (PendingIntent) null);
                    }
                    nanos = this.t.awaitNanos(nanos);
                }
                if (isConnected()) {
                    this.u = null;
                    return new ConnectionResult(0, (PendingIntent) null);
                }
                ConnectionResult connectionResult = this.u;
                return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            } finally {
                this.s.unlock();
            }
        }
        throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(int i2) {
        connect((Activity) null);
    }

    public void a(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f3424f != null && this.f3429k.get() == 2) {
            a(3);
            ConnectResp value = resolveResult.getValue();
            if (value != null) {
                this.f3425g = value.sessionId;
            }
            SubAppInfo subAppInfo = this.o;
            PendingIntent pendingIntent = null;
            String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
            if (!TextUtils.isEmpty(subAppID)) {
                this.f3422d = subAppID;
            }
            int statusCode = resolveResult.getStatus().getStatusCode();
            HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
            if (Status.SUCCESS.equals(resolveResult.getStatus())) {
                c(resolveResult);
                return;
            } else if (resolveResult.getStatus() != null && resolveResult.getStatus().getStatusCode() == 1001) {
                n();
                c(1);
                HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
                if (connectionCallbacks != null) {
                    connectionCallbacks.onConnectionSuspended(3);
                    return;
                }
                return;
            } else {
                n();
                c(1);
                if (this.w != null) {
                    WeakReference<Activity> weakReference = this.f3426h;
                    if (weakReference != null && weakReference.get() != null) {
                        pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f3426h.get(), statusCode);
                    }
                    ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                    this.w.onConnectionFailed(connectionResult);
                    this.u = connectionResult;
                    return;
                }
                return;
            }
        }
        HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
    }
}
