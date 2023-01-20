package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ai;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.y;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class b {
    private static int a;

    /* renamed from: g */
    private static final Map<Integer, Pair<String, String>> f6587g = new HashMap<Integer, Pair<String, String>>() { // from class: com.tencent.bugly.crashreport.crash.b.1
        {
            put(3, new Pair("203", "103"));
            put(7, new Pair("208", "108"));
            put(0, new Pair(BasicPushStatus.SUCCESS_CODE, "100"));
            put(1, new Pair("201", "101"));
            put(2, new Pair("202", "102"));
            put(4, new Pair("204", "104"));
            put(6, new Pair("206", "106"));
            put(5, new Pair("207", "107"));
        }
    };

    /* renamed from: h */
    private static final ArrayList<a> f6588h = new ArrayList<a>() { // from class: com.tencent.bugly.crashreport.crash.b.2
        {
            add(new C0235b((byte) 0));
            add(new c((byte) 0));
            add(new d((byte) 0));
            add(new e((byte) 0));
            add(new h((byte) 0));
            add(new i((byte) 0));
            add(new f((byte) 0));
            add(new g((byte) 0));
        }
    };

    /* renamed from: i */
    private static final Map<Integer, Integer> f6589i = new HashMap<Integer, Integer>() { // from class: com.tencent.bugly.crashreport.crash.b.3
        {
            put(3, 4);
            put(7, 7);
            put(2, 1);
            put(0, 0);
            put(1, 2);
            put(4, 3);
            put(5, 5);
            put(6, 6);
        }
    };

    /* renamed from: j */
    private static final Map<Integer, String> f6590j = new HashMap<Integer, String>() { // from class: com.tencent.bugly.crashreport.crash.b.4
        {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    };

    /* renamed from: k */
    private static final Map<Integer, String> f6591k = new HashMap<Integer, String>() { // from class: com.tencent.bugly.crashreport.crash.b.5
        {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    };
    private Context b;

    /* renamed from: c */
    private v f6592c;

    /* renamed from: d */
    private com.tencent.bugly.crashreport.common.strategy.a f6593d;

    /* renamed from: e */
    private n f6594e;

    /* renamed from: f */
    private BuglyStrategy.a f6595f;

    /* loaded from: classes3.dex */
    public static abstract class a {
        private final int a;

        public /* synthetic */ a(int i2, byte b) {
            this(i2);
        }

        public static /* synthetic */ boolean a(a aVar, CrashDetailBean crashDetailBean) {
            return aVar.a == crashDetailBean.b;
        }

        public abstract boolean a();

        private a(int i2) {
            this.a = i2;
        }
    }

    /* renamed from: com.tencent.bugly.crashreport.crash.b$b */
    /* loaded from: classes3.dex */
    public static class C0235b extends a {
        public /* synthetic */ C0235b(byte b) {
            this();
        }

        @Override // com.tencent.bugly.crashreport.crash.b.a
        public final boolean a() {
            return com.tencent.bugly.crashreport.crash.c.a().r();
        }

        private C0235b() {
            super(3, (byte) 0);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends a {
        public /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.tencent.bugly.crashreport.crash.b.a
        public final boolean a() {
            return true;
        }

        private c() {
            super(7, (byte) 0);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends a {
        public /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.tencent.bugly.crashreport.crash.b.a
        public final boolean a() {
            return true;
        }

        private d() {
            super(2, (byte) 0);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends a {
        public /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.tencent.bugly.crashreport.crash.b.a
        public final boolean a() {
            return com.tencent.bugly.crashreport.crash.c.a().q();
        }

        private e() {
            super(0, (byte) 0);
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends a {
        public /* synthetic */ f(byte b) {
            this();
        }

        @Override // com.tencent.bugly.crashreport.crash.b.a
        public final boolean a() {
            return com.tencent.bugly.crashreport.crash.c.a().t();
        }

        private f() {
            super(5, (byte) 0);
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends a {
        public /* synthetic */ g(byte b) {
            this();
        }

        @Override // com.tencent.bugly.crashreport.crash.b.a
        public final boolean a() {
            return com.tencent.bugly.crashreport.crash.c.a().u();
        }

        private g() {
            super(6, (byte) 0);
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends a {
        public /* synthetic */ h(byte b) {
            this();
        }

        @Override // com.tencent.bugly.crashreport.crash.b.a
        public final boolean a() {
            return com.tencent.bugly.crashreport.crash.c.a().q();
        }

        private h() {
            super(1, (byte) 0);
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends a {
        public /* synthetic */ i(byte b) {
            this();
        }

        @Override // com.tencent.bugly.crashreport.crash.b.a
        public final boolean a() {
            return com.tencent.bugly.crashreport.crash.c.a().s();
        }

        private i() {
            super(4, (byte) 0);
        }
    }

    public b(int i2, Context context, v vVar, o oVar, com.tencent.bugly.crashreport.common.strategy.a aVar, BuglyStrategy.a aVar2, n nVar) {
        a = i2;
        this.b = context;
        this.f6592c = vVar;
        this.f6593d = aVar;
        this.f6595f = aVar2;
        this.f6594e = nVar;
    }

    public static /* synthetic */ void a(b bVar, List list, boolean z, long j2, String str, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
            String str3 = f6591k.get(Integer.valueOf(crashDetailBean.b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new t.c(crashDetailBean.f6551c, str3, crashDetailBean.r, z, j2, str, str2));
            }
        }
        t.a().a(arrayList);
    }

    private static void b(CrashDetailBean crashDetailBean, List<com.tencent.bugly.crashreport.crash.a> list) {
        StringBuilder sb = new StringBuilder(64);
        for (com.tencent.bugly.crashreport.crash.a aVar : list) {
            if (!aVar.f6564e && !aVar.f6563d) {
                String str = crashDetailBean.s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aVar.b);
                if (!str.contains(sb2.toString())) {
                    crashDetailBean.t++;
                    sb.append(aVar.b);
                    sb.append("\n");
                }
            }
        }
        crashDetailBean.s += sb.toString();
    }

    private static ContentValues f(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = crashDetailBean.a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            int i2 = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f6552d ? 1 : 0));
            if (!crashDetailBean.f6558j) {
                i2 = 0;
            }
            contentValues.put("_me", Integer.valueOf(i2));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f6560l));
            contentValues.put("_dt", ab.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static String g(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = f6587g.get(Integer.valueOf(crashDetailBean.b));
            if (pair == null) {
                y.e("crash type error! %d", Integer.valueOf(crashDetailBean.b));
                return "";
            } else if (crashDetailBean.f6558j) {
                return (String) pair.first;
            } else {
                return (String) pair.second;
            }
        } catch (Exception e2) {
            y.a(e2);
            return "";
        }
    }

    private static ArrayList<ai> h(CrashDetailBean crashDetailBean) {
        Map<String, PlugInBean> map = crashDetailBean.f6556h;
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList<ai> arrayList = new ArrayList<>(crashDetailBean.f6556h.size());
        for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f6556h.entrySet()) {
            ai aiVar = new ai();
            aiVar.a = entry.getValue().a;
            aiVar.b = entry.getValue().f6518c;
            aiVar.f6682c = entry.getValue().b;
            arrayList.add(aiVar);
        }
        return arrayList;
    }

    public final void c(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3 && !com.tencent.bugly.crashreport.crash.c.a().r()) {
                    return;
                }
            } else if (!com.tencent.bugly.crashreport.crash.c.a().q()) {
                return;
            }
        } else if (!com.tencent.bugly.crashreport.crash.c.a().q()) {
            return;
        }
        if (this.f6594e != null) {
            y.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            int i3 = crashDetailBean.b;
        }
    }

    public final void d(CrashDetailBean crashDetailBean) {
        boolean z;
        Map<String, String> onCrashHandleStart;
        if (crashDetailBean == null) {
            return;
        }
        if (this.f6595f == null && this.f6594e == null) {
            return;
        }
        Iterator<a> it = f6588h.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (a.a(next, crashDetailBean)) {
                z = next.a();
                break;
            }
        }
        if (!z) {
            y.c("Should not call back.", new Object[0]);
            return;
        }
        try {
            Map<Integer, Integer> map = f6589i;
            if (!map.containsKey(Integer.valueOf(crashDetailBean.b))) {
                y.d("Cannot get crash type for crashBean type:" + crashDetailBean.b, new Object[0]);
                return;
            }
            int intValue = map.get(Integer.valueOf(crashDetailBean.b)).intValue();
            int i2 = crashDetailBean.b;
            byte[] bArr = null;
            if (this.f6594e != null) {
                y.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                y.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                n nVar = this.f6594e;
                String str = crashDetailBean.n;
                String str2 = crashDetailBean.p;
                String str3 = crashDetailBean.q;
                long j2 = crashDetailBean.r;
                String b = nVar.b();
                if (b != null) {
                    onCrashHandleStart = new HashMap<>(1);
                    onCrashHandleStart.put("userData", b);
                }
                onCrashHandleStart = null;
            } else {
                if (this.f6595f != null) {
                    y.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                    onCrashHandleStart = this.f6595f.onCrashHandleStart(intValue, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
                }
                onCrashHandleStart = null;
            }
            a(crashDetailBean, onCrashHandleStart);
            y.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
            if (this.f6594e != null) {
                y.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                n nVar2 = this.f6594e;
                String str4 = crashDetailBean.n;
                String str5 = crashDetailBean.p;
                String str6 = crashDetailBean.q;
                long j3 = crashDetailBean.r;
                bArr = nVar2.a();
            } else if (this.f6595f != null) {
                y.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                bArr = this.f6595f.onCrashHandleStart2GetExtraDatas(intValue, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
            }
            if (bArr == null) {
                y.d("extra user byte is null. CrashBean won't have userExtraByteDatas.", new Object[0]);
            } else {
                if (bArr.length <= 100000) {
                    crashDetailBean.X = bArr;
                } else {
                    y.d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArr.length), 100000);
                    crashDetailBean.X = Arrays.copyOf(bArr, 100000);
                }
                y.a("add extra bytes %d ", Integer.valueOf(bArr.length));
            }
            if (this.f6594e != null) {
                y.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
                n nVar3 = this.f6594e;
                String str7 = crashDetailBean.n;
                String str8 = crashDetailBean.o;
                String str9 = crashDetailBean.p;
                String str10 = crashDetailBean.q;
                long j4 = crashDetailBean.r;
                String str11 = crashDetailBean.f6561m;
                String str12 = crashDetailBean.f6553e;
                String str13 = crashDetailBean.f6551c;
                String str14 = crashDetailBean.A;
                String str15 = crashDetailBean.B;
                if (nVar3.c()) {
                    return;
                }
                y.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
            }
        } catch (Throwable th) {
            y.d("crash handle callback something wrong! %s", th.getClass().getName());
            if (y.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void e(CrashDetailBean crashDetailBean) {
        ContentValues f2;
        if (crashDetailBean == null || (f2 = f(crashDetailBean)) == null) {
            return;
        }
        long a2 = o.a().a("t_cr", f2, (n) null, true);
        if (a2 >= 0) {
            y.c("insert %s success!", "t_cr");
            crashDetailBean.a = a2;
        }
    }

    private static List<com.tencent.bugly.crashreport.crash.a> a(List<com.tencent.bugly.crashreport.crash.a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.tencent.bugly.crashreport.crash.a aVar : list) {
            if (aVar.f6563d && aVar.b <= currentTimeMillis - 86400000) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private static void e(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or _id");
                    sb.append(" = ");
                    sb.append(crashDetailBean.a);
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    sb2 = sb2.substring(4);
                }
                sb.setLength(0);
                y.c("deleted %s data %d", "t_cr", Integer.valueOf(o.a().a("t_cr", sb2, (String[]) null, (n) null, true)));
            } catch (Throwable th) {
                if (y.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    private List<CrashDetailBean> c(List<com.tencent.bugly.crashreport.crash.a> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        for (com.tencent.bugly.crashreport.crash.a aVar : list) {
            sb.append(aVar.a);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        }
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            cursor = o.a().a("t_cr", null, sb2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append("_id in ");
                sb.append("(");
                int i2 = 0;
                while (cursor.moveToNext()) {
                    CrashDetailBean a2 = a(cursor);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        sb.append(cursor.getLong(cursor.getColumnIndex("_id")));
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        i2++;
                    }
                }
                if (sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                }
                sb.append(")");
                String sb3 = sb.toString();
                if (i2 > 0) {
                    y.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(o.a().a("t_cr", sb3, (String[]) null, (n) null, true)));
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

    /* JADX WARN: Removed duplicated region for block: B:68:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(com.tencent.bugly.crashreport.crash.CrashDetailBean r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.b(com.tencent.bugly.crashreport.crash.CrashDetailBean):boolean");
    }

    private CrashDetailBean a(List<com.tencent.bugly.crashreport.crash.a> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> c2;
        if (list == null || list.isEmpty()) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (com.tencent.bugly.crashreport.crash.a aVar : list) {
            if (aVar.f6564e) {
                arrayList.add(aVar);
            }
        }
        if (!arrayList.isEmpty() && (c2 = c(arrayList)) != null && !c2.isEmpty()) {
            Collections.sort(c2);
            crashDetailBean2 = c2.get(0);
            a(crashDetailBean2, c2);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f6558j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        b(crashDetailBean2, list);
        if (crashDetailBean2.r != crashDetailBean.r) {
            String str = crashDetailBean2.s;
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.r);
            if (!str.contains(sb.toString())) {
                crashDetailBean2.t++;
                crashDetailBean2.s += crashDetailBean.r + "\n";
            }
        }
        return crashDetailBean2;
    }

    private static void d(List<com.tencent.bugly.crashreport.crash.a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        for (com.tencent.bugly.crashreport.crash.a aVar : list) {
            sb.append(aVar.a);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            y.c("deleted %s data %d", "t_cr", Integer.valueOf(o.a().a("t_cr", sb3, (String[]) null, (n) null, true)));
        } catch (Throwable th) {
            if (y.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] split;
        StringBuilder sb = new StringBuilder(128);
        for (int i2 = 1; i2 < list.size(); i2++) {
            String str = list.get(i2).s;
            if (str != null && (split = str.split("\n")) != null) {
                for (String str2 : split) {
                    if (!crashDetailBean.s.contains(str2)) {
                        crashDetailBean.t++;
                        sb.append(str2);
                        sb.append("\n");
                    }
                }
            }
        }
        crashDetailBean.s += sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0036, code lost:
        if (r0.size() >= com.tencent.bugly.crashreport.crash.c.f6598c) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(com.tencent.bugly.crashreport.crash.CrashDetailBean r9, java.util.List<com.tencent.bugly.crashreport.crash.a> r10, java.util.List<com.tencent.bugly.crashreport.crash.a> r11) {
        /*
            r8 = this;
            int r0 = r9.b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r3 = 0
            goto Lc
        Lb:
            r3 = 1
        Lc:
            r4 = 3
            if (r0 != r4) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            boolean r4 = com.tencent.bugly.b.f6489c
            if (r4 != 0) goto L1f
            if (r0 != 0) goto L1c
            if (r3 != 0) goto L1c
            r0 = 1
            goto L20
        L1c:
            boolean r0 = com.tencent.bugly.crashreport.crash.c.f6599d
            goto L20
        L1f:
            r0 = 0
        L20:
            if (r0 != 0) goto L23
            return r2
        L23:
            java.util.ArrayList r0 = new java.util.ArrayList
            r3 = 10
            r0.<init>(r3)
            boolean r10 = a(r9, r10, r0)
            if (r10 != 0) goto L38
            int r10 = r0.size()     // Catch: java.lang.Exception -> L6d
            int r3 = com.tencent.bugly.crashreport.crash.c.f6598c     // Catch: java.lang.Exception -> L6d
            if (r10 < r3) goto L78
        L38:
            java.lang.String r10 = "same crash occur too much do merged!"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.proguard.y.a(r10, r3)     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.crashreport.crash.CrashDetailBean r9 = r8.a(r0, r9)     // Catch: java.lang.Exception -> L6d
            java.util.Iterator r10 = r0.iterator()     // Catch: java.lang.Exception -> L6d
        L47:
            boolean r0 = r10.hasNext()     // Catch: java.lang.Exception -> L6d
            if (r0 == 0) goto L5f
            java.lang.Object r0 = r10.next()     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.crashreport.crash.a r0 = (com.tencent.bugly.crashreport.crash.a) r0     // Catch: java.lang.Exception -> L6d
            long r3 = r0.a     // Catch: java.lang.Exception -> L6d
            long r5 = r9.a     // Catch: java.lang.Exception -> L6d
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L47
            r11.add(r0)     // Catch: java.lang.Exception -> L6d
            goto L47
        L5f:
            r8.e(r9)     // Catch: java.lang.Exception -> L6d
            d(r11)     // Catch: java.lang.Exception -> L6d
            java.lang.String r9 = "[crash] save crash success. For this device crash many times, it will not upload crashes immediately"
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.proguard.y.b(r9, r10)     // Catch: java.lang.Exception -> L6d
            return r1
        L6d:
            r9 = move-exception
            com.tencent.bugly.proguard.y.a(r9)
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r10 = "Failed to merge crash."
            com.tencent.bugly.proguard.y.d(r10, r9)
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.b(com.tencent.bugly.crashreport.crash.CrashDetailBean, java.util.List, java.util.List):boolean");
    }

    public final boolean a(CrashDetailBean crashDetailBean) {
        return b(crashDetailBean);
    }

    private static boolean a(String str) {
        String str2 = com.tencent.bugly.crashreport.crash.c.o;
        if (str2 != null && !str2.isEmpty()) {
            try {
                y.c("Crash regular filter for crash stack is: %s", com.tencent.bugly.crashreport.crash.c.o);
                if (Pattern.compile(com.tencent.bugly.crashreport.crash.c.o).matcher(str).find()) {
                    y.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e2) {
                y.a(e2);
                y.d("Failed to compile " + com.tencent.bugly.crashreport.crash.c.o, new Object[0]);
            }
        }
        return false;
    }

    private void b(List<com.tencent.bugly.crashreport.crash.a> list) {
        List<CrashDetailBean> c2 = c(list);
        if (c2 == null || c2.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : c2) {
            String str = f6591k.get(Integer.valueOf(crashDetailBean.b));
            if (!TextUtils.isEmpty(str)) {
                y.c("find expired data,crashId:%s eventType:%s", crashDetailBean.f6551c, str);
                arrayList.add(new t.c(crashDetailBean.f6551c, str, crashDetailBean.r, false, 0L, "expired", null));
            }
        }
        t.a().a(arrayList);
    }

    private static void c(ArrayList<ak> arrayList, String str) {
        if (ab.a(str)) {
            return;
        }
        try {
            ak akVar = new ak((byte) 1, "crashInfos.txt", str.getBytes(com.qiniu.android.common.Constants.UTF_8));
            y.c("attach crash infos", new Object[0]);
            arrayList.add(akVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            y.a(e2);
        }
    }

    private static boolean a(CrashDetailBean crashDetailBean, List<com.tencent.bugly.crashreport.crash.a> list, List<com.tencent.bugly.crashreport.crash.a> list2) {
        boolean z = false;
        for (com.tencent.bugly.crashreport.crash.a aVar : list) {
            if (crashDetailBean.u.equals(aVar.f6562c)) {
                if (aVar.f6564e) {
                    z = true;
                }
                list2.add(aVar);
            }
        }
        return z;
    }

    public final List<CrashDetailBean> a() {
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (c2 == null) {
            y.d("have not synced remote!", new Object[0]);
            return null;
        } else if (!c2.f6533e) {
            y.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            y.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b = ab.b();
            List<com.tencent.bugly.crashreport.crash.a> b2 = b();
            y.c("Size of crash list loaded from DB: %s", Integer.valueOf(b2.size()));
            if (b2 == null || b2.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<com.tencent.bugly.crashreport.crash.a> arrayList2 = new ArrayList<>();
            arrayList.addAll(a(b2));
            b2.removeAll(arrayList);
            Iterator<com.tencent.bugly.crashreport.crash.a> it = b2.iterator();
            while (it.hasNext()) {
                com.tencent.bugly.crashreport.crash.a next = it.next();
                long j2 = next.b;
                if (j2 < b - com.tencent.bugly.crashreport.crash.c.f6602g) {
                    arrayList2.add(next);
                    it.remove();
                    arrayList.add(next);
                } else if (next.f6563d) {
                    if (j2 >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!next.f6564e) {
                        it.remove();
                        arrayList.add(next);
                    }
                } else if (next.f6565f >= 3 && j2 < currentTimeMillis - 86400000) {
                    it.remove();
                    arrayList.add(next);
                }
            }
            b(arrayList2);
            if (arrayList.size() > 0) {
                d(arrayList);
            }
            ArrayList arrayList3 = new ArrayList();
            List<CrashDetailBean> c3 = c(b2);
            if (c3 != null && c3.size() > 0) {
                String str = com.tencent.bugly.crashreport.common.info.a.b().f6525i;
                Iterator<CrashDetailBean> it2 = c3.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f6554f)) {
                        it2.remove();
                        arrayList3.add(next2);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                e(arrayList3);
            }
            return c3;
        }
    }

    private static com.tencent.bugly.crashreport.crash.a b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            com.tencent.bugly.crashreport.crash.a aVar = new com.tencent.bugly.crashreport.crash.a();
            aVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            aVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.f6562c = cursor.getString(cursor.getColumnIndex("_s1"));
            aVar.f6563d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            aVar.f6564e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            aVar.f6565f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private List<com.tencent.bugly.crashreport.crash.a> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a2 = o.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                }
                return null;
            }
            try {
                if (a2.getCount() <= 0) {
                    if (a2 != null) {
                        a2.close();
                    }
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("_id in ");
                sb.append("(");
                int i2 = 0;
                while (a2.moveToNext()) {
                    com.tencent.bugly.crashreport.crash.a b = b(a2);
                    if (b != null) {
                        arrayList.add(b);
                    } else {
                        sb.append(a2.getLong(a2.getColumnIndex("_id")));
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        i2++;
                    }
                }
                if (sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                }
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                if (i2 > 0) {
                    y.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(o.a().a("t_cr", sb2, (String[]) null, (n) null, true)));
                }
                if (a2 != null) {
                    a2.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = a2;
                try {
                    if (!y.a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void b(ArrayList<ak> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new ak((byte) 1, "jniLog.txt", str.getBytes(com.qiniu.android.common.Constants.UTF_8)));
            } catch (Exception e2) {
                e2.printStackTrace();
                y.a(e2);
            }
        }
    }

    private static void b(ArrayList<ak> arrayList, CrashDetailBean crashDetailBean, Context context) {
        String str;
        if (crashDetailBean.b == 1 && (str = crashDetailBean.v) != null) {
            try {
                ak a2 = a("tomb.zip", context, str);
                if (a2 != null) {
                    y.c("attach tombs", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e2) {
                y.a(e2);
            }
        }
    }

    public final void a(CrashDetailBean crashDetailBean, long j2, boolean z) {
        if (com.tencent.bugly.crashreport.crash.c.f6607l) {
            y.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, 3000L, z, crashDetailBean.b == 7, z);
            return;
        }
        y.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    private static void b(ArrayList<ak> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            arrayList.add(new ak((byte) 1, "userExtraByteData", bArr));
            y.c("attach extraData", new Object[0]);
        } catch (Exception e2) {
            y.a(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x0251 A[Catch: all -> 0x02a3, TryCatch #0 {all -> 0x02a3, blocks: (B:109:0x0057, B:112:0x0066, B:116:0x0070, B:117:0x0080, B:119:0x0086, B:124:0x0096, B:126:0x0117, B:127:0x011b, B:129:0x012c, B:131:0x0132, B:132:0x014c, B:136:0x01fb, B:138:0x0239, B:137:0x022f, B:142:0x0251, B:144:0x0259, B:146:0x025f, B:148:0x0268, B:150:0x0272, B:152:0x027b, B:154:0x028d, B:155:0x0299, B:140:0x0246), top: B:164:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0259 A[Catch: all -> 0x02a3, TryCatch #0 {all -> 0x02a3, blocks: (B:109:0x0057, B:112:0x0066, B:116:0x0070, B:117:0x0080, B:119:0x0086, B:124:0x0096, B:126:0x0117, B:127:0x011b, B:129:0x012c, B:131:0x0132, B:132:0x014c, B:136:0x01fb, B:138:0x0239, B:137:0x022f, B:142:0x0251, B:144:0x0259, B:146:0x025f, B:148:0x0268, B:150:0x0272, B:152:0x027b, B:154:0x028d, B:155:0x0299, B:140:0x0246), top: B:164:0x0057 }] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.tencent.bugly.proguard.aj, com.tencent.bugly.proguard.ai] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> r20, long r21, final boolean r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.a(java.util.List, long, boolean, boolean, boolean):void");
    }

    public static void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            y.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                y.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f6551c, Integer.valueOf(crashDetailBean.f6560l), Boolean.valueOf(crashDetailBean.f6552d), Boolean.valueOf(crashDetailBean.f6558j));
                int i2 = crashDetailBean.f6560l + 1;
                crashDetailBean.f6560l = i2;
                crashDetailBean.f6552d = z;
                y.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f6551c, Integer.valueOf(i2), Boolean.valueOf(crashDetailBean.f6552d), Boolean.valueOf(crashDetailBean.f6558j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                com.tencent.bugly.crashreport.crash.c.a().a(crashDetailBean2);
            }
            y.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        y.b("[crash] upload fail.", new Object[0]);
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ab.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ak a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            y.c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!ab.a(file, file2, 5000)) {
                y.d("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                y.c("read bytes :%d", Integer.valueOf(byteArray.length));
                ak akVar = new ak((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    if (!y.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    y.c("del tmp", new Object[0]);
                    file2.delete();
                }
                return akVar;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!y.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (!y.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        y.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            if (!y.a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        y.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th3;
                }
            }
        }
        y.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
        if (b == null) {
            return;
        }
        y.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        y.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        y.e("# PKG NAME: %s", b.f6519c);
        y.e("# APP VER: %s", b.f6525i);
        y.e("# SDK VER: %s", b.f6522f);
        y.e("# LAUNCH TIME: %s", ab.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().a)));
        y.e("# CRASH TYPE: %s", str);
        y.e("# CRASH TIME: %s", str2);
        y.e("# CRASH PROCESS: %s", str3);
        y.e("# CRASH FOREGROUND: %s", Boolean.valueOf(b.a()));
        y.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            y.e("# REPORT ID: %s", crashDetailBean.f6551c);
            Object[] objArr = new Object[2];
            objArr[0] = b.l();
            objArr[1] = b.v().booleanValue() ? "ROOTED" : "UNROOT";
            y.e("# CRASH DEVICE: %s %s", objArr);
            y.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            y.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!ab.a(crashDetailBean.N)) {
                y.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.N, crashDetailBean.M);
            } else if (crashDetailBean.b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.S == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.S.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                y.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!ab.a(str5)) {
            y.e("# CRASH STACK: ", new Object[0]);
            y.e(str5, new Object[0]);
        }
        y.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    private static void a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String value;
        if (map != null && !map.isEmpty()) {
            crashDetailBean.R = new LinkedHashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!ab.a(entry.getKey())) {
                    String key = entry.getKey();
                    if (key.length() > 100) {
                        key = key.substring(0, 100);
                        y.d("setted key length is over limit %d substring to %s", 100, key);
                    }
                    if (!ab.a(entry.getValue()) && entry.getValue().length() > 100000) {
                        value = entry.getValue().substring(entry.getValue().length() - 100000);
                        y.d("setted %s value length is over limit %d substring", key, 100000);
                    } else {
                        value = entry.getValue();
                    }
                    crashDetailBean.R.put(key, value);
                    y.a("add setted key %s value size:%d", key, Integer.valueOf(value.length()));
                }
            }
            return;
        }
        y.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
    }

    private static void a(ArrayList<ak> arrayList, CrashDetailBean crashDetailBean) {
        String str;
        if (crashDetailBean.f6558j && (str = crashDetailBean.s) != null && str.length() > 0) {
            try {
                arrayList.add(new ak((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes(com.qiniu.android.common.Constants.UTF_8)));
            } catch (Exception e2) {
                e2.printStackTrace();
                y.a(e2);
            }
        }
    }

    private static void a(ArrayList<ak> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new ak((byte) 1, "log.txt", str.getBytes(com.qiniu.android.common.Constants.UTF_8)));
            } catch (Exception e2) {
                e2.printStackTrace();
                y.a(e2);
            }
        }
    }

    private static void a(ArrayList<ak> arrayList, String str, Context context) {
        if (str != null) {
            try {
                ak a2 = a("backupRecord.zip", context, str);
                if (a2 != null) {
                    y.c("attach backup record", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e2) {
                y.a(e2);
            }
        }
    }

    private static void a(ArrayList<ak> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            ak akVar = new ak((byte) 2, "buglylog.zip", bArr);
            y.c("attach user log", new Object[0]);
            arrayList.add(akVar);
        } catch (Exception e2) {
            y.a(e2);
        }
    }

    private static void a(ArrayList<ak> arrayList, CrashDetailBean crashDetailBean, Context context) {
        ak a2;
        if (crashDetailBean.b != 3) {
            return;
        }
        y.c("crashBean.anrMessages:%s", crashDetailBean.S);
        try {
            Map<String, String> map = crashDetailBean.S;
            if (map != null && map.containsKey("BUGLY_CR_01")) {
                if (!TextUtils.isEmpty(crashDetailBean.S.get("BUGLY_CR_01"))) {
                    arrayList.add(new ak((byte) 1, "anrMessage.txt", crashDetailBean.S.get("BUGLY_CR_01").getBytes(com.qiniu.android.common.Constants.UTF_8)));
                    y.c("attach anr message", new Object[0]);
                }
                crashDetailBean.S.remove("BUGLY_CR_01");
            }
            String str = crashDetailBean.v;
            if (str == null || (a2 = a("trace.zip", context, str)) == null) {
                return;
            }
            y.c("attach traces", new Object[0]);
            arrayList.add(a2);
        } catch (Exception e2) {
            e2.printStackTrace();
            y.a(e2);
        }
    }

    private static void a(ArrayList<ak> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        try {
            arrayList.add(new ak((byte) 1, "martianlog.txt", sb.toString().getBytes(com.qiniu.android.common.Constants.UTF_8)));
            y.c("attach pageTracingList", new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static Map<String, String> a(CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        HashMap hashMap = new HashMap(30);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.C);
            hashMap.put("A9", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.D);
            hashMap.put("A11", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.E);
            hashMap.put("A10", sb3.toString());
            hashMap.put("A23", crashDetailBean.f6554f);
            StringBuilder sb4 = new StringBuilder();
            aVar.getClass();
            hashMap.put("A7", sb4.toString());
            hashMap.put("A6", com.tencent.bugly.crashreport.common.info.a.r());
            hashMap.put("A5", aVar.q());
            hashMap.put("A22", aVar.k());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.G);
            hashMap.put("A2", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.F);
            hashMap.put("A1", sb6.toString());
            hashMap.put("A24", aVar.f6523g);
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.H);
            hashMap.put("A17", sb7.toString());
            hashMap.put("A25", aVar.k());
            hashMap.put("A15", aVar.u());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(aVar.v());
            hashMap.put("A13", sb8.toString());
            hashMap.put("A34", crashDetailBean.A);
            if (aVar.w != null) {
                hashMap.put("productIdentify", aVar.w);
            }
            hashMap.put("A26", URLEncoder.encode(crashDetailBean.L, com.qiniu.android.common.Constants.UTF_8));
            boolean z = true;
            if (crashDetailBean.b == 1) {
                hashMap.put("A27", crashDetailBean.N);
                hashMap.put("A28", crashDetailBean.M);
                StringBuilder sb9 = new StringBuilder();
                sb9.append(crashDetailBean.f6559k);
                hashMap.put("A29", sb9.toString());
            }
            hashMap.put("A30", crashDetailBean.O);
            StringBuilder sb10 = new StringBuilder();
            sb10.append(crashDetailBean.P);
            hashMap.put("A18", sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            if (crashDetailBean.Q) {
                z = false;
            }
            sb11.append(z);
            hashMap.put("A36", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(aVar.p);
            hashMap.put("F02", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(aVar.q);
            hashMap.put("F03", sb13.toString());
            hashMap.put("F04", aVar.e());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(aVar.r);
            hashMap.put("F05", sb14.toString());
            hashMap.put("F06", aVar.o);
            hashMap.put("F08", aVar.u);
            hashMap.put("F09", aVar.v);
            StringBuilder sb15 = new StringBuilder();
            sb15.append(aVar.s);
            hashMap.put("F10", sb15.toString());
            a(hashMap, crashDetailBean);
        } catch (Exception e2) {
            e2.printStackTrace();
            y.a(e2);
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.T >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.T);
            map.put("C01", sb.toString());
        }
        if (crashDetailBean.U >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.U);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = crashDetailBean.V;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.V.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.W;
        if (map3 == null || map3.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.W.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }
}
