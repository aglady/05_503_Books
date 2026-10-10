package ru.gr05503.ui;

public record BookFormState(
        boolean addEnabled,
        String status,
        String error
) {
    public static BookFormState init(){
        return new BookFormState( false, "Заполните данные", null);
    }
    public static BookFormState setReady(){
        return new BookFormState( true, "Можно добавлять", null);
    }

    public static BookFormState setError(String message){
        return new BookFormState( false, "Ошибка", message);
    }

}

