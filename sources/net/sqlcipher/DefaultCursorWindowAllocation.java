package net.sqlcipher;

import com.caverock.androidsvg.SVG;

/* loaded from: classes4.dex */
public class DefaultCursorWindowAllocation implements CursorWindowAllocation {
    private long initialAllocationSize = SVG.H;
    private long WindowAllocationUnbounded = 0;

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getGrowthPaddingSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getMaxAllocationSize() {
        return this.WindowAllocationUnbounded;
    }
}
