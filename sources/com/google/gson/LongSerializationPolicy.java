package com.google.gson;

import e.j.e.h;
import e.j.e.i;
import e.j.e.l;

/* loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public h serialize(Long l2) {
            if (l2 == null) {
                return i.a;
            }
            return new l(l2);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public h serialize(Long l2) {
            if (l2 == null) {
                return i.a;
            }
            return new l(l2.toString());
        }
    };

    public abstract h serialize(Long l2);
}
