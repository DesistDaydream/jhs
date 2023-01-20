package com.m7.imkfsdk.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.m7.imkfsdk.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class StringBuilderUtils {
    public static SpannableStringBuilder setPhoneNum(Context context, SpannableStringBuilder spannableStringBuilder) {
        Matcher matcher = Pattern.compile("\\d{7,}", 2).matcher(spannableStringBuilder);
        while (matcher.find()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.ykfsdk_color_FF6B6B)), matcher.start(), matcher.start() + matcher.group().length(), 17);
        }
        return spannableStringBuilder;
    }
}
