package com.example.teamandworkers.task.TaskBlock.TaskBlockABout.TypeBlockFields;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BlockType")
public class TypeBlockFields {
    @Id
    Integer id;
    @Column(name = "_name")
    @Enumerated(EnumType.STRING)
    EnumTypeBlockFields name;
}
