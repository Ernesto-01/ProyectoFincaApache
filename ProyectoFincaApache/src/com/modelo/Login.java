/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jorge
 */
public class Login {
   private String nickname;
    private String passwrd;
    private int idRol;  

    public Login() {
    }

    public Login(String nickname, String passwrd, int idRol) {
        this.nickname = nickname;
        this.passwrd = passwrd;
        this.idRol = idRol;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

  
    
    
}
