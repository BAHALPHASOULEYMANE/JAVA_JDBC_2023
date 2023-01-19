package sn.exo.controller;

import sn.exo.entities.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements  IUser{
    private DB db = new DB() ;
    private int ok ;
    private ResultSet rs ;
    @Override
    public int add(User u) {
        String sql = "INSERT INTO user VALUES(NULL, ?, ?, ?, ?)";
        try {
            //Initialisation de la Requette
            db.initPrepar(sql);
            //Passage de valeurs
            db.getPtsm().setString(1,u.getNo());
            db.getPtsm().setString(2,u.getPrenom());
            db.getPtsm().setString(3,u.getEmail());
            db.getPtsm().setString(4,u.getPassowrd());
            //Execution de la requette
            ok = db.executeMaj();
            //Fermeture de la Connection
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(User u) {
        String sql = "UPDATE user SET nom = ? , prenom = ? , email = ? , password = ? WHERE id = ?";
        try {
            db.initPrepar(sql);
            db.getPtsm().setString(1,u.getNo());
            db.getPtsm().setString(2,u.getPrenom());
            db.getPtsm().setString(3,u.getEmail());
            db.getPtsm().setString(4,u.getPassowrd());
            db.getPtsm().setInt(5,u.getId());

            ok = db.executeMaj();
            db.closeConnection();

        }catch (Exception exception){
            exception.printStackTrace();
        }
        return ok;
    }


    @Override
    public int delete(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        try{
            db.initPrepar(sql);
            db.getPtsm().setInt(1,id);
            ok = db.executeMaj();
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }


    @Override
    public List<User> list() {
        List<User> users = new ArrayList<>() ;
        String sql = "SELECT * FROM user ORDER BY nom ASC" ;
        try {
            db.initPrepar(sql);
            rs = db.executeSelect();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setNo(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassowrd(rs.getString(5));
                users.add(user) ;
            }
            db.closeConnection();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return users;
    }

    @Override
    public User get(int id) {
        User user = null  ;
        String sql = "SELECT * FROM user WHERE id = ? ";
        try {
            db.initPrepar(sql);
            db.getPtsm().setInt(1,id);
            rs = db.executeSelect() ;
            if (rs.next()){
                user =  new User() ;
                user.setId(rs.getInt(1));
                user.setNo(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassowrd(rs.getString(5));
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return user;
    }
}
