package com.effective.android.panel.log;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.v.u;
import h.t2.q;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00060\u0010j\u0002`\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/effective/android/panel/log/LogFormatter;", "", "", "key", "value", "addContent", "(Ljava/lang/String;Ljava/lang/String;)Lcom/effective/android/panel/log/LogFormatter;", RemoteMessageConst.Notification.TAG, "Lh/t1;", "log", "(Ljava/lang/String;)V", "defaultKey", "Ljava/lang/String;", "", "keyLength", ExpandableTextView.P, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "stringBuilder", "Ljava/lang/StringBuilder;", "<init>", "(I)V", "Companion", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LogFormatter {
    public static final Companion Companion = new Companion(null);
    private int keyLength;
    private final StringBuilder stringBuilder = new StringBuilder();
    private final String defaultKey = "                                                                                                    ";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/effective/android/panel/log/LogFormatter$Companion;", "", "", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "Lcom/effective/android/panel/log/LogFormatter;", "setUp", "(I)Lcom/effective/android/panel/log/LogFormatter;", "<init>", "()V", "panel_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ LogFormatter setUp$default(Companion companion, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = 50;
            }
            return companion.setUp(i2);
        }

        @d
        public final LogFormatter setUp(int i2) {
            return new LogFormatter(i2);
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public LogFormatter(int i2) {
        this.keyLength = i2;
    }

    public static /* synthetic */ LogFormatter addContent$default(LogFormatter logFormatter, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return logFormatter.addContent(str, str2);
    }

    @d
    public final LogFormatter addContent(@d String str, @d String str2) {
        if (str.length() == 0) {
            StringBuilder sb = this.stringBuilder;
            sb.append(str2 + " \n");
        } else if (str.length() < this.keyLength) {
            StringBuilder sb2 = this.stringBuilder;
            sb2.append(str + this.defaultKey.subSequence(0, this.keyLength - str.length()) + " = " + str2 + " \n");
        } else {
            StringBuilder sb3 = this.stringBuilder;
            sb3.append(str + " = " + str2 + " \n");
        }
        return this;
    }

    public final void log(@d String str) {
        LogTracker.log(str, this.stringBuilder.toString());
        q.Y(this.stringBuilder);
    }
}
