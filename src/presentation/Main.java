package presentation;

import sn.exo.controller.DB;
import sn.exo.controller.IUser;
import sn.exo.controller.UserImpl;
import sn.exo.entities.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Instanciation d'un DB
         DB db = new DB() ;
        //Appel de la methode pour faire la connection
           db.getConnextion() ;
       System.out.println("Hello world!");*/

        IUser iUser = new UserImpl() ;

       /*//Creation D'un User
        User user = new User() ;
        user.setNo("Bah");
        user.setPrenom("Alpha");
        user.setEmail("asbahisidk@groupeisi224.com");
        user.setPassowrd("bahnh224");
        if (iUser.add(user) == 1){
            System.out.println("Utilisateur cree avec succees !");
        }else
            System.out.println("Insertion echoué !");*/

       /*//Listes Des Users
       List<User> listUsers = iUser.list() ;
        System.out.println("Liste des utilisateurs");
        for (User u: listUsers) {
            System.out.println(u.getPrenom() + " " + u.getNo() + " [" +u.getEmail() + "]");
        }*/

       /*//Update
        User user = new User() ;
        user.setId(1);
        user.setNo("Diallo Cherif");
        user.setPrenom("Mariame Cherif");
        user.setEmail("bah@gmail.com");
        user.setPassowrd("mcdbgign224");
        if (iUser.update(user) == 1){
            System.out.println("Utilisateur modifie avec succees !");
        }else
            System.out.println("Modification echoué !");*/

        /*//Delete
        if(iUser.delete(8) == 1){
            System.out.println("Utilisateur supprimé avec Succés !");
        }else{
            System.out.println("Suppression échouée !");
        }*/

         // Get en fontion de l'ID
        User u = iUser.get(6);
        System.out.println("L'utilisateur dont son id=1 est : " +
                u.getPrenom() + " " + u.getNo() + " ["+u.getEmail()+"]");
    }
}