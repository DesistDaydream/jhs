package com.jihuanshe;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.PopupWindow;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.didichuxing.doraemonkit.DoKit;
import com.eth.ext.FlowKt;
import com.jihuanshe.JApp;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.SplashActivity;
import com.jihuanshe.ui.page.login.LoginActivityCreator;
import com.jihuanshe.ui.widget.CopyPopupWindow;
import com.jihuanshe.utils.ImManager;
import com.jihuanshe.utils.KefuUtil;
import com.jihuanshe.utils.NotificationUtil;
import com.jihuanshe.wxapi.WXTool;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.mmkv.MMKV;
import com.tencent.qcloud.tim.tuiofflinepush.UploadPushTokenHelper;
import com.tencent.qcloud.tuikit.tuichat.OutInject;
import com.vector.AppEx;
import com.vector.config.AppBarConfig;
import com.vector.util.Res;
import e.l.h.j.b.e;
import e.l.h.k.b;
import e.l.m.c;
import e.l.n.c.i;
import e.l.r.d0;
import e.l.r.q;
import e.l.r.q0;
import e.l.r.r;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import i.b.o0;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class JApp extends AppEx {
    @d

    /* renamed from: g  reason: collision with root package name */
    public static final a f3735g = new a(null);
    @d

    /* renamed from: h  reason: collision with root package name */
    private static final String f3736h = "JApp";

    /* renamed from: i  reason: collision with root package name */
    private static final long f3737i = 1073741824;
    @d

    /* renamed from: j  reason: collision with root package name */
    public static final String f3738j = "image_cache";

    /* renamed from: k  reason: collision with root package name */
    private static boolean f3739k;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final b f3740c = new b();

    /* renamed from: d  reason: collision with root package name */
    private long f3741d;

    /* renamed from: e  reason: collision with root package name */
    private long f3742e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3743f;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b() {
            JApp.f3739k = false;
            e.f(this, Res.w(Res.a, R.string.common_token_expire, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            UserKV.f3913c.q();
            Intent newIntent = LoginActivityCreator.newIntent(e.t.a.b(), null);
            newIntent.setFlags(268468224);
            e.t.a.b().startActivity(newIntent);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends V2TIMAdvancedMsgListener {
        @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
        public void onRecvNewMessage(@k.e.a.e V2TIMMessage v2TIMMessage) {
            NotificationUtil.a.c(v2TIMMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(String str) {
        e.g.d.a.h(FlowKt.c(i.a.c((i) e.l.n.a.d(i.class, true, false, false, 60L, true), str, null, 2, null)), o0.b(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PopupWindow B(View view, View.OnClickListener onClickListener) {
        return new CopyPopupWindow(view.getContext(), new JApp$onCreateInMainProcess$2$1(onClickListener, view));
    }

    private final String v(int i2) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i2 + "/cmdline"));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                int length = readLine.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length) {
                    boolean z2 = f0.t(readLine.charAt(!z ? i3 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i3++;
                    } else {
                        z = true;
                    }
                }
                readLine = readLine.subSequence(i3, length + 1).toString();
            }
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return readLine;
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                return null;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    private final void w() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.jihuanshe.JApp$initBackgroundWatch$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@d LifecycleOwner lifecycleOwner, @d Lifecycle.Event event) {
                JApp.b bVar;
                boolean z;
                long j2;
                long j3;
                long j4;
                JApp.b bVar2;
                if (event == Lifecycle.Event.ON_STOP) {
                    JApp.this.f3743f = true;
                    JApp.this.f3741d = System.currentTimeMillis();
                    b.a.d("JApp", "on background");
                    V2TIMMessageManager messageManager = V2TIMManager.getMessageManager();
                    bVar2 = JApp.this.f3740c;
                    messageManager.addAdvancedMsgListener(bVar2);
                } else if (event == Lifecycle.Event.ON_START) {
                    JApp.this.f3743f = false;
                    JApp.this.f3742e = System.currentTimeMillis();
                    b.a.d("JApp", "on foreground");
                    V2TIMMessageManager messageManager2 = V2TIMManager.getMessageManager();
                    bVar = JApp.this.f3740c;
                    messageManager2.removeAdvancedMsgListener(bVar);
                    z = JApp.f3739k;
                    if (z) {
                        JApp.f3735g.b();
                    } else if (c.f14093c.u()) {
                        q qVar = q.a;
                        if (qVar.d() || qVar.c()) {
                            return;
                        }
                        j2 = JApp.this.f3741d;
                        if (j2 != 0) {
                            j3 = JApp.this.f3742e;
                            j4 = JApp.this.f3741d;
                            if (j3 - j4 < 180000) {
                                return;
                            }
                            JApp jApp = JApp.this;
                            Intent intent = new Intent(JApp.this, SplashActivity.class);
                            intent.putExtra("forceShowAd", true);
                            intent.addFlags(268435456);
                            t1 t1Var = t1.a;
                            jApp.startActivity(intent);
                        }
                    }
                }
            }
        });
    }

    @Override // com.vector.AppEx
    @d
    public e.t.i.a a() {
        return e.t.i.a.f14456j.a(JApp$configureApp$1.INSTANCE);
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(@k.e.a.e Context context) {
        super.attachBaseContext(context);
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            if (f0.g("com.platform.education", processName) || processName == null) {
                return;
            }
            WebView.setDataDirectorySuffix(processName);
        }
    }

    @Override // com.vector.AppEx
    @d
    public AppBarConfig b() {
        return AppBarConfig.s.a(new JApp$configureAppBar$1(this));
    }

    @Override // com.vector.AppEx
    @d
    public e.t.i.b c() {
        return e.t.i.b.f14464g.a(JApp$configureList$1.INSTANCE);
    }

    @Override // com.vector.AppEx
    public void h() {
        super.h();
        MMKV.initialize(this);
        q0 q0Var = q0.a;
        q0Var.d();
        if (c.f14093c.s()) {
            q0Var.a();
            x();
        }
    }

    @Override // com.vector.AppEx
    public void j() {
        super.j();
        q.a.b(this);
        e.l.q.c.p0.d.a.h(this);
        NotificationUtil.a.a();
        UploadPushTokenHelper.getInstance().setUploader(e.l.b.a);
        new DoKit.Builder(this).build();
        OutInject.getInstance().setRequest(e.l.a.a);
        e.g.d.b.a.a(new JApp$onCreateInMainProcess$3(this));
        WXTool.a.g();
        d0.a.c();
        e.l.m.b.f14084c.w();
        UserKV userKV = UserKV.f3913c;
        if (userKV.u().length() == 0) {
            User w = userKV.w();
            String token = w == null ? null : w.getToken();
            if (token == null) {
                token = "";
            }
            userKV.B(token);
        }
        if (userKV.t().length() == 0) {
            User w2 = userKV.w();
            String sig = w2 == null ? null : w2.getSig();
            userKV.A(sig != null ? sig : "");
        }
        if (userKV.w() != null) {
            ImManager.k(ImManager.a, false, 1, null);
            UserKV.z(userKV, null, 1, null);
        }
        w();
        if (c.f14093c.s()) {
            e.l.f.a.a.b();
            KefuUtil.a.c(this);
            r.a.a(this);
        }
        e.l.q.c.t0.b.a().c(new e.l.q.c.t0.a());
    }

    public final void x() {
        if (c.f14093c.s()) {
            String packageName = getPackageName();
            String v = v(Process.myPid());
            CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(this);
            userStrategy.setUploadProcess(v == null || f0.g(v, packageName));
            CrashReport.initCrashReport(this, "30c41ba4b9", false, userStrategy);
        }
    }
}
