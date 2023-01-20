package com.jihuanshe.ui.page.user;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.BankDetail;
import com.tencent.android.tpns.mqtt.MqttTopic;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.j.a;
import e.l.s.o.b;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class ShopOwnerConfirmActivity$onCommit$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ShopOwnerConfirmActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$onCommit$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ ShopOwnerConfirmActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ShopOwnerConfirmActivity shopOwnerConfirmActivity) {
            super(1);
            this.this$0 = shopOwnerConfirmActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            e.l.h.j.b.e.b(this.this$0, R.string.confirm_shop_owner_commit_success, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            i.d(f.b, a.s, null, 2, null);
            this.this$0.finish();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopOwnerConfirmActivity$onCommit$1(ShopOwnerConfirmActivity shopOwnerConfirmActivity) {
        super(1);
        this.this$0 = shopOwnerConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        EditText o0;
        EditText w0;
        EditText m0;
        EditText k0;
        EditText j0;
        CheckBox l0;
        o0 = this.this$0.o0();
        String obj = o0.getText().toString();
        if (!(obj.length() == 0)) {
            w0 = this.this$0.w0();
            String obj2 = w0.getText().toString();
            if (!(obj2.length() == 0)) {
                m0 = this.this$0.m0();
                String obj3 = m0.getText().toString();
                if (obj3.length() == 0) {
                    e.l.h.j.b.e.h(this.this$0, "邮箱不能为空", null, null, null, 0, null, 62, null);
                    return;
                }
                String value = ((b) this.this$0.L()).Z0().getValue();
                String substring = value == null ? null : value.substring(StringsKt__StringsKt.r3(value, MqttTopic.TOPIC_LEVEL_SEPARATOR, 10, false, 4, null) + 1);
                if (substring == null) {
                    e.l.h.j.b.e.h(this.this$0, "请先上传营业执照", null, null, null, 0, null, 62, null);
                    return;
                }
                String value2 = ((b) this.this$0.L()).I0().getValue();
                String substring2 = value2 == null ? null : value2.substring(StringsKt__StringsKt.r3(value2, MqttTopic.TOPIC_LEVEL_SEPARATOR, 10, false, 4, null) + 1);
                if (substring2 == null) {
                    e.l.h.j.b.e.h(this.this$0, "请先上传身份证正面照", null, null, null, 0, null, 62, null);
                    return;
                }
                String value3 = ((b) this.this$0.L()).C0().getValue();
                String substring3 = value3 == null ? null : value3.substring(StringsKt__StringsKt.r3(value3, MqttTopic.TOPIC_LEVEL_SEPARATOR, 10, false, 4, null) + 1);
                if (substring3 == null) {
                    e.l.h.j.b.e.h(this.this$0, "请先上传身份证背面照", null, null, null, 0, null, 62, null);
                    return;
                }
                String value4 = ((b) this.this$0.L()).G0().getValue();
                if (value4 == null || value4.length() == 0) {
                    e.l.h.j.b.e.h(this.this$0, "请先选择开户银行", null, null, null, 0, null, 62, null);
                    return;
                }
                BankDetail value5 = ((b) this.this$0.L()).E0().getValue();
                if (!f0.g(value4, "其他银行") || value5 != null) {
                    k0 = this.this$0.k0();
                    String obj4 = k0.getText().toString();
                    if (!(obj4.length() == 0)) {
                        j0 = this.this$0.j0();
                        String obj5 = j0.getText().toString();
                        if (!(obj5.length() == 0)) {
                            l0 = this.this$0.l0();
                            if (!l0.isChecked()) {
                                e.l.h.j.b.e.h(this.this$0, "请先阅读并同意卖家入驻协议", null, null, null, 0, null, 62, null);
                                return;
                            } else {
                                BinderKt.p(BinderKt.k(e.g.d.a.j(((b) this.this$0.L()).Y0(obj, obj2, obj3, substring, substring2, substring3, value4, obj4, obj5), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
                                return;
                            }
                        }
                        e.l.h.j.b.e.h(this.this$0, "银行账号不能为空", null, null, null, 0, null, 62, null);
                        return;
                    }
                    e.l.h.j.b.e.h(this.this$0, "请输入开户支行", null, null, null, 0, null, 62, null);
                    return;
                }
                e.l.h.j.b.e.h(this.this$0, "请输入开户行全称", null, null, null, 0, null, 62, null);
                return;
            }
            e.l.h.j.b.e.h(this.this$0, "手机号码不能为空", null, null, null, 0, null, 62, null);
            return;
        }
        e.l.h.j.b.e.h(this.this$0, "姓名不能为空", null, null, null, 0, null, 62, null);
    }
}
