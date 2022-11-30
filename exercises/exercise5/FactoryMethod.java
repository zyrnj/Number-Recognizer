public class FactoryMethod {

    public interface Vehicle {
        void build();
    }

    public class car implements Vehicle {

        @Override
        public void build() {
            System.out.println("Build a car");
        }
    }
    public class train implements Vehicle {

        @Override
        public void build() {
            System.out.println("Build a train");
        }
    }

    public Vehicle getVehicle(String vehicleType){
            if(vehicleType == null){
                return null;
            }
             else if(vehicleType.equalsIgnoreCase("car")){
                return new car();
            } else if(vehicleType.equalsIgnoreCase("train")){
                return new train();
            }
            return null;
    }

}
