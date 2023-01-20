package com.tencent.imsdk.message;

/* loaded from: classes3.dex */
public class TextElement extends MessageBaseElement {
    private String textContent;

    public TextElement() {
        setElementType(1);
    }

    public String getTextContent() {
        return this.textContent;
    }

    public void setTextContent(String str) {
        this.textContent = str;
    }
}
