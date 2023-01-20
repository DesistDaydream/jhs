package com.baidu.mobads.sdk.internal;

import java.util.Observer;

/* loaded from: classes.dex */
public interface t {

    /* loaded from: classes.dex */
    public enum a {
        NONE(-1, "未开始"),
        INITING(0, "下载准备中"),
        DOWNLOADING(1, "正在下载"),
        CANCELLED(2, "已取消下载"),
        COMPLETED(3, "下载完成"),
        ERROR(4, "下载失败"),
        COMPLETE_BUT_FILE_REMOVED(5, "下载完但文件异常"),
        PAUSED(6, "已暂停下载");
        

        /* renamed from: i  reason: collision with root package name */
        private int f1616i;

        /* renamed from: j  reason: collision with root package name */
        private String f1617j;

        a(int i2, String str) {
            this.f1616i = i2;
            this.f1617j = str;
        }

        public int b() {
            return this.f1616i;
        }

        public String c() {
            return this.f1617j;
        }
    }

    void a();

    void a(boolean z);

    void addObserver(Observer observer);

    void b();

    void c();

    void d();

    String e();

    String f();

    String g();

    String h();

    String i();

    int j();

    float k();

    a l();

    void m();

    boolean n();
}
