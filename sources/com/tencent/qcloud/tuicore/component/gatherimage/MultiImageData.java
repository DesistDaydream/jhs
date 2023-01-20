package com.tencent.qcloud.tuicore.component.gatherimage;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class MultiImageData implements Cloneable {
    public static final int maxSize = 9;
    public Map<Integer, Bitmap> bitmapMap;
    public int columnCount;
    public int defaultImageResId;
    public List<Object> imageUrls;
    public int maxHeight;
    public int maxWidth;
    public int rowCount;
    public int targetImageSize;
    public int bgColor = Color.parseColor("#cfd3d8");
    public int gap = 6;

    public MultiImageData() {
    }

    public Bitmap getBitmap(int i2) {
        Bitmap bitmap;
        Map<Integer, Bitmap> map = this.bitmapMap;
        if (map != null) {
            synchronized (map) {
                bitmap = this.bitmapMap.get(Integer.valueOf(i2));
            }
            return bitmap;
        }
        return null;
    }

    public int getDefaultImageResId() {
        return this.defaultImageResId;
    }

    public List<Object> getImageUrls() {
        return this.imageUrls;
    }

    public void putBitmap(Bitmap bitmap, int i2) {
        Map<Integer, Bitmap> map = this.bitmapMap;
        if (map != null) {
            synchronized (map) {
                this.bitmapMap.put(Integer.valueOf(i2), bitmap);
            }
            return;
        }
        HashMap hashMap = new HashMap();
        this.bitmapMap = hashMap;
        synchronized (hashMap) {
            this.bitmapMap.put(Integer.valueOf(i2), bitmap);
        }
    }

    public void setDefaultImageResId(int i2) {
        this.defaultImageResId = i2;
    }

    public void setImageUrls(List<Object> list) {
        this.imageUrls = list;
    }

    public int size() {
        List<Object> list = this.imageUrls;
        if (list != null) {
            if (list.size() > 9) {
                return 9;
            }
            return this.imageUrls.size();
        }
        return 0;
    }

    /* renamed from: clone */
    public MultiImageData m41clone() throws CloneNotSupportedException {
        MultiImageData multiImageData = (MultiImageData) super.clone();
        if (this.imageUrls != null) {
            ArrayList arrayList = new ArrayList(this.imageUrls.size());
            multiImageData.imageUrls = arrayList;
            arrayList.addAll(this.imageUrls);
        }
        if (this.bitmapMap != null) {
            HashMap hashMap = new HashMap();
            multiImageData.bitmapMap = hashMap;
            hashMap.putAll(this.bitmapMap);
        }
        return multiImageData;
    }

    public MultiImageData(int i2) {
        this.defaultImageResId = i2;
    }

    public MultiImageData(List<Object> list, int i2) {
        this.imageUrls = list;
        this.defaultImageResId = i2;
    }
}
