package com.m7.imkfsdk.chat.chatrow;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.google.gson.Gson;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.YKFVideoActivity;
import com.m7.imkfsdk.chat.adapter.FlowAdapter;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.TextViewHolder;
import com.m7.imkfsdk.chat.model.MoorImageInfoBean;
import com.m7.imkfsdk.utils.AnimatedGifDrawable;
import com.m7.imkfsdk.utils.AnimatedImageSpan;
import com.m7.imkfsdk.utils.GlideUtil;
import com.m7.imkfsdk.utils.ImageHeightCache;
import com.m7.imkfsdk.utils.RegexUtils;
import com.m7.imkfsdk.utils.ToastUtils;
import com.m7.imkfsdk.utils.faceutils.FaceConversionUtil;
import com.m7.imkfsdk.view.NumClickBottomSheetDialog;
import com.m7.imkfsdk.view.PopupWindowList;
import com.m7.imkfsdk.view.imageviewer.MoorImagePreview;
import com.m7.imkfsdk.view.widget.PagerGridLayoutManager;
import com.m7.imkfsdk.view.widget.PagerGridSnapHelper;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.event.TransferAgent;
import com.moor.imkf.lib.jsoup.Jsoup;
import com.moor.imkf.lib.jsoup.nodes.Element;
import com.moor.imkf.lib.jsoup.select.Elements;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.lib.utils.MoorNullUtil;
import com.moor.imkf.model.entity.FlowBean;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.utils.MoorUtils;
import com.umeng.analytics.pro.am;
import e.b.a.t.g;
import e.b.a.t.k.p;
import e.j.e.t.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.c.a.c;

/* loaded from: classes2.dex */
public class TextRxChatRow extends BaseChatRow {
    private Context context;
    private FlowAdapter flowAdapter;
    private int mColumns;
    private int mCurrent;
    private PagerGridLayoutManager mLayoutManager;
    private PopupWindowList mPopupWindowList;
    private int mRows;
    private int mTotal;

    /* loaded from: classes2.dex */
    public class AClickApan extends ClickableSpan {
        public String msg;

        public AClickApan(String str) {
            this.msg = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = this.msg + "";
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.startsWith("moor_moor_m7_actionrobotTransferAgent.m7_data:")) {
                str = str.replace("moor_moor_m7_actionrobotTransferAgent.m7_data:", "").replace(".com", "");
                TransferAgent transferAgent = new TransferAgent();
                transferAgent.peerid = str;
                c.f().q(transferAgent);
            }
            if (str.startsWith("moor_moor_m7_actiondata-phone-href.m7-data-tel:")) {
                NumClickBottomSheetDialog.instance(RegexUtils.regexNumber(str.replace("moor_moor_m7_actiondata-phone-href.m7-data-tel:", "").replace(".com", ""))).show(((ChatActivity) TextRxChatRow.this.context).getSupportFragmentManager(), "");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class AString {
        public String a;
        public String action;
        public String content;
        public String peerid;
        public String url;
    }

    /* loaded from: classes2.dex */
    public class HttpClickSpan extends ClickableSpan {
        public String msg;

        public HttpClickSpan(String str) {
            this.msg = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            try {
                if (!this.msg.contains("http") && !this.msg.contains("https")) {
                    this.msg = "http://" + this.msg;
                } else if (this.msg.startsWith("http://tel:")) {
                    NumClickBottomSheetDialog.instance(RegexUtils.regexNumber(this.msg.replaceAll("http://tel:", ""))).show(((ChatActivity) TextRxChatRow.this.context).getSupportFragmentManager(), "");
                } else {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(this.msg));
                    TextRxChatRow.this.context.startActivity(intent);
                }
            } catch (Exception unused) {
                Toast.makeText(TextRxChatRow.this.context, R.string.ykfsdk_url_failure, 0).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class NumClickSpan extends ClickableSpan {
        public String msg;

        public NumClickSpan(String str) {
            this.msg = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            NumClickBottomSheetDialog.instance(RegexUtils.regexNumber(this.msg)).show(((ChatActivity) TextRxChatRow.this.context).getSupportFragmentManager(), "");
        }
    }

    /* loaded from: classes2.dex */
    public static class RobotClickSpan extends ClickableSpan {
        public ChatActivity chatActivity;
        public String msg;

        public RobotClickSpan(String str, ChatActivity chatActivity) {
            this.msg = str;
            this.chatActivity = chatActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str;
            try {
                str = this.msg.split("：", 2)[1].trim();
            } catch (Exception unused) {
                str = "";
            }
            this.chatActivity.sendTextMsg(str);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes2.dex */
    public static class XbotClickSpan extends ClickableSpan {
        public ChatActivity chatActivity;
        public String msg;

        public XbotClickSpan(String str, ChatActivity chatActivity) {
            this.msg = str;
            this.chatActivity = chatActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.chatActivity.sendTextMsg(this.msg);
        }
    }

    public TextRxChatRow(int i2) {
        super(i2);
        this.mRows = 4;
        this.mColumns = 2;
        this.mTotal = 0;
        this.mCurrent = 0;
    }

    private void addVideo(String str, TextViewHolder textViewHolder) {
        View inflate = View.inflate(this.context, R.layout.ykfsdk_ykf_textrx_video, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_textrx_video);
        final String replace = str.replace("<video", "");
        GlideUtil.loadImage(this.context, replace, imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(TextRxChatRow.this.context, YKFVideoActivity.class);
                intent.putExtra(YKFConstants.YKFVIDEOPATHURI, replace);
                TextRxChatRow.this.context.startActivity(intent);
            }
        });
        textViewHolder.getDescLinearLayout().addView(inflate);
    }

    private boolean checkURL(String str) {
        return str.startsWith("moor_moor_m7_action");
    }

    public static void copyTxt(String str) {
        ((ClipboardManager) MoorUtils.getApp().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", str));
    }

    private SpannableStringBuilder getClickableHtml(Spanned spanned) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spanned.length(), URLSpan.class)) {
            setLinkClickable(spannableStringBuilder, uRLSpan);
        }
        return spannableStringBuilder;
    }

    public static List<String> getImgStr(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(<img.*src\\s*=\\s*(.*?)[^>]*?>|<p><video.*src\\s*=\\s*(.*?)[^>]*?</video></p>)", 2).matcher(str);
        while (matcher.find()) {
            Matcher matcher2 = Pattern.compile("(<img.*?src|<img.*?SRC|<video.*?src)=(\"|')(.*?)(\"|')").matcher(matcher.group());
            while (matcher2.find()) {
                if (matcher2.group().startsWith("<video")) {
                    arrayList.add("<video" + matcher2.group(3));
                } else {
                    arrayList.add(matcher2.group(3));
                }
            }
        }
        return arrayList;
    }

    private SpannableStringBuilder handler(final TextView textView, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = Pattern.compile("(\\#\\[face/png/f_static_)\\d{3}(.png\\]\\#)").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            try {
                String substring = group.substring(20, group.length() - 6);
                InputStream open = this.context.getAssets().open("face/gif/f" + substring + ".gif");
                spannableStringBuilder.setSpan(new AnimatedImageSpan(new AnimatedGifDrawable(open, new AnimatedGifDrawable.UpdateListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.24
                    @Override // com.m7.imkfsdk.utils.AnimatedGifDrawable.UpdateListener
                    public void update() {
                        textView.postInvalidate();
                    }
                })), matcher.start(), matcher.end(), 33);
                open.close();
            } catch (Exception e2) {
                String substring2 = group.substring(2, group.length() - 2);
                try {
                    Context context = this.context;
                    spannableStringBuilder.setSpan(new ImageSpan(context, BitmapFactory.decodeStream(context.getAssets().open(substring2))), matcher.start(), matcher.end(), 33);
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                e2.printStackTrace();
            }
        }
        return spannableStringBuilder;
    }

    private void initImgandText(final String str, TextViewHolder textViewHolder) {
        Spanned fromHtml;
        List<String> imgStr = getImgStr(str);
        String[] split = str.replaceAll("<(img|IMG|video|VIDEO)(.*?)(/>|></img>|></video>|>)", "---").split("---");
        for (int i2 = 0; i2 < split.length; i2++) {
            TextView textView = new TextView(this.context);
            textView.setTextColor(this.context.getResources().getColor(R.color.ykfsdk_color_333333));
            textView.setTextSize(2, 14.0f);
            textView.setLineSpacing(0.0f, 1.2f);
            if (str.contains("</a>") && !str.contains("1：")) {
                String a_String = setA_String(split[i2]);
                if (Build.VERSION.SDK_INT >= 24) {
                    fromHtml = Html.fromHtml(a_String, 63);
                } else {
                    fromHtml = Html.fromHtml(a_String);
                }
                SpannableStringBuilder clickableHtml = getClickableHtml(new SpannableStringBuilder(new SpannableStringBuilder(MoorUtils.trimTrailingWhitespace(fromHtml))));
                Pattern compile = Pattern.compile("\\[([^\\]]*)\\]\\(([^\\)]*)\\)", 2);
                Matcher matcher = compile.matcher(clickableHtml);
                boolean z = false;
                while (matcher.find()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    if (checkURL(group2)) {
                        clickableHtml.replace(matcher.start(), matcher.end(), (CharSequence) group);
                        clickableHtml.setSpan(new AClickApan(group2), matcher.start(), matcher.start() + group.length(), 17);
                        clickableHtml.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.ykfsdk_lite_blue)), matcher.start(), matcher.start() + group.length(), 17);
                        matcher = compile.matcher(clickableHtml);
                    }
                    z = true;
                }
                if (!z) {
                    Matcher matcher2 = Pattern.compile(RegexUtils.isPhoneRegexp(), 2).matcher(clickableHtml);
                    while (matcher2.find()) {
                        String group3 = matcher2.group();
                        int start = matcher2.start() + group3.length();
                        clickableHtml.setSpan(new NumClickSpan(group3), matcher2.start(), start, 17);
                        clickableHtml.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.ykfsdk_lite_blue)), matcher2.start(), start, 17);
                    }
                }
                textView.setAutoLinkMask(15);
                textView.setText(clickableHtml);
                textView.setLinkTextColor(this.context.getResources().getColor(R.color.ykfsdk_lite_blue));
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                setNoImgView(textView, split[i2], setAString(split[i2]));
            }
            textViewHolder.getDescLinearLayout().addView(textView);
            if (imgStr.size() > i2) {
                showImage(imgStr.get(i2), textViewHolder);
            }
            if (imgStr.size() == 0) {
                textViewHolder.getDescLinearLayout().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.28
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        TextRxChatRow.this.showPopWindows(view, str);
                        return true;
                    }
                });
            }
        }
    }

    private void parserImg(FromToMessage fromToMessage, TextViewHolder textViewHolder) {
        List<String> imgStr = getImgStr(fromToMessage.message);
        if (fromToMessage.message.replaceAll("<(img|IMG|video|VIDEO)(.*?)(/>|></img>|></video>|>)", "---").split("---").length != 0 || imgStr.size() <= 0) {
            return;
        }
        showImage(imgStr.get(0), textViewHolder);
    }

    private List<AString> setAString(String str) {
        SpannableString spannableString = new SpannableString(str);
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("<a[^>]*>([^<]*)</a>", 2).matcher(spannableString);
        while (matcher.find()) {
            AString aString = new AString();
            aString.a = matcher.group();
            aString.content = matcher.group(1);
            Matcher matcher2 = Pattern.compile("(href|HREF)=(\"|')(.*?)(\"|')").matcher(matcher.group());
            while (matcher2.find()) {
                aString.url = matcher2.group(3);
            }
            arrayList.add(aString);
        }
        return arrayList;
    }

    private String setA_String(String str) {
        Matcher matcher = Pattern.compile("<a[^>]*>([^<]*)</a>", 2).matcher(new SpannableString(str));
        while (matcher.find()) {
            AString aString = new AString();
            aString.a = matcher.group();
            aString.content = matcher.group(1);
            Elements elementsByTag = Jsoup.parse(aString.a).getElementsByTag(am.av);
            if (elementsByTag != null && elementsByTag.size() > 0) {
                for (int i2 = 0; i2 < elementsByTag.size(); i2++) {
                    if (elementsByTag.get(i2) != null) {
                        Element element = elementsByTag.get(i2);
                        String attr = element.attr("m7_action");
                        aString.action = attr;
                        if (!TextUtils.isEmpty(attr) && ("robotTransferAgent".equals(aString.action) | "transferAgent".equals(aString.action))) {
                            aString.peerid = element.attr("m7_data");
                            String str2 = aString.a;
                            str = str.replace(str2, "[" + aString.content + "](moor_moor_m7_actionrobotTransferAgent.m7_data:" + aString.peerid + ".com)");
                        }
                        if (TextUtils.isEmpty(aString.action)) {
                            String attr2 = element.attr("href");
                            aString.action = attr2;
                            if (!TextUtils.isEmpty(attr2) && aString.action.startsWith("tel:")) {
                                String str3 = aString.a;
                                str = str.replace(str3, "[" + aString.content + "](moor_moor_m7_actiondata-phone-href.m7-data-tel:" + aString.content + ".com)");
                            }
                        }
                    }
                }
            }
        }
        return str;
    }

    private void setLinkClickable(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
        int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
        spannableStringBuilder.setSpan(new HttpClickSpan(uRLSpan.getURL()), spanStart, spanEnd, spannableStringBuilder.getSpanFlags(uRLSpan));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.ykfsdk_lite_blue)), spanStart, spanEnd, 17);
    }

    private void setNoImgView(TextView textView, String str, List<AString> list) {
        Spanned fromHtml;
        String replaceAll = str.replaceAll("\\n", "\n");
        for (int i2 = 0; i2 < list.size(); i2++) {
            AString aString = list.get(i2);
            Elements elementsByTag = Jsoup.parse(aString.a).getElementsByTag(am.av);
            if (elementsByTag != null && elementsByTag.size() > 0) {
                for (int i3 = 0; i3 < elementsByTag.size(); i3++) {
                    if (elementsByTag.get(i3) != null) {
                        Element element = elementsByTag.get(i3);
                        String attr = element.attr("m7_action");
                        aString.action = attr;
                        if (!TextUtils.isEmpty(attr)) {
                            if ("transferAgent".equals(aString.action) | "robotTransferAgent".equals(aString.action)) {
                                aString.peerid = element.attr("m7_data");
                                String str2 = aString.a;
                                replaceAll = replaceAll.replace(str2, "[" + aString.content + "](moor_moor_m7_actionrobotTransferAgent.m7_data:" + aString.peerid + ".com)");
                                aString.content = "------------___---------------";
                            }
                        }
                        if (TextUtils.isEmpty(aString.action)) {
                            String attr2 = element.attr("href");
                            aString.action = attr2;
                            if (!TextUtils.isEmpty(attr2)) {
                                if (aString.action.startsWith("tel:")) {
                                    String str3 = aString.a;
                                    replaceAll = replaceAll.replace(str3, "[" + aString.content + "](moor_moor_m7_actiondata-phone-href.m7-data-tel:" + aString.content + ".com)");
                                    aString.content = "------------___---------------";
                                } else {
                                    replaceAll = replaceAll.replaceAll(aString.a, aString.content);
                                }
                            } else {
                                replaceAll = replaceAll.replaceAll(aString.a, aString.content);
                            }
                        }
                    }
                }
            }
        }
        String replaceAll2 = replaceAll.replaceAll("<p>", "").replaceAll("</p>", "\n").replaceAll("\n", "<br />");
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(replaceAll2, 63);
        } else {
            fromHtml = Html.fromHtml(replaceAll2);
        }
        SpannableStringBuilder clickableHtml = getClickableHtml(new SpannableStringBuilder(MoorUtils.trimTrailingWhitespace(fromHtml)));
        Matcher matcher = Pattern.compile("\\d+[：].*", 2).matcher(clickableHtml);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start() + group.length();
            clickableHtml.setSpan(new RobotClickSpan(group, (ChatActivity) this.context), matcher.start(), start, 17);
            clickableHtml.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.ykfsdk_lite_blue)), matcher.start(), start, 17);
        }
        Matcher matcher2 = Pattern.compile("((http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)|(www.[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)|(((http[s]{0,1}|ftp)://|)((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)", 2).matcher(clickableHtml);
        while (matcher2.find()) {
            String group2 = matcher2.group();
            int start2 = matcher2.start() + group2.length();
            clickableHtml.setSpan(new HttpClickSpan(group2), matcher2.start(), start2, 17);
            clickableHtml.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.ykfsdk_lite_blue)), matcher2.start(), start2, 17);
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            AString aString2 = list.get(i4);
            Matcher matcher3 = Pattern.compile(aString2.content, 2).matcher(clickableHtml);
            while (matcher3.find()) {
                int start3 = matcher3.start() + matcher3.group().length();
                clickableHtml.setSpan(new HttpClickSpan(aString2.url), matcher3.start(), start3, 17);
                clickableHtml.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.ykfsdk_lite_blue)), matcher3.start(), start3, 17);
            }
        }
        Matcher matcher4 = Pattern.compile(RegexUtils.isPhoneRegexp(), 2).matcher(clickableHtml);
        while (matcher4.find()) {
            String group3 = matcher4.group();
            int start4 = matcher4.start() + group3.length();
            clickableHtml.setSpan(new NumClickSpan(group3), matcher4.start(), start4, 17);
            clickableHtml.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.ykfsdk_lite_blue)), matcher4.start(), start4, 17);
        }
        Pattern compile = Pattern.compile("\\[([^\\]]*)\\]\\(([^\\)]*)\\)", 2);
        Matcher matcher5 = compile.matcher(clickableHtml);
        while (matcher5.find()) {
            String group4 = matcher5.group(1);
            String group5 = matcher5.group(2);
            if (checkURL(group5)) {
                clickableHtml.replace(matcher5.start(), matcher5.end(), (CharSequence) group4);
                clickableHtml.setSpan(new AClickApan(group5), matcher5.start(), matcher5.start() + group4.length(), 17);
                clickableHtml.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.ykfsdk_lite_blue)), matcher5.start(), matcher5.start() + group4.length(), 17);
                matcher5 = compile.matcher(clickableHtml);
            }
        }
        textView.setText(clickableHtml);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void showImage(final String str, TextViewHolder textViewHolder) {
        LinearLayout.LayoutParams layoutParams;
        if (str.startsWith("<video")) {
            addVideo(str, textViewHolder);
            return;
        }
        int imgH = ImageHeightCache.getInstance().getImgH(str);
        if (imgH == 0) {
            layoutParams = new LinearLayout.LayoutParams(MoorDensityUtil.getScreenWidth(this.context) - MoorDensityUtil.dp2px(98.0f), -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(MoorDensityUtil.getScreenWidth(this.context) - MoorDensityUtil.dp2px(98.0f), imgH);
        }
        final ImageView imageView = new ImageView(this.context);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxWidth(MoorDensityUtil.getScreenWidth(this.context) - MoorDensityUtil.dp2px(98.0f));
        imageView.setMaxHeight(MoorDensityUtil.dp2px(200.0f));
        imageView.setScaleType(ImageView.ScaleType.FIT_START);
        layoutParams.setMargins(0, MoorDensityUtil.dp2px(4.0f), 0, MoorDensityUtil.dp2px(4.0f));
        imageView.setLayoutParams(layoutParams);
        GlideUtil.loadImage(this.context, str, imageView, new g<Drawable>() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.25
            @Override // e.b.a.t.g
            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, p<Drawable> pVar, boolean z) {
                imageView.setVisibility(8);
                return false;
            }

            @Override // e.b.a.t.g
            public boolean onResourceReady(Drawable drawable, Object obj, p<Drawable> pVar, DataSource dataSource, boolean z) {
                ImageHeightCache.getInstance().putImgH(str, drawable.getIntrinsicHeight());
                return false;
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MoorImageInfoBean moorImageInfoBean = new MoorImageInfoBean();
                moorImageInfoBean.setFrom(YKFConstants.INVESTIGATE_TYPE_IN).setPath(str);
                MoorImagePreview.getInstance().setContext(TextRxChatRow.this.context).setIndex(0).setImage(moorImageInfoBean).start();
            }
        });
        textViewHolder.getDescLinearLayout().addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopWindows(View view, final String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.context.getString(R.string.ykfsdk_ykf_copy));
        if (this.mPopupWindowList == null) {
            this.mPopupWindowList = new PopupWindowList(view.getContext());
        }
        this.mPopupWindowList.setAnchorView(view);
        this.mPopupWindowList.setItemData(arrayList);
        this.mPopupWindowList.setModal(true);
        this.mPopupWindowList.show();
        this.mPopupWindowList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.27
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
                TextRxChatRow.copyTxt(str);
                ToastUtils.showShort(TextRxChatRow.this.context, TextRxChatRow.this.context.getString(R.string.ykfsdk_ykf_copy_success));
                TextRxChatRow.this.mPopupWindowList.hide();
            }
        });
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_text_rx, (ViewGroup) null);
            inflate.setTag(new TextViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, final FromToMessage fromToMessage, int i2) {
        this.context = context;
        final TextViewHolder textViewHolder = (TextViewHolder) baseHolder;
        if (fromToMessage != null) {
            textViewHolder.getDescLinearLayout().removeAllViews();
            textViewHolder.getLl_flow_multi().setVisibility(8);
            if (fromToMessage.withDrawStatus) {
                textViewHolder.getWithdrawTextView().setVisibility(0);
                textViewHolder.getContainer().setVisibility(8);
                return;
            }
            textViewHolder.getWithdrawTextView().setVisibility(8);
            textViewHolder.getContainer().setVisibility(0);
            String str = fromToMessage.flowTip;
            if (str != null && !"".equals(str)) {
                if ("button".equals(fromToMessage.flowType)) {
                    if (fromToMessage.flowMultiSelect && !fromToMessage.isFlowSelect) {
                        textViewHolder.getLl_flow_multi().setVisibility(0);
                    } else {
                        textViewHolder.getLl_flow_multi().setVisibility(8);
                    }
                    textViewHolder.ll_flow.setVisibility(0);
                    textViewHolder.chat_rl_robot.setVisibility(8);
                    textViewHolder.chat_rl_robot_result.setVisibility(8);
                    MoorLogUtils.aTag("messageflowlist", fromToMessage.flowList);
                    if (fromToMessage.showHtml.booleanValue()) {
                        initImgandText(fromToMessage.flowTip, textViewHolder);
                    }
                    if (!"0".equals(fromToMessage.flowStyle) && !TextUtils.isEmpty(fromToMessage.flowStyle) && !"null".equals(fromToMessage.flowStyle)) {
                        if ("1".equals(fromToMessage.flowStyle)) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textViewHolder.mRecyclerView.getLayoutParams();
                            layoutParams.width = MoorDensityUtil.dp2px(220.0f);
                            textViewHolder.mRecyclerView.setLayoutParams(layoutParams);
                            final ArrayList arrayList = (ArrayList) new Gson().o(fromToMessage.flowList, new a<ArrayList<FlowBean>>() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.10
                            }.getType());
                            final HashMap hashMap = new HashMap();
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                FlowBean flowBean = (FlowBean) arrayList.get(i3);
                                if (flowBean.isChoose()) {
                                    hashMap.put(Integer.valueOf(i3), flowBean);
                                }
                            }
                            TextView tv_multi_count = textViewHolder.getTv_multi_count();
                            tv_multi_count.setText(hashMap.size() + "");
                            textViewHolder.getTv_multi_save().setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.11
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Iterator it;
                                    if (hashMap.size() > 0) {
                                        String str2 = "";
                                        while (hashMap.values().iterator().hasNext()) {
                                            str2 = str2 + "【" + ((FlowBean) it.next()).getButton() + "】、";
                                        }
                                        ((ChatActivity) context).sendXbotTextMsg(str2);
                                        MessageDao messageDao = MessageDao.getInstance();
                                        FromToMessage fromToMessage2 = fromToMessage;
                                        messageDao.updateFlowList(fromToMessage2._id, fromToMessage2.flowList);
                                        MessageDao.getInstance().updateFlowChoose(fromToMessage._id, true);
                                        return;
                                    }
                                    ToastUtils.showShort(context, R.string.ykfsdk_ykf_please_choosemulit);
                                }
                            });
                            if (arrayList.size() == 3) {
                                ViewGroup.LayoutParams layoutParams2 = textViewHolder.ll_flow.getLayoutParams();
                                layoutParams2.height = MoorDensityUtil.dp2px(150.0f);
                                textViewHolder.ll_flow.setLayoutParams(layoutParams2);
                                PagerGridLayoutManager pagerGridLayoutManager = new PagerGridLayoutManager(4, 1, 0) { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.12
                                    @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                                    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                                        return new RecyclerView.LayoutParams(-2, MoorDensityUtil.dp2px(95.0f));
                                    }
                                };
                                this.mLayoutManager = pagerGridLayoutManager;
                                textViewHolder.mRecyclerView.setLayoutManager(pagerGridLayoutManager);
                            } else if (arrayList.size() == 2) {
                                ViewGroup.LayoutParams layoutParams3 = textViewHolder.ll_flow.getLayoutParams();
                                layoutParams3.height = MoorDensityUtil.dp2px(120.0f);
                                textViewHolder.ll_flow.setLayoutParams(layoutParams3);
                                PagerGridLayoutManager pagerGridLayoutManager2 = new PagerGridLayoutManager(4, 1, 0) { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.13
                                    @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                                    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                                        return new RecyclerView.LayoutParams(-2, MoorDensityUtil.dp2px(80.0f));
                                    }
                                };
                                this.mLayoutManager = pagerGridLayoutManager2;
                                textViewHolder.mRecyclerView.setLayoutManager(pagerGridLayoutManager2);
                            } else if (arrayList.size() == 1) {
                                ViewGroup.LayoutParams layoutParams4 = textViewHolder.ll_flow.getLayoutParams();
                                layoutParams4.height = MoorDensityUtil.dp2px(60.0f);
                                textViewHolder.ll_flow.setLayoutParams(layoutParams4);
                                PagerGridLayoutManager pagerGridLayoutManager3 = new PagerGridLayoutManager(1, 1, 0) { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.14
                                    @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                                    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                                        return new RecyclerView.LayoutParams(-2, MoorDensityUtil.dp2px(45.0f));
                                    }
                                };
                                this.mLayoutManager = pagerGridLayoutManager3;
                                textViewHolder.mRecyclerView.setLayoutManager(pagerGridLayoutManager3);
                            } else if (arrayList.size() == 4) {
                                ViewGroup.LayoutParams layoutParams5 = textViewHolder.ll_flow.getLayoutParams();
                                layoutParams5.height = MoorDensityUtil.dp2px(200.0f);
                                textViewHolder.ll_flow.setLayoutParams(layoutParams5);
                                PagerGridLayoutManager pagerGridLayoutManager4 = new PagerGridLayoutManager(4, 1, 0) { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.15
                                    @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                                    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                                        return new RecyclerView.LayoutParams(-2, MoorDensityUtil.dp2px(110.0f));
                                    }
                                };
                                this.mLayoutManager = pagerGridLayoutManager4;
                                textViewHolder.mRecyclerView.setLayoutManager(pagerGridLayoutManager4);
                            } else {
                                ViewGroup.LayoutParams layoutParams6 = textViewHolder.ll_flow.getLayoutParams();
                                layoutParams6.height = MoorDensityUtil.dp2px(236.0f);
                                textViewHolder.ll_flow.setLayoutParams(layoutParams6);
                                PagerGridLayoutManager pagerGridLayoutManager5 = new PagerGridLayoutManager(this.mRows, 1, 1) { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.16
                                    @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                                    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                                        return new RecyclerView.LayoutParams(-2, MoorDensityUtil.dp2px(200.0f));
                                    }
                                };
                                this.mLayoutManager = pagerGridLayoutManager5;
                                textViewHolder.mRecyclerView.setLayoutManager(pagerGridLayoutManager5);
                            }
                            PagerGridSnapHelper pagerGridSnapHelper = new PagerGridSnapHelper();
                            if (textViewHolder.mRecyclerView.getOnFlingListener() == null) {
                                pagerGridSnapHelper.attachToRecyclerView(textViewHolder.mRecyclerView);
                            }
                            this.flowAdapter = new FlowAdapter(context, arrayList, fromToMessage.flowMultiSelect, fromToMessage, new FlowAdapter.OnItemClickListenr() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.17
                                @Override // com.m7.imkfsdk.chat.adapter.FlowAdapter.OnItemClickListenr
                                public void setOnButtonClickListenr(int i4, boolean z, String str2) {
                                    if (fromToMessage.flowMultiSelect) {
                                        if (i4 < arrayList.size()) {
                                            ((FlowBean) arrayList.get(i4)).setChoose(z);
                                            fromToMessage.flowList = new Gson().z(arrayList);
                                            if (z) {
                                                hashMap.put(Integer.valueOf(i4), arrayList.get(i4));
                                            } else {
                                                hashMap.remove(Integer.valueOf(i4));
                                            }
                                            TextView tv_multi_count2 = textViewHolder.getTv_multi_count();
                                            tv_multi_count2.setText(hashMap.size() + "");
                                            return;
                                        }
                                        return;
                                    }
                                    ((ChatActivity) context).sendXbotTextMsg(str2);
                                }
                            });
                            MoorLogUtils.aTag("flowlist", Integer.valueOf(arrayList.size()));
                            textViewHolder.mRecyclerView.setAdapter(this.flowAdapter);
                            int size = arrayList.size() / 4;
                            if (arrayList.size() % 4 > 0) {
                                size++;
                            }
                            textViewHolder.pointBottomView.setFillColor(context.getResources().getColor(R.color.ykfsdk_pointed));
                            textViewHolder.pointBottomView.initData(size, 0);
                            this.mLayoutManager.setPageListener(new PagerGridLayoutManager.PageListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.18
                                @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager.PageListener
                                public void onPageSelect(int i4) {
                                    TextRxChatRow.this.mCurrent = i4;
                                    textViewHolder.pointBottomView.setCurrentPage(i4);
                                }

                                @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager.PageListener
                                public void onPageSizeChanged(int i4) {
                                    TextRxChatRow.this.mTotal = i4;
                                }
                            });
                            return;
                        } else if ("2".equals(fromToMessage.flowStyle)) {
                            textViewHolder.ll_flow.setVisibility(8);
                            textViewHolder.chat_rl_robot.setVisibility(8);
                            textViewHolder.chat_rl_robot_result.setVisibility(8);
                            ArrayList arrayList2 = (ArrayList) new Gson().o(fromToMessage.flowList, new a<ArrayList<FlowBean>>() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.19
                            }.getType());
                            int i4 = 0;
                            while (i4 < arrayList2.size()) {
                                TextView textView = new TextView(context);
                                StringBuilder sb = new StringBuilder();
                                int i5 = i4 + 1;
                                sb.append(i5);
                                sb.append(". ");
                                sb.append(((FlowBean) arrayList2.get(i4)).getButton());
                                String sb2 = sb.toString();
                                SpannableString spannableString = new SpannableString(sb2);
                                spannableString.setSpan(new XbotClickSpan(((FlowBean) arrayList2.get(i4)).getText(), (ChatActivity) context), 0, sb2.length(), 17);
                                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.ykfsdk_lite_blue)), 0, sb2.length(), 17);
                                textView.setText(spannableString);
                                textView.setTextSize(2, 14.0f);
                                textView.setMovementMethod(LinkMovementMethod.getInstance());
                                textViewHolder.getDescLinearLayout().addView(textView);
                                i4 = i5;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    final ArrayList arrayList3 = (ArrayList) new Gson().o(fromToMessage.flowList, new a<ArrayList<FlowBean>>() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.1
                    }.getType());
                    final HashMap hashMap2 = new HashMap();
                    for (int i6 = 0; i6 < arrayList3.size(); i6++) {
                        FlowBean flowBean2 = (FlowBean) arrayList3.get(i6);
                        if (flowBean2.isChoose()) {
                            hashMap2.put(Integer.valueOf(i6), flowBean2);
                        }
                    }
                    TextView tv_multi_count2 = textViewHolder.getTv_multi_count();
                    tv_multi_count2.setText(hashMap2.size() + "");
                    textViewHolder.getTv_multi_save().setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Iterator it;
                            if (hashMap2.size() > 0) {
                                String str2 = "";
                                while (hashMap2.values().iterator().hasNext()) {
                                    str2 = str2 + "【" + ((FlowBean) it.next()).getButton() + "】、";
                                }
                                ((ChatActivity) context).sendXbotTextMsg(str2);
                                MessageDao messageDao = MessageDao.getInstance();
                                FromToMessage fromToMessage2 = fromToMessage;
                                messageDao.updateFlowList(fromToMessage2._id, fromToMessage2.flowList);
                                MessageDao.getInstance().updateFlowChoose(fromToMessage._id, true);
                                return;
                            }
                            ToastUtils.showShort(context, R.string.ykfsdk_ykf_please_choosemulit);
                        }
                    });
                    if (arrayList3.size() < 7 && arrayList3.size() > 4) {
                        ViewGroup.LayoutParams layoutParams7 = textViewHolder.ll_flow.getLayoutParams();
                        layoutParams7.height = MoorDensityUtil.dp2px(150.0f);
                        textViewHolder.ll_flow.setLayoutParams(layoutParams7);
                        PagerGridLayoutManager pagerGridLayoutManager6 = new PagerGridLayoutManager(4, this.mColumns, 0) { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.3
                            @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                                return new RecyclerView.LayoutParams(-1, MoorDensityUtil.dp2px(95.0f));
                            }
                        };
                        this.mLayoutManager = pagerGridLayoutManager6;
                        textViewHolder.mRecyclerView.setLayoutManager(pagerGridLayoutManager6);
                    } else if (arrayList3.size() < 5 && arrayList3.size() > 2) {
                        ViewGroup.LayoutParams layoutParams8 = textViewHolder.ll_flow.getLayoutParams();
                        layoutParams8.height = MoorDensityUtil.dp2px(120.0f);
                        textViewHolder.ll_flow.setLayoutParams(layoutParams8);
                        PagerGridLayoutManager pagerGridLayoutManager7 = new PagerGridLayoutManager(4, this.mColumns, 0) { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.4
                            @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                                return new RecyclerView.LayoutParams(-1, MoorDensityUtil.dp2px(80.0f));
                            }
                        };
                        this.mLayoutManager = pagerGridLayoutManager7;
                        textViewHolder.mRecyclerView.setLayoutManager(pagerGridLayoutManager7);
                    } else if (arrayList3.size() < 3 && arrayList3.size() > 0) {
                        ViewGroup.LayoutParams layoutParams9 = textViewHolder.ll_flow.getLayoutParams();
                        layoutParams9.height = MoorDensityUtil.dp2px(60.0f);
                        textViewHolder.ll_flow.setLayoutParams(layoutParams9);
                        PagerGridLayoutManager pagerGridLayoutManager8 = new PagerGridLayoutManager(4, this.mColumns, 0) { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.5
                            @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                                return new RecyclerView.LayoutParams(-1, MoorDensityUtil.dp2px(45.0f));
                            }
                        };
                        this.mLayoutManager = pagerGridLayoutManager8;
                        textViewHolder.mRecyclerView.setLayoutManager(pagerGridLayoutManager8);
                    } else if (arrayList3.size() < 9 && arrayList3.size() > 6) {
                        ViewGroup.LayoutParams layoutParams10 = textViewHolder.ll_flow.getLayoutParams();
                        layoutParams10.height = MoorDensityUtil.dp2px(200.0f);
                        textViewHolder.ll_flow.setLayoutParams(layoutParams10);
                        PagerGridLayoutManager pagerGridLayoutManager9 = new PagerGridLayoutManager(4, this.mColumns, 0) { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.6
                            @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                                return new RecyclerView.LayoutParams(-1, MoorDensityUtil.dp2px(110.0f));
                            }
                        };
                        this.mLayoutManager = pagerGridLayoutManager9;
                        textViewHolder.mRecyclerView.setLayoutManager(pagerGridLayoutManager9);
                    } else {
                        ViewGroup.LayoutParams layoutParams11 = textViewHolder.ll_flow.getLayoutParams();
                        layoutParams11.height = MoorDensityUtil.dp2px(236.0f);
                        textViewHolder.ll_flow.setLayoutParams(layoutParams11);
                        PagerGridLayoutManager pagerGridLayoutManager10 = new PagerGridLayoutManager(this.mRows, this.mColumns, 1) { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.7
                            @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                                return new RecyclerView.LayoutParams(-1, MoorDensityUtil.dp2px(200.0f));
                            }
                        };
                        this.mLayoutManager = pagerGridLayoutManager10;
                        textViewHolder.mRecyclerView.setLayoutManager(pagerGridLayoutManager10);
                    }
                    PagerGridSnapHelper pagerGridSnapHelper2 = new PagerGridSnapHelper();
                    if (textViewHolder.mRecyclerView.getOnFlingListener() == null) {
                        pagerGridSnapHelper2.attachToRecyclerView(textViewHolder.mRecyclerView);
                    }
                    this.flowAdapter = new FlowAdapter(context, arrayList3, fromToMessage.flowMultiSelect, fromToMessage, new FlowAdapter.OnItemClickListenr() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.8
                        @Override // com.m7.imkfsdk.chat.adapter.FlowAdapter.OnItemClickListenr
                        public void setOnButtonClickListenr(int i7, boolean z, String str2) {
                            if (fromToMessage.flowMultiSelect) {
                                if (i7 < arrayList3.size()) {
                                    ((FlowBean) arrayList3.get(i7)).setChoose(z);
                                    fromToMessage.flowList = new Gson().z(arrayList3);
                                    if (z) {
                                        hashMap2.put(Integer.valueOf(i7), arrayList3.get(i7));
                                    } else {
                                        hashMap2.remove(Integer.valueOf(i7));
                                    }
                                    TextView tv_multi_count3 = textViewHolder.getTv_multi_count();
                                    tv_multi_count3.setText(hashMap2.size() + "");
                                    return;
                                }
                                return;
                            }
                            ((ChatActivity) context).sendXbotTextMsg(str2);
                        }
                    });
                    MoorLogUtils.aTag("flowlist", Integer.valueOf(arrayList3.size()));
                    textViewHolder.mRecyclerView.setAdapter(this.flowAdapter);
                    int size2 = arrayList3.size() / 8;
                    if (arrayList3.size() % 8 > 0) {
                        size2++;
                    }
                    textViewHolder.pointBottomView.setFillColor(context.getResources().getColor(R.color.ykfsdk_pointed));
                    textViewHolder.pointBottomView.initData(size2, 0);
                    this.mLayoutManager.setPageListener(new PagerGridLayoutManager.PageListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.9
                        @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager.PageListener
                        public void onPageSelect(int i7) {
                            TextRxChatRow.this.mCurrent = i7;
                            textViewHolder.pointBottomView.setCurrentPage(i7);
                        }

                        @Override // com.m7.imkfsdk.view.widget.PagerGridLayoutManager.PageListener
                        public void onPageSizeChanged(int i7) {
                            TextRxChatRow.this.mTotal = i7;
                        }
                    });
                    return;
                }
                textViewHolder.ll_flow.setVisibility(8);
                textViewHolder.chat_rl_robot.setVisibility(8);
                textViewHolder.chat_rl_robot_result.setVisibility(8);
                if (fromToMessage.showHtml.booleanValue()) {
                    initImgandText(fromToMessage.flowTip, textViewHolder);
                }
                ArrayList arrayList4 = (ArrayList) new Gson().o(fromToMessage.flowList, new a<ArrayList<FlowBean>>() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.20
                }.getType());
                int i7 = 0;
                while (i7 < arrayList4.size()) {
                    TextView textView2 = new TextView(context);
                    StringBuilder sb3 = new StringBuilder();
                    int i8 = i7 + 1;
                    sb3.append(i8);
                    sb3.append(". ");
                    sb3.append(((FlowBean) arrayList4.get(i7)).getButton());
                    String sb4 = sb3.toString();
                    SpannableString spannableString2 = new SpannableString(sb4);
                    spannableString2.setSpan(new XbotClickSpan(((FlowBean) arrayList4.get(i7)).getText(), (ChatActivity) context), 0, sb4.length(), 17);
                    spannableString2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.ykfsdk_lite_blue)), 0, sb4.length(), 17);
                    textView2.setText(spannableString2);
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    textViewHolder.getDescLinearLayout().addView(textView2);
                    i7 = i8;
                }
                return;
            }
            textViewHolder.ll_flow.setVisibility(8);
            if (fromToMessage.showHtml.booleanValue()) {
                parserImg(fromToMessage, textViewHolder);
                if (fromToMessage.showHtml.booleanValue()) {
                    initImgandText(fromToMessage.message, textViewHolder);
                }
                if (!"".equals(MoorNullUtil.checkNull(fromToMessage.questionId))) {
                    textViewHolder.chat_rl_robot.setVisibility(0);
                    if ("useful".equals(MoorNullUtil.checkNull(fromToMessage.robotPingjia))) {
                        textViewHolder.chat_iv_robot_useful.setImageResource(R.drawable.ykfsdk_robot_useful_blue);
                        textViewHolder.chat_tv_robot_useful.setTextColor(context.getResources().getColor(R.color.ykfsdk_all_white));
                        textViewHolder.chat_iv_robot_useless.setImageResource(R.drawable.ykfsdk_kf_robot_useless_grey);
                        textViewHolder.chat_tv_robot_useless.setTextColor(context.getResources().getColor(R.color.ykfsdk_ykf_help_unno));
                        textViewHolder.chat_rl_robot_result.setVisibility(0);
                        textViewHolder.chat_ll_robot_useful.setOnClickListener(null);
                        textViewHolder.chat_ll_robot_useless.setOnClickListener(null);
                        if (TextUtils.isEmpty(fromToMessage.fingerUp)) {
                            textViewHolder.chat_tv_robot_result.setText(R.string.ykfsdk_thinks_01);
                            return;
                        } else {
                            textViewHolder.chat_tv_robot_result.setText(fromToMessage.fingerUp);
                            return;
                        }
                    } else if ("useless".equals(MoorNullUtil.checkNull(fromToMessage.robotPingjia))) {
                        textViewHolder.chat_iv_robot_useful.setImageResource(R.drawable.ykfsdk_kf_robot_useful_grey);
                        textViewHolder.chat_tv_robot_useful.setTextColor(context.getResources().getColor(R.color.ykfsdk_ykf_help_unyes));
                        textViewHolder.chat_iv_robot_useless.setImageResource(R.drawable.ykfsdk_kf_robot_useless_blue);
                        textViewHolder.chat_tv_robot_useless.setTextColor(context.getResources().getColor(R.color.ykfsdk_all_white));
                        textViewHolder.chat_rl_robot_result.setVisibility(0);
                        textViewHolder.chat_ll_robot_useful.setOnClickListener(null);
                        textViewHolder.chat_ll_robot_useless.setOnClickListener(null);
                        if (TextUtils.isEmpty(fromToMessage.fingerDown)) {
                            textViewHolder.chat_tv_robot_result.setText(R.string.ykfsdk_thinks_02);
                            return;
                        } else {
                            textViewHolder.chat_tv_robot_result.setText(fromToMessage.fingerDown);
                            return;
                        }
                    } else {
                        textViewHolder.chat_iv_robot_useful.setImageResource(R.drawable.ykfsdk_kf_robot_useful_grey);
                        textViewHolder.chat_tv_robot_useful.setTextColor(context.getResources().getColor(R.color.ykfsdk_ykf_help_unyes));
                        textViewHolder.chat_iv_robot_useless.setImageResource(R.drawable.ykfsdk_kf_robot_useless_grey);
                        textViewHolder.chat_tv_robot_useless.setTextColor(context.getResources().getColor(R.color.ykfsdk_ykf_help_unno));
                        textViewHolder.chat_rl_robot_result.setVisibility(8);
                        textViewHolder.chat_ll_robot_useful.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.21
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                fromToMessage.robotPingjia = "useful";
                                MessageDao.getInstance().updateMsgToDao(fromToMessage);
                                ((ChatActivity) context).updateMessage();
                                if ("".equals(MoorNullUtil.checkNull(fromToMessage.questionId))) {
                                    return;
                                }
                                if ("xbot".equals(MoorNullUtil.checkNull(fromToMessage.robotType))) {
                                    IMChatManager.getInstance().sendRobotCsr(MoorNullUtil.checkNull(fromToMessage.questionId), MoorNullUtil.checkNull(fromToMessage.std_question), MoorNullUtil.checkNull(fromToMessage.robotType), MoorNullUtil.checkNull(fromToMessage.robotId), "1", MoorNullUtil.checkNull(fromToMessage.sid), MoorNullUtil.checkNull(fromToMessage.ori_question), MoorNullUtil.checkNull(fromToMessage.std_question), MoorNullUtil.checkNull(fromToMessage.message), MoorNullUtil.checkNull(fromToMessage.confidence), MoorNullUtil.checkNull(fromToMessage.sessionId));
                                } else {
                                    IMChatManager.getInstance().sendRobotCsr(MoorNullUtil.checkNull(fromToMessage.questionId), MoorNullUtil.checkNull(fromToMessage.robotType), MoorNullUtil.checkNull(fromToMessage.robotId), MoorNullUtil.checkNull(fromToMessage.robotMsgId), "useful");
                                }
                            }
                        });
                        textViewHolder.chat_ll_robot_useless.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.22
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                fromToMessage.robotPingjia = "useless";
                                MessageDao.getInstance().updateMsgToDao(fromToMessage);
                                ((ChatActivity) context).updateMessage();
                                if ("".equals(MoorNullUtil.checkNull(fromToMessage.questionId))) {
                                    return;
                                }
                                if ("xbot".equals(MoorNullUtil.checkNull(fromToMessage.robotType))) {
                                    IMChatManager.getInstance().sendRobotCsr(MoorNullUtil.checkNull(fromToMessage.questionId), MoorNullUtil.checkNull(fromToMessage.std_question), MoorNullUtil.checkNull(fromToMessage.robotType), MoorNullUtil.checkNull(fromToMessage.robotId), "0", MoorNullUtil.checkNull(fromToMessage.sid), MoorNullUtil.checkNull(fromToMessage.ori_question), MoorNullUtil.checkNull(fromToMessage.std_question), MoorNullUtil.checkNull(fromToMessage.message), MoorNullUtil.checkNull(fromToMessage.confidence), MoorNullUtil.checkNull(fromToMessage.sessionId));
                                } else {
                                    IMChatManager.getInstance().sendRobotCsr(MoorNullUtil.checkNull(fromToMessage.questionId), MoorNullUtil.checkNull(fromToMessage.robotType), MoorNullUtil.checkNull(fromToMessage.robotId), MoorNullUtil.checkNull(fromToMessage.robotMsgId), "useless");
                                }
                            }
                        });
                        return;
                    }
                }
                textViewHolder.chat_rl_robot.setVisibility(8);
                textViewHolder.chat_rl_robot_result.setVisibility(8);
                return;
            }
            textViewHolder.chat_rl_robot.setVisibility(8);
            textViewHolder.chat_rl_robot_result.setVisibility(8);
            TextView textView3 = new TextView(context);
            textView3.setTextColor(context.getResources().getColor(R.color.ykfsdk_color_333333));
            textView3.setTextSize(2, 14.0f);
            textView3.setLineSpacing(0.0f, 1.1f);
            String a_String = setA_String(handler(textView3, fromToMessage.message).toString());
            FaceConversionUtil instace = FaceConversionUtil.getInstace();
            SpannableStringBuilder expressionString = instace.getExpressionString(context, a_String + "", textView3);
            Pattern compile = Pattern.compile("\\[([^\\]]*)\\]\\(([^\\)]*)\\)", 2);
            Matcher matcher = compile.matcher(expressionString);
            while (matcher.find()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                if (checkURL(group2)) {
                    expressionString.replace(matcher.start(), matcher.end(), (CharSequence) group);
                    expressionString.setSpan(new AClickApan(group2), matcher.start(), matcher.start() + group.length(), 17);
                    expressionString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.ykfsdk_lite_blue)), matcher.start(), matcher.start() + group.length(), 17);
                    matcher = compile.matcher(expressionString);
                }
            }
            Matcher matcher2 = Pattern.compile("((http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)|(www.[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)|(((http[s]{0,1}|ftp)://|)((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)", 2).matcher(expressionString);
            while (matcher2.find()) {
                String group3 = matcher2.group();
                int start = matcher2.start() + group3.length();
                expressionString.setSpan(new HttpClickSpan(group3), matcher2.start(), start, 17);
                expressionString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.ykfsdk_lite_blue)), matcher2.start(), start, 17);
            }
            Matcher matcher3 = Pattern.compile(RegexUtils.isPhoneRegexp(), 2).matcher(expressionString);
            while (matcher3.find()) {
                String group4 = matcher3.group();
                int start2 = matcher3.start() + group4.length();
                expressionString.setSpan(new NumClickSpan(group4), matcher3.start(), start2, 17);
                expressionString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.ykfsdk_lite_blue)), matcher3.start(), start2, 17);
            }
            textView3.setText(expressionString);
            textView3.setMovementMethod(LinkMovementMethod.getInstance());
            textViewHolder.getDescLinearLayout().addView(textView3);
            textView3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextRxChatRow.23
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    TextRxChatRow.this.showPopWindows(view, fromToMessage.message);
                    return true;
                }
            });
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.TEXT_ROW_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
