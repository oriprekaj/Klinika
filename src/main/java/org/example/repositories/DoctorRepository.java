package org.example.repositories;


import org.example.entities.Doctor;
import org.example.exceptions.GenericExceptions;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DoctorRepository {
    private final Session session;
    private final Transaction transaction;

    public DoctorRepository(Session session, Transaction transaction) {
        this.session = session;
        this.transaction = transaction;
    }

    public Doctor create(Doctor doctor) {
        if (doctor.getDoctorId() == null) {
            try {
                session.persist(doctor);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw GenericExceptions.idMustBeNull();
        }
        return null;
    }

    public Doctor update(Doctor doctor) {
        if (doctor.getDoctorId() != null) {
            try {
                session.persist(doctor);
                transaction.commit();
                return doctor;
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        } else {
            throw GenericExceptions.idMustNotBeNull1();
        }
        return null;
    }
    public Doctor findById(Long id){
        Doctor doctor = session.get(Doctor.class, id);
        if(doctor !=null){
            return doctor;
        } else{
            throw GenericExceptions.notFound(id);
        }
    }
    public List<Doctor> getAll(){
        String query = "select d from Doctor d";
    }
}






