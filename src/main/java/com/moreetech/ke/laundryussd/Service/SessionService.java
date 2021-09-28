package com.moreetech.ke.laundryussd.Service;

import com.moreetech.ke.laundryussd.Entity.UssdSession;
import com.moreetech.ke.laundryussd.Repository.UssdSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author momondi  on 9/26/2021
 **/
@Service
public class SessionService {

    @Autowired
    private UssdSessionRepository ussdSessionRepository;

    public UssdSession createUssdSession(UssdSession session) {
        System.out.println("This is the session id "+session.getSessionId());
        return ussdSessionRepository.save(session);
    }

    public UssdSession get(String id) {
        return ussdSessionRepository.findById(id).orElse(null);
    }

    public UssdSession update(UssdSession session) {
        if (ussdSessionRepository.existsById(session.getId())) {

            return ussdSessionRepository.save(session);
        }
        throw new IllegalArgumentException("must have an id to be updated");
    }

    public void delete(String id) {
        // deleting the session
        ussdSessionRepository.deleteById(id);
    }

}