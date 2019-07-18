package AbstractFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean factoryOne){
        if(factoryOne){
            return new ConcreteFactory1();
        }else{
            return new ConcreteFactory2();
        }
    }
}
