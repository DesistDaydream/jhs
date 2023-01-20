package com.jihuanshe.repo;

import com.jihuanshe.model.ReasonResult;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReportRepo$refresh$1 extends Lambda implements l<ReasonResult, t1> {
    public static final ReportRepo$refresh$1 INSTANCE = new ReportRepo$refresh$1();

    public ReportRepo$refresh$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ReasonResult reasonResult) {
        invoke2(reasonResult);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e ReasonResult reasonResult) {
        ReportRepo reportRepo = ReportRepo.a;
        boolean z = false;
        ReportRepo.f3927e = false;
        if (reasonResult == null) {
            return;
        }
        List<String> value = reportRepo.d().getValue();
        if ((value == null || value.isEmpty()) || !f0.g(reportRepo.d().getValue(), reasonResult.getReportReason())) {
            reportRepo.d().r(reasonResult.getReportReason());
        }
        List<String> value2 = reportRepo.c().getValue();
        if ((value2 == null || value2.isEmpty()) || !f0.g(reportRepo.c().getValue(), reasonResult.getCorrectionReason())) {
            reportRepo.c().r(reasonResult.getCorrectionReason());
        }
        List<String> value3 = reportRepo.e().getValue();
        if (((value3 == null || value3.isEmpty()) ? true : true) || !f0.g(reportRepo.e().getValue(), reasonResult.getReportSellerReason())) {
            reportRepo.e().r(reasonResult.getReportSellerReason());
        }
    }
}
