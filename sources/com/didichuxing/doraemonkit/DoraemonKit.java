package com.didichuxing.doraemonkit;

import android.app.Application;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.didichuxing.doraemonkit.kit.AbstractKit;
import com.didichuxing.doraemonkit.kit.core.McClientProcessor;
import com.didichuxing.doraemonkit.kit.network.okhttp.interceptor.DokitExtInterceptor;
import com.didichuxing.doraemonkit.kit.webdoor.WebDoorManager;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import h.k2.k;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b:\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\tJG\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022.\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\rH\u0007¢\u0006\u0004\b\u0005\u0010\u000fJO\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022.\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\r2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\u0010J%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¢\u0006\u0004\b\u0005\u0010\u0012J-\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001eH\u0007¢\u0006\u0004\b#\u0010!J#\u0010&\u001a\u00020\u00042\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070$H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u000204H\u0007¢\u0006\u0004\b5\u00106R\u001c\u00107\u001a\u00020\u001e8F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0019\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/didichuxing/doraemonkit/DoraemonKit;", "", "Landroid/app/Application;", PushConstants.EXTRA_APPLICATION_PENDING_INTENT, "Lh/t1;", "install", "(Landroid/app/Application;)V", "", "productId", "(Landroid/app/Application;Ljava/lang/String;)V", "Ljava/util/LinkedHashMap;", "", "Lcom/didichuxing/doraemonkit/kit/AbstractKit;", "Lkotlin/collections/LinkedHashMap;", "mapKits", "(Landroid/app/Application;Ljava/util/LinkedHashMap;)V", "(Landroid/app/Application;Ljava/util/LinkedHashMap;Ljava/lang/String;)V", "listKits", "(Landroid/app/Application;Ljava/util/List;)V", "(Landroid/app/Application;Ljava/util/List;Ljava/lang/String;)V", "Lcom/didichuxing/doraemonkit/kit/webdoor/WebDoorManager$WebDoorCallback;", "callback", "setWebDoorCallback", "(Lcom/didichuxing/doraemonkit/kit/webdoor/WebDoorManager$WebDoorCallback;)V", TTLogUtil.TAG_EVENT_SHOW, "()V", "showToolPanel", "hideToolPanel", "hide", "disableUpload", "", "debug", "setDebug", "(Z)V", "alwaysShow", "setAlwaysShowMainIcon", "", "map", "setDatabasePass", "(Ljava/util/Map;)V", "", "port", "setFileManagerHttpPort", "(I)V", "Lcom/didichuxing/doraemonkit/kit/core/McClientProcessor;", "interceptor", "setMCIntercept", "(Lcom/didichuxing/doraemonkit/kit/core/McClientProcessor;)V", "Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor$DokitExtInterceptorProxy;", "extInterceptorProxy", "setNetExtInterceptor", "(Lcom/didichuxing/doraemonkit/kit/network/okhttp/interceptor/DokitExtInterceptor$DokitExtInterceptorProxy;)V", "Lcom/didichuxing/doraemonkit/DoKitCallBack;", "setCallBack", "(Lcom/didichuxing/doraemonkit/DoKitCallBack;)V", "isShow", "()Z", "isShow$annotations", "<init>", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DoraemonKit {
    public static final DoraemonKit INSTANCE = new DoraemonKit();

    private DoraemonKit() {
    }

    @k
    public static final void disableUpload() {
    }

    @k
    public static final void hide() {
    }

    @k
    public static final void hideToolPanel() {
    }

    @k
    public static final void install(@d Application application) {
    }

    @k
    public static final void install(@d Application application, @d String str) {
    }

    @k
    public static final void install(@d Application application, @d LinkedHashMap<String, List<AbstractKit>> linkedHashMap) {
    }

    @k
    public static final void install(@d Application application, @d LinkedHashMap<String, List<AbstractKit>> linkedHashMap, @d String str) {
    }

    @k
    public static final void install(@d Application application, @d List<AbstractKit> list) {
    }

    @k
    public static final void install(@d Application application, @d List<AbstractKit> list, @d String str) {
    }

    public static final boolean isShow() {
        return false;
    }

    @k
    public static /* synthetic */ void isShow$annotations() {
    }

    @k
    public static final void setAlwaysShowMainIcon(boolean z) {
    }

    @k
    public static final void setCallBack(@d DoKitCallBack doKitCallBack) {
    }

    @k
    public static final void setDatabasePass(@d Map<String, String> map) {
    }

    @k
    public static final void setDebug(boolean z) {
    }

    @k
    public static final void setFileManagerHttpPort(int i2) {
    }

    @k
    public static final void setMCIntercept(@d McClientProcessor mcClientProcessor) {
    }

    @k
    public static final void setNetExtInterceptor(@d DokitExtInterceptor.DokitExtInterceptorProxy dokitExtInterceptorProxy) {
    }

    @k
    public static final void setWebDoorCallback(@e WebDoorManager.WebDoorCallback webDoorCallback) {
    }

    @k
    public static final void show() {
    }

    @k
    public static final void showToolPanel() {
    }
}
