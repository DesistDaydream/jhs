package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class UMConfigureImpl {
    private static String a = "delayed_transmission_flag_new";

    /* renamed from: e  reason: collision with root package name */
    private static final int f7318e = 1000;

    /* renamed from: f  reason: collision with root package name */
    private static ScheduledExecutorService f7319f;

    /* renamed from: g  reason: collision with root package name */
    private static Context f7320g;
    private static CopyOnWriteArrayList<onMessageSendListener> b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private static int f7316c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f7317d = false;

    /* renamed from: h  reason: collision with root package name */
    private static int f7321h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static Runnable f7322i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f7316c == 0 || UMConfigureImpl.f7321h >= 10) {
                    if (!UMConfigureImpl.f7317d) {
                        boolean unused = UMConfigureImpl.f7317d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f7320g);
                    }
                    if (UMConfigureImpl.f7319f != null) {
                        UMConfigureImpl.f7319f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f7319f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    public static /* synthetic */ int f() {
        int i2 = f7321h;
        f7321h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f7320g = context;
        try {
            if (f7316c >= 1) {
                if (!d(context)) {
                    UMEnvelopeBuild.setTransmissionSendFlag(false);
                    c(context);
                    if (f7319f == null) {
                        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                        f7319f = newScheduledThreadPool;
                        newScheduledThreadPool.scheduleAtFixedRate(f7322i, 0L, 100L, TimeUnit.MILLISECONDS);
                    }
                } else {
                    UMEnvelopeBuild.setTransmissionSendFlag(true);
                }
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f7316c++;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList;
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList2 = b;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && (copyOnWriteArrayList = b) != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f7316c--;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = b;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.remove(onmessagesendlistener);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        synchronized (UMConfigureImpl.class) {
            try {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = b;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(a, true);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(a, false);
        } catch (Throwable unused) {
            return false;
        }
    }
}
