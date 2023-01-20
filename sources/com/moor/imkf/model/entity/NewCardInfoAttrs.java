package com.moor.imkf.model.entity;

import com.qiniu.android.common.Constants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: classes2.dex */
public class NewCardInfoAttrs implements Serializable {
    private String color;
    private String content;

    private String decode(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    return URLDecoder.decode(str, Constants.UTF_8);
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public String getColor() {
        return decode(this.color);
    }

    public String getContent() {
        return decode(this.content);
    }

    public NewCardInfoAttrs setColor(String str) {
        this.color = str;
        return this;
    }

    public NewCardInfoAttrs setContent(String str) {
        this.content = str;
        return this;
    }
}
