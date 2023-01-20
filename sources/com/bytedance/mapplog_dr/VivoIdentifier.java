package com.bytedance.mapplog_dr;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import bykvm_19do.bykvm_19do.bykvm_19do.l0;
import bykvm_19do.bykvm_19do.bykvm_19do.s0;
import bykvm_19do.bykvm_19do.bykvm_19do.t0;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.heytap.mcssdk.constant.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class VivoIdentifier {
    private static final Map<String, String> MSA_VERSION_MAP;
    private String oaid;
    private String resultCode;
    private final AtomicBoolean mSecondCallGetDeviceIds = new AtomicBoolean();
    private volatile boolean mProloading = false;
    private final Object mLock = new Object();
    private final IIdentifierListener listener = new IdentifierListener();

    /* loaded from: classes.dex */
    public class IdentifierListener implements IIdentifierListener {
        private IdentifierListener() {
        }

        public void OnSupport(IdSupplier idSupplier) {
            onSupport(idSupplier);
        }

        public void OnSupport(boolean z, IdSupplier idSupplier) {
            try {
                t0.b("Oaid#", "OaidMiit#OnSupport isSupport=" + z + ", supplier=" + idSupplier);
                if (z && idSupplier != null) {
                    VivoIdentifier.this.setupOaid(idSupplier.getOAID());
                    synchronized (VivoIdentifier.this.mLock) {
                        VivoIdentifier.this.mProloading = false;
                        VivoIdentifier.this.mLock.notifyAll();
                    }
                }
            } catch (Throwable th) {
                l0.a("", th);
            }
        }

        public void onSupport(IdSupplier idSupplier) {
            try {
                t0.b("Oaid#", "OaidMiit#OnSupport supplier=" + idSupplier);
                if (idSupplier != null && idSupplier.isSupported()) {
                    OnSupport(true, idSupplier);
                }
            } catch (Throwable th) {
                l0.a("", th);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap(4);
        MSA_VERSION_MAP = hashMap;
        hashMap.put("1.0.26", "nllvm1623827671");
        hashMap.put("1.0.27", "nllvm1630571663641560568");
        hashMap.put("1.0.29", "nllvm1632808251147706677");
    }

    private int callFromReflect(Context context) {
        try {
            if (loadMSALibrary()) {
                MdidSdkHelper.InitCert(context, loadPemFromAssetFile(context, context.getPackageName() + ".cert.pem"));
            }
        } catch (Throwable th) {
            t0.b("Oaid#", "msa cert init exception", th);
        }
        try {
            return MdidSdkHelper.InitSdk(context, false, this.listener);
        } catch (Throwable th2) {
            t0.b("Oaid#", "msa sdk init exception", th2);
            return -1105;
        }
    }

    private static void loadLibrary(ClassLoader classLoader, String str) {
        Method accessibleMethod = MethodUtils.getAccessibleMethod(Runtime.class, "loadLibrary0", ClassLoader.class, String.class);
        if (accessibleMethod == null) {
            throw new IllegalAccessException("can not access loadLibrary0 method");
        }
        accessibleMethod.invoke(Runtime.getRuntime(), classLoader, str);
    }

    private boolean loadMSALibrary() {
        String a = s0.a();
        ClassLoader classLoader = MdidSdkHelper.class.getClassLoader();
        if (a != null) {
            Map<String, String> map = MSA_VERSION_MAP;
            if (map.containsKey(a)) {
                String str = map.get(a);
                try {
                    loadLibrary(classLoader, str);
                    return true;
                } catch (Throwable th) {
                    l0.c("加载信通院so库异常，msaVersion is " + a + "，lib name is " + str, th);
                }
            }
        }
        for (String str2 : MSA_VERSION_MAP.keySet()) {
            try {
                loadLibrary(classLoader, MSA_VERSION_MAP.get(str2));
                return true;
            } catch (Throwable th2) {
                l0.c("如果信通院SDK不是" + str2 + "，请忽略这个错误: ", th2);
            }
        }
        return false;
    }

    private static String loadPemFromAssetFile(Context context, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
                sb.append('\n');
            }
        } catch (IOException unused) {
            Log.e("Oaid#", "loadPemFromAssetFile failed");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupOaid(String str) {
        synchronized (this) {
            t0.b("Oaid#", "OaidMiit#setupOaid current oaid=" + str + ", global oaid=" + this.oaid);
            if (!TextUtils.isEmpty(str) && !str.equals(this.oaid)) {
                this.oaid = str;
            }
        }
    }

    public a1.a getOaid(Context context) {
        synchronized (this.mLock) {
            if (this.mProloading) {
                this.mLock.wait(a.q);
            }
        }
        a1.a aVar = new a1.a();
        aVar.a = this.oaid;
        return aVar;
    }

    public void preloadOaid(Context context) {
        String str;
        synchronized (this.mLock) {
            this.mProloading = true;
            int callFromReflect = callFromReflect(context);
            if (callFromReflect == 1008614) {
                t0.b("Oaid#", "OaidMiit#getDeviceIds 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                if (this.mSecondCallGetDeviceIds.compareAndSet(false, true)) {
                    preloadOaid(context);
                } else {
                    str = "结果会在回调中返回";
                    this.resultCode = str;
                }
            } else {
                if (callFromReflect != 0 && callFromReflect != 1008610) {
                    this.resultCode = "未知 resultCode=" + callFromReflect;
                    t0.b("Oaid#", "OaidMiit#getDeviceIds 未知 resultCode=" + callFromReflect);
                }
                t0.b("Oaid#", "OaidMiit#getDeviceIds 正确");
                str = "正确";
                this.resultCode = str;
            }
        }
    }
}
