package com.sabio.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class HibernateDAO<T>  {


	private final Class<T> classe;

    private Session session;
    
	public HibernateDAO(Class<T> classe){
		this.classe = classe;
		getSession();
	}

    public void setSession(Session s) {
        this.session = s;
    }

    public Session getSession() {
        if (session == null)
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }

	public Object add(T u) {
		return this.session.merge(u);
	}


	public void remove(T u) {
		this.session.delete(u);
	}

	public void update(T u) {
		this.session.merge(u);

	}
	
	@SuppressWarnings("unchecked")
	public T get(int id) {
		T t = (T) this.session.load(this.classe, id); 
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public T get(String id) {
		T t = (T) this.session.load(this.classe, id); 
		return t;
	}	

	@SuppressWarnings("unchecked")
	public List<T> listAll() {
        Criteria criteria = this.session.createCriteria(this.classe);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<T> t = criteria.list();

		return t;
	}
}
