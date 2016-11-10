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
public class Comment {

    private int commentid;
    private int arandacid;
    private String title;
    private String text;
    private Date date;
    private String name;

    public Comment() {
        super();
    }

    public Comment(int commentid, int arandacid, String title, String text, Date date, String name) {
        super();
        this.commentid = commentid;
        this.arandacid = arandacid;
        this.title = title;
        this.text = text;
        this.date = date;
        this.name = name;
    }

    /**
     * @return the commentid
     */
    public int getCommentid() {
        return commentid;
    }

    /**
     * @param commentid the commentid to set
     */
    public void setCommentid(int commentid) {
        this.commentid = commentid;
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
