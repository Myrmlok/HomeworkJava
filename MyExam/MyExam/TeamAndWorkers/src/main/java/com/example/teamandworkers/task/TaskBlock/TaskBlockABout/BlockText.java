package com.example.teamandworkers.task.TaskBlock.TaskBlockABout;

import com.example.teamandworkers.task.TaskBlock.TaskBlockABout.TypeBlockFields.TypeBlockFields;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blockText")
public class BlockText {
    @Id
    Long id;
    @Column(name = "count")
    Integer count;
    @Column(name = "text")
    String text;
    @ManyToOne
    @JoinColumn(name = "blockType_id",referencedColumnName = "id")
    TypeBlockFields typeBlockFields;
}
