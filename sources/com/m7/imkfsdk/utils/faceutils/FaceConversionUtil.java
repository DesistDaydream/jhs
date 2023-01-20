package com.m7.imkfsdk.utils.faceutils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Log;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import com.moor.imkf.model.entity.ChatEmoji;
import com.moor.imkf.utils.MoorUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class FaceConversionUtil {
    private static FaceConversionUtil mFaceConversionUtil;
    private int pageSize = 20;
    public LinkedHashMap<String, String> emojiMap = new LinkedHashMap<>();
    public List<ChatEmoji> emojis = new ArrayList();
    public List<List<ChatEmoji>> emojiLists = new ArrayList();

    private FaceConversionUtil() {
    }

    private void ParseData(List<String> list, Context context) {
        int i2;
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String[] split = it.next().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String substring = split[0].substring(0, split[0].lastIndexOf("."));
                this.emojiMap.put(split[1], substring);
                int identifier = context.getResources().getIdentifier(substring, "drawable", context.getPackageName());
                if (identifier != 0) {
                    ChatEmoji chatEmoji = new ChatEmoji();
                    chatEmoji.setId(identifier);
                    chatEmoji.setCharacter(split[1]);
                    chatEmoji.setFaceName(substring);
                    this.emojis.add(chatEmoji);
                }
            }
            int ceil = (int) Math.ceil(this.emojis.size() / 20);
            for (i2 = 0; i2 < ceil; i2++) {
                this.emojiLists.add(getData(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void dealExpression(Context context, SpannableStringBuilder spannableStringBuilder, Pattern pattern, int i2, TextView textView) throws Exception {
        int identifier;
        Matcher matcher = pattern.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            if (matcher.start() >= i2) {
                String str = this.emojiMap.get(group);
                if (!TextUtils.isEmpty(str) && (identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName())) != 0) {
                    Drawable drawable = identifier != 0 ? context.getResources().getDrawable(identifier) : null;
                    int start = matcher.start() + group.length();
                    if (drawable != null) {
                        drawable.setBounds(0, 0, (int) (textView.getTextSize() * 1.3d), (int) (textView.getTextSize() * 1.3d));
                        spannableStringBuilder.setSpan(new ImageSpan(drawable, 0), matcher.start(), start, 33);
                    }
                    if (start < spannableStringBuilder.length()) {
                        dealExpression(context, spannableStringBuilder, pattern, start, textView);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private List<ChatEmoji> getData(int i2) {
        int i3 = this.pageSize;
        int i4 = i2 * i3;
        int i5 = i3 + i4;
        if (i5 > this.emojis.size()) {
            i5 = this.emojis.size();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.emojis.subList(i4, i5));
        if (arrayList.size() < this.pageSize) {
            for (int size = arrayList.size(); size < this.pageSize; size++) {
                arrayList.add(new ChatEmoji());
            }
        }
        if (arrayList.size() == this.pageSize) {
            ChatEmoji chatEmoji = new ChatEmoji();
            chatEmoji.setId(R.drawable.ykfsdk_kf_face_del_icon);
            arrayList.add(chatEmoji);
        }
        return arrayList;
    }

    public static FaceConversionUtil getInstace() {
        if (mFaceConversionUtil == null) {
            mFaceConversionUtil = new FaceConversionUtil();
        }
        return mFaceConversionUtil;
    }

    public SpannableString addFace(Context context, int i2, String str, TextView textView) {
        Drawable drawable;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i2 != 0 && (drawable = context.getResources().getDrawable(i2)) != null) {
            drawable.setBounds(0, 0, (int) (textView.getTextSize() * 1.3d), (int) (textView.getTextSize() * 1.3d));
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ImageSpan(drawable, 0), 0, str.length(), 33);
            return spannableString;
        }
        return new SpannableString(str);
    }

    public SpannableStringBuilder getExpressionString(Context context, String str, TextView textView) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        try {
            dealExpression(context, spannableStringBuilder, Pattern.compile("\\:[^\\:]+\\:", 2), 0, textView);
        } catch (Exception e2) {
            Log.e("dealExpression", e2.getMessage());
        }
        return spannableStringBuilder;
    }

    public void getFileText(Context context) {
        ParseData(MoorUtils.getEmojiFile(context), context);
    }
}
