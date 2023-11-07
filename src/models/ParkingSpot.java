package models;

public class ParkingSpot extends BaseModel{
    private int number;
    private VehicleType vehicleType;
    private Status status;
    private Vehicle vehicle;

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "number=" + number +
                ", vehicleType=" + vehicleType +
                ", status=" + status +
                ", vehicle=" + vehicle +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
