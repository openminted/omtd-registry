package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlRegistry;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by antleb on 9/6/16.
 */
@XmlRegistry
public class ObjectFactory {

	public Component createComponent() {
		return new Component();
	}
	
	public LexicalConceptualResource createLexicalConceptualResource() {
		return new LexicalConceptualResource();
	}

	public Corpus createCorpus() {
		return new Corpus();
	}

	private <T> T createInstance(Class<T> anInterface) {
		return (T) Proxy.newProxyInstance(anInterface.getClassLoader(), new Class[] {anInterface}, new InterfaceInvocationHandler());
	}

	private static class InterfaceInvocationHandler implements InvocationHandler {

		private Map<String, Object> values = new HashMap<>();

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			String methodName = method.getName();
			if(methodName.startsWith("get")) {
				return values.get(methodName.substring(3));
			} else {
				values.put(methodName.substring(3), args[0]);
				return null;
			}
		}

	}
}
