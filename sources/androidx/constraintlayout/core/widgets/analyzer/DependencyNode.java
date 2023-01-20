package androidx.constraintlayout.core.widgets.analyzer;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DependencyNode implements Dependency {
    public int margin;
    public WidgetRun run;
    public int value;
    public Dependency updateDelegate = null;
    public boolean delegateToWidgetRun = false;
    public boolean readyToSolve = false;
    public Type type = Type.UNKNOWN;
    public int marginFactor = 1;
    public DimensionDependency marginDependency = null;
    public boolean resolved = false;
    public List<Dependency> dependencies = new ArrayList();
    public List<DependencyNode> targets = new ArrayList();

    /* loaded from: classes.dex */
    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.run = widgetRun;
    }

    public void addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
        if (this.resolved) {
            dependency.update(dependency);
        }
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String str;
        String debugName = this.run.widget.getDebugName();
        Type type = this.type;
        if (type != Type.LEFT && type != Type.RIGHT) {
            str = debugName + "_VERTICAL";
        } else {
            str = debugName + "_HORIZONTAL";
        }
        return str + Constants.COLON_SEPARATOR + this.type.name();
    }

    public void resolve(int i2) {
        if (this.resolved) {
            return;
        }
        this.resolved = true;
        this.value = i2;
        for (Dependency dependency : this.dependencies) {
            dependency.update(dependency);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.run.widget.getDebugName());
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.type);
        sb.append("(");
        sb.append(this.resolved ? Integer.valueOf(this.value) : "unresolved");
        sb.append(") <t=");
        sb.append(this.targets.size());
        sb.append(":d=");
        sb.append(this.dependencies.size());
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        for (DependencyNode dependencyNode : this.targets) {
            if (!dependencyNode.resolved) {
                return;
            }
        }
        this.readyToSolve = true;
        Dependency dependency2 = this.updateDelegate;
        if (dependency2 != null) {
            dependency2.update(this);
        }
        if (this.delegateToWidgetRun) {
            this.run.update(this);
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i2 = 0;
        for (DependencyNode dependencyNode3 : this.targets) {
            if (!(dependencyNode3 instanceof DimensionDependency)) {
                i2++;
                dependencyNode2 = dependencyNode3;
            }
        }
        if (dependencyNode2 != null && i2 == 1 && dependencyNode2.resolved) {
            DimensionDependency dimensionDependency = this.marginDependency;
            if (dimensionDependency != null) {
                if (!dimensionDependency.resolved) {
                    return;
                }
                this.margin = this.marginFactor * dimensionDependency.value;
            }
            resolve(dependencyNode2.value + this.margin);
        }
        Dependency dependency3 = this.updateDelegate;
        if (dependency3 != null) {
            dependency3.update(this);
        }
    }
}
