import org.springframework.beans.factory.annotation.Autowired;

public class Player {
    TypeCinema typeCinema;

    public Player() {
    }

    public Player(TypeCinema typeCinema) {
        this.typeCinema = typeCinema;
    }

    public TypeCinema getTypeCinema() {
        return typeCinema;
    }

    public void setTypeCinema(TypeCinema typeCinema) {
        this.typeCinema = typeCinema;
    }
    public void ShowType(){
        System.out.println(typeCinema.GetType());
    }
}
