package com.github.aachartmodel.aainfographics.aachartcreator;

import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "aa_toAAOptions", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "charts_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAChartModelKt {
    @d
    public static final AAOptions aa_toAAOptions(@d AAChartModel aAChartModel) {
        return AAOptionsConstructor.INSTANCE.configureChartOptions(aAChartModel);
    }
}
