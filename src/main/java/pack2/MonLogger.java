package pack2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;

public class MonLogger {

	// M�thode appel�e � chaque fois qu'une m�thode du package ew.service est
	// intercept�e (avant son exec)
	public void logMethodEntry(JoinPoint joinPoint) {

		String name = joinPoint.getSignature().toLongString(); // Nom de la m�thode intercept�e

		StringBuffer sb = new StringBuffer(name + " called with: [");

		Object[] args = joinPoint.getArgs(); // Liste des valeurs des arguments re�us par la m�thode

		for (int i = 0; i < args.length; i++) {

			Object o = args[i];

			sb.append("'" + o + "'");

			sb.append((i == args.length - 1) ? "" : ", ");

		}

		sb.append("]");

		System.out.println(sb);

	}

	// M�thode appel�e � chaque fois (et apr�s) qu'une m�thode du package ew.service
	// est intercept�e
	// Elle re�oit en argument 'result' qui est le retour de la m�thode intercept�e
	public void logMethodExit(StaticPart staticPart, Object result) {

		String name = staticPart.getSignature().toLongString(); // Nom de la m�thode intercept�e

		System.out.println(name + " returning: [" + result + "]");

	}

	public Object logMethodAround(final ProceedingJoinPoint jointPoint) throws Throwable {

		String name = jointPoint.getSignature().toLongString(); // Nom de la m�thode intercept�e

		System.out.println(name + " is running");

		Object obj = jointPoint.proceed();

		System.out.println(name + " is executed");

		return obj;

	}

}