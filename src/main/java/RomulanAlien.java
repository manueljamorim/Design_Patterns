public class RomulanAlien extends AlienClient{
    protected OrderingStrategy createOrderingStrategy() {
        return new ImpatientStrategy();

    }
}
