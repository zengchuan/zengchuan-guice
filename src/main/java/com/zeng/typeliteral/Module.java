package com.zeng.typeliteral;

import com.google.inject.AbstractModule;
import com.google.inject.MembersInjector;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import java.lang.reflect.Field;
import java.util.MissingResourceException;

public class Module extends AbstractModule {
    public void configure() {

        bind(OtherService.class);
        bindListener(Matchers.any(), new TypeListener(){
            @Override
            public <T> void hear(TypeLiteral<T> typeLiteral,TypeEncounter<T> typeEncounter){
                for(Field field : typeLiteral.getRawType().getDeclaredFields()){
                    if (field.getType() == Service.class
                            && field.isAnnotationPresent(TestProperty.class)){
                        typeEncounter.register(new _PropertyInjector<T>(field));
                    }
                }
            }
            class _PropertyInjector<T> implements MembersInjector<T> {
                private final Field field;
                _PropertyInjector(Field field){
                    this.field = field;
                    this.field.setAccessible(true);
                }
                @Override
                public void injectMembers(T t){
                    try{
                        String value_PropertyInject
                                = this.field.getAnnotation(TestProperty.class).value();
                        if(value_PropertyInject.equals("A")){
                            this.field.set(t, new AService());
                        } else {
                            this.field.set(t, new BService());
                        }

                    }catch(Exception e){
                        System.out.println(e.toString());
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        );
    }
}
