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
public class ConscienceOrConvictionChoice {
    @Enumerated(EnumType.STRING)
    @Column(name = "conscience_or_conviction_choice")
    private ConscienceOrConviction choice;

    @Embedded
    @AttributeOverride(name = "dots", column = @Column(name = "conscience_or_conviction_dots"))
    private SimplePointValue value;
}