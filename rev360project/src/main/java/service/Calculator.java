package service;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public List<Double> convertCylinderNotation(Double spherePower, Double cylinderPower, Double axis) {
        List<Double> convertedRefraction = new ArrayList<Double>();

        Double convertedSpherePower = cylinderPower +  spherePower;
        Double convertedCylinderPower = (cylinderPower * -1);
        Double convertedAxis = (axis + 90) % 180;

        convertedRefraction.add(convertedSpherePower);
        convertedRefraction.add(convertedCylinderPower);
        convertedRefraction.add(convertedAxis);

        return convertedRefraction;
    }
}
