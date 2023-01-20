package com.tencent.tpns.baseapi.core.c;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.tencent.tpns.baseapi.core.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC0270a {
        CLUSTER_DEFAULT("default", "tpns.tencent.com"),
        CLUSTER_SGP("sgp", "tpns.sgp.tencent.com"),
        CLUSTER_HK("hk", "tpns.hk.tencent.com");
        

        /* renamed from: d  reason: collision with root package name */
        private String f6899d;

        /* renamed from: e  reason: collision with root package name */
        private String f6900e;

        EnumC0270a(String str, String str2) {
            this.f6899d = str;
            this.f6900e = str2;
        }

        public String a() {
            return this.f6899d;
        }

        public String b() {
            return this.f6900e;
        }
    }
}
