package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g {
    private String a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private List<f> f765c;

    /* renamed from: d  reason: collision with root package name */
    private List<h> f766d;

    /* loaded from: classes.dex */
    public static class a {
        private String a;
        private List<j> b = new ArrayList();

        public void a(String str) {
            this.a = str;
        }

        public void a(List<j> list) {
            this.b = list;
        }
    }

    public List<f> a() {
        return this.f765c;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(h hVar) {
    }

    public void a(String str) {
    }

    public void a(List<f> list) {
        this.f765c = list;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public void b(List<h> list) {
        this.f766d = list;
    }

    public List<j> c() {
        a aVar = this.b;
        if (aVar == null) {
            return null;
        }
        return aVar.b;
    }

    public void c(String str) {
    }

    public List<h> d() {
        return this.f766d;
    }

    public boolean e() {
        a aVar = this.b;
        return (aVar == null || TextUtils.isEmpty(aVar.a)) ? false : true;
    }
}
