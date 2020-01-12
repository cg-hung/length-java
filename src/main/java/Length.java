public class Length {
    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit target) {
        double value = this.value;
        Length result = new Length(value, target);

        if (this.unit == Unit.FOOT) {
            if (target == Unit.YARD) {
                value = this.value / 3;
                result = new Length(value, target);
            } else if (target == Unit.INCH) {
                value = this.value * 12;
                result = new Length(value, target);
            }
        }

        if (this.unit == Unit.YARD) {
            if (target == Unit.INCH) {
                result = new Length(this.value * 36, target);
            } else if (target == Unit.FOOT){
                result = new Length(this.value * 3, target);
            }
        }

        if (this.unit == Unit.INCH) {
            if (target == Unit.FOOT) {
                result = new Length(this.value / 12, target);
            } else if (target == Unit.YARD) {
                result = new Length(this.value / 36, target);
            }
        }

        return result;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return unit;
    }
}
