//
//interface Pizza {
//    String getDescription();
//    double getCost();
//}
//
//class PlainPizza implements Pizza {
//
//    @Override
//    public String getDescription() {
//        return "Plain Dough & Sauce";
//    }
//
//    @Override
//    public double getCost() {
//        return 5.0;
//    }
//}
//
//abstract class PizzaDecorator implements Pizza {
//    protected Pizza pizza;
//
//    public PizzaDecorator(Pizza pizza) {
//        this.pizza = pizza;
//    }
//}
//
//class Cheese extends PizzaDecorator {
//
//    public Cheese(Pizza pizza) {
//        super(pizza);
//    }
//
//    @Override
//    public String getDescription() {
//        return pizza.getDescription() + ", Cheese";
//    }
//
//    @Override
//    public double getCost() {
//        return pizza.getCost() + 2.0;
//    }
//}
//
//class Olives extends PizzaDecorator {
//
//    public Olives(Pizza pizza) {
//        super(pizza);
//    }
//
//    @Override
//    public String getDescription() {
//        return pizza.getDescription() + ", Olives";
//    }
//
//    @Override
//    public double getCost() {
//        return pizza.getCost() + 1.0;
//    }
//}
//
//class Pineapple extends PizzaDecorator {
//
//    public Pineapple(Pizza pizza) {
//        super(pizza);
//    }
//
//    @Override
//    public String getDescription() {
//        return pizza.getDescription() + ", Pineapple";
//    }
//
//    @Override
//    public double getCost() {
//        return pizza.getCost() + 1.5;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//
//        Pizza pizza = new PlainPizza();
//
//        pizza = new Cheese(pizza);
//        pizza = new Olives(pizza);
//        pizza = new Pineapple(pizza);
//
//        System.out.println("Description: " + pizza.getDescription());
//        System.out.printf("Total cost: $%.2f%n", pizza.getCost());
//    }
//}

//interface MovementStrategy {
//    void move();
//}
//
//class Walking implements MovementStrategy {
//    @Override
//    public void move() {
//        System.out.println("Walking: 5 km/h");
//    }
//}
//
//class Skateboarding implements MovementStrategy {
//    @Override
//    public void move() {
//        System.out.println("Skateboarding: 15 km/h");
//    }
//}
//
//class Jetpack implements MovementStrategy {
//    @Override
//    public void move() {
//        System.out.println("Jetpack: 60 km/h");
//    }
//}
//
//class Player {
//    private MovementStrategy strategy;
//
//    public Player(MovementStrategy strategy) {
//        this.strategy = strategy;
//    }
//
//    public void setStrategy(MovementStrategy strategy) {
//        this.strategy = strategy;
//    }
//
//    public void move() {
//        strategy.move();
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//
//        Player player = new Player(new Walking());
//
//        player.move();
//
//        System.out.println("Switching movement...");
//
//        player.setStrategy(new Jetpack());
//
//        player.move();
//    }
//}



interface ModernConsole {
    void playDigital();
}

// Old class: cannot be modified
class RetroCartridge {
    public void insertCartridge() {
        System.out.println("Playing retro game from cartridge!");
    }
}

// Adapter: connects the two interfaces
class CartridgeAdapter implements ModernConsole {
    private RetroCartridge cartridge;

    public CartridgeAdapter(RetroCartridge cartridge) {
        this.cartridge = cartridge;
    }

    @Override
    public void playDigital() {
        cartridge.insertCartridge();
    }
}

public class Main {
    public static void main(String[] args) {

        RetroCartridge retroGame = new RetroCartridge();

        ModernConsole console = new CartridgeAdapter(retroGame);

        console.playDigital();
    }
}

