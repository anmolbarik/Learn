package fundamental.cloning;

public class ChildClass implements Cloneable{
    int c;

    @Override
    public ChildClass clone() {
        try {
            ChildClass clone = (ChildClass) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
