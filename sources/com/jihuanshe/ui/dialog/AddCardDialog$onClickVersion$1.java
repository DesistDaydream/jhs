package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import com.jihuanshe.model.CardInfo;
import com.jihuanshe.model.CardPack;
import com.jihuanshe.model.CardVersion;
import e.n.f;
import h.k2.u.l;
import h.t1;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardDialog$onClickVersion$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ AddCardDialog this$0;

    /* renamed from: com.jihuanshe.ui.dialog.AddCardDialog$onClickVersion$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Integer, t1> {
        public final /* synthetic */ AddCardDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AddCardDialog addCardDialog) {
            super(1);
            this.this$0 = addCardDialog;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
            invoke(num.intValue());
            return t1.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void invoke(int i2) {
            List<CardVersion> versions;
            boolean z;
            CardPack cardPack = this.this$0.getCardPacks().get(i2);
            this.this$0.getVersion().r(cardPack);
            f<CardVersion> curCardVer = this.this$0.getCurCardVer();
            CardInfo cardInfo = this.this$0.getCardInfo();
            CardVersion cardVersion = null;
            if (cardInfo != null && (versions = cardInfo.getVersions()) != null) {
                Iterator<T> it = versions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (cardPack.getVersionId() == ((CardVersion) next).getId()) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        cardVersion = next;
                        break;
                    }
                }
                cardVersion = cardVersion;
            }
            curCardVer.r(cardVersion);
            this.this$0.getIgnore().setValue(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCardDialog$onClickVersion$1(AddCardDialog addCardDialog, Context context) {
        super(1);
        this.this$0 = addCardDialog;
        this.$context = context;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (this.this$0.getWantCard() == null || this.this$0.getCardPacks() == null) {
            return;
        }
        Context context = this.$context;
        List<CardPack> cardPacks = this.this$0.getCardPacks();
        List<CardPack> cardPacks2 = this.this$0.getCardPacks();
        AddCardDialog addCardDialog = this.this$0;
        Iterator<CardPack> it = cardPacks2.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            int versionId = it.next().getVersionId();
            CardVersion value = addCardDialog.getCurCardVer().getValue();
            if (value != null && versionId == value.getId()) {
                break;
            }
            i2++;
        }
        new ListDialog(context, cardPacks, Math.max(0, i2), new AnonymousClass2(this.this$0)).y();
    }
}
