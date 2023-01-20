package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {
    public WeakReference<Activity> a;
    public String b = "";

    public final void a() {
        Activity b = b();
        if (b == null || b.isFinishing()) {
            return;
        }
        b.finish();
    }

    public final Activity b() {
        WeakReference<Activity> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void c() {
        SystemManager.getInstance().notifyResolutionResult(null, this.b);
        a();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        this.a = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            c();
            return;
        }
        Bundle extras = intent.getExtras();
        this.b = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
        if (extras == null) {
            c();
            return;
        }
        Parcelable parcelable = extras.getParcelable("resolution");
        if (parcelable == null) {
            c();
        } else if (parcelable instanceof Intent) {
            try {
                activity.startActivityForResult((Intent) parcelable, 1001);
            } catch (ActivityNotFoundException unused) {
                c();
                HMSLog.e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
            }
        } else if (parcelable instanceof PendingIntent) {
            try {
                activity.startIntentSenderForResult(((PendingIntent) parcelable).getIntentSender(), 1001, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused2) {
                c();
                HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i2, int i3, Intent intent) {
        if (i2 != getRequestCode()) {
            return false;
        }
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i3);
        if (i3 == 1001 || i3 == 1002) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i3);
        }
        if (i3 != -1 && !intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) && !intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(null, this.b);
        } else {
            SystemManager.getInstance().notifyResolutionResult(intent, this.b);
        }
        a();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i2, KeyEvent keyEvent) {
        HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }
}
