package service;

import model.Refraction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class CalculatorTest {

    private Calculator calculator;
    private Refraction refraction;

    @Before
    public void _setup() {
        calculator = new Calculator();
        refraction = new Refraction();
    }

    @Test
    public void convertCylinderNotation_changeMinusCylinderToPlusCylinder() {
        refraction.setSpherePower(1.50);
        refraction.setCylinderPower(-1.25);
        refraction.setAxis(80.0);

        List<Double> convertedRefraction = calculator.convertCylinderNotation(refraction.getSpherePower(), refraction.getCylinderPower(), refraction.getAxis());
        Assert.assertThat(convertedRefraction.get(0), is(.25)); //new sphere power
        Assert.assertThat(convertedRefraction.get(1), is(1.25)); //new cylinder power
        Assert.assertThat(convertedRefraction.get(2), is(170.0)); //new axis
    }

    @Test
    public void convertCylinderNotation_changePlusCylinderToMinusCylinder() {
        refraction.setSpherePower(.25);
        refraction.setCylinderPower(1.25);
        refraction.setAxis(170.0);

        List<Double> convertedRefraction = calculator.convertCylinderNotation(refraction.getSpherePower(), refraction.getCylinderPower(), refraction.getAxis());
        Assert.assertThat(convertedRefraction.get(0), is(1.50)); //new sphere power
        Assert.assertThat(convertedRefraction.get(1), is(-1.25)); //new cylinder power
        Assert.assertThat(convertedRefraction.get(2), is(80.0)); //new axis
    }
}
