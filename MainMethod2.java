package com.motivity;


import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
//import org.hibernate.query.Query;
//import org.hibernate.query.Query;
public class MainMethod2 {
public static void main(String[] args){
StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hib2.cfg.xml").build();
Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
SessionFactory factory=meta.getSessionFactoryBuilder().build();
Session session=factory.openSession();
Transaction t=session.beginTransaction();
Query<Object[]> qr=session.createQuery("Select e.employee_name ,e.mobile,er.employer_name from EmployerNew er INNER JOIN EmployeeNew e on er.employer_id=e.employerNew");

List<Object[]> list=qr.list();
Iterator<Object[]> it=list.iterator();
while(it.hasNext()) {
	Object ob[]=(Object[])it.next();
	System.out.println(ob[0]+" "+ob[1]+" "+ob[2]);
}
/*EmployerNew empr1=new EmployerNew();
empr1.setEmployer_id(1);
empr1.setEmployer_name("riyad");
empr1.setMobile("876654223l");        
empr1.setDepartment("IT");
EmployerNew empr2=new EmployerNew();
empr2.setEmployer_id(2);
empr2.setEmployer_name("sony");
empr2.setMobile("9877645321");
empr2.setDepartment("HR");
EmployerNew empr3=new EmployerNew();
empr3.setEmployer_id(3);
empr3.setEmployer_name("Rony");
empr3.setMobile("769943332l");
empr3.setDepartment("Managing");
EmployeeNew emp1=new EmployeeNew();
emp1.setEmployee_id(4);
emp1.setEmployee_name("Keerthi");
emp1.setMobile("9453628223");
emp1.setAddress("mumbai");
emp1.setEmployerNew(empr1);
EmployeeNew emp2=new EmployeeNew();
emp2.setEmployee_id(5);
emp2.setEmployee_name("susmitha");
emp2.setMobile("6785466321");
emp2.setAddress("chennai");
emp2.setEmployerNew(empr2);
EmployeeNew emp3=new EmployeeNew();
emp3.setEmployee_id(6);
emp3.setEmployee_name("swetcha");
emp3.setMobile("8765499211");
emp3.setAddress("mumbai");
emp3.setEmployerNew(empr3);
EmployeeNew emp4=new EmployeeNew();
emp4.setEmployee_id(7);
emp4.setEmployee_name("vinny");
emp4.setMobile("8776566234");
emp4.setAddress("hyderabad");
emp4.setEmployerNew(empr2);
EmployeeNew emp5=new EmployeeNew();
emp5.setEmployee_id(8);
emp5.setEmployee_name("Shikha");
emp5.setMobile("9876546599");
emp5.setAddress("kolkata");
emp5.setEmployerNew(empr2);
List<EmployeeNew> al1=new ArrayList<EmployeeNew>();
al1.add(emp1);
al1.add(emp4);
al1.add(emp5);
List<EmployeeNew> al2=new ArrayList<EmployeeNew>();
al2.add(emp2);
al2.add(emp5);
List<EmployeeNew> al3=new ArrayList<EmployeeNew>();
al3.add(emp3);
empr1.setEmployeeNew(al1);
empr3.setEmployeeNew(al3);
session.save(empr1);
session.save(empr2);
session.save(empr3);
session.save(emp1);
session.save(emp2);
session.save(emp3);
session.save(emp4);
session.save(emp5);
/*Query qr=session.createQuery("from EmployeeNew e join EmployerNew er where er.employee_id=e.employer_employer_id");
List<> li=qr.list();
Iterator<Object> i=li.iterator();
while(i.hasNext()) {
	Object x=(Object[])i.next();
	
}*/
t.commit();
session.close();
}

}
