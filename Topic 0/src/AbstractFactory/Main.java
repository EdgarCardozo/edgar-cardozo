package AbstractFactory;

public class Main {
    public static void main(String[] args){
        //Create Factory One
        AbstractFactory factory1 = FactoryProducer.getFactory(true);
        //Create a Product of the type A
        AbstractProductA productA1 = factory1.createProductA();
        //call the product's operation
        productA1.operationA();
        //Get a product of the type B
        AbstractProductB productB1 = factory1.createProductB();
        //call the product's operation
        productB1.operationB();
        //Do the same with Factory Two
        AbstractFactory factory2 = FactoryProducer.getFactory(false);
        //Create a product of the type A. This time using Factory Two
        AbstractProductA productA2 = factory2.createProductA();
        //Execute operationA
        productA2.operationA();
        //Create a product of the type B. This time using Factory Two
        AbstractProductB productB2 = factory2.createProductB();
        //Execute operationB
        productB2.operationB();
    }
}
