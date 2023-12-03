package org.example.exceptions;

public class GenericExceptions extends RuntimeException {
    public GenericExceptions(String message){
        super(message);
    }
    public static GenericExceptions idMustBeNull(){
        String message = "id must be null";
        return new GenericExceptions(message);
    }

    public static GenericExceptions idMustNotBeNull1(){
        String message = "id must be null";
        return new GenericExceptions(message);
    }
    public static GenericExceptions notFound(Long id){
        String message = String.format("Record with id %s does not exists", id);
        return new GenericExceptions(message);
    }
}
