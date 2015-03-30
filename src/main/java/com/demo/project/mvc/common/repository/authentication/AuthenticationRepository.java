package com.demo.project.mvc.common.repository.authentication;

import com.demo.project.mvc.common.repository.BaseRepository;
import com.demo.project.mvc.model.entitymodel.UserRegistrationEntityModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


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


}
