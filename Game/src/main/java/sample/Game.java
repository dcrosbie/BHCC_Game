package sample;


public class Game {
    private Integer idGAME;
    private Integer idOWNER;
    private Boolean isLOBBY;

    public Integer getIdGAME() {
        return idGAME;
    }

    public void setIdGAME(Integer idGAME) {
        this.idGAME = idGAME;
    }

    public Integer getIdOWNER() {
        return idOWNER;
    }

    public void setIdOWNER(Integer idOWNER) {
        this.idOWNER = idOWNER;
    }

    public Boolean getLOBBY() {
        return isLOBBY;
    }

    public void setLOBBY(int i) {
        if (i == 0)
            this.isLOBBY = false;
        else if (i == 1)
            this.isLOBBY = true;
        else
            this.isLOBBY = null;
    }
}
