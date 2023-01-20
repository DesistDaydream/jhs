package com.meizu.cloud.pushsdk.handler.a.c;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;

/* loaded from: classes2.dex */
public class d {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f4899c;

    /* renamed from: d  reason: collision with root package name */
    private String f4900d;

    /* loaded from: classes2.dex */
    public static class a {
        private String a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f4901c;

        /* renamed from: d  reason: collision with root package name */
        private String f4902d;

        public a a(String str) {
            this.a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.f4901c = str;
            return this;
        }

        public a d(String str) {
            this.f4902d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.a = !TextUtils.isEmpty(aVar.a) ? aVar.a : "";
        this.b = !TextUtils.isEmpty(aVar.b) ? aVar.b : "";
        this.f4899c = !TextUtils.isEmpty(aVar.f4901c) ? aVar.f4901c : "";
        this.f4900d = TextUtils.isEmpty(aVar.f4902d) ? "" : aVar.f4902d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.d.a.c cVar = new com.meizu.cloud.pushsdk.d.a.c();
        cVar.a(PushConstants.TASK_ID, this.a);
        cVar.a(PushConstants.SEQ_ID, this.b);
        cVar.a(PushConstants.PUSH_TIMESTAMP, this.f4899c);
        cVar.a("device_id", this.f4900d);
        return cVar.toString();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f4899c;
    }

    public String f() {
        return this.f4900d;
    }
}
