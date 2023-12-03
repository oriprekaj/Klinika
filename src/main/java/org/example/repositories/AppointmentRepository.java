package org.example.repositories;
import jakarta.persistence.Id;
import org.example.entities.Appointment;
import org.example.exceptions.GenericExceptions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AppointmentRepository {
    private final Session session;
    private final Transaction transaction;
    public AppointmentRepository(Session session, Transaction transaction){
        this.session = session;
        this.transaction = transaction;
    }

    public Appointment create(Appointment appointment){
        if (appointment.getAppointmentId()==null){
            try
            {
            session.persist(appointment);
            transaction.commit();
            return appointment;
        } catch(Exception e){
                transaction.rollback();
                e.printStackTrace();
            }

    }
        else {
            throw GenericExceptions.idMustBeNull();
        }
        return null;
}

        public Appointment update(Appointment appointment){
        if (appointment.getAppointmentId() !=null){
            try{
                session.persist(appointment);
                transaction.commit();
            }
            catch (Exception e){
                transaction.rollback();
                e.printStackTrace();
            }}
            else{
                throw GenericExceptions.idMustNotBeNull1();
                }
                return null;
            }
            public List<Appointment> getAll(){
            String query = "select a from Appointments a";
            String querySql = "select = from appointment";
            Query <Appointment> getAll = session.createQuery(query, Appointment.class);
            return getAll.getResultList();
            }
            public Appointment getById(Long id){
            Appointment result =  session.get(Appointment.class, id);
            if(result !=null){
                return result;
            }
            else {
                throw GenericExceptions.notFound(id);

            }}
            public void delete(Long id){
            Appointment appointment = this.getById(id);
            session.delete(appointment);
            }
            public List<Appointment> getByDoctor(Long doctorId){
            String query = "select a from Appointment a share a.doctor.doctorId = :id";
            Query<Appointment> getByDoctor = session.createQuery(query, Appointment.class);
            getByDoctor.setParameter("id", doctorId);
            return getByDoctor.getResultList();
            }
        }

