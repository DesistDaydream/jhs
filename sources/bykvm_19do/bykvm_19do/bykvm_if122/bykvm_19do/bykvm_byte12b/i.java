package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class i extends d {

    /* renamed from: g  reason: collision with root package name */
    private long f731g;

    /* renamed from: h  reason: collision with root package name */
    private String f732h;

    /* renamed from: i  reason: collision with root package name */
    private long f733i;

    public i(String str, String str2, String str3, String str4, int i2, String str5, String str6) {
        super(str, str2, str3, str4, i2);
        this.f733i = 0L;
        this.f731g = 0L;
        try {
            this.f731g = Long.parseLong(str5);
        } catch (Exception unused) {
        }
        this.f732h = str6;
    }

    public i(String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7) {
        this(str, str2, str3, str4, i2, str5, str6);
        this.f733i = 0L;
        try {
            this.f733i = Long.parseLong(str7);
        } catch (Exception unused) {
        }
    }

    public void a(long j2) {
        this.f733i = j2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.d
    public boolean a() {
        return (TextUtils.isEmpty(this.f732h) || this.f731g == 0) ? false : true;
    }

    public long i() {
        return this.f731g;
    }

    public String j() {
        return this.f732h;
    }

    public long k() {
        return this.f733i;
    }

    public boolean l() {
        return this.f733i != 0;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.a + "', showRulesVersion='" + this.f720c + "', timingMode=" + this.f722e + "}IntervalPacingBean{pacing=" + this.f731g + ", pacingRuleId='" + this.f732h + "', effectiveTime=" + this.f733i + '}';
    }
}
