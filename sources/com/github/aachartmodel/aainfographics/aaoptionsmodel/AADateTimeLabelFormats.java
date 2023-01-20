package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.tencent.android.tpush.common.MessageKey;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\u0005R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\r\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\r\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\r\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011¨\u0006\""}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADateTimeLabelFormats;", "", "", "prop", "millisecond", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADateTimeLabelFormats;", "second", "minute", MessageKey.MSG_ACCEPT_TIME_HOUR, "day", "week", "month", "year", "Ljava/lang/String;", "getYear", "()Ljava/lang/String;", "setYear", "(Ljava/lang/String;)V", "getDay", "setDay", "getSecond", "setSecond", "getMillisecond", "setMillisecond", "getMonth", "setMonth", "getWeek", "setWeek", "getMinute", "setMinute", "getHour", "setHour", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AADateTimeLabelFormats {
    @e
    private String day;
    @e
    private String hour;
    @e
    private String millisecond;
    @e
    private String minute;
    @e
    private String month;
    @e
    private String second;
    @e
    private String week;
    @e
    private String year;

    @d
    public final AADateTimeLabelFormats day(@e String str) {
        this.day = str;
        return this;
    }

    @e
    public final String getDay() {
        return this.day;
    }

    @e
    public final String getHour() {
        return this.hour;
    }

    @e
    public final String getMillisecond() {
        return this.millisecond;
    }

    @e
    public final String getMinute() {
        return this.minute;
    }

    @e
    public final String getMonth() {
        return this.month;
    }

    @e
    public final String getSecond() {
        return this.second;
    }

    @e
    public final String getWeek() {
        return this.week;
    }

    @e
    public final String getYear() {
        return this.year;
    }

    @d
    public final AADateTimeLabelFormats hour(@e String str) {
        this.hour = str;
        return this;
    }

    @d
    public final AADateTimeLabelFormats millisecond(@e String str) {
        this.millisecond = str;
        return this;
    }

    @d
    public final AADateTimeLabelFormats minute(@e String str) {
        this.minute = str;
        return this;
    }

    @d
    public final AADateTimeLabelFormats month(@e String str) {
        this.month = str;
        return this;
    }

    @d
    public final AADateTimeLabelFormats second(@e String str) {
        this.second = str;
        return this;
    }

    public final void setDay(@e String str) {
        this.day = str;
    }

    public final void setHour(@e String str) {
        this.hour = str;
    }

    public final void setMillisecond(@e String str) {
        this.millisecond = str;
    }

    public final void setMinute(@e String str) {
        this.minute = str;
    }

    public final void setMonth(@e String str) {
        this.month = str;
    }

    public final void setSecond(@e String str) {
        this.second = str;
    }

    public final void setWeek(@e String str) {
        this.week = str;
    }

    public final void setYear(@e String str) {
        this.year = str;
    }

    @d
    public final AADateTimeLabelFormats week(@e String str) {
        this.week = str;
        return this;
    }

    @d
    public final AADateTimeLabelFormats year(@e String str) {
        this.year = str;
        return this;
    }
}
