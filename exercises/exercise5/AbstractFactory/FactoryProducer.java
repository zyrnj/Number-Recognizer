package AbstractFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("vehicle")){
            return new VehicleFactory();
        } else if(choice.equalsIgnoreCase("clothes")){
            return new ClothesFactory();
        }
        return null;
    }
}
