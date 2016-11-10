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
public class Arandac {

    private int arandacid;
    private String title;
    private String text;
    private int peoplemax;
    private int peoplemin;
    private Date date;
    private String place;
    private String K1;
    private String K2;
    private String K3;
    private int peoplenum;
    private String author;
    private String type;

    public Arandac() {
        super();
    }

    public Arandac(int arandacid, String title, String text, int peoplemax, int peoplemin, Date date, String place, String K1, String K2, String K3, int peoplenum,String author, String type) {
        super();
        this.arandacid = arandacid;
        this.title = title;
        this.text = text;
        this.peoplemax = peoplemax;
        this.peoplemin = peoplemin;
        this.date = date;
        this.place = place;
        this.K1 = K1;
        this.K2 = K2;
        this.K3 = K3;
        this.peoplenum = peoplenum;
        this.author = author;
        this.type = type;
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
     * @return the peoplemax
     */
    public int getPeoplemax() {
        return peoplemax;
    }

    /**
     * @param peoplemax the peoplemax to set
     */
    public void setPeoplemax(int peoplemax) {
        this.peoplemax = peoplemax;
    }

    /**
     * @return the peoplemin
     */
    public int getPeoplemin() {
        return peoplemin;
    }

    /**
     * @param peoplemin the peoplemin to set
     */
    public void setPeoplemin(int peoplemin) {
        this.peoplemin = peoplemin;
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
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the K1
     */
    public String getK1() {
        return K1;
    }

    /**
     * @param K1 the K1 to set
     */
    public void setK1(String K1) {
        this.K1 = K1;
    }

    /**
     * @return the K2
     */
    public String getK2() {
        return K2;
    }

    /**
     * @param K2 the K2 to set
     */
    public void setK2(String K2) {
        this.K2 = K2;
    }

    /**
     * @return the K3
     */
    public String getK3() {
        return K3;
    }

    /**
     * @param K3 the K3 to set
     */
    public void setK3(String K3) {
        this.K3 = K3;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the peoplenum
     */
    public int getPeoplenum() {
        return peoplenum;
    }

    /**
     * @param peoplenum the peoplenum to set
     */
    public void setPeoplenum(int peoplenum) {
        this.peoplenum = peoplenum;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}
