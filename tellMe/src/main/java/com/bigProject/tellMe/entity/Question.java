package com.bigProject.tellMe.entity;

import com.bigProject.tellMe.enumClass.Category;
import com.bigProject.tellMe.enumClass.Reveal;
import com.bigProject.tellMe.enumClass.Role;
import com.bigProject.tellMe.enumClass.Status;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 전체생성자
@Builder
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @OneToOne
    @JoinColumn(name = "origin_id")
    private Origin origin;

    @CreatedDate
    private LocalDateTime createDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Reveal reveal;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Integer views;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    private String file1;

    @Column
    private String file2;

    @Column
    private String file3;

    @PrePersist
    public void setDefaultValues() {
        if(this.category == null) {
            this.category = Category.정상;  // DB에 저장되기 전에 기본값 설정
        }
    }
}
