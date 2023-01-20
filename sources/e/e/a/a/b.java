package e.e.a.a;

import com.ctetin.expandabletextviewlibrary.app.LinkType;
import java.util.List;

/* loaded from: classes.dex */
public class b {
    private String a;
    private List<a> b;

    public String a() {
        return this.a;
    }

    public List<a> b() {
        return this.b;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(List<a> list) {
        this.b = list;
    }

    /* loaded from: classes.dex */
    public static class a {
        private int a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private String f10010c;

        /* renamed from: d  reason: collision with root package name */
        private LinkType f10011d;

        /* renamed from: e  reason: collision with root package name */
        private String f10012e;

        /* renamed from: f  reason: collision with root package name */
        private String f10013f;

        public a(int i2, int i3, String str, LinkType linkType) {
            this.a = i2;
            this.b = i3;
            this.f10010c = str;
            this.f10011d = linkType;
        }

        public int a() {
            return this.b;
        }

        public String b() {
            return this.f10012e;
        }

        public String c() {
            return this.f10013f;
        }

        public int d() {
            return this.a;
        }

        public String e() {
            return this.f10010c;
        }

        public void f(int i2) {
            this.b = i2;
        }

        public void g(String str) {
            this.f10012e = str;
        }

        public LinkType getType() {
            return this.f10011d;
        }

        public void h(String str) {
            this.f10013f = str;
        }

        public void i(int i2) {
            this.a = i2;
        }

        public void j(LinkType linkType) {
            this.f10011d = linkType;
        }

        public void k(String str) {
            this.f10010c = str;
        }

        public a(int i2, int i3, String str, String str2, LinkType linkType) {
            this.a = i2;
            this.b = i3;
            this.f10012e = str;
            this.f10013f = str2;
            this.f10011d = linkType;
        }
    }
}
