package com.jihuanshe.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SuperscriptSpan;
import android.widget.EditText;
import com.baidu.mobads.sdk.internal.bc;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.jihuanshe.R;
import com.jihuanshe.model.AtUserBean;
import com.vector.util.Res;
import e.l.h.j.b.e;
import e.l.h.k.b;
import e.t.a;
import h.k2.v.f0;
import h.r0;
import h.t1;
import h.t2.h;
import h.t2.k;
import h.t2.u;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class StringUtil {
    private static final int b = 1000;

    /* renamed from: c  reason: collision with root package name */
    private static final int f4347c = 60000;

    /* renamed from: d  reason: collision with root package name */
    private static final int f4348d = 3600000;

    /* renamed from: e  reason: collision with root package name */
    private static final int f4349e = 86400000;
    @d
    public static final StringUtil a = new StringUtil();
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final Regex f4350f = new Regex("<span data-uid=.*</span>");
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final Regex f4351g = new Regex("<span data-uid=\"(\\d+)\">(.+)</span>");

    private StringUtil() {
    }

    public static /* synthetic */ CharSequence c(StringUtil stringUtil, float f2, int i2, boolean z, int i3, int i4, boolean z2, int i5, Object obj) {
        return stringUtil.b(f2, (i5 & 2) != 0 ? R.string.shop_min_price : i2, (i5 & 4) != 0 ? false : z, (i5 & 8) != 0 ? 8 : i3, (i5 & 16) != 0 ? R.string.shop_no_price : i4, (i5 & 32) != 0 ? false : z2);
    }

    public final void a(@d String str) {
        ClipboardManager clipboardManager = (ClipboardManager) a.b().getSystemService("clipboard");
        if (clipboardManager == null) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
        e.k(this, "复制成功", null, null, null, 0, null, 62, null);
    }

    @d
    public final CharSequence b(float f2, int i2, boolean z, int i3, int i4, boolean z2) {
        if (f2 <= 0.0f && !z) {
            return Res.w(Res.a, i4, null, 2, null);
        }
        String format = new DecimalFormat("#.##").format(Float.valueOf(f2));
        String v = Res.a.v(i2, format);
        SpannableString spannableString = new SpannableString(v);
        int r3 = StringsKt__StringsKt.r3(v, format, 0, false, 6, null);
        spannableString.setSpan(new AbsoluteSizeSpan(i3, true), format.toString().length() + r3, spannableString.length(), 18);
        spannableString.setSpan(new SuperscriptSpan(), format.toString().length() + r3, spannableString.length(), 33);
        if (z2) {
            spannableString.setSpan(new StyleSpan(1), r3 + format.toString().length(), spannableString.length(), 17);
        }
        return spannableString;
    }

    @d
    public final String d(int i2, @d String str) {
        return "<span data-uid=\"" + i2 + "\">@" + str + "</span>";
    }

    @d
    public final String e(@d EditText editText, @d List<AtUserBean> list) {
        String substring;
        String obj = editText.getText().toString();
        b.a.a("ResultContent", f0.C("editTextStr:", editText.getText()));
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        for (Object obj2 : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            AtUserBean atUserBean = (AtUserBean) obj2;
            if (i3 == 0) {
                int start = atUserBean.getRange().getStart();
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                substring = obj.substring(0, start);
            } else {
                int end = list.get(i3 - 1).getRange().getEnd();
                int start2 = atUserBean.getRange().getStart();
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                substring = obj.substring(end, start2);
            }
            b.a.a("ResultContent", f0.C("resultStr:", substring));
            arrayList.add(substring);
            i3 = i4;
        }
        int end2 = ((AtUserBean) CollectionsKt___CollectionsKt.c3(list)).getRange().getEnd();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
        String substring2 = obj.substring(end2);
        arrayList.add(substring2);
        b.a.a("ResultContent", f0.C("resultStr:", substring2));
        String str = "";
        for (Object obj3 : arrayList) {
            int i5 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            String str2 = (String) obj3;
            str = i2 < arrayList.size() - 1 ? str + str2 + a.d((int) list.get(i2).getUserId(), list.get(i2).getUserName()) : f0.C(str, str2);
            i2 = i5;
        }
        b.a.a("ResultContent", f0.C("contentReply:", str));
        return str;
    }

    @d
    public final String f(long j2) {
        if (j2 < 1000000000000L) {
            j2 *= 1000;
        }
        if (j2 < 0) {
            return "未知时间";
        }
        if (j2 < com.heytap.mcssdk.constant.a.f3314d) {
            return "刚刚";
        }
        if (j2 < 120000) {
            return "1分钟前";
        }
        if (j2 < 3000000) {
            return (j2 / 60000) + "分钟前";
        } else if (j2 < 5400000) {
            return "1小时前";
        } else {
            if (j2 < 86400000) {
                return (j2 / 3600000) + "小时前";
            } else if (j2 < bc.f1470e) {
                return "昨天";
            } else {
                return (j2 / 86400000) + "天前";
            }
        }
    }

    @k.e.a.e
    public final String g(@k.e.a.e Long l2, @k.e.a.e String str) {
        return new SimpleDateFormat(str).format(Long.valueOf(System.currentTimeMillis()));
    }

    @d
    public final CharSequence h(float f2) {
        return c(this, f2, R.string.shop_min_want_price, false, 0, R.string.shop_no_want_price, false, 44, null);
    }

    @k.e.a.e
    public final CharSequence i(@k.e.a.e String str) {
        CharSequence charSequence;
        Throwable th;
        if (str == null) {
            return str;
        }
        try {
            Result.a aVar = Result.Companion;
            charSequence = str;
            while (f4350f.containsMatchIn(str)) {
                try {
                    int r3 = StringsKt__StringsKt.r3(str, "<span data-uid=\"", 0, false, 6, null);
                    int r32 = StringsKt__StringsKt.r3(str, "</span>", 0, false, 6, null) + 7;
                    if (str != null) {
                        String substring = str.substring(r3, r32);
                        String str2 = null;
                        k find$default = Regex.find$default(f4351g, substring, 0, 2, null);
                        if (find$default != null && find$default.d().size() >= 3) {
                            h hVar = find$default.d().get(1);
                            String f2 = hVar == null ? null : hVar.f();
                            String str3 = "";
                            String str4 = f2 != null ? f2 : "";
                            h hVar2 = find$default.d().get(2);
                            if (hVar2 != null) {
                                str2 = hVar2.f();
                            }
                            if (str2 != null) {
                                str3 = str2;
                            }
                            String C = f0.C(str3, ExpandableTextView.N);
                            str = u.o2(str, substring, C, false, 4, null);
                            charSequence = e.l.h.f.e.e(new SpannableStringBuilder(charSequence).replace(r3, r32, (CharSequence) C), Res.k(R.color.service_charge_color), Integer.valueOf(r3), Integer.valueOf(r3 + C.length()), new StringUtil$handleReplyText$1$1(str4));
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Result.a aVar2 = Result.Companion;
                    Result.m106constructorimpl(r0.a(th));
                    return charSequence;
                }
            }
            Result.m106constructorimpl(t1.a);
        } catch (Throwable th3) {
            charSequence = str;
            th = th3;
        }
        return charSequence;
    }

    public final boolean j(char c2) {
        return '0' <= c2 && c2 <= '9';
    }

    @k.e.a.e
    public final Long k(@k.e.a.e CharSequence charSequence) {
        if (charSequence != null && (charSequence instanceof String)) {
            try {
                Result.a aVar = Result.Companion;
                return Long.valueOf(Long.parseLong((String) charSequence));
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                Result.m106constructorimpl(r0.a(th));
                return null;
            }
        }
        return null;
    }
}
