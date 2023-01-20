package com.tencent.qcloud.tuicore;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import e.j.e.r.c;
import h.k2.v.u;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/tencent/qcloud/tuicore/GlobalConfig;", "", "warehouseIntro", "", PushConstants.URI_PACKAGE_NAME, "officials", "", "imNotice", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getImNotice", "()Ljava/lang/String;", "setImNotice", "(Ljava/lang/String;)V", "getOfficials", "()Ljava/util/List;", "setOfficials", "(Ljava/util/List;)V", "getPk", "setPk", "getWarehouseIntro", "setWarehouseIntro", "tuicore_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GlobalConfig {
    @c("chat_notice")
    @e
    private String imNotice;
    @c("official_uid_list")
    @e
    private List<String> officials;
    @c("rsa_public_key")
    @e
    private String pk;
    @c("warehouse_instruction")
    @e
    private String warehouseIntro;

    public GlobalConfig() {
        this(null, null, null, null, 15, null);
    }

    public GlobalConfig(@e String str, @e String str2, @e List<String> list, @e String str3) {
        this.warehouseIntro = str;
        this.pk = str2;
        this.officials = list;
        this.imNotice = str3;
    }

    @e
    public final String getImNotice() {
        return this.imNotice;
    }

    @e
    public final List<String> getOfficials() {
        return this.officials;
    }

    @e
    public final String getPk() {
        return this.pk;
    }

    @e
    public final String getWarehouseIntro() {
        return this.warehouseIntro;
    }

    public final void setImNotice(@e String str) {
        this.imNotice = str;
    }

    public final void setOfficials(@e List<String> list) {
        this.officials = list;
    }

    public final void setPk(@e String str) {
        this.pk = str;
    }

    public final void setWarehouseIntro(@e String str) {
        this.warehouseIntro = str;
    }

    public /* synthetic */ GlobalConfig(String str, String str2, List list, String str3, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : str3);
    }
}
