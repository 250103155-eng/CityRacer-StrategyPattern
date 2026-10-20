
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
