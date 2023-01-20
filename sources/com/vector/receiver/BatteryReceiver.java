package com.vector.receiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.vector.receiver.Battery;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000bJ\u001c\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\u0004\u0018\u0001`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/vector/receiver/BatteryReceiver;", "Lcom/vector/receiver/BaseReceiver;", "()V", "filter", "Landroid/content/IntentFilter;", "getFilter", "()Landroid/content/IntentFilter;", "onBatteryChanged", "Lkotlin/Function1;", "Lcom/vector/receiver/Battery;", "", "Lcom/vector/receiver/OnBatteryChanged;", "observe", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "onReceive", "context", "Landroid/content/Context;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BatteryReceiver extends BaseReceiver {
    @e
    private l<? super Battery, t1> b;

    @Override // com.vector.receiver.BaseReceiver
    @d
    public IntentFilter a() {
        return new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public final void g(@d LifecycleOwner lifecycleOwner, @d l<? super Battery, t1> lVar) {
        e(lifecycleOwner);
        this.b = lVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@e Context context, @e Intent intent) {
        Battery.Status status;
        Battery.Health health;
        if (intent == null || b()) {
            return;
        }
        Battery battery = new Battery();
        battery.j(intent.getIntExtra("voltage", 0));
        battery.i(intent.getIntExtra("temperature", 0));
        int intExtra = intent.getIntExtra("level", 0);
        int intExtra2 = intent.getIntExtra("scale", 100);
        if (intExtra2 != 100) {
            intExtra = (int) (intExtra / (intExtra2 * 100.0f));
        }
        battery.g(intExtra);
        int intExtra3 = intent.getIntExtra("status", 1);
        if (intExtra3 == 2) {
            status = Battery.Status.CHARGING;
        } else if (intExtra3 == 3) {
            status = Battery.Status.DISCHARGING;
        } else if (intExtra3 == 4) {
            status = Battery.Status.NOT_CHARGING;
        } else if (intExtra3 != 5) {
            status = Battery.Status.UNKNOWN;
        } else {
            status = Battery.Status.FULL;
        }
        battery.h(status);
        switch (intent.getIntExtra("health", 1)) {
            case 2:
                health = Battery.Health.GOOD;
                break;
            case 3:
                health = Battery.Health.OVERHEAT;
                break;
            case 4:
                health = Battery.Health.DEAD;
                break;
            case 5:
                health = Battery.Health.OVER_VOLTAGE;
                break;
            case 6:
                health = Battery.Health.UNSPECIFIED_FAILURE;
                break;
            case 7:
                health = Battery.Health.COLD;
                break;
            default:
                health = Battery.Health.UNKNOWN;
                break;
        }
        battery.f(health);
        l<? super Battery, t1> lVar = this.b;
        if (lVar == null) {
            return;
        }
        lVar.invoke(battery);
    }
}
