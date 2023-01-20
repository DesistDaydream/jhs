package net.sqlcipher;

/* loaded from: classes4.dex */
public class CustomCursorWindowAllocation implements CursorWindowAllocation {
    private long growthPaddingSize;
    private long initialAllocationSize;
    private long maxAllocationSize;

    public CustomCursorWindowAllocation(long j2, long j3, long j4) {
        this.initialAllocationSize = 0L;
        this.growthPaddingSize = 0L;
        this.maxAllocationSize = 0L;
        this.initialAllocationSize = j2;
        this.growthPaddingSize = j3;
        this.maxAllocationSize = j4;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getGrowthPaddingSize() {
        return this.growthPaddingSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getMaxAllocationSize() {
        return this.maxAllocationSize;
    }
}
