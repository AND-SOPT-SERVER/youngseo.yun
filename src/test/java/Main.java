public class Main {
    public static void main(String[] args) {

        // 만들어서
        Person person = new Person(30);
        Driver driver = new Driver(person);

        Vehicle v1 = new Car("gv80", "hyundai");
        Vehicle v2 = new Cycle();

//        Car c1 = new Car("gv80", "hyundai");
//        c1.setName("tesla");

        // 명령해요
//        if(c1.getName().equals("gv80")) {
//            c1.clarkson();
//        } else {
//            System.out.println("shhhh");
//        }

//        if(driver.canDrive()) {
//            System.out.println("Car drive successfully");
//        } else {
//            System.out.println("Car drive failed");
//        }

        System.out.println(v1.run(driver));
        System.out.println(v2.run(driver));
    }
}
