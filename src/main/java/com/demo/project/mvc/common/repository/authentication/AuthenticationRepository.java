package com.demo.project.mvc.common.repository.authentication;

import com.demo.project.mvc.common.repository.BaseRepository;
import com.demo.project.mvc.model.datamodel.LoginUser;
import com.demo.project.mvc.model.entitymodel.AuthenticationEntityModel;
import com.demo.project.mvc.model.entitymodel.UserRegistrationEntityModel;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by saif on 3/30/15.
 */
@Repository
public class AuthenticationRepository extends BaseRepository<AuthenticationEntityModel> {

//    public double getAllByUserName(String username) {
//
//        Session session = getSession();
//        Query query = session.createQuery("SELECT ureg.id FROM user_registration ureg WHERE ureg.user_name = :username");
//        query.setParameter("username", username);
//        Object obj = query.uniqueResult();
//        return obj != null ? (Double) obj : 0;
//    }


}
