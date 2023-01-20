package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {
    public ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public int matchConstraintsType;
    public RunGroup runGroup;
    public ConstraintWidget widget;
    public DimensionDependency dimension = new DimensionDependency(this);
    public int orientation = 0;
    public boolean resolved = false;
    public DependencyNode start = new DependencyNode(this);
    public DependencyNode end = new DependencyNode(this);
    public RunType mRunType = RunType.NONE;

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    private void resolveDimension(int i2, int i3) {
        int i4;
        int i5 = this.matchConstraintsType;
        if (i5 == 0) {
            this.dimension.resolve(getLimitedDimension(i3, i2));
        } else if (i5 == 1) {
            this.dimension.resolve(Math.min(getLimitedDimension(this.dimension.wrapValue, i2), i3));
        } else if (i5 == 2) {
            ConstraintWidget parent = this.widget.getParent();
            if (parent != null) {
                DimensionDependency dimensionDependency = (i2 == 0 ? parent.horizontalRun : parent.verticalRun).dimension;
                if (dimensionDependency.resolved) {
                    ConstraintWidget constraintWidget = this.widget;
                    this.dimension.resolve(getLimitedDimension((int) ((dimensionDependency.value * (i2 == 0 ? constraintWidget.mMatchConstraintPercentWidth : constraintWidget.mMatchConstraintPercentHeight)) + 0.5f), i2));
                }
            }
        } else if (i5 != 3) {
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            WidgetRun widgetRun = constraintWidget2.horizontalRun;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.dimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.matchConstraintsType == 3) {
                VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
                if (verticalWidgetRun.dimensionBehavior == dimensionBehaviour2 && verticalWidgetRun.matchConstraintsType == 3) {
                    return;
                }
            }
            if (i2 == 0) {
                widgetRun = constraintWidget2.verticalRun;
            }
            if (widgetRun.dimension.resolved) {
                float dimensionRatio = constraintWidget2.getDimensionRatio();
                if (i2 == 1) {
                    i4 = (int) ((widgetRun.dimension.value / dimensionRatio) + 0.5f);
                } else {
                    i4 = (int) ((dimensionRatio * widgetRun.dimension.value) + 0.5f);
                }
                this.dimension.resolve(i4);
            }
        }
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = i2;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int i2, int i3) {
        int max;
        if (i3 == 0) {
            ConstraintWidget constraintWidget = this.widget;
            int i4 = constraintWidget.mMatchConstraintMaxWidth;
            max = Math.max(constraintWidget.mMatchConstraintMinWidth, i2);
            if (i4 > 0) {
                max = Math.min(i4, i2);
            }
            if (max == i2) {
                return i2;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int i5 = constraintWidget2.mMatchConstraintMaxHeight;
            max = Math.max(constraintWidget2.mMatchConstraintMinHeight, i2);
            if (i5 > 0) {
                max = Math.min(i5, i2);
            }
            if (max == i2) {
                return i2;
            }
        }
        return max;
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return constraintWidget.verticalRun.end;
                    }
                    return constraintWidget.verticalRun.baseline;
                }
                return constraintWidget.verticalRun.start;
            }
            return constraintWidget.horizontalRun.end;
        }
        return constraintWidget.horizontalRun.start;
    }

    public long getWrapDimension() {
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            return dimensionDependency.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        int size = this.start.targets.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (this.start.targets.get(i3).run != this) {
                i2++;
            }
        }
        int size2 = this.end.targets.size();
        for (int i4 = 0; i4 < size2; i4++) {
            if (this.end.targets.get(i4).run != this) {
                i2++;
            }
        }
        return i2 >= 2;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    public abstract void reset();

    public abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    public void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = target.value + constraintAnchor.getMargin();
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i3 = margin2 - margin;
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                resolveDimension(i2, i3);
            }
            DimensionDependency dimensionDependency = this.dimension;
            if (dimensionDependency.resolved) {
                if (dimensionDependency.value == i3) {
                    this.start.resolve(margin);
                    this.end.resolve(margin2);
                    return;
                }
                ConstraintWidget constraintWidget = this.widget;
                float horizontalBiasPercent = i2 == 0 ? constraintWidget.getHorizontalBiasPercent() : constraintWidget.getVerticalBiasPercent();
                if (target == target2) {
                    margin = target.value;
                    margin2 = target2.value;
                    horizontalBiasPercent = 0.5f;
                }
                this.start.resolve((int) (margin + 0.5f + (((margin2 - margin) - this.dimension.value) * horizontalBiasPercent)));
                this.end.resolve(this.start.value + this.dimension.value);
            }
        }
    }

    public void updateRunEnd(Dependency dependency) {
    }

    public void updateRunStart(Dependency dependency) {
    }

    public long wrapSize(int i2) {
        int i3;
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            long j2 = dimensionDependency.value;
            if (isCenterConnection()) {
                i3 = this.start.margin - this.end.margin;
            } else if (i2 == 0) {
                i3 = this.start.margin;
            } else {
                return j2 - this.end.margin;
            }
            return j2 + i3;
        }
        return 0L;
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = i2;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i2) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i2 == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }
}
