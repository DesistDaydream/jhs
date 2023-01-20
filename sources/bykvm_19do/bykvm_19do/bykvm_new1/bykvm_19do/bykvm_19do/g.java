package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.drawable.IconCompat;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.h;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {
    private static boolean a = false;
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static int f1153c;

    /* renamed from: d  reason: collision with root package name */
    private static List<d> f1154d;

    /* renamed from: g  reason: collision with root package name */
    private static long f1157g;

    /* renamed from: h  reason: collision with root package name */
    private static HandlerThread f1158h;

    /* renamed from: i  reason: collision with root package name */
    private static long f1159i;

    /* renamed from: j  reason: collision with root package name */
    private static long f1160j;

    /* renamed from: k  reason: collision with root package name */
    private static Handler f1161k;

    /* renamed from: l  reason: collision with root package name */
    private static int f1162l;

    /* renamed from: m  reason: collision with root package name */
    private static boolean f1163m;

    /* renamed from: e  reason: collision with root package name */
    private static volatile AtomicLong f1155e = new AtomicLong(-1);

    /* renamed from: f  reason: collision with root package name */
    private static long f1156f = 100;
    private static volatile String n = null;
    private static volatile boolean o = false;
    private static int p = -1;
    public static long q = -1;
    public static long r = -1;
    private static int s = -1;
    private static MessageQueue t = null;
    private static Field u = null;
    private static Field v = null;

    /* loaded from: classes.dex */
    public static final class a implements Printer {
        @Override // android.util.Printer
        public void println(String str) {
            if (g.b) {
                String unused = g.n = str;
                if (!g.f1163m) {
                    boolean unused2 = g.f1163m = true;
                    int unused3 = g.p = Process.myTid();
                    g.v();
                }
                g.q = g.f1155e.get();
                if (g.r != -1) {
                    long j2 = g.q - g.r;
                    if (j2 <= 0) {
                        g.k();
                        return;
                    }
                    int i2 = j2 == 1 ? g.f1162l > 1 ? 7 : g.f1162l == 1 ? 3 : 0 : g.f1162l > 1 ? 5 : g.f1162l == 1 ? 6 : 1;
                    long s = g.s();
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (!g.o) {
                        g.b(g.t(), s - g.f1159i, uptimeMillis - g.f1160j, j2, i2, g.f1162l, null);
                    }
                    long unused4 = g.f1159i = s;
                    long unused5 = g.f1160j = uptimeMillis;
                    int unused6 = g.f1162l = 1;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Printer {
        @Override // android.util.Printer
        public void println(String str) {
            g.r = g.f1155e.get();
            if (g.q <= 0) {
                return;
            }
            long j2 = g.r - g.q;
            if (j2 > 0) {
                long s = g.s();
                long uptimeMillis = SystemClock.uptimeMillis();
                int i2 = (j2 > 1L ? 1 : (j2 == 1L ? 0 : -1));
                int i3 = (i2 != 0 || g.f1162l <= 1) ? (i2 == 0 && g.f1162l == 1) ? 2 : (i2 <= 0 || g.f1162l <= 1) ? (i2 <= 0 || g.f1162l != 1) ? 0 : 8 : 4 : 9;
                if (!g.o) {
                    g.b(g.t(), s - g.f1159i, uptimeMillis - g.f1160j, j2, i3, g.f1162l, str);
                }
                long unused = g.f1159i = s;
                long unused2 = g.f1160j = uptimeMillis;
                int unused3 = g.f1162l = 0;
                g.q = -1L;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            long j2;
            g.f1155e.set((SystemClock.uptimeMillis() - g.f1157g) / g.f1156f);
            long uptimeMillis = (SystemClock.uptimeMillis() - g.f1157g) % g.f1156f;
            if (uptimeMillis >= 95) {
                g.f1155e.incrementAndGet();
                j2 = g.f1156f << 1;
            } else {
                j2 = g.f1156f;
            }
            g.f1161k.postDelayed(this, j2 - uptimeMillis);
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public int a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public long f1164c;

        /* renamed from: d  reason: collision with root package name */
        public long f1165d;

        /* renamed from: e  reason: collision with root package name */
        public long f1166e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1167f;

        /* renamed from: g  reason: collision with root package name */
        public String f1168g;

        public String toString() {
            StringBuilder sb;
            String str;
            String str2;
            String str3;
            int i2 = this.b;
            if (i2 == 0) {
                sb = new StringBuilder();
                str3 = "[[[ IDLE  ]]] cost ";
            } else if (i2 != 1) {
                if (i2 == 2) {
                    sb = new StringBuilder();
                    sb.append("[[[  1 msg  ]]] cost ");
                    sb.append(this.f1164c);
                    sb.append(" tick , mDuration：");
                    sb.append(this.f1165d);
                    sb.append(",cpuTime:");
                    sb.append(this.f1166e);
                    sb.append(", msg:");
                } else if (i2 == 3) {
                    sb = new StringBuilder();
                    str3 = "[[[ 1 msg + IDLE  ]]] cost ";
                } else {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            sb = new StringBuilder();
                            sb.append("[[[ ");
                            sb.append(this.a);
                            sb.append(" msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than");
                            sb.append(this.f1164c - 1);
                            str2 = " ticks, , mDuration：";
                        } else if (i2 != 6) {
                            if (i2 == 7) {
                                sb = new StringBuilder();
                                sb.append("[[[ ");
                                sb.append(this.a);
                                str = " msgs + IDLE  ]]] cost 1 tick , mDuration：";
                            } else if (i2 == 8) {
                                sb = new StringBuilder();
                                sb.append("[[[ 1 msgs ]]] cost ");
                                sb.append(this.f1164c);
                                sb.append(" ticks , mDuration：");
                                sb.append(this.f1165d);
                                sb.append(" cost cpuTime:");
                            } else if (i2 != 9) {
                                sb = new StringBuilder();
                                sb.append("=========   UNKNOW =========  Type:");
                                sb.append(this.b);
                                sb.append(" cost ticks ");
                                sb.append(this.f1164c);
                                sb.append(" msgs:");
                                sb.append(this.a);
                                return sb.toString();
                            } else {
                                sb = new StringBuilder();
                                sb.append("[[[ ");
                                sb.append(this.a);
                                str = " msgs ]]] cost 1 tick , mDuration：";
                            }
                            sb.append(str);
                            sb.append(this.f1165d);
                            sb.append(" cost cpuTime:");
                            sb.append(this.f1166e);
                            return sb.toString();
                        } else {
                            sb = new StringBuilder();
                            sb.append("[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than");
                            sb.append(this.f1164c - 1);
                            str2 = ", , mDuration：";
                        }
                        sb.append(str2);
                        sb.append(this.f1165d);
                        sb.append("cpuTime:");
                        sb.append(this.f1166e);
                        return sb.toString();
                    }
                    sb = new StringBuilder();
                    sb.append("[[[ ");
                    sb.append(this.a - 1);
                    sb.append(" msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than ");
                    sb.append(this.f1164c - 1);
                    sb.append("tick ,, mDuration：");
                    sb.append(this.f1165d);
                    sb.append("cpuTime:");
                    sb.append(this.f1166e);
                    sb.append(" msg:");
                }
                sb.append(this.f1168g);
                return sb.toString();
            } else {
                sb = new StringBuilder();
                str3 = "[[[ Long IDLE  ]]] cost ";
            }
            sb.append(str3);
            sb.append(this.f1164c);
            sb.append(" tick , mDuration：");
            sb.append(this.f1165d);
            sb.append(",cpuTime:");
            sb.append(this.f1166e);
            return sb.toString();
        }
    }

    private static Message a(Message message) {
        Message message2;
        Field field = v;
        Message message3 = null;
        try {
            if (field == null) {
                Field declaredField = Class.forName("android.os.Message").getDeclaredField("next");
                v = declaredField;
                declaredField.setAccessible(true);
                message2 = (Message) v.get(message);
                if (a) {
                    Log.i("LooperMonitor", "[getNextMessage] success get next msg :" + message2);
                }
            } else {
                message2 = (Message) field.get(message);
            }
            message3 = message2;
            return message3;
        } catch (Exception unused) {
            return message3;
        }
    }

    private static Message a(MessageQueue messageQueue) {
        Object obj;
        Field field = u;
        try {
            if (field == null) {
                Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                u = declaredField;
                declaredField.setAccessible(true);
                obj = u.get(messageQueue);
            } else {
                obj = field.get(messageQueue);
            }
            return (Message) obj;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONArray a(int i2, long j2) {
        MessageQueue r2 = r();
        JSONArray jSONArray = new JSONArray();
        if (r2 != null) {
            synchronized (r2) {
                Message a2 = a(r2);
                if (a2 != null) {
                    int i3 = 0;
                    int i4 = 0;
                    while (a2 != null && i3 < i2) {
                        i3++;
                        i4++;
                        JSONObject a3 = a(a2, j2);
                        try {
                            a3.put("id", i4);
                        } catch (JSONException unused) {
                        }
                        jSONArray.put(a3);
                        a2 = a(a2);
                    }
                }
            }
        }
        return jSONArray;
    }

    private static JSONObject a(Message message, long j2) {
        JSONObject jSONObject = new JSONObject();
        if (message != null) {
            try {
                jSONObject.put(RemoteMessageConst.Notification.WHEN, message.getWhen() - j2);
                if (message.getCallback() != null) {
                    jSONObject.put("callback", message.getCallback());
                }
                jSONObject.put("what", message.what);
                if (message.getTarget() != null) {
                    jSONObject.put(TypedValues.Attributes.S_TARGET, message.getTarget());
                } else {
                    jSONObject.put("barrier", message.arg1);
                }
                jSONObject.put("arg1", message.arg1);
                jSONObject.put("arg2", message.arg2);
                Object obj = message.obj;
                if (obj != null) {
                    jSONObject.put(IconCompat.EXTRA_OBJ, obj);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static void a(int i2, int i3) {
        if (b) {
            if (i2 > 10) {
                f1153c = i2;
            }
            if (i3 > 10) {
                f1156f = i3;
            }
            f1154d = new ArrayList();
            u();
            a(r());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(d dVar, long j2, long j3, long j4, int i2, int i3, String str) {
        dVar.f1166e = j2;
        dVar.f1164c = j4;
        dVar.f1165d = j3;
        dVar.f1167f = false;
        dVar.a = i3;
        if (str != null) {
            dVar.f1168g = str;
        }
        dVar.b = i2;
    }

    public static JSONObject c(long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", n);
            jSONObject.put("currentMessageCost", o());
            jSONObject.put("currentMessageCpu", s() - f1159i);
            jSONObject.put("currentTick", f1155e.get());
        } catch (Throwable th) {
            j.a(th);
        }
        return jSONObject;
    }

    public static /* synthetic */ int k() {
        int i2 = f1162l;
        f1162l = i2 + 1;
        return i2;
    }

    public static long o() {
        return (SystemClock.uptimeMillis() - f1157g) - ((q < 0 ? r : q) * f1156f);
    }

    public static List<d> p() {
        if (f1154d == null) {
            return null;
        }
        o = true;
        ArrayList arrayList = new ArrayList();
        if (f1154d.size() == f1153c) {
            for (int i2 = s; i2 < f1154d.size(); i2++) {
                arrayList.add(f1154d.get(i2));
            }
            for (int i3 = 0; i3 < s; i3++) {
                arrayList.add(f1154d.get(i3));
            }
        } else {
            arrayList.addAll(f1154d);
        }
        o = false;
        return arrayList;
    }

    public static JSONArray q() {
        JSONArray jSONArray = new JSONArray();
        List<d> p2 = p();
        if (p2 != null) {
            int i2 = 0;
            for (d dVar : p2) {
                if (dVar != null) {
                    i2++;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("msg", dVar.f1168g);
                        jSONObject.put("cpuDuration", dVar.f1166e);
                        jSONObject.put("duration", dVar.f1165d);
                        jSONObject.put("tick", dVar.f1164c);
                        jSONObject.put("type", dVar.b);
                        jSONObject.put("count", dVar.a);
                        jSONObject.put("id", i2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray;
    }

    public static MessageQueue r() {
        MessageQueue queue;
        if (t == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                queue = Looper.myQueue();
            } else if (Build.VERSION.SDK_INT >= 23) {
                queue = mainLooper.getQueue();
            } else {
                try {
                    Field declaredField = mainLooper.getClass().getDeclaredField("mQueue");
                    declaredField.setAccessible(true);
                    t = (MessageQueue) declaredField.get(mainLooper);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            t = queue;
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long s() {
        return bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.c.a(p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static d t() {
        int size = f1154d.size();
        int i2 = f1153c;
        if (size == i2) {
            int i3 = (s + 1) % i2;
            s = i3;
            return f1154d.get(i3);
        }
        d dVar = new d();
        f1154d.add(dVar);
        s++;
        return dVar;
    }

    public static void u() {
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.g.a(4L);
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.f.e().a();
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.f.e().b(new a());
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.f.e().a(new b());
        f1159i = s();
        f1160j = SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v() {
        f1158h = h.b();
        f1157g = SystemClock.uptimeMillis();
        f1161k = new Handler(f1158h.getLooper());
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.g.a(8L);
        f1161k.postDelayed(new c(), f1156f);
    }
}
