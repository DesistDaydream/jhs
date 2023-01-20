package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.umeng.analytics.pro.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {
    private Context a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private int f6504c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6505d;

    /* renamed from: com.tencent.bugly.crashreport.biz.a$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.c();
            } catch (Throwable th) {
                y.a(th);
            }
        }
    }

    /* renamed from: com.tencent.bugly.crashreport.biz.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0232a implements Runnable {
        private boolean a;
        private UserInfoBean b;

        public RunnableC0232a(UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                UserInfoBean userInfoBean = this.b;
                if (userInfoBean != null) {
                    a.a(a.this, userInfoBean);
                    y.c("[UserInfo] Record user info.", new Object[0]);
                    a.a(a.this, this.b, false);
                }
                if (this.a) {
                    a aVar = a.this;
                    x a = x.a();
                    if (a != null) {
                        a.a(new AnonymousClass2());
                    }
                }
            } catch (Throwable th) {
                if (y.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < a.this.b) {
                x.a().a(new b(), (a.this.b - currentTimeMillis) + 5000);
                return;
            }
            a.this.a(3, false, 0L);
            a.this.a();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        private long a;

        public c(long j2) {
            this.a = 21600000L;
            this.a = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            x a = x.a();
            if (a != null) {
                a.a(new AnonymousClass2());
            }
            a aVar2 = a.this;
            long j2 = this.a;
            x.a().a(new c(j2), j2);
        }
    }

    public a(Context context, boolean z) {
        this.f6505d = true;
        this.a = context;
        this.f6505d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0029 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002b A[Catch: all -> 0x00eb, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:21:0x002b, B:23:0x003e, B:25:0x004f, B:28:0x0064, B:30:0x006a, B:32:0x006f, B:35:0x0076, B:39:0x008e, B:41:0x0094, B:44:0x009d, B:46:0x00a3, B:49:0x00ac, B:51:0x00b6, B:54:0x00bf, B:58:0x00dd, B:61:0x00e2, B:26:0x005e, B:6:0x0009, B:9:0x0010, B:12:0x0017, B:14:0x001d), top: B:67:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a A[Catch: all -> 0x00eb, TryCatch #0 {, blocks: (B:3:0x0001, B:21:0x002b, B:23:0x003e, B:25:0x004f, B:28:0x0064, B:30:0x006a, B:32:0x006f, B:35:0x0076, B:39:0x008e, B:41:0x0094, B:44:0x009d, B:46:0x00a3, B:49:0x00ac, B:51:0x00b6, B:54:0x00bf, B:58:0x00dd, B:61:0x00e2, B:26:0x005e, B:6:0x0009, B:9:0x0010, B:12:0x0017, B:14:0x001d), top: B:67:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0094 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:21:0x002b, B:23:0x003e, B:25:0x004f, B:28:0x0064, B:30:0x006a, B:32:0x006f, B:35:0x0076, B:39:0x008e, B:41:0x0094, B:44:0x009d, B:46:0x00a3, B:49:0x00ac, B:51:0x00b6, B:54:0x00bf, B:58:0x00dd, B:61:0x00e2, B:26:0x005e, B:6:0x0009, B:9:0x0010, B:12:0x0017, B:14:0x001d), top: B:67:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009d A[Catch: all -> 0x00eb, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:21:0x002b, B:23:0x003e, B:25:0x004f, B:28:0x0064, B:30:0x006a, B:32:0x006f, B:35:0x0076, B:39:0x008e, B:41:0x0094, B:44:0x009d, B:46:0x00a3, B:49:0x00ac, B:51:0x00b6, B:54:0x00bf, B:58:0x00dd, B:61:0x00e2, B:26:0x005e, B:6:0x0009, B:9:0x0010, B:12:0x0017, B:14:0x001d), top: B:67:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void c() {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.a.c():void");
    }

    public static /* synthetic */ void a(a aVar, UserInfoBean userInfoBean) {
        com.tencent.bugly.crashreport.common.info.a b2;
        if (userInfoBean == null || (b2 = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return;
        }
        userInfoBean.f6500j = b2.e();
    }

    private static void b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f6496f != -1) {
                it.remove();
                if (next.f6495e < ab.b()) {
                    list2.add(next);
                }
            }
        }
    }

    public static /* synthetic */ void a(a aVar, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a;
        if (userInfoBean != null) {
            if (!z && userInfoBean.b != 1 && (a = aVar.a(com.tencent.bugly.crashreport.common.info.a.a(aVar.a).f6520d)) != null && a.size() >= 20) {
                y.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a.size()));
                return;
            }
            long a2 = o.a().a("t_ui", a(userInfoBean), (n) null, true);
            if (a2 >= 0) {
                y.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a2));
                userInfoBean.a = a2;
            }
        }
    }

    public final void a(int i2, boolean z, long j2) {
        com.tencent.bugly.crashreport.common.strategy.a a = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a != null && !a.c().f6534f && i2 != 1 && i2 != 3) {
            y.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i2 == 1 || i2 == 3) {
            this.f6504c++;
        }
        com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(this.a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.b = i2;
        userInfoBean.f6493c = a2.f6520d;
        userInfoBean.f6494d = a2.g();
        userInfoBean.f6495e = System.currentTimeMillis();
        userInfoBean.f6496f = -1L;
        userInfoBean.n = a2.f6525i;
        userInfoBean.o = i2 == 1 ? 1 : 0;
        userInfoBean.f6502l = a2.a();
        userInfoBean.f6503m = a2.o;
        userInfoBean.f6497g = a2.p;
        userInfoBean.f6498h = a2.q;
        userInfoBean.f6499i = a2.r;
        userInfoBean.f6501k = a2.s;
        userInfoBean.r = a2.x();
        userInfoBean.s = a2.C();
        userInfoBean.p = a2.D();
        userInfoBean.q = a2.E();
        x.a().a(new RunnableC0232a(userInfoBean, z), 0L);
    }

    public final void b() {
        x a = x.a();
        if (a != null) {
            a.a(new AnonymousClass2());
        }
    }

    public final void a() {
        this.b = ab.b() + 86400000;
        x.a().a(new b(), (this.b - System.currentTimeMillis()) + 5000);
    }

    private static void a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i2 = 0;
            while (i2 < list.size() - 1) {
                int i3 = i2 + 1;
                for (int i4 = i3; i4 < list.size(); i4++) {
                    if (list.get(i2).f6495e > list.get(i4).f6495e) {
                        list.set(i2, list.get(i4));
                        list.set(i4, list.get(i2));
                    }
                }
                i2 = i3;
            }
            for (int i5 = 0; i5 < size; i5++) {
                list2.add(list.get(i5));
            }
        }
    }

    private static int a(List<UserInfoBean> list, long j2) {
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.f6495e > currentTimeMillis - 600000 && ((i2 = userInfoBean.b) == 1 || i2 == 4 || i2 == 3)) {
                i3++;
            }
        }
        return i3;
    }

    public final List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (ab.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = o.a().a("t_ui", null, str2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a = a(cursor);
                    if (a != null) {
                        arrayList.add(a);
                    } else {
                        long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(j2);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    y.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(o.a().a("t_ui", sb2.substring(4), (String[]) null, (n) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!y.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size() && i2 < 50; i2++) {
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(list.get(i2).a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        String str = sb2;
        sb.setLength(0);
        try {
            y.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(o.a().a("t_ui", str, (String[]) null, (n) null, true)));
        } catch (Throwable th) {
            if (y.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = userInfoBean.a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f6495e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f6496f));
            contentValues.put(aq.f7041e, Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.f6493c);
            contentValues.put("_dt", ab.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ab.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.a = j2;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
