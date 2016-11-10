/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Date;

/**
 *
 * @author Crystal
 */
public class Ranking {

    private int rankid;
    private int arandacid;
    private int click;

    public Ranking() {
        super();
    }

    public Ranking(int rankid, int arandacid, int click) {
        super();
        this.rankid = rankid;
        this.arandacid = arandacid;
        this.click = click;
    }

    /**
     * @return the rankid
     */
    public int getRankid() {
        return rankid;
    }

    /**
     * @param rankid the rankid to set
     */
    public void setRankid(int rankid) {
        this.rankid = rankid;
    }

    /**
     * @return the arandacid
     */
    public int getArandacid() {
        return arandacid;
    }

    /**
     * @param arandacid the arandacid to set
     */
    public void setArandacid(int arandacid) {
        this.arandacid = arandacid;
    }

    /**
     * @return the click
     */
    public int getClick() {
        return click;
    }

    /**
     * @param click the click to set
     */
    public void setClick(int click) {
        this.click = click;
    }
}
