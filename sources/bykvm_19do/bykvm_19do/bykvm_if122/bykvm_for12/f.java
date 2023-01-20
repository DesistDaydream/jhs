package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.w;
import com.baidu.mobads.sdk.internal.bc;
import com.bytedance.msdk.adapter.util.Logger;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class f<T extends k> extends HandlerThread implements Handler.Callback {
    public String a;
    public final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a<T> b;

    /* renamed from: c  reason: collision with root package name */
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<T> f947c;

    /* renamed from: d  reason: collision with root package name */
    public final List<T> f948d;

    /* renamed from: e  reason: collision with root package name */
    public long f949e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f950f;

    /* renamed from: g  reason: collision with root package name */
    public int f951g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f952h;

    /* renamed from: i  reason: collision with root package name */
    public final a f953i;

    /* renamed from: j  reason: collision with root package name */
    public final b f954j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f955k;

    /* loaded from: classes.dex */
    public interface a {
        boolean a();
    }

    /* loaded from: classes.dex */
    public static class b {
        public final int a;
        public final long b;

        /* renamed from: c  reason: collision with root package name */
        public final long f956c;

        /* renamed from: d  reason: collision with root package name */
        public final int f957d;

        /* renamed from: e  reason: collision with root package name */
        public final long f958e;

        /* renamed from: f  reason: collision with root package name */
        public final long f959f;

        public b(int i2, long j2, long j3, int i3, long j4, long j5) {
            this.a = i2;
            this.b = j2;
            this.f956c = j3;
            this.f957d = i3;
            this.f958e = j4;
            this.f959f = j5;
        }

        public static b b() {
            Logger.d("TTMediationSDK", "AdEventThread- policy: batchSize: " + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().i() + ", routineInterval: " + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().n());
            return new b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().i(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().n(), com.heytap.mcssdk.constant.a.f3314d, 5, bc.f1469d, 300000L);
        }

        public int a() {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l.a) {
                return 1;
            }
            return this.a;
        }
    }

    public f(String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a<T> aVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<T> aVar2, b bVar, a aVar3) {
        super("gm_t_adevent_" + str, -4);
        this.a = "AdEventThread-【";
        this.a += str + "】";
        this.f955k = "V3".equals(str);
        a("tag=" + str);
        this.f954j = bVar;
        this.f953i = aVar3;
        this.b = aVar;
        this.f947c = aVar2;
        this.f948d = Collections.synchronizedList(new LinkedList());
    }

    private void a() {
        this.b.a(h(), this.f948d);
        this.f948d.clear();
    }

    private void a(int i2, long j2) {
        Message obtainMessage = this.f952h.obtainMessage();
        obtainMessage.what = i2;
        this.f952h.sendMessageDelayed(obtainMessage, j2);
    }

    private void a(T t) {
        this.b.a(h(), (int) t);
        if (this.f950f) {
            a("如果在容灾状态，直接返回.......mIsServerBusy=" + this.f950f);
            return;
        }
        a("onHandleReceivedAdEvent");
        this.f948d.add(t);
        a(this.f948d);
        if (j()) {
            a("onHandleReceivedAdEvent upload");
            f();
        }
    }

    private void a(String str) {
        Logger.i(this.a, str);
    }

    private void a(List<T> list) {
        String str;
        int a2 = this.f954j.a();
        if (list == null) {
            return;
        }
        if (list.size() <= a2) {
            str = "start and return, checkAndDeleteEvent local size:" + list.size() + "小于:" + a2;
        } else {
            int size = list.size() - a2;
            a("start checkAndDeleteEvent local size,deleteCnt:" + list.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + size);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
            list.removeAll(arrayList);
            str = "end checkAndDeleteEvent local size:" + list.size();
        }
        a(str);
    }

    private static boolean a(g gVar) {
        return gVar.f961d;
    }

    private void b() {
        this.f950f = false;
        this.b.a(h(), false);
        this.f951g = 0;
        this.b.a(h(), 0);
        this.f952h.removeMessages(4);
    }

    private void b(List<T> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    HashSet hashSet = new HashSet();
                    for (T t : this.f948d) {
                        hashSet.add(t.a());
                    }
                    for (T t2 : list) {
                        if (!hashSet.contains(t2.a())) {
                            this.f948d.add(t2);
                        }
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        a("reloadCacheList adEventList is empty======");
    }

    private static boolean b(g gVar) {
        return gVar.b == 509;
    }

    private g c(List<T> list) {
        try {
            if (this.f947c == null) {
                this.f947c = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.e();
            }
        } catch (Exception unused) {
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<T> aVar = this.f947c;
        if (aVar == null) {
            return null;
        }
        return aVar.a(list);
    }

    private void c() {
        a(2, this.f954j.b);
    }

    private void d() {
        a(4, g());
    }

    private void e() {
        a("普通失败 ，触发重试机制：" + this.f954j.f956c + "毫秒后 重试.....");
        a(3, this.f954j.f956c);
    }

    private void f() {
        this.f952h.removeMessages(3);
        this.f952h.removeMessages(2);
        if (w.a(this.f948d)) {
            this.f949e = System.currentTimeMillis();
            c();
        } else if (!this.f953i.a()) {
            a("doRoutineUpload no net, wait retry");
            e();
        } else {
            g c2 = c(this.f948d);
            if (c2 != null) {
                if (c2.a) {
                    a("doRoutineUpload success: " + this.f948d.size() + " events");
                    a();
                    o();
                    p();
                } else if (b(c2)) {
                    a("doRoutineUpload serverbusy");
                    i();
                } else if (a(c2)) {
                    a("服务端返回data error 抛弃数据 , 清空本次日志，重置上传状态....");
                    a();
                    o();
                } else if (this.f950f) {
                } else {
                    e();
                    a("doRoutineUpload net fail retry");
                }
            }
        }
    }

    private long g() {
        long j2 = this.f954j.f959f;
        a("服务器繁忙，" + (((this.f951g % 3) + 1) * j2) + "毫秒后进行重试,当前重试次数：mServerBusyRetryCount=" + this.f951g + "，mServerBusyRetryBaseInternal=" + this.f954j.f959f);
        return ((this.f951g % 3) + 1) * this.f954j.f959f;
    }

    private int h() {
        return this.f955k ? 2 : 1;
    }

    private void i() {
        this.f950f = true;
        this.b.a(h(), true);
        this.f948d.clear();
        this.f952h.removeMessages(3);
        this.f952h.removeMessages(2);
        d();
    }

    private boolean j() {
        a("mCacheList.size():" + this.f948d.size() + ",mPolicy.mMaxCacheCount=" + this.f954j.a() + ",System.currentTimeMillis() - mLastSuccessUploadTime =" + (System.currentTimeMillis() - this.f949e) + ",mPolicy.mMaxCacheTime=" + this.f954j.b);
        return !this.f950f && (this.f948d.size() >= this.f954j.a() || System.currentTimeMillis() - this.f949e >= this.f954j.b);
    }

    private void k() {
        a("onHandleInitEvent 初始化日志组件.....线程优先级：" + Process.getThreadPriority(0));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a<T> aVar = this.b;
        b bVar = this.f954j;
        aVar.a(2, bVar.f957d, bVar.f958e);
        this.f950f = this.b.a(h());
        this.f951g = this.b.b(h());
        if (this.f950f) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.f951g);
            d();
            return;
        }
        List<T> a2 = this.b.a(h(), this.f954j.a(), "_id");
        if (Logger.isDebug()) {
            for (T t : a2) {
            }
        }
        b(a2);
        a("onHandleInitEvent cacheData count = " + this.f948d.size());
        f();
    }

    private void l() {
        if (!this.f950f) {
            a("onHandleRoutineRetryEvent");
            f();
            return;
        }
        a("如果在容灾状态，直接返回, 安全起见这里判断一下,mIsServerBusy=" + this.f950f);
    }

    private void m() {
        if (!this.f950f) {
            a("onHandleRoutineUploadEvent");
            f();
            return;
        }
        a("如果在容灾状态，直接返回, 安全起见这里判断一下,mIsServerBusy=" + this.f950f);
    }

    private void n() {
        String str;
        if (this.f953i.a()) {
            List<T> a2 = this.b.a(h(), this.f954j.a(), "_id");
            a(a2);
            StringBuilder sb = new StringBuilder();
            sb.append("数据库查询出来的size=");
            sb.append(a2 != null ? a2.size() : 0);
            a(sb.toString());
            if (w.a(a2)) {
                a("onHandleServerBusyRetryEvent, empty list start routine");
                b();
                c();
                return;
            }
            g c2 = c(a2);
            if (c2 == null) {
                return;
            }
            if (c2.a) {
                a("onHandleServerBusyRetryEvent, success");
                a();
                o();
                p();
                return;
            } else if (b(c2)) {
                this.f951g++;
                this.b.a(h(), this.f951g);
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a<T> aVar = this.b;
                int h2 = h();
                b bVar = this.f954j;
                aVar.a(h2, a2, bVar.f957d, bVar.f958e);
                d();
                str = "onHandleServerBusyRetryEvent, serverbusy, count = " + this.f951g;
            } else if (a(c2)) {
                a("onHandleServerBusyRetryEvent, ---》 data Error直接抛弃数据 ");
                a();
                o();
                return;
            } else {
                e();
                str = "onHandleServerBusyRetryEvent, net fail";
            }
        } else {
            a(4, this.f954j.f956c);
            str = "onHandleServerBusyRetryEvent, no net";
        }
        a(str);
    }

    private void o() {
        this.f949e = System.currentTimeMillis();
        b();
        c();
    }

    private void p() {
        StringBuilder sb;
        String str;
        int a2 = this.f954j.a() / 2;
        if (a2 < 1) {
            a2 = 1;
        }
        List<T> a3 = this.b.a(h(), a2, "_id");
        if (a3 == null || a3.size() <= 0) {
            sb = new StringBuilder();
            str = "数据库日志数量: 0, 小于batchSize/2（";
        } else {
            this.f948d.addAll(a3);
            if (a3.size() >= a2) {
                this.f952h.removeMessages(2);
                this.f952h.sendEmptyMessage(2);
                sb = new StringBuilder();
                sb.append("数据库日志数量: ");
                sb.append(this.f948d.size());
                sb.append(", 大于等于batchSize/2（");
                sb.append(a2);
                sb.append("），继续上传.");
                a(sb.toString());
            }
            sb = new StringBuilder();
            sb.append("数据库日志数量: ");
            sb.append(this.f948d.size());
            str = ", 小于batchSize/2（";
        }
        sb.append(str);
        sb.append(a2);
        sb.append("），停止上传，等待新产生的事件");
        a(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            a((f<T>) ((k) message.obj));
        } else if (i2 == 2) {
            m();
        } else if (i2 == 3) {
            a("routine触发失败重试.....");
            l();
        } else if (i2 == 4) {
            a("触发服务器繁忙重试机制.....");
            n();
        } else if (i2 == 5) {
            k();
        }
        return true;
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        this.f949e = System.currentTimeMillis();
        this.f952h = new Handler(getLooper(), this);
    }
}
