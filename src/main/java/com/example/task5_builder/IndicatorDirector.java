package com.example.task5_builder;

public class IndicatorDirector {
    private final IndicatorBuilder builder;

    public IndicatorDirector(IndicatorBuilder builder) {
        this.builder = builder;
    }

    public Indicator createIndicator() {
        builder.setView(300, 'G', 'T'); // 'T' для таймера
        builder.lineBounds(0, 60); // Таймер на 60 секунд
        builder.linePaint(0); // Начальное значение времени 0 секунд
        return builder.build();
    }
}
