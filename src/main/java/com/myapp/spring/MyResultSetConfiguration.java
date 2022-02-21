package com.myapp.spring;



import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

@Configuration
public class MyResultSetConfiguration {

	
	@Autowired
	private ApplicationContext applicationContext;
	/**
	* Initialize injection @JpaDto Corresponding Converter
	*/
	@PostConstruct
	public void init() {
	Map<String, Object> map = applicationContext.getBeansWithAnnotation(BookingAvailableDto.class);
	for (Object o : map.values()) {
	Class c = o.getClass();
	//log.info("Jpa add to Converter,class={}", c.getName());
	GenericConversionService genericConversionService = ((GenericConversionService) DefaultConversionService.getSharedInstance());
	genericConversionService.addConverter(Map.class, c, m -> {
	try {
	Object obj = c.newInstance();
	// It can be expanded here , Injected converter, Realization sql The result is an underlined field in the database , The hump is named by the program and then set to the entity
	// You can also do type conversion judgment , No type judgment is made here , direct copy To dto in , There may be errors when the type does not match
	return copyMapToObj(m, obj);
	} catch (Exception e) {
	throw new FatalBeanException("Jpa Result conversion error ,class=" + c.getName(), e);
	}
	});
	}
	}
	/**
	* take map The value in copy To bean On the corresponding field in
	* @author bazhandao
	* @date 2020-03-26
	* @param map
	* @param target
	* @return
	*/
	private Object copyMapToObj(Map<String, Object> map, Object target) {
	if(map == null || target == null || map.isEmpty()){
	return target;
	}
	Class<?> actualEditable = target.getClass();
	PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
	for (PropertyDescriptor targetPd : targetPds) {
	if(targetPd.getWriteMethod() == null) {
	continue;
	}
	try {
	String key = targetPd.getName();
	Object value = map.get(key);
	if (value == null) {
	continue;
	}
	Method writeMethod = targetPd.getWriteMethod();
	if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
	writeMethod.setAccessible(true);
	}
	writeMethod.invoke(target, value);
	} catch (Exception ex) {
	throw new FatalBeanException("Could not copy properties from source to target", ex);
	}
	}
	return target;
	}
}
