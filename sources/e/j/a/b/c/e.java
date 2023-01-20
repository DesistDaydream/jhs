package e.j.a.b.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.zabq;
import com.huawei.hms.push.constant.RemoteMessageConst;
import e.j.a.b.c.n.u.r1;
import e.j.a.b.c.n.u.u1;
import e.j.a.b.c.r.p;
import e.j.a.b.c.x.v;
import e.j.a.b.f.a.o;
import e.j.a.b.j.n;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class e extends f {

    /* renamed from: h */
    private static final Object f10121h = new Object();

    /* renamed from: i */
    private static final e f10122i = new e();

    /* renamed from: j */
    public static final int f10123j = f.a;

    /* renamed from: k */
    public static final String f10124k = "com.google.android.gms";
    @GuardedBy("mLock")

    /* renamed from: g */
    private String f10125g;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class a extends o {
        private final Context b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            e.this = r1;
            this.b = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int j2 = e.this.j(this.b);
            if (e.this.o(j2)) {
                e.this.A(this.b, j2);
            }
        }
    }

    public static Dialog C(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(e.j.a.b.c.r.g.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        F(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public static Dialog D(Context context, int i2, e.j.a.b.c.r.i iVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(e.j.a.b.c.r.g.d(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c2 = e.j.a.b.c.r.g.c(context, i2);
        if (c2 != null) {
            builder.setPositiveButton(c2, iVar);
        }
        String g2 = e.j.a.b.c.r.g.g(context, i2);
        if (g2 != null) {
            builder.setTitle(g2);
        }
        return builder.create();
    }

    public static void F(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            l.q(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
            return;
        }
        c.b(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void H(Context context, int i2, String str, PendingIntent pendingIntent) {
        int i3;
        if (i2 == 18) {
            G(context);
        } else if (pendingIntent == null) {
            if (i2 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            String f2 = e.j.a.b.c.r.g.f(context, i2);
            String e2 = e.j.a.b.c.r.g.e(context, i2);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(f2).setStyle(new NotificationCompat.BigTextStyle().bigText(e2));
            if (e.j.a.b.c.x.l.g(context)) {
                e.j.a.b.c.r.a0.q(v.i());
                style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
                if (e.j.a.b.c.x.l.h(context)) {
                    style.addAction(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), pendingIntent);
                } else {
                    style.setContentIntent(pendingIntent);
                }
            } else {
                style.setSmallIcon(17301642).setTicker(resources.getString(R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(e2);
            }
            if (v.n()) {
                e.j.a.b.c.r.a0.q(v.n());
                String K = K();
                if (K == null) {
                    K = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    String b = e.j.a.b.c.r.g.b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", b, 4));
                    } else if (!b.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                style.setChannelId(K);
            }
            Notification build = style.build();
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                i3 = h.f10138f;
                h.f10143k.set(false);
            } else {
                i3 = h.f10137e;
            }
            notificationManager.notify(i3, build);
        }
    }

    @VisibleForTesting(otherwise = 2)
    private final String K() {
        String str;
        synchronized (f10121h) {
            str = this.f10125g;
        }
        return str;
    }

    public static e v() {
        return f10122i;
    }

    public void A(Context context, int i2) {
        H(context, i2, null, g(context, i2, 0, "n"));
    }

    public void B(Context context, ConnectionResult connectionResult) {
        H(context, connectionResult.getErrorCode(), null, u(context, connectionResult));
    }

    @Nullable
    public final zabq E(Context context, r1 r1Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabq zabqVar = new zabq(r1Var);
        context.registerReceiver(zabqVar, intentFilter);
        zabqVar.b(context);
        if (n(context, "com.google.android.gms")) {
            return zabqVar;
        }
        r1Var.a();
        zabqVar.a();
        return null;
    }

    public final void G(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean I(Activity activity, @NonNull e.j.a.b.c.n.u.k kVar, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog D = D(activity, i2, e.j.a.b.c.r.i.c(kVar, e(activity, i2, f.f10128d), 2), onCancelListener);
        if (D == null) {
            return false;
        }
        F(activity, D, g.f10132m, onCancelListener);
        return true;
    }

    public final boolean J(Context context, ConnectionResult connectionResult, int i2) {
        PendingIntent u = u(context, connectionResult);
        if (u != null) {
            H(context, connectionResult.getErrorCode(), null, GoogleApiActivity.a(context, u, i2));
            return true;
        }
        return false;
    }

    @Override // e.j.a.b.c.f
    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public int c(Context context) {
        return super.c(context);
    }

    @Override // e.j.a.b.c.f
    @Nullable
    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public Intent e(Context context, int i2, @Nullable String str) {
        return super.e(context, i2, str);
    }

    @Override // e.j.a.b.c.f
    @Nullable
    public PendingIntent f(Context context, int i2, int i3) {
        return super.f(context, i2, i3);
    }

    @Override // e.j.a.b.c.f
    public final String h(int i2) {
        return super.h(i2);
    }

    @Override // e.j.a.b.c.f
    @p
    public int j(Context context) {
        return super.j(context);
    }

    @Override // e.j.a.b.c.f
    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public int k(Context context, int i2) {
        return super.k(context, i2);
    }

    @Override // e.j.a.b.c.f
    public final boolean o(int i2) {
        return super.o(i2);
    }

    public e.j.a.b.j.k<Void> r(e.j.a.b.c.n.h<?> hVar, e.j.a.b.c.n.h<?>... hVarArr) {
        e.j.a.b.c.r.a0.l(hVar, "Requested API must not be null.");
        for (e.j.a.b.c.n.h<?> hVar2 : hVarArr) {
            e.j.a.b.c.r.a0.l(hVar2, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(hVarArr.length + 1);
        arrayList.add(hVar);
        arrayList.addAll(Arrays.asList(hVarArr));
        return e.j.a.b.c.n.u.g.q().g(arrayList).m(new z(this));
    }

    public Dialog s(Activity activity, int i2, int i3) {
        return t(activity, i2, i3, null);
    }

    public Dialog t(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return D(activity, i2, e.j.a.b.c.r.i.a(activity, e(activity, i2, f.f10128d), i3), onCancelListener);
    }

    @Nullable
    public PendingIntent u(Context context, ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            return connectionResult.getResolution();
        }
        return f(context, connectionResult.getErrorCode(), 0);
    }

    @MainThread
    public e.j.a.b.j.k<Void> w(Activity activity) {
        int i2 = f10123j;
        e.j.a.b.c.r.a0.f("makeGooglePlayServicesAvailable must be called from the main thread");
        int k2 = k(activity, i2);
        if (k2 == 0) {
            return n.e(null);
        }
        u1 r = u1.r(activity);
        r.n(new ConnectionResult(k2, null), 0);
        return r.q();
    }

    @TargetApi(26)
    public void x(@NonNull Context context, @NonNull String str) {
        if (v.n()) {
            e.j.a.b.c.r.a0.k(((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).getNotificationChannel(str));
        }
        synchronized (f10121h) {
            this.f10125g = str;
        }
    }

    public boolean y(Activity activity, int i2, int i3) {
        return z(activity, i2, i3, null);
    }

    public boolean z(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog t = t(activity, i2, i3, onCancelListener);
        if (t == null) {
            return false;
        }
        F(activity, t, g.f10132m, onCancelListener);
        return true;
    }
}
