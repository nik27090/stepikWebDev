package dbService.dataSets;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UsersDataSet {


    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(){
    }

    public UsersDataSet(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public long getId(){
        return id;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return "UsersDataSet{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
