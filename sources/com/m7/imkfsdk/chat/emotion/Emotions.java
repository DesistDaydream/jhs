package com.m7.imkfsdk.chat.emotion;

import android.text.TextUtils;
import com.m7.imkfsdk.utils.faceutils.FaceConversionUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class Emotions {
    public static Map<String, String> EMOTIONS;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        EMOTIONS = linkedHashMap;
        linkedHashMap.putAll(FaceConversionUtil.getInstace().emojiMap);
    }

    private static String emotionCode2String(int i2) {
        return new String(Character.toChars(i2));
    }

    public static String getDrawableResByName(String str) {
        return (TextUtils.isEmpty(str) || !EMOTIONS.containsKey(str)) ? "" : EMOTIONS.get(str);
    }

    public static List<Emotion> getEmotions() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : EMOTIONS.entrySet()) {
            arrayList.add(new Emotion(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
