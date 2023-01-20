package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

/* loaded from: classes3.dex */
public class c extends AsyncTask<Void, Void, a> {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private OAuthListener f6828c;

    /* renamed from: d  reason: collision with root package name */
    private int f6829d;

    /* loaded from: classes3.dex */
    public static class a {
        public OAuthErrCode a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public int f6830c;
    }

    public c(String str, OAuthListener oAuthListener) {
        this.a = str;
        this.f6828c = oAuthListener;
        this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.mm.opensdk.diffdev.a.c.a doInBackground(java.lang.Void[] r14) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f6828c.onAuthFinish(aVar2.a, aVar2.b);
    }
}
