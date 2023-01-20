package com.didichuxing.doraemonkit;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.didichuxing.doraemonkit.kit.AbstractKit;
import com.didichuxing.doraemonkit.kit.core.AbsDokitView;
import com.didichuxing.doraemonkit.kit.core.BaseFragment;
import com.didichuxing.doraemonkit.kit.core.DoKitViewLaunchMode;
import com.didichuxing.doraemonkit.kit.core.McClientProcessor;
import com.didichuxing.doraemonkit.kit.network.okhttp.interceptor.DokitExtInterceptor;
import com.didichuxing.doraemonkit.kit.webdoor.WebDoorManager;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import h.k2.h;
import h.k2.k;
import h.k2.v.u;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0002\u0005\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/didichuxing/doraemonkit/DoKit;", "", "<init>", "()V", "Companion", "Builder", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DoKit {
    public static final Companion Companion = new Companion(null);
    @d
    public static final String TAG = "DoKit";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b6\u00107J\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J=\u0010\n\u001a\u00020\u00002.\u0010\t\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\n\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0016J!\u0010\u001b\u001a\u00020\u00002\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b!\u0010 J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020&¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\r\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/R>\u0010\t\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00100R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u00101R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/didichuxing/doraemonkit/DoKit$Builder;", "", "", "productId", "(Ljava/lang/String;)Lcom/didichuxing/doraemonkit/DoKit$Builder;", "Ljava/util/LinkedHashMap;", "", "Lcom/didichuxing/doraemonkit/kit/AbstractKit;", "Lkotlin/collections/LinkedHashMap;", "mapKits", "customKits", "(Ljava/util/LinkedHashMap;)Lcom/didichuxing/doraemonkit/DoKit$Builder;", "listKits", "(Ljava/util/List;)Lcom/didichuxing/doraemonkit/DoKit$Builder;", "Lcom/didichuxing/doraemonkit/kit/webdoor/WebDoorManager$WebDoorCallback;", "callback", "webDoorCallback", "(Lcom/didichuxing/doraemonkit/kit/webdoor/WebDoorManager$WebDoorCallback;)Lcom/didichuxing/doraemonkit/DoKit$Builder;", "disableUpload", "()Lcom/didichuxing/doraemonkit/DoKit$Builder;", "", "debug", "(Z)Lcom/didichuxing/doraemonkit/DoKit$Builder;", "alwaysShow", "alwaysShowMainIcon", "", "map", "databasePass", "(Ljava/util/Map;)Lcom/didichuxing/doraemonkit/DoKit$Builder;", "", "port", "fileManagerHttpPort", "(I)Lcom/didichuxing/doraemonkit/DoKit$Builder;", "mcWSPort", "Lcom/didichuxing/doraemonkit/kit/core/McClientProcessor;", "interceptor", "mcClientProcess", "(Lcom/didichuxing/doraemonkit/kit/core/McClientProcessor;)Lcom/didichuxing/doraemonkit/DoKit$Builder;", "Lcom/didichuxing/doraemonkit/DoKitCallBack;", "callBack", "(Lcom/didichuxing/doraemonkit/DoKitCallBack;)Lcom/didichuxing/doraemonkit/DoKit$Builder;", "Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor$DokitExtInterceptorProxy;", "extInterceptorProxy", "netExtInterceptor", "(Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor$DokitExtInterceptorProxy;)Lcom/didichuxing/doraemonkit/DoKit$Builder;", "Lh/t1;", "build", "()V", "Ljava/util/LinkedHashMap;", "Ljava/lang/String;", "Ljava/util/List;", "Landroid/app/Application;", PushConstants.EXTRA_APPLICATION_PENDING_INTENT, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Builder {
        private final Application app;
        private String productId = "";
        private LinkedHashMap<String, List<AbstractKit>> mapKits = new LinkedHashMap<>();
        private List<? extends AbstractKit> listKits = new ArrayList();

        public Builder(@d Application application) {
            this.app = application;
        }

        @d
        public final Builder alwaysShowMainIcon(boolean z) {
            return this;
        }

        public final void build() {
        }

        @d
        public final Builder callBack(@d DoKitCallBack doKitCallBack) {
            return this;
        }

        @d
        public final Builder customKits(@d LinkedHashMap<String, List<AbstractKit>> linkedHashMap) {
            return this;
        }

        @d
        public final Builder customKits(@d List<? extends AbstractKit> list) {
            return this;
        }

        @d
        public final Builder databasePass(@d Map<String, String> map) {
            return this;
        }

        @d
        public final Builder debug(boolean z) {
            return this;
        }

        @d
        public final Builder disableUpload() {
            return this;
        }

        @d
        public final Builder fileManagerHttpPort(int i2) {
            return this;
        }

        @d
        public final Builder mcClientProcess(@d McClientProcessor mcClientProcessor) {
            return this;
        }

        @d
        public final Builder mcWSPort(int i2) {
            return this;
        }

        @d
        public final Builder netExtInterceptor(@d DokitExtInterceptor.DokitExtInterceptorProxy dokitExtInterceptorProxy) {
            return this;
        }

        @d
        public final Builder productId(@d String str) {
            return this;
        }

        @d
        public final Builder webDoorCallback(@d WebDoorManager.WebDoorCallback webDoorCallback) {
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b4\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0004J5\u0010\u000f\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u000f\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u00112\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0015J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0013\u0010\u0017JA\u0010\u001d\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJA\u0010\u001d\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00112\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001fJ5\u0010$\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010 *\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!2\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b$\u0010%J5\u0010$\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010 *\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!2\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011H\u0007¢\u0006\u0004\b$\u0010&J;\u0010-\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u00010+H\u0007¢\u0006\u0004\b-\u0010.R\u001c\u0010/\u001a\u00020\u001b8F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0004\u001a\u0004\b/\u00100R\u0016\u00102\u001a\u00020'8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/didichuxing/doraemonkit/DoKit$Companion;", "", "Lh/t1;", TTLogUtil.TAG_EVENT_SHOW, "()V", "showToolPanel", "hideToolPanel", "hide", "Ljava/lang/Class;", "Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;", "targetClass", "Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;", "mode", "Landroid/os/Bundle;", TTLiveConstants.BUNDLE_KEY, "launchFloating", "(Ljava/lang/Class;Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;Landroid/os/Bundle;)V", "Lh/p2/d;", "(Lh/p2/d;Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;Landroid/os/Bundle;)V", "removeFloating", "(Ljava/lang/Class;)V", "(Lh/p2/d;)V", "dokitView", "(Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;)V", "Lcom/didichuxing/doraemonkit/kit/core/BaseFragment;", "Landroid/content/Context;", "context", "", "isSystemFragment", "launchFullScreen", "(Ljava/lang/Class;Landroid/content/Context;Landroid/os/Bundle;Z)V", "(Lh/p2/d;Landroid/content/Context;Landroid/os/Bundle;Z)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/app/Activity;", "activity", "clazz", "getDoKitView", "(Landroid/app/Activity;Ljava/lang/Class;)Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;", "(Landroid/app/Activity;Lh/p2/d;)Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;", "", "eventType", "Landroid/view/View;", "view", "", RemoteMessageConst.MessageBody.PARAM, "sendCustomEvent", "(Ljava/lang/String;Landroid/view/View;Ljava/util/Map;)V", "isMainIconShow", "()Z", "isMainIconShow$annotations", "TAG", "Ljava/lang/String;", "<init>", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        @k
        public static /* synthetic */ void isMainIconShow$annotations() {
        }

        public static /* synthetic */ void launchFloating$default(Companion companion, Class cls, DoKitViewLaunchMode doKitViewLaunchMode, Bundle bundle, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                doKitViewLaunchMode = DoKitViewLaunchMode.SINGLE_INSTANCE;
            }
            if ((i2 & 4) != 0) {
                bundle = null;
            }
            companion.launchFloating(cls, doKitViewLaunchMode, bundle);
        }

        public static /* synthetic */ void launchFullScreen$default(Companion companion, Class cls, Context context, Bundle bundle, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                context = null;
            }
            if ((i2 & 4) != 0) {
                bundle = null;
            }
            if ((i2 & 8) != 0) {
                z = false;
            }
            companion.launchFullScreen(cls, context, bundle, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void sendCustomEvent$default(Companion companion, String str, View view, Map map, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                view = null;
            }
            if ((i2 & 4) != 0) {
                map = null;
            }
            companion.sendCustomEvent(str, view, map);
        }

        @k
        @e
        public final <T extends AbsDokitView> T getDoKitView(@e Activity activity, @d h.p2.d<? extends T> dVar) {
            return null;
        }

        @k
        @e
        public final <T extends AbsDokitView> T getDoKitView(@e Activity activity, @d Class<? extends T> cls) {
            return null;
        }

        @k
        public final void hide() {
        }

        @k
        public final void hideToolPanel() {
        }

        public final boolean isMainIconShow() {
            return false;
        }

        @h
        @k
        public final void launchFloating(@d h.p2.d<? extends AbsDokitView> dVar) {
            launchFloating$default(this, dVar, (DoKitViewLaunchMode) null, (Bundle) null, 6, (Object) null);
        }

        @h
        @k
        public final void launchFloating(@d h.p2.d<? extends AbsDokitView> dVar, @d DoKitViewLaunchMode doKitViewLaunchMode) {
            launchFloating$default(this, dVar, doKitViewLaunchMode, (Bundle) null, 4, (Object) null);
        }

        @h
        @k
        public final void launchFloating(@d h.p2.d<? extends AbsDokitView> dVar, @d DoKitViewLaunchMode doKitViewLaunchMode, @e Bundle bundle) {
        }

        @h
        @k
        public final void launchFloating(@d Class<? extends AbsDokitView> cls) {
            launchFloating$default(this, cls, (DoKitViewLaunchMode) null, (Bundle) null, 6, (Object) null);
        }

        @h
        @k
        public final void launchFloating(@d Class<? extends AbsDokitView> cls, @d DoKitViewLaunchMode doKitViewLaunchMode) {
            launchFloating$default(this, cls, doKitViewLaunchMode, (Bundle) null, 4, (Object) null);
        }

        @h
        @k
        public final void launchFloating(@d Class<? extends AbsDokitView> cls, @d DoKitViewLaunchMode doKitViewLaunchMode, @e Bundle bundle) {
        }

        @h
        @k
        public final void launchFullScreen(@d h.p2.d<? extends BaseFragment> dVar) {
            launchFullScreen$default(this, (h.p2.d) dVar, (Context) null, (Bundle) null, false, 14, (Object) null);
        }

        @h
        @k
        public final void launchFullScreen(@d h.p2.d<? extends BaseFragment> dVar, @e Context context) {
            launchFullScreen$default(this, (h.p2.d) dVar, context, (Bundle) null, false, 12, (Object) null);
        }

        @h
        @k
        public final void launchFullScreen(@d h.p2.d<? extends BaseFragment> dVar, @e Context context, @e Bundle bundle) {
            launchFullScreen$default(this, (h.p2.d) dVar, context, bundle, false, 8, (Object) null);
        }

        @h
        @k
        public final void launchFullScreen(@d h.p2.d<? extends BaseFragment> dVar, @e Context context, @e Bundle bundle, boolean z) {
        }

        @h
        @k
        public final void launchFullScreen(@d Class<? extends BaseFragment> cls) {
            launchFullScreen$default(this, (Class) cls, (Context) null, (Bundle) null, false, 14, (Object) null);
        }

        @h
        @k
        public final void launchFullScreen(@d Class<? extends BaseFragment> cls, @e Context context) {
            launchFullScreen$default(this, (Class) cls, context, (Bundle) null, false, 12, (Object) null);
        }

        @h
        @k
        public final void launchFullScreen(@d Class<? extends BaseFragment> cls, @e Context context, @e Bundle bundle) {
            launchFullScreen$default(this, (Class) cls, context, bundle, false, 8, (Object) null);
        }

        @h
        @k
        public final void launchFullScreen(@d Class<? extends BaseFragment> cls, @e Context context, @e Bundle bundle, boolean z) {
        }

        @k
        public final void removeFloating(@d AbsDokitView absDokitView) {
        }

        @k
        public final void removeFloating(@d h.p2.d<? extends AbsDokitView> dVar) {
        }

        @k
        public final void removeFloating(@d Class<? extends AbsDokitView> cls) {
        }

        @k
        public final void sendCustomEvent(@d String str, @e View view, @e Map<String, String> map) {
        }

        @k
        public final void show() {
        }

        @k
        public final void showToolPanel() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        public static /* synthetic */ void launchFullScreen$default(Companion companion, h.p2.d dVar, Context context, Bundle bundle, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                context = null;
            }
            if ((i2 & 4) != 0) {
                bundle = null;
            }
            if ((i2 & 8) != 0) {
                z = false;
            }
            companion.launchFullScreen(dVar, context, bundle, z);
        }

        public static /* synthetic */ void launchFloating$default(Companion companion, h.p2.d dVar, DoKitViewLaunchMode doKitViewLaunchMode, Bundle bundle, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                doKitViewLaunchMode = DoKitViewLaunchMode.SINGLE_INSTANCE;
            }
            if ((i2 & 4) != 0) {
                bundle = null;
            }
            companion.launchFloating(dVar, doKitViewLaunchMode, bundle);
        }
    }

    private DoKit() {
    }

    @k
    @e
    public static final <T extends AbsDokitView> T getDoKitView(@e Activity activity, @d h.p2.d<? extends T> dVar) {
        return (T) Companion.getDoKitView(activity, dVar);
    }

    @k
    @e
    public static final <T extends AbsDokitView> T getDoKitView(@e Activity activity, @d Class<? extends T> cls) {
        return (T) Companion.getDoKitView(activity, cls);
    }

    @k
    public static final void hide() {
        Companion.hide();
    }

    @k
    public static final void hideToolPanel() {
        Companion.hideToolPanel();
    }

    public static final boolean isMainIconShow() {
        return Companion.isMainIconShow();
    }

    @h
    @k
    public static final void launchFloating(@d h.p2.d<? extends AbsDokitView> dVar) {
        Companion.launchFloating$default(Companion, dVar, (DoKitViewLaunchMode) null, (Bundle) null, 6, (Object) null);
    }

    @h
    @k
    public static final void launchFloating(@d h.p2.d<? extends AbsDokitView> dVar, @d DoKitViewLaunchMode doKitViewLaunchMode) {
        Companion.launchFloating$default(Companion, dVar, doKitViewLaunchMode, (Bundle) null, 4, (Object) null);
    }

    @h
    @k
    public static final void launchFloating(@d h.p2.d<? extends AbsDokitView> dVar, @d DoKitViewLaunchMode doKitViewLaunchMode, @e Bundle bundle) {
        Companion.launchFloating(dVar, doKitViewLaunchMode, bundle);
    }

    @h
    @k
    public static final void launchFloating(@d Class<? extends AbsDokitView> cls) {
        Companion.launchFloating$default(Companion, cls, (DoKitViewLaunchMode) null, (Bundle) null, 6, (Object) null);
    }

    @h
    @k
    public static final void launchFloating(@d Class<? extends AbsDokitView> cls, @d DoKitViewLaunchMode doKitViewLaunchMode) {
        Companion.launchFloating$default(Companion, cls, doKitViewLaunchMode, (Bundle) null, 4, (Object) null);
    }

    @h
    @k
    public static final void launchFloating(@d Class<? extends AbsDokitView> cls, @d DoKitViewLaunchMode doKitViewLaunchMode, @e Bundle bundle) {
        Companion.launchFloating(cls, doKitViewLaunchMode, bundle);
    }

    @h
    @k
    public static final void launchFullScreen(@d h.p2.d<? extends BaseFragment> dVar) {
        Companion.launchFullScreen$default(Companion, (h.p2.d) dVar, (Context) null, (Bundle) null, false, 14, (Object) null);
    }

    @h
    @k
    public static final void launchFullScreen(@d h.p2.d<? extends BaseFragment> dVar, @e Context context) {
        Companion.launchFullScreen$default(Companion, (h.p2.d) dVar, context, (Bundle) null, false, 12, (Object) null);
    }

    @h
    @k
    public static final void launchFullScreen(@d h.p2.d<? extends BaseFragment> dVar, @e Context context, @e Bundle bundle) {
        Companion.launchFullScreen$default(Companion, (h.p2.d) dVar, context, bundle, false, 8, (Object) null);
    }

    @h
    @k
    public static final void launchFullScreen(@d h.p2.d<? extends BaseFragment> dVar, @e Context context, @e Bundle bundle, boolean z) {
        Companion.launchFullScreen(dVar, context, bundle, z);
    }

    @h
    @k
    public static final void launchFullScreen(@d Class<? extends BaseFragment> cls) {
        Companion.launchFullScreen$default(Companion, (Class) cls, (Context) null, (Bundle) null, false, 14, (Object) null);
    }

    @h
    @k
    public static final void launchFullScreen(@d Class<? extends BaseFragment> cls, @e Context context) {
        Companion.launchFullScreen$default(Companion, (Class) cls, context, (Bundle) null, false, 12, (Object) null);
    }

    @h
    @k
    public static final void launchFullScreen(@d Class<? extends BaseFragment> cls, @e Context context, @e Bundle bundle) {
        Companion.launchFullScreen$default(Companion, (Class) cls, context, bundle, false, 8, (Object) null);
    }

    @h
    @k
    public static final void launchFullScreen(@d Class<? extends BaseFragment> cls, @e Context context, @e Bundle bundle, boolean z) {
        Companion.launchFullScreen(cls, context, bundle, z);
    }

    @k
    public static final void removeFloating(@d AbsDokitView absDokitView) {
        Companion.removeFloating(absDokitView);
    }

    @k
    public static final void removeFloating(@d h.p2.d<? extends AbsDokitView> dVar) {
        Companion.removeFloating(dVar);
    }

    @k
    public static final void removeFloating(@d Class<? extends AbsDokitView> cls) {
        Companion.removeFloating(cls);
    }

    @k
    public static final void sendCustomEvent(@d String str, @e View view, @e Map<String, String> map) {
        Companion.sendCustomEvent(str, view, map);
    }

    @k
    public static final void show() {
        Companion.show();
    }

    @k
    public static final void showToolPanel() {
        Companion.showToolPanel();
    }
}
