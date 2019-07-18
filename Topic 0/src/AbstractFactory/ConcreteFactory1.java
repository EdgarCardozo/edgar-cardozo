package AbstractFactory;

public class ConcreteFactory1 extends AbstractFactory{
    //Concrete Factory 1 will create the products the way it wants
    public AbstractProductA createProductA() {
        System.out.println("Factory 1 is creating Product A1...");
        return new ConcreteProductA1();
    }
    public AbstractProductB createProductB(){
        System.out.println("Factory 1 is creating Product A2...");
        return new ConcreteProductB1();
    }
}
