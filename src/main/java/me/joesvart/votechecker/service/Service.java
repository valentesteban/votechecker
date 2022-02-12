package me.joesvart.votechecker.service;

public interface Service {

    void start();

    default void stop() {}
}
