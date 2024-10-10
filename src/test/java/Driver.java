public class Driver {
    private Person person;

    Driver(Person person) {
        this.person = person;

    }

//    boolean canDrive() {
//        return person.getAge() > 20;
//    }

    // NPE error (Null Point Exception) -> primitive 많이 사용하기~
    boolean canDrive() {
        return person.getAge1() > 20;
    }
}
