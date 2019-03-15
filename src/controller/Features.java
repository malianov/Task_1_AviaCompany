package controller;

import model.Model;
import model.entity.PlaneBase;
import view.View;

import static java.util.Comparator.comparing;

public class Features {

    public int SumOfPassengersCalculation() {
        return Model.airAssets.stream()
                .mapToInt(PlaneBase::getPassengersCapacity)
                .sum();
    }

    public int SumOfCargoCalculation() {
        return Model.airAssets.stream()
                .mapToInt(PlaneBase::getCargoCapacity)
                .sum();
    }

    public void FlyDistanceSorting() {
        View.SortirIncreasingDistancePrinter();
        Model.airAssets.stream()
                .sorted(comparing(PlaneBase::getMaxFlyDistance))
                .forEach(System.out::println);
    }

    public void FuelTankConsumption() {
        double lowBoundary  = 1;
        double highBoundary = 5;

        View.FuelPerKmConsumption(lowBoundary, highBoundary);
        Model.airAssets.stream()
                .filter(x -> (x.getFuelTankVolume()/x.getMaxFlyDistance() > lowBoundary))
                .filter(x -> (x.getFuelTankVolume()/x.getMaxFlyDistance() < highBoundary))
                .forEach(System.out::println);
    }
}
