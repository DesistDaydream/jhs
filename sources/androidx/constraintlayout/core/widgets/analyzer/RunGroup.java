package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    public int direction;
    public WidgetRun firstRun;
    public int groupIndex;
    public WidgetRun lastRun;
    public int position = 0;
    public boolean dual = false;
    public ArrayList<WidgetRun> runs = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i2) {
        this.firstRun = null;
        this.lastRun = null;
        this.groupIndex = 0;
        int i3 = index;
        this.groupIndex = i3;
        index = i3 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = i2;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i2) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (widgetRun.widget.isTerminalWidget[i2]) {
            for (Dependency dependency : widgetRun.start.dependencies) {
                if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).run) != widgetRun && dependencyNode2 == widgetRun3.start) {
                    if (widgetRun instanceof ChainRun) {
                        Iterator<WidgetRun> it = ((ChainRun) widgetRun).widgets.iterator();
                        while (it.hasNext()) {
                            defineTerminalWidget(it.next(), i2);
                        }
                    } else if (!(widgetRun instanceof HelperReferences)) {
                        widgetRun.widget.isTerminalWidget[i2] = false;
                    }
                    defineTerminalWidget(dependencyNode2.run, i2);
                }
            }
            for (Dependency dependency2 : widgetRun.end.dependencies) {
                if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).run) != widgetRun && dependencyNode == widgetRun2.start) {
                    if (widgetRun instanceof ChainRun) {
                        Iterator<WidgetRun> it2 = ((ChainRun) widgetRun).widgets.iterator();
                        while (it2.hasNext()) {
                            defineTerminalWidget(it2.next(), i2);
                        }
                    } else if (!(widgetRun instanceof HelperReferences)) {
                        widgetRun.widget.isTerminalWidget[i2] = false;
                    }
                    defineTerminalWidget(dependencyNode.run, i2);
                }
            }
            return false;
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j2) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j2;
        }
        int size = dependencyNode.dependencies.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            Dependency dependency = dependencyNode.dependencies.get(i2);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j3 = Math.min(j3, traverseEnd(dependencyNode2, dependencyNode2.margin + j2));
                }
            }
        }
        if (dependencyNode == widgetRun.end) {
            long wrapDimension = j2 - widgetRun.getWrapDimension();
            return Math.min(Math.min(j3, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.margin);
        }
        return j3;
    }

    private long traverseStart(DependencyNode dependencyNode, long j2) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j2;
        }
        int size = dependencyNode.dependencies.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            Dependency dependency = dependencyNode.dependencies.get(i2);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j3 = Math.max(j3, traverseStart(dependencyNode2, dependencyNode2.margin + j2));
                }
            }
        }
        if (dependencyNode == widgetRun.start) {
            long wrapDimension = j2 + widgetRun.getWrapDimension();
            return Math.max(Math.max(j3, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.margin);
        }
        return j3;
    }

    public void add(WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        long wrapDimension;
        int i3;
        WidgetRun widgetRun = this.firstRun;
        if (widgetRun instanceof ChainRun) {
            if (((ChainRun) widgetRun).orientation != i2) {
                return 0L;
            }
        } else if (i2 == 0) {
            if (!(widgetRun instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof VerticalWidgetRun)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i2 == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).start;
        DependencyNode dependencyNode2 = (i2 == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).end;
        boolean contains = widgetRun.start.targets.contains(dependencyNode);
        boolean contains2 = this.firstRun.end.targets.contains(dependencyNode2);
        long wrapDimension2 = this.firstRun.getWrapDimension();
        if (contains && contains2) {
            long traverseStart = traverseStart(this.firstRun.start, 0L);
            long traverseEnd = traverseEnd(this.firstRun.end, 0L);
            long j2 = traverseStart - wrapDimension2;
            WidgetRun widgetRun2 = this.firstRun;
            int i4 = widgetRun2.end.margin;
            if (j2 >= (-i4)) {
                j2 += i4;
            }
            int i5 = widgetRun2.start.margin;
            long j3 = ((-traverseEnd) - wrapDimension2) - i5;
            if (j3 >= i5) {
                j3 -= i5;
            }
            float biasPercent = widgetRun2.widget.getBiasPercent(i2);
            float f2 = (float) (biasPercent > 0.0f ? (((float) j3) / biasPercent) + (((float) j2) / (1.0f - biasPercent)) : 0L);
            long j4 = (f2 * biasPercent) + 0.5f + wrapDimension2 + (f2 * (1.0f - biasPercent)) + 0.5f;
            WidgetRun widgetRun3 = this.firstRun;
            wrapDimension = widgetRun3.start.margin + j4;
            i3 = widgetRun3.end.margin;
        } else if (contains) {
            DependencyNode dependencyNode3 = this.firstRun.start;
            return Math.max(traverseStart(dependencyNode3, dependencyNode3.margin), this.firstRun.start.margin + wrapDimension2);
        } else if (contains2) {
            DependencyNode dependencyNode4 = this.firstRun.end;
            return Math.max(-traverseEnd(dependencyNode4, dependencyNode4.margin), (-this.firstRun.end.margin) + wrapDimension2);
        } else {
            WidgetRun widgetRun4 = this.firstRun;
            wrapDimension = widgetRun4.start.margin + widgetRun4.getWrapDimension();
            i3 = this.firstRun.end.margin;
        }
        return wrapDimension - i3;
    }

    public void defineTerminalWidgets(boolean z, boolean z2) {
        if (z) {
            WidgetRun widgetRun = this.firstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z2) {
            WidgetRun widgetRun2 = this.firstRun;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}
