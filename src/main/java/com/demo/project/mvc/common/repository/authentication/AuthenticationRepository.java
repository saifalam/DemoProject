package com.demo.project.mvc.common.repository.authentication;

import com.demo.project.mvc.common.repository.BaseRepository;
import com.demo.project.mvc.model.datamodel.LoginUser;
import com.demo.project.mvc.model.entitymodel.UserRegistrationEntityModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by saif on 3/30/15.
 */
@Repository
public class AuthenticationRepository extends BaseRepository<UserRegistrationEntityModel> {

//    public double getAllByUserName(String username) {
//
//        Session session = getSession();
//        Query query = session.createQuery("SELECT ureg.id FROM user_registration ureg WHERE ureg.user_name = :username");
//        query.setParameter("username", username);
//        Object obj = query.uniqueResult();
//        return obj != null ? (Double) obj : 0;
//    }

    public UserRegistrationEntityModel getAllByUserName(String userName) {

        Session session = getSession();
        Query query = session.createQuery("FROM UserRegistrationEntityModel  WHERE userName = :userName");
        query.setParameter("userName",userName);
        return (UserRegistrationEntityModel) query.uniqueResult();
    }


    public LoginUser getLoginUserByName(String username) {
        Session session = getSession();
        List<LoginUser> loginUser = session.createSQLQuery("SELECT ur.id as id, ur.full_name as fullName,ur.gender as gender," +
                "ur.phone as mobileNo,ur.email as email, ur.dob as dateOfBirth, ath user_password as password" +
                " FROM user_registration ur join authentication ath WHERE ath.is_active= Y and ur.user_name = " + username + ";")
                .addScalar("id", StandardBasicTypes.INTEGER)
                .addScalar("password", StandardBasicTypes.STRING)
                .addScalar("fullName", StandardBasicTypes.STRING)
                .addScalar("userName", StandardBasicTypes.STRING)
                .addScalar("gender", StandardBasicTypes.STRING)
                .addScalar("mobileNo", StandardBasicTypes.STRING)
                .addScalar("email", StandardBasicTypes.STRING)
                .addScalar("dateOfBirth", StandardBasicTypes.DATE)
                .setResultTransformer(new AliasToBeanResultTransformer(LoginUser.class))
                .list();
        
        return loginUser;
    }
}
