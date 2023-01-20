package com.tencent.qcloud.tuikit.tuichat.component.face;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class CustomFaceGroup {
    private ArrayList<CustomFace> array = new ArrayList<>();
    private int faceGroupId;
    private String faceIconName;
    private String faceIconPath;
    private int pageColumnCount;
    private int pageRowCount;

    public void addCustomFace(CustomFace customFace) {
        this.array.add(customFace);
    }

    public ArrayList<CustomFace> getCustomFaceList() {
        return this.array;
    }

    public int getFaceGroupId() {
        return this.faceGroupId;
    }

    public String getFaceIconName() {
        return this.faceIconName;
    }

    public String getFaceIconPath() {
        return this.faceIconPath;
    }

    public int getPageColumnCount() {
        return this.pageColumnCount;
    }

    public int getPageRowCount() {
        return this.pageRowCount;
    }

    public void setFaceGroupId(int i2) {
        this.faceGroupId = i2;
    }

    public void setFaceIconName(String str) {
        this.faceIconName = str;
    }

    public void setFaceIconPath(String str) {
        this.faceIconPath = str;
    }

    public void setPageColumnCount(int i2) {
        this.pageColumnCount = i2;
    }

    public void setPageRowCount(int i2) {
        this.pageRowCount = i2;
    }
}
