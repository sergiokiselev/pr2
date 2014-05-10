package Utils;

import DataEntities.RegistrationModel;
import DAO.MembershipDAO;
import Factory.HibFactory;

import java.sql.SQLException;

public class SecurityUtil {
    HibFactory factory = HibFactory.getInstance();

//    public static void logInUser(User user) {
//        ExampleUserDetails userDetails = ExampleUserDetails.getBuilder()
//                .firstName(user.getFirstName())
//                .id(user.getId())
//                .lastName(user.getLastName())
//                .password(user.getPassword())
//                .role(user.getRole())
//                .socialSignInProvider(user.getSignInProvider())
//                .username(user.getEmail())
//                .build();
//
//        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//    }

    public boolean isValidRegistrationModel(RegistrationModel model){
        if(isValidUserName(model.getUserName()) && isValidPassword(model.getPassword(),model.getPasswordConfirm())){
            return true;
        }
        return false;
    }

    private boolean isValidUserName(String userName){
        MembershipDAO dao = factory.getMembershipDao();

        if(userName == null || userName.isEmpty() ||userName.length() < 6 ){
            return false;
        }

        try {
            if(dao.getMembershipByLogin(userName) != null){
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean isValidPassword(String password, String confirm){
        if(password == null || confirm == null ||   password.compareTo(confirm) != 0){
            return false;
        }
        return true;
    }
}