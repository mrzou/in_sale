package class_project.zou;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class GetDelSession {
	private static SessionFactory sessionFactory;
	@SuppressWarnings("rawtypes")
	private static ThreadLocal session = new ThreadLocal();
	private GetDelSession(){}
	static{
		try{
		Configuration configurate = new Configuration();
		configurate.configure();
		sessionFactory = configurate.buildSessionFactory();
		}catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
		}
	}
	public static Session getThreadLocalSession(){
		Session newSession = (Session)session.get();	
		if(newSession==null){
			newSession = sessionFactory.openSession();
			session.set(newSession);
		}
		return newSession;
	}
	public static void closeSession(){
		Session newSession = (Session)session.get();
		if(newSession!=null){
			newSession.close();
			session.set(null);
		}
	}
}
