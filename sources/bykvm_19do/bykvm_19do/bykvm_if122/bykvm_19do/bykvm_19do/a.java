package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.y;
import cn.thinkingdata.android.TDConfig;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.base.TTBaseAd;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    private int a;
    private int b;

    /* renamed from: f  reason: collision with root package name */
    private RewardItem f697f;

    /* renamed from: l  reason: collision with root package name */
    private AdSlot f703l;

    /* renamed from: m  reason: collision with root package name */
    private TTBaseAd f704m;
    private long n;
    private String o;
    private i p;

    /* renamed from: c  reason: collision with root package name */
    private boolean f694c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f695d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f696e = -1;

    /* renamed from: g  reason: collision with root package name */
    private boolean f698g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f699h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f700i = true;

    /* renamed from: j  reason: collision with root package name */
    private int f701j = -1;

    /* renamed from: k  reason: collision with root package name */
    private String f702k = "";

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0026a implements Runnable {
        public RunnableC0026a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f695d = true;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f694c = true;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0027a implements Runnable {

            /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0028a implements RewardItem {
                public C0028a() {
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public float getAmount() {
                    if (a.this.f703l != null) {
                        return a.this.f703l.getRewardAmount();
                    }
                    return 0.0f;
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public Map<String, Object> getCustomData() {
                    HashMap hashMap = new HashMap();
                    hashMap.put(RewardItem.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
                    hashMap.put("transId", a.this.o);
                    hashMap.put(RewardItem.KEY_REASON, 0);
                    hashMap.put("gromoreExtra", (a.this.f703l == null || a.this.f703l.getCustomData() == null) ? "" : a.this.f703l.getCustomData().get("gromoreExtra"));
                    hashMap.put(RewardItem.KEY_ERROR_CODE, Integer.valueOf(a.this.f701j));
                    hashMap.put(RewardItem.KEY_ERROR_MSG, a.this.f702k);
                    return hashMap;
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public String getRewardName() {
                    return a.this.f703l != null ? a.this.f703l.getRewardName() : "";
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public boolean rewardVerify() {
                    return false;
                }
            }

            public RunnableC0027a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f694c) {
                    Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，已经destroy了, 直接return");
                } else if (a.this.p == null || a.this.f699h) {
                } else {
                    Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，给开发者verify回调");
                    a.this.f699h = true;
                    RewardItem c0028a = new C0028a();
                    i iVar = a.this.p;
                    if (a.this.f697f != null) {
                        c0028a = a.this.f697f;
                    }
                    iVar.onRewardVerify(c0028a);
                }
            }
        }

        public c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
            if (r7.a.f700i != false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
            r7.a.h();
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
            com.bytedance.msdk.adapter.util.Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
            if (r7.a.f700i != false) goto L20;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r7 = this;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.b(r0)
                java.lang.String r1 = "GROMORE_SS_REWARD_VERIFY"
                if (r0 == 0) goto L11
                java.lang.String r0 = "--==-- verify回调进来，已经destroy, 直接return"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                goto La0
            L11:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                r2 = 1
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.c(r0, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                com.bytedance.msdk.api.reward.RewardItem r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.f(r0)
                if (r0 == 0) goto L49
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$i r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.g(r0)
                if (r0 == 0) goto La0
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.h(r0)
                if (r0 != 0) goto La0
                java.lang.String r0 = "--==-- verify回调进来，已经有结果，直接给开发者回调"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.d(r0, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$i r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.g(r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                com.bytedance.msdk.api.reward.RewardItem r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.f(r1)
                r0.onRewardVerify(r1)
                goto La0
            L49:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i(r0)
                r4 = -1
                java.lang.String r0 = "--==-- verify回调进来准备请求，但是不能重试"
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L77
                java.lang.String r2 = "--==-- verify回调进来，先进来发起请求"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r3 = android.os.SystemClock.elapsedRealtime()
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.a(r2, r3)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.j(r2)
                if (r2 == 0) goto L73
            L6d:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.k(r0)
                goto L96
            L73:
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                goto L96
            L77:
                long r2 = android.os.SystemClock.elapsedRealtime()
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i(r4)
                long r2 = r2 - r4
                r4 = 2000(0x7d0, double:9.88E-321)
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 <= 0) goto L96
                java.lang.String r2 = "--==-- verify回调进来，后进来但大于2s，发起请求"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.j(r2)
                if (r2 == 0) goto L73
                goto L6d
            L96:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$c$a r0 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$c$a
                r0.<init>()
                r1 = 3000(0xbb8, double:1.482E-320)
                com.bytedance.msdk.adapter.util.ThreadHelper.postDelayOnMSDKThread(r0, r1)
            La0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.c.run():void");
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
            if (r7.a.f700i != false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
            r7.a.h();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
            if (r7.a.f700i != false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r7 = this;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.b(r0)
                java.lang.String r1 = "GROMORE_SS_REWARD_VERIFY"
                if (r0 == 0) goto L11
                java.lang.String r0 = "--==-- complete回调进来，已经destroy, 直接return"
            Lc:
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                goto L9c
            L11:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                com.bytedance.msdk.api.reward.RewardItem r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.f(r0)
                if (r0 != 0) goto L6b
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.h(r0)
                if (r0 == 0) goto L22
                goto L6b
            L22:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i(r0)
                r4 = -1
                java.lang.String r0 = "--==-- complete回调进来准备请求，但是不能重试"
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L4c
                java.lang.String r2 = "--==-- complete回调进来，先进来发起请求"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r3 = android.os.SystemClock.elapsedRealtime()
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.a(r2, r3)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.j(r2)
                if (r2 == 0) goto Lc
            L46:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.k(r0)
                goto L9c
            L4c:
                long r2 = android.os.SystemClock.elapsedRealtime()
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i(r4)
                long r2 = r2 - r4
                r4 = 2000(0x7d0, double:9.88E-321)
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 <= 0) goto L9c
                java.lang.String r2 = "--==-- complete回调进来，后进来但大于2s，发起请求"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.j(r2)
                if (r2 == 0) goto Lc
                goto L46
            L6b:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "--==-- complete回调进来，已经有响应("
                r0.append(r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                com.bytedance.msdk.api.reward.RewardItem r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.f(r2)
                if (r2 == 0) goto L7f
                r2 = 1
                goto L80
            L7f:
                r2 = 0
            L80:
                r0.append(r2)
                java.lang.String r2 = ")或已经给出开发者回调("
                r0.append(r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.h(r2)
                r0.append(r2)
                java.lang.String r2 = "), 直接return"
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                goto Lc
            L9c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.d.run():void");
        }
    }

    /* loaded from: classes.dex */
    public class e implements RewardItem {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f705c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f706d;

        public e(boolean z, int i2, String str, int i3) {
            this.a = z;
            this.b = i2;
            this.f705c = str;
            this.f706d = i3;
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public float getAmount() {
            return this.b;
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public Map<String, Object> getCustomData() {
            HashMap hashMap = new HashMap();
            hashMap.put(RewardItem.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
            hashMap.put("transId", a.this.o);
            hashMap.put(RewardItem.KEY_REASON, Integer.valueOf(this.f706d));
            hashMap.put("gromoreExtra", (a.this.f703l == null || a.this.f703l.getCustomData() == null) ? "" : a.this.f703l.getCustomData().get("gromoreExtra"));
            hashMap.put(RewardItem.KEY_ERROR_CODE, Integer.valueOf(a.this.f701j));
            hashMap.put(RewardItem.KEY_ERROR_MSG, a.this.f702k);
            return hashMap;
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public String getRewardName() {
            return this.f705c;
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public boolean rewardVerify() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f696e != -1 || a.this.f694c || a.this.f695d) {
                Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，已经destroy，或者skip，或者比complete/verify回调还晚，直接return");
                return;
            }
            Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，发起请求");
            a.this.h();
            ThreadHelper.postDelayOnMSDKThread(new h(1), 3000L);
            ThreadHelper.postDelayOnMSDKThread(new h(2), 6000L);
            ThreadHelper.postDelayOnMSDKThread(new h(3), 9000L);
        }
    }

    /* loaded from: classes.dex */
    public class g extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0029a implements Runnable {
            public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b a;

            public RunnableC0029a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(this.a);
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public final /* synthetic */ IOException a;

            public b(g gVar, IOException iOException) {
                this.a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify http error: " + this.a.toString());
            }
        }

        public g() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b bVar2) {
            ThreadHelper.runOnMSDKThread(new RunnableC0029a(bVar2));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, IOException iOException) {
            ThreadHelper.runOnMSDKThread(new b(this, iOException));
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        private final int a;

        public h(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f697f != null || a.this.f699h || !a.this.f700i || a.this.f694c || a.this.f695d) {
                return;
            }
            Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide reward verify 进行第" + this.a + "次重试请求");
            a.this.h();
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void onRewardVerify(RewardItem rewardItem);
    }

    public a(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c2;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d f2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f();
        if (f2 != null && (c2 = f2.c(str)) != null) {
            this.a = c2.w();
            this.b = c2.v();
        }
        if (this.a < 0) {
            this.a = TDConfig.DEFAULT_FLUSH_INTERVAL;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7 A[Catch: JSONException -> 0x0133, TryCatch #3 {JSONException -> 0x0133, blocks: (B:8:0x0011, B:10:0x003f, B:11:0x0043, B:15:0x004e, B:17:0x0076, B:21:0x0080, B:42:0x00d7, B:44:0x0114, B:46:0x0118, B:48:0x011c, B:28:0x00ad, B:34:0x00c4, B:23:0x008a), top: B:59:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b r13) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b):void");
    }

    private String f() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", "3.7.0.2");
            jSONObject.put("user_agent", e.c.c.a.b.b);
            jSONObject.put("network", y.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
            jSONObject.put("play_start_ts", this.n);
            jSONObject.put("play_end_ts", System.currentTimeMillis());
            AdSlot adSlot = this.f703l;
            String str2 = "";
            jSONObject.put("user_id", adSlot != null ? adSlot.getUserID() : "");
            if (TextUtils.isEmpty(this.o)) {
                str = UUID.randomUUID().toString();
                this.o = str;
            } else {
                str = this.o;
            }
            jSONObject.put("trans_id", str);
            AdSlot adSlot2 = this.f703l;
            jSONObject.put("link_id", adSlot2 != null ? adSlot2.getLinkedId() : "");
            AdSlot adSlot3 = this.f703l;
            jSONObject.put("prime_rit", adSlot3 != null ? adSlot3.getAdUnitId() : "");
            TTBaseAd tTBaseAd = this.f704m;
            jSONObject.put("adn_rit", tTBaseAd != null ? tTBaseAd.getAdNetworkSlotId() : "");
            TTBaseAd tTBaseAd2 = this.f704m;
            jSONObject.put("adn_name", tTBaseAd2 != null ? tTBaseAd2.getAdNetWorkName() : "");
            AdSlot adSlot4 = this.f703l;
            jSONObject.put("reward_name", adSlot4 != null ? adSlot4.getRewardName() : "");
            AdSlot adSlot5 = this.f703l;
            jSONObject.put("reward_amount", adSlot5 != null ? adSlot5.getRewardAmount() : 0);
            AdSlot adSlot6 = this.f703l;
            if (adSlot6 != null && adSlot6.getCustomData() != null) {
                str2 = this.f703l.getCustomData().get("gromoreExtra");
            }
            jSONObject.put("media_extra", str2);
            AdSlot adSlot7 = this.f703l;
            if (adSlot7 != null && adSlot7.getScenarioId() != null) {
                jSONObject.put("scenario_id", this.f703l.getScenarioId());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return l0.a(jSONObject).toString();
    }

    private void g() {
        Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- showListen回调进来，开始计时");
        ThreadHelper.postDelayOnMSDKThread(new f(), this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c c2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b().a().c();
        c2.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c.f());
        String q = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().q();
        if (!TextUtils.isEmpty(q)) {
            c2.a("X-Tt-Env", q);
            c2.a("x-use-ppe", "1");
        }
        c2.a("User-Agent", e.c.c.a.b.b);
        c2.c(f());
        c2.a(new g());
    }

    public void a() {
        ThreadHelper.runOnMSDKThread(new b());
    }

    public void a(i iVar) {
        this.p = iVar;
    }

    public void a(AdSlot adSlot, TTBaseAd tTBaseAd) {
        this.n = System.currentTimeMillis();
        this.f703l = adSlot;
        this.f704m = tTBaseAd;
        g();
    }

    public boolean b() {
        boolean z = this.b == 1;
        Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- 判断是否开启了M服务端激励验证： " + z);
        return z;
    }

    public void c() {
        ThreadHelper.runOnMSDKThread(new RunnableC0026a());
    }

    public void d() {
        ThreadHelper.runOnMSDKThread(new c());
    }

    public void e() {
        ThreadHelper.runOnMSDKThread(new d());
    }
}
