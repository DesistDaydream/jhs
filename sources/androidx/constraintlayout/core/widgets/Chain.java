package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i2) {
        ChainHead[] chainHeadArr;
        int i3;
        int i4;
        if (i2 == 0) {
            i3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i4 = 0;
        } else {
            int i5 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = i5;
            i4 = 2;
        }
        for (int i6 = 0; i6 < i3; i6++) {
            ChainHead chainHead = chainHeadArr[i6];
            chainHead.define();
            if (arrayList == null || (arrayList != null && arrayList.contains(chainHead.mFirst))) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i2, i4, chainHead);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r8 == 2) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r8 == 2) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0271 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0531 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x03b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:336:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r38, androidx.constraintlayout.core.LinearSystem r39, int r40, int r41, androidx.constraintlayout.core.widgets.ChainHead r42) {
        /*
            Method dump skipped, instructions count: 1362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Chain.applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead):void");
    }
}
