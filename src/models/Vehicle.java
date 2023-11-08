package models;

public class Vehicle extends BaseModel{
    private String number;
    private String color;
    private String make;
    private VehicleType vehicleType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleMake() {
        return make;
    }

    public void setVehicleMake(String make) {
        this.make = make;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String toString(){
        return "Vehicle{" +
                "Number=" + number + '\'' +
                "Color=" + color + '\'' +
                "Make=" + make + '\'' +
                '}';
    }
}
