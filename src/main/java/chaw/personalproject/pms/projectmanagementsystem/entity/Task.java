package chaw.personalproject.pms.projectmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_task_id")
    private Long id;

    @Column(nullable = false)
    private String taskName;

    @ManyToOne
    @JoinColumn(name = "fk_proj_id")
    private Project project;

    private String description;
}
