package com.vector.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.annotation.StringRes;
import androidx.core.content.FileProvider;
import com.baidu.mobads.sdk.internal.ak;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import e.t.l.x;
import e.t.u.r;
import h.k2.v.f0;
import h.k2.v.u;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001:\u0011!\"#$%&'()*+,-./01B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 ¨\u00062"}, d2 = {"Lcom/vector/util/IntentAction;", "", "()V", k.b.a.a.n.n.c.b, "Lcom/vector/util/IntentAction$AnyAction;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "anyFile", "Lcom/vector/util/IntentAction$AnyFileAction;", PushConstants.EXTRA_APPLICATION_PENDING_INTENT, "Lcom/vector/util/IntentAction$AppAction;", "appSetup", "Lcom/vector/util/IntentAction$AppSetupAction;", "browser", "Lcom/vector/util/IntentAction$BrowserAction;", "excel", "Lcom/vector/util/IntentAction$ExcelAction;", "mall", "Lcom/vector/util/IntentAction$MailAction;", "map", "Lcom/vector/util/IntentAction$MapAction;", BaseConstants.SCHEME_MARKET, "Lcom/vector/util/IntentAction$MarketAction;", "phoneCall", "Lcom/vector/util/IntentAction$PhoneCallAction;", "photo", "Lcom/vector/util/IntentAction$PhotoAction;", "ppt", "Lcom/vector/util/IntentAction$PptAction;", "systemShare", "Lcom/vector/util/IntentAction$SystemShareAction;", "word", "Lcom/vector/util/IntentAction$WordAction;", "AnyAction", "AnyFileAction", "AppAction", "AppSetupAction", "BaseAction", "BrowserAction", "ExcelAction", "FileAction", "MailAction", "MapAction", "MarketAction", "PhoneCallAction", "PhotoAction", "PhotoSource", "PptAction", "SystemShareAction", "WordAction", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IntentAction {
    @k.e.a.d
    public static final IntentAction a = new IntentAction();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/vector/util/IntentAction$PhotoSource;", "", "(Ljava/lang/String;I)V", "UN_KNOWN", "CAMERA", "ALBUM", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum PhotoSource {
        UN_KNOWN,
        CAMERA,
        ALBUM
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/vector/util/IntentAction$AnyAction;", "Lcom/vector/util/IntentAction$BaseAction;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "getIntent", "()Landroid/content/Intent;", "launch", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends e<a> {
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        private final Intent f7870d;

        public a(@k.e.a.d Intent intent) {
            this.f7870d = intent;
        }

        @Override // com.vector.util.IntentAction.e
        @k.e.a.d
        public Intent f() {
            return this.f7870d;
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            j(f());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/vector/util/IntentAction$AnyFileAction;", "Lcom/vector/util/IntentAction$BaseAction;", "()V", "category", "", "code", "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "type", "getType", "()Ljava/lang/String;", "c", "launch", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends e<b> {

        /* renamed from: d  reason: collision with root package name */
        private int f7871d = -1;
        @k.e.a.d

        /* renamed from: e  reason: collision with root package name */
        private String f7872e = "android.intent.category.OPENABLE";

        private final String getType() {
            return "*/*";
        }

        @Override // com.vector.util.IntentAction.e
        @k.e.a.e
        public Intent f() {
            return new Intent("android.intent.action.GET_CONTENT").addCategory(this.f7872e).setType(getType());
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            Intent f2 = f();
            if (f2 == null) {
                return;
            }
            j(f2);
        }

        @k.e.a.d
        public final b k(@k.e.a.d String str) {
            this.f7872e = str;
            return g();
        }

        @k.e.a.d
        public final b l(int i2) {
            this.f7871d = i2;
            return g();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vector/util/IntentAction$AppAction;", "Lcom/vector/util/IntentAction$BaseAction;", "()V", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "url", "", "launch", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c extends e<c> {
        @k.e.a.e

        /* renamed from: d  reason: collision with root package name */
        private String f7873d;

        @Override // com.vector.util.IntentAction.e
        @k.e.a.d
        public Intent f() {
            return new Intent("android.intent.action.VIEW", Uri.parse(this.f7873d));
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            if (this.f7873d == null) {
                x.f("url can not be null", 0, 2, null);
            } else {
                j(f());
            }
        }

        @k.e.a.d
        public final c k(@k.e.a.d String str) {
            this.f7873d = str;
            return g();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/vector/util/IntentAction$AppSetupAction;", "Lcom/vector/util/IntentAction$BaseAction;", "()V", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "launch", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class d extends e<d> {
        @Override // com.vector.util.IntentAction.e
        @k.e.a.d
        public Intent f() {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(f0.C("package:", e.t.a.b().getPackageName())));
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            j(f());
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0004J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0002J\u0013\u0010\n\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0002\u0010\u0015J\b\u0010\u001a\u001a\u00020\u0017H&J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0004R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/vector/util/IntentAction$BaseAction;", "ACTION", "", "()V", "<set-?>", "", "alert", "getAlert", "()Ljava/lang/String;", "chooserTitle", "createChooser", "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "self", "getSelf$annotations", "getSelf", "()Lcom/vector/util/IntentAction$BaseAction;", am.av, "(Ljava/lang/String;)Lcom/vector/util/IntentAction$BaseAction;", "autoLaunch", "", "chooserLaunch", "title", "launch", "normalLaunch", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class e<ACTION extends e<ACTION>> {
        private boolean a;
        @k.e.a.e
        private String b;
        @k.e.a.e

        /* renamed from: c  reason: collision with root package name */
        private String f7874c;

        private final void c(Intent intent) {
            r.startActivity(Intent.createChooser(intent, this.b), new Bundle[0]);
        }

        public static /* synthetic */ void h() {
        }

        @k.e.a.d
        public final ACTION a(@k.e.a.d String str) {
            this.f7874c = str;
            return g();
        }

        public final void b(@k.e.a.d Intent intent) {
            if (this.a) {
                c(intent);
            } else {
                j(intent);
            }
        }

        @k.e.a.d
        public final ACTION d(@k.e.a.d String str) {
            this.a = true;
            this.b = str;
            return g();
        }

        @k.e.a.e
        public final String e() {
            return this.f7874c;
        }

        @k.e.a.e
        public abstract Intent f();

        @k.e.a.d
        public final ACTION g() {
            return this;
        }

        public abstract void i();

        public final void j(@k.e.a.d Intent intent) {
            try {
                r.startActivity(intent, new Bundle[0]);
            } catch (Exception unused) {
                String str = this.f7874c;
                if (str != null) {
                    x.f(str, 0, 2, null);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vector/util/IntentAction$BrowserAction;", "Lcom/vector/util/IntentAction$BaseAction;", "()V", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "url", "", "launch", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class f extends e<f> {
        @k.e.a.e

        /* renamed from: d  reason: collision with root package name */
        private String f7875d;

        @Override // com.vector.util.IntentAction.e
        @k.e.a.d
        public Intent f() {
            return new Intent().setAction("android.intent.action.VIEW").setData(Uri.parse(this.f7875d));
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            if (this.f7875d == null) {
                return;
            }
            j(f());
        }

        @k.e.a.d
        public final f k(@k.e.a.d String str) {
            this.f7875d = str;
            return g();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/vector/util/IntentAction$ExcelAction;", "Lcom/vector/util/IntentAction$FileAction;", "()V", "type", "", "getType", "()Ljava/lang/String;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class g extends h<g> {
        @Override // com.vector.util.IntentAction.h
        @k.e.a.d
        public String getType() {
            return "application/vnd.ms-excel";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/vector/util/IntentAction$FileAction;", "ACTION", "Lcom/vector/util/IntentAction$BaseAction;", "()V", "filePath", "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "type", "getType", "()Ljava/lang/String;", "path", "(Ljava/lang/String;)Lcom/vector/util/IntentAction$BaseAction;", "launch", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class h<ACTION extends e<ACTION>> extends e<ACTION> {
        @k.e.a.e

        /* renamed from: d  reason: collision with root package name */
        private String f7876d;

        @Override // com.vector.util.IntentAction.e
        @k.e.a.e
        public Intent f() {
            String str = this.f7876d;
            if (str == null) {
                return null;
            }
            return new Intent("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").addFlags(268435456).setDataAndType(Uri.fromFile(new File(str)), getType());
        }

        @k.e.a.d
        public abstract String getType();

        @Override // com.vector.util.IntentAction.e
        public void i() {
            if (this.f7876d == null) {
                x.f("file path can not be null", 0, 2, null);
                return;
            }
            Intent f2 = f();
            if (f2 == null) {
                return;
            }
            j(f2);
        }

        @k.e.a.d
        public final ACTION k(@k.e.a.d String str) {
            this.f7876d = str;
            return g();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/vector/util/IntentAction$MailAction;", "Lcom/vector/util/IntentAction$BaseAction;", "()V", "address", "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "subject", "subjectId", "", "text", am.av, "launch", "", "id", "s", am.aI, "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class i extends e<i> {
        @k.e.a.e

        /* renamed from: d  reason: collision with root package name */
        private String f7877d;
        @k.e.a.e

        /* renamed from: e  reason: collision with root package name */
        private String f7878e;

        /* renamed from: f  reason: collision with root package name */
        private int f7879f;
        @k.e.a.e

        /* renamed from: g  reason: collision with root package name */
        private String f7880g;

        @Override // com.vector.util.IntentAction.e
        @k.e.a.d
        public Intent f() {
            boolean z = true;
            Intent putExtra = new Intent("android.intent.action.SEND").setType("plain/text").putExtra("android.intent.extra.EMAIL", new String[]{this.f7877d}).putExtra("android.intent.extra.TEXT", this.f7880g);
            String str = this.f7878e;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                putExtra.putExtra("android.intent.extra.SUBJECT", this.f7879f);
            } else {
                putExtra.putExtra("android.intent.extra.SUBJECT", this.f7878e);
            }
            return putExtra;
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            b(f());
        }

        @k.e.a.d
        public final i k(@k.e.a.d String str) {
            this.f7877d = str;
            return g();
        }

        @k.e.a.d
        public final i l(@StringRes int i2) {
            this.f7879f = i2;
            return g();
        }

        @k.e.a.d
        public final i m(@k.e.a.d String str) {
            this.f7878e = str;
            return g();
        }

        @k.e.a.d
        public final i n(@k.e.a.d String str) {
            this.f7880g = str;
            return g();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/vector/util/IntentAction$MapAction;", "Lcom/vector/util/IntentAction$BaseAction;", "()V", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "latitude", "", "longitude", "name", "", com.umeng.analytics.pro.d.C, "launch", "", "lon", "n", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class j extends e<j> {

        /* renamed from: d  reason: collision with root package name */
        private double f7881d;

        /* renamed from: e  reason: collision with root package name */
        private double f7882e;
        @k.e.a.e

        /* renamed from: f  reason: collision with root package name */
        private String f7883f;

        @Override // com.vector.util.IntentAction.e
        @k.e.a.d
        public Intent f() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("geo:");
            stringBuffer.append(this.f7881d);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(this.f7882e);
            String str = this.f7883f;
            if (!(str == null || str.length() == 0)) {
                stringBuffer.append("?q=");
                stringBuffer.append(this.f7883f);
            }
            return new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString()));
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            j(f());
        }

        @k.e.a.d
        public final j k(double d2) {
            this.f7881d = d2;
            return g();
        }

        @k.e.a.d
        public final j l(double d2) {
            this.f7882e = d2;
            return g();
        }

        @k.e.a.d
        public final j m(@k.e.a.d String str) {
            this.f7883f = str;
            return g();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/vector/util/IntentAction$MarketAction;", "Lcom/vector/util/IntentAction$BaseAction;", "()V", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "launch", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class k extends e<k> {
        @Override // com.vector.util.IntentAction.e
        @k.e.a.d
        public Intent f() {
            return new Intent("android.intent.action.VIEW").setData(Uri.parse(f0.C(BaseConstants.MARKET_PREFIX, e.t.a.b().getPackageName())));
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            Intent f2 = f();
            if (e.t.a.b().getPackageManager().queryIntentActivities(f2, 65536).isEmpty()) {
                x.f(e(), 0, 2, null);
            } else {
                j(f2);
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/vector/util/IntentAction$PhoneCallAction;", "Lcom/vector/util/IntentAction$BaseAction;", "()V", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "tellNum", "", "launch", "", "num", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class l extends e<l> {
        @k.e.a.e

        /* renamed from: d  reason: collision with root package name */
        private String f7884d;

        @Override // com.vector.util.IntentAction.e
        @k.e.a.d
        public Intent f() {
            String str = this.f7884d;
            if (str == null) {
                return new Intent();
            }
            return new Intent("android.intent.action.DIAL").setData(Uri.parse(f0.C("tel:", str)));
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            String str = this.f7884d;
            if (str == null || str.length() == 0) {
                return;
            }
            j(f());
        }

        @k.e.a.d
        public final l k(@k.e.a.d String str) {
            this.f7884d = str;
            return g();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/vector/util/IntentAction$PhotoAction;", "Lcom/vector/util/IntentAction$BaseAction;", "()V", "code", "", ReportItem.RequestKeyHost, "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "path", "", MessageKey.MSG_SOURCE, "Lcom/vector/util/IntentAction$PhotoSource;", "c", "h", "launch", "", am.ax, "s", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class m extends e<m> {
        @k.e.a.e

        /* renamed from: e  reason: collision with root package name */
        private String f7886e;
        @k.e.a.e

        /* renamed from: f  reason: collision with root package name */
        private Object f7887f;
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        private PhotoSource f7885d = PhotoSource.UN_KNOWN;

        /* renamed from: g  reason: collision with root package name */
        private int f7888g = -1;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[PhotoSource.values().length];
                iArr[PhotoSource.CAMERA.ordinal()] = 1;
                iArr[PhotoSource.ALBUM.ordinal()] = 2;
                a = iArr;
            }
        }

        @Override // com.vector.util.IntentAction.e
        @k.e.a.e
        public Intent f() {
            Uri fromFile;
            int i2 = a.a[this.f7885d.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            }
            String str = this.f7886e;
            if (str == null) {
                return null;
            }
            if (str.length() == 0) {
                return null;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File file = new File(str);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(3);
                fromFile = FileProvider.getUriForFile(e.t.a.b(), e.t.m.e.a(), file);
            } else {
                fromFile = Uri.fromFile(file);
            }
            intent.putExtra("output", fromFile);
            return intent;
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            int i2;
            Intent f2 = f();
            if (f2 == null) {
                return;
            }
            Object obj = this.f7887f;
            if (obj != null && (i2 = this.f7888g) != -1 && this.f7885d != PhotoSource.UN_KNOWN) {
                r.a.startActivityForResult(obj, f2, i2, new Bundle[0]);
            } else {
                x.f("Incorrect configuration", 0, 2, null);
            }
        }

        @k.e.a.d
        public final m k(int i2) {
            this.f7888g = i2;
            return g();
        }

        @k.e.a.d
        public final m l(@k.e.a.d Object obj) {
            this.f7887f = obj;
            return g();
        }

        @k.e.a.d
        public final m m(@k.e.a.d String str) {
            this.f7886e = str;
            return g();
        }

        @k.e.a.d
        public final m n(@k.e.a.d PhotoSource photoSource) {
            this.f7885d = photoSource;
            return g();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/vector/util/IntentAction$PptAction;", "Lcom/vector/util/IntentAction$FileAction;", "()V", "type", "", "getType", "()Ljava/lang/String;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class n extends h<n> {
        @Override // com.vector.util.IntentAction.h
        @k.e.a.d
        public String getType() {
            return "application/vnd.ms-powerpoint";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/vector/util/IntentAction$SystemShareAction;", "Lcom/vector/util/IntentAction$BaseAction;", "()V", "imgPath", "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "text", "title", "type", "path", "launch", "", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class o extends e<o> {
        @k.e.a.d

        /* renamed from: h  reason: collision with root package name */
        public static final a f7889h = new a(null);
        @k.e.a.d

        /* renamed from: i  reason: collision with root package name */
        public static final String f7890i = "text";
        @k.e.a.d

        /* renamed from: j  reason: collision with root package name */
        public static final String f7891j = "img";
        @k.e.a.e

        /* renamed from: d  reason: collision with root package name */
        private String f7892d = "";
        @k.e.a.e

        /* renamed from: e  reason: collision with root package name */
        private String f7893e;
        @k.e.a.e

        /* renamed from: f  reason: collision with root package name */
        private String f7894f;
        @k.e.a.e

        /* renamed from: g  reason: collision with root package name */
        private String f7895g;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vector/util/IntentAction$SystemShareAction$Companion;", "", "()V", "SHARE_IMG", "", "SHARE_TEXT", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }
        }

        @Override // com.vector.util.IntentAction.e
        @k.e.a.e
        public Intent f() {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            if (f0.g(this.f7892d, f7891j)) {
                intent.setType("image/jpeg");
                try {
                    String str = this.f7895g;
                    if (str == null) {
                        return null;
                    }
                    if (str.length() == 0) {
                        return null;
                    }
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
                } catch (Exception unused) {
                }
            } else {
                intent.setType(ak.f1434e);
                String str2 = this.f7893e;
                if (str2 == null) {
                    str2 = "";
                }
                intent.putExtra("android.intent.extra.TEXT", str2);
            }
            String str3 = this.f7894f;
            return Intent.createChooser(intent, str3 != null ? str3 : "");
        }

        @Override // com.vector.util.IntentAction.e
        public void i() {
            Intent f2 = f();
            if (f2 == null) {
                return;
            }
            r.startActivity(f2, new Bundle[0]);
        }

        @k.e.a.d
        public final o k(@k.e.a.e String str) {
            this.f7895g = str;
            return this;
        }

        @k.e.a.d
        public final o l(@k.e.a.e String str) {
            this.f7893e = str;
            return this;
        }

        @k.e.a.d
        public final o m(@k.e.a.e String str) {
            this.f7894f = str;
            return this;
        }

        @k.e.a.d
        public final o n(@k.e.a.e String str) {
            this.f7892d = str;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/vector/util/IntentAction$WordAction;", "Lcom/vector/util/IntentAction$FileAction;", "()V", "type", "", "getType", "()Ljava/lang/String;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class p extends h<p> {
        @Override // com.vector.util.IntentAction.h
        @k.e.a.d
        public String getType() {
            return "application/msword";
        }
    }

    private IntentAction() {
    }

    @k.e.a.d
    public final a a(@k.e.a.d Intent intent) {
        return new a(intent);
    }

    @k.e.a.d
    public final b b() {
        return new b();
    }

    @k.e.a.d
    public final c c() {
        return new c();
    }

    @k.e.a.d
    public final d d() {
        return new d();
    }

    @k.e.a.d
    public final f e() {
        return new f();
    }

    @k.e.a.d
    public final g f() {
        return new g();
    }

    @k.e.a.d
    public final i g() {
        return new i();
    }

    @k.e.a.d
    public final j h() {
        return new j();
    }

    @k.e.a.d
    public final k i() {
        return new k();
    }

    @k.e.a.d
    public final l j() {
        return new l();
    }

    @k.e.a.d
    public final m k() {
        return new m();
    }

    @k.e.a.d
    public final n l() {
        return new n();
    }

    @k.e.a.d
    public final o m() {
        return new o();
    }

    @k.e.a.d
    public final p n() {
        return new p();
    }
}
