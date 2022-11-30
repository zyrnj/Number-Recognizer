package AbstractFactory;

public class ClothesFactory extends AbstractFactory{
    public interface Clothes {
        void build();
    }

    public class coat implements Clothes {

        @Override
        public void build() {
            System.out.println("create a coat");
        }
    }
    public class trousers implements Clothes {

        @Override
        public void build() {
            System.out.println("create a trousers");
        }
    }

    @Override
    public VehicleFactory.Vehicle getVehicle(String vehicle) {
        return null;
    }

    public Clothes getClothes(String clothes){
        if(clothes == null){
            return null;
        }
        else if(clothes.equalsIgnoreCase("coat")){
            return new coat();
        } else if(clothes.equalsIgnoreCase("trousers")){
            return new trousers();
        }
        return null;
    }
}
