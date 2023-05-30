package gitlab.enums;

public enum Person {
    UMUT(10670426),
    TESTER_A(10000000);

    final int personId;

    Person(int personId){
        this.personId = personId;
    }

    public int id(){return personId;}
}
