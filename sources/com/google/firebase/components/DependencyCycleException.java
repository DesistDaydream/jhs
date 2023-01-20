package com.google.firebase.components;

import e.j.a.b.c.m.a;
import e.j.d.d.e;
import java.util.Arrays;
import java.util.List;

@a
/* loaded from: classes2.dex */
public class DependencyCycleException extends DependencyException {
    private final List<e<?>> componentsInCycle;

    @a
    public DependencyCycleException(List<e<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    @a
    public List<e<?>> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
