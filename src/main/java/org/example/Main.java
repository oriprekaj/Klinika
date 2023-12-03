package org.example;

import jakarta.transaction.Transaction;
import org.example.config.HibernateUtils;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
    }

}