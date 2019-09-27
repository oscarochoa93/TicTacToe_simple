package backend;

/**
 *
 * @author pride
 */
public class Player {
    public String name;
    private String chip;
    
    public Player(String name) {
        this.name = name;
    }
    
    public Player(String name, String chip ) {
        this.name = name;
        this.chip = chip;
    }

    public String getChip(){
        return chip;
    }
}
