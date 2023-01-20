package com.m7.imkfsdk.chat.emotion;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class EmojiSpanBuilder {
    private static Pattern sPatternEmotion = Pattern.compile(":[^:]+:", 2);
    private static String zhengze = ":[^:]+:";

    public static Spannable buildEmotionSpannable(Context context, String str) {
        Matcher matcher = sPatternEmotion.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            String group = matcher.group();
            String drawableResByName = Emotions.getDrawableResByName(group);
            if (!TextUtils.isEmpty(drawableResByName)) {
                int start = matcher.start();
                Drawable drawable = ContextCompat.getDrawable(context, context.getResources().getIdentifier(drawableResByName, "drawable", context.getPackageName()));
                drawable.setBounds(0, 0, MoorDensityUtil.dp2px(20.0f), MoorDensityUtil.dp2px(20.0f));
                spannableString.setSpan(new CenterImageSpan(drawable), start, group.length() + start, 33);
            }
        }
        return spannableString;
    }
}
