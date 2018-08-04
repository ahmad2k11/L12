package com.hibernate.L12;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class L12A {

	public static void main(String[] args) {
		Transaction tx=null;
		try {
			Configuration cfg=new Configuration();
			cfg.configure();
			StandardServiceRegistryBuilder ssrBuilder=new StandardServiceRegistryBuilder();
			StandardServiceRegistry ssRegistry=ssrBuilder.applySettings(cfg.getProperties()).build();
			
			SessionFactory factory=cfg.buildSessionFactory(ssRegistry);
			Session session=factory.openSession();
			tx=session.beginTransaction();
			
			Address add=new Address("BTM", "BLR", "KA");
			session.save(add);
			
			Customer cust=new Customer("Amit", "Sinha", "8495036559", "amit@mail");
			session.save(cust);
			
			tx.commit();
			System.out.println("Record Inserted Successfully");
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}
	}

}
