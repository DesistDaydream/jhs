package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.firebase.messaging.zze;
import e.j.a.b.f.c.a;
import e.j.a.b.f.c.b;
import e.j.a.b.f.c.f;
import e.j.a.b.j.e;
import e.j.a.b.j.k;
import e.j.a.b.j.l;
import e.j.a.b.j.n;
import e.j.d.f.x;
import e.j.d.f.z;
import e.j.d.i.g;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* loaded from: classes2.dex */
public abstract class zze extends Service {
    @VisibleForTesting
    private final ExecutorService zza;
    private Binder zzb;
    private final Object zzc;
    private int zzd;
    private int zze;

    public zze() {
        b a = a.a();
        String valueOf = String.valueOf(getClass().getSimpleName());
        this.zza = a.a(new e.j.a.b.c.x.f0.b(valueOf.length() != 0 ? "Firebase-".concat(valueOf) : new String("Firebase-")), f.b);
        this.zzc = new Object();
        this.zze = 0;
    }

    @MainThread
    /* renamed from: zze */
    public final k<Void> zzd(Intent intent) {
        if (zzb(intent)) {
            return n.e(null);
        }
        l lVar = new l();
        this.zza.execute(new Runnable(this, intent, lVar) { // from class: e.j.d.i.h
            private final zze a;
            private final Intent b;

            /* renamed from: c */
            private final e.j.a.b.j.l f11281c;

            {
                this.a = this;
                this.b = intent;
                this.f11281c = lVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zze zzeVar = this.a;
                Intent intent2 = this.b;
                e.j.a.b.j.l lVar2 = this.f11281c;
                try {
                    zzeVar.zzc(intent2);
                } finally {
                    lVar2.setResult(null);
                }
            }
        });
        return lVar.a();
    }

    private final void zzf(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.zzc) {
            int i2 = this.zze - 1;
            this.zze = i2;
            if (i2 == 0) {
                stopSelfResult(this.zzd);
            }
        }
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.zzb == null) {
            this.zzb = new x(new z(this) { // from class: e.j.d.i.f
                private final zze a;

                {
                    this.a = this;
                }

                @Override // e.j.d.f.z
                public final e.j.a.b.j.k a(Intent intent2) {
                    return this.a.zzd(intent2);
                }
            });
        }
        return this.zzb;
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.zza.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        synchronized (this.zzc) {
            this.zzd = i3;
            this.zze++;
        }
        Intent zza = zza(intent);
        if (zza == null) {
            zzf(intent);
            return 2;
        }
        k<Void> zzd = zzd(zza);
        if (zzd.u()) {
            zzf(intent);
            return 2;
        }
        zzd.f(g.a, new e(this, intent) { // from class: e.j.d.i.i
            private final zze a;
            private final Intent b;

            {
                this.a = this;
                this.b = intent;
            }

            @Override // e.j.a.b.j.e
            public final void onComplete(e.j.a.b.j.k kVar) {
                this.a.zza(this.b, kVar);
            }
        });
        return 3;
    }

    public Intent zza(Intent intent) {
        return intent;
    }

    public final /* synthetic */ void zza(Intent intent, k kVar) {
        zzf(intent);
    }

    public boolean zzb(Intent intent) {
        return false;
    }

    public abstract void zzc(Intent intent);
}
