package com.worldline.curso.entities.generator;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

@GenericGenerator(name="myGenerator", strategy="increment")
public class IdGenerator implements IdentifierGenerator {
	public static long inc=0;

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		return inc++;
	}
   

}
