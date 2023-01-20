package com.tencent.qcloud.tuikit.tuichat.component.face;

import android.graphics.Bitmap;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FaceGroup {
    private String desc;
    private ArrayList<Emoji> faces;
    private Bitmap groupIcon;
    private int groupId;
    private int pageColumnCount;
    private int pageRowCount;

    public String getDesc() {
        return this.desc;
    }

    public ArrayList<Emoji> getFaces() {
        return this.faces;
    }

    public Bitmap getGroupIcon() {
        return this.groupIcon;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public int getPageColumnCount() {
        return this.pageColumnCount;
    }

    public int getPageRowCount() {
        return this.pageRowCount;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setFaces(ArrayList<Emoji> arrayList) {
        this.faces = arrayList;
    }

    public void setGroupIcon(Bitmap bitmap) {
        this.groupIcon = bitmap;
    }

    public void setGroupId(int i2) {
        this.groupId = i2;
    }

    public void setPageColumnCount(int i2) {
        this.pageColumnCount = i2;
    }

    public void setPageRowCount(int i2) {
        this.pageRowCount = i2;
    }
}
