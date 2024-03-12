package io.github.caiorodriguesmll.imageliteapi.domain.entity;

import io.github.caiorodriguesmll.imageliteapi.domain.enums.ImageExtension;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class) //Auditing Annotation CreatedDate and input value in upload date!
@Data //Create methods getters, setters, constructors, hash and equals via lombok!
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String name;
    @Column
    private Long size;
    @Column
    @Enumerated(EnumType.STRING)
    private ImageExtension extension;
    @CreatedDate
    private LocalDateTime uploadDate;
    @Column
    private String tags;
    @Column
    @Lob //Save files in DataBase!
    private byte[] file;

    public String getFileName() {
        return getName().concat(".").concat(getExtension().name());
    }

}
