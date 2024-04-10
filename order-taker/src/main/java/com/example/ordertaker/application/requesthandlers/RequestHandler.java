package com.example.ordertaker.application.requesthandlers;

public interface RequestHandler<T, U> {

    U handle(T request);
}
