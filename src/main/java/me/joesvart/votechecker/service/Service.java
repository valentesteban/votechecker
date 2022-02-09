package me.joesvart.votechecker.service;

public interface Service {

    public void start();

    default void stop() {}
}
