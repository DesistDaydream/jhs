package com.tencent.android.tpush.a;

import android.content.pm.ProviderInfo;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class b {
    private String a;
    private ProviderInfo b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<ProviderInfo> f6053c;

    public void a(String str) {
        this.a = str;
    }

    public void b(ProviderInfo providerInfo) {
        if (this.f6053c == null) {
            this.f6053c = new ArrayList<>();
        }
        this.f6053c.add(providerInfo);
    }

    public void a(ProviderInfo providerInfo) {
        this.b = providerInfo;
    }

    public ArrayList<ProviderInfo> a() {
        return this.f6053c;
    }
}
