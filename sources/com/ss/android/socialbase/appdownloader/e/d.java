package com.ss.android.socialbase.appdownloader.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.c.n;
import com.ss.android.socialbase.appdownloader.i;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class d {
    private static final String a = "d";
    private static List<n> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private static com.ss.android.socialbase.appdownloader.view.a f5466c;

    /* renamed from: d  reason: collision with root package name */
    private static AlertDialog f5467d;

    public static void b(@NonNull Activity activity, @NonNull n nVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = a;
                    com.ss.android.socialbase.appdownloader.view.a aVar = (com.ss.android.socialbase.appdownloader.view.a) fragmentManager.findFragmentByTag(str);
                    f5466c = aVar;
                    if (aVar == null) {
                        f5466c = new com.ss.android.socialbase.appdownloader.view.a();
                        fragmentManager.beginTransaction().add(f5466c, str).commitAllowingStateLoss();
                        fragmentManager.executePendingTransactions();
                    }
                    f5466c.a();
                    return;
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    nVar.a();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
        }
        nVar.a();
    }

    public static boolean a() {
        try {
            return NotificationManagerCompat.from(com.ss.android.socialbase.downloader.downloader.c.N()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (d.class) {
            try {
                AlertDialog alertDialog = f5467d;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    f5467d = null;
                }
                for (n nVar : b) {
                    if (nVar != null) {
                        if (z) {
                            nVar.a();
                        } else {
                            nVar.b();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void a(@NonNull final Activity activity, @NonNull final n nVar) {
        synchronized (d.class) {
            if (nVar == null) {
                return;
            }
            if (activity != null) {
                try {
                } catch (Throwable th) {
                    th.printStackTrace();
                    a(false);
                }
                if (!activity.isFinishing()) {
                    int a2 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_title");
                    int a3 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_message");
                    int a4 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_btn_yes");
                    int a5 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_btn_no");
                    b.add(nVar);
                    AlertDialog alertDialog = f5467d;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        f5467d = new AlertDialog.Builder(activity).setTitle(a2).setMessage(a3).setPositiveButton(a4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                d.b(activity, nVar);
                                dialogInterface.cancel();
                                AlertDialog unused = d.f5467d = null;
                            }
                        }).setNegativeButton(a5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                d.a(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                                if (i2 == 4) {
                                    if (keyEvent.getAction() == 1) {
                                        d.a(false);
                                    }
                                    return true;
                                }
                                return false;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            }
            nVar.b();
        }
    }
}
