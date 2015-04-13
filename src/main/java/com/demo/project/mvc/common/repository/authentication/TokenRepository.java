package com.demo.project.mvc.common.repository.authentication;

import com.demo.project.mvc.common.repository.BaseRepository;
import com.demo.project.mvc.model.entitymodel.Token;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by saif on 4/13/15.
 */
@Repository
public class TokenRepository extends BaseRepository<Token> {
    public void DeleteTokenByUserID(int id) {
        Query query= getSession().createQuery("DELETE Token WHERE userId= :id ");
        query.setParameter("id",id);
        query.executeUpdate();
    }
    public void deleteUserToken(String token) {
//        Query query= getSession().createQuery("DELETE Token WHERE id= :token ");
//        query.setParameter("token",token);
//        int result=query.executeUpdate();
//        if(result==1){
//            return true;
//        }
//        return false;
         delete(load(token));
    }

}


