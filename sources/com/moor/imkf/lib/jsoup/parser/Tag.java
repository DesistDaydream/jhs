package com.moor.imkf.lib.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.internal.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.constant.b;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.Normalizer;
import com.moor.imkf.model.entity.FromToMessage;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.umeng.analytics.pro.am;
import com.vector.util.IntentAction;
import e.t.u.b0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class Tag implements Cloneable {
    private static final String[] blockTags;
    private static final String[] emptyTags;
    private static final String[] formListedTags;
    private static final String[] formSubmitTags;
    private static final String[] formatAsInlineTags;
    private static final String[] inlineTags;
    private static final String[] preserveWhitespaceTags;
    private static final Map<String, Tag> tags = new HashMap();
    private String normalName;
    private String tagName;
    private boolean isBlock = true;
    private boolean formatAsBlock = true;
    private boolean empty = false;
    private boolean selfClosing = false;
    private boolean preserveWhitespace = false;
    private boolean formList = false;
    private boolean formSubmit = false;

    static {
        String[] strArr = {a.f1401f, "head", "body", "frameset", "script", "noscript", "style", TTDownloadField.TT_META, "link", "title", TypedValues.Attributes.S_FRAME, "noframes", "section", "nav", "aside", "hgroup", "header", "footer", am.ax, "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", b0.a.f14655f, AppIconSetting.LARGE_ICON_URL, "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", TimeDisplaySetting.TIME_DISPLAY, "video", TUIConstants.TUICalling.TYPE_AUDIO, "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math", "center"};
        blockTags = strArr;
        inlineTags = new String[]{"object", "base", "font", PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, "i", "b", am.aH, "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", am.av, IntentAction.o.f7891j, BrightRemindSetting.BRIGHT_REMIND, "wbr", "map", "q", "sub", "sup", "bdo", FromToMessage.MSG_TYPE_IFRAME, "embed", "span", "input", "select", "textarea", TTDownloadField.TT_LABEL, "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", RemoteMessageConst.MessageBody.PARAM, MessageKey.MSG_SOURCE, "track", "summary", b.y, "device", "area", "basefont", "bgsound", "menuitem", RemoteMessageConst.MessageBody.PARAM, MessageKey.MSG_SOURCE, "track", "data", "bdi", "s"};
        emptyTags = new String[]{TTDownloadField.TT_META, "link", "base", TypedValues.Attributes.S_FRAME, IntentAction.o.f7891j, BrightRemindSetting.BRIGHT_REMIND, "wbr", "embed", "hr", "input", "keygen", "col", b.y, "device", "area", "basefont", "bgsound", "menuitem", RemoteMessageConst.MessageBody.PARAM, MessageKey.MSG_SOURCE, "track"};
        formatAsInlineTags = new String[]{"title", am.av, am.ax, "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", AppIconSetting.LARGE_ICON_URL, "th", TimeDisplaySetting.TIME_DISPLAY, "script", "style", "ins", "del", "s"};
        preserveWhitespaceTags = new String[]{"pre", "plaintext", "title", "textarea"};
        formListedTags = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        formSubmitTags = new String[]{"input", "keygen", "object", "select", "textarea"};
        for (String str : strArr) {
            register(new Tag(str));
        }
        for (String str2 : inlineTags) {
            Tag tag = new Tag(str2);
            tag.isBlock = false;
            tag.formatAsBlock = false;
            register(tag);
        }
        for (String str3 : emptyTags) {
            Tag tag2 = tags.get(str3);
            Validate.notNull(tag2);
            tag2.empty = true;
        }
        for (String str4 : formatAsInlineTags) {
            Tag tag3 = tags.get(str4);
            Validate.notNull(tag3);
            tag3.formatAsBlock = false;
        }
        for (String str5 : preserveWhitespaceTags) {
            Tag tag4 = tags.get(str5);
            Validate.notNull(tag4);
            tag4.preserveWhitespace = true;
        }
        for (String str6 : formListedTags) {
            Tag tag5 = tags.get(str6);
            Validate.notNull(tag5);
            tag5.formList = true;
        }
        for (String str7 : formSubmitTags) {
            Tag tag6 = tags.get(str7);
            Validate.notNull(tag6);
            tag6.formSubmit = true;
        }
    }

    private Tag(String str) {
        this.tagName = str;
        this.normalName = Normalizer.lowerCase(str);
    }

    private static void register(Tag tag) {
        tags.put(tag.tagName, tag);
    }

    public static Tag valueOf(String str, ParseSettings parseSettings) {
        Validate.notNull(str);
        Map<String, Tag> map = tags;
        Tag tag = map.get(str);
        if (tag == null) {
            String normalizeTag = parseSettings.normalizeTag(str);
            Validate.notEmpty(normalizeTag);
            String lowerCase = Normalizer.lowerCase(normalizeTag);
            Tag tag2 = map.get(lowerCase);
            if (tag2 == null) {
                Tag tag3 = new Tag(normalizeTag);
                tag3.isBlock = false;
                return tag3;
            } else if (!parseSettings.preserveTagCase() || normalizeTag.equals(lowerCase)) {
                return tag2;
            } else {
                Tag m37clone = tag2.m37clone();
                m37clone.tagName = normalizeTag;
                return m37clone;
            }
        }
        return tag;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Tag) {
            Tag tag = (Tag) obj;
            return this.tagName.equals(tag.tagName) && this.empty == tag.empty && this.formatAsBlock == tag.formatAsBlock && this.isBlock == tag.isBlock && this.preserveWhitespace == tag.preserveWhitespace && this.selfClosing == tag.selfClosing && this.formList == tag.formList && this.formSubmit == tag.formSubmit;
        }
        return false;
    }

    public boolean formatAsBlock() {
        return this.formatAsBlock;
    }

    public String getName() {
        return this.tagName;
    }

    public int hashCode() {
        return (((((((((((((this.tagName.hashCode() * 31) + (this.isBlock ? 1 : 0)) * 31) + (this.formatAsBlock ? 1 : 0)) * 31) + (this.empty ? 1 : 0)) * 31) + (this.selfClosing ? 1 : 0)) * 31) + (this.preserveWhitespace ? 1 : 0)) * 31) + (this.formList ? 1 : 0)) * 31) + (this.formSubmit ? 1 : 0);
    }

    public boolean isBlock() {
        return this.isBlock;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isFormListed() {
        return this.formList;
    }

    public boolean isFormSubmittable() {
        return this.formSubmit;
    }

    public boolean isInline() {
        return !this.isBlock;
    }

    public boolean isKnownTag() {
        return tags.containsKey(this.tagName);
    }

    public boolean isSelfClosing() {
        return this.empty || this.selfClosing;
    }

    public String normalName() {
        return this.normalName;
    }

    public boolean preserveWhitespace() {
        return this.preserveWhitespace;
    }

    public Tag setSelfClosing() {
        this.selfClosing = true;
        return this;
    }

    public String toString() {
        return this.tagName;
    }

    public static boolean isKnownTag(String str) {
        return tags.containsKey(str);
    }

    /* renamed from: clone */
    public Tag m37clone() {
        try {
            return (Tag) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Tag valueOf(String str) {
        return valueOf(str, ParseSettings.preserveCase);
    }
}
