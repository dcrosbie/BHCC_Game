package sample;


public class Player {
    private Integer idPLAYER;
    private Integer idCurrentGAME;
    private String playerNAME;
    private Boolean isREADY;

    public Integer getIDPlayer() {
        return idPLAYER;
    }

    public void setIDPlayer(int idPLAYER) {
        this.idPLAYER = idPLAYER;
    }

    public String getPlayerName() {
        return playerNAME;
    }

    public void setPlayerName(String playerNAME) {
        this.playerNAME = playerNAME;
    }

    public Integer getIDCurrentGame() {
        return idCurrentGAME;
    }

    public void setIDCurrentGame(int idCurrentGAME) {
        this.idCurrentGAME = idCurrentGAME;
    }

    public Boolean isReady() {
        return isREADY;
    }

    public void setReady(int i) {
        if (i == 0)
            this.isREADY = false;
        else if (i == 1)
            this.isREADY = true;
        else
        this.isREADY = null;
    }
}
