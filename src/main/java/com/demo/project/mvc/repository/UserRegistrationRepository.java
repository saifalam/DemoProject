package com.demo.project.mvc.repository;

import com.demo.project.mvc.common.repository.BaseRepository;
import com.demo.project.mvc.model.datamodel.LoginUser;
import com.demo.project.mvc.model.entitymodel.UserRegistrationEntityModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by saif on 3/20/15.
 */
@Repository
@Transactional
public class UserRegistrationRepository extends BaseRepository<UserRegistrationEntityModel> {

    public int getUserIdByUserName(String userName) {
        Session session=getSession();
        Query query= session.createQuery("SELECT ure.id FROM UserRegistrationEntityModel ure WHERE ure.userName= :userName ");
        query.setParameter("userName",userName);
        return (Integer)query.uniqueResult();
    }

    public UserRegistrationEntityModel getAllByUserName(String userName) {

        Session session = getSession();
        Query query = session.createQuery("FROM UserRegistrationEntityModel  WHERE userName = :userName");
        query.setParameter("userName",userName);
        return (UserRegistrationEntityModel) query.uniqueResult();
    }


    public LoginUser getLoginUserByName(String username) {
        Session session = getSession();
        Query query = session.createSQLQuery("SELECT ur.id as id, ur.full_name as fullName, ur.gender as gender," +
                "ur.phone as mobileNo,ur.email as email, ur.dob as dateOfBirth, ath.user_password as password" +
                " FROM user_registration ur join authentication ath WHERE ath.is_active= :isActive and ur.user_name = " + username)
                .addScalar("id", StandardBasicTypes.INTEGER)
                .addScalar("password", StandardBasicTypes.STRING)
                .addScalar("fullName", StandardBasicTypes.STRING)
                .addScalar("userName", StandardBasicTypes.STRING)
                .addScalar("gender", StandardBasicTypes.STRING)
                .addScalar("mobileNo", StandardBasicTypes.STRING)
                .addScalar("email", StandardBasicTypes.STRING)
                .addScalar("dateOfBirth", StandardBasicTypes.DATE)
                .setMaxResults(1)
                .setResultTransformer(new AliasToBeanResultTransformer(LoginUser.class));
        query.setParameter("isActive",1);


        return (LoginUser)query.uniqueResult();
    }
}
