package com.m7.imkfsdk.utils;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class ImageHeightCache {
    private HashMap<String, Integer> cacheImage = new HashMap<>();

    /* loaded from: classes2.dex */
    public static class ImageHeightCacheClassHolder {
        private static final ImageHeightCache instance = new ImageHeightCache();

        private ImageHeightCacheClassHolder() {
        }
    }

    public static ImageHeightCache getInstance() {
        return ImageHeightCacheClassHolder.instance;
    }

    public int getImgH(String str) {
        HashMap<String, Integer> hashMap;
        if (TextUtils.isEmpty(str) || (hashMap = this.cacheImage) == null || hashMap.get(str) == null) {
            return 0;
        }
        return this.cacheImage.get(str).intValue();
    }

    public void putImgH(String str, int i2) {
        if (this.cacheImage == null) {
            this.cacheImage = new HashMap<>();
        }
        this.cacheImage.put(str, Integer.valueOf(i2));
    }
}
