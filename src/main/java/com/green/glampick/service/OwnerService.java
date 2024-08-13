package com.green.glampick.service;

import com.green.glampick.dto.object.owner.OwnerBookCountListItem;
import com.green.glampick.dto.object.owner.OwnerBookDetailListItem;
import com.green.glampick.dto.request.owner.*;
import com.green.glampick.dto.request.ReviewPatchRequestDto;
import com.green.glampick.dto.request.user.GetReviewRequestDto;
import com.green.glampick.dto.response.owner.*;
import com.green.glampick.dto.response.owner.get.*;
import com.green.glampick.dto.response.owner.patch.PatchOwnerPeakResponseDto;
import com.green.glampick.dto.response.owner.patch.PatchOwnerReviewInfoResponseDto;
import com.green.glampick.dto.response.owner.post.PostBusinessPaperResponseDto;
import com.green.glampick.dto.response.owner.post.PostRoomInfoResponseDto;
import com.green.glampick.dto.response.owner.put.PatchOwnerInfoResponseDto;
import com.green.glampick.dto.response.user.GetReviewResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OwnerService {

    ResponseEntity<? super PostBusinessPaperResponseDto> postBusinessInfo(MultipartFile file);

    // 글램핑 등록
    ResponseEntity<? super OwnerSuccessResponseDto> postGlampingInfo(GlampingPostRequestDto glampingPostRequestDtoReq, MultipartFile glampImg);
    // 객실 등록
//    ResponseEntity<? super OwnerSuccessResponseDto> postRoomInfo(RoomPostRequestDto req, List<MultipartFile> img);
    ResponseEntity<? super PostRoomInfoResponseDto> postRoomInfo(RoomPostRequestDto req, List<MultipartFile> img);
    // 글램핑 대표이미지 변경
    ResponseEntity<? super OwnerSuccessResponseDto> changeGlampingImage (MultipartFile image, long glampId);
    // 글램핑 정보 변경
    ResponseEntity<? super OwnerSuccessResponseDto> updateGlampingInfo(GlampingPutRequestDto req);
    // 객실 정보 변경
    ResponseEntity<? super OwnerSuccessResponseDto> updateRoomInfo(List<MultipartFile> addImg, RoomPutRequestDto p);
    // 객실 삭제
    ResponseEntity<? super OwnerSuccessResponseDto> deleteRoom(Long roomId);
    // 글램핑 get
    ResponseEntity<? super GetGlampingInfoResponseDto> getGlamping();
    // 객실 get
    ResponseEntity<? super GetRoomListResponseDto> getRoomList(Long glampId);
    ResponseEntity<? super GetRoomInfoResponseDto> getRoomOne(Long glampId, Long roomId);
    // 비밀번호 확인
    ResponseEntity<? super OwnerSuccessResponseDto> checkOwnerPassword(CheckPasswordRequestDto dto);
    // 회원정보 불러오기
    ResponseEntity<? super OwnerInfoResponseDto> getOwnerInfo();
    // 회원 정보 수정
    ResponseEntity<? super PatchOwnerInfoResponseDto> patchOwnerInfo(PatchOwnerInfoRequestDto dto);
    // 탈퇴 승인 요청
    ResponseEntity<? super OwnerSuccessResponseDto> withdrawOwner();


    //성수기 비수기 설정
    ResponseEntity<? super PatchOwnerPeakResponseDto> patchPeak(Long glampId, PatchOwnerPeakRequestDto p);
    //리뷰 답글 작성
    ResponseEntity<? super PatchOwnerReviewInfoResponseDto> patchReview(ReviewPatchRequestDto p);
    //리뷰 불러오기
    ResponseEntity<? super GetReviewResponseDto> getReview(GetReviewRequestDto dto);
    //예약 상세보기(진행 중 예약)
    List<OwnerBookDetailListItem> getReservationBeforeList(ReservationGetRequestDto p);
    //예약 상세보기(취소 된 예약)
    List<OwnerBookDetailListItem> getReservationCancelList(ReservationGetRequestDto p);
    //예약 상세보기(완료 된 예약)
    List<OwnerBookDetailListItem> getReservationCompleteList(ReservationGetRequestDto p);
    //날짜별 예약 건수
    List<OwnerBookCountListItem> getTotalCount(String date,Long ownerId);
    //예약 삭제
    ResponseEntity<? super OwnerSuccessResponseDto> deleteOwnersReservation(Long reservationId);

}
