package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do;

import com.qiniu.android.collect.ReportItem;

/* loaded from: classes.dex */
public enum c {
    LAUNCH("launch"),
    JAVA("java"),
    NATIVE("native"),
    ANR("anr"),
    BLOCK(ReportItem.LogTypeBlock),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL("all");
    
    private String a;

    c(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }
}
