package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u00020\u00002\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;", "", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "prop", "position", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;", "", "relativeTo", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;", "", "theme", "(Ljava/util/Map;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;", "Ljava/util/Map;", "getTheme", "()Ljava/util/Map;", "setTheme", "(Ljava/util/Map;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "getPosition", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "setPosition", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;)V", "Ljava/lang/String;", "getRelativeTo", "()Ljava/lang/String;", "setRelativeTo", "(Ljava/lang/String;)V", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAResetZoomButton {
    @e
    private AAPosition position;
    @e
    private String relativeTo;
    @e
    private Map<String, ? extends Object> theme;

    @e
    public final AAPosition getPosition() {
        return this.position;
    }

    @e
    public final String getRelativeTo() {
        return this.relativeTo;
    }

    @e
    public final Map<String, Object> getTheme() {
        return this.theme;
    }

    @d
    public final AAResetZoomButton position(@e AAPosition aAPosition) {
        this.position = aAPosition;
        return this;
    }

    @d
    public final AAResetZoomButton relativeTo(@e String str) {
        this.relativeTo = str;
        return this;
    }

    public final void setPosition(@e AAPosition aAPosition) {
        this.position = aAPosition;
    }

    public final void setRelativeTo(@e String str) {
        this.relativeTo = str;
    }

    public final void setTheme(@e Map<String, ? extends Object> map) {
        this.theme = map;
    }

    @d
    public final AAResetZoomButton theme(@e Map<String, ? extends Object> map) {
        this.theme = map;
        return this;
    }
}
