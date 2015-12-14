package sample;


public class Player {
    private Integer idPLAYER;
    private Integer idCurrentGAME;
    private String playerNAME;
    private Boolean isREADY;

    public Integer getIdPLAYER() {
        return idPLAYER;
    }

    public void setIdPLAYER(int idPLAYER) {
        this.idPLAYER = idPLAYER;
    }

    public String getPlayerNAME() {
        return playerNAME;
    }

    public void setPlayerNAME(String playerNAME) {
        this.playerNAME = playerNAME;
    }

    public Integer getIdCurrentGAME() {
        return idCurrentGAME;
    }

    public void setIdCurrentGAME(int idCurrentGAME) {
        this.idCurrentGAME = idCurrentGAME;
    }

    public Boolean isREADY() {
        return isREADY;
    }

    public void setREADY(int i) {
        if (i == 0)
            this.isREADY = false;
        else if (i == 1)
            this.isREADY = true;
        else
        this.isREADY = null;
    }
}
