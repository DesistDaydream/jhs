package e.j.f.r.d;

/* loaded from: classes2.dex */
public final class l extends c {
    @Override // e.j.f.r.d.c, e.j.f.r.d.g
    public int b() {
        return 2;
    }

    @Override // e.j.f.r.d.c
    public int d(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        } else if (c2 >= 'a' && c2 <= 'z') {
            sb.append((char) ((c2 - 'a') + 14));
            return 1;
        } else if (c2 < ' ') {
            sb.append((char) 0);
            sb.append(c2);
            return 2;
        } else if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            return 2;
        } else if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        } else if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        } else if (c2 == '`') {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) 2);
            sb.append((char) ((c2 - 'A') + 1));
            return 2;
        } else if (c2 >= '{' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) ((c2 - '{') + 27));
            return 2;
        } else {
            sb.append("\u0001\u001e");
            return d((char) (c2 - 128), sb) + 2;
        }
    }
}
