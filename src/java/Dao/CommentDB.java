/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Comment;
import getConnection.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Crystal
 */
public class CommentDB {
    private Connection conn;
    private PreparedStatement pstat;
    public void addComment(Comment comment) throws ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "insert into comment(arandacid,title,text,date,name) values(?,?,?,?,?)";
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1,comment.getArandacid());
            pstat.setString(2, comment.getTitle());
            pstat.setString(3, comment.getText());
            pstat.setDate(4, comment.getDate());
            pstat.setString(5, comment.getName());
            pstat.executeUpdate();
            pstat.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("addComment wrong");
        }
    }
    public List<Comment> Comments(int id) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        System.out.println("comments");
        String sql = "select * from comment where arandacid=?";
        pstat = conn.prepareStatement(sql);
        pstat.setInt(1, id);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        List<Comment> list = new ArrayList<Comment>();
        try {
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setCommentid(rs.getInt(1));
                comment.setArandacid(rs.getInt(2));
                comment.setTitle(rs.getString(3));
                comment.setText(rs.getString(4));
                comment.setDate(rs.getDate(5));
                comment.setName(rs.getString(6));
                list.add(comment);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("Comments wrong");
        }
        return list;
    }
}
