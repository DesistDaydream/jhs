package com.tencent.imsdk.v2;

import com.tencent.bugly.Bugly;
import com.tencent.imsdk.message.FaceElement;

/* loaded from: classes3.dex */
public class V2TIMFaceElem extends V2TIMElem {
    private byte[] data;
    private int index = 0;

    public byte[] getData() {
        if (getElement() == null) {
            return this.data;
        }
        return ((FaceElement) getElement()).getFaceData();
    }

    public int getIndex() {
        if (getElement() == null) {
            return this.index;
        }
        return ((FaceElement) getElement()).getFaceIndex();
    }

    public void setData(byte[] bArr) {
        if (getElement() == null) {
            this.data = bArr;
        } else {
            ((FaceElement) getElement()).setFaceData(bArr);
        }
    }

    public void setIndex(int i2) {
        if (getElement() == null) {
            this.index = i2;
        } else {
            ((FaceElement) getElement()).setFaceIndex(i2);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V2TIMFaceElem--->");
        sb.append("index:");
        sb.append(getIndex());
        sb.append(", has data:");
        sb.append(getData() == null ? Bugly.SDK_IS_DEV : "true");
        return sb.toString();
    }
}
