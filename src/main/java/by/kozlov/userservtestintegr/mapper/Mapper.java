package by.kozlov.userservtestintegr.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);
}
