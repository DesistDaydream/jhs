package e.k.c.a.a.l;

import android.util.Log;
import android.webkit.WebView;
import e.k.c.a.a.k.m;
import e.k.c.a.a.k.n;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f11992c = "SafeGetUrl";

    /* renamed from: d  reason: collision with root package name */
    private static final long f11993d = 200;
    private String a;
    private WebView b;

    /* renamed from: e.k.c.a.a.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0385a implements Runnable {
        public final /* synthetic */ CountDownLatch a;

        public RunnableC0385a(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.d(aVar.b.getUrl());
            this.a.countDown();
        }
    }

    public a() {
    }

    public String b() {
        if (this.b == null) {
            return "";
        }
        if (m.a()) {
            return this.b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        n.a(new RunnableC0385a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            Log.e(f11992c, "getUrlMethod: InterruptedException " + e2.getMessage(), e2);
        }
        return this.a;
    }

    public WebView c() {
        return this.b;
    }

    public void d(String str) {
        this.a = str;
    }

    public void e(WebView webView) {
        this.b = webView;
    }

    public a(WebView webView) {
        this.b = webView;
    }
}
