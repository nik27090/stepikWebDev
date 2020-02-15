package accounts;

import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;

public class UserService {
   private UsersDAO usersDAO = new UsersDAO();

   public UserService(){
   }

   public UsersDataSet findUser(int id){
       return usersDAO.findById(id);
   }

   public UsersDataSet findUser(String login){
       return usersDAO.findByLogin(login);
   }

    public void saveUser(UsersDataSet user) {
        usersDAO.save(user);
    }

    public void deleteUser(UsersDataSet user) {
        usersDAO.delete(user);
    }

    public void updateUser(UsersDataSet user) {
        usersDAO.update(user);
    }
}
