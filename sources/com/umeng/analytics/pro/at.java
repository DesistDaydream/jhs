package com.umeng.analytics.pro;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;

/* loaded from: classes3.dex */
public class at {
    private short[] a;
    private int b = -1;

    public at(int i2) {
        this.a = new short[i2];
    }

    private void d() {
        short[] sArr = this.a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.a = sArr2;
    }

    public short a() {
        short[] sArr = this.a;
        int i2 = this.b;
        this.b = i2 - 1;
        return sArr[i2];
    }

    public short b() {
        return this.a[this.b];
    }

    public void c() {
        this.b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i2 = 0; i2 < this.a.length; i2++) {
            if (i2 != 0) {
                sb.append(ExpandableTextView.N);
            }
            if (i2 == this.b) {
                sb.append(">>");
            }
            sb.append((int) this.a[i2]);
            if (i2 == this.b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public void a(short s) {
        if (this.a.length == this.b + 1) {
            d();
        }
        short[] sArr = this.a;
        int i2 = this.b + 1;
        this.b = i2;
        sArr[i2] = s;
    }
}
