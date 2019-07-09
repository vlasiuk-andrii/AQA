package main.core.dto;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Puppey {
    @EqualsAndHashCode.Exclude
    private int id;
    @Builder.Default
    private String name = "Bobik";


}
