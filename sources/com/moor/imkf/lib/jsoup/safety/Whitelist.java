package com.moor.imkf.lib.jsoup.safety;

import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.Normalizer;
import com.moor.imkf.lib.jsoup.nodes.Attribute;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.moor.imkf.lib.jsoup.nodes.Element;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import com.vector.util.IntentAction;
import com.xiaomi.mipush.sdk.Constants;
import e.t.u.b0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class Whitelist {
    private Set<TagName> tagNames = new HashSet();
    private Map<TagName, Set<AttributeKey>> attributes = new HashMap();
    private Map<TagName, Map<AttributeKey, AttributeValue>> enforcedAttributes = new HashMap();
    private Map<TagName, Map<AttributeKey, Set<Protocol>>> protocols = new HashMap();
    private boolean preserveRelativeLinks = false;

    /* loaded from: classes2.dex */
    public static class AttributeKey extends TypedValue {
        public AttributeKey(String str) {
            super(str);
        }

        public static AttributeKey valueOf(String str) {
            return new AttributeKey(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class AttributeValue extends TypedValue {
        public AttributeValue(String str) {
            super(str);
        }

        public static AttributeValue valueOf(String str) {
            return new AttributeValue(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class Protocol extends TypedValue {
        public Protocol(String str) {
            super(str);
        }

        public static Protocol valueOf(String str) {
            return new Protocol(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class TagName extends TypedValue {
        public TagName(String str) {
            super(str);
        }

        public static TagName valueOf(String str) {
            return new TagName(str);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class TypedValue {
        private String value;

        public TypedValue(String str) {
            Validate.notNull(str);
            this.value = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                TypedValue typedValue = (TypedValue) obj;
                String str = this.value;
                if (str == null) {
                    return typedValue.value == null;
                }
                return str.equals(typedValue.value);
            }
            return false;
        }

        public int hashCode() {
            String str = this.value;
            return 31 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return this.value;
        }
    }

    public static Whitelist basic() {
        return new Whitelist().addTags(am.av, "b", "blockquote", BrightRemindSetting.BRIGHT_REMIND, "cite", "code", b0.a.f14655f, "dl", "dt", "em", "i", AppIconSetting.LARGE_ICON_URL, "ol", am.ax, "pre", "q", "small", "span", "strike", "strong", "sub", "sup", am.aH, "ul").addAttributes(am.av, "href").addAttributes("blockquote", "cite").addAttributes("q", "cite").addProtocols(am.av, "href", "ftp", "http", "https", "mailto").addProtocols("blockquote", "cite", "http", "https").addProtocols("cite", "cite", "http", "https").addEnforcedAttribute(am.av, "rel", "nofollow");
    }

    public static Whitelist basicWithImages() {
        return basic().addTags(IntentAction.o.f7891j).addAttributes(IntentAction.o.f7891j, "align", "alt", "height", "src", "title", "width").addProtocols(IntentAction.o.f7891j, "src", "http", "https");
    }

    private boolean isValidAnchor(String str) {
        return str.startsWith(MqttTopic.MULTI_LEVEL_WILDCARD) && !str.matches(".*\\s.*");
    }

    public static Whitelist none() {
        return new Whitelist();
    }

    public static Whitelist relaxed() {
        return new Whitelist().addTags(am.av, "b", "blockquote", BrightRemindSetting.BRIGHT_REMIND, "caption", "cite", "code", "col", "colgroup", b0.a.f14655f, "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6", "i", IntentAction.o.f7891j, AppIconSetting.LARGE_ICON_URL, "ol", am.ax, "pre", "q", "small", "span", "strike", "strong", "sub", "sup", "table", "tbody", TimeDisplaySetting.TIME_DISPLAY, "tfoot", "th", "thead", "tr", am.aH, "ul").addAttributes(am.av, "href", "title").addAttributes("blockquote", "cite").addAttributes("col", "span", "width").addAttributes("colgroup", "span", "width").addAttributes(IntentAction.o.f7891j, "align", "alt", "height", "src", "title", "width").addAttributes("ol", MessageKey.MSG_ACCEPT_TIME_START, "type").addAttributes("q", "cite").addAttributes("table", "summary", "width").addAttributes(TimeDisplaySetting.TIME_DISPLAY, "abbr", "axis", "colspan", "rowspan", "width").addAttributes("th", "abbr", "axis", "colspan", "rowspan", "scope", "width").addAttributes("ul", "type").addProtocols(am.av, "href", "ftp", "http", "https", "mailto").addProtocols("blockquote", "cite", "http", "https").addProtocols("cite", "cite", "http", "https").addProtocols(IntentAction.o.f7891j, "src", "http", "https").addProtocols("q", "cite", "http", "https");
    }

    public static Whitelist simpleText() {
        return new Whitelist().addTags("b", "em", "i", "strong", am.aH);
    }

    private boolean testValidProtocol(Element element, Attribute attribute, Set<Protocol> set) {
        String absUrl = element.absUrl(attribute.getKey());
        if (absUrl.length() == 0) {
            absUrl = attribute.getValue();
        }
        if (!this.preserveRelativeLinks) {
            attribute.setValue(absUrl);
        }
        for (Protocol protocol : set) {
            String typedValue = protocol.toString();
            if (typedValue.equals(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                if (isValidAnchor(absUrl)) {
                    return true;
                }
            } else {
                if (Normalizer.lowerCase(absUrl).startsWith(typedValue + Constants.COLON_SEPARATOR)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Whitelist addAttributes(String str, String... strArr) {
        Validate.notEmpty(str);
        Validate.notNull(strArr);
        Validate.isTrue(strArr.length > 0, "No attribute names supplied.");
        TagName valueOf = TagName.valueOf(str);
        this.tagNames.add(valueOf);
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.notEmpty(str2);
            hashSet.add(AttributeKey.valueOf(str2));
        }
        if (this.attributes.containsKey(valueOf)) {
            this.attributes.get(valueOf).addAll(hashSet);
        } else {
            this.attributes.put(valueOf, hashSet);
        }
        return this;
    }

    public Whitelist addEnforcedAttribute(String str, String str2, String str3) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notEmpty(str3);
        TagName valueOf = TagName.valueOf(str);
        this.tagNames.add(valueOf);
        AttributeKey valueOf2 = AttributeKey.valueOf(str2);
        AttributeValue valueOf3 = AttributeValue.valueOf(str3);
        if (this.enforcedAttributes.containsKey(valueOf)) {
            this.enforcedAttributes.get(valueOf).put(valueOf2, valueOf3);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(valueOf2, valueOf3);
            this.enforcedAttributes.put(valueOf, hashMap);
        }
        return this;
    }

    public Whitelist addProtocols(String str, String str2, String... strArr) {
        Map<AttributeKey, Set<Protocol>> map;
        Set<Protocol> set;
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notNull(strArr);
        TagName valueOf = TagName.valueOf(str);
        AttributeKey valueOf2 = AttributeKey.valueOf(str2);
        if (this.protocols.containsKey(valueOf)) {
            map = this.protocols.get(valueOf);
        } else {
            HashMap hashMap = new HashMap();
            this.protocols.put(valueOf, hashMap);
            map = hashMap;
        }
        if (map.containsKey(valueOf2)) {
            set = map.get(valueOf2);
        } else {
            HashSet hashSet = new HashSet();
            map.put(valueOf2, hashSet);
            set = hashSet;
        }
        for (String str3 : strArr) {
            Validate.notEmpty(str3);
            set.add(Protocol.valueOf(str3));
        }
        return this;
    }

    public Whitelist addTags(String... strArr) {
        Validate.notNull(strArr);
        for (String str : strArr) {
            Validate.notEmpty(str);
            this.tagNames.add(TagName.valueOf(str));
        }
        return this;
    }

    public Attributes getEnforcedAttributes(String str) {
        Attributes attributes = new Attributes();
        TagName valueOf = TagName.valueOf(str);
        if (this.enforcedAttributes.containsKey(valueOf)) {
            for (Map.Entry<AttributeKey, AttributeValue> entry : this.enforcedAttributes.get(valueOf).entrySet()) {
                attributes.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return attributes;
    }

    public boolean isSafeAttribute(String str, Element element, Attribute attribute) {
        TagName valueOf = TagName.valueOf(str);
        AttributeKey valueOf2 = AttributeKey.valueOf(attribute.getKey());
        Set<AttributeKey> set = this.attributes.get(valueOf);
        if (set != null && set.contains(valueOf2)) {
            if (this.protocols.containsKey(valueOf)) {
                Map<AttributeKey, Set<Protocol>> map = this.protocols.get(valueOf);
                return !map.containsKey(valueOf2) || testValidProtocol(element, attribute, map.get(valueOf2));
            }
            return true;
        }
        if (this.enforcedAttributes.get(valueOf) != null) {
            Attributes enforcedAttributes = getEnforcedAttributes(str);
            String key = attribute.getKey();
            if (enforcedAttributes.hasKeyIgnoreCase(key)) {
                return enforcedAttributes.getIgnoreCase(key).equals(attribute.getValue());
            }
        }
        return !str.equals(":all") && isSafeAttribute(":all", element, attribute);
    }

    public boolean isSafeTag(String str) {
        return this.tagNames.contains(TagName.valueOf(str));
    }

    public Whitelist preserveRelativeLinks(boolean z) {
        this.preserveRelativeLinks = z;
        return this;
    }

    public Whitelist removeAttributes(String str, String... strArr) {
        Validate.notEmpty(str);
        Validate.notNull(strArr);
        Validate.isTrue(strArr.length > 0, "No attribute names supplied.");
        TagName valueOf = TagName.valueOf(str);
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.notEmpty(str2);
            hashSet.add(AttributeKey.valueOf(str2));
        }
        if (this.tagNames.contains(valueOf) && this.attributes.containsKey(valueOf)) {
            Set<AttributeKey> set = this.attributes.get(valueOf);
            set.removeAll(hashSet);
            if (set.isEmpty()) {
                this.attributes.remove(valueOf);
            }
        }
        if (str.equals(":all")) {
            for (TagName tagName : this.attributes.keySet()) {
                Set<AttributeKey> set2 = this.attributes.get(tagName);
                set2.removeAll(hashSet);
                if (set2.isEmpty()) {
                    this.attributes.remove(tagName);
                }
            }
        }
        return this;
    }

    public Whitelist removeEnforcedAttribute(String str, String str2) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        TagName valueOf = TagName.valueOf(str);
        if (this.tagNames.contains(valueOf) && this.enforcedAttributes.containsKey(valueOf)) {
            AttributeKey valueOf2 = AttributeKey.valueOf(str2);
            Map<AttributeKey, AttributeValue> map = this.enforcedAttributes.get(valueOf);
            map.remove(valueOf2);
            if (map.isEmpty()) {
                this.enforcedAttributes.remove(valueOf);
            }
        }
        return this;
    }

    public Whitelist removeProtocols(String str, String str2, String... strArr) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notNull(strArr);
        TagName valueOf = TagName.valueOf(str);
        AttributeKey valueOf2 = AttributeKey.valueOf(str2);
        Validate.isTrue(this.protocols.containsKey(valueOf), "Cannot remove a protocol that is not set.");
        Map<AttributeKey, Set<Protocol>> map = this.protocols.get(valueOf);
        Validate.isTrue(map.containsKey(valueOf2), "Cannot remove a protocol that is not set.");
        Set<Protocol> set = map.get(valueOf2);
        for (String str3 : strArr) {
            Validate.notEmpty(str3);
            set.remove(Protocol.valueOf(str3));
        }
        if (set.isEmpty()) {
            map.remove(valueOf2);
            if (map.isEmpty()) {
                this.protocols.remove(valueOf);
            }
        }
        return this;
    }

    public Whitelist removeTags(String... strArr) {
        Validate.notNull(strArr);
        for (String str : strArr) {
            Validate.notEmpty(str);
            TagName valueOf = TagName.valueOf(str);
            if (this.tagNames.remove(valueOf)) {
                this.attributes.remove(valueOf);
                this.enforcedAttributes.remove(valueOf);
                this.protocols.remove(valueOf);
            }
        }
        return this;
    }
}
