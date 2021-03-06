package AdventOfCode2017;

public class AdventOfCodeDaySeventeen {

    private int currentPosition = 0;

    private final int steps;

    private int size;

    private int value;

    public AdventOfCodeDaySeventeen(int steps) {
        this.steps = steps;
        this.size = 1;
        this.value = 0;
    }

    public void step(int numberOfInsertions) {
        for(int i = 1; i <= numberOfInsertions; i++){
            insertNextElement(i);
        }
    }

    private int getNextLocation() {
        if(this.size == 1) {
            return 1;
        } else if(currentPosition + steps < this.size) {
            return currentPosition + steps + 1;
        } else if(currentPosition + steps == this.size) {
            return 1;
        } else {
            return ((currentPosition + steps) % this.size) + 1;
        }
    }

    private void insertNextElement(int insertValue) {
        int nextLocation = getNextLocation();
        size++;
        this.currentPosition = nextLocation;
        if(nextLocation == 1) {
            this.value = insertValue;
        }
    }
    
    public int getLayout() {
        return this.value;
    }

    public static void main(String[] args) {
        AdventOfCodeDaySeventeen adventOfCodeDaySeventeen = new AdventOfCodeDaySeventeen(367);
        adventOfCodeDaySeventeen.step(50000000);
        System.out.println("result: " + adventOfCodeDaySeventeen.getLayout());
    }
}
