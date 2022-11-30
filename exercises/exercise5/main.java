import AbstractFactory.*;

public class main {
    public static void main(String[] args) {
        //Singleton s=new Singleton();not applicable
        //only one object is available
        Singleton s=Singleton.Instance();
        s.build();


        //Factory Method define an interface, and let subclasses decide which to instantiate.
        FactoryMethod shapeFactory=new FactoryMethod();
        FactoryMethod.Vehicle vehicle1=shapeFactory.getVehicle("car");
        vehicle1.build();
        FactoryMethod.Vehicle vehicle2=shapeFactory.getVehicle("train");
        vehicle2.build();

        //abstract factory define a super factory that all the concrete factory extend from.
        AbstractFactory abstractFactory= FactoryProducer.getFactory("vehicle");
        VehicleFactory.Vehicle vehicle3=abstractFactory.getVehicle("train");
        vehicle3.build();
        VehicleFactory.Vehicle vehicle4=abstractFactory.getVehicle("car");
        vehicle4.build();
        AbstractFactory abstractFactory2= FactoryProducer.getFactory("clothes");
        ClothesFactory.Clothes clothes2=abstractFactory2.getClothes("trousers");
        clothes2.build();
        ClothesFactory.Clothes clothes1=abstractFactory2.getClothes("coat");
        clothes1.build();

    }
}
