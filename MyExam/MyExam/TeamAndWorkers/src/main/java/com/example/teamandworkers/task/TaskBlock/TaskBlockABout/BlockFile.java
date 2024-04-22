package com.example.teamandworkers.task.TaskBlock.TaskBlockABout;

import com.example.teamandworkers.task.TaskBlock.TaskBlockABout.TypeBlockFields.TypeBlockFields;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blockFile")
public class BlockFile {
    @Id
    Long id;
    @Column(name = "count")
    Integer count;
    @Column(name = "bytes")
    File file;
    @Column(name = "filename")
    String filename;
    @ManyToOne
    @JoinColumn(name = "blockType_id",referencedColumnName = "id")
    TypeBlockFields typeBlockFields;
}
