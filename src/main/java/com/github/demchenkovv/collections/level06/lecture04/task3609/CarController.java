package com.github.demchenkovv.collections.level06.lecture04.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public void speedDown(int seconds) {
        if (model.getSpeed() > 0) {
            model.setSpeed(model.getSpeed() - (12 * seconds));
        }
        if (model.getSpeed() < 0) {
            model.setSpeed(0);
        }
    }

    public void speedUp(int seconds) {
        if (model.getSpeed() < model.getMaxSpeed()) {
            model.setSpeed((int) (model.getSpeed() + (3.5 * seconds)));
        }
        if (model.getSpeed() > model.getMaxSpeed()) {
            model.setSpeed(model.getMaxSpeed());
        }
    }

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }
}
