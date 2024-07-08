public class Card {
    private String rank;
    private String suit;

    public Card(String cardrank, String cardsuit){
        rank=cardrank;
        suit=cardsuit;

    }
    public String toString(){
        return rank +" of " + suit;
    }

    public String getRank() {
        return rank;
    }

    public int getRankvalue(){
        int RankValue =0 ;
        if (rank == "Ace"){
            RankValue=1;
        }
        if (rank == "2"){
            RankValue=2;
        }
        if (rank == "3"){
            RankValue=3;
        }
        if (rank == "4"){
            RankValue=4;
        }
        if (rank == "5"){
            RankValue=5;
        }
        if (rank == "6"){
            RankValue=6;
        }
        if (rank == "7"){
            RankValue=7;
        }
        if (rank == "8"){
            RankValue=8;
        }
        if (rank == "9"){
            RankValue=9;
        }
        if (rank == "10"){
            RankValue=10;
        }
        if (rank == "Jack"){
            RankValue=11;
        }
        if (rank == "Queen"){
            RankValue=12;
        }
        if (rank == "King"){
            RankValue=13;
        }
        return RankValue ;
    }
}
