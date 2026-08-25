package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.virtue;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.point.SimplePointValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SelfControlOrInstinctChoice {
    @Enumerated(EnumType.STRING)
    @Column(name = "self_control_or_instinct_choice")
    private SelfControlOrInstinct choice;

    @Embedded
    @AttributeOverride(name = "dots", column = @Column(name = "self_control_or_instinct_dots"))
    private SimplePointValue value;
}