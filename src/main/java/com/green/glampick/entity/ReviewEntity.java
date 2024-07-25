package com.green.glampick.entity;

import com.green.glampick.dto.request.user.PostReviewRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review")
public class ReviewEntity extends CreatedAt{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;  // 리뷰 PK

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity userId;  // 유저 ID

    @ManyToOne
    @JoinColumn(name = "glampId", nullable = false)
    private GlampingEntity glampId;// 글램핑 ID

    @ManyToOne
    @JoinColumn(name = "reservationId", nullable = false)
    private ReservationCompleteEntity reservationId; // 객실 ID

    @Column(length = 500, nullable = false )
    private String reviewContent;  // 리뷰 내용

    @Column(nullable = false )
    private int reviewStarPoint;  // 리뷰 별점

    @Column(length = 500)
    private String reviewComment; // 사장님 답변





//    public ReviewEntity (PostReviewRequestDto dto) {
//
//        this.userId = dto.getUserId();
//        this.reviewContent = dto.getReviewContent();
//        this.reviewStarPoint = dto.getReviewStarPoint();
//        this.reservationId = dto.getReservationId();
//        this.glampId = dto.getGlampId();
//    }



}
