package com.vector.receiver;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/vector/receiver/Battery;", "", "()V", "health", "Lcom/vector/receiver/Battery$Health;", "getHealth", "()Lcom/vector/receiver/Battery$Health;", "setHealth", "(Lcom/vector/receiver/Battery$Health;)V", "level", "", "getLevel", "()I", "setLevel", "(I)V", "status", "Lcom/vector/receiver/Battery$Status;", "getStatus", "()Lcom/vector/receiver/Battery$Status;", "setStatus", "(Lcom/vector/receiver/Battery$Status;)V", "temperature", "getTemperature", "setTemperature", "voltage", "getVoltage", "setVoltage", "toString", "", "Health", "Status", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Battery {
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f7861c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private Status f7862d = Status.UNKNOWN;
    @d

    /* renamed from: e  reason: collision with root package name */
    private Health f7863e = Health.UNKNOWN;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/vector/receiver/Battery$Health;", "", "(Ljava/lang/String;I)V", GrsBaseInfo.CountryCodeSource.UNKNOWN, "GOOD", "OVERHEAT", "COLD", "DEAD", "OVER_VOLTAGE", "UNSPECIFIED_FAILURE", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum Health {
        UNKNOWN,
        GOOD,
        OVERHEAT,
        COLD,
        DEAD,
        OVER_VOLTAGE,
        UNSPECIFIED_FAILURE
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/vector/receiver/Battery$Status;", "", "(Ljava/lang/String;I)V", GrsBaseInfo.CountryCodeSource.UNKNOWN, "CHARGING", "DISCHARGING", "NOT_CHARGING", "FULL", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum Status {
        UNKNOWN,
        CHARGING,
        DISCHARGING,
        NOT_CHARGING,
        FULL
    }

    @d
    public final Health a() {
        return this.f7863e;
    }

    public final int b() {
        return this.f7861c;
    }

    @d
    public final Status c() {
        return this.f7862d;
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public final void f(@d Health health) {
        this.f7863e = health;
    }

    public final void g(int i2) {
        this.f7861c = i2;
    }

    public final void h(@d Status status) {
        this.f7862d = status;
    }

    public final void i(int i2) {
        this.a = i2;
    }

    public final void j(int i2) {
        this.b = i2;
    }

    @d
    public String toString() {
        return "temperature = " + this.a + "\nvoltage = " + this.b + "\nlevel = " + this.f7861c + "\nstatus = " + this.f7862d + "\nhealth = " + this.f7863e;
    }
}
