public class FerengiAlien extends AlienClient{
    protected OrderingStrategy createOrderingStrategy() {
        return new SmartStrategy();
    }
}
