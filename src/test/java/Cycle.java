public class Cycle implements Vehicle {

    public String run(Drvier drvier) {
        if (drvier.canDrive()) {
            System.out.println("운전 가능");
        } else {
            System.out.println("집가라");
        }
    }
}
