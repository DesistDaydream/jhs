package com.vector;

import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/vector/FileSuffix;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "TXT", "XML", "HTML", "JPEG", "PNG", "JS", "PPT", "PPTX", "PDF", "AMR", "MP4", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public enum FileSuffix {
    TXT(".txt"),
    XML(".xml"),
    HTML(".html"),
    JPEG(".jpg"),
    PNG(".png"),
    JS(".js"),
    PPT(".ppt"),
    PPTX(".pptx"),
    PDF(".pdf"),
    AMR(".amr"),
    MP4(".mp4");
    
    @d
    private final String text;

    FileSuffix(String str) {
        this.text = str;
    }

    @d
    public final String getText() {
        return this.text;
    }
}
