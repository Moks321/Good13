public class PlayerMoves {
    private String[] moves;
    private int numMoves;
    private int capacity;

    public PlayerMoves(int initialCapacity) {
        this.moves = new String[initialCapacity];
        this.numMoves = 0;
        this.capacity = initialCapacity;
    }

    public void addMove(String move) {
        if (numMoves == capacity) {
            String[] newMoves = new String[capacity * 2];
            System.arraycopy(moves, 0, newMoves, 0, capacity);
            System.out.println("Number of moves: " + numMoves);
            capacity *= 2;
            moves = newMoves;
        }
        moves[numMoves] = move;
        numMoves++;
    }

    public int getNumMoves() {
        return numMoves;
    }

    public String getMove(int i) {
        if (i >= numMoves) {
            return null;
        }
        return moves[i];
    }

    public void printMoves() {
        System.out.println("Moves Made:");
        for (int i = 0; i < numMoves; i++) {
            System.out.println(moves[i]);
        }
    }
}
