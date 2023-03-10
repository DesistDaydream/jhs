package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import com.heytap.mcssdk.constant.a;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;

/* loaded from: classes3.dex */
public class ImLatent implements d {
    private static ImLatent instanse;
    private Context context;
    private StatTracer statTracer;
    private com.umeng.commonsdk.statistics.common.d storeHelper;
    private final int _DEFAULT_HOURS = 360;
    private final int _DEFAULT_MIN_HOURS = 36;
    private final int _DEFAULT_MIN_LATENT = 1;
    private final int _DEFAULT_MAX_LATENT = 1800;
    private final long _ONE_HOURS_IN_MS = a.f3315e;
    private final long _360HOURS_IN_MS = 1296000000;
    private final long _36HOURS_IN_MS = 129600000;
    private final int LATENT_MAX = Camera2CameraImpl.StateCallback.CameraReopenMonitor.ACTIVE_REOPEN_LIMIT_MS;
    private final int LATENT_WINDOW = 10;
    private long latentHour = 1296000000;
    private int latentWindow = 10;
    private long mDelay = 0;
    private long mElapsed = 0;
    private boolean mLatentActivite = false;
    private Object mLatentLock = new Object();

    private ImLatent(Context context, StatTracer statTracer) {
        this.context = context;
        this.storeHelper = com.umeng.commonsdk.statistics.common.d.a(context);
        this.statTracer = statTracer;
    }

    public static synchronized ImLatent getService(Context context, StatTracer statTracer) {
        ImLatent imLatent;
        synchronized (ImLatent.class) {
            if (instanse == null) {
                ImLatent imLatent2 = new ImLatent(context, statTracer);
                instanse = imLatent2;
                imLatent2.onImprintChanged(ImprintHandler.getImprintService(context).c());
            }
            imLatent = instanse;
        }
        return imLatent;
    }

    public long getDelayTime() {
        long j2;
        synchronized (this.mLatentLock) {
            j2 = this.mDelay;
        }
        return j2;
    }

    public long getElapsedTime() {
        return this.mElapsed;
    }

    public boolean isLatentActivite() {
        boolean z;
        synchronized (this.mLatentLock) {
            z = this.mLatentActivite;
        }
        return z;
    }

    public void latentDeactivite() {
        synchronized (this.mLatentLock) {
            this.mLatentActivite = false;
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.d
    public void onImprintChanged(ImprintHandler.a aVar) {
        int intValue = Integer.valueOf(aVar.a("latent_hours", String.valueOf(360))).intValue();
        this.latentHour = (intValue > 36 ? intValue : 360) * a.f3315e;
        int intValue2 = Integer.valueOf(aVar.a(am.aS, "0")).intValue();
        intValue2 = (intValue2 < 1 || intValue2 > 1800) ? 0 : 0;
        if (intValue2 == 0) {
            int i2 = com.umeng.commonsdk.statistics.a.f7454c;
            if (i2 > 0 && i2 <= 1800000) {
                this.latentWindow = i2;
                return;
            } else {
                this.latentWindow = 10;
                return;
            }
        }
        this.latentWindow = intValue2;
    }

    public boolean shouldStartLatency() {
        if (this.storeHelper.c() || this.statTracer.isFirstRequest()) {
            return false;
        }
        synchronized (this.mLatentLock) {
            if (this.mLatentActivite) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.statTracer.getLastReqTime();
            if (currentTimeMillis > this.latentHour) {
                String signature = Envelope.getSignature(this.context);
                synchronized (this.mLatentLock) {
                    this.mDelay = DataHelper.random(this.latentWindow, signature);
                    this.mElapsed = currentTimeMillis;
                    this.mLatentActivite = true;
                }
                return true;
            } else if (currentTimeMillis > 129600000) {
                synchronized (this.mLatentLock) {
                    this.mDelay = 0L;
                    this.mElapsed = currentTimeMillis;
                    this.mLatentActivite = true;
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
