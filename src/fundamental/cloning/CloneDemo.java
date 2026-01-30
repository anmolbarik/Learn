package fundamental.cloning;

public class CloneDemo implements Cloneable{
    int a;
    String b;
    ChildClass c;

    @Override
    public CloneDemo clone() {
        try {
            CloneDemo cloned = (CloneDemo) super.clone();
            // Deep copy of mutable fields
            if (this.c != null) {
                cloned.c = this.c.clone();
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
