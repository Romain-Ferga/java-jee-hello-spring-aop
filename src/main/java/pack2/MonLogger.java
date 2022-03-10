package pack2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;

public class MonLogger {

	// Méthode appelée à chaque fois qu'une méthode du package ew.service est
	// interceptée (avant son exec)
	public void logMethodEntry(JoinPoint joinPoint) {

		String name = joinPoint.getSignature().toLongString(); // Nom de la méthode interceptée

		StringBuffer sb = new StringBuffer(name + " called with: [");

		Object[] args = joinPoint.getArgs(); // Liste des valeurs des arguments reçus par la méthode

		for (int i = 0; i < args.length; i++) {

			Object o = args[i];

			sb.append("'" + o + "'");

			sb.append((i == args.length - 1) ? "" : ", ");

		}

		sb.append("]");

		System.out.println(sb);

	}

	// Méthode appelée à chaque fois (et après) qu'une méthode du package ew.service
	// est interceptée
	// Elle reçoit en argument 'result' qui est le retour de la méthode interceptée
	public void logMethodExit(StaticPart staticPart, Object result) {

		String name = staticPart.getSignature().toLongString(); // Nom de la méthode interceptée

		System.out.println(name + " returning: [" + result + "]");

	}

	public Object logMethodAround(final ProceedingJoinPoint jointPoint) throws Throwable {

		String name = jointPoint.getSignature().toLongString(); // Nom de la méthode interceptée

		System.out.println(name + " is running");

		Object obj = jointPoint.proceed();

		System.out.println(name + " is executed");

		return obj;

	}

}