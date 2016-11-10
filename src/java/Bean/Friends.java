/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Crystal
 */
public class Friends {
    private int fid;
    private int userid;
    private int friendid;
    
    public Friends() {
        super();
    }
    
    public Friends(int fid, int userid, int friendid) {
        super();
        this.userid = userid;
        this.fid = fid;
        this.friendid = friendid;
    }

    /**
     * @return the fid
     */
    public int getFid() {
        return fid;
    }

    /**
     * @param fid the fid to set
     */
    public void setFid(int fid) {
        this.fid = fid;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * @return the friendid
     */
    public int getFriendid() {
        return friendid;
    }

    /**
     * @param friendid the friendid to set
     */
    public void setFriendid(int friendid) {
        this.friendid = friendid;
    }
}
