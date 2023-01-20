package com.moor.imkf.lib.jsoup.nodes;

import com.moor.imkf.lib.jsoup.SerializationException;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Document;
import h.t2.y;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public class Attribute implements Map.Entry<String, String>, Cloneable {
    private static final String[] booleanAttributes = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    private String key;
    public Attributes parent;
    private String val;

    public Attribute(String str, String str2) {
        this(str, str2, null);
    }

    public static Attribute createFromEncoded(String str, String str2) {
        return new Attribute(str, Entities.unescape(str2, true), null);
    }

    public static boolean isBooleanAttribute(String str) {
        return Arrays.binarySearch(booleanAttributes, str) >= 0;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        String str = this.key;
        if (str == null ? attribute.key == null : str.equals(attribute.key)) {
            String str2 = this.val;
            String str3 = attribute.val;
            return str2 != null ? str2.equals(str3) : str3 == null;
        }
        return false;
    }

    public boolean hasDeclaredValue() {
        return this.val != null;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.key;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.val;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String html() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        try {
            html(borrowBuilder, new Document("").outputSettings());
            return StringUtil.releaseBuilder(borrowBuilder);
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    public boolean isDataAttribute() {
        return isDataAttribute(this.key);
    }

    public void setKey(String str) {
        int indexOfKey;
        Validate.notNull(str);
        String trim = str.trim();
        Validate.notEmpty(trim);
        Attributes attributes = this.parent;
        if (attributes != null && (indexOfKey = attributes.indexOfKey(this.key)) != -1) {
            this.parent.keys[indexOfKey] = trim;
        }
        this.key = trim;
    }

    public final boolean shouldCollapseAttribute(Document.OutputSettings outputSettings) {
        return shouldCollapseAttribute(this.key, this.val, outputSettings);
    }

    public String toString() {
        return html();
    }

    public Attribute(String str, String str2, Attributes attributes) {
        Validate.notNull(str);
        String trim = str.trim();
        Validate.notEmpty(trim);
        this.key = trim;
        this.val = str2;
        this.parent = attributes;
    }

    public static boolean isDataAttribute(String str) {
        return str.startsWith(Attributes.dataPrefix) && str.length() > 5;
    }

    public static boolean shouldCollapseAttribute(String str, String str2, Document.OutputSettings outputSettings) {
        return outputSettings.syntax() == Document.OutputSettings.Syntax.html && (str2 == null || (("".equals(str2) || str2.equalsIgnoreCase(str)) && isBooleanAttribute(str)));
    }

    /* renamed from: clone */
    public Attribute m33clone() {
        try {
            return (Attribute) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.util.Map.Entry
    public String getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public String getValue() {
        return Attributes.checkNotNull(this.val);
    }

    @Override // java.util.Map.Entry
    public String setValue(String str) {
        String str2 = this.val;
        Attributes attributes = this.parent;
        if (attributes != null) {
            str2 = attributes.get(this.key);
            int indexOfKey = this.parent.indexOfKey(this.key);
            if (indexOfKey != -1) {
                this.parent.vals[indexOfKey] = str;
            }
        }
        this.val = str;
        return Attributes.checkNotNull(str2);
    }

    public static void html(String str, String str2, Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(str);
        if (shouldCollapseAttribute(str, str2, outputSettings)) {
            return;
        }
        appendable.append("=\"");
        Entities.escape(appendable, Attributes.checkNotNull(str2), outputSettings, true, false, false);
        appendable.append(y.a);
    }

    public void html(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        html(this.key, this.val, appendable, outputSettings);
    }
}
