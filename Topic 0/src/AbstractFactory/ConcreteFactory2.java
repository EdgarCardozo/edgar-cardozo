package AbstractFactory;

public class ConcreteFactory2 extends AbstractFactory{
    //ConcreteFactory2 will create products A and B differents of ConcreteFactory1
    public AbstractProductA createProductA(){
        System.out.println("Factory 2 is creating Product A2");
        return new ConcreteProductA2();
    }

    public AbstractProductB createProductB(){
        System.out.println("Factory 2 is creating Product B2");
        return new ConcreteProductB2();
    }
}
