package AbstractFactory;

public abstract class AbstractFactory {
    public abstract VehicleFactory.Vehicle getVehicle(String vehicle);
    public abstract ClothesFactory.Clothes getClothes(String clothes);
}
