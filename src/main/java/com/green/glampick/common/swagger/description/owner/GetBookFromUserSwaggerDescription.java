package com.green.glampick.common.swagger.description.owner;

public class GetBookFromUserSwaggerDescription {

    public static final String BOOK_FROM_USER_REVIEW_VIEW_DESCRIPTION =

            "<strong>글램핑에 대한 예약정보를 모두 불러옵니다.</strong>" +
            "<p>로그인이 필요한 기능입니다. 상단 Authorize 에 토큰값을 입력 후 이용해주세요.</p>" +
            "<p>-------------------------------------------------</p>" +
            "<p>glampId : 글램핑 PK</p>" +
            "<p>before : 이용 예정</p>" +
            "<p>complete : 이용 완료</p>" +
            "<p>cancel : 예약 취소</p>"
            ;

    public static final String BOOK_FROM_USER_REVIEW_VIEW_RESPONSE_ERROR_CODE =

            "<strong>발생 가능한 에러코드</strong>" +
            "<p>RN - 예약된 내역이 존재하지 않음 (400)</p>" +
            "<p>DBE - 데이터베이스 에러 (500)</p>"
            ;

}
